package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s
{
  public long Dpm;
  public long Dpn;
  public int Dpo;
  public int Dpp;
  public long Dpq;
  public long vlr;
  
  public final void bk(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70311);
    this.vlr = paramJSONObject.optLong("activity_id");
    this.Dpm = paramJSONObject.optLong("activity_type", 0L);
    this.Dpn = paramJSONObject.optLong("award_id");
    this.Dpo = paramJSONObject.optInt("send_record_id");
    this.Dpp = paramJSONObject.optInt("user_record_id");
    this.Dpq = paramJSONObject.optLong("activity_mch_id", 0L);
    AppMethodBeat.o(70311);
  }
  
  public static final class a
  {
    public String Dpr;
    public String Dps;
    public String name;
    public String title;
    public int type;
    public String url;
    public String xcF;
    
    public final void bk(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70309);
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("wording");
      this.xcF = paramJSONObject.optString("icon");
      this.Dpr = paramJSONObject.optString("btn_text");
      this.type = paramJSONObject.optInt("type");
      this.title = paramJSONObject.optString("title");
      this.Dps = paramJSONObject.optString("small_title");
      AppMethodBeat.o(70309);
    }
  }
  
  public static final class b
  {
    public String CRv;
    public String CRw;
    public String DfD;
    public String Dpt;
    public String Dpu;
    public String Dpv;
    public int Dpw;
    
    public final void bk(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70310);
      this.DfD = paramJSONObject.optString("tinyapp_name");
      this.Dpt = paramJSONObject.optString("tinyapp_logo");
      this.Dpu = paramJSONObject.optString("tinyapp_desc");
      this.CRv = paramJSONObject.optString("tinyapp_username");
      this.CRw = paramJSONObject.optString("tinyapp_path");
      this.Dpv = paramJSONObject.optString("activity_tinyapp_btn_text");
      this.Dpw = paramJSONObject.optInt("tinyapp_version", 0);
      AppMethodBeat.o(70310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */