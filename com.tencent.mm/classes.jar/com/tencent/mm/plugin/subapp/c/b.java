package com.tencent.mm.plugin.subapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.a;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cpa;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import junit.framework.Assert;

public final class b
  extends m
  implements com.tencent.mm.network.k
{
  com.tencent.mm.ai.f callback;
  private int endFlag;
  private int fXX;
  private boolean fZu;
  long fZz;
  String fileName;
  ap frx;
  int retCode;
  private com.tencent.mm.ai.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(25251);
    this.retCode = 0;
    this.fXX = 0;
    this.fZu = false;
    this.endFlag = 0;
    this.frx = new ap(new b.1(this), true);
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      ab.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:".concat(String.valueOf(paramString)));
      this.fileName = paramString;
      AppMethodBeat.o(25251);
      return;
      bool = false;
    }
  }
  
  public final int doScene(e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(25252);
    this.callback = paramf;
    this.fZu = false;
    if (this.fileName == null)
    {
      ab.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      AppMethodBeat.o(25252);
      return -1;
    }
    paramf = this.fileName;
    g localg = d.cGT().adV(paramf);
    if ((localg == null) || (!localg.amw()))
    {
      ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      AppMethodBeat.o(25252);
      return -1;
    }
    ab.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + localg.field_nettimes);
    paramf = this.fileName;
    boolean bool;
    if (paramf == null) {
      bool = false;
    }
    while (!bool)
    {
      ab.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
      h.vk(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      AppMethodBeat.o(25252);
      return -1;
      paramf = d.cGT().adV(paramf);
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
        paramf.bsY = 16384;
        bool = h.a(paramf);
      }
    }
    paramf = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      ab.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
      this.endFlag = 1;
      h.vP(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1621;
      }
      j = (this.fXX - 6) / 32 * 20;
    }
    label1621:
    for (;;)
    {
      ab.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new b.a();
      ((b.a)localObject).fsX = new cpa();
      ((b.a)localObject).fsY = new cpb();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((b.a)localObject).funcId = 329;
      ((b.a)localObject).reqCmdId = 157;
      ((b.a)localObject).respCmdId = 1000000157;
      this.rr = ((b.a)localObject).ado();
      localObject = (cpa)this.rr.fsV.fta;
      ((cpa)localObject).num = r.Zn();
      ((cpa)localObject).nul = localg.field_user;
      ((cpa)localObject).wzS = localg.field_offset;
      ((cpa)localObject).wpS = localg.field_clientid;
      ((cpa)localObject).wAr = j;
      ((cpa)localObject).fKi = this.endFlag;
      ((cpa)localObject).pIG = localg.field_msgid;
      ((cpa)localObject).wPU = i;
      ((cpa)localObject).xXO = ((int)(localg.field_createtime / 1000L));
      ((cpa)localObject).xrK = 1;
      if (i != 1) {
        ((cpa)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(paramf.buf, 0, paramf.ckj);
      }
      for (((cpa)localObject).wyT = paramf.ckj;; ((cpa)localObject).wyT = 1)
      {
        ab.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        ab.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((cpa)localObject).pIG + " user:" + ((cpa)localObject).nul + " offset:" + ((cpa)localObject).wzS + " dataLen:" + ((cpa)localObject).pIA.getILen() + " endFlag:" + ((cpa)localObject).fKi);
        ab.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + paramf.ckj + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.fXX + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        ab.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.fZz = System.currentTimeMillis();
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(25252);
        return i;
        if (localg.field_status == 3) {
          this.fZu = true;
        }
        paramf = h.adS(this.fileName);
        if (paramf == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          AppMethodBeat.o(25252);
          return -1;
        }
        paramf = paramf.Gl(localg.field_offset);
        ab.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.g.getLine());
        if (paramf.ret < 0)
        {
          ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + localg.field_offset);
          h.vk(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          AppMethodBeat.o(25252);
          return -1;
        }
        this.fXX = paramf.fXX;
        if ((this.fXX < localg.field_offset) || (this.fXX >= 469000))
        {
          ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.fXX + " OldtOff:" + localg.field_offset);
          h.vk(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          AppMethodBeat.o(25252);
          return -1;
        }
        this.endFlag = 0;
        if ((paramf.ckj == 0) && (!this.fZu))
        {
          ab.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.vk(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          AppMethodBeat.o(25252);
          return -1;
        }
        if (this.fZu)
        {
          if (localg.field_totallen <= 0)
          {
            ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.vk(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
            AppMethodBeat.o(25252);
            return -1;
          }
          if ((localg.field_totallen > this.fXX) && (paramf.ckj < 6000))
          {
            ab.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + paramf.ckj + " newOff:" + paramf.fXX + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.vk(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
            AppMethodBeat.o(25252);
            return -1;
          }
          if (localg.field_totallen <= this.fXX) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((cpa)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bv.b.bL(new byte[1]));
      }
    }
  }
  
  public final int getType()
  {
    return 329;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(25255);
    ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (cpa)((com.tencent.mm.ai.b)paramq).fsV.fta;
    paramq = (cpb)((com.tencent.mm.ai.b)paramq).fsW.fta;
    ab.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + paramq.toString());
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      paramq = this.fileName;
      paramq = d.cGT().adV(paramq);
      if (paramq != null)
      {
        if (paramq.field_status == 3)
        {
          aw.aaz();
          paramArrayOfByte = com.tencent.mm.model.c.YC().kB(paramq.field_msglocalid);
          paramArrayOfByte.setContent(f.d(paramq.field_human, paramq.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          aw.aaz();
          com.tencent.mm.model.c.YC().a(paramq.field_msglocalid, paramArrayOfByte);
        }
        paramq.field_status = 97;
        paramq.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        paramq.bsY = 320;
        h.a(paramq);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25255);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.vk(this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25255);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25255);
      return;
    }
    ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + paramq.pIG + " toUser:" + paramArrayOfByte.nul);
    paramArrayOfByte = this.fileName;
    int j = this.fXX;
    long l = paramq.pIG;
    Object localObject = paramq.wpS;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.pIG + " clientId:" + paramq.wpS + " neWWOff:" + this.fXX + " neTTTT:" + paramq.wyT);
      if (paramInt1 >= 0) {
        break;
      }
      h.vk(this.fileName);
      ab.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25255);
      return;
      ab.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = d.cGT().adV(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.bsY = 264;
        if ((bo.isNullOrNil(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.bsY |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.bsY |= 0x4;
        }
        int i = 0;
        ab.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + localg.field_totallen + "  newOffset " + j + "  " + localg.field_status);
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
              localg.bsY |= 0x40;
              aw.aaz();
              localObject = com.tencent.mm.model.c.YC().kB(localg.field_msglocalid);
              ((bi)localObject).kj(localg.field_user);
              ((bi)localObject).fP(localg.field_msgid);
              ((bi)localObject).setStatus(2);
              ((bi)localObject).setContent(f.d(localg.field_human, localg.field_voicelenght, false));
              aw.aaz();
              com.tencent.mm.model.c.YC().a(localg.field_msglocalid, (bi)localObject);
              ab.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.vL(paramArrayOfByte);
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
      ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(25255);
      return;
    }
    if (this.fZu) {}
    for (l = 0L;; l = 500L)
    {
      ab.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.frx.ag(l, l);
      AppMethodBeat.o(25255);
      return;
    }
  }
  
  public final int securityLimitCount()
  {
    return 240;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    AppMethodBeat.i(25253);
    paramq = (cpa)((com.tencent.mm.ai.b)paramq).fsV.fta;
    ab.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + paramq.wzS + " dataLen:" + paramq.pIA.getILen() + " endFlag:" + paramq.fKi);
    paramq = m.b.ftu;
    AppMethodBeat.o(25253);
    return paramq;
  }
  
  public final void setSecurityCheckError(m.a parama)
  {
    AppMethodBeat.i(25254);
    h.vk(this.fileName);
    AppMethodBeat.o(25254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.b
 * JD-Core Version:    0.7.0.1
 */