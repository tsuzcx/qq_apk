package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.a.ol.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class c
  extends a
{
  public k.b Iqt;
  boolean Iqu;
  j.a Iqv;
  com.tencent.mm.sdk.b.c fTb;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(152782);
    this.Iqu = false;
    this.fTb = new com.tencent.mm.sdk.b.c() {};
    this.Iqv = new j.a()
    {
      public final void C(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152781);
        ((l)g.ab(l.class)).azE().b(c.this.Iqt.getCmdId(), c.this.Iqv);
        if (c.this.Iqu)
        {
          AppMethodBeat.o(152781);
          return;
        }
        c.this.Iqu = true;
        if (c.this.Iqr != null)
        {
          if ((c.this.Iqr instanceof e))
          {
            e locale = (e)c.this.Iqr;
            locale.ret = paramAnonymousInt;
            locale.title = paramAnonymousString1;
            locale.content = paramAnonymousString2;
          }
          c.this.Iqr.a(0, paramAnonymousInt, "", c.this.Iqr);
        }
        if (c.this.tipDialog != null) {
          c.this.tipDialog.dismiss();
        }
        AppMethodBeat.o(152781);
      }
    };
    this.Iqo = paramBoolean;
    AppMethodBeat.o(152782);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(152785);
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    cAs();
    AppMethodBeat.o(152785);
  }
  
  public final void cAs()
  {
    AppMethodBeat.i(152784);
    ae.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.Iqt });
    if ((this.Iqp != null) || (this.Iqq != null) || (this.Iqr != null))
    {
      this.fTb.alive();
      ((l)g.ab(l.class)).azE().a(this.Iqt.getCmdId(), this.Iqv);
    }
    ((l)g.ab(l.class)).azE().d(this.Iqt);
    AppMethodBeat.o(152784);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152783);
    ((l)g.ab(l.class)).azE().e(this.Iqt);
    ((l)g.ab(l.class)).azE().b(this.Iqt.getCmdId(), this.Iqv);
    this.fTb.dead();
    AppMethodBeat.o(152783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c
 * JD-Core Version:    0.7.0.1
 */