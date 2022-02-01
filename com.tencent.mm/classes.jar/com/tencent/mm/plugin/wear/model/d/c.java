package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.cd.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.exu;
import com.tencent.mm.protocal.protobuf.exv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;
import java.util.UUID;

public final class c
  extends q
  implements m
{
  private int Psp;
  public String Psq;
  public boolean Psr;
  private i callback;
  private String clientId;
  private int encodeType;
  private String filename;
  public int fwM;
  MTimerHandler lAo;
  public boolean mjP;
  private boolean mlB;
  private d rr;
  public String talker;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(30061);
    this.filename = null;
    this.encodeType = 0;
    this.mjP = false;
    this.Psp = 0;
    this.mlB = false;
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30060);
        long l1 = u.bBQ(c.a(c.this));
        long l2 = l1 - c.b(c.this);
        Log.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { c.a(c.this), Long.valueOf(l1), Integer.valueOf(c.b(c.this)), Boolean.valueOf(c.c(c.this)), Long.valueOf(l2) });
        if ((l2 < 3300L) && (!c.c(c.this)))
        {
          AppMethodBeat.o(30060);
          return true;
        }
        if ((c.c(c.this)) && (l2 <= 0L))
        {
          AppMethodBeat.o(30060);
          return false;
        }
        if (c.this.doScene(c.d(c.this), c.e(c.this)) == -1) {
          c.e(c.this).onSceneEnd(3, -1, "doScene failed", c.this);
        }
        AppMethodBeat.o(30060);
        return false;
      }
    }, true);
    this.fwM = paramInt;
    this.talker = paramString2;
    this.filename = paramString1;
    this.encodeType = 0;
    this.clientId = UUID.randomUUID().toString();
    AppMethodBeat.o(30061);
  }
  
  private static String d(eae parameae)
  {
    AppMethodBeat.i(30065);
    if ((parameae != null) && (parameae.Tkb != null))
    {
      parameae = parameae.Tkb.Ap();
      AppMethodBeat.o(30065);
      return parameae;
    }
    AppMethodBeat.o(30065);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30062);
    this.callback = parami;
    int k = (int)u.bBQ(this.filename);
    if (k <= 0)
    {
      Log.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      AppMethodBeat.o(30062);
      return -1;
    }
    int j = k - this.Psp;
    int i;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.Psp), Boolean.valueOf(this.mjP), Boolean.valueOf(this.mlB), this.filename });
      parami = u.aY(this.filename, this.Psp, i);
      if (parami != null) {
        break label280;
      }
      if (!this.mlB) {
        break;
      }
      AppMethodBeat.o(30062);
      return 0;
      if ((j < 3300) && (!this.mjP))
      {
        Log.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.mjP) });
        AppMethodBeat.o(30062);
        return -1;
      }
      i = j;
      if (this.mjP)
      {
        this.mlB = true;
        i = j;
      }
    }
    Log.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.mjP), Boolean.valueOf(this.mlB) });
    AppMethodBeat.o(30062);
    return -1;
    label280:
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new exu();
    ((d.a)localObject).lBV = new exv();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((d.a)localObject).funcId = 349;
    ((d.a)localObject).lBW = 158;
    ((d.a)localObject).respCmdId = 1000000158;
    this.rr = ((d.a)localObject).bgN();
    localObject = (exu)d.b.b(this.rr.lBR);
    bh.beI();
    ((exu)localObject).UserName = ((String)com.tencent.mm.model.c.aHp().b(2, ""));
    ((exu)localObject).Hnc = new eae().dc(parami);
    ((exu)localObject).Sat = this.Psp;
    ((exu)localObject).UxY = this.clientId;
    if (this.mlB)
    {
      i = 1;
      ((exu)localObject).lVs = i;
      ((exu)localObject).UxZ = 0;
      ((exu)localObject).RLv = 0;
      ((exu)localObject).Uya = this.encodeType;
      ((exu)localObject).RLs = 0;
      i = dispatch(paramg, this.rr, this);
      j = ((exu)localObject).Sat;
      this.Psp = (((exu)localObject).Hnc.Ufv + j);
      if (!this.mjP) {
        break label566;
      }
    }
    label566:
    for (long l = 0L;; l = 500L)
    {
      Log.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.lAo.startTimer(l);
      AppMethodBeat.o(30062);
      return i;
      i = 0;
      break;
    }
  }
  
  public final int getType()
  {
    return 349;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30064);
    Log.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.filename });
    params = (exv)d.c.b(((d)params).lBS);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    Log.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(params.lVs), d(params.Uyb) });
    if (params.lVs == 1)
    {
      this.Psr = true;
      params = d(params.Uyb);
      if (params != null) {
        this.Psq = params;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    AppMethodBeat.o(30064);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(30063);
    this.callback.onSceneEnd(3, 0, "securityCheckError", this);
    AppMethodBeat.o(30063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.c
 * JD-Core Version:    0.7.0.1
 */