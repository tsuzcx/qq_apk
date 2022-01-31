package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class o$1
  implements MenuItem.OnMenuItemClickListener
{
  o$1(o paramo) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(30620);
    paramMenuItem = new Intent();
    Object localObject2 = ((h)this.zyF.caz.ay(h.class)).dGZ();
    if (localObject2 != null)
    {
      Object localObject1 = new ArrayList();
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject2).next();
        if (localLong != null) {
          ((List)localObject1).add(localLong);
        }
      }
      localObject2 = new long[((List)localObject1).size()];
      localObject1 = ((List)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2[i] = ((Long)((Iterator)localObject1).next()).longValue();
        i += 1;
      }
      paramMenuItem.putExtra("k_outside_expose_proof_item_list", (long[])localObject2);
      this.zyF.caz.zJz.getContext().setResult(-1, paramMenuItem);
    }
    for (;;)
    {
      paramMenuItem.putExtra("k_is_group_chat", this.zyF.caz.dJG());
      this.zyF.caz.zJz.dGb();
      AppMethodBeat.o(30620);
      return false;
      this.zyF.caz.zJz.getContext().setResult(0, paramMenuItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o.1
 * JD-Core Version:    0.7.0.1
 */