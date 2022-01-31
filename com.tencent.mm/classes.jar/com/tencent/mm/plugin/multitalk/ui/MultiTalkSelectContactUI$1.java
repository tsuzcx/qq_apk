package com.tencent.mm.plugin.multitalk.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.multitalk.a.g;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.j;
import com.tencent.mm.plugin.multitalk.a.p;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

final class MultiTalkSelectContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MultiTalkSelectContactUI$1(MultiTalkSelectContactUI paramMultiTalkSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (!aq.isNetworkConnected(ae.getContext())) {
      com.tencent.mm.bf.e.a(this.mvr, a.g.voip_net_unavailable, null);
    }
    for (;;)
    {
      this.mvr.XM();
      return true;
      paramMenuItem = new LinkedList();
      paramMenuItem.addAll(MultiTalkSelectContactUI.a(this.mvr));
      paramMenuItem.add(q.Gj());
      paramMenuItem = bk.c(paramMenuItem, ",");
      if (MultiTalkSelectContactUI.b(this.mvr))
      {
        com.tencent.mm.plugin.multitalk.a.e.a(MultiTalkSelectContactUI.a(this.mvr).size(), MultiTalkSelectContactUI.c(this.mvr), 1, "", MultiTalkSelectContactUI.d(this.mvr).mvV);
        p.blF().b(this.mvr, paramMenuItem, MultiTalkSelectContactUI.e(this.mvr));
      }
      else
      {
        com.tencent.mm.plugin.multitalk.a.e.a(MultiTalkSelectContactUI.a(this.mvr).size(), MultiTalkSelectContactUI.c(this.mvr), 2, j.blu(), 0);
        this.mvr.setResult(-1, this.mvr.getIntent().putExtra("Select_Contact", paramMenuItem));
        this.mvr.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */