package com.tencent.mm.pluginsdk.model.app;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.q.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.i.g.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.exg;
import com.tencent.mm.protocal.protobuf.exh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;

public final class ak
  extends q
  implements com.tencent.mm.network.m
{
  private static final long QXm;
  private c HCz;
  private long QXf;
  private i callback;
  private Handler handler;
  private String id;
  private boolean lPF;
  private String lPn;
  private g.a lPx;
  private int mgo;
  private int retCode;
  private com.tencent.mm.an.d rr;
  private long startTime;
  private boolean uEa;
  private long uploadedSize;
  
  static
  {
    AppMethodBeat.i(31083);
    QXm = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vFD, 5) * 1000L;
    AppMethodBeat.o(31083);
  }
  
  public ak(String paramString, c paramc)
  {
    AppMethodBeat.i(31080);
    this.mgo = 8192;
    this.lPF = true;
    this.retCode = 0;
    this.handler = new a((byte)0);
    this.startTime = 0L;
    this.QXf = -1L;
    this.lPn = "";
    this.lPx = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, com.tencent.mm.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31077);
        paramAnonymousString = ak.a(ak.this);
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
          Log.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ak.a(ak.this) });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          AppMethodBeat.o(31077);
          return 0;
          bool1 = false;
          break;
        }
        label153:
        if (paramAnonymousInt != 0)
        {
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).io(ak.d(ak.this), "");
          AppMethodBeat.o(31077);
          return 0;
        }
        if (ak.e(ak.this).field_status == 105L)
        {
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "attach upload has paused, status:%d", new Object[] { Long.valueOf(ak.e(ak.this).field_status) });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          com.tencent.mm.aq.f.bkg().Vy(ak.a(ak.this));
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          ak.e(ak.this).field_lastModifyTime = Util.nowSecond();
          ak.e(ak.this).field_offset = paramAnonymousc.field_finishedLength;
          ak.a(ak.this, ak.e(ak.this).field_offset);
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label497;
          }
          Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.iUs });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).io(ak.d(ak.this), "");
        }
        for (;;)
        {
          AppMethodBeat.o(31077);
          return 0;
          label497:
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), Util.secPrint(ak.e(ak.this).field_signature) });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).ap(ak.d(ak.this), paramAnonymousd.field_fileId, paramAnonymousd.field_aesKey);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    paramc.field_offset = 0L;
    paramc.field_isUpload = true;
    paramc.field_status = 101L;
    paramc.field_netTimes = 0L;
    this.id = paramString;
    this.HCz = paramc;
    if (NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext())) {
      this.mgo = 32768;
    }
    paramString = new d.a();
    paramString.lBU = new exg();
    paramString.lBV = new exh();
    paramString.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString.funcId = 220;
    paramString.lBW = 105;
    paramString.respCmdId = 1000000105;
    this.rr = paramString.bgN();
    Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig new NetSceneUploadAppAttachForHandOff stack[%s]", new Object[] { Util.getStack() });
    AppMethodBeat.o(31080);
  }
  
  public static c a(HandOffFile paramHandOffFile)
  {
    AppMethodBeat.i(31079);
    c localc = new c();
    localc.field_totalLen = paramHandOffFile.getSize();
    localc.field_fileFullPath = paramHandOffFile.getFullPath();
    localc.field_sdkVer = 0L;
    localc.field_appId = "";
    localc.field_clientAppDataId = Util.nowMilliSecond();
    localc.field_type = 0L;
    localc.field_status = 200L;
    localc.field_isUpload = true;
    localc.field_createTime = cm.bfC();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_mediaSvrId = Util.nowMilliSecond();
    localc.field_isUseCdn = 0;
    AppMethodBeat.o(31079);
    return localc;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(31081);
    this.callback = parami;
    if (this.HCz.field_status != 101L)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.avD() + " summerbig get field_status failed status:" + this.HCz.field_status);
      AppMethodBeat.o(31081);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.QXf = this.HCz.field_offset;
    }
    Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { this.HCz.field_fileFullPath, Long.valueOf(this.HCz.field_totalLen), Boolean.valueOf(this.HCz.field_isUpload), Integer.valueOf(this.HCz.field_isUseCdn), Long.valueOf(this.HCz.field_type) });
    com.tencent.mm.aq.f.bkg();
    if ((!com.tencent.mm.aq.b.vQ(4)) && (this.HCz.field_isUseCdn != 1))
    {
      com.tencent.mm.aq.f.bkg();
      Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.aq.b.vQ(4)), Integer.valueOf(this.HCz.field_isUseCdn) });
      i = 0;
    }
    while (i != 0)
    {
      this.uEa = true;
      Message.obtain(this.handler, 1, this.id).sendToTarget();
      Log.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client");
      AppMethodBeat.o(31081);
      return 0;
      i = (int)u.bBQ(this.HCz.field_fileFullPath);
      this.lPn = com.tencent.mm.aq.c.a("upattach", this.HCz.field_createTime, z.bdN().field_username, "");
      Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.HCz.field_createTime), this.lPn });
      if (Util.isNullOrNil(this.lPn))
      {
        Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId failed not use cdn");
        i = 0;
      }
      else
      {
        parami = new com.tencent.mm.i.g();
        parami.taskName = "task_NetSceneUploadAppAttachForHandOff";
        int j = com.tencent.mm.i.a.MediaType_FILE;
        parami.field_appType = 0;
        parami.iUG = this.lPx;
        parami.field_mediaId = this.lPn;
        parami.field_fullpath = this.HCz.field_fileFullPath;
        parami.field_fileType = j;
        parami.field_priority = com.tencent.mm.i.a.iTU;
        parami.field_totalLen = i;
        parami.field_needStorage = false;
        parami.field_isStreamMedia = false;
        parami.field_enable_hitcheck = this.lPF;
        if (Util.isNullOrNil(parami.field_aesKey))
        {
          com.tencent.mm.aq.f.bkh();
          parami.field_aesKey = com.tencent.mm.aq.a.bjV();
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summersafecdn gen aesKey new[%s]", new Object[] { parami.field_aesKey });
        }
        Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.HCz.field_msgInfoId), parami.field_fullpath, Integer.valueOf(i), this.lPn, Integer.valueOf(parami.field_fileType), Boolean.valueOf(parami.field_enable_hitcheck), Boolean.valueOf(parami.field_onlycheckexist), Boolean.valueOf(parami.field_force_aeskeycdn), Boolean.valueOf(parami.field_trysafecdn), Util.secPrint(parami.field_aesKey), parami.field_filemd5, Util.secPrint(parami.field_svr_signature), Util.secPrint(parami.field_fake_bigfile_signature_aeskey), Util.secPrint(parami.field_fake_bigfile_signature) });
        if (!com.tencent.mm.aq.f.bkg().f(parami))
        {
          Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra addSendTask failed.");
          this.lPn = "";
          i = 0;
        }
        else
        {
          if (this.HCz.field_isUseCdn != 1) {
            this.HCz.field_isUseCdn = 1;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.lPn });
          i = 1;
        }
      }
    }
    if (this.HCz.field_netTimes > 3200L)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.avD() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR!");
      AppMethodBeat.o(31081);
      return -1;
    }
    parami = this.HCz;
    parami.field_netTimes += 1L;
    if (Util.isNullOrNil(this.HCz.field_clientAppDataId))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((this.HCz.field_totalLen <= 0L) || (this.HCz.field_totalLen > 26214400L))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.HCz.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if (Util.isNullOrNil(this.HCz.field_fileFullPath))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((int)u.bBQ(this.HCz.field_fileFullPath) > 26214400)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : file is too large");
      AppMethodBeat.o(31081);
      return -1;
    }
    parami = u.aY(this.HCz.field_fileFullPath, (int)this.HCz.field_offset, this.mgo);
    if (Util.isNullOrNil(parami))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    exg localexg = (exg)d.b.b(this.rr.lBR);
    localexg.lVG = this.HCz.field_appId;
    localexg.RJP = ((int)this.HCz.field_sdkVer);
    localexg.UxD = this.HCz.field_clientAppDataId;
    localexg.rWu = ((int)this.HCz.field_type);
    localexg.UserName = z.bcZ();
    localexg.HmZ = ((int)this.HCz.field_totalLen);
    localexg.Hna = ((int)this.HCz.field_offset);
    localexg.Hnb = parami.length;
    localexg.Hnc = new eae().dc(parami);
    Log.d("UploadAppAttach", String.format("AppId=%s, SdkVersion=%d, ClientAppDataId=%s, Type=%d, UserName=%s, TotalLen=%d, StartPos=%d", new Object[] { localexg.lVG, Integer.valueOf(localexg.RJP), localexg.UxD, Integer.valueOf(localexg.rWu), localexg.UserName, Integer.valueOf(localexg.HmZ), Integer.valueOf(localexg.Hna) }));
    this.uEa = true;
    if (!this.handler.hasMessages(1)) {
      Message.obtain(this.handler, 1, this.id).sendToTarget();
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(31081);
    return i;
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31082);
    Log.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.lPn)))
    {
      Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.lPn });
      this.uEa = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.uEa = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).io(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    paramString = (exh)d.c.b(((com.tencent.mm.an.d)params).lBS);
    if ((paramString.lVG != null) && ((!paramString.lVG.equals(this.HCz.field_appId)) || (!paramString.UxD.equals(this.HCz.field_clientAppDataId))))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "argument is not consistent");
      this.uEa = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).io(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramString.HmZ < 0) || (paramString.HmZ != this.HCz.field_totalLen) || (paramString.Hna < 0) || (paramString.Hna > this.HCz.field_totalLen))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "dataLen, startPos or totalLen is incorrect");
      this.uEa = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).io(this.id, "");
      AppMethodBeat.o(31082);
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
      Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd STATUS PAUSE [" + this.HCz.field_mediaSvrId + "," + this.HCz.field_offset + "] ");
      this.uEa = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if (this.HCz.field_offset == this.HCz.field_totalLen)
    {
      if (Util.isNullOrNil(this.HCz.field_mediaSvrId))
      {
        Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "finish upload but mediaid == null!");
        this.uEa = false;
        this.handler.removeMessages(1);
        ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).io(this.id, "");
        AppMethodBeat.o(31082);
        return;
      }
      this.HCz.field_status = 199L;
    }
    while (this.HCz.field_status == 199L)
    {
      this.uEa = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).e(this.id, this.HCz.field_appId, (int)this.HCz.field_sdkVer, this.HCz.field_mediaSvrId);
      AppMethodBeat.o(31082);
      return;
      this.uploadedSize = this.HCz.field_offset;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : doScene fail");
      this.uEa = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).io(this.id, "");
    }
    AppMethodBeat.o(31082);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final q.b securityVerificationChecked(s params)
  {
    return q.b.lCx;
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(31078);
      if ((paramMessage.what == 1) && (ak.f(ak.this)) && (ak.e(ak.this).field_status != 105L) && (((com.tencent.mm.plugin.handoff.a.a)h.ae(com.tencent.mm.plugin.handoff.a.a.class)).aA(ak.d(ak.this), ak.g(ak.this)))) {
        sendMessageDelayed(Message.obtain(this, 1, ak.d(ak.this)), ak.cfW());
      }
      AppMethodBeat.o(31078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak
 * JD-Core Version:    0.7.0.1
 */