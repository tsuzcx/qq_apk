package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.xeffect.a.a;
import com.tencent.mm.xeffect.a.b;
import com.tencent.mm.xeffect.a.c;
import com.tencent.mm.xeffect.effect.n;
import com.tencent.mm.xeffect.effect.n.a;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.a.e;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.o;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/ImageEnhancementFilterSettingLogic;", "", "()V", "TAG", "", "currentSettings", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo;", "Lkotlin/collections/HashMap;", "getCurrentSettings", "()Ljava/util/HashMap;", "defaultSceneFilterSettings", "getDefaultSceneFilterSettings", "eyeBright", "", "getEyeBright", "()F", "setEyeBright", "(F)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceBeautyWeights", "", "getFaceBeautyWeights", "()[F", "faceBeautyWeightsIndex", "", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$FaceBeautyType;", "getFaceBeautyWeightsIndex", "()Ljava/util/Map;", "faceMorph", "getFaceMorph", "setFaceMorph", "sceneSaveJsonFileName", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "applyFilterSettings", "", "applyImageEnhancementSettings", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "builtinLutTypeFromIntValue", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$BuiltinLutFilterType;", "value", "createFilter", "type", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$FilterType;", "weight", "filterPath", "builtinLutFilterType", "filterWeights", "createSettingsFromFile", "createSettingsFromServerConfig", "faceBeautyTypeToDesc", "filterInfoDesc", "info", "filterTypeFromIntValue", "filterTypeToDesc", "imageLabelToDesc", "label", "initConfig", "isEnableDebug", "", "isShowSceneDesc", "jsonArrayToSceneFilterInfoList", "jsonArray", "Lorg/json/JSONArray;", "jsonToSceneFilterInfo", "json", "Lorg/json/JSONObject;", "jsonToSceneFiltersInfoMap", "loadFaceBeautySettings", "saveSettings", "infoMap", "sceneFilterInfoListToJson", "filtersInfo", "sceneFilterInfoToJson", "sceneFiltersInfoMapToJson", "sceneFiltersInfoMap", "plugin-vlog_release"})
public final class b
{
  private static float GLA;
  private static float GLB;
  private static float GLC;
  private static final Map<a.b, Integer> GLD;
  private static final float[] GLE;
  public static final b GLF;
  private static final String GLv;
  private static final HashMap<Integer, List<com.tencent.mm.xeffect.a>> GLw;
  private static final HashMap<Integer, List<com.tencent.mm.xeffect.a>> GLx;
  private static float GLy;
  private static float GLz;
  
  static
  {
    AppMethodBeat.i(191770);
    GLF = new b();
    GLv = com.tencent.mm.loader.j.b.aKB() + "imageEnhancementSceneFilterSettings.json";
    GLw = new HashMap();
    GLx = new HashMap();
    GLy = 0.45F;
    GLz = 0.1F;
    GLA = 0.1F;
    GLB = 0.2F;
    GLC = 0.4F;
    GLD = ae.e(new o[] { kotlin.s.U(a.b.Rxq, Integer.valueOf(0)), kotlin.s.U(a.b.Rxu, Integer.valueOf(1)), kotlin.s.U(a.b.Rxt, Integer.valueOf(2)), kotlin.s.U(a.b.Rxr, Integer.valueOf(3)), kotlin.s.U(a.b.Rxs, Integer.valueOf(4)) });
    GLE = new float[] { GLy, GLC, GLB, GLz, GLA };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(a.c.RxA, 0.3F, null, null, null, 28));
    localArrayList.add(a(a.c.Rxy, 0.3F, null, a.a.Rxm, null, 20));
    ((Map)GLw).put(Integer.valueOf(n.a.Rys.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.RxD, 0.0F, null, null, new float[] { GLy, GLC, GLB, GLz, GLA }, 14));
    ((Map)GLw).put(Integer.valueOf(n.a.Ryt.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.Rxx, 0.5F, null, null, null, 28));
    localArrayList.add(a(a.c.Rxy, 0.3F, null, a.a.Rxk, null, 20));
    ((Map)GLw).put(Integer.valueOf(n.a.Ryu.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.Rxy, 0.3F, null, a.a.Rxl, null, 20));
    ((Map)GLw).put(Integer.valueOf(n.a.Ryv.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.Rxy, 0.6F, null, a.a.Rxn, null, 20));
    ((Map)GLw).put(Integer.valueOf(n.a.Ryw.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.Rxy, 0.6F, null, a.a.Rxo, null, 20));
    ((Map)GLw).put(Integer.valueOf(n.a.Ryx.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.RxC, 0.5F, null, null, null, 28));
    ((Map)GLw).put(Integer.valueOf(n.a.Ryy.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.RxB, 1.0F, null, null, null, 28));
    localArrayList.add(a(a.c.RxA, 0.5F, null, null, null, 28));
    ((Map)GLw).put(Integer.valueOf(n.a.Ryz.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.Rxx, 0.3F, null, null, null, 28));
    localArrayList.add(a(a.c.RxC, 0.5F, null, null, null, 28));
    ((Map)GLw).put(Integer.valueOf(n.a.RyA.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.Rxx, 0.5F, null, null, null, 28));
    ((Map)GLw).put(Integer.valueOf(n.a.RyB.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.RxA, 0.3F, null, null, null, 28));
    localArrayList.add(a(a.c.Rxy, 0.2F, null, a.a.Rxm, null, 20));
    ((Map)GLw).put(Integer.valueOf(n.a.RyC.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(a.c.RxB, 0.0F, null, null, null, 28));
    localArrayList.add(a(a.c.Rxx, 0.6F, null, null, null, 28));
    ((Map)GLw).put(Integer.valueOf(n.a.RyD.ordinal()), localArrayList);
    AppMethodBeat.o(191770);
  }
  
  private static List<com.tencent.mm.xeffect.a> J(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(191762);
    p.h(paramJSONArray, "jsonArray");
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      p.g(localJSONObject, "jsonArray.getJSONObject(i)");
      localArrayList.add(bs(localJSONObject));
      i += 1;
    }
    paramJSONArray = (List)localArrayList;
    AppMethodBeat.o(191762);
    return paramJSONArray;
  }
  
  private HashMap<Integer, List<com.tencent.mm.xeffect.a>> K(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(191764);
    p.h(paramJSONArray, "json");
    HashMap localHashMap = new HashMap();
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramJSONArray.getJSONObject(i);
      int k = ((JSONObject)localObject).optInt("scene", -1);
      localObject = ((JSONObject)localObject).optJSONArray("filters");
      if ((k >= 0) && (localObject != null))
      {
        localObject = J((JSONArray)localObject);
        ((Map)localHashMap).put(Integer.valueOf(k), localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(191764);
    return localHashMap;
  }
  
  private static JSONObject a(com.tencent.mm.xeffect.a parama)
  {
    AppMethodBeat.i(191759);
    p.h(parama, "info");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", parama.Rxf.ordinal());
    localJSONObject.put("filterWeight", Float.valueOf(parama.Rxg));
    localJSONObject.put("filterPath", parama.hDj);
    localJSONObject.put("builtinLutFilterType", parama.Rxh.ordinal());
    JSONArray localJSONArray = new JSONArray();
    parama = parama.Rxi;
    p.g(parama, "info.filterWeights");
    int j = parama.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(Float.valueOf(parama[i]));
      i += 1;
    }
    localJSONObject.put("filterWeights", localJSONArray);
    AppMethodBeat.o(191759);
    return localJSONObject;
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(191758);
    String str = com.tencent.mm.vfs.s.boY(GLv);
    p.g(str, "json");
    if (((CharSequence)str).length() > 0) {}
    for (int i = 1; (i != 0) && (paramn != null); i = 0)
    {
      paramn.bpE(str);
      AppMethodBeat.o(191758);
      return;
    }
    AppMethodBeat.o(191758);
  }
  
  public static String acJ(int paramInt)
  {
    AppMethodBeat.i(191756);
    Object localObject = MMApplicationContext.getContext();
    if (paramInt == n.a.Rys.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767084);
      p.g(localObject, "context.getString(R.string.video_label_pet)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.Ryt.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767083);
      p.g(localObject, "context.getString(R.string.video_label_people)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.Ryu.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767080);
      p.g(localObject, "context.getString(R.string.video_label_food)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.Ryv.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767085);
      p.g(localObject, "context.getString(R.string.video_label_plant)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.Ryw.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767079);
      p.g(localObject, "context.getString(R.string.video_label_flower)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.Ryx.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767087);
      p.g(localObject, "context.getString(R.string.video_label_sky)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.Ryy.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767089);
      p.g(localObject, "context.getString(R.stri…ideo_label_sunrisesunset)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.Ryz.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767088);
      p.g(localObject, "context.getString(R.string.video_label_snow)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.RyA.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767077);
      p.g(localObject, "context.getString(R.string.video_label_city)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.RyB.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767081);
      p.g(localObject, "context.getString(R.string.video_label_night)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.RyC.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767086);
      p.g(localObject, "context.getString(R.string.video_label_room)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.RyD.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767078);
      p.g(localObject, "context.getString(R.string.video_label_doc)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    if (paramInt == n.a.RyE.ordinal())
    {
      localObject = ((Context)localObject).getString(2131767082);
      p.g(localObject, "context.getString(R.string.video_label_origin)");
      AppMethodBeat.o(191756);
      return localObject;
    }
    AppMethodBeat.o(191756);
    return "Unknown type";
  }
  
  private static com.tencent.mm.xeffect.a bs(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(191760);
    p.h(paramJSONObject, "json");
    com.tencent.mm.xeffect.a locala = new com.tencent.mm.xeffect.a();
    int j = paramJSONObject.optInt("type", 0);
    Object localObject2 = a.c.values();
    int k = localObject2.length;
    int i = 0;
    Object localObject1;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if (((a.c)localObject1).ordinal() == j)
      {
        label62:
        locala.Rxf = ((a.c)localObject1);
        locala.Rxg = ((float)paramJSONObject.optDouble("filterWeight", 0.0D));
        locala.hDj = paramJSONObject.optString("filterPath");
        j = paramJSONObject.optInt("builtinLutFilterType", 0);
        localObject2 = a.a.values();
        k = localObject2.length;
        i = 0;
        label115:
        if (i >= k) {
          break label219;
        }
        localObject1 = localObject2[i];
        if (((a.a)localObject1).ordinal() != j) {
          break label212;
        }
      }
    }
    for (;;)
    {
      locala.Rxh = ((a.a)localObject1);
      paramJSONObject = paramJSONObject.optJSONArray("filterWeights");
      if (paramJSONObject == null) {
        break label227;
      }
      locala.Rxi = new float[paramJSONObject.length()];
      j = paramJSONObject.length();
      i = 0;
      while (i < j)
      {
        locala.Rxi[i] = ((float)paramJSONObject.getDouble(i));
        i += 1;
      }
      i += 1;
      break;
      localObject1 = a.c.RxE;
      break label62;
      label212:
      i += 1;
      break label115;
      label219:
      localObject1 = a.a.Rxj;
    }
    label227:
    AppMethodBeat.o(191760);
    return locala;
  }
  
  private static void fDX()
  {
    AppMethodBeat.i(191754);
    Object localObject1 = (List)GLx.get(Integer.valueOf(n.a.Ryt.ordinal()));
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label200;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((com.tencent.mm.xeffect.a)localObject1).Rxf != a.c.RxD) {
        break label195;
      }
      i = 1;
      label70:
      if (i == 0) {
        break label198;
      }
      label74:
      localObject2 = (com.tencent.mm.xeffect.a)localObject1;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.xeffect.a)localObject2).Rxi.length != GLE.length) {
          break label205;
        }
        localObject1 = ((com.tencent.mm.xeffect.a)localObject2).Rxi;
        p.g(localObject1, "it.filterWeights");
        e.f((float[])localObject1, GLE);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "loadFaceBeautySettings, skinSmooth:" + GLy + ", skinBright:" + GLB + ", faceMorph:" + GLA + ", eyeBright:" + GLC + ", eyeMorph:" + GLz);
      AppMethodBeat.o(191754);
      return;
      label195:
      i = 0;
      break label70;
      label198:
      break;
      label200:
      localObject1 = null;
      break label74;
      label205:
      ((com.tencent.mm.xeffect.a)localObject2).Rxi = new float[GLE.length];
      localObject1 = GLE;
      localObject2 = ((com.tencent.mm.xeffect.a)localObject2).Rxi;
      p.g(localObject2, "it.filterWeights");
      e.f((float[])localObject1, (float[])localObject2);
    }
  }
  
  private final HashMap<Integer, List<com.tencent.mm.xeffect.a>> fDZ()
  {
    AppMethodBeat.i(191766);
    try
    {
      HashMap localHashMap1 = K(new JSONArray(com.tencent.mm.vfs.s.boY(GLv)));
      AppMethodBeat.o(191766);
      return localHashMap1;
    }
    catch (Exception localException)
    {
      HashMap localHashMap2 = GLw;
      AppMethodBeat.o(191766);
      return localHashMap2;
    }
  }
  
  private final void fEa()
  {
    AppMethodBeat.i(191767);
    int m = b.a.snn.ordinal();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < 5)
    {
      localObject3 = b.a.values();
      int n = localObject3.length;
      int j = 0;
      Object localObject1;
      int k;
      if (j < n)
      {
        localObject1 = localObject3[j];
        if (((b.a)localObject1).ordinal() == m + i)
        {
          k = 1;
          if (k == 0) {
            break label256;
          }
          label72:
          localObject1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a((b.a)localObject1, "");
          Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "scene_config_" + i + " json:" + (String)localObject1);
          p.g(localObject1, "sceneJson");
          if (((CharSequence)localObject1).length() <= 0) {
            break label269;
          }
        }
      }
      for (j = 1;; j = 0)
      {
        for (;;)
        {
          if (j == 0) {
            break label276;
          }
          label256:
          label269:
          try
          {
            localObject1 = new JSONArray((String)localObject1);
            Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "parse scene_config_" + i + " len:" + ((JSONArray)localObject1).length());
            if (((JSONArray)localObject1).length() <= 0) {
              break label276;
            }
            k = ((JSONArray)localObject1).length();
            j = 0;
            while (j < k)
            {
              localObject3 = ((JSONArray)localObject1).optJSONObject(j);
              if (localObject3 != null) {
                localJSONArray.put(localObject3);
              }
              j += 1;
            }
            k = 0;
          }
          catch (Exception localException) {}
        }
        j += 1;
        break;
        localObject1 = null;
        break label72;
      }
      label276:
      i += 1;
    }
    Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "finalConfigJson:" + localJSONArray + ", save to file:" + GLv);
    Object localObject2 = GLv;
    Object localObject3 = localJSONArray.toString();
    p.g(localObject3, "finalConfigJson.toString()");
    Charset localCharset = d.UTF_8;
    if (localObject3 == null)
    {
      localObject2 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(191767);
      throw ((Throwable)localObject2);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.g(localObject3, "(this as java.lang.String).getBytes(charset)");
    com.tencent.mm.vfs.s.C((String)localObject2, (byte[])localObject3);
    GLx.clear();
    GLx.putAll((Map)K(localJSONArray));
    AppMethodBeat.o(191767);
  }
  
  private static boolean fEb()
  {
    AppMethodBeat.i(191768);
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(191768);
      return true;
    }
    AppMethodBeat.o(191768);
    return false;
  }
  
  public static boolean fEc()
  {
    AppMethodBeat.i(191769);
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SCENE_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(191769);
      return true;
    }
    AppMethodBeat.o(191769);
    return false;
  }
  
  private static JSONArray hV(List<? extends com.tencent.mm.xeffect.a> paramList)
  {
    AppMethodBeat.i(191761);
    p.h(paramList, "filtersInfo");
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(a((com.tencent.mm.xeffect.a)paramList.next()));
    }
    AppMethodBeat.o(191761);
    return localJSONArray;
  }
  
  private static JSONArray q(HashMap<Integer, List<com.tencent.mm.xeffect.a>> paramHashMap)
  {
    AppMethodBeat.i(191763);
    p.h(paramHashMap, "sceneFiltersInfoMap");
    JSONArray localJSONArray = new JSONArray();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scene", ((Number)localEntry.getKey()).intValue());
      localJSONObject.put("filters", hV((List)localEntry.getValue()));
      localJSONArray.put(localJSONObject);
    }
    AppMethodBeat.o(191763);
    return localJSONArray;
  }
  
  private void r(HashMap<Integer, List<com.tencent.mm.xeffect.a>> paramHashMap)
  {
    AppMethodBeat.i(191765);
    p.h(paramHashMap, "infoMap");
    Object localObject = q(paramHashMap);
    paramHashMap = GLv;
    localObject = ((JSONArray)localObject).toString();
    p.g(localObject, "json.toString()");
    Charset localCharset = d.UTF_8;
    if (localObject == null)
    {
      paramHashMap = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(191765);
      throw paramHashMap;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.g(localObject, "(this as java.lang.String).getBytes(charset)");
    com.tencent.mm.vfs.s.C(paramHashMap, (byte[])localObject);
    AppMethodBeat.o(191765);
  }
  
  public final void cMT()
  {
    AppMethodBeat.i(191753);
    if (fEb())
    {
      HashMap localHashMap = fDZ();
      if (localHashMap != null)
      {
        GLx.clear();
        GLx.putAll((Map)localHashMap);
        fDX();
        AppMethodBeat.o(191753);
        return;
      }
      AppMethodBeat.o(191753);
      return;
    }
    fEa();
    AppMethodBeat.o(191753);
  }
  
  public final void fDY()
  {
    AppMethodBeat.i(191757);
    if (fEb())
    {
      fDX();
      r(GLx);
    }
    String str = com.tencent.mm.vfs.s.boY(GLv);
    com.tencent.mm.plugin.vlog.model.local.a locala = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    p.g(str, "settingsJson");
    com.tencent.mm.plugin.vlog.model.local.a.aUd(str);
    AppMethodBeat.o(191757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b
 * JD-Core Version:    0.7.0.1
 */