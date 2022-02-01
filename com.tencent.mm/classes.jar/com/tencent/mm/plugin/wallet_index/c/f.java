package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.avz;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.w;

public final class f
  extends w
{
  public bpk DpV;
  public bpl DpW;
  private com.tencent.mm.al.f callback;
  public int errCode;
  private b rr;
  
  public f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71819);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new avy();
    ((b.a)localObject).hNN = new avz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((b.a)localObject).funcId = 1130;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (avy)this.rr.hNK.hNQ;
    ((avy)localObject).duW = paramString1;
    ((avy)localObject).GuG = paramInt1;
    ((avy)localObject).GuH = Integer.parseInt(paramString2);
    ((avy)localObject).desc = paramString3;
    ((avy)localObject).count = paramInt2;
    ((avy)localObject).scene = 13;
    ((avy)localObject).GuI = paramString4;
    ((avy)localObject).GuJ = paramString5;
    ((avy)localObject).sign = paramString6;
    ((avy)localObject).GuK = paramString7;
    AppMethodBeat.o(71819);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(71821);
    this.callback = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(71821);
    return i;
  }
  
  public final int getType()
  {
    return 1130;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71820);
    ad.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71820);
      return;
    }
    paramString = (avz)this.rr.hNL.hNQ;
    ad.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.dvY + ",errMsg:" + paramString.dvZ);
    paramInt1 = paramString.dvY;
    paramq = paramString.dvZ;
    if (paramInt1 == 0)
    {
      this.DpV = paramString.GuL;
      this.DpW = paramString.GuM;
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.f
 * JD-Core Version:    0.7.0.1
 */