package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class be$b
  extends be.a
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
      localObject = new ah(paramLayoutInflater, 2131493462);
      ((View)localObject).setTag(new be.d().gN((View)localObject));
    }
    AppMethodBeat.o(37542);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37543);
    parama = (be.d)parama;
    paramString = c(parama1);
    if (parama != null)
    {
      parama.olI.setTag(new bk(parambv, parama1.fJC(), paramInt, null, '\000'));
      parama.olI.setOnLongClickListener(paramString);
      parama.olI.setOnTouchListener(((k)parama1.bh(k.class)).fGw());
    }
    AppMethodBeat.o(37543);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bv parambv)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bv parambv)
  {
    return false;
  }
  
  public final boolean br(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048187;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.b
 * JD-Core Version:    0.7.0.1
 */