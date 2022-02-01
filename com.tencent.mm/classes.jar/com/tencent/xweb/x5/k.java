package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends android.webkit.WebHistoryItem
{
  private com.tencent.smtt.sdk.WebHistoryItem Mvn;
  
  public k(com.tencent.smtt.sdk.WebHistoryItem paramWebHistoryItem)
  {
    this.Mvn = paramWebHistoryItem;
  }
  
  protected final android.webkit.WebHistoryItem clone()
  {
    AppMethodBeat.i(195527);
    k localk = new k(this.Mvn);
    AppMethodBeat.o(195527);
    return localk;
  }
  
  public final Bitmap getFavicon()
  {
    AppMethodBeat.i(195526);
    if (this.Mvn == null)
    {
      AppMethodBeat.o(195526);
      return null;
    }
    Bitmap localBitmap = this.Mvn.getFavicon();
    AppMethodBeat.o(195526);
    return localBitmap;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(195524);
    if (this.Mvn == null)
    {
      AppMethodBeat.o(195524);
      return null;
    }
    String str = this.Mvn.getOriginalUrl();
    AppMethodBeat.o(195524);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(195525);
    if (this.Mvn == null)
    {
      AppMethodBeat.o(195525);
      return null;
    }
    String str = this.Mvn.getTitle();
    AppMethodBeat.o(195525);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(195523);
    if (this.Mvn == null)
    {
      AppMethodBeat.o(195523);
      return null;
    }
    String str = this.Mvn.getUrl();
    AppMethodBeat.o(195523);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.k
 * JD-Core Version:    0.7.0.1
 */