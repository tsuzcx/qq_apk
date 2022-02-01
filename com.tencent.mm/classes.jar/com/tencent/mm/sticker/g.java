package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/StickerTransform;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "trans0", "", "getTrans0", "()[D", "setTrans0", "([D)V", "trans1", "getTrans1", "setTrans1", "trans2", "getTrans2", "setTrans2", "trans3", "getTrans3", "setTrans3", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "isEmpty", "", "toJson", "plugin-sticker_release"})
public final class g
  extends a
{
  double[] IGG;
  double[] IGH;
  double[] IGI;
  double[] IGJ;
  
  public g()
  {
    AppMethodBeat.i(105911);
    this.IGG = new double[0];
    this.IGH = new double[0];
    this.IGI = new double[0];
    this.IGJ = new double[0];
    AppMethodBeat.o(105911);
  }
  
  public final a bH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105909);
    p.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optJSONArray("trans_0");
    if (localObject != null)
    {
      localObject = b.R((JSONArray)localObject);
      this.IGG = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_1");
      if (localObject == null) {
        break label116;
      }
      localObject = b.R((JSONArray)localObject);
      label48:
      this.IGH = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_2");
      if (localObject == null) {
        break label124;
      }
      localObject = b.R((JSONArray)localObject);
      label69:
      this.IGI = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_3");
      if (localObject == null) {
        break label132;
      }
    }
    label132:
    for (localObject = b.R((JSONArray)localObject);; localObject = this.IGJ)
    {
      this.IGJ = ((double[])localObject);
      paramJSONObject = super.bH(paramJSONObject);
      AppMethodBeat.o(105909);
      return paramJSONObject;
      localObject = this.IGG;
      break;
      label116:
      localObject = this.IGH;
      break label48;
      label124:
      localObject = this.IGI;
      break label69;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105910);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("trans_0", b.c(this.IGG));
    localJSONObject.put("trans_1", b.c(this.IGH));
    localJSONObject.put("trans_2", b.c(this.IGI));
    localJSONObject.put("trans_3", b.c(this.IGJ));
    AppMethodBeat.o(105910);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.g
 * JD-Core Version:    0.7.0.1
 */