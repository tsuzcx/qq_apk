package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebBackForwardList;

public class WebBackForwardList
{
  private IX5WebBackForwardList a = null;
  private android.webkit.WebBackForwardList b = null;
  
  static WebBackForwardList a(android.webkit.WebBackForwardList paramWebBackForwardList)
  {
    AppMethodBeat.i(54642);
    if (paramWebBackForwardList == null)
    {
      AppMethodBeat.o(54642);
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.b = paramWebBackForwardList;
    AppMethodBeat.o(54642);
    return localWebBackForwardList;
  }
  
  static WebBackForwardList a(IX5WebBackForwardList paramIX5WebBackForwardList)
  {
    AppMethodBeat.i(54641);
    if (paramIX5WebBackForwardList == null)
    {
      AppMethodBeat.o(54641);
      return null;
    }
    WebBackForwardList localWebBackForwardList = new WebBackForwardList();
    localWebBackForwardList.a = paramIX5WebBackForwardList;
    AppMethodBeat.o(54641);
    return localWebBackForwardList;
  }
  
  public int getCurrentIndex()
  {
    AppMethodBeat.i(54644);
    if (this.a != null)
    {
      i = this.a.getCurrentIndex();
      AppMethodBeat.o(54644);
      return i;
    }
    int i = this.b.getCurrentIndex();
    AppMethodBeat.o(54644);
    return i;
  }
  
  public WebHistoryItem getCurrentItem()
  {
    AppMethodBeat.i(54643);
    if (this.a != null)
    {
      localWebHistoryItem = WebHistoryItem.a(this.a.getCurrentItem());
      AppMethodBeat.o(54643);
      return localWebHistoryItem;
    }
    WebHistoryItem localWebHistoryItem = WebHistoryItem.a(this.b.getCurrentItem());
    AppMethodBeat.o(54643);
    return localWebHistoryItem;
  }
  
  public WebHistoryItem getItemAtIndex(int paramInt)
  {
    AppMethodBeat.i(54645);
    if (this.a != null)
    {
      localWebHistoryItem = WebHistoryItem.a(this.a.getItemAtIndex(paramInt));
      AppMethodBeat.o(54645);
      return localWebHistoryItem;
    }
    WebHistoryItem localWebHistoryItem = WebHistoryItem.a(this.b.getItemAtIndex(paramInt));
    AppMethodBeat.o(54645);
    return localWebHistoryItem;
  }
  
  public int getSize()
  {
    AppMethodBeat.i(54646);
    if (this.a != null)
    {
      i = this.a.getSize();
      AppMethodBeat.o(54646);
      return i;
    }
    int i = this.b.getSize();
    AppMethodBeat.o(54646);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebBackForwardList
 * JD-Core Version:    0.7.0.1
 */