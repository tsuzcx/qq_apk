package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;

public final class ap$f
  extends c
{
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    View localView;
    if (paramView != null)
    {
      localView = paramView;
      if (paramView.getTag() != null) {}
    }
    else
    {
      localView = paramLayoutInflater.inflate(R.i.chatting_item_voip_notify, null);
      localView.setTag(new ap.i().dX(localView));
    }
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    parama.dsz.setVisibility(0);
    parama.dsz.setText(h.n(parama1.vtz.getContext(), parambi.field_createTime));
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
    return paramInt == 52;
  }
  
  public final boolean b(View paramView, a parama, bi parambi)
  {
    return false;
  }
  
  public final boolean bfO()
  {
    return false;
  }
  
  protected final boolean cHb()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.f
 * JD-Core Version:    0.7.0.1
 */