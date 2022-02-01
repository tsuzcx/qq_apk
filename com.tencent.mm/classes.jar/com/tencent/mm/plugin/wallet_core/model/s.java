package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s
{
  public long VGu;
  public long VGv;
  public int VGw;
  public int VGx;
  public long VGy;
  public long ehe;
  
  public final void cq(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70311);
    this.ehe = paramJSONObject.optLong("activity_id");
    this.VGu = paramJSONObject.optLong("activity_type", 0L);
    this.VGv = paramJSONObject.optLong("award_id");
    this.VGw = paramJSONObject.optInt("send_record_id");
    this.VGx = paramJSONObject.optInt("user_record_id");
    this.VGy = paramJSONObject.optLong("activity_mch_id", 0L);
    AppMethodBeat.o(70311);
  }
  
  public static final class a
  {
    public String MRI;
    public String VGA;
    public String VGz;
    public String name;
    public String title;
    public int type;
    public String url;
    
    public final void cq(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70309);
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("wording");
      this.MRI = paramJSONObject.optString("icon");
      this.VGz = paramJSONObject.optString("btn_text");
      this.type = paramJSONObject.optInt("type");
      this.title = paramJSONObject.optString("title");
      this.VGA = paramJSONObject.optString("small_title");
      AppMethodBeat.o(70309);
    }
  }
  
  public static final class b
  {
    public String VGB;
    public String VGC;
    public String VGD;
    public int VGE;
    public String VcU;
    public String VcV;
    public String VsI;
    
    public final void cq(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70310);
      this.VsI = paramJSONObject.optString("tinyapp_name");
      this.VGB = paramJSONObject.optString("tinyapp_logo");
      this.VGC = paramJSONObject.optString("tinyapp_desc");
      this.VcU = paramJSONObject.optString("tinyapp_username");
      this.VcV = paramJSONObject.optString("tinyapp_path");
      this.VGD = paramJSONObject.optString("activity_tinyapp_btn_text");
      this.VGE = paramJSONObject.optInt("tinyapp_version", 0);
      AppMethodBeat.o(70310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */