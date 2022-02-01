package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awo;
import com.tencent.mm.protocal.protobuf.awp;
import com.tencent.mm.protocal.protobuf.bqc;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.w;

public final class f
  extends w
{
  public bqc DHB;
  public bqd DHC;
  private com.tencent.mm.ak.f callback;
  public int errCode;
  private b rr;
  
  public f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71819);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new awo();
    ((b.a)localObject).hQG = new awp();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((b.a)localObject).funcId = 1130;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (awo)this.rr.hQD.hQJ;
    ((awo)localObject).dwb = paramString1;
    ((awo)localObject).GOf = paramInt1;
    ((awo)localObject).GOg = Integer.parseInt(paramString2);
    ((awo)localObject).desc = paramString3;
    ((awo)localObject).count = paramInt2;
    ((awo)localObject).scene = 13;
    ((awo)localObject).GOh = paramString4;
    ((awo)localObject).GOi = paramString5;
    ((awo)localObject).sign = paramString6;
    ((awo)localObject).GOj = paramString7;
    AppMethodBeat.o(71819);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
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
    ae.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71820);
      return;
    }
    paramString = (awp)this.rr.hQE.hQJ;
    ae.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.dxd + ",errMsg:" + paramString.dxe);
    paramInt1 = paramString.dxd;
    paramq = paramString.dxe;
    if (paramInt1 == 0)
    {
      this.DHB = paramString.GOk;
      this.DHC = paramString.GOl;
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.f
 * JD-Core Version:    0.7.0.1
 */