package com.tencent.mm.plugin.websearch.api;

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
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.sdk.platformtools.ac;

public final class u
  extends n
  implements k
{
  public bsx BYE;
  private int BYF;
  public int businessType;
  private g callback;
  public String dlj;
  public int drc;
  private b hEg;
  public int scene;
  
  public u(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2)
  {
    AppMethodBeat.i(117638);
    this.scene = paramInt1;
    this.BYF = paramInt3;
    this.drc = paramInt4;
    this.businessType = paramInt2;
    this.dlj = paramString2;
    ac.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    paramString2 = new b.a();
    paramString2.funcId = 1048;
    paramString2.uri = "/cgi-bin/mmsearch-bin/searchguide";
    paramString2.hvt = new bsw();
    paramString2.hvu = new bsx();
    this.hEg = paramString2.aAz();
    paramString2 = (bsw)this.hEg.hvr.hvw;
    paramString2.Scene = paramInt1;
    paramString2.FhS = paramInt3;
    paramString2.FhT = z.bJn();
    paramString2.DUM = paramInt2;
    paramString2.pAD = paramString1;
    paramString2.FhU = paramLong;
    AppMethodBeat.o(117638);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(117639);
    this.callback = paramg;
    int i = dispatch(parame, this.hEg, this);
    AppMethodBeat.o(117639);
    return i;
  }
  
  public final int getType()
  {
    return 1048;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117640);
    ac.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117640);
      return;
    }
    this.BYE = ((bsx)this.hEg.hvs.hvw);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.u
 * JD-Core Version:    0.7.0.1
 */