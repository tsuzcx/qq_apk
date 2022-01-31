package com.tencent.mm.ui.chatting.viewitems;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.a;

public final class ag
  extends c
{
  private ah vFB = new ah();
  private ae vFC = new ae();
  private ai vFD = new ai();
  private ar vFE = new ar();
  
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
      localView = paramLayoutInflater.inflate(R.i.chatting_item_system, null);
      paramLayoutInflater = new ag.b(this);
      paramLayoutInflater.kKz = localView;
      paramLayoutInflater.dsz = ((TextView)localView.findViewById(R.h.chatting_time_tv));
      paramLayoutInflater.vEC = ((TextView)localView.findViewById(R.h.chatting_content_itv));
      localView.setTag(paramLayoutInflater);
    }
    return localView;
  }
  
  public final void a(c.a parama, int paramInt, a parama1, bi parambi, String paramString)
  {
    if (parambi.getType() == 10002) {
      paramString = this.vFC;
    }
    for (;;)
    {
      paramString.b(parama, paramInt, parama1, parambi);
      return;
      if (parambi.getType() == 570425393) {
        paramString = this.vFD;
      } else if (parambi.getType() == 603979825) {
        paramString = this.vFE;
      } else {
        paramString = this.vFB;
      }
    }
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
    return (paramInt == 10000) || (paramInt == 10002) || (paramInt == 570425393) || (paramInt == 64) || (paramInt == 603979825);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ag
 * JD-Core Version:    0.7.0.1
 */