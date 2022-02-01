package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.i;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Random;

public final class t
  extends p
  implements m
{
  private h callback;
  private int dIY;
  private String filePath;
  private String msgId;
  private i oHS;
  private int osy;
  private c rr;
  
  public t(String paramString1, String paramString2, i parami)
  {
    AppMethodBeat.i(122722);
    this.filePath = null;
    this.dIY = 0;
    this.osy = 0;
    this.filePath = paramString1;
    this.msgId = (paramString2 + "_" + System.nanoTime() + "_" + Math.abs(new Random().nextInt() / 2));
    this.oHS = parami;
    Log.i("MicroMsg.NetSceneUploadFie", "msgId: %s, filePath: %s", new Object[] { this.msgId, this.filePath });
    AppMethodBeat.o(122722);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(122725);
    this.callback = paramh;
    if (Util.isNullOrNil(this.filePath))
    {
      Log.e("MicroMsg.NetSceneUploadFie", "doScene, filePath is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    if (!y.ZC(this.filePath))
    {
      Log.e("MicroMsg.NetSceneUploadFie", "doScene, file: %s not exist", new Object[] { this.filePath });
      AppMethodBeat.o(122725);
      return -1;
    }
    if (this.osy == 0)
    {
      this.osy = ((int)y.bEl(this.filePath));
      Log.i("MicroMsg.NetSceneUploadFie", "doScene, totalLen: %d", new Object[] { Integer.valueOf(this.osy) });
    }
    int i = Math.min(this.osy - this.dIY, 32768);
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, startPos: %d, dataLen: %d", new Object[] { Integer.valueOf(this.dIY), Integer.valueOf(i) });
    paramh = y.bi(this.filePath, this.dIY, i);
    if (paramh == null)
    {
      Log.e("MicroMsg.NetSceneUploadFie", "doScene, read file buf is null");
      AppMethodBeat.o(122725);
      return -1;
    }
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, buf.length: %d", new Object[] { Integer.valueOf(paramh.length) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new ag();
    ((c.a)localObject).otF = new ah();
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadfile";
    ((c.a)localObject).funcId = 484;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.rr = ((c.a)localObject).bEF();
    localObject = (ag)c.b.b(this.rr.otB);
    ((ag)localObject).nUv = this.msgId;
    ((ag)localObject).NkN = this.osy;
    ((ag)localObject).NkO = this.dIY;
    ((ag)localObject).NkP = i;
    ((ag)localObject).NkQ = w.aN(paramh);
    i = dispatch(paramg, this.rr, this);
    Log.i("MicroMsg.NetSceneUploadFie", "doScene, ret: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122725);
    return i;
  }
  
  public final ah gDZ()
  {
    AppMethodBeat.i(267086);
    if (this.rr != null)
    {
      ah localah = (ah)c.c.b(this.rr.otC);
      AppMethodBeat.o(267086);
      return localah;
    }
    AppMethodBeat.o(267086);
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
    params = (ah)c.c.b(((c)params).otC);
    paramArrayOfByte = params.nUv;
    Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, clientId: %s, totalLen: %d, attachId: %s", new Object[] { params.nUv, Integer.valueOf(params.NkN), params.Njt });
    if (!paramArrayOfByte.equals(this.msgId))
    {
      AppMethodBeat.o(122723);
      return;
    }
    this.dIY = params.NkO;
    if (this.dIY < this.osy)
    {
      Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, startPos: %d, totalLen: %d, continue to upload", new Object[] { Integer.valueOf(this.dIY), Integer.valueOf(this.osy) });
      if (doScene(dispatcher(), this.callback) < 0)
      {
        Log.e("MicroMsg.NetSceneUploadFie", "continue to upload fail");
        if (this.callback != null) {
          this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        }
        if (this.oHS != null) {
          this.oHS.a(this.dIY, this.osy, this);
        }
        AppMethodBeat.o(122723);
        return;
      }
    }
    params = params.Njt;
    Log.i("MicroMsg.NetSceneUploadFie", "onGYNetEnd, finish upload, startPos: %d, totalLen: %d, attachId: %s", new Object[] { Integer.valueOf(this.dIY), Integer.valueOf(this.osy), params });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
    if (this.oHS != null) {
      this.oHS.a(this.dIY, this.osy, this);
    }
    AppMethodBeat.o(122723);
  }
  
  public final int securityLimitCount()
  {
    return 640;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(122724);
    if ((Util.isNullOrNil(this.filePath)) || (!y.ZC(this.filePath)))
    {
      Log.e("MicroMsg.NetSceneUploadFie", "securityVerificationChecked failed, file not exist");
      params = p.b.oui;
      AppMethodBeat.o(122724);
      return params;
    }
    params = p.b.ouh;
    AppMethodBeat.o(122724);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.t
 * JD-Core Version:    0.7.0.1
 */