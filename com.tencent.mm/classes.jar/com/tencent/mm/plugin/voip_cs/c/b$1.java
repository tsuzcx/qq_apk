package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.am.a;

final class b$1
  implements am.a
{
  b$1(b paramb) {}
  
  public final boolean tC()
  {
    int i = this.qfd.pXd[(this.qfd.pXf % this.qfd.pXd.length)];
    if (this.qfd.lh != null)
    {
      if (-1 != i) {
        break label68;
      }
      this.qfd.lh.setText(null);
    }
    for (;;)
    {
      b localb = this.qfd;
      localb.pXf += 1;
      return true;
      label68:
      this.qfd.lh.setText(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b.1
 * JD-Core Version:    0.7.0.1
 */