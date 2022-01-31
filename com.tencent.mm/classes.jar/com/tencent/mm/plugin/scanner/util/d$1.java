package com.tencent.mm.plugin.scanner.util;

import android.graphics.Point;
import com.tencent.mm.sdk.platformtools.ai;

public final class d$1
  implements Runnable
{
  public d$1(d paramd, byte[] paramArrayOfByte, Point paramPoint) {}
  
  public final void run()
  {
    if (d.a(this.nOA, this.val$data, this.nOz))
    {
      ai.d(new d.1.1(this));
      return;
    }
    ai.d(new Runnable()
    {
      public final void run()
      {
        if (d.1.this.nOA.nOn != null) {
          d.1.this.nOA.nOn.fB(d.1.this.nOA.nOr);
        }
      }
    });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.d.1
 * JD-Core Version:    0.7.0.1
 */