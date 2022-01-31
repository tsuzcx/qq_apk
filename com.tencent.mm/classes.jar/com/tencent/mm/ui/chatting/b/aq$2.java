package com.tencent.mm.ui.chatting.b;

import android.view.View;
import android.view.ViewStub;
import com.tencent.mm.R.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.ui.chatting.c.a;

final class aq$2
  implements ChatFooter.d
{
  aq$2(aq paramaq) {}
  
  public final void h(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      if (aq.a(this.vts) == null) {
        aq.a(this.vts, ((ViewStub)this.vts.byx.findViewById(R.h.viewstub_voiceinput_mask_view)).inflate());
      }
      aq.a(this.vts).setVisibility(0);
    }
    while ((aq.a(this.vts) == null) || (aq.a(this.vts).getVisibility() != 0)) {
      return;
    }
    aq.a(this.vts).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.aq.2
 * JD-Core Version:    0.7.0.1
 */