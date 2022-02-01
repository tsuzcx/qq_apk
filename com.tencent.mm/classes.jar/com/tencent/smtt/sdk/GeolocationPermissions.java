package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5CoreGeolocationPermissions;
import java.util.Set;

public class GeolocationPermissions
  extends z
{
  private static GeolocationPermissions a;
  
  private static GeolocationPermissions a()
  {
    try
    {
      AppMethodBeat.i(55092);
      if (a == null) {
        a = new GeolocationPermissions();
      }
      GeolocationPermissions localGeolocationPermissions = a;
      AppMethodBeat.o(55092);
      return localGeolocationPermissions;
    }
    finally {}
  }
  
  public static GeolocationPermissions getInstance()
  {
    AppMethodBeat.i(55091);
    GeolocationPermissions localGeolocationPermissions = a();
    AppMethodBeat.o(55091);
    return localGeolocationPermissions;
  }
  
  public void allow(String paramString)
  {
    AppMethodBeat.i(55096);
    if (isX5Core())
    {
      getGeolocationPermissionsImpl().allow(paramString);
      AppMethodBeat.o(55096);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().allow(paramString);
    AppMethodBeat.o(55096);
  }
  
  public void clear(String paramString)
  {
    AppMethodBeat.i(55095);
    if (isX5Core())
    {
      getGeolocationPermissionsImpl().clear(paramString);
      AppMethodBeat.o(55095);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clear(paramString);
    AppMethodBeat.o(55095);
  }
  
  public void clearAll()
  {
    AppMethodBeat.i(55097);
    if (isX5Core())
    {
      getGeolocationPermissionsImpl().clearAll();
      AppMethodBeat.o(55097);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().clearAll();
    AppMethodBeat.o(55097);
  }
  
  public void getAllowed(String paramString, ValueCallback<Boolean> paramValueCallback)
  {
    AppMethodBeat.i(55094);
    if (isX5Core())
    {
      getAllowed(paramString, paramValueCallback);
      AppMethodBeat.o(55094);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getAllowed(paramString, paramValueCallback);
    AppMethodBeat.o(55094);
  }
  
  public void getOrigins(ValueCallback<Set<String>> paramValueCallback)
  {
    AppMethodBeat.i(55093);
    if (isX5Core())
    {
      getGeolocationPermissionsImpl().getOrigins(paramValueCallback);
      AppMethodBeat.o(55093);
      return;
    }
    android.webkit.GeolocationPermissions.getInstance().getOrigins(paramValueCallback);
    AppMethodBeat.o(55093);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.GeolocationPermissions
 * JD-Core Version:    0.7.0.1
 */