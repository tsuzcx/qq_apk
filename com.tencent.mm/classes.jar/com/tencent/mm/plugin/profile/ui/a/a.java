package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.profile.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

public final class a
  implements i
{
  private b Hdo;
  private s Hdp;
  private MTimerHandler Hdq;
  private Activity fDf;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(27423);
    this.Hdq = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27422);
        if (!a.a(a.this).isFinishing())
        {
          a locala = a.this;
          Activity localActivity = a.a(a.this);
          a.a(a.this).getString(R.l.app_tip);
          a.a(locala, h.a(localActivity, a.a(a.this).getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(27421);
              bh.aGY().a(a.b(a.this));
              a.a(a.this, null);
              AppMethodBeat.o(27421);
            }
          }));
        }
        AppMethodBeat.o(27422);
        return false;
      }
    }, false);
    this.fDf = paramActivity;
    AppMethodBeat.o(27423);
  }
  
  private void openWebView(String paramString)
  {
    AppMethodBeat.i(27426);
    this.Hdq.stopTimer();
    if (this.Hdp != null) {
      this.Hdp.dismiss();
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("title", this.fDf.getString(R.l.eAm));
    paramString.putExtra("zoom", true);
    paramString.putExtra("vertical_scroll", false);
    c.b(this.fDf, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(27426);
  }
  
  public final void jI(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27424);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.ViewTWeibo", "null weibo id");
      AppMethodBeat.o(27424);
      return;
    }
    bh.aGY().a(205, this);
    this.Hdo = new b(Util.nullAsNil(paramString1).replace("http://t.qq.com/", "").trim(), paramString2);
    bh.aGY().a(this.Hdo, 0);
    this.Hdq.startTimer(3000L);
    AppMethodBeat.o(27424);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(27425);
    bh.aGY().b(205, this);
    paramString = (b)paramq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      openWebView(paramString.btD());
      AppMethodBeat.o(27425);
      return;
    }
    if (paramInt1 != 4) {
      Log.e("MicroMsg.ViewTWeibo", "view weibo failed: " + paramInt1 + ", " + paramInt2);
    }
    openWebView("http://t.qq.com/" + paramString.GWU);
    AppMethodBeat.o(27425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a
 * JD-Core Version:    0.7.0.1
 */