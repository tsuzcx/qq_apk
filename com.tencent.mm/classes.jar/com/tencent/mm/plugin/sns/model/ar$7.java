package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class ar$7
  implements Runnable
{
  ar$7(ar paramar) {}
  
  public final void run()
  {
    boolean bool = true;
    if (this.otO.otK.isEmpty())
    {
      y.i("MicroMsg.SnsVideoService", "download queue is null, do nothing");
      return;
    }
    ay localay = (ay)this.otO.otK.poll();
    if (localay == null)
    {
      y.w("MicroMsg.SnsVideoService", "try start download video task is null. queue size %d", new Object[] { Integer.valueOf(this.otO.otK.size()) });
      return;
    }
    if ((this.otO.otJ != null) && (localay.eFo.equals(this.otO.otJ.eFo))) {}
    for (;;)
    {
      this.otO.a(localay, bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar.7
 * JD-Core Version:    0.7.0.1
 */