package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/StickerInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "elements", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sticker/StickerElement;", "Lkotlin/collections/HashMap;", "getElements", "()Ljava/util/HashMap;", "setElements", "(Ljava/util/HashMap;)V", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "type", "getType", "setType", "version", "", "getVersion", "()D", "setVersion", "(D)V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "needFaceAction", "", "needGesture", "toJson", "Companion", "plugin-sticker_release"})
public final class e
  extends a
{
  private static final int GAa = 11;
  private static final int GAb = 12;
  private static final int GAc = 13;
  private static final int GAd = 14;
  private static final int GAe = 15;
  private static final int GAf = 16;
  private static final int GAg = 17;
  private static final int GAh = 100;
  private static final int GAi = 101;
  private static final int GAj = 102;
  private static final int GAk = 103;
  private static final int GAl = 104;
  private static final int GAm = 105;
  private static final int GAn = 106;
  private static final int GAo = 107;
  private static final int GAp = 108;
  private static final int GAq = 109;
  private static final int GAr = 110;
  private static final int GAs = 111;
  private static final int GAt = 112;
  private static final int GAu = 199;
  public static final e.a GAv;
  private static final int GzZ = 10;
  public String GzW;
  g GzX;
  public HashMap<String, d> GzY;
  double bDF;
  private String pmO;
  public String type;
  
  static
  {
    AppMethodBeat.i(105902);
    GAv = new e.a((byte)0);
    GzZ = 10;
    GAa = 11;
    GAb = 12;
    GAc = 13;
    GAd = 14;
    GAe = 15;
    GAf = 16;
    GAg = 17;
    GAh = 100;
    GAi = 101;
    GAj = 102;
    GAk = 103;
    GAl = 104;
    GAm = 105;
    GAn = 106;
    GAo = 107;
    GAp = 108;
    GAq = 109;
    GAr = 110;
    GAs = 111;
    GAt = 112;
    GAu = 199;
    AppMethodBeat.o(105902);
  }
  
  public e()
  {
    AppMethodBeat.i(105901);
    this.pmO = "";
    this.type = "Sticker2D";
    this.GzW = "";
    this.GzX = new g();
    this.GzY = new HashMap();
    AppMethodBeat.o(105901);
  }
  
  public final void aMr(String paramString)
  {
    AppMethodBeat.i(105893);
    k.h(paramString, "<set-?>");
    this.pmO = paramString;
    AppMethodBeat.o(105893);
  }
  
  public final void aMs(String paramString)
  {
    AppMethodBeat.i(105895);
    k.h(paramString, "<set-?>");
    this.GzW = paramString;
    AppMethodBeat.o(105895);
  }
  
  public final a by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105899);
    k.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.getString("id");
    k.g(localObject, "jsonObj.getString(\"id\")");
    this.pmO = ((String)localObject);
    this.bDF = paramJSONObject.optDouble("version", this.bDF);
    localObject = paramJSONObject.optString("type", this.type);
    k.g(localObject, "jsonObj.optString(\"type\", type)");
    this.type = ((String)localObject);
    localObject = paramJSONObject.getJSONObject("params");
    JSONArray localJSONArray = ((JSONObject)localObject).getJSONArray("elements");
    int j = localJSONArray.length();
    int i = 0;
    while (i < j)
    {
      String str = localJSONArray.getString(i);
      JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject(str);
      d locald = new d();
      k.g(str, "name");
      locald.setName(str);
      k.g(localJSONObject, "elementObj");
      locald.by(localJSONObject);
      ((Map)this.GzY).put(str, locald);
      i += 1;
    }
    paramJSONObject = super.by(paramJSONObject);
    AppMethodBeat.o(105899);
    return paramJSONObject;
  }
  
  public final boolean eXX()
  {
    AppMethodBeat.i(105897);
    Object localObject = this.GzY.values();
    k.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label104:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).GzR;
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
  
  public final boolean eXY()
  {
    AppMethodBeat.i(105898);
    Object localObject = this.GzY.values();
    k.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label103:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).GzR;
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
  
  public final void o(HashMap<String, d> paramHashMap)
  {
    AppMethodBeat.i(105896);
    k.h(paramHashMap, "<set-?>");
    this.GzY = paramHashMap;
    AppMethodBeat.o(105896);
  }
  
  public final void setType(String paramString)
  {
    AppMethodBeat.i(105894);
    k.h(paramString, "<set-?>");
    this.type = paramString;
    AppMethodBeat.o(105894);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105900);
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id", this.pmO);
    localJSONObject1.put("version", this.bDF);
    localJSONObject1.put("type", this.type);
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONArray();
    Iterator localIterator = ((Map)this.GzY).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      JSONObject localJSONObject3 = ((d)localEntry.getValue()).toJson();
      localJSONObject2.put((String)localEntry.getKey(), localJSONObject3);
    }
    localJSONObject2.put("elements", localObject);
    localObject = this.GzX;
    if (((g)localObject).GAB.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).GAC.length != 0) {
        break label272;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).GAD.length != 0) {
        break label277;
      }
      i = 1;
      label210:
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).GAE.length != 0) {
        break label282;
      }
      i = 1;
      label225:
      if (i == 0) {
        break label287;
      }
    }
    label272:
    label277:
    label282:
    label287:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localJSONObject2.put("template_trans_set", this.GzX.toJson());
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