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
    AppMethodBeat.i(192867);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    AppMethodBeat.o(192867);
  }
  
  public Bitmap getIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(192872);
    paramString = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(192872);
      return null;
    }
    paramString = (Bitmap)paramString;
    AppMethodBeat.o(192872);
    return paramString;
  }
  
  public void open(String paramString)
  {
    AppMethodBeat.i(192866);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(192866);
  }
  
  public void releaseIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(192871);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(192871);
  }
  
  public void removeAllIcons()
  {
    AppMethodBeat.i(192868);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    AppMethodBeat.o(192868);
  }
  
  public void requestIconForPageUrl(String paramString, IconListener paramIconListener)
  {
    AppMethodBeat.i(192869);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[] { String.class, IconListener.class }, new Object[] { paramString, paramIconListener });
    AppMethodBeat.o(192869);
  }
  
  public void retainIconForPageUrl(String paramString)
  {
    AppMethodBeat.i(192870);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(192870);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.g
 * JD-Core Version:    0.7.0.1
 */