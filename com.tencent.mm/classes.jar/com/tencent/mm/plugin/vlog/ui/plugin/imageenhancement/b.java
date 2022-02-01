package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.u;
import com.tencent.mm.xeffect.b.b;
import com.tencent.mm.xeffect.b.c;
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
import kotlin.s;
import kotlin.t;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/ImageEnhancementFilterSettingLogic;", "", "()V", "TAG", "", "currentSettings", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo;", "Lkotlin/collections/HashMap;", "getCurrentSettings", "()Ljava/util/HashMap;", "defaultSceneFilterSettings", "getDefaultSceneFilterSettings", "eyeBright", "", "getEyeBright", "()F", "setEyeBright", "(F)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceBeautyWeights", "", "getFaceBeautyWeights", "()[F", "faceBeautyWeightsIndex", "", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$FaceBeautyType;", "getFaceBeautyWeightsIndex", "()Ljava/util/Map;", "faceMorph", "getFaceMorph", "setFaceMorph", "sceneSaveJsonFileName", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "applyFilterSettings", "", "applyImageEnhancementSettings", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "builtinLutTypeFromIntValue", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$BuiltinLutFilterType;", "value", "createFilter", "type", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$FilterType;", "weight", "filterPath", "builtinLutFilterType", "filterWeights", "createSettingsFromFile", "createSettingsFromServerConfig", "faceBeautyTypeToDesc", "filterInfoDesc", "info", "filterTypeFromIntValue", "filterTypeToDesc", "imageLabelToDesc", "label", "initConfig", "isEnableDebug", "", "isShowSceneDesc", "jsonArrayToSceneFilterInfoList", "jsonArray", "Lorg/json/JSONArray;", "jsonToSceneFilterInfo", "json", "Lorg/json/JSONObject;", "jsonToSceneFiltersInfoMap", "loadFaceBeautySettings", "saveSettings", "infoMap", "sceneFilterInfoListToJson", "filtersInfo", "sceneFilterInfoToJson", "sceneFiltersInfoMapToJson", "sceneFiltersInfoMap", "plugin-vlog_release"})
public final class b
{
  private static final String NyV;
  private static final HashMap<Integer, List<com.tencent.mm.xeffect.b>> NyW;
  private static final HashMap<Integer, List<com.tencent.mm.xeffect.b>> NyX;
  private static float NyY;
  private static float NyZ;
  private static float Nza;
  private static float Nzb;
  private static float Nzc;
  private static final Map<b.b, Integer> Nzd;
  private static final float[] Nze;
  public static final b Nzf;
  
  static
  {
    AppMethodBeat.i(247216);
    Nzf = new b();
    NyV = com.tencent.mm.loader.j.b.aSD() + "imageEnhancementSceneFilterSettings.json";
    NyW = new HashMap();
    NyX = new HashMap();
    NyY = 0.45F;
    NyZ = 0.1F;
    Nza = 0.1F;
    Nzb = 0.2F;
    Nzc = 0.4F;
    Nzd = ae.e(new o[] { s.M(b.b.YYP, Integer.valueOf(0)), s.M(b.b.YYT, Integer.valueOf(1)), s.M(b.b.YYS, Integer.valueOf(2)), s.M(b.b.YYQ, Integer.valueOf(3)), s.M(b.b.YYR, Integer.valueOf(4)) });
    Nze = new float[] { NyY, Nzc, Nzb, NyZ, Nza };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YYZ, 0.3F, null, null, null, 28));
    localArrayList.add(a(b.c.YYX, 0.3F, null, com.tencent.mm.xeffect.b.a.YYL, null, 20));
    ((Map)NyW).put(Integer.valueOf(n.a.Zaa.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YZc, 0.0F, null, null, new float[] { NyY, Nzc, Nzb, NyZ, Nza }, 14));
    ((Map)NyW).put(Integer.valueOf(n.a.Zab.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YYW, 0.5F, null, null, null, 28));
    localArrayList.add(a(b.c.YYX, 0.3F, null, com.tencent.mm.xeffect.b.a.YYJ, null, 20));
    ((Map)NyW).put(Integer.valueOf(n.a.Zac.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YYX, 0.3F, null, com.tencent.mm.xeffect.b.a.YYK, null, 20));
    ((Map)NyW).put(Integer.valueOf(n.a.Zad.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YYX, 0.6F, null, com.tencent.mm.xeffect.b.a.YYM, null, 20));
    ((Map)NyW).put(Integer.valueOf(n.a.Zae.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YYX, 0.6F, null, com.tencent.mm.xeffect.b.a.YYN, null, 20));
    ((Map)NyW).put(Integer.valueOf(n.a.Zaf.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YZb, 0.5F, null, null, null, 28));
    ((Map)NyW).put(Integer.valueOf(n.a.Zag.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YZa, 1.0F, null, null, null, 28));
    localArrayList.add(a(b.c.YYZ, 0.5F, null, null, null, 28));
    ((Map)NyW).put(Integer.valueOf(n.a.Zah.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YYW, 0.3F, null, null, null, 28));
    localArrayList.add(a(b.c.YZb, 0.5F, null, null, null, 28));
    ((Map)NyW).put(Integer.valueOf(n.a.Zai.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YYW, 0.5F, null, null, null, 28));
    ((Map)NyW).put(Integer.valueOf(n.a.Zaj.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YYZ, 0.3F, null, null, null, 28));
    localArrayList.add(a(b.c.YYX, 0.2F, null, com.tencent.mm.xeffect.b.a.YYL, null, 20));
    ((Map)NyW).put(Integer.valueOf(n.a.Zak.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.YZa, 0.0F, null, null, null, 28));
    localArrayList.add(a(b.c.YYW, 0.6F, null, null, null, 28));
    ((Map)NyW).put(Integer.valueOf(n.a.Zal.ordinal()), localArrayList);
    AppMethodBeat.o(247216);
  }
  
  private static List<com.tencent.mm.xeffect.b> L(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(247201);
    p.k(paramJSONArray, "jsonArray");
    ArrayList localArrayList = new ArrayList();
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      p.j(localJSONObject, "jsonArray.getJSONObject(i)");
      localArrayList.add(bD(localJSONObject));
      i += 1;
    }
    paramJSONArray = (List)localArrayList;
    AppMethodBeat.o(247201);
    return paramJSONArray;
  }
  
  private HashMap<Integer, List<com.tencent.mm.xeffect.b>> M(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(247205);
    p.k(paramJSONArray, "json");
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
        localObject = L((JSONArray)localObject);
        ((Map)localHashMap).put(Integer.valueOf(k), localObject);
      }
      i += 1;
    }
    AppMethodBeat.o(247205);
    return localHashMap;
  }
  
  private static JSONObject a(com.tencent.mm.xeffect.b paramb)
  {
    AppMethodBeat.i(247195);
    p.k(paramb, "info");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramb.YYE.ordinal());
    localJSONObject.put("filterWeight", Float.valueOf(paramb.YYF));
    localJSONObject.put("filterPath", paramb.krc);
    localJSONObject.put("builtinLutFilterType", paramb.YYG.ordinal());
    JSONArray localJSONArray = new JSONArray();
    paramb = paramb.YYH;
    p.j(paramb, "info.filterWeights");
    int j = paramb.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(Float.valueOf(paramb[i]));
      i += 1;
    }
    localJSONObject.put("filterWeights", localJSONArray);
    AppMethodBeat.o(247195);
    return localJSONObject;
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(247193);
    String str = u.bBS(NyV);
    p.j(str, "json");
    if (((CharSequence)str).length() > 0) {}
    for (int i = 1; (i != 0) && (paramn != null); i = 0)
    {
      paramn.bCB(str);
      AppMethodBeat.o(247193);
      return;
    }
    AppMethodBeat.o(247193);
  }
  
  public static String aks(int paramInt)
  {
    AppMethodBeat.i(247189);
    Object localObject = MMApplicationContext.getContext();
    if (paramInt == n.a.Zaa.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_pet);
      p.j(localObject, "context.getString(R.string.video_label_pet)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zab.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_people);
      p.j(localObject, "context.getString(R.string.video_label_people)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zac.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_food);
      p.j(localObject, "context.getString(R.string.video_label_food)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zad.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_plant);
      p.j(localObject, "context.getString(R.string.video_label_plant)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zae.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_flower);
      p.j(localObject, "context.getString(R.string.video_label_flower)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zaf.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_sky);
      p.j(localObject, "context.getString(R.string.video_label_sky)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zag.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_sunrisesunset);
      p.j(localObject, "context.getString(R.stri…ideo_label_sunrisesunset)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zah.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_snow);
      p.j(localObject, "context.getString(R.string.video_label_snow)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zai.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_city);
      p.j(localObject, "context.getString(R.string.video_label_city)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zaj.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_night);
      p.j(localObject, "context.getString(R.string.video_label_night)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zak.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_room);
      p.j(localObject, "context.getString(R.string.video_label_room)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zal.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_doc);
      p.j(localObject, "context.getString(R.string.video_label_doc)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    if (paramInt == n.a.Zam.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_origin);
      p.j(localObject, "context.getString(R.string.video_label_origin)");
      AppMethodBeat.o(247189);
      return localObject;
    }
    AppMethodBeat.o(247189);
    return "Unknown type";
  }
  
  private static com.tencent.mm.xeffect.b bD(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(247198);
    p.k(paramJSONObject, "json");
    com.tencent.mm.xeffect.b localb = new com.tencent.mm.xeffect.b();
    int j = paramJSONObject.optInt("type", 0);
    Object localObject2 = b.c.values();
    int k = localObject2.length;
    int i = 0;
    Object localObject1;
    if (i < k)
    {
      localObject1 = localObject2[i];
      if (((b.c)localObject1).ordinal() == j)
      {
        label62:
        localb.YYE = ((b.c)localObject1);
        localb.YYF = ((float)paramJSONObject.optDouble("filterWeight", 0.0D));
        localb.krc = paramJSONObject.optString("filterPath");
        j = paramJSONObject.optInt("builtinLutFilterType", 0);
        localObject2 = com.tencent.mm.xeffect.b.a.values();
        k = localObject2.length;
        i = 0;
        label115:
        if (i >= k) {
          break label219;
        }
        localObject1 = localObject2[i];
        if (((com.tencent.mm.xeffect.b.a)localObject1).ordinal() != j) {
          break label212;
        }
      }
    }
    for (;;)
    {
      localb.YYG = ((com.tencent.mm.xeffect.b.a)localObject1);
      paramJSONObject = paramJSONObject.optJSONArray("filterWeights");
      if (paramJSONObject == null) {
        break label227;
      }
      localb.YYH = new float[paramJSONObject.length()];
      j = paramJSONObject.length();
      i = 0;
      while (i < j)
      {
        localb.YYH[i] = ((float)paramJSONObject.getDouble(i));
        i += 1;
      }
      i += 1;
      break;
      localObject1 = b.c.YZd;
      break label62;
      label212:
      i += 1;
      break label115;
      label219:
      localObject1 = com.tencent.mm.xeffect.b.a.YYI;
    }
    label227:
    AppMethodBeat.o(247198);
    return localb;
  }
  
  private static void gvX()
  {
    AppMethodBeat.i(247184);
    Object localObject1 = (List)NyX.get(Integer.valueOf(n.a.Zab.ordinal()));
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label200;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((com.tencent.mm.xeffect.b)localObject1).YYE != b.c.YZc) {
        break label195;
      }
      i = 1;
      label70:
      if (i == 0) {
        break label198;
      }
      label74:
      localObject2 = (com.tencent.mm.xeffect.b)localObject1;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.xeffect.b)localObject2).YYH.length != Nze.length) {
          break label205;
        }
        localObject1 = ((com.tencent.mm.xeffect.b)localObject2).YYH;
        p.j(localObject1, "it.filterWeights");
        e.e((float[])localObject1, Nze);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "loadFaceBeautySettings, skinSmooth:" + NyY + ", skinBright:" + Nzb + ", faceMorph:" + Nza + ", eyeBright:" + Nzc + ", eyeMorph:" + NyZ);
      AppMethodBeat.o(247184);
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
      ((com.tencent.mm.xeffect.b)localObject2).YYH = new float[Nze.length];
      localObject1 = Nze;
      localObject2 = ((com.tencent.mm.xeffect.b)localObject2).YYH;
      p.j(localObject2, "it.filterWeights");
      e.e((float[])localObject1, (float[])localObject2);
    }
  }
  
  private final HashMap<Integer, List<com.tencent.mm.xeffect.b>> gvZ()
  {
    AppMethodBeat.i(247209);
    try
    {
      HashMap localHashMap1 = M(new JSONArray(u.bBS(NyV)));
      AppMethodBeat.o(247209);
      return localHashMap1;
    }
    catch (Exception localException)
    {
      HashMap localHashMap2 = NyW;
      AppMethodBeat.o(247209);
      return localHashMap2;
    }
  }
  
  private final void gwa()
  {
    AppMethodBeat.i(247211);
    int m = com.tencent.mm.plugin.expt.b.b.a.vYz.ordinal();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    while (i < 5)
    {
      localObject3 = com.tencent.mm.plugin.expt.b.b.a.values();
      int n = localObject3.length;
      int j = 0;
      Object localObject1;
      int k;
      if (j < n)
      {
        localObject1 = localObject3[j];
        if (((com.tencent.mm.plugin.expt.b.b.a)localObject1).ordinal() == m + i)
        {
          k = 1;
          if (k == 0) {
            break label256;
          }
          label72:
          localObject1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a((com.tencent.mm.plugin.expt.b.b.a)localObject1, "");
          Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "scene_config_" + i + " json:" + (String)localObject1);
          p.j(localObject1, "sceneJson");
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
    Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "finalConfigJson:" + localJSONArray + ", save to file:" + NyV);
    Object localObject2 = NyV;
    Object localObject3 = localJSONArray.toString();
    p.j(localObject3, "finalConfigJson.toString()");
    Charset localCharset = d.UTF_8;
    if (localObject3 == null)
    {
      localObject2 = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(247211);
      throw ((Throwable)localObject2);
    }
    localObject3 = ((String)localObject3).getBytes(localCharset);
    p.j(localObject3, "(this as java.lang.String).getBytes(charset)");
    u.H((String)localObject2, (byte[])localObject3);
    NyX.clear();
    NyX.putAll((Map)M(localJSONArray));
    AppMethodBeat.o(247211);
  }
  
  private static boolean gwb()
  {
    AppMethodBeat.i(247214);
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(247214);
      return true;
    }
    AppMethodBeat.o(247214);
    return false;
  }
  
  public static boolean gwc()
  {
    AppMethodBeat.i(247215);
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SCENE_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(247215);
      return true;
    }
    AppMethodBeat.o(247215);
    return false;
  }
  
  private static JSONArray iI(List<? extends com.tencent.mm.xeffect.b> paramList)
  {
    AppMethodBeat.i(247199);
    p.k(paramList, "filtersInfo");
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(a((com.tencent.mm.xeffect.b)paramList.next()));
    }
    AppMethodBeat.o(247199);
    return localJSONArray;
  }
  
  private static JSONArray t(HashMap<Integer, List<com.tencent.mm.xeffect.b>> paramHashMap)
  {
    AppMethodBeat.i(247203);
    p.k(paramHashMap, "sceneFiltersInfoMap");
    JSONArray localJSONArray = new JSONArray();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scene", ((Number)localEntry.getKey()).intValue());
      localJSONObject.put("filters", iI((List)localEntry.getValue()));
      localJSONArray.put(localJSONObject);
    }
    AppMethodBeat.o(247203);
    return localJSONArray;
  }
  
  private void u(HashMap<Integer, List<com.tencent.mm.xeffect.b>> paramHashMap)
  {
    AppMethodBeat.i(247207);
    p.k(paramHashMap, "infoMap");
    Object localObject = t(paramHashMap);
    paramHashMap = NyV;
    localObject = ((JSONArray)localObject).toString();
    p.j(localObject, "json.toString()");
    Charset localCharset = d.UTF_8;
    if (localObject == null)
    {
      paramHashMap = new t("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(247207);
      throw paramHashMap;
    }
    localObject = ((String)localObject).getBytes(localCharset);
    p.j(localObject, "(this as java.lang.String).getBytes(charset)");
    u.H(paramHashMap, (byte[])localObject);
    AppMethodBeat.o(247207);
  }
  
  public final void dbH()
  {
    AppMethodBeat.i(247179);
    if (gwb())
    {
      HashMap localHashMap = gvZ();
      if (localHashMap != null)
      {
        NyX.clear();
        NyX.putAll((Map)localHashMap);
        gvX();
        AppMethodBeat.o(247179);
        return;
      }
      AppMethodBeat.o(247179);
      return;
    }
    gwa();
    AppMethodBeat.o(247179);
  }
  
  public final void gvY()
  {
    AppMethodBeat.i(247190);
    if (gwb())
    {
      gvX();
      u(NyX);
    }
    String str = u.bBS(NyV);
    a locala = a.Nol;
    p.j(str, "settingsJson");
    a.bfA(str);
    AppMethodBeat.o(247190);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b
 * JD-Core Version:    0.7.0.1
 */