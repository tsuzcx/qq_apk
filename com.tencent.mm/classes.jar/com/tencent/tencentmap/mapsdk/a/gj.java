package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;

final class gj
  implements Runnable
{
  gj(gi paramgi) {}
  
  public final void run()
  {
    String str = hn.b("settings_in_client", "", true);
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      gi.a(this.a).a(str);
      gi.b(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      hn.a("settings_in_client", "", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.gj
 * JD-Core Version:    0.7.0.1
 */