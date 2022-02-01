package com.tencent.mm.plugin.recordvideo.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.media.util.d;
import com.tencent.mm.media.util.d.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/config/HevcEncodeChecker;", "", "()V", "TAG", "", "<set-?>", "cpuName", "getCpuName", "()Ljava/lang/String;", "canEncodeHevcHard", "", "captureEnableHevc", "isSoft", "checkHevcEnableImpl", "repairerKey", "Lcom/tencent/mm/util/ConstantsRepairer$ItemInfoKey;", "deviceHwEnableHevc", "", "deviceSwEnableHevc", "hardHevcExptKey", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "hardHevcGpuRatingLimitKey", "softHevcExptKey", "softHevcGpuRatingLimitKey", "finderEnableHevcSoft", "longVideo", "duration", "", "remuxEnableHevc", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e NGK;
  private static String NGL;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(279726);
    NGK = new e();
    NGL = "";
    TAG = "MicroMsg.HevcEncodeChecker";
    com.tencent.threadpool.h.ahAA.bm(e..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(279726);
  }
  
  public static boolean AT(boolean paramBoolean)
  {
    AppMethodBeat.i(279704);
    b.a locala = b.a.agrv;
    int i = af.lYf.lXb;
    c.a locala1 = c.a.zvZ;
    c.a locala2 = c.a.zwa;
    boolean bool = a(paramBoolean, locala, i, af.lYf.lXc, locala1, locala2, c.a.zwb, c.a.zwc);
    Log.i(TAG, "captureEnableHevc result:" + bool + ", isSoft:" + paramBoolean);
    AppMethodBeat.o(279704);
    return bool;
  }
  
  public static boolean AU(boolean paramBoolean)
  {
    AppMethodBeat.i(279709);
    b.a locala = b.a.agrw;
    int i = af.lYf.lXd;
    c.a locala1 = c.a.zwd;
    c.a locala2 = c.a.zwe;
    boolean bool = a(paramBoolean, locala, i, af.lYf.lXe, locala1, locala2, c.a.zwf, c.a.zwg);
    Log.i(TAG, "remuxEnableHevc result:" + bool + ", isSoft:" + paramBoolean);
    AppMethodBeat.o(279709);
    return bool;
  }
  
  private static boolean a(boolean paramBoolean, b.a parama, int paramInt1, int paramInt2, c.a parama1, c.a parama2, c.a parama3, c.a parama4)
  {
    AppMethodBeat.i(279701);
    if (!BuildInfo.IS_ARM64)
    {
      AppMethodBeat.o(279701);
      return false;
    }
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    int i = com.tencent.mm.util.i.a(parama, 0);
    int j = d.nFC.bqn();
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
        AppMethodBeat.o(279701);
        return paramBoolean;
        paramBoolean = false;
        continue;
        if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama1, 0) == 1) {}
        for (bool = true;; bool = false)
        {
          paramBoolean = bool;
          if (!bool) {
            break;
          }
          paramInt2 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama2, -1);
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
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama3, 0) == 1)
    {
      bool = true;
      label318:
      paramBoolean = bool;
      if (bool)
      {
        paramInt1 = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(parama4, -1);
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
  
  private static final void bvy()
  {
    AppMethodBeat.i(279720);
    String str2 = (String)q.aPp().get("hardware");
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    NGL = str1;
    Log.i(TAG, s.X("get cpu name:", NGL));
    AppMethodBeat.o(279720);
  }
  
  public static String gHn()
  {
    return NGL;
  }
  
  public static boolean gHo()
  {
    AppMethodBeat.i(279716);
    boolean bool;
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ztO, 0) == 1)
    {
      bool = true;
      Log.i(TAG, "canEncodeHevcHard, svr isEnable:" + bool + ", cpuName:" + NGL);
      if (bool) {
        if (((CharSequence)NGL).length() != 0) {
          break label101;
        }
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label106;
      }
      AppMethodBeat.o(279716);
      return false;
      bool = false;
      break;
    }
    label106:
    Object localObject = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ztR, "");
    Log.i(TAG, s.X("canEncodeHevcHard, hardCpuList:", localObject));
    s.s(localObject, "hardCpuList");
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
          label225:
          if ((i == 0) || (!n.i((CharSequence)NGL, (CharSequence)str))) {
            break label270;
          }
          i = 1;
          label247:
          if (i == 0) {
            break label273;
          }
        }
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label280;
      }
      AppMethodBeat.o(279716);
      return true;
      i = 0;
      break label225;
      label270:
      i = 0;
      break label247;
      label273:
      break;
    }
    label280:
    AppMethodBeat.o(279716);
    return false;
  }
  
  public static boolean n(boolean paramBoolean, long paramLong)
  {
    AppMethodBeat.i(279714);
    if (!BuildInfo.IS_ARM64)
    {
      AppMethodBeat.o(279714);
      return false;
    }
    boolean bool1;
    boolean bool3;
    label68:
    long l;
    int i;
    int j;
    boolean bool2;
    if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ztN, 0) == 1)
    {
      bool1 = true;
      if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ztS, 0) != 1) {
        break label251;
      }
      bool3 = true;
      l = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ztT, 9223372036854775807L);
      i = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ztQ, -1);
      j = d.nFC.bqn();
      if (paramBoolean) {
        break label257;
      }
      bool2 = bool1;
    }
    for (;;)
    {
      Log.i(TAG, "canEncodeHevcSoft, svr isEnable:" + bool2 + ", cpuName:" + NGL + ", longVideo:" + paramBoolean + ", duration:" + paramLong + ", enableShortSoft:" + bool1 + ", enableLongSoft:" + bool3 + ", longSoftDurationLimit:" + l + ", enableSoftMinGpuRating:" + i + ", gpuRating:" + j);
      if (bool2) {
        break label281;
      }
      AppMethodBeat.o(279714);
      return false;
      bool1 = false;
      break;
      label251:
      bool3 = false;
      break label68;
      label257:
      if ((bool3) && (paramLong <= l)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    label281:
    if ((j > 0) && (i > 0) && (j >= i))
    {
      AppMethodBeat.o(279714);
      return true;
    }
    AppMethodBeat.o(279714);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.c.e
 * JD-Core Version:    0.7.0.1
 */