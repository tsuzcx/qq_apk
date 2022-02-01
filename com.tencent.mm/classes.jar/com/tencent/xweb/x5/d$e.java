package com.tencent.xweb.x5;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;

public final class d$e
  implements GeolocationPermissions.Callback
{
  GeolocationPermissionsCallback aind;
  
  public d$e(GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    this.aind = paramGeolocationPermissionsCallback;
  }
  
  public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(153853);
    if (this.aind != null) {
      this.aind.invoke(paramString, paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(153853);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.xweb.x5.d.e
 * JD-Core Version:    0.7.0.1
 */