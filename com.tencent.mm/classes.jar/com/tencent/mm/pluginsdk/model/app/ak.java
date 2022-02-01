package com.tencent.mm.pluginsdk.model.app;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.protocal.protobuf.dse;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;

public final class ak
  extends n
  implements k
{
  private static final long ENG;
  private long ENy;
  private com.tencent.mm.al.f callback;
  private Handler handler;
  private String ibe;
  private g.a ibn;
  private boolean ibv;
  private String id;
  private int isH;
  private boolean pDT;
  private int retCode;
  private com.tencent.mm.al.b rr;
  private long startTime;
  private long uDQ;
  private c xqy;
  
  static
  {
    AppMethodBeat.i(31083);
    ENG = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qyo, 5) * 1000L;
    AppMethodBeat.o(31083);
  }
  
  public ak(String paramString, c paramc)
  {
    AppMethodBeat.i(31080);
    this.isH = 8192;
    this.ibv = true;
    this.retCode = 0;
    this.handler = new a((byte)0);
    this.startTime = 0L;
    this.ENy = -1L;
    this.ibe = "";
    this.ibn = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
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
          ad.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ak.a(ak.this) });
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
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hr(ak.d(ak.this), "");
          AppMethodBeat.o(31077);
          return 0;
        }
        if (ak.e(ak.this).field_status == 105L)
        {
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "attach upload has paused, status:%d", new Object[] { Long.valueOf(ak.e(ak.this).field_status) });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          com.tencent.mm.ao.f.aGI().EP(ak.a(ak.this));
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          ak.e(ak.this).field_lastModifyTime = bt.aQJ();
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
          ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fIT });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hr(ak.d(ak.this), "");
        }
        for (;;)
        {
          AppMethodBeat.o(31077);
          return 0;
          label497:
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bt.aRp(ak.e(ak.this).field_signature) });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).an(ak.d(ak.this), paramAnonymousd.field_fileId, paramAnonymousd.field_aesKey);
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
    this.xqy = paramc;
    if (ay.iY(aj.getContext())) {
      this.isH = 32768;
    }
    paramString = new com.tencent.mm.al.b.a();
    paramString.hNM = new dsd();
    paramString.hNN = new dse();
    paramString.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString.funcId = 220;
    paramString.hNO = 105;
    paramString.respCmdId = 1000000105;
    this.rr = paramString.aDC();
    ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig new NetSceneUploadAppAttachForHandOff stack[%s]", new Object[] { bt.flS() });
    AppMethodBeat.o(31080);
  }
  
  public static c a(HandOffFile paramHandOffFile)
  {
    AppMethodBeat.i(31079);
    c localc = new c();
    localc.field_totalLen = paramHandOffFile.size;
    localc.field_fileFullPath = paramHandOffFile.hdP;
    localc.field_sdkVer = 0L;
    localc.field_appId = "";
    localc.field_clientAppDataId = bt.flT();
    localc.field_type = 0L;
    localc.field_status = 200L;
    localc.field_isUpload = true;
    localc.field_createTime = bt.flT();
    localc.field_lastModifyTime = bt.aQJ();
    localc.field_mediaSvrId = bt.flT();
    localc.field_isUseCdn = 0;
    AppMethodBeat.o(31079);
    return localc;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(31081);
    this.callback = paramf;
    if (this.xqy.field_status != 101L)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.abi() + " summerbig get field_status failed status:" + this.xqy.field_status);
      AppMethodBeat.o(31081);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.flT();
      this.ENy = this.xqy.field_offset;
    }
    ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { this.xqy.field_fileFullPath, Long.valueOf(this.xqy.field_totalLen), Boolean.valueOf(this.xqy.field_isUpload), Integer.valueOf(this.xqy.field_isUseCdn), Long.valueOf(this.xqy.field_type) });
    com.tencent.mm.ao.f.aGI();
    if ((!com.tencent.mm.ao.b.pa(4)) && (this.xqy.field_isUseCdn != 1))
    {
      com.tencent.mm.ao.f.aGI();
      ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.ao.b.pa(4)), Integer.valueOf(this.xqy.field_isUseCdn) });
      i = 0;
    }
    while (i != 0)
    {
      this.pDT = true;
      Message.obtain(this.handler, 1, this.id).sendToTarget();
      ad.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client");
      AppMethodBeat.o(31081);
      return 0;
      i = (int)i.aYo(this.xqy.field_fileFullPath);
      this.ibe = com.tencent.mm.ao.c.a("upattach", this.xqy.field_createTime, u.aAY().field_username, "");
      ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.xqy.field_createTime), this.ibe });
      if (bt.isNullOrNil(this.ibe))
      {
        ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId failed not use cdn");
        i = 0;
      }
      else
      {
        paramf = new com.tencent.mm.i.g();
        paramf.fJi = "task_NetSceneUploadAppAttachForHandOff";
        int j = com.tencent.mm.i.a.MediaType_FILE;
        paramf.field_appType = 0;
        paramf.fJj = this.ibn;
        paramf.field_mediaId = this.ibe;
        paramf.field_fullpath = this.xqy.field_fileFullPath;
        paramf.field_fileType = j;
        paramf.field_priority = com.tencent.mm.i.a.fIw;
        paramf.field_totalLen = i;
        paramf.field_needStorage = false;
        paramf.field_isStreamMedia = false;
        paramf.field_enable_hitcheck = this.ibv;
        if (bt.isNullOrNil(paramf.field_aesKey))
        {
          com.tencent.mm.ao.f.aGJ();
          paramf.field_aesKey = com.tencent.mm.ao.a.aGz();
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summersafecdn gen aesKey new[%s]", new Object[] { paramf.field_aesKey });
        }
        ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.xqy.field_msgInfoId), paramf.field_fullpath, Integer.valueOf(i), this.ibe, Integer.valueOf(paramf.field_fileType), Boolean.valueOf(paramf.field_enable_hitcheck), Boolean.valueOf(paramf.field_onlycheckexist), Boolean.valueOf(paramf.field_force_aeskeycdn), Boolean.valueOf(paramf.field_trysafecdn), bt.aRp(paramf.field_aesKey), paramf.field_filemd5, bt.aRp(paramf.field_svr_signature), bt.aRp(paramf.field_fake_bigfile_signature_aeskey), bt.aRp(paramf.field_fake_bigfile_signature) });
        if (!com.tencent.mm.ao.f.aGI().f(paramf))
        {
          ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra addSendTask failed.");
          this.ibe = "";
          i = 0;
        }
        else
        {
          if (this.xqy.field_isUseCdn != 1) {
            this.xqy.field_isUseCdn = 1;
          }
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.ibe });
          i = 1;
        }
      }
    }
    if (this.xqy.field_netTimes > 3200L)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.abi() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR!");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramf = this.xqy;
    paramf.field_netTimes += 1L;
    if (bt.isNullOrNil(this.xqy.field_clientAppDataId))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((this.xqy.field_totalLen <= 0L) || (this.xqy.field_totalLen > 26214400L))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.xqy.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if (bt.isNullOrNil(this.xqy.field_fileFullPath))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((int)i.aYo(this.xqy.field_fileFullPath) > 26214400)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : file is too large");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramf = i.aY(this.xqy.field_fileFullPath, (int)this.xqy.field_offset, this.isH);
    if (bt.cC(paramf))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    dsd localdsd = (dsd)this.rr.hNK.hNQ;
    localdsd.iht = this.xqy.field_appId;
    localdsd.Fws = ((int)this.xqy.field_sdkVer);
    localdsd.HEY = this.xqy.field_clientAppDataId;
    localdsd.nEf = ((int)this.xqy.field_type);
    localdsd.nDo = u.aAm();
    localdsd.xcK = ((int)this.xqy.field_totalLen);
    localdsd.xcL = ((int)this.xqy.field_offset);
    localdsd.xcM = paramf.length;
    localdsd.xcN = new SKBuiltinBuffer_t().setBuffer(paramf);
    ad.d("UploadAppAttach", String.format("AppId=%s, SdkVersion=%d, ClientAppDataId=%s, Type=%d, UserName=%s, TotalLen=%d, StartPos=%d", new Object[] { localdsd.iht, Integer.valueOf(localdsd.Fws), localdsd.HEY, Integer.valueOf(localdsd.nEf), localdsd.nDo, Integer.valueOf(localdsd.xcK), Integer.valueOf(localdsd.xcL) }));
    this.pDT = true;
    if (!this.handler.hasMessages(1)) {
      Message.obtain(this.handler, 1, this.id).sendToTarget();
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(31081);
    return i;
  }
  
  public final int getType()
  {
    return 220;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31082);
    ad.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.ibe)))
    {
      ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.ibe });
      this.pDT = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.pDT = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hr(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    paramString = (dse)((com.tencent.mm.al.b)paramq).hNL.hNQ;
    if ((paramString.iht != null) && ((!paramString.iht.equals(this.xqy.field_appId)) || (!paramString.HEY.equals(this.xqy.field_clientAppDataId))))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "argument is not consistent");
      this.pDT = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hr(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramString.xcK < 0) || (paramString.xcK != this.xqy.field_totalLen) || (paramString.xcL < 0) || (paramString.xcL > this.xqy.field_totalLen))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "dataLen, startPos or totalLen is incorrect");
      this.pDT = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hr(this.id, "");
      AppMethodBeat.o(31082);
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
      ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd STATUS PAUSE [" + this.xqy.field_mediaSvrId + "," + this.xqy.field_offset + "] ");
      this.pDT = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if (this.xqy.field_offset == this.xqy.field_totalLen)
    {
      if (bt.isNullOrNil(this.xqy.field_mediaSvrId))
      {
        ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "finish upload but mediaid == null!");
        this.pDT = false;
        this.handler.removeMessages(1);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hr(this.id, "");
        AppMethodBeat.o(31082);
        return;
      }
      this.xqy.field_status = 199L;
    }
    while (this.xqy.field_status == 199L)
    {
      this.pDT = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.id, this.xqy.field_appId, (int)this.xqy.field_sdkVer, this.xqy.field_mediaSvrId);
      AppMethodBeat.o(31082);
      return;
      this.uDQ = this.xqy.field_offset;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : doScene fail");
      this.pDT = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hr(this.id, "");
    }
    AppMethodBeat.o(31082);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hOp;
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(31078);
      if ((paramMessage.what == 1) && (ak.f(ak.this)) && (ak.e(ak.this).field_status != 105L) && (((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).az(ak.d(ak.this), ak.g(ak.this)))) {
        sendMessageDelayed(Message.obtain(this, 1, ak.d(ak.this)), ak.bvT());
      }
      AppMethodBeat.o(31078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak
 * JD-Core Version:    0.7.0.1
 */