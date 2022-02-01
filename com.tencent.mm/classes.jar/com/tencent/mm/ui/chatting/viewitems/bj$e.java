package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.e.a;

public final class bj$e
  extends bj.b
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37525);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new an(paramLayoutInflater, 2131493615);
      ((View)localObject).setTag(new bj.i().hd((View)localObject));
    }
    AppMethodBeat.o(37525);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37526);
    bj.i.a((bj.i)parama, paramca, false, paramInt, parama1, o(parama1), c(parama1));
    AppMethodBeat.o(37526);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(m paramm, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bM(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 53);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.e
 * JD-Core Version:    0.7.0.1
 */