package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.List;

final class u$1
  implements Runnable
{
  u$1(u paramu, SnsObject paramSnsObject, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(36299);
    if (!this.rfg.Username.equals(u.a(this.rfi)))
    {
      g.RM();
      if (!g.RJ().QU())
      {
        ab.e("MicroMsg.NetSceneNewSyncAlbum", "mmcore has not set uin!!");
        AppMethodBeat.o(36299);
        return;
      }
      g.RM();
      Object localObject = (String)g.RL().Ru().get(68377, null);
      g.RM();
      if ((bo.a((Integer)g.RL().Ru().get(68400, null), 0) != this.rfg.CreateTime) || ((!bo.isNullOrNil((String)localObject)) && (!((String)localObject).equals(this.rfg.Username))))
      {
        g.RM();
        g.RL().Ru().set(68377, this.rfg.Username);
        g.RM();
        g.RL().Ru().set(68400, Integer.valueOf(this.rfg.CreateTime));
        g.RM();
        g.RL().Ru().set(68418, i.lq(this.rfg.Id));
        g.RM();
        g.RL().Ru().set(68419, Integer.valueOf(0));
        f.l(1, i.lq(this.rfg.Id), 0);
      }
      localObject = u.coC().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ar)((Iterator)localObject).next()).aan();
      }
    }
    this.rfh.sendEmptyMessage(0);
    AppMethodBeat.o(36299);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.1
 * JD-Core Version:    0.7.0.1
 */