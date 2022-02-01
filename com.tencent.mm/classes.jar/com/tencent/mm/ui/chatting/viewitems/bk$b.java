package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.e.a;

public final class bk$b
  extends bk.a
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
      localObject = new an(paramLayoutInflater, 2131493564);
      ((View)localObject).setTag(new bk.d().hd((View)localObject));
    }
    AppMethodBeat.o(37542);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37543);
    parama = (bk.d)parama;
    paramString = c(parama1);
    if (parama != null)
    {
      parama.clickArea.setTag(new bq(paramca, parama1.gRM(), paramInt, null, '\000'));
      parama.clickArea.setOnLongClickListener(paramString);
      parama.clickArea.setOnTouchListener(((k)parama1.bh(k.class)).gOC());
    }
    AppMethodBeat.o(37543);
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
    return paramInt == -1879048187;
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bk.b
 * JD-Core Version:    0.7.0.1
 */