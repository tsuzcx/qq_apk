package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.qc;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.g.b.a.h;
import com.tencent.mm.g.b.a.j;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.pluginsdk.f.d.a;
import com.tencent.mm.pluginsdk.g.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.protocal.protobuf.dse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class aj
  extends n
  implements k
{
  private long ENy;
  boolean ENz;
  com.tencent.mm.al.f callback;
  k.b dkv;
  private boolean gwT;
  int gwV;
  com.tencent.mm.i.d gwW;
  com.tencent.mm.sdk.b.c gwY;
  private String hzQ;
  private d.a ibI;
  String ibe;
  private com.tencent.mm.i.g.a ibn;
  boolean ibv;
  int retCode;
  private com.tencent.mm.al.b rr;
  String sessionId;
  long startTime;
  String toUser;
  private boolean wVh;
  long xqA;
  c xqy;
  
  public aj(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31073);
    this.xqy = null;
    this.dkv = null;
    this.xqA = -1L;
    this.hzQ = null;
    this.wVh = true;
    this.ibv = true;
    this.retCode = 0;
    this.startTime = 0L;
    this.ENy = -1L;
    this.ibe = "";
    this.ENz = false;
    this.ibI = new d.a()
    {
      public final void J(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(193413);
        ad.e("MicroMsg.NetSceneUploadAppAttach", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(com.tencent.mm.sdk.platformtools.aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        m.yD(aj.this.xqy.systemRowid);
        ao.bIX().get(aj.this.xqA, aj.this.xqy);
        aj.this.xqy.field_signature = "";
        boolean bool = ao.bIX().a(aj.this.xqy, new String[0]);
        ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(-1), Long.valueOf(aj.this.xqA), Boolean.valueOf(bool) });
        aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
        AppMethodBeat.o(193413);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(193414);
        aj.this.xqy.field_lastModifyTime = bt.aQJ();
        if (aj.this.xqy.field_offset < paramAnonymousLong) {
          aj.this.xqy.field_offset = paramAnonymousLong;
        }
        boolean bool = ao.bIX().a(aj.this.xqy, new String[0]);
        if (!bool)
        {
          ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          aj.this.callback.onSceneEnd(3, -1, "", aj.this);
        }
        AppMethodBeat.o(193414);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(193412);
        ad.i("MicroMsg.NetSceneUploadAppAttach", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.gjI, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.iQl) });
        long l1 = bt.flT();
        long l2 = aj.this.startTime;
        long l3 = paramAnonymousa.iQl;
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(l1), Integer.valueOf(com.tencent.mm.ao.c.cA(com.tencent.mm.sdk.platformtools.aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(l3), Long.valueOf(l3 / (l1 - l2)), Integer.valueOf(1) });
        com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.gjI;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.nUg;
        locald.field_fileLength = paramAnonymousa.iQl;
        com.tencent.mm.ao.f.aGJ();
        locald.field_filecrc = com.tencent.mm.ao.a.EK(aj.this.xqy.field_fileFullPath);
        paramAnonymousa = aj.this;
        paramAnonymousa.xqy.field_status = 199L;
        boolean bool = ao.bIX().a(paramAnonymousa.xqy, new String[0]);
        if (!bool)
        {
          ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          paramAnonymousa.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          paramAnonymousa.callback.onSceneEnd(3, 0, "", paramAnonymousa);
          AppMethodBeat.o(193412);
          return;
        }
        m.a(paramAnonymousa.xqy.field_msgInfoId, paramAnonymousa.xqy.field_mediaSvrId, locald, true);
        ba.aiU().a(new ah(paramAnonymousa.xqy.field_msgInfoId, true, locald, new aj.2(paramAnonymousa), paramAnonymousa.sessionId, paramAnonymousa.xqy), 0);
        AppMethodBeat.o(193412);
      }
    };
    this.ibn = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193422);
        paramAnonymousString = aj.this.ibe;
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
          ad.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          ao.bIX().get(aj.this.xqA, aj.this.xqy);
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { aj.this.ibe });
          AppMethodBeat.o(193422);
          return 0;
          bool1 = false;
          break;
        }
        label153:
        if (paramAnonymousInt != 0)
        {
          m.yD(aj.this.xqy.systemRowid);
          ao.bIX().get(aj.this.xqA, aj.this.xqy);
          aj.this.xqy.field_signature = "";
          paramAnonymousBoolean = ao.bIX().a(aj.this.xqy, new String[0]);
          ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(aj.this.xqA), Boolean.valueOf(paramAnonymousBoolean) });
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
          new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(com.tencent.mm.sdk.platformtools.aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aLk();
          AppMethodBeat.o(193422);
          return 0;
        }
        if (aj.this.xqy.field_status == 105L)
        {
          ad.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(aj.this.xqy.field_status), Long.valueOf(aj.this.xqA) });
          com.tencent.mm.ao.f.aGI().EP(aj.this.ibe);
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "attach  has paused, status" + aj.this.xqy.field_status, aj.this);
          AppMethodBeat.o(193422);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          aj.this.xqy.field_lastModifyTime = bt.aQJ();
          aj.this.xqy.field_offset = paramAnonymousc.field_finishedLength;
          paramAnonymousBoolean = ao.bIX().a(aj.this.xqy, new String[0]);
          if (!paramAnonymousBoolean)
          {
            ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(paramAnonymousBoolean)));
            aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
            aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
            AppMethodBeat.o(193422);
            return 0;
          }
          AppMethodBeat.o(193422);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1030;
          }
          ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT });
          m.yD(aj.this.xqy.systemRowid);
          ao.bIX().get(aj.this.xqA, aj.this.xqy);
          aj.this.xqy.field_signature = "";
          paramAnonymousBoolean = ao.bIX().a(aj.this.xqy, new String[0]);
          ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(aj.this.xqA), Boolean.valueOf(paramAnonymousBoolean) });
          paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(com.tencent.mm.sdk.platformtools.aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT });
          new j(paramAnonymousString).aLk();
          new h(paramAnonymousString).aLk();
          aj.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", aj.this);
        }
        for (;;)
        {
          AppMethodBeat.o(193422);
          return 0;
          label1030:
          ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bt.aRp(aj.this.xqy.field_signature) });
          if (paramAnonymousBoolean)
          {
            if (paramAnonymousd.field_exist_whencheck)
            {
              ba.aiU().a(new com.tencent.mm.pluginsdk.g.c(aj.this.dkv, aj.this.xqy.field_fileFullPath, aj.this.toUser, new c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(193417);
                  paramAnonymous2String3 = bt.aRp(paramAnonymous2String3);
                  String str1 = bt.aRp(paramAnonymous2String4);
                  String str2 = bt.aRp(paramAnonymous2String5);
                  String str3 = bt.aRp(paramAnonymous2String6);
                  if (aj.this.dkv == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new errMsg:[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2String3, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(aj.this.ibv) });
                    if (!bt.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    ba.aBQ();
                    paramAnonymous2String2 = com.tencent.mm.model.c.azs().xY(aj.this.xqy.field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    ba.aBQ();
                    com.tencent.mm.model.c.azs().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String3 = new bu();
                    paramAnonymous2String3.qA(paramAnonymous2String2.field_createTime + 1L);
                    paramAnonymous2String3.tN(aj.this.toUser);
                    paramAnonymous2String3.setContent(paramAnonymous2String1);
                    paramAnonymous2String3.setType(10000);
                    paramAnonymous2String3.setStatus(6);
                    paramAnonymous2String3.kr(0);
                    ba.aBQ();
                    com.tencent.mm.model.c.azs().as(paramAnonymous2String3);
                    AppMethodBeat.o(193417);
                    return;
                  }
                  aj.this.xqy.field_signature = paramAnonymous2String4;
                  aj.this.xqy.field_fakeAeskey = paramAnonymous2String5;
                  aj.this.xqy.field_fakeSignature = paramAnonymous2String6;
                  aj.3.this.a(paramAnonymousInt, paramAnonymousd);
                  AppMethodBeat.o(193417);
                }
              }), 0);
            }
            else
            {
              ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
              ba.aiU().a(new com.tencent.mm.pluginsdk.g.c(null, aj.this.xqy.field_fileFullPath, aj.this.toUser, new c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(193419);
                  String str1 = bt.aRp(paramAnonymous2String3);
                  String str2 = bt.aRp(paramAnonymous2String4);
                  String str3 = bt.aRp(paramAnonymous2String5);
                  String str4 = bt.aRp(paramAnonymous2String6);
                  if (aj.this.dkv == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new errMsg[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(aj.this.ibv) });
                    if (!bt.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    ba.aBQ();
                    paramAnonymous2String2 = com.tencent.mm.model.c.azs().xY(aj.this.xqy.field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    ba.aBQ();
                    com.tencent.mm.model.c.azs().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String3 = new bu();
                    paramAnonymous2String3.qA(paramAnonymous2String2.field_createTime + 1L);
                    paramAnonymous2String3.tN(aj.this.toUser);
                    paramAnonymous2String3.setContent(paramAnonymous2String1);
                    paramAnonymous2String3.setType(10000);
                    paramAnonymous2String3.setStatus(6);
                    paramAnonymous2String3.kr(0);
                    ba.aBQ();
                    com.tencent.mm.model.c.azs().as(paramAnonymous2String3);
                    AppMethodBeat.o(193419);
                    return;
                  }
                  aj.this.xqy.field_signature = paramAnonymous2String4;
                  aj.this.xqy.field_fakeAeskey = paramAnonymous2String5;
                  aj.this.xqy.field_fakeSignature = paramAnonymous2String6;
                  aj.this.xqy.field_lastModifyTime = bt.flT();
                  if (aj.this.dkv != null)
                  {
                    aj.this.dkv.filemd5 = paramAnonymous2String2;
                    aj.this.dkv.gjI = paramAnonymous2String3;
                    aj.this.dkv.hzO = ((int)paramAnonymous2Long);
                    ba.aBQ();
                    paramAnonymous2String1 = com.tencent.mm.model.c.azs().xY(aj.this.xqy.field_msgInfoId);
                    paramAnonymous2String1.setContent(k.b.a(aj.this.dkv, null, null));
                    ba.aBQ();
                    com.tencent.mm.model.c.azs().a(paramAnonymous2String1.field_msgId, paramAnonymous2String1);
                  }
                  aj.this.ibv = false;
                  bool = ao.bIX().a(aj.this.xqy, new String[0]);
                  if (!bool)
                  {
                    ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
                    aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
                    AppMethodBeat.o(193419);
                    return;
                  }
                  ba.ajF().ay(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(193418);
                      ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                      aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                      AppMethodBeat.o(193418);
                    }
                  });
                  AppMethodBeat.o(193419);
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
        AppMethodBeat.i(193423);
        aj.this.xqy.field_status = 199L;
        boolean bool = ao.bIX().a(aj.this.xqy, new String[0]);
        if (!bool)
        {
          ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
          AppMethodBeat.o(193423);
          return;
        }
        m.a(aj.this.xqy.field_msgInfoId, aj.this.xqy.field_mediaSvrId, paramAnonymousd, true);
        ba.aiU().a(new ah(aj.this.xqy.field_msgInfoId, true, paramAnonymousd, new ah.a()
        {
          public final void dg(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(193421);
            ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              ba.ajF().ay(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(193420);
                  aj.this.ibv = false;
                  aj.this.xqy.field_createTime = bt.flT();
                  aj.this.xqy.field_lastModifyTime = bt.aQJ();
                  aj.this.xqy.field_offset = 0L;
                  aj.this.xqy.field_status = 101L;
                  boolean bool = ao.bIX().a(aj.this.xqy, new String[0]);
                  ad.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(aj.this.ibv), Boolean.valueOf(bool), Long.valueOf(aj.this.xqy.field_createTime) });
                  aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                  AppMethodBeat.o(193420);
                }
              });
              AppMethodBeat.o(193421);
              return;
            }
            new j(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(com.tencent.mm.sdk.platformtools.aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT })).aLk();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              aj.this.e(paramAnonymousd);
            }
            aj.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", aj.this);
            AppMethodBeat.o(193421);
          }
        }, aj.this.sessionId, aj.this.xqy), 0);
        AppMethodBeat.o(193423);
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.gwT = false;
    this.gwV = 0;
    this.gwY = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(qe paramAnonymousqe)
      {
        AppMethodBeat.i(193425);
        if (!paramAnonymousqe.dEH.filePath.equals(aj.this.xqy.field_fileFullPath))
        {
          AppMethodBeat.o(193425);
          return false;
        }
        localObject1 = "";
        try
        {
          localObject2 = URLEncoder.encode(paramAnonymousqe.dEH.result, "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            com.tencent.mm.modelsns.g localg;
            ad.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            localObject1 = aj.this.gwW.field_filemd5;
            continue;
            localObject1 = aj.this.gwW.field_fileId;
            continue;
            localObject1 = aj.this.gwW.field_aesKey;
          }
        }
        if (aj.this.gwV == 1)
        {
          ba.aBQ();
          localObject3 = com.tencent.mm.model.c.azs().xY(aj.this.xqy.field_msgInfoId);
          localg = new com.tencent.mm.modelsns.g();
          localg.m("20toUser", aj.this.toUser + ",");
          localg.m("21source", "4,");
          localg.m("22qrUrl", (String)localObject1 + ",");
          localObject2 = new StringBuilder();
          if (aj.this.gwW == null)
          {
            localObject1 = "";
            localg.m("23md5", (String)localObject1 + ",");
            localObject2 = new StringBuilder();
            if (aj.this.gwW != null) {
              break label488;
            }
            localObject1 = "";
            localg.m("24cdnFileId", (String)localObject1 + ",");
            localObject2 = new StringBuilder();
            if (aj.this.gwW != null) {
              break label502;
            }
            localObject1 = "";
            localg.m("25cdnAesKey", (String)localObject1 + ",");
            localObject2 = "";
            localObject1 = localObject2;
            if (((bu)localObject3).cTc())
            {
              localObject3 = k.b.yr(((ei)localObject3).field_content);
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((k.b)localObject3).appId;
              }
            }
            localg.m("26appip", (String)localObject1 + ",");
            localg.m("27toUsersCount", com.tencent.mm.model.q.yS(aj.this.toUser) + ",");
            localg.m("28codeType", Integer.valueOf(paramAnonymousqe.dEH.dnt));
            ad.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + localg.RE());
            o.L(13628, localg.toString());
          }
        }
        else
        {
          com.tencent.mm.sdk.b.a.IbL.d(aj.this.gwY);
          AppMethodBeat.o(193425);
          return false;
        }
      }
    };
    this.xqA = paramLong;
    this.hzQ = paramString1;
    this.sessionId = paramString2;
    paramString2 = new com.tencent.mm.al.b.a();
    paramString2.hNM = new dsd();
    paramString2.hNN = new dse();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.funcId = 220;
    paramString2.hNO = 105;
    paramString2.respCmdId = 1000000105;
    this.rr = paramString2.aDC();
    ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bt.flS() });
    AppMethodBeat.o(31073);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(31074);
    this.callback = paramf;
    this.ENz = false;
    this.xqy = new c();
    if ((!ao.bIX().get(this.xqA, this.xqy)) || (this.xqy == null))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.abi() + " summerbig get info failed rowid:" + this.xqA);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.xqy = null;
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.xqy.field_status != 101L)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.abi() + " summerbig get field_status failed rowid:" + this.xqA + " status:" + this.xqy.field_status);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.flT();
      this.ENy = this.xqy.field_offset;
    }
    ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.xqA), this.xqy.field_fileFullPath, Long.valueOf(this.xqy.field_totalLen), Boolean.valueOf(this.xqy.field_isUpload), Integer.valueOf(this.xqy.field_isUseCdn), Long.valueOf(this.xqy.field_type) });
    if (bt.isNullOrNil(this.xqy.field_appId))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.xqy.field_type != 8L) && (this.xqy.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
    }
    int i;
    if ((this.xqy.field_type == 8L) || (this.xqy.field_type == 9L))
    {
      ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.xqy.field_type) });
      i = 0;
    }
    Object localObject3;
    while (i != 0)
    {
      ad.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.xqA) });
      AppMethodBeat.o(31074);
      return 0;
      if (!com.tencent.mm.pluginsdk.f.b.eZi())
      {
        ad.i("MicroMsg.NetSceneUploadAppAttach", "isAllow2UseCdnWithXLab = false");
        i = 0;
      }
      else
      {
        com.tencent.mm.ao.f.aGI();
        if ((!com.tencent.mm.ao.b.pa(4)) && (this.xqy.field_isUseCdn != 1))
        {
          com.tencent.mm.ao.f.aGI();
          ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.ao.b.pa(4)), Integer.valueOf(this.xqy.field_isUseCdn) });
          i = 0;
        }
        else
        {
          ba.aBQ();
          localObject3 = com.tencent.mm.model.c.azs().xY(this.xqy.field_msgInfoId);
          if (((ei)localObject3).field_msgId != this.xqy.field_msgInfoId)
          {
            ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.xqy.field_msgInfoId), Long.valueOf(this.xqy.systemRowid), Long.valueOf(this.xqy.field_createTime), Long.valueOf(this.xqy.field_totalLen), Long.valueOf(this.xqy.field_status), Boolean.valueOf(this.xqy.field_isUpload), Integer.valueOf(this.xqy.field_isUseCdn), this.xqy.field_mediaId });
            this.toUser = null;
            i = 0;
          }
          else
          {
            this.toUser = ((ei)localObject3).field_talker;
            if (bt.isNullOrNil(((ei)localObject3).field_imgPath)) {
              break label3218;
            }
          }
        }
      }
    }
    label1666:
    label1672:
    label1678:
    label3218:
    for (paramf = com.tencent.mm.aw.q.aIF().Fm(((ei)localObject3).field_imgPath);; paramf = "")
    {
      int k = (int)com.tencent.mm.vfs.i.aYo(paramf);
      int m = (int)com.tencent.mm.vfs.i.aYo(this.xqy.field_fileFullPath);
      if (k >= 262144)
      {
        ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { paramf, Integer.valueOf(k) });
        i = 0;
        break;
      }
      this.ibe = com.tencent.mm.ao.c.a("upattach", this.xqy.field_createTime, ((ei)localObject3).field_talker, this.xqA);
      ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.xqy.field_createTime), this.ibe });
      if (bt.isNullOrNil(this.ibe))
      {
        ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.xqA) });
        i = 0;
        break;
      }
      Object localObject4 = new com.tencent.mm.i.g();
      ((com.tencent.mm.i.g)localObject4).fJi = "task_NetSceneUploadAppAttach";
      i = 0;
      Object localObject2 = ((ei)localObject3).field_content;
      Object localObject1 = localObject2;
      int j;
      if (w.vF(((ei)localObject3).field_talker))
      {
        j = bj.Bh(((ei)localObject3).field_content);
        localObject1 = localObject2;
        if (j != -1) {
          localObject1 = (((ei)localObject3).field_content + " ").substring(j + 2).trim();
        }
      }
      this.dkv = k.b.yr(bt.aRd((String)localObject1));
      if (this.dkv != null)
      {
        ad.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.dkv.hAd, bt.aRp(this.dkv.gjI), this.dkv.filemd5, Integer.valueOf(this.dkv.type) });
        ((com.tencent.mm.i.g)localObject4).field_fileId = this.dkv.hAd;
        ((com.tencent.mm.i.g)localObject4).field_aesKey = this.dkv.gjI;
        ((com.tencent.mm.i.g)localObject4).field_filemd5 = this.dkv.filemd5;
        if ((this.dkv.hzS != 0) || (this.dkv.hzO > 26214400))
        {
          i = 1;
          label1126:
          if (i == 0) {
            break label1639;
          }
          j = com.tencent.mm.i.a.fIy;
          label1135:
          ((com.tencent.mm.i.g)localObject4).field_appType = 0;
          ((com.tencent.mm.i.g)localObject4).fJj = this.ibn;
          ((com.tencent.mm.i.g)localObject4).field_mediaId = this.ibe;
          ((com.tencent.mm.i.g)localObject4).field_fullpath = this.xqy.field_fileFullPath;
          ((com.tencent.mm.i.g)localObject4).field_thumbpath = paramf;
          ((com.tencent.mm.i.g)localObject4).field_fileType = j;
          if (i == 0) {
            break label1647;
          }
          localObject1 = bt.nullAsNil(this.xqy.field_signature);
          label1200:
          ((com.tencent.mm.i.g)localObject4).field_svr_signature = ((String)localObject1);
          if (i == 0) {
            break label1654;
          }
          bool = bt.isNullOrNil(this.xqy.field_signature);
          label1223:
          ((com.tencent.mm.i.g)localObject4).field_onlycheckexist = bool;
          ((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature_aeskey = this.xqy.field_fakeAeskey;
          ((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature = this.xqy.field_fakeSignature;
          ((com.tencent.mm.i.g)localObject4).field_talker = ((ei)localObject3).field_talker;
          ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.fIw;
          ((com.tencent.mm.i.g)localObject4).field_totalLen = m;
          ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
          ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
          ((com.tencent.mm.i.g)localObject4).field_enable_hitcheck = this.ibv;
          if (!w.vF(((ei)localObject3).field_talker)) {
            break label1660;
          }
          j = 1;
          label1314:
          ((com.tencent.mm.i.g)localObject4).field_chattype = j;
          ((com.tencent.mm.i.g)localObject4).field_force_aeskeycdn = false;
          ((com.tencent.mm.i.g)localObject4).field_trysafecdn = true;
          ((com.tencent.mm.i.g)localObject4).field_bzScene = 0;
          if (1 != ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHs, 0)) {
            break label1666;
          }
          bool = true;
          label1364:
          ad.i("MicroMsg.NetSceneUploadAppAttach", "cdn upload UseMultiSocket(X-Lab):%s", new Object[] { Boolean.valueOf(bool) });
          if ((!bool) || (i == 0)) {
            break label1672;
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ((com.tencent.mm.i.g)localObject4).field_use_multithread = bool;
        ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn field_use_multithread[%s], msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_use_multithread), Long.valueOf(this.xqy.field_msgInfoId), ((com.tencent.mm.i.g)localObject4).field_fullpath, Integer.valueOf(m), paramf, Integer.valueOf(k), this.ibe, Integer.valueOf(((com.tencent.mm.i.g)localObject4).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_trysafecdn), bt.aRp(((com.tencent.mm.i.g)localObject4).field_aesKey), ((com.tencent.mm.i.g)localObject4).field_filemd5, bt.aRp(((com.tencent.mm.i.g)localObject4).field_svr_signature), bt.aRp(((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature_aeskey), bt.aRp(((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature) });
        if (com.tencent.mm.ao.f.aGI().f((com.tencent.mm.i.g)localObject4)) {
          break label1678;
        }
        ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
        this.ibe = "";
        i = 0;
        break;
        i = 0;
        break label1126;
        ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
        break label1126;
        label1639:
        j = com.tencent.mm.i.a.MediaType_FILE;
        break label1135;
        label1647:
        localObject1 = "";
        break label1200;
        label1654:
        bool = false;
        break label1223;
        label1660:
        j = 0;
        break label1314;
        bool = false;
        break label1364;
      }
      if (this.xqy.field_isUseCdn != 1)
      {
        this.xqy.field_isUseCdn = 1;
        bool = ao.bIX().a(this.xqy, new String[0]);
        if (!bool)
        {
          ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
          this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          this.callback.onSceneEnd(3, -1, "", this);
          i = 0;
          break;
        }
      }
      ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.ibe });
      i = 1;
      break;
      if ((this.xqy.field_type == 8L) || (this.xqy.field_type == 9L))
      {
        ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig parallel-upload support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.xqy.field_type) });
        i = 0;
      }
      while (i != 0)
      {
        ad.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene use parallel-upload return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.xqA) });
        AppMethodBeat.o(31074);
        return 0;
        if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qHv, 1)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label1923;
          }
          ad.i("MicroMsg.NetSceneUploadAppAttach", "NOT ALLOW USE PARALLEL UPLOAD APP ATTACH");
          i = 0;
          break;
        }
        ba.aBQ();
        localObject1 = com.tencent.mm.model.c.azs().xY(this.xqy.field_msgInfoId);
        if (((ei)localObject1).field_msgId != this.xqy.field_msgInfoId)
        {
          ad.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.xqy.field_msgInfoId), Long.valueOf(this.xqy.systemRowid), Long.valueOf(this.xqy.field_createTime), Long.valueOf(this.xqy.field_totalLen), Long.valueOf(this.xqy.field_status), Boolean.valueOf(this.xqy.field_isUpload), Integer.valueOf(this.xqy.field_isUseCdn), this.xqy.field_mediaId });
          this.toUser = null;
          i = 0;
        }
        else
        {
          paramf = "";
          if (!bt.isNullOrNil(((ei)localObject1).field_imgPath)) {
            paramf = com.tencent.mm.aw.q.aIF().Fm(((ei)localObject1).field_imgPath);
          }
          localObject2 = new com.tencent.mm.pluginsdk.f.d();
          ((com.tencent.mm.pluginsdk.f.d)localObject2).hZF = fad();
          ((com.tencent.mm.pluginsdk.f.d)localObject2).EKE = this.ibI;
          ((com.tencent.mm.pluginsdk.f.d)localObject2).scene = 3;
          ((com.tencent.mm.pluginsdk.f.d)localObject2).fileType = 5;
          ((com.tencent.mm.pluginsdk.f.d)localObject2).thumbPath = paramf;
          ((com.tencent.mm.pluginsdk.f.d)localObject2).hdP = this.xqy.field_fileFullPath;
          localObject3 = new com.tencent.mm.pluginsdk.f.c();
          ba.aBQ();
          localObject4 = com.tencent.mm.model.c.azs().xY(this.xqy.field_msgInfoId);
          if (((ei)localObject4).field_msgId != this.xqy.field_msgInfoId)
          {
            ad.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.xqy.field_msgInfoId), Long.valueOf(this.xqy.systemRowid), Long.valueOf(this.xqy.field_createTime), Long.valueOf(this.xqy.field_totalLen), Long.valueOf(this.xqy.field_status), Boolean.valueOf(this.xqy.field_isUpload), Integer.valueOf(this.xqy.field_isUseCdn), this.xqy.field_mediaId });
            this.toUser = null;
            paramf = "";
            label2339:
            if (this.xqy == null) {
              break label2579;
            }
          }
          label2579:
          for (localObject1 = this.xqy.field_signature;; localObject1 = null)
          {
            ((com.tencent.mm.pluginsdk.f.c)localObject3).EKo = ((String)localObject1);
            ((com.tencent.mm.pluginsdk.f.c)localObject3).EKp = paramf;
            ((com.tencent.mm.pluginsdk.f.c)localObject3).a((com.tencent.mm.pluginsdk.f.d)localObject2);
            this.ENz = true;
            i = 1;
            break;
            localObject1 = ((ei)localObject4).field_content;
            paramf = (com.tencent.mm.al.f)localObject1;
            if (w.vF(((ei)localObject4).field_talker))
            {
              i = bj.Bh(((ei)localObject4).field_content);
              paramf = (com.tencent.mm.al.f)localObject1;
              if (i != -1) {
                paramf = (((ei)localObject4).field_content + " ").substring(i + 2).trim();
              }
            }
            this.dkv = k.b.yr(paramf);
            if (((this.dkv != null) && (this.dkv.hzS != 0)) || (this.dkv.hzO > 26214400))
            {
              ad.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.dkv.hAd, bt.aRp(this.dkv.gjI), this.dkv.filemd5, Integer.valueOf(this.dkv.type) });
              paramf = this.dkv.gjI;
              break label2339;
            }
            ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
            paramf = "";
            break label2339;
          }
        }
      }
      if (this.xqy.field_netTimes > 3200L)
      {
        m.yD(this.xqy.systemRowid);
        ad.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.abi() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.xqA);
        AppMethodBeat.o(31074);
        return -1;
      }
      paramf = this.xqy;
      paramf.field_netTimes += 1L;
      if (bt.isNullOrNil(this.xqy.field_clientAppDataId))
      {
        ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
      if ((this.xqy.field_totalLen <= 0L) || (this.xqy.field_totalLen > 26214400L))
      {
        ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.xqy.field_totalLen);
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        if (this.xqy.field_totalLen > 26214400L) {
          m.yD(this.xqy.systemRowid);
        }
        AppMethodBeat.o(31074);
        return -1;
      }
      if (bt.isNullOrNil(this.xqy.field_fileFullPath))
      {
        ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
      if ((int)com.tencent.mm.vfs.i.aYo(this.xqy.field_fileFullPath) > 26214400)
      {
        ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
        m.yD(this.xqy.systemRowid);
        AppMethodBeat.o(31074);
        return -1;
      }
      if (bt.isNullOrNil(this.hzQ)) {}
      for (paramf = com.tencent.mm.vfs.i.aY(this.xqy.field_fileFullPath, (int)this.xqy.field_offset, 8192); bt.cC(paramf); paramf = com.tencent.mm.vfs.i.aY(this.xqy.field_fileFullPath, (int)this.xqy.field_offset, 32768))
      {
        ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
      localObject1 = (dsd)this.rr.hNK.hNQ;
      ((dsd)localObject1).iht = this.xqy.field_appId;
      ((dsd)localObject1).Fws = ((int)this.xqy.field_sdkVer);
      ((dsd)localObject1).HEY = this.xqy.field_clientAppDataId;
      ((dsd)localObject1).nEf = ((int)this.xqy.field_type);
      ((dsd)localObject1).nDo = u.aAm();
      ((dsd)localObject1).xcK = ((int)this.xqy.field_totalLen);
      ((dsd)localObject1).xcL = ((int)this.xqy.field_offset);
      if ((this.hzQ != null) && (this.wVh))
      {
        ((dsd)localObject1).MD5 = this.hzQ;
        ((dsd)localObject1).xcK = ((int)this.xqy.field_totalLen);
        ((dsd)localObject1).xcM = 0;
        ((dsd)localObject1).xcN = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        this.wVh = false;
        i = dispatch(parame, this.rr, this);
        AppMethodBeat.o(31074);
        return i;
      }
      ((dsd)localObject1).xcM = paramf.length;
      ((dsd)localObject1).xcN = new SKBuiltinBuffer_t().setBuffer(paramf);
      if (this.hzQ != null) {
        ((dsd)localObject1).MD5 = this.hzQ;
      }
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(31074);
      return i;
    }
  }
  
  final void e(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(31076);
    if (this.xqy.field_type != 2L)
    {
      AppMethodBeat.o(31076);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aDs().wz("100131");
    if (localc.isValid()) {
      this.gwV = af.getInt((String)localc.foF().get("needUploadData"), 1);
    }
    if ((this.gwT) || (this.gwV == 0))
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.gwW = paramd;
    this.gwT = true;
    paramd = new qc();
    com.tencent.mm.sdk.b.a.IbL.c(this.gwY);
    paramd.dEC.filePath = this.xqy.field_fileFullPath;
    paramd.dEC.dlI = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.IbL.l(paramd);
    AppMethodBeat.o(31076);
  }
  
  public final long fad()
  {
    if (this.xqy == null) {
      return 0L;
    }
    return this.xqy.field_msgInfoId;
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31075);
    ad.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.ibe)))
    {
      ad.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.ibe });
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(com.tencent.mm.sdk.platformtools.aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.xqy.field_totalLen - this.ENy) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31075);
      return;
    }
    paramString = (dse)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramString.iht != null) && (this.hzQ == null) && ((!paramString.iht.equals(this.xqy.field_appId)) || (!paramString.HEY.equals(this.xqy.field_clientAppDataId))))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramString.xcK < 0) || (paramString.xcK != this.xqy.field_totalLen) || (paramString.xcL < 0) || (paramString.xcL > this.xqy.field_totalLen))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    this.xqy.field_offset = paramString.xcL;
    paramq = this.xqy;
    if (m.aLL(paramString.ihw)) {}
    for (paramString = paramString.ihw;; paramString = "")
    {
      paramq.field_mediaSvrId = paramString;
      if (this.xqy.field_status != 105L) {
        break;
      }
      ad.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.xqy.field_mediaSvrId + "," + this.xqy.field_offset + "] ");
      this.callback.onSceneEnd(paramInt2, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.xqy.field_offset == this.xqy.field_totalLen)
    {
      if (bt.isNullOrNil(this.xqy.field_mediaSvrId))
      {
        ad.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        this.callback.onSceneEnd(3, -1, "", this);
        m.yD(this.xqy.systemRowid);
        AppMethodBeat.o(31075);
        return;
      }
      this.xqy.field_status = 199L;
      com.tencent.mm.plugin.report.service.g.yhR.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.flT()), Integer.valueOf(com.tencent.mm.ao.c.cA(com.tencent.mm.sdk.platformtools.aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.xqy.field_totalLen - this.ENy) });
    }
    boolean bool = ao.bIX().a(this.xqy, new String[0]);
    if (!bool)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      e(null);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.xqy.field_status == 199L)
    {
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
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
    return n.b.hOp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */