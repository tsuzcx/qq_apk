package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.a;
import com.tencent.mm.al.n.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dig;
import com.tencent.mm.protocal.protobuf.dih;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import junit.framework.Assert;

public final class b
  extends n
  implements com.tencent.mm.network.k
{
  com.tencent.mm.al.g callback;
  private int endFlag;
  String fileName;
  av gTs;
  private int hAL;
  private boolean hCh;
  long hCm;
  int retCode;
  private com.tencent.mm.al.b rr;
  
  public b(String paramString)
  {
    AppMethodBeat.i(28930);
    this.retCode = 0;
    this.hAL = 0;
    this.hCh = false;
    this.endFlag = 0;
    this.gTs = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(28929);
        Object localObject = b.this.fileName;
        localObject = d.dMj().aso((String)localObject);
        if ((localObject == null) || (!((g)localObject).aDC()))
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
          if (l - b.this.hCm < 2000L)
          {
            ad.d("MicroMsg.NetSceneUploadVoiceRemind", "TimerExpired :" + b.this.fileName + " but last send time:" + (l - b.this.hCm));
            AppMethodBeat.o(28929);
            return true;
          }
          c.a locala = h.asl(b.this.fileName).OS(((g)localObject).field_offset);
          ad.d("MicroMsg.NetSceneUploadVoiceRemind", "pusher doscene:" + b.this.fileName + " readByte:" + locala.cZc + " stat:" + ((g)localObject).field_status);
          if (locala.cZc < 2000)
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
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(28931);
    this.callback = paramg;
    this.hCh = false;
    if (this.fileName == null)
    {
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    paramg = this.fileName;
    g localg = d.dMj().aso(paramg);
    if ((localg == null) || (!localg.aDC()))
    {
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
    }
    ad.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + localg.field_nettimes);
    paramg = this.fileName;
    boolean bool;
    if (paramg == null) {
      bool = false;
    }
    while (!bool)
    {
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
      h.zV(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
      AppMethodBeat.o(28931);
      return -1;
      paramg = d.dMj().aso(paramg);
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
        paramg.dtM = 16384;
        bool = h.a(paramg);
      }
    }
    paramg = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      ad.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
      this.endFlag = 1;
      h.AC(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1672;
      }
      j = (this.hAL - 6) / 32 * 20;
    }
    label1672:
    for (;;)
    {
      ad.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new b.a();
      ((b.a)localObject).gUU = new dig();
      ((b.a)localObject).gUV = new dih();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((b.a)localObject).funcId = 329;
      ((b.a)localObject).reqCmdId = 157;
      ((b.a)localObject).respCmdId = 1000000157;
      this.rr = ((b.a)localObject).atI();
      localObject = (dig)this.rr.gUS.gUX;
      ((dig)localObject).sdQ = u.aqG();
      ((dig)localObject).sdP = localg.field_user;
      ((dig)localObject).CNt = localg.field_offset;
      ((dig)localObject).CyF = localg.field_clientid;
      ((dig)localObject).CLA = j;
      ((dig)localObject).hno = this.endFlag;
      ((dig)localObject).uKZ = localg.field_msgid;
      ((dig)localObject).DcP = i;
      ((dig)localObject).Eyv = ((int)(localg.field_createtime / 1000L));
      ((dig)localObject).DMv = 1;
      if (((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).ifAddTicketByActionFlag(localg.field_user)) {
        ((dig)localObject).COT = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIi(localg.field_user);
      }
      if (i != 1) {
        ((dig)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(paramg.buf, 0, paramg.cZc);
      }
      for (((dig)localObject).CJI = paramg.cZc;; ((dig)localObject).CJI = 1)
      {
        ad.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        ad.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((dig)localObject).uKZ + " user:" + ((dig)localObject).sdP + " offset:" + ((dig)localObject).CNt + " dataLen:" + ((dig)localObject).uKT.getILen() + " endFlag:" + ((dig)localObject).hno);
        ad.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + paramg.cZc + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.hAL + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        ad.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.hCm = System.currentTimeMillis();
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(28931);
        return i;
        if (localg.field_status == 3) {
          this.hCh = true;
        }
        paramg = h.asl(this.fileName);
        if (paramg == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        paramg = paramg.OS(localg.field_offset);
        ad.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.f.getLine());
        if (paramg.ret < 0)
        {
          ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + paramg.ret + " readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + localg.field_offset);
          h.zV(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.hAL = paramg.hAL;
        if ((this.hAL < localg.field_offset) || (this.hAL >= 469000))
        {
          ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.hAL + " OldtOff:" + localg.field_offset);
          h.zV(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        this.endFlag = 0;
        if ((paramg.cZc == 0) && (!this.hCh))
        {
          ad.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.zV(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
          AppMethodBeat.o(28931);
          return -1;
        }
        if (this.hCh)
        {
          if (localg.field_totallen <= 0)
          {
            ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.zV(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if ((localg.field_totallen > this.hAL) && (paramg.cZc < 6000))
          {
            ad.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + paramg.cZc + " newOff:" + paramg.hAL + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.zV(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.f.getLine() + 10000);
            AppMethodBeat.o(28931);
            return -1;
          }
          if (localg.field_totallen <= this.hAL) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((dig)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bx.b.cd(new byte[1]));
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
    ad.i("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (dig)((com.tencent.mm.al.b)paramq).gUS.gUX;
    paramq = (dih)((com.tencent.mm.al.b)paramq).gUT.gUX;
    ad.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + paramq.toString());
    if ((paramq != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.messenger.foundation.a.q.class)).setEnSendMsgActionFlag(paramq.COU);
    }
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      paramq = this.fileName;
      paramq = d.dMj().aso(paramq);
      if (paramq != null)
      {
        if (paramq.field_status == 3)
        {
          az.arV();
          paramArrayOfByte = com.tencent.mm.model.c.apO().rm(paramq.field_msglocalid);
          paramArrayOfByte.setContent(f.b(paramq.field_human, paramq.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          az.arV();
          com.tencent.mm.model.c.apO().a(paramq.field_msglocalid, paramArrayOfByte);
        }
        paramq.field_status = 97;
        paramq.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        paramq.dtM = 320;
        h.a(paramq);
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.zV(this.fileName);
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
    ad.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + paramq.uKZ + " toUser:" + paramArrayOfByte.sdP);
    paramArrayOfByte = this.fileName;
    int j = this.hAL;
    long l = paramq.uKZ;
    Object localObject = paramq.CyF;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      ad.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.uKZ + " clientId:" + paramq.CyF + " neWWOff:" + this.hAL + " neTTTT:" + paramq.CJI);
      if (paramInt1 >= 0) {
        break;
      }
      h.zV(this.fileName);
      ad.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(28934);
      return;
      ad.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = d.dMj().aso(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.dtM = 264;
        if ((bt.isNullOrNil(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.dtM |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.dtM |= 0x4;
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
              localg.dtM |= 0x40;
              az.arV();
              localObject = com.tencent.mm.model.c.apO().rm(localg.field_msglocalid);
              ((bl)localObject).nY(localg.field_user);
              ((bl)localObject).kX(localg.field_msgid);
              ((bl)localObject).setStatus(2);
              ((bl)localObject).setContent(f.b(localg.field_human, localg.field_voicelenght, false));
              az.arV();
              com.tencent.mm.model.c.apO().a(localg.field_msglocalid, (bl)localObject);
              ad.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.Ay(paramArrayOfByte);
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
    if (this.hCh) {}
    for (l = 0L;; l = 500L)
    {
      ad.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.gTs.av(l, l);
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
    paramq = (dig)((com.tencent.mm.al.b)paramq).gUS.gUX;
    ad.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + paramq.CNt + " dataLen:" + paramq.uKT.getILen() + " endFlag:" + paramq.hno);
    paramq = n.b.gVB;
    AppMethodBeat.o(28932);
    return paramq;
  }
  
  public final void setSecurityCheckError(n.a parama)
  {
    AppMethodBeat.i(28933);
    h.zV(this.fileName);
    AppMethodBeat.o(28933);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.d.b
 * JD-Core Version:    0.7.0.1
 */