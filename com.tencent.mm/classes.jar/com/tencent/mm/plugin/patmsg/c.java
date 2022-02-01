package com.tencent.mm.plugin.patmsg;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static MultiProcessMMKV ARf;
  
  static
  {
    AppMethodBeat.i(206944);
    ARf = MultiProcessMMKV.getMMKV("pat_user_mmkv");
    AppMethodBeat.o(206944);
  }
  
  public static String aJL(String paramString)
  {
    AppMethodBeat.i(206939);
    try
    {
      paramString = (String)jl(paramString, "pat_user_suffix_content");
      AppMethodBeat.o(206939);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
        paramString = "";
      }
    }
  }
  
  public static int aJM(String paramString)
  {
    AppMethodBeat.i(206941);
    try
    {
      i = ((Integer)jl(paramString, "pat_user_suffix_version")).intValue();
      AppMethodBeat.o(206941);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
        int i = 0;
      }
    }
  }
  
  public static void fa(String paramString, int paramInt)
  {
    AppMethodBeat.i(206940);
    try
    {
      g(paramString, "pat_user_suffix_version", Integer.valueOf(paramInt));
      AppMethodBeat.o(206940);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
      AppMethodBeat.o(206940);
    }
  }
  
  private static void g(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(206942);
    if (!Util.isNullOrNil(paramString1)) {
      if (!ARf.containsKey(paramString1)) {
        break label69;
      }
    }
    label69:
    for (JSONObject localJSONObject = new JSONObject(ARf.getString(paramString1, ""));; localJSONObject = new JSONObject())
    {
      localJSONObject.put(paramString2, paramObject);
      ARf.putString(paramString1, localJSONObject.toString()).commit();
      AppMethodBeat.o(206942);
      return;
    }
  }
  
  public static void jk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206938);
    try
    {
      g(paramString1, "pat_user_suffix_content", paramString2);
      AppMethodBeat.o(206938);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.PatUserMMKV", paramString1, "", new Object[0]);
      AppMethodBeat.o(206938);
    }
  }
  
  private static Object jl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206943);
    if ((!Util.isNullOrNil(paramString1)) && (ARf.containsKey(paramString1)))
    {
      paramString1 = new JSONObject(ARf.getString(paramString1, ""));
      if (paramString1.has(paramString2))
      {
        paramString1 = paramString1.get(paramString2);
        AppMethodBeat.o(206943);
        return paramString1;
      }
    }
    AppMethodBeat.o(206943);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.c
 * JD-Core Version:    0.7.0.1
 */