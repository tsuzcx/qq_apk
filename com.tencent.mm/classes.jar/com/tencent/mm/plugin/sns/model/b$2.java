package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import java.util.Set;

final class b$2
  implements Runnable
{
  b$2(b paramb, b.b paramb1) {}
  
  public final void run()
  {
    b localb = this.ooN;
    b.b localb1 = this.ooM;
    localb.dup.remove(localb1);
    int i = b.ooB - 1;
    b.ooB = i;
    if (i <= 0)
    {
      g.DQ();
      g.DO().dJT.b(208, localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.2
 * JD-Core Version:    0.7.0.1
 */