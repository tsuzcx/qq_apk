package com.tencent.mm.plugin.scanner.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.protocal.protobuf.nt;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class i
  extends n
  implements k
{
  private f callback;
  public b rr;
  
  public i(String paramString1, LinkedList<String> paramLinkedList, int paramInt, String paramString2, double paramDouble1, double paramDouble2)
  {
    AppMethodBeat.i(51617);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ns();
    ((b.a)localObject).hQG = new nt();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
    ((b.a)localObject).funcId = 1068;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ns)this.rr.hQD.hQJ;
    ((ns)localObject).ProductID = paramString1;
    ((ns)localObject).Scene = paramInt;
    ((ns)localObject).Gaw = paramString2;
    ((ns)localObject).Gav = paramLinkedList;
    ((ns)localObject).Gay = paramDouble2;
    ((ns)localObject).Gax = paramDouble1;
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
    ae.i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + paramInt2 + " errcode:" + paramInt3 + " errMsg:" + paramString);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51618);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.i
 * JD-Core Version:    0.7.0.1
 */