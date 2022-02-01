package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b
  extends a
{
  public n ghA;
  f ghB;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(152775);
    this.ghB = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(152774);
        if (b.this.ghA.equals(paramAnonymousn))
        {
          g.ajS();
          g.ajQ().gDv.b(paramAnonymousn.getType(), b.this.ghB);
          if (b.this.tipDialog != null) {
            b.this.tipDialog.dismiss();
          }
          if ((paramAnonymousn instanceof com.tencent.mm.roomsdk.a.a)) {
            ((com.tencent.mm.roomsdk.a.a)paramAnonymousn).a(b.this.Iqr);
          }
          if (b.this.Iqr != null) {
            b.this.Iqr.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.Iqr);
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (b.this.Iqp != null)
            {
              b.this.Iqp.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.Iqp);
              AppMethodBeat.o(152774);
            }
          }
          else if (b.this.Iqq != null) {
            b.this.Iqq.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.Iqq);
          }
        }
        AppMethodBeat.o(152774);
      }
    };
    this.Iqo = paramBoolean;
    AppMethodBeat.o(152775);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(152778);
    if (this.ghA == null)
    {
      AppMethodBeat.o(152778);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    cAs();
    AppMethodBeat.o(152778);
  }
  
  public final void cAs()
  {
    AppMethodBeat.i(152777);
    if (this.ghA == null)
    {
      AppMethodBeat.o(152777);
      return;
    }
    ae.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.ghA });
    if ((this.tipDialog != null) || (this.Iqp != null) || (this.Iqq != null) || (this.Iqr != null))
    {
      g.ajS();
      g.ajQ().gDv.a(this.ghA.getType(), this.ghB);
    }
    g.ajS();
    g.ajQ().gDv.a(this.ghA, 0);
    AppMethodBeat.o(152777);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152776);
    if (this.ghA == null)
    {
      AppMethodBeat.o(152776);
      return;
    }
    g.ajS();
    g.ajQ().gDv.a(this.ghA);
    g.ajS();
    g.ajQ().gDv.b(this.ghA.getType(), this.ghB);
    AppMethodBeat.o(152776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b
 * JD-Core Version:    0.7.0.1
 */