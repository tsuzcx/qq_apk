package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.protobuf.sq;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.protocal.q.a;
import com.tencent.mm.protocal.q.b;
import java.util.LinkedList;

public final class o
  extends n
{
  public static void aVE()
  {
    AppMethodBeat.i(79560);
    o localo = new o();
    g.RK().eHt.a(localo, 0);
    AppMethodBeat.o(79560);
  }
  
  protected final q dmr()
  {
    AppMethodBeat.i(79561);
    o.a locala = new o.a();
    q.a locala1 = (q.a)locala.getReqObjImp();
    locala1.setUin(0);
    locala1.wiE.wQN.wQL.wLe.addAll(this.vNV);
    AppMethodBeat.o(79561);
    return locala;
  }
  
  protected final String getTag()
  {
    return "MicroMsg.NetSceneEncryptCheckResUpdate";
  }
  
  public final int getType()
  {
    if (f.whQ) {
      return 784;
    }
    return 722;
  }
  
  protected final sr h(q paramq)
  {
    return ((o.a)paramq).vOa.wiH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.a.a.o
 * JD-Core Version:    0.7.0.1
 */