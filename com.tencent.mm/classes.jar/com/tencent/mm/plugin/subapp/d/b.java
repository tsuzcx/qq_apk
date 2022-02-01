package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.dnw;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import junit.framework.Assert;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.ak.g callback;
  private int endFlag;
  String fileName;
  au htR;
  private int ibm;
  private boolean icI;
  long icN;
  int retCode;
  private com.tencent.mm.ak.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(28930);
    this.retCode = 0;
    this.ibm = 0;
    this.icI = false;
    this.endFlag = 0;
    this.htR = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28929);
        Object localObject = b.this.fileName;
        localObject = d.eaJ().axx((String)localObject);
        if ((localObject == null) || (!((g)localObject).aKt()))
        {
          ac.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + b.this.fileName);
          b.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
          AppMethodBeat.o(28929);
          return false;
        }
        if ((3 != ((g)localObject).field_status) && (8 != ((g)localObject).field_status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - ((g)localObject).field_lastmodifytime > 30L)
          {
            ac.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + b.this.fileName);
            b.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
            AppMethodBeat.o(28929);
            return false;
          }
          if (l - b.this.icN < 2000L)
          {
            ac.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.this.fileName + " but last send time:" + (l - b.this.icN));
            AppMethodBeat.o(28929);
            return true;
          }
          c.a locala = h.axu(b.this.fileName).QY(((g)localObject).field_offset);
          ac.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.this.fileName + " readByte:" + locala.cWy + " stat:" + ((g)localObject).field_status);
          if (locala.cWy < 2000)
          {
            AppMethodBeat.o(28929);
            return true;
          }
        }
        if (b.this.doScene(b.this.dispatcher(), b.this.callback) == -1)
        {
          b.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
        }
        AppMethodBeat.o(28929);
        return false;
      }
    }, true);
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      ac.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      AppMethodBeat.o(28930);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(28931);
    this.callback = paramg;
    this.icI = false;
    if (this.fileName == null)
    {
      ac.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    paramg = this.fileName;
    g localg = d.eaJ().axx(paramg);
    if ((localg == null) || (!localg.aKt()))
    {
      ac.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    ac.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + localg.field_nettimes);
    paramg = this.fileName;
    boolean bool;
    if (paramg == null) {
      bool = false;
    }
    while (!bool)
    {
      ac.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
      h.Ea(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
      paramg = d.eaJ().axx(paramg);
      if (paramg == null)
      {
        bool = false;
      }
      else if (paramg.field_nettimes >= 80)
      {
        bool = false;
      }
      else
      {
        paramg.field_nettimes += 1;
        paramg.drx = 16384;
        bool = h.a(paramg);
      }
    }
    paramg = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      ac.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
      this.endFlag = 1;
      h.EH(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1672;
      }
      j = (this.ibm - 6) / 32 * 20;
    }
    label1672:
    for (;;)
    {
      ac.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new b.a();
      ((b.a)localObject).hvt = new dnv();
      ((b.a)localObject).hvu = new dnw();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((b.a)localObject).funcId = 329;
      ((b.a)localObject).reqCmdId = 157;
      ((b.a)localObject).respCmdId = 1000000157;
      this.rr = ((b.a)localObject).aAz();
      localObject = (dnv)this.rr.hvr.hvw;
      ((dnv)localObject).tlK = u.axw();
      ((dnv)localObject).tlJ = localg.field_user;
      ((dnv)localObject).EfV = localg.field_offset;
      ((dnv)localObject).DRb = localg.field_clientid;
      ((dnv)localObject).Eed = j;
      ((dnv)localObject).hNR = this.endFlag;
      ((dnv)localObject).vTQ = localg.field_msgid;
      ((dnv)localObject).EvW = i;
      ((dnv)localObject).FVx = ((int)(localg.field_createtime / 1000L));
      ((dnv)localObject).FiL = 1;
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(localg.field_user)) {
        ((dnv)localObject).EhE = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aND(localg.field_user);
      }
      if (i != 1) {
        ((dnv)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(paramg.buf, 0, paramg.cWy);
      }
      for (((dnv)localObject).Eck = paramg.cWy;; ((dnv)localObject).Eck = 1)
      {
        ac.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        ac.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((dnv)localObject).vTQ + " user:" + ((dnv)localObject).tlJ + " offset:" + ((dnv)localObject).EfV + " dataLen:" + ((dnv)localObject).vTK.getILen() + " endFlag:" + ((dnv)localObject).hNR);
        ac.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + paramg.cWy + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.ibm + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        ac.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.icN = System.currentTimeMillis();
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(28931);
        return i;
        if (localg.field_status == 3) {
          this.icI = true;
        }
        paramg = h.axu(this.fileName);
        if (paramg == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        paramg = paramg.QY(localg.field_offset);
        ac.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.f.getLine());
        if (paramg.ret < 0)
        {
          ac.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + localg.field_offset);
          h.Ea(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.ibm = paramg.ibm;
        if ((this.ibm < localg.field_offset) || (this.ibm >= 469000))
        {
          ac.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.ibm + " OldtOff:" + localg.field_offset);
          h.Ea(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.endFlag = 0;
        if ((paramg.cWy == 0) && (!this.icI))
        {
          ac.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.Ea(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        if (this.icI)
        {
          if (localg.field_totallen <= 0)
          {
            ac.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.Ea(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if ((localg.field_totallen > this.ibm) && (paramg.cWy < 6000))
          {
            ac.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + paramg.cWy + " newOff:" + paramg.ibm + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.Ea(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if (localg.field_totallen <= this.ibm) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((dnv)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cc(new byte[1]));
      }
    }
  }
  
  public final int getType()
  {
    return 329;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28934);
    ac.i("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dnv)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    paramq = (dnw)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    ac.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + paramq.toString());
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.EhF);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      paramq = this.fileName;
      paramq = d.eaJ().axx(paramq);
      if (paramq != null)
      {
        if (paramq.field_status == 3)
        {
          az.ayM();
          paramArrayOfByte = com.tencent.mm.model.c.awD().vP(paramq.field_msglocalid);
          paramArrayOfByte.setContent(f.b(paramq.field_human, paramq.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          az.ayM();
          com.tencent.mm.model.c.awD().a(paramq.field_msglocalid, paramArrayOfByte);
        }
        paramq.field_status = 97;
        paramq.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        paramq.drx = 320;
        h.a(paramq);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.Ea(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    ac.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + paramq.vTQ + " toUser:" + paramArrayOfByte.tlJ);
    paramArrayOfByte = this.fileName;
    int j = this.ibm;
    long l = paramq.vTQ;
    Object localObject = paramq.DRb;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      ac.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.vTQ + " clientId:" + paramq.DRb + " neWWOff:" + this.ibm + " neTTTT:" + paramq.Eck);
      if (paramInt1 >= 0) {
        break;
      }
      h.Ea(this.fileName);
      ac.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
      ac.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = d.eaJ().axx(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.drx = 264;
        if ((bs.isNullOrNil(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.drx |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.drx |= 0x4;
        }
        int i = 0;
        ac.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + localg.field_totallen + "  newOffset " + j + "  " + localg.field_status);
        paramInt1 = i;
        if (localg.field_totallen <= j)
        {
          paramInt1 = i;
          if (localg.field_status == 3)
          {
            paramInt1 = i;
            if (k == 1)
            {
              localg.field_status = 99;
              localg.drx |= 0x40;
              az.ayM();
              localObject = com.tencent.mm.model.c.awD().vP(localg.field_msglocalid);
              ((bo)localObject).re(localg.field_user);
              ((bo)localObject).oz(localg.field_msgid);
              ((bo)localObject).setStatus(2);
              ((bo)localObject).setContent(f.b(localg.field_human, localg.field_voicelenght, false));
              az.ayM();
              com.tencent.mm.model.c.awD().a(localg.field_msglocalid, (bo)localObject);
              ac.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.ED(paramArrayOfByte);
            }
          }
        }
        if (!h.a(localg)) {
          paramInt1 = -4;
        }
      }
    }
    if (paramInt1 == 1)
    {
      ac.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if (this.icI) {}
    for (l = 0L;; l = 500L)
    {
      ac.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.htR.au(l, l);
      AppMethodBeat.o(28934);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(28932);
    paramq = (dnv)((com.tencent.mm.ak.b)paramq).hvr.hvw;
    ac.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + paramq.EfV + " dataLen:" + paramq.vTK.getILen() + " endFlag:" + paramq.hNR);
    paramq = n.b.hwa;
    AppMethodBeat.o(28932);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(28933);
    h.Ea(this.fileName);
    AppMethodBeat.o(28933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.b
 * JD-Core Version:    0.7.0.1
 */