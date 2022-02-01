package com.tencent.mm.pluginsdk.model.app;

import android.os.Handler;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.g.a;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.modelcdntran.k;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.protocal.protobuf.fsz;
import com.tencent.mm.protocal.protobuf.fta;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;

public final class ao
  extends p
  implements m
{
  private static final long XTk;
  private c NAc;
  private long XTd;
  private com.tencent.mm.am.h callback;
  private Handler handler;
  private String id;
  private String oHX;
  private boolean oIo;
  private int oZk;
  private g.a osH;
  private int retCode;
  private com.tencent.mm.am.c rr;
  private long startTime;
  private long uploadedSize;
  private boolean xMr;
  
  static
  {
    AppMethodBeat.i(31083);
    XTk = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yVc, 5) * 1000L;
    AppMethodBeat.o(31083);
  }
  
  public ao(String paramString, c paramc)
  {
    AppMethodBeat.i(31080);
    this.oZk = 8192;
    this.oIo = true;
    this.retCode = 0;
    this.handler = new a((byte)0);
    this.startTime = 0L;
    this.XTd = -1L;
    this.oHX = "";
    this.osH = new g.a()
    {
      public final int a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.g.c paramAnonymousc, com.tencent.mm.g.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(31077);
        paramAnonymousString = ao.a(ao.this);
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
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback ERR_CNDCOM_MEDIA_IS_UPLOADING clientid:%s", new Object[] { ao.a(ao.this) });
          ao.b(ao.this);
          ao.c(ao.this).removeMessages(1);
          AppMethodBeat.o(31077);
          return 0;
          bool1 = false;
          break;
        }
        label153:
        if (paramAnonymousInt != 0)
        {
          ao.b(ao.this);
          ao.c(ao.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).jv(ao.d(ao.this), "");
          AppMethodBeat.o(31077);
          return 0;
        }
        if (ao.e(ao.this).field_status == 105L)
        {
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "attach upload has paused, status:%d", new Object[] { Long.valueOf(ao.e(ao.this).field_status) });
          ao.b(ao.this);
          ao.c(ao.this).removeMessages(1);
          k.bHW().Ny(ao.a(ao.this));
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousc != null)
        {
          ao.e(ao.this).field_lastModifyTime = Util.nowSecond();
          ao.e(ao.this).field_offset = paramAnonymousc.field_finishedLength;
          ao.a(ao.this, ao.e(ao.this).field_offset);
          AppMethodBeat.o(31077);
          return 0;
        }
        if (paramAnonymousd != null)
        {
          if (paramAnonymousd.field_retCode == 0) {
            break label497;
          }
          Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback sceneResult.retCode :%d arg[%s] info[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_retCode), paramAnonymousd.field_arg, paramAnonymousd.field_transInfo, "", "", "", "", "", "", "", paramAnonymousd.lwx });
          ao.b(ao.this);
          ao.c(ao.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).jv(ao.d(ao.this), "");
        }
        for (;;)
        {
          AppMethodBeat.o(31077);
          return 0;
          label497:
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdnCallback upload attach by cdn, isHitCacheUpload: %d, onlyCheckExist[%b], exist[%b], signature[%s]", new Object[] { Integer.valueOf(paramAnonymousd.field_UploadHitCacheType), Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(paramAnonymousd.field_exist_whencheck), Util.secPrint(ao.e(ao.this).field_signature) });
          ao.b(ao.this);
          ao.c(ao.this).removeMessages(1);
          ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).az(ao.d(ao.this), paramAnonymousd.field_fileId, paramAnonymousd.field_aesKey);
        }
      }
      
      public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
      
      public final byte[] h(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
      {
        return null;
      }
    };
    paramc.field_offset = 0L;
    paramc.field_isUpload = true;
    paramc.field_status = 101L;
    paramc.field_netTimes = 0L;
    this.id = paramString;
    this.NAc = paramc;
    if (NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext())) {
      this.oZk = 32768;
    }
    paramString = new com.tencent.mm.am.c.a();
    paramString.otE = new fsz();
    paramString.otF = new fta();
    paramString.uri = "/cgi-bin/micromsg-bin/uploadappattach";
    paramString.funcId = 220;
    paramString.otG = 105;
    paramString.respCmdId = 1000000105;
    this.rr = paramString.bEF();
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
    localc.field_createTime = cn.bDu();
    localc.field_lastModifyTime = Util.nowSecond();
    localc.field_mediaSvrId = Util.nowMilliSecond();
    localc.field_isUseCdn = 0;
    AppMethodBeat.o(31079);
    return localc;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(31081);
    this.callback = paramh;
    if (this.NAc.field_status != 101L)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", f.aPX() + " summerbig get field_status failed status:" + this.NAc.field_status);
      AppMethodBeat.o(31081);
      return -1;
    }
    if (this.startTime == 0L)
    {
      this.startTime = Util.nowMilliSecond();
      this.XTd = this.NAc.field_offset;
    }
    Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene fileFullPath[%s], totalLen[%d],isUpload[%b], isUseCdn[%b], type[%d]", new Object[] { this.NAc.field_fileFullPath, Long.valueOf(this.NAc.field_totalLen), Boolean.valueOf(this.NAc.field_isUpload), Integer.valueOf(this.NAc.field_isUseCdn), Long.valueOf(this.NAc.field_type) });
    k.bHW();
    if ((!com.tencent.mm.modelcdntran.g.vV(4)) && (this.NAc.field_isUseCdn != 1))
    {
      k.bHW();
      Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra not use cdn flag:%b getCdnInfo:%d", new Object[] { Boolean.valueOf(com.tencent.mm.modelcdntran.g.vV(4)), Integer.valueOf(this.NAc.field_isUseCdn) });
      i = 0;
    }
    while (i != 0)
    {
      this.xMr = true;
      Message.obtain(this.handler, 1, this.id).sendToTarget();
      Log.d("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene cdntra use cdn return -1 for onGYNetEnd client");
      AppMethodBeat.o(31081);
      return 0;
      i = (int)y.bEl(this.NAc.field_fileFullPath);
      this.oHX = com.tencent.mm.modelcdntran.h.a("upattach", this.NAc.field_createTime, z.bBF().field_username, "");
      Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId field_createTime[%d], useCdnTransClientId[%s]", new Object[] { Long.valueOf(this.NAc.field_createTime), this.oHX });
      if (Util.isNullOrNil(this.oHX))
      {
        Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra genClientId failed not use cdn");
        i = 0;
      }
      else
      {
        paramh = new com.tencent.mm.g.g();
        paramh.taskName = "task_NetSceneUploadAppAttachForHandOff";
        int j = com.tencent.mm.g.a.MediaType_FILE;
        paramh.field_appType = 0;
        paramh.lwL = this.osH;
        paramh.field_mediaId = this.oHX;
        paramh.field_fullpath = this.NAc.field_fileFullPath;
        paramh.field_fileType = j;
        paramh.field_priority = com.tencent.mm.g.a.lvZ;
        paramh.field_totalLen = i;
        paramh.field_needStorage = false;
        paramh.field_isStreamMedia = false;
        paramh.field_enable_hitcheck = this.oIo;
        if (Util.isNullOrNil(paramh.field_aesKey))
        {
          k.bHX();
          paramh.field_aesKey = com.tencent.mm.modelcdntran.d.bHI();
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summersafecdn gen aesKey new[%s]", new Object[] { paramh.field_aesKey });
        }
        Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra checkUseCdn msgId:%d file[%s][%d], useCdnTransClientId[%s], fileType[%d], enable_hitcheck[%b], onlycheckexist[%b] force_aeskeycdn[%b] trysafecdn[%b] aeskey[%s], md5[%s], signature[%s], faeskey[%s], fsignature[%s]", new Object[] { Long.valueOf(this.NAc.field_msgInfoId), paramh.field_fullpath, Integer.valueOf(i), this.oHX, Integer.valueOf(paramh.field_fileType), Boolean.valueOf(paramh.field_enable_hitcheck), Boolean.valueOf(paramh.field_onlycheckexist), Boolean.valueOf(paramh.field_force_aeskeycdn), Boolean.valueOf(paramh.field_trysafecdn), Util.secPrint(paramh.field_aesKey), paramh.field_filemd5, Util.secPrint(paramh.field_svr_signature), Util.secPrint(paramh.field_fake_bigfile_signature_aeskey), Util.secPrint(paramh.field_fake_bigfile_signature) });
        if (!k.bHW().g(paramh))
        {
          Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig cdntra addSendTask failed.");
          this.oHX = "";
          i = 0;
        }
        else
        {
          if (this.NAc.field_isUseCdn != 1) {
            this.NAc.field_isUseCdn = 1;
          }
          Log.i("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig checkUseCdn ret true useCdnTransClientId[%s]", new Object[] { this.oHX });
          i = 1;
        }
      }
    }
    if (this.NAc.field_netTimes > 3200L)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", f.aPX() + " summerbig doScene info.field_netTimes > DOSCENE_LIMIT SET ERROR!");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramh = this.NAc;
    paramh.field_netTimes += 1L;
    if (Util.isNullOrNil(this.NAc.field_clientAppDataId))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : clientAppDataId is null");
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((this.NAc.field_totalLen <= 0L) || (this.NAc.field_totalLen > 26214400L))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : totalLen is invalid, totalLen = " + this.NAc.field_totalLen);
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if (Util.isNullOrNil(this.NAc.field_fileFullPath))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene checkArgs : fileFullPath is null");
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    if ((int)y.bEl(this.NAc.field_fileFullPath) > 26214400)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : file is too large");
      AppMethodBeat.o(31081);
      return -1;
    }
    paramh = y.bi(this.NAc.field_fileFullPath, (int)this.NAc.field_offset, this.oZk);
    if (Util.isNullOrNil(paramh))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "summerbig doScene doScene : data is null");
      this.retCode = (-10000 - f.getLine());
      AppMethodBeat.o(31081);
      return -1;
    }
    fsz localfsz = (fsz)c.b.b(this.rr.otB);
    localfsz.oOI = this.NAc.field_appId;
    localfsz.YHj = ((int)this.NAc.field_sdkVer);
    localfsz.abRk = this.NAc.field_clientAppDataId;
    localfsz.vhJ = ((int)this.NAc.field_type);
    localfsz.UserName = z.bAM();
    localfsz.NkN = ((int)this.NAc.field_totalLen);
    localfsz.NkO = ((int)this.NAc.field_offset);
    localfsz.NkP = paramh.length;
    localfsz.NkQ = new gol().df(paramh);
    Log.d("UploadAppAttach", String.format("AppId=%s, SdkVersion=%d, ClientAppDataId=%s, Type=%d, UserName=%s, TotalLen=%d, StartPos=%d", new Object[] { localfsz.oOI, Integer.valueOf(localfsz.YHj), localfsz.abRk, Integer.valueOf(localfsz.vhJ), localfsz.UserName, Integer.valueOf(localfsz.NkN), Integer.valueOf(localfsz.NkO) }));
    this.xMr = true;
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
    if ((paramInt2 == 3) && (paramInt3 == -1) && (!Util.isNullOrNil(this.oHX)))
    {
      Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "cdntra using cdn trans,  wait cdn service callback! clientid:%s", new Object[] { this.oHX });
      this.xMr = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : errType = " + paramInt2 + ", errCode = " + paramInt3);
      this.xMr = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).jv(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    paramString = (fta)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((paramString.oOI != null) && ((!paramString.oOI.equals(this.NAc.field_appId)) || (!paramString.abRk.equals(this.NAc.field_clientAppDataId))))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "argument is not consistent");
      this.xMr = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).jv(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    if ((paramString.NkN < 0) || (paramString.NkN != this.NAc.field_totalLen) || (paramString.NkO < 0) || (paramString.NkO > this.NAc.field_totalLen))
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "dataLen, startPos or totalLen is incorrect");
      this.xMr = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).jv(this.id, "");
      AppMethodBeat.o(31082);
      return;
    }
    this.NAc.field_offset = paramString.NkO;
    params = this.NAc;
    if (n.bpS(paramString.oOL)) {}
    for (paramString = paramString.oOL;; paramString = "")
    {
      params.field_mediaSvrId = paramString;
      if (this.NAc.field_status != 105L) {
        break;
      }
      Log.w("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd STATUS PAUSE [" + this.NAc.field_mediaSvrId + "," + this.NAc.field_offset + "] ");
      this.xMr = false;
      this.handler.removeMessages(1);
      AppMethodBeat.o(31082);
      return;
    }
    if (this.NAc.field_offset == this.NAc.field_totalLen)
    {
      if (Util.isNullOrNil(this.NAc.field_mediaSvrId))
      {
        Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "finish upload but mediaid == null!");
        this.xMr = false;
        this.handler.removeMessages(1);
        ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).jv(this.id, "");
        AppMethodBeat.o(31082);
        return;
      }
      this.NAc.field_status = 199L;
    }
    while (this.NAc.field_status == 199L)
    {
      this.xMr = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).f(this.id, this.NAc.field_appId, (int)this.NAc.field_sdkVer, this.NAc.field_mediaSvrId);
      AppMethodBeat.o(31082);
      return;
      this.uploadedSize = this.NAc.field_offset;
    }
    if (doScene(dispatcher(), this.callback) < 0)
    {
      Log.e("MicroMsg.NetSceneUploadAppAttachForHandOff", "onGYNetEnd : doScene fail");
      this.xMr = false;
      this.handler.removeMessages(1);
      ((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).jv(this.id, "");
    }
    AppMethodBeat.o(31082);
  }
  
  public final int securityLimitCount()
  {
    return 3200;
  }
  
  public final p.b securityVerificationChecked(s params)
  {
    return p.b.ouh;
  }
  
  final class a
    extends Handler
  {
    private a() {}
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(31078);
      if ((paramMessage.what == 1) && (ao.f(ao.this)) && (ao.e(ao.this).field_status != 105L) && (((com.tencent.mm.plugin.handoff.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.handoff.a.a.class)).aK(ao.d(ao.this), ao.g(ao.this)))) {
        sendMessageDelayed(Message.obtain(this, 1, ao.d(ao.this)), ao.cGI());
      }
      AppMethodBeat.o(31078);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.ao
 * JD-Core Version:    0.7.0.1
 */