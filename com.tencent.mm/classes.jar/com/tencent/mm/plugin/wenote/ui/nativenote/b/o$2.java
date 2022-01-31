package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.os.Message;
import android.widget.TextView;
import com.tencent.mm.bj.a;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;

final class o$2
  extends ah
{
  o$2(o paramo) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (o.a(this.rNE).rGJ)
    {
      o.b(this.rNE).removeMessages(4096);
      return;
    }
    paramMessage = " " + a.x(ae.getContext(), o.a(this.rNE).rGW).toString();
    o.c(this.rNE).setText(paramMessage);
    sendEmptyMessageDelayed(4096, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.o.2
 * JD-Core Version:    0.7.0.1
 */