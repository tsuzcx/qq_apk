package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.oc.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class c
  extends a
{
  boolean GkA;
  i.a GkB;
  public j.b Gkz;
  com.tencent.mm.sdk.b.c fxI;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(152782);
    this.GkA = false;
    this.fxI = new com.tencent.mm.sdk.b.c() {};
    this.GkB = new i.a()
    {
      public final void D(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152781);
        ((k)g.ab(k.class)).awA().b(c.this.Gkz.getCmdId(), c.this.GkB);
        if (c.this.GkA)
        {
          AppMethodBeat.o(152781);
          return;
        }
        c.this.GkA = true;
        if (c.this.Gkx != null)
        {
          if ((c.this.Gkx instanceof e))
          {
            e locale = (e)c.this.Gkx;
            locale.ret = paramAnonymousInt;
            locale.title = paramAnonymousString1;
            locale.content = paramAnonymousString2;
          }
          c.this.Gkx.a(0, paramAnonymousInt, "", c.this.Gkx);
        }
        if (c.this.tipDialog != null) {
          c.this.tipDialog.dismiss();
        }
        AppMethodBeat.o(152781);
      }
    };
    this.Gku = paramBoolean;
    AppMethodBeat.o(152782);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(152785);
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    csU();
    AppMethodBeat.o(152785);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152783);
    ((k)g.ab(k.class)).awA().d(this.Gkz);
    ((k)g.ab(k.class)).awA().b(this.Gkz.getCmdId(), this.GkB);
    this.fxI.dead();
    AppMethodBeat.o(152783);
  }
  
  public final void csU()
  {
    AppMethodBeat.i(152784);
    ac.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.Gkz });
    if ((this.Gkv != null) || (this.Gkw != null) || (this.Gkx != null))
    {
      this.fxI.alive();
      ((k)g.ab(k.class)).awA().a(this.Gkz.getCmdId(), this.GkB);
    }
    ((k)g.ab(k.class)).awA().c(this.Gkz);
    AppMethodBeat.o(152784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c
 * JD-Core Version:    0.7.0.1
 */