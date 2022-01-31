package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

public final class m$b
  extends c
{
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32969);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969070);
      ((View)localObject).setTag(new m.a().fd((View)localObject));
    }
    AppMethodBeat.o(32969);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32970);
    this.zzP = parama1;
    m.a.a((m.a)parama, paramInt, parama1, parambi, this);
    AppMethodBeat.o(32970);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32971);
    int i = ((az)paramView.getTag()).position;
    if (parambi != null) {
      paramContextMenu.add(i, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    }
    AppMethodBeat.o(32971);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 704643121);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  final boolean dLp()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.b
 * JD-Core Version:    0.7.0.1
 */