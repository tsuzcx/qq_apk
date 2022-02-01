package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
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

public final class u
  extends n
  implements k
{
  private f callback;
  private int dfG;
  private String filePath;
  private int hMP;
  private g iaZ;
  private String msgId;
  b rr;
  
  public u(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(122722);
    this.filePath = null;
    this.dfG = 0;
    this.hMP = 0;
    this.filePath = paramString1;
    this.msgId = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.iaZ = paramg;
    ad.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[] { this.msgId, this.filePath });
    AppMethodBeat.o(122722);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(122725);
    this.callback = paramf;
    if (bt.isNullOrNil(this.filePath))
    {
      ad.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    if (!i.fv(this.filePath))
    {
      ad.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      AppMethodBeat.o(122725);
      return -1;
    }
    if (this.hMP == 0)
    {
      this.hMP = ((int)i.aYo(this.filePath));
      ad.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.hMP) });
    }
    int i = Math.min(this.hMP - this.dfG, 32768);
    ad.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.dfG), Integer.valueOf(i) });
    paramf = i.aY(this.filePath, this.dfG, i);
    if (paramf == null)
    {
      ad.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    ad.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(paramf.length) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new ah();
    ((b.a)localObject).hNN = new ai();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((b.a)localObject).funcId = 484;
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDC();
    localObject = (ah)this.rr.hNK.hNQ;
    ((ah)localObject).hCW = this.msgId;
    ((ah)localObject).xcK = this.hMP;
    ((ah)localObject).xcL = this.dfG;
    ((ah)localObject).xcM = i;
    ((ah)localObject).xcN = z.al(paramf);
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
    paramq = (ai)((b)paramq).hNL.hNQ;
    paramArrayOfByte = paramq.hCW;
    ad.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { paramq.hCW, Integer.valueOf(paramq.xcK), paramq.xbs });
    if (!paramArrayOfByte.equals(this.msgId))
    {
      AppMethodBeat.o(122723);
      return;
    }
    this.dfG = paramq.xcL;
    if (this.dfG < this.hMP)
    {
      ad.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.dfG), Integer.valueOf(this.hMP) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ad.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.callback != null) {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        if (this.iaZ != null) {
          this.iaZ.a(this.dfG, this.hMP, this);
        }
        AppMethodBeat.o(122723);
        return;
      }
    }
    paramq = paramq.xbs;
    ad.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.dfG), Integer.valueOf(this.hMP), paramq });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.iaZ != null) {
      this.iaZ.a(this.dfG, this.hMP, this);
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
    if ((bt.isNullOrNil(this.filePath)) || (!i.fv(this.filePath)))
    {
      ad.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      paramq = n.b.hOq;
      AppMethodBeat.o(122724);
      return paramq;
    }
    paramq = n.b.hOp;
    AppMethodBeat.o(122724);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.u
 * JD-Core Version:    0.7.0.1
 */