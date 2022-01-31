package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.protocal.c.za;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class RemittanceBusiUI$6
  implements n.c
{
  RemittanceBusiUI$6(RemittanceBusiUI paramRemittanceBusiUI, List paramList, HashSet paramHashSet) {}
  
  public final void a(l paraml)
  {
    int j = 0;
    int i = 0;
    RemittanceBusiUI.a(this.nCA, RemittanceBusiUI.n(this.nCA));
    Iterator localIterator;
    if ((!RemittanceBusiUI.A(this.nCA).bwm()) || (RemittanceBusiUI.o(this.nCA) <= 0.0D)) {
      localIterator = this.nCB.iterator();
    }
    while (localIterator.hasNext())
    {
      za localza = (za)localIterator.next();
      paraml.a(i, localza.sXV, localza.sXX, null, true);
      this.nCC.add(Integer.valueOf(i));
      i += 1;
      continue;
      localIterator = this.nCB.iterator();
      i = j;
      if (localIterator.hasNext())
      {
        localza = (za)localIterator.next();
        if (localza.sYd == 1)
        {
          paraml.a(i, localza.sXV, localza.sXX, null, true);
          this.nCC.add(Integer.valueOf(i));
        }
        for (;;)
        {
          i += 1;
          break;
          paraml.a(i, localza.sXV, localza.sXX);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.6
 * JD-Core Version:    0.7.0.1
 */