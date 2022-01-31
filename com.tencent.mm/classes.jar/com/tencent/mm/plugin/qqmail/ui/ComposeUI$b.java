package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;
import com.tencent.xweb.w;
import java.net.URLDecoder;
import java.util.Map;

final class ComposeUI$b
  extends w
{
  private boolean pMj = false;
  
  private ComposeUI$b(ComposeUI paramComposeUI) {}
  
  public final boolean a(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(68208);
    ab.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[] { paramString });
    Object localObject;
    if (paramString.startsWith(ComposeUI.m(this.pLX)))
    {
      this.pLX.hideVKB();
      try
      {
        paramWebView = URLDecoder.decode(paramString.substring(ComposeUI.m(this.pLX).length()), "utf-8").split("@@");
        localObject = paramWebView[0].split(":");
        paramString = localObject[0];
        localObject = localObject[1];
        ab.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { paramWebView[1], paramString, localObject });
        paramWebView = ((j)g.E(j.class)).bPQ().kB(Integer.valueOf(paramString).intValue());
        paramString = new Intent(this.pLX, MailImageDownloadUI.class);
        paramString.putExtra("img_msg_id", paramWebView.field_msgId);
        paramString.putExtra("img_server_id", paramWebView.field_msgSvrId);
        paramString.putExtra("img_download_compress_type", 0);
        paramString.putExtra("img_download_username", paramWebView.field_talker);
        this.pLX.startActivity(paramString);
        AppMethodBeat.o(68208);
        return true;
      }
      catch (Exception paramWebView)
      {
        ab.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[] { paramWebView.getMessage() });
      }
    }
    do
    {
      AppMethodBeat.o(68208);
      return true;
      if (paramString.startsWith(ComposeUI.n(this.pLX))) {
        try
        {
          ComposeUI.a(this.pLX, URLDecoder.decode(paramString.substring(ComposeUI.n(this.pLX).length()), "utf-8"));
          if (ComposeUI.o(this.pLX)) {
            if (ComposeUI.p(this.pLX).indexOf("<img") == -1)
            {
              ComposeUI.q(this.pLX).clear();
              ComposeUI.r(this.pLX);
              AppMethodBeat.o(68208);
              return true;
            }
          }
        }
        catch (Exception paramWebView)
        {
          for (;;)
          {
            ab.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[] { paramWebView.getMessage() });
          }
          u.b(ComposeUI.s(this.pLX), ComposeUI.t(this.pLX), ComposeUI.u(this.pLX));
          AppMethodBeat.o(68208);
          return true;
        }
      }
    } while (!paramString.startsWith(ComposeUI.t(this.pLX)));
    ComposeUI.q(this.pLX).clear();
    try
    {
      paramWebView = URLDecoder.decode(paramString.substring(ComposeUI.t(this.pLX).length()), "utf-8");
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
        ab.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[] { str, paramWebView });
        ComposeUI.q(this.pLX).put(str, paramWebView);
        i += 1;
      }
      if (!ComposeUI.o(this.pLX)) {
        break label577;
      }
    }
    catch (Exception paramWebView)
    {
      ab.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[] { paramWebView.getMessage() });
      AppMethodBeat.o(68208);
      return true;
    }
    ComposeUI.r(this.pLX);
    label577:
    AppMethodBeat.o(68208);
    return true;
  }
  
  public final void b(WebView paramWebView, String paramString)
  {
    AppMethodBeat.i(68210);
    ab.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[] { paramString, Boolean.valueOf(this.pMj) });
    if (!this.pMj)
    {
      this.pMj = true;
      u.b(ComposeUI.s(this.pLX), ComposeUI.n(this.pLX), ComposeUI.x(this.pLX));
    }
    super.b(paramWebView, paramString);
    AppMethodBeat.o(68210);
  }
  
  public final void b(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(68209);
    super.b(paramWebView, paramString, paramBitmap);
    if (!ComposeUI.v(this.pLX))
    {
      u.d(ComposeUI.s(this.pLX));
      ComposeUI.w(this.pLX);
    }
    AppMethodBeat.o(68209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.b
 * JD-Core Version:    0.7.0.1
 */