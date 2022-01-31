package com.tencent.xweb.xwalk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;
import org.xwalk.core.XWalkView;

final class j$a
  extends XWalkView
{
  public j$a(j paramj, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void onScrollChangedDelegate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(85294);
    super.onScrollChangedDelegate(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.BJX.BHt != null) {
      this.BJX.BHt.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(85294);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.a
 * JD-Core Version:    0.7.0.1
 */