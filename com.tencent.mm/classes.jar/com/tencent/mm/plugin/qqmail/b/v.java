package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.util.Random;

public final class v
  extends n
  implements k
{
  private int cUq;
  private g callback;
  private String dtG;
  public String filePath;
  private h hIl;
  private int hux;
  private b rr;
  
  public v(String paramString1, String paramString2, h paramh)
  {
    AppMethodBeat.i(122722);
    this.filePath = null;
    this.cUq = 0;
    this.hux = 0;
    this.filePath = paramString1;
    this.dtG = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.hIl = paramh;
    ac.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[] { this.dtG, this.filePath });
    AppMethodBeat.o(122722);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(122725);
    this.callback = paramg;
    if (bs.isNullOrNil(this.filePath))
    {
      ac.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    if (!i.eA(this.filePath))
    {
      ac.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      AppMethodBeat.o(122725);
      return -1;
    }
    if (this.hux == 0)
    {
      this.hux = ((int)i.aSp(this.filePath));
      ac.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.hux) });
    }
    int i = Math.min(this.hux - this.cUq, 32768);
    ac.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.cUq), Integer.valueOf(i) });
    paramg = i.aU(this.filePath, this.cUq, i);
    if (paramg == null)
    {
      ac.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    ac.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(paramg.length) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new ah();
    ((b.a)localObject).hvu = new ai();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((b.a)localObject).funcId = 484;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (ah)this.rr.hvr.hvw;
    ((ah)localObject).hkN = this.dtG;
    ((ah)localObject).vTH = this.hux;
    ((ah)localObject).vTI = this.cUq;
    ((ah)localObject).vTJ = i;
    ((ah)localObject).vTK = z.al(paramg);
    i = dispatch(parame, this.rr, this);
    ac.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122725);
    return i;
  }
  
  public final ai drJ()
  {
    if (this.rr != null) {
      return (ai)this.rr.hvs.hvw;
    }
    return null;
  }
  
  public final int getType()
  {
    return 484;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122723);
    ac.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(122723);
      return;
    }
    paramq = (ai)((b)paramq).hvs.hvw;
    paramArrayOfByte = paramq.hkN;
    ac.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { paramq.hkN, Integer.valueOf(paramq.vTH), paramq.vTP });
    if (!paramArrayOfByte.equals(this.dtG))
    {
      AppMethodBeat.o(122723);
      return;
    }
    this.cUq = paramq.vTI;
    if (this.cUq < this.hux)
    {
      ac.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.cUq), Integer.valueOf(this.hux) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ac.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.callback != null) {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        if (this.hIl != null) {
          this.hIl.a(this.cUq, this.hux, this);
        }
        AppMethodBeat.o(122723);
        return;
      }
    }
    paramq = paramq.vTP;
    ac.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.cUq), Integer.valueOf(this.hux), paramq });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hIl != null) {
      this.hIl.a(this.cUq, this.hux, this);
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
    if ((bs.isNullOrNil(this.filePath)) || (!i.eA(this.filePath)))
    {
      ac.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      paramq = n.b.hwb;
      AppMethodBeat.o(122724);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(122724);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.v
 * JD-Core Version:    0.7.0.1
 */