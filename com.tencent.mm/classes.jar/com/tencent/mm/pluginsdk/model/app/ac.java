package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.a;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.uf;
import com.tencent.mm.protocal.c.ug;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;

public final class ac
  extends m
  implements k
{
  public long bIt = 0L;
  public String bUi = "";
  bi bWO = null;
  private com.tencent.mm.ah.b dmK;
  com.tencent.mm.ah.f dmL;
  com.tencent.mm.ah.g eoM;
  public String eoQ = "";
  private f.a epa = new ac.1(this);
  private long hJW = 0L;
  public b rUA = null;
  long rUD = -1L;
  private int rUE = -1;
  String rUF = "";
  public boolean rUG = false;
  private boolean rUH = false;
  private boolean rUI = false;
  int retCode = 0;
  long startTime = 0L;
  private int type = 0;
  
  public ac(long paramLong1, long paramLong2, com.tencent.mm.ah.g paramg)
  {
    this.hJW = paramLong2;
    this.bIt = paramLong1;
    this.rUA = ap.avh().gY(paramLong1);
    this.eoM = paramg;
    this.rUH = true;
    if (this.rUA == null)
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId" + paramLong1, new Object[] { Long.valueOf(paramLong2) });
      return;
    }
    paramg = new b.a();
    paramg.ecH = new uf();
    paramg.ecI = new ug();
    paramg.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramg.ecG = 221;
    paramg.ecJ = 106;
    paramg.ecK = 1000000106;
    this.dmK = paramg.Kt();
  }
  
  public ac(long paramLong, String paramString, com.tencent.mm.ah.g paramg)
  {
    this(paramString, paramg);
    this.bIt = paramLong;
  }
  
  public ac(b paramb)
  {
    this.rUA = paramb;
    this.rUG = true;
    this.bUi = this.rUA.field_mediaId;
    this.eoM = null;
    this.type = 0;
    if (paramb == null)
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.bUi);
      return;
    }
    b.a locala = new b.a();
    locala.ecH = new uf();
    locala.ecI = new ug();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.ecG = 221;
    locala.ecJ = 106;
    locala.ecK = 1000000106;
    this.dmK = locala.Kt();
    y.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramb.field_fileFullPath, Boolean.valueOf(true), bk.csb() });
  }
  
  public ac(String paramString)
  {
    this(paramString, null);
  }
  
  private ac(String paramString, com.tencent.mm.ah.g paramg)
  {
    this.bUi = paramString;
    this.eoM = paramg;
    this.type = 0;
    this.rUA = ap.avh().VQ(paramString);
    if (this.rUA == null)
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + paramString);
      return;
    }
    paramString = new b.a();
    paramString.ecH = new uf();
    paramString.ecI = new ug();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.ecG = 221;
    paramString.ecJ = 106;
    paramString.ecK = 1000000106;
    this.dmK = paramString.Kt();
    y.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.rUA.field_fileFullPath, Long.valueOf(this.rUA.field_type), this.rUA.field_signature, bk.csb() });
  }
  
  protected final int Ka()
  {
    return 400;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    if (this.rUA == null)
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.zI() + " get info failed mediaId:" + this.bUi);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
    }
    au.Hx();
    this.bWO = com.tencent.mm.model.c.Fy().fd(this.bIt);
    if ((this.bWO == null) || (this.bWO.field_msgId != this.bIt))
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.zI() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.bUi, Long.valueOf(this.bIt) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bk.UY();
      this.rUE = ((int)this.rUA.field_offset);
    }
    if (this.hJW != 0L)
    {
      paramf = (uf)this.dmK.ecE.ecN;
      paramf.hPY = com.tencent.mm.model.q.Gj();
      paramf.ndf = ((int)this.rUA.field_totalLen);
      paramf.ndg = ((int)this.rUA.field_offset);
      paramf.ndh = 0;
      paramf.hQR = 40;
      paramf.ndp = this.hJW;
      return a(parame, this.dmK, this);
    }
    Object localObject = this.bWO.field_content;
    paramf = (com.tencent.mm.ah.f)localObject;
    if (s.fn(this.bWO.field_talker))
    {
      i = bd.iH(this.bWO.field_content);
      paramf = (com.tencent.mm.ah.f)localObject;
      if (i != -1) {
        paramf = (this.bWO.field_content + " ").substring(i + 2).trim();
      }
    }
    paramf = g.a.gp(bk.ZQ(paramf));
    if (paramf == null)
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.bUi });
      i = 0;
    }
    while (i != 0)
    {
      y.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.bUi });
      return 0;
      y.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.bIt), Long.valueOf(this.rUA.field_totalLen), this.rUA.field_fileFullPath, paramf.dQK, bk.aac(paramf.dQR) });
      if (((bk.bl(paramf.dQK)) && (bk.bl(paramf.dQB))) || (bk.bl(paramf.dQR)))
      {
        y.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.bIt), paramf.dQK, bk.aac(paramf.dQR) });
        i = 0;
      }
      else
      {
        this.eoQ = com.tencent.mm.ak.c.a("downattach", this.rUA.field_createTime, this.bWO.field_talker, this.rUD);
        if (bk.bl(this.eoQ))
        {
          y.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.rUD) });
          i = 0;
        }
        else
        {
          com.tencent.mm.a.e.bO(this.rUA.field_fileFullPath);
          this.rUF = (this.rUA.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.j.f();
          ((com.tencent.mm.j.f)localObject).field_mediaId = this.eoQ;
          ((com.tencent.mm.j.f)localObject).field_fullpath = this.rUF;
          if ((paramf.dQz != 0) || (paramf.dQv > 26214400))
          {
            i = a.dlm;
            label713:
            ((com.tencent.mm.j.f)localObject).field_fileType = i;
            ((com.tencent.mm.j.f)localObject).field_totalLen = ((int)this.rUA.field_totalLen);
            ((com.tencent.mm.j.f)localObject).field_aesKey = paramf.dQR;
            ((com.tencent.mm.j.f)localObject).field_fileId = paramf.dQK;
            ((com.tencent.mm.j.f)localObject).field_svr_signature = this.rUA.field_signature;
            ((com.tencent.mm.j.f)localObject).field_fake_bigfile_signature_aeskey = this.rUA.field_fakeAeskey;
            ((com.tencent.mm.j.f)localObject).field_fake_bigfile_signature = this.rUA.field_fakeSignature;
            ((com.tencent.mm.j.f)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.j.f)localObject).field_priority = a.dlk;
            ((com.tencent.mm.j.f)localObject).dlP = this.epa;
            if (!s.fn(this.bWO.field_talker)) {
              break label998;
            }
          }
          label998:
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.j.f)localObject).field_chattype = i;
            if (!bk.bl(paramf.dQB))
            {
              ((com.tencent.mm.j.f)localObject).field_fileType = 19;
              ((com.tencent.mm.j.f)localObject).field_authKey = paramf.dQH;
              ((com.tencent.mm.j.f)localObject).dlQ = paramf.dQB;
              ((com.tencent.mm.j.f)localObject).field_fileId = "";
            }
            y.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Integer.valueOf(((com.tencent.mm.j.f)localObject).field_fileType), ((com.tencent.mm.j.f)localObject).field_fullpath, bk.aac(((com.tencent.mm.j.f)localObject).field_aesKey), bk.aac(((com.tencent.mm.j.f)localObject).field_svr_signature), bk.aac(((com.tencent.mm.j.f)localObject).field_fake_bigfile_signature_aeskey), bk.aac(((com.tencent.mm.j.f)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.j.f)localObject).field_onlycheckexist) });
            if (com.tencent.mm.ak.f.Nd().b((com.tencent.mm.j.f)localObject, -1)) {
              break label1003;
            }
            y.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.eoQ = "";
            i = 0;
            break;
            i = a.MediaType_FILE;
            break label713;
          }
          label1003:
          if (this.rUA.field_isUseCdn != 1)
          {
            this.rUA.field_isUseCdn = 1;
            boolean bool = ap.avh().c(this.rUA, new String[0]);
            if (!bool)
            {
              y.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:" + bool);
              this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
              this.dmL.onSceneEnd(3, -1, "", this);
              i = 0;
              continue;
            }
          }
          i = 1;
        }
      }
    }
    if (this.rUA.field_status == 102L)
    {
      this.rUA.field_status = 101L;
      if (!this.rUG) {
        ap.avh().c(this.rUA, new String[0]);
      }
    }
    this.rUD = this.rUA.ujK;
    if ((bk.bl(this.rUA.field_mediaSvrId)) && (this.hJW == 0L))
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
    }
    if ((this.rUA.field_totalLen <= 0L) || (this.rUA.field_totalLen > 26214400L))
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.rUA.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
    }
    if ((bk.bl(this.rUA.field_fileFullPath)) && (this.hJW == 0L))
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
    }
    int j = com.tencent.mm.a.e.bJ(this.rUA.field_fileFullPath);
    int i = j;
    if (this.rUI)
    {
      i = j - 6;
      if (i <= 0) {
        break label1407;
      }
    }
    while (i != this.rUA.field_offset)
    {
      y.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.rUA.field_offset);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
      label1407:
      i = 0;
    }
    y.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.rUA.field_appId, this.rUA.field_mediaSvrId, Long.valueOf(this.rUA.field_sdkVer) });
    paramf = (uf)this.dmK.ecE.ecN;
    paramf.euK = this.rUA.field_appId;
    paramf.euN = this.rUA.field_mediaSvrId;
    paramf.swP = ((int)this.rUA.field_sdkVer);
    paramf.hPY = com.tencent.mm.model.q.Gj();
    paramf.ndf = ((int)this.rUA.field_totalLen);
    paramf.ndg = ((int)this.rUA.field_offset);
    paramf.ndh = 0;
    if (this.hJW != 0L) {
      paramf.ndp = this.hJW;
    }
    if (this.type != 0) {}
    for (paramf.hQR = this.type;; paramf.hQR = ((int)this.rUA.field_type)) {
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bk.bl(this.eoQ))) {
      y.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.eoQ });
    }
    label879:
    label891:
    do
    {
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        y.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        if (paramInt2 == 4) {
          h.nFQ.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(a.MediaType_FILE), Integer.valueOf(0) });
        }
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      paramq = (ug)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      this.rUA.field_totalLen = paramq.ndf;
      if ((paramq.euN != null) && (!paramq.euN.equals(this.rUA.field_mediaSvrId)))
      {
        y.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      if (paramq.ndg != this.rUA.field_offset)
      {
        y.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramq.ndg);
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      if (paramq.ndh + this.rUA.field_offset > this.rUA.field_totalLen)
      {
        y.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramq.ndh + " off:" + this.rUA.field_offset + " total?:" + this.rUA.field_totalLen);
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      paramString = aa.a(paramq.ndi);
      if ((paramString == null) || (paramString.length == 0) || (paramString.length != paramq.ndh))
      {
        y.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      paramq = new String(paramString);
      y.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.rUH) });
      Object localObject;
      StringBuffer localStringBuffer1;
      if ((this.rUA.field_offset < this.rUA.field_totalLen) && (this.rUH))
      {
        au.Hx();
        paramArrayOfByte = com.tencent.mm.model.c.Fy().fd(this.rUA.field_msgInfoId);
        if (!paramq.startsWith("<appmsg")) {
          break label891;
        }
        if (!s.fn(paramArrayOfByte.field_talker)) {
          break label879;
        }
        if (!bk.bl(paramArrayOfByte.field_content))
        {
          localObject = paramArrayOfByte.field_content.split("\n", 2)[0];
          localStringBuffer1 = new StringBuffer();
          this.rUA.field_fullXml = ((String)localObject + "\n");
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append(this.rUA.field_fullXml).append(paramq);
          this.rUA.field_fullXml = ((StringBuffer)localObject).toString();
        }
      }
      for (;;)
      {
        paramArrayOfByte.setContent(this.rUA.field_fullXml);
        au.Hx();
        com.tencent.mm.model.c.Fy().a(this.rUA.field_msgInfoId, paramArrayOfByte);
        y.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramq });
        paramInt1 = com.tencent.mm.a.e.e(this.rUA.field_fileFullPath, paramString);
        if ((bk.bl(this.rUA.field_fileFullPath)) || (paramInt1 == 0)) {
          break;
        }
        y.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:" + paramInt1);
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
        this.rUA.field_fullXml = paramq;
        continue;
        if (!paramArrayOfByte.field_content.startsWith("<msg>"))
        {
          localObject = new StringBuffer();
          ((StringBuffer)localObject).append(paramArrayOfByte.field_content).append(paramq);
          this.rUA.field_fullXml = ((StringBuffer)localObject).toString();
        }
        if ((paramq.endsWith("</appmsg>")) || (this.rUA.field_offset + paramString.length == this.rUA.field_totalLen)) {
          if (s.fn(paramArrayOfByte.field_talker))
          {
            localObject = paramArrayOfByte.field_content.split("\n", 2);
            localStringBuffer1 = localObject[0];
            StringBuffer localStringBuffer2 = new StringBuffer();
            localStringBuffer2.append(localStringBuffer1).append("\n<msg>").append(localObject[1]).append(paramq).append("</msg>");
            this.rUA.field_fullXml = localStringBuffer2.toString();
          }
          else
          {
            localObject = new StringBuffer();
            ((StringBuffer)localObject).append("<msg>").append(this.rUA.field_fullXml).append("</msg>");
            this.rUA.field_fullXml = ((StringBuffer)localObject).toString();
          }
        }
      }
      paramq = this.rUA;
      paramq.field_offset += paramString.length;
      if (this.rUA.field_offset == this.rUA.field_totalLen) {
        this.rUA.field_status = 199L;
      }
      if (this.eoM != null) {
        ai.d(new ac.2(this));
      }
      if (this.rUG) {}
      for (boolean bool = true; !bool; bool = ap.avh().c(this.rUA, new String[0]))
      {
        y.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:" + paramInt1);
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      if (this.rUA.field_status == 199L)
      {
        h.nFQ.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(a.MediaType_FILE), Long.valueOf(this.rUA.field_totalLen - this.rUE) });
        au.Hx();
        paramString = com.tencent.mm.model.c.Fy().fd(this.rUA.field_msgInfoId);
        au.Hx();
        com.tencent.mm.model.c.Fy().a(new g.c(paramString.field_talker, "update", paramString));
        this.dmL.onSceneEnd(0, 0, "", this);
        return;
      }
      if (this.rUA.field_status == 102L)
      {
        this.dmL.onSceneEnd(3, -1, "", this);
        this.retCode = -20102;
        return;
      }
    } while (a(this.edc, this.dmL) >= 0);
    y.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
    this.dmL.onSceneEnd(3, -1, "", this);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  public final void ckX()
  {
    this.rUI = true;
    if (this.rUI) {
      com.tencent.mm.a.e.e(this.rUA.field_fileFullPath, "#!AMR\n".getBytes());
    }
  }
  
  public final String getMediaId()
  {
    if (this.rUA == null) {
      return "";
    }
    return this.rUA.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ac
 * JD-Core Version:    0.7.0.1
 */