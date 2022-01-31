package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.sdk.platformtools.ab;

public final class x
  extends m
  implements k
{
  private f eGj;
  public String kVV;
  public String kVW;
  private final b rr;
  public String sign;
  public String uVJ;
  public int uVK;
  
  public x(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(6628);
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new bbi();
    ((b.a)localObject).fsY = new bbj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
    ((b.a)localObject).funcId = 1177;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (bbi)this.rr.fsV.fta;
    ((bbi)localObject).app_id = paramString1;
    ((bbi)localObject).wYQ = paramString2;
    ((bbi)localObject).kqi = paramString3;
    AppMethodBeat.o(6628);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(6630);
    this.eGj = paramf;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(6630);
    return i;
  }
  
  public final int getType()
  {
    return 1177;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(6629);
    ab.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (bbj)this.rr.fsW.fta;
      this.uVJ = paramq.uVJ;
      this.sign = paramq.sign;
      this.kVW = paramq.kVW;
      this.kVV = paramq.kVV;
      this.uVK = paramq.uVK;
      ab.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[] { this.uVJ, this.sign, this.kVW, this.kVV, Integer.valueOf(this.uVK) });
    }
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(6629);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.x
 * JD-Core Version:    0.7.0.1
 */