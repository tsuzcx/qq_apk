package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.a.a;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMNeatTextView;

public final class af$b
  extends aj.b
{
  private com.tencent.mm.ui.chatting.c.a vko;
  
  public final void a(c.a parama, int paramInt, com.tencent.mm.ui.chatting.c.a parama1, bi parambi, String paramString)
  {
    this.vko = parama1;
    parama = (aj.e)parama;
    paramString = a.a.lC(parambi.field_content);
    if (parambi.field_status >= 2) {
      parama.nhQ.setVisibility(8);
    }
    for (;;)
    {
      j.a(parama.vFN.getContext(), com.tencent.mm.aj.a.a(paramString), (int)parama.vFN.getTextSize(), null, "");
      parama.vFN.setTag(new aw(parambi, parama1.cFE(), paramInt, null, '\000'));
      parama.vFN.setOnLongClickListener(c(parama1));
      a(paramInt, parama, parambi, parama1.cFB(), parama1.cFE(), parama1, this);
      return;
      parama.nhQ.setVisibility(0);
    }
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
    return (paramBoolean) && ((paramInt == 55) || (paramInt == 57));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.af.b
 * JD-Core Version:    0.7.0.1
 */