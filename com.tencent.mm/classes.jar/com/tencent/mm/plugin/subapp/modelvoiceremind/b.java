package com.tencent.mm.plugin.subapp.modelvoiceremind;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.a;
import com.tencent.mm.am.p.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.protocal.protobuf.fui;
import com.tencent.mm.protocal.protobuf.fuj;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import junit.framework.Assert;

public final class b
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private int endFlag;
  String fileName;
  MTimerHandler orP;
  private int pbK;
  private boolean pdm;
  private long pdr;
  int retCode;
  private com.tencent.mm.am.c rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(28930);
    this.retCode = 0;
    this.pbK = 0;
    this.pdm = false;
    this.endFlag = 0;
    this.orP = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28929);
        Object localObject = b.a(b.this);
        localObject = d.hAZ().bcF((String)localObject);
        if ((localObject == null) || (!((g)localObject).bPk()))
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
          c.a locala = h.bcC(b.a(b.this)).anG(((g)localObject).field_offset);
          Log.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.a(b.this) + " readByte:" + locala.hxg + " stat:" + ((g)localObject).field_status);
          if (locala.hxg < 2000)
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
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(28931);
    this.callback = paramh;
    this.pdm = false;
    if (this.fileName == null)
    {
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    paramh = this.fileName;
    g localg = d.hAZ().bcF(paramh);
    if ((localg == null) || (!localg.bPk()))
    {
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + localg.field_nettimes);
    paramh = this.fileName;
    boolean bool;
    if (paramh == null) {
      bool = false;
    }
    while (!bool)
    {
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
      h.Qf(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
      paramh = d.hAZ().bcF(paramh);
      if (paramh == null)
      {
        bool = false;
      }
      else if (paramh.field_nettimes >= 80)
      {
        bool = false;
      }
      else
      {
        paramh.field_nettimes += 1;
        paramh.eQp = 16384;
        bool = h.a(paramh);
      }
    }
    paramh = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      Log.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
      this.endFlag = 1;
      h.QM(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1691;
      }
      j = (this.pbK - 6) / 32 * 20;
    }
    label1691:
    for (;;)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new com.tencent.mm.am.c.a();
      ((com.tencent.mm.am.c.a)localObject).otE = new fui();
      ((com.tencent.mm.am.c.a)localObject).otF = new fuj();
      ((com.tencent.mm.am.c.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((com.tencent.mm.am.c.a)localObject).funcId = 329;
      ((com.tencent.mm.am.c.a)localObject).otG = 157;
      ((com.tencent.mm.am.c.a)localObject).respCmdId = 1000000157;
      this.rr = ((com.tencent.mm.am.c.a)localObject).bEF();
      localObject = (fui)c.b.b(this.rr.otB);
      ((fui)localObject).IMh = z.bAM();
      ((fui)localObject).IMg = localg.field_user;
      ((fui)localObject).YYs = localg.field_offset;
      ((fui)localObject).YHk = localg.field_clientid;
      ((fui)localObject).YWB = j;
      ((fui)localObject).oOu = this.endFlag;
      ((fui)localObject).Njv = localg.field_msgid;
      ((fui)localObject).Zsp = i;
      ((fui)localObject).abSA = ((int)(localg.field_createtime / 1000L));
      ((fui)localObject).aaSO = 1;
      if (((v)com.tencent.mm.kernel.h.az(v.class)).ifAddTicketByActionFlag(localg.field_user)) {
        ((fui)localObject).ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(localg.field_user);
      }
      if (i != 1) {
        ((fui)localObject).NkQ = new gol().ah(paramh.buf, paramh.hxg);
      }
      for (((fui)localObject).YTh = paramh.hxg;; ((fui)localObject).YTh = 1)
      {
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        Log.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((fui)localObject).Njv + " user:" + ((fui)localObject).IMg + " offset:" + ((fui)localObject).YYs + " dataLen:" + ((fui)localObject).NkQ.abwJ + " endFlag:" + ((fui)localObject).oOu);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + paramh.hxg + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.pbK + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.pdr = System.currentTimeMillis();
        i = dispatch(paramg, this.rr, this);
        AppMethodBeat.o(28931);
        return i;
        if (localg.field_status == 3) {
          this.pdm = true;
        }
        paramh = h.bcC(this.fileName);
        if (paramh == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        paramh = paramh.anG(localg.field_offset);
        if (paramh == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        Log.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + paramh.ret + " readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.f.getLine());
        if (paramh.ret < 0)
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + paramh.ret + " readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + localg.field_offset);
          h.Qf(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.pbK = paramh.pbK;
        if ((this.pbK < localg.field_offset) || (this.pbK >= 469000))
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.pbK + " OldtOff:" + localg.field_offset);
          h.Qf(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.endFlag = 0;
        if ((paramh.hxg == 0) && (!this.pdm))
        {
          Log.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.Qf(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        if (this.pdm)
        {
          if (localg.field_totallen <= 0)
          {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.Qf(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if ((localg.field_totallen > this.pbK) && (paramh.hxg < 6000))
          {
            Log.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + paramh.hxg + " newOff:" + paramh.pbK + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.Qf(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if (localg.field_totallen <= this.pbK) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((fui)localObject).NkQ = new gol().m(com.tencent.mm.bx.b.cX(new byte[1]));
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
    paramArrayOfByte = (fui)c.b.b(((com.tencent.mm.am.c)params).otB);
    fuj localfuj = (fuj)c.c.b(((com.tencent.mm.am.c)params).otC);
    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + localfuj.toString());
    if ((localfuj != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((v)com.tencent.mm.kernel.h.az(v.class)).setEnSendMsgActionFlag(localfuj.ZaS);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      params = this.fileName;
      params = d.hAZ().bcF(params);
      if (params != null)
      {
        if (params.field_status == 3)
        {
          bh.bCz();
          paramArrayOfByte = com.tencent.mm.model.c.bzD().sl(params.field_msglocalid);
          paramArrayOfByte.setContent(f.a(params.field_human, params.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          bh.bCz();
          com.tencent.mm.model.c.bzD().a(params.field_msglocalid, paramArrayOfByte);
        }
        params.field_status = 97;
        params.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        params.eQp = 320;
        h.a(params);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.Qf(this.fileName);
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
    Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + localfuj.Njv + " toUser:" + paramArrayOfByte.IMg);
    String str = this.fileName;
    int j = this.pbK;
    long l = localfuj.Njv;
    params = localfuj.YHk;
    int k = this.endFlag;
    if (str == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + localfuj.Njv + " clientId:" + localfuj.YHk + " neWWOff:" + this.pbK + " neTTTT:" + localfuj.YTh);
      if (paramInt1 >= 0) {
        break;
      }
      h.Qf(this.fileName);
      Log.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
      Log.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + str + "] newOff:" + j + " SvrID:" + l + " clientID:" + params + " hasSendEndFlag " + k);
      g localg = d.hAZ().bcF(str);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.eQp = 264;
        if ((Util.isNullOrNil(localg.field_clientid)) && (params != null))
        {
          localg.field_clientid = params;
          localg.eQp |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.eQp |= 0x4;
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
              localg.eQp |= 0x40;
              bh.bCz();
              paramArrayOfByte = com.tencent.mm.model.c.bzD().sl(localg.field_msglocalid);
              params = paramArrayOfByte;
              if (paramArrayOfByte == null)
              {
                Log.e("MicroMsg.VoiceRemindLogic", "updateAfterSend error, cannot get the msgInfo, create a default one");
                params = new cc();
              }
              params.BS(localg.field_user);
              params.gX(localg.field_msgid);
              params.setStatus(2);
              params.setContent(f.a(localg.field_human, localg.field_voicelenght, false));
              bh.bCz();
              com.tencent.mm.model.c.bzD().a(localg.field_msglocalid, params);
              Log.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + str + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.QI(str);
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
    if (this.pdm) {}
    for (l = 0L;; l = 500L)
    {
      Log.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.orP.startTimer(l);
      AppMethodBeat.o(28934);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    AppMethodBeat.i(28932);
    params = (fui)c.b.b(((com.tencent.mm.am.c)params).otB);
    Log.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + params.YYs + " dataLen:" + params.NkQ.abwJ + " endFlag:" + params.oOu);
    params = p.b.ouh;
    AppMethodBeat.o(28932);
    return params;
  }
  
  public final void setSecurityCheckError(p.a parama)
  {
    AppMethodBeat.i(28933);
    h.Qf(this.fileName);
    AppMethodBeat.o(28933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.modelvoiceremind.b
 * JD-Core Version:    0.7.0.1
 */