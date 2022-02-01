package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.chatting.e.a;

public final class bd$e
  extends bd.b
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
      localObject = new ah(paramLayoutInflater, 2131493506);
      ((View)localObject).setTag(new bd.i().gI((View)localObject));
    }
    AppMethodBeat.o(37525);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bu parambu, String paramString)
  {
    AppMethodBeat.i(37526);
    bd.i.a((bd.i)parama, parambu, false, paramInt, parama1, o(parama1), c(parama1));
    AppMethodBeat.o(37526);
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
    return (paramBoolean) && (paramInt == 53);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bd.e
 * JD-Core Version:    0.7.0.1
 */