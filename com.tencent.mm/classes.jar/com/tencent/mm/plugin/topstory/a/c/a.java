package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.efq;
import com.tencent.mm.protocal.protobuf.efr;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
  extends n
  implements k
{
  private f callback;
  public String dyb;
  private b rr;
  private long szi;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88477);
    this.szi = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
    ((b.a)localObject).hQF = new efq();
    ((b.a)localObject).hQG = new efr();
    this.rr = ((b.a)localObject).aDS();
    localObject = (efq)this.rr.hQD.hQJ;
    ((efq)localObject).Ijs = paramString2;
    ((efq)localObject).dyb = paramString1;
    this.dyb = paramString1;
    AppMethodBeat.o(88477);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(88478);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(88478);
    return i;
  }
  
  public final efr esA()
  {
    return (efr)this.rr.hQE.hQJ;
  }
  
  public final int getType()
  {
    return 2582;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88479);
    ae.i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.szi) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.a
 * JD-Core Version:    0.7.0.1
 */