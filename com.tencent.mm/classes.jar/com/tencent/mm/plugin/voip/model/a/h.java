package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.voip.model.k;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.protocal.protobuf.csz;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class h
  extends n<csy, csz>
{
  public h(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(4720);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new csy();
    ((b.a)localObject).fsY = new csz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/voipRedirect";
    ((b.a)localObject).funcId = 678;
    ((b.a)localObject).reqCmdId = 240;
    ((b.a)localObject).respCmdId = 1000000240;
    this.rr = ((b.a)localObject).ado();
    localObject = (csy)this.rr.fsV.fta;
    ((csy)localObject).wQP = paramInt1;
    ((csy)localObject).wQQ = paramLong;
    ((csy)localObject).xCv = paramInt2;
    ((csy)localObject).ybZ = paramInt3;
    ((csy)localObject).yca = paramInt4;
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < paramInt4)
    {
      ctb localctb = new ctb();
      paramInt3 = paramInt2 + 1;
      localctb.yck = paramArrayOfInt[paramInt2];
      paramInt2 = paramInt3 + 1;
      localctb.ycl = paramArrayOfInt[paramInt3];
      paramInt3 = paramInt2 + 1;
      localctb.ycm = paramArrayOfInt[paramInt2];
      int j = paramInt3 + 1;
      localctb.ycn = paramArrayOfInt[paramInt3];
      paramInt2 = j + 1;
      localctb.yco = paramArrayOfInt[j];
      ((csy)localObject).ycb.add(localctb);
      paramInt1 += 1;
    }
    paramInt1 = i;
    if (this.tvE.tvj.tBN.twC != 0L) {
      paramInt1 = (int)((System.currentTimeMillis() - this.tvE.tvj.tBN.twC) / 1000L);
    }
    ((csy)localObject).ycc = paramInt1;
    AppMethodBeat.o(4720);
  }
  
  public final f cOp()
  {
    AppMethodBeat.i(4722);
    h.1 local1 = new h.1(this);
    AppMethodBeat.o(4722);
    return local1;
  }
  
  public final int getType()
  {
    return 678;
  }
  
  public final void gk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(4721);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      csz localcsz = (csz)this.rr.fsW.fta;
      if (localcsz != null) {
        ab.i("MicroMsg.Voip.Redirect", "roomId:%d, roomKey:%s, member:%d", new Object[] { Integer.valueOf(localcsz.wQP), Long.valueOf(localcsz.wQQ), Integer.valueOf(localcsz.xCv) });
      }
      AppMethodBeat.o(4721);
      return;
    }
    ab.i("MicroMsg.Voip.Redirect", "Redirect error");
    AppMethodBeat.o(4721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.a.h
 * JD-Core Version:    0.7.0.1
 */