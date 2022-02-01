package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.profile.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class a
  implements i
{
  b BiP;
  private MTimerHandler BiQ;
  Activity dKq;
  com.tencent.mm.ui.base.q wSy;
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(27423);
    this.BiQ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(27422);
        if (!a.this.dKq.isFinishing())
        {
          a locala = a.this;
          Activity localActivity = a.this.dKq;
          a.this.dKq.getString(2131755998);
          locala.wSy = h.a(localActivity, a.this.dKq.getString(2131756029), true, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
            {
              AppMethodBeat.i(27421);
              bg.azz().a(a.this.BiP);
              a.this.wSy = null;
              AppMethodBeat.o(27421);
            }
          });
        }
        AppMethodBeat.o(27422);
        return false;
      }
    }, false);
    this.dKq = paramActivity;
    AppMethodBeat.o(27423);
  }
  
  private void openWebView(String paramString)
  {
    AppMethodBeat.i(27426);
    this.BiQ.stopTimer();
    if (this.wSy != null) {
      this.wSy.dismiss();
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("title", this.dKq.getString(2131758142));
    paramString.putExtra("zoom", true);
    paramString.putExtra("vertical_scroll", false);
    c.b(this.dKq, "webview", ".ui.tools.WebViewUI", paramString);
    AppMethodBeat.o(27426);
  }
  
  public final void jx(String paramString1, String paramString2)
  {
    AppMethodBeat.i(27424);
    if (paramString1 == null)
    {
      Log.e("MicroMsg.ViewTWeibo", "null weibo id");
      AppMethodBeat.o(27424);
      return;
    }
    bg.azz().a(205, this);
    this.BiP = new b(Util.nullAsNil(paramString1).replace("http://t.qq.com/", "").trim(), paramString2);
    bg.azz().a(this.BiP, 0);
    this.BiQ.startTimer(3000L);
    AppMethodBeat.o(27424);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(27425);
    bg.azz().b(205, this);
    paramString = (b)paramq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      openWebView(paramString.getURL());
      AppMethodBeat.o(27425);
      return;
    }
    if (paramInt1 != 4) {
      Log.e("MicroMsg.ViewTWeibo", "view weibo failed: " + paramInt1 + ", " + paramInt2);
    }
    openWebView("http://t.qq.com/" + paramString.BcV);
    AppMethodBeat.o(27425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a
 * JD-Core Version:    0.7.0.1
 */