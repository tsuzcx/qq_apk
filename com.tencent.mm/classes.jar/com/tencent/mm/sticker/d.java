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

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/StickerInfo;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "elements", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/sticker/StickerElement;", "Lkotlin/collections/HashMap;", "getElements", "()Ljava/util/HashMap;", "setElements", "(Ljava/util/HashMap;)V", "lensId", "getLensId", "()Ljava/lang/String;", "setLensId", "(Ljava/lang/String;)V", "resPath", "getResPath", "setResPath", "transform", "Lcom/tencent/mm/sticker/StickerTransform;", "getTransform", "()Lcom/tencent/mm/sticker/StickerTransform;", "setTransform", "(Lcom/tencent/mm/sticker/StickerTransform;)V", "type", "getType", "setType", "version", "", "getVersion", "()D", "setVersion", "(D)V", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "needFaceAction", "", "needGesture", "toJson", "Companion", "plugin-sticker_release"})
public final class d
  extends a
{
  private static final int FcC = 10;
  private static final int FcD = 11;
  private static final int FcE = 12;
  private static final int FcF = 13;
  private static final int FcG = 14;
  private static final int FcH = 15;
  private static final int FcI = 16;
  private static final int FcJ = 17;
  private static final int FcK = 100;
  private static final int FcL = 101;
  private static final int FcM = 102;
  private static final int FcN = 103;
  private static final int FcO = 104;
  private static final int FcP = 105;
  private static final int FcQ = 106;
  private static final int FcR = 107;
  private static final int FcS = 108;
  private static final int FcT = 109;
  private static final int FcU = 110;
  private static final int FcV = 111;
  private static final int FcW = 112;
  private static final int FcX = 199;
  public static final a FcY;
  f FcA;
  public HashMap<String, c> FcB;
  public String Fcz;
  double bFX;
  private String oJp;
  public String type;
  
  static
  {
    AppMethodBeat.i(105902);
    FcY = new a((byte)0);
    FcC = 10;
    FcD = 11;
    FcE = 12;
    FcF = 13;
    FcG = 14;
    FcH = 15;
    FcI = 16;
    FcJ = 17;
    FcK = 100;
    FcL = 101;
    FcM = 102;
    FcN = 103;
    FcO = 104;
    FcP = 105;
    FcQ = 106;
    FcR = 107;
    FcS = 108;
    FcT = 109;
    FcU = 110;
    FcV = 111;
    FcW = 112;
    FcX = 199;
    AppMethodBeat.o(105902);
  }
  
  public d()
  {
    AppMethodBeat.i(105901);
    this.oJp = "";
    this.type = "Sticker2D";
    this.Fcz = "";
    this.FcA = new f();
    this.FcB = new HashMap();
    AppMethodBeat.o(105901);
  }
  
  public final void aGY(String paramString)
  {
    AppMethodBeat.i(105893);
    k.h(paramString, "<set-?>");
    this.oJp = paramString;
    AppMethodBeat.o(105893);
  }
  
  public final void aGZ(String paramString)
  {
    AppMethodBeat.i(105895);
    k.h(paramString, "<set-?>");
    this.Fcz = paramString;
    AppMethodBeat.o(105895);
  }
  
  public final a bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105899);
    k.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.getString("id");
    k.g(localObject, "jsonObj.getString(\"id\")");
    this.oJp = ((String)localObject);
    this.bFX = paramJSONObject.optDouble("version", this.bFX);
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
      c localc = new c();
      k.g(str, "name");
      localc.setName(str);
      k.g(localJSONObject, "elementObj");
      localc.bx(localJSONObject);
      ((Map)this.FcB).put(str, localc);
      i += 1;
    }
    paramJSONObject = super.bx(paramJSONObject);
    AppMethodBeat.o(105899);
    return paramJSONObject;
  }
  
  public final boolean eIB()
  {
    AppMethodBeat.i(105897);
    Object localObject = this.FcB.values();
    k.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label104:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((c)((Iterator)localObject).next()).Fcu;
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
  
  public final boolean eIC()
  {
    AppMethodBeat.i(105898);
    Object localObject = this.FcB.values();
    k.g(localObject, "elements.values");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      label103:
      while (((Iterator)localObject).hasNext())
      {
        int i = ((c)((Iterator)localObject).next()).Fcu;
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
  
  public final void n(HashMap<String, c> paramHashMap)
  {
    AppMethodBeat.i(105896);
    k.h(paramHashMap, "<set-?>");
    this.FcB = paramHashMap;
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
    localJSONObject1.put("id", this.oJp);
    localJSONObject1.put("version", this.bFX);
    localJSONObject1.put("type", this.type);
    JSONObject localJSONObject2 = new JSONObject();
    Object localObject = new JSONArray();
    Iterator localIterator = ((Map)this.FcB).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ((JSONArray)localObject).put(localEntry.getKey());
      JSONObject localJSONObject3 = ((c)localEntry.getValue()).toJson();
      localJSONObject2.put((String)localEntry.getKey(), localJSONObject3);
    }
    localJSONObject2.put("elements", localObject);
    localObject = this.FcA;
    if (((f)localObject).Fde.length == 0)
    {
      i = 1;
      if (i == 0) {
        break label287;
      }
      if (((f)localObject).Fdf.length != 0) {
        break label272;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label287;
      }
      if (((f)localObject).Fdg.length != 0) {
        break label277;
      }
      i = 1;
      label210:
      if (i == 0) {
        break label287;
      }
      if (((f)localObject).Fdh.length != 0) {
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
        localJSONObject2.put("template_trans_set", this.FcA.toJson());
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/StickerInfo$Companion;", "", "()V", "ACTION_EYEBROW_UP", "", "getACTION_EYEBROW_UP", "()I", "ACTION_EYE_BLINK", "getACTION_EYE_BLINK", "ACTION_HEAD_NOD", "getACTION_HEAD_NOD", "ACTION_HEAD_SHAKE", "getACTION_HEAD_SHAKE", "ACTION_LEFTEYE_BLINK", "getACTION_LEFTEYE_BLINK", "ACTION_MOUTH_KISS", "getACTION_MOUTH_KISS", "ACTION_MOUTH_OPEN", "getACTION_MOUTH_OPEN", "ACTION_RIGHTEYE_BLINK", "getACTION_RIGHTEYE_BLINK", "HAND_ACTION_EIGHT", "getHAND_ACTION_EIGHT", "HAND_ACTION_FIST", "getHAND_ACTION_FIST", "HAND_ACTION_GOOD_FORTUNE", "getHAND_ACTION_GOOD_FORTUNE", "HAND_ACTION_HEART", "getHAND_ACTION_HEART", "HAND_ACTION_LIFT", "getHAND_ACTION_LIFT", "HAND_ACTION_LIKE", "getHAND_ACTION_LIKE", "HAND_ACTION_LOVE", "getHAND_ACTION_LOVE", "HAND_ACTION_OK", "getHAND_ACTION_OK", "HAND_ACTION_ONE", "getHAND_ACTION_ONE", "HAND_ACTION_PAPER", "getHAND_ACTION_PAPER", "HAND_ACTION_REJECT", "getHAND_ACTION_REJECT", "HAND_ACTION_ROCK", "getHAND_ACTION_ROCK", "HAND_ACTION_SCISSOR", "getHAND_ACTION_SCISSOR", "HAND_ACTION_SIX", "getHAND_ACTION_SIX", "plugin-sticker_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.d
 * JD-Core Version:    0.7.0.1
 */