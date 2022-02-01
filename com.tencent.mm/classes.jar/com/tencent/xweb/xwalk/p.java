package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationHistory;

public final class p
  extends WebBackForwardList
{
  private XWalkNavigationHistory aipy;
  
  public p(XWalkNavigationHistory paramXWalkNavigationHistory)
  {
    this.aipy = paramXWalkNavigationHistory;
  }
  
  protected final WebBackForwardList clone()
  {
    AppMethodBeat.i(212853);
    p localp = new p(this.aipy);
    AppMethodBeat.o(212853);
    return localp;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(212837);
    if (this.aipy == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.aipy.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(212837);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(212833);
    if (this.aipy == null)
    {
      AppMethodBeat.o(212833);
      return null;
    }
    q localq = new q(this.aipy.getCurrentItem());
    AppMethodBeat.o(212833);
    return localq;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(212844);
    if (this.aipy == null)
    {
      AppMethodBeat.o(212844);
      return null;
    }
    q localq = new q(this.aipy.getItemAt(paramInt));
    AppMethodBeat.o(212844);
    return localq;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(212849);
    if (this.aipy == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.aipy.size()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(212849);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.p
 * JD-Core Version:    0.7.0.1
 */