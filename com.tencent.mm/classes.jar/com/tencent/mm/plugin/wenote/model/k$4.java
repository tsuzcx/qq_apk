package com.tencent.mm.plugin.wenote.model;

import android.os.Message;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.sdk.platformtools.ah;

final class k$4
  extends ah
{
  k$4(k paramk) {}
  
  public final void handleMessage(Message paramMessage)
  {
    if (k.c(this.rGm).rGC.booleanValue())
    {
      k.d(this.rGm).chE();
      k.c(this.rGm).rGC = Boolean.valueOf(false);
    }
    k.c(this.rGm).rGW = ((int)com.tencent.mm.bj.a.ck(k.e(this.rGm)));
    sendEmptyMessageDelayed(4096, 250L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.k.4
 * JD-Core Version:    0.7.0.1
 */