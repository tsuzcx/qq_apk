package com.tencent.mm.plugin.voip.d;

import android.os.Debug;
import android.os.Debug.MemoryInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.autogen.mmdata.rpt.qu;
import com.tencent.mm.plugin.voip.f.h;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bg;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/report/VoipProfilerReportUtil;", "", "()V", "cameraFps", "", "getCameraFps", "()I", "setCameraFps", "(I)V", "cameraResolution", "", "getCameraResolution", "()Ljava/lang/String;", "setCameraResolution", "(Ljava/lang/String;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "encodeCost", "getEncodeCost", "setEncodeCost", "gpuMemoryEGL", "", "getGpuMemoryEGL", "()J", "setGpuMemoryEGL", "(J)V", "gpuMemoryGFX", "getGpuMemoryGFX", "setGpuMemoryGFX", "gpuMemoryGL", "getGpuMemoryGL", "setGpuMemoryGL", "isUseVoipBeauty", "setUseVoipBeauty", "localRenderCost", "getLocalRenderCost", "setLocalRenderCost", "localRenderFps", "getLocalRenderFps", "setLocalRenderFps", "mRoomId", "getMRoomId", "setMRoomId", "mRoomKey", "getMRoomKey", "setMRoomKey", "mUsername", "getMUsername", "setMUsername", "monitor", "Lcom/tencent/matrix/batterycanary/monitor/feature/CompositeMonitors;", "getMonitor", "()Lcom/tencent/matrix/batterycanary/monitor/feature/CompositeMonitors;", "monitor$delegate", "Lkotlin/Lazy;", "openCameraCost", "getOpenCameraCost", "setOpenCameraCost", "pixelReadCost", "getPixelReadCost", "setPixelReadCost", "remoteRenderHardCost", "getRemoteRenderHardCost", "setRemoteRenderHardCost", "remoteRenderHardFps", "getRemoteRenderHardFps", "setRemoteRenderHardFps", "remoteRenderSoftCost", "getRemoteRenderSoftCost", "setRemoteRenderSoftCost", "remoteRenderSoftFps", "getRemoteRenderSoftFps", "setRemoteRenderSoftFps", "dealCallingParam", "", "roomId", "roomKey", "toUsername", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)V", "doReportVoIPProfilerInfo", "getPss", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "reportCameraInfo", "startCost", "resolution", "fps", "reportGpuInfo", "gl", "egl", "gfx", "reportPixelReadCost", "cost", "transVoipInfo", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  static int JMX;
  public static final f UGZ;
  static long UGt;
  static int UHa;
  static String UHb;
  static long UHc;
  static long UHd;
  static long UHe;
  static long UHf;
  static int UHg;
  static int UHh;
  static int UHi;
  static int UHj;
  static int UHk;
  static int UHl;
  static int UHm;
  static int UHn;
  static int UHo;
  private static final kotlin.j UHp;
  private static aq coroutineScope;
  static String sWX;
  
  static
  {
    AppMethodBeat.i(292884);
    UGZ = new f();
    sWX = "";
    UHb = "";
    coroutineScope = ar.d((kotlin.d.f)bg.kCi());
    UHp = kotlin.k.cm((kotlin.g.a.a)f.c.UHr);
    AppMethodBeat.o(292884);
  }
  
  public static void a(Integer paramInteger, Long paramLong, String paramString)
  {
    AppMethodBeat.i(292861);
    if (paramInteger == null)
    {
      AppMethodBeat.o(292861);
      return;
    }
    JMX = paramInteger.intValue();
    if (paramLong == null)
    {
      AppMethodBeat.o(292861);
      return;
    }
    UGt = paramLong.longValue();
    if (paramString == null)
    {
      AppMethodBeat.o(292861);
      return;
    }
    sWX = paramString;
    paramInteger = iaa();
    if (paramInteger != null) {
      paramInteger.start();
    }
    AppMethodBeat.o(292861);
  }
  
  public static void aqH(int paramInt)
  {
    UHg = paramInt;
  }
  
  public static void aqI(int paramInt)
  {
    UHh = paramInt;
  }
  
  public static void aqJ(int paramInt)
  {
    UHi = paramInt;
  }
  
  public static void aqK(int paramInt)
  {
    UHj = paramInt;
  }
  
  public static void aqL(int paramInt)
  {
    UHk = paramInt;
  }
  
  public static void aqM(int paramInt)
  {
    UHl = paramInt;
  }
  
  public static void aqN(int paramInt)
  {
    UHm = paramInt;
  }
  
  public static void aqO(int paramInt)
  {
    UHn = paramInt;
  }
  
  public static void aqP(int paramInt)
  {
    UHo = paramInt;
  }
  
  public static void f(long paramLong, String paramString, int paramInt)
  {
    AppMethodBeat.i(292869);
    s.u(paramString, "resolution");
    UHa = paramInt;
    UHb = paramString;
    UHc = paramLong;
    AppMethodBeat.o(292869);
  }
  
  public static int getEncodeCost()
  {
    return UHn;
  }
  
  public static int hZT()
  {
    return UHh;
  }
  
  public static int hZU()
  {
    return UHi;
  }
  
  public static int hZV()
  {
    return UHj;
  }
  
  public static int hZW()
  {
    return UHk;
  }
  
  public static int hZX()
  {
    return UHl;
  }
  
  public static int hZY()
  {
    return UHm;
  }
  
  public static int hZZ()
  {
    return UHo;
  }
  
  static com.tencent.matrix.a.a.a.f iaa()
  {
    AppMethodBeat.i(292860);
    com.tencent.matrix.a.a.a.f localf = (com.tencent.matrix.a.a.a.f)UHp.getValue();
    AppMethodBeat.o(292860);
    return localf;
  }
  
  public static void iab()
  {
    int j = 1;
    AppMethodBeat.i(292872);
    qu localqu = new qu();
    Object localObject = new i();
    i locali = new i();
    locali.t("roomKey", UGt);
    locali.au("roomId", JMX);
    locali.m("callName", sWX);
    ((i)localObject).m("voipInfo", locali.toString());
    localObject = ((i)localObject).toString();
    s.s(localObject, "json.toString()");
    localqu.jtx = localqu.F("voipInfo", n.m((String)localObject, ",", ";", false), true);
    localqu.jtD = UHa;
    localqu.jtE = localqu.F("cameraResolution", UHb, true);
    localqu.jtC = UHc;
    localqu.jty = UHd;
    localqu.jtz = UHe;
    localqu.jtA = UHf;
    localqu.jtF = UHg;
    localqu.jtG = UHi;
    localqu.jtH = UHh;
    localqu.jtK = UHm;
    localqu.jtL = UHl;
    localqu.jtJ = UHj;
    localqu.jtI = UHk;
    localqu.jtN = UHn;
    int i;
    if (h.ibI())
    {
      i = 1;
      localqu.jtM = i;
      localqu.jtQ = UHo;
      if (!h.ibI()) {
        break label351;
      }
      i = j;
      label277:
      localqu.jtP = i;
      localObject = iaa();
      if (localObject != null) {
        ((com.tencent.matrix.a.a.a.f)localObject).finish();
      }
      localObject = iaa();
      if (localObject != null) {
        break label372;
      }
    }
    label351:
    label372:
    for (long l = 0L;; l = ((com.tencent.matrix.a.a.a.f)localObject).awZ())
    {
      localqu.jtR = l;
      kotlinx.coroutines.j.a(coroutineScope, null, null, (m)new a(localqu, null), 3);
      AppMethodBeat.o(292872);
      return;
      i = 0;
      break;
      localObject = h.ULL;
      if (h.ibC())
      {
        i = 2;
        break label277;
      }
      i = 0;
      break label277;
    }
  }
  
  public static void r(long paramLong1, long paramLong2, long paramLong3)
  {
    if (paramLong1 > 0L)
    {
      UHd = paramLong1;
      if (paramLong2 <= 0L) {
        break label38;
      }
      label16:
      UHe = paramLong2;
      if (paramLong3 <= 0L) {
        break label43;
      }
    }
    for (;;)
    {
      UHf = paramLong3;
      return;
      paramLong1 = 0L;
      break;
      label38:
      paramLong2 = 0L;
      break label16;
      label43:
      paramLong3 = 0L;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    Object L$0;
    int label;
    
    a(qu paramqu, d<? super a> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(292822);
      paramObject = (d)new a(this.UHq, paramd);
      AppMethodBeat.o(292822);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(292817);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      qu localqu;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(292817);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        localqu = this.UHq;
        paramObject = f.UGZ;
        paramObject = (d)this;
        this.L$0 = localqu;
        this.label = 1;
        Object localObject = f.aq(paramObject);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(292817);
          return locala;
        }
        break;
      case 1: 
        localqu = (qu)this.L$0;
        ResultKt.throwOnFailure(paramObject);
      }
      localqu.jtB = ((Number)paramObject).longValue();
      this.UHq.bMH();
      paramObject = f.UGZ;
      paramObject = a.UFW;
      a.release();
      paramObject = g.UHs;
      g.release();
      paramObject = b.UFY;
      b.release();
      paramObject = e.UGU;
      e.release();
      paramObject = f.iaa();
      if (paramObject != null) {
        paramObject.clear();
      }
      f.JMX = 0;
      f.UGt = 0L;
      f.sWX = "";
      f.UHa = 0;
      f.UHb = "";
      f.UHc = 0L;
      f.UHd = 0L;
      f.UHe = 0L;
      f.UHf = 0L;
      f.UHg = 0;
      f.UHh = 0;
      f.UHi = 0;
      f.UHj = 0;
      f.UHk = 0;
      f.UHl = 0;
      f.UHm = 0;
      f.UHn = 0;
      f.UHo = 0;
      paramObject = ah.aiuX;
      AppMethodBeat.o(292817);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<aq, d<? super Long>, Object>
  {
    int label;
    
    b(d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(292828);
      paramObject = (d)new b(paramd);
      AppMethodBeat.o(292828);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(292820);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(292820);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = new Debug.MemoryInfo();
      Debug.getMemoryInfo(paramObject);
      paramObject = kotlin.d.b.a.b.BF(paramObject.getTotalPss());
      AppMethodBeat.o(292820);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.d.f
 * JD-Core Version:    0.7.0.1
 */