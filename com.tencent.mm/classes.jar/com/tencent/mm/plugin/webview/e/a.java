package com.tencent.mm.plugin.webview.e;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;

public final class a
{
  public static final String[] UtG = { "cache", "publicCache" };
  
  public static boolean a(n paramn, f paramf)
  {
    AppMethodBeat.i(211023);
    if ((paramf == null) || (paramn == null) || (TextUtils.isEmpty(paramn.mhO)))
    {
      AppMethodBeat.o(211023);
      return false;
    }
    String[] arrayOfString = UtG;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (str.equalsIgnoreCase(paramn.mhO))
      {
        paramf.a(paramn, str + ":not in white list", null);
        AppMethodBeat.o(211023);
        return true;
      }
      i += 1;
    }
    AppMethodBeat.o(211023);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.e.a
 * JD-Core Version:    0.7.0.1
 */