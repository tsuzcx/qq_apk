package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.m.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class e
  extends m
  implements k
{
  private String cBO;
  bi cEE;
  com.tencent.mm.ai.f callback;
  public long cpO;
  com.tencent.mm.ai.g fFj;
  String fFo;
  private g.a fFy;
  private long jDz;
  com.tencent.mm.pluginsdk.model.app.b pYg;
  public long pYi;
  private int pYj;
  String pYk;
  private boolean pYl;
  private boolean pYm;
  private boolean pYn;
  public int retCode;
  private com.tencent.mm.ai.b rr;
  long startTime;
  private int type;
  
  public e(long paramLong1, long paramLong2, com.tencent.mm.ai.g paramg)
  {
    AppMethodBeat.i(135655);
    this.pYg = null;
    this.pYi = -1L;
    this.cBO = "";
    this.cpO = 0L;
    this.cEE = null;
    this.fFo = "";
    this.startTime = 0L;
    this.pYj = -1;
    this.pYk = "";
    this.type = 0;
    this.retCode = 0;
    this.pYl = false;
    this.pYm = false;
    this.jDz = 0L;
    this.pYn = false;
    this.fFy = new e.1(this);
    this.jDz = paramLong2;
    this.cpO = paramLong1;
    this.pYg = com.tencent.mm.plugin.s.a.aUJ().nw(paramLong1);
    this.fFj = paramg;
    this.pYm = true;
    if (this.pYg == null)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(paramLong1)), new Object[] { Long.valueOf(paramLong2) });
      AppMethodBeat.o(135655);
      return;
    }
    paramg = new b.a();
    paramg.fsX = new ys();
    paramg.fsY = new yt();
    paramg.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramg.funcId = 221;
    paramg.reqCmdId = 106;
    paramg.respCmdId = 1000000106;
    this.rr = paramg.ado();
    AppMethodBeat.o(135655);
  }
  
  public e(long paramLong, String paramString, com.tencent.mm.ai.g paramg)
  {
    this(paramString, paramLong, paramg);
    this.cpO = paramLong;
  }
  
  public e(com.tencent.mm.pluginsdk.model.app.b paramb)
  {
    AppMethodBeat.i(135656);
    this.pYg = null;
    this.pYi = -1L;
    this.cBO = "";
    this.cpO = 0L;
    this.cEE = null;
    this.fFo = "";
    this.startTime = 0L;
    this.pYj = -1;
    this.pYk = "";
    this.type = 0;
    this.retCode = 0;
    this.pYl = false;
    this.pYm = false;
    this.jDz = 0L;
    this.pYn = false;
    this.fFy = new e.1(this);
    this.pYg = paramb;
    this.pYl = true;
    this.cBO = this.pYg.field_mediaId;
    this.fFj = null;
    this.type = 0;
    if (paramb == null)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.cBO);
      AppMethodBeat.o(135656);
      return;
    }
    b.a locala = new b.a();
    locala.fsX = new ys();
    locala.fsY = new yt();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.funcId = 221;
    locala.reqCmdId = 106;
    locala.respCmdId = 1000000106;
    this.rr = locala.ado();
    ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramb.field_fileFullPath, Boolean.TRUE, bo.dtY() });
    AppMethodBeat.o(135656);
  }
  
  public e(String paramString)
  {
    this(paramString, 0L, null);
  }
  
  private e(String paramString, long paramLong, com.tencent.mm.ai.g paramg)
  {
    AppMethodBeat.i(135657);
    this.pYg = null;
    this.pYi = -1L;
    this.cBO = "";
    this.cpO = 0L;
    this.cEE = null;
    this.fFo = "";
    this.startTime = 0L;
    this.pYj = -1;
    this.pYk = "";
    this.type = 0;
    this.retCode = 0;
    this.pYl = false;
    this.pYm = false;
    this.jDz = 0L;
    this.pYn = false;
    this.fFy = new e.1(this);
    this.cBO = paramString;
    this.cpO = paramLong;
    this.fFj = paramg;
    this.type = 0;
    this.pYg = com.tencent.mm.plugin.s.a.aUJ().alo(paramString);
    if (this.pYg == null) {
      this.pYg = com.tencent.mm.plugin.s.a.aUJ().nw(paramLong);
    }
    if (this.pYg == null)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(135657);
      return;
    }
    paramString = new b.a();
    paramString.fsX = new ys();
    paramString.fsY = new yt();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.funcId = 221;
    paramString.reqCmdId = 106;
    paramString.respCmdId = 1000000106;
    this.rr = paramString.ado();
    ab.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.pYg.field_fileFullPath, Long.valueOf(this.pYg.field_type), this.pYg.field_signature, bo.dtY() });
    AppMethodBeat.o(135657);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(135659);
    if (!this.pYl)
    {
      com.tencent.mm.al.f.afO().sJ(this.fFo);
      this.pYg = com.tencent.mm.plugin.s.a.aUJ().nw(this.cpO);
      if (this.pYg == null)
      {
        ab.i("MicroMsg.NetSceneDownloadAppAttach", "pause get by msgid  %是is null then get by mediaId %s", new Object[] { Long.valueOf(this.cpO), this.cBO });
        this.pYg = com.tencent.mm.plugin.s.a.aUJ().alo(this.cBO);
      }
    }
    ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { parama, this.pYg, Boolean.valueOf(this.pYl), bo.dtY() });
    if (this.pYg == null)
    {
      AppMethodBeat.o(135659);
      return;
    }
    if ((this.pYg.field_status == 101L) && (parama != null)) {
      parama.cfP();
    }
    this.pYg.field_status = 102L;
    if (!this.pYl) {
      ab.i("MicroMsg.NetSceneDownloadAppAttach", "pause done %s", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.s.a.aUJ().a(this.pYg, new String[0])) });
    }
    AppMethodBeat.o(135659);
  }
  
  public final void cfO()
  {
    AppMethodBeat.i(135658);
    this.pYn = true;
    if (this.pYn) {
      com.tencent.mm.a.e.e(this.pYg.field_fileFullPath, "#!AMR\n".getBytes());
    }
    AppMethodBeat.o(135658);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ai.f paramf)
  {
    AppMethodBeat.i(135660);
    this.callback = paramf;
    if (this.pYg == null)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.Ml() + " get info failed mediaId:" + this.cBO);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(135660);
      return -1;
    }
    this.cEE = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.cpO);
    if ((this.cEE == null) || (this.cEE.field_msgId != this.cpO))
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", com.tencent.mm.compatible.util.g.Ml() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.cBO, Long.valueOf(this.cpO) });
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(135660);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bo.aoy();
      this.pYj = ((int)this.pYg.field_offset);
    }
    if (this.jDz != 0L)
    {
      paramf = (ys)this.rr.fsV.fta;
      paramf.jJA = r.Zn();
      paramf.pIx = ((int)this.pYg.field_totalLen);
      paramf.pIy = ((int)this.pYg.field_offset);
      paramf.pIz = 0;
      paramf.jKs = 40;
      paramf.pIG = this.jDz;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(135660);
      return i;
    }
    Object localObject = this.cEE.field_content;
    paramf = (com.tencent.mm.ai.f)localObject;
    if (t.lA(this.cEE.field_talker))
    {
      i = bf.pt(this.cEE.field_content);
      paramf = (com.tencent.mm.ai.f)localObject;
      if (i != -1) {
        paramf = (this.cEE.field_content + " ").substring(i + 2).trim();
      }
    }
    paramf = j.b.mY(bo.apU(paramf));
    if (paramf == null)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.cBO });
      i = 0;
    }
    while (i != 0)
    {
      ab.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.cBO });
      AppMethodBeat.o(135660);
      return 0;
      ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.cpO), Long.valueOf(this.pYg.field_totalLen), this.pYg.field_fileFullPath, paramf.fgL, bo.aqg(paramf.ewj) });
      if (((bo.isNullOrNil(paramf.fgL)) && (bo.isNullOrNil(paramf.fgC))) || (bo.isNullOrNil(paramf.ewj)))
      {
        ab.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.cpO), paramf.fgL, bo.aqg(paramf.ewj) });
        i = 0;
      }
      else
      {
        this.fFo = com.tencent.mm.al.c.a("downattach", this.pYg.field_createTime, this.cEE.field_talker, this.pYi);
        if (bo.isNullOrNil(this.fFo))
        {
          ab.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.pYi) });
          i = 0;
        }
        else
        {
          com.tencent.mm.a.e.cR(this.pYg.field_fileFullPath);
          this.pYk = (this.pYg.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.i.g();
          ((com.tencent.mm.i.g)localObject).field_mediaId = this.fFo;
          ((com.tencent.mm.i.g)localObject).field_fullpath = this.pYk;
          if ((paramf.fgA != 0) || (paramf.fgw > 26214400))
          {
            i = com.tencent.mm.i.a.ecH;
            label753:
            ((com.tencent.mm.i.g)localObject).field_fileType = i;
            ((com.tencent.mm.i.g)localObject).field_totalLen = ((int)this.pYg.field_totalLen);
            ((com.tencent.mm.i.g)localObject).field_aesKey = paramf.ewj;
            ((com.tencent.mm.i.g)localObject).field_fileId = paramf.fgL;
            ((com.tencent.mm.i.g)localObject).field_svr_signature = this.pYg.field_signature;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey = this.pYg.field_fakeAeskey;
            ((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature = this.pYg.field_fakeSignature;
            ((com.tencent.mm.i.g)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.i.g)localObject).field_priority = com.tencent.mm.i.a.ecF;
            ((com.tencent.mm.i.g)localObject).edp = this.fFy;
            if (!t.lA(this.cEE.field_talker)) {
              break label1038;
            }
          }
          label1038:
          for (i = 1;; i = 0)
          {
            ((com.tencent.mm.i.g)localObject).field_chattype = i;
            if (!bo.isNullOrNil(paramf.fgC))
            {
              ((com.tencent.mm.i.g)localObject).field_fileType = 19;
              ((com.tencent.mm.i.g)localObject).field_authKey = paramf.fgI;
              ((com.tencent.mm.i.g)localObject).eds = paramf.fgC;
              ((com.tencent.mm.i.g)localObject).field_fileId = "";
            }
            ab.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Integer.valueOf(((com.tencent.mm.i.g)localObject).field_fileType), ((com.tencent.mm.i.g)localObject).field_fullpath, bo.aqg(((com.tencent.mm.i.g)localObject).field_aesKey), bo.aqg(((com.tencent.mm.i.g)localObject).field_svr_signature), bo.aqg(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature_aeskey), bo.aqg(((com.tencent.mm.i.g)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.i.g)localObject).field_onlycheckexist) });
            if (com.tencent.mm.al.f.afO().b((com.tencent.mm.i.g)localObject, -1)) {
              break label1043;
            }
            ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.fFo = "";
            i = 0;
            break;
            i = com.tencent.mm.i.a.MediaType_FILE;
            break label753;
          }
          label1043:
          if (this.pYg.field_isUseCdn != 1)
          {
            this.pYg.field_isUseCdn = 1;
            boolean bool = com.tencent.mm.plugin.s.a.aUJ().a(this.pYg, new String[0]);
            if (!bool)
            {
              ab.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
              this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
              this.callback.onSceneEnd(3, -1, "", this);
              i = 0;
              continue;
            }
          }
          i = 1;
        }
      }
    }
    if (this.pYg.field_status == 102L)
    {
      this.pYg.field_status = 101L;
      if (!this.pYl) {
        com.tencent.mm.plugin.s.a.aUJ().a(this.pYg, new String[0]);
      }
    }
    this.pYi = this.pYg.systemRowid;
    if ((bo.isNullOrNil(this.pYg.field_mediaSvrId)) && (this.jDz == 0L))
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(135660);
      return -1;
    }
    if ((this.pYg.field_totalLen <= 0L) || (this.pYg.field_totalLen > 26214400L))
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.pYg.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(135660);
      return -1;
    }
    if ((bo.isNullOrNil(this.pYg.field_fileFullPath)) && (this.jDz == 0L))
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(135660);
      return -1;
    }
    int j = com.tencent.mm.a.e.cM(this.pYg.field_fileFullPath);
    int i = j;
    if (this.pYn)
    {
      i = j - 6;
      if (i <= 0) {
        break label1464;
      }
    }
    while (i != this.pYg.field_offset)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.pYg.field_offset);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      AppMethodBeat.o(135660);
      return -1;
      label1464:
      i = 0;
    }
    ab.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.pYg.field_appId, this.pYg.field_mediaSvrId, Long.valueOf(this.pYg.field_sdkVer) });
    paramf = (ys)this.rr.fsV.fta;
    paramf.fKw = this.pYg.field_appId;
    paramf.fKz = this.pYg.field_mediaSvrId;
    paramf.wpR = ((int)this.pYg.field_sdkVer);
    paramf.jJA = r.Zn();
    paramf.pIx = ((int)this.pYg.field_totalLen);
    paramf.pIy = ((int)this.pYg.field_offset);
    paramf.pIz = 0;
    if (this.jDz != 0L) {
      paramf.pIG = this.jDz;
    }
    if (this.type != 0) {}
    for (paramf.jKs = this.type;; paramf.jKs = ((int)this.pYg.field_type))
    {
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(135660);
      return i;
    }
  }
  
  public final String getMediaId()
  {
    if (this.pYg == null) {
      return "";
    }
    return this.pYg.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(135661);
    ab.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bo.isNullOrNil(this.fFo)))
    {
      ab.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.fFo });
      AppMethodBeat.o(135661);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(135661);
      return;
    }
    paramString = (yt)((com.tencent.mm.ai.b)paramq).fsW.fta;
    this.pYg.field_totalLen = paramString.pIx;
    if ((paramString.fKz != null) && (!paramString.fKz.equals(this.pYg.field_mediaSvrId)))
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(135661);
      return;
    }
    if (paramString.pIy != this.pYg.field_offset)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramString.pIy);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(135661);
      return;
    }
    if (paramString.pIz + this.pYg.field_offset > this.pYg.field_totalLen)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramString.pIz + " off:" + this.pYg.field_offset + " total?:" + this.pYg.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(135661);
      return;
    }
    paramArrayOfByte = aa.a(paramString.pIA);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length != paramString.pIz))
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(135661);
      return;
    }
    paramq = new String(paramArrayOfByte);
    ab.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.pYm) });
    bi localbi;
    StringBuffer localStringBuffer;
    if ((this.pYg.field_offset < this.pYg.field_totalLen) && (this.pYm))
    {
      localbi = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.pYg.field_msgInfoId);
      paramString = paramq;
      if (paramq.startsWith("<?xml version="))
      {
        paramInt1 = paramq.indexOf("<appmsg");
        ab.i("MicroMsg.NetSceneDownloadAppAttach", "inclued: <?xml version=  index:%s", new Object[] { Integer.valueOf(paramInt1) });
        paramString = paramq;
        if (paramInt1 > 0) {
          paramString = paramq.substring(paramInt1);
        }
      }
      if (!paramString.startsWith("<appmsg")) {
        break label1005;
      }
      if (!t.lA(localbi.field_talker)) {
        break label993;
      }
      if (!bo.isNullOrNil(localbi.field_content))
      {
        paramq = localbi.field_content.split("\n", 2)[0];
        localStringBuffer = new StringBuffer();
        this.pYg.field_fullXml = (paramq + "\n");
        paramq = new StringBuffer();
        paramq.append(this.pYg.field_fullXml).append(paramString);
        this.pYg.field_fullXml = paramq.toString();
      }
    }
    for (;;)
    {
      localbi.setContent(this.pYg.field_fullXml);
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(this.pYg.field_msgInfoId, localbi);
      ab.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramString });
      paramInt1 = com.tencent.mm.a.e.e(this.pYg.field_fileFullPath, paramArrayOfByte);
      if ((bo.isNullOrNil(this.pYg.field_fileFullPath)) || (paramInt1 == 0)) {
        break;
      }
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(135661);
      return;
      label993:
      this.pYg.field_fullXml = paramString;
      continue;
      label1005:
      if (!localbi.field_content.startsWith("<msg>"))
      {
        paramq = new StringBuffer();
        paramq.append(localbi.field_content).append(paramString);
        this.pYg.field_fullXml = paramq.toString();
      }
      if ((paramString.endsWith("</appmsg>")) || (this.pYg.field_offset + paramArrayOfByte.length == this.pYg.field_totalLen))
      {
        if (t.lA(localbi.field_talker))
        {
          paramq = localbi.field_content.split("\n", 2);
          Object localObject = paramq[0];
          localStringBuffer = new StringBuffer();
          localObject = localStringBuffer.append((String)localObject).append("\n<msg>");
          if (paramq.length > 1) {}
          for (paramq = paramq[1];; paramq = "")
          {
            ((StringBuffer)localObject).append(paramq).append(paramString).append("</msg>");
            this.pYg.field_fullXml = localStringBuffer.toString();
            break;
          }
        }
        paramq = new StringBuffer();
        paramq.append("<msg>").append(this.pYg.field_fullXml).append("</msg>");
        this.pYg.field_fullXml = paramq.toString();
      }
    }
    paramString = this.pYg;
    long l = paramString.field_offset;
    paramString.field_offset = (paramArrayOfByte.length + l);
    if (this.pYg.field_offset == this.pYg.field_totalLen) {
      this.pYg.field_status = 199L;
    }
    if (this.fFj != null) {
      al.d(new e.2(this));
    }
    if (this.pYl) {}
    for (boolean bool = true; !bool; bool = com.tencent.mm.plugin.s.a.aUJ().a(this.pYg, new String[0]))
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.g.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(135661);
      return;
    }
    if (this.pYg.field_status == 199L)
    {
      com.tencent.mm.plugin.report.service.h.qsU.e(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(2), Long.valueOf(this.startTime), Long.valueOf(bo.aoy()), Integer.valueOf(com.tencent.mm.al.c.cb(ah.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.pYg.field_totalLen - this.pYj) });
      paramString = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.pYg.field_msgInfoId);
      ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().a(new h.c(paramString.field_talker, "update", paramString));
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(135661);
      return;
    }
    if (this.pYg.field_status == 102L)
    {
      this.callback.onSceneEnd(3, -1, "", this);
      this.retCode = -20102;
      AppMethodBeat.o(135661);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ab.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(135661);
  }
  
  public final int securityLimitCount()
  {
    return 400;
  }
  
  public final m.b securityVerificationChecked(q paramq)
  {
    return m.b.ftu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.record.b.e
 * JD-Core Version:    0.7.0.1
 */