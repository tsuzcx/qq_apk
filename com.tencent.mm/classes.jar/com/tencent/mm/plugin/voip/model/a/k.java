package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.protocal.protobuf.cfw;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.protocal.protobuf.cth;

public final class k
  extends n<ctg, cth>
{
  public k(cfw paramcfw)
  {
    AppMethodBeat.i(4730);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ctg();
    ((b.a)localObject).fsY = new cth();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipspeedtest";
    ((b.a)localObject).funcId = 765;
    ((b.a)localObject).reqCmdId = 765;
    ((b.a)localObject).respCmdId = 1000000765;
    this.rr = ((b.a)localObject).ado();
    localObject = (ctg)this.rr.fsV.fta;
    ((ctg)localObject).wQP = paramcfw.wQP;
    ((ctg)localObject).xQo = paramcfw.xQo;
    ((ctg)localObject).wLO = paramcfw.wLO;
    ((ctg)localObject).xQp = paramcfw.xQp;
    ((ctg)localObject).xQq = paramcfw.xQq;
    ((ctg)localObject).xQr = paramcfw.xQr;
    ((ctg)localObject).xQs = paramcfw.xQs;
    ((ctg)localObject).xQt = paramcfw.xQt;
    ((ctg)localObject).xQu = paramcfw.xQu;
    ((ctg)localObject).xQv = paramcfw.xQv;
    ((ctg)localObject).xQw = paramcfw.xQw;
    ((ctg)localObject).xQx = paramcfw.xQx;
    ((ctg)localObject).xQy = paramcfw.xQy;
    AppMethodBeat.o(4730);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4731);
    k.1 local1 = new k.1(this);
    AppMethodBeat.o(4731);
    return local1;
  }
  
  public final int getType()
  {
    return 765;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.k
 * JD-Core Version:    0.7.0.1
 */