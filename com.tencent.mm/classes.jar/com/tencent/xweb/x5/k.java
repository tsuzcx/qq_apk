package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends android.webkit.WebHistoryItem
{
  private com.tencent.smtt.sdk.WebHistoryItem MSr;
  
  public k(com.tencent.smtt.sdk.WebHistoryItem paramWebHistoryItem)
  {
    this.MSr = paramWebHistoryItem;
  }
  
  protected final android.webkit.WebHistoryItem clone()
  {
    AppMethodBeat.i(207543);
    k localk = new k(this.MSr);
    AppMethodBeat.o(207543);
    return localk;
  }
  
  public final Bitmap getFavicon()
  {
    AppMethodBeat.i(207542);
    if (this.MSr == null)
    {
      AppMethodBeat.o(207542);
      return null;
    }
    Bitmap localBitmap = this.MSr.getFavicon();
    AppMethodBeat.o(207542);
    return localBitmap;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(207540);
    if (this.MSr == null)
    {
      AppMethodBeat.o(207540);
      return null;
    }
    String str = this.MSr.getOriginalUrl();
    AppMethodBeat.o(207540);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(207541);
    if (this.MSr == null)
    {
      AppMethodBeat.o(207541);
      return null;
    }
    String str = this.MSr.getTitle();
    AppMethodBeat.o(207541);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(207539);
    if (this.MSr == null)
    {
      AppMethodBeat.o(207539);
      return null;
    }
    String str = this.MSr.getUrl();
    AppMethodBeat.o(207539);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.k
 * JD-Core Version:    0.7.0.1
 */