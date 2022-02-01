package com.tencent.mm.pluginsdk.model.app;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.n.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dgx;
import com.tencent.mm.protocal.protobuf.dgy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;

public final class al
  extends n
  implements k
{
  private static final long BQB;
  private long BQw;
  private com.tencent.mm.al.g callback;
  private Handler handler;
  private String hhN;
  private g.a hhW;
  private boolean hie;
  private int hyK;
  private String id;
  private boolean owJ;
  private int retCode;
  private com.tencent.mm.al.b rr;
  private long startTime;
  private long str;
  private c uZZ;
  
  static
  {
    AppMethodBeat.i(31083);
    BQB = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.ppX, 5) * 1000L;
    AppMethodBeat.o(31083);
  }
  
  public al(String paramString, c paramc)
  {
    AppMethodBeat.i(31080);
    this.hyK = 8192;
    this.hie = true;
    this.retCode = 0;
    this.handler = new a((byte)0);
    this.startTime = 0L;
    this.BQw = -1L;
    this.hhN = "";
    this.hhW = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31077);
        paramAnonymousString = al.a(al.this);
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
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { al.a(al.this) });
          al.b(al.this);
          al.c(al.this).removeMessages(1);
          AppMethodBeat.o(31077);
          return 0;
          bool1 = false;
          break;
        }
        label153:
        if (paramAnonymousInt != 0)
        {
          al.b(al.this);
          al.c(al.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).gO(al.d(al.this), "");
          AppMethodBeat.o(31077);
          return 0;
        }
        if (al.e(al.this).field_status == 105L)
        {
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "attach upload has paused, status:%d", new Object[] { Long.valueOf(al.e(al.this).field_status) });
          al.b(al.this);
          al.c(al.this).removeMessages(1);
          com.tencent.mm.ao.f.awL().xK(al.a(al.this));
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          al.e(al.this).field_lastModifyTime = bt.aGK();
          al.e(al.this).field_offset = paramAnonymousc.field_finishedLength;
          al.a(al.this, al.e(al.this).field_offset);
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label497;
          }
          ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fns });
          al.b(al.this);
          al.c(al.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).gO(al.d(al.this), "");
        }
        for (;;)
        {
          AppMethodBeat.o(31077);
          return 0;
          label497:
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bt.aGs(al.e(al.this).field_signature) });
          al.b(al.this);
          al.c(al.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).af(al.d(al.this), paramAnonymousd.field_fileId, paramAnonymousd.field_aesKey);
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
    this.uZZ = paramc;
    if (ay.iD(aj.getContext())) {
      this.hyK = 32768;
    }
    paramString = new com.tencent.mm.al.b.a();
    paramString.gUU = new dgx();
    paramString.gUV = new dgy();
    paramString.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString.funcId = 220;
    paramString.reqCmdId = 105;
    paramString.respCmdId = 1000000105;
    this.rr = paramString.atI();
    ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig new NetSceneUploadAppAttach stack[%s]", new Object[] { bt.eGN() });
    AppMethodBeat.o(31080);
  }
  
  public static c a(HandOffFile paramHandOffFile)
  {
    AppMethodBeat.i(31079);
    c localc = new c();
    localc.field_totalLen = paramHandOffFile.size;
    localc.field_fileFullPath = paramHandOffFile.gjt;
    localc.field_sdkVer = 0L;
    localc.field_appId = "";
    localc.field_clientAppDataId = bt.eGO();
    localc.field_type = 0L;
    localc.field_status = 200L;
    localc.field_isUpload = true;
    localc.field_createTime = bt.eGO();
    localc.field_lastModifyTime = bt.aGK();
    localc.field_mediaSvrId = bt.eGO();
    localc.field_isUseCdn = 0;
    AppMethodBeat.o(31079);
    return localc;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(31081);
    this.callback = paramg;
    if (this.uZZ.field_status != 101L)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.XJ() + " summerbig get field_status failed status:" + this.uZZ.field_status);
      AppMethodBeat.o(31081);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bt.eGO();
      this.BQw = this.uZZ.field_offset;
    }
    ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { this.uZZ.field_fileFullPath, Long.valueOf(this.uZZ.field_totalLen), Boolean.valueOf(this.uZZ.field_isUpload), Integer.valueOf(this.uZZ.field_isUseCdn), Long.valueOf(this.uZZ.field_type) });
    com.tencent.mm.ao.f.awL();
    if ((!com.tencent.mm.ao.b.nL(4)) && (this.uZZ.field_isUseCdn != 1))
    {
      com.tencent.mm.ao.f.awL();
      ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.ao.b.nL(4)), Integer.valueOf(this.uZZ.field_isUseCdn) });
      i = 0;
    }
    while (i != 0)
    {
      this.owJ = true;
      Message.obtain(this.handler, 1, this.id).sendToTarget();
      ad.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client");
      AppMethodBeat.o(31081);
      return 0;
      i = (int)i.aMN(this.uZZ.field_fileFullPath);
      this.hhN = com.tencent.mm.ao.c.a("upattach", this.uZZ.field_createTime, u.arm().field_username, "");
      ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.uZZ.field_createTime), this.hhN });
      if (bt.isNullOrNil(this.hhN))
      {
        ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId failed not use cdn");
        i = 0;
      }
      else
      {
        paramg = new com.tencent.mm.i.g();
        int j = com.tencent.mm.i.a.MediaType_FILE;
        paramg.field_appType = 0;
        paramg.fnH = this.hhW;
        paramg.field_mediaId = this.hhN;
        paramg.field_fullpath = this.uZZ.field_fileFullPath;
        paramg.field_fileType = j;
        paramg.field_priority = com.tencent.mm.i.a.fmV;
        paramg.field_totalLen = i;
        paramg.field_needStorage = false;
        paramg.field_isStreamMedia = false;
        paramg.field_enable_hitcheck = this.hie;
        if (bt.isNullOrNil(paramg.field_aesKey))
        {
          com.tencent.mm.ao.f.awM();
          paramg.field_aesKey = com.tencent.mm.ao.a.awE();
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summersafecdn gen aesKey new[%s]", new Object[] { paramg.field_aesKey });
        }
        ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.uZZ.field_msgInfoId), paramg.field_fullpath, Integer.valueOf(i), this.hhN, Integer.valueOf(paramg.field_fileType), Boolean.valueOf(paramg.field_enable_hitcheck), Boolean.valueOf(paramg.field_onlycheckexist), Boolean.valueOf(paramg.field_force_aeskeycdn), Boolean.valueOf(paramg.field_trysafecdn), bt.aGs(paramg.field_aesKey), paramg.field_filemd5, bt.aGs(paramg.field_svr_signature), bt.aGs(paramg.field_fake_bigfile_signature_aeskey), bt.aGs(paramg.field_fake_bigfile_signature) });
        if (!com.tencent.mm.ao.f.awL().e(paramg))
        {
          ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra addSendTask failed.");
          this.hhN = "";
          i = 0;
        }
        else
        {
          if (this.uZZ.field_isUseCdn != 1) {
            this.uZZ.field_isUseCdn = 1;
          }
          ad.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.hhN });
          i = 1;
        }
      }
    }
    if (this.uZZ.field_netTimes > 3200L)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.XJ() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR!");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramg = this.uZZ;
    paramg.field_netTimes += 1L;
    if (bt.isNullOrNil(this.uZZ.field_clientAppDataId))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((this.uZZ.field_totalLen <= 0L) || (this.uZZ.field_totalLen > 26214400L))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.uZZ.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if (bt.isNullOrNil(this.uZZ.field_fileFullPath))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((int)i.aMN(this.uZZ.field_fileFullPath) > 26214400)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : file is too large");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramg = i.aR(this.uZZ.field_fileFullPath, (int)this.uZZ.field_offset, this.hyK);
    if (bt.cw(paramg))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    dgx localdgx = (dgx)this.rr.gUS.gUX;
    localdgx.hnC = this.uZZ.field_appId;
    localdgx.CyE = ((int)this.uZZ.field_sdkVer);
    localdgx.Exi = this.uZZ.field_clientAppDataId;
    localdgx.mBH = ((int)this.uZZ.field_type);
    localdgx.mAQ = u.aqG();
    localdgx.uKQ = ((int)this.uZZ.field_totalLen);
    localdgx.uKR = ((int)this.uZZ.field_offset);
    localdgx.uKS = paramg.length;
    localdgx.uKT = new SKBuiltinBuffer_t().setBuffer(paramg);
    ad.d("UploadAppAttach", String.format("AppId=%s, SdkVersion=%d, ClientAppDataId=%s, Type=%d, UserName=%s, TotalLen=%d, StartPos=%d", new Object[] { localdgx.hnC, Integer.valueOf(localdgx.CyE), localdgx.Exi, Integer.valueOf(localdgx.mBH), localdgx.mAQ, Integer.valueOf(localdgx.uKQ), Integer.valueOf(localdgx.uKR) }));
    this.owJ = true;
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
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bt.isNullOrNil(this.hhN)))
    {
      ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hhN });
      this.owJ = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.owJ = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).gO(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    paramString = (dgy)((com.tencent.mm.al.b)paramq).gUT.gUX;
    if ((paramString.hnC != null) && ((!paramString.hnC.equals(this.uZZ.field_appId)) || (!paramString.Exi.equals(this.uZZ.field_clientAppDataId))))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "argument is not consistent");
      this.owJ = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).gO(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramString.uKQ < 0) || (paramString.uKQ != this.uZZ.field_totalLen) || (paramString.uKR < 0) || (paramString.uKR > this.uZZ.field_totalLen))
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "dataLen, startPos or totalLen is incorrect");
      this.owJ = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).gO(this.id, "");
      AppMethodBeat.o(31082);
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
      ad.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd STATUS PAUSE [" + this.uZZ.field_mediaSvrId + "," + this.uZZ.field_offset + "] ");
      this.owJ = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if (this.uZZ.field_offset == this.uZZ.field_totalLen)
    {
      if (bt.isNullOrNil(this.uZZ.field_mediaSvrId))
      {
        ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "finish upload but mediaid == null!");
        this.owJ = false;
        this.handler.removeMessages(1);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).gO(this.id, "");
        AppMethodBeat.o(31082);
        return;
      }
      this.uZZ.field_status = 199L;
    }
    while (this.uZZ.field_status == 199L)
    {
      this.owJ = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(this.id, this.uZZ.field_appId, (int)this.uZZ.field_sdkVer, this.uZZ.field_mediaSvrId);
      AppMethodBeat.o(31082);
      return;
      this.str = this.uZZ.field_offset;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ad.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : doScene fail");
      this.owJ = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).gO(this.id, "");
    }
    AppMethodBeat.o(31082);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.gVB;
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(31078);
      if ((paramMessage.what == 1) && (al.f(al.this)) && (al.e(al.this).field_status != 105L) && (((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).au(al.d(al.this), al.g(al.this)))) {
        sendMessageDelayed(Message.obtain(this, 1, al.d(al.this)), al.bla());
      }
      AppMethodBeat.o(31078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al
 * JD-Core Version:    0.7.0.1
 */