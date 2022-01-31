package com.tencent.mm.plugin.webview.ui.tools;

import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebViewUI$l
{
  private static final Pattern hpo;
  public String keN;
  private LinkedList<String> vgT;
  String[] vgk;
  
  static
  {
    AppMethodBeat.i(7954);
    hpo = Pattern.compile(".*#.*wechat_redirect");
    AppMethodBeat.o(7954);
  }
  
  public WebViewUI$l(String paramString)
  {
    AppMethodBeat.i(7951);
    this.keN = null;
    this.vgT = new LinkedList();
    this.vgk = null;
    this.keN = paramString;
    AppMethodBeat.o(7951);
  }
  
  private boolean aiD(String paramString)
  {
    AppMethodBeat.i(7953);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7953);
      return false;
    }
    if ((this.vgk == null) || (this.vgk.length == 0))
    {
      AppMethodBeat.o(7953);
      return false;
    }
    if (this.vgT.contains(paramString))
    {
      AppMethodBeat.o(7953);
      return false;
    }
    if (URLUtil.isHttpUrl(paramString)) {}
    for (Object localObject1 = paramString.substring(7);; localObject1 = paramString)
    {
      Object localObject2 = localObject1;
      if (URLUtil.isHttpsUrl((String)localObject1)) {
        localObject2 = paramString.substring(8);
      }
      ab.i("MicroMsg.WebViewUI", "rawUrl = %s, subUrl = %s", new Object[] { paramString, localObject2 });
      localObject1 = this.vgk;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject1[i];
        ab.i("MicroMsg.WebViewUI", "force geta8key path = %s", new Object[] { str });
        if (((String)localObject2).startsWith(str))
        {
          this.vgT.add(paramString);
          AppMethodBeat.o(7953);
          return true;
        }
        i += 1;
      }
      AppMethodBeat.o(7953);
      return false;
    }
  }
  
  public final int agV(String paramString)
  {
    AppMethodBeat.i(7952);
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.WebViewUI", "getReason fail, url is null");
      AppMethodBeat.o(7952);
      return 0;
    }
    if (paramString.equals(this.keN))
    {
      AppMethodBeat.o(7952);
      return 0;
    }
    if (hpo.matcher(paramString).find())
    {
      AppMethodBeat.o(7952);
      return 2;
    }
    if (aiD(paramString))
    {
      AppMethodBeat.o(7952);
      return 8;
    }
    AppMethodBeat.o(7952);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.l
 * JD-Core Version:    0.7.0.1
 */