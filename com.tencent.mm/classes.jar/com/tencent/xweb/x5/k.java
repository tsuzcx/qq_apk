package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
  extends android.webkit.WebHistoryItem
{
  private com.tencent.smtt.sdk.WebHistoryItem aagI;
  
  public k(com.tencent.smtt.sdk.WebHistoryItem paramWebHistoryItem)
  {
    this.aagI = paramWebHistoryItem;
  }
  
  protected final android.webkit.WebHistoryItem clone()
  {
    AppMethodBeat.i(207440);
    k localk = new k(this.aagI);
    AppMethodBeat.o(207440);
    return localk;
  }
  
  public final Bitmap getFavicon()
  {
    AppMethodBeat.i(207439);
    if (this.aagI == null)
    {
      AppMethodBeat.o(207439);
      return null;
    }
    Bitmap localBitmap = this.aagI.getFavicon();
    AppMethodBeat.o(207439);
    return localBitmap;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(207436);
    if (this.aagI == null)
    {
      AppMethodBeat.o(207436);
      return null;
    }
    String str = this.aagI.getOriginalUrl();
    AppMethodBeat.o(207436);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(207437);
    if (this.aagI == null)
    {
      AppMethodBeat.o(207437);
      return null;
    }
    String str = this.aagI.getTitle();
    AppMethodBeat.o(207437);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(207435);
    if (this.aagI == null)
    {
      AppMethodBeat.o(207435);
      return null;
    }
    String str = this.aagI.getUrl();
    AppMethodBeat.o(207435);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.k
 * JD-Core Version:    0.7.0.1
 */