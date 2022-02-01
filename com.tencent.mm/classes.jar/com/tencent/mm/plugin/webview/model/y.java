package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bnh;
import com.tencent.mm.protocal.protobuf.bni;
import com.tencent.mm.sdk.platformtools.ad;

public final class y
  extends n
  implements k
{
  public String AXo;
  public int AXp;
  private g gbr;
  public String ocH;
  public String ocI;
  private final b rr;
  public String sign;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78912);
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new bnh();
    ((b.a)localObject).gUV = new bni();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((b.a)localObject).funcId = 1177;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (bnh)this.rr.gUS.gUX;
    ((bnh)localObject).app_id = paramString1;
    ((bnh)localObject).DqD = paramString2;
    ((bnh)localObject).nvC = paramString3;
    AppMethodBeat.o(78912);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78914);
    this.gbr = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(78914);
    return i;
  }
  
  public final int getType()
  {
    return 1177;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(78913);
    ad.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bni)this.rr.gUT.gUX;
      this.AXo = paramq.AXo;
      this.sign = paramq.sign;
      this.ocI = paramq.ocI;
      this.ocH = paramq.ocH;
      this.AXp = paramq.AXp;
      ad.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.AXo, this.sign, this.ocI, this.ocH, Integer.valueOf(this.AXp) });
    }
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */