package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  public double qjH = 0.0D;
  public int tNT = 0;
  public int tNU = 0;
  public int tNV = 0;
  public double tNW = 0.0D;
  public String ufo;
  public LinkedList<c.b> ufp;
  public String ufq;
  public String ufr;
  public c.a ufs;
  
  public static c.a av(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46701);
    c.a locala = new c.a();
    if (paramJSONObject != null) {
      try
      {
        locala.uft = paramJSONObject.optString("sector_title", "");
        paramJSONObject = paramJSONObject.optJSONArray("label");
        if (paramJSONObject != null)
        {
          locala.ufu = new c.c[paramJSONObject.length()];
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            c.c localc = new c.c();
            localc.title = localJSONObject.optString("title", "");
            localc.desc = localJSONObject.optString("desc", "");
            localc.kmm = localJSONObject.optString("logo_url", "");
            localc.pdt = localJSONObject.optInt("jump_type");
            localc.knV = localJSONObject.optString("jump_url", "");
            localc.username = localJSONObject.optString("username", "");
            localc.path = localJSONObject.optString("path", "");
            locala.ufu[i] = localc;
            i += 1;
          }
        }
        AppMethodBeat.o(46701);
      }
      catch (JSONException paramJSONObject) {}
    }
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.c
 * JD-Core Version:    0.7.0.1
 */