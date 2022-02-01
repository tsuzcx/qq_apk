package com.tencent.smtt.sdk.b;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions;
import java.util.Set;

public class k
  implements IX5CoreGeolocationPermissions
{
  private DexLoader a;
  
  k(DexLoader paramDexLoader)
  {
    this.a = paramDexLoader;
  }
  
  public void allow(String paramString)
  {
    AppMethodBeat.i(188458);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(188458);
  }
  
  public void clear(String paramString)
  {
    AppMethodBeat.i(188457);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(188457);
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(188459);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    AppMethodBeat.o(188459);
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(188456);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(188456);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    AppMethodBeat.i(188455);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(188455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.k
 * JD-Core Version:    0.7.0.1
 */