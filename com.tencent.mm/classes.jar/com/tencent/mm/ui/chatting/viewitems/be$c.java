package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.e.a;

public final class be$c
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
      localView.setTag(new be.d().gN(localView));
    }
    AppMethodBeat.o(37546);
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37547);
    parama.fVV.setVisibility(0);
    parama.fVV.setText(i.u(parama1.Kkd.getContext(), parambv.field_createTime));
    AppMethodBeat.o(37547);
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
    return paramInt == -1879048188;
  }
  
  protected final boolean fLy()
  {
    return false;
  }
  
  public final boolean fLz()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.c
 * JD-Core Version:    0.7.0.1
 */