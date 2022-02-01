package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.az;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dna;
import com.tencent.mm.protocal.protobuf.dnb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.storage.ae;
import com.tencent.mm.vfs.i;
import java.util.UUID;

public final class c
  extends n
  implements k
{
  int BWY;
  public String BWZ;
  public boolean BXa;
  g callback;
  private String clientId;
  public int daq;
  private int encodeType;
  String filename;
  au htR;
  public boolean icI;
  private boolean iew;
  private com.tencent.mm.ak.b rr;
  public String talker;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(30061);
    this.filename = null;
    this.encodeType = 0;
    this.icI = false;
    this.BWY = 0;
    this.iew = false;
    this.htR = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(30060);
        long l1 = i.aSp(c.this.filename);
        long l2 = l1 - c.this.BWY;
        ac.d("MicroMsg.Wear.NetSceneVoiceToText", "onTimerExpired: filename=%s | fileLength=%d | readOffset=%d | isRecordFinished=%b | canReadLength=%d", new Object[] { c.this.filename, Long.valueOf(l1), Integer.valueOf(c.this.BWY), Boolean.valueOf(c.this.icI), Long.valueOf(l2) });
        if ((l2 < 3300L) && (!c.this.icI))
        {
          AppMethodBeat.o(30060);
          return true;
        }
        if ((c.this.icI) && (l2 <= 0L))
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
    this.daq = paramInt;
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
      paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().eQU();
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
    int k = (int)i.aSp(this.filename);
    if (k <= 0)
    {
      ac.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      AppMethodBeat.o(30062);
      return -1;
    }
    int j = k - this.BWY;
    int i;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ac.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.BWY), Boolean.valueOf(this.icI), Boolean.valueOf(this.iew), this.filename });
      paramg = i.aU(this.filename, this.BWY, i);
      if (paramg != null) {
        break label280;
      }
      if (!this.iew) {
        break;
      }
      AppMethodBeat.o(30062);
      return 0;
      if ((j < 3300) && (!this.icI))
      {
        ac.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.icI) });
        AppMethodBeat.o(30062);
        return -1;
      }
      i = j;
      if (this.icI)
      {
        this.iew = true;
        i = j;
      }
    }
    ac.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.icI), Boolean.valueOf(this.iew) });
    AppMethodBeat.o(30062);
    return -1;
    label280:
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dna();
    ((b.a)localObject).hvu = new dnb();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).reqCmdId = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dna)this.rr.hvr.hvw;
    az.ayM();
    ((dna)localObject).ncR = ((String)com.tencent.mm.model.c.agA().get(2, ""));
    ((dna)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(paramg);
    ((dna)localObject).EfV = this.BWY;
    ((dna)localObject).FUF = this.clientId;
    if (this.iew)
    {
      i = 1;
      ((dna)localObject).hNR = i;
      ((dna)localObject).FUG = 0;
      ((dna)localObject).DTf = 0;
      ((dna)localObject).FUH = this.encodeType;
      ((dna)localObject).DTc = 0;
      i = dispatch(parame, this.rr, this);
      j = ((dna)localObject).EfV;
      this.BWY = (((dna)localObject).vTK.getILen() + j);
      if (!this.icI) {
        break label567;
      }
    }
    label567:
    for (long l = 0L;; l = 500L)
    {
      ac.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.htR.au(l, l);
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
    ac.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.filename });
    paramq = (dnb)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(30064);
      return;
    }
    ac.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(paramq.hNR), d(paramq.FUI) });
    if (paramq.hNR == 1)
    {
      this.BXa = true;
      paramq = d(paramq.FUI);
      if (paramq != null) {
        this.BWZ = paramq;
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
    return n.b.hwa;
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