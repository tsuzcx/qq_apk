package com.tencent.tav.core;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.asset.AssetTrack;
import com.tencent.tav.core.compositing.VideoCompositing;
import com.tencent.tav.core.composition.VideoComposition;
import com.tencent.tav.coremedia.CGRect;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.Filter;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;

public class AssetImageGenerator
{
  private final String TAG;
  private ApertureMode apertureMode;
  private boolean appliesPreferredTrackTransform;
  protected Asset asset;
  protected AssetExtension assetExtension;
  private final ImageGeneratorThread generatorThread;
  private long generatorThreadId;
  private CGSize maximumSize;
  private ByteBuffer outBitmapReaderBuffer;
  private String outSavePath;
  private OutputBitmapFactory outputBitmapFactory;
  private RenderContext renderContext;
  private RenderContextParams renderContextParams;
  private VideoCompositing videoCompositing;
  private VideoComposition videoComposition;
  private VideoCompositionDecoderTrack videoCompositionDecoderTrack;
  
  public AssetImageGenerator(Asset paramAsset)
  {
    this(paramAsset, new AssetExtension("thumbnail"));
    AppMethodBeat.i(215259);
    AppMethodBeat.o(215259);
  }
  
  public AssetImageGenerator(Asset paramAsset, AssetExtension paramAssetExtension)
  {
    AppMethodBeat.i(215267);
    this.TAG = ("AssetImageGenerator@" + Integer.toHexString(hashCode()));
    this.generatorThreadId = -1L;
    this.asset = paramAsset;
    this.assetExtension = paramAssetExtension;
    this.apertureMode = ApertureMode.aspectFit;
    this.generatorThread = new ImageGeneratorThread("image_generator");
    this.generatorThread.start();
    ImageGeneratorThread.access$000(this.generatorThread);
    AppMethodBeat.o(215267);
  }
  
  private Bitmap bitmapFromFBO(RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215343);
    TextureInfo localTextureInfo = paramCMSampleBuffer.getTextureInfo();
    if (localTextureInfo == null)
    {
      AppMethodBeat.o(215343);
      return null;
    }
    Bitmap localBitmap = readBitmapFromTexture(paramRenderContext, localTextureInfo);
    paramRenderContext = getMatrix(this.maximumSize, new CGSize(localTextureInfo.width, localTextureInfo.height));
    paramCMSampleBuffer = new Matrix();
    paramCMSampleBuffer.postScale(1.0F, -1.0F);
    paramCMSampleBuffer.postTranslate(0.0F, localBitmap.getHeight());
    if (paramRenderContext != null)
    {
      paramRenderContext.postConcat(paramCMSampleBuffer);
      if (this.maximumSize == null) {
        break label139;
      }
    }
    label139:
    for (paramCMSampleBuffer = this.maximumSize;; paramCMSampleBuffer = new CGSize(localTextureInfo.width, localTextureInfo.height))
    {
      paramRenderContext = Bitmap.createBitmap(localBitmap, 0, 0, (int)paramCMSampleBuffer.width, (int)paramCMSampleBuffer.height, paramRenderContext, true);
      AppMethodBeat.o(215343);
      return paramRenderContext;
      paramRenderContext = paramCMSampleBuffer;
      break;
    }
  }
  
  private Bitmap doGenerator(CMTime paramCMTime)
  {
    AppMethodBeat.i(215287);
    RenderContext localRenderContext = initRenderContext();
    paramCMTime = getCmSampleBuffer(paramCMTime, localRenderContext);
    if (!localRenderContext.isPBufferEnable())
    {
      paramCMTime = bitmapFromFBO(localRenderContext, paramCMTime);
      AppMethodBeat.o(215287);
      return paramCMTime;
    }
    paramCMTime = readBitmap(renderToMaximumSizeBox(localRenderContext, paramCMTime));
    AppMethodBeat.o(215287);
    return paramCMTime;
  }
  
  private void doRelease()
  {
    AppMethodBeat.i(215278);
    Logger.d(this.TAG, "doRelease: start, thread = " + Thread.currentThread().getName());
    if (this.videoCompositionDecoderTrack != null)
    {
      this.videoCompositionDecoderTrack.release();
      this.videoCompositionDecoderTrack = null;
    }
    if (this.videoCompositing != null)
    {
      this.videoCompositing.release();
      this.videoCompositing = null;
    }
    if (this.renderContext != null)
    {
      this.renderContext.release();
      this.renderContext = null;
    }
    this.videoComposition = null;
    Logger.d(this.TAG, "doRelease: end, thread = " + Thread.currentThread().getName());
    AppMethodBeat.o(215278);
  }
  
  private CMSampleBuffer getCmSampleBuffer(CMTime paramCMTime, RenderContext paramRenderContext)
  {
    AppMethodBeat.i(215307);
    if (this.videoCompositionDecoderTrack == null)
    {
      this.videoCompositionDecoderTrack = new VideoCompositionDecoderTrack(this.assetExtension, 1);
      localObject = this.asset.getTracks().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AssetTrack localAssetTrack = (AssetTrack)((Iterator)localObject).next();
        if (localAssetTrack.getMediaType() == 1) {
          this.videoCompositionDecoderTrack.addTrack(localAssetTrack);
        }
      }
      this.videoCompositionDecoderTrack.setVideoComposition(this.videoComposition);
      if (this.videoComposition != null) {
        break label155;
      }
    }
    label155:
    for (Object localObject = null;; localObject = this.videoComposition.getCustomVideoCompositor())
    {
      this.videoCompositing = ((VideoCompositing)localObject);
      this.videoCompositionDecoderTrack.setVideoCompositing(this.videoCompositing);
      this.videoCompositionDecoderTrack.start(paramRenderContext);
      this.videoCompositionDecoderTrack.seekTo(paramCMTime, false, true);
      paramCMTime = this.videoCompositionDecoderTrack.readSample(paramCMTime);
      AppMethodBeat.o(215307);
      return paramCMTime;
    }
  }
  
  private Matrix getMatrix(CGSize paramCGSize1, CGSize paramCGSize2)
  {
    AppMethodBeat.i(215324);
    if ((paramCGSize1 == null) || (paramCGSize2 == null) || (this.apertureMode == null))
    {
      AppMethodBeat.o(215324);
      return null;
    }
    paramCGSize2 = new CGRect(new PointF(), paramCGSize2);
    paramCGSize1 = new CGRect(new PointF(), paramCGSize1);
    switch (1.$SwitchMap$com$tencent$tav$core$AssetImageGenerator$ApertureMode[this.apertureMode.ordinal()])
    {
    default: 
      AppMethodBeat.o(215324);
      return null;
    case 1: 
      paramCGSize1 = CGMathFunctions.transformBySourceRectFit(paramCGSize2, paramCGSize1);
      AppMethodBeat.o(215324);
      return paramCGSize1;
    case 2: 
      paramCGSize1 = CGMathFunctions.transformBySourceRectFill(paramCGSize2, paramCGSize1);
      AppMethodBeat.o(215324);
      return paramCGSize1;
    }
    paramCGSize1 = CGMathFunctions.transformByScaleFitRect(paramCGSize2, paramCGSize1);
    AppMethodBeat.o(215324);
    return paramCGSize1;
  }
  
  private RenderContext initRenderContext()
  {
    AppMethodBeat.i(215296);
    this.generatorThreadId = Thread.currentThread().getId();
    if (this.renderContext == null) {
      if (this.maximumSize == null) {
        break label87;
      }
    }
    label87:
    for (Object localObject = this.maximumSize;; localObject = this.asset.getNaturalSize())
    {
      this.renderContext = new RenderContext((int)((CGSize)localObject).width, (int)((CGSize)localObject).height);
      this.renderContext.setParams(this.renderContextParams);
      this.renderContext.makeCurrent();
      localObject = this.renderContext;
      AppMethodBeat.o(215296);
      return localObject;
    }
  }
  
  private Bitmap readBitmap(CGSize paramCGSize)
  {
    AppMethodBeat.i(215333);
    if (this.outputBitmapFactory == null) {
      this.outputBitmapFactory = new DefaultBitmapFactory(null);
    }
    paramCGSize = this.outputBitmapFactory.getOutputBitmap((int)paramCGSize.width, (int)paramCGSize.height);
    if ((paramCGSize.getConfig() != Bitmap.Config.ARGB_8888) && (paramCGSize.getConfig() != Bitmap.Config.ARGB_4444))
    {
      Logger.e(this.TAG, "readBitmap: bitmap 格式错误：暂时只支持ARGB_8888、ARGB_4444格式");
      AppMethodBeat.o(215333);
      return paramCGSize;
    }
    int i = paramCGSize.getWidth() * paramCGSize.getHeight() * 4;
    if ((this.outBitmapReaderBuffer == null) || (this.outBitmapReaderBuffer.capacity() < i))
    {
      this.outBitmapReaderBuffer = ByteBuffer.allocateDirect(i);
      this.outBitmapReaderBuffer.order(ByteOrder.LITTLE_ENDIAN);
      this.outBitmapReaderBuffer.rewind();
      this.outBitmapReaderBuffer.clear();
    }
    GLES20.glReadPixels(0, 0, paramCGSize.getWidth(), paramCGSize.getHeight(), 6408, 5121, this.outBitmapReaderBuffer);
    this.outBitmapReaderBuffer.rewind();
    paramCGSize.copyPixelsFromBuffer(this.outBitmapReaderBuffer);
    this.outBitmapReaderBuffer.clear();
    AppMethodBeat.o(215333);
    return paramCGSize;
  }
  
  private Bitmap readBitmapFromTexture(RenderContext paramRenderContext, TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(215354);
    paramRenderContext.makeCurrent();
    paramRenderContext = new int[1];
    GLES20.glGenFramebuffers(1, paramRenderContext, 0);
    GLES20.glBindFramebuffer(36160, paramRenderContext[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramTextureInfo.textureID, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramTextureInfo.width * paramTextureInfo.height * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, paramTextureInfo.width, paramTextureInfo.height, 6408, 5121, localByteBuffer);
    paramTextureInfo = Bitmap.createBitmap(paramTextureInfo.width, paramTextureInfo.height, Bitmap.Config.ARGB_8888);
    localByteBuffer.rewind();
    paramTextureInfo.copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, paramRenderContext, 0);
    AppMethodBeat.o(215354);
    return paramTextureInfo;
  }
  
  private CGSize renderToMaximumSizeBox(RenderContext paramRenderContext, CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215318);
    TextureInfo localTextureInfo = paramCMSampleBuffer.getTextureInfo();
    if (this.maximumSize != null) {}
    for (CGSize localCGSize = this.maximumSize;; localCGSize = new CGSize(localTextureInfo.width, localTextureInfo.height))
    {
      if (localTextureInfo != null)
      {
        Filter localFilter = new Filter();
        localFilter.setRendererWidth((int)localCGSize.width);
        localFilter.setRendererHeight((int)localCGSize.height);
        Matrix localMatrix1 = getMatrix(this.maximumSize, new CGSize(localTextureInfo.width, localTextureInfo.height));
        paramRenderContext.makeCurrent();
        Matrix localMatrix2 = new Matrix();
        localMatrix2.setValues(new float[] { 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, 0.0F, 1.0F });
        int[] arrayOfInt = new int[4];
        GLES20.glGetIntegerv(2978, arrayOfInt, 0);
        GLES20.glViewport(0, 0, (int)localCGSize.width, (int)localCGSize.height);
        localFilter.applyFilter(localTextureInfo, localMatrix1, localMatrix2);
        localFilter.release();
        paramRenderContext.setPresentationTime(paramCMSampleBuffer.getTime().getTimeUs());
        paramRenderContext.swapBuffers();
        GLES20.glViewport(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
      }
      AppMethodBeat.o(215318);
      return localCGSize;
    }
  }
  
  public Bitmap copyCGImageAtTimeAndActualTime(CMTime paramCMTime1, CMTime paramCMTime2)
  {
    AppMethodBeat.i(215447);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramCMTime1 = new Exception("cannot process in the main thread");
      AppMethodBeat.o(215447);
      throw paramCMTime1;
    }
    paramCMTime1 = doGenerator(paramCMTime1);
    AppMethodBeat.o(215447);
    return paramCMTime1;
  }
  
  public void generateCGImagesAsynchronouslyForTimes(List<CMTime> paramList, ImageGeneratorListener paramImageGeneratorListener)
  {
    AppMethodBeat.i(215454);
    this.generatorThread.setRequestedTimes(paramList);
    this.generatorThread.setGeneratorListener(paramImageGeneratorListener);
    ImageGeneratorThread.access$100(this.generatorThread);
    AppMethodBeat.o(215454);
  }
  
  public AssetExtension getAssetExtension()
  {
    return this.assetExtension;
  }
  
  public RenderContextParams getRenderContextParams()
  {
    return this.renderContextParams;
  }
  
  public void release()
  {
    AppMethodBeat.i(215462);
    if (Thread.currentThread().getId() != this.generatorThreadId)
    {
      ImageGeneratorThread.access$200(this.generatorThread);
      this.videoComposition = null;
      AppMethodBeat.o(215462);
      return;
    }
    doRelease();
    this.generatorThread.quit();
    AppMethodBeat.o(215462);
  }
  
  public void setApertureMode(ApertureMode paramApertureMode)
  {
    this.apertureMode = paramApertureMode;
  }
  
  public void setAppliesPreferredTrackTransform(boolean paramBoolean)
  {
    this.appliesPreferredTrackTransform = paramBoolean;
  }
  
  public void setMaximumSize(CGSize paramCGSize)
  {
    this.maximumSize = paramCGSize;
  }
  
  public void setOutSavePath(String paramString)
  {
    this.outSavePath = paramString;
  }
  
  public void setOutputBitmapFactory(OutputBitmapFactory paramOutputBitmapFactory)
  {
    this.outputBitmapFactory = paramOutputBitmapFactory;
  }
  
  public void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    AppMethodBeat.i(215438);
    this.renderContextParams = paramRenderContextParams;
    if (this.renderContext != null) {
      this.renderContext.setParams(paramRenderContextParams);
    }
    AppMethodBeat.o(215438);
  }
  
  public void setVideoComposition(VideoComposition paramVideoComposition)
  {
    this.videoComposition = paramVideoComposition;
  }
  
  public static enum ApertureMode
  {
    static
    {
      AppMethodBeat.i(215212);
      aspectFit = new ApertureMode("aspectFit", 0);
      aspectFill = new ApertureMode("aspectFill", 1);
      scaleToFit = new ApertureMode("scaleToFit", 2);
      $VALUES = new ApertureMode[] { aspectFit, aspectFill, scaleToFit };
      AppMethodBeat.o(215212);
    }
    
    private ApertureMode() {}
  }
  
  static class DefaultBitmapFactory
    implements AssetImageGenerator.OutputBitmapFactory
  {
    public Bitmap getOutputBitmap(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(215690);
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      AppMethodBeat.o(215690);
      return localBitmap;
    }
  }
  
  public static abstract interface ImageGeneratorListener
  {
    public abstract void onCompletion(CMTime paramCMTime1, Bitmap paramBitmap, CMTime paramCMTime2, AssetImageGenerator.AssetImageGeneratorResult paramAssetImageGeneratorResult);
  }
  
  class ImageGeneratorThread
    extends HandlerThread
    implements Handler.Callback
  {
    private static final int MSG_CREATE_RENDERCONTEXT = 3;
    private static final int MSG_GENERATOR_COVER = 1;
    private static final int MSG_RELEASE = 2;
    private AssetImageGenerator.ImageGeneratorListener generatorListener;
    private Handler handler;
    private List<CMTime> requestedTimes;
    
    public ImageGeneratorThread(String paramString)
    {
      super();
    }
    
    private void generatorCover()
    {
      AppMethodBeat.i(215380);
      Iterator localIterator = this.requestedTimes.iterator();
      while (localIterator.hasNext())
      {
        CMTime localCMTime = (CMTime)localIterator.next();
        Message localMessage = Message.obtain();
        localMessage.what = 1;
        localMessage.obj = localCMTime;
        this.handler.sendMessage(localMessage);
      }
      AppMethodBeat.o(215380);
    }
    
    private void initHandler()
    {
      AppMethodBeat.i(215369);
      this.handler = new Handler(getLooper(), this);
      AppMethodBeat.o(215369);
    }
    
    private void release()
    {
      AppMethodBeat.i(215392);
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      this.handler.sendMessage(localMessage);
      AppMethodBeat.o(215392);
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(215445);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(215445);
        return false;
        try
        {
          Bitmap localBitmap = AssetImageGenerator.this.copyCGImageAtTimeAndActualTime((CMTime)paramMessage.obj, null);
          if (this.generatorListener == null) {
            continue;
          }
          AssetImageGenerator.ImageGeneratorListener localImageGeneratorListener = this.generatorListener;
          CMTime localCMTime = (CMTime)paramMessage.obj;
          if (localBitmap != null)
          {
            paramMessage = AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorSucceeded;
            localImageGeneratorListener.onCompletion(localCMTime, localBitmap, null, paramMessage);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Logger.e(AssetImageGenerator.this.TAG, "copyCGImage", localException);
            Object localObject = null;
            continue;
            paramMessage = AssetImageGenerator.AssetImageGeneratorResult.AssetImageGeneratorFailed;
          }
        }
        this.handler.removeCallbacksAndMessages(null);
        AssetImageGenerator.access$500(AssetImageGenerator.this);
        quit();
      }
    }
    
    protected void onLooperPrepared()
    {
      AppMethodBeat.i(215424);
      super.onLooperPrepared();
      AppMethodBeat.o(215424);
    }
    
    public void setGeneratorListener(AssetImageGenerator.ImageGeneratorListener paramImageGeneratorListener)
    {
      this.generatorListener = paramImageGeneratorListener;
    }
    
    public void setRequestedTimes(List<CMTime> paramList)
    {
      this.requestedTimes = paramList;
    }
  }
  
  public static abstract interface OutputBitmapFactory
  {
    public abstract Bitmap getOutputBitmap(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AssetImageGenerator
 * JD-Core Version:    0.7.0.1
 */