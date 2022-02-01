package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/StickerTransform;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "trans0", "", "getTrans0", "()[D", "setTrans0", "([D)V", "trans1", "getTrans1", "setTrans1", "trans2", "getTrans2", "setTrans2", "trans3", "getTrans3", "setTrans3", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "isEmpty", "", "toJson", "plugin-sticker_release"})
public final class f
  extends a
{
  double[] Fde;
  double[] Fdf;
  double[] Fdg;
  double[] Fdh;
  
  public f()
  {
    AppMethodBeat.i(105911);
    this.Fde = new double[0];
    this.Fdf = new double[0];
    this.Fdg = new double[0];
    this.Fdh = new double[0];
    AppMethodBeat.o(105911);
  }
  
  public final a bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105909);
    k.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optJSONArray("trans_0");
    if (localObject != null)
    {
      localObject = b.P((JSONArray)localObject);
      this.Fde = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_1");
      if (localObject == null) {
        break label116;
      }
      localObject = b.P((JSONArray)localObject);
      label48:
      this.Fdf = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_2");
      if (localObject == null) {
        break label124;
      }
      localObject = b.P((JSONArray)localObject);
      label69:
      this.Fdg = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_3");
      if (localObject == null) {
        break label132;
      }
    }
    label132:
    for (localObject = b.P((JSONArray)localObject);; localObject = this.Fdh)
    {
      this.Fdh = ((double[])localObject);
      paramJSONObject = super.bx(paramJSONObject);
      AppMethodBeat.o(105909);
      return paramJSONObject;
      localObject = this.Fde;
      break;
      label116:
      localObject = this.Fdf;
      break label48;
      label124:
      localObject = this.Fdg;
      break label69;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105910);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("trans_0", b.c(this.Fde));
    localJSONObject.put("trans_1", b.c(this.Fdf));
    localJSONObject.put("trans_2", b.c(this.Fdg));
    localJSONObject.put("trans_3", b.c(this.Fdh));
    AppMethodBeat.o(105910);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.f
 * JD-Core Version:    0.7.0.1
 */