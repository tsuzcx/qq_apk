package com.tencent.smtt.sdk;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebHistoryItem;

public class WebHistoryItem
{
  private IX5WebHistoryItem a = null;
  private android.webkit.WebHistoryItem b = null;
  
  static WebHistoryItem a(android.webkit.WebHistoryItem paramWebHistoryItem)
  {
    AppMethodBeat.i(64694);
    if (paramWebHistoryItem == null)
    {
      AppMethodBeat.o(64694);
      return null;
    }
    WebHistoryItem localWebHistoryItem = new WebHistoryItem();
    localWebHistoryItem.b = paramWebHistoryItem;
    AppMethodBeat.o(64694);
    return localWebHistoryItem;
  }
  
  static WebHistoryItem a(IX5WebHistoryItem paramIX5WebHistoryItem)
  {
    AppMethodBeat.i(64693);
    if (paramIX5WebHistoryItem == null)
    {
      AppMethodBeat.o(64693);
      return null;
    }
    WebHistoryItem localWebHistoryItem = new WebHistoryItem();
    localWebHistoryItem.a = paramIX5WebHistoryItem;
    AppMethodBeat.o(64693);
    return localWebHistoryItem;
  }
  
  public Bitmap getFavicon()
  {
    AppMethodBeat.i(64698);
    if (this.a != null)
    {
      localBitmap = this.a.getFavicon();
      AppMethodBeat.o(64698);
      return localBitmap;
    }
    Bitmap localBitmap = this.b.getFavicon();
    AppMethodBeat.o(64698);
    return localBitmap;
  }
  
  public String getOriginalUrl()
  {
    AppMethodBeat.i(64696);
    if (this.a != null)
    {
      str = this.a.getOriginalUrl();
      AppMethodBeat.o(64696);
      return str;
    }
    String str = this.b.getOriginalUrl();
    AppMethodBeat.o(64696);
    return str;
  }
  
  public String getTitle()
  {
    AppMethodBeat.i(64697);
    if (this.a != null)
    {
      str = this.a.getTitle();
      AppMethodBeat.o(64697);
      return str;
    }
    String str = this.b.getTitle();
    AppMethodBeat.o(64697);
    return str;
  }
  
  public String getUrl()
  {
    AppMethodBeat.i(64695);
    if (this.a != null)
    {
      str = this.a.getUrl();
      AppMethodBeat.o(64695);
      return str;
    }
    String str = this.b.getUrl();
    AppMethodBeat.o(64695);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebHistoryItem
 * JD-Core Version:    0.7.0.1
 */