package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ae;

final class f$14$1
  implements a
{
  f$14$1(f.14 param14) {}
  
  public final void a(Intent paramIntent, h paramh)
  {
    if (!this.mud.mtZ.bkC())
    {
      paramh.Qb(ae.getContext().getString(a.g.multitalk_waiting_wording));
      return;
    }
    int i = this.mud.mtZ.mtK;
    paramh.Qb(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
  }
  
  public final boolean bbL()
  {
    return (this.mud.mtZ.blh()) || (this.mud.mtZ.bkC());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.f.14.1
 * JD-Core Version:    0.7.0.1
 */