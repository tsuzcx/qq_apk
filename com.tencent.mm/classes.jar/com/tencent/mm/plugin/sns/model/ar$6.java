package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.Map;

final class ar$6
  implements Runnable
{
  ar$6(ar paramar, ay paramay, boolean paramBoolean) {}
  
  public final void run()
  {
    Object localObject = af.bDF().OB(this.otQ.bJQ);
    ay localay = this.otQ;
    if (localObject != null)
    {
      localObject = ((n)localObject).field_userName;
      localay.ouG = ((String)localObject);
      y.i("MicroMsg.SnsVideoService", "offer [%b] video task[%s] to queue ", new Object[] { Boolean.valueOf(this.otR), this.otQ });
      if (!this.otR) {
        break label114;
      }
      this.otO.otK.offerFirst(this.otQ);
    }
    for (;;)
    {
      this.otO.otL.put(this.otQ.eFo, this.otQ);
      return;
      localObject = "";
      break;
      label114:
      this.otO.otK.offerLast(this.otQ);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ar.6
 * JD-Core Version:    0.7.0.1
 */