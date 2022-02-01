package com.tencent.mm.plugin.webview.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;

public final class a
{
  public static final String[] akjy = { "cache", "publicCache" };
  
  public static boolean a(p paramp, j paramj)
  {
    AppMethodBeat.i(294557);
    if ((paramj == null) || (paramp == null) || (TextUtils.isEmpty(paramp.function)))
    {
      AppMethodBeat.o(294557);
      return false;
    }
    String[] arrayOfString = akjy;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.equalsIgnoreCase(paramp.function))
      {
        paramj.callback(paramp, str + ":not in white list", null);
        AppMethodBeat.o(294557);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(294557);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.d.a
 * JD-Core Version:    0.7.0.1
 */