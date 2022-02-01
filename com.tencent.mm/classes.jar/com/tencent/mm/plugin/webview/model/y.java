package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.sdk.platformtools.ac;

public final class y
  extends n
  implements k
{
  public String CpB;
  public int CpC;
  private g gfX;
  public String oGg;
  public String oGh;
  private final b rr;
  public String sign;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78912);
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new brx();
    ((b.a)localObject).hvu = new bry();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((b.a)localObject).funcId = 1177;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (brx)this.rr.hvr.hvw;
    ((brx)localObject).app_id = paramString1;
    ((brx)localObject).ELF = paramString2;
    ((brx)localObject).nYC = paramString3;
    AppMethodBeat.o(78912);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(78914);
    this.gfX = paramg;
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
    ac.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bry)this.rr.hvs.hvw;
      this.CpB = paramq.CpB;
      this.sign = paramq.sign;
      this.oGh = paramq.oGh;
      this.oGg = paramq.oGg;
      this.CpC = paramq.CpC;
      ac.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.CpB, this.sign, this.oGh, this.oGg, Integer.valueOf(this.CpC) });
    }
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */