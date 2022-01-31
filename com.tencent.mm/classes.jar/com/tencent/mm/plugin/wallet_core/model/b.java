package com.tencent.mm.plugin.wallet_core.model;

import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public double nyG = 0.0D;
  public int qgC = 0;
  public int qgD = 0;
  public int qgE = 0;
  public double qgF = 0.0D;
  public String qtd;
  public LinkedList<b.b> qte;
  public String qtf;
  public String qtg;
  public b.a qth;
  
  public static b.a al(JSONObject paramJSONObject)
  {
    locala = new b.a();
    if (paramJSONObject != null) {
      try
      {
        locala.qti = paramJSONObject.optString("sector_title", "");
        paramJSONObject = paramJSONObject.optJSONArray("label");
        if (paramJSONObject != null)
        {
          locala.qtj = new b.c[paramJSONObject.length()];
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            b.c localc = new b.c();
            localc.title = localJSONObject.optString("title", "");
            localc.desc = localJSONObject.optString("desc", "");
            localc.ilp = localJSONObject.optString("logo_url", "");
            localc.qho = localJSONObject.optInt("jump_type");
            localc.ina = localJSONObject.optString("jump_url", "");
            locala.qtj[i] = localc;
            i += 1;
          }
        }
        return locala;
      }
      catch (JSONException paramJSONObject) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.b
 * JD-Core Version:    0.7.0.1
 */