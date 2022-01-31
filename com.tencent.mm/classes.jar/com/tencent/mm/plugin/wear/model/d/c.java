package com.tencent.mm.plugin.wear.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.cog;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.z;
import java.util.UUID;

public final class c
  extends m
  implements k
{
  f callback;
  private String clientId;
  public int cnU;
  public boolean fZu;
  String filename;
  ap frx;
  private boolean gbi;
  private int gbm;
  private com.tencent.mm.ai.b rr;
  public String talker;
  public String uHA;
  public boolean uHB;
  int uHz;
  
  public c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(26379);
    this.filename = null;
    this.gbm = 0;
    this.fZu = false;
    this.uHz = 0;
    this.gbi = false;
    this.frx = new ap(new c.1(this), true);
    this.cnU = paramInt;
    this.talker = paramString2;
    this.filename = paramString1;
    this.gbm = 0;
    this.clientId = UUID.randomUUID().toString();
    AppMethodBeat.o(26379);
  }
  
  private static String d(SKBuiltinBuffer_t paramSKBuiltinBuffer_t)
  {
    AppMethodBeat.i(26383);
    if ((paramSKBuiltinBuffer_t != null) && (paramSKBuiltinBuffer_t.getBuffer() != null))
    {
      paramSKBuiltinBuffer_t = paramSKBuiltinBuffer_t.getBuffer().dqj();
      AppMethodBeat.o(26383);
      return paramSKBuiltinBuffer_t;
    }
    AppMethodBeat.o(26383);
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(26380);
    this.callback = paramf;
    int k = com.tencent.mm.a.e.cM(this.filename);
    if (k <= 0)
    {
      ab.e("MicroMsg.Wear.NetSceneVoiceToText", "doScene file length is zero: %s", new Object[] { this.filename });
      AppMethodBeat.o(26380);
      return -1;
    }
    int j = k - this.uHz;
    int i;
    if (j > 3960) {
      i = 3960;
    }
    for (;;)
    {
      ab.i("MicroMsg.Wear.NetSceneVoiceToText", "fileLength: %d | readOffset: %d | isRecordFinish=%b | endFlag=%b | filename=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(this.uHz), Boolean.valueOf(this.fZu), Boolean.valueOf(this.gbi), this.filename });
      paramf = com.tencent.mm.a.e.i(this.filename, this.uHz, i);
      if (paramf != null) {
        break label279;
      }
      if (!this.gbi) {
        break;
      }
      AppMethodBeat.o(26380);
      return 0;
      if ((j < 3300) && (!this.fZu))
      {
        ab.e("MicroMsg.Wear.NetSceneVoiceToText", "try to send a buf less than MIN_SEND_BYTE_PER_PACK: canReadLen=%d | isRecordFinished=%b", new Object[] { Integer.valueOf(j), Boolean.valueOf(this.fZu) });
        AppMethodBeat.o(26380);
        return -1;
      }
      i = j;
      if (this.fZu)
      {
        this.gbi = true;
        i = j;
      }
    }
    ab.e("MicroMsg.Wear.NetSceneVoiceToText", "Can not read file: canReadLen=%d | isRecordFinish=%b | endFlag=%b", new Object[] { Integer.valueOf(i), Boolean.valueOf(this.fZu), Boolean.valueOf(this.gbi) });
    AppMethodBeat.o(26380);
    return -1;
    label279:
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new cof();
    ((b.a)localObject).fsY = new cog();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadinputvoice";
    ((b.a)localObject).funcId = 349;
    ((b.a)localObject).reqCmdId = 158;
    ((b.a)localObject).respCmdId = 1000000158;
    this.rr = ((b.a)localObject).ado();
    localObject = (cof)this.rr.fsV.fta;
    aw.aaz();
    ((cof)localObject).jJA = ((String)com.tencent.mm.model.c.Ru().get(2, ""));
    ((cof)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(paramf);
    ((cof)localObject).wzS = this.uHz;
    ((cof)localObject).xWW = this.clientId;
    if (this.gbi)
    {
      i = 1;
      ((cof)localObject).fKi = i;
      ((cof)localObject).xWX = 0;
      ((cof)localObject).wrv = 0;
      ((cof)localObject).xWY = this.gbm;
      ((cof)localObject).wrs = 0;
      i = dispatch(parame, this.rr, this);
      j = ((cof)localObject).wzS;
      this.uHz = (((cof)localObject).pIA.getILen() + j);
      if (!this.fZu) {
        break label566;
      }
    }
    label566:
    for (long l = 0L;; l = 500L)
    {
      ab.i("MicroMsg.Wear.NetSceneVoiceToText", "doScene filename=%s | delay=%d | ret=%d", new Object[] { this.filename, Long.valueOf(l), Integer.valueOf(i) });
      this.frx.ag(l, l);
      AppMethodBeat.o(26380);
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
    AppMethodBeat.i(26382);
    ab.i("MicroMsg.Wear.NetSceneVoiceToText", "onGYNetEnd errorType=%d | errorCode=%d |filename=%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), this.filename });
    paramq = (cog)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26382);
      return;
    }
    ab.i("MicroMsg.Wear.NetSceneVoiceToText", "resp EndFlag=%d | Text=%s", new Object[] { Integer.valueOf(paramq.fKi), d(paramq.xWZ) });
    if (paramq.fKi == 1)
    {
      this.uHB = true;
      paramq = d(paramq.xWZ);
      if (paramq != null) {
        this.uHA = paramq;
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(26382);
      return;
    }
    AppMethodBeat.o(26382);
  }
  
  public final int securityLimitCount()
  {
    return 20;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(26381);
    this.callback.onSceneEnd(3, 0, "securityCheckError", this);
    AppMethodBeat.o(26381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.d.c
 * JD-Core Version:    0.7.0.1
 */