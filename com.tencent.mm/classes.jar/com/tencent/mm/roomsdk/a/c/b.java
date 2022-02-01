package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;

public final class b
  extends a
{
  public q jxA;
  i jxB;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(152775);
    this.jxB = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(152774);
        if (b.this.jxA.equals(paramAnonymousq))
        {
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHF().kcd.b(paramAnonymousq.getType(), b.this.jxB);
          if (b.this.tipDialog != null) {
            b.this.tipDialog.dismiss();
          }
          if ((paramAnonymousq instanceof com.tencent.mm.roomsdk.a.a)) {
            ((com.tencent.mm.roomsdk.a.a)paramAnonymousq).a(b.this.URl);
          }
          if (b.this.URl != null) {
            b.this.URl.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.URl);
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (b.this.URj != null)
            {
              b.this.URj.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.URj);
              AppMethodBeat.o(152774);
            }
          }
          else if (b.this.URk != null) {
            b.this.URk.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.URk);
          }
        }
        AppMethodBeat.o(152774);
      }
    };
    this.URi = paramBoolean;
    AppMethodBeat.o(152775);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(219959);
    if (this.jxA == null)
    {
      AppMethodBeat.o(219959);
      return;
    }
    this.tipDialog = com.tencent.mm.ui.base.h.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    aRu();
    AppMethodBeat.o(219959);
  }
  
  public final void aRu()
  {
    AppMethodBeat.i(152777);
    if (this.jxA == null)
    {
      AppMethodBeat.o(152777);
      return;
    }
    Log.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.jxA });
    if ((this.tipDialog != null) || (this.URj != null) || (this.URk != null) || (this.URl != null))
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(this.jxA.getType(), this.jxB);
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(this.jxA, 0);
    AppMethodBeat.o(152777);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152776);
    if (this.jxA == null)
    {
      AppMethodBeat.o(152776);
      return;
    }
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.a(this.jxA);
    com.tencent.mm.kernel.h.aHH();
    com.tencent.mm.kernel.h.aHF().kcd.b(this.jxA.getType(), this.jxB);
    AppMethodBeat.o(152776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b
 * JD-Core Version:    0.7.0.1
 */