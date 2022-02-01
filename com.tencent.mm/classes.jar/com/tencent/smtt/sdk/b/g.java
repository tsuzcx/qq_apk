package com.tencent.smtt.sdk.b;

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
    AppMethodBeat.i(188530);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    AppMethodBeat.o(188530);
  }
  
  public Bitmap getIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(188535);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(188535);
      return null;
    }
    paramString = (Bitmap)paramString;
    AppMethodBeat.o(188535);
    return paramString;
  }
  
  public void open(String paramString)
  {
    AppMethodBeat.i(188529);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(188529);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(188534);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(188534);
  }
  
  public void removeAllIcons()
  {
    AppMethodBeat.i(188531);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    AppMethodBeat.o(188531);
  }
  
  public void requestIconForPageUrl(String paramString, IconListener paramIconListener)
  {
    AppMethodBeat.i(188532);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[] { String.class, IconListener.class }, new Object[] { paramString, paramIconListener });
    AppMethodBeat.o(188532);
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(188533);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(188533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.g
 * JD-Core Version:    0.7.0.1
 */