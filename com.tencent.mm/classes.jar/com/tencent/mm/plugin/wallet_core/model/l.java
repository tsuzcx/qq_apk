package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class l
{
  public String content;
  public String title;
  public String uia;
  public List<l.a> uib;
  
  public static l aD(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46765);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(46765);
      return null;
    }
    l locall = new l();
    locall.title = paramJSONObject.optString("title");
    locall.content = paramJSONObject.optString("content");
    locall.uia = paramJSONObject.optString("content_not_enough");
    locall.uib = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray("show_infos");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        l.a locala = l.a.aE(paramJSONObject.optJSONObject(i));
        if (locala != null) {
          locall.uib.add(locala);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(46765);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.l
 * JD-Core Version:    0.7.0.1
 */