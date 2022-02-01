package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ax$a
{
  private static SharedPreferences DUF;
  public static String IyF;
  public static String IyG;
  
  static
  {
    AppMethodBeat.i(156208);
    DUF = ak.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    IyF = "pref_key_is_enable_MultiProcSP";
    IyG = "pref_key_is_disabled_MultiProcSP_manually";
    AppMethodBeat.o(156208);
  }
  
  private static boolean aRV(String paramString)
  {
    AppMethodBeat.i(156206);
    reload();
    if (DUF == null)
    {
      ae.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(156206);
      return false;
    }
    boolean bool = DUF.getBoolean(paramString, false);
    ae.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(156206);
    return bool;
  }
  
  public static boolean foY()
  {
    AppMethodBeat.i(156204);
    if ((!aRV(IyG)) && (aRV(IyF)))
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
    DUF = ak.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    AppMethodBeat.o(156205);
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156207);
    if (DUF == null)
    {
      ae.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(156207);
      return;
    }
    SharedPreferences.Editor localEditor = DUF.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
    AppMethodBeat.o(156207);
  }
  
  public static void wP(boolean paramBoolean)
  {
    AppMethodBeat.i(156203);
    setValue(IyG, paramBoolean);
    AppMethodBeat.o(156203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ax.a
 * JD-Core Version:    0.7.0.1
 */