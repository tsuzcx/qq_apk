package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.pluginsdk.g.h;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

public final class bd$c
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37546);
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(2131493513, null);
      localView.setTag(new bd.d().gr(localView));
    }
    AppMethodBeat.o(37546);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bo parambo, String paramString)
  {
    AppMethodBeat.i(37547);
    parama.fAz.setVisibility(0);
    parama.fAz.setText(h.t(parama1.HZF.getContext(), parambo.field_createTime));
    AppMethodBeat.o(37547);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bo parambo)
  {
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
    return paramInt == -1879048188;
  }
  
  protected final boolean fqt()
  {
    return false;
  }
  
  public final boolean fqu()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.c
 * JD-Core Version:    0.7.0.1
 */