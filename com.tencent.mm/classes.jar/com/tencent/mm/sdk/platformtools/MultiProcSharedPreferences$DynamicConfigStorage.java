package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MultiProcSharedPreferences$DynamicConfigStorage
{
  public static String PREF_KEY_IS_DISABLED_MULTIPROC_SP_MANUALLY;
  public static String PREF_KEY_IS_ENABLE_MULTIPROC_SP;
  private static final String PREF_NAME = "pref_MultiProcSP_dyncfg";
  private static SharedPreferences mPref;
  
  static
  {
    AppMethodBeat.i(156208);
    mPref = MMApplicationContext.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    PREF_KEY_IS_ENABLE_MULTIPROC_SP = "pref_key_is_enable_MultiProcSP";
    PREF_KEY_IS_DISABLED_MULTIPROC_SP_MANUALLY = "pref_key_is_disabled_MultiProcSP_manually";
    AppMethodBeat.o(156208);
  }
  
  private static boolean getValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(261268);
    reload();
    if (mPref == null)
    {
      Log.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(261268);
      return paramBoolean;
    }
    paramBoolean = mPref.getBoolean(paramString, paramBoolean);
    Log.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(261268);
    return paramBoolean;
  }
  
  private static boolean isDisabledManually()
  {
    AppMethodBeat.i(261265);
    boolean bool = getValue(PREF_KEY_IS_DISABLED_MULTIPROC_SP_MANUALLY, false);
    AppMethodBeat.o(261265);
    return bool;
  }
  
  public static boolean isEnabledMultiProcSP()
  {
    AppMethodBeat.i(156204);
    if ((!isDisabledManually()) && (getValue(PREF_KEY_IS_ENABLE_MULTIPROC_SP, false)))
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
    mPref = MMApplicationContext.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
    AppMethodBeat.o(156205);
  }
  
  public static void setDisabledFlagManually(boolean paramBoolean)
  {
    AppMethodBeat.i(156203);
    setValue(PREF_KEY_IS_DISABLED_MULTIPROC_SP_MANUALLY, paramBoolean);
    AppMethodBeat.o(156203);
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(156207);
    if (mPref == null)
    {
      Log.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
      AppMethodBeat.o(156207);
      return;
    }
    SharedPreferences.Editor localEditor = mPref.edit();
    localEditor.putBoolean(paramString, paramBoolean);
    localEditor.commit();
    AppMethodBeat.o(156207);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MultiProcSharedPreferences.DynamicConfigStorage
 * JD-Core Version:    0.7.0.1
 */