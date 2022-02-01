package com.tencent.mm.ui.chatting.viewitems;

import android.content.res.Resources;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

public final class s$b
  extends c
{
  private a HNS;
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(36985);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ag(paramLayoutInflater, 2131493442);
      ((View)localObject).setTag(new s.a().gi((View)localObject));
    }
    AppMethodBeat.o(36985);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(36986);
    this.HNS = parama1;
    s.a.a((s.a)parama, paramInt, parama1, parambo, this);
    AppMethodBeat.o(36986);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
    AppMethodBeat.i(36987);
    int i = ((bj)paramView.getTag()).position;
    if (parambo != null) {
      paramContextMenu.add(i, 100, 0, this.HNS.HZF.getMMResources().getString(2131757221));
    }
    AppMethodBeat.o(36987);
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bo parambo)
  {
    return false;
  }
  
  public final boolean bb(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 704643121);
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.s.b
 * JD-Core Version:    0.7.0.1
 */