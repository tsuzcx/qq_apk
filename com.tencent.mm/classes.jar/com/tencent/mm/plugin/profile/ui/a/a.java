package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.profile.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class a
  implements g
{
  Activity dgE;
  p sue;
  b vNP;
  private au vNQ;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(27423);
    this.vNQ = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27422);
        if (!a.this.dgE.isFinishing())
        {
          a locala = a.this;
          Activity localActivity = a.this.dgE;
          a.this.dgE.getString(2131755906);
          locala.sue = h.b(localActivity, a.this.dgE.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(27421);
              az.agi().a(a.this.vNP);
              a.this.sue = null;
              AppMethodBeat.o(27421);
            }
          });
        }
        AppMethodBeat.o(27422);
        return false;
      }
    }, false);
    this.dgE = paramActivity;
    AppMethodBeat.o(27423);
  }
  
  private void openWebView(String paramString)
  {
    AppMethodBeat.i(27426);
    this.vNQ.stopTimer();
    if (this.sue != null) {
      this.sue.dismiss();
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("title", this.dgE.getString(2131757902));
    paramString.putExtra("zoom", true);
    paramString.putExtra("vertical_scroll", false);
    d.b(this.dgE, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(27426);
  }
  
  public final void iq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27424);
    if (paramString1 == null)
    {
      ac.e("MicroMsg.ViewTWeibo", "null weibo id");
      AppMethodBeat.o(27424);
      return;
    }
    az.agi().a(205, this);
    this.vNP = new b(bs.nullAsNil(paramString1).replace("http://t.qq.com/", "").trim(), paramString2);
    az.agi().a(this.vNP, 0);
    this.vNQ.au(3000L, 3000L);
    AppMethodBeat.o(27424);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27425);
    az.agi().b(205, this);
    paramString = (b)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      openWebView(paramString.getURL());
      AppMethodBeat.o(27425);
      return;
    }
    if (paramInt1 != 4) {
      ac.e("MicroMsg.ViewTWeibo", "view weibo failed: " + paramInt1 + ", " + paramInt2);
    }
    openWebView("http://t.qq.com/" + paramString.vIr);
    AppMethodBeat.o(27425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a
 * JD-Core Version:    0.7.0.1
 */