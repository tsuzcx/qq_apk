package com.tencent.mm.plugin.profile.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.am;
import com.tencent.mm.protocal.protobuf.anf;
import com.tencent.mm.protocal.protobuf.ang;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
  extends m
  implements k
{
  private f callback;
  public String errMsg;
  public ang pxN;
  public final b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(23281);
    ab.i("MicroMsg.NetSceneGetOpenUrl", "NetSceneGetOpenUrl username:%s ticket:%s climsgid:%s content:%s ", new Object[] { paramString1, paramString2, paramString3, paramString4 });
    Object localObject = new b.a();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getopenurl";
    ((b.a)localObject).funcId = 913;
    ((b.a)localObject).fsX = new anf();
    ((b.a)localObject).fsY = new ang();
    this.rr = ((b.a)localObject).ado();
    localObject = (anf)this.rr.fsV.fta;
    ((anf)localObject).scene = 1;
    am localam = new am();
    localam.username = paramString1;
    localam.crs = paramString2;
    localam.pxP = paramString3;
    localam.content = paramString4;
    ((anf)localObject).xdH = localam;
    AppMethodBeat.o(23281);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(23282);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(23282);
    return i;
  }
  
  public final int getType()
  {
    return 913;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23283);
    ab.d("MicroMsg.NetSceneGetOpenUrl", "onGYNetEnd:[%d,%d,%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    this.errMsg = paramString;
    AppMethodBeat.o(23283);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.b.a
 * JD-Core Version:    0.7.0.1
 */