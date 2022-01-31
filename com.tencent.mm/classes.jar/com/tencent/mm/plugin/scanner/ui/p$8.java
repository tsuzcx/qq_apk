package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.util.e;

final class p$8
  implements Runnable
{
  p$8(p paramp, byte[] paramArrayOfByte, Point paramPoint, int paramInt, Rect paramRect) {}
  
  public final void run()
  {
    AppMethodBeat.i(81211);
    try
    {
      Object localObject2 = ((e)this.qAf.cim()).a(this.val$data, this.qAi, this.hJr, this.qAj, this.qAf.qzY);
      if (localObject2 != null) {
        synchronized (this.qAf.ceY)
        {
          if ((this.qAf.qzX == null) || (this.qAf.qzZ < localObject2.length))
          {
            this.qAf.qzX = new byte[localObject2.length];
            this.qAf.qzZ = localObject2.length;
          }
          System.arraycopy(localObject2, 0, this.qAf.qzX, 0, localObject2.length);
          localObject2 = this.qAf;
          ((p)localObject2).bufferSize += 1;
          p.b(this.qAf);
          AppMethodBeat.o(81211);
          return;
        }
      }
      AppMethodBeat.o(81211);
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(81211);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.p.8
 * JD-Core Version:    0.7.0.1
 */