package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends android.webkit.WebHistoryItem
{
  private com.tencent.smtt.sdk.WebHistoryItem KEN;
  
  public k(com.tencent.smtt.sdk.WebHistoryItem paramWebHistoryItem)
  {
    this.KEN = paramWebHistoryItem;
  }
  
  protected final android.webkit.WebHistoryItem clone()
  {
    AppMethodBeat.i(208896);
    k localk = new k(this.KEN);
    AppMethodBeat.o(208896);
    return localk;
  }
  
  public final Bitmap getFavicon()
  {
    AppMethodBeat.i(208895);
    if (this.KEN == null)
    {
      AppMethodBeat.o(208895);
      return null;
    }
    Bitmap localBitmap = this.KEN.getFavicon();
    AppMethodBeat.o(208895);
    return localBitmap;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(208893);
    if (this.KEN == null)
    {
      AppMethodBeat.o(208893);
      return null;
    }
    String str = this.KEN.getOriginalUrl();
    AppMethodBeat.o(208893);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(208894);
    if (this.KEN == null)
    {
      AppMethodBeat.o(208894);
      return null;
    }
    String str = this.KEN.getTitle();
    AppMethodBeat.o(208894);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(208892);
    if (this.KEN == null)
    {
      AppMethodBeat.o(208892);
      return null;
    }
    String str = this.KEN.getUrl();
    AppMethodBeat.o(208892);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.k
 * JD-Core Version:    0.7.0.1
 */