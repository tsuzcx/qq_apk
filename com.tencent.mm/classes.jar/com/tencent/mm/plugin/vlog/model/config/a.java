package com.tencent.mm.plugin.vlog.model.config;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.gallery.b.g;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.fos;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.vfs.y;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/config/VideoCompositionExportConfig;", "", "()V", "MIN_DURATION", "", "PARALLEL_COUNT_DEFAULT", "PARALLEL_COUNT_HISTORY", "", "PARALLEL_COUNT_MAX", "PARALLEL_HIT_COUNT", "PARALLEL_HIT_DEBUFF", "PARALLEL_RESOLUTION_THRESHOLD", "TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "JSONObjectInstance", "Lorg/json/JSONObject;", "key", "width", "height", "parallelCount", "hit", "calculateSize", "checkEnableParallelExport", "Lkotlin/Pair;", "", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "enableParallelVideoDowngrading", "enableParallelVideoTimeCheck", "forceSaveVideoToAlbum", "getAnalyseJsonArray", "Lorg/json/JSONArray;", "getKVSuggestSize", "path", "isEdited", "updateKVSuggestSize", "", "indicatorSize", "parallelSize", "suggestSize", "find", "getHeight", "getHit", "getKey", "getParallelCount", "getWidth", "setHit", "setParallelCount", "count", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Ubv;
  public static final MultiProcessMMKV eMf;
  
  static
  {
    AppMethodBeat.i(283469);
    Ubv = new a();
    eMf = MultiProcessMMKV.getMMKV("MicroMsg.VideoCompositionExportConfig");
    AppMethodBeat.o(283469);
  }
  
  public static int bV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283361);
    int i = paramJSONObject.optInt("count", -1);
    AppMethodBeat.o(283361);
    return i;
  }
  
  public static int bW(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(283369);
    int i = paramJSONObject.optInt("hit", -1);
    AppMethodBeat.o(283369);
    return i;
  }
  
  public static JSONObject c(JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(283376);
    paramJSONObject = paramJSONObject.put("count", paramInt);
    s.s(paramJSONObject, "this.put(\"count\", count)");
    AppMethodBeat.o(283376);
    return paramJSONObject;
  }
  
  public static JSONObject d(JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(283380);
    paramJSONObject = paramJSONObject.put("hit", paramInt);
    s.s(paramJSONObject, "this.put(\"hit\", hit)");
    AppMethodBeat.o(283380);
    return paramJSONObject;
  }
  
  public static r<Boolean, Integer> f(afb paramafb)
  {
    AppMethodBeat.i(283408);
    s.u(paramafb, "compositionInfo");
    boolean bool1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWt, true);
    boolean bool2 = MultiProcessMMKV.getMultiDefault().decodeBool("device_make_b_frame", false);
    Log.i("MicroMsg.VideoCompositionExportConfig", "bConfig:" + bool1 + " hasBFrame:" + bool2);
    if ((!bool1) && (bool2))
    {
      Log.e("MicroMsg.VideoCompositionExportConfig", "refuse by b-frame check");
      paramafb = new r(Boolean.FALSE, Integer.valueOf(1));
      AppMethodBeat.o(283408);
      return paramafb;
    }
    Object localObject = i.agtt;
    int i = ((Integer)i.a(b.a.agrH, Integer.valueOf(-1))).intValue();
    bool1 = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWr, false);
    Log.i("MicroMsg.VideoCompositionExportConfig", "localConfig:" + i + " xConfig:" + bool1);
    if (i == -1)
    {
      if (!bool1)
      {
        paramafb = new r(Boolean.FALSE, Integer.valueOf(1));
        AppMethodBeat.o(283408);
        return paramafb;
      }
    }
    else if ((i == 1) || (i == 0))
    {
      if (!bool1)
      {
        paramafb = new r(Boolean.FALSE, Integer.valueOf(1));
        AppMethodBeat.o(283408);
        return paramafb;
      }
    }
    else if ((i < 10) && (!g(paramafb)))
    {
      paramafb = new r(Boolean.TRUE, Integer.valueOf(i));
      AppMethodBeat.o(283408);
      return paramafb;
    }
    if (g(paramafb))
    {
      Log.i("MicroMsg.VideoCompositionExportConfig", "checkEnableParallelExportDebug false for compositionInfo not support");
      paramafb = new r(Boolean.FALSE, Integer.valueOf(1));
      AppMethodBeat.o(283408);
      return paramafb;
    }
    if (!BuildInfo.IS_ARM64)
    {
      Log.i("MicroMsg.VideoCompositionExportConfig", "checkEnableParallelExportDebug false for arm32 not support");
      paramafb = new r(Boolean.FALSE, Integer.valueOf(1));
      AppMethodBeat.o(283408);
      return paramafb;
    }
    paramafb = y.n(((fos)paramafb.Zng.get(0)).path, false);
    localObject = g.HRf;
    paramafb = g.aBH(paramafb);
    i = mw(paramafb.width, paramafb.height);
    Log.i("MicroMsg.VideoCompositionExportConfig", s.X("checkEnableParallelExportDebug getKVSuggestSize size:", Integer.valueOf(i)));
    if (i > 1) {}
    for (bool1 = true;; bool1 = false)
    {
      paramafb = new r(Boolean.valueOf(bool1), Integer.valueOf(k.qv(i, 4)));
      AppMethodBeat.o(283408);
      return paramafb;
    }
  }
  
  public static boolean g(afb paramafb)
  {
    AppMethodBeat.i(283418);
    s.u(paramafb, "compositionInfo");
    if ((paramafb.Zng.size() == 1) && (((fos)paramafb.Zng.get(0)).endTimeMs - ((fos)paramafb.Zng.get(0)).startTimeMs >= 30000L) && (paramafb.TYC.Znd.size() == 0))
    {
      AppMethodBeat.o(283418);
      return false;
    }
    AppMethodBeat.o(283418);
    return true;
  }
  
  public static JSONObject h(JSONArray paramJSONArray, int paramInt)
  {
    AppMethodBeat.i(283384);
    final ah.f localf = new ah.f();
    com.tencent.luggage.sdk.h.c.a(paramJSONArray, (kotlin.g.a.b)new a(paramInt, localf));
    paramJSONArray = (JSONObject)localf.aqH;
    AppMethodBeat.o(283384);
    return paramJSONArray;
  }
  
  public static JSONArray hRm()
  {
    AppMethodBeat.i(283430);
    Object localObject = eMf.decodeString("PARALLEL_COUNT_HISTORY_DATA_V2", "");
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new JSONArray();
      AppMethodBeat.o(283430);
      return localObject;
    }
    try
    {
      localObject = new JSONArray((String)localObject);
      AppMethodBeat.o(283430);
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        JSONArray localJSONArray = new JSONArray();
      }
    }
  }
  
  public static boolean hRn()
  {
    AppMethodBeat.i(283444);
    i locali = i.agtt;
    if (((Integer)i.a(b.a.agrG, Integer.valueOf(0))).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VideoCompositionExportConfig", s.X("forceSaveVideoToAlbum ", Boolean.valueOf(bool)));
      AppMethodBeat.o(283444);
      return bool;
    }
  }
  
  public static boolean hRo()
  {
    AppMethodBeat.i(283449);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWu, true);
    Log.i("MicroMsg.VideoCompositionExportConfig", s.X("enableParallelVideoTimeCheck:", Boolean.valueOf(bool)));
    AppMethodBeat.o(283449);
    return bool;
  }
  
  public static boolean hRp()
  {
    AppMethodBeat.i(283456);
    boolean bool = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yWv, true);
    Log.i("MicroMsg.VideoCompositionExportConfig", s.X("enableParallelVideoDowngrading:", Boolean.valueOf(bool)));
    AppMethodBeat.o(283456);
    return bool;
  }
  
  private static int mw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283425);
    JSONArray localJSONArray = hRm();
    int i = mx(paramInt1, paramInt2);
    paramInt1 = 0;
    int j = localJSONArray.length();
    Object localObject2;
    JSONObject localJSONObject;
    Object localObject1;
    if (j > 0)
    {
      localObject2 = null;
      paramInt2 = paramInt1 + 1;
      localJSONObject = localJSONArray.optJSONObject(paramInt1);
      if (localObject2 == null)
      {
        s.s(localJSONObject, "data");
        if (localJSONObject.optInt("key", -1) >= i)
        {
          localObject1 = localJSONObject;
          label73:
          if (paramInt2 < j) {
            break label206;
          }
        }
      }
    }
    for (;;)
    {
      if ((localObject1 != null) && (Math.abs(((JSONObject)localObject1).optInt("key", -1) - i) <= 10))
      {
        Log.i("MicroMsg.VideoCompositionExportConfig", s.X("getKVSuggestSize from kv:", localObject1));
        paramInt1 = ((JSONObject)localObject1).optInt("count", -1);
        AppMethodBeat.o(283425);
        return paramInt1;
        localObject1 = localObject2;
        if (localObject2 == null) {
          break label73;
        }
        paramInt1 = Math.abs(localObject2.optInt("key", -1) - i);
        s.s(localJSONObject, "data");
        localObject1 = localObject2;
        if (paramInt1 <= Math.abs(localJSONObject.optInt("key", -1) - i)) {
          break label73;
        }
        localObject1 = localJSONObject;
        break label73;
      }
      Log.i("MicroMsg.VideoCompositionExportConfig", "getKVSuggestSize from default 3");
      AppMethodBeat.o(283425);
      return 3;
      label206:
      paramInt1 = paramInt2;
      localObject2 = localObject1;
      break;
      localObject1 = null;
    }
  }
  
  public static int mx(int paramInt1, int paramInt2)
  {
    return paramInt1 / 100 * (paramInt2 / 100) / 10;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lorg/json/JSONObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.b<JSONObject, ah>
  {
    a(int paramInt, ah.f<JSONObject> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.config.a
 * JD-Core Version:    0.7.0.1
 */