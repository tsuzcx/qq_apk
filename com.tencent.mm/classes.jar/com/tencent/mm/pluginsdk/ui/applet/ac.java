package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;

public final class ac
  implements g
{
  private String BZJ;
  Context context;
  com.tencent.mm.ui.base.p rll;
  private av uEZ;
  k vWB;
  
  public ac(Context paramContext)
  {
    AppMethodBeat.i(31429);
    this.uEZ = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(31428);
        ac localac = ac.this;
        Context localContext = ac.this.context;
        ac.this.context.getString(2131755906);
        localac.rll = h.b(localContext, ac.this.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(31427);
            az.aeS().a(ac.this.vWB);
            ac.this.rll = null;
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
  
  private void aCc(String paramString)
  {
    AppMethodBeat.i(31431);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.context.getString(2131757778, new Object[] { paramString }));
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("neverGetA8Key", true);
    d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
    AppMethodBeat.o(31431);
  }
  
  public final void aCb(String paramString)
  {
    AppMethodBeat.i(31430);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ad.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
      AppMethodBeat.o(31430);
      return;
    }
    this.BZJ = paramString;
    az.arV();
    String str1 = (String)c.afk().get(46, null);
    az.arV();
    String str2 = bt.nullAsNil((String)c.afk().get(72, null));
    ad.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[] { str1, str2 });
    if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)))
    {
      aCc(paramString);
      AppMethodBeat.o(31430);
      return;
    }
    az.aeS().a(233, this);
    this.vWB = new k(com.tencent.mm.b.p.dG(paramString), (int)System.currentTimeMillis());
    az.aeS().a(this.vWB, 0);
    this.uEZ.av(3000L, 3000L);
    AppMethodBeat.o(31430);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(31432);
    this.uEZ.stopTimer();
    if (this.rll != null) {
      this.rll.dismiss();
    }
    az.aeS().b(233, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (k)paramn;
      paramn = paramString.aAq();
      if ((paramn == null) || (paramn.length() == 0))
      {
        aCc(this.BZJ);
        AppMethodBeat.o(31432);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramn);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("geta8key_session_id", paramString.aAy());
      d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
      AppMethodBeat.o(31432);
      return;
    }
    ad.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    aCc(this.BZJ);
    AppMethodBeat.o(31432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ac
 * JD-Core Version:    0.7.0.1
 */