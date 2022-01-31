package com.tencent.mm.ui.chatting.b;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.chatting.c.a;

final class c$1
  implements c.a
{
  c$1(c paramc) {}
  
  public final boolean cDV()
  {
    if (c.a(this.voK) == null)
    {
      i.a(this.voK.byx.vtz, R.h.viewstub_bizwait);
      c.a(this.voK, (RelativeLayout)this.voK.byx.findViewById(R.h.bizwait));
      c.a(this.voK, (TextView)this.voK.byx.findViewById(R.h.bizwait_msg));
      c.b(this.voK).setText(R.l.chatfooter_getting);
    }
    c.a(this.voK).setVisibility(0);
    a.cFG().postDelayed(new c.1.1(this), 5000L);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.c.1
 * JD-Core Version:    0.7.0.1
 */