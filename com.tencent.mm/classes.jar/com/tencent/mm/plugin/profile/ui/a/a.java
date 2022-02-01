package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.profile.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class a
  implements g
{
  Activity djj;
  p rll;
  b uEY;
  private av uEZ;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(27423);
    this.uEZ = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27422);
        if (!a.this.djj.isFinishing())
        {
          a locala = a.this;
          Activity localActivity = a.this.djj;
          a.this.djj.getString(2131755906);
          locala.rll = h.b(localActivity, a.this.djj.getString(2131755936), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(27421);
              az.aeS().a(a.this.uEY);
              a.this.rll = null;
              AppMethodBeat.o(27421);
            }
          });
        }
        AppMethodBeat.o(27422);
        return false;
      }
    }, false);
    this.djj = paramActivity;
    AppMethodBeat.o(27423);
  }
  
  private void openWebView(String paramString)
  {
    AppMethodBeat.i(27426);
    this.uEZ.stopTimer();
    if (this.rll != null) {
      this.rll.dismiss();
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("title", this.djj.getString(2131757902));
    paramString.putExtra("zoom", true);
    paramString.putExtra("vertical_scroll", false);
    d.b(this.djj, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(27426);
  }
  
  public final void hX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27424);
    if (paramString1 == null)
    {
      ad.e("MicroMsg.ViewTWeibo", "null weibo id");
      AppMethodBeat.o(27424);
      return;
    }
    az.aeS().a(205, this);
    this.uEY = new b(bt.nullAsNil(paramString1).replace("http://t.qq.com/", "").trim(), paramString2);
    az.aeS().a(this.uEY, 0);
    this.uEZ.av(3000L, 3000L);
    AppMethodBeat.o(27424);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(27425);
    az.aeS().b(205, this);
    paramString = (b)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      openWebView(paramString.getURL());
      AppMethodBeat.o(27425);
      return;
    }
    if (paramInt1 != 4) {
      ad.e("MicroMsg.ViewTWeibo", "view weibo failed: " + paramInt1 + ", " + paramInt2);
    }
    openWebView("http://t.qq.com/" + paramString.uzy);
    AppMethodBeat.o(27425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a
 * JD-Core Version:    0.7.0.1
 */