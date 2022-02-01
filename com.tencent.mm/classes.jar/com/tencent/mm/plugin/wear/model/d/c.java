package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dsr;
import com.tencent.mm.protocal.protobuf.dss;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;
import java.util.UUID;

public final class c
  extends n
  implements k
{
  int Dxr;
  public String Dxs;
  public boolean Dxt;
  f callback;
  private String clientId;
  public int dlK;
  private int encodeType;
  String filename;
  av hMj;
  public boolean iwe;
  private boolean ixQ;
  private com.tencent.mm.al.b rr;
  public String talker;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(30061);
    this.filename = null;
    this.encodeType = 0;
    this.iwe = false;
    this.Dxr = 0;
    this.ixQ = false;
    this.hMj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30060);
        long l1 = i.aYo(c.this.filename);
        long l2 = l1 - c.this.Dxr;
        ad.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { c.this.filename, Long.valueOf(l1), Integer.valueOf(c.this.Dxr), Boolean.valueOf(c.this.iwe), Long.valueOf(l2) });
        if ((l2 < 3300L) && (!c.this.iwe))
        {
          AppMethodBeat.o(30060);
          return true;
        }
        if ((c.this.iwe) && (l2 <= 0L))
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
    this.dlK = paramInt;
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
      paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().ffY();
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
    int k = (int)i.aYo(this.filename);
    if (k <= 0)
    {
      ad.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      AppMethodBeat.o(30062);
      return -1;
    }
    int j = k - this.Dxr;
    int i;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ad.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.Dxr), Boolean.valueOf(this.iwe), Boolean.valueOf(this.ixQ), this.filename });
      paramf = i.aY(this.filename, this.Dxr, i);
      if (paramf != null) {
        break label280;
      }
      if (!this.ixQ) {
        break;
      }
      AppMethodBeat.o(30062);
      return 0;
      if ((j < 3300) && (!this.iwe))
      {
        ad.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.iwe) });
        AppMethodBeat.o(30062);
        return -1;
      }
      i = j;
      if (this.iwe)
      {
        this.ixQ = true;
        i = j;
      }
    }
    ad.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.iwe), Boolean.valueOf(this.ixQ) });
    AppMethodBeat.o(30062);
    return -1;
    label280:
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new dsr();
    ((b.a)localObject).hNN = new dss();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).hNO = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).aDC();
    localObject = (dsr)this.rr.hNK.hNQ;
    ba.aBQ();
    ((dsr)localObject).nDo = ((String)com.tencent.mm.model.c.ajl().get(2, ""));
    ((dsr)localObject).xcN = new SKBuiltinBuffer_t().setBuffer(paramf);
    ((dsr)localObject).FMu = this.Dxr;
    ((dsr)localObject).HFt = this.clientId;
    if (this.ixQ)
    {
      i = 1;
      ((dsr)localObject).ihf = i;
      ((dsr)localObject).HFu = 0;
      ((dsr)localObject).Fyy = 0;
      ((dsr)localObject).HFv = this.encodeType;
      ((dsr)localObject).Fyv = 0;
      i = dispatch(parame, this.rr, this);
      j = ((dsr)localObject).FMu;
      this.Dxr = (((dsr)localObject).xcN.getILen() + j);
      if (!this.iwe) {
        break label567;
      }
    }
    label567:
    for (long l = 0L;; l = 500L)
    {
      ad.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.hMj.az(l, l);
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
    paramq = (dss)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    ad.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(paramq.ihf), d(paramq.HFw) });
    if (paramq.ihf == 1)
    {
      this.Dxt = true;
      paramq = d(paramq.HFw);
      if (paramq != null) {
        this.Dxs = paramq;
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
    return n.b.hOp;
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