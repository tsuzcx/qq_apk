package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.Intent;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.bizui.a.b;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.core.k.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.xweb.WebView;

public class GameChattingRoomWebViewUI
  extends WebViewUI
{
  private int JpM;
  private int JpN;
  final y.a JpO;
  final y.a JpP;
  private k JpQ;
  String jumpUrl;
  
  public GameChattingRoomWebViewUI()
  {
    AppMethodBeat.i(80816);
    this.jumpUrl = "";
    this.JpM = 4;
    this.JpN = 5;
    this.JpO = new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(80814);
        GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.a(GameChattingRoomWebViewUI.this), new Intent());
        GameChattingRoomWebViewUI.this.finish();
        AppMethodBeat.o(80814);
      }
    };
    this.JpP = new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(80815);
        paramAnonymousString = new Intent();
        paramAnonymousString.putExtra("rawUrl", GameChattingRoomWebViewUI.b(GameChattingRoomWebViewUI.this));
        GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.c(GameChattingRoomWebViewUI.this), paramAnonymousString);
        GameChattingRoomWebViewUI.this.finish();
        AppMethodBeat.o(80815);
      }
    };
    this.JpQ = new k()
    {
      public final k.a o(WebView paramAnonymousWebView, final String paramAnonymousString)
      {
        AppMethodBeat.i(211308);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          paramAnonymousWebView = new k.a(false, false);
          AppMethodBeat.o(211308);
          return paramAnonymousWebView;
        }
        if ((paramAnonymousString.toLowerCase().startsWith("weixin://jump/")) || (paramAnonymousString.toLowerCase().startsWith("weixin://scanqrcode/")))
        {
          h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211307);
              GameChattingRoomWebViewUI localGameChattingRoomWebViewUI = GameChattingRoomWebViewUI.this;
              String str1 = paramAnonymousString;
              Log.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", new Object[] { str1 });
              localGameChattingRoomWebViewUI.jumpUrl = str1;
              String str2 = localGameChattingRoomWebViewUI.getIntent().getStringExtra("action");
              if (str2 != null)
              {
                str1 = localGameChattingRoomWebViewUI.getIntent().getStringExtra("app_name");
                if (str1 == null) {}
                String str3;
                for (str1 = localGameChattingRoomWebViewUI.getString(2131755316);; str1 = localGameChattingRoomWebViewUI.getString(2131757784, new Object[] { str1 }))
                {
                  str3 = localGameChattingRoomWebViewUI.getString(2131757791);
                  if (!str2.equals("action_create")) {
                    break;
                  }
                  b.a(localGameChattingRoomWebViewUI.mController, localGameChattingRoomWebViewUI.getString(2131758214), str1, str3, localGameChattingRoomWebViewUI.JpO, localGameChattingRoomWebViewUI.JpP);
                  AppMethodBeat.o(211307);
                  return;
                }
                if (str2.equals("action_join")) {
                  b.a(localGameChattingRoomWebViewUI.mController, localGameChattingRoomWebViewUI.getString(2131762022), str1, str3, localGameChattingRoomWebViewUI.JpO, localGameChattingRoomWebViewUI.JpP);
                }
              }
              AppMethodBeat.o(211307);
            }
          });
          paramAnonymousWebView = new k.a(true, true);
          AppMethodBeat.o(211308);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = new k.a(false, false);
        AppMethodBeat.o(211308);
        return paramAnonymousWebView;
      }
    };
    AppMethodBeat.o(80816);
  }
  
  public final com.tencent.mm.plugin.webview.core.i cpO()
  {
    AppMethodBeat.i(211309);
    com.tencent.mm.plugin.webview.core.i locali = super.cpO();
    locali.a(this.JpQ);
    AppMethodBeat.o(211309);
    return locali;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(211310);
    this.IMH.b(this.JpQ);
    super.onDestroy();
    AppMethodBeat.o(211310);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI
 * JD-Core Version:    0.7.0.1
 */