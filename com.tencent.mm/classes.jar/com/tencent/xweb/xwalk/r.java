package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationItem;

public final class r
  extends WebHistoryItem
{
  XWalkNavigationItem MxA;
  
  public r(XWalkNavigationItem paramXWalkNavigationItem)
  {
    this.MxA = paramXWalkNavigationItem;
  }
  
  protected final WebHistoryItem clone()
  {
    AppMethodBeat.i(195576);
    r localr = new r(this.MxA);
    AppMethodBeat.o(195576);
    return localr;
  }
  
  public final Bitmap getFavicon()
  {
    return null;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(195574);
    if (this.MxA == null)
    {
      AppMethodBeat.o(195574);
      return null;
    }
    String str = this.MxA.getOriginalUrl();
    AppMethodBeat.o(195574);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(195575);
    if (this.MxA == null)
    {
      AppMethodBeat.o(195575);
      return null;
    }
    String str = this.MxA.getTitle();
    AppMethodBeat.o(195575);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(195573);
    if (this.MxA == null)
    {
      AppMethodBeat.o(195573);
      return null;
    }
    String str = this.MxA.getUrl();
    AppMethodBeat.o(195573);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.r
 * JD-Core Version:    0.7.0.1
 */