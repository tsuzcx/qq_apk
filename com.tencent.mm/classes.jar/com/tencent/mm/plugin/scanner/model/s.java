package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.ls;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager;", "", "()V", "TAG", "", "THREAD_LOOP_TAG", "count", "", "focusEngineNative", "Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;", "isAICrop", "", "isInit", "isUsingAI", "scanPointResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "serverState", "getCropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getPointObjects", "getReportString", "init", "width", "height", "cameraRotation", "usingAI", "initNetSpeed", "", "parseRemoteResult", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "source", "process", "imageData", "", "pixelFormat", "release", "reset", "runTask", "task", "Lcom/tencent/mm/plugin/scanner/model/ScanFocusEngineTask;", "tag", "setConfig", "config", "setServerState", "shouldJump", "Lcom/tencent/mm/plugin/scanner/model/ScanFrameProcessResult;", "minX", "", "minY", "maxX", "maxY", "frameId", "forceJump", "updateScanConfig", "type", "plugin-scan_release"})
public final class s
{
  private static int count;
  private static boolean cqf;
  private static ScanFastFocusEngineNative wZr;
  private static int wZs;
  private static boolean wZt;
  private static boolean wZu;
  private static y wZv;
  public static final s wZw;
  
  static
  {
    AppMethodBeat.i(52213);
    wZw = new s();
    wZr = new ScanFastFocusEngineNative();
    wZs = -1;
    wZv = new y();
    AppMethodBeat.o(52213);
  }
  
  public static final u a(ls paramls, int paramInt)
  {
    AppMethodBeat.i(52205);
    k.h(paramls, "response");
    u localu = new u();
    if (paramls != null)
    {
      localu.dac = paramls.djr;
      localu.jumpType = paramls.DZK;
      localu.wZA = paramls.DZL;
      localu.wZB = paramls.DZM;
      localu.qYH = paramls.DZN;
      localu.wZC = paramls.DZO;
      localu.sessionId = paramls.DZC;
      localu.wZD = paramls.DZB;
    }
    if (paramls.DZO != null)
    {
      if (paramInt != 1) {
        break label381;
      }
      float f1 = paramls.DZO.relative_minx;
      float f2 = paramls.DZO.relative_miny;
      float f3 = paramls.DZO.relative_maxx;
      float f4 = paramls.DZO.relative_maxy;
      paramInt = paramls.DZB;
      boolean bool = paramls.DZP;
      if (!cqf) {
        break label376;
      }
      ac.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo shouldJump minX: %f, minY: %f, maxX: %f, maxY: %f, frameId: %d, forceJump: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      paramls = wZr.shouldJump(f1, f2, f3, f4, paramInt, bool);
      if (paramls != null)
      {
        localu.wZz = paramls.shouldJump;
        localu.centerX = ((paramls.minX + paramls.maxX) / 2.0F);
        f1 = paramls.minY;
        localu.centerY = ((paramls.maxY + f1) / 2.0F);
      }
    }
    for (;;)
    {
      localu.centerX = Math.max(0.0F, localu.centerX);
      localu.centerX = Math.min(1.0F, localu.centerX);
      localu.centerY = Math.max(0.0F, localu.centerY);
      localu.centerY = Math.min(1.0F, localu.centerY);
      ac.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo parseRemoteResult centerX: %f, centerY: %f", new Object[] { Float.valueOf(localu.centerX), Float.valueOf(localu.centerY) });
      AppMethodBeat.o(52205);
      return localu;
      label376:
      paramls = null;
      break;
      label381:
      if (paramInt == 2)
      {
        localu.wZz = true;
        localu.centerX = ((paramls.DZO.relative_minx + paramls.DZO.relative_maxx) / 2.0F);
        localu.centerY = ((paramls.DZO.relative_miny + paramls.DZO.relative_maxy) / 2.0F);
      }
    }
  }
  
  public static final void a(t paramt)
  {
    AppMethodBeat.i(52212);
    k.h(paramt, "task");
    count += 1;
    ac.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo runTask %d", new Object[] { Integer.valueOf(count) });
    h.JZN.f((Runnable)paramt, "AiScanImageDecodeQueue_decode_task");
    AppMethodBeat.o(52212);
  }
  
  public static final void a(t paramt, String paramString)
  {
    AppMethodBeat.i(161055);
    k.h(paramt, "task");
    k.h(paramString, "tag");
    h.JZN.f((Runnable)paramt, paramString);
    AppMethodBeat.o(161055);
  }
  
  public static final int d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(199584);
    ac.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine isInit: %b, width: %d, height: %d, cameraRotation: %d, useAI: %b", new Object[] { Boolean.valueOf(cqf), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
    if (cqf)
    {
      ac.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine has inited and ignore");
      AppMethodBeat.o(199584);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    cqf = true;
    Object localObject1 = q.wZn;
    localObject1 = ai.getContext();
    k.g(localObject1, "MMApplicationContext.getContext()");
    k.h(localObject1, "context");
    localObject1 = q.cm((Context)localObject1) + "center_det.bin";
    Object localObject2 = q.wZn;
    localObject2 = ai.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    k.h(localObject2, "context");
    localObject2 = q.cm((Context)localObject2) + "center_det.param";
    paramInt2 = wZr.nativeInit(paramInt1, paramInt2, 0, 0, paramInt3, (String)localObject1, (String)localObject2, paramBoolean);
    if (!com.tencent.mm.vfs.i.eA((String)localObject1)) {
      ac.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerBin not exist");
    }
    if (!com.tencent.mm.vfs.i.eA((String)localObject2)) {
      ac.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerParam not exist");
    }
    wZt = wZr.isUsingAI();
    wZu = wZr.isAICrop();
    long l2 = System.currentTimeMillis();
    ac.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine result: %d, usingAI: %b, aiCrop: %b, init cost: %d", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(wZt), Boolean.valueOf(wZu), Long.valueOf(l2 - l1) });
    if (paramInt2 != 0)
    {
      AppMethodBeat.o(199584);
      return paramInt2;
    }
    localObject1 = g.agi();
    k.g(localObject1, "MMKernel.getNetSceneQueue()");
    if (((com.tencent.mm.ak.q)localObject1).aBK() != 6)
    {
      localObject1 = g.agi();
      k.g(localObject1, "MMKernel.getNetSceneQueue()");
      if (((com.tencent.mm.ak.q)localObject1).aBK() != 4) {}
    }
    else if (ax.getNetType(ai.getContext()) == 0)
    {
      paramInt1 = 0;
    }
    for (;;)
    {
      ac.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initNetSpeed: %d", new Object[] { Integer.valueOf(paramInt1) });
      wZr.setNetSpeed(paramInt1);
      ac.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig type: %d", new Object[] { Integer.valueOf(2) });
      r.a((r.a)new s.c());
      AppMethodBeat.o(199584);
      return paramInt2;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
    }
  }
  
  public static final GoodsObject dzA()
  {
    AppMethodBeat.i(52206);
    if (cqf)
    {
      ac.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getCropObject %f, %f, %f, %f", new Object[] { Float.valueOf(wZr.cropObject.relative_minx), Float.valueOf(wZr.cropObject.relative_maxx), Float.valueOf(wZr.cropObject.relative_miny), Float.valueOf(wZr.cropObject.relative_maxy) });
      GoodsObject localGoodsObject = wZr.cropObject;
      AppMethodBeat.o(52206);
      return localGoodsObject;
    }
    AppMethodBeat.o(52206);
    return null;
  }
  
  public static final void dzB()
  {
    AppMethodBeat.i(52209);
    if (wZs != 0) {
      a((t)new b());
    }
    AppMethodBeat.o(52209);
  }
  
  public static final y dzz()
  {
    Object localObject = null;
    AppMethodBeat.i(52204);
    if (cqf)
    {
      wZv.points = wZr.getPointObjects();
      wZv.pointCount = wZr.pointCount;
      int i = wZv.pointCount;
      int j = wZv.hashCode();
      ScanPoint[] arrayOfScanPoint = wZv.points;
      if (arrayOfScanPoint != null) {
        localObject = Integer.valueOf(arrayOfScanPoint.hashCode());
      }
      ac.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getPointObjects pointCount: %d, hashCode: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject });
      localObject = wZv;
      AppMethodBeat.o(52204);
      return localObject;
    }
    AppMethodBeat.o(52204);
    return null;
  }
  
  public static final String getReportString()
  {
    AppMethodBeat.i(52211);
    if (cqf)
    {
      String str = wZr.getReportString();
      AppMethodBeat.o(52211);
      return str;
    }
    ac.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo getReportString is not init");
    AppMethodBeat.o(52211);
    return null;
  }
  
  public static final boolean isAICrop()
  {
    return wZu;
  }
  
  public static final boolean isUsingAI()
  {
    return wZt;
  }
  
  public static final ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52203);
    k.h(paramArrayOfByte, "imageData");
    if (cqf)
    {
      long l1 = System.currentTimeMillis();
      wZr.resetStatus();
      ScanFastFocusEngineNative localScanFastFocusEngineNative = wZr.process(paramArrayOfByte, paramInt1, paramInt2);
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
        ac.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo process result: %s, cost: %d, width: %d, height: %d, bestImageData: %s", new Object[] { paramArrayOfByte, Long.valueOf(l2 - l1), localInteger1, localInteger2, localObject1 });
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
    if (cqf)
    {
      ac.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo release");
      wZr.nativeRelease();
      cqf = false;
    }
    AppMethodBeat.o(52208);
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(52207);
    if (cqf)
    {
      ac.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo focusEngineNative reset");
      wZr.reset();
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
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class a
    implements t
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(52198);
      s locals = s.wZw;
      if (s.dzD())
      {
        locals = s.wZw;
        s.dzC().setConfig(this.wZx);
      }
      AppMethodBeat.o(52198);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements t
  {
    public final void run()
    {
      AppMethodBeat.i(52199);
      ac.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo setServerState: %d", new Object[] { Integer.valueOf(this.wZy) });
      s locals = s.wZw;
      s.MQ(this.wZy);
      locals = s.wZw;
      s.dzC().setServerState(this.wZy);
      AppMethodBeat.o(52199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.s
 * JD-Core Version:    0.7.0.1
 */