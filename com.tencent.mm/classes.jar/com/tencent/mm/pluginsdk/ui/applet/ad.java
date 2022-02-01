package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.h;
import com.tencent.mm.am.s;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class ad
  implements h
{
  private w NbI;
  private MTimerHandler NbJ;
  private n Pdv;
  private String Ydf;
  private Context context;
  
  public ad(Context paramContext)
  {
    AppMethodBeat.i(31429);
    this.NbJ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(31428);
        ad localad = ad.this;
        Context localContext = ad.a(ad.this);
        ad.a(ad.this).getString(R.l.app_tip);
        ad.a(localad, k.a(localContext, ad.a(ad.this).getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(31427);
            bh.aZW().a(ad.b(ad.this));
            ad.a(ad.this, null);
            AppMethodBeat.o(31427);
          }
        }));
        AppMethodBeat.o(31428);
        return false;
      }
    }, false);
    this.context = paramContext;
    AppMethodBeat.o(31429);
  }
  
  private void brf(String paramString)
  {
    AppMethodBeat.i(31431);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.context.getString(R.l.gBM, new Object[] { paramString }));
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("neverGetA8Key", true);
    com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
    AppMethodBeat.o(31431);
  }
  
  public final void bre(String paramString)
  {
    AppMethodBeat.i(31430);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
      AppMethodBeat.o(31430);
      return;
    }
    this.Ydf = paramString;
    bh.bCz();
    String str1 = (String)com.tencent.mm.model.c.ban().d(46, null);
    bh.bCz();
    String str2 = Util.nullAsNil((String)com.tencent.mm.model.c.ban().d(72, null));
    Log.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[] { str1, str2 });
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
    {
      brf(paramString);
      AppMethodBeat.o(31430);
      return;
    }
    bh.aZW().a(233, this);
    this.Pdv = new n(com.tencent.mm.b.p.hw(paramString), n.bMd());
    bh.aZW().a(this.Pdv, 0);
    this.NbJ.startTimer(3000L);
    AppMethodBeat.o(31430);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(31432);
    this.NbJ.stopTimer();
    if (this.NbI != null) {
      this.NbI.dismiss();
    }
    bh.aZW().b(233, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (n)paramp;
      paramp = paramString.bLT();
      if ((paramp == null) || (paramp.length() == 0))
      {
        brf(this.Ydf);
        AppMethodBeat.o(31432);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramp);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("geta8key_session_id", paramString.bMc());
      com.tencent.mm.br.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
      AppMethodBeat.o(31432);
      return;
    }
    Log.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    brf(this.Ydf);
    AppMethodBeat.o(31432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ad
 * JD-Core Version:    0.7.0.1
 */