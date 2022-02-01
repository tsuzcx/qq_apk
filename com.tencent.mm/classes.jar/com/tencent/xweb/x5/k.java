package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends android.webkit.WebHistoryItem
{
  private com.tencent.smtt.sdk.WebHistoryItem SFx;
  
  public k(com.tencent.smtt.sdk.WebHistoryItem paramWebHistoryItem)
  {
    this.SFx = paramWebHistoryItem;
  }
  
  protected final android.webkit.WebHistoryItem clone()
  {
    AppMethodBeat.i(207201);
    k localk = new k(this.SFx);
    AppMethodBeat.o(207201);
    return localk;
  }
  
  public final Bitmap getFavicon()
  {
    AppMethodBeat.i(207200);
    if (this.SFx == null)
    {
      AppMethodBeat.o(207200);
      return null;
    }
    Bitmap localBitmap = this.SFx.getFavicon();
    AppMethodBeat.o(207200);
    return localBitmap;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(207198);
    if (this.SFx == null)
    {
      AppMethodBeat.o(207198);
      return null;
    }
    String str = this.SFx.getOriginalUrl();
    AppMethodBeat.o(207198);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(207199);
    if (this.SFx == null)
    {
      AppMethodBeat.o(207199);
      return null;
    }
    String str = this.SFx.getTitle();
    AppMethodBeat.o(207199);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(207197);
    if (this.SFx == null)
    {
      AppMethodBeat.o(207197);
      return null;
    }
    String str = this.SFx.getUrl();
    AppMethodBeat.o(207197);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.x5.k
 * JD-Core Version:    0.7.0.1
 */