package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.modelsimple.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class i
  implements com.tencent.mm.ak.g
{
  Context context;
  p sue;
  String url;
  au vNQ;
  k xho;
  
  public i(Context paramContext)
  {
    AppMethodBeat.i(52017);
    this.vNQ = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(52016);
        i locali = i.this;
        Context localContext = i.this.context;
        i.this.context.getString(2131755906);
        locali.sue = h.b(localContext, i.this.context.getString(2131755936), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymous2DialogInterface)
          {
            AppMethodBeat.i(52015);
            com.tencent.mm.kernel.g.agi().a(i.this.xho);
            i.this.sue = null;
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
    com.tencent.mm.plugin.scanner.g.iyx.i(localIntent, this.context);
    AppMethodBeat.o(52018);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(52019);
    this.vNQ.stopTimer();
    if (this.sue != null) {
      this.sue.dismiss();
    }
    com.tencent.mm.kernel.g.agi().b(233, this);
    paramString = (k)paramn;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramn = paramString.aHg();
      if ((paramn == null) || (paramn.length() == 0))
      {
        b(this.url, paramString.aHo(), paramString.aHq());
        AppMethodBeat.o(52019);
        return;
      }
      b(paramn, paramString.aHo(), paramString.aHq());
      AppMethodBeat.o(52019);
      return;
    }
    ac.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    b(this.url, paramString.aHo(), paramString.aHq());
    AppMethodBeat.o(52019);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.i
 * JD-Core Version:    0.7.0.1
 */