package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.tm;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.g.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.g.b;
import com.tencent.mm.pluginsdk.g.d.a;
import com.tencent.mm.protocal.protobuf.fsz;
import com.tencent.mm.protocal.protobuf.fta;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;

public final class an
  extends p
  implements m
{
  c NAc;
  long NAf;
  private boolean NdJ;
  private long XTd;
  boolean XTe;
  private com.tencent.mm.am.h callback;
  private k.b hzP;
  private boolean mxR;
  private int mxT;
  private com.tencent.mm.g.d mxU;
  private IListener mxW;
  private String nRf;
  String oHX;
  private d.a oIA;
  private boolean oIo;
  private com.tencent.mm.g.g.a osH;
  int retCode;
  private com.tencent.mm.am.c rr;
  private String sessionId;
  private long startTime;
  private String toUser;
  
  public an(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31073);
    this.NAc = null;
    this.hzP = null;
    this.NAf = -1L;
    this.nRf = null;
    this.NdJ = true;
    this.oIo = true;
    this.retCode = 0;
    this.startTime = 0L;
    this.XTd = -1L;
    this.oHX = "";
    this.XTe = false;
    this.oIA = new d.a()
    {
      public final void T(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(244945);
        Log.e("MicroMsg.NetSceneUploadAppAttach", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        n.tn(an.b(an.this).systemRowid);
        as.cWJ().get(an.c(an.this), an.b(an.this));
        an.b(an.this).field_signature = "";
        boolean bool = as.cWJ().a(an.b(an.this), new String[0]);
        Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(-1), Long.valueOf(an.c(an.this)), Boolean.valueOf(bool) });
        an.d(an.this).onSceneEnd(3, paramAnonymousInt, "", an.this);
        AppMethodBeat.o(244945);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(244940);
        Log.i("MicroMsg.NetSceneUploadAppAttach", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.fileLength) });
        Util.nowMilliSecond();
        an.a(an.this);
        com.tencent.mm.g.d locald = new com.tencent.mm.g.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.vyS;
        locald.field_fileLength = paramAnonymousa.fileLength;
        k.bHX();
        locald.field_filecrc = com.tencent.mm.modelcdntran.d.Nt(an.b(an.this).field_fileFullPath);
        an.a(an.this, locald);
        AppMethodBeat.o(244940);
      }
      
      public final void b(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(244949);
        an.b(an.this).field_lastModifyTime = Util.nowSecond();
        if (an.b(an.this).field_offset < paramAnonymousLong) {
          an.b(an.this).field_offset = paramAnonymousLong;
        }
        boolean bool = as.cWJ().a(an.b(an.this), new String[0]);
        if (!bool)
        {
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          an.a(an.this, -10000 - com.tencent.mm.compatible.util.f.getLine());
          an.d(an.this).onSceneEnd(3, -1, "", an.this);
        }
        AppMethodBeat.o(244949);
      }
    };
    this.osH = new com.tencent.mm.g.g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, final com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(244951);
        paramAnonymousString = an.h(an.this);
        boolean bool1;
        if (paramAnonymousc != null)
        {
          bool1 = true;
          if (paramAnonymousd == null) {
            break label147;
          }
        }
        label147:
        for (boolean bool2 = true;; bool2 = false)
        {
          Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          as.cWJ().get(an.c(an.this), an.b(an.this));
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { an.h(an.this) });
          AppMethodBeat.o(244951);
          return 0;
          bool1 = false;
          break;
        }
        label153:
        if (paramAnonymousInt != 0)
        {
          n.tn(an.b(an.this).systemRowid);
          as.cWJ().get(an.c(an.this), an.b(an.this));
          an.b(an.this).field_signature = "";
          paramAnonymousBoolean = as.cWJ().a(an.b(an.this), new String[0]);
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(an.c(an.this)), Boolean.valueOf(paramAnonymousBoolean) });
          an.d(an.this).onSceneEnd(3, paramAnonymousInt, "", an.this);
          AppMethodBeat.o(244951);
          return 0;
        }
        if (an.b(an.this).field_status == 105L)
        {
          Log.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(an.b(an.this).field_status), Long.valueOf(an.c(an.this)) });
          k.bHW().Ny(an.h(an.this));
          an.d(an.this).onSceneEnd(3, paramAnonymousInt, "attach  has paused, status" + an.b(an.this).field_status, an.this);
          AppMethodBeat.o(244951);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          an.b(an.this).field_lastModifyTime = Util.nowSecond();
          an.b(an.this).field_offset = paramAnonymousc.field_finishedLength;
          paramAnonymousBoolean = as.cWJ().a(an.b(an.this), new String[0]);
          if (!paramAnonymousBoolean)
          {
            Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(paramAnonymousBoolean)));
            an.a(an.this, -10000 - com.tencent.mm.compatible.util.f.getLine());
            an.d(an.this).onSceneEnd(3, paramAnonymousInt, "", an.this);
            AppMethodBeat.o(244951);
            return 0;
          }
          AppMethodBeat.o(244951);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label774;
          }
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.lwx });
          n.tn(an.b(an.this).systemRowid);
          as.cWJ().get(an.c(an.this), an.b(an.this));
          an.b(an.this).field_signature = "";
          paramAnonymousBoolean = as.cWJ().a(an.b(an.this), new String[0]);
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(an.c(an.this)), Boolean.valueOf(paramAnonymousBoolean) });
          an.d(an.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", an.this);
        }
        for (;;)
        {
          AppMethodBeat.o(244951);
          return 0;
          label774:
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), Util.secPrint(an.b(an.this).field_signature) });
          if (paramAnonymousBoolean)
          {
            if (paramAnonymousd.field_exist_whencheck)
            {
              bh.aZW().a(new com.tencent.mm.pluginsdk.h.c(an.i(an.this), an.b(an.this).field_fileFullPath, an.j(an.this), new com.tencent.mm.pluginsdk.h.c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(244934);
                  paramAnonymous2String3 = Util.secPrint(paramAnonymous2String3);
                  String str1 = Util.secPrint(paramAnonymous2String4);
                  String str2 = Util.secPrint(paramAnonymous2String5);
                  String str3 = Util.secPrint(paramAnonymous2String6);
                  if (an.i(an.this) == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new errMsg:[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2String3, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(an.f(an.this)) });
                    if (!Util.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    bh.bCz();
                    paramAnonymous2String2 = com.tencent.mm.model.c.bzD().sl(an.b(an.this).field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    bh.bCz();
                    com.tencent.mm.model.c.bzD().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String2 = new cc();
                    paramAnonymous2String2.setCreateTime(br.JN(an.j(an.this)));
                    paramAnonymous2String2.BS(an.j(an.this));
                    paramAnonymous2String2.setContent(paramAnonymous2String1);
                    paramAnonymous2String2.setType(10000);
                    paramAnonymous2String2.setStatus(6);
                    paramAnonymous2String2.pI(0);
                    bh.bCz();
                    com.tencent.mm.model.c.bzD().ba(paramAnonymous2String2);
                    AppMethodBeat.o(244934);
                    return;
                  }
                  an.b(an.this).field_signature = paramAnonymous2String4;
                  an.b(an.this).field_fakeAeskey = paramAnonymous2String5;
                  an.b(an.this).field_fakeSignature = paramAnonymous2String6;
                  an.3.this.a(paramAnonymousInt, paramAnonymousd);
                  AppMethodBeat.o(244934);
                }
              }), 0);
            }
            else
            {
              Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
              bh.aZW().a(new com.tencent.mm.pluginsdk.h.c(null, an.b(an.this).field_fileFullPath, an.j(an.this), new com.tencent.mm.pluginsdk.h.c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(244939);
                  String str1 = Util.secPrint(paramAnonymous2String3);
                  String str2 = Util.secPrint(paramAnonymous2String4);
                  String str3 = Util.secPrint(paramAnonymous2String5);
                  String str4 = Util.secPrint(paramAnonymous2String6);
                  if (an.i(an.this) == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new errMsg[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(an.f(an.this)) });
                    if (!Util.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    bh.bCz();
                    paramAnonymous2String2 = com.tencent.mm.model.c.bzD().sl(an.b(an.this).field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    bh.bCz();
                    com.tencent.mm.model.c.bzD().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String2 = new cc();
                    paramAnonymous2String2.setCreateTime(br.JN(an.j(an.this)));
                    paramAnonymous2String2.BS(an.j(an.this));
                    paramAnonymous2String2.setContent(paramAnonymous2String1);
                    paramAnonymous2String2.setType(10000);
                    paramAnonymous2String2.setStatus(6);
                    paramAnonymous2String2.pI(0);
                    bh.bCz();
                    com.tencent.mm.model.c.bzD().ba(paramAnonymous2String2);
                    AppMethodBeat.o(244939);
                    return;
                  }
                  an.b(an.this).field_signature = paramAnonymous2String4;
                  an.b(an.this).field_fakeAeskey = paramAnonymous2String5;
                  an.b(an.this).field_fakeSignature = paramAnonymous2String6;
                  an.b(an.this).field_lastModifyTime = Util.nowMilliSecond();
                  if (an.i(an.this) != null)
                  {
                    an.i(an.this).filemd5 = paramAnonymous2String2;
                    an.i(an.this).aesKey = paramAnonymous2String3;
                    an.i(an.this).nRd = ((int)paramAnonymous2Long);
                    bh.bCz();
                    paramAnonymous2String1 = com.tencent.mm.model.c.bzD().sl(an.b(an.this).field_msgInfoId);
                    paramAnonymous2String1.setContent(k.b.a(an.i(an.this), null, null));
                    bh.bCz();
                    com.tencent.mm.model.c.bzD().a(paramAnonymous2String1.field_msgId, paramAnonymous2String1);
                  }
                  an.e(an.this);
                  bool = as.cWJ().a(an.b(an.this), new String[0]);
                  if (!bool)
                  {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
                    an.a(an.this, -10000 - com.tencent.mm.compatible.util.f.getLine());
                    an.d(an.this).onSceneEnd(3, paramAnonymousInt, "", an.this);
                    AppMethodBeat.o(244939);
                    return;
                  }
                  bh.baH().postToWorker(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(244891);
                      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                      an.this.doScene(an.k(an.this), an.d(an.this));
                      AppMethodBeat.o(244891);
                    }
                  });
                  AppMethodBeat.o(244939);
                }
              }), 0);
            }
          }
          else {
            a(paramAnonymousInt, paramAnonymousd);
          }
        }
      }
      
      final void a(int paramAnonymousInt, final com.tencent.mm.g.d paramAnonymousd)
      {
        AppMethodBeat.i(244955);
        an.b(an.this).field_status = 199L;
        boolean bool = as.cWJ().a(an.b(an.this), new String[0]);
        if (!bool)
        {
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          an.a(an.this, -10000 - com.tencent.mm.compatible.util.f.getLine());
          an.d(an.this).onSceneEnd(3, paramAnonymousInt, "", an.this);
          AppMethodBeat.o(244955);
          return;
        }
        n.a(an.b(an.this).field_msgInfoId, an.b(an.this).field_mediaSvrId, paramAnonymousd, true);
        bh.aZW().a(new al(an.b(an.this).field_msgInfoId, true, paramAnonymousd, new al.a()
        {
          public final void eF(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(244933);
            Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              bh.baH().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(244823);
                  an.e(an.this);
                  an.b(an.this).field_createTime = cn.bDu();
                  an.b(an.this).field_lastModifyTime = Util.nowSecond();
                  an.b(an.this).field_offset = 0L;
                  an.b(an.this).field_status = 101L;
                  boolean bool = as.cWJ().a(an.b(an.this), new String[0]);
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(an.f(an.this)), Boolean.valueOf(bool), Long.valueOf(an.b(an.this).field_createTime) });
                  an.this.doScene(an.l(an.this), an.d(an.this));
                  AppMethodBeat.o(244823);
                }
              });
              AppMethodBeat.o(244933);
              return;
            }
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              an.b(an.this, paramAnonymousd);
            }
            an.d(an.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", an.this);
            AppMethodBeat.o(244933);
          }
        }, an.m(an.this), an.b(an.this)), 0);
        AppMethodBeat.o(244955);
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.mxR = false;
    this.mxT = 0;
    this.mxW = new NetSceneUploadAppAttach.4(this, com.tencent.mm.app.f.hfK);
    this.NAf = paramLong;
    this.nRf = paramString1;
    this.sessionId = paramString2;
    paramString2 = new com.tencent.mm.am.c.a();
    paramString2.otE = new fsz();
    paramString2.otF = new fta();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.funcId = 220;
    paramString2.otG = 105;
    paramString2.respCmdId = 1000000105;
    this.rr = paramString2.bEF();
    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, Util.getStack() });
    AppMethodBeat.o(31073);
  }
  
  private void e(com.tencent.mm.g.d paramd)
  {
    AppMethodBeat.i(31076);
    if (this.NAc.field_type != 2L)
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.mxT = 1;
    if ((this.mxR) || (this.mxT == 0))
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.mxU = paramd;
    this.mxR = true;
    paramd = new tm();
    this.mxW.alive();
    paramd.hXd.filePath = this.NAc.field_fileFullPath;
    paramd.hXd.hBk = System.currentTimeMillis();
    paramd.publish();
    AppMethodBeat.o(31076);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(31074);
    this.callback = paramh;
    this.XTe = false;
    this.NAc = new c();
    if ((!as.cWJ().get(this.NAf, this.NAc)) || (this.NAc == null))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.aPX() + " summerbig get info failed rowid:" + this.NAf);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.NAc = null;
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.NAc.field_status != 101L)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.aPX() + " summerbig get field_status failed rowid:" + this.NAf + " status:" + this.NAc.field_status);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.XTd = this.NAc.field_offset;
    }
    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.NAf), this.NAc.field_fileFullPath, Long.valueOf(this.NAc.field_totalLen), Boolean.valueOf(this.NAc.field_isUpload), Integer.valueOf(this.NAc.field_isUseCdn), Long.valueOf(this.NAc.field_type) });
    if (Util.isNullOrNil(this.NAc.field_appId))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.NAc.field_type != 8L) && (this.NAc.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
    }
    if ((this.NAc.field_type == 8L) || (this.NAc.field_type == 9L))
    {
      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.NAc.field_type) });
      i = 0;
    }
    Object localObject3;
    Object localObject4;
    Object localObject2;
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.NAf) });
      AppMethodBeat.o(31074);
      return 0;
      if (!b.iGQ())
      {
        Log.i("MicroMsg.NetSceneUploadAppAttach", "isAllow2UseCdnWithXLab = false");
        i = 0;
      }
      else
      {
        k.bHW();
        if ((!com.tencent.mm.modelcdntran.g.vV(4)) && (this.NAc.field_isUseCdn != 1))
        {
          k.bHW();
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.g.vV(4)), Integer.valueOf(this.NAc.field_isUseCdn) });
          i = 0;
        }
        else
        {
          bh.bCz();
          localObject3 = com.tencent.mm.model.c.bzD().sl(this.NAc.field_msgInfoId);
          if ((localObject3 == null) || (((fi)localObject3).field_msgId != this.NAc.field_msgInfoId))
          {
            Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.NAc.field_msgInfoId), Long.valueOf(this.NAc.systemRowid), Long.valueOf(this.NAc.field_createTime), Long.valueOf(this.NAc.field_totalLen), Long.valueOf(this.NAc.field_status), Boolean.valueOf(this.NAc.field_isUpload), Integer.valueOf(this.NAc.field_isUseCdn), this.NAc.field_mediaId });
            this.toUser = null;
            i = 0;
          }
          else
          {
            this.toUser = ((fi)localObject3).field_talker;
            paramh = "";
            if (!Util.isNullOrNil(((fi)localObject3).field_imgPath)) {
              paramh = r.bKa().NY(((fi)localObject3).field_imgPath);
            }
            int k = (int)y.bEl(paramh);
            int m = (int)y.bEl(this.NAc.field_fileFullPath);
            if (k >= 262144)
            {
              Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { paramh, Integer.valueOf(k) });
              i = 0;
            }
            else
            {
              this.oHX = com.tencent.mm.modelcdntran.h.a("upattach", this.NAc.field_createTime, ((fi)localObject3).field_talker, this.NAf);
              Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.NAc.field_createTime), this.oHX });
              if (Util.isNullOrNil(this.oHX))
              {
                Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.NAf) });
                i = 0;
              }
              else
              {
                localObject4 = new com.tencent.mm.g.g();
                ((com.tencent.mm.g.g)localObject4).taskName = "task_NetSceneUploadAppAttach";
                i = 0;
                localObject2 = ((fi)localObject3).field_content;
                localObject1 = localObject2;
                int j;
                if (au.bwE(((fi)localObject3).field_talker))
                {
                  j = br.JG(((fi)localObject3).field_content);
                  localObject1 = localObject2;
                  if (j != -1) {
                    localObject1 = (((fi)localObject3).field_content + " ").substring(j + 2).trim();
                  }
                }
                this.hzP = k.b.Hf(Util.processXml((String)localObject1));
                if (this.hzP != null)
                {
                  Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.hzP.nRq, Util.secPrint(this.hzP.aesKey), this.hzP.filemd5, Integer.valueOf(this.hzP.type) });
                  ((com.tencent.mm.g.g)localObject4).field_fileId = this.hzP.nRq;
                  ((com.tencent.mm.g.g)localObject4).field_aesKey = this.hzP.aesKey;
                  ((com.tencent.mm.g.g)localObject4).field_filemd5 = this.hzP.filemd5;
                  if ((this.hzP.nRh != 0) || (this.hzP.nRd > 26214400))
                  {
                    i = 1;
                    label1138:
                    if (i == 0) {
                      break label1607;
                    }
                    j = a.lwb;
                    label1147:
                    ((com.tencent.mm.g.g)localObject4).field_appType = 0;
                    ((com.tencent.mm.g.g)localObject4).lwL = this.osH;
                    ((com.tencent.mm.g.g)localObject4).field_mediaId = this.oHX;
                    ((com.tencent.mm.g.g)localObject4).field_fullpath = this.NAc.field_fileFullPath;
                    ((com.tencent.mm.g.g)localObject4).field_thumbpath = paramh;
                    ((com.tencent.mm.g.g)localObject4).field_fileType = j;
                    if (i == 0) {
                      break label1615;
                    }
                    localObject1 = Util.nullAsNil(this.NAc.field_signature);
                    label1212:
                    ((com.tencent.mm.g.g)localObject4).field_svr_signature = ((String)localObject1);
                    if (i == 0) {
                      break label1622;
                    }
                    bool = Util.isNullOrNil(this.NAc.field_signature);
                    label1235:
                    ((com.tencent.mm.g.g)localObject4).field_onlycheckexist = bool;
                    ((com.tencent.mm.g.g)localObject4).field_fake_bigfile_signature_aeskey = this.NAc.field_fakeAeskey;
                    ((com.tencent.mm.g.g)localObject4).field_fake_bigfile_signature = this.NAc.field_fakeSignature;
                    ((com.tencent.mm.g.g)localObject4).field_talker = ((fi)localObject3).field_talker;
                    ((com.tencent.mm.g.g)localObject4).field_priority = a.lvZ;
                    ((com.tencent.mm.g.g)localObject4).field_totalLen = m;
                    ((com.tencent.mm.g.g)localObject4).field_needStorage = false;
                    ((com.tencent.mm.g.g)localObject4).field_isStreamMedia = false;
                    ((com.tencent.mm.g.g)localObject4).field_enable_hitcheck = this.oIo;
                    if (!au.bwE(((fi)localObject3).field_talker)) {
                      break label1628;
                    }
                    j = 1;
                    label1326:
                    ((com.tencent.mm.g.g)localObject4).field_chattype = j;
                    ((com.tencent.mm.g.g)localObject4).field_force_aeskeycdn = false;
                    ((com.tencent.mm.g.g)localObject4).field_trysafecdn = true;
                    ((com.tencent.mm.g.g)localObject4).field_bzScene = 0;
                    if ((!com.tencent.mm.modelcdntran.h.bHQ()) || (i == 0)) {
                      break label1634;
                    }
                  }
                }
                label1607:
                label1615:
                label1622:
                label1628:
                label1634:
                for (boolean bool = true;; bool = false)
                {
                  ((com.tencent.mm.g.g)localObject4).field_use_multithread = bool;
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn field_use_multithread[%s], msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.g.g)localObject4).field_use_multithread), Long.valueOf(this.NAc.field_msgInfoId), ((com.tencent.mm.g.g)localObject4).field_fullpath, Integer.valueOf(m), paramh, Integer.valueOf(k), this.oHX, Integer.valueOf(((com.tencent.mm.g.g)localObject4).field_fileType), Boolean.valueOf(((com.tencent.mm.g.g)localObject4).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.g.g)localObject4).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.g.g)localObject4).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.g.g)localObject4).field_trysafecdn), Util.secPrint(((com.tencent.mm.g.g)localObject4).field_aesKey), ((com.tencent.mm.g.g)localObject4).field_filemd5, Util.secPrint(((com.tencent.mm.g.g)localObject4).field_svr_signature), Util.secPrint(((com.tencent.mm.g.g)localObject4).field_fake_bigfile_signature_aeskey), Util.secPrint(((com.tencent.mm.g.g)localObject4).field_fake_bigfile_signature) });
                  if (k.bHW().g((com.tencent.mm.g.g)localObject4)) {
                    break label1640;
                  }
                  Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                  this.oHX = "";
                  i = 0;
                  break;
                  i = 0;
                  break label1138;
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                  break label1138;
                  j = a.MediaType_FILE;
                  break label1147;
                  localObject1 = "";
                  break label1212;
                  bool = false;
                  break label1235;
                  j = 0;
                  break label1326;
                }
                label1640:
                if (this.NAc.field_isUseCdn != 1)
                {
                  this.NAc.field_isUseCdn = 1;
                  bool = as.cWJ().a(this.NAc, new String[0]);
                  if (!bool)
                  {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
                    this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    this.callback.onSceneEnd(3, -1, "", this);
                    i = 0;
                    continue;
                  }
                }
                Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.oHX });
                i = 1;
              }
            }
          }
        }
      }
    }
    if ((this.NAc.field_type == 8L) || (this.NAc.field_type == 9L))
    {
      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig parallel-upload support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.NAc.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene use parallel-upload return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.NAf) });
      AppMethodBeat.o(31074);
      return 0;
      if (1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.zpC, 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1885;
        }
        Log.i("MicroMsg.NetSceneUploadAppAttach", "NOT ALLOW USE PARALLEL UPLOAD APP ATTACH");
        i = 0;
        break;
      }
      label1885:
      bh.bCz();
      localObject1 = com.tencent.mm.model.c.bzD().sl(this.NAc.field_msgInfoId);
      if ((localObject1 == null) || (((fi)localObject1).field_msgId != this.NAc.field_msgInfoId))
      {
        Log.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.NAc.field_msgInfoId), Long.valueOf(this.NAc.systemRowid), Long.valueOf(this.NAc.field_createTime), Long.valueOf(this.NAc.field_totalLen), Long.valueOf(this.NAc.field_status), Boolean.valueOf(this.NAc.field_isUpload), Integer.valueOf(this.NAc.field_isUseCdn), this.NAc.field_mediaId });
        this.toUser = null;
        i = 0;
      }
      else
      {
        paramh = "";
        if (!Util.isNullOrNil(((fi)localObject1).field_imgPath)) {
          paramh = r.bKa().NY(((fi)localObject1).field_imgPath);
        }
        localObject2 = new com.tencent.mm.pluginsdk.g.d();
        ((com.tencent.mm.pluginsdk.g.d)localObject2).oGz = iIF();
        ((com.tencent.mm.pluginsdk.g.d)localObject2).XPa = this.oIA;
        ((com.tencent.mm.pluginsdk.g.d)localObject2).scene = 3;
        ((com.tencent.mm.pluginsdk.g.d)localObject2).fileType = 5;
        ((com.tencent.mm.pluginsdk.g.d)localObject2).thumbPath = paramh;
        ((com.tencent.mm.pluginsdk.g.d)localObject2).fullPath = this.NAc.field_fileFullPath;
        localObject3 = new com.tencent.mm.pluginsdk.g.c();
        bh.bCz();
        localObject4 = com.tencent.mm.model.c.bzD().sl(this.NAc.field_msgInfoId);
        if ((localObject4 == null) || (((fi)localObject4).field_msgId != this.NAc.field_msgInfoId))
        {
          Log.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.NAc.field_msgInfoId), Long.valueOf(this.NAc.systemRowid), Long.valueOf(this.NAc.field_createTime), Long.valueOf(this.NAc.field_totalLen), Long.valueOf(this.NAc.field_status), Boolean.valueOf(this.NAc.field_isUpload), Integer.valueOf(this.NAc.field_isUseCdn), this.NAc.field_mediaId });
          this.toUser = null;
          paramh = "";
          label2311:
          if (this.NAc == null) {
            break label2551;
          }
        }
        label2551:
        for (localObject1 = this.NAc.field_signature;; localObject1 = null)
        {
          ((com.tencent.mm.pluginsdk.g.c)localObject3).XOH = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.g.c)localObject3).XOI = paramh;
          ((com.tencent.mm.pluginsdk.g.c)localObject3).a((com.tencent.mm.pluginsdk.g.d)localObject2);
          this.XTe = true;
          i = 1;
          break;
          localObject1 = ((fi)localObject4).field_content;
          paramh = (com.tencent.mm.am.h)localObject1;
          if (au.bwE(((fi)localObject4).field_talker))
          {
            i = br.JG(((fi)localObject4).field_content);
            paramh = (com.tencent.mm.am.h)localObject1;
            if (i != -1) {
              paramh = (((fi)localObject4).field_content + " ").substring(i + 2).trim();
            }
          }
          this.hzP = k.b.Hf(paramh);
          if (((this.hzP != null) && (this.hzP.nRh != 0)) || (this.hzP.nRd > 26214400))
          {
            Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.hzP.nRq, Util.secPrint(this.hzP.aesKey), this.hzP.filemd5, Integer.valueOf(this.hzP.type) });
            paramh = this.hzP.aesKey;
            break label2311;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
          paramh = "";
          break label2311;
        }
      }
    }
    if (this.NAc.field_netTimes > 3200L)
    {
      n.tn(this.NAc.systemRowid);
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.aPX() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.NAf);
      AppMethodBeat.o(31074);
      return -1;
    }
    paramh = this.NAc;
    paramh.field_netTimes += 1L;
    if (Util.isNullOrNil(this.NAc.field_clientAppDataId))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((this.NAc.field_totalLen <= 0L) || (this.NAc.field_totalLen > 26214400L))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.NAc.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (this.NAc.field_totalLen > 26214400L) {
        n.tn(this.NAc.systemRowid);
      }
      AppMethodBeat.o(31074);
      return -1;
    }
    if (Util.isNullOrNil(this.NAc.field_fileFullPath))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((int)y.bEl(this.NAc.field_fileFullPath) > 26214400)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      n.tn(this.NAc.systemRowid);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (Util.isNullOrNil(this.nRf)) {}
    for (paramh = y.bi(this.NAc.field_fileFullPath, (int)this.NAc.field_offset, 8192); Util.isNullOrNil(paramh); paramh = y.bi(this.NAc.field_fileFullPath, (int)this.NAc.field_offset, 32768))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    Object localObject1 = (fsz)c.b.b(this.rr.otB);
    ((fsz)localObject1).oOI = this.NAc.field_appId;
    ((fsz)localObject1).YHj = ((int)this.NAc.field_sdkVer);
    ((fsz)localObject1).abRk = this.NAc.field_clientAppDataId;
    ((fsz)localObject1).vhJ = ((int)this.NAc.field_type);
    ((fsz)localObject1).UserName = z.bAM();
    ((fsz)localObject1).NkN = ((int)this.NAc.field_totalLen);
    ((fsz)localObject1).NkO = ((int)this.NAc.field_offset);
    if ((this.nRf != null) && (this.NdJ))
    {
      ((fsz)localObject1).MD5 = this.nRf;
      ((fsz)localObject1).NkN = ((int)this.NAc.field_totalLen);
      ((fsz)localObject1).NkP = 0;
      ((fsz)localObject1).NkQ = new gol().df(new byte[0]);
      this.NdJ = false;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(31074);
      return i;
    }
    ((fsz)localObject1).NkP = paramh.length;
    ((fsz)localObject1).NkQ = new gol().df(paramh);
    if (this.nRf != null) {
      ((fsz)localObject1).MD5 = this.nRf;
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(31074);
    return i;
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final long iIF()
  {
    if (this.NAc == null) {
      return 0L;
    }
    return this.NAc.field_msgInfoId;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31075);
    Log.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.oHX });
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31075);
      return;
    }
    paramString = (fta)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((paramString.oOI != null) && (this.nRf == null) && ((!paramString.oOI.equals(this.NAc.field_appId)) || (!paramString.abRk.equals(this.NAc.field_clientAppDataId))))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramString.NkN < 0) || (paramString.NkN != this.NAc.field_totalLen) || (paramString.NkO < 0) || (paramString.NkO > this.NAc.field_totalLen))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    this.NAc.field_offset = paramString.NkO;
    params = this.NAc;
    if (n.bpS(paramString.oOL)) {}
    for (paramString = paramString.oOL;; paramString = "")
    {
      params.field_mediaSvrId = paramString;
      if (this.NAc.field_status != 105L) {
        break;
      }
      Log.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.NAc.field_mediaSvrId + "," + this.NAc.field_offset + "] ");
      this.callback.onSceneEnd(paramInt2, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.NAc.field_offset == this.NAc.field_totalLen)
    {
      if (Util.isNullOrNil(this.NAc.field_mediaSvrId))
      {
        Log.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        this.callback.onSceneEnd(3, -1, "", this);
        n.tn(this.NAc.systemRowid);
        AppMethodBeat.o(31075);
        return;
      }
      this.NAc.field_status = 199L;
    }
    boolean bool = as.cWJ().a(this.NAc, new String[0]);
    if (!bool)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      e(null);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.NAc.field_status == 199L)
    {
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(31075);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.an
 * JD-Core Version:    0.7.0.1
 */