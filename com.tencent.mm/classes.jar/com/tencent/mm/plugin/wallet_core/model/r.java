package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  public String CVP;
  public String CVQ;
  public int CXE;
  public List<a> CXF;
  public int ozA;
  public boolean ozk;
  public String url;
  
  public r()
  {
    AppMethodBeat.i(199313);
    this.CXF = new ArrayList();
    AppMethodBeat.o(199313);
  }
  
  public static r bj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(199314);
    if (paramJSONObject != null)
    {
      r localr = new r();
      localr.CXE = paramJSONObject.optInt("block_layer_report_id");
      localr.ozk = paramJSONObject.optBoolean("is_show");
      localr.ozA = paramJSONObject.optInt("action_type");
      localr.CVP = paramJSONObject.optString("tiny_app_username");
      localr.CVQ = paramJSONObject.optString("tiny_app_path");
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
            locala.CXA = localJSONObject.optString("main_wording");
            locala.CXB = localJSONObject.optString("reminder_content");
            locala.CXG = localJSONObject.optString("action_btn_text");
            locala.language = localJSONObject.optString("language");
            localr.CXF.add(locala);
            i += 1;
          }
        }
      }
      AppMethodBeat.o(199314);
      return localr;
    }
    AppMethodBeat.o(199314);
    return null;
  }
  
  public static final class a
  {
    public String CXA;
    public String CXB;
    public String CXG;
    public String language;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */