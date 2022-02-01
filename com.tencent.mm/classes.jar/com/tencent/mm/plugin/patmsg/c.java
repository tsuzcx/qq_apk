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
  private static MultiProcessMMKV GKq;
  
  static
  {
    AppMethodBeat.i(186429);
    GKq = MultiProcessMMKV.getMMKV("pat_user_mmkv");
    AppMethodBeat.o(186429);
  }
  
  public static String aUh(String paramString)
  {
    AppMethodBeat.i(186423);
    try
    {
      paramString = (String)jw(paramString, "pat_user_suffix_content");
      AppMethodBeat.o(186423);
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
  
  public static int aUi(String paramString)
  {
    AppMethodBeat.i(186425);
    try
    {
      i = ((Integer)jw(paramString, "pat_user_suffix_version")).intValue();
      AppMethodBeat.o(186425);
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
  
  public static void fB(String paramString, int paramInt)
  {
    AppMethodBeat.i(186424);
    try
    {
      g(paramString, "pat_user_suffix_version", Integer.valueOf(paramInt));
      AppMethodBeat.o(186424);
      return;
    }
    catch (JSONException paramString)
    {
      Log.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
      AppMethodBeat.o(186424);
    }
  }
  
  private static void g(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(186426);
    if (!Util.isNullOrNil(paramString1)) {
      if (!GKq.containsKey(paramString1)) {
        break label69;
      }
    }
    label69:
    for (JSONObject localJSONObject = new JSONObject(GKq.getString(paramString1, ""));; localJSONObject = new JSONObject())
    {
      localJSONObject.put(paramString2, paramObject);
      GKq.putString(paramString1, localJSONObject.toString()).commit();
      AppMethodBeat.o(186426);
      return;
    }
  }
  
  public static void jv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186422);
    try
    {
      g(paramString1, "pat_user_suffix_content", paramString2);
      AppMethodBeat.o(186422);
      return;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.PatUserMMKV", paramString1, "", new Object[0]);
      AppMethodBeat.o(186422);
    }
  }
  
  private static Object jw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(186427);
    if ((!Util.isNullOrNil(paramString1)) && (GKq.containsKey(paramString1)))
    {
      paramString1 = new JSONObject(GKq.getString(paramString1, ""));
      if (paramString1.has(paramString2))
      {
        paramString1 = paramString1.get(paramString2);
        AppMethodBeat.o(186427);
        return paramString1;
      }
    }
    AppMethodBeat.o(186427);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.c
 * JD-Core Version:    0.7.0.1
 */