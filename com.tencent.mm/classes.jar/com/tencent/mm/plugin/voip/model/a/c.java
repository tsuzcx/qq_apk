package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.cti;

public final class c
  extends n<csg, csh>
{
  public c(int paramInt1, long paramLong, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(4702);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new csg();
    ((b.a)localObject).fsY = new csh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipcancelinvite";
    ((b.a)localObject).funcId = 171;
    ((b.a)localObject).reqCmdId = 64;
    ((b.a)localObject).respCmdId = 1000000064;
    this.rr = ((b.a)localObject).ado();
    localObject = (csg)this.rr.fsV.fta;
    ((csg)localObject).wQP = paramInt1;
    ((csg)localObject).wQQ = paramLong;
    ((csg)localObject).nul = paramString1;
    ((csg)localObject).xCk = paramInt2;
    paramString1 = new cti();
    bwc localbwc = new bwc();
    localbwc.aoF(paramString2);
    paramString1.xTE = localbwc;
    ((csg)localObject).yaW = paramString1;
    ((csg)localObject).yab = System.currentTimeMillis();
    AppMethodBeat.o(4702);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4704);
    c.1 local1 = new c.1(this);
    AppMethodBeat.o(4704);
    return local1;
  }
  
  public final int cOq()
  {
    AppMethodBeat.i(4703);
    csg localcsg = (csg)cOu();
    if ((localcsg.wQP == 0) && (localcsg.xCk == 0))
    {
      AppMethodBeat.o(4703);
      return -1;
    }
    AppMethodBeat.o(4703);
    return 0;
  }
  
  public final int getType()
  {
    return 171;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.c
 * JD-Core Version:    0.7.0.1
 */