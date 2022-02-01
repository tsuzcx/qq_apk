package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.plugin.scanner.f;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.base.p;

public final class h
  implements com.tencent.mm.al.g
{
  Context context;
  p rll;
  av uEZ;
  String url;
  k vWB;
  
  public h(Context paramContext)
  {
    AppMethodBeat.i(52017);
    this.uEZ = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52016);
        h localh = h.this;
        Context localContext = h.this.context;
        h.this.context.getString(2131755906);
        localh.rll = com.tencent.mm.ui.base.h.b(localContext, h.this.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(52015);
            com.tencent.mm.kernel.g.aeS().a(h.this.vWB);
            h.this.rll = null;
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
    f.hYt.i(localIntent, this.context);
    AppMethodBeat.o(52018);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(52019);
    this.uEZ.stopTimer();
    if (this.rll != null) {
      this.rll.dismiss();
    }
    com.tencent.mm.kernel.g.aeS().b(233, this);
    paramString = (k)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramn = paramString.aAq();
      if ((paramn == null) || (paramn.length() == 0))
      {
        b(this.url, paramString.aAy(), paramString.aAA());
        AppMethodBeat.o(52019);
        return;
      }
      b(paramn, paramString.aAy(), paramString.aAA());
      AppMethodBeat.o(52019);
      return;
    }
    ad.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    b(this.url, paramString.aAy(), paramString.aAA());
    AppMethodBeat.o(52019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.h
 * JD-Core Version:    0.7.0.1
 */