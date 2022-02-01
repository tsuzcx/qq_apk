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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/StickerInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "elements", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sticker/StickerElement;", "Lkotlin/collections/HashMap;", "getElements", "()Ljava/util/HashMap;", "setElements", "(Ljava/util/HashMap;)V", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "type", "getType", "setType", "version", "", "getVersion", "()D", "setVersion", "(D)V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "needFaceAction", "", "needGesture", "toJson", "Companion", "plugin-sticker_release"})
public final class e
  extends a
{
  public static final e.a IGA;
  private static final int IGe = 10;
  private static final int IGf = 11;
  private static final int IGg = 12;
  private static final int IGh = 13;
  private static final int IGi = 14;
  private static final int IGj = 15;
  private static final int IGk = 16;
  private static final int IGl = 17;
  private static final int IGm = 100;
  private static final int IGn = 101;
  private static final int IGo = 102;
  private static final int IGp = 103;
  private static final int IGq = 104;
  private static final int IGr = 105;
  private static final int IGs = 106;
  private static final int IGt = 107;
  private static final int IGu = 108;
  private static final int IGv = 109;
  private static final int IGw = 110;
  private static final int IGx = 111;
  private static final int IGy = 112;
  private static final int IGz = 199;
  public String IGb;
  g IGc;
  public HashMap<String, d> IGd;
  double bNT;
  private String pWT;
  public String type;
  
  static
  {
    AppMethodBeat.i(105902);
    IGA = new e.a((byte)0);
    IGe = 10;
    IGf = 11;
    IGg = 12;
    IGh = 13;
    IGi = 14;
    IGj = 15;
    IGk = 16;
    IGl = 17;
    IGm = 100;
    IGn = 101;
    IGo = 102;
    IGp = 103;
    IGq = 104;
    IGr = 105;
    IGs = 106;
    IGt = 107;
    IGu = 108;
    IGv = 109;
    IGw = 110;
    IGx = 111;
    IGy = 112;
    IGz = 199;
    AppMethodBeat.o(105902);
  }
  
  public e()
  {
    AppMethodBeat.i(105901);
    this.pWT = "";
    this.type = "Sticker2D";
    this.IGb = "";
    this.IGc = new g();
    this.IGd = new HashMap();
    AppMethodBeat.o(105901);
  }
  
  public final void aTv(String paramString)
  {
    AppMethodBeat.i(105893);
    p.h(paramString, "<set-?>");
    this.pWT = paramString;
    AppMethodBeat.o(105893);
  }
  
  public final void aTw(String paramString)
  {
    AppMethodBeat.i(105895);
    p.h(paramString, "<set-?>");
    this.IGb = paramString;
    AppMethodBeat.o(105895);
  }
  
  public final a bH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105899);
    p.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.getString("id");
    p.g(localObject, "jsonObj.getString(\"id\")");
    this.pWT = ((String)localObject);
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
      ((Map)this.IGd).put(str, locald);
      i += 1;
    }
    paramJSONObject = super.bH(paramJSONObject);
    AppMethodBeat.o(105899);
    return paramJSONObject;
  }
  
  public final boolean frA()
  {
    AppMethodBeat.i(105897);
    Object localObject = this.IGd.values();
    p.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label104:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).IFW;
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
  
  public final boolean frB()
  {
    AppMethodBeat.i(105898);
    Object localObject = this.IGd.values();
    p.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label103:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).IFW;
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
  
  public final void p(HashMap<String, d> paramHashMap)
  {
    AppMethodBeat.i(105896);
    p.h(paramHashMap, "<set-?>");
    this.IGd = paramHashMap;
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
    localJSONObject1.put("id", this.pWT);
    localJSONObject1.put("version", this.bNT);
    localJSONObject1.put("type", this.type);
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONArray();
    Iterator localIterator = ((Map)this.IGd).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      JSONObject localJSONObject3 = ((d)localEntry.getValue()).toJson();
      localJSONObject2.put((String)localEntry.getKey(), localJSONObject3);
    }
    localJSONObject2.put("elements", localObject);
    localObject = this.IGc;
    if (((g)localObject).IGG.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).IGH.length != 0) {
        break label272;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).IGI.length != 0) {
        break label277;
      }
      i = 1;
      label210:
      if (i == 0) {
        break label287;
      }
      if (((g)localObject).IGJ.length != 0) {
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
        localJSONObject2.put("template_trans_set", this.IGc.toJson());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.e
 * JD-Core Version:    0.7.0.1
 */