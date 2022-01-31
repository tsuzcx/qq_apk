package com.tencent.mm.plugin.webview.ui.tools;

import android.webkit.URLUtil;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class WebViewUI$m
{
  private static final Pattern fsW = Pattern.compile(".*#.*wechat_redirect");
  public String rfY = null;
  String[] rpq = null;
  private LinkedList<String> rqO = new LinkedList();
  
  public WebViewUI$m(String paramString)
  {
    this.rfY = paramString;
  }
  
  public final int TB(String paramString)
  {
    int k = 0;
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.WebViewUI", "getReason fail, url is null");
      return 0;
    }
    if (paramString.equals(this.rfY)) {
      return 0;
    }
    if (fsW.matcher(paramString).find()) {
      return 2;
    }
    int i = k;
    if (!bk.bl(paramString))
    {
      i = k;
      if (this.rpq != null)
      {
        if (this.rpq.length != 0) {
          break label85;
        }
        i = k;
      }
    }
    while (i != 0)
    {
      return 8;
      label85:
      i = k;
      if (!this.rqO.contains(paramString)) {
        if (!URLUtil.isHttpUrl(paramString)) {
          break label231;
        }
      }
    }
    label231:
    for (Object localObject1 = paramString.substring(7);; localObject1 = paramString)
    {
      Object localObject2 = localObject1;
      if (URLUtil.isHttpsUrl((String)localObject1)) {
        localObject2 = paramString.substring(8);
      }
      y.i("MicroMsg.WebViewUI", "rawUrl = %s, subUrl = %s", new Object[] { paramString, localObject2 });
      localObject1 = this.rpq;
      int m = localObject1.length;
      int j = 0;
      for (;;)
      {
        i = k;
        if (j >= m) {
          break;
        }
        String str = localObject1[j];
        y.i("MicroMsg.WebViewUI", "force geta8key path = %s", new Object[] { str });
        if (((String)localObject2).startsWith(str))
        {
          this.rqO.add(paramString);
          i = 1;
          break;
        }
        j += 1;
      }
      return 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.m
 * JD-Core Version:    0.7.0.1
 */