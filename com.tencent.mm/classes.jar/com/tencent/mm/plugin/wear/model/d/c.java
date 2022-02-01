package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.enm;
import com.tencent.mm.protocal.protobuf.enn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.storage.ao;
import java.util.UUID;

public final class c
  extends q
  implements m
{
  int Iym;
  public String Iyn;
  public boolean Iyo;
  i callback;
  private String clientId;
  public int dEb;
  private int encodeType;
  String filename;
  MTimerHandler iKj;
  public boolean jul;
  private boolean jvY;
  private d rr;
  public String talker;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(30061);
    this.filename = null;
    this.encodeType = 0;
    this.jul = false;
    this.Iym = 0;
    this.jvY = false;
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30060);
        long l1 = com.tencent.mm.vfs.s.boW(c.this.filename);
        long l2 = l1 - c.this.Iym;
        Log.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { c.this.filename, Long.valueOf(l1), Integer.valueOf(c.this.Iym), Boolean.valueOf(c.this.jul), Long.valueOf(l2) });
        if ((l2 < 3300L) && (!c.this.jul))
        {
          AppMethodBeat.o(30060);
          return true;
        }
        if ((c.this.jul) && (l2 <= 0L))
        {
          AppMethodBeat.o(30060);
          return false;
        }
        if (c.this.doScene(c.this.dispatcher(), c.this.callback) == -1) {
          c.this.callback.onSceneEnd(3, -1, "doScene failed", c.this);
        }
        AppMethodBeat.o(30060);
        return false;
      }
    }, true);
    this.dEb = paramInt;
    this.talker = paramString2;
    this.filename = paramString1;
    this.encodeType = 0;
    this.clientId = UUID.randomUUID().toString();
    AppMethodBeat.o(30061);
  }
  
  private static String d(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(30065);
    if ((paramSKBuiltinBuffer_t != null) && (paramSKBuiltinBuffer_t.getBuffer() != null))
    {
      paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().yO();
      AppMethodBeat.o(30065);
      return paramSKBuiltinBuffer_t;
    }
    AppMethodBeat.o(30065);
    return null;
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(30062);
    this.callback = parami;
    int k = (int)com.tencent.mm.vfs.s.boW(this.filename);
    if (k <= 0)
    {
      Log.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      AppMethodBeat.o(30062);
      return -1;
    }
    int j = k - this.Iym;
    int i;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      Log.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.Iym), Boolean.valueOf(this.jul), Boolean.valueOf(this.jvY), this.filename });
      parami = com.tencent.mm.vfs.s.aW(this.filename, this.Iym, i);
      if (parami != null) {
        break label280;
      }
      if (!this.jvY) {
        break;
      }
      AppMethodBeat.o(30062);
      return 0;
      if ((j < 3300) && (!this.jul))
      {
        Log.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.jul) });
        AppMethodBeat.o(30062);
        return -1;
      }
      i = j;
      if (this.jul)
      {
        this.jvY = true;
        i = j;
      }
    }
    Log.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.jul), Boolean.valueOf(this.jvY) });
    AppMethodBeat.o(30062);
    return -1;
    label280:
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new enm();
    ((d.a)localObject).iLO = new enn();
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((d.a)localObject).funcId = 349;
    ((d.a)localObject).iLP = 158;
    ((d.a)localObject).respCmdId = 1000000158;
    this.rr = ((d.a)localObject).aXF();
    localObject = (enm)this.rr.iLK.iLR;
    bg.aVF();
    ((enm)localObject).UserName = ((String)com.tencent.mm.model.c.azQ().get(2, ""));
    ((enm)localObject).BsI = new SKBuiltinBuffer_t().setBuffer(parami);
    ((enm)localObject).KZk = this.Iym;
    ((enm)localObject).Nln = this.clientId;
    if (this.jvY)
    {
      i = 1;
      ((enm)localObject).jeU = i;
      ((enm)localObject).Nlo = 0;
      ((enm)localObject).KKD = 0;
      ((enm)localObject).Nlp = this.encodeType;
      ((enm)localObject).KKA = 0;
      i = dispatch(paramg, this.rr, this);
      j = ((enm)localObject).KZk;
      this.Iym = (((enm)localObject).BsI.getILen() + j);
      if (!this.jul) {
        break label565;
      }
    }
    label565:
    for (long l = 0L;; l = 500L)
    {
      Log.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.iKj.startTimer(l);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30064);
    Log.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.filename });
    params = (enn)((d)params).iLL.iLR;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    Log.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(params.jeU), d(params.Nlq) });
    if (params.jeU == 1)
    {
      this.Iyo = true;
      params = d(params.Nlq);
      if (params != null) {
        this.Iyn = params;
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
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(30063);
    this.callback.onSceneEnd(3, 0, "securityCheckError", this);
    AppMethodBeat.o(30063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.c
 * JD-Core Version:    0.7.0.1
 */