package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sticker/StickerElement;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "active", "", "getActive", "()I", "setActive", "(I)V", "adjust", "", "getAdjust", "()Z", "setAdjust", "(Z)V", "len", "getLen", "setLen", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "pendantType", "getPendantType", "setPendantType", "pos", "", "getPos", "()[D", "setPos", "([D)V", "segment", "getSegment", "setSegment", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-sticker_release"})
public final class d
  extends a
{
  private boolean VaA;
  public double[] VaB;
  public int Vax;
  public int Vay;
  int Vaz;
  public int fTZ;
  private String name;
  
  public d()
  {
    AppMethodBeat.i(105892);
    this.name = "";
    this.Vax = -1;
    this.Vay = -1;
    this.VaB = new double[0];
    AppMethodBeat.o(105892);
  }
  
  public final a ay(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105890);
    p.k(paramJSONObject, "jsonObj");
    this.fTZ = paramJSONObject.optInt("len");
    this.Vax = paramJSONObject.optInt("active", this.Vax);
    this.Vay = paramJSONObject.optInt("segtype", this.Vay);
    this.Vaz = paramJSONObject.optInt("pendant_type", this.Vaz);
    this.VaA = paramJSONObject.optBoolean("adjust", this.VaA);
    Object localObject = paramJSONObject.optJSONArray("pos");
    if (localObject != null) {}
    for (localObject = b.Y((JSONArray)localObject);; localObject = this.VaB)
    {
      this.VaB = ((double[])localObject);
      paramJSONObject = super.ay(paramJSONObject);
      AppMethodBeat.o(105890);
      return paramJSONObject;
    }
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(105889);
    p.k(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(105889);
  }
  
  public final JSONObject toJson()
  {
    int j = 0;
    AppMethodBeat.i(105891);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("len", this.fTZ);
    localJSONObject.put("active", this.Vax);
    if ((this.Vay >= 0) || (this.Vaz == 2)) {
      localJSONObject.put("segtype", 0);
    }
    if (this.VaB.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        j = 1;
      }
      if (j != 0) {
        localJSONObject.put("pos", b.c(this.VaB));
      }
      if ((this.Vaz == 1) || (this.Vaz == 2)) {
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