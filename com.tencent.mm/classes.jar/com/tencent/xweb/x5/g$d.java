package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.xweb.x.a;

public final class g$d
  extends x.a
{
  public WebChromeClient.FileChooserParams KEu;
  
  public g$d(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.KEu = paramFileChooserParams;
  }
  
  public final String[] getAcceptTypes()
  {
    AppMethodBeat.i(153851);
    if (this.KEu != null)
    {
      String[] arrayOfString = this.KEu.getAcceptTypes();
      AppMethodBeat.o(153851);
      return arrayOfString;
    }
    AppMethodBeat.o(153851);
    return new String[0];
  }
  
  public final int getMode()
  {
    AppMethodBeat.i(153850);
    if (this.KEu != null)
    {
      int i = this.KEu.getMode();
      AppMethodBeat.o(153850);
      return i;
    }
    AppMethodBeat.o(153850);
    return 0;
  }
  
  public final boolean isCaptureEnabled()
  {
    AppMethodBeat.i(153852);
    if (this.KEu != null)
    {
      boolean bool = this.KEu.isCaptureEnabled();
      AppMethodBeat.o(153852);
      return bool;
    }
    AppMethodBeat.o(153852);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.d
 * JD-Core Version:    0.7.0.1
 */