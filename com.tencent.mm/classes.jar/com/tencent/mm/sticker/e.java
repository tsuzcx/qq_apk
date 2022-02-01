package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/StickerInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "elements", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sticker/StickerElement;", "Lkotlin/collections/HashMap;", "getElements", "()Ljava/util/HashMap;", "setElements", "(Ljava/util/HashMap;)V", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "type", "getType", "setType", "version", "", "getVersion", "()D", "setVersion", "(D)V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "needFaceAction", "", "needGesture", "toJson", "Companion", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends a
{
  public static final e.a acBV;
  private static final int acBY;
  private static final int acBZ;
  private static final int acCa;
  private static final int acCb;
  private static final int acCc;
  private static final int acCd;
  private static final int acCe;
  private static final int acCf;
  private static final int acCg;
  private static final int acCh;
  private static final int acCi;
  private static final int acCj;
  private static final int acCk;
  private static final int acCl;
  private static final int acCm;
  private static final int acCn;
  private static final int acCo;
  private static final int acCp;
  private static final int acCq;
  private static final int acCr;
  private static final int acCs;
  private static final int acCt;
  private g acBW;
  public HashMap<String, d> acBX;
  public double dFr;
  public String eBX;
  public String type;
  String ygo;
  
  static
  {
    AppMethodBeat.i(105902);
    acBV = new e.a((byte)0);
    acBY = 10;
    acBZ = 11;
    acCa = 12;
    acCb = 13;
    acCc = 14;
    acCd = 15;
    acCe = 16;
    acCf = 17;
    acCg = 100;
    acCh = 101;
    acCi = 102;
    acCj = 103;
    acCk = 104;
    acCl = 105;
    acCm = 106;
    acCn = 107;
    acCo = 108;
    acCp = 109;
    acCq = 110;
    acCr = 111;
    acCs = 112;
    acCt = 199;
    AppMethodBeat.o(105902);
  }
  
  public e()
  {
    AppMethodBeat.i(105901);
    this.ygo = "";
    this.type = "Sticker2D";
    this.eBX = "";
    this.acBW = new g();
    this.acBX = new HashMap();
    AppMethodBeat.o(105901);
  }
  
  public final a G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105899);
    s.u(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optString("id", "");
    s.s(localObject, "jsonObj.optString(\"id\", \"\")");
    this.ygo = ((String)localObject);
    this.dFr = paramJSONObject.optDouble("version", this.dFr);
    localObject = paramJSONObject.optString("type", this.type);
    s.s(localObject, "jsonObj.optString(\"type\", type)");
    this.type = ((String)localObject);
    JSONObject localJSONObject1 = paramJSONObject.optJSONObject("params");
    int i;
    int k;
    if (localJSONObject1 == null)
    {
      localObject = null;
      if (localObject != null)
      {
        i = 0;
        k = ((JSONArray)localObject).length();
        if (k <= 0) {}
      }
    }
    for (;;)
    {
      int j = i + 1;
      String str = ((JSONArray)localObject).getString(i);
      JSONObject localJSONObject2 = localJSONObject1.getJSONObject(str);
      d locald = new d();
      s.s(str, "name");
      locald.setName(str);
      s.s(localJSONObject2, "elementObj");
      locald.G(localJSONObject2);
      ((Map)this.acBX).put(str, locald);
      if (j >= k)
      {
        paramJSONObject = super.G(paramJSONObject);
        AppMethodBeat.o(105899);
        return paramJSONObject;
        localObject = localJSONObject1.optJSONArray("elements");
        break;
      }
      i = j;
    }
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(233926);
    s.u(paramg, "<set-?>");
    this.acBW = paramg;
    AppMethodBeat.o(233926);
  }
  
  public final void buM(String paramString)
  {
    AppMethodBeat.i(105895);
    s.u(paramString, "<set-?>");
    this.eBX = paramString;
    AppMethodBeat.o(105895);
  }
  
  public final boolean iWc()
  {
    AppMethodBeat.i(105897);
    Object localObject = this.acBX.values();
    s.s(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if (!((Collection)localObject).isEmpty())
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).acBQ;
        if (100 <= i) {
          if (i <= 199) {
            i = 1;
          }
        }
        while (i != 0)
        {
          AppMethodBeat.o(105897);
          return true;
          i = 0;
          continue;
          i = 0;
        }
      }
    }
    AppMethodBeat.o(105897);
    return false;
  }
  
  public final boolean iWd()
  {
    AppMethodBeat.i(105898);
    Object localObject = this.acBX.values();
    s.s(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if (!((Collection)localObject).isEmpty())
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).acBQ;
        if (10 <= i) {
          if (i <= 17) {
            i = 1;
          }
        }
        while (i != 0)
        {
          AppMethodBeat.o(105898);
          return true;
          i = 0;
          continue;
          i = 0;
        }
      }
    }
    AppMethodBeat.o(105898);
    return false;
  }
  
  public final void setType(String paramString)
  {
    AppMethodBeat.i(105894);
    s.u(paramString, "<set-?>");
    this.type = paramString;
    AppMethodBeat.o(105894);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105900);
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id", this.ygo);
    localJSONObject1.put("version", this.dFr);
    localJSONObject1.put("type", this.type);
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONArray();
    Iterator localIterator = ((Map)this.acBX).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      JSONObject localJSONObject3 = ((d)localEntry.getValue()).toJson();
      localJSONObject2.put((String)localEntry.getKey(), localJSONObject3);
    }
    localJSONObject2.put("elements", localObject);
    localObject = this.acBW;
    if (((g)localObject).acCC.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).acCD.length != 0) {
        break label271;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).acCE.length != 0) {
        break label276;
      }
      i = 1;
      label210:
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).acCF.length != 0) {
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
        localJSONObject2.put("template_trans_set", this.acBW.toJson());
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
  
  public final void y(HashMap<String, d> paramHashMap)
  {
    AppMethodBeat.i(105896);
    s.u(paramHashMap, "<set-?>");
    this.acBX = paramHashMap;
    AppMethodBeat.o(105896);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.e
 * JD-Core Version:    0.7.0.1
 */