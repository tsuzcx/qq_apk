package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager;", "", "()V", "TAG", "", "THREAD_LOOP_TAG", "count", "", "focusEngineNative", "Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;", "isAICrop", "", "isInit", "isUsingAI", "scanPointResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "serverState", "getCropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getPointObjects", "getReportString", "init", "width", "height", "cameraRotation", "initNetSpeed", "", "parseRemoteResult", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "source", "process", "imageData", "", "pixelFormat", "release", "reset", "runTask", "task", "Lcom/tencent/mm/plugin/scanner/model/ScanFocusEngineTask;", "tag", "setConfig", "config", "setServerState", "shouldJump", "Lcom/tencent/mm/plugin/scanner/model/ScanFrameProcessResult;", "minX", "", "minY", "maxX", "maxY", "frameId", "forceJump", "updateScanConfig", "type", "plugin-scan_release"})
public final class s
{
  private static int count;
  private static boolean csX;
  private static ScanFastFocusEngineNative vOV;
  private static int vOW;
  private static boolean vOX;
  private static boolean vOY;
  private static w vOZ;
  public static final s vPa;
  
  static
  {
    AppMethodBeat.i(52213);
    vPa = new s();
    vOV = new ScanFastFocusEngineNative();
    vOW = -1;
    vOZ = new w();
    AppMethodBeat.o(52213);
  }
  
  public static final u a(ll paramll, int paramInt)
  {
    AppMethodBeat.i(52205);
    k.h(paramll, "response");
    u localu = new u();
    if (paramll != null)
    {
      localu.dcE = paramll.dlJ;
      localu.jumpType = paramll.CHi;
      localu.vPe = paramll.CHj;
      localu.vPf = paramll.CHk;
      localu.qpB = paramll.CHl;
      localu.vPg = paramll.CHm;
      localu.sessionId = paramll.CHb;
      localu.vPh = paramll.CHa;
    }
    if (paramll.CHm != null)
    {
      if (paramInt != 1) {
        break label381;
      }
      float f1 = paramll.CHm.relative_minx;
      float f2 = paramll.CHm.relative_miny;
      float f3 = paramll.CHm.relative_maxx;
      float f4 = paramll.CHm.relative_maxy;
      paramInt = paramll.CHa;
      boolean bool = paramll.CHn;
      if (!csX) {
        break label376;
      }
      ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo shouldJump minX: %f, minY: %f, maxX: %f, maxY: %f, frameId: %d, forceJump: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      paramll = vOV.shouldJump(f1, f2, f3, f4, paramInt, bool);
      if (paramll != null)
      {
        localu.vPd = paramll.shouldJump;
        localu.centerX = ((paramll.minX + paramll.maxX) / 2.0F);
        f1 = paramll.minY;
        localu.centerY = ((paramll.maxY + f1) / 2.0F);
      }
    }
    for (;;)
    {
      localu.centerX = Math.max(0.0F, localu.centerX);
      localu.centerX = Math.min(1.0F, localu.centerX);
      localu.centerY = Math.max(0.0F, localu.centerY);
      localu.centerY = Math.min(1.0F, localu.centerY);
      ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo parseRemoteResult centerX: %f, centerY: %f", new Object[] { Float.valueOf(localu.centerX), Float.valueOf(localu.centerY) });
      AppMethodBeat.o(52205);
      return localu;
      label376:
      paramll = null;
      break;
      label381:
      if (paramInt == 2)
      {
        localu.vPd = true;
        localu.centerX = ((paramll.CHm.relative_minx + paramll.CHm.relative_maxx) / 2.0F);
        localu.centerY = ((paramll.CHm.relative_miny + paramll.CHm.relative_maxy) / 2.0F);
      }
    }
  }
  
  public static final void a(t paramt)
  {
    AppMethodBeat.i(52212);
    k.h(paramt, "task");
    count += 1;
    ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo runTask %d", new Object[] { Integer.valueOf(count) });
    h.Iye.f((Runnable)paramt, "AiScanImageDecodeQueue_decode_task");
    AppMethodBeat.o(52212);
  }
  
  public static final void a(t paramt, String paramString)
  {
    AppMethodBeat.i(161055);
    k.h(paramt, "task");
    k.h(paramString, "tag");
    h.Iye.f((Runnable)paramt, paramString);
    AppMethodBeat.o(161055);
  }
  
  public static final int ap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(52202);
    ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine isInit: %b, width: %d, height: %d, cameraRotation: %d", new Object[] { Boolean.valueOf(csX), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (csX)
    {
      ad.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine has inited and ignore");
      AppMethodBeat.o(52202);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    csX = true;
    Object localObject1 = q.vOR;
    localObject1 = aj.getContext();
    k.g(localObject1, "MMApplicationContext.getContext()");
    k.h(localObject1, "context");
    localObject1 = q.cg((Context)localObject1) + "center_det.bin";
    Object localObject2 = q.vOR;
    localObject2 = aj.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    k.h(localObject2, "context");
    localObject2 = q.cg((Context)localObject2) + "center_det.param";
    paramInt2 = vOV.nativeInit(paramInt1, paramInt2, 0, 0, paramInt3, (String)localObject1, (String)localObject2);
    if (!com.tencent.mm.vfs.i.eK((String)localObject1)) {
      ad.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerBin not exist");
    }
    if (!com.tencent.mm.vfs.i.eK((String)localObject2)) {
      ad.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerParam not exist");
    }
    vOX = vOV.isUsingAI();
    vOY = vOV.isAICrop();
    long l2 = System.currentTimeMillis();
    ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine result: %d, usingAI: %b, aiCrop: %b, init cost: %d", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(vOX), Boolean.valueOf(vOY), Long.valueOf(l2 - l1) });
    if (paramInt2 != 0)
    {
      AppMethodBeat.o(52202);
      return paramInt2;
    }
    localObject1 = g.aeS();
    k.g(localObject1, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.al.q)localObject1).auR() != 6)
    {
      localObject1 = g.aeS();
      k.g(localObject1, "MMKernel.getNetSceneQueue()");
      if (((com.tencent.mm.al.q)localObject1).auR() != 4) {}
    }
    else if (ay.getNetType(aj.getContext()) == 0)
    {
      paramInt1 = 0;
    }
    for (;;)
    {
      ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initNetSpeed: %d", new Object[] { Integer.valueOf(paramInt1) });
      vOV.setNetSpeed(paramInt1);
      ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig type: %d", new Object[] { Integer.valueOf(2) });
      r.a((r.a)new s.c());
      AppMethodBeat.o(52202);
      return paramInt2;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
    }
  }
  
  public static final w dlx()
  {
    Object localObject = null;
    AppMethodBeat.i(52204);
    if (csX)
    {
      vOZ.points = vOV.getPointObjects();
      vOZ.pointCount = vOV.pointCount;
      int i = vOZ.pointCount;
      int j = vOZ.hashCode();
      ScanPoint[] arrayOfScanPoint = vOZ.points;
      if (arrayOfScanPoint != null) {
        localObject = Integer.valueOf(arrayOfScanPoint.hashCode());
      }
      ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getPointObjects pointCount: %d, hashCode: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject });
      localObject = vOZ;
      AppMethodBeat.o(52204);
      return localObject;
    }
    AppMethodBeat.o(52204);
    return null;
  }
  
  public static final GoodsObject dly()
  {
    AppMethodBeat.i(52206);
    if (csX)
    {
      ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getCropObject %f, %f, %f, %f", new Object[] { Float.valueOf(vOV.cropObject.relative_minx), Float.valueOf(vOV.cropObject.relative_maxx), Float.valueOf(vOV.cropObject.relative_miny), Float.valueOf(vOV.cropObject.relative_maxy) });
      GoodsObject localGoodsObject = vOV.cropObject;
      AppMethodBeat.o(52206);
      return localGoodsObject;
    }
    AppMethodBeat.o(52206);
    return null;
  }
  
  public static final void dlz()
  {
    AppMethodBeat.i(52209);
    if (vOW != 0) {
      a((t)new b());
    }
    AppMethodBeat.o(52209);
  }
  
  public static final String getReportString()
  {
    AppMethodBeat.i(52211);
    if (csX)
    {
      String str = vOV.getReportString();
      AppMethodBeat.o(52211);
      return str;
    }
    ad.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo getReportString is not init");
    AppMethodBeat.o(52211);
    return null;
  }
  
  public static final boolean isAICrop()
  {
    return vOY;
  }
  
  public static final boolean isUsingAI()
  {
    return vOX;
  }
  
  public static final ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52203);
    k.h(paramArrayOfByte, "imageData");
    if (csX)
    {
      long l1 = System.currentTimeMillis();
      vOV.resetStatus();
      ScanFastFocusEngineNative localScanFastFocusEngineNative = vOV.process(paramArrayOfByte, paramInt1, paramInt2);
      long l2 = System.currentTimeMillis();
      Integer localInteger1;
      if (localScanFastFocusEngineNative != null)
      {
        paramArrayOfByte = Integer.valueOf(localScanFastFocusEngineNative.result);
        if (localScanFastFocusEngineNative == null) {
          break label180;
        }
        localInteger1 = Integer.valueOf(localScanFastFocusEngineNative.width);
        label77:
        if (localScanFastFocusEngineNative == null) {
          break label186;
        }
      }
      label180:
      label186:
      for (Integer localInteger2 = Integer.valueOf(localScanFastFocusEngineNative.height);; localInteger2 = null)
      {
        Object localObject1 = localObject2;
        if (localScanFastFocusEngineNative != null)
        {
          byte[] arrayOfByte = localScanFastFocusEngineNative.bestImageData;
          localObject1 = localObject2;
          if (arrayOfByte != null) {
            localObject1 = Integer.valueOf(arrayOfByte.length);
          }
        }
        ad.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo process result: %s, cost: %d, width: %d, height: %d, bestImageData: %s", new Object[] { paramArrayOfByte, Long.valueOf(l2 - l1), localInteger1, localInteger2, localObject1 });
        AppMethodBeat.o(52203);
        return localScanFastFocusEngineNative;
        paramArrayOfByte = null;
        break;
        localInteger1 = null;
        break label77;
      }
    }
    AppMethodBeat.o(52203);
    return null;
  }
  
  public static final void release()
  {
    AppMethodBeat.i(52208);
    if (csX)
    {
      ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo release");
      vOV.nativeRelease();
      csX = false;
    }
    AppMethodBeat.o(52208);
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(52207);
    if (csX)
    {
      ad.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo focusEngineNative reset");
      vOV.reset();
    }
    AppMethodBeat.o(52207);
  }
  
  public static final void setConfig(String paramString)
  {
    AppMethodBeat.i(52210);
    k.h(paramString, "config");
    a((t)new a(paramString));
    AppMethodBeat.o(52210);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class a
    implements t
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(52198);
      s locals = s.vPa;
      if (s.dlB())
      {
        locals = s.vPa;
        s.dlA().setConfig(this.vPb);
      }
      AppMethodBeat.o(52198);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements t
  {
    public final void run()
    {
      AppMethodBeat.i(52199);
      ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo setServerState: %d", new Object[] { Integer.valueOf(this.vPc) });
      s locals = s.vPa;
      s.KP(this.vPc);
      locals = s.vPa;
      s.dlA().setServerState(this.vPc);
      AppMethodBeat.o(52199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s
 * JD-Core Version:    0.7.0.1
 */