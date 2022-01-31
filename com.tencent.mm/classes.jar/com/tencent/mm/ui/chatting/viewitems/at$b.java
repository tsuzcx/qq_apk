package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.h;
import com.tencent.mm.ui.chatting.d.a;

public final class at$b
  extends at.a
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(33432);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new w(paramLayoutInflater, 2130969089);
      ((View)localObject).setTag(new at.d().fl((View)localObject));
    }
    AppMethodBeat.o(33432);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    AppMethodBeat.i(33433);
    parama = (at.d)parama;
    paramString = c(parama1);
    if (parama != null)
    {
      parama.jYu.setTag(new az(parambi, parama1.dJG(), paramInt, null, '\000'));
      parama.jYu.setOnLongClickListener(paramString);
      parama.jYu.setOnTouchListener(((h)parama1.ay(h.class)).dHi());
    }
    AppMethodBeat.o(33433);
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
    return paramInt == -1879048187;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.at.b
 * JD-Core Version:    0.7.0.1
 */