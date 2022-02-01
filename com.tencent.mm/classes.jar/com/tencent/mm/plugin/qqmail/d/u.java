package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.Random;

public final class u
  extends n
  implements k
{
  private f callback;
  private int dgI;
  private String filePath;
  private int hPI;
  private g idS;
  private String msgId;
  b rr;
  
  public u(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(122722);
    this.filePath = null;
    this.dgI = 0;
    this.hPI = 0;
    this.filePath = paramString1;
    this.msgId = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.idS = paramg;
    ae.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[] { this.msgId, this.filePath });
    AppMethodBeat.o(122722);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(122725);
    this.callback = paramf;
    if (bu.isNullOrNil(this.filePath))
    {
      ae.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    if (!o.fB(this.filePath))
    {
      ae.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      AppMethodBeat.o(122725);
      return -1;
    }
    if (this.hPI == 0)
    {
      this.hPI = ((int)o.aZR(this.filePath));
      ae.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.hPI) });
    }
    int i = Math.min(this.hPI - this.dgI, 32768);
    ae.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.dgI), Integer.valueOf(i) });
    paramf = o.bb(this.filePath, this.dgI, i);
    if (paramf == null)
    {
      ae.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    ae.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(paramf.length) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new ah();
    ((b.a)localObject).hQG = new ai();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((b.a)localObject).funcId = 484;
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aDS();
    localObject = (ah)this.rr.hQD.hQJ;
    ((ah)localObject).hFO = this.msgId;
    ((ah)localObject).xsB = this.hPI;
    ((ah)localObject).xsC = this.dgI;
    ((ah)localObject).xsD = i;
    ((ah)localObject).xsE = z.al(paramf);
    i = dispatch(parame, this.rr, this);
    ae.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
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
    ae.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(122723);
      return;
    }
    paramq = (ai)((b)paramq).hQE.hQJ;
    paramArrayOfByte = paramq.hFO;
    ae.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { paramq.hFO, Integer.valueOf(paramq.xsB), paramq.xrj });
    if (!paramArrayOfByte.equals(this.msgId))
    {
      AppMethodBeat.o(122723);
      return;
    }
    this.dgI = paramq.xsC;
    if (this.dgI < this.hPI)
    {
      ae.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.dgI), Integer.valueOf(this.hPI) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ae.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.callback != null) {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        if (this.idS != null) {
          this.idS.a(this.dgI, this.hPI, this);
        }
        AppMethodBeat.o(122723);
        return;
      }
    }
    paramq = paramq.xrj;
    ae.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.dgI), Integer.valueOf(this.hPI), paramq });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.idS != null) {
      this.idS.a(this.dgI, this.hPI, this);
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
    if ((bu.isNullOrNil(this.filePath)) || (!o.fB(this.filePath)))
    {
      ae.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      paramq = n.b.hRj;
      AppMethodBeat.o(122724);
      return paramq;
    }
    paramq = n.b.hRi;
    AppMethodBeat.o(122724);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.u
 * JD-Core Version:    0.7.0.1
 */