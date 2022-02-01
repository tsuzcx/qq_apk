package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/StickerTransform;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "trans0", "", "getTrans0", "()[D", "setTrans0", "([D)V", "trans1", "getTrans1", "setTrans1", "trans2", "getTrans2", "setTrans2", "trans3", "getTrans3", "setTrans3", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "isEmpty", "", "toJson", "plugin-sticker_release"})
public final class g
  extends a
{
  public double[] NNA;
  public double[] NNB;
  public double[] NNC;
  public double[] NNz;
  
  public g()
  {
    AppMethodBeat.i(105911);
    this.NNz = new double[0];
    this.NNA = new double[0];
    this.NNB = new double[0];
    this.NNC = new double[0];
    AppMethodBeat.o(105911);
  }
  
  public final a au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105909);
    p.h(paramJSONObject, "jsonObj");
    Object localObject = paramJSONObject.optJSONArray("trans_0");
    if (localObject != null)
    {
      localObject = b.W((JSONArray)localObject);
      this.NNz = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_1");
      if (localObject == null) {
        break label116;
      }
      localObject = b.W((JSONArray)localObject);
      label48:
      this.NNA = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_2");
      if (localObject == null) {
        break label124;
      }
      localObject = b.W((JSONArray)localObject);
      label69:
      this.NNB = ((double[])localObject);
      localObject = paramJSONObject.optJSONArray("trans_3");
      if (localObject == null) {
        break label132;
      }
    }
    label132:
    for (localObject = b.W((JSONArray)localObject);; localObject = this.NNC)
    {
      this.NNC = ((double[])localObject);
      paramJSONObject = super.au(paramJSONObject);
      AppMethodBeat.o(105909);
      return paramJSONObject;
      localObject = this.NNz;
      break;
      label116:
      localObject = this.NNA;
      break label48;
      label124:
      localObject = this.NNB;
      break label69;
    }
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105910);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("trans_0", b.c(this.NNz));
    localJSONObject.put("trans_1", b.c(this.NNA));
    localJSONObject.put("trans_2", b.c(this.NNB));
    localJSONObject.put("trans_3", b.c(this.NNC));
    AppMethodBeat.o(105910);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.g
 * JD-Core Version:    0.7.0.1
 */