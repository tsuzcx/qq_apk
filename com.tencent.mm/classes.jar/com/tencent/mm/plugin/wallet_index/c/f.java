package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.asa;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.w;

public final class f
  extends w
{
  public bla BPD;
  public blb BPE;
  private g callback;
  public int errCode;
  private b rr;
  
  public f(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71819);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new asa();
    ((b.a)localObject).hvu = new asb();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((b.a)localObject).funcId = 1130;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (asa)this.rr.hvr.hvw;
    ((asa)localObject).djj = paramString1;
    ((asa)localObject).ELC = paramInt1;
    ((asa)localObject).ELD = Integer.parseInt(paramString2);
    ((asa)localObject).desc = paramString3;
    ((asa)localObject).count = paramInt2;
    ((asa)localObject).scene = 13;
    ((asa)localObject).ELE = paramString4;
    ((asa)localObject).ELF = paramString5;
    ((asa)localObject).sign = paramString6;
    ((asa)localObject).ELG = paramString7;
    AppMethodBeat.o(71819);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(71821);
    this.callback = paramg;
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
    ac.e("MicroMsg.NetSceneGetAndroidIapPackage", "ErrType:" + paramInt2 + ",errCode:" + paramInt3 + ",errMsg:" + paramString);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(71820);
      return;
    }
    paramString = (asb)this.rr.hvs.hvw;
    ac.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.dkl + ",errMsg:" + paramString.dkm);
    paramInt1 = paramString.dkl;
    paramq = paramString.dkm;
    if (paramInt1 == 0)
    {
      this.BPD = paramString.ELH;
      this.BPE = paramString.ELI;
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, paramq, this);
    AppMethodBeat.o(71820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.f
 * JD-Core Version:    0.7.0.1
 */