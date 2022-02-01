package com.tencent.mm.pluginsdk.model.app;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;

public final class al
  extends n
  implements k
{
  private static final long DiQ;
  private long DiL;
  private com.tencent.mm.ak.g callback;
  private boolean hIH;
  private String hIq;
  private g.a hIz;
  private int hZl;
  private Handler handler;
  private String id;
  private boolean paj;
  private int retCode;
  private com.tencent.mm.ak.b rr;
  private long startTime;
  private long tBh;
  private c wiN;
  
  static
  {
    AppMethodBeat.i(31083);
    DiQ = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pTI, 5) * 1000L;
    AppMethodBeat.o(31083);
  }
  
  public al(String paramString, c paramc)
  {
    AppMethodBeat.i(31080);
    this.hZl = 8192;
    this.hIH = true;
    this.retCode = 0;
    this.handler = new a((byte)0);
    this.startTime = 0L;
    this.DiL = -1L;
    this.hIq = "";
    this.hIz = new g.a()
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
          ac.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          ac.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { al.a(al.this) });
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
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hf(al.d(al.this), "");
          AppMethodBeat.o(31077);
          return 0;
        }
        if (al.e(al.this).field_status == 105L)
        {
          ac.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "attach upload has paused, status:%d", new Object[] { Long.valueOf(al.e(al.this).field_status) });
          al.b(al.this);
          al.c(al.this).removeMessages(1);
          com.tencent.mm.an.f.aDD().BQ(al.a(al.this));
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          al.e(al.this).field_lastModifyTime = bs.aNx();
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
          ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fqM });
          al.b(al.this);
          al.c(al.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hf(al.d(al.this), "");
        }
        for (;;)
        {
          AppMethodBeat.o(31077);
          return 0;
          label497:
          ac.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bs.aLJ(al.e(al.this).field_signature) });
          al.b(al.this);
          al.c(al.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).ag(al.d(al.this), paramAnonymousd.field_fileId, paramAnonymousd.field_aesKey);
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
    this.wiN = paramc;
    if (ax.iO(ai.getContext())) {
      this.hZl = 32768;
    }
    paramString = new com.tencent.mm.ak.b.a();
    paramString.hvt = new dmm();
    paramString.hvu = new dmn();
    paramString.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString.funcId = 220;
    paramString.reqCmdId = 105;
    paramString.respCmdId = 1000000105;
    this.rr = paramString.aAz();
    ac.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig new NetSceneUploadAppAttach stack[%s]", new Object[] { bs.eWi() });
    AppMethodBeat.o(31080);
  }
  
  public static c a(HandOffFile paramHandOffFile)
  {
    AppMethodBeat.i(31079);
    c localc = new c();
    localc.field_totalLen = paramHandOffFile.size;
    localc.field_fileFullPath = paramHandOffFile.gKe;
    localc.field_sdkVer = 0L;
    localc.field_appId = "";
    localc.field_clientAppDataId = bs.eWj();
    localc.field_type = 0L;
    localc.field_status = 200L;
    localc.field_isUpload = true;
    localc.field_createTime = bs.eWj();
    localc.field_lastModifyTime = bs.aNx();
    localc.field_mediaSvrId = bs.eWj();
    localc.field_isUseCdn = 0;
    AppMethodBeat.o(31079);
    return localc;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(31081);
    this.callback = paramg;
    if (this.wiN.field_status != 101L)
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.YG() + " summerbig get field_status failed status:" + this.wiN.field_status);
      AppMethodBeat.o(31081);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bs.eWj();
      this.DiL = this.wiN.field_offset;
    }
    ac.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { this.wiN.field_fileFullPath, Long.valueOf(this.wiN.field_totalLen), Boolean.valueOf(this.wiN.field_isUpload), Integer.valueOf(this.wiN.field_isUseCdn), Long.valueOf(this.wiN.field_type) });
    com.tencent.mm.an.f.aDD();
    if ((!com.tencent.mm.an.b.oz(4)) && (this.wiN.field_isUseCdn != 1))
    {
      com.tencent.mm.an.f.aDD();
      ac.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.oz(4)), Integer.valueOf(this.wiN.field_isUseCdn) });
      i = 0;
    }
    while (i != 0)
    {
      this.paj = true;
      Message.obtain(this.handler, 1, this.id).sendToTarget();
      ac.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client");
      AppMethodBeat.o(31081);
      return 0;
      i = (int)i.aSp(this.wiN.field_fileFullPath);
      this.hIq = com.tencent.mm.an.c.a("upattach", this.wiN.field_createTime, u.ayc().field_username, "");
      ac.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.wiN.field_createTime), this.hIq });
      if (bs.isNullOrNil(this.hIq))
      {
        ac.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId failed not use cdn");
        i = 0;
      }
      else
      {
        paramg = new com.tencent.mm.i.g();
        int j = com.tencent.mm.i.a.MediaType_FILE;
        paramg.field_appType = 0;
        paramg.frb = this.hIz;
        paramg.field_mediaId = this.hIq;
        paramg.field_fullpath = this.wiN.field_fileFullPath;
        paramg.field_fileType = j;
        paramg.field_priority = com.tencent.mm.i.a.fqp;
        paramg.field_totalLen = i;
        paramg.field_needStorage = false;
        paramg.field_isStreamMedia = false;
        paramg.field_enable_hitcheck = this.hIH;
        if (bs.isNullOrNil(paramg.field_aesKey))
        {
          com.tencent.mm.an.f.aDE();
          paramg.field_aesKey = com.tencent.mm.an.a.aDw();
          ac.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summersafecdn gen aesKey new[%s]", new Object[] { paramg.field_aesKey });
        }
        ac.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.wiN.field_msgInfoId), paramg.field_fullpath, Integer.valueOf(i), this.hIq, Integer.valueOf(paramg.field_fileType), Boolean.valueOf(paramg.field_enable_hitcheck), Boolean.valueOf(paramg.field_onlycheckexist), Boolean.valueOf(paramg.field_force_aeskeycdn), Boolean.valueOf(paramg.field_trysafecdn), bs.aLJ(paramg.field_aesKey), paramg.field_filemd5, bs.aLJ(paramg.field_svr_signature), bs.aLJ(paramg.field_fake_bigfile_signature_aeskey), bs.aLJ(paramg.field_fake_bigfile_signature) });
        if (!com.tencent.mm.an.f.aDD().f(paramg))
        {
          ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra addSendTask failed.");
          this.hIq = "";
          i = 0;
        }
        else
        {
          if (this.wiN.field_isUseCdn != 1) {
            this.wiN.field_isUseCdn = 1;
          }
          ac.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.hIq });
          i = 1;
        }
      }
    }
    if (this.wiN.field_netTimes > 3200L)
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.YG() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR!");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramg = this.wiN;
    paramg.field_netTimes += 1L;
    if (bs.isNullOrNil(this.wiN.field_clientAppDataId))
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((this.wiN.field_totalLen <= 0L) || (this.wiN.field_totalLen > 26214400L))
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.wiN.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if (bs.isNullOrNil(this.wiN.field_fileFullPath))
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((int)i.aSp(this.wiN.field_fileFullPath) > 26214400)
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : file is too large");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramg = i.aU(this.wiN.field_fileFullPath, (int)this.wiN.field_offset, this.hZl);
    if (bs.cv(paramg))
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    dmm localdmm = (dmm)this.rr.hvr.hvw;
    localdmm.hOf = this.wiN.field_appId;
    localdmm.DRa = ((int)this.wiN.field_sdkVer);
    localdmm.FUk = this.wiN.field_clientAppDataId;
    localdmm.ndI = ((int)this.wiN.field_type);
    localdmm.ncR = u.axw();
    localdmm.vTH = ((int)this.wiN.field_totalLen);
    localdmm.vTI = ((int)this.wiN.field_offset);
    localdmm.vTJ = paramg.length;
    localdmm.vTK = new SKBuiltinBuffer_t().setBuffer(paramg);
    ac.d("UploadAppAttach", String.format("AppId=%s, SdkVersion=%d, ClientAppDataId=%s, Type=%d, UserName=%s, TotalLen=%d, StartPos=%d", new Object[] { localdmm.hOf, Integer.valueOf(localdmm.DRa), localdmm.FUk, Integer.valueOf(localdmm.ndI), localdmm.ncR, Integer.valueOf(localdmm.vTH), Integer.valueOf(localdmm.vTI) }));
    this.paj = true;
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
    ac.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bs.isNullOrNil(this.hIq)))
    {
      ac.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.hIq });
      this.paj = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.paj = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hf(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    paramString = (dmn)((com.tencent.mm.ak.b)paramq).hvs.hvw;
    if ((paramString.hOf != null) && ((!paramString.hOf.equals(this.wiN.field_appId)) || (!paramString.FUk.equals(this.wiN.field_clientAppDataId))))
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "argument is not consistent");
      this.paj = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hf(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramString.vTH < 0) || (paramString.vTH != this.wiN.field_totalLen) || (paramString.vTI < 0) || (paramString.vTI > this.wiN.field_totalLen))
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "dataLen, startPos or totalLen is incorrect");
      this.paj = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hf(this.id, "");
      AppMethodBeat.o(31082);
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
      ac.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd STATUS PAUSE [" + this.wiN.field_mediaSvrId + "," + this.wiN.field_offset + "] ");
      this.paj = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if (this.wiN.field_offset == this.wiN.field_totalLen)
    {
      if (bs.isNullOrNil(this.wiN.field_mediaSvrId))
      {
        ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "finish upload but mediaid == null!");
        this.paj = false;
        this.handler.removeMessages(1);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hf(this.id, "");
        AppMethodBeat.o(31082);
        return;
      }
      this.wiN.field_status = 199L;
    }
    while (this.wiN.field_status == 199L)
    {
      this.paj = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.id, this.wiN.field_appId, (int)this.wiN.field_sdkVer, this.wiN.field_mediaSvrId);
      AppMethodBeat.o(31082);
      return;
      this.tBh = this.wiN.field_offset;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ac.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : doScene fail");
      this.paj = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hf(this.id, "");
    }
    AppMethodBeat.o(31082);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hwa;
  }
  
  @SuppressLint({"HandlerLeak"})
  final class a
    extends Handler
  {
    private a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(31078);
      if ((paramMessage.what == 1) && (al.f(al.this)) && (al.e(al.this).field_status != 105L) && (((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).aw(al.d(al.this), al.g(al.this)))) {
        sendMessageDelayed(Message.obtain(this, 1, al.d(al.this)), al.brP());
      }
      AppMethodBeat.o(31078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al
 * JD-Core Version:    0.7.0.1
 */