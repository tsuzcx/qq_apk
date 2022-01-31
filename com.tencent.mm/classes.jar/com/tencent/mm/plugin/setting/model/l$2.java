package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.concurrent.CountDownLatch;

final class l$2
  implements Runnable
{
  l$2(l paraml) {}
  
  public final void run()
  {
    try
    {
      this.nRa.nQS.await();
      long l = System.currentTimeMillis();
      this.nRa.nQT.clear();
      this.nRa.nQU.remove(q.Gj());
      this.nRa.nQT.addAll(this.nRa.nQU);
      this.nRa.nQT.addAll(this.nRa.nQV);
      this.nRa.nQT.addAll(this.nRa.nQW);
      if (this.nRa.nQQ) {
        this.nRa.nQT.retainAll(this.nRa.nQW);
      }
      if (this.nRa.nQR) {
        this.nRa.nQT.retainAll(this.nRa.nQV);
      }
      if (this.nRa.nQP) {
        this.nRa.nQT.retainAll(this.nRa.nQU);
      }
      this.nRa.nQY.e(this.nRa.nQT);
      y.i("MicroMsg.UnfamiliarContactEngine", "[onResult] :%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      ai.d(new l.2.1(this));
      y.i("MicroMsg.UnfamiliarContactEngine", "all cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - this.nRa.nQZ) });
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      y.printErrStackTrace("MicroMsg.UnfamiliarContactEngine", localInterruptedException, "", new Object[0]);
      ai.d(new Runnable()
      {
        public final void run()
        {
          l.2.this.nRa.nQY.onError();
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.model.l.2
 * JD-Core Version:    0.7.0.1
 */