package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationItem;

public final class q
  extends WebHistoryItem
{
  XWalkNavigationItem IUy;
  
  public q(XWalkNavigationItem paramXWalkNavigationItem)
  {
    this.IUy = paramXWalkNavigationItem;
  }
  
  protected final WebHistoryItem clone()
  {
    AppMethodBeat.i(194704);
    q localq = new q(this.IUy);
    AppMethodBeat.o(194704);
    return localq;
  }
  
  public final Bitmap getFavicon()
  {
    return null;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(194702);
    if (this.IUy == null)
    {
      AppMethodBeat.o(194702);
      return null;
    }
    String str = this.IUy.getOriginalUrl();
    AppMethodBeat.o(194702);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(194703);
    if (this.IUy == null)
    {
      AppMethodBeat.o(194703);
      return null;
    }
    String str = this.IUy.getTitle();
    AppMethodBeat.o(194703);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(194701);
    if (this.IUy == null)
    {
      AppMethodBeat.o(194701);
      return null;
    }
    String str = this.IUy.getUrl();
    AppMethodBeat.o(194701);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.q
 * JD-Core Version:    0.7.0.1
 */