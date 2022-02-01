package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.cqi;
import com.tencent.mm.protocal.protobuf.cqj;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.fgr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private final com.tencent.mm.an.d rr;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89765);
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      Log.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new cqi();
    ((d.a)localObject).lBV = new cqj();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((d.a)localObject).funcId = 148;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (cqi)d.b.b(this.rr.lBR);
    ((cqi)localObject).RLe = paramInt1;
    ((cqi)localObject).ScO = paramFloat1;
    ((cqi)localObject).ScP = paramFloat2;
    ((cqi)localObject).Sxt = paramInt2;
    ((cqi)localObject).Sxu = paramString1;
    ((cqi)localObject).Sxv = paramString2;
    ((cqi)localObject).Sxw = paramInt3;
    try
    {
      fgr localfgr = new fgr();
      localfgr.UGO = new eae().dc(com.tencent.mm.plugin.normsg.a.d.GxJ.fjn());
      ((cqi)localObject).RMN = new eae().dc(localfgr.toByteArray());
      label223:
      Log.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt2 + " gpsSource:" + paramInt3 + " mac" + paramString1 + " cell:" + paramString2);
      n.a(2001, paramFloat1, paramFloat2, paramInt2);
      AppMethodBeat.o(89765);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label223;
    }
  }
  
  public static boolean abO()
  {
    AppMethodBeat.i(231902);
    Long localLong = (Long)h.aHG().aHp().b(8210, null);
    long l = System.currentTimeMillis();
    if (localLong == null)
    {
      AppMethodBeat.o(231902);
      return true;
    }
    if (l > localLong.longValue())
    {
      AppMethodBeat.o(231902);
      return true;
    }
    AppMethodBeat.o(231902);
    return false;
  }
  
  public final int ZB()
  {
    AppMethodBeat.i(231901);
    int i = ((cqi)d.b.b(this.rr.lBR)).RLe;
    AppMethodBeat.o(231901);
    return i;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(89766);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(89766);
    return i;
  }
  
  public final boolean fiu()
  {
    AppMethodBeat.i(231903);
    if (((cqj)d.c.b(this.rr.lBS)).TxU == 1)
    {
      AppMethodBeat.o(231903);
      return true;
    }
    AppMethodBeat.o(231903);
    return false;
  }
  
  public final int fiv()
  {
    AppMethodBeat.i(231904);
    int i = ((cqj)d.c.b(this.rr.lBS)).TxV;
    AppMethodBeat.o(231904);
    return i;
  }
  
  public final List<cqe> fiw()
  {
    AppMethodBeat.i(89768);
    LinkedList localLinkedList = ((cqj)d.c.b(this.rr.lBS)).Tdk;
    if (localLinkedList != null)
    {
      h.aHE().aGH();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        cqe localcqe = (cqe)localIterator.next();
        a.bBt().bcn().nG(localcqe.UserName, localcqe.Tav);
      }
    }
    AppMethodBeat.o(89768);
    return localLinkedList;
  }
  
  public final int getType()
  {
    return 148;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(89767);
    Log.d("MicroMsg.NetSceneLbsP", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = (cqj)d.c.b(((com.tencent.mm.an.d)params).lBS);
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < params.Tdk.size())
    {
      j localj = new j();
      localj.username = ((cqe)params.Tdk.get(paramInt1)).UserName;
      localj.hDc = ((cqe)params.Tdk.get(paramInt1)).RIG;
      localj.lBe = ((cqe)params.Tdk.get(paramInt1)).SjI;
      localj.lBd = ((cqe)params.Tdk.get(paramInt1)).SjJ;
      localj.gg(true);
      paramArrayOfByte.add(localj);
      paramInt1 += 1;
    }
    com.tencent.mm.am.q.bhP().at(paramArrayOfByte);
    if ((ZB() == 1) || (ZB() == 3) || (ZB() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        h.aHG().aHp().i(8210, Long.valueOf(0L));
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(89767);
        return;
      }
      h.aHG().aHp().i(8210, Long.valueOf(System.currentTimeMillis() + params.TxT * 1000));
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89767);
      return;
      if (ZB() == 2) {
        h.aHG().aHp().i(8210, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.c
 * JD-Core Version:    0.7.0.1
 */