package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.dxz;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
  extends n
  implements k
{
  private g callback;
  public String dlj;
  private b rr;
  private long rxC;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88477);
    this.rxC = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
    ((b.a)localObject).hvt = new dxz();
    ((b.a)localObject).hvu = new dya();
    this.rr = ((b.a)localObject).aAz();
    localObject = (dxz)this.rr.hvr.hvw;
    ((dxz)localObject).Gef = paramString2;
    ((dxz)localObject).dlj = paramString1;
    this.dlj = paramString1;
    AppMethodBeat.o(88477);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(88478);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88478);
    return i;
  }
  
  public final dya ecC()
  {
    return (dya)this.rr.hvs.hvw;
  }
  
  public final int getType()
  {
    return 2582;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88479);
    ac.i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.rxC) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.a
 * JD-Core Version:    0.7.0.1
 */