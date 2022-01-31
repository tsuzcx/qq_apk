package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p;
import java.net.URLDecoder;
import java.util.Map;

final class ComposeUI$b
  extends p
{
  private boolean ngV = false;
  
  private ComposeUI$b(ComposeUI paramComposeUI) {}
  
  public final void a(WebView paramWebView, String paramString)
  {
    y.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.ngV) });
    if (!this.ngV)
    {
      this.ngV = true;
      s.c(ComposeUI.s(this.ngJ), ComposeUI.n(this.ngJ), ComposeUI.x(this.ngJ));
    }
    super.a(paramWebView, paramString);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.b(paramWebView, paramString, paramBitmap);
    if (!ComposeUI.v(this.ngJ))
    {
      s.b(ComposeUI.s(this.ngJ));
      ComposeUI.w(this.ngJ);
    }
  }
  
  public final boolean b(WebView paramWebView, String paramString)
  {
    y.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    if (paramString.startsWith(ComposeUI.m(this.ngJ))) {
      this.ngJ.XM();
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramWebView = URLDecoder.decode(paramString.substring(ComposeUI.m(this.ngJ).length()), "utf-8").split("@@");
        localObject = paramWebView[0].split(":");
        paramString = localObject[0];
        localObject = localObject[1];
        y.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { paramWebView[1], paramString, localObject });
        paramWebView = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(Integer.valueOf(paramString).intValue());
        paramString = new Intent(this.ngJ, MailImageDownloadUI.class);
        paramString.putExtra("img_msg_id", paramWebView.field_msgId);
        paramString.putExtra("img_server_id", paramWebView.field_msgSvrId);
        paramString.putExtra("img_download_compress_type", 0);
        paramString.putExtra("img_download_username", paramWebView.field_talker);
        this.ngJ.startActivity(paramString);
        return true;
      }
      catch (Exception paramWebView)
      {
        y.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[] { paramWebView.getMessage() });
        return true;
      }
      if (paramString.startsWith(ComposeUI.n(this.ngJ)))
      {
        try
        {
          ComposeUI.a(this.ngJ, URLDecoder.decode(paramString.substring(ComposeUI.n(this.ngJ).length()), "utf-8"));
          if (!ComposeUI.o(this.ngJ)) {
            continue;
          }
          if (ComposeUI.p(this.ngJ).indexOf("<img") == -1)
          {
            ComposeUI.q(this.ngJ).clear();
            ComposeUI.r(this.ngJ);
            return true;
          }
        }
        catch (Exception paramWebView)
        {
          for (;;)
          {
            y.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[] { paramWebView.getMessage() });
          }
          s.c(ComposeUI.s(this.ngJ), ComposeUI.t(this.ngJ), ComposeUI.u(this.ngJ));
          return true;
        }
      }
      else if (paramString.startsWith(ComposeUI.t(this.ngJ)))
      {
        ComposeUI.q(this.ngJ).clear();
        try
        {
          paramWebView = URLDecoder.decode(paramString.substring(ComposeUI.t(this.ngJ).length()), "utf-8");
          localObject = paramWebView.split("&&");
          int i = 0;
          while (i < localObject.length)
          {
            paramWebView = localObject[i].split("@@");
            String str = paramWebView[0].split(":")[1];
            paramString = paramWebView[1];
            paramWebView = paramString;
            if (paramString.startsWith("file://")) {
              paramWebView = paramString.replaceFirst("file://", "");
            }
            y.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[] { str, paramWebView });
            ComposeUI.q(this.ngJ).put(str, paramWebView);
            i += 1;
          }
          if (!ComposeUI.o(this.ngJ)) {}
        }
        catch (Exception paramWebView)
        {
          y.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[] { paramWebView.getMessage() });
          return true;
        }
      }
    }
    ComposeUI.r(this.ngJ);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.b
 * JD-Core Version:    0.7.0.1
 */