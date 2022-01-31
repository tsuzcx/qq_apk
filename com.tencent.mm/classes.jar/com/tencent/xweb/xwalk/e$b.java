package com.tencent.xweb.xwalk;

import android.webkit.GeolocationPermissions.Callback;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;

public final class e$b
  implements GeolocationPermissions.Callback
{
  XWalkGeolocationPermissionsCallback xlR;
  
  public e$b(XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    this.xlR = paramXWalkGeolocationPermissionsCallback;
  }
  
  public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.xlR != null) {
      this.xlR.invoke(paramString, paramBoolean1, paramBoolean2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.e.b
 * JD-Core Version:    0.7.0.1
 */