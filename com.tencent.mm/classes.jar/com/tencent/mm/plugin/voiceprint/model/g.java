package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.be.a;
import com.tencent.mm.model.be.b;
import com.tencent.mm.modelsimple.l;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;

public final class g
  extends n
  implements k
{
  String BVk;
  int BVl;
  private String BVm;
  f callback;
  private final q hON;
  
  public g(String paramString)
  {
    AppMethodBeat.i(29773);
    this.BVk = "";
    this.BVl = 0;
    this.BVm = "";
    this.hON = new a();
    be.a locala = (be.a)this.hON.getReqObj();
    ad.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[] { Integer.valueOf(73), paramString });
    locala.hGq.GES = 73;
    locala.hGq.GEU = paramString;
    AppMethodBeat.o(29773);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(29774);
    this.callback = paramf;
    int i = dispatch(parame, this.hON, this);
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
    ad.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (be.b)paramq.getRespObj();
    if ((paramInt2 == 4) && (paramInt3 == -102))
    {
      paramInt1 = paramq.getReqObj().getRsaInfo().ver;
      ad.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[] { Integer.valueOf(paramInt1) });
      ba.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(29772);
          new l().doScene(g.this.dispatcher(), new f()
          {
            public final void onSceneEnd(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, n paramAnonymous2n)
            {
              AppMethodBeat.i(29771);
              ad.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth dkcert getcert type:%d ret [%d,%d]", new Object[] { Integer.valueOf(paramAnonymous2n.getType()), Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
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
    if (paramArrayOfByte.hGr.GEV != null)
    {
      this.BVk = new String(paramArrayOfByte.hGr.GEV.HnH.getBufferToBytes());
      this.BVl = paramArrayOfByte.hGr.GEV.Hlk;
      ad.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[] { Integer.valueOf(this.BVl), this.BVm, this.BVk });
    }
    for (;;)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29775);
      return;
      ad.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
    }
  }
  
  public final int securityLimitCount()
  {
    return 3;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
  
  public final void setSecurityCheckError(n.a parama) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.g
 * JD-Core Version:    0.7.0.1
 */