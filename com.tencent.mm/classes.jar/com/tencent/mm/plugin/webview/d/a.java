package com.tencent.mm.plugin.webview.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;

public final class a
{
  public static final String[] Jio = { "cache", "publicCache" };
  
  public static boolean a(l paraml, f paramf)
  {
    AppMethodBeat.i(198163);
    if ((paramf == null) || (paraml == null) || (TextUtils.isEmpty(paraml.lcx)))
    {
      AppMethodBeat.o(198163);
      return false;
    }
    String[] arrayOfString = Jio;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.equalsIgnoreCase(paraml.lcx))
      {
        paramf.a(paraml, str + ":not in white list", null);
        AppMethodBeat.o(198163);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(198163);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.a
 * JD-Core Version:    0.7.0.1
 */