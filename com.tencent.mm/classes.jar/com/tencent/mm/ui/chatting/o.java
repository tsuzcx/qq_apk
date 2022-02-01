package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.s.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class o
{
  public long[] JAK;
  public com.tencent.mm.ui.chatting.e.a cWM;
  
  public o(final com.tencent.mm.ui.chatting.e.a parama, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(34486);
    this.JAK = null;
    this.cWM = parama;
    this.JAK = paramArrayOfLong;
    this.cWM.JOR.removeAllOptionMenu();
    this.cWM.JOR.addTextOptionMenu(2, this.cWM.JOR.getMMResources().getString(2131756588), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34484);
        paramAnonymousMenuItem = new Intent();
        Object localObject2 = ((k)o.this.cWM.bh(k.class)).fCk();
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
          paramAnonymousMenuItem.putExtra("k_outside_expose_proof_item_list", (long[])localObject2);
          o.this.cWM.JOR.getContext().setResult(-1, paramAnonymousMenuItem);
        }
        for (;;)
        {
          paramAnonymousMenuItem.putExtra("k_is_group_chat", o.this.cWM.fFv());
          o.this.cWM.JOR.fAX();
          AppMethodBeat.o(34484);
          return false;
          o.this.cWM.JOR.getContext().setResult(0, paramAnonymousMenuItem);
        }
      }
    }, null, s.b.JbS);
    parama = (k)this.cWM.bh(k.class);
    parama.e(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34485);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingExposeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        parama.DR(((Long)paramAnonymousView.getTag()).longValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingExposeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34485);
      }
    });
    AppMethodBeat.o(34486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.o
 * JD-Core Version:    0.7.0.1
 */