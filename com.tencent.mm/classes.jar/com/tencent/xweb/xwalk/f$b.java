package com.tencent.xweb.xwalk;

import android.webkit.GeolocationPermissions.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkGeolocationPermissionsCallback;

public final class f$b
  implements GeolocationPermissions.Callback
{
  XWalkGeolocationPermissionsCallback BJz;
  
  public f$b(XWalkGeolocationPermissionsCallback paramXWalkGeolocationPermissionsCallback)
  {
    this.BJz = paramXWalkGeolocationPermissionsCallback;
  }
  
  public final void invoke(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(85218);
    if (this.BJz != null) {
      this.BJz.invoke(paramString, paramBoolean1, paramBoolean2);
    }
    AppMethodBeat.o(85218);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.f.b
 * JD-Core Version:    0.7.0.1
 */