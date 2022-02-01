package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.chatting.c.b.i;
import com.tencent.mm.ui.chatting.d.a;

public final class bc$b
  extends bc.a
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37542);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new af(paramLayoutInflater, 2131493462);
      ((View)localObject).setTag(new bc.d().ge((View)localObject));
    }
    AppMethodBeat.o(37542);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bl parambl, String paramString)
  {
    AppMethodBeat.i(37543);
    parama = (bc.d)parama;
    paramString = c(parama1);
    if (parama != null)
    {
      parama.naN.setTag(new bi(parambl, parama1.eZb(), paramInt, null, '\000'));
      parama.naN.setOnLongClickListener(paramString);
      parama.naN.setOnTouchListener(((i)parama1.be(i.class)).eWp());
    }
    AppMethodBeat.o(37543);
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bl parambl)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bl parambl)
  {
    return false;
  }
  
  public final boolean aX(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048187;
  }
  
  public final boolean b(View paramView, a parama, bl parambl)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc.b
 * JD-Core Version:    0.7.0.1
 */