package com.tencent.xweb.x5;

import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  extends android.webkit.WebBackForwardList
{
  private com.tencent.smtt.sdk.WebBackForwardList SFo;
  
  public i(com.tencent.smtt.sdk.WebBackForwardList paramWebBackForwardList)
  {
    this.SFo = paramWebBackForwardList;
  }
  
  protected final android.webkit.WebBackForwardList clone()
  {
    AppMethodBeat.i(207194);
    i locali = new i(this.SFo);
    AppMethodBeat.o(207194);
    return locali;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(207191);
    if (this.SFo == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.SFo.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(207191);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(207190);
    if (this.SFo == null)
    {
      AppMethodBeat.o(207190);
      return null;
    }
    k localk = new k(this.SFo.getCurrentItem());
    AppMethodBeat.o(207190);
    return localk;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(207192);
    if (this.SFo == null)
    {
      AppMethodBeat.o(207192);
      return null;
    }
    k localk = new k(this.SFo.getItemAtIndex(paramInt));
    AppMethodBeat.o(207192);
    return localk;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(207193);
    if (this.SFo == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.SFo.getSize()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(207193);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.i
 * JD-Core Version:    0.7.0.1
 */