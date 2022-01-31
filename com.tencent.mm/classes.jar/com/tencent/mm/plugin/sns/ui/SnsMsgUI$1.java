package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.sdk.platformtools.y;

final class SnsMsgUI$1
  implements View.OnClickListener
{
  SnsMsgUI$1(SnsMsgUI paramSnsMsgUI) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof ao))
    {
      SnsMsgUI.a(this.paq).l(paramView, -1, 1);
      return;
    }
    if ((paramView.getTag() instanceof j))
    {
      SnsMsgUI.a(this.paq, (j)paramView.getTag());
      return;
    }
    y.w("MicroMsg.SnsMsgUI", "v.getTag():" + paramView.getTag());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsMsgUI.1
 * JD-Core Version:    0.7.0.1
 */