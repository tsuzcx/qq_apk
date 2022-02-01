package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.Intent;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.bizui.a.b;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.core.j.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.xweb.WebView;

public class GameChattingRoomWebViewUI
  extends WebViewUI
{
  private int Bmu;
  private int Bmv;
  final y.a Bmw;
  final y.a Bmx;
  private j Bmy;
  String jumpUrl;
  
  public GameChattingRoomWebViewUI()
  {
    AppMethodBeat.i(80816);
    this.jumpUrl = "";
    this.Bmu = 4;
    this.Bmv = 5;
    this.Bmw = new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(80814);
        GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.a(GameChattingRoomWebViewUI.this), new Intent());
        GameChattingRoomWebViewUI.this.finish();
        AppMethodBeat.o(80814);
      }
    };
    this.Bmx = new y.a()
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
    this.Bmy = new j()
    {
      public final j.a n(WebView paramAnonymousWebView, final String paramAnonymousString)
      {
        AppMethodBeat.i(188105);
        if (bt.isNullOrNil(paramAnonymousString))
        {
          paramAnonymousWebView = new j.a(false, false);
          AppMethodBeat.o(188105);
          return paramAnonymousWebView;
        }
        if ((paramAnonymousString.toLowerCase().startsWith("weixin://jump/")) || (paramAnonymousString.toLowerCase().startsWith("weixin://scanqrcode/")))
        {
          com.tencent.e.h.Iye.aN(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(188104);
              GameChattingRoomWebViewUI localGameChattingRoomWebViewUI = GameChattingRoomWebViewUI.this;
              String str1 = paramAnonymousString;
              ad.i("MicroMsg.GameChattingRoomWebViewUI", "url = %s", new Object[] { str1 });
              localGameChattingRoomWebViewUI.jumpUrl = str1;
              String str2 = localGameChattingRoomWebViewUI.getIntent().getStringExtra("action");
              if (str2 != null)
              {
                str1 = localGameChattingRoomWebViewUI.getIntent().getStringExtra("app_name");
                if (str1 == null) {}
                String str3;
                for (str1 = localGameChattingRoomWebViewUI.getString(2131755281);; str1 = localGameChattingRoomWebViewUI.getString(2131757557, new Object[] { str1 }))
                {
                  str3 = localGameChattingRoomWebViewUI.getString(2131757564);
                  if (!str2.equals("action_create")) {
                    break;
                  }
                  b.a(localGameChattingRoomWebViewUI.mController, localGameChattingRoomWebViewUI.getString(2131757965), str1, str3, localGameChattingRoomWebViewUI.Bmw, localGameChattingRoomWebViewUI.Bmx);
                  AppMethodBeat.o(188104);
                  return;
                }
                if (str2.equals("action_join")) {
                  b.a(localGameChattingRoomWebViewUI.mController, localGameChattingRoomWebViewUI.getString(2131760577), str1, str3, localGameChattingRoomWebViewUI.Bmw, localGameChattingRoomWebViewUI.Bmx);
                }
              }
              AppMethodBeat.o(188104);
            }
          });
          paramAnonymousWebView = new j.a(true, true);
          AppMethodBeat.o(188105);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = new j.a(false, false);
        AppMethodBeat.o(188105);
        return paramAnonymousWebView;
      }
    };
    AppMethodBeat.o(80816);
  }
  
  public final com.tencent.mm.plugin.webview.core.h bFq()
  {
    AppMethodBeat.i(188106);
    com.tencent.mm.plugin.webview.core.h localh = super.bFq();
    localh.a(this.Bmy);
    AppMethodBeat.o(188106);
    return localh;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.GameChattingRoomWebViewUI
 * JD-Core Version:    0.7.0.1
 */