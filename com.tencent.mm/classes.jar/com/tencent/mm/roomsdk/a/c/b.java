package com.tencent.mm.roomsdk.a.c;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.h;

public final class b
  extends a
{
  f fur;
  public m uAW;
  
  public b(boolean paramBoolean)
  {
    AppMethodBeat.i(80258);
    this.fur = new b.1(this);
    this.yjH = paramBoolean;
    AppMethodBeat.o(80258);
  }
  
  public final void a(Context paramContext, String paramString, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(80261);
    if (this.uAW == null)
    {
      AppMethodBeat.o(80261);
      return;
    }
    this.tipDialog = h.b(paramContext, paramString, paramBoolean, paramOnCancelListener);
    drn();
    AppMethodBeat.o(80261);
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(80259);
    if (this.uAW == null)
    {
      AppMethodBeat.o(80259);
      return;
    }
    g.RM();
    g.RK().eHt.a(this.uAW);
    g.RM();
    g.RK().eHt.b(this.uAW.getType(), this.fur);
    AppMethodBeat.o(80259);
  }
  
  public final void drn()
  {
    AppMethodBeat.i(80260);
    if (this.uAW == null)
    {
      AppMethodBeat.o(80260);
      return;
    }
    ab.i("MicroMsg.RoomCallbackFactory", "request scene %s", new Object[] { this.uAW });
    if ((this.tipDialog != null) || (this.yjI != null) || (this.yjJ != null) || (this.yjK != null))
    {
      g.RM();
      g.RK().eHt.a(this.uAW.getType(), this.fur);
    }
    g.RM();
    g.RK().eHt.a(this.uAW, 0);
    AppMethodBeat.o(80260);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b
 * JD-Core Version:    0.7.0.1
 */