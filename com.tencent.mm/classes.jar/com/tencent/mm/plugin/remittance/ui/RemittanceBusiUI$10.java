package com.tencent.mm.plugin.remittance.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.picker.d;
import com.tencent.mm.ui.widget.picker.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class RemittanceBusiUI$10
  implements n.d
{
  RemittanceBusiUI$10(RemittanceBusiUI paramRemittanceBusiUI, HashSet paramHashSet, List paramList, d paramd) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    int i = 1;
    int j = 0;
    AppMethodBeat.i(142183);
    if (this.qoH.contains(Integer.valueOf(paramInt)))
    {
      AppMethodBeat.o(142183);
      return;
    }
    if (paramInt < this.qoG.size())
    {
      h.qsU.e(15235, new Object[] { Integer.valueOf(4) });
      Object localObject1 = (adh)this.qoG.get(paramInt);
      paramMenuItem = this.qoI;
      boolean bool;
      if (paramMenuItem.AJe != null)
      {
        paramMenuItem = paramMenuItem.AJe.dPr();
        bool = paramMenuItem.contains(Integer.valueOf(paramInt));
        if (bool) {
          break label214;
        }
      }
      for (;;)
      {
        localObject2 = new LinkedList();
        paramMenuItem = paramMenuItem.iterator();
        while (paramMenuItem.hasNext())
        {
          int k = ((Integer)paramMenuItem.next()).intValue();
          if ((k < this.qoG.size()) && ((i != 0) || (paramInt != k))) {
            ((List)localObject2).add((adh)this.qoG.get(k));
          }
        }
        paramMenuItem = new ArrayList();
        break;
        label214:
        i = 0;
      }
      if (i != 0) {
        ((List)localObject2).add(localObject1);
      }
      b localb = RemittanceBusiUI.H(this.qoF);
      if (i != 0) {}
      for (paramMenuItem = (MenuItem)localObject1;; paramMenuItem = null)
      {
        localb.a((List)localObject2, paramMenuItem);
        localObject1 = RemittanceBusiUI.H(this.qoF).qkU;
        paramMenuItem = new HashSet();
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((adg)localObject1).wAS.iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramMenuItem.add(Long.valueOf(((adh)((Iterator)localObject1).next()).wVT));
        }
      }
      localObject1 = new HashMap();
      Object localObject2 = this.qoG.iterator();
      i = j;
      if (((Iterator)localObject2).hasNext())
      {
        if (paramMenuItem.contains(Long.valueOf(((adh)((Iterator)localObject2).next()).wVT))) {
          ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.TRUE);
        }
        for (;;)
        {
          if (i == paramInt) {
            ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.valueOf(bool));
          }
          i += 1;
          break;
          ((HashMap)localObject1).put(Integer.valueOf(i), Boolean.FALSE);
        }
      }
      paramMenuItem = this.qoI;
      if (paramMenuItem.AJe != null)
      {
        paramMenuItem.AJe.AJh = ((HashMap)localObject1);
        paramMenuItem.AJe.notifyDataSetChanged();
      }
    }
    AppMethodBeat.o(142183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBusiUI.10
 * JD-Core Version:    0.7.0.1
 */