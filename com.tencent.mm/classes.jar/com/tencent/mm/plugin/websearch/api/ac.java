package com.tencent.mm.plugin.websearch.api;

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
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.sdk.platformtools.Log;

public final class ac
  extends q
  implements m
{
  public clw IEi;
  private int IEj;
  public int businessType;
  private i callback;
  public String dPI;
  public int dVL;
  private d iUB;
  public int scene;
  public String sessionId;
  
  public ac(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(187841);
    this.scene = paramInt1;
    this.IEj = paramInt3;
    this.dVL = paramInt4;
    this.businessType = paramInt2;
    this.dPI = paramString2;
    this.sessionId = paramString3;
    Log.i("MicroMsg.FTS.NetSceneWebSearchGuide", "scene %d, h5Version=%d type=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    Object localObject = new d.a();
    ((d.a)localObject).funcId = 1048;
    ((d.a)localObject).uri = "/cgi-bin/mmsearch-bin/searchguide";
    ((d.a)localObject).iLN = new clv();
    ((d.a)localObject).iLO = new clw();
    this.iUB = ((d.a)localObject).aXF();
    localObject = (clv)this.iUB.iLK.iLR;
    ((clv)localObject).Scene = paramInt1;
    ((clv)localObject).MaY = paramInt3;
    ((clv)localObject).MlQ = ai.clJ();
    ((clv)localObject).xMB = paramInt2;
    ((clv)localObject).rBI = paramString1;
    ((clv)localObject).Mri = paramLong;
    ((clv)localObject).SessionId = paramString3;
    ((clv)localObject).Mrj = paramString4;
    ((clv)localObject).MlR = ai.fYd();
    ah.c(paramInt1, paramString3, "", "", paramString2, paramInt2);
    AppMethodBeat.o(187841);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(117639);
    this.callback = parami;
    int i = dispatch(paramg, this.iUB, this);
    AppMethodBeat.o(117639);
    return i;
  }
  
  public final int getType()
  {
    return 1048;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117640);
    Log.i("MicroMsg.FTS.NetSceneWebSearchGuide", "netId %d | errType %d | errCode %d | errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(117640);
      return;
    }
    this.IEi = ((clw)this.iUB.iLL.iLR);
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(117640);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.api.ac
 * JD-Core Version:    0.7.0.1
 */