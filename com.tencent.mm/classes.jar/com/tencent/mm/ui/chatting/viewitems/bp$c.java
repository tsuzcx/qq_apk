package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.d.a;

public final class bp$c
  extends bp.a
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37517);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ap(paramLayoutInflater, R.i.ggj);
      ((View)localObject).setTag(new bp.i().lM((View)localObject));
    }
    AppMethodBeat.o(37517);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, cc paramcc, String paramString)
  {
    AppMethodBeat.i(37518);
    bp.i.a((bp.i)parama, paramcc, true, paramInt, parama1, p(parama1), c(parama1));
    AppMethodBeat.o(37518);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean a(s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo, cc paramcc)
  {
    return false;
  }
  
  public final boolean c(View paramView, a parama, cc paramcc)
  {
    return false;
  }
  
  public final boolean cM(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 50);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bp.c
 * JD-Core Version:    0.7.0.1
 */