package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class r
{
  public long BoC;
  public long Bxo;
  public long Bxp;
  public int Bxq;
  public int Bxr;
  public long Bxs;
  
  public final void bb(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70311);
    this.BoC = paramJSONObject.optLong("activity_id");
    this.Bxo = paramJSONObject.optLong("activity_type", 0L);
    this.Bxp = paramJSONObject.optLong("award_id");
    this.Bxq = paramJSONObject.optInt("send_record_id");
    this.Bxr = paramJSONObject.optInt("user_record_id");
    this.Bxs = paramJSONObject.optLong("activity_mch_id", 0L);
    AppMethodBeat.o(70311);
  }
  
  public static final class a
  {
    public String Bxt;
    public String Bxu;
    public String name;
    public String title;
    public int type;
    public String url;
    public String vFL;
    
    public final void bb(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70309);
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("wording");
      this.vFL = paramJSONObject.optString("icon");
      this.Bxt = paramJSONObject.optString("btn_text");
      this.type = paramJSONObject.optInt("type");
      this.title = paramJSONObject.optString("title");
      this.Bxu = paramJSONObject.optString("small_title");
      AppMethodBeat.o(70309);
    }
  }
  
  public static final class b
  {
    public String AZE;
    public String AZF;
    public String BnG;
    public String Bxv;
    public String Bxw;
    public String Bxx;
    public int Bxy;
    
    public final void bb(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70310);
      this.BnG = paramJSONObject.optString("tinyapp_name");
      this.Bxv = paramJSONObject.optString("tinyapp_logo");
      this.Bxw = paramJSONObject.optString("tinyapp_desc");
      this.AZE = paramJSONObject.optString("tinyapp_username");
      this.AZF = paramJSONObject.optString("tinyapp_path");
      this.Bxx = paramJSONObject.optString("activity_tinyapp_btn_text");
      this.Bxy = paramJSONObject.optInt("tinyapp_version", 0);
      AppMethodBeat.o(70310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */