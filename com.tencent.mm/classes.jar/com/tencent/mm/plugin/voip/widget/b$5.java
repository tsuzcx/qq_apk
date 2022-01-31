package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.voip.a.e;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ae;

final class b$5
  implements a
{
  b$5(b paramb) {}
  
  public final void a(Intent paramIntent, h paramh)
  {
    if (paramIntent.getBooleanExtra("Voip_Is_Talking", false))
    {
      paramh.Qb(this.qcP.bSI());
      return;
    }
    paramh.Qb(ae.getContext().getString(a.e.voip_multitalk_waiting_wording));
  }
  
  public final boolean bbL()
  {
    return (com.tencent.mm.plugin.voip.a.b.Ay(b.d(this.qcP))) || (com.tencent.mm.plugin.voip.a.b.Aw(b.d(this.qcP)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.b.5
 * JD-Core Version:    0.7.0.1
 */