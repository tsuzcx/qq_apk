package com.tencent.xweb.xwalk;

import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationHistory;

public final class q
  extends WebBackForwardList
{
  XWalkNavigationHistory KGZ;
  
  public q(XWalkNavigationHistory paramXWalkNavigationHistory)
  {
    this.KGZ = paramXWalkNavigationHistory;
  }
  
  protected final WebBackForwardList clone()
  {
    AppMethodBeat.i(208929);
    q localq = new q(this.KGZ);
    AppMethodBeat.o(208929);
    return localq;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(208926);
    if (this.KGZ == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.KGZ.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(208926);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(208925);
    if (this.KGZ == null)
    {
      AppMethodBeat.o(208925);
      return null;
    }
    r localr = new r(this.KGZ.getCurrentItem());
    AppMethodBeat.o(208925);
    return localr;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(208927);
    if (this.KGZ == null)
    {
      AppMethodBeat.o(208927);
      return null;
    }
    r localr = new r(this.KGZ.getItemAt(paramInt));
    AppMethodBeat.o(208927);
    return localr;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(208928);
    if (this.KGZ == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.KGZ.size()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(208928);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.q
 * JD-Core Version:    0.7.0.1
 */