package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dto;
import com.tencent.mm.protocal.protobuf.dtp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.storage.aj;
import com.tencent.mm.vfs.o;
import java.util.UUID;

public final class c
  extends n
  implements k
{
  int DOW;
  public String DOX;
  public boolean DOY;
  f callback;
  private String clientId;
  public int dmM;
  private int encodeType;
  String filename;
  aw hPc;
  private boolean iAJ;
  public boolean iyX;
  private com.tencent.mm.ak.b rr;
  public String talker;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(30061);
    this.filename = null;
    this.encodeType = 0;
    this.iyX = false;
    this.DOW = 0;
    this.iAJ = false;
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30060);
        long l1 = o.aZR(c.this.filename);
        long l2 = l1 - c.this.DOW;
        ae.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { c.this.filename, Long.valueOf(l1), Integer.valueOf(c.this.DOW), Boolean.valueOf(c.this.iyX), Long.valueOf(l2) });
        if ((l2 < 3300L) && (!c.this.iyX))
        {
          AppMethodBeat.o(30060);
          return true;
        }
        if ((c.this.iyX) && (l2 <= 0L))
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
    this.dmM = paramInt;
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
      paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().fjO();
      AppMethodBeat.o(30065);
      return paramSKBuiltinBuffer_t;
    }
    AppMethodBeat.o(30065);
    return null;
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(30062);
    this.callback = paramf;
    int k = (int)o.aZR(this.filename);
    if (k <= 0)
    {
      ae.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      AppMethodBeat.o(30062);
      return -1;
    }
    int j = k - this.DOW;
    int i;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ae.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.DOW), Boolean.valueOf(this.iyX), Boolean.valueOf(this.iAJ), this.filename });
      paramf = o.bb(this.filename, this.DOW, i);
      if (paramf != null) {
        break label280;
      }
      if (!this.iAJ) {
        break;
      }
      AppMethodBeat.o(30062);
      return 0;
      if ((j < 3300) && (!this.iyX))
      {
        ae.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.iyX) });
        AppMethodBeat.o(30062);
        return -1;
      }
      i = j;
      if (this.iyX)
      {
        this.iAJ = true;
        i = j;
      }
    }
    ae.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.iyX), Boolean.valueOf(this.iAJ) });
    AppMethodBeat.o(30062);
    return -1;
    label280:
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new dto();
    ((b.a)localObject).hQG = new dtp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).hQH = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).aDS();
    localObject = (dto)this.rr.hQD.hQJ;
    bc.aCg();
    ((dto)localObject).nIJ = ((String)com.tencent.mm.model.c.ajA().get(2, ""));
    ((dto)localObject).xsE = new SKBuiltinBuffer_t().setBuffer(paramf);
    ((dto)localObject).GeT = this.DOW;
    ((dto)localObject).HZg = this.clientId;
    if (this.iAJ)
    {
      i = 1;
      ((dto)localObject).ijY = i;
      ((dto)localObject).HZh = 0;
      ((dto)localObject).FQW = 0;
      ((dto)localObject).HZi = this.encodeType;
      ((dto)localObject).FQT = 0;
      i = dispatch(parame, this.rr, this);
      j = ((dto)localObject).GeT;
      this.DOW = (((dto)localObject).xsE.getILen() + j);
      if (!this.iyX) {
        break label567;
      }
    }
    label567:
    for (long l = 0L;; l = 500L)
    {
      ae.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.hPc.ay(l, l);
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
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(30064);
    ae.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.filename });
    paramq = (dtp)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    ae.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(paramq.ijY), d(paramq.HZj) });
    if (paramq.ijY == 1)
    {
      this.DOY = true;
      paramq = d(paramq.HZj);
      if (paramq != null) {
        this.DOX = paramq;
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
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(30063);
    this.callback.onSceneEnd(3, 0, "securityCheckError", this);
    AppMethodBeat.o(30063);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.c
 * JD-Core Version:    0.7.0.1
 */