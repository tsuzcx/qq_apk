package com.tencent.mm.plugin.wallet_index.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.protocal.protobuf.dbf;
import com.tencent.mm.protocal.protobuf.dbg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.w;

public final class g
  extends w
{
  public dbf Waq;
  public dbg War;
  private h callback;
  public int errCode;
  private c rr;
  
  public g(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    AppMethodBeat.i(263684);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new cea();
    ((c.a)localObject).otF = new ceb();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/boss/getandroidiappackage";
    ((c.a)localObject).funcId = 1130;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (cea)c.b.b(this.rr.otB);
    ((cea)localObject).appid = paramString1;
    ((cea)localObject).aaog = paramInt1;
    ((cea)localObject).aaoh = Integer.parseInt(paramString2);
    ((cea)localObject).desc = paramString3;
    ((cea)localObject).count = paramInt2;
    ((cea)localObject).scene = 13;
    ((cea)localObject).aaoi = paramString4;
    ((cea)localObject).aaoj = paramString5;
    ((cea)localObject).sign = paramString6;
    ((cea)localObject).aaok = paramString7;
    ((cea)localObject).ext_info = paramString8;
    AppMethodBeat.o(263684);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, h paramh)
  {
    AppMethodBeat.i(71821);
    this.callback = paramh;
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
    paramString = (ceb)c.c.b(this.rr.otC);
    Log.e("MicroMsg.NetSceneGetAndroidIapPackage", "business: errCode:" + paramString.hNv + ",errMsg:" + paramString.hNw);
    paramInt1 = paramString.hNv;
    params = paramString.hNw;
    if (paramInt1 == 0)
    {
      this.Waq = paramString.aaom;
      this.War = paramString.aaon;
    }
    this.callback.onSceneEnd(paramInt2, paramInt1, params, this);
    AppMethodBeat.o(71820);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.model.g
 * JD-Core Version:    0.7.0.1
 */