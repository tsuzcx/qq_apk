package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dtm;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import junit.framework.Assert;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.al.f callback;
  private int endFlag;
  String fileName;
  av hMj;
  private int iuI;
  private boolean iwe;
  long iwj;
  int retCode;
  private com.tencent.mm.al.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(28930);
    this.retCode = 0;
    this.iuI = 0;
    this.iwe = false;
    this.endFlag = 0;
    this.hMj = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28929);
        Object localObject = b.this.fileName;
        localObject = d.emZ().aCB((String)localObject);
        if ((localObject == null) || (!((g)localObject).aNC()))
        {
          ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + b.this.fileName);
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
            ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + b.this.fileName);
            b.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
            AppMethodBeat.o(28929);
            return false;
          }
          if (l - b.this.iwj < 2000L)
          {
            ad.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.this.fileName + " but last send time:" + (l - b.this.iwj));
            AppMethodBeat.o(28929);
            return true;
          }
          c.a locala = h.aCy(b.this.fileName).SH(((g)localObject).field_offset);
          ad.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.this.fileName + " readByte:" + locala.dhO + " stat:" + ((g)localObject).field_status);
          if (locala.dhO < 2000)
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
      ad.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      AppMethodBeat.o(28930);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(28931);
    this.callback = paramf;
    this.iwe = false;
    if (this.fileName == null)
    {
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    paramf = this.fileName;
    g localg = d.emZ().aCB(paramf);
    if ((localg == null) || (!localg.aNC()))
    {
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    ad.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + localg.field_nettimes);
    paramf = this.fileName;
    boolean bool;
    if (paramf == null) {
      bool = false;
    }
    while (!bool)
    {
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
      h.Hp(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
      paramf = d.emZ().aCB(paramf);
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
        paramf.dDp = 16384;
        bool = h.a(paramf);
      }
    }
    paramf = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      ad.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
      this.endFlag = 1;
      h.HW(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1672;
      }
      j = (this.iuI - 6) / 32 * 20;
    }
    label1672:
    for (;;)
    {
      ad.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new b.a();
      ((b.a)localObject).hNM = new dtm();
      ((b.a)localObject).hNN = new dtn();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((b.a)localObject).funcId = 329;
      ((b.a)localObject).hNO = 157;
      ((b.a)localObject).respCmdId = 1000000157;
      this.rr = ((b.a)localObject).aDC();
      localObject = (dtm)this.rr.hNK.hNQ;
      ((dtm)localObject).ukj = u.aAm();
      ((dtm)localObject).uki = localg.field_user;
      ((dtm)localObject).FMu = localg.field_offset;
      ((dtm)localObject).Fwt = localg.field_clientid;
      ((dtm)localObject).FKC = j;
      ((dtm)localObject).ihf = this.endFlag;
      ((dtm)localObject).xbt = localg.field_msgid;
      ((dtm)localObject).Gds = i;
      ((dtm)localObject).HGl = ((int)(localg.field_createtime / 1000L));
      ((dtm)localObject).GSm = 1;
      if (((r)com.tencent.mm.kernel.g.ad(r.class)).ifAddTicketByActionFlag(localg.field_user)) {
        ((dtm)localObject).FOL = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTu(localg.field_user);
      }
      if (i != 1) {
        ((dtm)localObject).xcN = new SKBuiltinBuffer_t().setBuffer(paramf.buf, 0, paramf.dhO);
      }
      for (((dtm)localObject).FIg = paramf.dhO;; ((dtm)localObject).FIg = 1)
      {
        ad.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        ad.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((dtm)localObject).xbt + " user:" + ((dtm)localObject).uki + " offset:" + ((dtm)localObject).FMu + " dataLen:" + ((dtm)localObject).xcN.getILen() + " endFlag:" + ((dtm)localObject).ihf);
        ad.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + paramf.dhO + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.iuI + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        ad.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.iwj = System.currentTimeMillis();
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(28931);
        return i;
        if (localg.field_status == 3) {
          this.iwe = true;
        }
        paramf = h.aCy(this.fileName);
        if (paramf == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        paramf = paramf.SH(localg.field_offset);
        ad.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.dhO + " newOff:" + paramf.iuI + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.f.getLine());
        if (paramf.ret < 0)
        {
          ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.dhO + " newOff:" + paramf.iuI + " netOff:" + localg.field_offset);
          h.Hp(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.iuI = paramf.iuI;
        if ((this.iuI < localg.field_offset) || (this.iuI >= 469000))
        {
          ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.iuI + " OldtOff:" + localg.field_offset);
          h.Hp(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.endFlag = 0;
        if ((paramf.dhO == 0) && (!this.iwe))
        {
          ad.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.Hp(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        if (this.iwe)
        {
          if (localg.field_totallen <= 0)
          {
            ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.Hp(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if ((localg.field_totallen > this.iuI) && (paramf.dhO < 6000))
          {
            ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + paramf.dhO + " newOff:" + paramf.iuI + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.Hp(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if (localg.field_totallen <= this.iuI) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((dtm)localObject).xcN = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bx.b.cj(new byte[1]));
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
    ad.i("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dtm)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    paramq = (dtn)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    ad.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + paramq.toString());
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((r)com.tencent.mm.kernel.g.ad(r.class)).setEnSendMsgActionFlag(paramq.FOM);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      paramq = this.fileName;
      paramq = d.emZ().aCB(paramq);
      if (paramq != null)
      {
        if (paramq.field_status == 3)
        {
          ba.aBQ();
          paramArrayOfByte = com.tencent.mm.model.c.azs().xY(paramq.field_msglocalid);
          paramArrayOfByte.setContent(f.b(paramq.field_human, paramq.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          ba.aBQ();
          com.tencent.mm.model.c.azs().a(paramq.field_msglocalid, paramArrayOfByte);
        }
        paramq.field_status = 97;
        paramq.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        paramq.dDp = 320;
        h.a(paramq);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.Hp(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    ad.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + paramq.xbt + " toUser:" + paramArrayOfByte.uki);
    paramArrayOfByte = this.fileName;
    int j = this.iuI;
    long l = paramq.xbt;
    Object localObject = paramq.Fwt;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.xbt + " clientId:" + paramq.Fwt + " neWWOff:" + this.iuI + " neTTTT:" + paramq.FIg);
      if (paramInt1 >= 0) {
        break;
      }
      h.Hp(this.fileName);
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
      ad.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = d.emZ().aCB(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.dDp = 264;
        if ((bt.isNullOrNil(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.dDp |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.dDp |= 0x4;
        }
        int i = 0;
        ad.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + localg.field_totallen + "  newOffset " + j + "  " + localg.field_status);
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
              localg.dDp |= 0x40;
              ba.aBQ();
              localObject = com.tencent.mm.model.c.azs().xY(localg.field_msglocalid);
              ((bu)localObject).tN(localg.field_user);
              ((bu)localObject).qz(localg.field_msgid);
              ((bu)localObject).setStatus(2);
              ((bu)localObject).setContent(f.b(localg.field_human, localg.field_voicelenght, false));
              ba.aBQ();
              com.tencent.mm.model.c.azs().a(localg.field_msglocalid, (bu)localObject);
              ad.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.HS(paramArrayOfByte);
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
      ad.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if (this.iwe) {}
    for (l = 0L;; l = 500L)
    {
      ad.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.hMj.az(l, l);
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
    paramq = (dtm)((com.tencent.mm.al.b)paramq).hNK.hNQ;
    ad.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + paramq.FMu + " dataLen:" + paramq.xcN.getILen() + " endFlag:" + paramq.ihf);
    paramq = n.b.hOp;
    AppMethodBeat.o(28932);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(28933);
    h.Hp(this.fileName);
    AppMethodBeat.o(28933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.b
 * JD-Core Version:    0.7.0.1
 */