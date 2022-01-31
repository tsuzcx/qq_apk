package com.tencent.xweb.xwalk;

import android.webkit.WebView.FindListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkFindListener;

public final class f$g
  extends XWalkFindListener
{
  WebView.FindListener BHO;
  
  public f$g(WebView.FindListener paramFindListener)
  {
    this.BHO = paramFindListener;
  }
  
  public final void onFindResultReceived(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(85226);
    if (this.BHO != null) {
      this.BHO.onFindResultReceived(paramInt1, paramInt2, paramBoolean);
    }
    AppMethodBeat.o(85226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f.g
 * JD-Core Version:    0.7.0.1
 */