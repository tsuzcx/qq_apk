package com.tencent.mm.pluginsdk.model.app;

import android.graphics.BitmapFactory.Options;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.p.b;
import com.tencent.mm.autogen.a.aec;
import com.tencent.mm.autogen.a.aec.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.g.d;
import com.tencent.mm.j.a.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.l;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.protocal.protobuf.ewx;
import com.tencent.mm.protocal.protobuf.ewy;
import com.tencent.mm.protocal.protobuf.fhl;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.fu;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.viewitems.o;
import com.tencent.mm.ui.chatting.viewitems.o.d;
import java.util.Locale;

public final class al
  extends p
  implements m
{
  private aec QsB;
  private a XSU;
  private com.tencent.mm.autogen.a.s XSV;
  private c XSZ;
  private boolean XTa;
  private a XTb;
  private com.tencent.mm.am.h callback;
  private cc hTm;
  private int hYn;
  private String mSessionId;
  private long msgId;
  private d mxU;
  private com.tencent.mm.am.c rr;
  
  public al(long paramLong, d paramd, a parama, String paramString, int paramInt, a parama1)
  {
    this(paramLong, false, paramd, parama, paramString, null);
    this.hYn = paramInt;
    this.XSU = parama1;
  }
  
  public al(long paramLong, boolean paramBoolean, d paramd, a parama, String paramString, c paramc)
  {
    AppMethodBeat.i(31057);
    this.msgId = 0L;
    this.mxU = null;
    this.XSZ = null;
    this.hTm = null;
    this.XTa = false;
    this.hYn = 0;
    this.XTb = null;
    this.msgId = paramLong;
    this.mSessionId = paramString;
    this.mxU = paramd;
    this.XTb = parama;
    this.XTa = paramBoolean;
    this.XSZ = paramc;
    parama = new c.a();
    parama.otE = new ewx();
    parama.otF = new ewy();
    parama.uri = "/cgi-bin/micromsg-bin/sendappmsg";
    parama.funcId = 222;
    parama.otG = 107;
    parama.respCmdId = 1000000107;
    this.rr = parama.bEF();
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig NetSceneSendAppMsgForCdn msgId[%d], sceneResult[%s], sessionId[%s], attachInfo[%s]. stack[%s]", new Object[] { Long.valueOf(paramLong), paramd, paramString, paramc, Util.getStack() });
    AppMethodBeat.o(31057);
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(31058);
    this.callback = paramh;
    bh.bCz();
    this.hTm = com.tencent.mm.model.c.bzD().sl(this.msgId);
    if ((this.hTm == null) || (this.hTm.field_msgId != this.msgId))
    {
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene msginfo null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.XTb.eF(3, -1);
      AppMethodBeat.o(31058);
      return -1;
    }
    k.b localb = k.b.Hf(this.hTm.field_content);
    if (localb == null)
    {
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra doscene AppMessage.Content.parse null id:%d", new Object[] { Long.valueOf(this.msgId) });
      this.XTb.eF(3, -1);
    }
    if ((localb != null) && (localb.type == 6) && (this.hTm.getType() == 10000))
    {
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "stop send revoke msg(%s)", new Object[] { Long.valueOf(this.hTm.field_msgId) });
      AppMethodBeat.o(31058);
      return -1;
    }
    if ((localb != null) && (localb.type == 6) && ((this.hTm.field_msgSvrId <= 0L) || (this.hTm.field_status != 2)))
    {
      paramh = (com.tencent.mm.message.a.b)localb.aK(com.tencent.mm.message.a.b.class);
      if ((paramh != null) && ((paramh.nVD != 0L) || (!Util.isNullOrNil(paramh.nVE))))
      {
        paramh.reset();
        this.hTm.setContent(k.b.a(localb, null, null));
        ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().a(this.hTm.field_msgId, this.hTm);
      }
    }
    ewx localewx = (ewx)c.b.b(this.rr.otB);
    fu localfu = new fu();
    localfu.oOI = localb.appId;
    localfu.YHk = (this.hTm.field_talker + this.hTm.field_msgId + "T" + this.hTm.getCreateTime());
    localfu.CreateTime = ((int)Util.nowSecond());
    localfu.IMg = this.hTm.field_talker;
    localfu.IMh = z.bAM();
    localfu.vhJ = localb.type;
    localfu.YHj = localb.sdkVer;
    localfu.IcB = localb.nRg;
    paramh = a.a.aOb().o(this.hTm);
    ad.b localb1;
    fhn localfhn;
    if (!Util.isNullOrNil(paramh))
    {
      localfu.YFJ = paramh;
      localfu.YHn = localb.iad;
      localfu.YHo = localb.iae;
      localfu.YHp = localb.iaf;
      if (this.XSU != null)
      {
        localfu.YHq = this.XSU.XRT;
        localfu.IcK = this.XSU.pkgName;
      }
      localewx.abzc = this.hYn;
      localb1 = com.tencent.mm.ui.transmit.c.bCJ(this.mSessionId);
      if (localb1 != null)
      {
        this.QsB = new aec();
        this.QsB.iiq.url = localb.url;
        this.QsB.iiq.iir = localb1.getString("prePublishId", "");
        this.QsB.iiq.iit = localb1.getString("preUsername", "");
        this.QsB.iiq.iiu = localb1.getString("preChatName", "");
        this.QsB.iiq.iiv = localb1.getInt("preMsgIndex", 0);
        this.QsB.iiq.iiz = localb1.getInt("sendAppMsgScene", 0);
        this.QsB.iiq.iiA = localb1.getInt("getA8KeyScene", 0);
        this.QsB.iiq.iiB = localb1.getString("referUrl", null);
        this.QsB.iiq.iiC = localb1.getString("adExtStr", null);
        this.QsB.iiq.iiw = this.hTm.field_talker;
        this.QsB.iiq.iiD = localb.title;
        this.QsB.iiq.iiF = localb.description;
        bh.bCz();
        paramh = com.tencent.mm.model.c.bzA().JE(this.hTm.field_talker);
        if (paramh != null) {
          this.QsB.iiq.iix = paramh.aSU();
        }
        this.QsB.iiq.iiy = com.tencent.mm.model.v.getMembersCountByChatRoomName(this.hTm.field_talker);
        str = "";
        paramh = str;
        if (localb.iah != null)
        {
          localfhn = new fhn();
          paramh = Base64.decode(localb.iah, 0);
        }
      }
    }
    try
    {
      localfhn.parseFrom(paramh);
      paramh = str;
      if (localfhn.abIe != null) {
        paramh = localfhn.abIe.ICZ;
      }
    }
    catch (Exception paramh)
    {
      for (;;)
      {
        int i;
        int j;
        label1168:
        boolean bool;
        label1212:
        int k;
        int m;
        label1869:
        label1874:
        label1902:
        paramh = str;
      }
    }
    localewx.abza = String.format(Locale.US, "prePublishId=%s&preUserName=%s&preChatName=%s&preChatType=%d&getA8KeyScene=%d&sourceAppId=%s", new Object[] { this.QsB.iiq.iir, this.QsB.iiq.iit, this.QsB.iiq.iiu, Integer.valueOf(ac.aX(this.QsB.iiq.iit, this.QsB.iiq.iiu)), Integer.valueOf(this.QsB.iiq.iiA), paramh });
    if ((localb1 != null) && (localb.type == 33))
    {
      this.XSV = new com.tencent.mm.autogen.a.s();
      i = localb1.getInt("fromScene", 1);
      this.XSV.hzu.scene = i;
      j = localb1.getInt("appservicetype", 0);
      this.XSV.hzu.appServiceType = j;
      paramh = localb1.getString("preChatName", "");
      if (2 == i)
      {
        str = localb1.getString("preUsername", "");
        this.XSV.hzu.hzx = (paramh + ":" + str);
        paramh = this.hTm.field_talker;
        bool = localb1.getBoolean("moreRetrAction", false);
        if (!paramh.endsWith("@chatroom")) {
          break label1874;
        }
        paramh = this.XSV.hzu;
        if (!bool) {
          break label1869;
        }
        i = 5;
        paramh.action = i;
        this.XSV.hzu.hzw = (localb.nTW + 1);
        this.XSV.hzu.hzy = localb.nTC;
        this.XSV.hzu.hzv = localb.nTD;
        this.XSV.hzu.appId = localb.nTE;
        this.XSV.hzu.appVersion = localb.nTX;
        this.XSV.hzu.hzA = Util.nowSecond();
        this.XSV.hzu.hzB = 1;
        this.XSV.hzu.hzD = localb.nTI;
      }
    }
    else
    {
      Log.d("MicroMsg.NetSceneSendAppMsgForCdn", "stev summerbig SnsPostOperationFields: ShareUrlOriginal=%s, ShareUrlOpen=%s, JsAppId=%s", new Object[] { localb.iad, localb.iae, localb.iaf });
      k = 0;
      m = 0;
      j = m;
      i = k;
      if (!Util.isNullOrNil(this.hTm.field_imgPath))
      {
        paramh = BitmapUtil.getImageOptions(r.bKa().NY(this.hTm.field_imgPath));
        j = m;
        i = k;
        if (paramh != null)
        {
          i = paramh.outWidth;
          j = paramh.outHeight;
        }
      }
      if (this.mxU.aLG())
      {
        Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn app sceneResult crc[%d], safecdn[%b], hitcachetype[%d], aeskey[%s]", new Object[] { Integer.valueOf(this.mxU.field_filecrc), Boolean.valueOf(this.mxU.field_upload_by_safecdn), Integer.valueOf(this.mxU.field_UploadHitCacheType), this.mxU.field_aesKey });
        this.mxU.field_aesKey = "";
        localewx.abzb = 1;
      }
      localewx.ZaP = this.mxU.field_filecrc;
      paramh = null;
      if (this.XTa) {
        paramh = "@cdn_" + this.mxU.field_fileId + "_" + this.mxU.field_aesKey + "_1";
      }
      localfu.nUB = k.b.a(localb, paramh, this.mxU, i, j);
      localewx.abyY = localfu;
      if ((this.XSZ != null) && ((localb.nRh != 0) || (localb.nRd > 26214400)))
      {
        localewx.pSi = this.XSZ.field_signature;
        localewx.YIE = com.tencent.mm.g.a.lwb;
      }
      localewx.Md5 = localb.filemd5;
      if (!Util.isNullOrNil(this.mxU.field_filemd5)) {
        break label1902;
      }
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig sceneResult filemd5 is null use content.filemd5[%s]", new Object[] { localb.filemd5 });
    }
    for (;;)
    {
      if (((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).ifAddTicketByActionFlag(this.hTm.field_talker)) {
        localewx.ZaR = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxH(this.hTm.field_talker);
      }
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig file md5[%s], HitMd5[%d], signature[%s], type[%d], sceneResult[%s], fromScene[%s]", new Object[] { localewx.Md5, Integer.valueOf(localewx.abzb), Util.secPrint(localewx.pSi), Integer.valueOf(localewx.YIE), this.mxU, localewx.abza });
      i = dispatch(paramg, this.rr, this);
      AppMethodBeat.o(31058);
      return i;
      localfu.YFJ = bt.bCQ();
      break;
      this.XSV.hzu.hzx = paramh;
      break label1168;
      i = 2;
      break label1212;
      paramh = this.XSV.hzu;
      if (bool) {}
      for (i = 4;; i = 1)
      {
        paramh.action = i;
        break;
      }
      localewx.Md5 = this.mxU.field_filemd5;
    }
  }
  
  public final int getType()
  {
    return 222;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(31059);
    paramArrayOfByte = (ewx)c.b.b(((com.tencent.mm.am.c)params).otB);
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig cdntra onGYNetEnd [%d,%d,%s] msgId:%d, oldContent[%s], newContent[%s]", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.msgId), Util.secPrint(this.hTm.field_content), paramArrayOfByte.abyY.nUB });
    paramArrayOfByte = (ewy)c.c.b(((com.tencent.mm.am.c)params).otC);
    if ((paramArrayOfByte != null) && ((paramInt2 == 4) || ((paramInt2 == 0) && (paramInt3 == 0)))) {
      ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).setEnSendMsgActionFlag(paramArrayOfByte.ZaS);
    }
    bh.bCz();
    params = com.tencent.mm.model.c.bzD().sl(this.hTm.field_msgId);
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      if ((paramInt2 == 4) && (paramInt3 == 102))
      {
        Log.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn MM_ERR_GET_AESKEY_FAILED");
        this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
        this.XTb.eF(paramInt2, paramInt3);
        AppMethodBeat.o(31059);
        return;
      }
      params.setStatus(5);
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(params.field_msgId, params);
      Log.e("MicroMsg.NetSceneSendAppMsgForCdn", "summerbig send app msg failed, err=" + paramInt2 + "," + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.XTb.eF(paramInt2, paramInt3);
      AppMethodBeat.o(31059);
      return;
    }
    Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn svrid[%d]. aeskey[%s], old content[%s]", new Object[] { Long.valueOf(paramArrayOfByte.Njv), paramArrayOfByte.ZaN, Util.secPrint(params.field_content) });
    if ((this.mxU != null) && (this.mxU.aLG()))
    {
      if (Util.isNullOrNil(paramArrayOfByte.ZaN)) {
        break label753;
      }
      k.b localb = k.b.Hf(params.field_content);
      localb.aesKey = paramArrayOfByte.ZaN;
      params.setContent(k.b.a(localb, null, null));
      Log.i("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn aeskey[%s], new content[%s]", new Object[] { paramArrayOfByte.ZaN, Util.secPrint(params.field_content) });
    }
    for (;;)
    {
      params.setStatus(2);
      params.gX(paramArrayOfByte.Njv);
      bh.bCz();
      com.tencent.mm.model.c.bzD().a(params.field_msgId, params);
      ((f)com.tencent.mm.kernel.h.ax(f.class)).tl(params.field_msgId);
      com.tencent.mm.modelstat.b.oUZ.d(params, l.v(params));
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      this.XTb.eF(paramInt2, paramInt3);
      if ((this.QsB != null) && (!Util.isNullOrNil(this.QsB.iiq.url)))
      {
        this.QsB.iiq.iis = ("msg_" + Long.toString(paramArrayOfByte.Njv));
        this.QsB.publish();
      }
      if (this.XSV != null)
      {
        this.XSV.hzu.hzz = ("msg_" + params.field_msgSvrId);
        this.XSV.publish();
      }
      paramString = k.b.Hf(params.field_content);
      if (paramString != null)
      {
        if (au.bwG(params.field_talker))
        {
          paramArrayOfByte = (com.tencent.mm.message.a)paramString.aK(com.tencent.mm.message.a.class);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.nPl)) {
            ab.a(params, paramString);
          }
          ((com.tencent.mm.chatroom.plugin.a)com.tencent.mm.kernel.h.az(com.tencent.mm.chatroom.plugin.a.class)).handleGroupToolByReceiverAppMsg(params);
        }
        if (paramString.type == 6)
        {
          paramArrayOfByte = o.aePR;
          o.d.a(6, paramString, params);
        }
      }
      AppMethodBeat.o(31059);
      return;
      label753:
      Log.w("MicroMsg.NetSceneSendAppMsgForCdn", "summersafecdn need aeskey but ret null");
    }
  }
  
  public final p.b securityVerificationChecked(com.tencent.mm.network.s params)
  {
    return p.b.ouh;
  }
  
  static abstract interface a
  {
    public abstract void eF(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al
 * JD-Core Version:    0.7.0.1
 */