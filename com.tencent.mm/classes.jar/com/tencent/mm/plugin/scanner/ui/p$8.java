package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.scanner.util.d;

final class p$8
  implements Runnable
{
  p$8(p paramp, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect) {}
  
  public final void run()
  {
    ??? = ((d)this.nMw.bxp()).a(this.val$data, this.nMA, this.gpn, this.nMB, this.nMw.nMr);
    if (??? != null)
    {
      if ((this.nMw.nMq == null) || (this.nMw.nMs < ???.length))
      {
        this.nMw.nMq = new byte[???.length];
        this.nMw.nMs = ???.length;
      }
      System.arraycopy(???, 0, this.nMw.nMq, 0, ???.length);
      synchronized (this.nMw.bjn)
      {
        p localp = this.nMw;
        localp.bufferSize += 1;
        p.b(this.nMw);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.8
 * JD-Core Version:    0.7.0.1
 */