package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k$a
{
  private static final Pattern hpo;
  private String keN = null;
  
  static
  {
    AppMethodBeat.i(9965);
    hpo = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(9965);
  }
  
  public k$a(String paramString)
  {
    this.keN = paramString;
  }
  
  public final int agV(String paramString)
  {
    AppMethodBeat.i(9964);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
      AppMethodBeat.o(9964);
      return 0;
    }
    if (paramString.equals(this.keN))
    {
      AppMethodBeat.o(9964);
      return 0;
    }
    if (hpo.matcher(paramString).find())
    {
      AppMethodBeat.o(9964);
      return 2;
    }
    AppMethodBeat.o(9964);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.a
 * JD-Core Version:    0.7.0.1
 */