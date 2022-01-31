package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.o;

final class g$5
  implements View.OnClickListener
{
  g$5(q.a parama, View paramView, o paramo) {}
  
  public final void onClick(View paramView)
  {
    if (this.sch != null) {
      this.sch.a(true, g.du(this.val$view), g.dv(this.val$view));
    }
    this.scj.dismiss();
    this.scj.setFocusable(false);
    this.scj.setTouchable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.g.5
 * JD-Core Version:    0.7.0.1
 */