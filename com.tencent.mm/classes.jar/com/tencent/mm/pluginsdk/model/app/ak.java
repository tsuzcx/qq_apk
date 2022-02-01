package com.tencent.mm.pluginsdk.model.app;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.n.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.model.v;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.protocal.protobuf.dtb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;

public final class ak
  extends n
  implements k
{
  private static final long Fgc;
  private long FfV;
  private com.tencent.mm.ak.f callback;
  private Handler handler;
  private String id;
  private String idX;
  private g.a ieg;
  private boolean ieo;
  private int ivB;
  private boolean pKx;
  private int retCode;
  private com.tencent.mm.ak.b rr;
  private long startTime;
  private long uPv;
  private c xGv;
  
  static
  {
    AppMethodBeat.i(31083);
    Fgc = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFu, 5) * 1000L;
    AppMethodBeat.o(31083);
  }
  
  public ak(String paramString, c paramc)
  {
    AppMethodBeat.i(31080);
    this.ivB = 8192;
    this.ieo = true;
    this.retCode = 0;
    this.handler = new a((byte)0);
    this.startTime = 0L;
    this.FfV = -1L;
    this.idX = "";
    this.ieg = new g.a()
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
          ae.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt), paramAnonymousc, paramAnonymousd, Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(paramAnonymousBoolean) });
          if (paramAnonymousInt != -21005) {
            break label153;
          }
          ae.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ak.a(ak.this) });
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
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hy(ak.d(ak.this), "");
          AppMethodBeat.o(31077);
          return 0;
        }
        if (ak.e(ak.this).field_status == 105L)
        {
          ae.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "attach upload has paused, status:%d", new Object[] { Long.valueOf(ak.e(ak.this).field_status) });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          com.tencent.mm.an.f.aGZ().Fr(ak.a(ak.this));
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          ak.e(ak.this).field_lastModifyTime = bu.aRi();
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
          ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.fKX });
          ak.b(ak.this);
          ak.c(ak.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hy(ak.d(ak.this), "");
        }
        for (;;)
        {
          AppMethodBeat.o(31077);
          return 0;
          label497:
          ae.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), bu.aSM(ak.e(ak.this).field_signature) });
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
    this.xGv = paramc;
    if (az.jd(com.tencent.mm.sdk.platformtools.ak.getContext())) {
      this.ivB = 32768;
    }
    paramString = new com.tencent.mm.ak.b.a();
    paramString.hQF = new dta();
    paramString.hQG = new dtb();
    paramString.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString.funcId = 220;
    paramString.hQH = 105;
    paramString.respCmdId = 1000000105;
    this.rr = paramString.aDS();
    ae.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig new NetSceneUploadAppAttachForHandOff stack[%s]", new Object[] { bu.fpN() });
    AppMethodBeat.o(31080);
  }
  
  public static c a(HandOffFile paramHandOffFile)
  {
    AppMethodBeat.i(31079);
    c localc = new c();
    localc.field_totalLen = paramHandOffFile.size;
    localc.field_fileFullPath = paramHandOffFile.hgD;
    localc.field_sdkVer = 0L;
    localc.field_appId = "";
    localc.field_clientAppDataId = bu.fpO();
    localc.field_type = 0L;
    localc.field_status = 200L;
    localc.field_isUpload = true;
    localc.field_createTime = bu.fpO();
    localc.field_lastModifyTime = bu.aRi();
    localc.field_mediaSvrId = bu.fpO();
    localc.field_isUseCdn = 0;
    AppMethodBeat.o(31079);
    return localc;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(31081);
    this.callback = paramf;
    if (this.xGv.field_status != 101L)
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.abr() + " summerbig get field_status failed status:" + this.xGv.field_status);
      AppMethodBeat.o(31081);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = bu.fpO();
      this.FfV = this.xGv.field_offset;
    }
    ae.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { this.xGv.field_fileFullPath, Long.valueOf(this.xGv.field_totalLen), Boolean.valueOf(this.xGv.field_isUpload), Integer.valueOf(this.xGv.field_isUseCdn), Long.valueOf(this.xGv.field_type) });
    com.tencent.mm.an.f.aGZ();
    if ((!com.tencent.mm.an.b.pd(4)) && (this.xGv.field_isUseCdn != 1))
    {
      com.tencent.mm.an.f.aGZ();
      ae.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.an.b.pd(4)), Integer.valueOf(this.xGv.field_isUseCdn) });
      i = 0;
    }
    while (i != 0)
    {
      this.pKx = true;
      Message.obtain(this.handler, 1, this.id).sendToTarget();
      ae.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client");
      AppMethodBeat.o(31081);
      return 0;
      i = (int)o.aZR(this.xGv.field_fileFullPath);
      this.idX = com.tencent.mm.an.c.a("upattach", this.xGv.field_createTime, v.aBo().field_username, "");
      ae.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.xGv.field_createTime), this.idX });
      if (bu.isNullOrNil(this.idX))
      {
        ae.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId failed not use cdn");
        i = 0;
      }
      else
      {
        paramf = new com.tencent.mm.i.g();
        paramf.fLl = "task_NetSceneUploadAppAttachForHandOff";
        int j = com.tencent.mm.i.a.MediaType_FILE;
        paramf.field_appType = 0;
        paramf.fLm = this.ieg;
        paramf.field_mediaId = this.idX;
        paramf.field_fullpath = this.xGv.field_fileFullPath;
        paramf.field_fileType = j;
        paramf.field_priority = com.tencent.mm.i.a.fKA;
        paramf.field_totalLen = i;
        paramf.field_needStorage = false;
        paramf.field_isStreamMedia = false;
        paramf.field_enable_hitcheck = this.ieo;
        if (bu.isNullOrNil(paramf.field_aesKey))
        {
          com.tencent.mm.an.f.aHa();
          paramf.field_aesKey = com.tencent.mm.an.a.aGP();
          ae.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summersafecdn gen aesKey new[%s]", new Object[] { paramf.field_aesKey });
        }
        ae.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.xGv.field_msgInfoId), paramf.field_fullpath, Integer.valueOf(i), this.idX, Integer.valueOf(paramf.field_fileType), Boolean.valueOf(paramf.field_enable_hitcheck), Boolean.valueOf(paramf.field_onlycheckexist), Boolean.valueOf(paramf.field_force_aeskeycdn), Boolean.valueOf(paramf.field_trysafecdn), bu.aSM(paramf.field_aesKey), paramf.field_filemd5, bu.aSM(paramf.field_svr_signature), bu.aSM(paramf.field_fake_bigfile_signature_aeskey), bu.aSM(paramf.field_fake_bigfile_signature) });
        if (!com.tencent.mm.an.f.aGZ().f(paramf))
        {
          ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra addSendTask failed.");
          this.idX = "";
          i = 0;
        }
        else
        {
          if (this.xGv.field_isUseCdn != 1) {
            this.xGv.field_isUseCdn = 1;
          }
          ae.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.idX });
          i = 1;
        }
      }
    }
    if (this.xGv.field_netTimes > 3200L)
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", com.tencent.mm.compatible.util.f.abr() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR!");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramf = this.xGv;
    paramf.field_netTimes += 1L;
    if (bu.isNullOrNil(this.xGv.field_clientAppDataId))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((this.xGv.field_totalLen <= 0L) || (this.xGv.field_totalLen > 26214400L))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.xGv.field_totalLen);
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if (bu.isNullOrNil(this.xGv.field_fileFullPath))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((int)o.aZR(this.xGv.field_fileFullPath) > 26214400)
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : file is too large");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramf = o.bb(this.xGv.field_fileFullPath, (int)this.xGv.field_offset, this.ivB);
    if (bu.cF(paramf))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - com.tencent.mm.compatible.util.f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    dta localdta = (dta)this.rr.hQD.hQJ;
    localdta.ikm = this.xGv.field_appId;
    localdta.FOQ = ((int)this.xGv.field_sdkVer);
    localdta.HYL = this.xGv.field_clientAppDataId;
    localdta.nJA = ((int)this.xGv.field_type);
    localdta.nIJ = v.aAC();
    localdta.xsB = ((int)this.xGv.field_totalLen);
    localdta.xsC = ((int)this.xGv.field_offset);
    localdta.xsD = paramf.length;
    localdta.xsE = new SKBuiltinBuffer_t().setBuffer(paramf);
    ae.d("UploadAppAttach", String.format("AppId=%s, SdkVersion=%d, ClientAppDataId=%s, Type=%d, UserName=%s, TotalLen=%d, StartPos=%d", new Object[] { localdta.ikm, Integer.valueOf(localdta.FOQ), localdta.HYL, Integer.valueOf(localdta.nJA), localdta.nIJ, Integer.valueOf(localdta.xsB), Integer.valueOf(localdta.xsC) }));
    this.pKx = true;
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
    ae.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!bu.isNullOrNil(this.idX)))
    {
      ae.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.idX });
      this.pKx = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.pKx = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hy(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    paramString = (dtb)((com.tencent.mm.ak.b)paramq).hQE.hQJ;
    if ((paramString.ikm != null) && ((!paramString.ikm.equals(this.xGv.field_appId)) || (!paramString.HYL.equals(this.xGv.field_clientAppDataId))))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "argument is not consistent");
      this.pKx = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hy(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramString.xsB < 0) || (paramString.xsB != this.xGv.field_totalLen) || (paramString.xsC < 0) || (paramString.xsC > this.xGv.field_totalLen))
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "dataLen, startPos or totalLen is incorrect");
      this.pKx = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hy(this.id, "");
      AppMethodBeat.o(31082);
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
      ae.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd STATUS PAUSE [" + this.xGv.field_mediaSvrId + "," + this.xGv.field_offset + "] ");
      this.pKx = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if (this.xGv.field_offset == this.xGv.field_totalLen)
    {
      if (bu.isNullOrNil(this.xGv.field_mediaSvrId))
      {
        ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "finish upload but mediaid == null!");
        this.pKx = false;
        this.handler.removeMessages(1);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hy(this.id, "");
        AppMethodBeat.o(31082);
        return;
      }
      this.xGv.field_status = 199L;
    }
    while (this.xGv.field_status == 199L)
    {
      this.pKx = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).f(this.id, this.xGv.field_appId, (int)this.xGv.field_sdkVer, this.xGv.field_mediaSvrId);
      AppMethodBeat.o(31082);
      return;
      this.uPv = this.xGv.field_offset;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      ae.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : doScene fail");
      this.pKx = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.handoff.a.a.class)).hy(this.id, "");
    }
    AppMethodBeat.o(31082);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final n.b securityVerificationChecked(q paramq)
  {
    return n.b.hRi;
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
        sendMessageDelayed(Message.obtain(this, 1, ak.d(ak.this)), ak.bwK());
      }
      AppMethodBeat.o(31078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ak
 * JD-Core Version:    0.7.0.1
 */