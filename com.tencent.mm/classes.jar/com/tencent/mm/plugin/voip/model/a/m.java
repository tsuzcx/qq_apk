package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.sdk.platformtools.ab;

public final class m
  extends n<ctm, ctn>
{
  public m(int paramInt1, csj paramcsj, byte[] paramArrayOfByte, long paramLong, int paramInt2)
  {
    AppMethodBeat.i(4736);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ctm();
    ((b.a)localObject).fsY = new ctn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipsync";
    ((b.a)localObject).funcId = 174;
    ((b.a)localObject).reqCmdId = 62;
    ((b.a)localObject).respCmdId = 1000000062;
    this.rr = ((b.a)localObject).ado();
    localObject = (ctm)this.rr.fsV.fta;
    ((ctm)localObject).wQP = paramInt1;
    ((ctm)localObject).ycC = paramcsj;
    ((ctm)localObject).wQQ = paramLong;
    ((ctm)localObject).xCG = r.Zn();
    ((ctm)localObject).wFQ = paramInt2;
    ((ctm)localObject).wFR = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte);
    ((ctm)localObject).yab = System.currentTimeMillis();
    ab.i("MicroMsg.NetSceneVoipSync", "sync timestamp: " + ((ctm)localObject).yab);
    AppMethodBeat.o(4736);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4737);
    m.1 local1 = new m.1(this);
    AppMethodBeat.o(4737);
    return local1;
  }
  
  public final int cOr()
  {
    return ((ctm)this.rr.fsV.fta).wFQ;
  }
  
  public final int getType()
  {
    return 174;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.m
 * JD-Core Version:    0.7.0.1
 */