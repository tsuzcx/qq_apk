package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ok;
import com.tencent.mm.g.a.ok.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class c
  extends a
{
  public k.b HWl;
  boolean HWm;
  j.a HWn;
  com.tencent.mm.sdk.b.c fQV;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(152782);
    this.HWm = false;
    this.fQV = new com.tencent.mm.sdk.b.c() {};
    this.HWn = new j.a()
    {
      public final void C(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152781);
        ((l)g.ab(l.class)).azo().b(c.this.HWl.getCmdId(), c.this.HWn);
        if (c.this.HWm)
        {
          AppMethodBeat.o(152781);
          return;
        }
        c.this.HWm = true;
        if (c.this.HWj != null)
        {
          if ((c.this.HWj instanceof e))
          {
            e locale = (e)c.this.HWj;
            locale.ret = paramAnonymousInt;
            locale.title = paramAnonymousString1;
            locale.content = paramAnonymousString2;
          }
          c.this.HWj.a(0, paramAnonymousInt, "", c.this.HWj);
        }
        if (c.this.tipDialog != null) {
          c.this.tipDialog.dismiss();
        }
        AppMethodBeat.o(152781);
      }
    };
    this.HWg = paramBoolean;
    AppMethodBeat.o(152782);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(152785);
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    cyR();
    AppMethodBeat.o(152785);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152783);
    ((l)g.ab(l.class)).azo().d(this.HWl);
    ((l)g.ab(l.class)).azo().b(this.HWl.getCmdId(), this.HWn);
    this.fQV.dead();
    AppMethodBeat.o(152783);
  }
  
  public final void cyR()
  {
    AppMethodBeat.i(152784);
    ad.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.HWl });
    if ((this.HWh != null) || (this.HWi != null) || (this.HWj != null))
    {
      this.fQV.alive();
      ((l)g.ab(l.class)).azo().a(this.HWl.getCmdId(), this.HWn);
    }
    ((l)g.ab(l.class)).azo().c(this.HWl);
    AppMethodBeat.o(152784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c
 * JD-Core Version:    0.7.0.1
 */