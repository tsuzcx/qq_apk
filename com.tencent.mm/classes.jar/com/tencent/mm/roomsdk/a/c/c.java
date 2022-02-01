package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pd;
import com.tencent.mm.g.a.pd.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.roomsdk.a.b.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;

public final class c
  extends a
{
  public k.b NDQ;
  boolean NDR;
  j.a NDS;
  IListener gyj;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(152782);
    this.NDR = false;
    this.gyj = new IListener() {};
    this.NDS = new j.a()
    {
      public final void F(int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(152781);
        ((l)g.af(l.class)).aSM().b(c.this.NDQ.getCmdId(), c.this.NDS);
        if (c.this.NDR)
        {
          AppMethodBeat.o(152781);
          return;
        }
        c.this.NDR = true;
        if (c.this.NDO != null)
        {
          if ((c.this.NDO instanceof e))
          {
            e locale = (e)c.this.NDO;
            locale.ret = paramAnonymousInt;
            locale.title = paramAnonymousString1;
            locale.content = paramAnonymousString2;
          }
          c.this.NDO.a(0, paramAnonymousInt, "", c.this.NDO);
        }
        if (c.this.tipDialog != null) {
          c.this.tipDialog.dismiss();
        }
        AppMethodBeat.o(152781);
      }
    };
    this.NDL = paramBoolean;
    AppMethodBeat.o(152782);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(223897);
    this.tipDialog = h.a(paramContext, paramString2, paramBoolean2, paramOnCancelListener);
    aJu();
    AppMethodBeat.o(223897);
  }
  
  public final void aJu()
  {
    AppMethodBeat.i(152784);
    Log.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.NDQ });
    if ((this.NDM != null) || (this.NDN != null) || (this.NDO != null))
    {
      this.gyj.alive();
      ((l)g.af(l.class)).aSM().a(this.NDQ.getCmdId(), this.NDS);
    }
    ((l)g.af(l.class)).aSM().d(this.NDQ);
    AppMethodBeat.o(152784);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(152783);
    ((l)g.af(l.class)).aSM().e(this.NDQ);
    ((l)g.af(l.class)).aSM().b(this.NDQ.getCmdId(), this.NDS);
    this.gyj.dead();
    AppMethodBeat.o(152783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c
 * JD-Core Version:    0.7.0.1
 */