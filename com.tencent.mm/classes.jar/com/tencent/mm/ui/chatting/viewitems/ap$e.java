package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R.i;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;

public final class ap$e
  extends ap.b
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if (paramView != null)
    {
      localObject = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localObject = new t(paramLayoutInflater, R.i.chatting_item_to_voip_invite);
      ((View)localObject).setTag(new ap.i().dX((View)localObject));
    }
    return localObject;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    ap.i.a((ap.i)parama, parambi, false, paramInt, parama1, k(parama1), c(parama1));
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
  {
    return false;
  }
  
  public final boolean a(MenuItem paramMenuItem, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean au(int paramInt, boolean paramBoolean)
  {
    return (paramBoolean) && (paramInt == 53);
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.e
 * JD-Core Version:    0.7.0.1
 */