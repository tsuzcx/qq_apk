package com.tencent.mm.plugin.wallet_index.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ecw;
import com.tencent.mm.protocal.protobuf.ecx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class a
  extends w
{
  public String Wam;
  public String Wan;
  private h callback;
  private c rr;
  
  public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, int paramInt)
  {
    AppMethodBeat.i(71849);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ecw();
    ((c.a)localObject).otF = new ecx();
    ((c.a)localObject).uri = "/cgi-bin/mmpay-bin/payugenprepay";
    ((c.a)localObject).funcId = 1521;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ecw)c.b.b(this.rr.otB);
    ((ecw)localObject).oOI = paramString1;
    ((ecw)localObject).ZjJ = paramString4;
    ((ecw)localObject).ZjI = paramString3;
    ((ecw)localObject).ZjK = paramString5;
    ((ecw)localObject).ZjL = paramString2;
    ((ecw)localObject).YNW = paramString6;
    ((ecw)localObject).ZiL = paramString7;
    ((ecw)localObject).aalN = paramString8;
    ((ecw)localObject).YJZ = paramInt;
    Log.d("MicroMsg.NetScenePayUGenPrepay", String.format("appid:%s,packageExt:%s,nonceStr:%s,paySignature:%s,signtype:%s,timeStamp:%s,url:%s,bizUsername:%s,", new Object[] { paramString1, paramString4, paramString3, paramString5, paramString2, paramString6, paramString7, paramString8 }));
    AppMethodBeat.o(71849);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(71851);
    this.callback = paramh;
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
    paramString = (ecx)c.c.b(((c)params).otC);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      Log.d("MicroMsg.NetScenePayUGenPrepay", "rr " + paramString.aalO);
      this.Wam = paramString.aalO;
      this.Wan = paramString.aalP;
    }
    paramString = paramString.ytw;
    this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(71850);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.b.a
 * JD-Core Version:    0.7.0.1
 */