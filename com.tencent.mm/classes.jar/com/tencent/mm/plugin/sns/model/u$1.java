package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.bto;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

final class u$1
  implements Runnable
{
  u$1(u paramu, bto parambto, ah paramah) {}
  
  public final void run()
  {
    if (!this.oqw.sxM.equals(u.a(this.oqy)))
    {
      g.DQ();
      if (!g.DN().Dc())
      {
        y.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
        return;
      }
      g.DQ();
      Object localObject = (String)g.DP().Dz().get(68377, null);
      g.DQ();
      if ((bk.a((Integer)g.DP().Dz().get(68400, null), 0) != this.oqw.mPL) || ((!bk.bl((String)localObject)) && (!((String)localObject).equals(this.oqw.sxM))))
      {
        g.DQ();
        g.DP().Dz().o(68377, this.oqw.sxM);
        g.DQ();
        g.DP().Dz().o(68400, Integer.valueOf(this.oqw.mPL));
        g.DQ();
        g.DP().Dz().o(68418, i.fN(this.oqw.sGd));
        g.DQ();
        g.DP().Dz().o(68419, Integer.valueOf(0));
        com.tencent.mm.plugin.sns.h.e.i(1, i.fN(this.oqw.sGd), 0);
      }
      localObject = u.bDc().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ap)((Iterator)localObject).next()).Hk();
      }
    }
    this.oqx.sendEmptyMessage(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.1
 * JD-Core Version:    0.7.0.1
 */