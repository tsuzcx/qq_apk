package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Random;

public final class u
  extends q
  implements m
{
  private int bNu;
  private i callback;
  private String filePath;
  private int iKP;
  private j iYO;
  private String msgId;
  d rr;
  
  public u(String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(122722);
    this.filePath = null;
    this.bNu = 0;
    this.iKP = 0;
    this.filePath = paramString1;
    this.msgId = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.iYO = paramj;
    Log.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[] { this.msgId, this.filePath });
    AppMethodBeat.o(122722);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(122725);
    this.callback = parami;
    if (Util.isNullOrNil(this.filePath))
    {
      Log.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    if (!com.tencent.mm.vfs.s.YS(this.filePath))
    {
      Log.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      AppMethodBeat.o(122725);
      return -1;
    }
    if (this.iKP == 0)
    {
      this.iKP = ((int)com.tencent.mm.vfs.s.boW(this.filePath));
      Log.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.iKP) });
    }
    int i = Math.min(this.iKP - this.bNu, 32768);
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.bNu), Integer.valueOf(i) });
    parami = com.tencent.mm.vfs.s.aW(this.filePath, this.bNu, i);
    if (parami == null)
    {
      Log.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(parami.length) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new ah();
    ((d.a)localObject).iLO = new ai();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((d.a)localObject).funcId = 484;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).aXF();
    localObject = (ah)this.rr.iLK.iLR;
    ((ah)localObject).izX = this.msgId;
    ((ah)localObject).BsF = this.iKP;
    ((ah)localObject).BsG = this.bNu;
    ((ah)localObject).BsH = i;
    ((ah)localObject).BsI = z.aC(parami);
    i = dispatch(paramg, this.rr, this);
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122725);
    return i;
  }
  
  public final int getType()
  {
    return 484;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(122723);
    Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if (this.callback != null) {
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      }
      AppMethodBeat.o(122723);
      return;
    }
    params = (ai)((d)params).iLL.iLR;
    paramArrayOfByte = params.izX;
    Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { params.izX, Integer.valueOf(params.BsF), params.Brm });
    if (!paramArrayOfByte.equals(this.msgId))
    {
      AppMethodBeat.o(122723);
      return;
    }
    this.bNu = params.BsG;
    if (this.bNu < this.iKP)
    {
      Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.bNu), Integer.valueOf(this.iKP) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        Log.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.callback != null) {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        if (this.iYO != null) {
          this.iYO.a(this.bNu, this.iKP, this);
        }
        AppMethodBeat.o(122723);
        return;
      }
    }
    params = params.Brm;
    Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.bNu), Integer.valueOf(this.iKP), params });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.iYO != null) {
      this.iYO.a(this.bNu, this.iKP, this);
    }
    AppMethodBeat.o(122723);
  }
  
  public final int securityLimitCount()
  {
    return 640;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(122724);
    if ((Util.isNullOrNil(this.filePath)) || (!com.tencent.mm.vfs.s.YS(this.filePath)))
    {
      Log.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      params = q.b.iMr;
      AppMethodBeat.o(122724);
      return params;
    }
    params = q.b.iMq;
    AppMethodBeat.o(122724);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.u
 * JD-Core Version:    0.7.0.1
 */