package com.tencent.xweb.x5;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class k$a
  extends com.tencent.smtt.sdk.WebView
{
  public k$a(k paramk, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(84908);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.BIu.BHt != null) {
      this.BIu.BHt.onWebViewScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(84908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.x5.k.a
 * JD-Core Version:    0.7.0.1
 */