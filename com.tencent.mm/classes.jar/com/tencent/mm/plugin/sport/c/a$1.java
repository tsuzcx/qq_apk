package com.tencent.mm.plugin.sport.c;

import com.tencent.mm.h.a.rb;
import com.tencent.mm.h.a.rb.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;

final class a$1
  extends c<rb>
{
  a$1(a parama)
  {
    this.udX = rb.class.getName().hashCode();
  }
  
  private boolean a(rb paramrb)
  {
    long l;
    boolean bool1;
    switch (paramrb.cap.action)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
      do
      {
        return false;
        g.bLm();
      } while (!a.bLj());
      this.pti.bLi();
      l = this.pti.bLh();
      if (paramrb.cap.action == 1) {
        bool1 = this.pti.gE(l);
      }
      break;
    }
    for (;;)
    {
      y.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d %b", new Object[] { Integer.valueOf(paramrb.cap.action), Long.valueOf(l), Boolean.valueOf(bool1) });
      return false;
      if (n.M(this.pti.bLg(), l))
      {
        bool1 = this.pti.gE(l);
        continue;
        g.bLm();
        if (!a.bLj()) {
          break;
        }
        this.pti.bLi();
        l = this.pti.bLh();
        a locala = this.pti;
        if (locala.ptf == 0L) {
          locala.ptf = i.Q(3, 0L);
        }
        boolean bool2 = n.L(locala.ptf, System.currentTimeMillis());
        boolean bool3 = n.M(this.pti.bLg(), l);
        if ((bool3) || (bool2)) {}
        for (bool1 = this.pti.gE(l);; bool1 = false)
        {
          y.i("MicroMsg.Sport.DeviceStepManager", "upload step %d %d result %b timeCondition %b stepCountCondition %b", new Object[] { Integer.valueOf(paramrb.cap.action), Long.valueOf(l), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          return false;
        }
      }
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sport.c.a.1
 * JD-Core Version:    0.7.0.1
 */