package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;
import java.util.List;

final class aw$4
  implements Runnable
{
  aw$4(aw paramaw, String paramString1, awe paramawe, List paramList, bxk parambxk, int paramInt, boolean paramBoolean, LinkedList paramLinkedList, com.tencent.mm.bv.b paramb, String paramString2) {}
  
  public final void run()
  {
    if (af.bDo())
    {
      y.e("MicroMsg.UploadManager", "is invalid to getSnsInfoStorage");
      return;
    }
    aw.a(this.ouc, new s(this.ezi, this.oue.trR, this.oue.tsm, this.ouf, this.oug, this.oud, this.oue.nde, this.oue.tsr, this.oue.tss, this.oue.tst, this.oue, this.ouh, this.oui, this.oue.tsy, this.ouj, this.dYK));
    g.DQ();
    g.DO().dJT.a(aw.d(this.ouc), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.aw.4
 * JD-Core Version:    0.7.0.1
 */