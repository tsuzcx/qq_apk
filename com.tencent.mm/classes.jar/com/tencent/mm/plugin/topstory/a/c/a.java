package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.edz;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
  extends n
  implements k
{
  private f callback;
  public String dwW;
  private b rr;
  private long soX;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88477);
    this.soX = System.currentTimeMillis();
    Object localObject = new b.a();
    ((b.a)localObject).funcId = getType();
    ((b.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
    ((b.a)localObject).hNM = new edz();
    ((b.a)localObject).hNN = new eea();
    this.rr = ((b.a)localObject).aDC();
    localObject = (edz)this.rr.hNK.hNQ;
    ((edz)localObject).HPl = paramString2;
    ((edz)localObject).dwW = paramString1;
    this.dwW = paramString1;
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
  
  public final eea eoT()
  {
    return (eea)this.rr.hNL.hNQ;
  }
  
  public final int getType()
  {
    return 2582;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88479);
    ad.i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.soX) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.a
 * JD-Core Version:    0.7.0.1
 */