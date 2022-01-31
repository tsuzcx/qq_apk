package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public final class c
  extends a
{
  com.tencent.mm.sdk.b.c ehn;
  public j.b yjM;
  boolean yjN;
  i.a yjO;
  
  public c(boolean paramBoolean)
  {
    AppMethodBeat.i(80266);
    this.yjN = false;
    this.ehn = new c.1(this);
    this.yjO = new c.2(this);
    this.yjH = paramBoolean;
    AppMethodBeat.o(80266);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(80269);
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    drn();
    AppMethodBeat.o(80269);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(80267);
    ((j)g.E(j.class)).Yz().d(this.yjM);
    ((j)g.E(j.class)).Yz().b(this.yjM.getCmdId(), this.yjO);
    this.ehn.dead();
    AppMethodBeat.o(80267);
  }
  
  public final void drn()
  {
    AppMethodBeat.i(80268);
    ab.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.yjM });
    if ((this.yjI != null) || (this.yjJ != null) || (this.yjK != null))
    {
      this.ehn.alive();
      ((j)g.E(j.class)).Yz().a(this.yjM.getCmdId(), this.yjO);
    }
    ((j)g.E(j.class)).Yz().c(this.yjM);
    AppMethodBeat.o(80268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c
 * JD-Core Version:    0.7.0.1
 */