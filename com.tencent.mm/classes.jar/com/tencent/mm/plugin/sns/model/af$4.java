package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;

final class af$4
  implements Runnable
{
  af$4(af paramaf, int paramInt) {}
  
  public final void run()
  {
    Looper.prepare();
    af.a(this.osS)[this.val$id] = new ah();
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af.4
 * JD-Core Version:    0.7.0.1
 */