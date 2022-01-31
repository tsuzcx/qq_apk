package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class ap$1
  implements View.OnClickListener
{
  ap$1(ap paramap) {}
  
  public final void onClick(View paramView)
  {
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof ap.c)))
    {
      paramView = null;
      if (paramView != null) {
        break label42;
      }
      y.w("MicroMsg.Sns.AnimatedExpandableListAdapter", "dividerIv tag is null.");
    }
    label42:
    while (ap.a(this.paa) == null)
    {
      return;
      paramView = (ap.c)paramView.getTag();
      break;
    }
    ap.a(this.paa).a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap.1
 * JD-Core Version:    0.7.0.1
 */