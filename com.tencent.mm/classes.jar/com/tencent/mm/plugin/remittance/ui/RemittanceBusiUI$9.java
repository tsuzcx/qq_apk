package com.tencent.mm.plugin.remittance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class RemittanceBusiUI$9
  implements n.c
{
  RemittanceBusiUI$9(RemittanceBusiUI paramRemittanceBusiUI, List paramList, HashSet paramHashSet) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(142182);
    int j = 0;
    int i = 0;
    RemittanceBusiUI.a(this.qoF, RemittanceBusiUI.n(this.qoF));
    adh localadh;
    if ((!RemittanceBusiUI.H(this.qoF).chd()) || (RemittanceBusiUI.o(this.qoF) <= 0.0D))
    {
      localIterator = this.qoG.iterator();
      while (localIterator.hasNext())
      {
        localadh = (adh)localIterator.next();
        paraml.a(i, localadh.wVU, localadh.wVW, null, true);
        this.qoH.add(Integer.valueOf(i));
        i += 1;
      }
      AppMethodBeat.o(142182);
      return;
    }
    Iterator localIterator = this.qoG.iterator();
    i = j;
    if (localIterator.hasNext())
    {
      localadh = (adh)localIterator.next();
      if (localadh.wWc == 1)
      {
        paraml.a(i, localadh.wVU, localadh.wVW, null, true);
        this.qoH.add(Integer.valueOf(i));
      }
      for (;;)
      {
        i += 1;
        break;
        paraml.a(i, localadh.wVU, localadh.wVW);
      }
    }
    AppMethodBeat.o(142182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.9
 * JD-Core Version:    0.7.0.1
 */