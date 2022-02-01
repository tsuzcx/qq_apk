package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q.b;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.g.b.a.y;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g.c.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.emy;
import com.tencent.mm.protocal.protobuf.emz;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.ByteArrayOutputStream;
import java.util.Map;

public final class aj
  extends com.tencent.mm.ak.q
  implements com.tencent.mm.network.m
{
  c BGu;
  long BGw;
  private boolean BiZ;
  private long JWM;
  boolean JWN;
  com.tencent.mm.ak.i callback;
  k.b dCN;
  private boolean hmn;
  int hmp;
  com.tencent.mm.i.d hmq;
  IListener hms;
  String iYT;
  private com.tencent.mm.i.g.a iZc;
  boolean iZk;
  private com.tencent.mm.pluginsdk.f.d.a iZw;
  private String iwK;
  int retCode;
  private com.tencent.mm.ak.d rr;
  String sessionId;
  long startTime;
  String toUser;
  
  public aj(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31073);
    this.BGu = null;
    this.dCN = null;
    this.BGw = -1L;
    this.iwK = null;
    this.BiZ = true;
    this.iZk = true;
    this.retCode = 0;
    this.startTime = 0L;
    this.JWM = -1L;
    this.iYT = "";
    this.JWN = false;
    this.iZw = new com.tencent.mm.pluginsdk.f.d.a()
    {
      public final void M(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(232155);
        Log.e("MicroMsg.NetSceneUploadAppAttach", "onUploadFailure, errCode:%s, uploadID:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        h.CyF.a(10420, new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
        m.HS(aj.this.BGu.systemRowid);
        ao.cgO().get(aj.this.BGw, aj.this.BGu);
        aj.this.BGu.field_signature = "";
        boolean bool = ao.cgO().a(aj.this.BGu, new String[0]);
        Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(-1), Long.valueOf(aj.this.BGw), Boolean.valueOf(bool) });
        aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
        AppMethodBeat.o(232155);
      }
      
      public final void a(float paramAnonymousFloat, long paramAnonymousLong)
      {
        AppMethodBeat.i(232156);
        aj.this.BGu.field_lastModifyTime = Util.nowSecond();
        if (aj.this.BGu.field_offset < paramAnonymousLong) {
          aj.this.BGu.field_offset = paramAnonymousLong;
        }
        boolean bool = ao.cgO().a(aj.this.BGu, new String[0]);
        if (!bool)
        {
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          aj.this.callback.onSceneEnd(3, -1, "", aj.this);
        }
        AppMethodBeat.o(232156);
      }
      
      public final void a(com.tencent.mm.pluginsdk.f.g.a paramAnonymousa)
      {
        AppMethodBeat.i(232154);
        Log.i("MicroMsg.NetSceneUploadAppAttach", "upload success, field_aesKey:%s, fileId:%s, fileLen:%s", new Object[] { paramAnonymousa.aesKey, paramAnonymousa.fileId, Long.valueOf(paramAnonymousa.jPY) });
        long l1 = Util.nowMilliSecond();
        long l2 = aj.this.startTime;
        long l3 = paramAnonymousa.jPY;
        h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(l1), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(l3), Long.valueOf(l3 / (l1 - l2)), Integer.valueOf(1) });
        com.tencent.mm.i.d locald = new com.tencent.mm.i.d();
        locald.field_aesKey = paramAnonymousa.aesKey;
        locald.field_fileId = paramAnonymousa.fileId;
        locald.field_filemd5 = paramAnonymousa.pkL;
        locald.field_fileLength = paramAnonymousa.jPY;
        com.tencent.mm.an.f.baR();
        locald.field_filecrc = com.tencent.mm.an.a.NW(aj.this.BGu.field_fileFullPath);
        paramAnonymousa = aj.this;
        paramAnonymousa.BGu.field_status = 199L;
        boolean bool = ao.cgO().a(paramAnonymousa.BGu, new String[0]);
        if (!bool)
        {
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          paramAnonymousa.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          paramAnonymousa.callback.onSceneEnd(3, 0, "", paramAnonymousa);
          AppMethodBeat.o(232154);
          return;
        }
        m.a(paramAnonymousa.BGu.field_msgInfoId, paramAnonymousa.BGu.field_mediaSvrId, locald, true);
        bg.azz().a(new ah(paramAnonymousa.BGu.field_msgInfoId, true, locald, new aj.2(paramAnonymousa), paramAnonymousa.sessionId, paramAnonymousa.BGu), 0);
        AppMethodBeat.o(232154);
      }
    };
    this.iZc = new com.tencent.mm.i.g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(232164);
        paramAnonymousString = aj.this.iYT;
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
          ao.cgO().get(aj.this.BGw, aj.this.BGu);
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { aj.this.iYT });
          AppMethodBeat.o(232164);
          return 0;
          bool1 = false;
          break;
        }
        label153:
        if (paramAnonymousInt != 0)
        {
          m.HS(aj.this.BGu.systemRowid);
          ao.cgO().get(aj.this.BGw, aj.this.BGu);
          aj.this.BGu.field_signature = "";
          paramAnonymousBoolean = ao.cgO().a(aj.this.BGu, new String[0]);
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(aj.this.BGw), Boolean.valueOf(paramAnonymousBoolean) });
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
          new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).bfK();
          AppMethodBeat.o(232164);
          return 0;
        }
        if (aj.this.BGu.field_status == 105L)
        {
          Log.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(aj.this.BGu.field_status), Long.valueOf(aj.this.BGw) });
          com.tencent.mm.an.f.baQ().Ob(aj.this.iYT);
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "attach  has paused, status" + aj.this.BGu.field_status, aj.this);
          AppMethodBeat.o(232164);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          aj.this.BGu.field_lastModifyTime = Util.nowSecond();
          aj.this.BGu.field_offset = paramAnonymousc.field_finishedLength;
          paramAnonymousBoolean = ao.cgO().a(aj.this.BGu, new String[0]);
          if (!paramAnonymousBoolean)
          {
            Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(paramAnonymousBoolean)));
            aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
            aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
            AppMethodBeat.o(232164);
            return 0;
          }
          AppMethodBeat.o(232164);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1030;
          }
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk });
          m.HS(aj.this.BGu.systemRowid);
          ao.cgO().get(aj.this.BGw, aj.this.BGu);
          aj.this.BGu.field_signature = "";
          paramAnonymousBoolean = ao.cgO().a(aj.this.BGu, new String[0]);
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(aj.this.BGw), Boolean.valueOf(paramAnonymousBoolean) });
          paramAnonymousString = com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk });
          new y(paramAnonymousString).bfK();
          new w(paramAnonymousString).bfK();
          aj.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", aj.this);
        }
        for (;;)
        {
          AppMethodBeat.o(232164);
          return 0;
          label1030:
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), Util.secPrint(aj.this.BGu.field_signature) });
          if (paramAnonymousBoolean)
          {
            if (paramAnonymousd.field_exist_whencheck)
            {
              bg.azz().a(new com.tencent.mm.pluginsdk.g.c(aj.this.dCN, aj.this.BGu.field_fileFullPath, aj.this.toUser, new c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(232159);
                  paramAnonymous2String3 = Util.secPrint(paramAnonymous2String3);
                  String str1 = Util.secPrint(paramAnonymous2String4);
                  String str2 = Util.secPrint(paramAnonymous2String5);
                  String str3 = Util.secPrint(paramAnonymous2String6);
                  if (aj.this.dCN == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new errMsg:[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, paramAnonymous2String3, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(aj.this.iZk) });
                    if (!Util.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    bg.aVF();
                    paramAnonymous2String2 = com.tencent.mm.model.c.aSQ().Hb(aj.this.BGu.field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String2 = new ca();
                    paramAnonymous2String2.setCreateTime(bp.Kw(aj.this.toUser));
                    paramAnonymous2String2.Cy(aj.this.toUser);
                    paramAnonymous2String2.setContent(paramAnonymous2String1);
                    paramAnonymous2String2.setType(10000);
                    paramAnonymous2String2.setStatus(6);
                    paramAnonymous2String2.nv(0);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().aC(paramAnonymous2String2);
                    AppMethodBeat.o(232159);
                    return;
                  }
                  aj.this.BGu.field_signature = paramAnonymous2String4;
                  aj.this.BGu.field_fakeAeskey = paramAnonymous2String5;
                  aj.this.BGu.field_fakeSignature = paramAnonymous2String6;
                  aj.3.this.a(paramAnonymousInt, paramAnonymousd);
                  AppMethodBeat.o(232159);
                }
              }), 0);
            }
            else
            {
              Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
              bg.azz().a(new com.tencent.mm.pluginsdk.g.c(null, aj.this.BGu.field_fileFullPath, aj.this.toUser, new c.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, String paramAnonymous2String6, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(232161);
                  String str1 = Util.secPrint(paramAnonymous2String3);
                  String str2 = Util.secPrint(paramAnonymous2String4);
                  String str3 = Util.secPrint(paramAnonymous2String5);
                  String str4 = Util.secPrint(paramAnonymous2String6);
                  if (aj.this.dCN == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new errMsg[%s], md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(aj.this.iZk) });
                    if (!Util.isNullOrNil(paramAnonymous2String4)) {
                      break;
                    }
                    bg.aVF();
                    paramAnonymous2String2 = com.tencent.mm.model.c.aSQ().Hb(aj.this.BGu.field_msgInfoId);
                    paramAnonymous2String2.setStatus(5);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(paramAnonymous2String2.field_msgId, paramAnonymous2String2);
                    paramAnonymous2String2 = new ca();
                    paramAnonymous2String2.setCreateTime(bp.Kw(aj.this.toUser));
                    paramAnonymous2String2.Cy(aj.this.toUser);
                    paramAnonymous2String2.setContent(paramAnonymous2String1);
                    paramAnonymous2String2.setType(10000);
                    paramAnonymous2String2.setStatus(6);
                    paramAnonymous2String2.nv(0);
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().aC(paramAnonymous2String2);
                    AppMethodBeat.o(232161);
                    return;
                  }
                  aj.this.BGu.field_signature = paramAnonymous2String4;
                  aj.this.BGu.field_fakeAeskey = paramAnonymous2String5;
                  aj.this.BGu.field_fakeSignature = paramAnonymous2String6;
                  aj.this.BGu.field_lastModifyTime = Util.nowMilliSecond();
                  if (aj.this.dCN != null)
                  {
                    aj.this.dCN.filemd5 = paramAnonymous2String2;
                    aj.this.dCN.aesKey = paramAnonymous2String3;
                    aj.this.dCN.iwI = ((int)paramAnonymous2Long);
                    bg.aVF();
                    paramAnonymous2String1 = com.tencent.mm.model.c.aSQ().Hb(aj.this.BGu.field_msgInfoId);
                    paramAnonymous2String1.setContent(k.b.a(aj.this.dCN, null, null));
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(paramAnonymous2String1.field_msgId, paramAnonymous2String1);
                  }
                  aj.this.iZk = false;
                  bool = ao.cgO().a(aj.this.BGu, new String[0]);
                  if (!bool)
                  {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
                    aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
                    AppMethodBeat.o(232161);
                    return;
                  }
                  bg.aAk().postToWorker(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(232160);
                      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                      aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                      AppMethodBeat.o(232160);
                    }
                  });
                  AppMethodBeat.o(232161);
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
        AppMethodBeat.i(232165);
        aj.this.BGu.field_status = 199L;
        boolean bool = ao.cgO().a(aj.this.BGu, new String[0]);
        if (!bool)
        {
          Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          aj.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          aj.this.callback.onSceneEnd(3, paramAnonymousInt, "", aj.this);
          AppMethodBeat.o(232165);
          return;
        }
        m.a(aj.this.BGu.field_msgInfoId, aj.this.BGu.field_mediaSvrId, paramAnonymousd, true);
        bg.azz().a(new ah(aj.this.BGu.field_msgInfoId, true, paramAnonymousd, new ah.a()
        {
          public final void dq(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(232163);
            Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              bg.aAk().postToWorker(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(232162);
                  aj.this.iZk = false;
                  aj.this.BGu.field_createTime = Util.nowMilliSecond();
                  aj.this.BGu.field_lastModifyTime = Util.nowSecond();
                  aj.this.BGu.field_offset = 0L;
                  aj.this.BGu.field_status = 101L;
                  boolean bool = ao.cgO().a(aj.this.BGu, new String[0]);
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(aj.this.iZk), Boolean.valueOf(bool), Long.valueOf(aj.this.BGu.field_createTime) });
                  aj.this.doScene(aj.this.dispatcher(), aj.this.callback);
                  AppMethodBeat.o(232162);
                }
              });
              AppMethodBeat.o(232163);
              return;
            }
            new y(com.tencent.mm.plugin.report.a.t(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(aj.this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.gqk })).bfK();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              aj.this.e(paramAnonymousd);
            }
            aj.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", aj.this);
            AppMethodBeat.o(232163);
          }
        }, aj.this.sessionId, aj.this.BGu), 0);
        AppMethodBeat.o(232165);
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.hmn = false;
    this.hmp = 0;
    this.hms = new aj.4(this);
    this.BGw = paramLong;
    this.iwK = paramString1;
    this.sessionId = paramString2;
    paramString2 = new com.tencent.mm.ak.d.a();
    paramString2.iLN = new emy();
    paramString2.iLO = new emz();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.funcId = 220;
    paramString2.iLP = 105;
    paramString2.respCmdId = 1000000105;
    this.rr = paramString2.aXF();
    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, Util.getStack() });
    AppMethodBeat.o(31073);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(31074);
    this.callback = parami;
    this.JWN = false;
    this.BGu = new c();
    if ((!ao.cgO().get(this.BGw, this.BGu)) || (this.BGu == null))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.apq() + " summerbig get info failed rowid:" + this.BGw);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.BGu = null;
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.BGu.field_status != 101L)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.apq() + " summerbig get field_status failed rowid:" + this.BGw + " status:" + this.BGu.field_status);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.JWM = this.BGu.field_offset;
    }
    Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.BGw), this.BGu.field_fileFullPath, Long.valueOf(this.BGu.field_totalLen), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), Long.valueOf(this.BGu.field_type) });
    if (Util.isNullOrNil(this.BGu.field_appId))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.BGu.field_type != 8L) && (this.BGu.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
    }
    if ((this.BGu.field_type == 8L) || (this.BGu.field_type == 9L))
    {
      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.BGu.field_type) });
      i = 0;
    }
    Object localObject3;
    Object localObject4;
    Object localObject2;
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.BGw) });
      AppMethodBeat.o(31074);
      return 0;
      if (!com.tencent.mm.pluginsdk.f.b.gmg())
      {
        Log.i("MicroMsg.NetSceneUploadAppAttach", "isAllow2UseCdnWithXLab = false");
        i = 0;
      }
      else
      {
        com.tencent.mm.an.f.baQ();
        if ((!com.tencent.mm.an.b.sS(4)) && (this.BGu.field_isUseCdn != 1))
        {
          com.tencent.mm.an.f.baQ();
          Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.sS(4)), Integer.valueOf(this.BGu.field_isUseCdn) });
          i = 0;
        }
        else
        {
          bg.aVF();
          localObject3 = com.tencent.mm.model.c.aSQ().Hb(this.BGu.field_msgInfoId);
          if (((eo)localObject3).field_msgId != this.BGu.field_msgInfoId)
          {
            Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.BGu.field_msgInfoId), Long.valueOf(this.BGu.systemRowid), Long.valueOf(this.BGu.field_createTime), Long.valueOf(this.BGu.field_totalLen), Long.valueOf(this.BGu.field_status), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), this.BGu.field_mediaId });
            this.toUser = null;
            i = 0;
          }
          else
          {
            this.toUser = ((eo)localObject3).field_talker;
            parami = "";
            if (!Util.isNullOrNil(((eo)localObject3).field_imgPath)) {
              parami = com.tencent.mm.av.q.bcR().Oz(((eo)localObject3).field_imgPath);
            }
            int k = (int)com.tencent.mm.vfs.s.boW(parami);
            int m = (int)com.tencent.mm.vfs.s.boW(this.BGu.field_fileFullPath);
            if (k >= 262144)
            {
              Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { parami, Integer.valueOf(k) });
              i = 0;
            }
            else
            {
              this.iYT = com.tencent.mm.an.c.a("upattach", this.BGu.field_createTime, ((eo)localObject3).field_talker, this.BGw);
              Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.BGu.field_createTime), this.iYT });
              if (Util.isNullOrNil(this.iYT))
              {
                Log.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.BGw) });
                i = 0;
              }
              else
              {
                localObject4 = new com.tencent.mm.i.g();
                ((com.tencent.mm.i.g)localObject4).taskName = "task_NetSceneUploadAppAttach";
                i = 0;
                localObject2 = ((eo)localObject3).field_content;
                localObject1 = localObject2;
                int j;
                if (ab.Eq(((eo)localObject3).field_talker))
                {
                  j = bp.Kp(((eo)localObject3).field_content);
                  localObject1 = localObject2;
                  if (j != -1) {
                    localObject1 = (((eo)localObject3).field_content + " ").substring(j + 2).trim();
                  }
                }
                this.dCN = k.b.HD(Util.processXml((String)localObject1));
                if (this.dCN != null)
                {
                  Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.dCN.iwW, Util.secPrint(this.dCN.aesKey), this.dCN.filemd5, Integer.valueOf(this.dCN.type) });
                  ((com.tencent.mm.i.g)localObject4).field_fileId = this.dCN.iwW;
                  ((com.tencent.mm.i.g)localObject4).field_aesKey = this.dCN.aesKey;
                  ((com.tencent.mm.i.g)localObject4).field_filemd5 = this.dCN.filemd5;
                  if ((this.dCN.iwM != 0) || (this.dCN.iwI > 26214400))
                  {
                    i = 1;
                    label1129:
                    if (i == 0) {
                      break label1598;
                    }
                    j = com.tencent.mm.i.a.gpO;
                    label1138:
                    ((com.tencent.mm.i.g)localObject4).field_appType = 0;
                    ((com.tencent.mm.i.g)localObject4).gqy = this.iZc;
                    ((com.tencent.mm.i.g)localObject4).field_mediaId = this.iYT;
                    ((com.tencent.mm.i.g)localObject4).field_fullpath = this.BGu.field_fileFullPath;
                    ((com.tencent.mm.i.g)localObject4).field_thumbpath = parami;
                    ((com.tencent.mm.i.g)localObject4).field_fileType = j;
                    if (i == 0) {
                      break label1606;
                    }
                    localObject1 = Util.nullAsNil(this.BGu.field_signature);
                    label1203:
                    ((com.tencent.mm.i.g)localObject4).field_svr_signature = ((String)localObject1);
                    if (i == 0) {
                      break label1613;
                    }
                    bool = Util.isNullOrNil(this.BGu.field_signature);
                    label1226:
                    ((com.tencent.mm.i.g)localObject4).field_onlycheckexist = bool;
                    ((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature_aeskey = this.BGu.field_fakeAeskey;
                    ((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature = this.BGu.field_fakeSignature;
                    ((com.tencent.mm.i.g)localObject4).field_talker = ((eo)localObject3).field_talker;
                    ((com.tencent.mm.i.g)localObject4).field_priority = com.tencent.mm.i.a.gpM;
                    ((com.tencent.mm.i.g)localObject4).field_totalLen = m;
                    ((com.tencent.mm.i.g)localObject4).field_needStorage = false;
                    ((com.tencent.mm.i.g)localObject4).field_isStreamMedia = false;
                    ((com.tencent.mm.i.g)localObject4).field_enable_hitcheck = this.iZk;
                    if (!ab.Eq(((eo)localObject3).field_talker)) {
                      break label1619;
                    }
                    j = 1;
                    label1317:
                    ((com.tencent.mm.i.g)localObject4).field_chattype = j;
                    ((com.tencent.mm.i.g)localObject4).field_force_aeskeycdn = false;
                    ((com.tencent.mm.i.g)localObject4).field_trysafecdn = true;
                    ((com.tencent.mm.i.g)localObject4).field_bzScene = 0;
                    if ((!com.tencent.mm.an.c.baL()) || (i == 0)) {
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
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn field_use_multithread[%s], msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_use_multithread), Long.valueOf(this.BGu.field_msgInfoId), ((com.tencent.mm.i.g)localObject4).field_fullpath, Integer.valueOf(m), parami, Integer.valueOf(k), this.iYT, Integer.valueOf(((com.tencent.mm.i.g)localObject4).field_fileType), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_enable_hitcheck), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_onlycheckexist), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_force_aeskeycdn), Boolean.valueOf(((com.tencent.mm.i.g)localObject4).field_trysafecdn), Util.secPrint(((com.tencent.mm.i.g)localObject4).field_aesKey), ((com.tencent.mm.i.g)localObject4).field_filemd5, Util.secPrint(((com.tencent.mm.i.g)localObject4).field_svr_signature), Util.secPrint(((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature_aeskey), Util.secPrint(((com.tencent.mm.i.g)localObject4).field_fake_bigfile_signature) });
                  if (com.tencent.mm.an.f.baQ().f((com.tencent.mm.i.g)localObject4)) {
                    break label1631;
                  }
                  Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                  this.iYT = "";
                  i = 0;
                  break;
                  i = 0;
                  break label1129;
                  Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
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
                if (this.BGu.field_isUseCdn != 1)
                {
                  this.BGu.field_isUseCdn = 1;
                  bool = ao.cgO().a(this.BGu, new String[0]);
                  if (!bool)
                  {
                    Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
                    this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    this.callback.onSceneEnd(3, -1, "", this);
                    i = 0;
                    continue;
                  }
                }
                Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.iYT });
                i = 1;
              }
            }
          }
        }
      }
    }
    if ((this.BGu.field_type == 8L) || (this.BGu.field_type == 9L))
    {
      Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig parallel-upload support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.BGu.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene use parallel-upload return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.BGw) });
      AppMethodBeat.o(31074);
      return 0;
      if (1 == ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smi, 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label1876;
        }
        Log.i("MicroMsg.NetSceneUploadAppAttach", "NOT ALLOW USE PARALLEL UPLOAD APP ATTACH");
        i = 0;
        break;
      }
      label1876:
      bg.aVF();
      localObject1 = com.tencent.mm.model.c.aSQ().Hb(this.BGu.field_msgInfoId);
      if (((eo)localObject1).field_msgId != this.BGu.field_msgInfoId)
      {
        Log.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.BGu.field_msgInfoId), Long.valueOf(this.BGu.systemRowid), Long.valueOf(this.BGu.field_createTime), Long.valueOf(this.BGu.field_totalLen), Long.valueOf(this.BGu.field_status), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), this.BGu.field_mediaId });
        this.toUser = null;
        i = 0;
      }
      else
      {
        parami = "";
        if (!Util.isNullOrNil(((eo)localObject1).field_imgPath)) {
          parami = com.tencent.mm.av.q.bcR().Oz(((eo)localObject1).field_imgPath);
        }
        localObject2 = new com.tencent.mm.pluginsdk.f.d();
        ((com.tencent.mm.pluginsdk.f.d)localObject2).iXv = gnc();
        ((com.tencent.mm.pluginsdk.f.d)localObject2).JTT = this.iZw;
        ((com.tencent.mm.pluginsdk.f.d)localObject2).scene = 3;
        ((com.tencent.mm.pluginsdk.f.d)localObject2).fileType = 5;
        ((com.tencent.mm.pluginsdk.f.d)localObject2).thumbPath = parami;
        ((com.tencent.mm.pluginsdk.f.d)localObject2).fullPath = this.BGu.field_fileFullPath;
        localObject3 = new com.tencent.mm.pluginsdk.f.c();
        bg.aVF();
        localObject4 = com.tencent.mm.model.c.aSQ().Hb(this.BGu.field_msgInfoId);
        if (((eo)localObject4).field_msgId != this.BGu.field_msgInfoId)
        {
          Log.w("MicroMsg.NetSceneUploadAppAttach", "#parallel-upload# read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.BGu.field_msgInfoId), Long.valueOf(this.BGu.systemRowid), Long.valueOf(this.BGu.field_createTime), Long.valueOf(this.BGu.field_totalLen), Long.valueOf(this.BGu.field_status), Boolean.valueOf(this.BGu.field_isUpload), Integer.valueOf(this.BGu.field_isUseCdn), this.BGu.field_mediaId });
          this.toUser = null;
          parami = "";
          label2292:
          if (this.BGu == null) {
            break label2532;
          }
        }
        label2532:
        for (localObject1 = this.BGu.field_signature;; localObject1 = null)
        {
          ((com.tencent.mm.pluginsdk.f.c)localObject3).JTD = ((String)localObject1);
          ((com.tencent.mm.pluginsdk.f.c)localObject3).JTE = parami;
          ((com.tencent.mm.pluginsdk.f.c)localObject3).a((com.tencent.mm.pluginsdk.f.d)localObject2);
          this.JWN = true;
          i = 1;
          break;
          localObject1 = ((eo)localObject4).field_content;
          parami = (com.tencent.mm.ak.i)localObject1;
          if (ab.Eq(((eo)localObject4).field_talker))
          {
            i = bp.Kp(((eo)localObject4).field_content);
            parami = (com.tencent.mm.ak.i)localObject1;
            if (i != -1) {
              parami = (((eo)localObject4).field_content + " ").substring(i + 2).trim();
            }
          }
          this.dCN = k.b.HD(parami);
          if (((this.dCN != null) && (this.dCN.iwM != 0)) || (this.dCN.iwI > 26214400))
          {
            Log.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.dCN.iwW, Util.secPrint(this.dCN.aesKey), this.dCN.filemd5, Integer.valueOf(this.dCN.type) });
            parami = this.dCN.aesKey;
            break label2292;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
          parami = "";
          break label2292;
        }
      }
    }
    if (this.BGu.field_netTimes > 3200L)
    {
      m.HS(this.BGu.systemRowid);
      Log.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.apq() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.BGw);
      AppMethodBeat.o(31074);
      return -1;
    }
    parami = this.BGu;
    parami.field_netTimes += 1L;
    if (Util.isNullOrNil(this.BGu.field_clientAppDataId))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((this.BGu.field_totalLen <= 0L) || (this.BGu.field_totalLen > 26214400L))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.BGu.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (this.BGu.field_totalLen > 26214400L) {
        m.HS(this.BGu.systemRowid);
      }
      AppMethodBeat.o(31074);
      return -1;
    }
    if (Util.isNullOrNil(this.BGu.field_fileFullPath))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((int)com.tencent.mm.vfs.s.boW(this.BGu.field_fileFullPath) > 26214400)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      m.HS(this.BGu.systemRowid);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (Util.isNullOrNil(this.iwK)) {}
    for (parami = com.tencent.mm.vfs.s.aW(this.BGu.field_fileFullPath, (int)this.BGu.field_offset, 8192); Util.isNullOrNil(parami); parami = com.tencent.mm.vfs.s.aW(this.BGu.field_fileFullPath, (int)this.BGu.field_offset, 32768))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    Object localObject1 = (emy)this.rr.iLK.iLR;
    ((emy)localObject1).jfi = this.BGu.field_appId;
    ((emy)localObject1).KIy = ((int)this.BGu.field_sdkVer);
    ((emy)localObject1).NkS = this.BGu.field_clientAppDataId;
    ((emy)localObject1).oUv = ((int)this.BGu.field_type);
    ((emy)localObject1).UserName = z.aTY();
    ((emy)localObject1).BsF = ((int)this.BGu.field_totalLen);
    ((emy)localObject1).BsG = ((int)this.BGu.field_offset);
    if ((this.iwK != null) && (this.BiZ))
    {
      ((emy)localObject1).MD5 = this.iwK;
      ((emy)localObject1).BsF = ((int)this.BGu.field_totalLen);
      ((emy)localObject1).BsH = 0;
      ((emy)localObject1).BsI = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      this.BiZ = false;
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(31074);
      return i;
    }
    ((emy)localObject1).BsH = parami.length;
    ((emy)localObject1).BsI = new SKBuiltinBuffer_t().setBuffer(parami);
    if (this.iwK != null) {
      ((emy)localObject1).MD5 = this.iwK;
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(31074);
    return i;
  }
  
  final void e(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(31076);
    if (this.BGu.field_type != 2L)
    {
      AppMethodBeat.o(31076);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aXu().Fu("100131");
    if (localc.isValid()) {
      this.hmp = af.getInt((String)localc.gzz().get("needUploadData"), 1);
    }
    if ((this.hmn) || (this.hmp == 0))
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.hmq = paramd;
    this.hmn = true;
    paramd = new qx();
    EventCenter.instance.addListener(this.hms);
    paramd.dXu.filePath = this.BGu.field_fileFullPath;
    paramd.dXu.dDZ = System.currentTimeMillis();
    EventCenter.instance.publish(paramd);
    AppMethodBeat.o(31076);
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final long gnc()
  {
    if (this.BGu == null) {
      return 0L;
    }
    return this.BGu.field_msgInfoId;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31075);
    Log.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.iYT)))
    {
      Log.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.iYT });
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        h.CyF.a(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.BGu.field_totalLen - this.JWM) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31075);
      return;
    }
    paramString = (emz)((com.tencent.mm.ak.d)params).iLL.iLR;
    if ((paramString.jfi != null) && (this.iwK == null) && ((!paramString.jfi.equals(this.BGu.field_appId)) || (!paramString.NkS.equals(this.BGu.field_clientAppDataId))))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramString.BsF < 0) || (paramString.BsF != this.BGu.field_totalLen) || (paramString.BsG < 0) || (paramString.BsG > this.BGu.field_totalLen))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    this.BGu.field_offset = paramString.BsG;
    params = this.BGu;
    if (m.bdH(paramString.jfl)) {}
    for (paramString = paramString.jfl;; paramString = "")
    {
      params.field_mediaSvrId = paramString;
      if (this.BGu.field_status != 105L) {
        break;
      }
      Log.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.BGu.field_mediaSvrId + "," + this.BGu.field_offset + "] ");
      this.callback.onSceneEnd(paramInt2, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.BGu.field_offset == this.BGu.field_totalLen)
    {
      if (Util.isNullOrNil(this.BGu.field_mediaSvrId))
      {
        Log.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        this.callback.onSceneEnd(3, -1, "", this);
        m.HS(this.BGu.systemRowid);
        AppMethodBeat.o(31075);
        return;
      }
      this.BGu.field_status = 199L;
      h.CyF.a(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(Util.nowMilliSecond()), Integer.valueOf(com.tencent.mm.an.c.cY(MMApplicationContext.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.BGu.field_totalLen - this.JWM) });
    }
    boolean bool = ao.cgO().a(this.BGu, new String[0]);
    if (!bool)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      e(null);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.BGu.field_status == 199L)
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
  
  public final q.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return q.b.iMq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.aj
 * JD-Core Version:    0.7.0.1
 */