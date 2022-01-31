package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$2
  implements a.b
{
  l$2(l paraml) {}
  
  public final void dfb()
  {
    AppMethodBeat.i(8210);
    l.a(this.viG, 17);
    Point localPoint = null;
    if (l.b(this.viG) != null) {
      localPoint = l.b(this.viG).getLastTouchDownViewPos();
    }
    this.viG.dfj();
    if (localPoint != null)
    {
      l.c(this.viG).viI = localPoint.x;
      l.c(this.viG).viH = localPoint.y;
      l.c(this.viG).save();
    }
    AppMethodBeat.o(8210);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.l.2
 * JD-Core Version:    0.7.0.1
 */