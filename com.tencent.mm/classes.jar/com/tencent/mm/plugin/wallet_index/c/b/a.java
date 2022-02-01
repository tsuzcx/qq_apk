package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cex;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String BPA;
  public String BPz;
  private g callback;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71849);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new cex();
    ((b.a)localObject).hvu = new cey();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payugenprepay";
    ((b.a)localObject).funcId = 1521;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (cex)this.rr.hvr.hvw;
    ((cex)localObject).hOf = paramString1;
    ((cex)localObject).EpU = paramString4;
    ((cex)localObject).EpT = paramString3;
    ((cex)localObject).EpV = paramString5;
    ((cex)localObject).EpW = paramString2;
    ((cex)localObject).DYh = paramString6;
    ((cex)localObject).EoO = paramString7;
    ((cex)localObject).EJO = paramString8;
    ((cex)localObject).DLC = paramInt;
    ac.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8 }));
    AppMethodBeat.o(71849);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71851);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71851);
    return i;
  }
  
  public final int getType()
  {
    return 1521;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71850);
    ac.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (cey)((b)paramq).hvs.hvw;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ac.d("MicroMsg.NetScenePayUGenPrepay", "rr " + paramString.EJP);
      this.BPz = paramString.EJP;
      this.BPA = paramString.EJQ;
    }
    paramString = paramString.pAH;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b.a
 * JD-Core Version:    0.7.0.1
 */