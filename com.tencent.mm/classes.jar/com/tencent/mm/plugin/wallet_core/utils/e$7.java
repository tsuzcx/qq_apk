package com.tencent.mm.plugin.wallet_core.utils;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.cju;
import com.tencent.mm.protocal.protobuf.cjw;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e$7
  implements MenuItem.OnMenuItemClickListener
{
  public e$7(bfq parambfq, e.a parama, MMActivity paramMMActivity) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(48022);
    Object localObject = this.uyt.wNE;
    paramMenuItem = new ArrayList();
    if ((localObject != null) && (((cjw)localObject).xTN != null) && (!((cjw)localObject).xTN.isEmpty()))
    {
      localObject = ((cjw)localObject).xTN.iterator();
      while (((Iterator)localObject).hasNext()) {
        paramMenuItem.add(((cju)((Iterator)localObject).next()).wna);
      }
    }
    paramMenuItem = paramMenuItem.iterator();
    while (paramMenuItem.hasNext())
    {
      localObject = (bvz)paramMenuItem.next();
      if (this.uyo != null)
      {
        e.a(this.val$activity, (bvz)localObject);
        this.uyo.a((bvz)localObject);
      }
      else
      {
        e.a(this.val$activity, (bvz)localObject);
      }
    }
    AppMethodBeat.o(48022);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e.7
 * JD-Core Version:    0.7.0.1
 */