package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sticker/StickerElement;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "active", "", "getActive", "()I", "setActive", "(I)V", "adjust", "", "getAdjust", "()Z", "setAdjust", "(Z)V", "len", "getLen", "setLen", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "pendantType", "getPendantType", "setPendantType", "pos", "", "getPos", "()[D", "setPos", "([D)V", "segment", "getSegment", "setSegment", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-sticker_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends a
{
  public int acBQ;
  public int acBR;
  int acBS;
  private boolean acBT;
  public double[] acBU;
  public int len;
  private String name;
  
  public d()
  {
    AppMethodBeat.i(105892);
    this.name = "";
    this.acBQ = -1;
    this.acBR = -1;
    this.acBU = new double[0];
    AppMethodBeat.o(105892);
  }
  
  public final a G(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105890);
    s.u(paramJSONObject, "jsonObj");
    this.len = paramJSONObject.optInt("len");
    this.acBQ = paramJSONObject.optInt("active", this.acBQ);
    this.acBR = paramJSONObject.optInt("segtype", this.acBR);
    this.acBS = paramJSONObject.optInt("pendant_type", this.acBS);
    this.acBT = paramJSONObject.optBoolean("adjust", this.acBT);
    Object localObject1 = paramJSONObject.optJSONArray("pos");
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = b.ac((JSONArray)localObject1))
    {
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = this.acBU;
      }
      this.acBU = ((double[])localObject2);
      paramJSONObject = super.G(paramJSONObject);
      AppMethodBeat.o(105890);
      return paramJSONObject;
    }
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(105889);
    s.u(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(105889);
  }
  
  public final JSONObject toJson()
  {
    int j = 0;
    AppMethodBeat.i(105891);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("len", this.len);
    localJSONObject.put("active", this.acBQ);
    if ((this.acBR >= 0) || (this.acBS == 2)) {
      localJSONObject.put("segtype", 0);
    }
    if (this.acBU.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        j = 1;
      }
      if (j != 0) {
        localJSONObject.put("pos", b.e(this.acBU));
      }
      if ((this.acBS == 1) || (this.acBS == 2)) {
        localJSONObject.put("adjust", true);
      }
      AppMethodBeat.o(105891);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.d
 * JD-Core Version:    0.7.0.1
 */