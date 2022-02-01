package com.tencent.mm.plugin.topstory.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.faa;
import com.tencent.mm.protocal.protobuf.fab;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
  extends q
  implements m
{
  private i callback;
  public String dPI;
  private d rr;
  private long uOV;
  
  public a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(88477);
    this.uOV = System.currentTimeMillis();
    Object localObject = new d.a();
    ((d.a)localObject).funcId = getType();
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchwebcomm";
    ((d.a)localObject).iLN = new faa();
    ((d.a)localObject).iLO = new fab();
    this.rr = ((d.a)localObject).aXF();
    localObject = (faa)this.rr.iLK.iLR;
    ((faa)localObject).NvY = paramString2;
    ((faa)localObject).dPI = paramString1;
    this.dPI = paramString1;
    AppMethodBeat.o(88477);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(88478);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(88478);
    return i;
  }
  
  public final fab fxY()
  {
    return (fab)this.rr.iLL.iLR;
  }
  
  public final int getType()
  {
    return 2582;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(88479);
    Log.i("MicroMsg.TopStory.NetSceneSearchWebComm", "netId %d | errType %d | errCode %d | errMsg %s useTime %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(System.currentTimeMillis() - this.uOV) });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(88479);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.a.c.a
 * JD-Core Version:    0.7.0.1
 */