package com.tencent.smtt.sdk.a;

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
    AppMethodBeat.i(54839);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(54839);
  }
  
  public void clear(String paramString)
  {
    AppMethodBeat.i(54838);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[] { String.class }, new Object[] { paramString });
    AppMethodBeat.o(54838);
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(54840);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
    AppMethodBeat.o(54840);
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(54837);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[] { String.class, ValueCallback.class }, new Object[] { paramString, paramValueCallback });
    AppMethodBeat.o(54837);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    AppMethodBeat.i(54836);
    this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[] { ValueCallback.class }, new Object[] { paramValueCallback });
    AppMethodBeat.o(54836);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.a.k
 * JD-Core Version:    0.7.0.1
 */