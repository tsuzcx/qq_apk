package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.Set;

final class aw$3
  implements Runnable
{
  aw$3(aw paramaw, int paramInt, boolean paramBoolean) {}
  
  public final void run()
  {
    if (af.bDo()) {
      y.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
    }
    for (;;)
    {
      return;
      Iterator localIterator = aw.c(this.ouc).iterator();
      while (localIterator.hasNext())
      {
        aw.a locala = (aw.a)localIterator.next();
        if (locala != null) {
          locala.W(this.oud, this.elN);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw.3
 * JD-Core Version:    0.7.0.1
 */