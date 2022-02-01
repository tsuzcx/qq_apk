package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationHistory;

public final class q
  extends WebBackForwardList
{
  XWalkNavigationHistory MUD;
  
  public q(XWalkNavigationHistory paramXWalkNavigationHistory)
  {
    this.MUD = paramXWalkNavigationHistory;
  }
  
  protected final WebBackForwardList clone()
  {
    AppMethodBeat.i(207589);
    q localq = new q(this.MUD);
    AppMethodBeat.o(207589);
    return localq;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(207586);
    if (this.MUD == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.MUD.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(207586);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(207585);
    if (this.MUD == null)
    {
      AppMethodBeat.o(207585);
      return null;
    }
    r localr = new r(this.MUD.getCurrentItem());
    AppMethodBeat.o(207585);
    return localr;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(207587);
    if (this.MUD == null)
    {
      AppMethodBeat.o(207587);
      return null;
    }
    r localr = new r(this.MUD.getItemAt(paramInt));
    AppMethodBeat.o(207587);
    return localr;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(207588);
    if (this.MUD == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.MUD.size()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(207588);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.q
 * JD-Core Version:    0.7.0.1
 */