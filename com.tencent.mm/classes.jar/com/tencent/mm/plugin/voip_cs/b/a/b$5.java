package com.tencent.mm.plugin.voip_cs.b.a;

import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlView;

final class b$5
  implements View.OnClickListener
{
  b$5(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(135322);
    paramView = this.tLv;
    if (!b.h(this.tLv)) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(paramView, bool);
      paramView = b.b(this.tLv, b.h(this.tLv));
      b.i(this.tLv).gp(paramView.x, paramView.y);
      AppMethodBeat.o(135322);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.a.b.5
 * JD-Core Version:    0.7.0.1
 */