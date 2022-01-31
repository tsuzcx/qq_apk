package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class ab$1
  extends ah
{
  ab$1(ab paramab, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if ((ab.a(this.ord) >= 5) || (System.currentTimeMillis() - ab.b(this.ord) > 300000L))
    {
      y.d("MicroMsg.RemoveSnsTask", "cleanCount: " + ab.a(this.ord));
      ab.lER = false;
    }
    while ((ab.c(this.ord)) || (!ab.lER)) {
      return;
    }
    new ab.a(this.ord).p(new String[] { "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ab.1
 * JD-Core Version:    0.7.0.1
 */