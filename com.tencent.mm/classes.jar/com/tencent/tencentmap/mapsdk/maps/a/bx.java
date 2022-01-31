package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class bx
  implements Runnable
{
  bx(bw parambw) {}
  
  public final void run()
  {
    AppMethodBeat.i(147326);
    String str = da.b("settings_in_client", "", true);
    if (!TextUtils.isEmpty(str)) {
      try
      {
        bw.a(this.a).a(str);
        bw.b(this.a);
        AppMethodBeat.o(147326);
        return;
      }
      catch (Throwable localThrowable)
      {
        da.a("settings_in_client", "", true);
      }
    }
    AppMethodBeat.o(147326);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bx
 * JD-Core Version:    0.7.0.1
 */