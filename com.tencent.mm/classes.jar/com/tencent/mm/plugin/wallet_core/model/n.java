package com.tencent.mm.plugin.wallet_core.model;

import org.json.JSONObject;

public final class n
{
  public long qqG;
  public long qwk;
  public long qwl;
  public int qwm;
  public int qwn;
  public long qwo;
  
  public static final class a
  {
    public String mTc;
    public String name;
    public String qwp;
    public String qwq;
    public String title;
    public int type;
    public String url;
    
    public final void ar(JSONObject paramJSONObject)
    {
      this.url = paramJSONObject.optString("url");
      this.name = paramJSONObject.optString("wording");
      this.mTc = paramJSONObject.optString("icon");
      this.qwp = paramJSONObject.optString("btn_text");
      this.type = paramJSONObject.optInt("type");
      this.title = paramJSONObject.optString("title");
      this.qwq = paramJSONObject.optString("small_title");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.n
 * JD-Core Version:    0.7.0.1
 */