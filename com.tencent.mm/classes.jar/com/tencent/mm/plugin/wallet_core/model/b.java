package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public int AYG = 0;
  public int AYH = 0;
  public int AYI = 0;
  public double AYJ = 0.0D;
  public String BtS;
  public LinkedList<b.b> BtT;
  public String BtU;
  public String BtV;
  public a BtW;
  public double wKO = 0.0D;
  
  public static a aR(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70212);
    a locala = new a();
    if (paramJSONObject != null) {
      try
      {
        locala.BtX = paramJSONObject.optString("sector_title", "");
        paramJSONObject = paramJSONObject.optJSONArray("label");
        if (paramJSONObject != null)
        {
          locala.BtY = new c[paramJSONObject.length()];
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            c localc = new c();
            localc.title = localJSONObject.optString("title", "");
            localc.desc = localJSONObject.optString("desc", "");
            localc.hhs = localJSONObject.optString("logo_url", "");
            localc.vjP = localJSONObject.optInt("jump_type");
            localc.nWj = localJSONObject.optString("jump_url", "");
            localc.username = localJSONObject.optString("username", "");
            localc.path = localJSONObject.optString("path", "");
            locala.BtY[i] = localc;
            i += 1;
          }
        }
        AppMethodBeat.o(70212);
      }
      catch (JSONException paramJSONObject) {}
    }
    return locala;
  }
  
  public static final class a
  {
    public String BtX;
    public b.c[] BtY;
    
    public a()
    {
      AppMethodBeat.i(70211);
      this.BtX = "";
      this.BtY = new b.c[0];
      AppMethodBeat.o(70211);
    }
  }
  
  public static final class c
  {
    public String desc;
    public String hhs;
    public String nWj;
    public String path;
    public String title;
    public String username;
    public int vjP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.b
 * JD-Core Version:    0.7.0.1
 */