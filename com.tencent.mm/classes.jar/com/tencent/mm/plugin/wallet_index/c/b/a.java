package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.blx;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.u;

public final class a
  extends u
{
  private f callback;
  private b rr;
  public String uAd;
  public String uAe;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(48215);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new blx();
    ((b.a)localObject).fsY = new bly();
    ((b.a)localObject).uri = "/cgi-bin/mmpay-bin/payugenprepay";
    ((b.a)localObject).funcId = 1521;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (blx)this.rr.fsV.fta;
    ((blx)localObject).fKw = paramString1;
    ((blx)localObject).wKW = paramString4;
    ((blx)localObject).wKV = paramString3;
    ((blx)localObject).wKX = paramString5;
    ((blx)localObject).wKY = paramString2;
    ((blx)localObject).wvC = paramString6;
    ((blx)localObject).wJT = paramString7;
    ((blx)localObject).wXP = paramString8;
    ((blx)localObject).wkX = paramInt;
    ab.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8 }));
    AppMethodBeat.o(48215);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(48217);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(48217);
    return i;
  }
  
  public final int getType()
  {
    return 1521;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(142586);
    ab.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (bly)((b)paramq).fsW.fta;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ab.d("MicroMsg.NetScenePayUGenPrepay", "rr " + paramString.wXQ);
      this.uAd = paramString.wXQ;
      this.uAe = paramString.wXR;
    }
    paramString = paramString.lGL;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(142586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b.a
 * JD-Core Version:    0.7.0.1
 */