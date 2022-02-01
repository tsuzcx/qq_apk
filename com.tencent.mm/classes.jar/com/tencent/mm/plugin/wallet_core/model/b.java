package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public double Ims = 0.0D;
  public String ONh;
  public LinkedList<b> ONi;
  public String ONj;
  public String ONk;
  public a ONl;
  public int OmZ = 0;
  public int Ona = 0;
  public int Onb = 0;
  public double Onc = 0.0D;
  
  public static a bK(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70212);
    a locala = new a();
    if (paramJSONObject != null) {
      try
      {
        locala.ONm = paramJSONObject.optString("sector_title", "");
        paramJSONObject = paramJSONObject.optJSONArray("label");
        if (paramJSONObject != null)
        {
          locala.ONn = new c[paramJSONObject.length()];
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            c localc = new c();
            localc.title = localJSONObject.optString("title", "");
            localc.desc = localJSONObject.optString("desc", "");
            localc.llI = localJSONObject.optString("logo_url", "");
            localc.jump_type = localJSONObject.optInt("jump_type");
            localc.jump_url = localJSONObject.optString("jump_url", "");
            localc.username = localJSONObject.optString("username", "");
            localc.path = localJSONObject.optString("path", "");
            locala.ONn[i] = localc;
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
    public String ONm;
    public b.c[] ONn;
    
    public a()
    {
      AppMethodBeat.i(70211);
      this.ONm = "";
      this.ONn = new b.c[0];
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
    public String llI;
    public String path;
    public String title;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.b
 * JD-Core Version:    0.7.0.1
 */