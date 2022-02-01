package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class r
{
  public long AeU;
  public long AeV;
  public int AeW;
  public int AeX;
  public long AeY;
  public long zWi;
  
  public final void ba(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70311);
    this.zWi = paramJSONObject.optLong("activity_id");
    this.AeU = paramJSONObject.optLong("activity_type", 0L);
    this.AeV = paramJSONObject.optLong("award_id");
    this.AeW = paramJSONObject.optInt("send_record_id");
    this.AeX = paramJSONObject.optInt("user_record_id");
    this.AeY = paramJSONObject.optLong("activity_mch_id", 0L);
    AppMethodBeat.o(70311);
  }
  
  public static final class a
  {
    public String AeZ;
    public String Afa;
    public String name;
    public String title;
    public int type;
    public String url;
    public String uwS;
    
    public final void ba(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70309);
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("wording");
      this.uwS = paramJSONObject.optString("icon");
      this.AeZ = paramJSONObject.optString("btn_text");
      this.type = paramJSONObject.optInt("type");
      this.title = paramJSONObject.optString("title");
      this.Afa = paramJSONObject.optString("small_title");
      AppMethodBeat.o(70309);
    }
  }
  
  public static final class b
  {
    public String Afb;
    public String Afc;
    public String Afd;
    public int Afe;
    public String zHs;
    public String zHt;
    public String zVm;
    
    public final void ba(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70310);
      this.zVm = paramJSONObject.optString("tinyapp_name");
      this.Afb = paramJSONObject.optString("tinyapp_logo");
      this.Afc = paramJSONObject.optString("tinyapp_desc");
      this.zHs = paramJSONObject.optString("tinyapp_username");
      this.zHt = paramJSONObject.optString("tinyapp_path");
      this.Afd = paramJSONObject.optString("activity_tinyapp_btn_text");
      this.Afe = paramJSONObject.optInt("tinyapp_version", 0);
      AppMethodBeat.o(70310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */