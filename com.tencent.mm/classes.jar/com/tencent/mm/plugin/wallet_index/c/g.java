package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.w;

public final class g
  extends w
{
  public ccu IqP;
  public ccv IqQ;
  private i callback;
  public int errCode;
  private d rr;
  
  public g(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    AppMethodBeat.i(71819);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new bhy();
    ((d.a)localObject).iLO = new bhz();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((d.a)localObject).funcId = 1130;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (bhy)this.rr.iLK.iLR;
    ((bhy)localObject).dNI = paramString1;
    ((bhy)localObject).LSk = paramInt1;
    ((bhy)localObject).LSl = Integer.parseInt(paramString2);
    ((bhy)localObject).desc = paramString3;
    ((bhy)localObject).count = paramInt2;
    ((bhy)localObject).scene = 13;
    ((bhy)localObject).LSm = paramString4;
    ((bhy)localObject).GaP = paramString5;
    ((bhy)localObject).sign = paramString6;
    ((bhy)localObject).LSn = paramString7;
    AppMethodBeat.o(71819);
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
    paramString = (bhz)this.rr.iLL.iLR;
    Log.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.dOK + ",errMsg:" + paramString.dOL);
    paramInt1 = paramString.dOK;
    params = paramString.dOL;
    if (paramInt1 == 0)
    {
      this.IqP = paramString.LSo;
      this.IqQ = paramString.LSp;
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.g
 * JD-Core Version:    0.7.0.1
 */