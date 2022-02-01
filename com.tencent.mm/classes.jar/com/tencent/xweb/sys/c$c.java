package com.tencent.xweb.sys;

import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.z.a;

public final class c$c
  extends z.a
{
  public WebChromeClient.FileChooserParams aikv;
  
  public c$c(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.aikv = paramFileChooserParams;
  }
  
  public final String[] getAcceptTypes()
  {
    AppMethodBeat.i(153660);
    if (this.aikv != null)
    {
      String[] arrayOfString = this.aikv.getAcceptTypes();
      AppMethodBeat.o(153660);
      return arrayOfString;
    }
    AppMethodBeat.o(153660);
    return new String[0];
  }
  
  public final int getMode()
  {
    AppMethodBeat.i(153659);
    if (this.aikv != null)
    {
      int i = this.aikv.getMode();
      AppMethodBeat.o(153659);
      return i;
    }
    AppMethodBeat.o(153659);
    return 0;
  }
  
  public final boolean isCaptureEnabled()
  {
    AppMethodBeat.i(153661);
    if (this.aikv != null)
    {
      boolean bool = this.aikv.isCaptureEnabled();
      AppMethodBeat.o(153661);
      return bool;
    }
    AppMethodBeat.o(153661);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.sys.c.c
 * JD-Core Version:    0.7.0.1
 */