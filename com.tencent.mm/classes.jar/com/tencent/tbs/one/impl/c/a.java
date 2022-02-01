package com.tencent.tbs.one.impl.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneComponent;
import java.io.File;

public final class a
  implements TBSOneComponent
{
  Context a;
  ClassLoader b;
  Object c;
  private String d;
  private String e;
  private int f;
  private File g;
  
  public a(String paramString1, String paramString2, int paramInt, File paramFile)
  {
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramInt;
    this.g = paramFile;
  }
  
  public final ClassLoader getEntryClassLoader()
  {
    return this.b;
  }
  
  public final Object getEntryObject()
  {
    return this.c;
  }
  
  public final File getInstallationDirectory()
  {
    return this.g;
  }
  
  public final String getName()
  {
    return this.d;
  }
  
  public final Context getResourcesContext()
  {
    return this.a;
  }
  
  public final int getVersionCode()
  {
    return this.f;
  }
  
  public final String getVersionName()
  {
    return this.e;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(173883);
    String str = String.format("{name: '%s', versionName: '%s', versionCode: %d, installationDirectory: '%s', apkContext: '%s', entryClassLoader: '%s', entryObject: '%s'}", new Object[] { this.d, this.e, Integer.valueOf(this.f), this.g, this.a, this.b, this.c });
    AppMethodBeat.o(173883);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.a
 * JD-Core Version:    0.7.0.1
 */