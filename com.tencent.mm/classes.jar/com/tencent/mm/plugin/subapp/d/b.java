package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.q.a;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.eoi;
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
  com.tencent.mm.ak.i callback;
  private int endFlag;
  String fileName;
  MTimerHandler iKj;
  private int jsR;
  private boolean jul;
  long juq;
  int retCode;
  private com.tencent.mm.ak.d rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(28930);
    this.retCode = 0;
    this.jsR = 0;
    this.jul = false;
    this.endFlag = 0;
    this.iKj = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28929);
        Object localObject = b.this.fileName;
        localObject = d.fth().aSP((String)localObject);
        if ((localObject == null) || (!((g)localObject).big()))
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + b.this.fileName);
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
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Error ModifyTime in Read file:" + b.this.fileName);
            b.this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            b.this.callback.onSceneEnd(3, -1, "doScene failed", b.this);
            AppMethodBeat.o(28929);
            return false;
          }
          if (l - b.this.juq < 2000L)
          {
            Log.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.this.fileName + " but last send time:" + (l - b.this.juq));
            AppMethodBeat.o(28929);
            return true;
          }
          c.a locala = h.aSM(b.this.fileName).abk(((g)localObject).field_offset);
          Log.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.this.fileName + " readByte:" + locala.dAc + " stat:" + ((g)localObject).field_status);
          if (locala.dAc < 2000)
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
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      AppMethodBeat.o(28930);
      return;
      bool = false;
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(28931);
    this.callback = parami;
    this.jul = false;
    if (this.fileName == null)
    {
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    parami = this.fileName;
    g localg = d.fth().aSP(parami);
    if ((localg == null) || (!localg.big()))
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
      h.QE(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
      parami = d.fth().aSP(parami);
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
        parami.cSx = 16384;
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
      h.Rk(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1672;
      }
      j = (this.jsR - 6) / 32 * 20;
    }
    label1672:
    for (;;)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new d.a();
      ((d.a)localObject).iLN = new eoh();
      ((d.a)localObject).iLO = new eoi();
      ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((d.a)localObject).funcId = 329;
      ((d.a)localObject).iLP = 157;
      ((d.a)localObject).respCmdId = 1000000157;
      this.rr = ((d.a)localObject).aXF();
      localObject = (eoh)this.rr.iLK.iLR;
      ((eoh)localObject).xNH = z.aTY();
      ((eoh)localObject).xNG = localg.field_user;
      ((eoh)localObject).KZk = localg.field_offset;
      ((eoh)localObject).KIz = localg.field_clientid;
      ((eoh)localObject).KXq = j;
      ((eoh)localObject).jeU = this.endFlag;
      ((eoh)localObject).Brn = localg.field_msgid;
      ((eoh)localObject).LrF = i;
      ((eoh)localObject).Nmf = ((int)(localg.field_createtime / 1000L));
      ((eoh)localObject).Msa = 1;
      if (((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).ifAddTicketByActionFlag(localg.field_user)) {
        ((eoh)localObject).LbN = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().bjT(localg.field_user);
      }
      if (i != 1) {
        ((eoh)localObject).BsI = new SKBuiltinBuffer_t().setBuffer(parami.buf, 0, parami.dAc);
      }
      for (((eoh)localObject).KUy = parami.dAc;; ((eoh)localObject).KUy = 1)
      {
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((eoh)localObject).Brn + " user:" + ((eoh)localObject).xNG + " offset:" + ((eoh)localObject).KZk + " dataLen:" + ((eoh)localObject).BsI.getILen() + " endFlag:" + ((eoh)localObject).jeU);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + parami.dAc + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.jsR + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.juq = System.currentTimeMillis();
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(28931);
        return i;
        if (localg.field_status == 3) {
          this.jul = true;
        }
        parami = h.aSM(this.fileName);
        if (parami == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        parami = parami.abk(localg.field_offset);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.f.getLine());
        if (parami.ret < 0)
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + parami.ret + " readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + localg.field_offset);
          h.QE(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.jsR = parami.jsR;
        if ((this.jsR < localg.field_offset) || (this.jsR >= 469000))
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.jsR + " OldtOff:" + localg.field_offset);
          h.QE(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.endFlag = 0;
        if ((parami.dAc == 0) && (!this.jul))
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.QE(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        if (this.jul)
        {
          if (localg.field_totallen <= 0)
          {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.QE(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if ((localg.field_totallen > this.jsR) && (parami.dAc < 6000))
          {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + parami.dAc + " newOff:" + parami.jsR + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.QE(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if (localg.field_totallen <= this.jsR) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((eoh)localObject).BsI = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bw.b.cD(new byte[1]));
      }
    }
  }
  
  public final int getType()
  {
    return 329;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(28934);
    Log.i("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (eoh)((com.tencent.mm.ak.d)params).iLK.iLR;
    params = (eoi)((com.tencent.mm.ak.d)params).iLL.iLR;
    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + params.toString());
    if ((params != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.s)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setEnSendMsgActionFlag(params.LbO);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      params = this.fileName;
      params = d.fth().aSP(params);
      if (params != null)
      {
        if (params.field_status == 3)
        {
          bg.aVF();
          paramArrayOfByte = com.tencent.mm.model.c.aSQ().Hb(params.field_msglocalid);
          paramArrayOfByte.setContent(f.b(params.field_human, params.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          bg.aVF();
          com.tencent.mm.model.c.aSQ().a(params.field_msglocalid, paramArrayOfByte);
        }
        params.field_status = 97;
        params.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        params.cSx = 320;
        h.a(params);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.QE(this.fileName);
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
    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + params.Brn + " toUser:" + paramArrayOfByte.xNG);
    paramArrayOfByte = this.fileName;
    int j = this.jsR;
    long l = params.Brn;
    Object localObject = params.KIz;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + params.Brn + " clientId:" + params.KIz + " neWWOff:" + this.jsR + " neTTTT:" + params.KUy);
      if (paramInt1 >= 0) {
        break;
      }
      h.QE(this.fileName);
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
      Log.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = d.fth().aSP(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.cSx = 264;
        if ((Util.isNullOrNil(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.cSx |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.cSx |= 0x4;
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
              localg.cSx |= 0x40;
              bg.aVF();
              localObject = com.tencent.mm.model.c.aSQ().Hb(localg.field_msglocalid);
              ((ca)localObject).Cy(localg.field_user);
              ((ca)localObject).yF(localg.field_msgid);
              ((ca)localObject).setStatus(2);
              ((ca)localObject).setContent(f.b(localg.field_human, localg.field_voicelenght, false));
              bg.aVF();
              com.tencent.mm.model.c.aSQ().a(localg.field_msglocalid, (ca)localObject);
              Log.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.Rg(paramArrayOfByte);
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
    if (this.jul) {}
    for (l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.iKj.startTimer(l);
      AppMethodBeat.o(28934);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(28932);
    params = (eoh)((com.tencent.mm.ak.d)params).iLK.iLR;
    Log.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + params.KZk + " dataLen:" + params.BsI.getILen() + " endFlag:" + params.jeU);
    params = q.b.iMq;
    AppMethodBeat.o(28932);
    return params;
  }
  
  public final void setSecurityCheckError(q.a parama)
  {
    AppMethodBeat.i(28933);
    h.QE(this.fileName);
    AppMethodBeat.o(28933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.b
 * JD-Core Version:    0.7.0.1
 */