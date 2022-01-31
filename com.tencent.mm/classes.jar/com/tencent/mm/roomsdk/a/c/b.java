package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

public final class b
  extends a
{
  f eeo = new b.1(this);
  public m ubv;
  
  public b(boolean paramBoolean)
  {
    this.ubr = paramBoolean;
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (this.ubv == null) {
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    cpz();
  }
  
  public final void cancel()
  {
    if (this.ubv == null) {
      return;
    }
    g.DQ();
    g.DO().dJT.c(this.ubv);
    g.DQ();
    g.DO().dJT.b(this.ubv.getType(), this.eeo);
  }
  
  public final void cpz()
  {
    if (this.ubv == null) {
      return;
    }
    y.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.ubv });
    if ((this.tipDialog != null) || (this.ubs != null) || (this.ubt != null) || (this.ubu != null))
    {
      g.DQ();
      g.DO().dJT.a(this.ubv.getType(), this.eeo);
    }
    g.DQ();
    g.DO().dJT.a(this.ubv, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b
 * JD-Core Version:    0.7.0.1
 */