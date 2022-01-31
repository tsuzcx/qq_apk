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

public final class m$c
  extends c
{
  private a zzP;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(32972);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969108);
      ((View)localObject).setTag(new m.a().fd((View)localObject));
    }
    AppMethodBeat.o(32972);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(32973);
    this.zzP = parama1;
    m.a.a((m.a)parama, paramInt, parama1, parambi, this);
    AppMethodBeat.o(32973);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    AppMethodBeat.i(32974);
    paramContextMenu.add(((az)paramView.getTag()).position, 100, 0, this.zzP.zJz.getMMResources().getString(2131298232));
    AppMethodBeat.o(32974);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 704643121);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  final boolean dLp()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.m.c
 * JD-Core Version:    0.7.0.1
 */