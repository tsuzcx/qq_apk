package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationItem;

public final class r
  extends WebHistoryItem
{
  XWalkNavigationItem KHa;
  
  public r(XWalkNavigationItem paramXWalkNavigationItem)
  {
    this.KHa = paramXWalkNavigationItem;
  }
  
  protected final WebHistoryItem clone()
  {
    AppMethodBeat.i(208935);
    r localr = new r(this.KHa);
    AppMethodBeat.o(208935);
    return localr;
  }
  
  public final Bitmap getFavicon()
  {
    return null;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(208933);
    if (this.KHa == null)
    {
      AppMethodBeat.o(208933);
      return null;
    }
    String str = this.KHa.getOriginalUrl();
    AppMethodBeat.o(208933);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(208934);
    if (this.KHa == null)
    {
      AppMethodBeat.o(208934);
      return null;
    }
    String str = this.KHa.getTitle();
    AppMethodBeat.o(208934);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(208932);
    if (this.KHa == null)
    {
      AppMethodBeat.o(208932);
      return null;
    }
    String str = this.KHa.getUrl();
    AppMethodBeat.o(208932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.r
 * JD-Core Version:    0.7.0.1
 */