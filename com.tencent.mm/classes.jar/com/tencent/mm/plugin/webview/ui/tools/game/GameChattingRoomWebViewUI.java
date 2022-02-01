package com.tencent.mm.plugin.webview.ui.tools.game;

import android.app.Activity;
import android.content.Intent;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.bizui.a.b;
import com.tencent.mm.plugin.webview.c.i;
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
  private int Qnh;
  private int Qni;
  final y.a Qnj;
  final y.a Qnk;
  private k Qnl;
  String jumpUrl;
  
  public GameChattingRoomWebViewUI()
  {
    AppMethodBeat.i(80816);
    this.jumpUrl = "";
    this.Qnh = 4;
    this.Qni = 5;
    this.Qnj = new y.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(80814);
        GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.a(GameChattingRoomWebViewUI.this), new Intent());
        GameChattingRoomWebViewUI.this.finish();
        AppMethodBeat.o(80814);
      }
    };
    this.Qnk = new y.a()
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
    this.Qnl = new k()
    {
      public final k.a o(WebView paramAnonymousWebView, final String paramAnonymousString)
      {
        AppMethodBeat.i(214290);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          paramAnonymousWebView = new k.a(false, false);
          AppMethodBeat.o(214290);
          return paramAnonymousWebView;
        }
        if ((paramAnonymousString.toLowerCase().startsWith("weixin://jump/")) || (paramAnonymousString.toLowerCase().startsWith("weixin://scanqrcode/")))
        {
          h.ZvG.bc(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(267394);
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
                for (str1 = localGameChattingRoomWebViewUI.getString(c.i.app_back);; str1 = localGameChattingRoomWebViewUI.getString(c.i.confirm_dialog_back_app, new Object[] { str1 }))
                {
                  str3 = localGameChattingRoomWebViewUI.getString(c.i.confirm_dialog_stay_in_weixin);
                  if (!str2.equals("action_create")) {
                    break;
                  }
                  b.a(localGameChattingRoomWebViewUI.mController, localGameChattingRoomWebViewUI.getString(c.i.created_chatroom), str1, str3, localGameChattingRoomWebViewUI.Qnj, localGameChattingRoomWebViewUI.Qnk);
                  AppMethodBeat.o(267394);
                  return;
                }
                if (str2.equals("action_join")) {
                  b.a(localGameChattingRoomWebViewUI.mController, localGameChattingRoomWebViewUI.getString(c.i.joined_chatroom), str1, str3, localGameChattingRoomWebViewUI.Qnj, localGameChattingRoomWebViewUI.Qnk);
                }
              }
              AppMethodBeat.o(267394);
            }
          });
          paramAnonymousWebView = new k.a(true, true);
          AppMethodBeat.o(214290);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = new k.a(false, false);
        AppMethodBeat.o(214290);
        return paramAnonymousWebView;
      }
    };
    AppMethodBeat.o(80816);
  }
  
  public final com.tencent.mm.plugin.webview.core.i cDV()
  {
    AppMethodBeat.i(229282);
    com.tencent.mm.plugin.webview.core.i locali = super.cDV();
    locali.a(this.Qnl);
    AppMethodBeat.o(229282);
    return locali;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(229283);
    this.PIQ.b(this.Qnl);
    super.onDestroy();
    AppMethodBeat.o(229283);
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