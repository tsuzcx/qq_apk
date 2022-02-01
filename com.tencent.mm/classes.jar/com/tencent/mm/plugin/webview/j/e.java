package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e
{
  private static int We(int paramInt)
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
      localaw = aw.fK("WebViewFontUtil", 2);
      bool = localaw.getBoolean("webview_key_font_use_system", false);
      ac.i("MicroMsg.WebViewFontUtil", "useSystemFont = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        i = gY(paramContext);
        AppMethodBeat.o(82379);
        return i;
      }
      bool = localaw.getBoolean("webview_key_font_has_set", false);
      if ((!bs.isNullOrNil(paramString)) && (com.tencent.mm.plugin.webview.a.CcA.matcher(paramString).matches()))
      {
        j = parame.iN(16388, 2);
        if ((j == 2) && (!bool)) {
          i = j;
        }
      }
    }
    catch (Exception paramContext)
    {
      aw localaw;
      boolean bool;
      int j;
      int k;
      i = 2;
    }
    try
    {
      j = gY(paramContext);
      AppMethodBeat.o(82379);
      return j;
    }
    catch (Exception paramContext)
    {
      break label312;
    }
    int i = j;
    bool = localaw.getBoolean("webview_key_has_transfer_mp", false);
    if (bool)
    {
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    k = We(j);
    i = j;
    localaw.putBoolean("webview_key_has_transfer_mp", true);
    i = j;
    parame.iO(16388, k);
    AppMethodBeat.o(82379);
    return k;
    j = parame.iN(16384, 2);
    if ((j == 2) && (!bool))
    {
      i = j;
      j = gY(paramContext);
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    bool = localaw.getBoolean("webview_key_has_transfer_reader", false);
    if (bool)
    {
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    k = We(j);
    i = j;
    localaw.putBoolean("webview_key_has_transfer_reader", true);
    i = j;
    parame.iO(16384, k);
    AppMethodBeat.o(82379);
    return k;
    label312:
    ac.e("MicroMsg.WebViewFontUtil", "onLoadJsApiFinished, ex = " + paramContext.getMessage());
    AppMethodBeat.o(82379);
    return i;
  }
  
  public static int gY(Context paramContext)
  {
    AppMethodBeat.i(82380);
    float f = paramContext.getSharedPreferences(ai.eUX(), 0).getFloat("current_text_size_scale_key", 1.0F);
    if (f == com.tencent.mm.cc.a.hP(paramContext))
    {
      AppMethodBeat.o(82380);
      return 1;
    }
    if (f == com.tencent.mm.cc.a.hQ(paramContext))
    {
      AppMethodBeat.o(82380);
      return 2;
    }
    if (f == com.tencent.mm.cc.a.hR(paramContext))
    {
      AppMethodBeat.o(82380);
      return 3;
    }
    if (f == com.tencent.mm.cc.a.hS(paramContext))
    {
      AppMethodBeat.o(82380);
      return 4;
    }
    if (f == com.tencent.mm.cc.a.hT(paramContext))
    {
      AppMethodBeat.o(82380);
      return 5;
    }
    if (f == com.tencent.mm.cc.a.hU(paramContext))
    {
      AppMethodBeat.o(82380);
      return 6;
    }
    if (f == com.tencent.mm.cc.a.hV(paramContext))
    {
      AppMethodBeat.o(82380);
      return 7;
    }
    if (f == com.tencent.mm.cc.a.hW(paramContext))
    {
      AppMethodBeat.o(82380);
      return 8;
    }
    AppMethodBeat.o(82380);
    return 2;
  }
  
  public static void uJ(boolean paramBoolean)
  {
    AppMethodBeat.i(160473);
    aw localaw = aw.fK("WebViewFontUtil", 2);
    localaw.putBoolean("webview_key_font_use_system", paramBoolean);
    localaw.apply();
    AppMethodBeat.o(160473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.e
 * JD-Core Version:    0.7.0.1
 */