package com.tencent.xweb.x5;

import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends android.webkit.WebBackForwardList
{
  private com.tencent.smtt.sdk.WebBackForwardList aagz;
  
  public i(com.tencent.smtt.sdk.WebBackForwardList paramWebBackForwardList)
  {
    this.aagz = paramWebBackForwardList;
  }
  
  protected final android.webkit.WebBackForwardList clone()
  {
    AppMethodBeat.i(206558);
    i locali = new i(this.aagz);
    AppMethodBeat.o(206558);
    return locali;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(206555);
    if (this.aagz == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.aagz.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(206555);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(206552);
    if (this.aagz == null)
    {
      AppMethodBeat.o(206552);
      return null;
    }
    k localk = new k(this.aagz.getCurrentItem());
    AppMethodBeat.o(206552);
    return localk;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(206556);
    if (this.aagz == null)
    {
      AppMethodBeat.o(206556);
      return null;
    }
    k localk = new k(this.aagz.getItemAtIndex(paramInt));
    AppMethodBeat.o(206556);
    return localk;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(206557);
    if (this.aagz == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.aagz.getSize()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(206557);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */