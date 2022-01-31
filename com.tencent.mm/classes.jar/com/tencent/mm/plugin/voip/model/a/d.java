package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.csn;
import com.tencent.mm.sdk.platformtools.ab;

public final class d
  extends n<csm, csn>
{
  public d(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, byte[] paramArrayOfByte, int paramInt7)
  {
    AppMethodBeat.i(4706);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new csm();
    ((b.a)localObject).fsY = new csn();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipDoubleLinkSwitch";
    ((b.a)localObject).funcId = 249;
    ((b.a)localObject).reqCmdId = 249;
    ((b.a)localObject).respCmdId = 1000000249;
    this.rr = ((b.a)localObject).ado();
    localObject = (csm)this.rr.fsV.fta;
    ((csm)localObject).wQP = paramInt1;
    ((csm)localObject).wQQ = paramLong;
    ((csm)localObject).xCv = paramInt2;
    ((csm)localObject).yaZ = paramInt3;
    ((csm)localObject).yba = paramInt4;
    ((csm)localObject).ybb = paramInt5;
    ((csm)localObject).ybc = paramInt6;
    ((csm)localObject).ybd = 1;
    ((csm)localObject).wtq = new SKBuiltinBuffer_t().setBuffer(paramArrayOfByte, 0, paramInt7);
    AppMethodBeat.o(4706);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4708);
    d.1 local1 = new d.1(this);
    AppMethodBeat.o(4708);
    return local1;
  }
  
  public final int getType()
  {
    return 249;
  }
  
  public final void gk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4707);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      csn localcsn = (csn)cOt();
      if (localcsn != null) {
        ab.i("MicroMsg.Voip.DoubleLinkSwitch", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localcsn.wQP), Long.valueOf(localcsn.wQQ), Integer.valueOf(localcsn.xCv) });
      }
      AppMethodBeat.o(4707);
      return;
    }
    ab.i("MicroMsg.Voip.DoubleLinkSwitch", "double link switch error");
    AppMethodBeat.o(4707);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.d
 * JD-Core Version:    0.7.0.1
 */