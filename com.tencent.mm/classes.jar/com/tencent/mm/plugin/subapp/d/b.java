package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.a;
import com.tencent.mm.an.q.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.eyp;
import com.tencent.mm.protocal.protobuf.eyq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import junit.framework.Assert;

public final class b
  extends q
  implements m
{
  private com.tencent.mm.an.i callback;
  private int endFlag;
  String fileName;
  MTimerHandler lAo;
  private int miv;
  private boolean mjP;
  private long mjU;
  int retCode;
  private com.tencent.mm.an.d rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(28930);
    this.retCode = 0;
    this.miv = 0;
    this.mjP = false;
    this.endFlag = 0;
    this.lAo = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28929);
        Object localObject = b.a(b.this);
        localObject = d.ghG().bdT((String)localObject);
        if ((localObject == null) || (!((g)localObject).brE()))
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + b.a(b.this));
          b.a(b.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
          b.b(b.this).onSceneEnd(3, -1, "doScene failed", b.this);
          AppMethodBeat.o(28929);
          return false;
        }
        if ((3 != ((g)localObject).field_status) && (8 != ((g)localObject).field_status))
        {
          long l = System.currentTimeMillis();
          if (l / 1000L - ((g)localObject).field_lastmodifytime > 30L)
          {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + b.a(b.this));
            b.a(b.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
            b.b(b.this).onSceneEnd(3, -1, "doScene failed", b.this);
            AppMethodBeat.o(28929);
            return false;
          }
          if (l - b.c(b.this) < 2000L)
          {
            Log.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.a(b.this) + " but last send time:" + (l - b.c(b.this)));
            AppMethodBeat.o(28929);
            return true;
          }
          c.a locala = h.bdQ(b.a(b.this)).aiF(((g)localObject).field_offset);
          Log.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.a(b.this) + " readByte:" + locala.fsR + " stat:" + ((g)localObject).field_status);
          if (locala.fsR < 2000)
          {
            AppMethodBeat.o(28929);
            return true;
          }
        }
        if (b.this.doScene(b.d(b.this), b.b(b.this)) == -1)
        {
          b.a(b.this, com.tencent.mm.compatible.util.f.getLine() + 10000);
          b.b(b.this).onSceneEnd(3, -1, "doScene failed", b.this);
        }
        AppMethodBeat.o(28929);
        return false;
      }
    }, true);
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      AppMethodBeat.o(28930);
      return;
      bool = false;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(28931);
    this.callback = parami;
    this.mjP = false;
    if (this.fileName == null)
    {
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    parami = this.fileName;
    g localg = d.ghG().bdT(parami);
    if ((localg == null) || (!localg.brE()))
    {
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + localg.field_nettimes);
    parami = this.fileName;
    boolean bool;
    if (parami == null) {
      bool = false;
    }
    while (!bool)
    {
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
      h.Yb(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
      parami = d.ghG().bdT(parami);
      if (parami == null)
      {
        bool = false;
      }
      else if (parami.field_nettimes >= 80)
      {
        bool = false;
      }
      else
      {
        parami.field_nettimes += 1;
        parami.cUP = 16384;
        bool = h.a(parami);
      }
    }
    parami = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      Log.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
      this.endFlag = 1;
      h.YH(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1671;
      }
      j = (this.miv - 6) / 32 * 20;
    }
    label1671:
    for (;;)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new d.a();
      ((d.a)localObject).lBU = new eyp();
      ((d.a)localObject).lBV = new eyq();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((d.a)localObject).funcId = 329;
      ((d.a)localObject).lBW = 157;
      ((d.a)localObject).respCmdId = 1000000157;
      this.rr = ((d.a)localObject).bgN();
      localObject = (eyp)d.b.b(this.rr.lBR);
      ((eyp)localObject).CRR = z.bcZ();
      ((eyp)localObject).CRQ = localg.field_user;
      ((eyp)localObject).Sat = localg.field_offset;
      ((eyp)localObject).RJQ = localg.field_clientid;
      ((eyp)localObject).RYC = j;
      ((eyp)localObject).lVs = this.endFlag;
      ((eyp)localObject).HlH = localg.field_msgid;
      ((eyp)localObject).Stc = i;
      ((eyp)localObject).UyR = ((int)(localg.field_createtime / 1000L));
      ((eyp)localObject).TDg = 1;
      if (((v)com.tencent.mm.kernel.h.ag(v.class)).ifAddTicketByActionFlag(localg.field_user)) {
        ((eyp)localObject).ScZ = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bws(localg.field_user);
      }
      if (i != 1) {
        ((eyp)localObject).Hnc = new eae().ag(parami.buf, parami.fsR);
      }
      for (((eyp)localObject).RVD = parami.fsR;; ((eyp)localObject).RVD = 1)
      {
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((eyp)localObject).HlH + " user:" + ((eyp)localObject).CRQ + " offset:" + ((eyp)localObject).Sat + " dataLen:" + ((eyp)localObject).Hnc.Ufv + " endFlag:" + ((eyp)localObject).lVs);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + parami.fsR + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.miv + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.mjU = System.currentTimeMillis();
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(28931);
        return i;
        if (localg.field_status == 3) {
          this.mjP = true;
        }
        parami = h.bdQ(this.fileName);
        if (parami == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        parami = parami.aiF(localg.field_offset);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.f.getLine());
        if (parami.ret < 0)
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + localg.field_offset);
          h.Yb(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.miv = parami.miv;
        if ((this.miv < localg.field_offset) || (this.miv >= 469000))
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.miv + " OldtOff:" + localg.field_offset);
          h.Yb(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.endFlag = 0;
        if ((parami.fsR == 0) && (!this.mjP))
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.Yb(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        if (this.mjP)
        {
          if (localg.field_totallen <= 0)
          {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.Yb(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if ((localg.field_totallen > this.miv) && (parami.fsR < 6000))
          {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + parami.fsR + " newOff:" + parami.miv + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.Yb(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if (localg.field_totallen <= this.miv) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((eyp)localObject).Hnc = new eae().g(com.tencent.mm.cd.b.cU(new byte[1]));
      }
    }
  }
  
  public final int getType()
  {
    return 329;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28934);
    Log.i("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (eyp)d.b.b(((com.tencent.mm.an.d)params).lBR);
    params = (eyq)d.c.b(((com.tencent.mm.an.d)params).lBS);
    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + params.toString());
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)com.tencent.mm.kernel.h.ag(v.class)).setEnSendMsgActionFlag(params.Sda);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      params = this.fileName;
      params = d.ghG().bdT(params);
      if (params != null)
      {
        if (params.field_status == 3)
        {
          bh.beI();
          paramArrayOfByte = com.tencent.mm.model.c.bbO().Oq(params.field_msglocalid);
          paramArrayOfByte.setContent(f.a(params.field_human, params.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          bh.beI();
          com.tencent.mm.model.c.bbO().a(params.field_msglocalid, paramArrayOfByte);
        }
        params.field_status = 97;
        params.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        params.cUP = 320;
        h.a(params);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.Yb(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + params.HlH + " toUser:" + paramArrayOfByte.CRQ);
    paramArrayOfByte = this.fileName;
    int j = this.miv;
    long l = params.HlH;
    Object localObject = params.RJQ;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + params.HlH + " clientId:" + params.RJQ + " neWWOff:" + this.miv + " neTTTT:" + params.RVD);
      if (paramInt1 >= 0) {
        break;
      }
      h.Yb(this.fileName);
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
      Log.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = d.ghG().bdT(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.cUP = 264;
        if ((Util.isNullOrNil(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.cUP |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.cUP |= 0x4;
        }
        int i = 0;
        Log.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + localg.field_totallen + "  newOffset " + j + "  " + localg.field_status);
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
              localg.cUP |= 0x40;
              bh.beI();
              localObject = com.tencent.mm.model.c.bbO().Oq(localg.field_msglocalid);
              ((ca)localObject).Jm(localg.field_user);
              ((ca)localObject).EG(localg.field_msgid);
              ((ca)localObject).setStatus(2);
              ((ca)localObject).setContent(f.a(localg.field_human, localg.field_voicelenght, false));
              bh.beI();
              com.tencent.mm.model.c.bbO().a(localg.field_msglocalid, (ca)localObject);
              Log.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.YD(paramArrayOfByte);
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
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if (this.mjP) {}
    for (l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.lAo.startTimer(l);
      AppMethodBeat.o(28934);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(28932);
    params = (eyp)d.b.b(((com.tencent.mm.an.d)params).lBR);
    Log.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + params.Sat + " dataLen:" + params.Hnc.Ufv + " endFlag:" + params.lVs);
    params = q.b.lCx;
    AppMethodBeat.o(28932);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(28933);
    h.Yb(this.fileName);
    AppMethodBeat.o(28933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.b
 * JD-Core Version:    0.7.0.1
 */