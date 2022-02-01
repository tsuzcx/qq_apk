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
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.ow;
import com.tencent.mm.protocal.protobuf.ox;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;

public final class m
  extends n
  implements k
{
  private f callback;
  private b rr;
  
  public m(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(51631);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ow();
    ((b.a)localObject).hNN = new ox();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanproductreport";
    ((b.a)localObject).funcId = 1064;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ow)this.rr.hNK.hNQ;
    ((ow)localObject).gsM = d.Fne;
    ((ow)localObject).gsN = d.Fnd;
    ((ow)localObject).gsO = d.Fng;
    ((ow)localObject).gsP = d.Fnh;
    ((ow)localObject).gsQ = ac.fks();
    ((ow)localObject).gsR = 11294;
    ((ow)localObject).gsS = null;
    ((ow)localObject).ymf = paramString1;
    ((ow)localObject).yme = paramString2;
    ((ow)localObject).type = paramInt1;
    ((ow)localObject).value = paramString3;
    ((ow)localObject).count = paramInt2;
    ((ow)localObject).wzc = paramInt3;
    ad.v("MircoMsg.NetSceneScanProductReport", "statid:".concat(String.valueOf(paramString2)));
    AppMethodBeat.o(51631);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(51633);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(51633);
    return i;
  }
  
  public final int getType()
  {
    return 1064;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(51632);
    ad.d("MircoMsg.NetSceneScanProductReport", "errType = " + paramInt2 + ", errCode = " + paramInt3);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(51632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.m
 * JD-Core Version:    0.7.0.1
 */