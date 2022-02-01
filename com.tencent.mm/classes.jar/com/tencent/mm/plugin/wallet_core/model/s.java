package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s
{
  public long OQA;
  public long OQB;
  public int OQC;
  public int OQD;
  public long OQE;
  public long cpu;
  
  public final void bV(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70311);
    this.cpu = paramJSONObject.optLong("activity_id");
    this.OQA = paramJSONObject.optLong("activity_type", 0L);
    this.OQB = paramJSONObject.optLong("award_id");
    this.OQC = paramJSONObject.optInt("send_record_id");
    this.OQD = paramJSONObject.optInt("user_record_id");
    this.OQE = paramJSONObject.optLong("activity_mch_id", 0L);
    AppMethodBeat.o(70311);
  }
  
  public static final class a
  {
    public String GUf;
    public String OQF;
    public String OQG;
    public String name;
    public String title;
    public int type;
    public String url;
    
    public final void bV(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70309);
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("wording");
      this.GUf = paramJSONObject.optString("icon");
      this.OQF = paramJSONObject.optString("btn_text");
      this.type = paramJSONObject.optInt("type");
      this.title = paramJSONObject.optString("title");
      this.OQG = paramJSONObject.optString("small_title");
      AppMethodBeat.o(70309);
    }
  }
  
  public static final class b
  {
    public String ODu;
    public String OQH;
    public String OQI;
    public String OQJ;
    public int OQK;
    public String Ooe;
    public String Oof;
    
    public final void bV(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70310);
      this.ODu = paramJSONObject.optString("tinyapp_name");
      this.OQH = paramJSONObject.optString("tinyapp_logo");
      this.OQI = paramJSONObject.optString("tinyapp_desc");
      this.Ooe = paramJSONObject.optString("tinyapp_username");
      this.Oof = paramJSONObject.optString("tinyapp_path");
      this.OQJ = paramJSONObject.optString("activity_tinyapp_btn_text");
      this.OQK = paramJSONObject.optInt("tinyapp_version", 0);
      AppMethodBeat.o(70310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */