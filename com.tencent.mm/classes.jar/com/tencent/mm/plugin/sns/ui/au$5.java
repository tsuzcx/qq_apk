package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.plugin.sns.ui.d.b;
import java.util.HashMap;

final class au$5
  implements View.OnClickListener
{
  au$5(au paramau) {}
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof a.c)) {}
    do
    {
      return;
      paramView = (a.c)paramView.getTag();
    } while (paramView == null);
    if ((this.pep.oOk.containsKey(paramView.bJQ)) && (((Integer)this.pep.oOk.get(paramView.bJQ)).equals(Integer.valueOf(1))))
    {
      this.pep.oOk.put(paramView.bJQ, Integer.valueOf(2));
      this.pep.peb.notifyDataSetChanged();
      return;
    }
    this.pep.oOk.put(paramView.bJQ, Integer.valueOf(1));
    if (paramView.kKz.getTop() < 0)
    {
      this.pep.ovx.b(paramView.kKz, paramView.position, paramView.kKz.getTop(), paramView.pmF.getSpreadHeight());
      return;
    }
    this.pep.peb.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au.5
 * JD-Core Version:    0.7.0.1
 */