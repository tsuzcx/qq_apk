package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class s
{
  public long COR;
  public long CXH;
  public long CXI;
  public int CXJ;
  public int CXK;
  public long CXL;
  
  public final void bk(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70311);
    this.COR = paramJSONObject.optLong("activity_id");
    this.CXH = paramJSONObject.optLong("activity_type", 0L);
    this.CXI = paramJSONObject.optLong("award_id");
    this.CXJ = paramJSONObject.optInt("send_record_id");
    this.CXK = paramJSONObject.optInt("user_record_id");
    this.CXL = paramJSONObject.optLong("activity_mch_id", 0L);
    AppMethodBeat.o(70311);
  }
  
  public static final class a
  {
    public String CXM;
    public String CXN;
    public String name;
    public String title;
    public int type;
    public String url;
    public String wMR;
    
    public final void bk(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70309);
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("wording");
      this.wMR = paramJSONObject.optString("icon");
      this.CXM = paramJSONObject.optString("btn_text");
      this.type = paramJSONObject.optInt("type");
      this.title = paramJSONObject.optString("title");
      this.CXN = paramJSONObject.optString("small_title");
      AppMethodBeat.o(70309);
    }
  }
  
  public static final class b
  {
    public String CNV;
    public String CXO;
    public String CXP;
    public String CXQ;
    public int CXR;
    public String CzQ;
    public String CzR;
    
    public final void bk(JSONObject paramJSONObject)
    {
      AppMethodBeat.i(70310);
      this.CNV = paramJSONObject.optString("tinyapp_name");
      this.CXO = paramJSONObject.optString("tinyapp_logo");
      this.CXP = paramJSONObject.optString("tinyapp_desc");
      this.CzQ = paramJSONObject.optString("tinyapp_username");
      this.CzR = paramJSONObject.optString("tinyapp_path");
      this.CXQ = paramJSONObject.optString("activity_tinyapp_btn_text");
      this.CXR = paramJSONObject.optInt("tinyapp_version", 0);
      AppMethodBeat.o(70310);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.s
 * JD-Core Version:    0.7.0.1
 */