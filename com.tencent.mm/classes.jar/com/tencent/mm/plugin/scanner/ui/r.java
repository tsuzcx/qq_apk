package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.j;
import com.tencent.mm.plugin.scanner.c;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public final class r
  implements f
{
  Context context;
  com.tencent.mm.ui.base.p mOt;
  ap pDa;
  j qBT;
  String url;
  
  public r(Context paramContext)
  {
    AppMethodBeat.i(81364);
    this.pDa = new ap(new r.1(this), false);
    this.context = paramContext;
    AppMethodBeat.o(81364);
  }
  
  final void c(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(81365);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    localIntent.putExtra("useJs", true);
    localIntent.putExtra("vertical_scroll", true);
    localIntent.putExtra("geta8key_session_id", paramInt);
    localIntent.putExtra("geta8key_cookie", paramArrayOfByte);
    c.gmO.i(localIntent, this.context);
    AppMethodBeat.o(81365);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(81366);
    this.pDa.stopTimer();
    if (this.mOt != null) {
      this.mOt.dismiss();
    }
    g.Rc().b(233, this);
    paramString = (j)paramm;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramm = paramString.ajl();
      if ((paramm == null) || (paramm.length() == 0))
      {
        c(this.url, paramString.ajt(), paramString.ajv());
        AppMethodBeat.o(81366);
        return;
      }
      c(paramm, paramString.ajt(), paramString.ajv());
      AppMethodBeat.o(81366);
      return;
    }
    ab.e("MicroMsg.scanner.ViewMMURL", "getA8Key fail, errType = " + paramInt1 + ", errCode = " + paramInt2);
    c(this.url, paramString.ajt(), paramString.ajv());
    AppMethodBeat.o(81366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.r
 * JD-Core Version:    0.7.0.1
 */