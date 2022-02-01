package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.bizui.a.b;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.core.m;
import com.tencent.mm.plugin.webview.core.m.a;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.xweb.WebView;

public class GameChattingRoomWebViewUI
  extends WebViewUI
{
  private int Xfv;
  private int Xfw;
  final y.a Xfx;
  final y.a Xfy;
  private m Xfz;
  String jumpUrl;
  
  public GameChattingRoomWebViewUI()
  {
    AppMethodBeat.i(80816);
    this.jumpUrl = "";
    this.Xfv = 4;
    this.Xfw = 5;
    this.Xfx = new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(80814);
        GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.a(GameChattingRoomWebViewUI.this), new Intent());
        GameChattingRoomWebViewUI.this.finish();
        AppMethodBeat.o(80814);
      }
    };
    this.Xfy = new y.a()
    {
      public final void onDialogClick(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(80815);
        paramAnonymousString = new Intent();
        paramAnonymousString.putExtra("rawUrl", GameChattingRoomWebViewUI.b(GameChattingRoomWebViewUI.this));
        GameChattingRoomWebViewUI.this.setResult(GameChattingRoomWebViewUI.c(GameChattingRoomWebViewUI.this), paramAnonymousString);
        GameChattingRoomWebViewUI.this.finish();
        AppMethodBeat.o(80815);
      }
    };
    this.Xfz = new m()
    {
      public final m.a j(WebView paramAnonymousWebView, final String paramAnonymousString)
      {
        AppMethodBeat.i(297058);
        if (Util.isNullOrNil(paramAnonymousString))
        {
          paramAnonymousWebView = new m.a(false, false);
          AppMethodBeat.o(297058);
          return paramAnonymousWebView;
        }
        if ((paramAnonymousString.toLowerCase().startsWith("weixin://jump/")) || (paramAnonymousString.toLowerCase().startsWith("weixin://scanqrcode/")))
        {
          h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(297024);
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
                  b.a(localGameChattingRoomWebViewUI.mController, localGameChattingRoomWebViewUI.getString(c.i.created_chatroom), str1, str3, localGameChattingRoomWebViewUI.Xfx, localGameChattingRoomWebViewUI.Xfy);
                  AppMethodBeat.o(297024);
                  return;
                }
                if (str2.equals("action_join")) {
                  b.a(localGameChattingRoomWebViewUI.mController, localGameChattingRoomWebViewUI.getString(c.i.joined_chatroom), str1, str3, localGameChattingRoomWebViewUI.Xfx, localGameChattingRoomWebViewUI.Xfy);
                }
              }
              AppMethodBeat.o(297024);
            }
          });
          paramAnonymousWebView = new m.a(true, true);
          AppMethodBeat.o(297058);
          return paramAnonymousWebView;
        }
        paramAnonymousWebView = new m.a(false, false);
        AppMethodBeat.o(297058);
        return paramAnonymousWebView;
      }
    };
    AppMethodBeat.o(80816);
  }
  
  public final k dhx()
  {
    AppMethodBeat.i(297039);
    k localk = super.dhx();
    localk.a(this.Xfz);
    AppMethodBeat.o(297039);
    return localk;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(297044);
    this.Wzl.b(this.Xfz);
    super.onDestroy();
    AppMethodBeat.o(297044);
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