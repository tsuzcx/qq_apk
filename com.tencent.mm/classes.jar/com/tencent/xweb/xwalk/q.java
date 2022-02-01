package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationHistory;

public final class q
  extends WebBackForwardList
{
  XWalkNavigationHistory SHK;
  
  public q(XWalkNavigationHistory paramXWalkNavigationHistory)
  {
    this.SHK = paramXWalkNavigationHistory;
  }
  
  protected final WebBackForwardList clone()
  {
    AppMethodBeat.i(207319);
    q localq = new q(this.SHK);
    AppMethodBeat.o(207319);
    return localq;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(207316);
    if (this.SHK == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.SHK.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(207316);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(207315);
    if (this.SHK == null)
    {
      AppMethodBeat.o(207315);
      return null;
    }
    r localr = new r(this.SHK.getCurrentItem());
    AppMethodBeat.o(207315);
    return localr;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(207317);
    if (this.SHK == null)
    {
      AppMethodBeat.o(207317);
      return null;
    }
    r localr = new r(this.SHK.getItemAt(paramInt));
    AppMethodBeat.o(207317);
    return localr;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(207318);
    if (this.SHK == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.SHK.size()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(207318);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.q
 * JD-Core Version:    0.7.0.1
 */