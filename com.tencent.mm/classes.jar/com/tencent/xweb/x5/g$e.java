package com.tencent.xweb.x5;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;

public final class g$e
  implements GeolocationPermissions.Callback
{
  GeolocationPermissionsCallback xkv;
  
  public g$e(GeolocationPermissionsCallback paramGeolocationPermissionsCallback)
  {
    this.xkv = paramGeolocationPermissionsCallback;
  }
  
  public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.xkv != null) {
      this.xkv.invoke(paramString, paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.x5.g.e
 * JD-Core Version:    0.7.0.1
 */