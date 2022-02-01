package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x.a;

public final class c$c
  extends x.a
{
  public WebChromeClient.FileChooserParams SDY;
  
  public c$c(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.SDY = paramFileChooserParams;
  }
  
  @TargetApi(21)
  public final String[] getAcceptTypes()
  {
    AppMethodBeat.i(153660);
    if (this.SDY != null)
    {
      String[] arrayOfString = this.SDY.getAcceptTypes();
      AppMethodBeat.o(153660);
      return arrayOfString;
    }
    AppMethodBeat.o(153660);
    return new String[0];
  }
  
  @TargetApi(21)
  public final int getMode()
  {
    AppMethodBeat.i(153659);
    if (this.SDY != null)
    {
      int i = this.SDY.getMode();
      AppMethodBeat.o(153659);
      return i;
    }
    AppMethodBeat.o(153659);
    return 0;
  }
  
  @TargetApi(21)
  public final boolean isCaptureEnabled()
  {
    AppMethodBeat.i(153661);
    if (this.SDY != null)
    {
      boolean bool = this.SDY.isCaptureEnabled();
      AppMethodBeat.o(153661);
      return bool;
    }
    AppMethodBeat.o(153661);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.sys.c.c
 * JD-Core Version:    0.7.0.1
 */