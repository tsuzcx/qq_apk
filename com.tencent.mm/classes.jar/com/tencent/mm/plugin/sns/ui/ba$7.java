package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.am.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.sdk.platformtools.y;

final class ba$7
  implements SnsHeader.a
{
  ba$7(ba paramba) {}
  
  public final boolean bIO()
  {
    ba.c(this.piF).bJH();
    return false;
  }
  
  public final boolean gx(long paramLong)
  {
    if ((ba.b(this.piF)) || (ba.c(this.piF).getType() == 1))
    {
      this.piF.yW(2);
      return false;
    }
    Object localObject1 = new n();
    ((n)localObject1).field_snsId = paramLong;
    ((n)localObject1).field_userName = ba.d(this.piF);
    Object localObject2 = e.QZ();
    ((bxk)localObject2).hPY = ba.d(this.piF);
    ((n)localObject1).c((bxk)localObject2);
    localObject2 = aj.ND(ba.d(this.piF));
    y.d("MicroMsg.SnsActivity", "friend like %s", new Object[] { ba.d(this.piF) });
    if (localObject2 == null) {
      am.a.a((n)localObject1, 1, "", 0);
    }
    for (;;)
    {
      localObject1 = af.bDJ().OF(ba.d(this.piF));
      ((l)localObject1).field_local_flag |= 0x2;
      af.bDJ().c((l)localObject1);
      ba.e(this.piF);
      return false;
      if (((n)localObject2).bGD()) {
        am.a.a((n)localObject1, 1, "", 0);
      } else {
        am.a.a((n)localObject1, 5, "", 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ba.7
 * JD-Core Version:    0.7.0.1
 */