package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.profile.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class a
  implements f
{
  Activity dtg;
  p tBx;
  b xkP;
  private aw xkQ;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(27423);
    this.xkQ = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27422);
        if (!a.this.dtg.isFinishing())
        {
          a locala = a.this;
          Activity localActivity = a.this.dtg;
          a.this.dtg.getString(2131755906);
          locala.tBx = h.b(localActivity, a.this.dtg.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(27421);
              bc.ajj().a(a.this.xkP);
              a.this.tBx = null;
              AppMethodBeat.o(27421);
            }
          });
        }
        AppMethodBeat.o(27422);
        return false;
      }
    }, false);
    this.dtg = paramActivity;
    AppMethodBeat.o(27423);
  }
  
  private void openWebView(String paramString)
  {
    AppMethodBeat.i(27426);
    this.xkQ.stopTimer();
    if (this.tBx != null) {
      this.tBx.dismiss();
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("title", this.dtg.getString(2131757902));
    paramString.putExtra("zoom", true);
    paramString.putExtra("vertical_scroll", false);
    d.b(this.dtg, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(27426);
  }
  
  public final void iK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27424);
    if (paramString1 == null)
    {
      ae.e("MicroMsg.ViewTWeibo", "null weibo id");
      AppMethodBeat.o(27424);
      return;
    }
    bc.ajj().a(205, this);
    this.xkP = new b(bu.nullAsNil(paramString1).replace("http://t.qq.com/", "").trim(), paramString2);
    bc.ajj().a(this.xkP, 0);
    this.xkQ.ay(3000L, 3000L);
    AppMethodBeat.o(27424);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27425);
    bc.ajj().b(205, this);
    paramString = (b)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      openWebView(paramString.getURL());
      AppMethodBeat.o(27425);
      return;
    }
    if (paramInt1 != 4) {
      ae.e("MicroMsg.ViewTWeibo", "view weibo failed: " + paramInt1 + ", " + paramInt2);
    }
    openWebView("http://t.qq.com/" + paramString.xfp);
    AppMethodBeat.o(27425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a
 * JD-Core Version:    0.7.0.1
 */