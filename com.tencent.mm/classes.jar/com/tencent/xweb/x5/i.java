package com.tencent.xweb.x5;

import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends android.webkit.WebBackForwardList
{
  private com.tencent.smtt.sdk.WebBackForwardList KEE;
  
  public i(com.tencent.smtt.sdk.WebBackForwardList paramWebBackForwardList)
  {
    this.KEE = paramWebBackForwardList;
  }
  
  protected final android.webkit.WebBackForwardList clone()
  {
    AppMethodBeat.i(208889);
    i locali = new i(this.KEE);
    AppMethodBeat.o(208889);
    return locali;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(208886);
    if (this.KEE == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.KEE.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(208886);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(208885);
    if (this.KEE == null)
    {
      AppMethodBeat.o(208885);
      return null;
    }
    k localk = new k(this.KEE.getCurrentItem());
    AppMethodBeat.o(208885);
    return localk;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(208887);
    if (this.KEE == null)
    {
      AppMethodBeat.o(208887);
      return null;
    }
    k localk = new k(this.KEE.getItemAtIndex(paramInt));
    AppMethodBeat.o(208887);
    return localk;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(208888);
    if (this.KEE == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.KEE.getSize()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(208888);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */