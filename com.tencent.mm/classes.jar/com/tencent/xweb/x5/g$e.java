package com.tencent.xweb.x5;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;

public final class g$e
  implements GeolocationPermissions.Callback
{
  GeolocationPermissionsCallback BIa;
  
  public g$e(GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    this.BIa = paramGeolocationPermissionsCallback;
  }
  
  public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(84829);
    if (this.BIa != null) {
      this.BIa.invoke(paramString, paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(84829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.e
 * JD-Core Version:    0.7.0.1
 */