package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b
  extends a
{
  public n BQv;
  com.tencent.mm.ak.g hwV;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(152775);
    this.hwV = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(152774);
        if (b.this.BQv.equals(paramAnonymousn))
        {
          com.tencent.mm.kernel.g.agS();
          com.tencent.mm.kernel.g.agQ().ghe.b(paramAnonymousn.getType(), b.this.hwV);
          if (b.this.tipDialog != null) {
            b.this.tipDialog.dismiss();
          }
          if ((paramAnonymousn instanceof com.tencent.mm.roomsdk.a.a)) {
            ((com.tencent.mm.roomsdk.a.a)paramAnonymousn).a(b.this.Gkx);
          }
          if (b.this.Gkx != null) {
            b.this.Gkx.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.Gkx);
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (b.this.Gkv != null)
            {
              b.this.Gkv.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.Gkv);
              AppMethodBeat.o(152774);
            }
          }
          else if (b.this.Gkw != null) {
            b.this.Gkw.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.Gkw);
          }
        }
        AppMethodBeat.o(152774);
      }
    };
    this.Gku = paramBoolean;
    AppMethodBeat.o(152775);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(152778);
    if (this.BQv == null)
    {
      AppMethodBeat.o(152778);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    csU();
    AppMethodBeat.o(152778);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152776);
    if (this.BQv == null)
    {
      AppMethodBeat.o(152776);
      return;
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(this.BQv);
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.b(this.BQv.getType(), this.hwV);
    AppMethodBeat.o(152776);
  }
  
  public final void csU()
  {
    AppMethodBeat.i(152777);
    if (this.BQv == null)
    {
      AppMethodBeat.o(152777);
      return;
    }
    ac.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.BQv });
    if ((this.tipDialog != null) || (this.Gkv != null) || (this.Gkw != null) || (this.Gkx != null))
    {
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(this.BQv.getType(), this.hwV);
    }
    com.tencent.mm.kernel.g.agS();
    com.tencent.mm.kernel.g.agQ().ghe.a(this.BQv, 0);
    AppMethodBeat.o(152777);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b
 * JD-Core Version:    0.7.0.1
 */