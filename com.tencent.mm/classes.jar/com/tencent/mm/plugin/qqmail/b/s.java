package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Random;

public final class s
  extends m
  implements k
{
  private com.tencent.mm.ai.f callback;
  private int chT;
  private String clientId;
  private String czp;
  private com.tencent.mm.ai.g fFj;
  private int fsd;
  private int pJA;
  private String pJy;
  private String pJz;
  private b rr;
  
  public s(String paramString1, String paramString2, String[] paramArrayOfString, int paramInt, com.tencent.mm.ai.g paramg)
  {
    AppMethodBeat.i(67981);
    this.pJy = null;
    this.fsd = 0;
    this.clientId = null;
    this.chT = 0;
    this.pJA = 0;
    this.pJy = paramString1;
    this.pJA = paramInt;
    this.fFj = paramg;
    if (!bo.isNullOrNil(paramString1))
    {
      this.clientId = (com.tencent.mm.a.g.w(paramString1.getBytes()) + "_" + System.nanoTime() + "_" + new Random().nextInt());
      this.fsd = paramString1.getBytes().length;
      this.chT = 0;
    }
    if (!bo.isNullOrNil(paramString2)) {
      this.czp = paramString2;
    }
    if (paramArrayOfString != null)
    {
      this.pJz = "";
      int i = paramArrayOfString.length;
      paramInt = 0;
      while (paramInt < i)
      {
        paramString1 = paramArrayOfString[paramInt];
        this.pJz = (this.pJz + paramString1 + ",");
        paramInt += 1;
      }
      this.pJz = this.pJz.substring(0, this.pJz.length() - 1);
    }
    ab.i("MicroMsg.NetSceneComposeSend", "NetSceneComposeSend, clientId: %s, totalLen: %d", new Object[] { this.clientId, Integer.valueOf(this.fsd) });
    AppMethodBeat.o(67981);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(67984);
    this.callback = paramf;
    if (bo.isNullOrNil(this.pJy))
    {
      ab.e("MicroMsg.NetSceneComposeSend", "doScene, sendContent is null");
      AppMethodBeat.o(67984);
      return -1;
    }
    int k = Math.min(this.fsd - this.chT, 32768);
    ab.i("MicroMsg.NetSceneComposeSend", "doScene, dataLen: %d", new Object[] { Integer.valueOf(k) });
    paramf = new byte[k];
    Object localObject = this.pJy.getBytes();
    int i = this.chT;
    int j = 0;
    while (i < this.chT + k)
    {
      paramf[j] = localObject[i];
      j += 1;
      i += 1;
    }
    if (bo.ce(paramf))
    {
      ab.e("MicroMsg.NetSceneComposeSend", "doScene, sendData is null");
      AppMethodBeat.o(67984);
      return -1;
    }
    localObject = new b.a();
    ((b.a)localObject).fsX = new e();
    ((b.a)localObject).fsY = new f();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/composesend";
    ((b.a)localObject).funcId = 485;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).ado();
    localObject = (e)this.rr.fsV.fta;
    ((e)localObject).pIw = this.clientId;
    ((e)localObject).pIx = this.fsd;
    ((e)localObject).pIy = this.chT;
    ((e)localObject).pIz = k;
    ((e)localObject).pIB = this.czp;
    ((e)localObject).pIC = this.pJz;
    ((e)localObject).pID = ((int)(this.fsd + this.pJA * 1.333333F));
    ab.i("MicroMsg.NetSceneComposeSend", "doScene, realSize: %d", new Object[] { Integer.valueOf(((e)localObject).pID) });
    ((e)localObject).pIA = aa.ac(paramf);
    i = dispatch(parame, this.rr, this);
    ab.i("MicroMsg.NetSceneComposeSend", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(67984);
    return i;
  }
  
  public final int getType()
  {
    return 485;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(67983);
    ab.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(67983);
      return;
    }
    this.chT = ((f)((b)paramq).fsW.fta).pIy;
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.fFj != null) {
      this.fFj.a(this.chT, this.fsd, this);
    }
    if (this.chT < this.fsd)
    {
      ab.i("MicroMsg.NetSceneComposeSend", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.chT), Integer.valueOf(this.fsd) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        ab.e("MicroMsg.NetSceneComposeSend", "continue to upload fail");
        AppMethodBeat.o(67983);
      }
    }
    else
    {
      ab.i("MicroMsg.NetSceneComposeSend", "finished upload");
    }
    AppMethodBeat.o(67983);
  }
  
  public final int securityLimitCount()
  {
    return 100;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(67982);
    if (bo.isNullOrNil(this.pJy))
    {
      ab.e("MicroMsg.NetSceneComposeSend", "securityVerificationChecked failed, content is null");
      paramq = m.b.ftv;
      AppMethodBeat.o(67982);
      return paramq;
    }
    paramq = m.b.ftu;
    AppMethodBeat.o(67982);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.s
 * JD-Core Version:    0.7.0.1
 */