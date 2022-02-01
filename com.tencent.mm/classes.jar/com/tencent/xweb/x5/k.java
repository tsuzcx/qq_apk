package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends android.webkit.WebHistoryItem
{
  private com.tencent.smtt.sdk.WebHistoryItem ISq;
  
  public k(com.tencent.smtt.sdk.WebHistoryItem paramWebHistoryItem)
  {
    this.ISq = paramWebHistoryItem;
  }
  
  protected final android.webkit.WebHistoryItem clone()
  {
    AppMethodBeat.i(194684);
    k localk = new k(this.ISq);
    AppMethodBeat.o(194684);
    return localk;
  }
  
  public final Bitmap getFavicon()
  {
    AppMethodBeat.i(194683);
    if (this.ISq == null)
    {
      AppMethodBeat.o(194683);
      return null;
    }
    Bitmap localBitmap = this.ISq.getFavicon();
    AppMethodBeat.o(194683);
    return localBitmap;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(194681);
    if (this.ISq == null)
    {
      AppMethodBeat.o(194681);
      return null;
    }
    String str = this.ISq.getOriginalUrl();
    AppMethodBeat.o(194681);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(194682);
    if (this.ISq == null)
    {
      AppMethodBeat.o(194682);
      return null;
    }
    String str = this.ISq.getTitle();
    AppMethodBeat.o(194682);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(194680);
    if (this.ISq == null)
    {
      AppMethodBeat.o(194680);
      return null;
    }
    String str = this.ISq.getUrl();
    AppMethodBeat.o(194680);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.k
 * JD-Core Version:    0.7.0.1
 */