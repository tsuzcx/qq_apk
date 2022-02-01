package com.tencent.mm.plugin.voiceprint.model;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.protocal.protobuf.dpp;
import com.tencent.mm.protocal.protobuf.dqq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.i;

public final class j
  extends com.tencent.mm.ak.n
  implements k
{
  public boolean AvU;
  private boolean AvV;
  private Handler AvW;
  private int AvX;
  int LD;
  private int MW;
  private com.tencent.mm.ak.g callback;
  private String filename;
  private String iRo;
  private final b rr;
  
  public j(String paramString, int paramInt)
  {
    AppMethodBeat.i(29785);
    this.MW = 0;
    this.AvU = false;
    this.AvV = false;
    this.AvW = null;
    this.AvX = 0;
    this.LD = 0;
    this.iRo = "";
    ac.d("MicroMsg.NetSceneVerifyVoicePrint", "resid %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new dpo();
    ((b.a)localObject).hvu = new dpp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/verifyvoiceprint";
    ((b.a)localObject).funcId = 613;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.rr = ((b.a)localObject).aAz();
    localObject = (dpo)this.rr.hvr.hvw;
    this.filename = paramString;
    this.MW = 0;
    ((dpo)localObject).FAX = paramInt;
    this.AvX = 0;
    ((dpo)localObject).FAV = 0;
    ac.i("MicroMsg.NetSceneVerifyVoicePrint", "voiceRegist %d %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(0) });
    this.AvU = true;
    egw();
    AppMethodBeat.o(29785);
  }
  
  private int egw()
  {
    AppMethodBeat.i(29787);
    dpo localdpo = (dpo)this.rr.hvr.hvw;
    dqq localdqq = new dqq();
    new com.tencent.mm.modelvoice.g();
    localdpo.FWU = localdqq;
    Object localObject = new com.tencent.mm.modelvoice.n(m.bW(this.filename, false));
    int i = (int)i.aSp(m.bW(this.filename, false));
    if (i - this.MW >= 6000) {}
    int j;
    for (localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(this.MW, 6000);; localObject = ((com.tencent.mm.modelvoice.n)localObject).dp(j, i - j))
    {
      ac.d("MicroMsg.NetSceneVerifyVoicePrint", "read offset %d, ret %d , buf len %d, totallen %d finish %b", new Object[] { Integer.valueOf(this.MW), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret), Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).cWy), Integer.valueOf(i), Boolean.valueOf(this.AvU) });
      if (((com.tencent.mm.modelvoice.g)localObject).cWy != 0) {
        break;
      }
      AppMethodBeat.o(29787);
      return -2;
      j = this.MW;
    }
    if (((com.tencent.mm.modelvoice.g)localObject).ret < 0)
    {
      ac.w("MicroMsg.NetSceneVerifyVoicePrint", "readerror %d", new Object[] { Integer.valueOf(((com.tencent.mm.modelvoice.g)localObject).ret) });
      AppMethodBeat.o(29787);
      return -1;
    }
    if (this.MW >= 469000)
    {
      ac.i("MicroMsg.NetSceneVerifyVoicePrint", "moffset > maxfile %d", new Object[] { Integer.valueOf(this.MW) });
      AppMethodBeat.o(29787);
      return -1;
    }
    localdqq.FXX = new SKBuiltinBuffer_t().setBuffer(((com.tencent.mm.modelvoice.g)localObject).buf);
    localdqq.vTI = this.MW;
    localdqq.FXV = ((com.tencent.mm.modelvoice.g)localObject).cWy;
    localdqq.FXW = 0;
    localdpo.FAV = this.AvX;
    if (this.AvU)
    {
      j = (int)i.aSp(m.bW(this.filename, false));
      if (((com.tencent.mm.modelvoice.g)localObject).ibm >= j)
      {
        localdqq.FXW = 1;
        this.AvV = true;
        ac.i("MicroMsg.NetSceneVerifyVoicePrint", "the last one pack for uploading totallen %d", new Object[] { Integer.valueOf(i) });
      }
    }
    this.MW = ((com.tencent.mm.modelvoice.g)localObject).ibm;
    localdpo.FWU = localdqq;
    AppMethodBeat.o(29787);
    return 0;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(29786);
    this.callback = paramg;
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(29786);
    return i;
  }
  
  public final int getType()
  {
    return 613;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(29788);
    ac.d("MicroMsg.NetSceneVerifyVoicePrint", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (dpp)((b)paramq).hvs.hvw;
    if ((paramInt2 != 0) && (paramInt3 != 0))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    this.AvX = paramq.FAV;
    this.LD = paramq.Epu;
    ac.i("MicroMsg.NetSceneVerifyVoicePrint", "voice VoiceTicket %d mResult %d", new Object[] { Integer.valueOf(paramq.FAV), Integer.valueOf(this.LD) });
    if (this.AvV)
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(29788);
      return;
    }
    ac.i("MicroMsg.NetSceneVerifyVoicePrint", "tryDoScene ret %d", new Object[] { Integer.valueOf(egw()) });
    doScene(dispatcher(), this.callback);
    ac.i("MicroMsg.NetSceneVerifyVoicePrint", "loop doscene");
    AppMethodBeat.o(29788);
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.model.j
 * JD-Core Version:    0.7.0.1
 */