package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationItem;

public final class r
  extends WebHistoryItem
{
  XWalkNavigationItem SHL;
  
  public r(XWalkNavigationItem paramXWalkNavigationItem)
  {
    this.SHL = paramXWalkNavigationItem;
  }
  
  protected final WebHistoryItem clone()
  {
    AppMethodBeat.i(207325);
    r localr = new r(this.SHL);
    AppMethodBeat.o(207325);
    return localr;
  }
  
  public final Bitmap getFavicon()
  {
    return null;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(207323);
    if (this.SHL == null)
    {
      AppMethodBeat.o(207323);
      return null;
    }
    String str = this.SHL.getOriginalUrl();
    AppMethodBeat.o(207323);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(207324);
    if (this.SHL == null)
    {
      AppMethodBeat.o(207324);
      return null;
    }
    String str = this.SHL.getTitle();
    AppMethodBeat.o(207324);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(207322);
    if (this.SHL == null)
    {
      AppMethodBeat.o(207322);
      return null;
    }
    String str = this.SHL.getUrl();
    AppMethodBeat.o(207322);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.r
 * JD-Core Version:    0.7.0.1
 */