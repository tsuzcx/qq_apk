package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationHistory;

public final class q
  extends WebBackForwardList
{
  XWalkNavigationHistory aajC;
  
  public q(XWalkNavigationHistory paramXWalkNavigationHistory)
  {
    this.aajC = paramXWalkNavigationHistory;
  }
  
  protected final WebBackForwardList clone()
  {
    AppMethodBeat.i(204479);
    q localq = new q(this.aajC);
    AppMethodBeat.o(204479);
    return localq;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(204475);
    if (this.aajC == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.aajC.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(204475);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(204473);
    if (this.aajC == null)
    {
      AppMethodBeat.o(204473);
      return null;
    }
    r localr = new r(this.aajC.getCurrentItem());
    AppMethodBeat.o(204473);
    return localr;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(204476);
    if (this.aajC == null)
    {
      AppMethodBeat.o(204476);
      return null;
    }
    r localr = new r(this.aajC.getItemAt(paramInt));
    AppMethodBeat.o(204476);
    return localr;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(204477);
    if (this.aajC == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.aajC.size()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(204477);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.q
 * JD-Core Version:    0.7.0.1
 */