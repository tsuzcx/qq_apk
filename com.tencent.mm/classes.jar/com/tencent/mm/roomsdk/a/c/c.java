package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.nt.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class c
  extends a
{
  public j.b ENn;
  boolean ENo;
  i.a ENp;
  com.tencent.mm.sdk.b.c fub;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(152782);
    this.ENo = false;
    this.fub = new com.tencent.mm.sdk.b.c() {};
    this.ENp = new i.a()
    {
      public final void D(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152781);
        ((k)g.ab(k.class)).apL().b(c.this.ENn.getCmdId(), c.this.ENp);
        if (c.this.ENo)
        {
          AppMethodBeat.o(152781);
          return;
        }
        c.this.ENo = true;
        if (c.this.ENl != null)
        {
          if ((c.this.ENl instanceof e))
          {
            e locale = (e)c.this.ENl;
            locale.ret = paramAnonymousInt;
            locale.title = paramAnonymousString1;
            locale.content = paramAnonymousString2;
          }
          c.this.ENl.a(0, paramAnonymousInt, "", c.this.ENl);
        }
        if (c.this.tipDialog != null) {
          c.this.tipDialog.dismiss();
        }
        AppMethodBeat.o(152781);
      }
    };
    this.ENi = paramBoolean;
    AppMethodBeat.o(152782);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(152785);
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    eDp();
    AppMethodBeat.o(152785);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152783);
    ((k)g.ab(k.class)).apL().d(this.ENn);
    ((k)g.ab(k.class)).apL().b(this.ENn.getCmdId(), this.ENp);
    this.fub.dead();
    AppMethodBeat.o(152783);
  }
  
  public final void eDp()
  {
    AppMethodBeat.i(152784);
    ad.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.ENn });
    if ((this.ENj != null) || (this.ENk != null) || (this.ENl != null))
    {
      this.fub.alive();
      ((k)g.ab(k.class)).apL().a(this.ENn.getCmdId(), this.ENp);
    }
    ((k)g.ab(k.class)).apL().c(this.ENn);
    AppMethodBeat.o(152784);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c
 * JD-Core Version:    0.7.0.1
 */