package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.g.a.pu.a;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bo;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class ak
  extends n
  implements k
{
  private long DiL;
  k.b cZd;
  com.tencent.mm.ak.g callback;
  private boolean gdj;
  int gdl;
  com.tencent.mm.i.d gdm;
  com.tencent.mm.sdk.b.c gdo;
  boolean hIH;
  String hIq;
  private g.a hIz;
  private String hhH;
  int retCode;
  private com.tencent.mm.ak.b rr;
  String sessionId;
  long startTime;
  String toUser;
  private boolean vNY;
  c wiN;
  long wiP;
  
  public ak(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31073);
    this.wiN = null;
    this.cZd = null;
    this.wiP = -1L;
    this.hhH = null;
    this.vNY = true;
    this.hIH = true;
    this.retCode = 0;
    this.startTime = 0L;
    this.DiL = -1L;
    this.hIq = "";
    this.hIz = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31069);
        paramAnonymousString = ak.this.hIq;
        boolean bool1;
        if (paramAnonymousc != null)
        {
          bool1 = true;
          if (paramAnonymousd == null) {
            break label149;
          }
        }
        label149:
        for (boolean bool2 = true;; bool2 = false)
        {
          com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          ap.bEO().get(ak.this.wiP, ak.this.wiN);
          if (paramAnonymousInt != -21005) {
            break label155;
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ak.this.hIq });
          AppMethodBeat.o(31069);
          return 0;
          bool1 = false;
          break;
        }
        label155:
        if (paramAnonymousInt != 0)
        {
          m.wr(ak.this.wiN.systemRowid);
          ap.bEO().get(ak.this.wiP, ak.this.wiN);
          ak.this.wiN.field_signature = "";
          paramAnonymousBoolean = ap.bEO().a(ak.this.wiN, new String[0]);
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(ak.this.wiP), Boolean.valueOf(paramAnonymousBoolean) });
          ak.this.callback.onSceneEnd(3, paramAnonymousInt, "", ak.this);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aHZ();
          AppMethodBeat.o(31069);
          return 0;
        }
        if (ak.this.wiN.field_status == 105L)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(ak.this.wiN.field_status), Long.valueOf(ak.this.wiP) });
          com.tencent.mm.an.f.aDD().BQ(ak.this.hIq);
          ak.this.callback.onSceneEnd(3, paramAnonymousInt, "attach  has paused, status" + ak.this.wiN.field_status, ak.this);
          AppMethodBeat.o(31069);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          ak.this.wiN.field_lastModifyTime = bs.aNx();
          ak.this.wiN.field_offset = paramAnonymousc.field_finishedLength;
          paramAnonymousBoolean = ap.bEO().a(ak.this.wiN, new String[0]);
          if (!paramAnonymousBoolean)
          {
            com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(paramAnonymousBoolean)));
            ak.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
            ak.this.callback.onSceneEnd(3, paramAnonymousInt, "", ak.this);
            AppMethodBeat.o(31069);
            return 0;
          }
          AppMethodBeat.o(31069);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label1037;
          }
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM });
          m.wr(ak.this.wiN.systemRowid);
          ap.bEO().get(ak.this.wiP, ak.this.wiN);
          ak.this.wiN.field_signature = "";
          paramAnonymousBoolean = ap.bEO().a(ak.this.wiN, new String[0]);
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(ak.this.wiP), Boolean.valueOf(paramAnonymousBoolean) });
          paramAnonymousString = com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM });
          new com.tencent.mm.g.b.a.h(paramAnonymousString).aHZ();
          new com.tencent.mm.g.b.a.f(paramAnonymousString).aHZ();
          ak.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", ak.this);
        }
        for (;;)
        {
          AppMethodBeat.o(31069);
          return 0;
          label1037:
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bs.aLJ(ak.this.wiN.field_signature) });
          if (paramAnonymousBoolean)
          {
            if (paramAnonymousd.field_exist_whencheck)
            {
              az.agi().a(new ac(ak.this.cZd, ak.this.wiN.field_fileFullPath, ak.this.toUser, new ac.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, long paramAnonymous2Long)
                {
                  boolean bool = true;
                  AppMethodBeat.i(31064);
                  paramAnonymous2String2 = bs.aLJ(paramAnonymous2String2);
                  String str1 = bs.aLJ(paramAnonymous2String3);
                  String str2 = bs.aLJ(paramAnonymous2String4);
                  String str3 = bs.aLJ(paramAnonymous2String5);
                  if (ak.this.cZd == null) {}
                  for (;;)
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(ak.this.hIH) });
                    if (!bs.isNullOrNil(paramAnonymous2String3))
                    {
                      ak.this.wiN.field_signature = paramAnonymous2String3;
                      ak.this.wiN.field_fakeAeskey = paramAnonymous2String4;
                      ak.this.wiN.field_fakeSignature = paramAnonymous2String5;
                    }
                    ak.1.this.a(paramAnonymousInt, paramAnonymousd);
                    AppMethodBeat.o(31064);
                    return;
                    bool = false;
                  }
                }
              }), 0);
            }
            else
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
              az.agi().a(new ac(null, ak.this.wiN.field_fileFullPath, ak.this.toUser, new ac.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(31066);
                  String str1 = bs.aLJ(paramAnonymous2String2);
                  String str2 = bs.aLJ(paramAnonymous2String3);
                  String str3 = bs.aLJ(paramAnonymous2String4);
                  String str4 = bs.aLJ(paramAnonymous2String5);
                  if (ak.this.cZd == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(ak.this.hIH) });
                    if (!bs.isNullOrNil(paramAnonymous2String3))
                    {
                      ak.this.wiN.field_signature = paramAnonymous2String3;
                      ak.this.wiN.field_fakeAeskey = paramAnonymous2String4;
                      ak.this.wiN.field_fakeSignature = paramAnonymous2String5;
                      ak.this.wiN.field_lastModifyTime = bs.eWj();
                      if (ak.this.cZd != null)
                      {
                        ak.this.cZd.filemd5 = paramAnonymous2String1;
                        ak.this.cZd.fQi = paramAnonymous2String2;
                        ak.this.cZd.hhF = ((int)paramAnonymous2Long);
                        az.ayM();
                        paramAnonymous2String1 = com.tencent.mm.model.c.awD().vP(ak.this.wiN.field_msgInfoId);
                        paramAnonymous2String1.setContent(k.b.a(ak.this.cZd, null, null));
                        az.ayM();
                        com.tencent.mm.model.c.awD().a(paramAnonymous2String1.field_msgId, paramAnonymous2String1);
                      }
                    }
                    ak.this.hIH = false;
                    bool = ap.bEO().a(ak.this.wiN, new String[0]);
                    if (bool) {
                      break;
                    }
                    com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
                    ak.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    ak.this.callback.onSceneEnd(3, paramAnonymousInt, "", ak.this);
                    AppMethodBeat.o(31066);
                    return;
                  }
                  az.agU().az(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(31065);
                      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
                      ak.this.doScene(ak.this.dispatcher(), ak.this.callback);
                      AppMethodBeat.o(31065);
                    }
                  });
                  AppMethodBeat.o(31066);
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
        AppMethodBeat.i(31070);
        ak.this.wiN.field_status = 199L;
        boolean bool = ap.bEO().a(ak.this.wiN, new String[0]);
        if (!bool)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          ak.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          ak.this.callback.onSceneEnd(3, paramAnonymousInt, "", ak.this);
          AppMethodBeat.o(31070);
          return;
        }
        m.a(ak.this.wiN.field_msgInfoId, ak.this.wiN.field_mediaSvrId, paramAnonymousd, true);
        az.agi().a(new ai(ak.this.wiN.field_msgInfoId, true, paramAnonymousd, new ai.a()
        {
          public final void dm(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(31068);
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              az.agU().az(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(31067);
                  ak.this.hIH = false;
                  ak.this.wiN.field_createTime = bs.eWj();
                  ak.this.wiN.field_lastModifyTime = bs.aNx();
                  ak.this.wiN.field_offset = 0L;
                  ak.this.wiN.field_status = 101L;
                  boolean bool = ap.bEO().a(ak.this.wiN, new String[0]);
                  com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(ak.this.hIH), Boolean.valueOf(bool), Long.valueOf(ak.this.wiN.field_createTime) });
                  ak.this.doScene(ak.this.dispatcher(), ak.this.callback);
                  AppMethodBeat.o(31067);
                }
              });
              AppMethodBeat.o(31068);
              return;
            }
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.u(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM })).aHZ();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              ak.this.e(paramAnonymousd);
            }
            ak.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ak.this);
            AppMethodBeat.o(31068);
          }
        }, ak.this.sessionId, ak.this.wiN), 0);
        AppMethodBeat.o(31070);
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.gdj = false;
    this.gdl = 0;
    this.gdo = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(pu paramAnonymouspu)
      {
        AppMethodBeat.i(31071);
        if (!paramAnonymouspu.dsM.filePath.equals(ak.this.wiN.field_fileFullPath))
        {
          AppMethodBeat.o(31071);
          return false;
        }
        localObject1 = "";
        try
        {
          localObject2 = URLEncoder.encode(paramAnonymouspu.dsM.result, "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            com.tencent.mm.modelsns.f localf;
            com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            localObject1 = ak.this.gdm.field_filemd5;
            continue;
            localObject1 = ak.this.gdm.field_fileId;
            continue;
            localObject1 = ak.this.gdm.field_aesKey;
          }
        }
        if (ak.this.gdl == 1)
        {
          az.ayM();
          localObject3 = com.tencent.mm.model.c.awD().vP(ak.this.wiN.field_msgInfoId);
          localf = new com.tencent.mm.modelsns.f();
          localf.n("20toUser", ak.this.toUser + ",");
          localf.n("21source", "4,");
          localf.n("22qrUrl", (String)localObject1 + ",");
          localObject2 = new StringBuilder();
          if (ak.this.gdm == null)
          {
            localObject1 = "";
            localf.n("23md5", (String)localObject1 + ",");
            localObject2 = new StringBuilder();
            if (ak.this.gdm != null) {
              break label491;
            }
            localObject1 = "";
            localf.n("24cdnFileId", (String)localObject1 + ",");
            localObject2 = new StringBuilder();
            if (ak.this.gdm != null) {
              break label505;
            }
            localObject1 = "";
            localf.n("25cdnAesKey", (String)localObject1 + ",");
            localObject2 = "";
            localObject1 = localObject2;
            if (((bo)localObject3).cKN())
            {
              localObject3 = k.b.vA(((dy)localObject3).field_content);
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((k.b)localObject3).appId;
              }
            }
            localf.n("26appip", (String)localObject1 + ",");
            localf.n("27toUsersCount", com.tencent.mm.model.q.wb(ak.this.toUser) + ",");
            localf.n("28codeType", Integer.valueOf(paramAnonymouspu.dsM.dbX));
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + localf.PS());
            com.tencent.mm.modelstat.o.K(13628, localf.toString());
          }
        }
        else
        {
          com.tencent.mm.sdk.b.a.GpY.d(ak.this.gdo);
          AppMethodBeat.o(31071);
          return false;
        }
      }
    };
    this.wiP = paramLong;
    this.hhH = paramString1;
    this.sessionId = paramString2;
    paramString2 = new b.a();
    paramString2.hvt = new dmm();
    paramString2.hvu = new dmn();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.funcId = 220;
    paramString2.reqCmdId = 105;
    paramString2.respCmdId = 1000000105;
    this.rr = paramString2.aAz();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bs.eWi() });
    AppMethodBeat.o(31073);
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(31074);
    this.callback = paramg;
    this.wiN = new c();
    if ((!ap.bEO().get(this.wiP, this.wiN)) || (this.wiN == null))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.YG() + " summerbig get info failed rowid:" + this.wiP);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.wiN = null;
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.wiN.field_status != 101L)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.YG() + " summerbig get field_status failed rowid:" + this.wiP + " status:" + this.wiN.field_status);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bs.eWj();
      this.DiL = this.wiN.field_offset;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.wiP), this.wiN.field_fileFullPath, Long.valueOf(this.wiN.field_totalLen), Boolean.valueOf(this.wiN.field_isUpload), Integer.valueOf(this.wiN.field_isUseCdn), Long.valueOf(this.wiN.field_type) });
    if (bs.isNullOrNil(this.wiN.field_appId))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.wiN.field_type != 8L) && (this.wiN.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
    }
    if ((this.wiN.field_type == 8L) || (this.wiN.field_type == 9L))
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.wiN.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.wiP) });
      AppMethodBeat.o(31074);
      return 0;
      com.tencent.mm.an.f.aDD();
      if ((!com.tencent.mm.an.b.oz(4)) && (this.wiN.field_isUseCdn != 1))
      {
        com.tencent.mm.an.f.aDD();
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.oz(4)), Integer.valueOf(this.wiN.field_isUseCdn) });
        i = 0;
      }
      else
      {
        az.ayM();
        bo localbo = com.tencent.mm.model.c.awD().vP(this.wiN.field_msgInfoId);
        if (localbo.field_msgId != this.wiN.field_msgInfoId)
        {
          com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.wiN.field_msgInfoId), Long.valueOf(this.wiN.systemRowid), Long.valueOf(this.wiN.field_createTime), Long.valueOf(this.wiN.field_totalLen), Long.valueOf(this.wiN.field_status), Boolean.valueOf(this.wiN.field_isUpload), Integer.valueOf(this.wiN.field_isUseCdn), this.wiN.field_mediaId });
          this.toUser = null;
          i = 0;
        }
        else
        {
          this.toUser = localbo.field_talker;
          paramg = "";
          if (!bs.isNullOrNil(localbo.field_imgPath)) {
            paramg = com.tencent.mm.av.o.aFx().Cl(localbo.field_imgPath);
          }
          int k = (int)i.aSp(paramg);
          int m = (int)i.aSp(this.wiN.field_fileFullPath);
          if (k >= 262144)
          {
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { paramg, Integer.valueOf(k) });
            i = 0;
          }
          else
          {
            this.hIq = com.tencent.mm.an.c.a("upattach", this.wiN.field_createTime, localbo.field_talker, this.wiP);
            com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.wiN.field_createTime), this.hIq });
            if (bs.isNullOrNil(this.hIq))
            {
              com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.wiP) });
              i = 0;
            }
            else
            {
              com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
              i = 0;
              String str = localbo.field_content;
              localObject = str;
              int j;
              if (w.sQ(localbo.field_talker))
              {
                j = bi.yi(localbo.field_content);
                localObject = str;
                if (j != -1) {
                  localObject = (localbo.field_content + " ").substring(j + 2).trim();
                }
              }
              this.cZd = k.b.vA(bs.aLx((String)localObject));
              label1097:
              label1106:
              boolean bool;
              if (this.cZd != null)
              {
                com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.cZd.hhU, bs.aLJ(this.cZd.fQi), this.cZd.filemd5, Integer.valueOf(this.cZd.type) });
                localg.field_fileId = this.cZd.hhU;
                localg.field_aesKey = this.cZd.fQi;
                localg.field_filemd5 = this.cZd.filemd5;
                if ((this.cZd.hhJ != 0) || (this.cZd.hhF > 26214400))
                {
                  i = 1;
                  if (i == 0) {
                    break label1532;
                  }
                  j = com.tencent.mm.i.a.fqr;
                  localg.field_appType = 0;
                  localg.frb = this.hIz;
                  localg.field_mediaId = this.hIq;
                  localg.field_fullpath = this.wiN.field_fileFullPath;
                  localg.field_thumbpath = paramg;
                  localg.field_fileType = j;
                  if (i == 0) {
                    break label1540;
                  }
                  localObject = bs.nullAsNil(this.wiN.field_signature);
                  label1171:
                  localg.field_svr_signature = ((String)localObject);
                  if (i == 0) {
                    break label1547;
                  }
                  bool = bs.isNullOrNil(this.wiN.field_signature);
                  label1194:
                  localg.field_onlycheckexist = bool;
                  localg.field_fake_bigfile_signature_aeskey = this.wiN.field_fakeAeskey;
                  localg.field_fake_bigfile_signature = this.wiN.field_fakeSignature;
                  localg.field_talker = localbo.field_talker;
                  localg.field_priority = com.tencent.mm.i.a.fqp;
                  localg.field_totalLen = m;
                  localg.field_needStorage = false;
                  localg.field_isStreamMedia = false;
                  localg.field_enable_hitcheck = this.hIH;
                  if (!w.sQ(localbo.field_talker)) {
                    break label1553;
                  }
                }
              }
              label1540:
              label1547:
              label1553:
              for (i = 1;; i = 0)
              {
                localg.field_chattype = i;
                localg.field_force_aeskeycdn = false;
                localg.field_trysafecdn = true;
                localg.field_bzScene = 0;
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.wiN.field_msgInfoId), localg.field_fullpath, Integer.valueOf(m), paramg, Integer.valueOf(k), this.hIq, Integer.valueOf(localg.field_fileType), Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_onlycheckexist), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), bs.aLJ(localg.field_aesKey), localg.field_filemd5, bs.aLJ(localg.field_svr_signature), bs.aLJ(localg.field_fake_bigfile_signature_aeskey), bs.aLJ(localg.field_fake_bigfile_signature) });
                if (com.tencent.mm.an.f.aDD().f(localg)) {
                  break label1558;
                }
                com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                this.hIq = "";
                i = 0;
                break;
                i = 0;
                break label1097;
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                break label1097;
                label1532:
                j = com.tencent.mm.i.a.MediaType_FILE;
                break label1106;
                localObject = "";
                break label1171;
                bool = false;
                break label1194;
              }
              label1558:
              if (this.wiN.field_isUseCdn != 1)
              {
                this.wiN.field_isUseCdn = 1;
                bool = ap.bEO().a(this.wiN, new String[0]);
                if (!bool)
                {
                  com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
                  this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                  this.callback.onSceneEnd(3, -1, "", this);
                  i = 0;
                  continue;
                }
              }
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.hIq });
              i = 1;
            }
          }
        }
      }
    }
    if (this.wiN.field_netTimes > 3200L)
    {
      m.wr(this.wiN.systemRowid);
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.YG() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.wiP);
      AppMethodBeat.o(31074);
      return -1;
    }
    paramg = this.wiN;
    paramg.field_netTimes += 1L;
    if (bs.isNullOrNil(this.wiN.field_clientAppDataId))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((this.wiN.field_totalLen <= 0L) || (this.wiN.field_totalLen > 26214400L))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.wiN.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (this.wiN.field_totalLen > 26214400L) {
        m.wr(this.wiN.systemRowid);
      }
      AppMethodBeat.o(31074);
      return -1;
    }
    if (bs.isNullOrNil(this.wiN.field_fileFullPath))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((int)i.aSp(this.wiN.field_fileFullPath) > 26214400)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      m.wr(this.wiN.systemRowid);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (bs.isNullOrNil(this.hhH)) {}
    for (paramg = i.aU(this.wiN.field_fileFullPath, (int)this.wiN.field_offset, 8192); bs.cv(paramg); paramg = i.aU(this.wiN.field_fileFullPath, (int)this.wiN.field_offset, 32768))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    Object localObject = (dmm)this.rr.hvr.hvw;
    ((dmm)localObject).hOf = this.wiN.field_appId;
    ((dmm)localObject).DRa = ((int)this.wiN.field_sdkVer);
    ((dmm)localObject).FUk = this.wiN.field_clientAppDataId;
    ((dmm)localObject).ndI = ((int)this.wiN.field_type);
    ((dmm)localObject).ncR = u.axw();
    ((dmm)localObject).vTH = ((int)this.wiN.field_totalLen);
    ((dmm)localObject).vTI = ((int)this.wiN.field_offset);
    if ((this.hhH != null) && (this.vNY))
    {
      ((dmm)localObject).MD5 = this.hhH;
      ((dmm)localObject).vTH = ((int)this.wiN.field_totalLen);
      ((dmm)localObject).vTJ = 0;
      ((dmm)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      this.vNY = false;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(31074);
      return i;
    }
    ((dmm)localObject).vTJ = paramg.length;
    ((dmm)localObject).vTK = new SKBuiltinBuffer_t().setBuffer(paramg);
    if (this.hhH != null) {
      ((dmm)localObject).MD5 = this.hhH;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(31074);
    return i;
  }
  
  final void e(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(31076);
    if (this.wiN.field_type != 2L)
    {
      AppMethodBeat.o(31076);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aAp().tJ("100131");
    if (localc.isValid()) {
      this.gdl = ae.getInt((String)localc.eYV().get("needUploadData"), 1);
    }
    if ((this.gdj) || (this.gdl == 0))
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.gdm = paramd;
    this.gdj = true;
    paramd = new ps();
    com.tencent.mm.sdk.b.a.GpY.c(this.gdo);
    paramd.dsJ.filePath = this.wiN.field_fileFullPath;
    paramd.dsJ.dao = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.GpY.l(paramd);
    AppMethodBeat.o(31076);
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31075);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bs.isNullOrNil(this.hIq)))
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hIq });
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.wiN.field_totalLen - this.DiL) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31075);
      return;
    }
    paramString = (dmn)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramString.hOf != null) && (this.hhH == null) && ((!paramString.hOf.equals(this.wiN.field_appId)) || (!paramString.FUk.equals(this.wiN.field_clientAppDataId))))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramString.vTH < 0) || (paramString.vTH != this.wiN.field_totalLen) || (paramString.vTI < 0) || (paramString.vTI > this.wiN.field_totalLen))
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    this.wiN.field_offset = paramString.vTI;
    paramq = this.wiN;
    if (m.aGl(paramString.hOi)) {}
    for (paramString = paramString.hOi;; paramString = "")
    {
      paramq.field_mediaSvrId = paramString;
      if (this.wiN.field_status != 105L) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.wiN.field_mediaSvrId + "," + this.wiN.field_offset + "] ");
      this.callback.onSceneEnd(paramInt2, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.wiN.field_offset == this.wiN.field_totalLen)
    {
      if (bs.isNullOrNil(this.wiN.field_mediaSvrId))
      {
        com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        this.callback.onSceneEnd(3, -1, "", this);
        m.wr(this.wiN.systemRowid);
        AppMethodBeat.o(31075);
        return;
      }
      this.wiN.field_status = 199L;
      com.tencent.mm.plugin.report.service.h.wUl.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bs.eWj()), Integer.valueOf(com.tencent.mm.an.c.cD(com.tencent.mm.sdk.platformtools.ai.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.wiN.field_totalLen - this.DiL) });
    }
    boolean bool = ap.bEO().a(this.wiN, new String[0]);
    if (!bool)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      e(null);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.wiN.field_status == 199L)
    {
      this.callback.onSceneEnd(0, 0, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : doScene fail");
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
    return n.b.hwa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak
 * JD-Core Version:    0.7.0.1
 */