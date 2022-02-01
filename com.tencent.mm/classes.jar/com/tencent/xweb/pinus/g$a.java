package com.tencent.xweb.pinus;

import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.z.a;

public final class g$a
  extends z.a
{
  public WebChromeClient.FileChooserParams aikv;
  
  public g$a(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.aikv = paramFileChooserParams;
  }
  
  public final String[] getAcceptTypes()
  {
    AppMethodBeat.i(213306);
    if (this.aikv != null)
    {
      String[] arrayOfString = this.aikv.getAcceptTypes();
      AppMethodBeat.o(213306);
      return arrayOfString;
    }
    AppMethodBeat.o(213306);
    return new String[0];
  }
  
  public final int getMode()
  {
    AppMethodBeat.i(213300);
    if (this.aikv != null)
    {
      int i = this.aikv.getMode();
      AppMethodBeat.o(213300);
      return i;
    }
    AppMethodBeat.o(213300);
    return 0;
  }
  
  public final boolean isCaptureEnabled()
  {
    AppMethodBeat.i(213312);
    if (this.aikv != null)
    {
      boolean bool = this.aikv.isCaptureEnabled();
      AppMethodBeat.o(213312);
      return bool;
    }
    AppMethodBeat.o(213312);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.pinus.g.a
 * JD-Core Version:    0.7.0.1
 */