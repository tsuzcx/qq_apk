package com.tencent.xweb.x5;

import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends android.webkit.WebBackForwardList
{
  private com.tencent.smtt.sdk.WebBackForwardList ainh;
  
  public e(com.tencent.smtt.sdk.WebBackForwardList paramWebBackForwardList)
  {
    this.ainh = paramWebBackForwardList;
  }
  
  protected final android.webkit.WebBackForwardList clone()
  {
    AppMethodBeat.i(213195);
    e locale = new e(this.ainh);
    AppMethodBeat.o(213195);
    return locale;
  }
  
  public final int getCurrentIndex()
  {
    AppMethodBeat.i(213182);
    if (this.ainh == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.ainh.getCurrentIndex()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(213182);
      return i;
    }
  }
  
  public final WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(213177);
    if (this.ainh == null)
    {
      AppMethodBeat.o(213177);
      return null;
    }
    h localh = new h(this.ainh.getCurrentItem());
    AppMethodBeat.o(213177);
    return localh;
  }
  
  public final WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(213186);
    if (this.ainh == null)
    {
      AppMethodBeat.o(213186);
      return null;
    }
    h localh = new h(this.ainh.getItemAtIndex(paramInt));
    AppMethodBeat.o(213186);
    return localh;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(213191);
    if (this.ainh == null) {}
    for (Integer localInteger = null;; localInteger = Integer.valueOf(this.ainh.getSize()))
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(213191);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.e
 * JD-Core Version:    0.7.0.1
 */