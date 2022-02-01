package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.w.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class p
{
  public long[] WAh;
  public com.tencent.mm.ui.chatting.e.a fgR;
  
  public p(final com.tencent.mm.ui.chatting.e.a parama, long[] paramArrayOfLong)
  {
    AppMethodBeat.i(34486);
    this.WAh = null;
    this.fgR = parama;
    this.WAh = paramArrayOfLong;
    this.fgR.WQv.removeAllOptionMenu();
    this.fgR.WQv.addTextOptionMenu(2, this.fgR.WQv.getMMResources().getString(R.l.biz_report_confirm), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(34484);
        paramAnonymousMenuItem = new Intent();
        Object localObject2 = ((k)p.this.fgR.bC(k.class)).hND();
        if (localObject2 != null)
        {
          Object localObject1 = new ArrayList();
          ((List)localObject1).addAll((Collection)localObject2);
          Collections.sort((List)localObject1);
          localObject2 = new long[((List)localObject1).size()];
          localObject1 = ((List)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2[i] = ((Long)((Iterator)localObject1).next()).longValue();
            i += 1;
          }
          paramAnonymousMenuItem.putExtra("k_outside_expose_proof_item_list", (long[])localObject2);
          p.this.fgR.WQv.getContext().setResult(-1, paramAnonymousMenuItem);
        }
        for (;;)
        {
          paramAnonymousMenuItem.putExtra("k_is_group_chat", p.this.fgR.hRi());
          p.this.fgR.WQv.hMr();
          AppMethodBeat.o(34484);
          return false;
          p.this.fgR.WQv.getContext().setResult(0, paramAnonymousMenuItem);
        }
      }
    }, null, w.b.Wao);
    parama = (k)this.fgR.bC(k.class);
    parama.k(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(34485);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChattingExposeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        parama.VC(((Long)paramAnonymousView.getTag()).longValue());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingExposeMode$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(34485);
      }
    });
    AppMethodBeat.o(34486);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.p
 * JD-Core Version:    0.7.0.1
 */