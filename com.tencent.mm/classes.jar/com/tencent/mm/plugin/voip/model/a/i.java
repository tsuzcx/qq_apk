package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.cti;

public final class i
  extends n<ctc, ctd>
{
  String TAG;
  
  public i(int paramInt, long paramLong, String paramString)
  {
    AppMethodBeat.i(4724);
    this.TAG = "MicroMsg.NetSceneVoipShutDown";
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ctc();
    ((b.a)localObject).fsY = new ctd();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipshutdown";
    ((b.a)localObject).funcId = 173;
    ((b.a)localObject).reqCmdId = 66;
    ((b.a)localObject).respCmdId = 1000000066;
    this.rr = ((b.a)localObject).ado();
    localObject = (ctc)this.rr.fsV.fta;
    ((ctc)localObject).wQP = paramInt;
    ((ctc)localObject).wQQ = paramLong;
    cti localcti = new cti();
    bwc localbwc = new bwc();
    localbwc.aoF(paramString);
    localcti.xTE = localbwc;
    ((ctc)localObject).yaW = localcti;
    ((ctc)localObject).yab = System.currentTimeMillis();
    AppMethodBeat.o(4724);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4725);
    i.1 local1 = new i.1(this);
    AppMethodBeat.o(4725);
    return local1;
  }
  
  public final int getType()
  {
    return 173;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.i
 * JD-Core Version:    0.7.0.1
 */