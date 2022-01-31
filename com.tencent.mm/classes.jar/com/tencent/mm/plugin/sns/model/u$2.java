package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ar;
import com.tencent.mm.protocal.protobuf.cdm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.List;

final class u$2
  implements Runnable
{
  u$2(u paramu, boolean paramBoolean, cdm paramcdm, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(36300);
    if (this.rfj)
    {
      Iterator localIterator = u.coC().iterator();
      while (localIterator.hasNext())
      {
        ar localar = (ar)localIterator.next();
        ab.i("MicroMsg.NetSceneNewSyncAlbum", "notify list ");
        localar.aam();
      }
    }
    this.rfh.sendEmptyMessage(0);
    AppMethodBeat.o(36300);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.u.2
 * JD-Core Version:    0.7.0.1
 */