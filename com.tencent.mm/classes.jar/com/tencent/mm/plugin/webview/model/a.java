package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.n;

public final class a
{
  private static String[] rfe = null;
  
  public static void a(MMWebView paramMMWebView, d paramd)
  {
    if (paramd == null) {
      y.e("MicroMsg.AutoPlayLogic", "invoker null");
    }
    String str;
    do
    {
      return;
      if (paramMMWebView == null)
      {
        y.e("MicroMsg.AutoPlayLogic", "webView null");
        return;
      }
      str = paramMMWebView.getUrl();
      y.i("MicroMsg.AutoPlayLogic", "currentUrl:%s", new Object[] { str });
    } while (bk.bl(str));
    if (a(str, paramd))
    {
      a(paramMMWebView, true);
      y.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (true)");
      return;
    }
    a(paramMMWebView, false);
    y.i("MicroMsg.AutoPlayLogic", "enableAutoPlay (false)");
  }
  
  private static void a(MMWebView paramMMWebView, boolean paramBoolean)
  {
    if (paramMMWebView.getIsX5Kernel()) {
      try
      {
        Bundle localBundle = new Bundle();
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          localBundle.putBoolean("require", paramBoolean);
          org.b.a.cz(paramMMWebView.getX5WebViewExtension()).y("invokeMiscMethod", new Object[] { "setVideoPlaybackRequiresUserGesture", localBundle });
          return;
        }
        y.i("MicroMsg.AutoPlayLogic", "not x5 all enable");
      }
      catch (Exception paramMMWebView)
      {
        y.e("MicroMsg.AutoPlayLogic", "enableAutoPlay :%s", new Object[] { paramMMWebView });
        return;
      }
    }
    paramMMWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
  }
  
  private static boolean a(String paramString, d paramd)
  {
    boolean bool2 = false;
    if (rfe == null) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramd.f(100, new Bundle());
        paramd = null;
        if (localObject != null) {
          paramd = ((Bundle)localObject).getString("enable_auto_play_host_paths");
        }
        y.i("MicroMsg.AutoPlayLogic", "autoPlayHostsStr config:%s", new Object[] { paramd });
        localObject = paramd;
        if (bk.bl(paramd)) {
          localObject = "mp.weixin.qq.com/s;mp.weixin.qq.com/mp/appmsg/show";
        }
        rfe = ((String)localObject).split(";");
        paramString = Uri.parse(paramString);
        paramString = paramString.getAuthority() + paramString.getPath();
        i = 0;
        boolean bool1 = bool2;
        if (i < rfe.length)
        {
          if (paramString.startsWith(rfe[i])) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
      }
      catch (RemoteException paramString)
      {
        y.w("MicroMsg.AutoPlayLogic", "isOauthHost exp:%s", new Object[] { paramString.getLocalizedMessage() });
        return false;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.a
 * JD-Core Version:    0.7.0.1
 */