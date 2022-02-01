package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.model.bd.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.sdk.platformtools.ap;

public final class g
  extends n
  implements k
{
  String AvP;
  int AvQ;
  private String AvR;
  com.tencent.mm.ak.g callback;
  private final q hwy;
  
  public g(String paramString)
  {
    AppMethodBeat.i(29773);
    this.AvP = "";
    this.AvQ = 0;
    this.AvR = "";
    this.hwy = new a();
    bd.a locala = (bd.a)this.hwy.getReqObj();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(73), paramString });
    locala.hnY.EVv = 73;
    locala.hnY.EVw = paramString;
    AppMethodBeat.o(29773);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(29774);
    this.callback = paramg;
    int i = dispatch(parame, this.hwy, this);
    AppMethodBeat.o(29774);
    return i;
  }
  
  public final int getType()
  {
    return 616;
  }
  
  public final void onGYNetEnd(final int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29775);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (bd.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      az.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29772);
          new l().doScene(g.this.dispatcher(), new com.tencent.mm.ak.g()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(29771);
              com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              if ((paramAnonymous2Int1 != 0) || (paramAnonymous2Int2 != 0))
              {
                g.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", g.this);
                AppMethodBeat.o(29771);
                return;
              }
              g.this.doScene(g.this.dispatcher(), g.this.callback);
              AppMethodBeat.o(29771);
            }
          });
          AppMethodBeat.o(29772);
        }
      });
      AppMethodBeat.o(29775);
      return;
    }
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29775);
      return;
    }
    if (paramArrayOfByte.hnZ.EVx != null)
    {
      this.AvP = new String(paramArrayOfByte.hnZ.EVx.FDu.getBufferToBytes());
      this.AvQ = paramArrayOfByte.hnZ.EVx.FAX;
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[] { Integer.valueOf(this.AvQ), this.AvR, this.AvP });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29775);
      return;
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
    }
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.g
 * JD-Core Version:    0.7.0.1
 */