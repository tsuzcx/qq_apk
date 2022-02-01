package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.q;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.apn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.protocal.protobuf.bja;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bje;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.bjg;
import com.tencent.mm.protocal.protobuf.crk;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.cwx;
import com.tencent.mm.protocal.protobuf.elm;
import com.tencent.mm.protocal.protobuf.eoq;
import com.tencent.mm.protocal.protobuf.fiu;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;
import java.util.Map;

public final class ag
  implements af
{
  private byte[] KCN = null;
  private String KCO;
  private int KCP;
  private CdnImageView KCQ = null;
  private TextView KCR = null;
  private com.tencent.mm.modelsns.l KCV = null;
  private String KCW = "";
  private com.tencent.mm.modelsns.e KDj;
  private boolean KEC = false;
  private String KED;
  private boolean KEE = false;
  boolean KEF = false;
  boolean KEG = false;
  private boolean KEH = false;
  private boolean KEI = false;
  private WXMediaMessage KEJ = null;
  private String KEK = "";
  private String KEL = "";
  private String KEM;
  private String KEN;
  private int KEO = 0;
  private com.tencent.mm.modelsns.l KEP = null;
  private String KEQ = "";
  private String KER = "";
  private int KES;
  private int KET;
  private String KEU;
  private boolean KEV;
  private String KEW;
  private int KEX;
  private String KEZ;
  private int KFa = 0;
  private String KFb = "";
  private String KFc = "";
  String KFd = "";
  private g KFe;
  private b KFf;
  private com.tencent.mm.modelsns.d KFg;
  private c KFh;
  private h KFi;
  private f KFj;
  private int Kcp = 1;
  private String appId;
  private String appName;
  private View bvK = null;
  private String fUd;
  private String fUi;
  private String fUj;
  private int h = -1;
  final MMActivity iXq;
  private Bitmap lAx = null;
  String link = "";
  private String loN = "";
  private String loO = "";
  private String loP = "";
  public String lox = "";
  public String loy = "";
  String mSessionId;
  private String statExtStr;
  private String title = "";
  private TextView titleTv = null;
  private String videoUrl = "";
  private int w = -1;
  private boolean wRb = false;
  private flm webSearchInfo = null;
  private String xei = "";
  private int yAT = 0;
  
  public ag(MMActivity paramMMActivity)
  {
    this.iXq = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cst paramcst, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97928);
    if (this.KEE) {
      paramLinkedList = new be(4, this.iXq);
    }
    label367:
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramPInt.value = paramLinkedList.aOl;
      if (paramInt3 > com.tencent.mm.plugin.sns.c.a.JPj) {
        paramLinkedList.afW(4);
      }
      if (this.KCN == null)
      {
        q.bmg();
        paramPInt = com.tencent.mm.ay.d.LI(this.xei);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = BitmapUtil.extractThumbNail(paramPInt, 150, 150, false, false);
          Log.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.KCN = BitmapUtil.Bitmap2Bytes(paramPInt);
        }
      }
      paramLinkedList.bax(this.title).bav(this.link).baw(this.link).bas(paramString1);
      paramLinkedList.bav(Util.nullAs(this.iXq.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
      if (this.yAT == 15) {
        paramLinkedList.bav(Util.nullAs(this.iXq.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.KEE) {
        break;
      }
      if (!paramLinkedList.a(this.KCN, this.link, this.link, this.link, 3, "", "", "", "")) {}
      paramLinkedList.ct(this.Kcp, this.KCW);
      paramLinkedList.agb(this.KCP);
      paramLinkedList.baA(this.fUd);
      paramLinkedList.baB(this.KCO);
      paramString1 = this.statExtStr;
      paramLinkedList.Kck.statExtStr = Util.nullAsNil(paramString1);
      Log.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      paramLinkedList.afZ(paramInt1);
      if (!paramBoolean) {
        break label1884;
      }
      paramLinkedList.agc(1);
      paramLinkedList.hA(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1894;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.j.a.hhW();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          localObject1 = new elm();
          ((elm)localObject1).UserName = paramPInt;
          paramString1.add(localObject1);
        }
      }
      if (this.wRb)
      {
        paramLinkedList = new be(5, this.iXq);
      }
      else
      {
        if (this.KEF)
        {
          paramLinkedList = new be(30, this.iXq);
          localObject1 = this.KEQ;
          paramLinkedList.Kck.weappInfo.username = ((String)localObject1);
          localObject1 = this.KER;
          paramLinkedList.Kck.weappInfo.path = ((String)localObject1);
          paramInt2 = this.KES;
          paramLinkedList.Kck.weappInfo.version = paramInt2;
          paramInt2 = this.KET;
          paramLinkedList.Kck.weappInfo.qbu = paramInt2;
          localObject1 = this.KEU;
          paramLinkedList.Kck.weappInfo.fvj = ((String)localObject1);
          boolean bool = this.KEV;
          localObject1 = paramLinkedList.Kck.weappInfo;
          if (bool) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            ((fiu)localObject1).UIv = paramInt2;
            localObject1 = this.KEW;
            paramLinkedList.Kck.weappInfo.fXg = ((String)localObject1);
            paramInt2 = this.KEX;
            paramLinkedList.Kck.weappInfo.subType = paramInt2;
            localObject1 = this.KEZ;
            paramLinkedList.Kck.weappInfo.UIw = ((String)localObject1);
            break;
          }
        }
        if (this.KEG)
        {
          paramLinkedList = new be(41, this.iXq);
          localObject1 = new crk();
          ((crk)localObject1).appId = this.loN;
          ((crk)localObject1).path = this.loO;
          ((crk)localObject1).query = this.loP;
          paramLinkedList.Kck.liteappInfo = ((crk)localObject1);
        }
        else if (this.yAT == 11)
        {
          paramLinkedList = new be(18, this.iXq);
          localObject1 = new eoq();
          ((eoq)localObject1).lou = this.KFb;
          ((eoq)localObject1).lot = this.title;
          ((eoq)localObject1).lor = this.link;
          ((eoq)localObject1).lov = this.KFc;
          ((eoq)localObject1).los = this.KFa;
          ((eoq)localObject1).low = this.xei;
          ((eoq)localObject1).lox = this.lox;
          ((eoq)localObject1).loy = this.loy;
          paramLinkedList.Kco = ((eoq)localObject1);
          paramLinkedList.Kck.streamvideo = ((eoq)localObject1);
        }
        else if (this.yAT == 15)
        {
          paramLinkedList = new be(26, this.iXq);
          localObject1 = this.KFd;
          paramLinkedList.Kck.ContentObj.Sqt = ((String)localObject1);
        }
        else if ((this.yAT == 16) && (this.webSearchInfo != null))
        {
          localObject1 = new be(3, this.iXq);
          localObject2 = this.webSearchInfo;
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (localObject2 != null)
          {
            ((be)localObject1).webSearchInfo = ((flm)localObject2);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.yAT == 17)
        {
          localObject1 = new be(28, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KDj != null)
          {
            ((be)localObject1).a(this.KDj);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.yAT == 23)
        {
          localObject1 = new be(36, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KFi != null)
          {
            ((be)localObject1).a(this.KFi);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.yAT == 18)
        {
          localObject1 = new be(29, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KFe != null)
          {
            ((be)localObject1).a(this.KFe);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.yAT == 22)
        {
          localObject1 = new be(37, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KFe != null)
          {
            ((be)localObject1).a(this.KFe);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.yAT == 24)
        {
          localObject1 = new be(39, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KFf != null)
          {
            localObject2 = this.KFf;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((be)localObject1).Kck.ContentObj.Sqz = ((b)localObject2).mbf;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else if (this.yAT == 20)
        {
          localObject1 = new be(38, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KFh != null)
          {
            localObject2 = this.KFh;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((be)localObject1).Kck.ContentObj.Sqx = ((c)localObject2).mbg;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else if (this.yAT == 21)
        {
          localObject1 = new be(34, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KFg != null)
          {
            ((be)localObject1).a(this.KFg);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.yAT == 27)
        {
          localObject1 = new be(43, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KFg != null)
          {
            ((be)localObject1).a(this.KFg);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.yAT == 29)
        {
          localObject1 = new be(44, this.iXq);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.KFj != null)
          {
            localObject2 = this.KFj;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((be)localObject1).Kck.ContentObj.SqA = ((f)localObject2).mbj;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else
        {
          paramLinkedList = new be(3, this.iXq);
        }
      }
    }
    if (this.wRb) {
      if (this.KEJ == null) {
        break label2183;
      }
    }
    label2183:
    for (paramPInt = (WXVideoObject)this.KEJ.mediaObject;; paramPInt = null)
    {
      localObject1 = this.KCN;
      localObject2 = this.link;
      if (paramPInt == null)
      {
        paramString1 = this.link;
        label1593:
        if (paramPInt != null) {
          break label1661;
        }
      }
      label1661:
      for (paramPInt = this.link;; paramPInt = Util.nullAs(paramPInt.videoUrl, this.link))
      {
        paramLinkedList.a((byte[])localObject1, (String)localObject2, paramString1, paramPInt, 4, Util.nullAs(this.title, ""), Util.nullAs(this.KEL, ""), "", "");
        break;
        paramString1 = Util.nullAs(paramPInt.videoLowBandUrl, this.link);
        break label1593;
      }
      if (!Util.isNullOrNil(this.KED))
      {
        paramLinkedList.h(this.KED, "", "", this.w, this.h);
        break;
      }
      if (this.KCN == null) {
        break;
      }
      if (this.KEF)
      {
        paramString1 = this.KCN;
        if (paramString1 != null) {
          break label1808;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          Log.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.ct(this.KCN);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            Log.i("MicroMsg.LinkWidget", "use covert data");
            this.KCN = e.ct(paramString1);
          }
        }
        paramLinkedList.b(this.KCN, "", "");
        break;
        label1808:
        if (paramString1.length >= 4) {
          break label1821;
        }
      }
      label1821:
      paramInt2 = 1;
      int i = 0;
      for (;;)
      {
        paramInt3 = paramInt2;
        if (i >= 4) {
          break;
        }
        if (paramString1[i] != new byte[] { -119, 80, 78, 71 }[i]) {
          paramInt2 = 0;
        }
        i += 1;
      }
      label1884:
      paramLinkedList.agc(0);
      break label367;
      label1894:
      if (parami != null) {
        paramLinkedList.kG(parami.token, parami.TEk);
      }
      paramLinkedList.bL(paramString1);
      if (!Util.isNullOrNil(this.appId)) {
        paramLinkedList.bay(this.appId);
      }
      if (!Util.isNullOrNil(this.appName)) {
        paramLinkedList.baz(Util.nullAs(this.appName, ""));
      }
      if (this.KEH) {
        paramLinkedList.agb(5);
      }
      paramLinkedList.a(paramcst);
      if ((this.KEI) && (this.KEJ != null))
      {
        paramLinkedList.bat(this.KEJ.mediaTagName);
        paramLinkedList.aI(this.appId, this.KEJ.messageExt, this.KEJ.messageAction);
      }
      paramLinkedList.bau(paramString2);
      paramLinkedList.i(this.KEM, this.KEN, this.fUi, paramInt4, paramInt5);
      paramLinkedList.baD(this.fUj);
      paramLinkedList.setSessionId(this.mSessionId);
      paramLinkedList.afX(this.KEO);
      paramInt1 = paramLinkedList.in();
      if (this.KCV != null)
      {
        this.KCV.wQ(paramInt1);
        com.tencent.mm.plugin.sns.k.i.Kjb.c(this.KCV);
      }
      if (this.KEP != null)
      {
        this.KEP.wQ(paramInt1);
        j.Kjb.c(this.KEP);
        this.KEP.bpa();
      }
      aj.fOE().fNd();
      this.iXq.finish();
      AppMethodBeat.o(97928);
      return false;
    }
  }
  
  public final void ay(Bundle paramBundle)
  {
    AppMethodBeat.i(97926);
    this.KCV = com.tencent.mm.modelsns.l.x(this.iXq.getIntent());
    this.yAT = this.iXq.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.KFa = this.iXq.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.KFb = Util.nullAs(this.iXq.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.KFc = Util.nullAs(this.iXq.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.lox = Util.nullAs(this.iXq.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.loy = Util.nullAs(this.iXq.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.iXq.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.iXq.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.KCP = this.iXq.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.statExtStr = Util.nullAs(this.iXq.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.link = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.xei = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.KCN = this.iXq.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    paramBundle = this.iXq.getIntent().getStringExtra("KsnsUpload_imgPath");
    if ((this.KCN == null) && (!Util.isNullOrNil(paramBundle))) {
      this.KCN = u.aY(paramBundle, 0, -1);
    }
    if ((this.KCN == null) && (this.KEJ != null) && (this.KEJ.mediaObject != null) && ((this.KEJ.mediaObject instanceof WXImageObject))) {
      this.KCN = ((WXImageObject)this.KEJ.mediaObject).imageData;
    }
    this.wRb = this.iXq.getIntent().getBooleanExtra("ksnsis_video", false);
    this.KEE = this.iXq.getIntent().getBooleanExtra("ksnsis_music", false);
    this.KEF = this.iXq.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.KEG = this.iXq.getIntent().getBooleanExtra("ksnsis_liteapp", false);
    this.fUd = Util.nullAs(this.iXq.getIntent().getStringExtra("src_username"), "");
    this.KCO = Util.nullAs(this.iXq.getIntent().getStringExtra("src_displayname"), "");
    this.appId = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.iXq.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.KEH = this.iXq.getIntent().getBooleanExtra("KThrid_app", false);
    this.KEI = this.iXq.getIntent().getBooleanExtra("KSnsAction", false);
    this.KEM = Util.nullAs(this.iXq.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.KEN = Util.nullAs(this.iXq.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.fUi = Util.nullAs(this.iXq.getIntent().getStringExtra("JsAppId"), "");
    this.fUj = Util.nullAs(this.iXq.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.iXq.getIntent().getStringExtra("reportSessionId"), "");
    this.KEO = this.iXq.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.KFd = this.iXq.getIntent().getStringExtra("fav_note_xml");
    this.KEQ = Util.nullAs(this.iXq.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.KER = Util.nullAs(this.iXq.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.KES = this.iXq.getIntent().getIntExtra("KsnsUpload_BrandVersion", 0);
    this.KET = this.iXq.getIntent().getIntExtra("KsnsUpload_BrandVersionType", 0);
    this.KEU = Util.nullAs(this.iXq.getIntent().getStringExtra("KsnsUpload_BrandShareActionId"), "");
    this.KEV = this.iXq.getIntent().getBooleanExtra("KsnsUpload_isGame", false);
    this.KEW = Util.nullAs(this.iXq.getIntent().getStringExtra("KsnsUpload_MessageExtraData"), "");
    this.KEX = this.iXq.getIntent().getIntExtra("KsnsUpload_SubType", 0);
    this.KEZ = Util.nullAs(this.iXq.getIntent().getStringExtra("KsnsUpload_PreloadResouces"), "");
    if (this.KEG)
    {
      this.loN = Util.nullAs(this.iXq.getIntent().getStringExtra("KsnsUpload_LiteAppId"), "");
      this.loO = Util.nullAs(this.iXq.getIntent().getStringExtra("KsnsUpload_LiteAppPath"), "");
      this.loP = Util.nullAs(this.iXq.getIntent().getStringExtra("KsnsUpload_LiteAppQuery"), "");
    }
    this.KED = Util.nullAs(this.iXq.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.KED.startsWith("http://mmsns.qpic.cn")) || (this.KED.startsWith("https://mmsns.qpic.cn")))
    {
      this.xei = this.KED;
      this.KCN = null;
      Log.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.KED });
    }
    paramBundle = this.iXq.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.KEJ = new SendMessageToWX.Req(paramBundle).message;
      if (Util.isNullOrNil(this.title)) {
        this.title = this.KEJ.title;
      }
      if (Util.isNullOrNil(this.KEL)) {
        this.KEL = this.KEJ.description;
      }
      if (Util.isNullOrNil(this.KCN)) {
        this.KCN = this.KEJ.thumbData;
      }
    }
    paramBundle = this.iXq.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.webSearchInfo = new flm();
    }
    try
    {
      this.webSearchInfo.parseFrom(paramBundle);
      paramBundle = this.iXq.getIntent().getStringExtra("KSnsStrId");
      Object localObject = Util.nullAs(this.iXq.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = aj.fOI().bbl((String)localObject);
      if (!Util.isNullOrNil(paramBundle))
      {
        this.KEP = com.tencent.mm.modelsns.l.wO(706);
        this.KEP.wS(this.KEP.mbo).Xg(System.currentTimeMillis()).wS(this.KEP.mbp).wS(1).Xg(paramBundle);
        if (localObject != null)
        {
          this.KEP.wR(((SnsInfo)localObject).field_type);
          this.KEP.gx(((SnsInfo)localObject).isAd()).Xf(((SnsInfo)localObject).getUxinfo()).Xf(this.link);
        }
        j.Kjb.b(this.KEP);
      }
      if (this.iXq.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
      {
        this.Kcp = 1;
        this.KCW = Util.nullAs(this.iXq.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        paramBundle = this.iXq.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!Util.isNullOrNil(paramBundle))
        {
          localObject = XmlParser.parseXml(paramBundle, "finderFeed", null);
          if (localObject != null)
          {
            this.KDj = new com.tencent.mm.modelsns.e();
            this.KDj.i("", (Map)localObject);
          }
        }
        localObject = this.iXq.getIntent().getStringExtra("ksnsupload_finder_topic_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderTopic", null);
          if (localObject != null)
          {
            this.KFe = new g();
            this.KFe.i("", (Map)localObject);
          }
        }
        localObject = this.iXq.getIntent().getStringExtra("ksnsupload_finder_activity_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderTopic", null);
          if (localObject != null)
          {
            this.KFf = new b();
            this.KFf.mbf = com.tencent.mm.plugin.findersdk.a.k.y("", (Map)localObject);
          }
        }
        localObject = this.iXq.getIntent().getStringExtra("ksnsupload_finder_album_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderColumn", null);
          if (localObject != null)
          {
            this.KFh = new c();
            this.KFh.i("", (Map)localObject);
          }
        }
        localObject = this.iXq.getIntent().getStringExtra("ksnsupload_finder_live_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderLive", null);
          if (localObject != null)
          {
            this.KFg = new com.tencent.mm.modelsns.d();
            this.KFg.i("", (Map)localObject);
          }
        }
        if (!Util.isNullOrNil(this.iXq.getIntent().getStringExtra("ksnsupload_mega_video_object_xml")))
        {
          paramBundle = XmlParser.parseXml(paramBundle, "finderMegaVideo", null);
          if (paramBundle != null)
          {
            this.KFi = new h();
            this.KFi.i("", paramBundle);
          }
        }
        paramBundle = this.iXq.getIntent().getStringExtra("ksnsupload_finder_poi_xml");
        if (!Util.isNullOrNil(paramBundle))
        {
          paramBundle = XmlParser.parseXml(paramBundle, "finder", null);
          if (paramBundle != null)
          {
            this.KFj = new f();
            this.KFj.i("", paramBundle);
          }
        }
        AppMethodBeat.o(97926);
        return;
      }
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.LinkWidget", paramBundle, "parse web search info failed", new Object[0]);
        this.webSearchInfo = null;
        continue;
        this.Kcp = 0;
      }
    }
  }
  
  public final void az(Bundle paramBundle) {}
  
  public final boolean fTA()
  {
    AppMethodBeat.i(97929);
    if ((this.lAx != null) && (!this.lAx.isRecycled()) && (this.KEC)) {
      this.lAx.recycle();
    }
    AppMethodBeat.o(97929);
    return false;
  }
  
  public final boolean fTw()
  {
    return true;
  }
  
  public final View fTx()
  {
    AppMethodBeat.i(97927);
    this.bvK = com.tencent.mm.ui.ad.kS(this.iXq).inflate(i.g.upload_media_link, null);
    if (!Util.isNullOrNil(this.link)) {
      this.bvK.setOnClickListener(new ag.1(this));
    }
    this.KCQ = ((CdnImageView)this.bvK.findViewById(i.f.image_left));
    this.titleTv = ((TextView)this.bvK.findViewById(i.f.titletext));
    this.KCR = ((TextView)this.bvK.findViewById(i.f.righttext));
    int i;
    label162:
    Object localObject;
    if ((!this.wRb) && (!this.KEE))
    {
      if ((this.webSearchInfo != null) && (!Util.isNullOrNil(this.webSearchInfo.PyQ)))
      {
        i = 1;
        if ((i == 0) && (this.KEX != 1)) {
          break label313;
        }
      }
    }
    else
    {
      this.bvK.findViewById(i.f.state).setVisibility(0);
      localObject = com.tencent.mm.model.ad.beh().I(this.mSessionId, true);
      if ((localObject == null) || (1 != ((ad.b)localObject).getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", -1))) {
        break label331;
      }
      localObject = MMApplicationContext.getContext().getString(i.j.mp_pay_content);
      this.KCR.setText((CharSequence)localObject);
      this.KCR.setVisibility(0);
      label216:
      if (Util.isNullOrNil(this.title)) {
        break label354;
      }
      this.titleTv.setText(this.title);
      if (this.KCR.getVisibility() != 0) {
        break label343;
      }
      this.titleTv.setMaxLines(1);
      label255:
      if (Util.isNullOrNil(this.xei)) {
        break label1397;
      }
      this.KCQ.setVisibility(0);
      this.KCQ.setUrl(this.xei);
    }
    label313:
    label1857:
    label2114:
    for (;;)
    {
      t.b(this.KCQ, this.iXq);
      localObject = this.bvK;
      AppMethodBeat.o(97927);
      return localObject;
      i = 0;
      break;
      this.bvK.findViewById(i.f.state).setVisibility(8);
      break label162;
      label331:
      this.KCR.setVisibility(8);
      break label216;
      label343:
      this.titleTv.setMaxLines(2);
      break label255;
      label354:
      if ((this.yAT == 17) && (this.KDj != null))
      {
        if ((Util.isNullOrNil(this.KDj.mbi.nickname)) && (!Util.isNullOrNil(this.KDj.mbi.desc)))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.KDj.mbi.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.KDj.mbi.desc))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.KDj.mbi.nickname + ": " + this.KDj.mbi.desc));
          break label255;
        }
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.iXq.getString(i.j.sns_share_finder_feed_title, new Object[] { this.KDj.mbi.nickname })));
        break label255;
      }
      if ((this.yAT == 23) && (this.KFi != null))
      {
        if ((Util.isNullOrNil(this.KFi.mbk.nickname)) && (!Util.isNullOrNil(this.KFi.mbk.desc)))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.KFi.mbk.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.KFi.mbk.desc))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.KFi.mbk.nickname + ": " + this.KFi.mbk.desc));
          break label255;
        }
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.iXq.getString(i.j.sns_share_finder_feed_title, new Object[] { this.KFi.mbk.nickname })));
        break label255;
      }
      if (((this.yAT == 18) || (this.yAT == 22)) && (this.KFe != null))
      {
        localObject = this.iXq.getString(i.j.app_finder_topic);
        if (this.KFe.mbf != null) {
          if (this.KFe.mbf.wXA != 1) {
            break label872;
          }
        }
        label872:
        for (localObject = MMApplicationContext.getContext().getString(i.j.sns_share_finder_topic_card_prefix, new Object[] { this.KFe.mbf.topic });; localObject = this.KFe.mbf.topic)
        {
          this.KCR.setVisibility(0);
          this.KCR.setText(this.KFe.mbf.desc);
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, (CharSequence)localObject));
          break;
        }
      }
      String str;
      if ((this.yAT == 24) && (this.KFf != null))
      {
        str = this.iXq.getString(i.j.app_finder_topic);
        localObject = str;
        if (this.KFf.mbf != null)
        {
          localObject = str;
          if (this.KFf.mbf.STw != null) {
            if (this.KFf.mbf.wXA != 7) {
              break label1044;
            }
          }
        }
        for (localObject = MMApplicationContext.getContext().getString(i.j.sns_share_finder_activity_card, new Object[] { this.KFf.mbf.STw.SCS, this.KFf.mbf.STw.SCR });; localObject = this.KFf.mbf.topic)
        {
          this.KCR.setVisibility(0);
          this.KCR.setText(this.KFf.mbf.desc);
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, (CharSequence)localObject));
          break;
        }
      }
      if ((this.yAT == 20) && (this.KFh != null))
      {
        localObject = this.KFh.mbg.title;
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, (CharSequence)localObject));
        break label255;
      }
      if ((this.yAT == 21) && (this.KFg != null))
      {
        if ((Util.isNullOrNil(this.KFg.mbh.nickName)) && (!Util.isNullOrNil(this.KFg.mbh.desc)))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.KFg.mbh.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.KFg.mbh.desc))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.KFg.mbh.nickName + ": " + this.KFg.mbh.desc));
          break label255;
        }
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, this.iXq.getString(i.j.sns_share_finder_live_title, new Object[] { this.KFg.mbh.nickName })));
        break label255;
      }
      if ((this.yAT == 29) && (this.KFj != null))
      {
        localObject = "";
        if (this.KFj.mbj != null)
        {
          localObject = this.KFj.mbj.poiName;
          this.KCR.setVisibility(0);
          this.KCR.setText(this.KFj.mbj.xzN);
        }
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.iXq, (CharSequence)localObject));
        break label255;
      }
      this.titleTv.setText(bm.bcg(this.link));
      break label255;
      label1397:
      if (!Util.isNullOrNil(this.KCN))
      {
        this.KCQ.setVisibility(0);
        this.lAx = BitmapUtil.decodeByteArray(this.KCN);
        this.KCQ.setImageBitmap(this.lAx);
        this.KEC = true;
      }
      else if (!Util.isNullOrNil(this.KFd))
      {
        this.KCQ.setImageResource(i.i.note_sns_link_default);
        this.KCQ.setVisibility(0);
      }
      else if (this.yAT == 17)
      {
        if ((this.KDj != null) && (!this.KDj.mbi.mediaList.isEmpty()) && (!Util.isNullOrNil(((bjc)this.KDj.mbi.mediaList.get(0)).thumbUrl))) {
          this.KCQ.setUrl(((bjc)this.KDj.mbi.mediaList.get(0)).thumbUrl);
        }
        this.KCQ.setVisibility(0);
      }
      else
      {
        if (this.yAT == 23)
        {
          if ((this.KFi != null) && (!this.KFi.mbk.mediaList.isEmpty()))
          {
            if (Util.isNullOrNil(((cww)this.KFi.mbk.mediaList.get(0)).coverUrl)) {
              break label1668;
            }
            this.KCQ.setUrl(((cww)this.KFi.mbk.mediaList.get(0)).coverUrl);
          }
          for (;;)
          {
            this.KCQ.setVisibility(0);
            break;
            if (!Util.isNullOrNil(((cww)this.KFi.mbk.mediaList.get(0)).thumbUrl)) {
              this.KCQ.setUrl(((cww)this.KFi.mbk.mediaList.get(0)).thumbUrl);
            }
          }
        }
        if ((this.yAT == 18) || (this.yAT == 22))
        {
          if ((this.KFe != null) && (this.KFe.mbf != null)) {
            this.KCQ.setUrl(this.KFe.mbf.iconUrl);
          }
          this.KCQ.setVisibility(0);
        }
        else
        {
          if (this.yAT == 24)
          {
            if ((this.KFf != null) && (this.KFf.mbf != null))
            {
              if (Util.isNullOrNil(this.KFf.mbf.iconUrl)) {
                break label1857;
              }
              this.KCQ.setUrl(this.KFf.mbf.iconUrl);
            }
            for (;;)
            {
              this.KCQ.setVisibility(0);
              break;
              this.KCQ.setImageDrawable(com.tencent.mm.ci.a.m(this.KCQ.getContext(), i.i.icon_filled_activity));
            }
          }
          if (this.yAT == 20)
          {
            if (this.KFh != null)
            {
              localObject = (String)this.KFh.mbg.STk.get(0);
              str = (String)this.KFh.mbg.STl.get(0);
              this.KCQ.setUrl((String)localObject + str);
            }
            this.KCQ.setVisibility(0);
          }
          else if (this.yAT == 21)
          {
            if ((this.KFg != null) && (!this.KFg.mbh.coverUrl.isEmpty()) && (!Util.isNullOrNil(this.KFg.mbh.coverUrl))) {
              this.KCQ.setUrl(this.KFg.mbh.coverUrl);
            }
            this.KCQ.setVisibility(0);
          }
          else
          {
            if (this.yAT == 29)
            {
              if ((this.KFj != null) && (this.KFj.mbj != null))
              {
                if (Util.isNullOrNil(this.KFj.mbj.QSw)) {
                  break label2114;
                }
                this.KCQ.setUrl(this.KFj.mbj.QSw);
              }
              for (;;)
              {
                this.KCQ.setVisibility(0);
                break;
                this.KCQ.setImageDrawable(com.tencent.mm.ci.a.m(this.KCQ.getContext(), i.i.icons_outlined_location));
              }
            }
            this.KCQ.setImageResource(i.i.app_attach_file_icon_webpage);
            this.KCQ.setVisibility(0);
          }
        }
      }
    }
  }
  
  public final boolean fTy()
  {
    return true;
  }
  
  public final boolean fTz()
  {
    return true;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ag
 * JD-Core Version:    0.7.0.1
 */