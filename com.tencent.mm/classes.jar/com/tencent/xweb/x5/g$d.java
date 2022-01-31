package com.tencent.xweb.x5;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient.FileChooserParams;
import com.tencent.xweb.p.a;

public final class g$d
  extends p.a
{
  public WebChromeClient.FileChooserParams BHZ;
  
  public g$d(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.BHZ = paramFileChooserParams;
  }
  
  public final String[] getAcceptTypes()
  {
    AppMethodBeat.i(84827);
    if (this.BHZ != null)
    {
      String[] arrayOfString = this.BHZ.getAcceptTypes();
      AppMethodBeat.o(84827);
      return arrayOfString;
    }
    AppMethodBeat.o(84827);
    return new String[0];
  }
  
  public final int getMode()
  {
    AppMethodBeat.i(84826);
    if (this.BHZ != null)
    {
      int i = this.BHZ.getMode();
      AppMethodBeat.o(84826);
      return i;
    }
    AppMethodBeat.o(84826);
    return 0;
  }
  
  public final boolean isCaptureEnabled()
  {
    AppMethodBeat.i(84828);
    if (this.BHZ != null)
    {
      boolean bool = this.BHZ.isCaptureEnabled();
      AppMethodBeat.o(84828);
      return bool;
    }
    AppMethodBeat.o(84828);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.xweb.x5.g.d
 * JD-Core Version:    0.7.0.1
 */