package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.a.pj;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.g.a.pl.a;
import com.tencent.mm.g.c.du;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class ak
  extends n
  implements k
{
  private long BQw;
  com.tencent.mm.al.g callback;
  k.b dbE;
  private boolean fYD;
  int fYF;
  com.tencent.mm.i.d fYG;
  com.tencent.mm.sdk.b.c fYI;
  private String gHg;
  String hhN;
  private g.a hhW;
  boolean hie;
  int retCode;
  private com.tencent.mm.al.b rr;
  String sessionId;
  long startTime;
  String toUser;
  private boolean uFh;
  c uZZ;
  long vab;
  
  public ak(long paramLong, String paramString1, String paramString2)
  {
    AppMethodBeat.i(31073);
    this.uZZ = null;
    this.dbE = null;
    this.vab = -1L;
    this.gHg = null;
    this.uFh = true;
    this.hie = true;
    this.retCode = 0;
    this.startTime = 0L;
    this.BQw = -1L;
    this.hhN = "";
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, final int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, final com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31069);
        paramAnonymousString = ak.this.hhN;
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
          ad.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          ap.bxS().get(ak.this.vab, ak.this.uZZ);
          if (paramAnonymousInt != -21005) {
            break label155;
          }
          ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ak.this.hhN });
          AppMethodBeat.o(31069);
          return 0;
          bool1 = false;
          break;
        }
        label155:
        if (paramAnonymousInt != 0)
        {
          m.rO(ak.this.uZZ.systemRowid);
          ap.bxS().get(ak.this.vab, ak.this.uZZ);
          ak.this.uZZ.field_signature = "";
          paramAnonymousBoolean = ap.bxS().a(ak.this.uZZ, new String[0]);
          ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Long.valueOf(ak.this.vab), Boolean.valueOf(paramAnonymousBoolean) });
          ak.this.callback.onSceneEnd(3, paramAnonymousInt, "", ak.this);
          new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Integer.valueOf(0), "" })).aBj();
          AppMethodBeat.o(31069);
          return 0;
        }
        if (ak.this.uZZ.field_status == 105L)
        {
          ad.i("MicroMsg.NetSceneUploadAppAttach", "attach upload has paused, status:%d, rowid:%d", new Object[] { Long.valueOf(ak.this.uZZ.field_status), Long.valueOf(ak.this.vab) });
          com.tencent.mm.ao.f.awL().xK(ak.this.hhN);
          ak.this.callback.onSceneEnd(3, paramAnonymousInt, "attach  has paused, status" + ak.this.uZZ.field_status, ak.this);
          AppMethodBeat.o(31069);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          ak.this.uZZ.field_lastModifyTime = bt.aGK();
          ak.this.uZZ.field_offset = paramAnonymousc.field_finishedLength;
          paramAnonymousBoolean = ap.bxS().a(ak.this.uZZ, new String[0]);
          if (!paramAnonymousBoolean)
          {
            ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(paramAnonymousBoolean)));
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
          ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns });
          m.rO(ak.this.uZZ.systemRowid);
          ap.bxS().get(ak.this.vab, ak.this.uZZ);
          ak.this.uZZ.field_signature = "";
          paramAnonymousBoolean = ap.bxS().a(ak.this.uZZ, new String[0]);
          ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback startRet[%d] sceneResult.field_retCode[%d], rowid[%d], reset signature ret[%b]", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(paramAnonymousd.field_retCode), Long.valueOf(ak.this.vab), Boolean.valueOf(paramAnonymousBoolean) });
          paramAnonymousString = com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns });
          new com.tencent.mm.g.b.a.h(paramAnonymousString).aBj();
          new com.tencent.mm.g.b.a.f(paramAnonymousString).aBj();
          ak.this.callback.onSceneEnd(3, paramAnonymousd.field_retCode, "", ak.this);
        }
        for (;;)
        {
          AppMethodBeat.o(31069);
          return 0;
          label1037:
          ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bt.aGs(ak.this.uZZ.field_signature) });
          if (paramAnonymousBoolean)
          {
            if (paramAnonymousd.field_exist_whencheck)
            {
              az.aeS().a(new ac(ak.this.dbE, ak.this.uZZ.field_fileFullPath, ak.this.toUser, new ac.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, long paramAnonymous2Long)
                {
                  boolean bool = true;
                  AppMethodBeat.i(31064);
                  paramAnonymous2String2 = bt.aGs(paramAnonymous2String2);
                  String str1 = bt.aGs(paramAnonymous2String3);
                  String str2 = bt.aGs(paramAnonymous2String4);
                  String str3 = bt.aGs(paramAnonymous2String5);
                  if (ak.this.dbE == null) {}
                  for (;;)
                  {
                    ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, paramAnonymous2String2, str1, str2, str3, Boolean.valueOf(bool), Boolean.valueOf(ak.this.hie) });
                    if (!bt.isNullOrNil(paramAnonymous2String3))
                    {
                      ak.this.uZZ.field_signature = paramAnonymous2String3;
                      ak.this.uZZ.field_fakeAeskey = paramAnonymous2String4;
                      ak.this.uZZ.field_fakeSignature = paramAnonymous2String5;
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
              ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig upload check but not exist");
              az.aeS().a(new ac(null, ak.this.uZZ.field_fileFullPath, ak.this.toUser, new ac.a()
              {
                public final void a(String paramAnonymous2String1, String paramAnonymous2String2, String paramAnonymous2String3, String paramAnonymous2String4, String paramAnonymous2String5, long paramAnonymous2Long)
                {
                  AppMethodBeat.i(31066);
                  String str1 = bt.aGs(paramAnonymous2String2);
                  String str2 = bt.aGs(paramAnonymous2String3);
                  String str3 = bt.aGs(paramAnonymous2String4);
                  String str4 = bt.aGs(paramAnonymous2String5);
                  if (ak.this.dbE == null) {}
                  for (boolean bool = true;; bool = false)
                  {
                    ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig NetSceneCheckBigFileUpload not exist_whencheck call back new md5[%s], aesKey[%s], signature[%s], aesKey[%s], signature[%s], amc null[%b], enableHitcheck[%b]", new Object[] { paramAnonymous2String1, str1, str2, str3, str4, Boolean.valueOf(bool), Boolean.valueOf(ak.this.hie) });
                    if (!bt.isNullOrNil(paramAnonymous2String3))
                    {
                      ak.this.uZZ.field_signature = paramAnonymous2String3;
                      ak.this.uZZ.field_fakeAeskey = paramAnonymous2String4;
                      ak.this.uZZ.field_fakeSignature = paramAnonymous2String5;
                      ak.this.uZZ.field_lastModifyTime = bt.eGO();
                      if (ak.this.dbE != null)
                      {
                        ak.this.dbE.filemd5 = paramAnonymous2String1;
                        ak.this.dbE.fMw = paramAnonymous2String2;
                        ak.this.dbE.gHe = ((int)paramAnonymous2Long);
                        az.arV();
                        paramAnonymous2String1 = com.tencent.mm.model.c.apO().rm(ak.this.uZZ.field_msgInfoId);
                        paramAnonymous2String1.setContent(k.b.a(ak.this.dbE, null, null));
                        az.arV();
                        com.tencent.mm.model.c.apO().a(paramAnonymous2String1.field_msgId, paramAnonymous2String1);
                      }
                    }
                    ak.this.hie = false;
                    bool = ap.bxS().a(ak.this.uZZ, new String[0]);
                    if (bool) {
                      break;
                    }
                    ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
                    ak.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                    ak.this.callback.onSceneEnd(3, paramAnonymousInt, "", ak.this);
                    AppMethodBeat.o(31066);
                    return;
                  }
                  az.afE().ax(new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(31065);
                      ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene again");
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
        ak.this.uZZ.field_status = 199L;
        boolean bool = ap.bxS().a(ak.this.uZZ, new String[0]);
        if (!bool)
        {
          ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdnCallback onGYNetEnd update info ret:".concat(String.valueOf(bool)));
          ak.this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
          ak.this.callback.onSceneEnd(3, paramAnonymousInt, "", ak.this);
          AppMethodBeat.o(31070);
          return;
        }
        m.a(ak.this.uZZ.field_msgInfoId, ak.this.uZZ.field_mediaSvrId, paramAnonymousd, true);
        az.aeS().a(new ai(ak.this.uZZ.field_msgInfoId, true, paramAnonymousd, new ai.a()
        {
          public final void dm(int paramAnonymous2Int1, int paramAnonymous2Int2)
          {
            AppMethodBeat.i(31068);
            ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra NetSceneSendAppMsgForCdn callback %d,%d", new Object[] { Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
            if ((paramAnonymous2Int1 == 4) && (paramAnonymous2Int2 == 102))
            {
              az.afE().ax(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(31067);
                  ak.this.hie = false;
                  ak.this.uZZ.field_createTime = bt.eGO();
                  ak.this.uZZ.field_lastModifyTime = bt.aGK();
                  ak.this.uZZ.field_offset = 0L;
                  ak.this.uZZ.field_status = 101L;
                  boolean bool = ap.bxS().a(ak.this.uZZ, new String[0]);
                  ad.i("MicroMsg.NetSceneUploadAppAttach", "summersafecdn MM_ERR_GET_AESKEY_FAILED doScene again enableHitcheck[%b], ret[%b] new createtime:%d", new Object[] { Boolean.valueOf(ak.this.hie), Boolean.valueOf(bool), Long.valueOf(ak.this.uZZ.field_createTime) });
                  ak.this.doScene(ak.this.dispatcher(), ak.this.callback);
                  AppMethodBeat.o(31067);
                }
              });
              AppMethodBeat.o(31068);
              return;
            }
            new com.tencent.mm.g.b.a.h(com.tencent.mm.plugin.report.a.s(new Object[] { Integer.valueOf(paramAnonymous2Int2), Integer.valueOf(1), Long.valueOf(ak.this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(paramAnonymousd.field_fileLength), paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns })).aBj();
            if ((paramAnonymous2Int1 == 0) && (paramAnonymous2Int2 == 0)) {
              ak.this.d(paramAnonymousd);
            }
            ak.this.callback.onSceneEnd(paramAnonymous2Int1, paramAnonymous2Int2, "", ak.this);
            AppMethodBeat.o(31068);
          }
        }, ak.this.sessionId, ak.this.uZZ), 0);
        AppMethodBeat.o(31070);
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    this.fYD = false;
    this.fYF = 0;
    this.fYI = new com.tencent.mm.sdk.b.c()
    {
      private boolean a(pl paramAnonymouspl)
      {
        AppMethodBeat.i(31071);
        if (!paramAnonymouspl.dva.filePath.equals(ak.this.uZZ.field_fileFullPath))
        {
          AppMethodBeat.o(31071);
          return false;
        }
        localObject1 = "";
        try
        {
          localObject2 = URLEncoder.encode(paramAnonymouspl.dva.result, "UTF-8");
          localObject1 = localObject2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            Object localObject2;
            Object localObject3;
            com.tencent.mm.modelsns.f localf;
            ad.printErrStackTrace("MicroMsg.NetSceneUploadAppAttach", localUnsupportedEncodingException, "", new Object[0]);
            continue;
            localObject1 = ak.this.fYG.field_filemd5;
            continue;
            localObject1 = ak.this.fYG.field_fileId;
            continue;
            localObject1 = ak.this.fYG.field_aesKey;
          }
        }
        if (ak.this.fYF == 1)
        {
          az.arV();
          localObject3 = com.tencent.mm.model.c.apO().rm(ak.this.uZZ.field_msgInfoId);
          localf = new com.tencent.mm.modelsns.f();
          localf.o("20toUser", ak.this.toUser + ",");
          localf.o("21source", "4,");
          localf.o("22qrUrl", (String)localObject1 + ",");
          localObject2 = new StringBuilder();
          if (ak.this.fYG == null)
          {
            localObject1 = "";
            localf.o("23md5", (String)localObject1 + ",");
            localObject2 = new StringBuilder();
            if (ak.this.fYG != null) {
              break label491;
            }
            localObject1 = "";
            localf.o("24cdnFileId", (String)localObject1 + ",");
            localObject2 = new StringBuilder();
            if (ak.this.fYG != null) {
              break label505;
            }
            localObject1 = "";
            localf.o("25cdnAesKey", (String)localObject1 + ",");
            localObject2 = "";
            localObject1 = localObject2;
            if (((bl)localObject3).cxB())
            {
              localObject3 = k.b.rx(((du)localObject3).field_content);
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((k.b)localObject3).appId;
              }
            }
            localf.o("26appip", (String)localObject1 + ",");
            localf.o("27toUsersCount", com.tencent.mm.model.q.rY(ak.this.toUser) + ",");
            localf.o("28codeType", Integer.valueOf(paramAnonymouspl.dva.deB));
            ad.i("MicroMsg.NetSceneUploadAppAttach", "report qrCodeImgChatting(13628): " + localf.PW());
            com.tencent.mm.modelstat.o.J(13628, localf.toString());
          }
        }
        else
        {
          com.tencent.mm.sdk.b.a.ESL.d(ak.this.fYI);
          AppMethodBeat.o(31071);
          return false;
        }
      }
    };
    this.vab = paramLong;
    this.gHg = paramString1;
    this.sessionId = paramString2;
    paramString2 = new b.a();
    paramString2.gUU = new dgx();
    paramString2.gUV = new dgy();
    paramString2.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString2.funcId = 220;
    paramString2.reqCmdId = 105;
    paramString2.respCmdId = 1000000105;
    this.rr = paramString2.atI();
    ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig new NetSceneUploadAppAttach rowid[%d], emoticonmd5[%s], stack[%s]", new Object[] { Long.valueOf(paramLong), paramString1, bt.eGN() });
    AppMethodBeat.o(31073);
  }
  
  final void d(com.tencent.mm.i.d paramd)
  {
    AppMethodBeat.i(31076);
    if (this.uZZ.field_type != 2L)
    {
      AppMethodBeat.o(31076);
      return;
    }
    com.tencent.mm.storage.c localc = com.tencent.mm.model.c.d.aty().qu("100131");
    if (localc.isValid()) {
      this.fYF = ae.getInt((String)localc.eJy().get("needUploadData"), 1);
    }
    if ((this.fYD) || (this.fYF == 0))
    {
      AppMethodBeat.o(31076);
      return;
    }
    this.fYG = paramd;
    this.fYD = true;
    paramd = new pj();
    com.tencent.mm.sdk.b.a.ESL.c(this.fYI);
    paramd.duX.filePath = this.uZZ.field_fileFullPath;
    paramd.duX.dcQ = System.currentTimeMillis();
    com.tencent.mm.sdk.b.a.ESL.l(paramd);
    AppMethodBeat.o(31076);
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(31074);
    this.callback = paramg;
    this.uZZ = new c();
    if ((!ap.bxS().get(this.vab, this.uZZ)) || (this.uZZ == null))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.XJ() + " summerbig get info failed rowid:" + this.vab);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.uZZ = null;
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.uZZ.field_status != 101L)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.XJ() + " summerbig get field_status failed rowid:" + this.vab + " status:" + this.uZZ.field_status);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.eGO();
      this.BQw = this.uZZ.field_offset;
    }
    ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene rowid[%d], fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { Long.valueOf(this.vab), this.uZZ.field_fileFullPath, Long.valueOf(this.uZZ.field_totalLen), Boolean.valueOf(this.uZZ.field_isUpload), Integer.valueOf(this.uZZ.field_isUseCdn), Long.valueOf(this.uZZ.field_type) });
    if (bt.isNullOrNil(this.uZZ.field_appId))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : appId is null");
      if ((this.uZZ.field_type != 8L) && (this.uZZ.field_type != 6L))
      {
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        AppMethodBeat.o(31074);
        return -1;
      }
    }
    if ((this.uZZ.field_type == 8L) || (this.uZZ.field_type == 9L))
    {
      ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra cdn not support Emoji or voiceremind now type:%d", new Object[] { Long.valueOf(this.uZZ.field_type) });
      i = 0;
    }
    while (i != 0)
    {
      ad.d("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client rowid:%d", new Object[] { Long.valueOf(this.vab) });
      AppMethodBeat.o(31074);
      return 0;
      com.tencent.mm.ao.f.awL();
      if ((!com.tencent.mm.ao.b.nL(4)) && (this.uZZ.field_isUseCdn != 1))
      {
        com.tencent.mm.ao.f.awL();
        ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.ao.b.nL(4)), Integer.valueOf(this.uZZ.field_isUseCdn) });
        i = 0;
      }
      else
      {
        az.arV();
        bl localbl = com.tencent.mm.model.c.apO().rm(this.uZZ.field_msgInfoId);
        if (localbl.field_msgId != this.uZZ.field_msgInfoId)
        {
          ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra read msg info failed msgId[%d], rowid[%d], createtime[%d], len[%d], status[%d], upload[%b], useCdn[%d], mediaId[%s]", new Object[] { Long.valueOf(this.uZZ.field_msgInfoId), Long.valueOf(this.uZZ.systemRowid), Long.valueOf(this.uZZ.field_createTime), Long.valueOf(this.uZZ.field_totalLen), Long.valueOf(this.uZZ.field_status), Boolean.valueOf(this.uZZ.field_isUpload), Integer.valueOf(this.uZZ.field_isUseCdn), this.uZZ.field_mediaId });
          this.toUser = null;
          i = 0;
        }
        else
        {
          this.toUser = localbl.field_talker;
          paramg = "";
          if (!bt.isNullOrNil(localbl.field_imgPath)) {
            paramg = com.tencent.mm.aw.o.ayF().yg(localbl.field_imgPath);
          }
          int k = (int)i.aMN(paramg);
          int m = (int)i.aMN(this.uZZ.field_fileFullPath);
          if (k >= 262144)
          {
            ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra thumb[%s][%d] Too Big Not Use CDN TRANS", new Object[] { paramg, Integer.valueOf(k) });
            i = 0;
          }
          else
          {
            this.hhN = com.tencent.mm.ao.c.a("upattach", this.uZZ.field_createTime, localbl.field_talker, this.vab);
            ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.uZZ.field_createTime), this.hhN });
            if (bt.isNullOrNil(this.hhN))
            {
              ad.w("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra genClientId failed not use cdn rowid:%d", new Object[] { Long.valueOf(this.vab) });
              i = 0;
            }
            else
            {
              com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
              i = 0;
              String str = localbl.field_content;
              localObject = str;
              int j;
              if (w.pF(localbl.field_talker))
              {
                j = bi.uc(localbl.field_content);
                localObject = str;
                if (j != -1) {
                  localObject = (localbl.field_content + " ").substring(j + 2).trim();
                }
              }
              this.dbE = k.b.rx(bt.aGg((String)localObject));
              label1101:
              label1110:
              boolean bool;
              if (this.dbE != null)
              {
                ad.d("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra amc.cdnAttachUrl[%s], amc.aesKey[%s], amc.filemd5[%s], amc.type[%d]", new Object[] { this.dbE.gHt, bt.aGs(this.dbE.fMw), this.dbE.filemd5, Integer.valueOf(this.dbE.type) });
                localg.field_fileId = this.dbE.gHt;
                localg.field_aesKey = this.dbE.fMw;
                localg.field_filemd5 = this.dbE.filemd5;
                if ((this.dbE.gHi != 0) || (this.dbE.gHe > 26214400))
                {
                  i = 1;
                  if (i == 0) {
                    break label1536;
                  }
                  j = com.tencent.mm.i.a.fmX;
                  localg.field_appType = 0;
                  localg.fnH = this.hhW;
                  localg.field_mediaId = this.hhN;
                  localg.field_fullpath = this.uZZ.field_fileFullPath;
                  localg.field_thumbpath = paramg;
                  localg.field_fileType = j;
                  if (i == 0) {
                    break label1544;
                  }
                  localObject = bt.nullAsNil(this.uZZ.field_signature);
                  label1175:
                  localg.field_svr_signature = ((String)localObject);
                  if (i == 0) {
                    break label1551;
                  }
                  bool = bt.isNullOrNil(this.uZZ.field_signature);
                  label1198:
                  localg.field_onlycheckexist = bool;
                  localg.field_fake_bigfile_signature_aeskey = this.uZZ.field_fakeAeskey;
                  localg.field_fake_bigfile_signature = this.uZZ.field_fakeSignature;
                  localg.field_talker = localbl.field_talker;
                  localg.field_priority = com.tencent.mm.i.a.fmV;
                  localg.field_totalLen = m;
                  localg.field_needStorage = false;
                  localg.field_isStreamMedia = false;
                  localg.field_enable_hitcheck = this.hie;
                  if (!w.pF(localbl.field_talker)) {
                    break label1557;
                  }
                }
              }
              label1536:
              label1544:
              label1551:
              label1557:
              for (i = 1;; i = 0)
              {
                localg.field_chattype = i;
                localg.field_force_aeskeycdn = false;
                localg.field_trysafecdn = true;
                localg.field_bzScene = 0;
                ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d] thumb[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.uZZ.field_msgInfoId), localg.field_fullpath, Integer.valueOf(m), paramg, Integer.valueOf(k), this.hhN, Integer.valueOf(localg.field_fileType), Boolean.valueOf(localg.field_enable_hitcheck), Boolean.valueOf(localg.field_onlycheckexist), Boolean.valueOf(localg.field_force_aeskeycdn), Boolean.valueOf(localg.field_trysafecdn), bt.aGs(localg.field_aesKey), localg.field_filemd5, bt.aGs(localg.field_svr_signature), bt.aGs(localg.field_fake_bigfile_signature_aeskey), bt.aGs(localg.field_fake_bigfile_signature) });
                if (com.tencent.mm.ao.f.awL().e(localg)) {
                  break label1562;
                }
                ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra addSendTask failed.");
                this.hhN = "";
                i = 0;
                break;
                i = 0;
                break label1101;
                ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig cdntra parse content xml failed");
                break label1101;
                j = com.tencent.mm.i.a.MediaType_FILE;
                break label1110;
                localObject = "";
                break label1175;
                bool = false;
                break label1198;
              }
              label1562:
              if (this.uZZ.field_isUseCdn != 1)
              {
                this.uZZ.field_isUseCdn = 1;
                bool = ap.bxS().a(this.uZZ, new String[0]);
                if (!bool)
                {
                  ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn update info ret:".concat(String.valueOf(bool)));
                  this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
                  this.callback.onSceneEnd(3, -1, "", this);
                  i = 0;
                  continue;
                }
              }
              ad.i("MicroMsg.NetSceneUploadAppAttach", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.hhN });
              i = 1;
            }
          }
        }
      }
    }
    if (this.uZZ.field_netTimes > 3200L)
    {
      m.rO(this.uZZ.systemRowid);
      ad.e("MicroMsg.NetSceneUploadAppAttach", com.tencent.mm.compatible.util.f.XJ() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR! rowid:" + this.vab);
      AppMethodBeat.o(31074);
      return -1;
    }
    paramg = this.uZZ;
    paramg.field_netTimes += 1L;
    if (bt.isNullOrNil(this.uZZ.field_clientAppDataId))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((this.uZZ.field_totalLen <= 0L) || (this.uZZ.field_totalLen > 26214400L))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.uZZ.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (this.uZZ.field_totalLen > 26214400L) {
        m.rO(this.uZZ.systemRowid);
      }
      AppMethodBeat.o(31074);
      return -1;
    }
    if (bt.isNullOrNil(this.uZZ.field_fileFullPath))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    if ((int)i.aMN(this.uZZ.field_fileFullPath) > 26214400)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : file is too large");
      m.rO(this.uZZ.systemRowid);
      AppMethodBeat.o(31074);
      return -1;
    }
    if (bt.isNullOrNil(this.gHg)) {}
    for (paramg = i.aR(this.uZZ.field_fileFullPath, (int)this.uZZ.field_offset, 8192); bt.cw(paramg); paramg = i.aR(this.uZZ.field_fileFullPath, (int)this.uZZ.field_offset, 32768))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31074);
      return -1;
    }
    Object localObject = (dgx)this.rr.gUS.gUX;
    ((dgx)localObject).hnC = this.uZZ.field_appId;
    ((dgx)localObject).CyE = ((int)this.uZZ.field_sdkVer);
    ((dgx)localObject).Exi = this.uZZ.field_clientAppDataId;
    ((dgx)localObject).mBH = ((int)this.uZZ.field_type);
    ((dgx)localObject).mAQ = u.aqG();
    ((dgx)localObject).uKQ = ((int)this.uZZ.field_totalLen);
    ((dgx)localObject).uKR = ((int)this.uZZ.field_offset);
    if ((this.gHg != null) && (this.uFh))
    {
      ((dgx)localObject).MD5 = this.gHg;
      ((dgx)localObject).uKQ = ((int)this.uZZ.field_totalLen);
      ((dgx)localObject).uKS = 0;
      ((dgx)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
      this.uFh = false;
      i = dispatch(parame, this.rr, this);
      AppMethodBeat.o(31074);
      return i;
    }
    ((dgx)localObject).uKS = paramg.length;
    ((dgx)localObject).uKT = new SKBuiltinBuffer_t().setBuffer(paramg);
    if (this.gHg != null) {
      ((dgx)localObject).MD5 = this.gHg;
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(31074);
    return i;
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31075);
    ad.d("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.hhN)))
    {
      ad.w("MicroMsg.NetSceneUploadAppAttach", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hhN });
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      if (paramInt2 == 4) {
        com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.uZZ.field_totalLen - this.BQw) });
      }
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(31075);
      return;
    }
    paramString = (dgy)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramString.hnC != null) && (this.gHg == null) && ((!paramString.hnC.equals(this.uZZ.field_appId)) || (!paramString.Exi.equals(this.uZZ.field_clientAppDataId))))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "argument is not consistent");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if ((paramString.uKQ < 0) || (paramString.uKQ != this.uZZ.field_totalLen) || (paramString.uKR < 0) || (paramString.uKR > this.uZZ.field_totalLen))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "dataLen, startPos or totalLen is incorrect");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    this.uZZ.field_offset = paramString.uKR;
    paramq = this.uZZ;
    if (m.aAT(paramString.hnF)) {}
    for (paramString = paramString.hnF;; paramString = "")
    {
      paramq.field_mediaSvrId = paramString;
      if (this.uZZ.field_status != 105L) {
        break;
      }
      ad.w("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd STATUS PAUSE [" + this.uZZ.field_mediaSvrId + "," + this.uZZ.field_offset + "] ");
      this.callback.onSceneEnd(paramInt2, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.uZZ.field_offset == this.uZZ.field_totalLen)
    {
      if (bt.isNullOrNil(this.uZZ.field_mediaSvrId))
      {
        ad.e("MicroMsg.NetSceneUploadAppAttach", "finish upload but mediaid == null!");
        this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
        this.callback.onSceneEnd(3, -1, "", this);
        m.rO(this.uZZ.systemRowid);
        AppMethodBeat.o(31075);
        return;
      }
      this.uZZ.field_status = 199L;
      com.tencent.mm.plugin.report.service.h.vKh.f(10420, new Object[] { Integer.valueOf(0), Integer.valueOf(1), Long.valueOf(this.startTime), Long.valueOf(bt.eGO()), Integer.valueOf(com.tencent.mm.ao.c.cu(aj.getContext())), Integer.valueOf(com.tencent.mm.i.a.MediaType_FILE), Long.valueOf(this.uZZ.field_totalLen - this.BQw) });
    }
    boolean bool = ap.bxS().a(this.uZZ, new String[0]);
    if (!bool)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttach", "onGYNetEnd update info ret:".concat(String.valueOf(bool)));
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      d(null);
      this.callback.onSceneEnd(3, -1, "", this);
      AppMethodBeat.o(31075);
      return;
    }
    if (this.uZZ.field_status == 199L)
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
    return n.b.gVB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak
 * JD-Core Version:    0.7.0.1
 */