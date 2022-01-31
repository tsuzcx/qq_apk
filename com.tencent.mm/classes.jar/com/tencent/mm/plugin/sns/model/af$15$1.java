package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.ri;
import com.tencent.mm.h.a.ri.a;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.sdk.platformtools.y;

final class af$15$1
  implements Runnable
{
  af$15$1(af.15 param15, ri paramri) {}
  
  public final void run()
  {
    int i = (int)this.osU.caT.caV;
    k localk = af.bDK();
    String str = " update SnsComment set isRead = 1 where isRead = 0 and  createTime <= " + i;
    y.i("MicroMsg.SnsCommentStorage", "updateToread " + str);
    boolean bool = localk.dXo.gk("SnsComment", str);
    y.i("MicroMsg.SnsCore", "update msg read " + bool);
    u.bDb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.af.15.1
 * JD-Core Version:    0.7.0.1
 */