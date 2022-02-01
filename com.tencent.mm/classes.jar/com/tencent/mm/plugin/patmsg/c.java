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
  private static MultiProcessMMKV MHf;
  
  static
  {
    AppMethodBeat.i(266360);
    MHf = MultiProcessMMKV.getMMKV("pat_user_mmkv");
    AppMethodBeat.o(266360);
  }
  
  public static String aRm(String paramString)
  {
    AppMethodBeat.i(266348);
    try
    {
      paramString = (String)kQ(paramString, "pat_user_suffix_content");
      AppMethodBeat.o(266348);
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
  
  public static int aRn(String paramString)
  {
    AppMethodBeat.i(266352);
    try
    {
      i = ((Integer)kQ(paramString, "pat_user_suffix_version")).intValue();
      AppMethodBeat.o(266352);
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
  
  public static void gu(String paramString, int paramInt)
  {
    AppMethodBeat.i(266350);
    try
    {
      j(paramString, "pat_user_suffix_version", Integer.valueOf(paramInt));
      AppMethodBeat.o(266350);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
      AppMethodBeat.o(266350);
    }
  }
  
  private static void j(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(266356);
    if (!Util.isNullOrNil(paramString1)) {
      if (!MHf.containsKey(paramString1)) {
        break label69;
      }
    }
    label69:
    for (JSONObject localJSONObject = new JSONObject(MHf.getString(paramString1, ""));; localJSONObject = new JSONObject())
    {
      localJSONObject.put(paramString2, paramObject);
      MHf.putString(paramString1, localJSONObject.toString()).commit();
      AppMethodBeat.o(266356);
      return;
    }
  }
  
  public static void kP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266344);
    try
    {
      j(paramString1, "pat_user_suffix_content", paramString2);
      AppMethodBeat.o(266344);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.PatUserMMKV", paramString1, "", new Object[0]);
      AppMethodBeat.o(266344);
    }
  }
  
  private static Object kQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(266359);
    if ((!Util.isNullOrNil(paramString1)) && (MHf.containsKey(paramString1)))
    {
      paramString1 = new JSONObject(MHf.getString(paramString1, ""));
      if (paramString1.has(paramString2))
      {
        paramString1 = paramString1.get(paramString2);
        AppMethodBeat.o(266359);
        return paramString1;
      }
    }
    AppMethodBeat.o(266359);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.c
 * JD-Core Version:    0.7.0.1
 */