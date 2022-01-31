package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;

public final class as$d
  extends as.a
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33411);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969090);
      ((View)localObject).setTag(new as.i().fl((View)localObject));
    }
    AppMethodBeat.o(33411);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33412);
    as.i.a((as.i)parama, parambi, true, paramInt, parama1, o(parama1), c(parama1));
    AppMethodBeat.o(33412);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean aK(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 53);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.as.d
 * JD-Core Version:    0.7.0.1
 */