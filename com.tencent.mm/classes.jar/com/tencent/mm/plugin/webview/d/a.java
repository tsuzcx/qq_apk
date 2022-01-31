package com.tencent.mm.plugin.webview.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;

public final class a
{
  public static final String[] vIR = { "cache", "publicCache" };
  
  public static boolean a(i parami, g paramg)
  {
    AppMethodBeat.i(153141);
    if ((paramg == null) || (parami == null) || (TextUtils.isEmpty(parami.vrQ)))
    {
      AppMethodBeat.o(153141);
      return false;
    }
    String[] arrayOfString = vIR;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.equalsIgnoreCase(parami.vrQ))
      {
        paramg.a(parami, str + ":not in white list", null);
        AppMethodBeat.o(153141);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(153141);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.a
 * JD-Core Version:    0.7.0.1
 */