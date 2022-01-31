package com.tencent.xweb.sys;

import android.annotation.TargetApi;
import android.webkit.WebChromeClient.FileChooserParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.p.a;

public final class c$b
  extends p.a
{
  public WebChromeClient.FileChooserParams BHj;
  
  public c$b(WebChromeClient.FileChooserParams paramFileChooserParams)
  {
    this.BHj = paramFileChooserParams;
  }
  
  @TargetApi(21)
  public final String[] getAcceptTypes()
  {
    AppMethodBeat.i(84652);
    if (this.BHj != null)
    {
      String[] arrayOfString = this.BHj.getAcceptTypes();
      AppMethodBeat.o(84652);
      return arrayOfString;
    }
    AppMethodBeat.o(84652);
    return new String[0];
  }
  
  @TargetApi(21)
  public final int getMode()
  {
    AppMethodBeat.i(84651);
    if (this.BHj != null)
    {
      int i = this.BHj.getMode();
      AppMethodBeat.o(84651);
      return i;
    }
    AppMethodBeat.o(84651);
    return 0;
  }
  
  @TargetApi(21)
  public final boolean isCaptureEnabled()
  {
    AppMethodBeat.i(84653);
    if (this.BHj != null)
    {
      boolean bool = this.BHj.isCaptureEnabled();
      AppMethodBeat.o(84653);
      return bool;
    }
    AppMethodBeat.o(84653);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.xweb.sys.c.b
 * JD-Core Version:    0.7.0.1
 */