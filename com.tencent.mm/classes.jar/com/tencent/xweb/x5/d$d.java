package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.xweb.z.a;

public final class d$d
  extends z.a
{
  public WebChromeClient.FileChooserParams ainc;
  
  public d$d(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.ainc = paramFileChooserParams;
  }
  
  public final String[] getAcceptTypes()
  {
    AppMethodBeat.i(153851);
    if (this.ainc != null)
    {
      String[] arrayOfString = this.ainc.getAcceptTypes();
      AppMethodBeat.o(153851);
      return arrayOfString;
    }
    AppMethodBeat.o(153851);
    return new String[0];
  }
  
  public final int getMode()
  {
    AppMethodBeat.i(153850);
    if (this.ainc != null)
    {
      int i = this.ainc.getMode();
      AppMethodBeat.o(153850);
      return i;
    }
    AppMethodBeat.o(153850);
    return 0;
  }
  
  public final boolean isCaptureEnabled()
  {
    AppMethodBeat.i(153852);
    if (this.ainc != null)
    {
      boolean bool = this.ainc.isCaptureEnabled();
      AppMethodBeat.o(153852);
      return bool;
    }
    AppMethodBeat.o(153852);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.d.d
 * JD-Core Version:    0.7.0.1
 */