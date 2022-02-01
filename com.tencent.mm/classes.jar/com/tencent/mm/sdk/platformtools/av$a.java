package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class av$a
{
  private static SharedPreferences BZL;
  public static String GsF;
  public static String GsG;
  
  static
  {
    AppMethodBeat.i(156208);
    BZL = ai.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    GsF = "pref_key_is_enable_MultiProcSP";
    GsG = "pref_key_is_disabled_MultiProcSP_manually";
    AppMethodBeat.o(156208);
  }
  
  private static boolean aKS(String paramString)
  {
    AppMethodBeat.i(156206);
    reload();
    if (BZL == null)
    {
      ac.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(156206);
      return false;
    }
    boolean bool = BZL.getBoolean(paramString, false);
    ac.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(156206);
    return bool;
  }
  
  public static boolean eVw()
  {
    AppMethodBeat.i(156204);
    if ((!aKS(GsG)) && (aKS(GsF)))
    {
      AppMethodBeat.o(156204);
      return true;
    }
    AppMethodBeat.o(156204);
    return false;
  }
  
  private static void reload()
  {
    AppMethodBeat.i(156205);
    BZL = ai.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    AppMethodBeat.o(156205);
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156207);
    if (BZL == null)
    {
      ac.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(156207);
      return;
    }
    SharedPreferences.Editor localEditor = BZL.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
    AppMethodBeat.o(156207);
  }
  
  public static void vV(boolean paramBoolean)
  {
    AppMethodBeat.i(156203);
    setValue(GsG, paramBoolean);
    AppMethodBeat.o(156203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.av.a
 * JD-Core Version:    0.7.0.1
 */