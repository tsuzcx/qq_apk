package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.a;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.model.au;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.cbu;
import com.tencent.mm.protocal.c.cbv;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import junit.framework.Assert;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  com.tencent.mm.ah.f dmL;
  private int eIh = 0;
  private boolean eJS = false;
  long eJX;
  am ebj = new am(new b.1(this), true);
  private int endFlag = 0;
  String fileName;
  int retCode = 0;
  
  public b(String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      Assert.assertTrue(bool);
      y.d("MicroMsg.NetSceneUploadVoiceRemind", "NetSceneUploadVoice:  file:" + paramString);
      this.fileName = paramString;
      return;
      bool = false;
    }
  }
  
  protected final int Ka()
  {
    return 240;
  }
  
  public final int a(e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    this.eJS = false;
    if (this.fileName == null)
    {
      y.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  filename null!");
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      return -1;
    }
    g localg = h.PB(this.fileName);
    if ((localg == null) || (!localg.Tk()))
    {
      y.e("MicroMsg.NetSceneUploadVoiceRemind", "Get info Failed file:" + this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      return -1;
    }
    y.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene file:" + this.fileName + " netTimes:" + localg.field_nettimes);
    paramf = this.fileName;
    boolean bool;
    if (paramf == null) {
      bool = false;
    }
    while (!bool)
    {
      y.e("MicroMsg.NetSceneUploadVoiceRemind", "checkVoiceNetTimes Failed file:" + this.fileName);
      h.nX(this.fileName);
      this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
      return -1;
      paramf = h.PB(paramf);
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
        paramf.bcw = 16384;
        bool = h.a(paramf);
      }
    }
    paramf = new c.a();
    int i;
    int j;
    if (localg.field_status == 8)
    {
      y.v("MicroMsg.NetSceneUploadVoiceRemind", this.fileName + " cancelFlag = 1");
      this.endFlag = 1;
      h.oC(localg.field_filename);
      i = 1;
      j = localg.field_voicelenght;
      if (j != 0) {
        break label1544;
      }
      j = (this.eIh - 6) / 32 * 20;
    }
    label1544:
    for (;;)
    {
      y.d("MicroMsg.NetSceneUploadVoiceRemind", "info.getMsgSvrId() " + localg.field_msgid);
      Object localObject = new b.a();
      ((b.a)localObject).ecH = new cbu();
      ((b.a)localObject).ecI = new cbv();
      ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/uploadvoicerecognize";
      ((b.a)localObject).ecG = 329;
      ((b.a)localObject).ecJ = 157;
      ((b.a)localObject).ecK = 1000000157;
      this.dmK = ((b.a)localObject).Kt();
      localObject = (cbu)this.dmK.ecE.ecN;
      ((cbu)localObject).kWn = com.tencent.mm.model.q.Gj();
      ((cbu)localObject).kWm = localg.field_user;
      ((cbu)localObject).sDT = localg.field_offset;
      ((cbu)localObject).swQ = localg.field_clientid;
      ((cbu)localObject).sRf = j;
      ((cbu)localObject).euw = this.endFlag;
      ((cbu)localObject).ndp = localg.field_msgid;
      ((cbu)localObject).sRg = i;
      ((cbu)localObject).tQU = ((int)(localg.field_createtime / 1000L));
      ((cbu)localObject).trH = 1;
      if (i != 1) {
        ((cbu)localObject).ndi = new bmk().T(paramf.buf, paramf.bDu);
      }
      for (((cbu)localObject).sRd = paramf.bDu;; ((cbu)localObject).sRd = 1)
      {
        y.v("MicroMsg.NetSceneUploadVoiceRemind", "cancelFlag:" + i + " endFlag:" + this.endFlag + " svrId:" + localg.field_msgid);
        y.v("MicroMsg.NetSceneUploadVoiceRemind", "doscene msgId:" + ((cbu)localObject).ndp + " user:" + ((cbu)localObject).kWm + " offset:" + ((cbu)localObject).sDT + " dataLen:" + ((cbu)localObject).ndi.tFK + " endFlag:" + ((cbu)localObject).euw);
        y.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene MsgId:" + localg.field_msgid + " file:" + this.fileName + " readBytes:" + paramf.bDu + " neTTTOff:" + localg.field_offset + " neWWWOff:" + this.eIh + " endFlag:" + this.endFlag + " cancelFlag:" + i + " status:" + localg.field_status);
        y.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log " + localObject.toString());
        this.eJX = System.currentTimeMillis();
        return a(parame, this.dmK, this);
        if (localg.field_status == 3) {
          this.eJS = true;
        }
        paramf = h.PC(this.fileName);
        if (paramf == null)
        {
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          return -1;
        }
        paramf = paramf.zm(localg.field_offset);
        y.d("MicroMsg.NetSceneUploadVoiceRemind", "doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + localg.field_offset + " line:" + com.tencent.mm.compatible.util.g.getLine());
        if (paramf.ret < 0)
        {
          y.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read ret:" + paramf.ret + " readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + localg.field_offset);
          h.nX(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          return -1;
        }
        this.eIh = paramf.eIh;
        if ((this.eIh < localg.field_offset) || (this.eIh >= 469000))
        {
          y.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] newOff:" + this.eIh + " OldtOff:" + localg.field_offset);
          h.nX(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          return -1;
        }
        this.endFlag = 0;
        if ((paramf.bDu == 0) && (!this.eJS))
        {
          y.e("MicroMsg.NetSceneUploadVoiceRemind", "doScene:  file:" + this.fileName + " No Data temperature , will be retry");
          h.nX(this.fileName);
          this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
          return -1;
        }
        if (this.eJS)
        {
          if (localg.field_totallen <= 0)
          {
            y.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] read totalLen:" + localg.field_totallen);
            h.nX(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
          }
          if ((localg.field_totallen > this.eIh) && (paramf.bDu < 6000))
          {
            y.e("MicroMsg.NetSceneUploadVoiceRemind", "Err doScene READ file[" + this.fileName + "] readlen:" + paramf.bDu + " newOff:" + paramf.eIh + " netOff:" + localg.field_offset + " totalLen:" + localg.field_totallen);
            h.nX(this.fileName);
            this.retCode = (com.tencent.mm.compatible.util.g.getLine() + 10000);
            return -1;
          }
          if (localg.field_totallen <= this.eIh) {
            this.endFlag = 1;
          }
        }
        i = 0;
        break;
        ((cbu)localObject).ndi = new bmk().b(com.tencent.mm.bv.b.bk(new byte[1]));
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errtype:" + paramInt2 + " errCode:" + paramInt3);
    paramArrayOfByte = (cbu)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    paramq = (cbv)((com.tencent.mm.ah.b)paramq).ecF.ecN;
    y.d("MicroMsg.NetSceneUploadVoiceRemind", "tiger log resp " + paramq.toString());
    if ((paramInt2 == 4) && (paramInt3 == -22))
    {
      paramq = h.PB(this.fileName);
      if (paramq != null)
      {
        if (paramq.field_status == 3)
        {
          au.Hx();
          paramArrayOfByte = com.tencent.mm.model.c.Fy().fd(paramq.field_msglocalid);
          paramArrayOfByte.setContent(f.d(paramq.field_human, paramq.field_voicelenght, false));
          paramArrayOfByte.setStatus(2);
          au.Hx();
          com.tencent.mm.model.c.Fy().a(paramq.field_msglocalid, paramArrayOfByte);
        }
        paramq.field_status = 97;
        paramq.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        paramq.bcw = 320;
        h.a(paramq);
      }
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 == 4) && (paramInt3 != 0))
    {
      h.nX(this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd msgId:" + paramq.ndp + " toUser:" + paramArrayOfByte.kWm);
    paramArrayOfByte = this.fileName;
    int j = this.eIh;
    long l = paramq.ndp;
    Object localObject = paramq.swQ;
    int k = this.endFlag;
    if (paramArrayOfByte == null) {
      paramInt1 = -1;
    }
    for (;;)
    {
      y.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd updateAfterSend:" + paramInt1 + " file:" + this.fileName + " MsgSvrId:" + paramq.ndp + " clientId:" + paramq.swQ + " neWWOff:" + this.eIh + " neTTTT:" + paramq.sRd);
      if (paramInt1 >= 0) {
        break;
      }
      h.nX(this.fileName);
      y.e("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + "UpdateAfterSend Ret:" + paramInt1);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      y.d("MicroMsg.VoiceRemindLogic", "UpdateAfterSend file:[" + paramArrayOfByte + "] newOff:" + j + " SvrID:" + l + " clientID:" + (String)localObject + " hasSendEndFlag " + k);
      g localg = h.PB(paramArrayOfByte);
      if (localg == null)
      {
        paramInt1 = -1;
      }
      else
      {
        localg.field_offset = j;
        localg.field_lastmodifytime = (System.currentTimeMillis() / 1000L);
        localg.bcw = 264;
        if ((bk.bl(localg.field_clientid)) && (localObject != null))
        {
          localg.field_clientid = ((String)localObject);
          localg.bcw |= 0x200;
        }
        if ((localg.field_msgid == 0L) && (l != 0L))
        {
          localg.field_msgid = l;
          localg.bcw |= 0x4;
        }
        int i = 0;
        y.d("MicroMsg.VoiceRemindLogic", "info.getTotalLen() " + localg.field_totallen + "  newOffset " + j + "  " + localg.field_status);
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
              localg.bcw |= 0x40;
              au.Hx();
              localObject = com.tencent.mm.model.c.Fy().fd(localg.field_msglocalid);
              ((bi)localObject).ec(localg.field_user);
              ((bi)localObject).bf(localg.field_msgid);
              ((bi)localObject).setStatus(2);
              ((bi)localObject).setContent(f.d(localg.field_human, localg.field_voicelenght, false));
              au.Hx();
              com.tencent.mm.model.c.Fy().a(localg.field_msglocalid, (bi)localObject);
              y.d("MicroMsg.VoiceRemindLogic", "END!!! updateSend  file:" + paramArrayOfByte + " total:" + localg.field_totallen + " status:" + localg.field_status + " netTimes:" + localg.field_nettimes);
              paramInt1 = 1;
              h.oy(paramArrayOfByte);
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
      y.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd finish file:" + this.fileName);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    if (this.eJS) {}
    for (l = 0L;; l = 500L)
    {
      y.d("MicroMsg.NetSceneUploadVoiceRemind", "onGYNetEnd file:" + this.fileName + " delay:" + l);
      this.ebj.S(l, l);
      return;
    }
  }
  
  protected final void a(m.a parama)
  {
    h.nX(this.fileName);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    paramq = (cbu)((com.tencent.mm.ah.b)paramq).ecE.ecN;
    y.v("MicroMsg.NetSceneUploadVoiceRemind", "check : offset:" + paramq.sDT + " dataLen:" + paramq.ndi.tFK + " endFlag:" + paramq.euw);
    return m.b.edr;
  }
  
  public final int getType()
  {
    return 329;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.c.b
 * JD-Core Version:    0.7.0.1
 */