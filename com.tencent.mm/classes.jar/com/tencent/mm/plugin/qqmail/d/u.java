package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.j;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Random;

public final class u
  extends q
  implements m
{
  private int bPt;
  private i callback;
  private String filePath;
  private int lAW;
  private j lPi;
  private String msgId;
  private d rr;
  
  public u(String paramString1, String paramString2, j paramj)
  {
    AppMethodBeat.i(122722);
    this.filePath = null;
    this.bPt = 0;
    this.lAW = 0;
    this.filePath = paramString1;
    this.msgId = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.lPi = paramj;
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
    if (!com.tencent.mm.vfs.u.agG(this.filePath))
    {
      Log.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      AppMethodBeat.o(122725);
      return -1;
    }
    if (this.lAW == 0)
    {
      this.lAW = ((int)com.tencent.mm.vfs.u.bBQ(this.filePath));
      Log.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.lAW) });
    }
    int i = Math.min(this.lAW - this.bPt, 32768);
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.bPt), Integer.valueOf(i) });
    parami = com.tencent.mm.vfs.u.aY(this.filePath, this.bPt, i);
    if (parami == null)
    {
      Log.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(parami.length) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ah();
    ((d.a)localObject).lBV = new ai();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((d.a)localObject).funcId = 484;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.rr = ((d.a)localObject).bgN();
    localObject = (ah)d.b.b(this.rr.lBR);
    ((ah)localObject).lps = this.msgId;
    ((ah)localObject).HmZ = this.lAW;
    ((ah)localObject).Hna = this.bPt;
    ((ah)localObject).Hnb = i;
    ((ah)localObject).Hnc = z.aN(parami);
    i = dispatch(paramg, this.rr, this);
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122725);
    return i;
  }
  
  public final ai fsr()
  {
    AppMethodBeat.i(250004);
    if (this.rr != null)
    {
      ai localai = (ai)d.c.b(this.rr.lBS);
      AppMethodBeat.o(250004);
      return localai;
    }
    AppMethodBeat.o(250004);
    return null;
  }
  
  public final int getType()
  {
    return 484;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
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
    params = (ai)d.c.b(((d)params).lBS);
    paramArrayOfByte = params.lps;
    Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { params.lps, Integer.valueOf(params.HmZ), params.HlF });
    if (!paramArrayOfByte.equals(this.msgId))
    {
      AppMethodBeat.o(122723);
      return;
    }
    this.bPt = params.Hna;
    if (this.bPt < this.lAW)
    {
      Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.bPt), Integer.valueOf(this.lAW) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        Log.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.callback != null) {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        if (this.lPi != null) {
          this.lPi.a(this.bPt, this.lAW, this);
        }
        AppMethodBeat.o(122723);
        return;
      }
    }
    params = params.HlF;
    Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.bPt), Integer.valueOf(this.lAW), params });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.lPi != null) {
      this.lPi.a(this.bPt, this.lAW, this);
    }
    AppMethodBeat.o(122723);
  }
  
  public final int securityLimitCount()
  {
    return 640;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(122724);
    if ((Util.isNullOrNil(this.filePath)) || (!com.tencent.mm.vfs.u.agG(this.filePath)))
    {
      Log.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      params = q.b.lCy;
      AppMethodBeat.o(122724);
      return params;
    }
    params = q.b.lCx;
    AppMethodBeat.o(122724);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.u
 * JD-Core Version:    0.7.0.1
 */