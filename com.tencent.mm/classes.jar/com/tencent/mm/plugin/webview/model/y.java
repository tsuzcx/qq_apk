package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.sdk.platformtools.ae;

public final class y
  extends n
  implements k
{
  public String EkZ;
  public int Ela;
  private f gCo;
  public String pqp;
  public String pqq;
  private final b rr;
  public String sign;
  
  public y(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(78912);
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new bxe();
    ((b.a)localObject).hQG = new bxf();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((b.a)localObject).funcId = 1177;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (bxe)this.rr.hQD.hQJ;
    ((bxe)localObject).app_id = paramString1;
    ((bxe)localObject).GOi = paramString2;
    ((bxe)localObject).oIy = paramString3;
    AppMethodBeat.o(78912);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(78914);
    this.gCo = paramf;
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
    ae.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bxf)this.rr.hQE.hQJ;
      this.EkZ = paramq.EkZ;
      this.sign = paramq.sign;
      this.pqq = paramq.pqq;
      this.pqp = paramq.pqp;
      this.Ela = paramq.Ela;
      ae.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.EkZ, this.sign, this.pqq, this.pqp, Integer.valueOf(this.Ela) });
    }
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(78913);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.y
 * JD-Core Version:    0.7.0.1
 */