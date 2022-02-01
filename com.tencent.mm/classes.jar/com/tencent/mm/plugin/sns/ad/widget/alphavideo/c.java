package com.tencent.mm.plugin.sns.ad.widget.alphavideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  private static boolean Qfg = true;
  
  public static void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310503);
    if (Qfg) {
      Log.d("AlphaPlayer_".concat(String.valueOf(paramString1)), String.valueOf(paramString2));
    }
    AppMethodBeat.o(310503);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310508);
    if (Qfg) {
      Log.e("AlphaPlayer_".concat(String.valueOf(paramString1)), String.valueOf(paramString2));
    }
    AppMethodBeat.o(310508);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(310520);
    if (Qfg) {
      Log.e("AlphaPlayer_".concat(String.valueOf(paramString1)), String.valueOf(paramString2), new Object[] { paramThrowable });
    }
    AppMethodBeat.o(310520);
  }
  
  public static void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(310514);
    if (Qfg) {
      Log.e("AlphaPlayer_", String.valueOf(paramString), new Object[] { paramThrowable });
    }
    AppMethodBeat.o(310514);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310525);
    if (Qfg) {
      Log.i("AlphaPlayer_".concat(String.valueOf(paramString1)), String.valueOf(paramString2));
    }
    AppMethodBeat.o(310525);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    AppMethodBeat.i(310530);
    if (Qfg) {
      Log.w("AlphaPlayer_".concat(String.valueOf(paramString1)), String.valueOf(paramString2));
    }
    AppMethodBeat.o(310530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.widget.alphavideo.c
 * JD-Core Version:    0.7.0.1
 */