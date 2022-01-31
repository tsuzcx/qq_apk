package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class i$1$1
  implements Runnable
{
  int count = 20;
  
  i$1$1(i.1 param1, int paramInt1, int paramInt2, int paramInt3, View paramView) {}
  
  public final void run()
  {
    this.oNW.oNT.lwE.setSelectionFromTop(this.kX + this.oNW.oNT.lwE.getHeaderViewsCount(), this.oNU + this.oNV);
    this.count -= 1;
    y.d("MicroMsg.TimelineClickListener", "count: %s, delt: %s", new Object[] { Integer.valueOf(this.count), Integer.valueOf(Math.abs(this.val$view.getTop() - (this.oNU + this.oNV))) });
    if ((this.count <= 0) || (Math.abs(this.val$view.getTop() - (this.oNU + this.oNV)) < 5))
    {
      y.d("MicroMsg.TimelineClickListener", "count: %s", new Object[] { Integer.valueOf(this.count) });
      this.oNW.oNT.owd.notifyDataSetChanged();
      return;
    }
    new ah().postDelayed(this, 5L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.i.1.1
 * JD-Core Version:    0.7.0.1
 */