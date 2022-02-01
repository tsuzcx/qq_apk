package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.c;
import com.tencent.mm.protocal.protobuf.bul;
import com.tencent.mm.protocal.protobuf.bum;

public final class i
  extends c<bum>
{
  public i(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(68406);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bul();
    ((b.a)localObject).gUV = new bum();
    ((b.a)localObject).funcId = 2585;
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/onclickpurchase";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localObject = ((b.a)localObject).atI();
    bul localbul = (bul)((b)localObject).gUS.gUX;
    localbul.CYU = paramInt1;
    localbul.zFN = paramInt2;
    localbul.zFY = ae.dYR();
    this.rr = ((b)localObject);
    AppMethodBeat.o(68406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.i
 * JD-Core Version:    0.7.0.1
 */