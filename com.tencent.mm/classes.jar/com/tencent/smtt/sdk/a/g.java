package com.tencent.smtt.sdk.a;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreWebIconDB;
import com.tencent.smtt.export.external.interfaces.IconListener;

public class g
  implements IX5CoreWebIconDB
{
  private DexLoader a;
  
  g(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public void close()
  {
    AppMethodBeat.i(54734);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    AppMethodBeat.o(54734);
  }
  
  public Bitmap getIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(54739);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(54739);
      return null;
    }
    paramString = (Bitmap)paramString;
    AppMethodBeat.o(54739);
    return paramString;
  }
  
  public void open(String paramString)
  {
    AppMethodBeat.i(54733);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(54733);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(54738);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(54738);
  }
  
  public void removeAllIcons()
  {
    AppMethodBeat.i(54735);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    AppMethodBeat.o(54735);
  }
  
  public void requestIconForPageUrl(String paramString, IconListener paramIconListener)
  {
    AppMethodBeat.i(54736);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[] { String.class, IconListener.class }, new Object[] { paramString, paramIconListener });
    AppMethodBeat.o(54736);
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(54737);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(54737);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.g
 * JD-Core Version:    0.7.0.1
 */