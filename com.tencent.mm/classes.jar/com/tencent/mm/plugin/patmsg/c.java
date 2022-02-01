package com.tencent.mm.plugin.patmsg;

import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
{
  private static ax wFy;
  
  static
  {
    AppMethodBeat.i(215688);
    wFy = ax.aQz("pat_user_mmkv");
    AppMethodBeat.o(215688);
  }
  
  public static String auj(String paramString)
  {
    AppMethodBeat.i(215683);
    try
    {
      paramString = (String)iu(paramString, "pat_user_suffix_content");
      AppMethodBeat.o(215683);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
        paramString = "";
      }
    }
  }
  
  public static int auk(String paramString)
  {
    AppMethodBeat.i(215685);
    try
    {
      i = ((Integer)iu(paramString, "pat_user_suffix_version")).intValue();
      AppMethodBeat.o(215685);
      return i;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
        int i = 0;
      }
    }
  }
  
  public static void eC(String paramString, int paramInt)
  {
    AppMethodBeat.i(215684);
    try
    {
      i(paramString, "pat_user_suffix_version", Integer.valueOf(paramInt));
      AppMethodBeat.o(215684);
      return;
    }
    catch (JSONException paramString)
    {
      ad.printErrStackTrace("MicroMsg.PatUserMMKV", paramString, "", new Object[0]);
      AppMethodBeat.o(215684);
    }
  }
  
  private static void i(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(215686);
    if (!bt.isNullOrNil(paramString1)) {
      if (!wFy.containsKey(paramString1)) {
        break label69;
      }
    }
    label69:
    for (JSONObject localJSONObject = new JSONObject(wFy.getString(paramString1, ""));; localJSONObject = new JSONObject())
    {
      localJSONObject.put(paramString2, paramObject);
      wFy.putString(paramString1, localJSONObject.toString()).commit();
      AppMethodBeat.o(215686);
      return;
    }
  }
  
  public static void it(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215682);
    try
    {
      i(paramString1, "pat_user_suffix_content", paramString2);
      AppMethodBeat.o(215682);
      return;
    }
    catch (Exception paramString1)
    {
      ad.printErrStackTrace("MicroMsg.PatUserMMKV", paramString1, "", new Object[0]);
      AppMethodBeat.o(215682);
    }
  }
  
  private static Object iu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(215687);
    if ((!bt.isNullOrNil(paramString1)) && (wFy.containsKey(paramString1)))
    {
      paramString1 = new JSONObject(wFy.getString(paramString1, ""));
      if (paramString1.has(paramString2))
      {
        paramString1 = paramString1.get(paramString2);
        AppMethodBeat.o(215687);
        return paramString1;
      }
    }
    AppMethodBeat.o(215687);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.patmsg.c
 * JD-Core Version:    0.7.0.1
 */