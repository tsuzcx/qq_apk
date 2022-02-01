package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.protocal.protobuf.ctq;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  public String PUo;
  public int PUp;
  private i jQg;
  private final d rr;
  public String sign;
  public String ueW;
  public String ueX;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78912);
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ctp();
    ((d.a)localObject).lBV = new ctq();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((d.a)localObject).funcId = 1177;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ctp)d.b.b(this.rr.lBR);
    ((ctp)localObject).app_id = paramString1;
    ((ctp)localObject).TaX = paramString2;
    ((ctp)localObject).tsk = paramString3;
    AppMethodBeat.o(78912);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78914);
    this.jQg = parami;
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
      params = (ctq)d.c.b(this.rr.lBS);
      this.PUo = params.PUo;
      this.sign = params.sign;
      this.ueX = params.ueX;
      this.ueW = params.ueW;
      this.PUp = params.PUp;
      Log.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.PUo, this.sign, this.ueX, this.ueW, Integer.valueOf(this.PUp) });
    }
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */