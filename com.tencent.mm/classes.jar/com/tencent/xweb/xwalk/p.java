package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationHistory;

public final class p
  extends WebBackForwardList
{
  XWalkNavigationHistory IUx;
  
  public p(XWalkNavigationHistory paramXWalkNavigationHistory)
  {
    this.IUx = paramXWalkNavigationHistory;
  }
  
  protected final WebBackForwardList clone()
  {
    AppMethodBeat.i(194699);
    p localp = new p(this.IUx);
    AppMethodBeat.o(194699);
    return localp;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(194696);
    if (this.IUx == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.IUx.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(194696);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(194695);
    if (this.IUx == null)
    {
      AppMethodBeat.o(194695);
      return null;
    }
    q localq = new q(this.IUx.getCurrentItem());
    AppMethodBeat.o(194695);
    return localq;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(194697);
    if (this.IUx == null)
    {
      AppMethodBeat.o(194697);
      return null;
    }
    q localq = new q(this.IUx.getItemAt(paramInt));
    AppMethodBeat.o(194697);
    return localq;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(194698);
    if (this.IUx == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.IUx.size()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(194698);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.p
 * JD-Core Version:    0.7.0.1
 */