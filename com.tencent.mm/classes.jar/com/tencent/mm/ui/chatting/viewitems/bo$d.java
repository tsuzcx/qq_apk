package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.e.a;

public final class bo$d
  extends bo.a
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    AppMethodBeat.i(37521);
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new aq(paramLayoutInflater, R.i.edu);
      ((View)localObject).setTag(new bo.i().ip((View)localObject));
    }
    AppMethodBeat.o(37521);
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, ca paramca, String paramString)
  {
    AppMethodBeat.i(37522);
    bo.i.a((bo.i)parama, paramca, true, paramInt, parama1, o(parama1), c(parama1));
    AppMethodBeat.o(37522);
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, ca paramca)
  {
    return false;
  }
  
  public final boolean a(o paramo, View paramView, ca paramca)
  {
    return false;
  }
  
  public final boolean bZ(int paramInt, boolean paramBoolean)
  {
    return (!paramBoolean) && (paramInt == 53);
  }
  
  public final boolean c(View paramView, a parama, ca paramca)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bo.d
 * JD-Core Version:    0.7.0.1
 */