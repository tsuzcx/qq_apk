package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.qp;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.aa;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.ae;
import com.tencent.mm.modelvideo.ae.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/report/VideoPlayReporter;", "", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "fileName", "", "isRawVideo", "", "type", "", "(Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;ZI)V", "reporter", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoPlayReportStruct;", "startLoadingRawTime", "", "startPlayTime", "endLoadingOrigin", "", "report", "startLoadingOrigin", "startPlay", "stopPlay", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a aeJq;
  private final boolean aeAh;
  public long aeJr;
  public final qp aeJs;
  private final String fileName;
  private final cc hzO;
  public long ork;
  private final int type;
  
  static
  {
    AppMethodBeat.i(253983);
    aeJq = new e.a((byte)0);
    AppMethodBeat.o(253983);
  }
  
  public e(cc paramcc, String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(253978);
    this.hzO = paramcc;
    this.fileName = paramString;
    this.aeAh = paramBoolean;
    this.type = paramInt;
    this.aeJs = new qp();
    AppMethodBeat.o(253978);
  }
  
  public final void jwR()
  {
    AppMethodBeat.i(253986);
    this.aeJs.jtm = a.ai((float)(System.currentTimeMillis() - this.aeJr) / 1000.0F);
    AppMethodBeat.o(253986);
  }
  
  public final void report()
  {
    long l2 = 1L;
    long l3 = 0L;
    int k = 1;
    int j = 1;
    AppMethodBeat.i(253992);
    if (this.hzO == null)
    {
      AppMethodBeat.o(253992);
      return;
    }
    if (this.fileName == null)
    {
      AppMethodBeat.o(253992);
      return;
    }
    com.tencent.mm.modelvideo.z localz = ab.Qo(this.fileName);
    if (localz == null)
    {
      AppMethodBeat.o(253992);
      return;
    }
    Object localObject1 = ae.pbN;
    localObject1 = ae.a.Qv(localz.bOu());
    int i;
    Object localObject2;
    long l1;
    if (this.hzO.field_isSend == 1)
    {
      i = 1;
      boolean bool = au.bwG(this.hzO.field_talker);
      localObject2 = ((n)h.ax(n.class)).bzA().JE(this.hzO.field_talker);
      this.aeJs.xO(((au)localObject2).aSV());
      localObject2 = this.aeJs;
      if (!bool) {
        break label379;
      }
      l1 = 1L;
      label155:
      ((qp)localObject2).iNl = l1;
      this.aeJs.iCW = localz.omT;
      localObject2 = this.aeJs;
      com.tencent.mm.modelvideo.v.bOh();
      ((qp)localObject2).jtk = y.bEl(aa.PX(this.fileName));
      if (localObject1 != null)
      {
        localObject2 = this.aeJs;
        if (!((ae)localObject1).pbO) {
          break label385;
        }
        l1 = l3;
        label223:
        ((qp)localObject2).iSD = l1;
        this.aeJs.jto = ((ae)localObject1).nVD;
        localObject2 = this.aeJs;
        if (!this.aeAh) {
          break label396;
        }
        localObject1 = ((ae)localObject1).pbQ;
        label262:
        ((qp)localObject2).xN((String)localObject1);
      }
      switch (this.type)
      {
      default: 
        label308:
        if (bool) {
          this.aeJs.imZ = com.tencent.mm.model.v.getMembersCountByChatRoomName(this.hzO.field_talker);
        }
        localObject2 = this.aeJs;
        if (i == 0) {
          break;
        }
      }
    }
    for (localObject1 = com.tencent.mm.model.z.bAM();; localObject1 = this.hzO.field_talker)
    {
      ((qp)localObject2).xP((String)localObject1);
      this.aeJs.bMH();
      ab.f(localz);
      AppMethodBeat.o(253992);
      return;
      i = 0;
      break;
      label379:
      l1 = 0L;
      break label155;
      label385:
      l1 = ((ae)localObject1).pbT;
      break label223;
      label396:
      localObject1 = ((ae)localObject1).pbR;
      break label262;
      if (!localz.bOz())
      {
        label414:
        localObject1 = this.aeJs;
        if (j == 0) {
          break label452;
        }
      }
      label452:
      for (l1 = l2;; l1 = 3L)
      {
        ((qp)localObject1).ikE = l1;
        if (j == 0) {
          break;
        }
        localz.bOA();
        break;
        j = 0;
        break label414;
      }
      this.aeJs.ikE = 6L;
      break label308;
      this.aeJs.ikE = 5L;
      break label308;
      this.aeJs.ikE = 4L;
      break label308;
      if (!localz.bOz())
      {
        j = k;
        label509:
        localObject1 = this.aeJs;
        if (j == 0) {
          break label548;
        }
      }
      label548:
      for (l1 = 2L;; l1 = 3L)
      {
        ((qp)localObject1).ikE = l1;
        if (j == 0) {
          break;
        }
        localz.bOA();
        break;
        j = 0;
        break label509;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.e
 * JD-Core Version:    0.7.0.1
 */