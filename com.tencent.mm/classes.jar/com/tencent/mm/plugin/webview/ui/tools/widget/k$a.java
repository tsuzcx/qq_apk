package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class k$a
{
  private static final Pattern fsW = Pattern.compile(".*#.*wechat_redirect");
  private String rfY = null;
  
  public k$a(String paramString)
  {
    this.rfY = paramString;
  }
  
  public final int TB(String paramString)
  {
    if (bk.bl(paramString)) {
      y.e("MicroMsg.MMWebViewClient", "getReason fail, url is null");
    }
    while (paramString.equals(this.rfY)) {
      return 0;
    }
    if (fsW.matcher(paramString).find()) {
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.k.a
 * JD-Core Version:    0.7.0.1
 */