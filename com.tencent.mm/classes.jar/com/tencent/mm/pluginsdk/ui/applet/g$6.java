package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.o;

final class g$6
  implements View.OnClickListener
{
  g$6(q.a parama, o paramo) {}
  
  public final void onClick(View paramView)
  {
    if (this.sch != null) {
      this.sch.a(false, null, 0);
    }
    this.scj.dismiss();
    this.scj.setFocusable(false);
    this.scj.setTouchable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.6
 * JD-Core Version:    0.7.0.1
 */