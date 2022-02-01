package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
{
  public String Dow;
  public List<j.a> Dox;
  public String content;
  public String title;
  
  public static j bh(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70282);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(70282);
      return null;
    }
    j localj = new j();
    localj.title = paramJSONObject.optString("title");
    localj.content = paramJSONObject.optString("content");
    localj.Dow = paramJSONObject.optString("content_not_enough");
    localj.Dox = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("show_infos");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        j.a locala = j.a.bi(paramJSONObject.optJSONObject(i));
        if (locala != null) {
          localj.Dox.add(locala);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(70282);
    return localj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.j
 * JD-Core Version:    0.7.0.1
 */