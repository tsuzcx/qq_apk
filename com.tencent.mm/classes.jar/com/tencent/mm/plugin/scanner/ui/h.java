package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public final class h
  implements i
{
  MTimerHandler BiQ;
  l CPb;
  Context context;
  String url;
  com.tencent.mm.ui.base.q wSy;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(52017);
    this.BiQ = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52016);
        h localh = h.this;
        Context localContext = h.this.context;
        h.this.context.getString(2131755998);
        localh.wSy = com.tencent.mm.ui.base.h.a(localContext, h.this.context.getString(2131756029), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(52015);
            g.azz().a(h.this.CPb);
            h.this.wSy = null;
            AppMethodBeat.o(52015);
          }
        });
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
    com.tencent.mm.plugin.scanner.h.jRt.i(localIntent, this.context);
    AppMethodBeat.o(52018);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(52019);
    this.BiQ.stopTimer();
    if (this.wSy != null) {
      this.wSy.dismiss();
    }
    g.azz().b(233, this);
    paramString = (l)paramq;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramq = paramString.beQ();
      if ((paramq == null) || (paramq.length() == 0))
      {
        b(this.url, paramString.beY(), paramString.bfa());
        AppMethodBeat.o(52019);
        return;
      }
      b(paramq, paramString.beY(), paramString.bfa());
      AppMethodBeat.o(52019);
      return;
    }
    Log.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    b(this.url, paramString.beY(), paramString.bfa());
    AppMethodBeat.o(52019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h
 * JD-Core Version:    0.7.0.1
 */