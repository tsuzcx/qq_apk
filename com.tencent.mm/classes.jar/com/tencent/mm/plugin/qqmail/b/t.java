package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.h;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Random;

public final class t
  extends n
  implements k
{
  private int cWU;
  private com.tencent.mm.al.g callback;
  private String clientId;
  private String dpv;
  private int gTY;
  private h hhI;
  private b rr;
  private String uLR;
  private String uLS;
  private int uLT;
  
  public t(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt, h paramh)
  {
    AppMethodBeat.i(122715);
    this.uLR = null;
    this.gTY = 0;
    this.clientId = null;
    this.cWU = 0;
    this.uLT = 0;
    this.uLR = paramString1;
    this.uLT = paramInt;
    this.hhI = paramh;
    if (!bt.isNullOrNil(paramString1))
    {
      this.clientId = (com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) + "_" + System.nanoTime() + "_" + new Random().nextInt());
      this.gTY = paramString1.getBytes().length;
      this.cWU = 0;
    }
    if (!bt.isNullOrNil(paramString2)) {
      this.dpv = paramString2;
    }
    if (paramArrayOfString != null)
    {
      this.uLS = "";
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramString1 = paramArrayOfString[paramInt];
        this.uLS = (this.uLS + paramString1 + ",");
        paramInt += 1;
      }
      this.uLS = this.uLS.substring(0, this.uLS.length() - 1);
    }
    ad.i("MicroMsg.NetSceneComposeSend", "NetSceneComposeSend, clientId: %s, totalLen: %d", new Object[] { this.clientId, Integer.valueOf(this.gTY) });
    AppMethodBeat.o(122715);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(122718);
    this.callback = paramg;
    if (bt.isNullOrNil(this.uLR))
    {
      ad.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
      AppMethodBeat.o(122718);
      return -1;
    }
    int k = Math.min(this.gTY - this.cWU, 32768);
    ad.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", new Object[] { Integer.valueOf(k) });
    paramg = new byte[k];
    Object localObject = this.uLR.getBytes();
    int i = this.cWU;
    int j = 0;
    while (i < this.cWU + k)
    {
      paramg[j] = localObject[i];
      j += 1;
      i += 1;
    }
    if (bt.cw(paramg))
    {
      ad.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
      AppMethodBeat.o(122718);
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).gUU = new e();
    ((b.a)localObject).gUV = new f();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/composesend";
    ((b.a)localObject).funcId = 485;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (e)this.rr.gUS.gUX;
    ((e)localObject).gKn = this.clientId;
    ((e)localObject).uKQ = this.gTY;
    ((e)localObject).uKR = this.cWU;
    ((e)localObject).uKS = k;
    ((e)localObject).uKU = this.dpv;
    ((e)localObject).uKV = this.uLS;
    ((e)localObject).uKW = ((int)(this.gTY + this.uLT * 1.333333F));
    ad.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", new Object[] { Integer.valueOf(((e)localObject).uKW) });
    ((e)localObject).uKT = z.am(paramg);
    i = dispatch(parame, this.rr, this);
    ad.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122718);
    return i;
  }
  
  public final int getType()
  {
    return 485;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122717);
    ad.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(122717);
      return;
    }
    this.cWU = ((f)((b)paramq).gUT.gUX).uKR;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hhI != null) {
      this.hhI.a(this.cWU, this.gTY, this);
    }
    if (this.cWU < this.gTY)
    {
      ad.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.cWU), Integer.valueOf(this.gTY) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ad.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
        AppMethodBeat.o(122717);
      }
    }
    else
    {
      ad.i("MicroMsg.NetSceneComposeSend", "finished upload");
    }
    AppMethodBeat.o(122717);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(122716);
    if (bt.isNullOrNil(this.uLR))
    {
      ad.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
      paramq = n.b.gVC;
      AppMethodBeat.o(122716);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(122716);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.t
 * JD-Core Version:    0.7.0.1
 */