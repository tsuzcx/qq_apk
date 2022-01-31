package com.tencent.mm.plugin.voip_cs.b.a;

import android.content.Context;
import android.widget.TextView;
import com.tencent.mm.plugin.voip_cs.a.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class b$2
  implements am.a
{
  b$2(b paramb) {}
  
  public final boolean tC()
  {
    b.a(this.qeI).setText(ae.getContext().getString(a.e.voip_cs_waiting));
    b.b(this.qeI).setVisibility(0);
    com.tencent.mm.plugin.voip_cs.c.b localb = b.c(this.qeI);
    TextView localTextView = b.b(this.qeI);
    Object localObject = b.pWP;
    if ((localObject == null) || (localTextView == null)) {
      y.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
    }
    for (;;)
    {
      return true;
      localb.bSc();
      localb.pXf = 0;
      localb.pXd = ((int[])localObject);
      localb.lh = localTextView;
      localb.pXe = 500;
      if (localb.fjC != null)
      {
        localObject = localb.fjC;
        long l = localb.pXe;
        ((am)localObject).S(l, l);
      }
      y.b("MicroMsg.DynamicTextWrap", "start textview:" + localTextView, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.2
 * JD-Core Version:    0.7.0.1
 */