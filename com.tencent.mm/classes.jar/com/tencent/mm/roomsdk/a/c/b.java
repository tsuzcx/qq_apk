package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;

public final class b
  extends a
{
  public com.tencent.mm.ak.q gNg;
  i gNh;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(152775);
    this.gNh = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
      {
        AppMethodBeat.i(152774);
        if (b.this.gNg.equals(paramAnonymousq))
        {
          g.aAi();
          g.aAg().hqi.b(paramAnonymousq.getType(), b.this.gNh);
          if (b.this.tipDialog != null) {
            b.this.tipDialog.dismiss();
          }
          if ((paramAnonymousq instanceof com.tencent.mm.roomsdk.a.a)) {
            ((com.tencent.mm.roomsdk.a.a)paramAnonymousq).a(b.this.NDO);
          }
          if (b.this.NDO != null) {
            b.this.NDO.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.NDO);
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            if (b.this.NDM != null)
            {
              b.this.NDM.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.NDM);
              AppMethodBeat.o(152774);
            }
          }
          else if (b.this.NDN != null) {
            b.this.NDN.a(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousString, b.this.NDN);
          }
        }
        AppMethodBeat.o(152774);
      }
    };
    this.NDL = paramBoolean;
    AppMethodBeat.o(152775);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(223896);
    if (this.gNg == null)
    {
      AppMethodBeat.o(223896);
      return;
    }
    this.tipDialog = h.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    aJu();
    AppMethodBeat.o(223896);
  }
  
  public final void aJu()
  {
    AppMethodBeat.i(152777);
    if (this.gNg == null)
    {
      AppMethodBeat.o(152777);
      return;
    }
    Log.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.gNg });
    if ((this.tipDialog != null) || (this.NDM != null) || (this.NDN != null) || (this.NDO != null))
    {
      g.aAi();
      g.aAg().hqi.a(this.gNg.getType(), this.gNh);
    }
    g.aAi();
    g.aAg().hqi.a(this.gNg, 0);
    AppMethodBeat.o(152777);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152776);
    if (this.gNg == null)
    {
      AppMethodBeat.o(152776);
      return;
    }
    g.aAi();
    g.aAg().hqi.a(this.gNg);
    g.aAi();
    g.aAg().hqi.b(this.gNg.getType(), this.gNh);
    AppMethodBeat.o(152776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b
 * JD-Core Version:    0.7.0.1
 */