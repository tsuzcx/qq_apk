package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/StickerTransform;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "trans0", "", "getTrans0", "()[D", "setTrans0", "([D)V", "trans1", "getTrans1", "setTrans1", "trans2", "getTrans2", "setTrans2", "trans3", "getTrans3", "setTrans3", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "isEmpty", "", "toJson", "plugin-sticker_release"})
public final class g
  extends a
{
  public double[] Vbj;
  public double[] Vbk;
  public double[] Vbl;
  public double[] Vbm;
  
  public g()
  {
    AppMethodBeat.i(105911);
    this.Vbj = new double[0];
    this.Vbk = new double[0];
    this.Vbl = new double[0];
    this.Vbm = new double[0];
    AppMethodBeat.o(105911);
  }
  
  public final a ay(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105909);
    p.k(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optJSONArray("trans_0");
    if (localObject != null)
    {
      localObject = b.Y((JSONArray)localObject);
      this.Vbj = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_1");
      if (localObject == null) {
        break label116;
      }
      localObject = b.Y((JSONArray)localObject);
      label48:
      this.Vbk = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_2");
      if (localObject == null) {
        break label124;
      }
      localObject = b.Y((JSONArray)localObject);
      label69:
      this.Vbl = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_3");
      if (localObject == null) {
        break label132;
      }
    }
    label132:
    for (localObject = b.Y((JSONArray)localObject);; localObject = this.Vbm)
    {
      this.Vbm = ((double[])localObject);
      paramJSONObject = super.ay(paramJSONObject);
      AppMethodBeat.o(105909);
      return paramJSONObject;
      localObject = this.Vbj;
      break;
      label116:
      localObject = this.Vbk;
      break label48;
      label124:
      localObject = this.Vbl;
      break label69;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105910);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("trans_0", b.c(this.Vbj));
    localJSONObject.put("trans_1", b.c(this.Vbk));
    localJSONObject.put("trans_2", b.c(this.Vbl));
    localJSONObject.put("trans_3", b.c(this.Vbm));
    AppMethodBeat.o(105910);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.g
 * JD-Core Version:    0.7.0.1
 */