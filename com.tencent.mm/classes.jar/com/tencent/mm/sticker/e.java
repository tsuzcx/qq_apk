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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/StickerInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "elements", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sticker/StickerElement;", "Lkotlin/collections/HashMap;", "getElements", "()Ljava/util/HashMap;", "setElements", "(Ljava/util/HashMap;)V", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "type", "getType", "setType", "version", "", "getVersion", "()D", "setVersion", "(D)V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "needFaceAction", "", "needGesture", "toJson", "Companion", "plugin-sticker_release"})
public final class e
  extends a
{
  private static final int VaE = 10;
  private static final int VaF = 11;
  private static final int VaG = 12;
  private static final int VaH = 13;
  private static final int VaI = 14;
  private static final int VaJ = 15;
  private static final int VaK = 16;
  private static final int VaL = 17;
  private static final int VaM = 100;
  private static final int VaN = 101;
  private static final int VaO = 102;
  private static final int VaP = 103;
  private static final int VaQ = 104;
  private static final int VaR = 105;
  private static final int VaS = 106;
  private static final int VaT = 107;
  private static final int VaU = 108;
  private static final int VaV = 109;
  private static final int VaW = 110;
  private static final int VaX = 111;
  private static final int VaY = 112;
  private static final int VaZ = 199;
  public static final a Vba;
  private g VaC;
  public HashMap<String, d> VaD;
  public double bLJ;
  public String cIr;
  public String type;
  String uTz;
  
  static
  {
    AppMethodBeat.i(105902);
    Vba = new a((byte)0);
    VaE = 10;
    VaF = 11;
    VaG = 12;
    VaH = 13;
    VaI = 14;
    VaJ = 15;
    VaK = 16;
    VaL = 17;
    VaM = 100;
    VaN = 101;
    VaO = 102;
    VaP = 103;
    VaQ = 104;
    VaR = 105;
    VaS = 106;
    VaT = 107;
    VaU = 108;
    VaV = 109;
    VaW = 110;
    VaX = 111;
    VaY = 112;
    VaZ = 199;
    AppMethodBeat.o(105902);
  }
  
  public e()
  {
    AppMethodBeat.i(105901);
    this.uTz = "";
    this.type = "Sticker2D";
    this.cIr = "";
    this.VaC = new g();
    this.VaD = new HashMap();
    AppMethodBeat.o(105901);
  }
  
  public final void a(g paramg)
  {
    AppMethodBeat.i(232723);
    p.k(paramg, "<set-?>");
    this.VaC = paramg;
    AppMethodBeat.o(232723);
  }
  
  public final a ay(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105899);
    p.k(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optString("id", "");
    p.j(localObject, "jsonObj.optString(\"id\", \"\")");
    this.uTz = ((String)localObject);
    this.bLJ = paramJSONObject.optDouble("version", this.bLJ);
    localObject = paramJSONObject.optString("type", this.type);
    p.j(localObject, "jsonObj.optString(\"type\", type)");
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
        p.j(str, "name");
        locald.setName(str);
        p.j(localJSONObject2, "elementObj");
        locald.ay(localJSONObject2);
        ((Map)this.VaD).put(str, locald);
        i += 1;
      }
    }
    paramJSONObject = super.ay(paramJSONObject);
    AppMethodBeat.o(105899);
    return paramJSONObject;
  }
  
  public final void buG(String paramString)
  {
    AppMethodBeat.i(105895);
    p.k(paramString, "<set-?>");
    this.cIr = paramString;
    AppMethodBeat.o(105895);
  }
  
  public final boolean huA()
  {
    AppMethodBeat.i(105897);
    Object localObject = this.VaD.values();
    p.j(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label104:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).Vax;
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
  
  public final boolean huB()
  {
    AppMethodBeat.i(105898);
    Object localObject = this.VaD.values();
    p.j(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label103:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((d)((Iterator)localObject).next()).Vax;
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
  
  public final void setType(String paramString)
  {
    AppMethodBeat.i(105894);
    p.k(paramString, "<set-?>");
    this.type = paramString;
    AppMethodBeat.o(105894);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105900);
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("id", this.uTz);
    localJSONObject1.put("version", this.bLJ);
    localJSONObject1.put("type", this.type);
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONArray();
    Iterator localIterator = ((Map)this.VaD).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      JSONObject localJSONObject3 = ((d)localEntry.getValue()).toJson();
      localJSONObject2.put((String)localEntry.getKey(), localJSONObject3);
    }
    localJSONObject2.put("elements", localObject);
    localObject = this.VaC;
    if (((g)localObject).Vbj.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).Vbk.length != 0) {
        break label271;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).Vbl.length != 0) {
        break label276;
      }
      i = 1;
      label210:
      if (i == 0) {
        break label286;
      }
      if (((g)localObject).Vbm.length != 0) {
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
        localJSONObject2.put("template_trans_set", this.VaC.toJson());
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
  
  public final void v(HashMap<String, d> paramHashMap)
  {
    AppMethodBeat.i(105896);
    p.k(paramHashMap, "<set-?>");
    this.VaD = paramHashMap;
    AppMethodBeat.o(105896);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/StickerInfo$Companion;", "", "()V", "ACTION_EYEBROW_UP", "", "getACTION_EYEBROW_UP", "()I", "ACTION_EYE_BLINK", "getACTION_EYE_BLINK", "ACTION_HEAD_NOD", "getACTION_HEAD_NOD", "ACTION_HEAD_SHAKE", "getACTION_HEAD_SHAKE", "ACTION_LEFTEYE_BLINK", "getACTION_LEFTEYE_BLINK", "ACTION_MOUTH_KISS", "getACTION_MOUTH_KISS", "ACTION_MOUTH_OPEN", "getACTION_MOUTH_OPEN", "ACTION_RIGHTEYE_BLINK", "getACTION_RIGHTEYE_BLINK", "HAND_ACTION_EIGHT", "getHAND_ACTION_EIGHT", "HAND_ACTION_FIST", "getHAND_ACTION_FIST", "HAND_ACTION_GOOD_FORTUNE", "getHAND_ACTION_GOOD_FORTUNE", "HAND_ACTION_HEART", "getHAND_ACTION_HEART", "HAND_ACTION_LIFT", "getHAND_ACTION_LIFT", "HAND_ACTION_LIKE", "getHAND_ACTION_LIKE", "HAND_ACTION_LOVE", "getHAND_ACTION_LOVE", "HAND_ACTION_OK", "getHAND_ACTION_OK", "HAND_ACTION_ONE", "getHAND_ACTION_ONE", "HAND_ACTION_PAPER", "getHAND_ACTION_PAPER", "HAND_ACTION_REJECT", "getHAND_ACTION_REJECT", "HAND_ACTION_ROCK", "getHAND_ACTION_ROCK", "HAND_ACTION_SCISSOR", "getHAND_ACTION_SCISSOR", "HAND_ACTION_SIX", "getHAND_ACTION_SIX", "plugin-sticker_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.e
 * JD-Core Version:    0.7.0.1
 */