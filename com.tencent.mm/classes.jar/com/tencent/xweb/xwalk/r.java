package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationItem;

public final class r
  extends WebHistoryItem
{
  XWalkNavigationItem aajD;
  
  public r(XWalkNavigationItem paramXWalkNavigationItem)
  {
    this.aajD = paramXWalkNavigationItem;
  }
  
  protected final WebHistoryItem clone()
  {
    AppMethodBeat.i(204868);
    r localr = new r(this.aajD);
    AppMethodBeat.o(204868);
    return localr;
  }
  
  public final Bitmap getFavicon()
  {
    return null;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(204864);
    if (this.aajD == null)
    {
      AppMethodBeat.o(204864);
      return null;
    }
    String str = this.aajD.getOriginalUrl();
    AppMethodBeat.o(204864);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(204866);
    if (this.aajD == null)
    {
      AppMethodBeat.o(204866);
      return null;
    }
    String str = this.aajD.getTitle();
    AppMethodBeat.o(204866);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(204862);
    if (this.aajD == null)
    {
      AppMethodBeat.o(204862);
      return null;
    }
    String str = this.aajD.getUrl();
    AppMethodBeat.o(204862);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.r
 * JD-Core Version:    0.7.0.1
 */