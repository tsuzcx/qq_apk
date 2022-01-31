package com.tencent.mm.plugin.sns.model;

import android.os.Message;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bug;
import com.tencent.mm.protocal.c.buh;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

final class u$a$1
  extends ah
{
  u$a$1(u.a parama) {}
  
  public final void handleMessage(Message paramMessage)
  {
    g.DQ();
    if (!g.DN().Dc()) {
      return;
    }
    if ((this.oqB.jZU == null) || (this.oqB.jZU.isEmpty()))
    {
      paramMessage = this.oqB.oqy;
      buh localbuh = (buh)paramMessage.dmK.ecF.ecN;
      bug localbug = (bug)paramMessage.dmK.ecE.ecN;
      byte[] arrayOfByte = localbuh.sIi.tFM.toByteArray();
      arrayOfByte = com.tencent.mm.protocal.z.g(localbug.sIi.tFM.toByteArray(), arrayOfByte);
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        g.DQ();
        g.DP().Dz().o(8195, bk.bG(arrayOfByte));
      }
      localbug.sIi.bs(arrayOfByte);
      if ((localbuh.sFD & localbug.sIh) == 0)
      {
        paramMessage.dmL.onSceneEnd(0, 0, "", paramMessage);
        return;
      }
      paramMessage.a(paramMessage.edc, paramMessage.dmL);
      return;
    }
    paramMessage = (qv)this.oqB.jZU.getFirst();
    y.d("MicroMsg.NetSceneNewSyncAlbum", "cmdId = " + paramMessage.sOA);
    this.oqB.jZU.removeFirst();
    switch (paramMessage.sOA)
    {
    default: 
      this.oqB.jZV.sendEmptyMessage(0);
      return;
    case 45: 
      af.bDp().post(new u.a.1.1(this, paramMessage));
      return;
    }
    af.bDp().post(new u.a.1.2(this, paramMessage));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.a.1
 * JD-Core Version:    0.7.0.1
 */