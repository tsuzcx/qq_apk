package com.tencent.mm.plugin.voip_cs.b.a;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.voip.video.OpenGlView;

final class b$5
  implements View.OnClickListener
{
  b$5(b paramb) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.qeI;
    if (!b.h(this.qeI)) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(paramView, bool);
      paramView = b.b(this.qeI, b.h(this.qeI));
      b.i(this.qeI).eq(paramView.x, paramView.y);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.5
 * JD-Core Version:    0.7.0.1
 */