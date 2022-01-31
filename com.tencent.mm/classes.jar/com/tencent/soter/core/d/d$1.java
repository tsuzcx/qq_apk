package com.tencent.soter.core.d;

import android.os.IBinder;
import android.os.IBinder.DeathRecipient;
import com.tencent.soter.soterserver.a;

final class d$1
  implements IBinder.DeathRecipient
{
  d$1(d paramd) {}
  
  public final void binderDied()
  {
    if (this.wPo.wPk == null) {
      return;
    }
    this.wPo.wPk.asBinder().unlinkToDeath(d.a(this.wPo), 0);
    this.wPo.wPk = null;
    this.wPo.aDx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.soter.core.d.d.1
 * JD-Core Version:    0.7.0.1
 */