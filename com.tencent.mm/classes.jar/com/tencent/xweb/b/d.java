package com.tencent.xweb.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.WebViewKind;
import com.tencent.xweb.ao;
import com.tencent.xweb.util.l;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  public static void a(WebView.WebViewKind paramWebViewKind, int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(212525);
    int i = f(paramWebViewKind);
    paramWebViewKind = new StringBuilder().append(XWalkEnvironment.getInstalledNewstVersionForCurAbi()).append(",").append(ao.kge()).append(",").append(i).append(",").append(paramInt1).append(",").append(paramInt2).append(",");
    if (paramBoolean) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      StringBuilder localStringBuilder = paramWebViewKind.append(paramInt1).append(",");
      paramWebViewKind = paramString;
      if (TextUtils.isEmpty(paramString)) {
        paramWebViewKind = "";
      }
      l.ev(24151, paramWebViewKind);
      AppMethodBeat.o(212525);
      return;
    }
  }
  
  private static int f(WebView.WebViewKind paramWebViewKind)
  {
    AppMethodBeat.i(212517);
    switch (1.ueK[paramWebViewKind.ordinal()])
    {
    default: 
      AppMethodBeat.o(212517);
      return 0;
    case 1: 
      AppMethodBeat.o(212517);
      return 1;
    case 2: 
      AppMethodBeat.o(212517);
      return 2;
    case 3: 
      AppMethodBeat.o(212517);
      return 3;
    }
    AppMethodBeat.o(212517);
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.b.d
 * JD-Core Version:    0.7.0.1
 */