package com.tencent.mm.plugin.sns.model.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.b;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, int paramInt, d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(36745);
    if (9 == this.rkf.rke.rjH.rjC)
    {
      if (((f)this.rkf.rkc).Jo()) {
        c.cpW().remove(this.rkf.rke.rjH.reG);
      }
      ab.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[] { Integer.valueOf(this.fMh), this.rkf.rke.rjH.url, this.rkf.rke.rjH.cBO, Integer.valueOf(this.fyV.field_fileLength), Integer.valueOf(c.cpW().size()) });
      if ((!this.rkf.rke.rjH.rjA) || (this.fMh == 2)) {
        break label526;
      }
      if (9 != this.rkf.rke.rjH.rjC) {
        break label497;
      }
      aw.aaI(((bcs)this.rkf.rke.rjH.rbn.get(this.fyV.index)).Id);
      this.rkf.rke.DZ(this.fyV.index);
    }
    Object localObject1;
    Object localObject2;
    long l;
    for (;;)
    {
      if (9 != this.rkf.rke.rjH.rjC) {
        break label644;
      }
      localObject1 = (bcs)this.rkf.rke.rjH.rbn.get(this.fyV.index);
      localObject2 = (f)this.rkf.rkc;
      if ((((f)localObject2).Jo()) && (!((f)localObject2).edo))
      {
        ((f)localObject2).edo = true;
        l = bo.hl(this.rkf.rkd);
        ab.d("MicroMsg.SnsCdnDownloadBase", "group download, feed cost: %d.", new Object[] { Long.valueOf(l) });
        h.qsU.j(1040L, 3L, l);
        h.qsU.cT(1040, 4);
        h.qsU.j(1040L, 9L, l);
        h.qsU.j(1040L, 10L, ((f)localObject2).edn);
      }
      this.rkf.rke.rjF.a(this.fMh, (bcs)localObject1, this.rkf.rke.rjH.rjC, this.rkf.rke.rjH.rjA, this.rkf.rke.rjH.reG, this.fyV.field_fileLength, this.fyV.index, ((f)localObject2).Jo());
      AppMethodBeat.o(36745);
      return;
      c.cpW().remove(this.rkf.rke.rjH.reG);
      break;
      label497:
      aw.aaI(this.rkf.rke.rjH.cBO);
      this.rkf.rke.cpV();
      continue;
      label526:
      if ((!this.rkf.rke.rjH.rjA) && ((this.rkf.rke.rjH.rjC == 4) || (this.rkf.rke.rjH.rjC == 6)))
      {
        localObject1 = this.rkf.rke.rjH.getPath() + i.j(this.rkf.rke.cIc);
        ag.cpc().gj(this.rkf.rke.rjH.cBO, (String)localObject1);
      }
    }
    label644:
    if (1 == this.rkf.rke.rjH.rjC)
    {
      localObject1 = ag.cpa();
      localObject2 = this.rkf.rke.rjH.cBO;
      if (((b)localObject1).rdi.remove(localObject2))
      {
        l = bo.hl(this.rkf.rkd);
        ab.d("MicroMsg.SnsCdnDownloadBase", "single download cost: %d.", new Object[] { Long.valueOf(l) });
        h.qsU.j(1040L, 6L, l);
        h.qsU.cT(1040, 7);
      }
    }
    this.rkf.rke.rjF.a(this.fMh, this.rkf.rke.cIc, this.rkf.rke.rjH.rjC, this.rkf.rke.rjH.rjA, this.rkf.rke.rjH.reG, this.fyV.field_fileLength, -1, true);
    AppMethodBeat.o(36745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.c.1.1
 * JD-Core Version:    0.7.0.1
 */