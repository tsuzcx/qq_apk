package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ar$a
{
  private static SharedPreferences uKq;
  public static String yoH;
  public static String yoI;
  
  static
  {
    AppMethodBeat.i(93418);
    uKq = ah.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    yoH = "pref_key_is_enable_MultiProcSP";
    yoI = "pref_key_is_disabled_MultiProcSP_manually";
    AppMethodBeat.o(93418);
  }
  
  private static boolean app(String paramString)
  {
    AppMethodBeat.i(93416);
    reload();
    if (uKq == null)
    {
      ab.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(93416);
      return false;
    }
    boolean bool = uKq.getBoolean(paramString, false);
    ab.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(93416);
    return bool;
  }
  
  public static boolean dtn()
  {
    AppMethodBeat.i(93414);
    if ((!app(yoI)) && (app(yoH)))
    {
      AppMethodBeat.o(93414);
      return true;
    }
    AppMethodBeat.o(93414);
    return false;
  }
  
  public static void pJ(boolean paramBoolean)
  {
    AppMethodBeat.i(93413);
    setValue(yoI, paramBoolean);
    AppMethodBeat.o(93413);
  }
  
  private static void reload()
  {
    AppMethodBeat.i(93415);
    uKq = ah.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    AppMethodBeat.o(93415);
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(93417);
    if (uKq == null)
    {
      ab.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(93417);
      return;
    }
    SharedPreferences.Editor localEditor = uKq.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
    AppMethodBeat.o(93417);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ar.a
 * JD-Core Version:    0.7.0.1
 */