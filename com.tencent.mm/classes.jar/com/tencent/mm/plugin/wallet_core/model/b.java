package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public double Cpd = 0.0D;
  public String HVg;
  public LinkedList<b.b> HVh;
  public String HVi;
  public String HVj;
  public a HVk;
  public int Hvm = 0;
  public int Hvn = 0;
  public int Hvo = 0;
  public double Hvp = 0.0D;
  
  public static a bz(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(70212);
    a locala = new a();
    if (paramJSONObject != null) {
      try
      {
        locala.HVl = paramJSONObject.optString("sector_title", "");
        paramJSONObject = paramJSONObject.optJSONArray("label");
        if (paramJSONObject != null)
        {
          locala.HVm = new c[paramJSONObject.length()];
          int i = 0;
          while (i < paramJSONObject.length())
          {
            JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
            c localc = new c();
            localc.title = localJSONObject.optString("title", "");
            localc.desc = localJSONObject.optString("desc", "");
            localc.iwv = localJSONObject.optString("logo_url", "");
            localc.uSc = localJSONObject.optInt("jump_type");
            localc.pTL = localJSONObject.optString("jump_url", "");
            localc.username = localJSONObject.optString("username", "");
            localc.path = localJSONObject.optString("path", "");
            locala.HVm[i] = localc;
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
    public String HVl;
    public b.c[] HVm;
    
    public a()
    {
      AppMethodBeat.i(70211);
      this.HVl = "";
      this.HVm = new b.c[0];
      AppMethodBeat.o(70211);
    }
  }
  
  public static final class c
  {
    public String desc;
    public String iwv;
    public String pTL;
    public String path;
    public String title;
    public int uSc;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.b
 * JD-Core Version:    0.7.0.1
 */