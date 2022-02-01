package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.sdk.platformtools.Log;

public final class y
  extends q
  implements m
{
  public String IXX;
  public int IXY;
  private i heq;
  public String qFU;
  public String qFV;
  private final d rr;
  public String sign;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78912);
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ckw();
    ((d.a)localObject).iLO = new ckx();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((d.a)localObject).funcId = 1177;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ckw)this.rr.iLK.iLR;
    ((ckw)localObject).app_id = paramString1;
    ((ckw)localObject).GaP = paramString2;
    ((ckw)localObject).pWm = paramString3;
    AppMethodBeat.o(78912);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(78914);
    this.heq = parami;
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
      params = (ckx)this.rr.iLL.iLR;
      this.IXX = params.IXX;
      this.sign = params.sign;
      this.qFV = params.qFV;
      this.qFU = params.qFU;
      this.IXY = params.IXY;
      Log.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.IXX, this.sign, this.qFV, this.qFU, Integer.valueOf(this.IXY) });
    }
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */