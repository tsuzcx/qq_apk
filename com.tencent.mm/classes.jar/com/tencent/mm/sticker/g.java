package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/StickerTransform;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "trans0", "", "getTrans0", "()[D", "setTrans0", "([D)V", "trans1", "getTrans1", "setTrans1", "trans2", "getTrans2", "setTrans2", "trans3", "getTrans3", "setTrans3", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "isEmpty", "", "toJson", "plugin-sticker_release"})
public final class g
  extends a
{
  double[] Imv;
  double[] Imw;
  double[] Imx;
  double[] Imy;
  
  public g()
  {
    AppMethodBeat.i(105911);
    this.Imv = new double[0];
    this.Imw = new double[0];
    this.Imx = new double[0];
    this.Imy = new double[0];
    AppMethodBeat.o(105911);
  }
  
  public final a bH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105909);
    p.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optJSONArray("trans_0");
    if (localObject != null)
    {
      localObject = b.Q((JSONArray)localObject);
      this.Imv = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_1");
      if (localObject == null) {
        break label116;
      }
      localObject = b.Q((JSONArray)localObject);
      label48:
      this.Imw = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_2");
      if (localObject == null) {
        break label124;
      }
      localObject = b.Q((JSONArray)localObject);
      label69:
      this.Imx = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_3");
      if (localObject == null) {
        break label132;
      }
    }
    label132:
    for (localObject = b.Q((JSONArray)localObject);; localObject = this.Imy)
    {
      this.Imy = ((double[])localObject);
      paramJSONObject = super.bH(paramJSONObject);
      AppMethodBeat.o(105909);
      return paramJSONObject;
      localObject = this.Imv;
      break;
      label116:
      localObject = this.Imw;
      break label48;
      label124:
      localObject = this.Imx;
      break label69;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105910);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("trans_0", b.c(this.Imv));
    localJSONObject.put("trans_1", b.c(this.Imw));
    localJSONObject.put("trans_2", b.c(this.Imx));
    localJSONObject.put("trans_3", b.c(this.Imy));
    AppMethodBeat.o(105910);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.g
 * JD-Core Version:    0.7.0.1
 */