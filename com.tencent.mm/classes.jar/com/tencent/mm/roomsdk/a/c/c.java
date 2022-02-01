package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.qa;
import com.tencent.mm.f.a.qa.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.s;

public final class c
  extends a
{
  public k.b URn;
  boolean URo;
  j.a URp;
  IListener jil;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(152782);
    this.URo = false;
    this.jil = new IListener() {};
    this.URp = new j.a()
    {
      public final void I(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152781);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().b(c.this.URn.getCmdId(), c.this.URp);
        if (c.this.URo)
        {
          AppMethodBeat.o(152781);
          return;
        }
        c.this.URo = true;
        if (c.this.URl != null)
        {
          if ((c.this.URl instanceof e))
          {
            e locale = (e)c.this.URl;
            locale.ret = paramAnonymousInt;
            locale.title = paramAnonymousString1;
            locale.content = paramAnonymousString2;
          }
          c.this.URl.a(0, paramAnonymousInt, "", c.this.URl);
        }
        if (c.this.tipDialog != null) {
          c.this.tipDialog.dismiss();
        }
        AppMethodBeat.o(152781);
      }
    };
    this.URi = paramBoolean;
    AppMethodBeat.o(152782);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(189464);
    this.tipDialog = com.tencent.mm.ui.base.h.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    aRu();
    AppMethodBeat.o(189464);
  }
  
  public final void aRu()
  {
    AppMethodBeat.i(152784);
    Log.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.URn });
    if ((this.URj != null) || (this.URk != null) || (this.URl != null))
    {
      this.jil.alive();
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().a(this.URn.getCmdId(), this.URp);
    }
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().d(this.URn);
    AppMethodBeat.o(152784);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152783);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().e(this.URn);
    ((n)com.tencent.mm.kernel.h.ae(n.class)).bbK().b(this.URn.getCmdId(), this.URp);
    this.jil.dead();
    AppMethodBeat.o(152783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c
 * JD-Core Version:    0.7.0.1
 */