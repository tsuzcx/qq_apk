package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.ui.base.p;

public final class i
  implements f
{
  Context context;
  p tBx;
  String url;
  aw xkQ;
  l yLp;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(52017);
    this.xkQ = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52016);
        i locali = i.this;
        Context localContext = i.this.context;
        i.this.context.getString(2131755906);
        locali.tBx = com.tencent.mm.ui.base.h.b(localContext, i.this.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(52015);
            g.ajj().a(i.this.yLp);
            i.this.tBx = null;
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
    com.tencent.mm.plugin.scanner.h.iUz.i(localIntent, this.context);
    AppMethodBeat.o(52018);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(52019);
    this.xkQ.stopTimer();
    if (this.tBx != null) {
      this.tBx.dismiss();
    }
    g.ajj().b(233, this);
    paramString = (l)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramn = paramString.aKO();
      if ((paramn == null) || (paramn.length() == 0))
      {
        b(this.url, paramString.aKW(), paramString.aKY());
        AppMethodBeat.o(52019);
        return;
      }
      b(paramn, paramString.aKW(), paramString.aKY());
      AppMethodBeat.o(52019);
      return;
    }
    ae.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    b(this.url, paramString.aKW(), paramString.aKY());
    AppMethodBeat.o(52019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.i
 * JD-Core Version:    0.7.0.1
 */