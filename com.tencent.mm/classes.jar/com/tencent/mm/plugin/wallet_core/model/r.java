package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  public String OON;
  public String OOO;
  public int OQx;
  public List<a> OQy;
  public int tpK;
  public boolean tpu;
  public String url;
  
  public r()
  {
    AppMethodBeat.i(274622);
    this.OQy = new ArrayList();
    AppMethodBeat.o(274622);
  }
  
  public static r bU(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(274623);
    if (paramJSONObject != null)
    {
      r localr = new r();
      localr.OQx = paramJSONObject.optInt("block_layer_report_id");
      localr.tpu = paramJSONObject.optBoolean("is_show");
      localr.tpK = paramJSONObject.optInt("action_type");
      localr.OON = paramJSONObject.optString("tiny_app_username");
      localr.OOO = paramJSONObject.optString("tiny_app_path");
      localr.url = paramJSONObject.optString("url");
      if (paramJSONObject.has("text_info_array"))
      {
        paramJSONObject = paramJSONObject.optJSONArray("text_info_array");
        if (paramJSONObject != null)
        {
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.optJSONObject(i);
            a locala = new a();
            locala.OQt = localJSONObject.optString("main_wording");
            locala.OQu = localJSONObject.optString("reminder_content");
            locala.OQz = localJSONObject.optString("action_btn_text");
            locala.language = localJSONObject.optString("language");
            localr.OQy.add(locala);
            i += 1;
          }
        }
      }
      AppMethodBeat.o(274623);
      return localr;
    }
    AppMethodBeat.o(274623);
    return null;
  }
  
  public static final class a
  {
    public String OQt;
    public String OQu;
    public String OQz;
    public String language;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */