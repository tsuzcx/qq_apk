package com.tencent.mm.plugin.nearby.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.protocal.protobuf.dhc;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private final com.tencent.mm.am.c rr;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89765);
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      Log.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    Object localObject1 = new c.a();
    ((c.a)localObject1).otE = new dhc();
    ((c.a)localObject1).otF = new dhd();
    ((c.a)localObject1).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((c.a)localObject1).funcId = 148;
    ((c.a)localObject1).otG = 0;
    ((c.a)localObject1).respCmdId = 0;
    this.rr = ((c.a)localObject1).bEF();
    localObject1 = (dhc)c.b.b(this.rr.otB);
    ((dhc)localObject1).YIq = paramInt1;
    ((dhc)localObject1).ZaG = paramFloat1;
    ((dhc)localObject1).ZaH = paramFloat2;
    ((dhc)localObject1).Zyl = paramInt2;
    ((dhc)localObject1).Zym = paramString1;
    ((dhc)localObject1).Zyn = paramString2;
    ((dhc)localObject1).Zyo = paramInt3;
    try
    {
      gdd localgdd = new gdd();
      localgdd.acaX = new gol().df(d.MtP.gtE());
      ((dhc)localObject1).YKb = new gol().df(localgdd.toByteArray());
      label223:
      Log.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt2 + " gpsSource:" + paramInt3 + " mac" + paramString1 + " cell:" + paramString2);
      n.a(2001, paramFloat1, paramFloat2, paramInt2);
      AppMethodBeat.o(89765);
      return;
    }
    finally
    {
      break label223;
    }
  }
  
  public static boolean aDN()
  {
    AppMethodBeat.i(262803);
    Long localLong = (Long)com.tencent.mm.kernel.h.baE().ban().d(8210, null);
    long l = System.currentTimeMillis();
    if (localLong == null)
    {
      AppMethodBeat.o(262803);
      return true;
    }
    if (l > localLong.longValue())
    {
      AppMethodBeat.o(262803);
      return true;
    }
    AppMethodBeat.o(262803);
    return false;
  }
  
  public final int bIO()
  {
    AppMethodBeat.i(262805);
    int i = ((dhc)c.b.b(this.rr.otB)).YIq;
    AppMethodBeat.o(262805);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(89766);
    this.callback = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(89766);
    return i;
  }
  
  public final int getType()
  {
    return 148;
  }
  
  public final boolean gsL()
  {
    AppMethodBeat.i(262821);
    if (((dhd)c.c.b(this.rr.otC)).aaMB == 1)
    {
      AppMethodBeat.o(262821);
      return true;
    }
    AppMethodBeat.o(262821);
    return false;
  }
  
  public final int gsM()
  {
    AppMethodBeat.i(262827);
    int i = ((dhd)c.c.b(this.rr.otC)).aaMC;
    AppMethodBeat.o(262827);
    return i;
  }
  
  public final List<dgy> gsN()
  {
    AppMethodBeat.i(89768);
    LinkedList localLinkedList = ((dhd)c.c.b(this.rr.otC)).aaqz;
    if (localLinkedList != null)
    {
      com.tencent.mm.kernel.h.baC().aZJ();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        dgy localdgy = (dgy)localIterator.next();
        a.caJ().bAc().pE(localdgy.UserName, localdgy.aant);
      }
    }
    AppMethodBeat.o(89768);
    return localLinkedList;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89767);
    Log.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (dhd)c.c.b(((com.tencent.mm.am.c)params).otC);
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < params.aaqz.size())
    {
      j localj = new j();
      localj.username = ((dgy)params.aaqz.get(paramInt1)).UserName;
      localj.jZY = ((dgy)params.aaqz.get(paramInt1)).YFH;
      localj.osN = ((dgy)params.aaqz.get(paramInt1)).ZhO;
      localj.osM = ((dgy)params.aaqz.get(paramInt1)).ZhP;
      localj.gX(true);
      paramArrayOfByte.add(localj);
      paramInt1 += 1;
    }
    q.bFE().bY(paramArrayOfByte);
    if ((bIO() == 1) || (bIO() == 3) || (bIO() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        com.tencent.mm.kernel.h.baE().ban().B(8210, Long.valueOf(0L));
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(89767);
        return;
      }
      com.tencent.mm.kernel.h.baE().ban().B(8210, Long.valueOf(System.currentTimeMillis() + params.aaMA * 1000));
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89767);
      return;
      if (bIO() == 2) {
        com.tencent.mm.kernel.h.baE().ban().B(8210, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.model.c
 * JD-Core Version:    0.7.0.1
 */