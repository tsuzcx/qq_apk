package com.tencent.xweb.xwalk;

import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.v;
import org.xwalk.core.XWalkView.ScrollChangedListener;

final class j$4
  implements XWalkView.ScrollChangedListener
{
  j$4(j paramj) {}
  
  public final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(85291);
    this.BJX.BJM.scrollTo(paramInt1, paramInt2);
    if (this.BJX.igO != null) {
      this.BJX.igO.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this.BJX.BJF);
    }
    AppMethodBeat.o(85291);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.4
 * JD-Core Version:    0.7.0.1
 */