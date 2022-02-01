package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class r
{
  public String HWN;
  public String HWO;
  public int HYx;
  public List<a> HYy;
  public int pTI;
  public boolean pTt;
  public String url;
  
  public r()
  {
    AppMethodBeat.i(214194);
    this.HYy = new ArrayList();
    AppMethodBeat.o(214194);
  }
  
  public static r bJ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(214195);
    if (paramJSONObject != null)
    {
      r localr = new r();
      localr.HYx = paramJSONObject.optInt("block_layer_report_id");
      localr.pTt = paramJSONObject.optBoolean("is_show");
      localr.pTI = paramJSONObject.optInt("action_type");
      localr.HWN = paramJSONObject.optString("tiny_app_username");
      localr.HWO = paramJSONObject.optString("tiny_app_path");
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
            locala.HYt = localJSONObject.optString("main_wording");
            locala.HYu = localJSONObject.optString("reminder_content");
            locala.HYz = localJSONObject.optString("action_btn_text");
            locala.language = localJSONObject.optString("language");
            localr.HYy.add(locala);
            i += 1;
          }
        }
      }
      AppMethodBeat.o(214195);
      return localr;
    }
    AppMethodBeat.o(214195);
    return null;
  }
  
  public static final class a
  {
    public String HYt;
    public String HYu;
    public String HYz;
    public String language;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.r
 * JD-Core Version:    0.7.0.1
 */