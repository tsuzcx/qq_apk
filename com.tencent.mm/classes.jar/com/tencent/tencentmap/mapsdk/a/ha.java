package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

final class ha
  implements Runnable
{
  ha(gz paramgz) {}
  
  public final void run()
  {
    String str = em.a().getSharedPreferences(gz.a(this.a), 0).getString("halley_cloud_param_content", "");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      gz.b(this.a).a(str);
      return;
    }
    catch (Throwable localThrowable)
    {
      gz.a(this.a, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ha
 * JD-Core Version:    0.7.0.1
 */