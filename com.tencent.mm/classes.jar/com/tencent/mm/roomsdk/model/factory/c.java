package com.tencent.mm.roomsdk.model.factory;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.roomsdk.model.b.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;

public final class c
  extends a
{
  j.a PuH;
  public k.b acmB;
  boolean acmC;
  IListener lKB;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(152782);
    this.acmC = false;
    this.lKB = new RoomOpLogCallbackFactory.1(this, f.hfK);
    this.PuH = new j.a()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152781);
        ((n)h.ax(n.class)).bzz().b(c.this.acmB.getCmdId(), c.this.PuH);
        if (c.this.acmC)
        {
          AppMethodBeat.o(152781);
          return;
        }
        c.this.acmC = true;
        if (c.this.acmz != null)
        {
          if ((c.this.acmz instanceof e))
          {
            e locale = (e)c.this.acmz;
            locale.ret = paramAnonymousInt;
            locale.title = paramAnonymousString1;
            locale.content = paramAnonymousString2;
          }
          c.this.acmz.onResult(0, paramAnonymousInt, "", c.this.acmz);
        }
        if (c.this.tipDialog != null) {
          c.this.tipDialog.dismiss();
        }
        AppMethodBeat.o(152781);
      }
    };
    this.acmw = paramBoolean;
    AppMethodBeat.o(152782);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(234087);
    this.tipDialog = k.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    blj();
    AppMethodBeat.o(234087);
  }
  
  public final void blj()
  {
    AppMethodBeat.i(152784);
    Log.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.acmB });
    if ((this.acmx != null) || (this.acmy != null) || (this.acmz != null))
    {
      this.lKB.alive();
      ((n)h.ax(n.class)).bzz().a(this.acmB.getCmdId(), this.PuH);
    }
    ((n)h.ax(n.class)).bzz().d(this.acmB);
    AppMethodBeat.o(152784);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152783);
    ((n)h.ax(n.class)).bzz().e(this.acmB);
    ((n)h.ax(n.class)).bzz().b(this.acmB.getCmdId(), this.PuH);
    this.lKB.dead();
    AppMethodBeat.o(152783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.model.factory.c
 * JD-Core Version:    0.7.0.1
 */