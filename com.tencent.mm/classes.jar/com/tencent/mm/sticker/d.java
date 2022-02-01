package com.tencent.mm.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sticker/StickerElement;", "Lcom/tencent/mm/sticker/BaseJsonObject;", "()V", "active", "", "getActive", "()I", "setActive", "(I)V", "adjust", "", "getAdjust", "()Z", "setAdjust", "(Z)V", "len", "getLen", "setLen", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "pendantType", "getPendantType", "setPendantType", "pos", "", "getPos", "()[D", "setPos", "([D)V", "segment", "getSegment", "setSegment", "fromJson", "jsonObj", "Lorg/json/JSONObject;", "toJson", "plugin-sticker_release"})
public final class d
  extends a
{
  public int NMN;
  public int NMO;
  int NMP;
  private boolean NMQ;
  public double[] NMR;
  public int len;
  private String name;
  
  public d()
  {
    AppMethodBeat.i(105892);
    this.name = "";
    this.NMN = -1;
    this.NMO = -1;
    this.NMR = new double[0];
    AppMethodBeat.o(105892);
  }
  
  public final a au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(105890);
    p.h(paramJSONObject, "jsonObj");
    this.len = paramJSONObject.optInt("len");
    this.NMN = paramJSONObject.optInt("active", this.NMN);
    this.NMO = paramJSONObject.optInt("segtype", this.NMO);
    this.NMP = paramJSONObject.optInt("pendant_type", this.NMP);
    this.NMQ = paramJSONObject.optBoolean("adjust", this.NMQ);
    Object localObject = paramJSONObject.optJSONArray("pos");
    if (localObject != null) {}
    for (localObject = b.W((JSONArray)localObject);; localObject = this.NMR)
    {
      this.NMR = ((double[])localObject);
      paramJSONObject = super.au(paramJSONObject);
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
    int j = 0;
    AppMethodBeat.i(105891);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("len", this.len);
    localJSONObject.put("active", this.NMN);
    if ((this.NMO >= 0) || (this.NMP == 2)) {
      localJSONObject.put("segtype", 0);
    }
    if (this.NMR.length == 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        j = 1;
      }
      if (j != 0) {
        localJSONObject.put("pos", b.c(this.NMR));
      }
      if ((this.NMP == 1) || (this.NMP == 2)) {
        localJSONObject.put("adjust", true);
      }
      AppMethodBeat.o(105891);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.sticker.d
 * JD-Core Version:    0.7.0.1
 */