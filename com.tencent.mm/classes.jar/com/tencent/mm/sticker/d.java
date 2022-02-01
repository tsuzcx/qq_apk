package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sticker/StickerElement;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "active", "", "getActive", "()I", "setActive", "(I)V", "adjust", "", "getAdjust", "()Z", "setAdjust", "(Z)V", "len", "getLen", "setLen", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "pendantType", "getPendantType", "setPendantType", "pos", "", "getPos", "()[D", "setPos", "([D)V", "segment", "getSegment", "setSegment", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-sticker_release"})
public final class d
  extends a
{
  public int IFW;
  private int IFX;
  int IFY;
  private boolean IFZ;
  private double[] IGa;
  private int len;
  private String name;
  
  public d()
  {
    AppMethodBeat.i(105892);
    this.name = "";
    this.IFW = -1;
    this.IFX = -1;
    this.IGa = new double[0];
    AppMethodBeat.o(105892);
  }
  
  public final a bH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105890);
    p.h(paramJSONObject, "jsonObj");
    this.len = paramJSONObject.optInt("len");
    this.IFW = paramJSONObject.optInt("active", this.IFW);
    this.IFX = paramJSONObject.optInt("segtype", this.IFX);
    this.IFY = paramJSONObject.optInt("pendant_type", this.IFY);
    this.IFZ = paramJSONObject.optBoolean("adjust", this.IFZ);
    Object localObject = paramJSONObject.optJSONArray("pos");
    if (localObject != null) {}
    for (localObject = b.R((JSONArray)localObject);; localObject = this.IGa)
    {
      this.IGa = ((double[])localObject);
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
    localJSONObject.put("active", this.IFW);
    if ((this.IFX >= 0) || (this.IFY == 2)) {
      localJSONObject.put("segtype", 0);
    }
    localJSONObject.put("pos", b.c(this.IGa));
    if ((this.IFY == 1) || (this.IFY == 2)) {
      localJSONObject.put("adjust", true);
    }
    AppMethodBeat.o(105891);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.sticker.d
 * JD-Core Version:    0.7.0.1
 */