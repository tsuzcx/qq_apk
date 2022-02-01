package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public int CQv = 0;
  public int CQw = 0;
  public int CQx = 0;
  public double CQy = 0.0D;
  public String DlN;
  public LinkedList<b> DlO;
  public String DlP;
  public String DlQ;
  public a DlR;
  public double yon = 0.0D;
  
  public static a aZ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70212);
    a locala = new a();
    if (paramJSONObject != null) {
      try
      {
        locala.DlS = paramJSONObject.optString("sector_title", "");
        paramJSONObject = paramJSONObject.optJSONArray("label");
        if (paramJSONObject != null)
        {
          locala.DlT = new c[paramJSONObject.length()];
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            c localc = new c();
            localc.title = localJSONObject.optString("title", "");
            localc.desc = localJSONObject.optString("desc", "");
            localc.hCp = localJSONObject.optString("logo_url", "");
            localc.uIW = localJSONObject.optInt("jump_type");
            localc.oGf = localJSONObject.optString("jump_url", "");
            localc.username = localJSONObject.optString("username", "");
            localc.path = localJSONObject.optString("path", "");
            locala.DlT[i] = localc;
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
    public String DlS;
    public b.c[] DlT;
    
    public a()
    {
      AppMethodBeat.i(70211);
      this.DlS = "";
      this.DlT = new b.c[0];
      AppMethodBeat.o(70211);
    }
  }
  
  public static final class b
  {
    public String key;
    public String value;
  }
  
  public static final class c
  {
    public String desc;
    public String hCp;
    public String oGf;
    public String path;
    public String title;
    public int uIW;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.b
 * JD-Core Version:    0.7.0.1
 */