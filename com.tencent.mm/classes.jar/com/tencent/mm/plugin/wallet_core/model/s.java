package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s
{
  public long HYA;
  public long HYB;
  public int HYC;
  public int HYD;
  public long HYE;
  public long crw;
  
  public final void bK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70311);
    this.crw = paramJSONObject.optLong("activity_id");
    this.HYA = paramJSONObject.optLong("activity_type", 0L);
    this.HYB = paramJSONObject.optLong("award_id");
    this.HYC = paramJSONObject.optInt("send_record_id");
    this.HYD = paramJSONObject.optInt("user_record_id");
    this.HYE = paramJSONObject.optLong("activity_mch_id", 0L);
    AppMethodBeat.o(70311);
  }
  
  public static final class a
  {
    public String Bah;
    public String HYF;
    public String HYG;
    public String name;
    public String title;
    public int type;
    public String url;
    
    public final void bK(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70309);
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("wording");
      this.Bah = paramJSONObject.optString("icon");
      this.HYF = paramJSONObject.optString("btn_text");
      this.type = paramJSONObject.optInt("type");
      this.title = paramJSONObject.optString("title");
      this.HYG = paramJSONObject.optString("small_title");
      AppMethodBeat.o(70309);
    }
  }
  
  public static final class b
  {
    public String HLz;
    public String HYH;
    public String HYI;
    public String HYJ;
    public int HYK;
    public String Hwr;
    public String Hws;
    
    public final void bK(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70310);
      this.HLz = paramJSONObject.optString("tinyapp_name");
      this.HYH = paramJSONObject.optString("tinyapp_logo");
      this.HYI = paramJSONObject.optString("tinyapp_desc");
      this.Hwr = paramJSONObject.optString("tinyapp_username");
      this.Hws = paramJSONObject.optString("tinyapp_path");
      this.HYJ = paramJSONObject.optString("activity_tinyapp_btn_text");
      this.HYK = paramJSONObject.optInt("tinyapp_version", 0);
      AppMethodBeat.o(70310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */