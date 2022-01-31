package com.tencent.mm.plugin.walletlock.fingerprint.a;

import android.content.SharedPreferences;
import com.tencent.mm.plugin.soter.d.g;

final class c$2
  implements g
{
  c$2(c paramc, SharedPreferences paramSharedPreferences) {}
  
  public final void ai(int paramInt, String paramString)
  {
    if (this.qPh.ndI) {}
    do
    {
      return;
      if (paramInt == 0)
      {
        c.fm(this.qPi.getString("cpu_id", null), this.qPi.getString("uid", null));
        return;
      }
    } while (this.qPh.qPe == null);
    this.qPh.qPe.ai(2, "init soter failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.fingerprint.a.c.2
 * JD-Core Version:    0.7.0.1
 */