package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.az;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dhl;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ab;
import com.tencent.mm.vfs.i;
import java.util.UUID;

public final class c
  extends n
  implements k
{
  int AEE;
  public String AEF;
  public boolean AEG;
  g callback;
  private String clientId;
  public int dcS;
  private int encodeType;
  String filename;
  av gTs;
  public boolean hCh;
  private boolean hDU;
  private com.tencent.mm.al.b rr;
  public String talker;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(30061);
    this.filename = null;
    this.encodeType = 0;
    this.hCh = false;
    this.AEE = 0;
    this.hDU = false;
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30060);
        long l1 = i.aMN(c.this.filename);
        long l2 = l1 - c.this.AEE;
        ad.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { c.this.filename, Long.valueOf(l1), Integer.valueOf(c.this.AEE), Boolean.valueOf(c.this.hCh), Long.valueOf(l2) });
        if ((l2 < 3300L) && (!c.this.hCh))
        {
          AppMethodBeat.o(30060);
          return true;
        }
        if ((c.this.hCh) && (l2 <= 0L))
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
    this.dcS = paramInt;
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
      paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().eBA();
      AppMethodBeat.o(30065);
      return paramSKBuiltinBuffer_t;
    }
    AppMethodBeat.o(30065);
    return null;
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(30062);
    this.callback = paramg;
    int k = (int)i.aMN(this.filename);
    if (k <= 0)
    {
      ad.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      AppMethodBeat.o(30062);
      return -1;
    }
    int j = k - this.AEE;
    int i;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ad.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.AEE), Boolean.valueOf(this.hCh), Boolean.valueOf(this.hDU), this.filename });
      paramg = i.aR(this.filename, this.AEE, i);
      if (paramg != null) {
        break label280;
      }
      if (!this.hDU) {
        break;
      }
      AppMethodBeat.o(30062);
      return 0;
      if ((j < 3300) && (!this.hCh))
      {
        ad.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.hCh) });
        AppMethodBeat.o(30062);
        return -1;
      }
      i = j;
      if (this.hCh)
      {
        this.hDU = true;
        i = j;
      }
    }
    ad.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.hCh), Boolean.valueOf(this.hDU) });
    AppMethodBeat.o(30062);
    return -1;
    label280:
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new dhl();
    ((b.a)localObject).gUV = new dhm();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).reqCmdId = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).atI();
    localObject = (dhl)this.rr.gUS.gUX;
    az.arV();
    ((dhl)localObject).mAQ = ((String)com.tencent.mm.model.c.afk().get(2, ""));
    ((dhl)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(paramg);
    ((dhl)localObject).CNt = this.AEE;
    ((dhl)localObject).ExD = this.clientId;
    if (this.hDU)
    {
      i = 1;
      ((dhl)localObject).hno = i;
      ((dhl)localObject).ExE = 0;
      ((dhl)localObject).CAJ = 0;
      ((dhl)localObject).ExF = this.encodeType;
      ((dhl)localObject).CAG = 0;
      i = dispatch(parame, this.rr, this);
      j = ((dhl)localObject).CNt;
      this.AEE = (((dhl)localObject).uKT.getILen() + j);
      if (!this.hCh) {
        break label567;
      }
    }
    label567:
    for (long l = 0L;; l = 500L)
    {
      ad.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.gTs.av(l, l);
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
    ad.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.filename });
    paramq = (dhm)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    ad.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(paramq.hno), d(paramq.ExG) });
    if (paramq.hno == 1)
    {
      this.AEG = true;
      paramq = d(paramq.ExG);
      if (paramq != null) {
        this.AEF = paramq;
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
    return n.b.gVB;
  }
  
  public final void setSecurityCheckError(n.a parama)
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