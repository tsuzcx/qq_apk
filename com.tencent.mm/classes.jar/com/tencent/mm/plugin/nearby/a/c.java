package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.chi;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private final com.tencent.mm.ak.d rr;
  
  public c(int paramInt1, float paramFloat1, float paramFloat2, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    AppMethodBeat.i(89765);
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4)) {
      Log.e("MicroMsg.NetSceneLbsP", "OpCode Error :".concat(String.valueOf(paramInt1)));
    }
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new chm();
    ((d.a)localObject).iLO = new chn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/lbsfind";
    ((d.a)localObject).funcId = 148;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (chm)this.rr.iLK.iLR;
    ((chm)localObject).OpCode = paramInt1;
    ((chm)localObject).LbC = paramFloat1;
    ((chm)localObject).LbD = paramFloat2;
    ((chm)localObject).LuT = paramInt2;
    ((chm)localObject).LuU = paramString1;
    ((chm)localObject).LuV = paramString2;
    ((chm)localObject).LuW = paramInt3;
    try
    {
      ewf localewf = new ewf();
      localewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.AEF.exJ());
      ((chm)localObject).KLQ = new SKBuiltinBuffer_t().setBuffer(localewf.toByteArray());
      label223:
      Log.d("MicroMsg.NetSceneLbsP", "Req: opcode:" + paramInt1 + " lon:" + paramFloat1 + " lat:" + paramFloat2 + " pre:" + paramInt2 + " gpsSource:" + paramInt3 + " mac" + paramString1 + " cell:" + paramString2);
      o.a(2001, paramFloat1, paramFloat2, paramInt2);
      AppMethodBeat.o(89765);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label223;
    }
  }
  
  public final int Vj()
  {
    return ((chm)this.rr.iLK.iLR).OpCode;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(89766);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(89766);
    return i;
  }
  
  public final boolean ewR()
  {
    return ((chn)this.rr.iLL.iLR).MmZ == 1;
  }
  
  public final int ewS()
  {
    return ((chn)this.rr.iLL.iLR).Mna;
  }
  
  public final List<chi> ewT()
  {
    AppMethodBeat.i(89768);
    LinkedList localLinkedList = ((chn)this.rr.iLL.iLR).LUC;
    if (localLinkedList != null)
    {
      com.tencent.mm.kernel.g.aAf().azk();
      Iterator localIterator = localLinkedList.iterator();
      while (localIterator.hasNext())
      {
        chi localchi = (chi)localIterator.next();
        com.tencent.mm.plugin.c.a.bqE().aTp().mP(localchi.UserName, localchi.LRO);
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
    params = (chn)((com.tencent.mm.ak.d)params).iLL.iLR;
    paramArrayOfByte = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < params.LUC.size())
    {
      com.tencent.mm.aj.i locali = new com.tencent.mm.aj.i();
      locali.username = ((chi)params.LUC.get(paramInt1)).UserName;
      locali.fuz = ((chi)params.LUC.get(paramInt1)).KHo;
      locali.iKX = ((chi)params.LUC.get(paramInt1)).Lir;
      locali.iKW = ((chi)params.LUC.get(paramInt1)).Lis;
      locali.fv(true);
      paramArrayOfByte.add(locali);
      paramInt1 += 1;
    }
    p.aYB().av(paramArrayOfByte);
    if ((Vj() == 1) || (Vj() == 3) || (Vj() == 4))
    {
      if ((paramInt2 != 0) && (paramInt3 == -2001))
      {
        com.tencent.mm.kernel.g.aAh().azQ().set(8210, Long.valueOf(0L));
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        AppMethodBeat.o(89767);
        return;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(8210, Long.valueOf(System.currentTimeMillis() + params.MmY * 1000));
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(89767);
      return;
      if (Vj() == 2) {
        com.tencent.mm.kernel.g.aAh().azQ().set(8210, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.a.c
 * JD-Core Version:    0.7.0.1
 */