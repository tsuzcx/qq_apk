package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationHistory;

public final class q
  extends WebBackForwardList
{
  XWalkNavigationHistory Mxz;
  
  public q(XWalkNavigationHistory paramXWalkNavigationHistory)
  {
    this.Mxz = paramXWalkNavigationHistory;
  }
  
  protected final WebBackForwardList clone()
  {
    AppMethodBeat.i(195570);
    q localq = new q(this.Mxz);
    AppMethodBeat.o(195570);
    return localq;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(195567);
    if (this.Mxz == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.Mxz.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(195567);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(195566);
    if (this.Mxz == null)
    {
      AppMethodBeat.o(195566);
      return null;
    }
    r localr = new r(this.Mxz.getCurrentItem());
    AppMethodBeat.o(195566);
    return localr;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(195568);
    if (this.Mxz == null)
    {
      AppMethodBeat.o(195568);
      return null;
    }
    r localr = new r(this.Mxz.getItemAt(paramInt));
    AppMethodBeat.o(195568);
    return localr;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(195569);
    if (this.Mxz == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.Mxz.size()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(195569);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.q
 * JD-Core Version:    0.7.0.1
 */