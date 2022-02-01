package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
{
  public cky Pjy;
  public ckz Pjz;
  private i callback;
  public int errCode;
  private d rr;
  
  public g(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(272266);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new bpj();
    ((d.a)localObject).lBV = new bpk();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((d.a)localObject).funcId = 1130;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (bpj)d.b.b(this.rr.lBR);
    ((bpj)localObject).appid = paramString1;
    ((bpj)localObject).TaU = paramInt1;
    ((bpj)localObject).TaV = Integer.parseInt(paramString2);
    ((bpj)localObject).desc = paramString3;
    ((bpj)localObject).count = paramInt2;
    ((bpj)localObject).scene = 13;
    ((bpj)localObject).TaW = paramString4;
    ((bpj)localObject).TaX = paramString5;
    ((bpj)localObject).sign = paramString6;
    ((bpj)localObject).TaY = paramString7;
    ((bpj)localObject).MFj = paramString8;
    AppMethodBeat.o(272266);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(71821);
    this.callback = parami;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(71821);
    return i;
  }
  
  public final int getType()
  {
    return 1130;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte, long paramLong)
  {
    AppMethodBeat.i(71820);
    Log.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71820);
      return;
    }
    paramString = (bpk)d.c.b(this.rr.lBS);
    Log.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.fHV + ",errMsg:" + paramString.fHW);
    paramInt1 = paramString.fHV;
    params = paramString.fHW;
    if (paramInt1 == 0)
    {
      this.Pjy = paramString.Tba;
      this.Pjz = paramString.Tbb;
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.g
 * JD-Core Version:    0.7.0.1
 */