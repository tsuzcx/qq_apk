package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends a
{
  com.tencent.mm.sdk.b.c dpQ = new c.1(this);
  public i.b ubx;
  boolean uby = false;
  h.a ubz = new c.2(this);
  
  public c(boolean paramBoolean)
  {
    this.ubr = paramBoolean;
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.tipDialog = com.tencent.mm.ui.base.h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    cpz();
  }
  
  public final void cancel()
  {
    ((j)g.r(j.class)).Fv().c(this.ubx);
    ((j)g.r(j.class)).Fv().b(this.ubx.getCmdId(), this.ubz);
    this.dpQ.dead();
  }
  
  public final void cpz()
  {
    y.i("MicroMsg.RoomCallbackFactory", "request oplog %s", new Object[] { this.ubx });
    if ((this.ubs != null) || (this.ubt != null) || (this.ubu != null))
    {
      this.dpQ.cqo();
      ((j)g.r(j.class)).Fv().a(this.ubx.getCmdId(), this.ubz);
    }
    ((j)g.r(j.class)).Fv().b(this.ubx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.c
 * JD-Core Version:    0.7.0.1
 */