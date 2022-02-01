package com.tencent.tav.core.parallel.control;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.core.AssetParallelSegmentStatus;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.core.parallel.info.PipelineWorkInfo;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tav/core/parallel/control/ParallelExportController;", "", "()V", "currentFrameRate", "", "exportWork", "Ljava/util/ArrayList;", "Lcom/tencent/tav/core/parallel/info/PipelineWorkInfo;", "Lkotlin/collections/ArrayList;", "hardwareLimit", "", "lastFrameRate", "lastTimestampMs", "", "maxParallelCount", "getMaxParallelCount", "()I", "setMaxParallelCount", "(I)V", "performanceMap", "Ljava/util/HashMap;", "Lcom/tencent/tav/core/parallel/control/ParallelExportAnalyse;", "Lkotlin/collections/HashMap;", "releaseWork", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "info", "Ljava/lang/Runnable;", "callback", "_", "", "startTimeMs", "startWork", "Lkotlin/Function1;", "totalFrame", "allSuccess", "allWorkFinish", "analyseAppendSampleBuffer", "buffer", "Lcom/tencent/tav/coremedia/CMSampleBuffer;", "analyseGetSampleBuffer", "canWorkReuse", "createNewWork", "currentRunSize", "handleWorkFinish", "hasPreparedWork", "markHardwareLimit", "Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;", "registerFunction", "releaseWorkResource", "reuseWork", "setupWorkInfo", "startExport", "tryStartOneMoreWork", "Companion", "avfoundation_release"}, k=1, mv={1, 1, 15})
public final class ParallelExportController
{
  public static final ParallelExportController.Companion Companion;
  private static final int DEFAULT_FRAME = 20;
  private static final int FRAME_BUFF = 10;
  private static final int MAX_WORK_COUNT = 5;
  private static final String TAG = "ParallelExportController";
  private static final int TIME_INTERVAL = 3000;
  private int currentFrameRate;
  private ArrayList<PipelineWorkInfo> exportWork;
  private boolean hardwareLimit;
  private int lastFrameRate;
  private long lastTimestampMs;
  private int maxParallelCount;
  private final HashMap<PipelineWorkInfo, ParallelExportAnalyse> performanceMap;
  private q<? super PipelineWorkInfo, ? super Runnable, ? super Boolean, ah> releaseWork;
  private long startTimeMs;
  private b<? super PipelineWorkInfo, ah> startWork;
  private int totalFrame;
  
  static
  {
    AppMethodBeat.i(215637);
    Companion = new ParallelExportController.Companion(null);
    AppMethodBeat.o(215637);
  }
  
  public ParallelExportController()
  {
    AppMethodBeat.i(215635);
    this.performanceMap = new HashMap();
    this.totalFrame = 30;
    this.lastFrameRate = 20;
    this.currentFrameRate = 20;
    AppMethodBeat.o(215635);
  }
  
  private final void createNewWork(b<? super PipelineWorkInfo, ah> paramb)
  {
    Object localObject3 = null;
    AppMethodBeat.i(215625);
    label180:
    if (paramb != null)
    {
      Object localObject1 = this.exportWork;
      Object localObject2;
      Object localObject4;
      PipelineIndicatorInfo localPipelineIndicatorInfo;
      int i;
      if (localObject1 != null)
      {
        localObject2 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = ((Iterator)localObject2).next();
          localObject4 = (PipelineWorkInfo)localObject1;
          localPipelineIndicatorInfo = ((PipelineWorkInfo)localObject4).getIndicator();
          s.r(localPipelineIndicatorInfo, "it.indicator");
          if ((localPipelineIndicatorInfo.getSegmentStatus() == AssetParallelSegmentStatus.AssetParallelStatusPrepared) && (((PipelineWorkInfo)localObject4).getIndicator().type == 1))
          {
            i = 1;
            label95:
            if (i == 0) {
              break label180;
            }
          }
        }
      }
      label99:
      for (localObject1 = (PipelineWorkInfo)localObject1;; localObject1 = null)
      {
        localObject4 = new StringBuilder("tryStartOneMoreWork index:");
        localObject2 = localObject3;
        if (localObject1 != null)
        {
          localPipelineIndicatorInfo = ((PipelineWorkInfo)localObject1).getIndicator();
          localObject2 = localObject3;
          if (localPipelineIndicatorInfo != null) {
            localObject2 = Integer.valueOf(localPipelineIndicatorInfo.getIndex());
          }
        }
        Logger.i("ParallelExportController", localObject2);
        paramb.invoke(localObject1);
        AppMethodBeat.o(215625);
        return;
        i = 0;
        break label95;
        break;
        localObject1 = null;
        break label99;
      }
    }
    AppMethodBeat.o(215625);
  }
  
  private final int currentFrameRate()
  {
    return this.currentFrameRate * 1000 / 3000;
  }
  
  private final boolean hasPreparedWork()
  {
    AppMethodBeat.i(215632);
    Object localObject = this.exportWork;
    int i;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        PipelineWorkInfo localPipelineWorkInfo = (PipelineWorkInfo)localObject;
        PipelineIndicatorInfo localPipelineIndicatorInfo = localPipelineWorkInfo.getIndicator();
        s.r(localPipelineIndicatorInfo, "it.indicator");
        if ((localPipelineIndicatorInfo.getSegmentStatus() == AssetParallelSegmentStatus.AssetParallelStatusPrepared) && (localPipelineWorkInfo.getIndicator().type == 1))
        {
          i = 1;
          label85:
          if (i == 0) {
            break label108;
          }
        }
      }
    }
    label89:
    for (localObject = (PipelineWorkInfo)localObject;; localObject = null)
    {
      if (localObject == null) {
        break label120;
      }
      AppMethodBeat.o(215632);
      return true;
      i = 0;
      break label85;
      label108:
      break;
      localObject = null;
      break label89;
    }
    label120:
    AppMethodBeat.o(215632);
    return false;
  }
  
  private final void releaseWorkResource(Runnable paramRunnable)
  {
    AppMethodBeat.i(215619);
    Object localObject1 = this.exportWork;
    if (localObject1 != null)
    {
      Object localObject2 = ((Iterable)localObject1).iterator();
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        Object localObject3 = (PipelineWorkInfo)localObject1;
        PipelineIndicatorInfo localPipelineIndicatorInfo = ((PipelineWorkInfo)localObject3).getIndicator();
        s.r(localPipelineIndicatorInfo, "it.indicator");
        if ((localPipelineIndicatorInfo.getSegmentStatus() == AssetParallelSegmentStatus.AssetReaderStatusWriteFinish) && (((PipelineWorkInfo)localObject3).getIndicator().type == 1))
        {
          localObject3 = ((PipelineWorkInfo)localObject3).thread;
          if ((localObject3 != null) && (((HandlerThread)localObject3).isAlive() == true))
          {
            i = 1;
            label109:
            if (i == 0) {
              break label155;
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = (PipelineWorkInfo)localObject1;
        if (localObject1 == null) {
          break label168;
        }
        localObject2 = this.releaseWork;
        if (localObject2 == null) {
          break label162;
        }
        ((q)localObject2).invoke(localObject1, paramRunnable, Boolean.FALSE);
        AppMethodBeat.o(215619);
        return;
        i = 0;
        break label109;
        label155:
        break;
        localObject1 = null;
      }
      label162:
      AppMethodBeat.o(215619);
      return;
    }
    label168:
    paramRunnable.run();
    AppMethodBeat.o(215619);
  }
  
  private final void reuseWork(b<? super PipelineWorkInfo, ah> paramb)
  {
    AppMethodBeat.i(215615);
    Object localObject1 = this.exportWork;
    if (localObject1 != null)
    {
      Object localObject2 = ((Iterable)localObject1).iterator();
      int i;
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = ((Iterator)localObject2).next();
        localObject3 = (PipelineWorkInfo)localObject1;
        localObject4 = ((PipelineWorkInfo)localObject3).getIndicator();
        s.r(localObject4, "it.indicator");
        if ((((PipelineIndicatorInfo)localObject4).getSegmentStatus() == AssetParallelSegmentStatus.AssetReaderStatusWriteFinish) && (((PipelineWorkInfo)localObject3).getIndicator().type == 1))
        {
          i = 1;
          label88:
          if (i == 0) {
            break label208;
          }
          label92:
          localObject2 = (PipelineWorkInfo)localObject1;
          if (localObject2 == null) {
            break label331;
          }
          localObject1 = this.exportWork;
          if (localObject1 != null)
          {
            localObject3 = ((Iterable)localObject1).iterator();
            label123:
            if (!((Iterator)localObject3).hasNext()) {
              break label220;
            }
            localObject1 = ((Iterator)localObject3).next();
            localObject4 = (PipelineWorkInfo)localObject1;
            PipelineIndicatorInfo localPipelineIndicatorInfo = ((PipelineWorkInfo)localObject4).getIndicator();
            s.r(localPipelineIndicatorInfo, "todoWork.indicator");
            if ((localPipelineIndicatorInfo.getSegmentStatus() != AssetParallelSegmentStatus.AssetParallelStatusPrepared) || (((PipelineWorkInfo)localObject4).getIndicator().type != 1)) {
              break label215;
            }
            i = 1;
            label186:
            if (i == 0) {
              break label218;
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = (PipelineWorkInfo)localObject1;
        if (localObject1 != null) {
          break label225;
        }
        AppMethodBeat.o(215615);
        return;
        i = 0;
        break label88;
        label208:
        break;
        localObject1 = null;
        break label92;
        label215:
        i = 0;
        break label186;
        label218:
        break label123;
        label220:
        localObject1 = null;
      }
      label225:
      Object localObject3 = new StringBuilder("try reuse Work from:");
      Object localObject4 = ((PipelineWorkInfo)localObject2).getIndicator();
      s.r(localObject4, "reuseWork.indicator");
      localObject3 = ((StringBuilder)localObject3).append(((PipelineIndicatorInfo)localObject4).getIndex()).append(" to:");
      localObject4 = ((PipelineWorkInfo)localObject1).getIndicator();
      s.r(localObject4, "work.indicator");
      Logger.i("ParallelExportController", ((PipelineIndicatorInfo)localObject4).getIndex());
      ((PipelineWorkInfo)localObject2).reuseWork((PipelineWorkInfo)localObject1);
      if (paramb != null)
      {
        paramb.invoke(localObject2);
        AppMethodBeat.o(215615);
        return;
      }
      AppMethodBeat.o(215615);
      return;
    }
    label331:
    AppMethodBeat.o(215615);
  }
  
  private final void setupWorkInfo(ArrayList<PipelineWorkInfo> paramArrayList)
  {
    AppMethodBeat.i(215598);
    this.exportWork = paramArrayList;
    Object localObject = this.exportWork;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (((PipelineWorkInfo)localObject).type == 2)
        {
          i = 1;
          label62:
          if (i == 0) {
            break label177;
          }
          label66:
          localObject = (PipelineWorkInfo)localObject;
          label71:
          if (localObject == null) {
            break label189;
          }
          i = 1;
          label77:
          if (i == 0) {
            break label194;
          }
        }
      }
    }
    label177:
    label189:
    label194:
    for (int i = 1;; i = 0)
    {
      Logger.i("ParallelExportController", "exportWork video count:" + (paramArrayList.size() - i) + " audio count:" + i);
      paramArrayList = ((Iterable)paramArrayList).iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (PipelineWorkInfo)paramArrayList.next();
        ((Map)this.performanceMap).put(localObject, new ParallelExportAnalyse((PipelineWorkInfo)localObject));
      }
      i = 0;
      break label62;
      break;
      localObject = null;
      break label66;
      localObject = null;
      break label71;
      i = 0;
      break label77;
    }
    AppMethodBeat.o(215598);
  }
  
  public final boolean allSuccess()
  {
    AppMethodBeat.i(215717);
    Object localObject = this.exportWork;
    int i;
    if (localObject != null)
    {
      Iterator localIterator = ((Iterable)localObject).iterator();
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        PipelineIndicatorInfo localPipelineIndicatorInfo = ((PipelineWorkInfo)localObject).getIndicator();
        s.r(localPipelineIndicatorInfo, "it.indicator");
        if (localPipelineIndicatorInfo.getSegmentStatus() != AssetParallelSegmentStatus.AssetReaderStatusWriteFinish)
        {
          i = 1;
          label70:
          if (i == 0) {
            break label94;
          }
        }
      }
    }
    label74:
    for (localObject = (PipelineWorkInfo)localObject;; localObject = null)
    {
      if (localObject != null) {
        break label106;
      }
      AppMethodBeat.o(215717);
      return true;
      i = 0;
      break label70;
      label94:
      break;
      localObject = null;
      break label74;
    }
    label106:
    AppMethodBeat.o(215717);
    return false;
  }
  
  public final boolean allWorkFinish()
  {
    AppMethodBeat.i(215710);
    Object localObject1 = this.exportWork;
    int i;
    if (localObject1 != null)
    {
      Iterator localIterator = ((Iterable)localObject1).iterator();
      if (localIterator.hasNext())
      {
        localObject1 = localIterator.next();
        Object localObject2 = (PipelineWorkInfo)localObject1;
        PipelineIndicatorInfo localPipelineIndicatorInfo = ((PipelineWorkInfo)localObject2).getIndicator();
        s.r(localPipelineIndicatorInfo, "it.indicator");
        if (localPipelineIndicatorInfo.getSegmentStatus() == AssetParallelSegmentStatus.AssetReaderStatusWriteFinish)
        {
          localObject2 = ((PipelineWorkInfo)localObject2).getIndicator();
          s.r(localObject2, "it.indicator");
          if (((PipelineIndicatorInfo)localObject2).getSegmentStatus() == AssetParallelSegmentStatus.AssetParallelStatusFailed) {}
        }
        else
        {
          i = 1;
          label99:
          if (i == 0) {
            break label123;
          }
        }
      }
    }
    label103:
    for (localObject1 = (PipelineWorkInfo)localObject1;; localObject1 = null)
    {
      if (localObject1 != null) {
        break label135;
      }
      AppMethodBeat.o(215710);
      return true;
      i = 0;
      break label99;
      label123:
      break;
      localObject1 = null;
      break label103;
    }
    label135:
    AppMethodBeat.o(215710);
    return false;
  }
  
  public final void analyseAppendSampleBuffer(PipelineWorkInfo paramPipelineWorkInfo, CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215668);
    s.t(paramPipelineWorkInfo, "info");
    s.t(paramCMSampleBuffer, "buffer");
    paramPipelineWorkInfo = (ParallelExportAnalyse)this.performanceMap.get(paramPipelineWorkInfo);
    if (paramPipelineWorkInfo != null)
    {
      paramPipelineWorkInfo.analyseAppendSampleBuffer(paramCMSampleBuffer);
      AppMethodBeat.o(215668);
      return;
    }
    AppMethodBeat.o(215668);
  }
  
  public final void analyseGetSampleBuffer(PipelineWorkInfo paramPipelineWorkInfo, CMSampleBuffer paramCMSampleBuffer)
  {
    AppMethodBeat.i(215660);
    s.t(paramPipelineWorkInfo, "info");
    s.t(paramCMSampleBuffer, "buffer");
    paramPipelineWorkInfo = (ParallelExportAnalyse)this.performanceMap.get(paramPipelineWorkInfo);
    if (paramPipelineWorkInfo != null) {
      paramPipelineWorkInfo.analyseGetSampleBuffer(paramCMSampleBuffer);
    }
    this.totalFrame += 1;
    this.currentFrameRate += 1;
    if (System.currentTimeMillis() - this.lastTimestampMs >= 3000L)
    {
      this.lastTimestampMs = System.currentTimeMillis();
      long l = this.totalFrame * 1000 / (this.lastTimestampMs - this.startTimeMs);
      if ((currentFrameRate() - this.lastFrameRate >= 10) && (!this.hardwareLimit)) {
        tryStartOneMoreWork();
      }
      Logger.i("ParallelExportController", "current work size:" + currentRunSize() + " frameRate:" + l + " currentRate:" + currentFrameRate() + " lastFrameRate:" + this.lastFrameRate);
      this.lastFrameRate = k.qu(currentFrameRate(), this.lastFrameRate);
      this.currentFrameRate = 0;
    }
    this.maxParallelCount = k.qu(this.maxParallelCount, currentRunSize());
    AppMethodBeat.o(215660);
  }
  
  public final boolean canWorkReuse()
  {
    return false;
  }
  
  public final int currentRunSize()
  {
    AppMethodBeat.i(215700);
    Object localObject1 = this.exportWork;
    if (localObject1 != null)
    {
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      label120:
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        PipelineWorkInfo localPipelineWorkInfo = (PipelineWorkInfo)localObject3;
        PipelineIndicatorInfo localPipelineIndicatorInfo = localPipelineWorkInfo.getIndicator();
        s.r(localPipelineIndicatorInfo, "it.indicator");
        if ((localPipelineIndicatorInfo.getSegmentStatus() == AssetParallelSegmentStatus.AssetParallelStatusStarted) && (localPipelineWorkInfo.getIndicator().type == 1)) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label120;
          }
          ((Collection)localObject1).add(localObject3);
          break;
        }
      }
      int i = ((List)localObject1).size();
      AppMethodBeat.o(215700);
      return i;
    }
    AppMethodBeat.o(215700);
    return 0;
  }
  
  public final int getMaxParallelCount()
  {
    return this.maxParallelCount;
  }
  
  public final void handleWorkFinish(final PipelineWorkInfo paramPipelineWorkInfo, Runnable paramRunnable)
  {
    AppMethodBeat.i(215689);
    s.t(paramPipelineWorkInfo, "info");
    s.t(paramRunnable, "callback");
    if (hasPreparedWork())
    {
      if (canWorkReuse())
      {
        reuseWork(this.startWork);
        AppMethodBeat.o(215689);
        return;
      }
      paramRunnable = this.releaseWork;
      if (paramRunnable != null)
      {
        paramRunnable.invoke(paramPipelineWorkInfo, new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(215578);
            this.this$0.tryStartOneMoreWork();
            AppMethodBeat.o(215578);
          }
        }, Boolean.FALSE);
        AppMethodBeat.o(215689);
        return;
      }
      AppMethodBeat.o(215689);
      return;
    }
    q localq = this.releaseWork;
    if (localq != null)
    {
      localq.invoke(paramPipelineWorkInfo, paramRunnable, Boolean.FALSE);
      AppMethodBeat.o(215689);
      return;
    }
    AppMethodBeat.o(215689);
  }
  
  public final void markHardwareLimit(PipelineIndicatorInfo paramPipelineIndicatorInfo)
  {
    AppMethodBeat.i(215727);
    Logger.i("ParallelExportController", "markHardwareLimit:".concat(String.valueOf(paramPipelineIndicatorInfo)));
    this.hardwareLimit = true;
    AppMethodBeat.o(215727);
  }
  
  public final void registerFunction(b<? super PipelineWorkInfo, ah> paramb, q<? super PipelineWorkInfo, ? super Runnable, ? super Boolean, ah> paramq)
  {
    this.startWork = paramb;
    this.releaseWork = paramq;
  }
  
  public final void setMaxParallelCount(int paramInt)
  {
    this.maxParallelCount = paramInt;
  }
  
  public final void startExport(ArrayList<PipelineWorkInfo> paramArrayList)
  {
    AppMethodBeat.i(215675);
    s.t(paramArrayList, "info");
    setupWorkInfo(paramArrayList);
    this.lastTimestampMs = System.currentTimeMillis();
    this.startTimeMs = this.lastTimestampMs;
    b localb = this.startWork;
    int i;
    if (localb != null)
    {
      paramArrayList = this.exportWork;
      if (paramArrayList == null) {
        break label163;
      }
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      if (!localIterator.hasNext()) {
        break label158;
      }
      paramArrayList = localIterator.next();
      PipelineWorkInfo localPipelineWorkInfo = (PipelineWorkInfo)paramArrayList;
      PipelineIndicatorInfo localPipelineIndicatorInfo = localPipelineWorkInfo.getIndicator();
      s.r(localPipelineIndicatorInfo, "it.indicator");
      if ((localPipelineIndicatorInfo.getSegmentStatus() != AssetParallelSegmentStatus.AssetParallelStatusPrepared) || (localPipelineWorkInfo.getIndicator().type != 2)) {
        break label153;
      }
      i = 1;
      label125:
      if (i == 0) {
        break label156;
      }
    }
    label129:
    label153:
    label156:
    label158:
    label163:
    for (paramArrayList = (PipelineWorkInfo)paramArrayList;; paramArrayList = null)
    {
      localb.invoke(paramArrayList);
      tryStartOneMoreWork();
      AppMethodBeat.o(215675);
      return;
      i = 0;
      break label125;
      break;
      paramArrayList = null;
      break label129;
    }
  }
  
  /* Error */
  public final void tryStartOneMoreWork()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 394
    //   5: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: ldc 84
    //   10: ldc_w 396
    //   13: iconst_1
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_0
    //   20: invokevirtual 330	com/tencent/tav/core/parallel/control/ParallelExportController:currentRunSize	()I
    //   23: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   26: aastore
    //   27: invokestatic 399	com/tencent/tav/decoder/logger/Logger:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   30: aload_0
    //   31: invokevirtual 330	com/tencent/tav/core/parallel/control/ParallelExportController:currentRunSize	()I
    //   34: iconst_5
    //   35: if_icmplt +12 -> 47
    //   38: ldc_w 394
    //   41: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_0
    //   45: monitorexit
    //   46: return
    //   47: aload_0
    //   48: invokespecial 366	com/tencent/tav/core/parallel/control/ParallelExportController:hasPreparedWork	()Z
    //   51: ifeq +11 -> 62
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 370	com/tencent/tav/core/parallel/control/ParallelExportController:startWork	Lkotlin/g/a/b;
    //   59: invokespecial 401	com/tencent/tav/core/parallel/control/ParallelExportController:createNewWork	(Lkotlin/g/a/b;)V
    //   62: ldc_w 394
    //   65: invokestatic 110	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: goto -24 -> 44
    //   71: astore_1
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ParallelExportController
    //   71	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	71	finally
    //   47	62	71	finally
    //   62	68	71	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.parallel.control.ParallelExportController
 * JD-Core Version:    0.7.0.1
 */