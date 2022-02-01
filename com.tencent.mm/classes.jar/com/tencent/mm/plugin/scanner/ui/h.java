package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.modelsimple.n;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class h
  implements com.tencent.mm.am.h
{
  private w NbI;
  MTimerHandler NbJ;
  n Pdv;
  private Context context;
  String url;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(52017);
    this.NbJ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52016);
        h localh = h.this;
        Context localContext = h.a(h.this);
        h.a(h.this).getString(l.i.app_tip);
        h.a(localh, k.a(localContext, h.a(h.this).getString(l.i.app_waiting), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(52015);
            com.tencent.mm.kernel.h.aZW().a(h.b(h.this));
            h.a(h.this, null);
            AppMethodBeat.o(52015);
          }
        }));
        AppMethodBeat.o(52016);
        return false;
      }
    }, false);
    this.context = paramContext;
    AppMethodBeat.o(52017);
  }
  
  final void b(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(52018);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("geta8key_session_id", paramInt);
    localIntent.putExtra("geta8key_cookie", paramArrayOfByte);
    com.tencent.mm.plugin.scanner.m.dFc().h(localIntent, this.context);
    AppMethodBeat.o(52018);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(52019);
    this.NbJ.stopTimer();
    if (this.NbI != null) {
      this.NbI.dismiss();
    }
    com.tencent.mm.kernel.h.aZW().b(233, this);
    paramString = (n)paramp;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramp = paramString.bLT();
      if ((paramp == null) || (paramp.length() == 0))
      {
        b(this.url, paramString.bMc(), paramString.bMe());
        AppMethodBeat.o(52019);
        return;
      }
      b(paramp, paramString.bMc(), paramString.bMe());
      AppMethodBeat.o(52019);
      return;
    }
    Log.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    b(this.url, paramString.bMc(), paramString.bMe());
    AppMethodBeat.o(52019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h
 * JD-Core Version:    0.7.0.1
 */