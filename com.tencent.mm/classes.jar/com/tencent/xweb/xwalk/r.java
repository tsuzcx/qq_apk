package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationItem;

public final class r
  extends WebHistoryItem
{
  XWalkNavigationItem MUE;
  
  public r(XWalkNavigationItem paramXWalkNavigationItem)
  {
    this.MUE = paramXWalkNavigationItem;
  }
  
  protected final WebHistoryItem clone()
  {
    AppMethodBeat.i(207595);
    r localr = new r(this.MUE);
    AppMethodBeat.o(207595);
    return localr;
  }
  
  public final Bitmap getFavicon()
  {
    return null;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(207593);
    if (this.MUE == null)
    {
      AppMethodBeat.o(207593);
      return null;
    }
    String str = this.MUE.getOriginalUrl();
    AppMethodBeat.o(207593);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(207594);
    if (this.MUE == null)
    {
      AppMethodBeat.o(207594);
      return null;
    }
    String str = this.MUE.getTitle();
    AppMethodBeat.o(207594);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(207592);
    if (this.MUE == null)
    {
      AppMethodBeat.o(207592);
      return null;
    }
    String str = this.MUE.getUrl();
    AppMethodBeat.o(207592);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.r
 * JD-Core Version:    0.7.0.1
 */