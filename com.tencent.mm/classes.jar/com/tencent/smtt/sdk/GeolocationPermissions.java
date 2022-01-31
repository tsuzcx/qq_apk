package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class GeolocationPermissions
{
  private static GeolocationPermissions a;
  
  private static GeolocationPermissions a()
  {
    try
    {
      AppMethodBeat.i(63903);
      if (a == null) {
        a = new GeolocationPermissions();
      }
      GeolocationPermissions localGeolocationPermissions = a;
      AppMethodBeat.o(63903);
      return localGeolocationPermissions;
    }
    finally {}
  }
  
  public static GeolocationPermissions getInstance()
  {
    AppMethodBeat.i(63902);
    GeolocationPermissions localGeolocationPermissions = a();
    AppMethodBeat.o(63902);
    return localGeolocationPermissions;
  }
  
  public void allow(String paramString)
  {
    AppMethodBeat.i(63907);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().g(paramString);
      AppMethodBeat.o(63907);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().allow(paramString);
    AppMethodBeat.o(63907);
  }
  
  public void clear(String paramString)
  {
    AppMethodBeat.i(63906);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().f(paramString);
      AppMethodBeat.o(63906);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clear(paramString);
    AppMethodBeat.o(63906);
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(63908);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().o();
      AppMethodBeat.o(63908);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clearAll();
    AppMethodBeat.o(63908);
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(63905);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().c(paramString, paramValueCallback);
      AppMethodBeat.o(63905);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getAllowed(paramString, paramValueCallback);
    AppMethodBeat.o(63905);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    AppMethodBeat.i(63904);
    bz localbz = bz.a();
    if ((localbz != null) && (localbz.b()))
    {
      localbz.c().b(paramValueCallback);
      AppMethodBeat.o(63904);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getOrigins(paramValueCallback);
    AppMethodBeat.o(63904);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.GeolocationPermissions
 * JD-Core Version:    0.7.0.1
 */