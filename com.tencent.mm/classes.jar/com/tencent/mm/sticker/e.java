package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/StickerInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "elements", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sticker/StickerElement;", "Lkotlin/collections/HashMap;", "getElements", "()Ljava/util/HashMap;", "setElements", "(Ljava/util/HashMap;)V", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "type", "getType", "setType", "version", "", "getVersion", "()D", "setVersion", "(D)V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "needFaceAction", "", "needGesture", "toJson", "Companion", "plugin-sticker_release"})
public final class e
  extends a
{
  private static final int IlT = 10;
  private static final int IlU = 11;
  private static final int IlV = 12;
  private static final int IlW = 13;
  private static final int IlX = 14;
  private static final int IlY = 15;
  private static final int IlZ = 16;
  private static final int Ima = 17;
  private static final int Imb = 100;
  private static final int Imc = 101;
  private static final int Imd = 102;
  private static final int Ime = 103;
  private static final int Imf = 104;
  private static final int Img = 105;
  private static final int Imh = 106;
  private static final int Imi = 107;
  private static final int Imj = 108;
  private static final int Imk = 109;
  private static final int Iml = 110;
  private static final int Imm = 111;
  private static final int Imn = 112;
  private static final int Imo = 199;
  public static final e.a Imp;
  public String IlQ;
  g IlR;
  public HashMap<String, d> IlS;
  double bNT;
  private String pQo;
  public String type;
  
  static
  {
    AppMethodBeat.i(105902);
    Imp = new e.a((byte)0);
    IlT = 10;
    IlU = 11;
    IlV = 12;
    IlW = 13;
    IlX = 14;
    IlY = 15;
    IlZ = 16;
    Ima = 17;
    Imb = 100;
    Imc = 101;
    Imd = 102;
    Ime = 103;
    Imf = 104;
    Img = 105;
    Imh = 106;
    Imi = 107;
    Imj = 108;
    Imk = 109;
    Iml = 110;
    Imm = 111;
    Imn = 112;
    Imo = 199;
    AppMethodBeat.o(105902);
  }
  
  public e()
  {
    AppMethodBeat.i(105901);
    this.pQo = "";
    this.type = "Sticker2D";
    this.IlQ = "";
    this.IlR = new g();
    this.IlS = new HashMap();
    AppMethodBeat.o(105901);
  }
  
  public final void aRY(String paramString)
  {
    AppMethodBeat.i(105893);
    p.h(paramString, "<set-?>");
    this.pQo = paramString;
    AppMethodBeat.o(105893);
  }
  
  public final void aRZ(String paramString)
  {
    AppMethodBeat.i(105895);
    p.h(paramString, "<set-?>");
    this.IlQ = paramString;
    AppMethodBeat.o(105895);
  }
  
  public final a bH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105899);
    p.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.getString("id");
    p.g(localObject, "jsonObj.getString(\"id\")");
    this.pQo = ((String)localObject);
    this.bNT = paramJSONObject.optDouble("version", this.bNT);
    localObject = paramJSONObject.optString("type", this.type);
    p.g(localObject, "jsonObj.optString(\"type\", type)");
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
      p.g(str, "name");
      locald.setName(str);
      p.g(localJSONObject, "elementObj");
      locald.bH(localJSONObject);
      ((Map)this.IlS).put(str, locald);
      i += 1;
    }
    paramJSONObject = super.bH(paramJSONObject);
    AppMethodBeat.o(105899);
    return paramJSONObject;
  }
  
  public final boolean fnH()
  {
    AppMethodBeat.i(105897);
    Object localObject = this.IlS.values();
    p.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label104:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).IlL;
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
  
  public final boolean fnI()
  {
    AppMethodBeat.i(105898);
    Object localObject = this.IlS.values();
    p.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label103:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).IlL;
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
    p.h(paramHashMap, "<set-?>");
    this.IlS = paramHashMap;
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
    localJSONObject1.put("id", this.pQo);
    localJSONObject1.put("version", this.bNT);
    localJSONObject1.put("type", this.type);
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONArray();
    Iterator localIterator = ((Map)this.IlS).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      JSONObject localJSONObject3 = ((d)localEntry.getValue()).toJson();
      localJSONObject2.put((String)localEntry.getKey(), localJSONObject3);
    }
    localJSONObject2.put("elements", localObject);
    localObject = this.IlR;
    if (((g)localObject).Imv.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).Imw.length != 0) {
        break label272;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).Imx.length != 0) {
        break label277;
      }
      i = 1;
      label210:
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).Imy.length != 0) {
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
        localJSONObject2.put("template_trans_set", this.IlR.toJson());
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