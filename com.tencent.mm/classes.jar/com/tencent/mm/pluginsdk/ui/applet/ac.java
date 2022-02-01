package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.h;

public final class ac
  implements g
{
  private String DrZ;
  Context context;
  com.tencent.mm.ui.base.p sue;
  private au vNQ;
  k xho;
  
  public ac(Context paramContext)
  {
    AppMethodBeat.i(31429);
    this.vNQ = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(31428);
        ac localac = ac.this;
        Context localContext = ac.this.context;
        ac.this.context.getString(2131755906);
        localac.sue = h.b(localContext, ac.this.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(31427);
            az.agi().a(ac.this.xho);
            ac.this.sue = null;
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
  
  private void aHu(String paramString)
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
  
  public final void aHt(String paramString)
  {
    AppMethodBeat.i(31430);
    if ((paramString == null) || (paramString.length() == 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
      AppMethodBeat.o(31430);
      return;
    }
    this.DrZ = paramString;
    az.ayM();
    String str1 = (String)c.agA().get(46, null);
    az.ayM();
    String str2 = bs.nullAsNil((String)c.agA().get(72, null));
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[] { str1, str2 });
    if ((bs.isNullOrNil(str1)) && (bs.isNullOrNil(str2)))
    {
      aHu(paramString);
      AppMethodBeat.o(31430);
      return;
    }
    az.agi().a(233, this);
    this.xho = new k(com.tencent.mm.b.p.dv(paramString), (int)System.currentTimeMillis());
    az.agi().a(this.xho, 0);
    this.vNQ.au(3000L, 3000L);
    AppMethodBeat.o(31430);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(31432);
    this.vNQ.stopTimer();
    if (this.sue != null) {
      this.sue.dismiss();
    }
    az.agi().b(233, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (k)paramn;
      paramn = paramString.aHg();
      if ((paramn == null) || (paramn.length() == 0))
      {
        aHu(this.DrZ);
        AppMethodBeat.o(31432);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramn);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("geta8key_session_id", paramString.aHo());
      d.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
      AppMethodBeat.o(31432);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    aHu(this.DrZ);
    AppMethodBeat.o(31432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ac
 * JD-Core Version:    0.7.0.1
 */