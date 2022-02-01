package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public double OjJ = 0.0D;
  public String VCS;
  public LinkedList<b> VCT;
  public String VCU;
  public String VCV;
  public a VCW;
  public int VbN = 0;
  public int VbO = 0;
  public int VbP = 0;
  public double VbQ = 0.0D;
  
  public static a cf(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70212);
    a locala = new a();
    if (paramJSONObject != null) {
      try
      {
        locala.VCX = paramJSONObject.optString("sector_title", "");
        paramJSONObject = paramJSONObject.optJSONArray("label");
        if (paramJSONObject != null)
        {
          locala.VCY = new c[paramJSONObject.length()];
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            c localc = new c();
            localc.title = localJSONObject.optString("title", "");
            localc.desc = localJSONObject.optString("desc", "");
            localc.nQG = localJSONObject.optString("logo_url", "");
            localc.jump_type = localJSONObject.optInt("jump_type");
            localc.jump_url = localJSONObject.optString("jump_url", "");
            localc.username = localJSONObject.optString("username", "");
            localc.path = localJSONObject.optString("path", "");
            locala.VCY[i] = localc;
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
    public String VCX;
    public b.c[] VCY;
    
    public a()
    {
      AppMethodBeat.i(70211);
      this.VCX = "";
      this.VCY = new b.c[0];
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
    public int jump_type;
    public String jump_url;
    public String nQG;
    public String path;
    public String title;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.b
 * JD-Core Version:    0.7.0.1
 */