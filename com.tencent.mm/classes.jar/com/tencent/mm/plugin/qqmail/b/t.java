package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Random;

public final class t
  extends n
  implements k
{
  private int cUq;
  private com.tencent.mm.ak.g callback;
  private String clientId;
  private String dng;
  private h hIl;
  private int hux;
  private b rr;
  private String vUH;
  private String vUI;
  private int vUJ;
  
  public t(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt, h paramh)
  {
    AppMethodBeat.i(122715);
    this.vUH = null;
    this.hux = 0;
    this.clientId = null;
    this.cUq = 0;
    this.vUJ = 0;
    this.vUH = paramString1;
    this.vUJ = paramInt;
    this.hIl = paramh;
    if (!bs.isNullOrNil(paramString1))
    {
      this.clientId = (com.tencent.mm.b.g.getMessageDigest(paramString1.getBytes()) + "_" + System.nanoTime() + "_" + new Random().nextInt());
      this.hux = paramString1.getBytes().length;
      this.cUq = 0;
    }
    if (!bs.isNullOrNil(paramString2)) {
      this.dng = paramString2;
    }
    if (paramArrayOfString != null)
    {
      this.vUI = "";
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramString1 = paramArrayOfString[paramInt];
        this.vUI = (this.vUI + paramString1 + ",");
        paramInt += 1;
      }
      this.vUI = this.vUI.substring(0, this.vUI.length() - 1);
    }
    ac.i("MicroMsg.NetSceneComposeSend", "NetSceneComposeSend, clientId: %s, totalLen: %d", new Object[] { this.clientId, Integer.valueOf(this.hux) });
    AppMethodBeat.o(122715);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(122718);
    this.callback = paramg;
    if (bs.isNullOrNil(this.vUH))
    {
      ac.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
      AppMethodBeat.o(122718);
      return -1;
    }
    int k = Math.min(this.hux - this.cUq, 32768);
    ac.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", new Object[] { Integer.valueOf(k) });
    paramg = new byte[k];
    Object localObject = this.vUH.getBytes();
    int i = this.cUq;
    int j = 0;
    while (i < this.cUq + k)
    {
      paramg[j] = localObject[i];
      j += 1;
      i += 1;
    }
    if (bs.cv(paramg))
    {
      ac.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
      AppMethodBeat.o(122718);
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).hvt = new e();
    ((b.a)localObject).hvu = new f();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/composesend";
    ((b.a)localObject).funcId = 485;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (e)this.rr.hvr.hvw;
    ((e)localObject).hkN = this.clientId;
    ((e)localObject).vTH = this.hux;
    ((e)localObject).vTI = this.cUq;
    ((e)localObject).vTJ = k;
    ((e)localObject).vTL = this.dng;
    ((e)localObject).vTM = this.vUI;
    ((e)localObject).vTN = ((int)(this.hux + this.vUJ * 1.333333F));
    ac.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", new Object[] { Integer.valueOf(((e)localObject).vTN) });
    ((e)localObject).vTK = z.al(paramg);
    i = dispatch(parame, this.rr, this);
    ac.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
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
    ac.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(122717);
      return;
    }
    this.cUq = ((f)((b)paramq).hvs.hvw).vTI;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.hIl != null) {
      this.hIl.a(this.cUq, this.hux, this);
    }
    if (this.cUq < this.hux)
    {
      ac.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.cUq), Integer.valueOf(this.hux) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ac.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
        AppMethodBeat.o(122717);
      }
    }
    else
    {
      ac.i("MicroMsg.NetSceneComposeSend", "finished upload");
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
    if (bs.isNullOrNil(this.vUH))
    {
      ac.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
      paramq = n.b.hwb;
      AppMethodBeat.o(122716);
      return paramq;
    }
    paramq = n.b.hwa;
    AppMethodBeat.o(122716);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.t
 * JD-Core Version:    0.7.0.1
 */