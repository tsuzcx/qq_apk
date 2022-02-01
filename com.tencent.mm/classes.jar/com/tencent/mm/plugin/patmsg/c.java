package com.tencent.mm.plugin.patmsg;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static ay wVj;
  
  static
  {
    AppMethodBeat.i(220322);
    wVj = ay.aRW("pat_user_mmkv");
    AppMethodBeat.o(220322);
  }
  
  public static String avy(String paramString)
  {
    AppMethodBeat.i(220317);
    try
    {
      paramString = (String)iA(paramString, "pat_user_suffix_content");
      AppMethodBeat.o(220317);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
        paramString = "";
      }
    }
  }
  
  public static int avz(String paramString)
  {
    AppMethodBeat.i(220319);
    try
    {
      i = ((Integer)iA(paramString, "pat_user_suffix_version")).intValue();
      AppMethodBeat.o(220319);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
        int i = 0;
      }
    }
  }
  
  public static void eK(String paramString, int paramInt)
  {
    AppMethodBeat.i(220318);
    try
    {
      i(paramString, "pat_user_suffix_version", Integer.valueOf(paramInt));
      AppMethodBeat.o(220318);
      return;
    }
    catch (JSONException paramString)
    {
      ae.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
      AppMethodBeat.o(220318);
    }
  }
  
  private static void i(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(220320);
    if (!bu.isNullOrNil(paramString1)) {
      if (!wVj.containsKey(paramString1)) {
        break label69;
      }
    }
    label69:
    for (JSONObject localJSONObject = new JSONObject(wVj.getString(paramString1, ""));; localJSONObject = new JSONObject())
    {
      localJSONObject.put(paramString2, paramObject);
      wVj.putString(paramString1, localJSONObject.toString()).commit();
      AppMethodBeat.o(220320);
      return;
    }
  }
  
  private static Object iA(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220321);
    if ((!bu.isNullOrNil(paramString1)) && (wVj.containsKey(paramString1)))
    {
      paramString1 = new JSONObject(wVj.getString(paramString1, ""));
      if (paramString1.has(paramString2))
      {
        paramString1 = paramString1.get(paramString2);
        AppMethodBeat.o(220321);
        return paramString1;
      }
    }
    AppMethodBeat.o(220321);
    return null;
  }
  
  public static void iz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220316);
    try
    {
      i(paramString1, "pat_user_suffix_content", paramString2);
      AppMethodBeat.o(220316);
      return;
    }
    catch (Exception paramString1)
    {
      ae.printErrStackTrace("MicroMsg.PatUserMMKV", paramString1, "", new Object[0]);
      AppMethodBeat.o(220316);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.c
 * JD-Core Version:    0.7.0.1
 */