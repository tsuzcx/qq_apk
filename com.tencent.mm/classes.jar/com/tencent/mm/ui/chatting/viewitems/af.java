package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi;

public final class af
{
  public static final class a
    extends aj.a
  {
    private com.tencent.mm.ui.chatting.c.a vko;
    
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
        localObject = new t(paramLayoutInflater, R.i.chatting_item_qamsg_from);
        ((View)localObject).setTag(new af.c().dX((View)localObject));
      }
      return localObject;
    }
    
    public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
    {
      this.vko = parama1;
      parama = (af.c)parama;
      paramString = a.a.lC(parambi.field_content);
      if (paramString == null) {
        return;
      }
      String str = paramString.bRO;
      a(parama, parama1, parambi, str);
      a(parama, parama1, str, parambi);
      j.a(parama.vEC.getContext(), com.tencent.mm.aj.a.a(paramString), (int)parama.vEC.getTextSize(), null, "");
      parama.vEC.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
      parama.vEC.setOnLongClickListener(c(parama1));
    }
    
    public final boolean a(ContextMenu paramContextMenu, View paramView, bi parambi)
    {
      if (parambi.cvv())
      {
        int i = ((aw)paramView.getTag()).position;
        if (parambi.field_status == 5) {
          paramContextMenu.add(i, 103, 0, paramView.getContext().getString(R.l.chatting_resend_title));
        }
        if (!this.vko.cFF()) {
          paramContextMenu.add(i, 100, 0, paramView.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
        }
      }
      return true;
    }
    
    public final boolean au(int paramInt, boolean paramBoolean)
    {
      return (!paramBoolean) && ((paramInt == 55) || (paramInt == 57));
    }
    
    protected final boolean cHb()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af
 * JD-Core Version:    0.7.0.1
 */