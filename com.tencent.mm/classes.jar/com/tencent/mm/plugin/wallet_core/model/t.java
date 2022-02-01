package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t
{
  public String MpW;
  public String desc;
  public int jumpType;
  public String jumpUrl;
  public String path;
  public String title;
  public String username;
  
  public static ArrayList<t> bgx(String paramString)
  {
    AppMethodBeat.i(301169);
    localArrayList = new ArrayList();
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(301169);
      return localArrayList;
    }
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.optJSONObject(i);
        if (localJSONObject != null) {
          localArrayList.add(cs(localJSONObject));
        }
        i += 1;
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("PayManageLabel", paramString, "", new Object[0]);
      AppMethodBeat.o(301169);
    }
  }
  
  public static t cs(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(301167);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(301167);
      return null;
    }
    t localt = new t();
    localt.title = paramJSONObject.optString("title");
    localt.desc = paramJSONObject.optString("desc");
    localt.MpW = paramJSONObject.optString("logo_url");
    localt.jumpType = paramJSONObject.optInt("jump_type", 0);
    localt.jumpUrl = paramJSONObject.optString("jump_url");
    localt.username = paramJSONObject.optString("username");
    localt.path = paramJSONObject.optString("path");
    AppMethodBeat.o(301167);
    return localt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.t
 * JD-Core Version:    0.7.0.1
 */