package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aw$a
{
  private static SharedPreferences DCH;
  public static String Ieu;
  public static String Iev;
  
  static
  {
    AppMethodBeat.i(156208);
    DCH = aj.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    Ieu = "pref_key_is_enable_MultiProcSP";
    Iev = "pref_key_is_disabled_MultiProcSP_manually";
    AppMethodBeat.o(156208);
  }
  
  private static boolean aQy(String paramString)
  {
    AppMethodBeat.i(156206);
    reload();
    if (DCH == null)
    {
      ad.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(156206);
      return false;
    }
    boolean bool = DCH.getBoolean(paramString, false);
    ad.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(bool) });
    AppMethodBeat.o(156206);
    return bool;
  }
  
  public static boolean fld()
  {
    AppMethodBeat.i(156204);
    if ((!aQy(Iev)) && (aQy(Ieu)))
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
    DCH = aj.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    AppMethodBeat.o(156205);
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156207);
    if (DCH == null)
    {
      ad.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(156207);
      return;
    }
    SharedPreferences.Editor localEditor = DCH.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
    AppMethodBeat.o(156207);
  }
  
  public static void wH(boolean paramBoolean)
  {
    AppMethodBeat.i(156203);
    setValue(Iev, paramBoolean);
    AppMethodBeat.o(156203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.aw.a
 * JD-Core Version:    0.7.0.1
 */