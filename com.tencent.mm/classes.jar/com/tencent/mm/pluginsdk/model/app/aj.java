package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.g.a.qf.a;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.f.d.a;
import com.tencent.mm.pluginsdk.g.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.protobuf.dtb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class aj
  extends n
  implements k
{
  private long FfV;
  boolean FfW;
  com.tencent.mm.ak.f callback;
  k.b dlx;
  private boolean gzA;
  int gzC;
  com.tencent.mm.i.d gzD;
  com.tencent.mm.sdk.b.c gzF;
  private String hCE;
  String idX;
  private d.a ieB;
  private com.tencent.mm.i.g.a ieg;
  boolean ieo;
  int retCode;
  private com.tencent.mm.ak.b rr;
  String sessionId;
  long startTime;
  String toUser;
  c xGv;
  long xGx;
  private boolean xkY;
  
  public aj(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31073);
    this.xGv = null;
    this.dlx = null;
    this.xGx = -1L;
    this.hCE = null;
    this.xkY = true;
    this.ieo = true;
    this.retCode = 0;
    this.startTime = 0L;
    this.FfV = -1L;
    this.idX = "";
    this.FfW = false;
    this.ieB = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(186693);
        ae.e("MicroMsg.NetSceneUploadAppAttach", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        m.zc(aj.this.xGv.systemRowid);
        ao.bJV().get(aj.this.xGx, aj.this.xGv);
        aj.this.xGv.field_signature = "";
        boolean bool = ao.bJV().a(aj.this.xGv, new String[0]);
        ae.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(-1), Long.valueOf(aj.this.xGx), Boolean.valueOf(bool) });
        aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
        AppMethodBeat.o(186693);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(186694);
        aj.this.xGv.field_lastModifyTime = bu.aRi();
        if (aj.this.xGv.field_offset < paramAnonymousLong) {
          aj.this.xGv.field_offset = paramAnonymousLong;
        }
        boolean bool = ao.bJV().a(aj.this.xGv, new String[0]);
        if (!bool)
        {
          ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          aj.this.callback.onSceneEnd(3, -1, "", aj.this);
        }
        AppMethodBeat.o(186694);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(186692);
        ae.i("MicroMsg.NetSceneUploadAppAttach", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gmb, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iTe) });
        long l1 = bu.fpO();
        long l2 = aj.this.startTime;
        long l3 = paramAnonymousa.iTe;
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(l1), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(l3), Long.valueOf(l3 / (l1 - l2)), Integer.valueOf(1) });
        com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gmb;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nZM;
        locald.field_fileLength = paramAnonymousa.iTe;
        com.tencent.mm.an.f.aHa();
        locald.field_filecrc = com.tencent.mm.an.a.Fm(aj.this.xGv.field_fileFullPath);
        paramAnonymousa = aj.this;
        paramAnonymousa.xGv.field_status = 199L;
        boolean bool = ao.bJV().a(paramAnonymousa.xGv, new String[0]);
        if (!bool)
        {
          ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          paramAnonymousa.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          paramAnonymousa.callback.onSceneEnd(3, 0, "", paramAnonymousa);
          AppMethodBeat.o(186692);
          return;
        }
        m.a(paramAnonymousa.xGv.field_msgInfoId, paramAnonymousa.xGv.field_mediaSvrId, locald, true);
        bc.ajj().a(new ah(paramAnonymousa.xGv.field_msgInfoId, true, locald, new aj.2(paramAnonymousa), paramAnonymousa.sessionId, paramAnonymousa.xGv), 0);
        AppMethodBeat.o(186692);
      }
    };
    this.ieg = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(186702);
        paramAnonymousString = aj.this.idX;
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
          ae.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          ao.bJV().get(aj.this.xGx, aj.this.xGv);
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { aj.this.idX });
          AppMethodBeat.o(186702);
          return 0;
          bool1 = false;
          break;
        }
        label153:
        if (paramAnonymousInt != 0)
        {
          m.zc(aj.this.xGv.systemRowid);
          ao.bJV().get(aj.this.xGx, aj.this.xGv);
          aj.this.xGv.field_signature = "";
          paramAnonymousBoolean = ao.bJV().a(aj.this.xGv, new String[0]);
          ae.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(aj.this.xGx), Boolean.valueOf(paramAnonymousBoolean) });
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
          new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLH();
          AppMethodBeat.o(186702);
          return 0;
        }
        if (aj.this.xGv.field_status == 105L)
        {
          ae.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(aj.this.xGv.field_status), Long.valueOf(aj.this.xGx) });
          com.tencent.mm.an.f.aGZ().Fr(aj.this.idX);
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "attach  has paused, status" + aj.this.xGv.field_status, aj.this);
          AppMethodBeat.o(186702);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          aj.this.xGv.field_lastModifyTime = bu.aRi();
          aj.this.xGv.field_offset = paramAnonymousc.field_finishedLength;
          paramAnonymousBoolean = ao.bJV().a(aj.this.xGv, new String[0]);
          if (!paramAnonymousBoolean)
          {
            ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(paramAnonymousBoolean)));
            aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
            aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
            AppMethodBeat.o(186702);
            return 0;
          }
          AppMethodBeat.o(186702);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1030;
          }
          ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX });
          m.zc(aj.this.xGv.systemRowid);
          ao.bJV().get(aj.this.xGx, aj.this.xGv);
          aj.this.xGv.field_signature = "";
          paramAnonymousBoolean = ao.bJV().a(aj.this.xGv, new String[0]);
          ae.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(aj.this.xGx), Boolean.valueOf(paramAnonymousBoolean) });
          paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX });
          new j(paramAnonymousString).aLH();
          new h(paramAnonymousString).aLH();
          aj.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", aj.this);
        }
        for (;;)
        {
          AppMethodBeat.o(186702);
          return 0;
          label1030:
          ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bu.aSM(aj.this.xGv.field_signature) });
          if (paramAnonymousBoolean)
          {
            if (paramAnonymousd.field_exist_whencheck)
            {
              bc.ajj().a(new com.tencent.mm.pluginsdk.g.c(aj.this.dlx, aj.this.xGv.field_fileFullPath, aj.this.toUser, new c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(186697);
                  paramAnonymous2String3 = bu.aSM(paramAnonymous2String3);
                  String str1 = bu.aSM(paramAnonymous2String4);
                  String str2 = bu.aSM(paramAnonymous2String5);
                  String str3 = bu.aSM(paramAnonymous2String6);
                  if (aj.this.dlx == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new errMsg:[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2String3, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(aj.this.ieo) });
                    if (!bu.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    bc.aCg();
                    paramAnonymous2String2 = com.tencent.mm.model.c.azI().ys(aj.this.xGv.field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    bc.aCg();
                    com.tencent.mm.model.c.azI().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String2 = new bv();
                    paramAnonymous2String2.qN(bl.BQ(aj.this.toUser));
                    paramAnonymous2String2.ui(aj.this.toUser);
                    paramAnonymous2String2.setContent(paramAnonymous2String1);
                    paramAnonymous2String2.setType(10000);
                    paramAnonymous2String2.setStatus(6);
                    paramAnonymous2String2.kt(0);
                    bc.aCg();
                    com.tencent.mm.model.c.azI().ar(paramAnonymous2String2);
                    AppMethodBeat.o(186697);
                    return;
                  }
                  aj.this.xGv.field_signature = paramAnonymous2String4;
                  aj.this.xGv.field_fakeAeskey = paramAnonymous2String5;
                  aj.this.xGv.field_fakeSignature = paramAnonymous2String6;
                  aj.3.this.a(paramAnonymousInt, paramAnonymousd);
                  AppMethodBeat.o(186697);
                }
              }), 0);
            }
            else
            {
              ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
              bc.ajj().a(new com.tencent.mm.pluginsdk.g.c(null, aj.this.xGv.field_fileFullPath, aj.this.toUser, new c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(186699);
                  String str1 = bu.aSM(paramAnonymous2String3);
                  String str2 = bu.aSM(paramAnonymous2String4);
                  String str3 = bu.aSM(paramAnonymous2String5);
                  String str4 = bu.aSM(paramAnonymous2String6);
                  if (aj.this.dlx == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new errMsg[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(aj.this.ieo) });
                    if (!bu.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    bc.aCg();
                    paramAnonymous2String2 = com.tencent.mm.model.c.azI().ys(aj.this.xGv.field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    bc.aCg();
                    com.tencent.mm.model.c.azI().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String2 = new bv();
                    paramAnonymous2String2.qN(bl.BQ(aj.this.toUser));
                    paramAnonymous2String2.ui(aj.this.toUser);
                    paramAnonymous2String2.setContent(paramAnonymous2String1);
                    paramAnonymous2String2.setType(10000);
                    paramAnonymous2String2.setStatus(6);
                    paramAnonymous2String2.kt(0);
                    bc.aCg();
                    com.tencent.mm.model.c.azI().ar(paramAnonymous2String2);
                    AppMethodBeat.o(186699);
                    return;
                  }
                  aj.this.xGv.field_signature = paramAnonymous2String4;
                  aj.this.xGv.field_fakeAeskey = paramAnonymous2String5;
                  aj.this.xGv.field_fakeSignature = paramAnonymous2String6;
                  aj.this.xGv.field_lastModifyTime = bu.fpO();
                  if (aj.this.dlx != null)
                  {
                    aj.this.dlx.filemd5 = paramAnonymous2String2;
                    aj.this.dlx.gmb = paramAnonymous2String3;
                    aj.this.dlx.hCC = ((int)paramAnonymous2Long);
                    bc.aCg();
                    paramAnonymous2String1 = com.tencent.mm.model.c.azI().ys(aj.this.xGv.field_msgInfoId);
                    paramAnonymous2String1.setContent(k.b.a(aj.this.dlx, null, null));
                    bc.aCg();
                    com.tencent.mm.model.c.azI().a(paramAnonymous2String1.field_msgId, paramAnonymous2String1);
                  }
                  aj.this.ieo = false;
                  bool = ao.bJV().a(aj.this.xGv, new String[0]);
                  if (!bool)
                  {
                    ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
                    aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
                    AppMethodBeat.o(186699);
                    return;
                  }
                  bc.ajU().aw(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(186698);
                      ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                      aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                      AppMethodBeat.o(186698);
                    }
                  });
                  AppMethodBeat.o(186699);
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
        AppMethodBeat.i(186703);
        aj.this.xGv.field_status = 199L;
        boolean bool = ao.bJV().a(aj.this.xGv, new String[0]);
        if (!bool)
        {
          ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
          AppMethodBeat.o(186703);
          return;
        }
        m.a(aj.this.xGv.field_msgInfoId, aj.this.xGv.field_mediaSvrId, paramAnonymousd, true);
        bc.ajj().a(new ah(aj.this.xGv.field_msgInfoId, true, paramAnonymousd, new ah.a()
        {
          public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(186701);
            ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              bc.ajU().aw(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(186700);
                  aj.this.ieo = false;
                  aj.this.xGv.field_createTime = bu.fpO();
                  aj.this.xGv.field_lastModifyTime = bu.aRi();
                  aj.this.xGv.field_offset = 0L;
                  aj.this.xGv.field_status = 101L;
                  boolean bool = ao.bJV().a(aj.this.xGv, new String[0]);
                  ae.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(aj.this.ieo), Boolean.valueOf(bool), Long.valueOf(aj.this.xGv.field_createTime) });
                  aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                  AppMethodBeat.o(186700);
                }
              });
              AppMethodBeat.o(186701);
              return;
            }
            new j(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX })).aLH();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              aj.this.e(paramAnonymousd);
            }
            aj.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", aj.this);
            AppMethodBeat.o(186701);
          }
        }, aj.this.sessionId, aj.this.xGv), 0);
        AppMethodBeat.o(186703);
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.gzA = false;
    this.gzC = 0;
    this.gzF = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(qf paramAnonymousqf)
      {
        AppMethodBeat.i(186705);
        if (!paramAnonymousqf.dFM.filePath.equals(aj.this.xGv.field_fileFullPath))
        {
          AppMethodBeat.o(186705);
          return false;
        }
        localObject1 = "";
        try
        {
          localObject2 = URLEncoder.encode(paramAnonymousqf.dFM.result, "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            com.tencent.mm.modelsns.g localg;
            ae.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            localObject1 = aj.this.gzD.field_filemd5;
            continue;
            localObject1 = aj.this.gzD.field_fileId;
            continue;
            localObject1 = aj.this.gzD.field_aesKey;
          }
        }
        if (aj.this.gzC == 1)
        {
          bc.aCg();
          localObject3 = com.tencent.mm.model.c.azI().ys(aj.this.xGv.field_msgInfoId);
          localg = new com.tencent.mm.modelsns.g();
          localg.m("20toUser", aj.this.toUser + ",");
          localg.m("21source", "4,");
          localg.m("22qrUrl", (String)localObject1 + ",");
          localObject2 = new StringBuilder();
          if (aj.this.gzD == null)
          {
            localObject1 = "";
            localg.m("23md5", (String)localObject1 + ",");
            localObject2 = new StringBuilder();
            if (aj.this.gzD != null) {
              break label488;
            }
            localObject1 = "";
            localg.m("24cdnFileId", (String)localObject1 + ",");
            localObject2 = new StringBuilder();
            if (aj.this.gzD != null) {
              break label502;
            }
            localObject1 = "";
            localg.m("25cdnAesKey", (String)localObject1 + ",");
            localObject2 = "";
            localObject1 = localObject2;
            if (((bv)localObject3).cVH())
            {
              localObject3 = k.b.zb(((ei)localObject3).field_content);
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((k.b)localObject3).appId;
              }
            }
            localg.m("26appip", (String)localObject1 + ",");
            localg.m("27toUsersCount", r.zC(aj.this.toUser) + ",");
            localg.m("28codeType", Integer.valueOf(paramAnonymousqf.dFM.dov));
            ae.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + localg.RD());
            com.tencent.mm.modelstat.o.L(13628, localg.toString());
          }
        }
        else
        {
          com.tencent.mm.sdk.b.a.IvT.d(aj.this.gzF);
          AppMethodBeat.o(186705);
          return false;
        }
      }
    };
    this.xGx = paramLong;
    this.hCE = paramString1;
    this.sessionId = paramString2;
    paramString2 = new com.tencent.mm.ak.b.a();
    paramString2.hQF = new dta();
    paramString2.hQG = new dtb();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.funcId = 220;
    paramString2.hQH = 105;
    paramString2.respCmdId = 1000000105;
    this.rr = paramString2.aDS();
    ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bu.fpN() });
    AppMethodBeat.o(31073);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(31074);
    this.callback = paramf;
    this.FfW = false;
    this.xGv = new c();
    if ((!ao.bJV().get(this.xGx, this.xGv)) || (this.xGv == null))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.abr() + " summerbig get info failed rowid:" + this.xGx);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.xGv = null;
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.xGv.field_status != 101L)
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.abr() + " summerbig get field_status failed rowid:" + this.xGx + " status:" + this.xGv.field_status);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bu.fpO();
      this.FfV = this.xGv.field_offset;
    }
    ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.xGx), this.xGv.field_fileFullPath, Long.valueOf(this.xGv.field_totalLen), Boolean.valueOf(this.xGv.field_isUpload), Integer.valueOf(this.xGv.field_isUseCdn), Long.valueOf(this.xGv.field_type) });
    if (bu.isNullOrNil(this.xGv.field_appId))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.xGv.field_type != 8L) && (this.xGv.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
    }
    if ((this.xGv.field_type == 8L) || (this.xGv.field_type == 9L))
    {
      ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.xGv.field_type) });
      i = 0;
    }
    Object localObject3;
    Object localObject4;
    Object localObject2;
    while (i != 0)
    {
      ae.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.xGx) });
      AppMethodBeat.o(31074);
      return 0;
      if (!com.tencent.mm.pluginsdk.f.b.fcW())
      {
        ae.i("MicroMsg.NetSceneUploadAppAttach", "isAllow2UseCdnWithXLab = false");
        i = 0;
      }
      else
      {
        com.tencent.mm.an.f.aGZ();
        if ((!com.tencent.mm.an.b.pd(4)) && (this.xGv.field_isUseCdn != 1))
        {
          com.tencent.mm.an.f.aGZ();
          ae.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.pd(4)), Integer.valueOf(this.xGv.field_isUseCdn) });
          i = 0;
        }
        else
        {
          bc.aCg();
          localObject3 = com.tencent.mm.model.c.azI().ys(this.xGv.field_msgInfoId);
          if (((ei)localObject3).field_msgId != this.xGv.field_msgInfoId)
          {
            ae.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.xGv.field_msgInfoId), Long.valueOf(this.xGv.systemRowid), Long.valueOf(this.xGv.field_createTime), Long.valueOf(this.xGv.field_totalLen), Long.valueOf(this.xGv.field_status), Boolean.valueOf(this.xGv.field_isUpload), Integer.valueOf(this.xGv.field_isUseCdn), this.xGv.field_mediaId });
            this.toUser = null;
            i = 0;
          }
          else
          {
            this.toUser = ((ei)localObject3).field_talker;
            paramf = "";
            if (!bu.isNullOrNil(((ei)localObject3).field_imgPath)) {
              paramf = com.tencent.mm.av.q.aIX().FO(((ei)localObject3).field_imgPath);
            }
            int k = (int)com.tencent.mm.vfs.o.aZR(paramf);
            int m = (int)com.tencent.mm.vfs.o.aZR(this.xGv.field_fileFullPath);
            if (k >= 262144)
            {
              ae.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { paramf, Integer.valueOf(k) });
              i = 0;
            }
            else
            {
              this.idX = com.tencent.mm.an.c.a("upattach", this.xGv.field_createTime, ((ei)localObject3).field_talker, this.xGx);
              ae.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.xGv.field_createTime), this.idX });
              if (bu.isNullOrNil(this.idX))
              {
                ae.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.xGx) });
                i = 0;
              }
              else
              {
                localObject4 = new com.tencent.mm.i.g();
                ((com.tencent.mm.i.g)localObject4).fLl = "task_NetSceneUploadAppAttach";
                i = 0;
                localObject2 = ((ei)localObject3).field_content;
                localObject1 = localObject2;
                int j;
                if (x.wb(((ei)localObject3).field_talker))
                {
                  j = bl.BJ(((ei)localObject3).field_content);
                  localObject1 = localObject2;
                  if (j != -1) {
                    localObject1 = (((ei)localObject3).field_content + " ").substring(j + 2).trim();
                  }
                }
                this.dlx = k.b.zb(bu.aSA((String)localObject1));
                if (this.dlx != null)
                {
                  ae.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.dlx.hCR, bu.aSM(this.dlx.gmb), this.dlx.filemd5, Integer.valueOf(this.dlx.type) });
                  ((com.tencent.mm.i.g)localObject4).field_fileId = this.dlx.hCR;
                  ((com.tencent.mm.i.g)localObject4).field_aesKey = this.dlx.gmb;
                  ((com.tencent.mm.i.g)localObject4).field_filemd5 = this.dlx.filemd5;
                  if ((this.dlx.hCG != 0) || (this.dlx.hCC > 26214400))
                  {
                    i = 1;
                    label1129:
                    if (i == 0) {
                      break label1598;
                    }
                    j = com.tencent.mm.i.a.fKC;
                    label1138:
                    ((com.tencent.mm.i.g)localObject4).field_appType = 0;
                    ((com.tencent.mm.i.g)localObject4).fLm = this.ieg;
                    ((com.tencent.mm.i.g)localObject4).field_mediaId = this.idX;
                    ((com.tencent.mm.i.g)localObject4).field_fullpath = this.xGv.field_fileFullPath;
                    ((com.tencent.mm.i.g)localObject4).field_thumbpath = paramf;
                    ((com.tencent.mm.i.g)localObject4).field_fileType = j;
                    if (i == 0) {
                      break label1606;
                    }
                    localObject1 = bu.nullAsNil(this.xGv.field_signature);
                    label1203:
                    ((com.tencent.mm.i.g)localObject4).field_svr_signature = ((String)localObject1);
                    if (i == 0) {
                      break label1613;
                    }
                    bool = bu.isNullOrNil(this.xGv.field_signature);
                    label1226:
                    ((com.tencent.mm.i.g)localObject4).field_onlycheckexist = bool;
                    ((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature_aeskey = this.xGv.field_fakeAeskey;
                    ((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature = this.xGv.field_fakeSignature;
                    ((com.tencent.mm.i.g)localObject4).field_talker = ((ei)localObject3).field_talker;
                    ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.fKA;
                    ((com.tencent.mm.i.g)localObject4).field_totalLen = m;
                    ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
                    ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
                    ((com.tencent.mm.i.g)localObject4).field_enable_hitcheck = this.ieo;
                    if (!x.wb(((ei)localObject3).field_talker)) {
                      break label1619;
                    }
                    j = 1;
                    label1317:
                    ((com.tencent.mm.i.g)localObject4).field_chattype = j;
                    ((com.tencent.mm.i.g)localObject4).field_force_aeskeycdn = false;
                    ((com.tencent.mm.i.g)localObject4).field_trysafecdn = true;
                    ((com.tencent.mm.i.g)localObject4).field_bzScene = 0;
                    if ((!com.tencent.mm.an.c.aGU()) || (i == 0)) {
                      break label1625;
                    }
                  }
                }
                label1598:
                label1606:
                label1613:
                label1619:
                label1625:
                for (boolean bool = true;; bool = false)
                {
                  ((com.tencent.mm.i.g)localObject4).field_use_multithread = bool;
                  ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn field_use_multithread[%s], msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_use_multithread), Long.valueOf(this.xGv.field_msgInfoId), ((com.tencent.mm.i.g)localObject4).field_fullpath, Integer.valueOf(m), paramf, Integer.valueOf(k), this.idX, Integer.valueOf(((com.tencent.mm.i.g)localObject4).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_trysafecdn), bu.aSM(((com.tencent.mm.i.g)localObject4).field_aesKey), ((com.tencent.mm.i.g)localObject4).field_filemd5, bu.aSM(((com.tencent.mm.i.g)localObject4).field_svr_signature), bu.aSM(((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature_aeskey), bu.aSM(((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature) });
                  if (com.tencent.mm.an.f.aGZ().f((com.tencent.mm.i.g)localObject4)) {
                    break label1631;
                  }
                  ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                  this.idX = "";
                  i = 0;
                  break;
                  i = 0;
                  break label1129;
                  ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                  break label1129;
                  j = com.tencent.mm.i.a.MediaType_FILE;
                  break label1138;
                  localObject1 = "";
                  break label1203;
                  bool = false;
                  break label1226;
                  j = 0;
                  break label1317;
                }
                label1631:
                if (this.xGv.field_isUseCdn != 1)
                {
                  this.xGv.field_isUseCdn = 1;
                  bool = ao.bJV().a(this.xGv, new String[0]);
                  if (!bool)
                  {
                    ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
                    this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    this.callback.onSceneEnd(3, -1, "", this);
                    i = 0;
                    continue;
                  }
                }
                ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.idX });
                i = 1;
              }
            }
          }
        }
      }
    }
    if ((this.xGv.field_type == 8L) || (this.xGv.field_type == 9L))
    {
      ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig parallel-upload support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.xGv.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      ae.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene use parallel-upload return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.xGx) });
      AppMethodBeat.o(31074);
      return 0;
      if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qPb, 1)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1876;
        }
        ae.i("MicroMsg.NetSceneUploadAppAttach", "NOT ALLOW USE PARALLEL UPLOAD APP ATTACH");
        i = 0;
        break;
      }
      label1876:
      bc.aCg();
      localObject1 = com.tencent.mm.model.c.azI().ys(this.xGv.field_msgInfoId);
      if (((ei)localObject1).field_msgId != this.xGv.field_msgInfoId)
      {
        ae.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.xGv.field_msgInfoId), Long.valueOf(this.xGv.systemRowid), Long.valueOf(this.xGv.field_createTime), Long.valueOf(this.xGv.field_totalLen), Long.valueOf(this.xGv.field_status), Boolean.valueOf(this.xGv.field_isUpload), Integer.valueOf(this.xGv.field_isUseCdn), this.xGv.field_mediaId });
        this.toUser = null;
        i = 0;
      }
      else
      {
        paramf = "";
        if (!bu.isNullOrNil(((ei)localObject1).field_imgPath)) {
          paramf = com.tencent.mm.av.q.aIX().FO(((ei)localObject1).field_imgPath);
        }
        localObject2 = new com.tencent.mm.pluginsdk.f.d();
        ((com.tencent.mm.pluginsdk.f.d)localObject2).icx = fdR();
        ((com.tencent.mm.pluginsdk.f.d)localObject2).Fdc = this.ieB;
        ((com.tencent.mm.pluginsdk.f.d)localObject2).scene = 3;
        ((com.tencent.mm.pluginsdk.f.d)localObject2).fileType = 5;
        ((com.tencent.mm.pluginsdk.f.d)localObject2).thumbPath = paramf;
        ((com.tencent.mm.pluginsdk.f.d)localObject2).hgD = this.xGv.field_fileFullPath;
        localObject3 = new com.tencent.mm.pluginsdk.f.c();
        bc.aCg();
        localObject4 = com.tencent.mm.model.c.azI().ys(this.xGv.field_msgInfoId);
        if (((ei)localObject4).field_msgId != this.xGv.field_msgInfoId)
        {
          ae.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.xGv.field_msgInfoId), Long.valueOf(this.xGv.systemRowid), Long.valueOf(this.xGv.field_createTime), Long.valueOf(this.xGv.field_totalLen), Long.valueOf(this.xGv.field_status), Boolean.valueOf(this.xGv.field_isUpload), Integer.valueOf(this.xGv.field_isUseCdn), this.xGv.field_mediaId });
          this.toUser = null;
          paramf = "";
          label2292:
          if (this.xGv == null) {
            break label2532;
          }
        }
        label2532:
        for (localObject1 = this.xGv.field_signature;; localObject1 = null)
        {
          ((com.tencent.mm.pluginsdk.f.c)localObject3).FcM = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.f.c)localObject3).FcN = paramf;
          ((com.tencent.mm.pluginsdk.f.c)localObject3).a((com.tencent.mm.pluginsdk.f.d)localObject2);
          this.FfW = true;
          i = 1;
          break;
          localObject1 = ((ei)localObject4).field_content;
          paramf = (com.tencent.mm.ak.f)localObject1;
          if (x.wb(((ei)localObject4).field_talker))
          {
            i = bl.BJ(((ei)localObject4).field_content);
            paramf = (com.tencent.mm.ak.f)localObject1;
            if (i != -1) {
              paramf = (((ei)localObject4).field_content + " ").substring(i + 2).trim();
            }
          }
          this.dlx = k.b.zb(paramf);
          if (((this.dlx != null) && (this.dlx.hCG != 0)) || (this.dlx.hCC > 26214400))
          {
            ae.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.dlx.hCR, bu.aSM(this.dlx.gmb), this.dlx.filemd5, Integer.valueOf(this.dlx.type) });
            paramf = this.dlx.gmb;
            break label2292;
          }
          ae.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
          paramf = "";
          break label2292;
        }
      }
    }
    if (this.xGv.field_netTimes > 3200L)
    {
      m.zc(this.xGv.systemRowid);
      ae.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.abr() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.xGx);
      AppMethodBeat.o(31074);
      return -1;
    }
    paramf = this.xGv;
    paramf.field_netTimes += 1L;
    if (bu.isNullOrNil(this.xGv.field_clientAppDataId))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((this.xGv.field_totalLen <= 0L) || (this.xGv.field_totalLen > 26214400L))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.xGv.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (this.xGv.field_totalLen > 26214400L) {
        m.zc(this.xGv.systemRowid);
      }
      AppMethodBeat.o(31074);
      return -1;
    }
    if (bu.isNullOrNil(this.xGv.field_fileFullPath))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((int)com.tencent.mm.vfs.o.aZR(this.xGv.field_fileFullPath) > 26214400)
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      m.zc(this.xGv.systemRowid);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (bu.isNullOrNil(this.hCE)) {}
    for (paramf = com.tencent.mm.vfs.o.bb(this.xGv.field_fileFullPath, (int)this.xGv.field_offset, 8192); bu.cF(paramf); paramf = com.tencent.mm.vfs.o.bb(this.xGv.field_fileFullPath, (int)this.xGv.field_offset, 32768))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    Object localObject1 = (dta)this.rr.hQD.hQJ;
    ((dta)localObject1).ikm = this.xGv.field_appId;
    ((dta)localObject1).FOQ = ((int)this.xGv.field_sdkVer);
    ((dta)localObject1).HYL = this.xGv.field_clientAppDataId;
    ((dta)localObject1).nJA = ((int)this.xGv.field_type);
    ((dta)localObject1).nIJ = v.aAC();
    ((dta)localObject1).xsB = ((int)this.xGv.field_totalLen);
    ((dta)localObject1).xsC = ((int)this.xGv.field_offset);
    if ((this.hCE != null) && (this.xkY))
    {
      ((dta)localObject1).MD5 = this.hCE;
      ((dta)localObject1).xsB = ((int)this.xGv.field_totalLen);
      ((dta)localObject1).xsD = 0;
      ((dta)localObject1).xsE = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      this.xkY = false;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(31074);
      return i;
    }
    ((dta)localObject1).xsD = paramf.length;
    ((dta)localObject1).xsE = new SKBuiltinBuffer_t().setBuffer(paramf);
    if (this.hCE != null) {
      ((dta)localObject1).MD5 = this.hCE;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(31074);
    return i;
  }
  
  final void e(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(31076);
    if (this.xGv.field_type != 2L)
    {
      AppMethodBeat.o(31076);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDI().xi("100131");
    if (localc.isValid()) {
      this.gzC = af.getInt((String)localc.fsy().get("needUploadData"), 1);
    }
    if ((this.gzA) || (this.gzC == 0))
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.gzD = paramd;
    this.gzA = true;
    paramd = new qd();
    com.tencent.mm.sdk.b.a.IvT.c(this.gzF);
    paramd.dFH.filePath = this.xGv.field_fileFullPath;
    paramd.dFH.dmK = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.IvT.l(paramd);
    AppMethodBeat.o(31076);
  }
  
  public final long fdR()
  {
    if (this.xGv == null) {
      return 0L;
    }
    return this.xGv.field_msgInfoId;
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31075);
    ae.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bu.isNullOrNil(this.idX)))
    {
      ae.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.idX });
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.xGv.field_totalLen - this.FfV) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31075);
      return;
    }
    paramString = (dtb)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramString.ikm != null) && (this.hCE == null) && ((!paramString.ikm.equals(this.xGv.field_appId)) || (!paramString.HYL.equals(this.xGv.field_clientAppDataId))))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramString.xsB < 0) || (paramString.xsB != this.xGv.field_totalLen) || (paramString.xsC < 0) || (paramString.xsC > this.xGv.field_totalLen))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    this.xGv.field_offset = paramString.xsC;
    paramq = this.xGv;
    if (m.aNh(paramString.ikp)) {}
    for (paramString = paramString.ikp;; paramString = "")
    {
      paramq.field_mediaSvrId = paramString;
      if (this.xGv.field_status != 105L) {
        break;
      }
      ae.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.xGv.field_mediaSvrId + "," + this.xGv.field_offset + "] ");
      this.callback.onSceneEnd(paramInt2, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.xGv.field_offset == this.xGv.field_totalLen)
    {
      if (bu.isNullOrNil(this.xGv.field_mediaSvrId))
      {
        ae.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        this.callback.onSceneEnd(3, -1, "", this);
        m.zc(this.xGv.systemRowid);
        AppMethodBeat.o(31075);
        return;
      }
      this.xGv.field_status = 199L;
      com.tencent.mm.plugin.report.service.g.yxI.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bu.fpO()), Integer.valueOf(com.tencent.mm.an.c.cC(ak.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.xGv.field_totalLen - this.FfV) });
    }
    boolean bool = ao.bJV().a(this.xGv, new String[0]);
    if (!bool)
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      e(null);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.xGv.field_status == 199L)
    {
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ae.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
      this.callback.onSceneEnd(3, -1, "", this);
    }
    AppMethodBeat.o(31075);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final n.b securityVerificationChecked(com.tencent.mm.network.q paramq)
  {
    return n.b.hRi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */