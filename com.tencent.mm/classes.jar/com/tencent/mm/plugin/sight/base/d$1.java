package com.tencent.mm.plugin.sight.base;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.j;

final class d$1
  implements Runnable
{
  d$1(int paramInt) {}
  
  public final void run()
  {
    int i = d.access$000();
    while (i < this.mff)
    {
      b localb1 = new b(String.format("%s/tempvideo%s.mp4", new Object[] { g.DP().dKt + "video/", Integer.valueOf(i) }));
      if (localb1.exists()) {
        localb1.delete();
      }
      b localb2 = new b(j.n(localb1.cLr()) + ".remux");
      if (localb2.exists()) {
        localb2.delete();
      }
      localb1 = new b(localb1.cLs() + ".thumb");
      if (localb1.exists()) {
        localb1.delete();
      }
      i += 1;
    }
    d.access$002(Math.max(this.mff, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.base.d.1
 * JD-Core Version:    0.7.0.1
 */