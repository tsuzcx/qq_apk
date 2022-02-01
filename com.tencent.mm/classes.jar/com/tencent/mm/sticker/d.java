package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sticker/StickerElement;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "active", "", "getActive", "()I", "setActive", "(I)V", "adjust", "", "getAdjust", "()Z", "setAdjust", "(Z)V", "len", "getLen", "setLen", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "pendantType", "getPendantType", "setPendantType", "pos", "", "getPos", "()[D", "setPos", "([D)V", "segment", "getSegment", "setSegment", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-sticker_release"})
public final class d
  extends a
{
  public int GzR;
  private int GzS;
  int GzT;
  private boolean GzU;
  private double[] GzV;
  private int len;
  private String name;
  
  public d()
  {
    AppMethodBeat.i(105892);
    this.name = "";
    this.GzR = -1;
    this.GzS = -1;
    this.GzV = new double[0];
    AppMethodBeat.o(105892);
  }
  
  public final a by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105890);
    k.h(paramJSONObject, "jsonObj");
    this.len = paramJSONObject.optInt("len");
    this.GzR = paramJSONObject.optInt("active", this.GzR);
    this.GzS = paramJSONObject.optInt("segtype", this.GzS);
    this.GzT = paramJSONObject.optInt("pendant_type", this.GzT);
    this.GzU = paramJSONObject.optBoolean("adjust", this.GzU);
    Object localObject = paramJSONObject.optJSONArray("pos");
    if (localObject != null) {}
    for (localObject = b.P((JSONArray)localObject);; localObject = this.GzV)
    {
      this.GzV = ((double[])localObject);
      paramJSONObject = super.by(paramJSONObject);
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
    localJSONObject.put("active", this.GzR);
    if ((this.GzS >= 0) || (this.GzT == 2)) {
      localJSONObject.put("segtype", 0);
    }
    localJSONObject.put("pos", b.c(this.GzV));
    if ((this.GzT == 1) || (this.GzT == 2)) {
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