package com.tencent.mm.plugin.recordvideo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.media.k.d;
import com.tencent.mm.media.k.d.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/config/HevcEncodeChecker;", "", "()V", "TAG", "", "<set-?>", "cpuName", "getCpuName", "()Ljava/lang/String;", "canEncodeHevcHard", "", "captureEnableHevc", "isSoft", "checkHevcEnableImpl", "repairerKey", "Lcom/tencent/mm/util/ConstantsRepairer$ItemInfoKey;", "deviceHwEnableHevc", "", "deviceSwEnableHevc", "hardHevcExptKey", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "hardHevcGpuRatingLimitKey", "softHevcExptKey", "softHevcGpuRatingLimitKey", "finderEnableHevcSoft", "longVideo", "duration", "", "remuxEnableHevc", "plugin-recordvideo_release"})
public final class e
{
  private static String HJL;
  public static final e HJM;
  private static final String TAG = "MicroMsg.HevcEncodeChecker";
  
  static
  {
    AppMethodBeat.i(217164);
    HJM = new e();
    HJL = "";
    TAG = "MicroMsg.HevcEncodeChecker";
    com.tencent.e.h.ZvG.be((Runnable)e.1.HJN);
    AppMethodBeat.o(217164);
  }
  
  private static boolean a(boolean paramBoolean, com.tencent.mm.util.b.a parama, int paramInt1, int paramInt2, com.tencent.mm.plugin.expt.b.b.a parama1, com.tencent.mm.plugin.expt.b.b.a parama2, com.tencent.mm.plugin.expt.b.b.a parama3, com.tencent.mm.plugin.expt.b.b.a parama4)
  {
    AppMethodBeat.i(217154);
    if (!BuildInfo.IS_ARM64)
    {
      AppMethodBeat.o(217154);
      return false;
    }
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.YyX;
    int i = com.tencent.mm.util.i.a(parama, 0);
    int j = d.law.aVI();
    boolean bool;
    if (!paramBoolean)
    {
      if (paramInt1 != -1) {
        if (paramInt1 == 1) {
          paramBoolean = true;
        }
      }
      for (;;)
      {
        if (i == 2) {
          paramBoolean = true;
        }
        Log.i(TAG, "checkHevcEnableImpl hardware encode enable:" + paramBoolean + ", deviceSwEnableHevc:" + paramInt1 + ", repairerConfig:" + i);
        AppMethodBeat.o(217154);
        return paramBoolean;
        paramBoolean = false;
        continue;
        if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(parama1, 0) == 1) {}
        for (bool = true;; bool = false)
        {
          paramBoolean = bool;
          if (!bool) {
            break;
          }
          paramInt2 = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(parama2, -1);
          Log.i(TAG, "checkHevcEnableImpl hardware encode gpu rating limit:" + paramInt2 + ", gpuRating:" + j);
          if (paramInt2 <= 0) {
            break label221;
          }
          if (j < paramInt2) {
            break label216;
          }
          paramBoolean = true;
          break;
        }
        label216:
        paramBoolean = false;
        continue;
        label221:
        paramBoolean = false;
      }
    }
    if (paramInt2 != -1)
    {
      if (paramInt2 == 1) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        if (i == 1) {
          paramBoolean = true;
        }
        Log.i(TAG, "checkHevcEnableImpl software encode enable:" + paramBoolean + ", deviceSwEnableHevc:" + paramInt2 + ", repairerConfig:" + i);
        break;
      }
    }
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(parama3, 0) == 1)
    {
      bool = true;
      label318:
      paramBoolean = bool;
      if (bool)
      {
        paramInt1 = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(parama4, -1);
        Log.i(TAG, "checkHevcEnableImpl software encode gpu rating limit:" + paramInt1 + ", gpuRating:" + j);
        if (paramInt1 <= 0) {
          break label433;
        }
        if (j < paramInt1) {
          break label428;
        }
        paramBoolean = true;
      }
    }
    for (;;)
    {
      Log.i(TAG, "checkHevcEnableImpl software encode enable:" + paramBoolean + ", gpuRating:" + j);
      break;
      bool = false;
      break label318;
      label428:
      paramBoolean = false;
      continue;
      label433:
      paramBoolean = false;
    }
  }
  
  public static String fvy()
  {
    return HJL;
  }
  
  public static boolean fvz()
  {
    AppMethodBeat.i(217163);
    boolean bool;
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wap, 0) == 1)
    {
      bool = true;
      Log.i(TAG, "canEncodeHevcHard, svr isEnable:" + bool + ", cpuName:" + HJL);
      if (bool) {
        if (((CharSequence)HJL).length() != 0) {
          break label97;
        }
      }
    }
    label97:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label102;
      }
      AppMethodBeat.o(217163);
      return false;
      bool = false;
      break;
    }
    label102:
    Object localObject = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.was, "");
    Log.i(TAG, "canEncodeHevcHard, hardCpuList:".concat(String.valueOf(localObject)));
    p.j(localObject, "hardCpuList");
    localObject = (Iterable)n.b((CharSequence)localObject, new String[] { ";" });
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (((CharSequence)str).length() > 0)
        {
          i = 1;
          label221:
          if ((i == 0) || (!n.g((CharSequence)HJL, (CharSequence)str))) {
            break label265;
          }
          i = 1;
          label243:
          if (i == 0) {
            break label268;
          }
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label275;
      }
      AppMethodBeat.o(217163);
      return true;
      i = 0;
      break label221;
      label265:
      i = 0;
      break label243;
      label268:
      break;
    }
    label275:
    AppMethodBeat.o(217163);
    return false;
  }
  
  public static boolean k(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(217160);
    if (!BuildInfo.IS_ARM64)
    {
      AppMethodBeat.o(217160);
      return false;
    }
    boolean bool1;
    boolean bool3;
    label66:
    long l;
    int i;
    int j;
    boolean bool2;
    if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wao, 0) == 1)
    {
      bool1 = true;
      if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wat, 0) != 1) {
        break label247;
      }
      bool3 = true;
      l = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.wau, 9223372036854775807L);
      i = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(com.tencent.mm.plugin.expt.b.b.a.war, -1);
      j = d.law.aVI();
      if (paramBoolean) {
        break label253;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      Log.i(TAG, "canEncodeHevcSoft, svr isEnable:" + bool2 + ", cpuName:" + HJL + ", longVideo:" + paramBoolean + ", duration:" + paramLong + ", enableShortSoft:" + bool1 + ", enableLongSoft:" + bool3 + ", longSoftDurationLimit:" + l + ", enableSoftMinGpuRating:" + i + ", gpuRating:" + j);
      if (bool2) {
        break label277;
      }
      AppMethodBeat.o(217160);
      return false;
      bool1 = false;
      break;
      label247:
      bool3 = false;
      break label66;
      label253:
      if ((bool3) && (paramLong <= l)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    label277:
    if ((j > 0) && (i > 0) && (j >= i))
    {
      AppMethodBeat.o(217160);
      return true;
    }
    AppMethodBeat.o(217160);
    return false;
  }
  
  public static boolean wu(boolean paramBoolean)
  {
    AppMethodBeat.i(217155);
    com.tencent.mm.util.b.a locala = com.tencent.mm.util.b.a.Yyj;
    int i = af.juO.jtK;
    com.tencent.mm.plugin.expt.b.b.a locala1 = com.tencent.mm.plugin.expt.b.b.a.wco;
    com.tencent.mm.plugin.expt.b.b.a locala2 = com.tencent.mm.plugin.expt.b.b.a.wcp;
    boolean bool = a(paramBoolean, locala, i, af.juO.jtL, locala1, locala2, com.tencent.mm.plugin.expt.b.b.a.wcq, com.tencent.mm.plugin.expt.b.b.a.wcr);
    Log.i(TAG, "captureEnableHevc result:" + bool + ", isSoft:" + paramBoolean);
    AppMethodBeat.o(217155);
    return bool;
  }
  
  public static boolean wv(boolean paramBoolean)
  {
    AppMethodBeat.i(217158);
    com.tencent.mm.util.b.a locala = com.tencent.mm.util.b.a.Yyk;
    int i = af.juO.jtM;
    com.tencent.mm.plugin.expt.b.b.a locala1 = com.tencent.mm.plugin.expt.b.b.a.wcs;
    com.tencent.mm.plugin.expt.b.b.a locala2 = com.tencent.mm.plugin.expt.b.b.a.wct;
    boolean bool = a(paramBoolean, locala, i, af.juO.jtN, locala1, locala2, com.tencent.mm.plugin.expt.b.b.a.wcu, com.tencent.mm.plugin.expt.b.b.a.wcv);
    Log.i(TAG, "remuxEnableHevc result:" + bool + ", isSoft:" + paramBoolean);
    AppMethodBeat.o(217158);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.b.e
 * JD-Core Version:    0.7.0.1
 */