package com.tencent.xweb.x5;

import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends android.webkit.WebBackForwardList
{
  private com.tencent.smtt.sdk.WebBackForwardList Mve;
  
  public i(com.tencent.smtt.sdk.WebBackForwardList paramWebBackForwardList)
  {
    this.Mve = paramWebBackForwardList;
  }
  
  protected final android.webkit.WebBackForwardList clone()
  {
    AppMethodBeat.i(195520);
    i locali = new i(this.Mve);
    AppMethodBeat.o(195520);
    return locali;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(195517);
    if (this.Mve == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.Mve.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(195517);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(195516);
    if (this.Mve == null)
    {
      AppMethodBeat.o(195516);
      return null;
    }
    k localk = new k(this.Mve.getCurrentItem());
    AppMethodBeat.o(195516);
    return localk;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(195518);
    if (this.Mve == null)
    {
      AppMethodBeat.o(195518);
      return null;
    }
    k localk = new k(this.Mve.getItemAtIndex(paramInt));
    AppMethodBeat.o(195518);
    return localk;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(195519);
    if (this.Mve == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.Mve.getSize()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(195519);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */