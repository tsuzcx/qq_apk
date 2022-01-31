package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import java.util.Set;

final class b$1
  implements Runnable
{
  b$1(b paramb, b.b paramb1) {}
  
  public final void run()
  {
    b localb = this.ooN;
    b.b localb1 = this.ooM;
    localb.dup.add(localb1);
    int i = b.ooB + 1;
    b.ooB = i;
    if (i <= 1)
    {
      g.DQ();
      g.DO().dJT.a(208, localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.b.1
 * JD-Core Version:    0.7.0.1
 */