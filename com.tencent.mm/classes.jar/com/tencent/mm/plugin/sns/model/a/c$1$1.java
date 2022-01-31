package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.j.d;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, int paramInt, d paramd) {}
  
  public final void run()
  {
    c.bEw().remove(this.ovk.ovj.ouO.opZ);
    y.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(this.ewr), this.ovk.ovj.ouO.url, this.ovk.ovj.ouO.bUi, Integer.valueOf(this.eiR.field_fileLength), Integer.valueOf(c.bEw().size()) });
    if ((this.ovk.ovj.ouO.ouH) && (this.ewr != 2))
    {
      av.NO(this.ovk.ovj.ouO.bUi);
      this.ovk.ovj.bEv();
    }
    for (;;)
    {
      this.ovk.ovj.ouM.a(this.ewr, this.ovk.ovj.bZK, this.ovk.ovj.ouO.ouJ, this.ovk.ovj.ouO.ouH, this.ovk.ovj.ouO.opZ, this.eiR.field_fileLength);
      return;
      if ((!this.ovk.ovj.ouO.ouH) && ((this.ovk.ovj.ouO.ouJ == 4) || (this.ovk.ovj.ouO.ouJ == 6)))
      {
        String str = this.ovk.ovj.ouO.getPath() + i.j(this.ovk.ovj.bZK);
        af.bDC().eH(this.ovk.ovj.ouO.bUi, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c.1.1
 * JD-Core Version:    0.7.0.1
 */