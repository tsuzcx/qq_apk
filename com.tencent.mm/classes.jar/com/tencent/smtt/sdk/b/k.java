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
    AppMethodBeat.i(192819);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(192819);
  }
  
  public void clear(String paramString)
  {
    AppMethodBeat.i(192818);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(192818);
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(192820);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    AppMethodBeat.o(192820);
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(192817);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(192817);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    AppMethodBeat.i(192816);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(192816);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.b.k
 * JD-Core Version:    0.7.0.1
 */