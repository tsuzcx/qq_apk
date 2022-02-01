package com.tencent.xweb.x5;

import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends android.webkit.WebBackForwardList
{
  private com.tencent.smtt.sdk.WebBackForwardList MSi;
  
  public i(com.tencent.smtt.sdk.WebBackForwardList paramWebBackForwardList)
  {
    this.MSi = paramWebBackForwardList;
  }
  
  protected final android.webkit.WebBackForwardList clone()
  {
    AppMethodBeat.i(207536);
    i locali = new i(this.MSi);
    AppMethodBeat.o(207536);
    return locali;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(207533);
    if (this.MSi == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.MSi.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(207533);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(207532);
    if (this.MSi == null)
    {
      AppMethodBeat.o(207532);
      return null;
    }
    k localk = new k(this.MSi.getCurrentItem());
    AppMethodBeat.o(207532);
    return localk;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(207534);
    if (this.MSi == null)
    {
      AppMethodBeat.o(207534);
      return null;
    }
    k localk = new k(this.MSi.getItemAtIndex(paramInt));
    AppMethodBeat.o(207534);
    return localk;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(207535);
    if (this.MSi == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.MSi.getSize()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(207535);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */