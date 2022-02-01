package com.tencent.tav.core.parallel.newversion;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.lifecycle.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.asset.Asset;
import com.tencent.tav.codec.IMediaFactory;
import com.tencent.tav.codec.MediaCodecAnalyse;
import com.tencent.tav.codec.MediaCodecAnalyse.Companion;
import com.tencent.tav.core.AssetExportSession.AssetExportSessionStatus;
import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.AssetParallelExportSession.ExportCallbackHandler;
import com.tencent.tav.core.AssetParallelSegmentStatus;
import com.tencent.tav.core.AudioMix;
import com.tencent.tav.core.ExportConfig;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tav.core.parallel.FixedParallelStrategy;
import com.tencent.tav.core.parallel.IParallelStrategy;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tav.decoder.logger.Logger;
import com.tencent.tav.decoder.muxer.IMediaMuxer;
import com.tencent.tav.decoder.muxer.MediaMuxerFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/newversion/AssetParallelExportWork;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;", "exportSession", "Lcom/tencent/tav/core/AssetParallelExportSession;", "callbackHandler", "Lcom/tencent/tav/core/AssetParallelExportSession$ExportCallbackHandler;", "audioMix", "Lcom/tencent/tav/core/AudioMix;", "encodeOption", "Lcom/tencent/tav/core/ExportConfig;", "(Lcom/tencent/tav/core/AssetParallelExportSession;Lcom/tencent/tav/core/AssetParallelExportSession$ExportCallbackHandler;Lcom/tencent/tav/core/AudioMix;Lcom/tencent/tav/core/ExportConfig;)V", "getAudioMix", "()Lcom/tencent/tav/core/AudioMix;", "setAudioMix", "(Lcom/tencent/tav/core/AudioMix;)V", "callbackControlHandle", "Landroid/os/Handler;", "callbackHandleThread", "Landroid/os/HandlerThread;", "getCallbackHandler", "()Lcom/tencent/tav/core/AssetParallelExportSession$ExportCallbackHandler;", "setCallbackHandler", "(Lcom/tencent/tav/core/AssetParallelExportSession$ExportCallbackHandler;)V", "currentFrameRate", "", "getEncodeOption", "()Lcom/tencent/tav/core/ExportConfig;", "setEncodeOption", "(Lcom/tencent/tav/core/ExportConfig;)V", "getExportSession", "()Lcom/tencent/tav/core/AssetParallelExportSession;", "setExportSession", "(Lcom/tencent/tav/core/AssetParallelExportSession;)V", "hardwareLimit", "", "isNeedCheckFrameProcessTimeout", "lastBalanceTimestampMs", "", "lastFrameRate", "lastProgressCallbackTimeStamp", "lock", "Ljava/lang/Object;", "maxParallelCount", "mediaFactory", "Lcom/tencent/tav/codec/IMediaFactory;", "parallelStartTimeMs", "renderContextParams", "Lcom/tencent/tav/decoder/RenderContextParams;", "resulted", "segmentIndicators", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "strategy", "Lcom/tencent/tav/core/parallel/IParallelStrategy;", "timeoutInterruptWork", "totalFrame", "workList", "Lcom/tencent/tav/core/parallel/newversion/AssetSingleExportThread;", "addWork", "", "work", "allWorkFinish", "cancel", "currentVideoRunSize", "findUnStartedIndicator", "getParallelCount", "handleResult", "status", "Lcom/tencent/tav/core/AssetExportSession$AssetExportSessionStatus;", "error", "Lcom/tencent/tav/core/ExportErrorStatus;", "hasUnknownWork", "mediaMux", "onChanged", "info", "release", "releaseSingleWork", "remove", "runnable", "Ljava/lang/Runnable;", "setMediaFactory", "setRenderContextParams", "setTimeoutParameter", "check", "interrupt", "startAudioWork", "startExport", "startVideoWork", "triggerLoadBalance", "Companion", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class AssetParallelExportWork
  implements y<PipelineIndicatorInfo>
{
  public static final AssetParallelExportWork.Companion Companion;
  private static final int DEFAULT_FRAME = 20;
  private static final int FRAME_BUFF = 10;
  private static final int MAX_WORK_COUNT = 5;
  private static final int PROGRESS_CALLBACK_INTERVAL = 10;
  private static final String TAG = "AssetParallelExportWork";
  private static final int TIME_INTERVAL = 2000;
  private AudioMix<?> audioMix;
  private final Handler callbackControlHandle;
  private final HandlerThread callbackHandleThread;
  private AssetParallelExportSession.ExportCallbackHandler callbackHandler;
  private int currentFrameRate;
  private ExportConfig encodeOption;
  private AssetParallelExportSession exportSession;
  private boolean hardwareLimit;
  private volatile boolean isNeedCheckFrameProcessTimeout;
  private long lastBalanceTimestampMs;
  private int lastFrameRate;
  private long lastProgressCallbackTimeStamp;
  private final Object lock;
  private int maxParallelCount;
  private IMediaFactory mediaFactory;
  private long parallelStartTimeMs;
  private RenderContextParams renderContextParams;
  private volatile boolean resulted;
  private final ArrayList<PipelineIndicatorInfo> segmentIndicators;
  private final IParallelStrategy strategy;
  private volatile boolean timeoutInterruptWork;
  private int totalFrame;
  private final ArrayList<AssetSingleExportThread> workList;
  
  static
  {
    AppMethodBeat.i(215781);
    Companion = new AssetParallelExportWork.Companion(null);
    AppMethodBeat.o(215781);
  }
  
  public AssetParallelExportWork(AssetParallelExportSession paramAssetParallelExportSession, AssetParallelExportSession.ExportCallbackHandler paramExportCallbackHandler, AudioMix<?> paramAudioMix, ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(215774);
    this.exportSession = paramAssetParallelExportSession;
    this.callbackHandler = paramExportCallbackHandler;
    this.audioMix = paramAudioMix;
    this.encodeOption = paramExportConfig;
    this.lock = new Object();
    this.strategy = ((IParallelStrategy)new FixedParallelStrategy(this.exportSession));
    this.segmentIndicators = new ArrayList();
    this.workList = new ArrayList();
    this.totalFrame = 30;
    this.lastFrameRate = 20;
    this.currentFrameRate = 20;
    this.isNeedCheckFrameProcessTimeout = true;
    this.callbackHandleThread = new HandlerThread("parallel-callback");
    this.strategy.calculateSubsection(this.exportSession, this.segmentIndicators);
    this.exportSession.setIndicatorInfo(this.segmentIndicators);
    this.callbackHandleThread.start();
    this.callbackControlHandle = new Handler(this.callbackHandleThread.getLooper());
    AppMethodBeat.o(215774);
  }
  
  private final void addWork(AssetSingleExportThread paramAssetSingleExportThread)
  {
    AppMethodBeat.i(215666);
    synchronized (this.lock)
    {
      this.workList.add(paramAssetSingleExportThread);
      AppMethodBeat.o(215666);
      return;
    }
  }
  
  private final boolean allWorkFinish()
  {
    AppMethodBeat.i(215711);
    Iterator localIterator = ((Iterable)this.segmentIndicators).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((PipelineIndicatorInfo)localObject).getSegmentStatus() != AssetParallelSegmentStatus.AssetExportStatusCompleted)
      {
        i = 1;
        label50:
        if (i == 0) {
          break label69;
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label76;
      }
      AppMethodBeat.o(215711);
      return true;
      i = 0;
      break label50;
      label69:
      break;
      localObject = null;
    }
    label76:
    AppMethodBeat.o(215711);
    return false;
  }
  
  private final int currentFrameRate()
  {
    return this.currentFrameRate * 1000 / 2000;
  }
  
  private final int currentVideoRunSize()
  {
    AppMethodBeat.i(215704);
    Collection localCollection;
    for (;;)
    {
      synchronized (this.lock)
      {
        Object localObject1 = (Iterable)this.workList;
        localCollection = (Collection)new ArrayList();
        Iterator localIterator = ((Iterable)localObject1).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject5 = localIterator.next();
        AssetSingleExportThread localAssetSingleExportThread = (AssetSingleExportThread)localObject5;
        localObject1 = localAssetSingleExportThread.indicatorInfo;
        if (localObject1 != null)
        {
          localObject1 = ((PipelineIndicatorInfo)localObject1).getSegmentStatus();
          if (localObject1 != AssetParallelSegmentStatus.AssetParallelStatusStarted) {
            break label142;
          }
          localObject1 = localAssetSingleExportThread.indicatorInfo;
          if ((localObject1 == null) || (((PipelineIndicatorInfo)localObject1).type != 1)) {
            break label142;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          localCollection.add(localObject5);
        }
      }
      Object localObject3 = null;
      continue;
      label142:
      i = 0;
    }
    int i = ((List)localCollection).size();
    AppMethodBeat.o(215704);
    return i;
  }
  
  private final PipelineIndicatorInfo findUnStartedIndicator()
  {
    AppMethodBeat.i(215679);
    Iterator localIterator = ((Iterable)this.segmentIndicators).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((PipelineIndicatorInfo)localObject).getSegmentStatus() == AssetParallelSegmentStatus.AssetParallelStatusUnknown)
      {
        i = 1;
        label50:
        if (i == 0) {
          break label70;
        }
      }
    }
    for (;;)
    {
      localObject = (PipelineIndicatorInfo)localObject;
      AppMethodBeat.o(215679);
      return localObject;
      i = 0;
      break label50;
      label70:
      break;
      localObject = null;
    }
  }
  
  private final void handleResult(final AssetExportSession.AssetExportSessionStatus paramAssetExportSessionStatus, final ExportErrorStatus paramExportErrorStatus)
  {
    try
    {
      AppMethodBeat.i(215737);
      Logger.i("AssetParallelExportWork", "handleResult " + paramAssetExportSessionStatus + " error:" + paramExportErrorStatus);
      this.callbackControlHandle.removeCallbacksAndMessages(null);
      this.callbackControlHandle.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(215645);
          this.this$0.getExportSession().status = paramAssetExportSessionStatus;
          this.this$0.getExportSession().exportErrorStatus = paramExportErrorStatus;
          AssetParallelExportSession.ExportCallbackHandler localExportCallbackHandler = this.this$0.getCallbackHandler();
          if (localExportCallbackHandler != null) {
            localExportCallbackHandler.handlerCallback(this.this$0.getExportSession());
          }
          this.this$0.setCallbackHandler(null);
          AssetParallelExportWork.access$release(this.this$0);
          AppMethodBeat.o(215645);
        }
      });
      AppMethodBeat.o(215737);
      return;
    }
    finally
    {
      paramAssetExportSessionStatus = finally;
      throw paramAssetExportSessionStatus;
    }
  }
  
  private final boolean hasUnknownWork()
  {
    AppMethodBeat.i(215719);
    Iterator localIterator = ((Iterable)this.segmentIndicators).iterator();
    Object localObject;
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((PipelineIndicatorInfo)localObject).getSegmentStatus() == AssetParallelSegmentStatus.AssetParallelStatusUnknown)
      {
        i = 1;
        label50:
        if (i == 0) {
          break label69;
        }
      }
    }
    for (;;)
    {
      if (localObject == null) {
        break label76;
      }
      AppMethodBeat.o(215719);
      return true;
      i = 0;
      break label50;
      label69:
      break;
      localObject = null;
    }
    label76:
    AppMethodBeat.o(215719);
    return false;
  }
  
  private final int mediaMux()
  {
    AppMethodBeat.i(215728);
    Logger.i("AssetParallelExportWork", "mediaMux:" + this.workList.size());
    synchronized (this.lock)
    {
      Object localObject3 = (Iterable)this.workList;
      Collection localCollection = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (AssetSingleExportThread)((Iterator)localObject3).next();
        ((AssetSingleExportThread)localObject4).getMuxer().stop();
        localObject4 = ((AssetSingleExportThread)localObject4).getMuxer();
        if (localObject4 != null) {
          localCollection.add(localObject4);
        }
      }
    }
    int i = MediaMuxerFactory.parallelMux((List)localObject2);
    AppMethodBeat.o(215728);
    return i;
  }
  
  private final void release()
  {
    AppMethodBeat.i(215744);
    this.callbackHandleThread.quitSafely();
    synchronized (this.lock)
    {
      Iterator localIterator = ((Iterable)this.workList).iterator();
      if (localIterator.hasNext())
      {
        AssetSingleExportThread localAssetSingleExportThread = (AssetSingleExportThread)localIterator.next();
        localAssetSingleExportThread.observe(null);
        localAssetSingleExportThread.release(null);
        localAssetSingleExportThread.clearResource();
      }
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(215744);
  }
  
  private final void releaseSingleWork(PipelineIndicatorInfo paramPipelineIndicatorInfo, boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(215754);
    Logger.i("AssetParallelExportWork", "releaseSingleWork:" + paramPipelineIndicatorInfo + " remove:" + paramBoolean);
    synchronized (this.lock)
    {
      Iterator localIterator = ((Iterable)this.workList).iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = localIterator.next();
        if (s.p(((AssetSingleExportThread)localObject1).indicatorInfo, paramPipelineIndicatorInfo))
        {
          paramPipelineIndicatorInfo = localObject1;
          paramPipelineIndicatorInfo = (AssetSingleExportThread)paramPipelineIndicatorInfo;
          if (paramPipelineIndicatorInfo != null)
          {
            paramPipelineIndicatorInfo.observe(null);
            paramPipelineIndicatorInfo.release(paramRunnable);
            if (paramBoolean)
            {
              paramPipelineIndicatorInfo.clearResource();
              this.workList.remove(paramPipelineIndicatorInfo);
            }
            paramPipelineIndicatorInfo = ah.aiuX;
          }
          AppMethodBeat.o(215754);
          return;
        }
      }
      paramPipelineIndicatorInfo = null;
    }
  }
  
  private final void startAudioWork()
  {
    AppMethodBeat.i(215658);
    Object localObject = this.exportSession.asset.tracksWithMediaType(2);
    if (localObject != null) {}
    for (int i = ((List)localObject).size(); i > 0; i = 0)
    {
      localObject = PipelineIndicatorInfo.getAudioPipelineIndicatorInfo(this.exportSession.timeRange);
      this.segmentIndicators.add(localObject);
      if (localObject == null) {
        break;
      }
      Logger.i("AssetParallelExportWork", "startAudioWork ".concat(String.valueOf(localObject)));
      localObject = new AssetSingleExportThread((PipelineIndicatorInfo)localObject, this.exportSession, this.audioMix, this.encodeOption);
      ((AssetSingleExportThread)localObject).setMediaFactory(this.mediaFactory);
      ((AssetSingleExportThread)localObject).observe((y)this);
      ((AssetSingleExportThread)localObject).setTimeoutParameter(this.isNeedCheckFrameProcessTimeout, this.timeoutInterruptWork);
      ((AssetSingleExportThread)localObject).startExport();
      addWork((AssetSingleExportThread)localObject);
      AppMethodBeat.o(215658);
      return;
    }
    AppMethodBeat.o(215658);
  }
  
  /* Error */
  private final void startVideoWork()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 468
    //   5: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokespecial 470	com/tencent/tav/core/parallel/newversion/AssetParallelExportWork:findUnStartedIndicator	()Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +92 -> 106
    //   17: ldc 130
    //   19: ldc_w 472
    //   22: aload_1
    //   23: invokestatic 446	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   26: invokevirtual 450	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokestatic 343	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_1
    //   33: getstatic 475	com/tencent/tav/core/AssetParallelSegmentStatus:AssetParallelStatusPrepared	Lcom/tencent/tav/core/AssetParallelSegmentStatus;
    //   36: invokevirtual 479	com/tencent/tav/core/parallel/info/PipelineIndicatorInfo:setSegmentStatus	(Lcom/tencent/tav/core/AssetParallelSegmentStatus;)V
    //   39: new 298	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread
    //   42: dup
    //   43: aload_1
    //   44: aload_0
    //   45: getfield 169	com/tencent/tav/core/parallel/newversion/AssetParallelExportWork:exportSession	Lcom/tencent/tav/core/AssetParallelExportSession;
    //   48: aload_0
    //   49: getfield 173	com/tencent/tav/core/parallel/newversion/AssetParallelExportWork:audioMix	Lcom/tencent/tav/core/AudioMix;
    //   52: aload_0
    //   53: getfield 175	com/tencent/tav/core/parallel/newversion/AssetParallelExportWork:encodeOption	Lcom/tencent/tav/core/ExportConfig;
    //   56: invokespecial 453	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:<init>	(Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;Lcom/tencent/tav/core/AssetParallelExportSession;Lcom/tencent/tav/core/AudioMix;Lcom/tencent/tav/core/ExportConfig;)V
    //   59: astore_1
    //   60: aload_1
    //   61: aload_0
    //   62: getfield 455	com/tencent/tav/core/parallel/newversion/AssetParallelExportWork:mediaFactory	Lcom/tencent/tav/codec/IMediaFactory;
    //   65: invokevirtual 458	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:setMediaFactory	(Lcom/tencent/tav/codec/IMediaFactory;)V
    //   68: aload_1
    //   69: aload_0
    //   70: checkcast 7	androidx/lifecycle/y
    //   73: invokevirtual 387	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:observe	(Landroidx/lifecycle/y;)V
    //   76: aload_1
    //   77: aload_0
    //   78: getfield 200	com/tencent/tav/core/parallel/newversion/AssetParallelExportWork:isNeedCheckFrameProcessTimeout	Z
    //   81: aload_0
    //   82: getfield 460	com/tencent/tav/core/parallel/newversion/AssetParallelExportWork:timeoutInterruptWork	Z
    //   85: invokevirtual 463	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:setTimeoutParameter	(ZZ)V
    //   88: aload_1
    //   89: invokevirtual 465	com/tencent/tav/core/parallel/newversion/AssetSingleExportThread:startExport	()V
    //   92: aload_0
    //   93: aload_1
    //   94: invokespecial 467	com/tencent/tav/core/parallel/newversion/AssetParallelExportWork:addWork	(Lcom/tencent/tav/core/parallel/newversion/AssetSingleExportThread;)V
    //   97: ldc_w 468
    //   100: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: monitorexit
    //   105: return
    //   106: ldc_w 468
    //   109: invokestatic 155	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: goto -9 -> 103
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	AssetParallelExportWork
    //   12	82	1	localObject1	Object
    //   115	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	115	finally
    //   17	103	115	finally
    //   106	112	115	finally
  }
  
  private final void triggerLoadBalance()
  {
    AppMethodBeat.i(215691);
    this.currentFrameRate += 1;
    this.totalFrame += 1;
    int i = currentVideoRunSize();
    if (System.currentTimeMillis() - this.lastBalanceTimestampMs >= 2000L)
    {
      this.lastBalanceTimestampMs = System.currentTimeMillis();
      long l = this.totalFrame * 1000 / (this.lastBalanceTimestampMs - this.parallelStartTimeMs);
      if ((currentFrameRate() - this.lastFrameRate >= 10) && (!this.hardwareLimit)) {
        startVideoWork();
      }
      Logger.i("AssetParallelExportWork", "current video work size:" + i + ' ' + "frameRate:" + l + ' ' + "currentRate:" + currentFrameRate() + ' ' + "lastFrameRate:" + this.lastFrameRate + ' ' + "maxParallelCount:" + this.maxParallelCount + ' ' + "mediaCodec count:" + MediaCodecAnalyse.Companion.instanceCount());
      this.lastFrameRate = k.qu(currentFrameRate(), this.lastFrameRate);
      this.currentFrameRate = 0;
    }
    this.maxParallelCount = k.qu(this.maxParallelCount, i);
    AppMethodBeat.o(215691);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(215865);
    Logger.i("AssetParallelExportWork", "cancel");
    ExportErrorStatus localExportErrorStatus = new ExportErrorStatus(-11);
    handleResult(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCancelled, localExportErrorStatus);
    AppMethodBeat.o(215865);
  }
  
  public final AudioMix<?> getAudioMix()
  {
    return this.audioMix;
  }
  
  public final AssetParallelExportSession.ExportCallbackHandler getCallbackHandler()
  {
    return this.callbackHandler;
  }
  
  public final ExportConfig getEncodeOption()
  {
    return this.encodeOption;
  }
  
  public final AssetParallelExportSession getExportSession()
  {
    return this.exportSession;
  }
  
  public final int getParallelCount()
  {
    return this.maxParallelCount;
  }
  
  public final void onChanged(PipelineIndicatorInfo paramPipelineIndicatorInfo)
  {
    AppMethodBeat.i(215856);
    if (paramPipelineIndicatorInfo != null)
    {
      if (paramPipelineIndicatorInfo.type == 1) {
        triggerLoadBalance();
      }
      if (paramPipelineIndicatorInfo.getSegmentStatus() == AssetParallelSegmentStatus.AssetParallelStatusStarted)
      {
        this.callbackControlHandle.post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215610);
            if (System.currentTimeMillis() - AssetParallelExportWork.access$getLastProgressCallbackTimeStamp$p(this.this$0) >= 10L)
            {
              Object localObject = (Iterable)AssetParallelExportWork.access$getSegmentIndicators$p(this.this$0);
              double d = 0.0D;
              localObject = ((Iterable)localObject).iterator();
              while (((Iterator)localObject).hasNext()) {
                d = ((PipelineIndicatorInfo)((Iterator)localObject).next()).getProgress() + d;
              }
              this.this$0.getExportSession().progress = ((float)(d / AssetParallelExportWork.access$getSegmentIndicators$p(this.this$0).size()));
              localObject = this.this$0.getCallbackHandler();
              if (localObject != null) {
                ((AssetParallelExportSession.ExportCallbackHandler)localObject).handlerCallback(this.this$0.getExportSession());
              }
              AssetParallelExportWork.access$setLastProgressCallbackTimeStamp$p(this.this$0, System.currentTimeMillis());
              Logger.d("AssetParallelExportWork", "handle progress:" + this.this$0.getExportSession().progress);
            }
            AppMethodBeat.o(215610);
          }
        });
        AppMethodBeat.o(215856);
        return;
      }
      if (paramPipelineIndicatorInfo.getSegmentStatus() == AssetParallelSegmentStatus.AssetExportStatusCompleted)
      {
        Logger.i("AssetParallelExportWork", "PipelineIndicatorInfo finish:".concat(String.valueOf(paramPipelineIndicatorInfo)));
        if (hasUnknownWork())
        {
          releaseSingleWork(paramPipelineIndicatorInfo, false, (Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215600);
              AssetParallelExportWork.access$startVideoWork(this.this$0);
              AppMethodBeat.o(215600);
            }
          });
          AppMethodBeat.o(215856);
          return;
        }
        if ((allWorkFinish()) && (!this.resulted))
        {
          this.resulted = true;
          int i = mediaMux();
          Logger.i("AssetParallelExportWork", "mediaMux ret:".concat(String.valueOf(i)));
          if (i != 0)
          {
            paramPipelineIndicatorInfo = new ExportErrorStatus(-205);
            handleResult(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed, paramPipelineIndicatorInfo);
            AppMethodBeat.o(215856);
            return;
          }
          paramPipelineIndicatorInfo = new ExportErrorStatus(0);
          handleResult(AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusCompleted, paramPipelineIndicatorInfo);
        }
        AppMethodBeat.o(215856);
        return;
      }
      if (paramPipelineIndicatorInfo.getSegmentStatus() == AssetParallelSegmentStatus.AssetParallelStatusFailed)
      {
        this.hardwareLimit = true;
        Logger.e("AssetParallelExportWork", "exportError index:" + paramPipelineIndicatorInfo.getIndex() + " parallel:" + getParallelCount() + " :" + paramPipelineIndicatorInfo.errorStatus + " retry count:" + paramPipelineIndicatorInfo.getRetryCount() + " mediaCodec count:" + MediaCodecAnalyse.Companion.instanceCount());
        if (paramPipelineIndicatorInfo.getRetryCount() <= 0)
        {
          paramPipelineIndicatorInfo.retry();
          releaseSingleWork(paramPipelineIndicatorInfo, true, (Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(215602);
              if (AssetParallelExportWork.access$currentVideoRunSize(this.this$0) <= 0) {
                AssetParallelExportWork.access$startVideoWork(this.this$0);
              }
              AppMethodBeat.o(215602);
            }
          });
          AppMethodBeat.o(215856);
          return;
        }
        AssetExportSession.AssetExportSessionStatus localAssetExportSessionStatus = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusFailed;
        paramPipelineIndicatorInfo = paramPipelineIndicatorInfo.errorStatus;
        s.r(paramPipelineIndicatorInfo, "it.errorStatus");
        handleResult(localAssetExportSessionStatus, paramPipelineIndicatorInfo);
      }
      AppMethodBeat.o(215856);
      return;
    }
    AppMethodBeat.o(215856);
  }
  
  public final void setAudioMix(AudioMix<?> paramAudioMix)
  {
    this.audioMix = paramAudioMix;
  }
  
  public final void setCallbackHandler(AssetParallelExportSession.ExportCallbackHandler paramExportCallbackHandler)
  {
    this.callbackHandler = paramExportCallbackHandler;
  }
  
  public final void setEncodeOption(ExportConfig paramExportConfig)
  {
    AppMethodBeat.i(215906);
    s.t(paramExportConfig, "<set-?>");
    this.encodeOption = paramExportConfig;
    AppMethodBeat.o(215906);
  }
  
  public final void setExportSession(AssetParallelExportSession paramAssetParallelExportSession)
  {
    AppMethodBeat.i(215875);
    s.t(paramAssetParallelExportSession, "<set-?>");
    this.exportSession = paramAssetParallelExportSession;
    AppMethodBeat.o(215875);
  }
  
  public final void setMediaFactory(IMediaFactory paramIMediaFactory)
  {
    this.mediaFactory = paramIMediaFactory;
  }
  
  public final void setRenderContextParams(RenderContextParams paramRenderContextParams)
  {
    this.renderContextParams = paramRenderContextParams;
  }
  
  public final void setTimeoutParameter(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(215843);
    this.isNeedCheckFrameProcessTimeout = paramBoolean1;
    this.timeoutInterruptWork = paramBoolean2;
    Logger.i("AssetParallelExportWork", "setNeedCheckFrameProcessTimeout:%b timeoutInterruptWork:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    AppMethodBeat.o(215843);
  }
  
  public final void startExport()
  {
    AppMethodBeat.i(215848);
    Logger.i("AssetParallelExportWork", "start work,print indicator info");
    Iterator localIterator = ((Iterable)this.segmentIndicators).iterator();
    while (localIterator.hasNext()) {
      Logger.i("AssetParallelExportWork", String.valueOf((PipelineIndicatorInfo)localIterator.next()));
    }
    this.exportSession.status = AssetExportSession.AssetExportSessionStatus.AssetExportSessionStatusExporting;
    this.parallelStartTimeMs = System.currentTimeMillis();
    this.lastBalanceTimestampMs = this.parallelStartTimeMs;
    startAudioWork();
    startVideoWork();
    AppMethodBeat.o(215848);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.newversion.AssetParallelExportWork
 * JD-Core Version:    0.7.0.1
 */