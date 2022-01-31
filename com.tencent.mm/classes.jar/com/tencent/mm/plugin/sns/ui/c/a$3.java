package com.tencent.mm.plugin.sns.ui.c;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.d.b;

final class a$3
  implements View.OnLongClickListener
{
  a$3(a parama, View paramView) {}
  
  public final boolean onLongClick(View paramView)
  {
    int[] arrayOfInt = new int[2];
    if ((paramView.getTag(i.f.touch_loc) instanceof int[])) {}
    for (paramView = (int[])paramView.getTag(i.f.touch_loc);; paramView = arrayOfInt)
    {
      this.pmz.owd.iep.a(this.pkk, this.pmz.owd.ovx.poM, this.pmz.owd.ovx.poz, paramView[0], paramView[1]);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.3
 * JD-Core Version:    0.7.0.1
 */