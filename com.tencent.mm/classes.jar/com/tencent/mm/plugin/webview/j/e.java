package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static int TW(int paramInt)
  {
    if (paramInt == 1) {
      return 1;
    }
    if (paramInt == 2) {
      return 2;
    }
    if (paramInt == 3) {
      return 4;
    }
    if (paramInt == 4) {
      return 6;
    }
    return 2;
  }
  
  public static int a(Context paramContext, com.tencent.mm.plugin.webview.stub.e parame, String paramString)
  {
    AppMethodBeat.i(82379);
    try
    {
      localax = ax.fF("WebViewFontUtil", 2);
      bool = localax.getBoolean("webview_key_font_use_system", false);
      ad.i("MicroMsg.WebViewFontUtil", "useSystemFont = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        i = gN(paramContext);
        AppMethodBeat.o(82379);
        return i;
      }
      bool = localax.getBoolean("webview_key_font_has_set", false);
      if ((!bt.isNullOrNil(paramString)) && (com.tencent.mm.plugin.webview.a.AKj.matcher(paramString).matches()))
      {
        j = parame.iz(16388, 2);
        if ((j == 2) && (!bool)) {
          i = j;
        }
      }
    }
    catch (Exception paramContext)
    {
      ax localax;
      boolean bool;
      int j;
      int k;
      i = 2;
    }
    try
    {
      j = gN(paramContext);
      AppMethodBeat.o(82379);
      return j;
    }
    catch (Exception paramContext)
    {
      break label312;
    }
    int i = j;
    bool = localax.getBoolean("webview_key_has_transfer_mp", false);
    if (bool)
    {
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    k = TW(j);
    i = j;
    localax.putBoolean("webview_key_has_transfer_mp", true);
    i = j;
    parame.iA(16388, k);
    AppMethodBeat.o(82379);
    return k;
    j = parame.iz(16384, 2);
    if ((j == 2) && (!bool))
    {
      i = j;
      j = gN(paramContext);
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    bool = localax.getBoolean("webview_key_has_transfer_reader", false);
    if (bool)
    {
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    k = TW(j);
    i = j;
    localax.putBoolean("webview_key_has_transfer_reader", true);
    i = j;
    parame.iA(16384, k);
    AppMethodBeat.o(82379);
    return k;
    label312:
    ad.e("MicroMsg.WebViewFontUtil", "onLoadJsApiFinished, ex = " + paramContext.getMessage());
    AppMethodBeat.o(82379);
    return i;
  }
  
  public static int gN(Context paramContext)
  {
    AppMethodBeat.i(82380);
    float f = paramContext.getSharedPreferences(aj.eFD(), 0).getFloat("current_text_size_scale_key", 1.0F);
    if (f == com.tencent.mm.cd.a.hE(paramContext))
    {
      AppMethodBeat.o(82380);
      return 1;
    }
    if (f == com.tencent.mm.cd.a.hF(paramContext))
    {
      AppMethodBeat.o(82380);
      return 2;
    }
    if (f == com.tencent.mm.cd.a.hG(paramContext))
    {
      AppMethodBeat.o(82380);
      return 3;
    }
    if (f == com.tencent.mm.cd.a.hH(paramContext))
    {
      AppMethodBeat.o(82380);
      return 4;
    }
    if (f == com.tencent.mm.cd.a.hI(paramContext))
    {
      AppMethodBeat.o(82380);
      return 5;
    }
    if (f == com.tencent.mm.cd.a.hJ(paramContext))
    {
      AppMethodBeat.o(82380);
      return 6;
    }
    if (f == com.tencent.mm.cd.a.hK(paramContext))
    {
      AppMethodBeat.o(82380);
      return 7;
    }
    if (f == com.tencent.mm.cd.a.hL(paramContext))
    {
      AppMethodBeat.o(82380);
      return 8;
    }
    AppMethodBeat.o(82380);
    return 2;
  }
  
  public static void tH(boolean paramBoolean)
  {
    AppMethodBeat.i(160473);
    ax localax = ax.fF("WebViewFontUtil", 2);
    localax.putBoolean("webview_key_font_use_system", paramBoolean);
    localax.apply();
    AppMethodBeat.o(160473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.e
 * JD-Core Version:    0.7.0.1
 */