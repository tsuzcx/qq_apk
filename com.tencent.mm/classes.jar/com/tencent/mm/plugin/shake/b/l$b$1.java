package com.tencent.mm.plugin.shake.b;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah.a;

final class l$b$1
  implements ah.a
{
  l$b$1(l.b paramb) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    if ((paramMessage.what == l.nYR) && (!this.nYY.nYV) && (this.nYY.nYU != null)) {
      this.nYY.nYU.a(null, 5L);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.l.b.1
 * JD-Core Version:    0.7.0.1
 */