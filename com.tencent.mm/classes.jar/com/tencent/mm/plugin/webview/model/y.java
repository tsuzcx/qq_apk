package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bwl;
import com.tencent.mm.sdk.platformtools.ad;

public final class y
  extends n
  implements k
{
  public String DSZ;
  public int DTa;
  private f gzH;
  public String pjK;
  public String pjL;
  private final b rr;
  public String sign;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78912);
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new bwk();
    ((b.a)localObject).hNN = new bwl();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((b.a)localObject).funcId = 1177;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (bwk)this.rr.hNK.hNQ;
    ((bwk)localObject).app_id = paramString1;
    ((bwk)localObject).GuJ = paramString2;
    ((bwk)localObject).oBW = paramString3;
    AppMethodBeat.o(78912);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78914);
    this.gzH = paramf;
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
      paramq = (bwl)this.rr.hNL.hNQ;
      this.DSZ = paramq.DSZ;
      this.sign = paramq.sign;
      this.pjL = paramq.pjL;
      this.pjK = paramq.pjK;
      this.DTa = paramq.DTa;
      ad.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.DSZ, this.sign, this.pjL, this.pjK, Integer.valueOf(this.DTa) });
    }
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */