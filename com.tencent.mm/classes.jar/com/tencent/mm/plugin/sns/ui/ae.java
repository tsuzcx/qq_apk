package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.h;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.be;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.cio;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cok;
import com.tencent.mm.protocal.protobuf.col;
import com.tencent.mm.protocal.protobuf.ebm;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;
import java.util.Map;

public final class ae
  implements ad
{
  private int DPi = 1;
  private byte[] EpE = null;
  private String EpF;
  private int EpG;
  private CdnImageView EpH = null;
  private TextView EpI = null;
  private k EpM = null;
  private String EpN = "";
  private com.tencent.mm.modelsns.e EpW;
  private int ErA;
  private String ErB;
  private boolean ErC;
  private String ErD;
  private int ErE;
  private String ErF;
  private int ErG = 0;
  private String ErH = "";
  private String ErI = "";
  String ErJ = "";
  private f ErK;
  private com.tencent.mm.modelsns.b ErL;
  private com.tencent.mm.modelsns.d ErM;
  private com.tencent.mm.modelsns.c ErN;
  private com.tencent.mm.modelsns.g ErO;
  private boolean Erj = false;
  private String Erk;
  private boolean Erl = false;
  boolean Erm = false;
  boolean Ern = false;
  private boolean Ero = false;
  private boolean Erp = false;
  private WXMediaMessage Erq = null;
  private String Err = "";
  private String Ers = "";
  private String Ert;
  private String Eru;
  private int Erv = 0;
  private k Erw = null;
  private String Erx = "";
  private String Ery = "";
  private int Erz;
  private String appId;
  private String appName;
  private String eag;
  private String eal;
  private String eam;
  final MMActivity gte;
  private int h = -1;
  private Bitmap iKs = null;
  public String izf = "";
  public String izg = "";
  private String izu = "";
  private String izv = "";
  private String izw = "";
  String link = "";
  String mSessionId;
  private View sc = null;
  private String statExtStr;
  private String title = "";
  private TextView titleTv = null;
  private boolean tkD = false;
  private String twt = "";
  private String videoUrl = "";
  private int vjQ = 0;
  private int w = -1;
  private fat webSearchInfo = null;
  
  public ae(MMActivity paramMMActivity)
  {
    this.gte = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, cjy paramcjy, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97928);
    if (this.Erl) {
      paramLinkedList = new bf(4, this.gte);
    }
    label367:
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramPInt.value = paramLinkedList.beK;
      if (paramInt3 > com.tencent.mm.plugin.sns.c.a.DCT) {
        paramLinkedList.YF(4);
      }
      if (this.EpE == null)
      {
        q.bcQ();
        paramPInt = com.tencent.mm.av.d.EP(this.twt);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = BitmapUtil.extractThumbNail(paramPInt, 150, 150, false, false);
          Log.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.EpE = BitmapUtil.Bitmap2Bytes(paramPInt);
        }
      }
      paramLinkedList.aPB(this.title).aPz(this.link).aPA(this.link).aPw(paramString1);
      paramLinkedList.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
      if (this.vjQ == 15) {
        paramLinkedList.aPz(Util.nullAs(this.gte.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.Erl) {
        break;
      }
      if (!paramLinkedList.a(this.EpE, this.link, this.link, this.link, 3, "", "", "", "")) {}
      paramLinkedList.ct(this.DPi, this.EpN);
      paramLinkedList.YK(this.EpG);
      paramLinkedList.aPE(this.eag);
      paramLinkedList.aPF(this.EpF);
      paramString1 = this.statExtStr;
      paramLinkedList.DPd.statExtStr = Util.nullAsNil(paramString1);
      Log.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      paramLinkedList.YI(paramInt1);
      if (!paramBoolean) {
        break label1877;
      }
      paramLinkedList.YL(1);
      paramLinkedList.gR(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1887;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.i.a.gnq();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          localObject1 = new ebm();
          ((ebm)localObject1).UserName = paramPInt;
          paramString1.add(localObject1);
        }
      }
      if (this.tkD)
      {
        paramLinkedList = new bf(5, this.gte);
      }
      else
      {
        if (this.Erm)
        {
          paramLinkedList = new bf(30, this.gte);
          localObject1 = this.Erx;
          paramLinkedList.DPd.weappInfo.username = ((String)localObject1);
          localObject1 = this.Ery;
          paramLinkedList.DPd.weappInfo.path = ((String)localObject1);
          paramInt2 = this.Erz;
          paramLinkedList.DPd.weappInfo.version = paramInt2;
          paramInt2 = this.ErA;
          paramLinkedList.DPd.weappInfo.nbf = paramInt2;
          localObject1 = this.ErB;
          paramLinkedList.DPd.weappInfo.dCC = ((String)localObject1);
          boolean bool = this.ErC;
          localObject1 = paramLinkedList.DPd.weappInfo;
          if (bool) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            ((eyd)localObject1).isGame = paramInt2;
            localObject1 = this.ErD;
            paramLinkedList.DPd.weappInfo.eda = ((String)localObject1);
            paramInt2 = this.ErE;
            paramLinkedList.DPd.weappInfo.subType = paramInt2;
            localObject1 = this.ErF;
            paramLinkedList.DPd.weappInfo.Nvm = ((String)localObject1);
            break;
          }
        }
        if (this.Ern)
        {
          paramLinkedList = new bf(41, this.gte);
          localObject1 = new cio();
          ((cio)localObject1).appId = this.izu;
          ((cio)localObject1).path = this.izv;
          ((cio)localObject1).query = this.izw;
          paramLinkedList.DPd.liteappInfo = ((cio)localObject1);
        }
        else if (this.vjQ == 11)
        {
          paramLinkedList = new bf(18, this.gte);
          localObject1 = new eep();
          ((eep)localObject1).izc = this.ErH;
          ((eep)localObject1).izb = this.title;
          ((eep)localObject1).iyZ = this.link;
          ((eep)localObject1).izd = this.ErI;
          ((eep)localObject1).iza = this.ErG;
          ((eep)localObject1).ize = this.twt;
          ((eep)localObject1).izf = this.izf;
          ((eep)localObject1).izg = this.izg;
          paramLinkedList.DPh = ((eep)localObject1);
          paramLinkedList.DPd.streamvideo = ((eep)localObject1);
        }
        else if (this.vjQ == 15)
        {
          paramLinkedList = new bf(26, this.gte);
          localObject1 = this.ErJ;
          paramLinkedList.DPd.ContentObj.LoX = ((String)localObject1);
        }
        else if ((this.vjQ == 16) && (this.webSearchInfo != null))
        {
          localObject1 = new bf(3, this.gte);
          localObject2 = this.webSearchInfo;
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (localObject2 != null)
          {
            ((bf)localObject1).webSearchInfo = ((fat)localObject2);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.vjQ == 17)
        {
          localObject1 = new bf(28, this.gte);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.EpW != null)
          {
            ((bf)localObject1).a(this.EpW);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.vjQ == 23)
        {
          localObject1 = new bf(36, this.gte);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ErO != null)
          {
            ((bf)localObject1).a(this.ErO);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.vjQ == 18)
        {
          localObject1 = new bf(29, this.gte);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ErK != null)
          {
            ((bf)localObject1).a(this.ErK);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.vjQ == 22)
        {
          localObject1 = new bf(37, this.gte);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ErK != null)
          {
            ((bf)localObject1).a(this.ErK);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.vjQ == 24)
        {
          localObject1 = new bf(39, this.gte);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ErL != null)
          {
            localObject2 = this.ErL;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bf)localObject1).DPd.ContentObj.Lpe = ((com.tencent.mm.modelsns.b)localObject2).jld;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else if (this.vjQ == 20)
        {
          localObject1 = new bf(38, this.gte);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ErN != null)
          {
            localObject2 = this.ErN;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bf)localObject1).DPd.ContentObj.Lpb = ((com.tencent.mm.modelsns.c)localObject2).jle;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else if (this.vjQ == 21)
        {
          localObject1 = new bf(34, this.gte);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ErM != null)
          {
            ((bf)localObject1).a(this.ErM);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else
        {
          paramLinkedList = new bf(3, this.gte);
        }
      }
    }
    if (this.tkD) {
      if (this.Erq == null) {
        break label2176;
      }
    }
    label2176:
    for (paramPInt = (WXVideoObject)this.Erq.mediaObject;; paramPInt = null)
    {
      localObject1 = this.EpE;
      localObject2 = this.link;
      if (paramPInt == null)
      {
        paramString1 = this.link;
        label1469:
        if (paramPInt != null) {
          break label1537;
        }
      }
      label1537:
      for (paramPInt = this.link;; paramPInt = Util.nullAs(paramPInt.videoUrl, this.link))
      {
        paramLinkedList.a((byte[])localObject1, (String)localObject2, paramString1, paramPInt, 4, Util.nullAs(this.title, ""), Util.nullAs(this.Ers, ""), "", "");
        break;
        paramString1 = Util.nullAs(paramPInt.videoLowBandUrl, this.link);
        break label1469;
      }
      if (!Util.isNullOrNil(this.Erk))
      {
        paramString1 = this.Erk;
        paramInt2 = this.w;
        paramInt3 = this.h;
        paramString1 = bf.aP("", paramString1, paramString1);
        if (paramString1 == null)
        {
          Log.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
          break;
        }
        paramString1.Desc = "";
        if ((paramInt2 > 0) && (paramInt3 > 0))
        {
          paramPInt = new cnd();
          paramPInt.Mtp = paramInt3;
          paramPInt.Mto = paramInt2;
          paramString1.MsB = paramPInt;
        }
        if (!Util.isNullOrNil("")) {
          paramString1.Title = "";
        }
        if (!Util.isNullOrNil("")) {
          paramString1.Desc = "";
        }
        paramLinkedList.DPd.ContentObj.LoV.add(paramString1);
        break;
      }
      if (this.EpE == null) {
        break;
      }
      if (this.Erm)
      {
        paramString1 = this.EpE;
        if (paramString1 != null) {
          break label1801;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          Log.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.cd(this.EpE);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            Log.i("MicroMsg.LinkWidget", "use covert data");
            this.EpE = e.cd(paramString1);
          }
        }
        paramLinkedList.b(this.EpE, "", "");
        break;
        label1801:
        if (paramString1.length >= 4) {
          break label1814;
        }
      }
      label1814:
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
      label1877:
      paramLinkedList.YL(0);
      break label367;
      label1887:
      if (parami != null) {
        paramLinkedList.kl(parami.token, parami.Mte);
      }
      paramLinkedList.bq(paramString1);
      if (!Util.isNullOrNil(this.appId)) {
        paramLinkedList.aPC(this.appId);
      }
      if (!Util.isNullOrNil(this.appName)) {
        paramLinkedList.aPD(Util.nullAs(this.appName, ""));
      }
      if (this.Ero) {
        paramLinkedList.YK(5);
      }
      paramLinkedList.a(paramcjy);
      if ((this.Erp) && (this.Erq != null))
      {
        paramLinkedList.aPx(this.Erq.mediaTagName);
        paramLinkedList.aO(this.appId, this.Erq.messageExt, this.Erq.messageAction);
      }
      paramLinkedList.aPy(paramString2);
      paramLinkedList.g(this.Ert, this.Eru, this.eal, paramInt4, paramInt5);
      paramLinkedList.aPH(this.eam);
      paramLinkedList.setSessionId(this.mSessionId);
      paramLinkedList.YG(this.Erv);
      paramInt1 = paramLinkedList.commit();
      if (this.EpM != null)
      {
        this.EpM.tQ(paramInt1);
        com.tencent.mm.plugin.sns.k.g.DVR.c(this.EpM);
      }
      if (this.Erw != null)
      {
        this.Erw.tQ(paramInt1);
        h.DVR.c(this.Erw);
        this.Erw.bfK();
      }
      aj.faK().eZn();
      this.gte.finish();
      AppMethodBeat.o(97928);
      return false;
    }
  }
  
  public final void aC(Bundle paramBundle)
  {
    AppMethodBeat.i(97926);
    this.EpM = k.w(this.gte.getIntent());
    this.vjQ = this.gte.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.ErG = this.gte.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.ErH = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.ErI = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.izf = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.izg = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.gte.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.gte.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.EpG = this.gte.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.statExtStr = Util.nullAs(this.gte.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.link = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.twt = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.EpE = this.gte.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    paramBundle = this.gte.getIntent().getStringExtra("KsnsUpload_imgPath");
    if ((this.EpE == null) && (!Util.isNullOrNil(paramBundle))) {
      this.EpE = s.aW(paramBundle, 0, -1);
    }
    if ((this.EpE == null) && (this.Erq != null) && (this.Erq.mediaObject != null) && ((this.Erq.mediaObject instanceof WXImageObject))) {
      this.EpE = ((WXImageObject)this.Erq.mediaObject).imageData;
    }
    this.tkD = this.gte.getIntent().getBooleanExtra("ksnsis_video", false);
    this.Erl = this.gte.getIntent().getBooleanExtra("ksnsis_music", false);
    this.Erm = this.gte.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.Ern = this.gte.getIntent().getBooleanExtra("ksnsis_liteapp", false);
    this.eag = Util.nullAs(this.gte.getIntent().getStringExtra("src_username"), "");
    this.EpF = Util.nullAs(this.gte.getIntent().getStringExtra("src_displayname"), "");
    this.appId = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.gte.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Ero = this.gte.getIntent().getBooleanExtra("KThrid_app", false);
    this.Erp = this.gte.getIntent().getBooleanExtra("KSnsAction", false);
    this.Ert = Util.nullAs(this.gte.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.Eru = Util.nullAs(this.gte.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.eal = Util.nullAs(this.gte.getIntent().getStringExtra("JsAppId"), "");
    this.eam = Util.nullAs(this.gte.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.gte.getIntent().getStringExtra("reportSessionId"), "");
    this.Erv = this.gte.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.ErJ = this.gte.getIntent().getStringExtra("fav_note_xml");
    this.Erx = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.Ery = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.Erz = this.gte.getIntent().getIntExtra("KsnsUpload_BrandVersion", 0);
    this.ErA = this.gte.getIntent().getIntExtra("KsnsUpload_BrandVersionType", 0);
    this.ErB = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_BrandShareActionId"), "");
    this.ErC = this.gte.getIntent().getBooleanExtra("KsnsUpload_isGame", false);
    this.ErD = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_MessageExtraData"), "");
    this.ErE = this.gte.getIntent().getIntExtra("KsnsUpload_SubType", 0);
    this.ErF = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_PreloadResouces"), "");
    if (this.Ern)
    {
      this.izu = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_LiteAppId"), "");
      this.izv = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_LiteAppPath"), "");
      this.izw = Util.nullAs(this.gte.getIntent().getStringExtra("KsnsUpload_LiteAppQuery"), "");
    }
    this.Erk = Util.nullAs(this.gte.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.Erk.startsWith("http://mmsns.qpic.cn")) || (this.Erk.startsWith("https://mmsns.qpic.cn")))
    {
      this.twt = this.Erk;
      this.EpE = null;
      Log.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.Erk });
    }
    paramBundle = this.gte.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.Erq = new SendMessageToWX.Req(paramBundle).message;
      if (Util.isNullOrNil(this.title)) {
        this.title = this.Erq.title;
      }
      if (Util.isNullOrNil(this.Ers)) {
        this.Ers = this.Erq.description;
      }
      if (Util.isNullOrNil(this.EpE)) {
        this.EpE = this.Erq.thumbData;
      }
    }
    paramBundle = this.gte.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.webSearchInfo = new fat();
    }
    try
    {
      this.webSearchInfo.parseFrom(paramBundle);
      paramBundle = this.gte.getIntent().getStringExtra("KSnsStrId");
      Object localObject = Util.nullAs(this.gte.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = aj.faO().aQm((String)localObject);
      if (!Util.isNullOrNil(paramBundle))
      {
        this.Erw = k.tO(706);
        this.Erw.tS(this.Erw.jll).PI(System.currentTimeMillis()).tS(this.Erw.jlm).tS(1).PI(paramBundle);
        if (localObject != null)
        {
          this.Erw.tR(((SnsInfo)localObject).field_type);
          this.Erw.fL(((SnsInfo)localObject).isAd()).PH(((SnsInfo)localObject).getUxinfo()).PH(this.link);
        }
        h.DVR.b(this.Erw);
      }
      if (this.gte.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
      {
        this.DPi = 1;
        this.EpN = Util.nullAs(this.gte.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        paramBundle = this.gte.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!Util.isNullOrNil(paramBundle))
        {
          localObject = XmlParser.parseXml(paramBundle, "finderFeed", null);
          if (localObject != null)
          {
            this.EpW = new com.tencent.mm.modelsns.e();
            this.EpW.j("", (Map)localObject);
          }
        }
        localObject = this.gte.getIntent().getStringExtra("ksnsupload_finder_topic_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderTopic", null);
          if (localObject != null)
          {
            this.ErK = new f();
            this.ErK.j("", (Map)localObject);
          }
        }
        localObject = this.gte.getIntent().getStringExtra("ksnsupload_finder_activity_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderTopic", null);
          if (localObject != null)
          {
            this.ErL = new com.tencent.mm.modelsns.b();
            this.ErL.jld = com.tencent.mm.plugin.i.a.l.z("", (Map)localObject);
          }
        }
        localObject = this.gte.getIntent().getStringExtra("ksnsupload_finder_album_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderColumn", null);
          if (localObject != null)
          {
            this.ErN = new com.tencent.mm.modelsns.c();
            this.ErN.j("", (Map)localObject);
          }
        }
        localObject = this.gte.getIntent().getStringExtra("ksnsupload_finder_live_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderLive", null);
          if (localObject != null)
          {
            this.ErM = new com.tencent.mm.modelsns.d();
            this.ErM.j("", (Map)localObject);
          }
        }
        if (!Util.isNullOrNil(this.gte.getIntent().getStringExtra("ksnsupload_mega_video_object_xml")))
        {
          paramBundle = XmlParser.parseXml(paramBundle, "finderMegaVideo", null);
          if (paramBundle != null)
          {
            this.ErO = new com.tencent.mm.modelsns.g();
            this.ErO.j("", paramBundle);
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
        this.DPi = 0;
      }
    }
  }
  
  public final void aD(Bundle paramBundle) {}
  
  public final boolean ffA()
  {
    return true;
  }
  
  public final View ffB()
  {
    AppMethodBeat.i(97927);
    this.sc = aa.jQ(this.gte).inflate(2131496778, null);
    if (!Util.isNullOrNil(this.link)) {
      this.sc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97925);
          Object localObject = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
          if ((!Util.isNullOrNil(ae.this.ErJ)) || (ae.this.Erm) || (ae.this.Ern))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(97925);
            return;
          }
          localObject = com.tencent.mm.model.ad.aVe().G(ae.this.mSessionId, true);
          if (((ad.b)localObject).containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
          {
            int i = ((ad.b)localObject).getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
            int j = ((ad.b)localObject).getInt("_DATA_SHOW_NATIVE_PAGE", -1);
            if ((i == 5) && (j == 1) && (ae.this.gte.getIntent().getBundleExtra("BizVideoDetailUIExtras") != null))
            {
              Log.i("MicroMsg.LinkWidget", "goto native video");
              localObject = new Intent();
              ((Intent)localObject).putExtras(ae.this.gte.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
              paramAnonymousView = paramAnonymousView.findViewById(2131302578);
              if (paramAnonymousView != null)
              {
                i = paramAnonymousView.getWidth();
                j = paramAnonymousView.getHeight();
                int[] arrayOfInt = new int[2];
                paramAnonymousView.getLocationInWindow(arrayOfInt);
                ((Intent)localObject).putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
              }
              ((Intent)localObject).addFlags(268435456);
              com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", (Intent)localObject);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(97925);
              return;
            }
            if (z.gsK())
            {
              paramAnonymousView = new Intent();
              j = (int)(System.currentTimeMillis() / 1000L);
              localObject = ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(ae.this.link, 2, 10000, j);
              if (!((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(ae.this.gte, (String)localObject, i, 2, 10000, paramAnonymousView))
              {
                paramAnonymousView.putExtra("rawUrl", ae.this.link);
                com.tencent.mm.br.c.b(ae.this.gte, "webview", ".ui.tools.WebViewUI", paramAnonymousView);
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(97925);
              return;
            }
          }
          Log.i("MicroMsg.LinkWidget", "adlink url " + ae.this.link);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", ae.this.link);
          com.tencent.mm.plugin.sns.c.a.jRt.i(paramAnonymousView, ae.this.gte);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/LinkWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(97925);
        }
      });
    }
    this.EpH = ((CdnImageView)this.sc.findViewById(2131302578));
    this.titleTv = ((TextView)this.sc.findViewById(2131309253));
    this.EpI = ((TextView)this.sc.findViewById(2131307116));
    int i;
    label162:
    Object localObject;
    if ((!this.tkD) && (!this.Erl))
    {
      if ((this.webSearchInfo != null) && (!Util.isNullOrNil(this.webSearchInfo.IEy)))
      {
        i = 1;
        if ((i == 0) && (this.ErE != 1)) {
          break label313;
        }
      }
    }
    else
    {
      this.sc.findViewById(2131308376).setVisibility(0);
      localObject = com.tencent.mm.model.ad.aVe().G(this.mSessionId, true);
      if ((localObject == null) || (1 != ((ad.b)localObject).getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", -1))) {
        break label331;
      }
      localObject = MMApplicationContext.getContext().getString(2131763172);
      this.EpI.setText((CharSequence)localObject);
      this.EpI.setVisibility(0);
      label216:
      if (Util.isNullOrNil(this.title)) {
        break label354;
      }
      this.titleTv.setText(this.title);
      if (this.EpI.getVisibility() != 0) {
        break label343;
      }
      this.titleTv.setMaxLines(1);
      label255:
      if (Util.isNullOrNil(this.twt)) {
        break label1314;
      }
      this.EpH.setVisibility(0);
      this.EpH.setUrl(this.twt);
    }
    for (;;)
    {
      r.b(this.EpH, this.gte);
      localObject = this.sc;
      AppMethodBeat.o(97927);
      return localObject;
      i = 0;
      break;
      label313:
      this.sc.findViewById(2131308376).setVisibility(8);
      break label162;
      label331:
      this.EpI.setVisibility(8);
      break label216;
      label343:
      this.titleTv.setMaxLines(2);
      break label255;
      label354:
      if ((this.vjQ == 17) && (this.EpW != null))
      {
        if ((Util.isNullOrNil(this.EpW.jlg.nickname)) && (!Util.isNullOrNil(this.EpW.jlg.desc)))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.EpW.jlg.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.EpW.jlg.desc))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.EpW.jlg.nickname + ": " + this.EpW.jlg.desc));
          break label255;
        }
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getString(2131766209, new Object[] { this.EpW.jlg.nickname })));
        break label255;
      }
      if ((this.vjQ == 23) && (this.ErO != null))
      {
        if ((Util.isNullOrNil(this.ErO.jlh.nickname)) && (!Util.isNullOrNil(this.ErO.jlh.desc)))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.ErO.jlh.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.ErO.jlh.desc))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.ErO.jlh.nickname + ": " + this.ErO.jlh.desc));
          break label255;
        }
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getString(2131766209, new Object[] { this.ErO.jlh.nickname })));
        break label255;
      }
      if (((this.vjQ == 18) || (this.vjQ == 22)) && (this.ErK != null))
      {
        localObject = this.gte.getString(2131755857);
        if (this.ErK.jld != null) {
          if (this.ErK.jld.tvC != 1) {
            break label872;
          }
        }
        label872:
        for (localObject = MMApplicationContext.getContext().getString(2131766212, new Object[] { this.ErK.jld.dST });; localObject = this.ErK.jld.dST)
        {
          this.EpI.setVisibility(0);
          this.EpI.setText(this.ErK.jld.desc);
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, (CharSequence)localObject));
          break;
        }
      }
      String str;
      if ((this.vjQ == 24) && (this.ErL != null))
      {
        str = this.gte.getString(2131755857);
        localObject = str;
        if (this.ErL.jld != null)
        {
          localObject = str;
          if (this.ErL.jld.LLD != null) {
            if (this.ErL.jld.tvC != 7) {
              break label1044;
            }
          }
        }
        label1044:
        for (localObject = MMApplicationContext.getContext().getString(2131766207, new Object[] { this.ErL.jld.LLD.LAr, this.ErL.jld.LLD.LAq });; localObject = this.ErL.jld.dST)
        {
          this.EpI.setVisibility(0);
          this.EpI.setText(this.ErL.jld.desc);
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, (CharSequence)localObject));
          break;
        }
      }
      if ((this.vjQ == 20) && (this.ErN != null))
      {
        localObject = this.ErN.jle.title;
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, (CharSequence)localObject));
        break label255;
      }
      if ((this.vjQ == 21) && (this.ErM != null))
      {
        if ((Util.isNullOrNil(this.ErM.jlf.nickName)) && (!Util.isNullOrNil(this.ErM.jlf.desc)))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.ErM.jlf.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.ErM.jlf.desc))
        {
          this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.ErM.jlf.nickName + ": " + this.ErM.jlf.desc));
          break label255;
        }
        this.titleTv.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.gte, this.gte.getString(2131766211, new Object[] { this.ErM.jlf.nickName })));
        break label255;
      }
      this.titleTv.setText(bk.aRf(this.link));
      break label255;
      label1314:
      if (!Util.isNullOrNil(this.EpE))
      {
        this.EpH.setVisibility(0);
        this.iKs = BitmapUtil.decodeByteArray(this.EpE);
        this.EpH.setImageBitmap(this.iKs);
        this.Erj = true;
      }
      else if (!Util.isNullOrNil(this.ErJ))
      {
        this.EpH.setImageResource(2131691246);
        this.EpH.setVisibility(0);
      }
      else if (this.vjQ == 17)
      {
        if ((this.EpW != null) && (!this.EpW.jlg.mediaList.isEmpty()) && (!Util.isNullOrNil(((bch)this.EpW.jlg.mediaList.get(0)).thumbUrl))) {
          this.EpH.setUrl(((bch)this.EpW.jlg.mediaList.get(0)).thumbUrl);
        }
        this.EpH.setVisibility(0);
      }
      else
      {
        if (this.vjQ == 23)
        {
          if ((this.ErO != null) && (!this.ErO.jlh.mediaList.isEmpty()))
          {
            if (Util.isNullOrNil(((cok)this.ErO.jlh.mediaList.get(0)).coverUrl)) {
              break label1585;
            }
            this.EpH.setUrl(((cok)this.ErO.jlh.mediaList.get(0)).coverUrl);
          }
          for (;;)
          {
            this.EpH.setVisibility(0);
            break;
            label1585:
            if (!Util.isNullOrNil(((cok)this.ErO.jlh.mediaList.get(0)).thumbUrl)) {
              this.EpH.setUrl(((cok)this.ErO.jlh.mediaList.get(0)).thumbUrl);
            }
          }
        }
        if ((this.vjQ == 18) || (this.vjQ == 22))
        {
          if ((this.ErK != null) && (this.ErK.jld != null)) {
            this.EpH.setUrl(this.ErK.jld.iconUrl);
          }
          this.EpH.setVisibility(0);
        }
        else if (this.vjQ == 24)
        {
          if ((this.ErL != null) && (this.ErL.jld != null)) {
            this.EpH.setUrl(this.ErL.jld.iconUrl);
          }
          this.EpH.setVisibility(0);
        }
        else if (this.vjQ == 20)
        {
          if (this.ErN != null)
          {
            localObject = (String)this.ErN.jle.LLt.get(0);
            str = (String)this.ErN.jle.LLu.get(0);
            this.EpH.setUrl((String)localObject + str);
          }
          this.EpH.setVisibility(0);
        }
        else if (this.vjQ == 21)
        {
          if ((this.ErM != null) && (!this.ErM.jlf.coverUrl.isEmpty()) && (!Util.isNullOrNil(this.ErM.jlf.coverUrl))) {
            this.EpH.setUrl(this.ErM.jlf.coverUrl);
          }
          this.EpH.setVisibility(0);
        }
        else
        {
          this.EpH.setImageResource(2131689587);
          this.EpH.setVisibility(0);
        }
      }
    }
  }
  
  public final boolean ffC()
  {
    return true;
  }
  
  public final boolean ffD()
  {
    return true;
  }
  
  public final boolean ffE()
  {
    AppMethodBeat.i(97929);
    if ((this.iKs != null) && (!this.iKs.isRecycled()) && (this.Erj)) {
      this.iKs.recycle();
    }
    AppMethodBeat.o(97929);
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ae
 * JD-Core Version:    0.7.0.1
 */