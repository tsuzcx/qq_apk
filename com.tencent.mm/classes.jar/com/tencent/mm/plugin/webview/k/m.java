package com.tencent.mm.plugin.webview.k;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class m
{
  public static void Jf(boolean paramBoolean)
  {
    AppMethodBeat.i(160473);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebViewFontUtil", 2);
    localMultiProcessMMKV.putBoolean("webview_key_font_use_system", paramBoolean);
    localMultiProcessMMKV.apply();
    AppMethodBeat.o(160473);
  }
  
  public static int a(Context paramContext, e parame, String paramString)
  {
    AppMethodBeat.i(82379);
    try
    {
      localMultiProcessMMKV = MultiProcessMMKV.getMMKV("WebViewFontUtil", 2);
      bool = localMultiProcessMMKV.getBoolean("webview_key_font_use_system", false);
      Log.i("MicroMsg.WebViewFontUtil", "useSystemFont = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        i = lg(paramContext);
        AppMethodBeat.o(82379);
        return i;
      }
      bool = localMultiProcessMMKV.getBoolean("webview_key_font_has_set", false);
      if ((!Util.isNullOrNil(paramString)) && (com.tencent.mm.plugin.webview.a.Wuh.matcher(paramString).matches()))
      {
        j = parame.no(16388, 2);
        if ((j == 2) && (!bool)) {
          i = j;
        }
      }
    }
    catch (Exception paramContext)
    {
      MultiProcessMMKV localMultiProcessMMKV;
      boolean bool;
      int j;
      int k;
      i = 2;
    }
    try
    {
      j = lg(paramContext);
      AppMethodBeat.o(82379);
      return j;
    }
    catch (Exception paramContext)
    {
      break label312;
    }
    int i = j;
    bool = localMultiProcessMMKV.getBoolean("webview_key_has_transfer_mp", false);
    if (bool)
    {
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    k = avc(j);
    i = j;
    localMultiProcessMMKV.putBoolean("webview_key_has_transfer_mp", true);
    i = j;
    parame.np(16388, k);
    AppMethodBeat.o(82379);
    return k;
    j = parame.no(16384, 2);
    if ((j == 2) && (!bool))
    {
      i = j;
      j = lg(paramContext);
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    bool = localMultiProcessMMKV.getBoolean("webview_key_has_transfer_reader", false);
    if (bool)
    {
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    k = avc(j);
    i = j;
    localMultiProcessMMKV.putBoolean("webview_key_has_transfer_reader", true);
    i = j;
    parame.np(16384, k);
    AppMethodBeat.o(82379);
    return k;
    label312:
    Log.e("MicroMsg.WebViewFontUtil", "onLoadJsApiFinished, ex = " + paramContext.getMessage());
    AppMethodBeat.o(82379);
    return i;
  }
  
  private static int avc(int paramInt)
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
  
  public static int lg(Context paramContext)
  {
    AppMethodBeat.i(82380);
    float f = paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", 1.0F);
    if ((f == com.tencent.mm.cd.a.mc(paramContext)) || (f == 0.8F))
    {
      AppMethodBeat.o(82380);
      return 1;
    }
    if ((f == com.tencent.mm.cd.a.md(paramContext)) || (f == 1.0F))
    {
      AppMethodBeat.o(82380);
      return 2;
    }
    if ((f == com.tencent.mm.cd.a.me(paramContext)) || (f == 1.1F))
    {
      AppMethodBeat.o(82380);
      return 3;
    }
    if ((f == com.tencent.mm.cd.a.mf(paramContext)) || (f == 1.12F))
    {
      AppMethodBeat.o(82380);
      return 4;
    }
    if ((f == com.tencent.mm.cd.a.mg(paramContext)) || (f == 1.125F))
    {
      AppMethodBeat.o(82380);
      return 5;
    }
    if ((f == com.tencent.mm.cd.a.mh(paramContext)) || (f == 1.4F))
    {
      AppMethodBeat.o(82380);
      return 6;
    }
    if ((f == com.tencent.mm.cd.a.mi(paramContext)) || (f == 1.55F))
    {
      AppMethodBeat.o(82380);
      return 7;
    }
    if ((f == com.tencent.mm.cd.a.mj(paramContext)) || (f == 1.65F))
    {
      AppMethodBeat.o(82380);
      return 8;
    }
    AppMethodBeat.o(82380);
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.k.m
 * JD-Core Version:    0.7.0.1
 */