package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.nq;
import com.tencent.mm.protocal.protobuf.nr;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class h
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public h(String paramString1, LinkedList<String> paramLinkedList, int paramInt, String paramString2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51617);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new nq();
    ((b.a)localObject).hNN = new nr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
    ((b.a)localObject).funcId = 1068;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (nq)this.rr.hNK.hNQ;
    ((nq)localObject).ProductID = paramString1;
    ((nq)localObject).Scene = paramInt;
    ((nq)localObject).FIa = paramString2;
    ((nq)localObject).FHZ = paramLinkedList;
    ((nq)localObject).FIc = paramDouble2;
    ((nq)localObject).FIb = paramDouble1;
    AppMethodBeat.o(51617);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(51619);
    this.callback = paramf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.h
 * JD-Core Version:    0.7.0.1
 */