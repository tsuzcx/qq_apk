package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  public String VEH;
  public String VEI;
  public int VGr;
  public List<a> VGs;
  public String url;
  public boolean wtT;
  public int wuj;
  
  public r()
  {
    AppMethodBeat.i(301163);
    this.VGs = new ArrayList();
    AppMethodBeat.o(301163);
  }
  
  public static r cp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(301165);
    if (paramJSONObject != null)
    {
      r localr = new r();
      localr.VGr = paramJSONObject.optInt("block_layer_report_id");
      localr.wtT = paramJSONObject.optBoolean("is_show");
      localr.wuj = paramJSONObject.optInt("action_type");
      localr.VEH = paramJSONObject.optString("tiny_app_username");
      localr.VEI = paramJSONObject.optString("tiny_app_path");
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
            locala.VGn = localJSONObject.optString("main_wording");
            locala.VGo = localJSONObject.optString("reminder_content");
            locala.VGt = localJSONObject.optString("action_btn_text");
            locala.language = localJSONObject.optString("language");
            localr.VGs.add(locala);
            i += 1;
          }
        }
      }
      AppMethodBeat.o(301165);
      return localr;
    }
    AppMethodBeat.o(301165);
    return null;
  }
  
  public static final class a
  {
    public String VGn;
    public String VGo;
    public String VGt;
    public String language;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */