package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/StickerTransform;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "trans0", "", "getTrans0", "()[D", "setTrans0", "([D)V", "trans1", "getTrans1", "setTrans1", "trans2", "getTrans2", "setTrans2", "trans3", "getTrans3", "setTrans3", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "isEmpty", "", "toJson", "plugin-sticker_release"})
public final class g
  extends a
{
  double[] GAB;
  double[] GAC;
  double[] GAD;
  double[] GAE;
  
  public g()
  {
    AppMethodBeat.i(105911);
    this.GAB = new double[0];
    this.GAC = new double[0];
    this.GAD = new double[0];
    this.GAE = new double[0];
    AppMethodBeat.o(105911);
  }
  
  public final a by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105909);
    k.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optJSONArray("trans_0");
    if (localObject != null)
    {
      localObject = b.P((JSONArray)localObject);
      this.GAB = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_1");
      if (localObject == null) {
        break label116;
      }
      localObject = b.P((JSONArray)localObject);
      label48:
      this.GAC = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_2");
      if (localObject == null) {
        break label124;
      }
      localObject = b.P((JSONArray)localObject);
      label69:
      this.GAD = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_3");
      if (localObject == null) {
        break label132;
      }
    }
    label132:
    for (localObject = b.P((JSONArray)localObject);; localObject = this.GAE)
    {
      this.GAE = ((double[])localObject);
      paramJSONObject = super.by(paramJSONObject);
      AppMethodBeat.o(105909);
      return paramJSONObject;
      localObject = this.GAB;
      break;
      label116:
      localObject = this.GAC;
      break label48;
      label124:
      localObject = this.GAD;
      break label69;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105910);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("trans_0", b.c(this.GAB));
    localJSONObject.put("trans_1", b.c(this.GAC));
    localJSONObject.put("trans_2", b.c(this.GAD));
    localJSONObject.put("trans_3", b.c(this.GAE));
    AppMethodBeat.o(105910);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.g
 * JD-Core Version:    0.7.0.1
 */