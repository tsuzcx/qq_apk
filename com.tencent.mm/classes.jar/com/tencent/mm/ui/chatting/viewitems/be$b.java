package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bu;
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
      ((View)localObject).setTag(new be.d().gI((View)localObject));
    }
    AppMethodBeat.o(37542);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37543);
    parama = (be.d)parama;
    paramString = c(parama1);
    if (parama != null)
    {
      parama.ofK.setTag(new bk(parambu, parama1.fFv(), paramInt, null, '\000'));
      parama.ofK.setOnLongClickListener(paramString);
      parama.ofK.setOnTouchListener(((k)parama1.bh(k.class)).fCu());
    }
    AppMethodBeat.o(37543);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean a(l paraml, View paramView, bu parambu)
  {
    return false;
  }
  
  public final boolean b(View paramView, a parama, bu parambu)
  {
    return false;
  }
  
  public final boolean bi(int paramInt, boolean paramBoolean)
  {
    return paramInt == -1879048187;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.be.b
 * JD-Core Version:    0.7.0.1
 */