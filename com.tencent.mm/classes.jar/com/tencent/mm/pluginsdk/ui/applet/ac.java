package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;

public final class ac
  implements i
{
  private MTimerHandler BiQ;
  l CPb;
  private String Kgo;
  Context context;
  com.tencent.mm.ui.base.q wSy;
  
  public ac(Context paramContext)
  {
    AppMethodBeat.i(31429);
    this.BiQ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(31428);
        ac localac = ac.this;
        Context localContext = ac.this.context;
        ac.this.context.getString(2131755998);
        localac.wSy = h.a(localContext, ac.this.context.getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(31427);
            bg.azz().a(ac.this.CPb);
            ac.this.wSy = null;
            AppMethodBeat.o(31427);
          }
        });
        AppMethodBeat.o(31428);
        return false;
      }
    }, false);
    this.context = paramContext;
    AppMethodBeat.o(31429);
  }
  
  private void beV(String paramString)
  {
    AppMethodBeat.i(31431);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.context.getString(2131758018, new Object[] { paramString }));
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("neverGetA8Key", true);
    com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
    AppMethodBeat.o(31431);
  }
  
  public final void beU(String paramString)
  {
    AppMethodBeat.i(31430);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
      AppMethodBeat.o(31430);
      return;
    }
    this.Kgo = paramString;
    bg.aVF();
    String str1 = (String)com.tencent.mm.model.c.azQ().get(46, null);
    bg.aVF();
    String str2 = Util.nullAsNil((String)com.tencent.mm.model.c.azQ().get(72, null));
    Log.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[] { str1, str2 });
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
    {
      beV(paramString);
      AppMethodBeat.o(31430);
      return;
    }
    bg.azz().a(233, this);
    this.CPb = new l(p.fd(paramString), (int)System.currentTimeMillis());
    bg.azz().a(this.CPb, 0);
    this.BiQ.startTimer(3000L);
    AppMethodBeat.o(31430);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(31432);
    this.BiQ.stopTimer();
    if (this.wSy != null) {
      this.wSy.dismiss();
    }
    bg.azz().b(233, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (l)paramq;
      paramq = paramString.beQ();
      if ((paramq == null) || (paramq.length() == 0))
      {
        beV(this.Kgo);
        AppMethodBeat.o(31432);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramq);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("geta8key_session_id", paramString.beY());
      com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
      AppMethodBeat.o(31432);
      return;
    }
    Log.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    beV(this.Kgo);
    AppMethodBeat.o(31432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ac
 * JD-Core Version:    0.7.0.1
 */