package com.tencent.mm.plugin.multitalk.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.multitalk.model.f;
import com.tencent.mm.plugin.multitalk.model.j;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.multitalk.ui.widget.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

final class MultiTalkSelectContactUI$1
  implements MenuItem.OnMenuItemClickListener
{
  MultiTalkSelectContactUI$1(MultiTalkSelectContactUI paramMultiTalkSelectContactUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(54158);
    if (!at.isNetworkConnected(ah.getContext())) {
      com.tencent.mm.bg.e.a(this.oVj, 2131304713, null);
    }
    for (;;)
    {
      this.oVj.hideVKB();
      AppMethodBeat.o(54158);
      return true;
      paramMenuItem = new LinkedList();
      paramMenuItem.addAll(MultiTalkSelectContactUI.a(this.oVj));
      paramMenuItem.add(r.Zn());
      paramMenuItem = bo.d(paramMenuItem, ",");
      if (MultiTalkSelectContactUI.b(this.oVj))
      {
        com.tencent.mm.plugin.multitalk.model.e.a(MultiTalkSelectContactUI.a(this.oVj).size(), MultiTalkSelectContactUI.c(this.oVj), 1, "", MultiTalkSelectContactUI.d(this.oVj).oVN);
        p.bTF().b(this.oVj, paramMenuItem, MultiTalkSelectContactUI.e(this.oVj));
      }
      else
      {
        com.tencent.mm.plugin.multitalk.model.e.a(MultiTalkSelectContactUI.a(this.oVj).size(), MultiTalkSelectContactUI.c(this.oVj), 2, j.bTu(), 0);
        this.oVj.setResult(-1, this.oVj.getIntent().putExtra("Select_Contact", paramMenuItem));
        this.oVj.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.MultiTalkSelectContactUI.1
 * JD-Core Version:    0.7.0.1
 */