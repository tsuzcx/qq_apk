package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class cn
  implements Runnable
{
  cn(cm paramcm) {}
  
  public final void run()
  {
    AppMethodBeat.i(98654);
    String str = ac.a().getSharedPreferences(cm.a(this.a), 0).getString("halley_cloud_param_content", "");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        cm.b(this.a).a(str);
        AppMethodBeat.o(98654);
        return;
      }
      catch (Throwable localThrowable)
      {
        cm.a(this.a, "");
      }
    }
    AppMethodBeat.o(98654);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.cn
 * JD-Core Version:    0.7.0.1
 */