package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends android.webkit.WebHistoryItem
{
  private com.tencent.smtt.sdk.WebHistoryItem ainn;
  
  public h(com.tencent.smtt.sdk.WebHistoryItem paramWebHistoryItem)
  {
    this.ainn = paramWebHistoryItem;
  }
  
  protected final android.webkit.WebHistoryItem clone()
  {
    AppMethodBeat.i(213190);
    h localh = new h(this.ainn);
    AppMethodBeat.o(213190);
    return localh;
  }
  
  public final Bitmap getFavicon()
  {
    AppMethodBeat.i(213184);
    if (this.ainn == null)
    {
      AppMethodBeat.o(213184);
      return null;
    }
    Bitmap localBitmap = this.ainn.getFavicon();
    AppMethodBeat.o(213184);
    return localBitmap;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(213175);
    if (this.ainn == null)
    {
      AppMethodBeat.o(213175);
      return null;
    }
    String str = this.ainn.getOriginalUrl();
    AppMethodBeat.o(213175);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(213180);
    if (this.ainn == null)
    {
      AppMethodBeat.o(213180);
      return null;
    }
    String str = this.ainn.getTitle();
    AppMethodBeat.o(213180);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(213171);
    if (this.ainn == null)
    {
      AppMethodBeat.o(213171);
      return null;
    }
    String str = this.ainn.getUrl();
    AppMethodBeat.o(213171);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.h
 * JD-Core Version:    0.7.0.1
 */