package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;

public final class r$a
  extends c
{
  private r.c zUs;
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33009);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969091);
      ((View)localObject).setTag(new r.d().fi((View)localObject));
    }
    AppMethodBeat.o(33009);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33010);
    this.zzP = parama1;
    parama = (r.d)parama;
    if (this.zUs == null) {
      this.zUs = new r.c(this.zzP, this);
    }
    r.d.a(parama, paramInt, parama1, parambi, false, this.zUs, c(parama1));
    AppMethodBeat.o(33010);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(33011);
    boolean bool = r.a(this.zzP, paramContextMenu, paramView, parambi);
    AppMethodBeat.o(33011);
    return bool;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    AppMethodBeat.i(33012);
    if (paramMenuItem.getItemId() == 111)
    {
      paramMenuItem = j.b.mY(bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
      if (paramMenuItem != null) {
        h.qsU.e(16979, new Object[] { paramMenuItem.fiY, paramMenuItem.fiW, Integer.valueOf(0), Integer.valueOf(2) });
      }
      d.b.a(parama, parambi, b(parama, parambi));
    }
    AppMethodBeat.o(33012);
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 687865905);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return true;
  }
  
  final boolean dLp()
  {
    return false;
  }
  
  final boolean dLq()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.a
 * JD-Core Version:    0.7.0.1
 */