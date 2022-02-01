package com.tencent.mm.plugin.profile.ui.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class a
  implements h
{
  private b NbH;
  private w NbI;
  private MTimerHandler NbJ;
  private Activity hHU;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(27423);
    this.NbJ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27422);
        if (!a.a(a.this).isFinishing())
        {
          a locala = a.this;
          Activity localActivity = a.a(a.this);
          a.a(a.this).getString(R.l.app_tip);
          a.a(locala, k.a(localActivity, a.a(a.this).getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(27421);
              bh.aZW().a(a.b(a.this));
              a.a(a.this, null);
              AppMethodBeat.o(27421);
            }
          }));
        }
        AppMethodBeat.o(27422);
        return false;
      }
    }, false);
    this.hHU = paramActivity;
    AppMethodBeat.o(27423);
  }
  
  private void openWebView(String paramString)
  {
    AppMethodBeat.i(27426);
    this.NbJ.stopTimer();
    if (this.NbI != null) {
      this.NbI.dismiss();
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("title", this.hHU.getString(R.l.gDc));
    paramString.putExtra("zoom", true);
    paramString.putExtra("vertical_scroll", false);
    c.b(this.hHU, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(27426);
  }
  
  public final void ld(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27424);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.ViewTWeibo", "null weibo id");
      AppMethodBeat.o(27424);
      return;
    }
    bh.aZW().a(205, this);
    this.NbH = new b(Util.nullAsNil(paramString1).replace("http://t.qq.com/", "").trim(), paramString2);
    bh.aZW().a(this.NbH, 0);
    this.NbJ.startTimer(3000L);
    AppMethodBeat.o(27424);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(27425);
    bh.aZW().b(205, this);
    paramString = (b)paramp;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      openWebView(paramString.cgR());
      AppMethodBeat.o(27425);
      return;
    }
    if (paramInt1 != 4) {
      Log.e("MicroMsg.ViewTWeibo", "view weibo failed: " + paramInt1 + ", " + paramInt2);
    }
    openWebView("http://t.qq.com/" + paramString.MUN);
    AppMethodBeat.o(27425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.a
 * JD-Core Version:    0.7.0.1
 */