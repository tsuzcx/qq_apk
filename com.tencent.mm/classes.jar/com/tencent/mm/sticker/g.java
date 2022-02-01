package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/StickerTransform;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "trans0", "", "getTrans0", "()[D", "setTrans0", "([D)V", "trans1", "getTrans1", "setTrans1", "trans2", "getTrans2", "setTrans2", "trans3", "getTrans3", "setTrans3", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "isEmpty", "", "toJson", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  public double[] acCC;
  public double[] acCD;
  public double[] acCE;
  public double[] acCF;
  
  public g()
  {
    AppMethodBeat.i(105911);
    this.acCC = new double[0];
    this.acCD = new double[0];
    this.acCE = new double[0];
    this.acCF = new double[0];
    AppMethodBeat.o(105911);
  }
  
  public final a G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105909);
    s.u(paramJSONObject, "jsonObj");
    Object localObject1 = paramJSONObject.optJSONArray("trans_0");
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.acCC;
      }
      this.acCC = ((double[])localObject2);
      localObject1 = paramJSONObject.optJSONArray("trans_1");
      if (localObject1 != null) {
        break label148;
      }
      localObject1 = null;
      label53:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.acCD;
      }
      this.acCD = ((double[])localObject2);
      localObject1 = paramJSONObject.optJSONArray("trans_2");
      if (localObject1 != null) {
        break label156;
      }
      localObject1 = null;
      label82:
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.acCE;
      }
      this.acCE = ((double[])localObject2);
      localObject1 = paramJSONObject.optJSONArray("trans_3");
      if (localObject1 != null) {
        break label164;
      }
    }
    label148:
    label156:
    label164:
    for (localObject1 = null;; localObject1 = b.ac((JSONArray)localObject1))
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.acCF;
      }
      this.acCF = ((double[])localObject2);
      paramJSONObject = super.G(paramJSONObject);
      AppMethodBeat.o(105909);
      return paramJSONObject;
      localObject1 = b.ac((JSONArray)localObject1);
      break;
      localObject1 = b.ac((JSONArray)localObject1);
      break label53;
      localObject1 = b.ac((JSONArray)localObject1);
      break label82;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105910);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("trans_0", b.e(this.acCC));
    localJSONObject.put("trans_1", b.e(this.acCD));
    localJSONObject.put("trans_2", b.e(this.acCE));
    localJSONObject.put("trans_3", b.e(this.acCF));
    AppMethodBeat.o(105910);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.g
 * JD-Core Version:    0.7.0.1
 */