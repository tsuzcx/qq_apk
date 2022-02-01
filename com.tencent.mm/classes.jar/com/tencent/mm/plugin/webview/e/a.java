package com.tencent.mm.plugin.webview.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;

public final class a
{
  public static final String[] SuK = { "cache", "publicCache" };
  
  public static boolean a(n paramn, h paramh)
  {
    AppMethodBeat.i(218700);
    if ((paramh == null) || (paramn == null) || (TextUtils.isEmpty(paramn.function)))
    {
      AppMethodBeat.o(218700);
      return false;
    }
    String[] arrayOfString = SuK;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.equalsIgnoreCase(paramn.function))
      {
        paramh.a(paramn, str + ":not in white list", null);
        AppMethodBeat.o(218700);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(218700);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.a
 * JD-Core Version:    0.7.0.1
 */