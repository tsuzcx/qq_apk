package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckq;
import com.tencent.mm.protocal.protobuf.ckr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String DHx;
  public String DHy;
  private f callback;
  private b rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71849);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ckq();
    ((b.a)localObject).hQG = new ckr();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payugenprepay";
    ((b.a)localObject).funcId = 1521;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ckq)this.rr.hQD.hQJ;
    ((ckq)localObject).ikm = paramString1;
    ((ckq)localObject).GpE = paramString4;
    ((ckq)localObject).GpD = paramString3;
    ((ckq)localObject).GpF = paramString5;
    ((ckq)localObject).GpG = paramString2;
    ((ckq)localObject).FVY = paramString6;
    ((ckq)localObject).Goz = paramString7;
    ((ckq)localObject).GMo = paramString8;
    ((ckq)localObject).FJf = paramInt;
    ae.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8 }));
    AppMethodBeat.o(71849);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(71851);
    this.callback = paramf;
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
    ae.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (ckr)((b)paramq).hQE.hQJ;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ae.d("MicroMsg.NetScenePayUGenPrepay", "rr " + paramString.GMp);
      this.DHx = paramString.GMp;
      this.DHy = paramString.GMq;
    }
    paramString = paramString.qkR;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b.a
 * JD-Core Version:    0.7.0.1
 */