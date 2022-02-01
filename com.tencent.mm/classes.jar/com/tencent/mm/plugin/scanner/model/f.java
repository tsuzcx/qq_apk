package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.protocal.protobuf.mq;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class f
  extends n
  implements k
{
  private g callback;
  public b rr;
  
  public f(String paramString1, LinkedList<String> paramLinkedList, int paramInt, String paramString2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51617);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new mp();
    ((b.a)localObject).gUV = new mq();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
    ((b.a)localObject).funcId = 1068;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (mp)this.rr.gUS.gUX;
    ((mp)localObject).ProductID = paramString1;
    ((mp)localObject).Scene = paramInt;
    ((mp)localObject).CJC = paramString2;
    ((mp)localObject).CJB = paramLinkedList;
    ((mp)localObject).CJE = paramDouble2;
    ((mp)localObject).CJD = paramDouble1;
    AppMethodBeat.o(51617);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(51619);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(51619);
    return i;
  }
  
  public final int getType()
  {
    return 1068;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51618);
    ad.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.f
 * JD-Core Version:    0.7.0.1
 */