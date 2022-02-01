package com.tencent.mm.plugin.wallet_core.utils;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dni;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g$7
  implements MenuItem.OnMenuItemClickListener
{
  public g$7(ccr paramccr, g.a parama, MMActivity paramMMActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(71657);
    Object localObject = this.DFQ.Gtc;
    paramMenuItem = new ArrayList();
    if ((localObject != null) && (((dnl)localObject).HUA != null) && (!((dnl)localObject).HUA.isEmpty()))
    {
      localObject = ((dnl)localObject).HUA.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramMenuItem.add(((dni)((Iterator)localObject).next()).FLp);
      }
    }
    paramMenuItem = paramMenuItem.iterator();
    while (paramMenuItem.hasNext())
    {
      localObject = (cxk)paramMenuItem.next();
      if (this.DFM != null)
      {
        g.a(this.val$activity, (cxk)localObject, null);
        this.DFM.a((cxk)localObject);
      }
      else
      {
        g.a(this.val$activity, (cxk)localObject, null);
      }
    }
    AppMethodBeat.o(71657);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.g.7
 * JD-Core Version:    0.7.0.1
 */