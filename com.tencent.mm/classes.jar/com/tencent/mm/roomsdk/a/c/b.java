package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b
  extends a
{
  public n DqO;
  f hPn;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(152775);
    this.hPn = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(152774);
        if (b.this.DqO.equals(paramAnonymousn))
        {
          g.ajD();
          g.ajB().gAO.b(paramAnonymousn.getType(), b.this.hPn);
          if (b.this.tipDialog != null) {
            b.this.tipDialog.dismiss();
          }
          if ((paramAnonymousn instanceof com.tencent.mm.roomsdk.a.a)) {
            ((com.tencent.mm.roomsdk.a.a)paramAnonymousn).a(b.this.HWj);
          }
          if (b.this.HWj != null) {
            b.this.HWj.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.HWj);
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (b.this.HWh != null)
            {
              b.this.HWh.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.HWh);
              AppMethodBeat.o(152774);
            }
          }
          else if (b.this.HWi != null) {
            b.this.HWi.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.HWi);
          }
        }
        AppMethodBeat.o(152774);
      }
    };
    this.HWg = paramBoolean;
    AppMethodBeat.o(152775);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(152778);
    if (this.DqO == null)
    {
      AppMethodBeat.o(152778);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    cyR();
    AppMethodBeat.o(152778);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152776);
    if (this.DqO == null)
    {
      AppMethodBeat.o(152776);
      return;
    }
    g.ajD();
    g.ajB().gAO.a(this.DqO);
    g.ajD();
    g.ajB().gAO.b(this.DqO.getType(), this.hPn);
    AppMethodBeat.o(152776);
  }
  
  public final void cyR()
  {
    AppMethodBeat.i(152777);
    if (this.DqO == null)
    {
      AppMethodBeat.o(152777);
      return;
    }
    ad.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.DqO });
    if ((this.tipDialog != null) || (this.HWh != null) || (this.HWi != null) || (this.HWj != null))
    {
      g.ajD();
      g.ajB().gAO.a(this.DqO.getType(), this.hPn);
    }
    g.ajD();
    g.ajB().gAO.a(this.DqO, 0);
    AppMethodBeat.o(152777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b
 * JD-Core Version:    0.7.0.1
 */