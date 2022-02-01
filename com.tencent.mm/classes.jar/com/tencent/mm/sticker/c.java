package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sticker/StickerElement;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "active", "", "getActive", "()I", "setActive", "(I)V", "adjust", "", "getAdjust", "()Z", "setAdjust", "(Z)V", "len", "getLen", "setLen", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "pendantType", "getPendantType", "setPendantType", "pos", "", "getPos", "()[D", "setPos", "([D)V", "segment", "getSegment", "setSegment", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-sticker_release"})
public final class c
  extends a
{
  public int Fcu;
  private int Fcv;
  int Fcw;
  private boolean Fcx;
  private double[] Fcy;
  private int len;
  private String name;
  
  public c()
  {
    AppMethodBeat.i(105892);
    this.name = "";
    this.Fcu = -1;
    this.Fcv = -1;
    this.Fcy = new double[0];
    AppMethodBeat.o(105892);
  }
  
  public final a bx(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105890);
    k.h(paramJSONObject, "jsonObj");
    this.len = paramJSONObject.optInt("len");
    this.Fcu = paramJSONObject.optInt("active", this.Fcu);
    this.Fcv = paramJSONObject.optInt("segtype", this.Fcv);
    this.Fcw = paramJSONObject.optInt("pendant_type", this.Fcw);
    this.Fcx = paramJSONObject.optBoolean("adjust", this.Fcx);
    Object localObject = paramJSONObject.optJSONArray("pos");
    if (localObject != null) {}
    for (localObject = b.P((JSONArray)localObject);; localObject = this.Fcy)
    {
      this.Fcy = ((double[])localObject);
      paramJSONObject = super.bx(paramJSONObject);
      AppMethodBeat.o(105890);
      return paramJSONObject;
    }
  }
  
  public final void setName(String paramString)
  {
    AppMethodBeat.i(105889);
    k.h(paramString, "<set-?>");
    this.name = paramString;
    AppMethodBeat.o(105889);
  }
  
  public final JSONObject toJson()
  {
    AppMethodBeat.i(105891);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("len", this.len);
    localJSONObject.put("active", this.Fcu);
    if ((this.Fcv >= 0) || (this.Fcw == 2)) {
      localJSONObject.put("segtype", 0);
    }
    localJSONObject.put("pos", b.c(this.Fcy));
    if ((this.Fcw == 1) || (this.Fcw == 2)) {
      localJSONObject.put("adjust", true);
    }
    AppMethodBeat.o(105891);
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.sticker.c
 * JD-Core Version:    0.7.0.1
 */