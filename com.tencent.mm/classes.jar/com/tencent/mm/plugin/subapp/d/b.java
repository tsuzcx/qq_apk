package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.a;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.duj;
import com.tencent.mm.protocal.protobuf.duk;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import junit.framework.Assert;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.ak.f callback;
  private int endFlag;
  String fileName;
  aw hPc;
  private int ixC;
  private boolean iyX;
  long izc;
  int retCode;
  private com.tencent.mm.ak.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(28930);
    this.retCode = 0;
    this.ixC = 0;
    this.iyX = false;
    this.endFlag = 0;
    this.hPc = new aw(new aw.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28929);
        Object localObject = b.this.fileName;
        localObject = d.eqI().aDU((String)localObject);
        if ((localObject == null) || (!((g)localObject).aOa()))
        {
          ae.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + b.this.fileName);
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
            ae.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + b.this.fileName);
            b.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
            AppMethodBeat.o(28929);
            return false;
          }
          if (l - b.this.izc < 2000L)
          {
            ae.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.this.fileName + " but last send time:" + (l - b.this.izc));
            AppMethodBeat.o(28929);
            return true;
          }
          c.a locala = h.aDR(b.this.fileName).To(((g)localObject).field_offset);
          ae.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.this.fileName + " readByte:" + locala.diR + " stat:" + ((g)localObject).field_status);
          if (locala.diR < 2000)
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
      ae.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      AppMethodBeat.o(28930);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(28931);
    this.callback = paramf;
    this.iyX = false;
    if (this.fileName == null)
    {
      ae.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    paramf = this.fileName;
    g localg = d.eqI().aDU(paramf);
    if ((localg == null) || (!localg.aOa()))
    {
      ae.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    ae.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + localg.field_nettimes);
    paramf = this.fileName;
    boolean bool;
    if (paramf == null) {
      bool = false;
    }
    while (!bool)
    {
      ae.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
      h.HR(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
      paramf = d.eqI().aDU(paramf);
      if (paramf == null)
      {
        bool = false;
      }
      else if (paramf.field_nettimes >= 80)
      {
        bool = false;
      }
      else
      {
        paramf.field_nettimes += 1;
        paramf.dEu = 16384;
        bool = h.a(paramf);
      }
    }
    paramf = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      ae.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
      this.endFlag = 1;
      h.Iy(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1672;
      }
      j = (this.ixC - 6) / 32 * 20;
    }
    label1672:
    for (;;)
    {
      ae.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new b.a();
      ((b.a)localObject).hQF = new duj();
      ((b.a)localObject).hQG = new duk();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((b.a)localObject).funcId = 329;
      ((b.a)localObject).hQH = 157;
      ((b.a)localObject).respCmdId = 1000000157;
      this.rr = ((b.a)localObject).aDS();
      localObject = (duj)this.rr.hQD.hQJ;
      ((duj)localObject).uvG = v.aAC();
      ((duj)localObject).uvF = localg.field_user;
      ((duj)localObject).GeT = localg.field_offset;
      ((duj)localObject).FOR = localg.field_clientid;
      ((duj)localObject).Gdb = j;
      ((duj)localObject).ijY = this.endFlag;
      ((duj)localObject).xrk = localg.field_msgid;
      ((duj)localObject).GvZ = i;
      ((duj)localObject).HZY = ((int)(localg.field_createtime / 1000L));
      ((duj)localObject).HlN = 1;
      if (((s)com.tencent.mm.kernel.g.ad(s.class)).ifAddTicketByActionFlag(localg.field_user)) {
        ((duj)localObject).Ghk = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUV(localg.field_user);
      }
      if (i != 1) {
        ((duj)localObject).xsE = new SKBuiltinBuffer_t().setBuffer(paramf.buf, 0, paramf.diR);
      }
      for (((duj)localObject).GaC = paramf.diR;; ((duj)localObject).GaC = 1)
      {
        ae.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        ae.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((duj)localObject).xrk + " user:" + ((duj)localObject).uvF + " offset:" + ((duj)localObject).GeT + " dataLen:" + ((duj)localObject).xsE.getILen() + " endFlag:" + ((duj)localObject).ijY);
        ae.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + paramf.diR + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.ixC + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        ae.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.izc = System.currentTimeMillis();
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(28931);
        return i;
        if (localg.field_status == 3) {
          this.iyX = true;
        }
        paramf = h.aDR(this.fileName);
        if (paramf == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        paramf = paramf.To(localg.field_offset);
        ae.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.f.getLine());
        if (paramf.ret < 0)
        {
          ae.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + localg.field_offset);
          h.HR(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.ixC = paramf.ixC;
        if ((this.ixC < localg.field_offset) || (this.ixC >= 469000))
        {
          ae.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.ixC + " OldtOff:" + localg.field_offset);
          h.HR(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.endFlag = 0;
        if ((paramf.diR == 0) && (!this.iyX))
        {
          ae.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.HR(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        if (this.iyX)
        {
          if (localg.field_totallen <= 0)
          {
            ae.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.HR(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if ((localg.field_totallen > this.ixC) && (paramf.diR < 6000))
          {
            ae.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + paramf.diR + " newOff:" + paramf.ixC + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.HR(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if (localg.field_totallen <= this.ixC) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((duj)localObject).xsE = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cm(new byte[1]));
      }
    }
  }
  
  public final int getType()
  {
    return 329;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28934);
    ae.i("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (duj)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    paramq = (duk)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    ae.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + paramq.toString());
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((s)com.tencent.mm.kernel.g.ad(s.class)).setEnSendMsgActionFlag(paramq.Ghl);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      paramq = this.fileName;
      paramq = d.eqI().aDU(paramq);
      if (paramq != null)
      {
        if (paramq.field_status == 3)
        {
          bc.aCg();
          paramArrayOfByte = com.tencent.mm.model.c.azI().ys(paramq.field_msglocalid);
          paramArrayOfByte.setContent(f.b(paramq.field_human, paramq.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          bc.aCg();
          com.tencent.mm.model.c.azI().a(paramq.field_msglocalid, paramArrayOfByte);
        }
        paramq.field_status = 97;
        paramq.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        paramq.dEu = 320;
        h.a(paramq);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.HR(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    ae.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + paramq.xrk + " toUser:" + paramArrayOfByte.uvF);
    paramArrayOfByte = this.fileName;
    int j = this.ixC;
    long l = paramq.xrk;
    Object localObject = paramq.FOR;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      ae.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.xrk + " clientId:" + paramq.FOR + " neWWOff:" + this.ixC + " neTTTT:" + paramq.GaC);
      if (paramInt1 >= 0) {
        break;
      }
      h.HR(this.fileName);
      ae.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
      ae.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = d.eqI().aDU(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.dEu = 264;
        if ((bu.isNullOrNil(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.dEu |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.dEu |= 0x4;
        }
        int i = 0;
        ae.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + localg.field_totallen + "  newOffset " + j + "  " + localg.field_status);
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
              localg.dEu |= 0x40;
              bc.aCg();
              localObject = com.tencent.mm.model.c.azI().ys(localg.field_msglocalid);
              ((bv)localObject).ui(localg.field_user);
              ((bv)localObject).qM(localg.field_msgid);
              ((bv)localObject).setStatus(2);
              ((bv)localObject).setContent(f.b(localg.field_human, localg.field_voicelenght, false));
              bc.aCg();
              com.tencent.mm.model.c.azI().a(localg.field_msglocalid, (bv)localObject);
              ae.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.Iu(paramArrayOfByte);
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
      ae.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if (this.iyX) {}
    for (l = 0L;; l = 500L)
    {
      ae.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.hPc.ay(l, l);
      AppMethodBeat.o(28934);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(28932);
    paramq = (duj)((com.tencent.mm.ak.b)paramq).hQD.hQJ;
    ae.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + paramq.GeT + " dataLen:" + paramq.xsE.getILen() + " endFlag:" + paramq.ijY);
    paramq = n.b.hRi;
    AppMethodBeat.o(28932);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(28933);
    h.HR(this.fileName);
    AppMethodBeat.o(28933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.b
 * JD-Core Version:    0.7.0.1
 */