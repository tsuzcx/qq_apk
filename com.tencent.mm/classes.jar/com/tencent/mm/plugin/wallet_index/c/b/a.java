package com.tencent.mm.plugin.wallet_index.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dkm;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class a
  extends w
{
  public String Pju;
  public String Pjv;
  private i callback;
  private d rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71849);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new dkm();
    ((d.a)localObject).lBV = new dkn();
    ((d.a)localObject).uri = "/cgi-bin/mmpay-bin/payugenprepay";
    ((d.a)localObject).funcId = 1521;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (dkm)d.b.b(this.rr.lBR);
    ((dkm)localObject).lVG = paramString1;
    ((dkm)localObject).Slz = paramString4;
    ((dkm)localObject).Sly = paramString3;
    ((dkm)localObject).SlA = paramString5;
    ((dkm)localObject).SlB = paramString2;
    ((dkm)localObject).RQH = paramString6;
    ((dkm)localObject).SkB = paramString7;
    ((dkm)localObject).SYV = paramString8;
    ((dkm)localObject).RML = paramInt;
    Log.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8 }));
    AppMethodBeat.o(71849);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(71851);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71851);
    return i;
  }
  
  public final int getType()
  {
    return 1521;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71850);
    Log.d("MicroMsg.NetScenePayUGenPrepay", "errType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg" + paramString);
    paramString = (dkn)d.c.b(((d)params).lBS);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetScenePayUGenPrepay", "rr " + paramString.SYW);
      this.Pju = paramString.SYW;
      this.Pjv = paramString.SYX;
    }
    paramString = paramString.vhu;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.b.a
 * JD-Core Version:    0.7.0.1
 */