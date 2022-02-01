package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b
  extends a
{
  public n AxZ;
  com.tencent.mm.al.g gWw;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(152775);
    this.gWw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(152774);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.b(paramAnonymousn.getType(), b.this.gWw);
        if (b.this.tipDialog != null) {
          b.this.tipDialog.dismiss();
        }
        if (b.this.AxZ.equals(paramAnonymousn))
        {
          if ((paramAnonymousn instanceof com.tencent.mm.roomsdk.a.a)) {
            ((com.tencent.mm.roomsdk.a.a)paramAnonymousn).a(b.this.ENl);
          }
          if (b.this.ENl != null) {
            b.this.ENl.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.ENl);
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (b.this.ENj != null)
            {
              b.this.ENj.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.ENj);
              AppMethodBeat.o(152774);
            }
          }
          else if (b.this.ENk != null) {
            b.this.ENk.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.ENk);
          }
        }
        AppMethodBeat.o(152774);
      }
    };
    this.ENi = paramBoolean;
    AppMethodBeat.o(152775);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(152778);
    if (this.AxZ == null)
    {
      AppMethodBeat.o(152778);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    eDp();
    AppMethodBeat.o(152778);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152776);
    if (this.AxZ == null)
    {
      AppMethodBeat.o(152776);
      return;
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(this.AxZ);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(this.AxZ.getType(), this.gWw);
    AppMethodBeat.o(152776);
  }
  
  public final void eDp()
  {
    AppMethodBeat.i(152777);
    if (this.AxZ == null)
    {
      AppMethodBeat.o(152777);
      return;
    }
    ad.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.AxZ });
    if ((this.tipDialog != null) || (this.ENj != null) || (this.ENk != null) || (this.ENl != null))
    {
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(this.AxZ.getType(), this.gWw);
    }
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(this.AxZ, 0);
    AppMethodBeat.o(152777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b
 * JD-Core Version:    0.7.0.1
 */