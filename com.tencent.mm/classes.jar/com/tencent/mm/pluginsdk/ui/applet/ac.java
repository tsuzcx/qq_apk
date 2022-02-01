package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;

public final class ac
  implements i
{
  private s Hdp;
  private MTimerHandler Hdq;
  private l IUD;
  private String RgZ;
  private Context context;
  
  public ac(Context paramContext)
  {
    AppMethodBeat.i(31429);
    this.Hdq = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(31428);
        ac localac = ac.this;
        Context localContext = ac.a(ac.this);
        ac.a(ac.this).getString(R.l.app_tip);
        ac.a(localac, h.a(localContext, ac.a(ac.this).getString(R.l.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(31427);
            bh.aGY().a(ac.b(ac.this));
            ac.a(ac.this, null);
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
  
  private void brr(String paramString)
  {
    AppMethodBeat.i(31431);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", this.context.getString(R.l.eyU, new Object[] { paramString }));
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("neverGetA8Key", true);
    com.tencent.mm.by.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
    AppMethodBeat.o(31431);
  }
  
  public final void brq(String paramString)
  {
    AppMethodBeat.i(31430);
    if ((paramString == null) || (paramString.length() == 0))
    {
      Log.e("MicroMsg.ViewQZone", "go fail, qqNum is null");
      AppMethodBeat.o(31430);
      return;
    }
    this.RgZ = paramString;
    bh.beI();
    String str1 = (String)com.tencent.mm.model.c.aHp().b(46, null);
    bh.beI();
    String str2 = Util.nullAsNil((String)com.tencent.mm.model.c.aHp().b(72, null));
    Log.i("MicroMsg.ViewQZone", "get a2key:[%s], get new a2key:[%s]", new Object[] { str1, str2 });
    if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
    {
      brr(paramString);
      AppMethodBeat.o(31430);
      return;
    }
    bh.aGY().a(233, this);
    this.IUD = new l(p.fT(paramString), l.boo());
    bh.aGY().a(this.IUD, 0);
    this.Hdq.startTimer(3000L);
    AppMethodBeat.o(31430);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(31432);
    this.Hdq.stopTimer();
    if (this.Hdp != null) {
      this.Hdp.dismiss();
    }
    bh.aGY().b(233, this);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (l)paramq;
      paramq = paramString.bof();
      if ((paramq == null) || (paramq.length() == 0))
      {
        brr(this.RgZ);
        AppMethodBeat.o(31432);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramq);
      localIntent.putExtra("useJs", true);
      localIntent.putExtra("vertical_scroll", true);
      localIntent.putExtra("neverGetA8Key", true);
      localIntent.putExtra("geta8key_session_id", paramString.bon());
      com.tencent.mm.by.c.b(this.context, "webview", ".ui.tools.ContactQZoneWebView", localIntent);
      AppMethodBeat.o(31432);
      return;
    }
    Log.e("MicroMsg.ViewQZone", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    brr(this.RgZ);
    AppMethodBeat.o(31432);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.ac
 * JD-Core Version:    0.7.0.1
 */