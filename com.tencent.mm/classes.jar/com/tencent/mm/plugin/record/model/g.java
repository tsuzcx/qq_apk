package com.tencent.mm.plugin.record.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;

public final class g
  extends p
  implements m
{
  private static g.a NAe = null;
  private com.tencent.mm.pluginsdk.model.app.c NAc;
  public long NAf;
  private int NAg;
  private String NAh;
  private boolean NAi;
  private boolean NAj;
  private boolean NAk;
  private com.tencent.mm.am.h callback;
  private cc hTm;
  private String mediaId;
  public long msgId;
  public com.tencent.mm.am.i oHS;
  private String oHX;
  private com.tencent.mm.modelcdntran.c oIg;
  public int retCode;
  private com.tencent.mm.am.c rr;
  private long startTime;
  private int type;
  private long vaU;
  public boolean xon;
  
  public g(long paramLong1, long paramLong2, com.tencent.mm.am.i parami)
  {
    AppMethodBeat.i(9475);
    this.NAc = null;
    this.NAf = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.hTm = null;
    this.oHX = "";
    this.startTime = 0L;
    this.NAg = -1;
    this.NAh = "";
    this.type = 0;
    this.retCode = 0;
    this.NAi = false;
    this.NAj = false;
    this.vaU = 0L;
    this.xon = false;
    this.NAk = false;
    this.oIg = new g..ExternalSyntheticLambda0(this);
    this.vaU = paramLong2;
    this.msgId = paramLong1;
    this.NAc = com.tencent.mm.plugin.openapi.a.cWJ().yi(paramLong1);
    this.oHS = parami;
    this.NAj = true;
    if (this.NAc == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "big appMsg, info is null, msgid = , svrId".concat(String.valueOf(paramLong1)), new Object[] { Long.valueOf(paramLong2) });
      AppMethodBeat.o(9475);
      return;
    }
    parami = new c.a();
    parami.otE = new akx();
    parami.otF = new aky();
    parami.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    parami.funcId = 221;
    parami.otG = 106;
    parami.respCmdId = 1000000106;
    this.rr = parami.bEF();
    AppMethodBeat.o(9475);
  }
  
  public g(long paramLong, String paramString, com.tencent.mm.am.i parami)
  {
    this(paramString, paramLong, parami);
    this.msgId = paramLong;
  }
  
  public g(com.tencent.mm.pluginsdk.model.app.c paramc)
  {
    AppMethodBeat.i(9476);
    this.NAc = null;
    this.NAf = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.hTm = null;
    this.oHX = "";
    this.startTime = 0L;
    this.NAg = -1;
    this.NAh = "";
    this.type = 0;
    this.retCode = 0;
    this.NAi = false;
    this.NAj = false;
    this.vaU = 0L;
    this.xon = false;
    this.NAk = false;
    this.oIg = new g..ExternalSyntheticLambda0(this);
    this.NAc = paramc;
    this.NAi = true;
    this.mediaId = this.NAc.field_mediaId;
    this.oHS = null;
    this.type = 0;
    if (paramc == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = " + this.mediaId);
      AppMethodBeat.o(9476);
      return;
    }
    c.a locala = new c.a();
    locala.otE = new akx();
    locala.otF = new aky();
    locala.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    locala.funcId = 221;
    locala.otG = 106;
    locala.respCmdId = 1000000106;
    this.rr = locala.bEF();
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach info fullpath[%s], justSaveFile[%b], stack[%s]", new Object[] { paramc.field_fileFullPath, Boolean.TRUE, Util.getStack() });
    AppMethodBeat.o(9476);
  }
  
  public g(String paramString)
  {
    this(paramString, 0L, null);
  }
  
  private g(String paramString, long paramLong, com.tencent.mm.am.i parami)
  {
    AppMethodBeat.i(9477);
    this.NAc = null;
    this.NAf = -1L;
    this.mediaId = "";
    this.msgId = 0L;
    this.hTm = null;
    this.oHX = "";
    this.startTime = 0L;
    this.NAg = -1;
    this.NAh = "";
    this.type = 0;
    this.retCode = 0;
    this.NAi = false;
    this.NAj = false;
    this.vaU = 0L;
    this.xon = false;
    this.NAk = false;
    this.oIg = new g..ExternalSyntheticLambda0(this);
    this.mediaId = paramString;
    this.msgId = paramLong;
    this.oHS = parami;
    this.type = 0;
    this.NAc = com.tencent.mm.plugin.openapi.a.cWJ().bpI(paramString);
    if (this.NAc == null) {
      this.NAc = com.tencent.mm.plugin.openapi.a.cWJ().yi(paramLong);
    }
    if (this.NAc == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig <init>, info is null, mediaId = ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(9477);
      return;
    }
    paramString = new c.a();
    paramString.otE = new akx();
    paramString.otF = new aky();
    paramString.uri = "/cgi-bin/micromsg-bin/downloadappattach";
    paramString.funcId = 221;
    paramString.otG = 106;
    paramString.respCmdId = 1000000106;
    this.rr = paramString.bEF();
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "summerbig NetSceneDownloadAppAttach , type[%d], info fullpath[%s], field_type[%d], signature[%s], stack[%s]", new Object[] { Integer.valueOf(0), this.NAc.field_fileFullPath, Long.valueOf(this.NAc.field_type), this.NAc.field_signature, Util.getStack() });
    AppMethodBeat.o(9477);
  }
  
  public static String a(long paramLong1, String paramString, long paramLong2)
  {
    AppMethodBeat.i(305350);
    paramString = com.tencent.mm.modelcdntran.h.a("downattach", paramLong1, paramString, String.valueOf(paramLong2));
    AppMethodBeat.o(305350);
    return paramString;
  }
  
  public static void a(g.a parama)
  {
    NAe = parama;
  }
  
  private static void bq(cc paramcc)
  {
    AppMethodBeat.i(305346);
    if (paramcc == null)
    {
      AppMethodBeat.o(305346);
      return;
    }
    try
    {
      k.b localb = k.b.Hf(paramcc.field_content);
      Object localObject;
      long l1;
      if (localb != null)
      {
        long l2 = paramcc.field_msgSvrId;
        localObject = (com.tencent.mm.message.a.b)localb.aK(com.tencent.mm.message.a.b.class);
        l1 = l2;
        if (localObject != null)
        {
          l1 = l2;
          if (((com.tencent.mm.message.a.b)localObject).nVD != 0L) {
            l1 = ((com.tencent.mm.message.a.b)localObject).nVD;
          }
        }
        localObject = localb.nRq;
        if (localb.nRh != 1) {
          break label262;
        }
      }
      label262:
      for (int i = 7;; i = 5)
      {
        paramcc = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[] { localObject, Integer.valueOf(i), Integer.valueOf(localb.nRd), Integer.valueOf(0), Long.valueOf((cn.bDv() - paramcc.getCreateTime()) / 1000L), Util.nullAsNil(localb.nRe).toLowerCase(), paramcc.field_talker, Integer.valueOf(1), "", Long.valueOf(l1), Long.valueOf(paramcc.getCreateTime()), Long.valueOf(cn.bDu()), Integer.valueOf(1) });
        Log.i("MicroMsg.NetSceneDownloadAppAttach", "reportKVStat 14665 %s", new Object[] { paramcc });
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(14665, paramcc);
        AppMethodBeat.o(305346);
        return;
      }
      return;
    }
    catch (Exception paramcc)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "reportKVStat exception:%s", new Object[] { paramcc.getMessage() });
      AppMethodBeat.o(305346);
    }
  }
  
  public static boolean f(cc paramcc, String paramString)
  {
    AppMethodBeat.i(305339);
    if (paramcc == null)
    {
      Log.i("MicroMsg.NetSceneDownloadAppAttach", "fileLanDownloadFinish msgInfo is null");
      AppMethodBeat.o(305339);
      return false;
    }
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "fileLanDownloadFinish msgId:%s, msgSvrId:%s", new Object[] { Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
    com.tencent.mm.pluginsdk.model.app.c localc = com.tencent.mm.plugin.openapi.a.cWJ().yi(paramcc.field_msgId);
    if (localc == null)
    {
      AppMethodBeat.o(305339);
      return false;
    }
    String str = a(localc.field_createTime, paramcc.field_talker, paramcc.field_msgId);
    new u(paramString).am(new u(localc.field_fileFullPath));
    localc.field_status = 199L;
    localc.field_offset = localc.field_totalLen;
    boolean bool = com.tencent.mm.plugin.openapi.a.cWJ().a(localc, new String[0]);
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "fileLanDownloadFinish mediaId:%s, updateRsult:%s", new Object[] { Util.nullAs(str, ""), Boolean.valueOf(bool) });
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 45L, localc.field_totalLen, false);
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(198L, 46L, 1L, false);
    paramString = com.tencent.mm.plugin.report.service.h.OAn;
    long l;
    if (paramcc == null)
    {
      paramcc = "";
      if (!au.bwE(paramcc)) {
        break label339;
      }
      l = 48L;
      label239:
      paramString.idkeyStat(198L, l, 1L, false);
      paramcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localc.field_msgInfoId);
      if ((paramcc.field_status != 5) && (paramcc.fileStatus == 0)) {
        break label346;
      }
      paramcc.setStatus(3);
      paramcc.setFileStatus(0);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(paramcc.field_msgId, paramcc);
    }
    for (;;)
    {
      AppMethodBeat.o(305339);
      return true;
      paramcc = paramcc.field_talker;
      break;
      label339:
      l = 47L;
      break label239;
      label346:
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(new i.c(paramcc.field_talker, "update", paramcc));
    }
  }
  
  private void g(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(9482);
    if (this.callback != null)
    {
      com.tencent.threadpool.h.ahAA.bk(new g..ExternalSyntheticLambda2(this, paramInt1, paramInt2, paramString, paramp));
      if (this.NAc != null)
      {
        long l = this.NAc.field_msgInfoId;
        paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(l);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).a(this.xon, String.valueOf(l), paramString.field_msgSvrId, true);
          if ((paramString.jbO()) && (this.oHS == null)) {
            bq(paramString);
          }
          if (NAe != null)
          {
            NAe.br(paramString);
            AppMethodBeat.o(9482);
          }
        }
        else
        {
          ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).a(this.xon, String.valueOf(l), paramString.field_msgSvrId, false);
        }
      }
    }
    AppMethodBeat.o(9482);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(9479);
    if (!this.NAi) {
      com.tencent.mm.modelcdntran.b.a(this.oHX, new g..ExternalSyntheticLambda1(this), paramb);
    }
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[] { paramb, this.NAc, Boolean.valueOf(this.NAi), Util.getStack() });
    AppMethodBeat.o(9479);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(9480);
    this.callback = paramh;
    if (this.NAc == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", f.aPX() + " get info failed mediaId:" + this.mediaId);
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    this.hTm = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.msgId);
    if ((this.hTm == null) || (this.hTm.field_msgId != this.msgId))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", f.aPX() + " get msginfo failed mediaId:%s  msgId:%d", new Object[] { this.mediaId, Long.valueOf(this.msgId) });
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.NAg = ((int)this.NAc.field_offset);
    }
    if (this.vaU != 0L)
    {
      paramh = (akx)c.b.b(this.rr.otB);
      paramh.UserName = z.bAM();
      paramh.NkN = ((int)this.NAc.field_totalLen);
      paramh.NkO = ((int)this.NAc.field_offset);
      paramh.NkP = 0;
      paramh.vhJ = 40;
      paramh.Njv = this.vaU;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
    Object localObject = this.hTm.field_content;
    paramh = (com.tencent.mm.am.h)localObject;
    if (au.bwE(this.hTm.field_talker))
    {
      i = br.JG(this.hTm.field_content);
      paramh = (com.tencent.mm.am.h)localObject;
      if (i != -1) {
        paramh = (this.hTm.field_content + " ").substring(i + 2).trim();
      }
    }
    paramh = k.b.Hf(Util.processXml(paramh));
    if (paramh == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn cdntra parse content xml failed: mediaId:%s", new Object[] { this.mediaId });
      i = 0;
    }
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneDownloadAppAttach", "cdntra use cdn return -1 for onGYNetEnd mediaid:%s", new Object[] { this.mediaId });
      AppMethodBeat.o(9480);
      return 0;
      Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgid:%d total:%d fullpath:%s fileid:%s aeskey:%s ", new Object[] { Long.valueOf(this.msgId), Long.valueOf(this.NAc.field_totalLen), this.NAc.field_fileFullPath, paramh.nRq, Util.secPrint(paramh.aesKey) });
      if (((Util.isNullOrNil(paramh.nRq)) && (Util.isNullOrNil(paramh.tpurl))) || (Util.isNullOrNil(paramh.aesKey)))
      {
        Log.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra checkUseCdn msgId:%d Not use CDN  cdnAttachUrl:%s aes:%s ", new Object[] { Long.valueOf(this.msgId), paramh.nRq, Util.secPrint(paramh.aesKey) });
        i = 0;
      }
      else
      {
        this.oHX = a(this.NAc.field_createTime, this.hTm.field_talker, this.hTm.field_msgId);
        if (Util.isNullOrNil(this.oHX))
        {
          Log.w("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.NAf) });
          i = 0;
        }
        else
        {
          y.bDX(y.bEo(this.NAc.field_fileFullPath));
          this.NAh = (this.NAc.field_fileFullPath + "_tmp");
          localObject = new com.tencent.mm.g.g();
          ((com.tencent.mm.g.g)localObject).taskName = "task_NetSceneDownloadAppAttach";
          ((com.tencent.mm.g.g)localObject).field_mediaId = this.oHX;
          ((com.tencent.mm.g.g)localObject).field_fullpath = this.NAh;
          if ((paramh.nRh != 0) || (paramh.nRd > 26214400))
          {
            i = com.tencent.mm.g.a.lwb;
            label752:
            ((com.tencent.mm.g.g)localObject).field_fileType = i;
            ((com.tencent.mm.g.g)localObject).field_totalLen = ((int)this.NAc.field_totalLen);
            ((com.tencent.mm.g.g)localObject).field_aesKey = paramh.aesKey;
            ((com.tencent.mm.g.g)localObject).field_fileId = paramh.nRq;
            ((com.tencent.mm.g.g)localObject).field_svr_signature = this.NAc.field_signature;
            ((com.tencent.mm.g.g)localObject).field_fake_bigfile_signature_aeskey = this.NAc.field_fakeAeskey;
            ((com.tencent.mm.g.g)localObject).field_fake_bigfile_signature = this.NAc.field_fakeSignature;
            ((com.tencent.mm.g.g)localObject).field_onlycheckexist = false;
            ((com.tencent.mm.g.g)localObject).field_priority = com.tencent.mm.g.a.lvZ;
            if (!au.bwE(this.hTm.field_talker)) {
              break label1074;
            }
            i = 1;
            label854:
            ((com.tencent.mm.g.g)localObject).field_chattype = i;
            if ((!com.tencent.mm.modelcdntran.h.bHQ()) || ((paramh.nRh == 0) && (paramh.nRd <= 26214400))) {
              break label1079;
            }
          }
          label1074:
          label1079:
          for (boolean bool = true;; bool = false)
          {
            ((com.tencent.mm.g.g)localObject).field_use_multithread = bool;
            if (!Util.isNullOrNil(paramh.tpurl))
            {
              ((com.tencent.mm.g.g)localObject).field_fileType = 19;
              ((com.tencent.mm.g.g)localObject).field_authKey = paramh.nRn;
              ((com.tencent.mm.g.g)localObject).lwO = paramh.tpurl;
              ((com.tencent.mm.g.g)localObject).field_fileId = "";
            }
            Log.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn addRecvTask taskInfo field_use_multithread[%s], field_fileType[%d], fileFullPath[%s], aeskey[%s], signature[%s], faeskey[%s], fsignature[%s], onlycheckexist[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.g.g)localObject).field_use_multithread), Integer.valueOf(((com.tencent.mm.g.g)localObject).field_fileType), ((com.tencent.mm.g.g)localObject).field_fullpath, Util.secPrint(((com.tencent.mm.g.g)localObject).field_aesKey), Util.secPrint(((com.tencent.mm.g.g)localObject).field_svr_signature), Util.secPrint(((com.tencent.mm.g.g)localObject).field_fake_bigfile_signature_aeskey), Util.secPrint(((com.tencent.mm.g.g)localObject).field_fake_bigfile_signature), Boolean.valueOf(((com.tencent.mm.g.g)localObject).field_onlycheckexist) });
            if (com.tencent.mm.modelcdntran.b.a((com.tencent.mm.g.g)localObject, this.oIg, null) != null) {
              break label1085;
            }
            Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig cdntra addSendTask failed.");
            this.oHX = "";
            i = 0;
            break;
            i = com.tencent.mm.g.a.MediaType_FILE;
            break label752;
            i = 0;
            break label854;
          }
          label1085:
          if (this.NAc.field_isUseCdn != 1)
          {
            this.NAc.field_isUseCdn = 1;
            bool = com.tencent.mm.plugin.openapi.a.cWJ().a(this.NAc, new String[0]);
            if (!bool)
            {
              Log.e("MicroMsg.NetSceneDownloadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
              this.retCode = (-10000 - f.getLine());
              g(3, -1, "", this);
              i = 0;
              continue;
            }
          }
          i = 1;
        }
      }
    }
    if (this.NAc.field_status == 102L)
    {
      this.NAc.field_status = 101L;
      if (!this.NAi) {
        com.tencent.mm.plugin.openapi.a.cWJ().a(this.NAc, new String[0]);
      }
    }
    this.NAf = this.NAc.systemRowid;
    if ((Util.isNullOrNil(this.NAc.field_mediaSvrId)) && (this.vaU == 0L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : mediaId is null");
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((this.NAc.field_totalLen <= 0L) || (this.NAc.field_totalLen > 26214400L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : totalLen is invalid, totalLen = " + this.NAc.field_totalLen);
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    if ((Util.isNullOrNil(this.NAc.field_fileFullPath)) && (this.vaU == 0L))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is null");
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(9480);
      return -1;
    }
    int j = (int)y.bEl(this.NAc.field_fileFullPath);
    int i = j;
    if (this.NAk)
    {
      i = j - 6;
      if (i <= 0) {
        break label1502;
      }
    }
    while (i != this.NAc.field_offset)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "checkArgs : fileFullPath is invalid, fileLength = " + i + ", info.field_offset = " + this.NAc.field_offset);
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(9480);
      return -1;
      label1502:
      i = 0;
    }
    Log.i("MicroMsg.NetSceneDownloadAppAttach", "downing attach by non cdn, appId: %s,  mediaId: %s, sdkVer: %d", new Object[] { this.NAc.field_appId, this.NAc.field_mediaSvrId, Long.valueOf(this.NAc.field_sdkVer) });
    paramh = (akx)c.b.b(this.rr.otB);
    paramh.oOI = this.NAc.field_appId;
    paramh.oOL = this.NAc.field_mediaSvrId;
    paramh.YHj = ((int)this.NAc.field_sdkVer);
    paramh.UserName = z.bAM();
    paramh.NkN = ((int)this.NAc.field_totalLen);
    paramh.NkO = ((int)this.NAc.field_offset);
    paramh.NkP = 0;
    if (this.vaU != 0L) {
      paramh.Njv = this.vaU;
    }
    if (this.type != 0) {}
    for (paramh.vhJ = this.type;; paramh.vhJ = ((int)this.NAc.field_type))
    {
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(9480);
      return i;
    }
  }
  
  public final void gGg()
  {
    AppMethodBeat.i(9478);
    this.NAk = true;
    if (this.NAk)
    {
      String str = this.NAc.field_fileFullPath;
      byte[] arrayOfByte = "#!AMR\n".getBytes();
      y.e(str, arrayOfByte, arrayOfByte.length);
    }
    AppMethodBeat.o(9478);
  }
  
  public final String getMediaId()
  {
    if (this.NAc == null) {
      return "";
    }
    return this.NAc.field_mediaSvrId;
  }
  
  public final int getType()
  {
    return 221;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(9481);
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.w("MicroMsg.NetSceneDownloadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.oHX });
      AppMethodBeat.o(9481);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - f.getLine());
      g(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(9481);
      return;
    }
    paramString = (aky)c.c.b(((com.tencent.mm.am.c)params).otC);
    this.NAc.field_totalLen = paramString.NkN;
    if ((paramString.oOL != null) && (!paramString.oOL.equals(this.NAc.field_mediaSvrId)))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.NkO != this.NAc.field_offset)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "startPos, totalLen is incorrect startpos:" + paramString.NkO);
      this.retCode = (-10000 - f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (paramString.NkP + this.NAc.field_offset > this.NAc.field_totalLen)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect datalen:" + paramString.NkP + " off:" + this.NAc.field_offset + " total?:" + this.NAc.field_totalLen);
      this.retCode = (-10000 - f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    paramArrayOfByte = w.a(paramString.NkQ);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0) || (paramArrayOfByte.length != paramString.NkP))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "data buffer is incorrect");
      this.retCode = (-10000 - f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (a.q(this.mediaId, this.msgId) == null)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed, msg maybe revoked or deleted. msgId:%d", new Object[] { Long.valueOf(this.NAc.field_msgInfoId) });
      this.retCode = (-10000 - f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    params = new String(paramArrayOfByte);
    Log.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download big appmsg : %s", new Object[] { Boolean.valueOf(this.NAj) });
    cc localcc;
    StringBuffer localStringBuffer;
    if ((this.NAc.field_offset < this.NAc.field_totalLen) && (this.NAj))
    {
      localcc = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.NAc.field_msgInfoId);
      paramString = params;
      if (params.startsWith("<?xml version="))
      {
        paramInt1 = params.indexOf("<appmsg");
        Log.i("MicroMsg.NetSceneDownloadAppAttach", "inclued: <?xml version=  index:%s", new Object[] { Integer.valueOf(paramInt1) });
        paramString = params;
        if (paramInt1 > 0) {
          paramString = params.substring(paramInt1);
        }
      }
      if (!paramString.startsWith("<appmsg")) {
        break label1101;
      }
      if (!au.bwE(localcc.field_talker)) {
        break label1089;
      }
      if (!Util.isNullOrNil(localcc.field_content))
      {
        params = localcc.field_content.split("\n", 2)[0];
        localStringBuffer = new StringBuffer();
        this.NAc.field_fullXml = (params + "\n");
        params = new StringBuffer();
        params.append(this.NAc.field_fullXml).append(paramString);
        this.NAc.field_fullXml = params.toString();
      }
      if ((paramString.endsWith("</appmsg>")) || (this.NAc.field_offset + paramArrayOfByte.length == this.NAc.field_totalLen))
      {
        if (!au.bwE(localcc.field_talker)) {
          break label1167;
        }
        params = localcc.field_content.split("\n", 2);
        Object localObject = params[0];
        localStringBuffer = new StringBuffer();
        localObject = localStringBuffer.append((String)localObject).append("\n<msg>");
        if (params.length <= 1) {
          break label1160;
        }
        params = params[1];
        label921:
        ((StringBuffer)localObject).append(params).append(paramString).append("</msg>");
      }
    }
    for (this.NAc.field_fullXml = localStringBuffer.toString();; this.NAc.field_fullXml = params.toString())
    {
      if (localcc != null) {
        localcc.setContent(this.NAc.field_fullXml);
      }
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.NAc.field_msgInfoId, localcc);
      Log.d("MicroMsg.NetSceneDownloadAppAttach", "dancy download full xml succed! xml: [%s]", new Object[] { paramString });
      paramInt1 = y.e(this.NAc.field_fileFullPath, paramArrayOfByte, paramArrayOfByte.length);
      if ((Util.isNullOrNil(this.NAc.field_fileFullPath)) || (paramInt1 == 0)) {
        break label1216;
      }
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "append to file failed:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
      label1089:
      this.NAc.field_fullXml = paramString;
      break;
      label1101:
      if ((localcc == null) || (localcc.field_content.startsWith("<msg>"))) {
        break;
      }
      params = new StringBuffer();
      params.append(localcc.field_content).append(paramString);
      this.NAc.field_fullXml = params.toString();
      break;
      label1160:
      params = "";
      break label921;
      label1167:
      params = new StringBuffer();
      params.append("<msg>").append(this.NAc.field_fullXml).append("</msg>");
    }
    label1216:
    paramString = this.NAc;
    long l = paramString.field_offset;
    paramString.field_offset = (paramArrayOfByte.length + l);
    if (this.NAc.field_offset == this.NAc.field_totalLen) {
      this.NAc.field_status = 199L;
    }
    if ((this.oHS != null) && (this.oHS != null)) {
      this.oHS.a((int)this.NAc.field_offset, (int)this.NAc.field_totalLen, this);
    }
    if (this.NAi) {}
    for (boolean bool = true; !bool; bool = com.tencent.mm.plugin.openapi.a.cWJ().a(this.NAc, new String[0]))
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(paramInt1)));
      this.retCode = (-10000 - f.getLine());
      g(3, -1, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.NAc.field_status == 199L)
    {
      paramString = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.NAc.field_msgInfoId);
      ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(new i.c(paramString.field_talker, "update", paramString));
      g(0, 0, "", this);
      AppMethodBeat.o(9481);
      return;
    }
    if (this.NAc.field_status == 102L)
    {
      g(3, -1, "", this);
      this.retCode = -20102;
      AppMethodBeat.o(9481);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      Log.e("MicroMsg.NetSceneDownloadAppAttach", "onGYNetEnd : doScene fail");
      g(3, -1, "", this);
    }
    AppMethodBeat.o(9481);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(305366);
    a(null);
    AppMethodBeat.o(305366);
  }
  
  public final int securityLimitCount()
  {
    return 400;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  public static abstract interface b
  {
    public abstract void gGh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.record.model.g
 * JD-Core Version:    0.7.0.1
 */