package com.tencent.xweb.x5;

import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends android.webkit.WebBackForwardList
{
  private com.tencent.smtt.sdk.WebBackForwardList ISh;
  
  public i(com.tencent.smtt.sdk.WebBackForwardList paramWebBackForwardList)
  {
    this.ISh = paramWebBackForwardList;
  }
  
  protected final android.webkit.WebBackForwardList clone()
  {
    AppMethodBeat.i(194678);
    i locali = new i(this.ISh);
    AppMethodBeat.o(194678);
    return locali;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(194675);
    if (this.ISh == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.ISh.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(194675);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(194674);
    if (this.ISh == null)
    {
      AppMethodBeat.o(194674);
      return null;
    }
    k localk = new k(this.ISh.getCurrentItem());
    AppMethodBeat.o(194674);
    return localk;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(194676);
    if (this.ISh == null)
    {
      AppMethodBeat.o(194676);
      return null;
    }
    k localk = new k(this.ISh.getItemAtIndex(paramInt));
    AppMethodBeat.o(194676);
    return localk;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(194677);
    if (this.ISh == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.ISh.getSize()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(194677);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */