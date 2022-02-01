package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.h;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.util.Random;

public final class v
  extends n
  implements k
{
  private int cWU;
  private g callback;
  private String dvT;
  public String filePath;
  private int gTY;
  private h hhI;
  private b rr;
  
  public v(String paramString1, String paramString2, h paramh)
  {
    AppMethodBeat.i(122722);
    this.filePath = null;
    this.cWU = 0;
    this.gTY = 0;
    this.filePath = paramString1;
    this.dvT = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.hhI = paramh;
    ad.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[] { this.dvT, this.filePath });
    AppMethodBeat.o(122722);
  }
  
  public final ai deb()
  {
    if (this.rr != null) {
      return (ai)this.rr.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(122725);
    this.callback = paramg;
    if (bt.isNullOrNil(this.filePath))
    {
      ad.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    if (!i.eK(this.filePath))
    {
      ad.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      AppMethodBeat.o(122725);
      return -1;
    }
    if (this.gTY == 0)
    {
      this.gTY = ((int)i.aMN(this.filePath));
      ad.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.gTY) });
    }
    int i = Math.min(this.gTY - this.cWU, 32768);
    ad.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.cWU), Integer.valueOf(i) });
    paramg = i.aR(this.filePath, this.cWU, i);
    if (paramg == null)
    {
      ad.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    ad.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(paramg.length) });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new ah();
    ((b.a)localObject).gUV = new ai();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((b.a)localObject).funcId = 484;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).atI();
    localObject = (ah)this.rr.gUS.gUX;
    ((ah)localObject).gKn = this.dvT;
    ((ah)localObject).uKQ = this.gTY;
    ((ah)localObject).uKR = this.cWU;
    ((ah)localObject).uKS = i;
    ((ah)localObject).uKT = z.am(paramg);
    i = dispatch(parame, this.rr, this);
    ad.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122725);
    return i;
  }
  
  public final int getType()
  {
    return 484;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122723);
    ad.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(122723);
      return;
    }
    paramq = (ai)((b)paramq).gUT.gUX;
    paramArrayOfByte = paramq.gKn;
    ad.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { paramq.gKn, Integer.valueOf(paramq.uKQ), paramq.uKY });
    if (!paramArrayOfByte.equals(this.dvT))
    {
      AppMethodBeat.o(122723);
      return;
    }
    this.cWU = paramq.uKR;
    if (this.cWU < this.gTY)
    {
      ad.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.cWU), Integer.valueOf(this.gTY) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ad.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.callback != null) {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        if (this.hhI != null) {
          this.hhI.a(this.cWU, this.gTY, this);
        }
        AppMethodBeat.o(122723);
        return;
      }
    }
    paramq = paramq.uKY;
    ad.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.cWU), Integer.valueOf(this.gTY), paramq });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hhI != null) {
      this.hhI.a(this.cWU, this.gTY, this);
    }
    AppMethodBeat.o(122723);
  }
  
  public final int securityLimitCount()
  {
    return 640;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(122724);
    if ((bt.isNullOrNil(this.filePath)) || (!i.eK(this.filePath)))
    {
      ad.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      paramq = n.b.gVC;
      AppMethodBeat.o(122724);
      return paramq;
    }
    paramq = n.b.gVB;
    AppMethodBeat.o(122724);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v
 * JD-Core Version:    0.7.0.1
 */