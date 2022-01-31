package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ae.g.a;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.m.b;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.mz;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.j.f.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.can;
import com.tencent.mm.protocal.c.cao;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class al
  extends m
  implements k
{
  g.a bFI = null;
  String bIB;
  private boolean dFX = false;
  int dFZ = 0;
  com.tencent.mm.j.d dGa;
  com.tencent.mm.sdk.b.c dGc = new al.2(this);
  private String dQx = null;
  private com.tencent.mm.ah.b dmK;
  com.tencent.mm.ah.f dmL;
  String eoQ = "";
  private f.a epa = new f.a()
  {
    public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.j.c paramAnonymousc, com.tencent.mm.j.d paramAnonymousd, boolean paramAnonymousBoolean)
    {
      paramAnonymousString = al.this.eoQ;
      boolean bool1;
      if (paramAnonymousc != null)
      {
        bool1 = true;
        if (paramAnonymousd == null) {
          break label137;
        }
      }
      label137:
      for (boolean bool2 = true;; bool2 = false)
      {
        y.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
        ap.avh().b(al.this.rUD, al.this.rUA);
        if (paramAnonymousInt != -21005) {
          break label143;
        }
        y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { al.this.eoQ });
        return 0;
        bool1 = false;
        break;
      }
      label143:
      if (paramAnonymousInt != 0)
      {
        l.hb(al.this.rUA.ujK);
        ap.avh().b(al.this.rUD, al.this.rUA);
        al.this.rUA.field_signature = "";
        paramAnonymousBoolean = ap.avh().c(al.this.rUA, new String[0]);
        y.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(al.this.rUD), Boolean.valueOf(paramAnonymousBoolean) });
        al.this.dmL.onSceneEnd(3, paramAnonymousInt, "", al.this);
        new com.tencent.mm.h.b.a.f(com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(al.this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Integer.valueOf(0), "" })).QX();
        return 0;
      }
      if (al.this.rUA.field_status == 105L)
      {
        y.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(al.this.rUA.field_status), Long.valueOf(al.this.rUD) });
        com.tencent.mm.ak.f.Nd().lL(al.this.eoQ);
        al.this.dmL.onSceneEnd(3, paramAnonymousInt, "attach  has paused, status" + al.this.rUA.field_status, al.this);
        return 0;
      }
      if (paramAnonymousc != null)
      {
        al.this.rUA.field_lastModifyTime = bk.UX();
        al.this.rUA.field_offset = paramAnonymousc.field_finishedLength;
        paramAnonymousBoolean = ap.avh().c(al.this.rUA, new String[0]);
        if (!paramAnonymousBoolean)
        {
          y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + paramAnonymousBoolean);
          al.this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
          al.this.dmL.onSceneEnd(3, paramAnonymousInt, "", al.this);
          return 0;
        }
        return 0;
      }
      if (paramAnonymousd != null)
      {
        if (paramAnonymousd.field_retCode == 0) {
          break label1002;
        }
        y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.dlG });
        l.hb(al.this.rUA.ujK);
        ap.avh().b(al.this.rUD, al.this.rUA);
        al.this.rUA.field_signature = "";
        paramAnonymousBoolean = ap.avh().c(al.this.rUA, new String[0]);
        y.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(al.this.rUD), Boolean.valueOf(paramAnonymousBoolean) });
        paramAnonymousString = com.tencent.mm.plugin.report.a.n(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(al.this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Integer.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.dlG });
        new com.tencent.mm.h.b.a.f(paramAnonymousString).QX();
        new com.tencent.mm.h.b.a.d(paramAnonymousString).QX();
        al.this.dmL.onSceneEnd(3, paramAnonymousd.field_retCode, "", al.this);
      }
      for (;;)
      {
        return 0;
        label1002:
        y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bk.aac(al.this.rUA.field_signature) });
        if (paramAnonymousBoolean)
        {
          if (paramAnonymousd.field_exist_whencheck)
          {
            au.Dk().a(new aa(al.this.bFI, al.this.rUA.field_fileFullPath, al.this.toUser, new al.1.1(this, paramAnonymousInt, paramAnonymousd)), 0);
          }
          else
          {
            y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
            au.Dk().a(new aa(null, al.this.rUA.field_fileFullPath, al.this.toUser, new al.1.2(this, paramAnonymousInt)), 0);
          }
        }
        else {
          a(paramAnonymousInt, paramAnonymousd);
        }
      }
    }
    
    final void a(int paramAnonymousInt, com.tencent.mm.j.d paramAnonymousd)
    {
      al.this.rUA.field_status = 199L;
      boolean bool = ap.avh().c(al.this.rUA, new String[0]);
      if (!bool)
      {
        y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:" + bool);
        al.this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        al.this.dmL.onSceneEnd(3, paramAnonymousInt, "", al.this);
        return;
      }
      l.a(al.this.rUA.field_msgInfoId, al.this.rUA.field_mediaSvrId, paramAnonymousd);
      au.Dk().a(new aj(al.this.rUA.field_msgInfoId, true, paramAnonymousd, new al.1.3(this, paramAnonymousd), al.this.bIB, al.this.rUA), 0);
    }
    
    public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
    
    public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
    {
      return null;
    }
  };
  boolean epi = true;
  b rUA = null;
  long rUD = -1L;
  private boolean rUX = true;
  private long rUY = -1L;
  int retCode = 0;
  long startTime = 0L;
  String toUser;
  
  public al(long paramLong, String paramString1, String paramString2)
  {
    this.rUD = paramLong;
    this.dQx = paramString1;
    this.bIB = paramString2;
    paramString2 = new b.a();
    paramString2.ecH = new can();
    paramString2.ecI = new cao();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.ecG = 220;
    paramString2.ecJ = 105;
    paramString2.ecK = 1000000105;
    this.dmK = paramString2.Kt();
    y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bk.csb() });
  }
  
  protected final int Ka()
  {
    return 3200;
  }
  
  public final int a(com.tencent.mm.network.e parame, com.tencent.mm.ah.f paramf)
  {
    this.dmL = paramf;
    this.rUA = new b();
    if ((!ap.avh().b(this.rUD, this.rUA)) || (this.rUA == null))
    {
      y.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.zI() + " summerbig get info failed rowid:" + this.rUD);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.rUA = null;
      return -1;
    }
    if (this.rUA.field_status != 101L)
    {
      y.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.zI() + " summerbig get field_status failed rowid:" + this.rUD + " status:" + this.rUA.field_status);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bk.UY();
      this.rUY = this.rUA.field_offset;
    }
    y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.rUD), this.rUA.field_fileFullPath, Long.valueOf(this.rUA.field_totalLen), Boolean.valueOf(this.rUA.field_isUpload), Integer.valueOf(this.rUA.field_isUseCdn), Long.valueOf(this.rUA.field_type) });
    if (bk.bl(this.rUA.field_appId))
    {
      y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.rUA.field_type != 8L) && (this.rUA.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        return -1;
      }
    }
    int i;
    if ((this.rUA.field_type == 8L) || (this.rUA.field_type == 9L))
    {
      y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.rUA.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      y.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.rUD) });
      return 0;
      com.tencent.mm.ak.f.Nd();
      if ((!com.tencent.mm.ak.b.iq(4)) && (this.rUA.field_isUseCdn != 1))
      {
        com.tencent.mm.ak.f.Nd();
        y.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.ak.b.iq(4)), Integer.valueOf(this.rUA.field_isUseCdn) });
        i = 0;
      }
      else
      {
        au.Hx();
        bi localbi = com.tencent.mm.model.c.Fy().fd(this.rUA.field_msgInfoId);
        if (localbi.field_msgId != this.rUA.field_msgInfoId)
        {
          y.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.rUA.field_msgInfoId), Long.valueOf(this.rUA.ujK), Long.valueOf(this.rUA.field_createTime), Long.valueOf(this.rUA.field_totalLen), Long.valueOf(this.rUA.field_status), Boolean.valueOf(this.rUA.field_isUpload), Integer.valueOf(this.rUA.field_isUseCdn), this.rUA.field_mediaId });
          this.toUser = null;
          i = 0;
        }
        else
        {
          this.toUser = localbi.field_talker;
          paramf = "";
          if (!bk.bl(localbi.field_imgPath)) {
            paramf = o.OJ().me(localbi.field_imgPath);
          }
          int k = com.tencent.mm.a.e.bJ(paramf);
          int m = com.tencent.mm.a.e.bJ(this.rUA.field_fileFullPath);
          if (k >= com.tencent.mm.j.a.dlE)
          {
            y.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { paramf, Integer.valueOf(k) });
            i = 0;
          }
          else
          {
            this.eoQ = com.tencent.mm.ak.c.a("upattach", this.rUA.field_createTime, localbi.field_talker, this.rUD);
            y.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.rUA.field_createTime), this.eoQ });
            if (bk.bl(this.eoQ))
            {
              y.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.rUD) });
              i = 0;
            }
            else
            {
              com.tencent.mm.j.f localf = new com.tencent.mm.j.f();
              String str = localbi.field_content;
              localObject = str;
              if (s.fn(localbi.field_talker))
              {
                i = bd.iH(localbi.field_content);
                localObject = str;
                if (i != -1) {
                  localObject = (localbi.field_content + " ").substring(i + 2).trim();
                }
              }
              this.bFI = g.a.gp(bk.ZQ((String)localObject));
              label1058:
              int j;
              label1103:
              label1126:
              boolean bool;
              if (this.bFI != null)
              {
                y.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.bFI.dQK, bk.aac(this.bFI.dQR), this.bFI.filemd5, Integer.valueOf(this.bFI.type) });
                localf.field_fileId = this.bFI.dQK;
                localf.field_aesKey = this.bFI.dQR;
                localf.field_filemd5 = this.bFI.filemd5;
                if ((this.bFI.dQz != 0) || (this.bFI.dQv > 26214400))
                {
                  i = 1;
                  localf.dlP = this.epa;
                  localf.field_mediaId = this.eoQ;
                  localf.field_fullpath = this.rUA.field_fileFullPath;
                  localf.field_thumbpath = paramf;
                  if (i == 0) {
                    break label1483;
                  }
                  j = com.tencent.mm.j.a.dlm;
                  localf.field_fileType = j;
                  if (i == 0) {
                    break label1491;
                  }
                  localObject = bk.pm(this.rUA.field_signature);
                  localf.field_svr_signature = ((String)localObject);
                  if (i == 0) {
                    break label1498;
                  }
                  bool = bk.bl(this.rUA.field_signature);
                  label1149:
                  localf.field_onlycheckexist = bool;
                  localf.field_fake_bigfile_signature_aeskey = this.rUA.field_fakeAeskey;
                  localf.field_fake_bigfile_signature = this.rUA.field_fakeSignature;
                  localf.field_talker = localbi.field_talker;
                  localf.field_priority = com.tencent.mm.j.a.dlk;
                  localf.field_totalLen = m;
                  localf.field_needStorage = false;
                  localf.field_isStreamMedia = false;
                  localf.field_enable_hitcheck = this.epi;
                  if (!s.fn(localbi.field_talker)) {
                    break label1504;
                  }
                }
              }
              label1483:
              label1491:
              label1498:
              label1504:
              for (i = 1;; i = 0)
              {
                localf.field_chattype = i;
                localf.field_force_aeskeycdn = false;
                localf.field_trysafecdn = true;
                y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.rUA.field_msgInfoId), localf.field_fullpath, Integer.valueOf(m), paramf, Integer.valueOf(k), this.eoQ, Integer.valueOf(localf.field_fileType), Boolean.valueOf(localf.field_enable_hitcheck), Boolean.valueOf(localf.field_onlycheckexist), Boolean.valueOf(localf.field_force_aeskeycdn), Boolean.valueOf(localf.field_trysafecdn), bk.aac(localf.field_aesKey), localf.field_filemd5, bk.aac(localf.field_svr_signature), bk.aac(localf.field_fake_bigfile_signature_aeskey), bk.aac(localf.field_fake_bigfile_signature) });
                if (com.tencent.mm.ak.f.Nd().c(localf)) {
                  break label1509;
                }
                y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                this.eoQ = "";
                i = 0;
                break;
                i = 0;
                break label1058;
                y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                i = 0;
                break label1058;
                j = com.tencent.mm.j.a.MediaType_FILE;
                break label1103;
                localObject = "";
                break label1126;
                bool = false;
                break label1149;
              }
              label1509:
              if (this.rUA.field_isUseCdn != 1)
              {
                this.rUA.field_isUseCdn = 1;
                bool = ap.avh().c(this.rUA, new String[0]);
                if (!bool)
                {
                  y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:" + bool);
                  this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
                  this.dmL.onSceneEnd(3, -1, "", this);
                  i = 0;
                  continue;
                }
              }
              y.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.eoQ });
              i = 1;
            }
          }
        }
      }
    }
    if (this.rUA.field_netTimes > 3200L)
    {
      l.hb(this.rUA.ujK);
      y.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.zI() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.rUD);
      return -1;
    }
    paramf = this.rUA;
    paramf.field_netTimes += 1L;
    if (bk.bl(this.rUA.field_clientAppDataId))
    {
      y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
    }
    if ((this.rUA.field_totalLen <= 0L) || (this.rUA.field_totalLen > 26214400L))
    {
      y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.rUA.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      if (this.rUA.field_totalLen > 26214400L) {
        l.hb(this.rUA.ujK);
      }
      return -1;
    }
    if (bk.bl(this.rUA.field_fileFullPath))
    {
      y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
    }
    if (com.tencent.mm.a.e.bJ(this.rUA.field_fileFullPath) > 26214400)
    {
      y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      l.hb(this.rUA.ujK);
      return -1;
    }
    if (bk.bl(this.dQx)) {}
    for (paramf = com.tencent.mm.a.e.d(this.rUA.field_fileFullPath, (int)this.rUA.field_offset, 8192); bk.bE(paramf); paramf = com.tencent.mm.a.e.d(this.rUA.field_fileFullPath, (int)this.rUA.field_offset, 32768))
    {
      y.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      return -1;
    }
    Object localObject = (can)this.dmK.ecE.ecN;
    ((can)localObject).euK = this.rUA.field_appId;
    ((can)localObject).swP = ((int)this.rUA.field_sdkVer);
    ((can)localObject).tPI = this.rUA.field_clientAppDataId;
    ((can)localObject).hQR = ((int)this.rUA.field_type);
    ((can)localObject).hPY = com.tencent.mm.model.q.Gj();
    ((can)localObject).ndf = ((int)this.rUA.field_totalLen);
    ((can)localObject).ndg = ((int)this.rUA.field_offset);
    if ((this.dQx != null) && (this.rUX))
    {
      ((can)localObject).sRE = this.dQx;
      ((can)localObject).ndf = ((int)this.rUA.field_totalLen);
      ((can)localObject).ndh = 0;
      ((can)localObject).ndi = new bmk().bs(new byte[0]);
      this.rUX = false;
      return a(parame, this.dmK, this);
    }
    ((can)localObject).ndh = paramf.length;
    ((can)localObject).ndi = new bmk().bs(paramf);
    if (this.dQx != null) {
      ((can)localObject).sRE = this.dQx;
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bk.bl(this.eoQ))) {
      y.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.eoQ });
    }
    do
    {
      return;
      if ((paramInt2 != 0) || (paramInt3 != 0))
      {
        y.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        if (paramInt2 == 4) {
          h.nFQ.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Long.valueOf(this.rUA.field_totalLen - this.rUY) });
        }
        this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
        return;
      }
      paramString = (cao)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      if ((paramString.euK != null) && (this.dQx == null) && ((!paramString.euK.equals(this.rUA.field_appId)) || (!paramString.tPI.equals(this.rUA.field_clientAppDataId))))
      {
        y.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      if ((paramString.ndf < 0) || (paramString.ndf != this.rUA.field_totalLen) || (paramString.ndg < 0) || (paramString.ndg > this.rUA.field_totalLen))
      {
        y.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      this.rUA.field_offset = paramString.ndg;
      paramq = this.rUA;
      if (l.VV(paramString.euN)) {}
      for (paramString = paramString.euN;; paramString = "")
      {
        paramq.field_mediaSvrId = paramString;
        if (this.rUA.field_status != 105L) {
          break;
        }
        y.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.rUA.field_mediaSvrId + "," + this.rUA.field_offset + "] ");
        this.dmL.onSceneEnd(paramInt2, -1, "", this);
        return;
      }
      if (this.rUA.field_offset == this.rUA.field_totalLen)
      {
        if (bk.bl(this.rUA.field_mediaSvrId))
        {
          y.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
          this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
          this.dmL.onSceneEnd(3, -1, "", this);
          l.hb(this.rUA.ujK);
          return;
        }
        this.rUA.field_status = 199L;
        h.nFQ.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bk.UY()), Integer.valueOf(com.tencent.mm.ak.c.bx(ae.getContext())), Integer.valueOf(com.tencent.mm.j.a.MediaType_FILE), Long.valueOf(this.rUA.field_totalLen - this.rUY) });
      }
      boolean bool = ap.avh().c(this.rUA, new String[0]);
      if (!bool)
      {
        y.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:" + bool);
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        d(null);
        this.dmL.onSceneEnd(3, -1, "", this);
        return;
      }
      if (this.rUA.field_status == 199L)
      {
        this.dmL.onSceneEnd(0, 0, "", this);
        return;
      }
    } while (a(this.edc, this.dmL) >= 0);
    y.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
    this.dmL.onSceneEnd(3, -1, "", this);
  }
  
  protected final m.b b(com.tencent.mm.network.q paramq)
  {
    return m.b.edr;
  }
  
  final void d(com.tencent.mm.j.d paramd)
  {
    if (this.rUA.field_type != 2L) {}
    do
    {
      return;
      com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.IX().fJ("100131");
      if (localc.isValid()) {
        this.dFZ = ah.getInt((String)localc.ctr().get("needUploadData"), 1);
      }
    } while ((this.dFX) || (this.dFZ == 0));
    this.dGa = paramd;
    this.dFX = true;
    paramd = new mz();
    com.tencent.mm.sdk.b.a.udP.c(this.dGc);
    paramd.bWF.filePath = this.rUA.field_fileFullPath;
    com.tencent.mm.sdk.b.a.udP.m(paramd);
  }
  
  public final int getType()
  {
    return 220;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al
 * JD-Core Version:    0.7.0.1
 */