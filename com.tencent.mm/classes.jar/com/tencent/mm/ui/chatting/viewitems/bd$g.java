package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.e.a;

public final class bd$g
  extends bd.b
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37530);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new ah(paramLayoutInflater, 2131493505);
      ((View)localObject).setTag(new bd.i().gN((View)localObject));
    }
    AppMethodBeat.o(37530);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bv parambv, String paramString)
  {
    AppMethodBeat.i(37531);
    bd.i.a((bd.i)parama, parambv, false, paramInt, parama1, o(parama1), c(parama1));
    AppMethodBeat.o(37531);
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
    return (paramBoolean) && (paramInt == 50);
  }
  
  final boolean fLA()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.g
 * JD-Core Version:    0.7.0.1
 */