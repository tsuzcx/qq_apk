package com.tencent.mm.roomsdk.model.factory;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class b
  extends a
{
  public p maU;
  com.tencent.mm.am.h maV;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(152775);
    this.maV = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(152774);
        if (b.this.maU.equals(paramAnonymousp))
        {
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baD().mCm.b(paramAnonymousp.getType(), b.this.maV);
          if (b.this.tipDialog != null) {
            b.this.tipDialog.dismiss();
          }
          if ((paramAnonymousp instanceof com.tencent.mm.roomsdk.model.a)) {
            ((com.tencent.mm.roomsdk.model.a)paramAnonymousp).a(b.this.acmz);
          }
          if (b.this.acmz != null) {
            b.this.acmz.onResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.acmz);
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (b.this.acmx != null)
            {
              b.this.acmx.onResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.acmx);
              AppMethodBeat.o(152774);
            }
          }
          else if (b.this.acmy != null) {
            b.this.acmy.onResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.acmy);
          }
        }
        AppMethodBeat.o(152774);
      }
    };
    this.acmw = paramBoolean;
    AppMethodBeat.o(152775);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(234086);
    if (this.maU == null)
    {
      AppMethodBeat.o(234086);
      return;
    }
    this.tipDialog = k.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    blj();
    AppMethodBeat.o(234086);
  }
  
  public final void blj()
  {
    AppMethodBeat.i(152777);
    if (this.maU == null)
    {
      AppMethodBeat.o(152777);
      return;
    }
    Log.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.maU });
    if ((this.tipDialog != null) || (this.acmx != null) || (this.acmy != null) || (this.acmz != null))
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(this.maU.getType(), this.maV);
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(this.maU, 0);
    AppMethodBeat.o(152777);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152776);
    if (this.maU == null)
    {
      AppMethodBeat.o(152776);
      return;
    }
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(this.maU);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(this.maU.getType(), this.maV);
    AppMethodBeat.o(152776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.model.factory.b
 * JD-Core Version:    0.7.0.1
 */