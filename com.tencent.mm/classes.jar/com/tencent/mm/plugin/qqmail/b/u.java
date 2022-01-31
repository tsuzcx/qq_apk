package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Random;

public final class u
  extends m
  implements k
{
  private String cDC;
  private f callback;
  private int chT;
  private g fFj;
  public String filePath;
  private int fsd;
  private b rr;
  
  public u(String paramString1, String paramString2, g paramg)
  {
    AppMethodBeat.i(67988);
    this.filePath = null;
    this.chT = 0;
    this.fsd = 0;
    this.filePath = paramString1;
    this.cDC = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.fFj = paramg;
    ab.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[] { this.cDC, this.filePath });
    AppMethodBeat.o(67988);
  }
  
  public final ah cdJ()
  {
    if (this.rr != null) {
      return (ah)this.rr.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(67991);
    this.callback = paramf;
    if (bo.isNullOrNil(this.filePath))
    {
      ab.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
      AppMethodBeat.o(67991);
      return -1;
    }
    if (!com.tencent.mm.vfs.e.cN(this.filePath))
    {
      ab.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      AppMethodBeat.o(67991);
      return -1;
    }
    if (this.fsd == 0)
    {
      this.fsd = ((int)com.tencent.mm.vfs.e.avI(this.filePath));
      ab.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.fsd) });
    }
    int i = Math.min(this.fsd - this.chT, 32768);
    ab.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.chT), Integer.valueOf(i) });
    paramf = com.tencent.mm.vfs.e.i(this.filePath, this.chT, i);
    if (paramf == null)
    {
      ab.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      AppMethodBeat.o(67991);
      return -1;
    }
    ab.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(paramf.length) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new ag();
    ((b.a)localObject).fsY = new ah();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((b.a)localObject).funcId = 484;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (ag)this.rr.fsV.fta;
    ((ag)localObject).pIw = this.cDC;
    ((ag)localObject).pIx = this.fsd;
    ((ag)localObject).pIy = this.chT;
    ((ag)localObject).pIz = i;
    ((ag)localObject).pIA = aa.ac(paramf);
    i = dispatch(parame, this.rr, this);
    ab.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(67991);
    return i;
  }
  
  public final int getType()
  {
    return 484;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67989);
    ab.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(67989);
      return;
    }
    paramq = (ah)((b)paramq).fsW.fta;
    paramArrayOfByte = paramq.pIw;
    ab.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { paramq.pIw, Integer.valueOf(paramq.pIx), paramq.pIF });
    if (!paramArrayOfByte.equals(this.cDC))
    {
      AppMethodBeat.o(67989);
      return;
    }
    this.chT = paramq.pIy;
    if (this.chT < this.fsd)
    {
      ab.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.chT), Integer.valueOf(this.fsd) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ab.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.callback != null) {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        if (this.fFj != null) {
          this.fFj.a(this.chT, this.fsd, this);
        }
        AppMethodBeat.o(67989);
        return;
      }
    }
    paramq = paramq.pIF;
    ab.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.chT), Integer.valueOf(this.fsd), paramq });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.fFj != null) {
      this.fFj.a(this.chT, this.fsd, this);
    }
    AppMethodBeat.o(67989);
  }
  
  public final int securityLimitCount()
  {
    return 640;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(67990);
    if ((bo.isNullOrNil(this.filePath)) || (!com.tencent.mm.vfs.e.cN(this.filePath)))
    {
      ab.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      paramq = m.b.ftv;
      AppMethodBeat.o(67990);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(67990);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.u
 * JD-Core Version:    0.7.0.1
 */