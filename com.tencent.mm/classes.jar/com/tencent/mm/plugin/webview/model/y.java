package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dks;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends p
  implements m
{
  public String WLa;
  public int WLb;
  private h mAY;
  private final c rr;
  public String sign;
  public String xkX;
  public String xkY;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78912);
    Object localObject = new c.a();
    ((c.a)localObject).otE = new dkr();
    ((c.a)localObject).otF = new dks();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((c.a)localObject).funcId = 1177;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (dkr)c.b.b(this.rr.otB);
    ((dkr)localObject).app_id = paramString1;
    ((dkr)localObject).aaoj = paramString2;
    ((dkr)localObject).wwH = paramString3;
    AppMethodBeat.o(78912);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(78914);
    this.mAY = paramh;
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(78914);
    return i;
  }
  
  public final int getType()
  {
    return 1177;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78913);
    Log.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = (dks)c.c.b(this.rr.otC);
      this.WLa = params.WLa;
      this.sign = params.sign;
      this.xkY = params.xkY;
      this.xkX = params.xkX;
      this.WLb = params.WLb;
      Log.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.WLa, this.sign, this.xkY, this.xkX, Integer.valueOf(this.WLb) });
    }
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */