package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/StickerInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "elements", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sticker/StickerElement;", "Lkotlin/collections/HashMap;", "getElements", "()Ljava/util/HashMap;", "setElements", "(Ljava/util/HashMap;)V", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "type", "getType", "setType", "version", "", "getVersion", "()D", "setVersion", "(D)V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "needFaceAction", "", "needGesture", "toJson", "Companion", "plugin-sticker_release"})
public final class e
  extends a
{
  private static final int NMU = 10;
  private static final int NMV = 11;
  private static final int NMW = 12;
  private static final int NMX = 13;
  private static final int NMY = 14;
  private static final int NMZ = 15;
  private static final int NNa = 16;
  private static final int NNb = 17;
  private static final int NNc = 100;
  private static final int NNd = 101;
  private static final int NNe = 102;
  private static final int NNf = 103;
  private static final int NNg = 104;
  private static final int NNh = 105;
  private static final int NNi = 106;
  private static final int NNj = 107;
  private static final int NNk = 108;
  private static final int NNl = 109;
  private static final int NNm = 110;
  private static final int NNn = 111;
  private static final int NNo = 112;
  private static final int NNp = 199;
  public static final e.a NNq;
  private g NMS;
  public HashMap<String, d> NMT;
  public String cHM;
  public double jgT;
  String rnS;
  public String type;
  
  static
  {
    AppMethodBeat.i(105902);
    NNq = new e.a((byte)0);
    NMU = 10;
    NMV = 11;
    NMW = 12;
    NMX = 13;
    NMY = 14;
    NMZ = 15;
    NNa = 16;
    NNb = 17;
    NNc = 100;
    NNd = 101;
    NNe = 102;
    NNf = 103;
    NNg = 104;
    NNh = 105;
    NNi = 106;
    NNj = 107;
    NNk = 108;
    NNl = 109;
    NNm = 110;
    NNn = 111;
    NNo = 112;
    NNp = 199;
    AppMethodBeat.o(105902);
  }
  
  public e()
  {
    AppMethodBeat.i(105901);
    this.rnS = "";
    this.type = "Sticker2D";
    this.cHM = "";
    this.NMS = new g();
    this.NMT = new HashMap();
    AppMethodBeat.o(105901);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(194215);
    p.h(paramg, "<set-?>");
    this.NMS = paramg;
    AppMethodBeat.o(194215);
  }
  
  public final a au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105899);
    p.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optString("id", "");
    p.g(localObject, "jsonObj.optString(\"id\", \"\")");
    this.rnS = ((String)localObject);
    this.jgT = paramJSONObject.optDouble("version", this.jgT);
    localObject = paramJSONObject.optString("type", this.type);
    p.g(localObject, "jsonObj.optString(\"type\", type)");
    this.type = ((String)localObject);
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("params");
    if (localJSONObject1 != null) {}
    for (localObject = localJSONObject1.optJSONArray("elements"); localObject != null; localObject = null)
    {
      int j = ((JSONArray)localObject).length();
      int i = 0;
      while (i < j)
      {
        String str = ((JSONArray)localObject).getString(i);
        JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str);
        d locald = new d();
        p.g(str, "name");
        locald.setName(str);
        p.g(localJSONObject2, "elementObj");
        locald.au(localJSONObject2);
        ((Map)this.NMT).put(str, locald);
        i += 1;
      }
    }
    paramJSONObject = super.au(paramJSONObject);
    AppMethodBeat.o(105899);
    return paramJSONObject;
  }
  
  public final void bip(String paramString)
  {
    AppMethodBeat.i(105895);
    p.h(paramString, "<set-?>");
    this.cHM = paramString;
    AppMethodBeat.o(105895);
  }
  
  public final boolean gyA()
  {
    AppMethodBeat.i(105897);
    Object localObject = this.NMT.values();
    p.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label104:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).NMN;
        if (100 > i) {}
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label104;
          }
          AppMethodBeat.o(105897);
          return true;
          if (199 < i) {
            break;
          }
        }
      }
    }
    AppMethodBeat.o(105897);
    return false;
  }
  
  public final boolean gyB()
  {
    AppMethodBeat.i(105898);
    Object localObject = this.NMT.values();
    p.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label103:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).NMN;
        if (10 > i) {}
        for (i = 0;; i = 1)
        {
          if (i == 0) {
            break label103;
          }
          AppMethodBeat.o(105898);
          return true;
          if (17 < i) {
            break;
          }
        }
      }
    }
    AppMethodBeat.o(105898);
    return false;
  }
  
  public final void s(HashMap<String, d> paramHashMap)
  {
    AppMethodBeat.i(105896);
    p.h(paramHashMap, "<set-?>");
    this.NMT = paramHashMap;
    AppMethodBeat.o(105896);
  }
  
  public final void setType(String paramString)
  {
    AppMethodBeat.i(105894);
    p.h(paramString, "<set-?>");
    this.type = paramString;
    AppMethodBeat.o(105894);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105900);
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id", this.rnS);
    localJSONObject1.put("version", this.jgT);
    localJSONObject1.put("type", this.type);
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONArray();
    Iterator localIterator = ((Map)this.NMT).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      JSONObject localJSONObject3 = ((d)localEntry.getValue()).toJson();
      localJSONObject2.put((String)localEntry.getKey(), localJSONObject3);
    }
    localJSONObject2.put("elements", localObject);
    localObject = this.NMS;
    if (((g)localObject).NNz.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).NNA.length != 0) {
        break label271;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).NNB.length != 0) {
        break label276;
      }
      i = 1;
      label210:
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).NNC.length != 0) {
        break label281;
      }
      i = 1;
      label225:
      if (i == 0) {
        break label286;
      }
    }
    label271:
    label276:
    label281:
    label286:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localJSONObject2.put("template_trans_set", this.NMS.toJson());
      }
      localJSONObject1.put("params", localJSONObject2);
      AppMethodBeat.o(105900);
      return localJSONObject1;
      i = 0;
      break;
      i = 0;
      break label195;
      i = 0;
      break label210;
      i = 0;
      break label225;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.e
 * JD-Core Version:    0.7.0.1
 */