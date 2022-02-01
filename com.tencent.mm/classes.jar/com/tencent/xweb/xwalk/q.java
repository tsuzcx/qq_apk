package com.tencent.xweb.xwalk;

import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkNavigationItem;

public final class q
  extends WebHistoryItem
{
  private XWalkNavigationItem aipz;
  
  public q(XWalkNavigationItem paramXWalkNavigationItem)
  {
    this.aipz = paramXWalkNavigationItem;
  }
  
  protected final WebHistoryItem clone()
  {
    AppMethodBeat.i(212822);
    q localq = new q(this.aipz);
    AppMethodBeat.o(212822);
    return localq;
  }
  
  public final Bitmap getFavicon()
  {
    return null;
  }
  
  public final String getOriginalUrl()
  {
    AppMethodBeat.i(212810);
    if (this.aipz == null)
    {
      AppMethodBeat.o(212810);
      return null;
    }
    String str = this.aipz.getOriginalUrl();
    AppMethodBeat.o(212810);
    return str;
  }
  
  public final String getTitle()
  {
    AppMethodBeat.i(212817);
    if (this.aipz == null)
    {
      AppMethodBeat.o(212817);
      return null;
    }
    String str = this.aipz.getTitle();
    AppMethodBeat.o(212817);
    return str;
  }
  
  public final String getUrl()
  {
    AppMethodBeat.i(212805);
    if (this.aipz == null)
    {
      AppMethodBeat.o(212805);
      return null;
    }
    String str = this.aipz.getUrl();
    AppMethodBeat.o(212805);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.xwalk.q
 * JD-Core Version:    0.7.0.1
 */