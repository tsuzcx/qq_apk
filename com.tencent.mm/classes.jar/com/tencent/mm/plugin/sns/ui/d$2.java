package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.List;

final class d$2
  implements Runnable
{
  d$2(d paramd, List paramList) {}
  
  public final void run()
  {
    this.oMp.cF(this.oMq);
    d locald = this.oMp;
    boolean bool = this.oMr;
    af.bDp().post(new d.3(locald, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.d.2
 * JD-Core Version:    0.7.0.1
 */