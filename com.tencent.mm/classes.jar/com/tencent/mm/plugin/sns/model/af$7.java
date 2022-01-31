package com.tencent.mm.plugin.sns.model;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;

final class af$7
  implements Runnable
{
  af$7(af paramaf) {}
  
  public final void run()
  {
    Looper.prepare();
    af.b(this.osS, new ah());
    Looper.loop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af.7
 * JD-Core Version:    0.7.0.1
 */