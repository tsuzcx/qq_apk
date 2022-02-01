package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public String AbA;
  public String AbB;
  public a AbC;
  public String Aby;
  public LinkedList<b.b> Abz;
  public double vAJ = 0.0D;
  public int zGt = 0;
  public int zGu = 0;
  public int zGv = 0;
  public double zGw = 0.0D;
  
  public static a aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70212);
    a locala = new a();
    if (paramJSONObject != null) {
      try
      {
        locala.AbD = paramJSONObject.optString("sector_title", "");
        paramJSONObject = paramJSONObject.optJSONArray("label");
        if (paramJSONObject != null)
        {
          locala.AbE = new c[paramJSONObject.length()];
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            c localc = new c();
            localc.title = localJSONObject.optString("title", "");
            localc.desc = localJSONObject.optString("desc", "");
            localc.gGR = localJSONObject.optString("logo_url", "");
            localc.uaQ = localJSONObject.optInt("jump_type");
            localc.ntj = localJSONObject.optString("jump_url", "");
            localc.username = localJSONObject.optString("username", "");
            localc.path = localJSONObject.optString("path", "");
            locala.AbE[i] = localc;
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
    public String AbD;
    public b.c[] AbE;
    
    public a()
    {
      AppMethodBeat.i(70211);
      this.AbD = "";
      this.AbE = new b.c[0];
      AppMethodBeat.o(70211);
    }
  }
  
  public static final class c
  {
    public String desc;
    public String gGR;
    public String ntj;
    public String path;
    public String title;
    public int uaQ;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.b
 * JD-Core Version:    0.7.0.1
 */