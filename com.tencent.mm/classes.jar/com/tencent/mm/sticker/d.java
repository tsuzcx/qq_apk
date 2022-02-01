package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sticker/StickerElement;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "active", "", "getActive", "()I", "setActive", "(I)V", "adjust", "", "getAdjust", "()Z", "setAdjust", "(Z)V", "len", "getLen", "setLen", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "pendantType", "getPendantType", "setPendantType", "pos", "", "getPos", "()[D", "setPos", "([D)V", "segment", "getSegment", "setSegment", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-sticker_release"})
public final class d
  extends a
{
  public int IlL;
  private int IlM;
  int IlN;
  private boolean IlO;
  private double[] IlP;
  private int len;
  private String name;
  
  public d()
  {
    AppMethodBeat.i(105892);
    this.name = "";
    this.IlL = -1;
    this.IlM = -1;
    this.IlP = new double[0];
    AppMethodBeat.o(105892);
  }
  
  public final a bH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105890);
    p.h(paramJSONObject, "jsonObj");
    this.len = paramJSONObject.optInt("len");
    this.IlL = paramJSONObject.optInt("active", this.IlL);
    this.IlM = paramJSONObject.optInt("segtype", this.IlM);
    this.IlN = paramJSONObject.optInt("pendant_type", this.IlN);
    this.IlO = paramJSONObject.optBoolean("adjust", this.IlO);
    Object localObject = paramJSONObject.optJSONArray("pos");
    if (localObject != null) {}
    for (localObject = b.Q((JSONArray)localObject);; localObject = this.IlP)
    {
      this.IlP = ((double[])localObject);
      paramJSONObject = super.bH(paramJSONObject);
      AppMethodBeat.o(105890);
      return paramJSONObject;
    }
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(105889);
    p.h(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(105889);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105891);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("len", this.len);
    localJSONObject.put("active", this.IlL);
    if ((this.IlM >= 0) || (this.IlN == 2)) {
      localJSONObject.put("segtype", 0);
    }
    localJSONObject.put("pos", b.c(this.IlP));
    if ((this.IlN == 1) || (this.IlN == 2)) {
      localJSONObject.put("adjust", true);
    }
    AppMethodBeat.o(105891);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.d
 * JD-Core Version:    0.7.0.1
 */