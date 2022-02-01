package com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.vlog.a.i;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.vfs.y;
import com.tencent.mm.xeffect.b.a;
import com.tencent.mm.xeffect.b.b;
import com.tencent.mm.xeffect.b.c;
import com.tencent.mm.xeffect.effect.n;
import com.tencent.mm.xeffect.effect.n.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.k;
import kotlin.g.b.s;
import kotlin.n.d;
import kotlin.r;
import kotlin.v;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/imageenhancement/ImageEnhancementFilterSettingLogic;", "", "()V", "TAG", "", "currentSettings", "Ljava/util/HashMap;", "", "", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo;", "Lkotlin/collections/HashMap;", "getCurrentSettings", "()Ljava/util/HashMap;", "defaultSceneFilterSettings", "getDefaultSceneFilterSettings", "eyeBright", "", "getEyeBright", "()F", "setEyeBright", "(F)V", "eyeMorph", "getEyeMorph", "setEyeMorph", "faceBeautyWeights", "", "getFaceBeautyWeights", "()[F", "faceBeautyWeightsIndex", "", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$FaceBeautyType;", "getFaceBeautyWeightsIndex", "()Ljava/util/Map;", "faceMorph", "getFaceMorph", "setFaceMorph", "sceneSaveJsonFileName", "skinBright", "getSkinBright", "setSkinBright", "skinSmooth", "getSkinSmooth", "setSkinSmooth", "applyFilterSettings", "", "applyImageEnhancementSettings", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "builtinLutTypeFromIntValue", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$BuiltinLutFilterType;", "value", "createFilter", "type", "Lcom/tencent/mm/xeffect/ImageEnhancementSceneFilterInfo$FilterType;", "weight", "filterPath", "builtinLutFilterType", "filterWeights", "createSettingsFromFile", "createSettingsFromServerConfig", "faceBeautyTypeToDesc", "filterInfoDesc", "info", "filterTypeFromIntValue", "filterTypeToDesc", "imageLabelToDesc", "label", "initConfig", "isEnableDebug", "", "isShowSceneDesc", "jsonArrayToSceneFilterInfoList", "jsonArray", "Lorg/json/JSONArray;", "jsonToSceneFilterInfo", "json", "Lorg/json/JSONObject;", "jsonToSceneFiltersInfoMap", "loadFaceBeautySettings", "saveSettings", "infoMap", "sceneFilterInfoListToJson", "filtersInfo", "sceneFilterInfoToJson", "sceneFiltersInfoMapToJson", "sceneFiltersInfoMap", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b UlR;
  private static final String UlS;
  private static final HashMap<Integer, List<com.tencent.mm.xeffect.b>> UlT;
  private static final HashMap<Integer, List<com.tencent.mm.xeffect.b>> UlU;
  private static float UlV;
  private static float UlW;
  private static float UlX;
  private static float UlY;
  private static float UlZ;
  private static final Map<b.b, Integer> Uma;
  private static final float[] Umb;
  
  static
  {
    AppMethodBeat.i(283386);
    UlR = new b();
    UlS = s.X(com.tencent.mm.loader.i.b.bmr(), "imageEnhancementSceneFilterSettings.json");
    UlT = new HashMap();
    UlU = new HashMap();
    UlV = 0.45F;
    UlW = 0.1F;
    UlX = 0.1F;
    UlY = 0.2F;
    UlZ = 0.4F;
    Uma = ak.e(new r[] { v.Y(b.b.agXa, Integer.valueOf(0)), v.Y(b.b.agXe, Integer.valueOf(1)), v.Y(b.b.agXd, Integer.valueOf(2)), v.Y(b.b.agXb, Integer.valueOf(3)), v.Y(b.b.agXc, Integer.valueOf(4)) });
    Umb = new float[] { UlV, UlZ, UlY, UlW, UlX };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXk, 0.3F, null, null, null, 28));
    localArrayList.add(a(b.c.agXi, 0.3F, null, b.a.agWW, null, 20));
    ((Map)UlT).put(Integer.valueOf(n.a.agYm.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXn, 0.0F, null, null, new float[] { UlV, UlZ, UlY, UlW, UlX }, 14));
    ((Map)UlT).put(Integer.valueOf(n.a.agYn.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXh, 0.5F, null, null, null, 28));
    localArrayList.add(a(b.c.agXi, 0.3F, null, b.a.agWU, null, 20));
    ((Map)UlT).put(Integer.valueOf(n.a.agYo.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXi, 0.3F, null, b.a.agWV, null, 20));
    ((Map)UlT).put(Integer.valueOf(n.a.agYp.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXi, 0.6F, null, b.a.agWX, null, 20));
    ((Map)UlT).put(Integer.valueOf(n.a.agYq.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXi, 0.6F, null, b.a.agWY, null, 20));
    ((Map)UlT).put(Integer.valueOf(n.a.agYr.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXm, 0.5F, null, null, null, 28));
    ((Map)UlT).put(Integer.valueOf(n.a.agYs.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXl, 1.0F, null, null, null, 28));
    localArrayList.add(a(b.c.agXk, 0.5F, null, null, null, 28));
    ((Map)UlT).put(Integer.valueOf(n.a.agYt.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXh, 0.3F, null, null, null, 28));
    localArrayList.add(a(b.c.agXm, 0.5F, null, null, null, 28));
    ((Map)UlT).put(Integer.valueOf(n.a.agYu.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXh, 0.5F, null, null, null, 28));
    ((Map)UlT).put(Integer.valueOf(n.a.agYv.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXk, 0.3F, null, null, null, 28));
    localArrayList.add(a(b.c.agXi, 0.2F, null, b.a.agWW, null, 20));
    ((Map)UlT).put(Integer.valueOf(n.a.agYw.ordinal()), localArrayList);
    localArrayList = new ArrayList();
    localArrayList.add(a(b.c.agXl, 0.0F, null, null, null, 28));
    localArrayList.add(a(b.c.agXh, 0.6F, null, null, null, 28));
    ((Map)UlT).put(Integer.valueOf(n.a.agYx.ordinal()), localArrayList);
    AppMethodBeat.o(283386);
  }
  
  private static List<com.tencent.mm.xeffect.b> Q(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(283340);
    s.u(paramJSONArray, "jsonArray");
    ArrayList localArrayList = new ArrayList();
    int k = paramJSONArray.length();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
      s.s(localJSONObject, "jsonArray.getJSONObject(i)");
      localArrayList.add(bY(localJSONObject));
      if (j >= k)
      {
        paramJSONArray = (List)localArrayList;
        AppMethodBeat.o(283340);
        return paramJSONArray;
      }
      i = j;
    }
  }
  
  private HashMap<Integer, List<com.tencent.mm.xeffect.b>> R(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(283354);
    s.u(paramJSONArray, "json");
    HashMap localHashMap = new HashMap();
    int k = paramJSONArray.length();
    int i = 0;
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject = paramJSONArray.getJSONObject(i);
      i = ((JSONObject)localObject).optInt("scene", -1);
      localObject = ((JSONObject)localObject).optJSONArray("filters");
      if ((i >= 0) && (localObject != null))
      {
        localObject = Q((JSONArray)localObject);
        ((Map)localHashMap).put(Integer.valueOf(i), localObject);
      }
      if (j >= k)
      {
        AppMethodBeat.o(283354);
        return localHashMap;
      }
      i = j;
    }
  }
  
  private static JSONObject a(com.tencent.mm.xeffect.b paramb)
  {
    AppMethodBeat.i(283310);
    s.u(paramb, "info");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("type", paramb.agWP.ordinal());
    localJSONObject.put("filterWeight", Float.valueOf(paramb.agWQ));
    localJSONObject.put("filterPath", paramb.mUY);
    localJSONObject.put("builtinLutFilterType", paramb.agWR.ordinal());
    JSONArray localJSONArray = new JSONArray();
    paramb = paramb.agWS;
    s.s(paramb, "info.filterWeights");
    int j = paramb.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(Float.valueOf(paramb[i]));
      i += 1;
    }
    localJSONObject.put("filterWeights", localJSONArray);
    AppMethodBeat.o(283310);
    return localJSONObject;
  }
  
  public static void a(n paramn)
  {
    AppMethodBeat.i(283298);
    String str = y.bEn(UlS);
    s.s(str, "json");
    if (((CharSequence)str).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (paramn != null)) {
        paramn.bEY(str);
      }
      AppMethodBeat.o(283298);
      return;
    }
  }
  
  public static String apN(int paramInt)
  {
    AppMethodBeat.i(283290);
    Object localObject = MMApplicationContext.getContext();
    if (paramInt == n.a.agYm.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_pet);
      s.s(localObject, "context.getString(R.string.video_label_pet)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYn.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_people);
      s.s(localObject, "context.getString(R.string.video_label_people)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYo.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_food);
      s.s(localObject, "context.getString(R.string.video_label_food)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYp.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_plant);
      s.s(localObject, "context.getString(R.string.video_label_plant)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYq.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_flower);
      s.s(localObject, "context.getString(R.string.video_label_flower)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYr.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_sky);
      s.s(localObject, "context.getString(R.string.video_label_sky)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYs.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_sunrisesunset);
      s.s(localObject, "context.getString(R.stri…ideo_label_sunrisesunset)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYt.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_snow);
      s.s(localObject, "context.getString(R.string.video_label_snow)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYu.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_city);
      s.s(localObject, "context.getString(R.string.video_label_city)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYv.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_night);
      s.s(localObject, "context.getString(R.string.video_label_night)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYw.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_room);
      s.s(localObject, "context.getString(R.string.video_label_room)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYx.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_doc);
      s.s(localObject, "context.getString(R.string.video_label_doc)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    if (paramInt == n.a.agYy.ordinal())
    {
      localObject = ((Context)localObject).getString(a.i.video_label_origin);
      s.s(localObject, "context.getString(R.string.video_label_origin)");
      AppMethodBeat.o(283290);
      return localObject;
    }
    AppMethodBeat.o(283290);
    return "Unknown type";
  }
  
  private static com.tencent.mm.xeffect.b bY(JSONObject paramJSONObject)
  {
    int j = 0;
    AppMethodBeat.i(283322);
    s.u(paramJSONObject, "json");
    com.tencent.mm.xeffect.b localb = new com.tencent.mm.xeffect.b();
    int k = paramJSONObject.optInt("type", 0);
    Object localObject2 = b.c.values();
    int m = localObject2.length;
    int i = 0;
    Object localObject1;
    if (i < m)
    {
      localObject1 = localObject2[i];
      if (((b.c)localObject1).ordinal() == k)
      {
        label66:
        localb.agWP = ((b.c)localObject1);
        localb.agWQ = ((float)paramJSONObject.optDouble("filterWeight", 0.0D));
        localb.mUY = paramJSONObject.optString("filterPath");
        k = paramJSONObject.optInt("builtinLutFilterType", 0);
        localObject2 = b.a.values();
        m = localObject2.length;
        i = 0;
        label120:
        if (i >= m) {
          break label237;
        }
        localObject1 = localObject2[i];
        if (((b.a)localObject1).ordinal() != k) {
          break label230;
        }
      }
    }
    for (;;)
    {
      localb.agWR = ((b.a)localObject1);
      paramJSONObject = paramJSONObject.optJSONArray("filterWeights");
      if (paramJSONObject != null)
      {
        localb.agWS = new float[paramJSONObject.length()];
        k = paramJSONObject.length();
        if (k > 0)
        {
          i = j;
          do
          {
            j = i + 1;
            localb.agWS[i] = ((float)paramJSONObject.getDouble(i));
            i = j;
          } while (j < k);
        }
      }
      AppMethodBeat.o(283322);
      return localb;
      i += 1;
      break;
      localObject1 = b.c.agXo;
      break label66;
      label230:
      i += 1;
      break label120;
      label237:
      localObject1 = b.a.agWT;
    }
  }
  
  public static HashMap<Integer, List<com.tencent.mm.xeffect.b>> hTL()
  {
    return UlU;
  }
  
  public static void hTM()
  {
    AppMethodBeat.i(283267);
    Object localObject1 = (List)UlU.get(Integer.valueOf(n.a.agYn.ordinal()));
    Object localObject2;
    int i;
    if (localObject1 != null)
    {
      localObject2 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject2).hasNext()) {
        break label203;
      }
      localObject1 = ((Iterator)localObject2).next();
      if (((com.tencent.mm.xeffect.b)localObject1).agWP != b.c.agXn) {
        break label198;
      }
      i = 1;
      label70:
      if (i == 0) {
        break label201;
      }
      label74:
      localObject2 = (com.tencent.mm.xeffect.b)localObject1;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.xeffect.b)localObject2).agWS.length != Umb.length) {
          break label208;
        }
        localObject1 = ((com.tencent.mm.xeffect.b)localObject2).agWS;
        s.s(localObject1, "it.filterWeights");
        k.a((float[])localObject1, Umb, 0, 14);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "loadFaceBeautySettings, skinSmooth:" + UlV + ", skinBright:" + UlY + ", faceMorph:" + UlX + ", eyeBright:" + UlZ + ", eyeMorph:" + UlW);
      AppMethodBeat.o(283267);
      return;
      label198:
      i = 0;
      break label70;
      label201:
      break;
      label203:
      localObject1 = null;
      break label74;
      label208:
      ((com.tencent.mm.xeffect.b)localObject2).agWS = new float[Umb.length];
      localObject1 = Umb;
      localObject2 = ((com.tencent.mm.xeffect.b)localObject2).agWS;
      s.s(localObject2, "it.filterWeights");
      k.a((float[])localObject1, (float[])localObject2, 0, 14);
    }
  }
  
  public static boolean hTQ()
  {
    AppMethodBeat.i(283367);
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(283367);
      return true;
    }
    AppMethodBeat.o(283367);
    return false;
  }
  
  public static boolean hTR()
  {
    AppMethodBeat.i(283375);
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SCENE_INT_SYNC", 0) == 1)
    {
      AppMethodBeat.o(283375);
      return true;
    }
    AppMethodBeat.o(283375);
    return false;
  }
  
  private static JSONArray lQ(List<? extends com.tencent.mm.xeffect.b> paramList)
  {
    AppMethodBeat.i(283332);
    s.u(paramList, "filtersInfo");
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(a((com.tencent.mm.xeffect.b)paramList.next()));
    }
    AppMethodBeat.o(283332);
    return localJSONArray;
  }
  
  private static JSONArray w(HashMap<Integer, List<com.tencent.mm.xeffect.b>> paramHashMap)
  {
    AppMethodBeat.i(283346);
    s.u(paramHashMap, "sceneFiltersInfoMap");
    JSONArray localJSONArray = new JSONArray();
    paramHashMap = ((Map)paramHashMap).entrySet().iterator();
    while (paramHashMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHashMap.next();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("scene", ((Number)localEntry.getKey()).intValue());
      localJSONObject.put("filters", lQ((List)localEntry.getValue()));
      localJSONArray.put(localJSONObject);
    }
    AppMethodBeat.o(283346);
    return localJSONArray;
  }
  
  private void x(HashMap<Integer, List<com.tencent.mm.xeffect.b>> paramHashMap)
  {
    AppMethodBeat.i(283360);
    s.u(paramHashMap, "infoMap");
    Object localObject = w(paramHashMap);
    paramHashMap = UlS;
    localObject = ((JSONArray)localObject).toString();
    s.s(localObject, "json.toString()");
    localObject = ((String)localObject).getBytes(d.UTF_8);
    s.s(localObject, "(this as java.lang.String).getBytes(charset)");
    y.f(paramHashMap, (byte[])localObject, localObject.length);
    AppMethodBeat.o(283360);
  }
  
  public final void hTN()
  {
    AppMethodBeat.i(283395);
    if (hTQ())
    {
      hTM();
      x(UlU);
    }
    String str = y.bEn(UlS);
    a locala = a.UbD;
    s.s(str, "settingsJson");
    a.bfh(str);
    AppMethodBeat.o(283395);
  }
  
  public final HashMap<Integer, List<com.tencent.mm.xeffect.b>> hTO()
  {
    AppMethodBeat.i(283401);
    try
    {
      HashMap localHashMap1 = R(new JSONArray(y.bEn(UlS)));
      AppMethodBeat.o(283401);
      return localHashMap1;
    }
    catch (Exception localException)
    {
      HashMap localHashMap2 = UlT;
      AppMethodBeat.o(283401);
      return localHashMap2;
    }
  }
  
  public final void hTP()
  {
    AppMethodBeat.i(283416);
    int n = c.a.zrT.ordinal();
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    int m = i + 1;
    Object localObject2 = c.a.values();
    int i1 = localObject2.length;
    int j = 0;
    label42:
    Object localObject1;
    int k;
    if (j < i1)
    {
      localObject1 = localObject2[j];
      if (((c.a)localObject1).ordinal() == n + i)
      {
        k = 1;
        label68:
        if (k == 0) {
          break label376;
        }
        label72:
        localObject1 = ((c)h.ax(c.class)).a((c.a)localObject1, "");
        Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "scene_config_" + i + " json:" + localObject1);
        s.s(localObject1, "sceneJson");
        if (((CharSequence)localObject1).length() <= 0) {
          break label389;
        }
        j = 1;
        label150:
        if (j == 0) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "parse scene_config_" + i + " len:" + ((JSONArray)localObject1).length());
        if (((JSONArray)localObject1).length() > 0)
        {
          k = ((JSONArray)localObject1).length();
          if (k > 0)
          {
            i = 0;
            j = i + 1;
            localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if (localObject2 != null) {
              localJSONArray.put(localObject2);
            }
            if (j < k) {
              break label405;
            }
          }
        }
      }
      catch (Exception localException)
      {
        label376:
        continue;
        label389:
        i = m;
      }
      if (m >= 5)
      {
        Log.i("MicroMsg.ImageEnhancementFilterSettingLogic", "finalConfigJson:" + localJSONArray + ", save to file:" + UlS);
        localObject1 = UlS;
        localObject2 = localJSONArray.toString();
        s.s(localObject2, "finalConfigJson.toString()");
        localObject2 = ((String)localObject2).getBytes(d.UTF_8);
        s.s(localObject2, "(this as java.lang.String).getBytes(charset)");
        y.f((String)localObject1, (byte[])localObject2, localObject2.length);
        UlU.clear();
        UlU.putAll((Map)R(localJSONArray));
        AppMethodBeat.o(283416);
        return;
        k = 0;
        break label68;
        j += 1;
        break label42;
        localObject1 = null;
        break label72;
        j = 0;
        break label150;
      }
      break;
      label405:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b
 * JD-Core Version:    0.7.0.1
 */