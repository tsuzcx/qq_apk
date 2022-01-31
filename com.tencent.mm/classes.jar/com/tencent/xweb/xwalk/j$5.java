package com.tencent.xweb.xwalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkView.OverScrolledListener;

final class j$5
  implements XWalkView.OverScrolledListener
{
  j$5(j paramj) {}
  
  public final void onOverScrolled(boolean paramBoolean)
  {
    AppMethodBeat.i(85292);
    if (paramBoolean)
    {
      j.a(this.BJX, true);
      AppMethodBeat.o(85292);
      return;
    }
    j.a(this.BJX, false);
    AppMethodBeat.o(85292);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.5
 * JD-Core Version:    0.7.0.1
 */