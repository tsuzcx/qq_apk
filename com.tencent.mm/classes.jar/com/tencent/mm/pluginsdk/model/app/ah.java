package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.nw;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cnt;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import java.util.Map;

public final class ah
  extends m
  implements k
{
  com.tencent.mm.ai.f callback;
  j.b cmR;
  String cpW;
  int eDB;
  com.tencent.mm.i.d eDC;
  com.tencent.mm.sdk.b.c eDE;
  private boolean eDz;
  boolean fFG;
  String fFo;
  private g.a fFy;
  private String fgy;
  private boolean pDi;
  b pYg;
  long pYi;
  int retCode;
  private com.tencent.mm.ai.b rr;
  long startTime;
  String toUser;
  private long vLL;
  
  public ah(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(27380);
    this.pYg = null;
    this.cmR = null;
    this.pYi = -1L;
    this.fgy = null;
    this.pDi = true;
    this.fFG = true;
    this.retCode = 0;
    this.startTime = 0L;
    this.vLL = -1L;
    this.fFo = "";
    this.fFy = new ah.1(this);
    this.eDz = false;
    this.eDB = 0;
    this.eDE = new ah.2(this);
    this.pYi = paramLong;
    this.fgy = paramString1;
    this.cpW = paramString2;
    paramString2 = new b.a();
    paramString2.fsX = new cnt();
    paramString2.fsY = new cnu();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.funcId = 220;
    paramString2.reqCmdId = 105;
    paramString2.respCmdId = 1000000105;
    this.rr = paramString2.ado();
    ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bo.dtY() });
    AppMethodBeat.o(27380);
  }
  
  final void d(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(27383);
    if (this.pYg.field_type != 2L)
    {
      AppMethodBeat.o(27383);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.c.abU().me("100131");
    if (localc.isValid()) {
      this.eDB = com.tencent.mm.platformtools.ah.getInt((String)localc.dvN().get("needUploadData"), 1);
    }
    if ((this.eDz) || (this.eDB == 0))
    {
      AppMethodBeat.o(27383);
      return;
    }
    this.eDC = paramd;
    this.eDz = true;
    paramd = new nw();
    com.tencent.mm.sdk.b.a.ymk.c(this.eDE);
    paramd.cEv.filePath = this.pYg.field_fileFullPath;
    com.tencent.mm.sdk.b.a.ymk.l(paramd);
    AppMethodBeat.o(27383);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(27381);
    this.callback = paramf;
    this.pYg = new b();
    if ((!al.aUJ().get(this.pYi, this.pYg)) || (this.pYg == null))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.Ml() + " summerbig get info failed rowid:" + this.pYi);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.pYg = null;
      AppMethodBeat.o(27381);
      return -1;
    }
    if (this.pYg.field_status != 101L)
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.Ml() + " summerbig get field_status failed rowid:" + this.pYi + " status:" + this.pYg.field_status);
      AppMethodBeat.o(27381);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bo.aoy();
      this.vLL = this.pYg.field_offset;
    }
    ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.pYi), this.pYg.field_fileFullPath, Long.valueOf(this.pYg.field_totalLen), Boolean.valueOf(this.pYg.field_isUpload), Integer.valueOf(this.pYg.field_isUseCdn), Long.valueOf(this.pYg.field_type) });
    if (bo.isNullOrNil(this.pYg.field_appId))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.pYg.field_type != 8L) && (this.pYg.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        AppMethodBeat.o(27381);
        return -1;
      }
    }
    if ((this.pYg.field_type == 8L) || (this.pYg.field_type == 9L))
    {
      ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.pYg.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      ab.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.pYi) });
      AppMethodBeat.o(27381);
      return 0;
      com.tencent.mm.al.f.afO();
      if ((!com.tencent.mm.al.b.lc(4)) && (this.pYg.field_isUseCdn != 1))
      {
        com.tencent.mm.al.f.afO();
        ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.al.b.lc(4)), Integer.valueOf(this.pYg.field_isUseCdn) });
        i = 0;
      }
      else
      {
        aw.aaz();
        bi localbi = com.tencent.mm.model.c.YC().kB(this.pYg.field_msgInfoId);
        if (localbi.field_msgId != this.pYg.field_msgInfoId)
        {
          ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.pYg.field_msgInfoId), Long.valueOf(this.pYg.systemRowid), Long.valueOf(this.pYg.field_createTime), Long.valueOf(this.pYg.field_totalLen), Long.valueOf(this.pYg.field_status), Boolean.valueOf(this.pYg.field_isUpload), Integer.valueOf(this.pYg.field_isUseCdn), this.pYg.field_mediaId });
          this.toUser = null;
          i = 0;
        }
        else
        {
          this.toUser = localbi.field_talker;
          paramf = "";
          if (!bo.isNullOrNil(localbi.field_imgPath)) {
            paramf = o.ahC().te(localbi.field_imgPath);
          }
          int k = com.tencent.mm.a.e.cM(paramf);
          int m = com.tencent.mm.a.e.cM(this.pYg.field_fileFullPath);
          if (k >= 262144)
          {
            ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { paramf, Integer.valueOf(k) });
            i = 0;
          }
          else
          {
            this.fFo = com.tencent.mm.al.c.a("upattach", this.pYg.field_createTime, localbi.field_talker, this.pYi);
            ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.pYg.field_createTime), this.fFo });
            if (bo.isNullOrNil(this.fFo))
            {
              ab.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.pYi) });
              i = 0;
            }
            else
            {
              com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
              i = 0;
              String str = localbi.field_content;
              localObject = str;
              int j;
              if (t.lA(localbi.field_talker))
              {
                j = bf.pt(localbi.field_content);
                localObject = str;
                if (j != -1) {
                  localObject = (localbi.field_content + " ").substring(j + 2).trim();
                }
              }
              this.cmR = j.b.mY(bo.apU((String)localObject));
              label1099:
              label1108:
              boolean bool;
              if (this.cmR != null)
              {
                ab.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.cmR.fgL, bo.aqg(this.cmR.ewj), this.cmR.filemd5, Integer.valueOf(this.cmR.type) });
                localg.field_fileId = this.cmR.fgL;
                localg.field_aesKey = this.cmR.ewj;
                localg.field_filemd5 = this.cmR.filemd5;
                if ((this.cmR.fgA != 0) || (this.cmR.fgw > 26214400))
                {
                  i = 1;
                  if (i == 0) {
                    break label1534;
                  }
                  j = com.tencent.mm.i.a.ecH;
                  localg.field_appType = 0;
                  localg.edp = this.fFy;
                  localg.field_mediaId = this.fFo;
                  localg.field_fullpath = this.pYg.field_fileFullPath;
                  localg.field_thumbpath = paramf;
                  localg.field_fileType = j;
                  if (i == 0) {
                    break label1542;
                  }
                  localObject = bo.nullAsNil(this.pYg.field_signature);
                  label1173:
                  localg.field_svr_signature = ((String)localObject);
                  if (i == 0) {
                    break label1549;
                  }
                  bool = bo.isNullOrNil(this.pYg.field_signature);
                  label1196:
                  localg.field_onlycheckexist = bool;
                  localg.field_fake_bigfile_signature_aeskey = this.pYg.field_fakeAeskey;
                  localg.field_fake_bigfile_signature = this.pYg.field_fakeSignature;
                  localg.field_talker = localbi.field_talker;
                  localg.field_priority = com.tencent.mm.i.a.ecF;
                  localg.field_totalLen = m;
                  localg.field_needStorage = false;
                  localg.field_isStreamMedia = false;
                  localg.field_enable_hitcheck = this.fFG;
                  if (!t.lA(localbi.field_talker)) {
                    break label1555;
                  }
                }
              }
              label1542:
              label1549:
              label1555:
              for (i = 1;; i = 0)
              {
                localg.field_chattype = i;
                localg.field_force_aeskeycdn = false;
                localg.field_trysafecdn = true;
                localg.field_bzScene = 0;
                ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.pYg.field_msgInfoId), localg.field_fullpath, Integer.valueOf(m), paramf, Integer.valueOf(k), this.fFo, Integer.valueOf(localg.field_fileType), Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_onlycheckexist), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), bo.aqg(localg.field_aesKey), localg.field_filemd5, bo.aqg(localg.field_svr_signature), bo.aqg(localg.field_fake_bigfile_signature_aeskey), bo.aqg(localg.field_fake_bigfile_signature) });
                if (com.tencent.mm.al.f.afO().e(localg)) {
                  break label1560;
                }
                ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                this.fFo = "";
                i = 0;
                break;
                i = 0;
                break label1099;
                ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                break label1099;
                label1534:
                j = com.tencent.mm.i.a.MediaType_FILE;
                break label1108;
                localObject = "";
                break label1173;
                bool = false;
                break label1196;
              }
              label1560:
              if (this.pYg.field_isUseCdn != 1)
              {
                this.pYg.field_isUseCdn = 1;
                bool = al.aUJ().a(this.pYg, new String[0]);
                if (!bool)
                {
                  ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
                  this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
                  this.callback.onSceneEnd(3, -1, "", this);
                  i = 0;
                  continue;
                }
              }
              ab.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.fFo });
              i = 1;
            }
          }
        }
      }
    }
    if (this.pYg.field_netTimes > 3200L)
    {
      l.kX(this.pYg.systemRowid);
      ab.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.g.Ml() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.pYi);
      AppMethodBeat.o(27381);
      return -1;
    }
    paramf = this.pYg;
    paramf.field_netTimes += 1L;
    if (bo.isNullOrNil(this.pYg.field_clientAppDataId))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(27381);
      return -1;
    }
    if ((this.pYg.field_totalLen <= 0L) || (this.pYg.field_totalLen > 26214400L))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.pYg.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      if (this.pYg.field_totalLen > 26214400L) {
        l.kX(this.pYg.systemRowid);
      }
      AppMethodBeat.o(27381);
      return -1;
    }
    if (bo.isNullOrNil(this.pYg.field_fileFullPath))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(27381);
      return -1;
    }
    if (com.tencent.mm.a.e.cM(this.pYg.field_fileFullPath) > 26214400)
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      l.kX(this.pYg.systemRowid);
      AppMethodBeat.o(27381);
      return -1;
    }
    if (bo.isNullOrNil(this.fgy)) {}
    for (paramf = com.tencent.mm.a.e.j(this.pYg.field_fileFullPath, (int)this.pYg.field_offset, 8192); bo.ce(paramf); paramf = com.tencent.mm.a.e.j(this.pYg.field_fileFullPath, (int)this.pYg.field_offset, 32768))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(27381);
      return -1;
    }
    Object localObject = (cnt)this.rr.fsV.fta;
    ((cnt)localObject).fKw = this.pYg.field_appId;
    ((cnt)localObject).wpR = ((int)this.pYg.field_sdkVer);
    ((cnt)localObject).xWD = this.pYg.field_clientAppDataId;
    ((cnt)localObject).jKs = ((int)this.pYg.field_type);
    ((cnt)localObject).jJA = r.Zn();
    ((cnt)localObject).pIx = ((int)this.pYg.field_totalLen);
    ((cnt)localObject).pIy = ((int)this.pYg.field_offset);
    if ((this.fgy != null) && (this.pDi))
    {
      ((cnt)localObject).wQr = this.fgy;
      ((cnt)localObject).pIx = ((int)this.pYg.field_totalLen);
      ((cnt)localObject).pIz = 0;
      ((cnt)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      this.pDi = false;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(27381);
      return i;
    }
    ((cnt)localObject).pIz = paramf.length;
    ((cnt)localObject).pIA = new SKBuiltinBuffer_t().setBuffer(paramf);
    if (this.fgy != null) {
      ((cnt)localObject).wQr = this.fgy;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(27381);
    return i;
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(27382);
    ab.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bo.isNullOrNil(this.fFo)))
    {
      ab.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.fFo });
      AppMethodBeat.o(27382);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(com.tencent.mm.sdk.platformtools.ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.pYg.field_totalLen - this.vLL) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(27382);
      return;
    }
    paramString = (cnu)((com.tencent.mm.ai.b)paramq).fsW.fta;
    if ((paramString.fKw != null) && (this.fgy == null) && ((!paramString.fKw.equals(this.pYg.field_appId)) || (!paramString.xWD.equals(this.pYg.field_clientAppDataId))))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(27382);
      return;
    }
    if ((paramString.pIx < 0) || (paramString.pIx != this.pYg.field_totalLen) || (paramString.pIy < 0) || (paramString.pIy > this.pYg.field_totalLen))
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(27382);
      return;
    }
    this.pYg.field_offset = paramString.pIy;
    paramq = this.pYg;
    if (l.alt(paramString.fKz)) {}
    for (paramString = paramString.fKz;; paramString = "")
    {
      paramq.field_mediaSvrId = paramString;
      if (this.pYg.field_status != 105L) {
        break;
      }
      ab.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.pYg.field_mediaSvrId + "," + this.pYg.field_offset + "] ");
      this.callback.onSceneEnd(paramInt2, -1, "", this);
      AppMethodBeat.o(27382);
      return;
    }
    if (this.pYg.field_offset == this.pYg.field_totalLen)
    {
      if (bo.isNullOrNil(this.pYg.field_mediaSvrId))
      {
        ab.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
        this.callback.onSceneEnd(3, -1, "", this);
        l.kX(this.pYg.systemRowid);
        AppMethodBeat.o(27382);
        return;
      }
      this.pYg.field_status = 199L;
      com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(com.tencent.mm.sdk.platformtools.ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.pYg.field_totalLen - this.vLL) });
    }
    boolean bool = al.aUJ().a(this.pYg, new String[0]);
    if (!bool)
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      d(null);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(27382);
      return;
    }
    if (this.pYg.field_status == 199L)
    {
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(27382);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ab.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(27382);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ah
 * JD-Core Version:    0.7.0.1
 */