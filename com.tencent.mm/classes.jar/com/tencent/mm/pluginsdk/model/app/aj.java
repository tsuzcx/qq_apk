package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q.b;
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.rx;
import com.tencent.mm.f.a.rz;
import com.tencent.mm.f.a.rz.a;
import com.tencent.mm.f.b.a.ac;
import com.tencent.mm.f.b.a.ae;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.h.c.a;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.exg;
import com.tencent.mm.protocal.protobuf.exh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class aj
  extends com.tencent.mm.an.q
  implements com.tencent.mm.network.m
{
  long HCC;
  c HCz;
  private boolean Hdz;
  private long QXf;
  boolean QXg;
  private com.tencent.mm.an.i callback;
  private k.b fvu;
  private boolean jXX;
  private int jXZ;
  private com.tencent.mm.i.d jYa;
  private IListener jYc;
  private boolean lPF;
  private com.tencent.mm.pluginsdk.g.d.a lPR;
  String lPn;
  private com.tencent.mm.i.g.a lPx;
  private String llZ;
  int retCode;
  private com.tencent.mm.an.d rr;
  private String sessionId;
  private long startTime;
  private String toUser;
  
  public aj(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31073);
    this.HCz = null;
    this.fvu = null;
    this.HCC = -1L;
    this.llZ = null;
    this.Hdz = true;
    this.lPF = true;
    this.retCode = 0;
    this.startTime = 0L;
    this.QXf = -1L;
    this.lPn = "";
    this.QXg = false;
    this.lPR = new com.tencent.mm.pluginsdk.g.d.a()
    {
      public final void O(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(289733);
        Log.e("MicroMsg.NetSceneUploadAppAttach", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(aj.a(aj.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        m.Pn(aj.b(aj.this).systemRowid);
        ao.ctZ().get(aj.c(aj.this), aj.b(aj.this));
        aj.b(aj.this).field_signature = "";
        boolean bool = ao.ctZ().a(aj.b(aj.this), new String[0]);
        Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(-1), Long.valueOf(aj.c(aj.this)), Boolean.valueOf(bool) });
        aj.d(aj.this).onSceneEnd(3, paramAnonymousInt, "", aj.this);
        AppMethodBeat.o(289733);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(289734);
        aj.b(aj.this).field_lastModifyTime = Util.nowSecond();
        if (aj.b(aj.this).field_offset < paramAnonymousLong) {
          aj.b(aj.this).field_offset = paramAnonymousLong;
        }
        boolean bool = ao.ctZ().a(aj.b(aj.this), new String[0]);
        if (!bool)
        {
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          aj.a(aj.this, -10000 - com.tencent.mm.compatible.util.f.getLine());
          aj.d(aj.this).onSceneEnd(3, -1, "", aj.this);
        }
        AppMethodBeat.o(289734);
      }
      
      public final void a(com.tencent.mm.pluginsdk.g.g.a paramAnonymousa)
      {
        AppMethodBeat.i(289732);
        Log.i("MicroMsg.NetSceneUploadAppAttach", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.mHi) });
        long l1 = Util.nowMilliSecond();
        long l2 = aj.a(aj.this);
        long l3 = paramAnonymousa.mHi;
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(aj.a(aj.this)), Long.valueOf(l1), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(l3), Long.valueOf(l3 / (l1 - l2)), Integer.valueOf(1) });
        com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.smU;
        locald.field_fileLength = paramAnonymousa.mHi;
        com.tencent.mm.aq.f.bkh();
        locald.field_filecrc = com.tencent.mm.aq.a.Vt(aj.b(aj.this).field_fileFullPath);
        aj.a(aj.this, locald);
        AppMethodBeat.o(289732);
      }
    };
    this.lPx = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(231427);
        paramAnonymousString = aj.h(aj.this);
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
          ao.ctZ().get(aj.c(aj.this), aj.b(aj.this));
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { aj.h(aj.this) });
          AppMethodBeat.o(231427);
          return 0;
          bool1 = false;
          break;
        }
        label153:
        if (paramAnonymousInt != 0)
        {
          m.Pn(aj.b(aj.this).systemRowid);
          ao.ctZ().get(aj.c(aj.this), aj.b(aj.this));
          aj.b(aj.this).field_signature = "";
          paramAnonymousBoolean = ao.ctZ().a(aj.b(aj.this), new String[0]);
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(aj.c(aj.this)), Boolean.valueOf(paramAnonymousBoolean) });
          aj.d(aj.this).onSceneEnd(3, paramAnonymousInt, "", aj.this);
          new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(aj.a(aj.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bpa();
          AppMethodBeat.o(231427);
          return 0;
        }
        if (aj.b(aj.this).field_status == 105L)
        {
          Log.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(aj.b(aj.this).field_status), Long.valueOf(aj.c(aj.this)) });
          com.tencent.mm.aq.f.bkg().Vy(aj.h(aj.this));
          aj.d(aj.this).onSceneEnd(3, paramAnonymousInt, "attach  has paused, status" + aj.b(aj.this).field_status, aj.this);
          AppMethodBeat.o(231427);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          aj.b(aj.this).field_lastModifyTime = Util.nowSecond();
          aj.b(aj.this).field_offset = paramAnonymousc.field_finishedLength;
          paramAnonymousBoolean = ao.ctZ().a(aj.b(aj.this), new String[0]);
          if (!paramAnonymousBoolean)
          {
            Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(paramAnonymousBoolean)));
            aj.a(aj.this, -10000 - com.tencent.mm.compatible.util.f.getLine());
            aj.d(aj.this).onSceneEnd(3, paramAnonymousInt, "", aj.this);
            AppMethodBeat.o(231427);
            return 0;
          }
          AppMethodBeat.o(231427);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1031;
          }
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs });
          m.Pn(aj.b(aj.this).systemRowid);
          ao.ctZ().get(aj.c(aj.this), aj.b(aj.this));
          aj.b(aj.this).field_signature = "";
          paramAnonymousBoolean = ao.ctZ().a(aj.b(aj.this), new String[0]);
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(aj.c(aj.this)), Boolean.valueOf(paramAnonymousBoolean) });
          paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(aj.a(aj.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs });
          new ae(paramAnonymousString).bpa();
          new ac(paramAnonymousString).bpa();
          aj.d(aj.this).onSceneEnd(3, paramAnonymousd.field_retCode, "", aj.this);
        }
        for (;;)
        {
          AppMethodBeat.o(231427);
          return 0;
          label1031:
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), Util.secPrint(aj.b(aj.this).field_signature) });
          if (paramAnonymousBoolean)
          {
            if (paramAnonymousd.field_exist_whencheck)
            {
              bh.aGY().a(new com.tencent.mm.pluginsdk.h.c(aj.i(aj.this), aj.b(aj.this).field_fileFullPath, aj.j(aj.this), new c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(288075);
                  paramAnonymous2String3 = Util.secPrint(paramAnonymous2String3);
                  String str1 = Util.secPrint(paramAnonymous2String4);
                  String str2 = Util.secPrint(paramAnonymous2String5);
                  String str3 = Util.secPrint(paramAnonymous2String6);
                  if (aj.i(aj.this) == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new errMsg:[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2String3, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(aj.f(aj.this)) });
                    if (!Util.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    bh.beI();
                    paramAnonymous2String2 = com.tencent.mm.model.c.bbO().Oq(aj.b(aj.this).field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    bh.beI();
                    com.tencent.mm.model.c.bbO().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String2 = new ca();
                    paramAnonymous2String2.setCreateTime(bq.RP(aj.j(aj.this)));
                    paramAnonymous2String2.Jm(aj.j(aj.this));
                    paramAnonymous2String2.setContent(paramAnonymous2String1);
                    paramAnonymous2String2.setType(10000);
                    paramAnonymous2String2.setStatus(6);
                    paramAnonymous2String2.pJ(0);
                    bh.beI();
                    com.tencent.mm.model.c.bbO().aM(paramAnonymous2String2);
                    AppMethodBeat.o(288075);
                    return;
                  }
                  aj.b(aj.this).field_signature = paramAnonymous2String4;
                  aj.b(aj.this).field_fakeAeskey = paramAnonymous2String5;
                  aj.b(aj.this).field_fakeSignature = paramAnonymous2String6;
                  aj.3.this.a(paramAnonymousInt, paramAnonymousd);
                  AppMethodBeat.o(288075);
                }
              }), 0);
            }
            else
            {
              Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
              bh.aGY().a(new com.tencent.mm.pluginsdk.h.c(null, aj.b(aj.this).field_fileFullPath, aj.j(aj.this), new c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(291215);
                  String str1 = Util.secPrint(paramAnonymous2String3);
                  String str2 = Util.secPrint(paramAnonymous2String4);
                  String str3 = Util.secPrint(paramAnonymous2String5);
                  String str4 = Util.secPrint(paramAnonymous2String6);
                  if (aj.i(aj.this) == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new errMsg[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(aj.f(aj.this)) });
                    if (!Util.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    bh.beI();
                    paramAnonymous2String2 = com.tencent.mm.model.c.bbO().Oq(aj.b(aj.this).field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    bh.beI();
                    com.tencent.mm.model.c.bbO().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String2 = new ca();
                    paramAnonymous2String2.setCreateTime(bq.RP(aj.j(aj.this)));
                    paramAnonymous2String2.Jm(aj.j(aj.this));
                    paramAnonymous2String2.setContent(paramAnonymous2String1);
                    paramAnonymous2String2.setType(10000);
                    paramAnonymous2String2.setStatus(6);
                    paramAnonymous2String2.pJ(0);
                    bh.beI();
                    com.tencent.mm.model.c.bbO().aM(paramAnonymous2String2);
                    AppMethodBeat.o(291215);
                    return;
                  }
                  aj.b(aj.this).field_signature = paramAnonymous2String4;
                  aj.b(aj.this).field_fakeAeskey = paramAnonymous2String5;
                  aj.b(aj.this).field_fakeSignature = paramAnonymous2String6;
                  aj.b(aj.this).field_lastModifyTime = Util.nowMilliSecond();
                  if (aj.i(aj.this) != null)
                  {
                    aj.i(aj.this).filemd5 = paramAnonymous2String2;
                    aj.i(aj.this).aesKey = paramAnonymous2String3;
                    aj.i(aj.this).llX = ((int)paramAnonymous2Long);
                    bh.beI();
                    paramAnonymous2String1 = com.tencent.mm.model.c.bbO().Oq(aj.b(aj.this).field_msgInfoId);
                    paramAnonymous2String1.setContent(k.b.a(aj.i(aj.this), null, null));
                    bh.beI();
                    com.tencent.mm.model.c.bbO().a(paramAnonymous2String1.field_msgId, paramAnonymous2String1);
                  }
                  aj.e(aj.this);
                  bool = ao.ctZ().a(aj.b(aj.this), new String[0]);
                  if (!bool)
                  {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
                    aj.a(aj.this, -10000 - com.tencent.mm.compatible.util.f.getLine());
                    aj.d(aj.this).onSceneEnd(3, paramAnonymousInt, "", aj.this);
                    AppMethodBeat.o(291215);
                    return;
                  }
                  bh.aHJ().postToWorker(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(289811);
                      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                      aj.this.doScene(aj.k(aj.this), aj.d(aj.this));
                      AppMethodBeat.o(289811);
                    }
                  });
                  AppMethodBeat.o(291215);
                }
              }), 0);
            }
          }
          else {
            a(paramAnonymousInt, paramAnonymousd);
          }
        }
      }
      
      final void a(int paramAnonymousInt, final com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(231429);
        aj.b(aj.this).field_status = 199L;
        boolean bool = ao.ctZ().a(aj.b(aj.this), new String[0]);
        if (!bool)
        {
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          aj.a(aj.this, -10000 - com.tencent.mm.compatible.util.f.getLine());
          aj.d(aj.this).onSceneEnd(3, paramAnonymousInt, "", aj.this);
          AppMethodBeat.o(231429);
          return;
        }
        m.a(aj.b(aj.this).field_msgInfoId, aj.b(aj.this).field_mediaSvrId, paramAnonymousd);
        bh.aGY().a(new ah(aj.b(aj.this).field_msgInfoId, true, paramAnonymousd, new ah.a()
        {
          public final void dN(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(280272);
            Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              bh.aHJ().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(290981);
                  aj.e(aj.this);
                  aj.b(aj.this).field_createTime = cm.bfC();
                  aj.b(aj.this).field_lastModifyTime = Util.nowSecond();
                  aj.b(aj.this).field_offset = 0L;
                  aj.b(aj.this).field_status = 101L;
                  boolean bool = ao.ctZ().a(aj.b(aj.this), new String[0]);
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(aj.f(aj.this)), Boolean.valueOf(bool), Long.valueOf(aj.b(aj.this).field_createTime) });
                  aj.this.doScene(aj.l(aj.this), aj.d(aj.this));
                  AppMethodBeat.o(290981);
                }
              });
              AppMethodBeat.o(280272);
              return;
            }
            new ae(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(aj.a(aj.this)), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs })).bpa();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              aj.b(aj.this, paramAnonymousd);
            }
            aj.d(aj.this).onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", aj.this);
            AppMethodBeat.o(280272);
          }
        }, aj.m(aj.this), aj.b(aj.this)), 0);
        AppMethodBeat.o(231429);
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.jXX = false;
    this.jXZ = 0;
    this.jYc = new IListener()
    {
      private boolean a(rz paramAnonymousrz)
      {
        AppMethodBeat.i(230460);
        if (!paramAnonymousrz.fRl.filePath.equals(aj.b(aj.this).field_fileFullPath))
        {
          AppMethodBeat.o(230460);
          return false;
        }
        Object localObject1 = "";
        Object localObject2 = p.RxG;
        localObject2 = p.d(paramAnonymousrz);
        Object localObject3 = p.RxG;
        int i = p.e(paramAnonymousrz);
        try
        {
          paramAnonymousrz = URLEncoder.encode((String)localObject2, "UTF-8");
          if (aj.n(aj.this) == 1)
          {
            bh.beI();
            localObject3 = com.tencent.mm.model.c.bbO().Oq(aj.b(aj.this).field_msgInfoId);
            localObject2 = new com.tencent.mm.modelsns.n();
            ((com.tencent.mm.modelsns.n)localObject2).m("20toUser", aj.j(aj.this) + ",");
            ((com.tencent.mm.modelsns.n)localObject2).m("21source", "4,");
            ((com.tencent.mm.modelsns.n)localObject2).m("22qrUrl", paramAnonymousrz + ",");
            localObject1 = new StringBuilder();
            if (aj.o(aj.this) == null)
            {
              paramAnonymousrz = "";
              ((com.tencent.mm.modelsns.n)localObject2).m("23md5", paramAnonymousrz + ",");
              localObject1 = new StringBuilder();
              if (aj.o(aj.this) != null) {
                break label498;
              }
              paramAnonymousrz = "";
              ((com.tencent.mm.modelsns.n)localObject2).m("24cdnFileId", paramAnonymousrz + ",");
              localObject1 = new StringBuilder();
              if (aj.o(aj.this) != null) {
                break label512;
              }
              paramAnonymousrz = "";
              ((com.tencent.mm.modelsns.n)localObject2).m("25cdnAesKey", paramAnonymousrz + ",");
              localObject1 = "";
              paramAnonymousrz = (rz)localObject1;
              if (((ca)localObject3).erk())
              {
                localObject3 = k.b.OQ(((et)localObject3).field_content);
                paramAnonymousrz = (rz)localObject1;
                if (localObject3 != null) {
                  paramAnonymousrz = ((k.b)localObject3).appId;
                }
              }
              ((com.tencent.mm.modelsns.n)localObject2).m("26appip", paramAnonymousrz + ",");
              ((com.tencent.mm.modelsns.n)localObject2).m("27toUsersCount", v.Pu(aj.j(aj.this)) + ",");
              ((com.tencent.mm.modelsns.n)localObject2).m("28codeType", Integer.valueOf(i));
              Log.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + ((com.tencent.mm.modelsns.n)localObject2).agI());
              com.tencent.mm.modelstat.n.Q(13628, ((com.tencent.mm.modelsns.n)localObject2).toString());
            }
          }
          else
          {
            EventCenter.instance.removeListener(aj.p(aj.this));
            AppMethodBeat.o(230460);
            return false;
          }
        }
        catch (UnsupportedEncodingException paramAnonymousrz)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", paramAnonymousrz, "", new Object[0]);
            paramAnonymousrz = (rz)localObject1;
            continue;
            paramAnonymousrz = aj.o(aj.this).field_filemd5;
            continue;
            label498:
            paramAnonymousrz = aj.o(aj.this).field_fileId;
            continue;
            label512:
            paramAnonymousrz = aj.o(aj.this).field_aesKey;
          }
        }
      }
    };
    this.HCC = paramLong;
    this.llZ = paramString1;
    this.sessionId = paramString2;
    paramString2 = new com.tencent.mm.an.d.a();
    paramString2.lBU = new exg();
    paramString2.lBV = new exh();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.funcId = 220;
    paramString2.lBW = 105;
    paramString2.respCmdId = 1000000105;
    this.rr = paramString2.bgN();
    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, Util.getStack() });
    AppMethodBeat.o(31073);
  }
  
  private void e(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(31076);
    if (this.HCz.field_type != 2L)
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.jXZ = 1;
    if ((this.jXX) || (this.jXZ == 0))
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.jYa = paramd;
    this.jXX = true;
    paramd = new rx();
    EventCenter.instance.addListener(this.jYc);
    paramd.fRg.filePath = this.HCz.field_fileFullPath;
    paramd.fRg.fwK = System.currentTimeMillis();
    EventCenter.instance.publish(paramd);
    AppMethodBeat.o(31076);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(31074);
    this.callback = parami;
    this.QXg = false;
    this.HCz = new c();
    if ((!ao.ctZ().get(this.HCC, this.HCz)) || (this.HCz == null))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.avD() + " summerbig get info failed rowid:" + this.HCC);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.HCz = null;
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.HCz.field_status != 101L)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.avD() + " summerbig get field_status failed rowid:" + this.HCC + " status:" + this.HCz.field_status);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.QXf = this.HCz.field_offset;
    }
    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.HCC), this.HCz.field_fileFullPath, Long.valueOf(this.HCz.field_totalLen), Boolean.valueOf(this.HCz.field_isUpload), Integer.valueOf(this.HCz.field_isUseCdn), Long.valueOf(this.HCz.field_type) });
    if (Util.isNullOrNil(this.HCz.field_appId))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.HCz.field_type != 8L) && (this.HCz.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
    }
    if ((this.HCz.field_type == 8L) || (this.HCz.field_type == 9L))
    {
      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.HCz.field_type) });
      i = 0;
    }
    Object localObject3;
    Object localObject4;
    Object localObject2;
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.HCC) });
      AppMethodBeat.o(31074);
      return 0;
      if (!com.tencent.mm.pluginsdk.g.b.hfX())
      {
        Log.i("MicroMsg.NetSceneUploadAppAttach", "isAllow2UseCdnWithXLab = false");
        i = 0;
      }
      else
      {
        com.tencent.mm.aq.f.bkg();
        if ((!com.tencent.mm.aq.b.vQ(4)) && (this.HCz.field_isUseCdn != 1))
        {
          com.tencent.mm.aq.f.bkg();
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.aq.b.vQ(4)), Integer.valueOf(this.HCz.field_isUseCdn) });
          i = 0;
        }
        else
        {
          bh.beI();
          localObject3 = com.tencent.mm.model.c.bbO().Oq(this.HCz.field_msgInfoId);
          if (((et)localObject3).field_msgId != this.HCz.field_msgInfoId)
          {
            Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.HCz.field_msgInfoId), Long.valueOf(this.HCz.systemRowid), Long.valueOf(this.HCz.field_createTime), Long.valueOf(this.HCz.field_totalLen), Long.valueOf(this.HCz.field_status), Boolean.valueOf(this.HCz.field_isUpload), Integer.valueOf(this.HCz.field_isUseCdn), this.HCz.field_mediaId });
            this.toUser = null;
            i = 0;
          }
          else
          {
            this.toUser = ((et)localObject3).field_talker;
            parami = "";
            if (!Util.isNullOrNil(((et)localObject3).field_imgPath)) {
              parami = com.tencent.mm.ay.q.bmh().VW(((et)localObject3).field_imgPath);
            }
            int k = (int)u.bBQ(parami);
            int m = (int)u.bBQ(this.HCz.field_fileFullPath);
            if (k >= 262144)
            {
              Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { parami, Integer.valueOf(k) });
              i = 0;
            }
            else
            {
              this.lPn = com.tencent.mm.aq.c.a("upattach", this.HCz.field_createTime, ((et)localObject3).field_talker, this.HCC);
              Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.HCz.field_createTime), this.lPn });
              if (Util.isNullOrNil(this.lPn))
              {
                Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.HCC) });
                i = 0;
              }
              else
              {
                localObject4 = new com.tencent.mm.i.g();
                ((com.tencent.mm.i.g)localObject4).taskName = "task_NetSceneUploadAppAttach";
                i = 0;
                localObject2 = ((et)localObject3).field_content;
                localObject1 = localObject2;
                int j;
                if (ab.Lj(((et)localObject3).field_talker))
                {
                  j = bq.RI(((et)localObject3).field_content);
                  localObject1 = localObject2;
                  if (j != -1) {
                    localObject1 = (((et)localObject3).field_content + " ").substring(j + 2).trim();
                  }
                }
                this.fvu = k.b.OQ(Util.processXml((String)localObject1));
                if (this.fvu != null)
                {
                  Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.fvu.lml, Util.secPrint(this.fvu.aesKey), this.fvu.filemd5, Integer.valueOf(this.fvu.type) });
                  ((com.tencent.mm.i.g)localObject4).field_fileId = this.fvu.lml;
                  ((com.tencent.mm.i.g)localObject4).field_aesKey = this.fvu.aesKey;
                  ((com.tencent.mm.i.g)localObject4).field_filemd5 = this.fvu.filemd5;
                  if ((this.fvu.lmb != 0) || (this.fvu.llX > 26214400))
                  {
                    i = 1;
                    label1133:
                    if (i == 0) {
                      break label1602;
                    }
                    j = com.tencent.mm.i.a.iTW;
                    label1142:
                    ((com.tencent.mm.i.g)localObject4).field_appType = 0;
                    ((com.tencent.mm.i.g)localObject4).iUG = this.lPx;
                    ((com.tencent.mm.i.g)localObject4).field_mediaId = this.lPn;
                    ((com.tencent.mm.i.g)localObject4).field_fullpath = this.HCz.field_fileFullPath;
                    ((com.tencent.mm.i.g)localObject4).field_thumbpath = parami;
                    ((com.tencent.mm.i.g)localObject4).field_fileType = j;
                    if (i == 0) {
                      break label1610;
                    }
                    localObject1 = Util.nullAsNil(this.HCz.field_signature);
                    label1207:
                    ((com.tencent.mm.i.g)localObject4).field_svr_signature = ((String)localObject1);
                    if (i == 0) {
                      break label1617;
                    }
                    bool = Util.isNullOrNil(this.HCz.field_signature);
                    label1230:
                    ((com.tencent.mm.i.g)localObject4).field_onlycheckexist = bool;
                    ((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature_aeskey = this.HCz.field_fakeAeskey;
                    ((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature = this.HCz.field_fakeSignature;
                    ((com.tencent.mm.i.g)localObject4).field_talker = ((et)localObject3).field_talker;
                    ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.iTU;
                    ((com.tencent.mm.i.g)localObject4).field_totalLen = m;
                    ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
                    ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
                    ((com.tencent.mm.i.g)localObject4).field_enable_hitcheck = this.lPF;
                    if (!ab.Lj(((et)localObject3).field_talker)) {
                      break label1623;
                    }
                    j = 1;
                    label1321:
                    ((com.tencent.mm.i.g)localObject4).field_chattype = j;
                    ((com.tencent.mm.i.g)localObject4).field_force_aeskeycdn = false;
                    ((com.tencent.mm.i.g)localObject4).field_trysafecdn = true;
                    ((com.tencent.mm.i.g)localObject4).field_bzScene = 0;
                    if ((!com.tencent.mm.aq.c.bka()) || (i == 0)) {
                      break label1629;
                    }
                  }
                }
                label1602:
                label1610:
                label1617:
                label1623:
                label1629:
                for (boolean bool = true;; bool = false)
                {
                  ((com.tencent.mm.i.g)localObject4).field_use_multithread = bool;
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn field_use_multithread[%s], msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_use_multithread), Long.valueOf(this.HCz.field_msgInfoId), ((com.tencent.mm.i.g)localObject4).field_fullpath, Integer.valueOf(m), parami, Integer.valueOf(k), this.lPn, Integer.valueOf(((com.tencent.mm.i.g)localObject4).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_trysafecdn), Util.secPrint(((com.tencent.mm.i.g)localObject4).field_aesKey), ((com.tencent.mm.i.g)localObject4).field_filemd5, Util.secPrint(((com.tencent.mm.i.g)localObject4).field_svr_signature), Util.secPrint(((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature_aeskey), Util.secPrint(((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature) });
                  if (com.tencent.mm.aq.f.bkg().f((com.tencent.mm.i.g)localObject4)) {
                    break label1635;
                  }
                  Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                  this.lPn = "";
                  i = 0;
                  break;
                  i = 0;
                  break label1133;
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                  break label1133;
                  j = com.tencent.mm.i.a.MediaType_FILE;
                  break label1142;
                  localObject1 = "";
                  break label1207;
                  bool = false;
                  break label1230;
                  j = 0;
                  break label1321;
                }
                label1635:
                if (this.HCz.field_isUseCdn != 1)
                {
                  this.HCz.field_isUseCdn = 1;
                  bool = ao.ctZ().a(this.HCz, new String[0]);
                  if (!bool)
                  {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
                    this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    this.callback.onSceneEnd(3, -1, "", this);
                    i = 0;
                    continue;
                  }
                }
                Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.lPn });
                i = 1;
              }
            }
          }
        }
      }
    }
    if ((this.HCz.field_type == 8L) || (this.HCz.field_type == 9L))
    {
      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig parallel-upload support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.HCz.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene use parallel-upload return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.HCC) });
      AppMethodBeat.o(31074);
      return 0;
      if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vWX, 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1880;
        }
        Log.i("MicroMsg.NetSceneUploadAppAttach", "NOT ALLOW USE PARALLEL UPLOAD APP ATTACH");
        i = 0;
        break;
      }
      label1880:
      bh.beI();
      localObject1 = com.tencent.mm.model.c.bbO().Oq(this.HCz.field_msgInfoId);
      if (((et)localObject1).field_msgId != this.HCz.field_msgInfoId)
      {
        Log.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.HCz.field_msgInfoId), Long.valueOf(this.HCz.systemRowid), Long.valueOf(this.HCz.field_createTime), Long.valueOf(this.HCz.field_totalLen), Long.valueOf(this.HCz.field_status), Boolean.valueOf(this.HCz.field_isUpload), Integer.valueOf(this.HCz.field_isUseCdn), this.HCz.field_mediaId });
        this.toUser = null;
        i = 0;
      }
      else
      {
        parami = "";
        if (!Util.isNullOrNil(((et)localObject1).field_imgPath)) {
          parami = com.tencent.mm.ay.q.bmh().VW(((et)localObject1).field_imgPath);
        }
        localObject2 = new com.tencent.mm.pluginsdk.g.d();
        ((com.tencent.mm.pluginsdk.g.d)localObject2).lNP = hhD();
        ((com.tencent.mm.pluginsdk.g.d)localObject2).QSZ = this.lPR;
        ((com.tencent.mm.pluginsdk.g.d)localObject2).scene = 3;
        ((com.tencent.mm.pluginsdk.g.d)localObject2).fileType = 5;
        ((com.tencent.mm.pluginsdk.g.d)localObject2).thumbPath = parami;
        ((com.tencent.mm.pluginsdk.g.d)localObject2).fullPath = this.HCz.field_fileFullPath;
        localObject3 = new com.tencent.mm.pluginsdk.g.c();
        bh.beI();
        localObject4 = com.tencent.mm.model.c.bbO().Oq(this.HCz.field_msgInfoId);
        if (((et)localObject4).field_msgId != this.HCz.field_msgInfoId)
        {
          Log.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.HCz.field_msgInfoId), Long.valueOf(this.HCz.systemRowid), Long.valueOf(this.HCz.field_createTime), Long.valueOf(this.HCz.field_totalLen), Long.valueOf(this.HCz.field_status), Boolean.valueOf(this.HCz.field_isUpload), Integer.valueOf(this.HCz.field_isUseCdn), this.HCz.field_mediaId });
          this.toUser = null;
          parami = "";
          label2296:
          if (this.HCz == null) {
            break label2536;
          }
        }
        label2536:
        for (localObject1 = this.HCz.field_signature;; localObject1 = null)
        {
          ((com.tencent.mm.pluginsdk.g.c)localObject3).QSJ = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.g.c)localObject3).QSK = parami;
          ((com.tencent.mm.pluginsdk.g.c)localObject3).a((com.tencent.mm.pluginsdk.g.d)localObject2);
          this.QXg = true;
          i = 1;
          break;
          localObject1 = ((et)localObject4).field_content;
          parami = (com.tencent.mm.an.i)localObject1;
          if (ab.Lj(((et)localObject4).field_talker))
          {
            i = bq.RI(((et)localObject4).field_content);
            parami = (com.tencent.mm.an.i)localObject1;
            if (i != -1) {
              parami = (((et)localObject4).field_content + " ").substring(i + 2).trim();
            }
          }
          this.fvu = k.b.OQ(parami);
          if (((this.fvu != null) && (this.fvu.lmb != 0)) || (this.fvu.llX > 26214400))
          {
            Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.fvu.lml, Util.secPrint(this.fvu.aesKey), this.fvu.filemd5, Integer.valueOf(this.fvu.type) });
            parami = this.fvu.aesKey;
            break label2296;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
          parami = "";
          break label2296;
        }
      }
    }
    if (this.HCz.field_netTimes > 3200L)
    {
      m.Pn(this.HCz.systemRowid);
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.avD() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.HCC);
      AppMethodBeat.o(31074);
      return -1;
    }
    parami = this.HCz;
    parami.field_netTimes += 1L;
    if (Util.isNullOrNil(this.HCz.field_clientAppDataId))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((this.HCz.field_totalLen <= 0L) || (this.HCz.field_totalLen > 26214400L))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.HCz.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (this.HCz.field_totalLen > 26214400L) {
        m.Pn(this.HCz.systemRowid);
      }
      AppMethodBeat.o(31074);
      return -1;
    }
    if (Util.isNullOrNil(this.HCz.field_fileFullPath))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((int)u.bBQ(this.HCz.field_fileFullPath) > 26214400)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      m.Pn(this.HCz.systemRowid);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (Util.isNullOrNil(this.llZ)) {}
    for (parami = u.aY(this.HCz.field_fileFullPath, (int)this.HCz.field_offset, 8192); Util.isNullOrNil(parami); parami = u.aY(this.HCz.field_fileFullPath, (int)this.HCz.field_offset, 32768))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    Object localObject1 = (exg)d.b.b(this.rr.lBR);
    ((exg)localObject1).lVG = this.HCz.field_appId;
    ((exg)localObject1).RJP = ((int)this.HCz.field_sdkVer);
    ((exg)localObject1).UxD = this.HCz.field_clientAppDataId;
    ((exg)localObject1).rWu = ((int)this.HCz.field_type);
    ((exg)localObject1).UserName = z.bcZ();
    ((exg)localObject1).HmZ = ((int)this.HCz.field_totalLen);
    ((exg)localObject1).Hna = ((int)this.HCz.field_offset);
    if ((this.llZ != null) && (this.Hdz))
    {
      ((exg)localObject1).MD5 = this.llZ;
      ((exg)localObject1).HmZ = ((int)this.HCz.field_totalLen);
      ((exg)localObject1).Hnb = 0;
      ((exg)localObject1).Hnc = new eae().dc(new byte[0]);
      this.Hdz = false;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(31074);
      return i;
    }
    ((exg)localObject1).Hnb = parami.length;
    ((exg)localObject1).Hnc = new eae().dc(parami);
    if (this.llZ != null) {
      ((exg)localObject1).MD5 = this.llZ;
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(31074);
    return i;
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final long hhD()
  {
    if (this.HCz == null) {
      return 0L;
    }
    return this.HCz.field_msgInfoId;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31075);
    Log.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.lPn });
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.HCz.field_totalLen - this.QXf) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31075);
      return;
    }
    paramString = (exh)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((paramString.lVG != null) && (this.llZ == null) && ((!paramString.lVG.equals(this.HCz.field_appId)) || (!paramString.UxD.equals(this.HCz.field_clientAppDataId))))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramString.HmZ < 0) || (paramString.HmZ != this.HCz.field_totalLen) || (paramString.Hna < 0) || (paramString.Hna > this.HCz.field_totalLen))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    this.HCz.field_offset = paramString.Hna;
    params = this.HCz;
    if (m.bqd(paramString.lVJ)) {}
    for (paramString = paramString.lVJ;; paramString = "")
    {
      params.field_mediaSvrId = paramString;
      if (this.HCz.field_status != 105L) {
        break;
      }
      Log.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.HCz.field_mediaSvrId + "," + this.HCz.field_offset + "] ");
      this.callback.onSceneEnd(paramInt2, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.HCz.field_offset == this.HCz.field_totalLen)
    {
      if (Util.isNullOrNil(this.HCz.field_mediaSvrId))
      {
        Log.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        this.callback.onSceneEnd(3, -1, "", this);
        m.Pn(this.HCz.systemRowid);
        AppMethodBeat.o(31075);
        return;
      }
      this.HCz.field_status = 199L;
      com.tencent.mm.plugin.report.service.h.IzE.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.aq.c.cV(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.HCz.field_totalLen - this.QXf) });
    }
    boolean bool = ao.ctZ().a(this.HCz, new String[0]);
    if (!bool)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      e(null);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.HCz.field_status == 199L)
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
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */