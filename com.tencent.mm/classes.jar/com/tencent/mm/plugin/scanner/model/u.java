package com.tencent.mm.plugin.scanner.model;

import android.content.Context;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.GoodsObject;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineManager;", "", "()V", "TAG", "", "THREAD_LOOP_TAG", "count", "", "focusEngineNative", "Lcom/tencent/mm/plugin/scanner/model/ScanFastFocusEngineNative;", "isAICrop", "", "isInit", "isUsingAI", "scanPointResult", "Lcom/tencent/mm/plugin/scanner/model/ScanPointsInfo;", "serverState", "computeImagePHash", "Lcom/tencent/mm/plugin/scanner/model/ScanImagePHashInfo;", "imageData", "", "imageWidth", "imageHeight", "slidedImage", "getCropObject", "Lcom/tencent/mm/protocal/protobuf/GoodsObject;", "getPointObjects", "getReportString", "init", "width", "height", "cameraRotation", "usingAI", "initNetSpeed", "", "parseRemoteResult", "Lcom/tencent/mm/plugin/scanner/model/ScanGoodsRemoteResult;", "response", "Lcom/tencent/mm/protocal/protobuf/BizAiScanImageResponse;", "source", "process", "pixelFormat", "release", "reset", "runTask", "task", "Lcom/tencent/mm/plugin/scanner/model/ScanFocusEngineTask;", "tag", "setConfig", "config", "setServerState", "shouldJump", "Lcom/tencent/mm/plugin/scanner/model/ScanFrameProcessResult;", "minX", "", "minY", "maxX", "maxY", "frameId", "forceJump", "updateScanConfig", "type", "plugin-scan_release"})
public final class u
{
  private static boolean cAX;
  private static int count;
  private static ScanFastFocusEngineNative ynn;
  private static int yno;
  private static boolean ynp;
  private static boolean ynq;
  private static ab ynr;
  public static final u yns;
  
  static
  {
    AppMethodBeat.i(52213);
    yns = new u();
    ynn = new ScanFastFocusEngineNative();
    yno = -1;
    ynr = new ab();
    AppMethodBeat.o(52213);
  }
  
  public static final ScanImagePHashInfo B(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(186291);
    p.h(paramArrayOfByte, "imageData");
    paramArrayOfByte = ynn.computeImagePHash(paramArrayOfByte, paramInt1, paramInt2, false);
    AppMethodBeat.o(186291);
    return paramArrayOfByte;
  }
  
  public static final w a(me paramme, int paramInt)
  {
    AppMethodBeat.i(52205);
    p.h(paramme, "response");
    w localw = new w();
    if (paramme != null)
    {
      localw.dlu = paramme.dve;
      localw.jumpType = paramme.FFk;
      localw.ynw = paramme.FFl;
      localw.ynx = paramme.FFm;
      localw.rJX = paramme.FFn;
      localw.yny = paramme.FFo;
      localw.sessionId = paramme.FFa;
      localw.ynz = paramme.FEZ;
      localw.ynA = paramme.FFq;
    }
    if (paramme.FFo != null)
    {
      if (paramInt != 1) {
        break label391;
      }
      float f1 = paramme.FFo.relative_minx;
      float f2 = paramme.FFo.relative_miny;
      float f3 = paramme.FFo.relative_maxx;
      float f4 = paramme.FFo.relative_maxy;
      paramInt = paramme.FEZ;
      boolean bool = paramme.FFp;
      if (!cAX) {
        break label386;
      }
      ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo shouldJump minX: %f, minY: %f, maxX: %f, maxY: %f, frameId: %d, forceJump: %b", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Integer.valueOf(paramInt), Boolean.valueOf(bool) });
      paramme = ynn.shouldJump(f1, f2, f3, f4, paramInt, bool);
      if (paramme != null)
      {
        localw.ynv = paramme.shouldJump;
        localw.centerX = ((paramme.minX + paramme.maxX) / 2.0F);
        f1 = paramme.minY;
        localw.centerY = ((paramme.maxY + f1) / 2.0F);
      }
    }
    for (;;)
    {
      localw.centerX = Math.max(0.0F, localw.centerX);
      localw.centerX = Math.min(1.0F, localw.centerX);
      localw.centerY = Math.max(0.0F, localw.centerY);
      localw.centerY = Math.min(1.0F, localw.centerY);
      ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo parseRemoteResult centerX: %f, centerY: %f", new Object[] { Float.valueOf(localw.centerX), Float.valueOf(localw.centerY) });
      AppMethodBeat.o(52205);
      return localw;
      label386:
      paramme = null;
      break;
      label391:
      if (paramInt == 2)
      {
        localw.ynv = true;
        localw.centerX = ((paramme.FFo.relative_minx + paramme.FFo.relative_maxx) / 2.0F);
        localw.centerY = ((paramme.FFo.relative_miny + paramme.FFo.relative_maxy) / 2.0F);
      }
    }
  }
  
  public static final void a(v paramv)
  {
    AppMethodBeat.i(52212);
    p.h(paramv, "task");
    count += 1;
    ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo runTask %d", new Object[] { Integer.valueOf(count) });
    h.LTJ.f((Runnable)paramv, "AiScanImageDecodeQueue_decode_task");
    AppMethodBeat.o(52212);
  }
  
  public static final void a(v paramv, String paramString)
  {
    AppMethodBeat.i(161055);
    p.h(paramv, "task");
    p.h(paramString, "tag");
    h.LTJ.f((Runnable)paramv, paramString);
    AppMethodBeat.o(161055);
  }
  
  public static final int d(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(186290);
    ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine isInit: %b, width: %d, height: %d, cameraRotation: %d, useAI: %b", new Object[] { Boolean.valueOf(cAX), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) });
    if (cAX)
    {
      ad.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine has inited and ignore");
      AppMethodBeat.o(186290);
      return 0;
    }
    long l1 = System.currentTimeMillis();
    cAX = true;
    Object localObject1 = s.yni;
    localObject1 = aj.getContext();
    p.g(localObject1, "MMApplicationContext.getContext()");
    p.h(localObject1, "context");
    localObject1 = s.cj((Context)localObject1) + "center_det.bin";
    Object localObject2 = s.yni;
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    p.h(localObject2, "context");
    localObject2 = s.cj((Context)localObject2) + "center_det.param";
    paramInt2 = ynn.nativeInit(paramInt1, paramInt2, 0, 0, paramInt3, (String)localObject1, (String)localObject2, paramBoolean);
    if (!com.tencent.mm.vfs.i.fv((String)localObject1)) {
      ad.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerBin not exist");
    }
    if (!com.tencent.mm.vfs.i.fv((String)localObject2)) {
      ad.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine centerParam not exist");
    }
    ynp = ynn.isUsingAI();
    ynq = ynn.isAICrop();
    long l2 = System.currentTimeMillis();
    ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initFocusEngine result: %d, usingAI: %b, aiCrop: %b, init cost: %d", new Object[] { Integer.valueOf(paramInt2), Boolean.valueOf(ynp), Boolean.valueOf(ynq), Long.valueOf(l2 - l1) });
    if (paramInt2 != 0)
    {
      AppMethodBeat.o(186290);
      return paramInt2;
    }
    localObject1 = g.aiU();
    p.g(localObject1, "MMKernel.getNetSceneQueue()");
    if (((q)localObject1).aEN() != 6)
    {
      localObject1 = g.aiU();
      p.g(localObject1, "MMKernel.getNetSceneQueue()");
      if (((q)localObject1).aEN() != 4) {}
    }
    else if (ay.getNetType(aj.getContext()) == 0)
    {
      paramInt1 = 0;
    }
    for (;;)
    {
      ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo initNetSpeed: %d", new Object[] { Integer.valueOf(paramInt1) });
      ynn.setNetSpeed(paramInt1);
      ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo updateScanConfig type: %d", new Object[] { Integer.valueOf(2) });
      t.a((t.a)new u.c());
      AppMethodBeat.o(186290);
      return paramInt2;
      paramInt1 = 1;
      continue;
      paramInt1 = 1;
    }
  }
  
  public static final ab dKZ()
  {
    Object localObject = null;
    AppMethodBeat.i(52204);
    if (cAX)
    {
      ynr.points = ynn.getPointObjects();
      ynr.pointCount = ynn.pointCount;
      int i = ynr.pointCount;
      int j = ynr.hashCode();
      ScanPoint[] arrayOfScanPoint = ynr.points;
      if (arrayOfScanPoint != null) {
        localObject = Integer.valueOf(arrayOfScanPoint.hashCode());
      }
      ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getPointObjects pointCount: %d, hashCode: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), localObject });
      localObject = ynr;
      AppMethodBeat.o(52204);
      return localObject;
    }
    AppMethodBeat.o(52204);
    return null;
  }
  
  public static final GoodsObject dLa()
  {
    AppMethodBeat.i(52206);
    if (cAX)
    {
      ad.v("MicroMsg.ScanFastFocusEngineManager", "alvinluo getCropObject %f, %f, %f, %f", new Object[] { Float.valueOf(ynn.cropObject.relative_minx), Float.valueOf(ynn.cropObject.relative_maxx), Float.valueOf(ynn.cropObject.relative_miny), Float.valueOf(ynn.cropObject.relative_maxy) });
      GoodsObject localGoodsObject = ynn.cropObject;
      AppMethodBeat.o(52206);
      return localGoodsObject;
    }
    AppMethodBeat.o(52206);
    return null;
  }
  
  public static final void dLb()
  {
    AppMethodBeat.i(52209);
    if (yno != 0) {
      a((v)new b());
    }
    AppMethodBeat.o(52209);
  }
  
  public static final String getReportString()
  {
    AppMethodBeat.i(52211);
    if (cAX)
    {
      String str = ynn.getReportString();
      AppMethodBeat.o(52211);
      return str;
    }
    ad.w("MicroMsg.ScanFastFocusEngineManager", "alvinluo getReportString is not init");
    AppMethodBeat.o(52211);
    return null;
  }
  
  public static final boolean isAICrop()
  {
    return ynq;
  }
  
  public static final boolean isUsingAI()
  {
    return ynp;
  }
  
  public static final ScanFastFocusEngineNative process(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52203);
    p.h(paramArrayOfByte, "imageData");
    if (cAX)
    {
      long l1 = System.currentTimeMillis();
      ynn.resetStatus();
      ScanFastFocusEngineNative localScanFastFocusEngineNative = ynn.process(paramArrayOfByte, paramInt1, paramInt2);
      long l2 = System.currentTimeMillis();
      Integer localInteger1;
      if (localScanFastFocusEngineNative != null)
      {
        paramArrayOfByte = Integer.valueOf(localScanFastFocusEngineNative.result);
        if (localScanFastFocusEngineNative == null) {
          break label179;
        }
        localInteger1 = Integer.valueOf(localScanFastFocusEngineNative.width);
        label76:
        if (localScanFastFocusEngineNative == null) {
          break label185;
        }
      }
      label179:
      label185:
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
        break label76;
      }
    }
    AppMethodBeat.o(52203);
    return null;
  }
  
  public static final void release()
  {
    AppMethodBeat.i(52208);
    if (cAX)
    {
      ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo release");
      ynn.nativeRelease();
      cAX = false;
    }
    AppMethodBeat.o(52208);
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(52207);
    if (cAX)
    {
      ad.d("MicroMsg.ScanFastFocusEngineManager", "alvinluo focusEngineNative reset");
      ynn.reset();
    }
    AppMethodBeat.o(52207);
  }
  
  public static final void setConfig(String paramString)
  {
    AppMethodBeat.i(52210);
    p.h(paramString, "config");
    a((v)new a(paramString));
    AppMethodBeat.o(52210);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class a
    implements v
  {
    a(String paramString) {}
    
    public final void run()
    {
      AppMethodBeat.i(52198);
      u localu = u.yns;
      if (u.dLd())
      {
        localu = u.yns;
        u.dLc().setConfig(this.ynt);
      }
      AppMethodBeat.o(52198);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements v
  {
    public final void run()
    {
      AppMethodBeat.i(52199);
      ad.i("MicroMsg.ScanFastFocusEngineManager", "alvinluo setServerState: %d", new Object[] { Integer.valueOf(this.ynu) });
      u localu = u.yns;
      u.Os(this.ynu);
      localu = u.yns;
      u.dLc().setServerState(this.ynu);
      AppMethodBeat.o(52199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.u
 * JD-Core Version:    0.7.0.1
 */