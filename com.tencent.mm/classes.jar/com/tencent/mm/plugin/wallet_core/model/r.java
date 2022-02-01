package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  public String Dnv;
  public String Dnw;
  public int Dpj;
  public List<a> Dpk;
  public boolean oFM;
  public int oGc;
  public String url;
  
  public r()
  {
    AppMethodBeat.i(190192);
    this.Dpk = new ArrayList();
    AppMethodBeat.o(190192);
  }
  
  public static r bj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(190193);
    if (paramJSONObject != null)
    {
      r localr = new r();
      localr.Dpj = paramJSONObject.optInt("block_layer_report_id");
      localr.oFM = paramJSONObject.optBoolean("is_show");
      localr.oGc = paramJSONObject.optInt("action_type");
      localr.Dnv = paramJSONObject.optString("tiny_app_username");
      localr.Dnw = paramJSONObject.optString("tiny_app_path");
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
            locala.Dpf = localJSONObject.optString("main_wording");
            locala.Dpg = localJSONObject.optString("reminder_content");
            locala.Dpl = localJSONObject.optString("action_btn_text");
            locala.language = localJSONObject.optString("language");
            localr.Dpk.add(locala);
            i += 1;
          }
        }
      }
      AppMethodBeat.o(190193);
      return localr;
    }
    AppMethodBeat.o(190193);
    return null;
  }
  
  public static final class a
  {
    public String Dpf;
    public String Dpg;
    public String Dpl;
    public String language;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */