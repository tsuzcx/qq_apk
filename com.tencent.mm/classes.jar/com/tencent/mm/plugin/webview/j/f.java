package com.tencent.mm.plugin.webview.j;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  private static int YB(int paramInt)
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
  
  public static int a(Context paramContext, e parame, String paramString)
  {
    AppMethodBeat.i(82379);
    try
    {
      localay = ay.gq("WebViewFontUtil", 2);
      bool = localay.getBoolean("webview_key_font_use_system", false);
      ae.i("MicroMsg.WebViewFontUtil", "useSystemFont = %b", new Object[] { Boolean.valueOf(bool) });
      if (bool)
      {
        i = hj(paramContext);
        AppMethodBeat.o(82379);
        return i;
      }
      bool = localay.getBoolean("webview_key_font_has_set", false);
      if ((!bu.isNullOrNil(paramString)) && (com.tencent.mm.plugin.webview.a.DXw.matcher(paramString).matches()))
      {
        j = parame.je(16388, 2);
        if ((j == 2) && (!bool)) {
          i = j;
        }
      }
    }
    catch (Exception paramContext)
    {
      ay localay;
      boolean bool;
      int j;
      int k;
      i = 2;
    }
    try
    {
      j = hj(paramContext);
      AppMethodBeat.o(82379);
      return j;
    }
    catch (Exception paramContext)
    {
      break label312;
    }
    int i = j;
    bool = localay.getBoolean("webview_key_has_transfer_mp", false);
    if (bool)
    {
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    k = YB(j);
    i = j;
    localay.putBoolean("webview_key_has_transfer_mp", true);
    i = j;
    parame.jf(16388, k);
    AppMethodBeat.o(82379);
    return k;
    j = parame.je(16384, 2);
    if ((j == 2) && (!bool))
    {
      i = j;
      j = hj(paramContext);
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    bool = localay.getBoolean("webview_key_has_transfer_reader", false);
    if (bool)
    {
      AppMethodBeat.o(82379);
      return j;
    }
    i = j;
    k = YB(j);
    i = j;
    localay.putBoolean("webview_key_has_transfer_reader", true);
    i = j;
    parame.jf(16384, k);
    AppMethodBeat.o(82379);
    return k;
    label312:
    ae.e("MicroMsg.WebViewFontUtil", "onLoadJsApiFinished, ex = " + paramContext.getMessage());
    AppMethodBeat.o(82379);
    return i;
  }
  
  public static int hj(Context paramContext)
  {
    AppMethodBeat.i(82380);
    float f = paramContext.getSharedPreferences(ak.fow(), 0).getFloat("current_text_size_scale_key", 1.0F);
    if (f == com.tencent.mm.cb.a.id(paramContext))
    {
      AppMethodBeat.o(82380);
      return 1;
    }
    if (f == com.tencent.mm.cb.a.ie(paramContext))
    {
      AppMethodBeat.o(82380);
      return 2;
    }
    if (f == com.tencent.mm.cb.a.jdMethod_if(paramContext))
    {
      AppMethodBeat.o(82380);
      return 3;
    }
    if (f == com.tencent.mm.cb.a.ig(paramContext))
    {
      AppMethodBeat.o(82380);
      return 4;
    }
    if (f == com.tencent.mm.cb.a.ih(paramContext))
    {
      AppMethodBeat.o(82380);
      return 5;
    }
    if (f == com.tencent.mm.cb.a.ii(paramContext))
    {
      AppMethodBeat.o(82380);
      return 6;
    }
    if (f == com.tencent.mm.cb.a.ij(paramContext))
    {
      AppMethodBeat.o(82380);
      return 7;
    }
    if (f == com.tencent.mm.cb.a.ik(paramContext))
    {
      AppMethodBeat.o(82380);
      return 8;
    }
    AppMethodBeat.o(82380);
    return 2;
  }
  
  public static void vD(boolean paramBoolean)
  {
    AppMethodBeat.i(160473);
    ay localay = ay.gq("WebViewFontUtil", 2);
    localay.putBoolean("webview_key_font_use_system", paramBoolean);
    localay.apply();
    AppMethodBeat.o(160473);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.j.f
 * JD-Core Version:    0.7.0.1
 */