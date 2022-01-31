package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList
{
  private IX5WebBackForwardList a = null;
  private android.webkit.WebBackForwardList b = null;
  
  static WebBackForwardList a(android.webkit.WebBackForwardList paramWebBackForwardList)
  {
    AppMethodBeat.i(64684);
    if (paramWebBackForwardList == null)
    {
      AppMethodBeat.o(64684);
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.b = paramWebBackForwardList;
    AppMethodBeat.o(64684);
    return localWebBackForwardList;
  }
  
  static WebBackForwardList a(IX5WebBackForwardList paramIX5WebBackForwardList)
  {
    AppMethodBeat.i(64683);
    if (paramIX5WebBackForwardList == null)
    {
      AppMethodBeat.o(64683);
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.a = paramIX5WebBackForwardList;
    AppMethodBeat.o(64683);
    return localWebBackForwardList;
  }
  
  public int getCurrentIndex()
  {
    AppMethodBeat.i(64686);
    if (this.a != null)
    {
      i = this.a.getCurrentIndex();
      AppMethodBeat.o(64686);
      return i;
    }
    int i = this.b.getCurrentIndex();
    AppMethodBeat.o(64686);
    return i;
  }
  
  public WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(64685);
    if (this.a != null)
    {
      localWebHistoryItem = WebHistoryItem.a(this.a.getCurrentItem());
      AppMethodBeat.o(64685);
      return localWebHistoryItem;
    }
    WebHistoryItem localWebHistoryItem = WebHistoryItem.a(this.b.getCurrentItem());
    AppMethodBeat.o(64685);
    return localWebHistoryItem;
  }
  
  public WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(64687);
    if (this.a != null)
    {
      localWebHistoryItem = WebHistoryItem.a(this.a.getItemAtIndex(paramInt));
      AppMethodBeat.o(64687);
      return localWebHistoryItem;
    }
    WebHistoryItem localWebHistoryItem = WebHistoryItem.a(this.b.getItemAtIndex(paramInt));
    AppMethodBeat.o(64687);
    return localWebHistoryItem;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(64688);
    if (this.a != null)
    {
      i = this.a.getSize();
      AppMethodBeat.o(64688);
      return i;
    }
    int i = this.b.getSize();
    AppMethodBeat.o(64688);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebBackForwardList
 * JD-Core Version:    0.7.0.1
 */