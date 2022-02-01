package com.tencent.tavkit.composition.video;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.compositing.AsynchronousVideoCompositionRequest;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.compositing.VideoCompositionRenderContext;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.coremedia.ErrorMsg;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.ciimage.ThreadLocalTextureCache;
import com.tencent.tavkit.composition.model.TAVVideoCompositionTrack;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration;
import com.tencent.tavkit.composition.model.TAVVideoConfiguration.TAVVideoConfigurationContentMode;
import com.tencent.tavkit.report.CompositingReportSession;
import com.tencent.tavkit.report.MemoryReportHelper;
import com.tencent.tavkit.utils.BenchUtil;
import com.tencent.tavkit.utils.Utils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class TAVVideoCompositing
  implements VideoCompositing
{
  public static boolean LOG_VERBOSE = false;
  private final String TAG;
  private CIContext ciContext;
  private final TAVVideoMixEffect.Filter defaultVideoMixFilter;
  private final HashMap<String, TAVVideoEffect.Filter> globalFilterMap;
  private final HashMap<String, TAVVideoMixEffect.Filter> mixFilterMap;
  private Thread renderThread;
  private CompositingReportSession reportSession;
  private final HashMap<String, TAVVideoEffect.Filter> sourceFilterMap;
  private final HashMap<String, TAVVideoTransition.Filter> transitionFilterMap;
  private boolean tryPostReleaseDone;
  
  public TAVVideoCompositing()
  {
    AppMethodBeat.i(192111);
    this.TAG = ("TAVVideoCompositing@" + Integer.toHexString(hashCode()));
    this.transitionFilterMap = new HashMap();
    this.sourceFilterMap = new HashMap();
    this.mixFilterMap = new HashMap();
    this.globalFilterMap = new HashMap();
    this.defaultVideoMixFilter = new DefaultVideoMixFilter();
    this.tryPostReleaseDone = false;
    AppMethodBeat.o(192111);
  }
  
  private CIImage applyClipSourceEffect(RenderInfo paramRenderInfo, CIImage paramCIImage, List<TAVVideoEffect> paramList)
  {
    AppMethodBeat.i(192120);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(192120);
      return paramCIImage;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TAVVideoEffect localTAVVideoEffect = (TAVVideoEffect)paramList.next();
      TAVVideoEffect.Filter localFilter = getSourceFilter(localTAVVideoEffect);
      if (localFilter != null) {
        paramCIImage = localFilter.apply(localTAVVideoEffect, paramCIImage, paramRenderInfo);
      }
    }
    AppMethodBeat.o(192120);
    return paramCIImage;
  }
  
  private CIImage applyCompositionSourceEffect(RenderInfo paramRenderInfo, CIImage paramCIImage, TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(192121);
    TAVVideoEffect.Filter localFilter = getSourceFilter(paramTAVVideoEffect);
    if (localFilter == null)
    {
      AppMethodBeat.o(192121);
      return paramCIImage;
    }
    paramRenderInfo = localFilter.apply(paramTAVVideoEffect, paramCIImage, paramRenderInfo);
    AppMethodBeat.o(192121);
    return paramRenderInfo;
  }
  
  private void applySourceTransform(TAVVideoConfiguration paramTAVVideoConfiguration, CIImage paramCIImage)
  {
    AppMethodBeat.i(192123);
    if (LOG_VERBOSE) {
      Logger.v(this.TAG, "applySourceTransform() called with: config = [" + paramTAVVideoConfiguration + "]");
    }
    if (Utils.isRectValid(paramTAVVideoConfiguration.getFrame()))
    {
      TAVVideoConfiguration.TAVVideoConfigurationContentMode localTAVVideoConfigurationContentMode = paramTAVVideoConfiguration.getContentMode();
      paramCIImage.applyFillInFrame(paramTAVVideoConfiguration.getFrame(), localTAVVideoConfigurationContentMode);
    }
    paramCIImage.safeApplyTransform(paramTAVVideoConfiguration.getTransform());
    AppMethodBeat.o(192123);
  }
  
  private CIImage compositingImages(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, TAVVideoCompositionInstruction paramTAVVideoCompositionInstruction)
  {
    AppMethodBeat.i(192114);
    if (this.ciContext == null)
    {
      AppMethodBeat.o(192114);
      return null;
    }
    Object localObject1 = this.sourceFilterMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (TAVVideoEffect.Filter)((Iterator)localObject1).next();
      if ((localObject2 instanceof TAVAttachTimeRangeSourceEffect.TimeAttachFilter)) {
        ((TAVAttachTimeRangeSourceEffect.TimeAttachFilter)localObject2).attachPositionTime(paramAsynchronousVideoCompositionRequest.getCompositionTime());
      }
    }
    Object localObject2 = new RenderInfo(paramAsynchronousVideoCompositionRequest.getCompositionTime(), paramAsynchronousVideoCompositionRequest.getRenderContext().getSize(), this.ciContext);
    Object localObject3 = convertToImageCollection(paramAsynchronousVideoCompositionRequest, (RenderInfo)localObject2, paramTAVVideoCompositionInstruction);
    paramAsynchronousVideoCompositionRequest = getVideoMixFilter(paramTAVVideoCompositionInstruction, paramTAVVideoCompositionInstruction.getVideoMixEffect());
    if (paramAsynchronousVideoCompositionRequest != null) {}
    for (localObject1 = paramAsynchronousVideoCompositionRequest.apply(paramTAVVideoCompositionInstruction.getVideoMixEffect(), (ImageCollection)localObject3, (RenderInfo)localObject2);; localObject1 = null)
    {
      paramAsynchronousVideoCompositionRequest = (AsynchronousVideoCompositionRequest)localObject1;
      if (localObject1 == null) {
        paramAsynchronousVideoCompositionRequest = this.defaultVideoMixFilter.apply(null, (ImageCollection)localObject3, (RenderInfo)localObject2);
      }
      localObject3 = getGlobalFilter(paramTAVVideoCompositionInstruction.getGlobalVideoEffect());
      localObject1 = paramAsynchronousVideoCompositionRequest;
      if (localObject3 != null) {
        localObject1 = ((TAVVideoEffect.Filter)localObject3).apply(paramTAVVideoCompositionInstruction.getGlobalVideoEffect(), paramAsynchronousVideoCompositionRequest, (RenderInfo)localObject2);
      }
      AppMethodBeat.o(192114);
      return localObject1;
    }
  }
  
  private CIImage convertLayerToImage(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, RenderInfo paramRenderInfo, TAVVideoCompositionLayerInstruction paramTAVVideoCompositionLayerInstruction, TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(192118);
    if (!paramTAVVideoCompositionLayerInstruction.getTimeRange().containsTime(paramRenderInfo.getTime()))
    {
      AppMethodBeat.o(192118);
      return null;
    }
    CIImage localCIImage = paramTAVVideoCompositionLayerInstruction.getImageSource().sourceImageAtTime(paramRenderInfo.getTime().sub(paramTAVVideoCompositionLayerInstruction.getTimeRange().getStart()), paramRenderInfo.getRenderSize());
    Object localObject = localCIImage;
    if (localCIImage == null)
    {
      paramAsynchronousVideoCompositionRequest = getImageWithRequest(paramAsynchronousVideoCompositionRequest, paramTAVVideoCompositionLayerInstruction);
      localObject = paramAsynchronousVideoCompositionRequest;
      if (LOG_VERBOSE)
      {
        Logger.v(this.TAG, "convertLayerToImage: begin sourceImage by request, sourceImage = ".concat(String.valueOf(paramAsynchronousVideoCompositionRequest)));
        localObject = paramAsynchronousVideoCompositionRequest;
      }
    }
    if (localObject == null)
    {
      Logger.w(this.TAG, "convertLayerToImage: begin sourceImage by request, sourceImage is null ");
      AppMethodBeat.o(192118);
      return null;
    }
    ((CIImage)localObject).applyPreferRotation(paramTAVVideoCompositionLayerInstruction.getVideoConfiguration().getPreferRotation());
    paramAsynchronousVideoCompositionRequest = applyCompositionSourceEffect(paramRenderInfo, applyClipSourceEffect(paramRenderInfo, (CIImage)localObject, paramTAVVideoCompositionLayerInstruction.getVideoConfiguration().getEffects()), paramTAVVideoEffect);
    applySourceTransform(paramTAVVideoCompositionLayerInstruction.getVideoConfiguration(), paramAsynchronousVideoCompositionRequest);
    if (LOG_VERBOSE) {
      Logger.v(this.TAG, "convertLayerToImage: end, returned: ".concat(String.valueOf(paramAsynchronousVideoCompositionRequest)));
    }
    AppMethodBeat.o(192118);
    return paramAsynchronousVideoCompositionRequest;
  }
  
  private ImageCollection convertToImageCollection(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, RenderInfo paramRenderInfo, TAVVideoCompositionInstruction paramTAVVideoCompositionInstruction)
  {
    AppMethodBeat.i(192115);
    ImageCollection localImageCollection = new ImageCollection();
    Iterator localIterator = paramTAVVideoCompositionInstruction.getChannelLayers().iterator();
    Object localObject1;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = ((List)localIterator.next()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TAVVideoCompositionLayerInstruction)((Iterator)localObject1).next();
        CIImage localCIImage = convertLayerToImage(paramAsynchronousVideoCompositionRequest, paramRenderInfo, (TAVVideoCompositionLayerInstruction)localObject2, paramTAVVideoCompositionInstruction.getSourceVideoEffect());
        if ((localCIImage != null) && (!localCIImage.isCanvasImage())) {
          localImageCollection.addChannelImage(localCIImage, ((TAVVideoCompositionLayerInstruction)localObject2).getImageSource());
        }
      }
    }
    localIterator = paramTAVVideoCompositionInstruction.getOverlayLayers().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (TAVVideoCompositionLayerInstruction)localIterator.next();
      localObject2 = convertLayerToImage(paramAsynchronousVideoCompositionRequest, paramRenderInfo, (TAVVideoCompositionLayerInstruction)localObject1, paramTAVVideoCompositionInstruction.getSourceVideoEffect());
      if ((localObject2 != null) && (!((CIImage)localObject2).isCanvasImage())) {
        localImageCollection.addOverlayImage((CIImage)localObject2, ((TAVVideoCompositionLayerInstruction)localObject1).getImageSource());
      }
    }
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "convertToImageCollection: result imageCollection = ".concat(String.valueOf(localImageCollection)));
    }
    AppMethodBeat.o(192115);
    return localImageCollection;
  }
  
  private TAVVideoEffect.Filter getGlobalFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(192117);
    if ((paramTAVVideoEffect == null) || (TextUtils.isEmpty(paramTAVVideoEffect.effectId())))
    {
      AppMethodBeat.o(192117);
      return null;
    }
    String str = paramTAVVideoEffect.effectId();
    if (this.globalFilterMap.containsKey(str)) {
      paramTAVVideoEffect = (TAVVideoEffect.Filter)this.globalFilterMap.get(str);
    }
    for (;;)
    {
      AppMethodBeat.o(192117);
      return paramTAVVideoEffect;
      paramTAVVideoEffect = paramTAVVideoEffect.createFilter();
      this.globalFilterMap.put(str, paramTAVVideoEffect);
    }
  }
  
  private CIImage getImageWithRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest, TAVVideoCompositionLayerInstruction paramTAVVideoCompositionLayerInstruction)
  {
    AppMethodBeat.i(192119);
    paramAsynchronousVideoCompositionRequest = paramAsynchronousVideoCompositionRequest.sourceFrameByTrackID(paramTAVVideoCompositionLayerInstruction.getTrackID());
    if ((paramAsynchronousVideoCompositionRequest != null) && (paramAsynchronousVideoCompositionRequest.getTextureInfo() != null))
    {
      paramAsynchronousVideoCompositionRequest = new CIImage(paramAsynchronousVideoCompositionRequest.getTextureInfo());
      AppMethodBeat.o(192119);
      return paramAsynchronousVideoCompositionRequest;
    }
    AppMethodBeat.o(192119);
    return null;
  }
  
  private TAVVideoEffect.Filter getSourceFilter(TAVVideoEffect paramTAVVideoEffect)
  {
    AppMethodBeat.i(192122);
    if ((paramTAVVideoEffect == null) || (TextUtils.isEmpty(paramTAVVideoEffect.effectId())))
    {
      AppMethodBeat.o(192122);
      return null;
    }
    String str = paramTAVVideoEffect.effectId();
    if (this.sourceFilterMap.containsKey(str)) {
      paramTAVVideoEffect = (TAVVideoEffect.Filter)this.sourceFilterMap.get(str);
    }
    for (;;)
    {
      AppMethodBeat.o(192122);
      return paramTAVVideoEffect;
      paramTAVVideoEffect = paramTAVVideoEffect.createFilter();
      this.sourceFilterMap.put(str, paramTAVVideoEffect);
    }
  }
  
  private TAVVideoMixEffect.Filter getVideoMixFilter(TAVVideoCompositionInstruction paramTAVVideoCompositionInstruction, TAVVideoMixEffect paramTAVVideoMixEffect)
  {
    AppMethodBeat.i(192116);
    if ((paramTAVVideoMixEffect == null) || (TextUtils.isEmpty(paramTAVVideoMixEffect.effectId())))
    {
      AppMethodBeat.o(192116);
      return null;
    }
    paramTAVVideoMixEffect = paramTAVVideoMixEffect.effectId();
    if (this.mixFilterMap.containsKey(paramTAVVideoMixEffect)) {
      paramTAVVideoCompositionInstruction = (TAVVideoMixEffect.Filter)this.mixFilterMap.get(paramTAVVideoMixEffect);
    }
    for (;;)
    {
      AppMethodBeat.o(192116);
      return paramTAVVideoCompositionInstruction;
      paramTAVVideoCompositionInstruction = paramTAVVideoCompositionInstruction.getVideoMixEffect().createFilter();
      this.mixFilterMap.put(paramTAVVideoMixEffect, paramTAVVideoCompositionInstruction);
    }
  }
  
  private void reportMemory()
  {
    AppMethodBeat.i(192113);
    if (MemoryReportHelper.isInIntervalTime())
    {
      AppMethodBeat.o(192113);
      return;
    }
    String str1 = MemoryReportHelper.appendReportKey(this.sourceFilterMap.values());
    String str2 = MemoryReportHelper.appendReportKey(this.mixFilterMap.values());
    String str3 = MemoryReportHelper.appendReportKey(this.globalFilterMap.values());
    str1 = "sourceFilter:[" + str1 + "], mixFilter:[" + str2 + "], globalFilter:[" + str3 + "]";
    MemoryReportHelper.getInstance().tick(str1);
    AppMethodBeat.o(192113);
  }
  
  private void tryPostReleaseToRenderThread()
  {
    AppMethodBeat.i(192125);
    if (this.tryPostReleaseDone)
    {
      AppMethodBeat.o(192125);
      return;
    }
    this.tryPostReleaseDone = true;
    if ((this.renderThread instanceof HandlerThread)) {
      new Handler(((HandlerThread)this.renderThread).getLooper()).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(192110);
          TAVVideoCompositing.this.release();
          AppMethodBeat.o(192110);
        }
      });
    }
    AppMethodBeat.o(192125);
  }
  
  public void cancelAllPendingVideoCompositionRequests() {}
  
  public void release()
  {
    AppMethodBeat.i(192124);
    if ((this.renderThread != null) && (!Thread.currentThread().equals(this.renderThread)))
    {
      Logger.e(this.TAG, "release: 当前线程非渲染线程！currentThread = " + Thread.currentThread().getName() + ", renderThread = " + this.renderThread.getName());
      tryPostReleaseToRenderThread();
      AppMethodBeat.o(192124);
      return;
    }
    this.tryPostReleaseDone = false;
    Logger.d(this.TAG, "release: begin, currentThread = " + Thread.currentThread().getName());
    if (this.ciContext != null) {
      this.ciContext.release();
    }
    Iterator localIterator = this.transitionFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoTransition.Filter)localIterator.next()).release();
    }
    localIterator = this.sourceFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoEffect.Filter)localIterator.next()).release();
    }
    localIterator = this.mixFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoMixEffect.Filter)localIterator.next()).release();
    }
    localIterator = this.globalFilterMap.values().iterator();
    while (localIterator.hasNext()) {
      ((TAVVideoEffect.Filter)localIterator.next()).release();
    }
    this.transitionFilterMap.clear();
    this.sourceFilterMap.clear();
    this.mixFilterMap.clear();
    this.globalFilterMap.clear();
    ThreadLocalTextureCache.getInstance().release();
    if (this.reportSession != null)
    {
      this.reportSession.flush();
      this.reportSession = null;
    }
    Logger.d(this.TAG, "release: end, currentThread = " + Thread.currentThread().getName());
    AppMethodBeat.o(192124);
  }
  
  public void renderContextChanged(VideoCompositionRenderContext paramVideoCompositionRenderContext) {}
  
  public HashMap<String, Object> requiredPixelBufferAttributesForRenderContext()
  {
    return null;
  }
  
  public HashMap<String, Object> sourcePixelBufferAttributes()
  {
    return null;
  }
  
  public void startVideoCompositionRequest(AsynchronousVideoCompositionRequest paramAsynchronousVideoCompositionRequest)
  {
    AppMethodBeat.i(192112);
    if (this.reportSession == null) {
      this.reportSession = new CompositingReportSession(paramAsynchronousVideoCompositionRequest.getRenderContext().getSize().width, paramAsynchronousVideoCompositionRequest.getRenderContext().getSize().height);
    }
    long l = System.nanoTime();
    if (LOG_VERBOSE) {
      Logger.d(this.TAG, "startVideoCompositionRequest: begin, currentThread = " + Thread.currentThread().getName() + ", request = [" + paramAsynchronousVideoCompositionRequest + "]");
    }
    if (this.ciContext == null) {
      this.ciContext = new CIContext(paramAsynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
    }
    if (this.renderThread == null) {
      this.renderThread = Thread.currentThread();
    }
    Object localObject = paramAsynchronousVideoCompositionRequest.getVideoCompositionInstruction();
    if (!(localObject instanceof TAVVideoCompositionInstruction))
    {
      Logger.e(this.TAG, "startVideoCompositionRequest: end, ".concat(String.valueOf("instruction not instanceof TAVVideoCompositionInstruction")));
      this.reportSession.tickFailed();
      paramAsynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "instruction not instanceof TAVVideoCompositionInstruction"));
      AppMethodBeat.o(192112);
      return;
    }
    BenchUtil.benchStart("compositingImages");
    localObject = compositingImages(paramAsynchronousVideoCompositionRequest, (TAVVideoCompositionInstruction)localObject);
    BenchUtil.benchEnd("compositingImages");
    BenchUtil.benchStart("renderToSampleBuffer");
    reportMemory();
    if (localObject != null)
    {
      localObject = this.ciContext.renderToSampleBuffer((CIImage)localObject, paramAsynchronousVideoCompositionRequest.getCompositionTime(), paramAsynchronousVideoCompositionRequest.getRenderContext().getRenderContext());
      if (LOG_VERBOSE) {
        Logger.d(this.TAG, "startVideoCompositionRequest: end, resultPixels = [" + localObject + "]");
      }
      this.reportSession.tickSuccess(System.nanoTime() - l);
      paramAsynchronousVideoCompositionRequest.finishWithComposedVideoFrame((CMSampleBuffer)localObject);
    }
    for (;;)
    {
      BenchUtil.benchEnd("renderToSampleBuffer");
      AppMethodBeat.o(192112);
      return;
      Logger.e(this.TAG, "startVideoCompositionRequest: end, ".concat(String.valueOf("destImage is null ")));
      this.reportSession.tickFailed();
      paramAsynchronousVideoCompositionRequest.finishWithError(new ErrorMsg(10086, "destImage is null "));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.TAVVideoCompositing
 * JD-Core Version:    0.7.0.1
 */