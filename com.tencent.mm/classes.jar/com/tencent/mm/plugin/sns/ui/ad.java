package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.j.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.ari;
import com.tencent.mm.protocal.protobuf.arj;
import com.tencent.mm.protocal.protobuf.ark;
import com.tencent.mm.protocal.protobuf.bvq;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dkh;
import com.tencent.mm.protocal.protobuf.ece;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;

public final class ad
  implements ac
{
  private String appId;
  private String appName;
  private String dHo;
  private String dHt;
  private String dHu;
  final MMActivity fLP;
  private int h = -1;
  public String hCk = "";
  public String hCl = "";
  private Bitmap hMs = null;
  String link = "";
  String mSessionId;
  private boolean pzW = false;
  private String rJX = "";
  private View rY = null;
  private String title = "";
  private TextView titleTv = null;
  private String videoUrl = "";
  private int w = -1;
  private byte[] zQb = null;
  private String zQc;
  private int zQd;
  private CdnImageView zQe = null;
  private TextView zQf = null;
  private com.tencent.mm.modelsns.e zQj = null;
  private String zQk = "";
  private b zQp;
  private boolean zRA = false;
  boolean zRB = false;
  private boolean zRC = false;
  private boolean zRD = false;
  private WXMediaMessage zRE = null;
  private String zRF = "";
  private String zRG = "";
  private String zRH;
  private String zRI;
  private int zRJ = 0;
  private com.tencent.mm.modelsns.e zRK = null;
  private int zRL = 0;
  private String zRM = "";
  private String zRN = "";
  private int zRO;
  private int zRP;
  private String zRQ;
  private boolean zRR;
  private String zRS;
  private int zRT;
  private int zRU = 0;
  private String zRV = "";
  private String zRW = "";
  String zRX = "";
  private c zRY;
  private boolean zRx = false;
  private String zRy;
  private String zRz;
  private eeq znS = null;
  private int znT = 1;
  
  public ad(MMActivity paramMMActivity)
  {
    this.fLP = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bvq parambvq, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97928);
    if (this.zRA) {
      paramLinkedList = new bc(4);
    }
    label363:
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramPInt.value = paramLinkedList.beN;
      if (paramInt3 > a.zbZ) {
        paramLinkedList.Qb(4);
      }
      if (this.zQb == null)
      {
        com.tencent.mm.aw.q.aIE();
        paramPInt = com.tencent.mm.aw.d.vT(this.rJX);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = com.tencent.mm.sdk.platformtools.g.a(paramPInt, 150, 150, false, false);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.zQb = com.tencent.mm.sdk.platformtools.g.Bitmap2Bytes(paramPInt);
        }
      }
      paramLinkedList.azo(this.title).azm(this.link).azn(this.link).azj(paramString1);
      paramLinkedList.azm(bt.bI(this.fLP.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
      if (this.zRL == 15) {
        paramLinkedList.azm(bt.bI(this.fLP.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.zRA) {
        break;
      }
      if (!paramLinkedList.a(this.zQb, this.link, this.link, this.link, 3, "", "", "", "")) {}
      paramLinkedList.cc(this.znT, this.zQk);
      paramLinkedList.Qg(this.zQd);
      paramLinkedList.azr(this.dHo);
      paramLinkedList.azs(this.zQc);
      paramString1 = this.zRz;
      paramLinkedList.znM.zRz = bt.nullAsNil(paramString1);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      paramLinkedList.Qe(paramInt1);
      if (!paramBoolean) {
        break label1474;
      }
      paramLinkedList.Qh(1);
      paramLinkedList.fL(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1484;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.i.d.fas();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          localObject1 = new dhj();
          ((dhj)localObject1).nDo = paramPInt;
          paramString1.add(localObject1);
        }
      }
      if (this.pzW)
      {
        paramLinkedList = new bc(5);
      }
      else
      {
        if (this.zRB)
        {
          paramLinkedList = new bc(30);
          localObject1 = this.zRM;
          paramLinkedList.znM.HAZ.username = ((String)localObject1);
          localObject1 = this.zRN;
          paramLinkedList.znM.HAZ.path = ((String)localObject1);
          paramInt2 = this.zRO;
          paramLinkedList.znM.HAZ.version = paramInt2;
          paramInt2 = this.zRP;
          paramLinkedList.znM.HAZ.DCU = paramInt2;
          localObject1 = this.zRQ;
          paramLinkedList.znM.HAZ.HOB = ((String)localObject1);
          boolean bool = this.zRR;
          localObject1 = paramLinkedList.znM.HAZ;
          if (bool) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            ((ece)localObject1).isGame = paramInt2;
            localObject1 = this.zRS;
            paramLinkedList.znM.HAZ.dJW = ((String)localObject1);
            paramInt2 = this.zRT;
            paramLinkedList.znM.HAZ.subType = paramInt2;
            break;
          }
        }
        if (this.zRL == 11)
        {
          paramLinkedList = new bc(18);
          localObject1 = new dkh();
          ((dkh)localObject1).hCh = this.zRV;
          ((dkh)localObject1).hCg = this.title;
          ((dkh)localObject1).hCe = this.link;
          ((dkh)localObject1).hCi = this.zRW;
          ((dkh)localObject1).hCf = this.zRU;
          ((dkh)localObject1).hCj = this.rJX;
          ((dkh)localObject1).hCk = this.hCk;
          ((dkh)localObject1).hCl = this.hCl;
          paramLinkedList.znR = ((dkh)localObject1);
          paramLinkedList.znM.HAY = ((dkh)localObject1);
        }
        else if (this.zRL == 15)
        {
          paramLinkedList = new bc(26);
          localObject1 = this.zRX;
          paramLinkedList.znM.HAT.GaS = ((String)localObject1);
        }
        else if ((this.zRL == 16) && (this.znS != null))
        {
          localObject1 = new bc(3);
          localObject2 = this.znS;
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (localObject2 != null)
          {
            ((bc)localObject1).znS = ((eeq)localObject2);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.zRL == 17)
        {
          localObject1 = new bc(28);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.zQp != null)
          {
            ((bc)localObject1).a(this.zQp);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.zRL == 18)
        {
          localObject1 = new bc(29);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.zRY != null)
          {
            localObject2 = this.zRY;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bc)localObject1).znM.HAT.GaV = ((c)localObject2).ind;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else
        {
          paramLinkedList = new bc(3);
        }
      }
    }
    if (this.pzW) {
      if (this.zRE == null) {
        break label1773;
      }
    }
    label1066:
    label1474:
    label1484:
    label1773:
    for (paramPInt = (WXVideoObject)this.zRE.mediaObject;; paramPInt = null)
    {
      localObject1 = this.zQb;
      localObject2 = this.link;
      if (paramPInt == null)
      {
        paramString1 = this.link;
        if (paramPInt != null) {
          break label1134;
        }
      }
      label1134:
      for (paramPInt = this.link;; paramPInt = bt.bI(paramPInt.videoUrl, this.link))
      {
        paramLinkedList.a((byte[])localObject1, (String)localObject2, paramString1, paramPInt, 4, bt.bI(this.title, ""), bt.bI(this.zRG, ""), "", "");
        break;
        paramString1 = bt.bI(paramPInt.videoLowBandUrl, this.link);
        break label1066;
      }
      if (!bt.isNullOrNil(this.zRy))
      {
        paramString1 = this.zRy;
        paramInt2 = this.w;
        paramInt3 = this.h;
        paramString1 = bc.aE("", paramString1, paramString1);
        if (paramString1 == null)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
          break;
        }
        paramString1.Desc = "";
        if ((paramInt2 > 0) && (paramInt3 > 0))
        {
          paramPInt = new byp();
          paramPInt.GTA = paramInt3;
          paramPInt.GTz = paramInt2;
          paramString1.GSL = paramPInt;
        }
        if (!bt.isNullOrNil("")) {
          paramString1.Title = "";
        }
        if (!bt.isNullOrNil("")) {
          paramString1.Desc = "";
        }
        paramLinkedList.znM.HAT.GaQ.add(paramString1);
        break;
      }
      if (this.zQb == null) {
        break;
      }
      if (this.zRB)
      {
        paramString1 = this.zQb;
        if (paramString1 != null) {
          break label1398;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.bJ(this.zQb);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LinkWidget", "use covert data");
            this.zQb = e.bJ(paramString1);
          }
        }
        paramLinkedList.b(this.zQb, "", "");
        break;
        label1398:
        if (paramString1.length >= 4) {
          break label1411;
        }
      }
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
      paramLinkedList.Qh(0);
      break label363;
      if (parami != null) {
        paramLinkedList.jr(parami.token, parami.GTp);
      }
      paramLinkedList.aU(paramString1);
      if (!bt.isNullOrNil(this.appId)) {
        paramLinkedList.azp(this.appId);
      }
      if (!bt.isNullOrNil(this.appName)) {
        paramLinkedList.azq(bt.bI(this.appName, ""));
      }
      if (this.zRC) {
        paramLinkedList.Qg(5);
      }
      paramLinkedList.a(parambvq);
      if ((this.zRD) && (this.zRE != null))
      {
        paramLinkedList.azk(this.zRE.mediaTagName);
        paramLinkedList.aD(this.appId, this.zRE.messageExt, this.zRE.messageAction);
      }
      paramLinkedList.azl(paramString2);
      paramLinkedList.g(this.zRH, this.zRI, this.dHt, paramInt4, paramInt5);
      paramLinkedList.azu(this.dHu);
      paramLinkedList.setSessionId(this.mSessionId);
      paramLinkedList.Qc(this.zRJ);
      paramInt1 = paramLinkedList.commit();
      if (this.zQj != null)
      {
        this.zQj.pX(paramInt1);
        com.tencent.mm.plugin.sns.j.g.zus.c(this.zQj);
      }
      if (this.zRK != null)
      {
        this.zRK.pX(paramInt1);
        h.zus.c(this.zRK);
        this.zRK.aLk();
      }
      ag.dUa().dSE();
      this.fLP.finish();
      AppMethodBeat.o(97928);
      return false;
    }
  }
  
  public final void ap(Bundle paramBundle)
  {
    AppMethodBeat.i(97926);
    this.zQj = com.tencent.mm.modelsns.e.w(this.fLP.getIntent());
    this.zRL = this.fLP.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.zRU = this.fLP.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.zRV = bt.bI(this.fLP.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.zRW = bt.bI(this.fLP.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.hCk = bt.bI(this.fLP.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.hCl = bt.bI(this.fLP.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.fLP.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.fLP.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.zQd = this.fLP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.zRz = bt.bI(this.fLP.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.link = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.rJX = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.zQb = this.fLP.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    paramBundle = this.fLP.getIntent().getStringExtra("KsnsUpload_imgPath");
    if ((this.zQb == null) && (!bt.isNullOrNil(paramBundle))) {
      this.zQb = com.tencent.mm.vfs.i.aY(paramBundle, 0, -1);
    }
    if ((this.zQb == null) && (this.zRE != null) && (this.zRE.mediaObject != null) && ((this.zRE.mediaObject instanceof WXImageObject))) {
      this.zQb = ((WXImageObject)this.zRE.mediaObject).imageData;
    }
    this.pzW = this.fLP.getIntent().getBooleanExtra("ksnsis_video", false);
    this.zRA = this.fLP.getIntent().getBooleanExtra("ksnsis_music", false);
    this.zRB = this.fLP.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.dHo = bt.bI(this.fLP.getIntent().getStringExtra("src_username"), "");
    this.zQc = bt.bI(this.fLP.getIntent().getStringExtra("src_displayname"), "");
    this.appId = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.bI(this.fLP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.zRC = this.fLP.getIntent().getBooleanExtra("KThrid_app", false);
    this.zRD = this.fLP.getIntent().getBooleanExtra("KSnsAction", false);
    this.zRH = bt.bI(this.fLP.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.zRI = bt.bI(this.fLP.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.dHt = bt.bI(this.fLP.getIntent().getStringExtra("JsAppId"), "");
    this.dHu = bt.bI(this.fLP.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bt.bI(this.fLP.getIntent().getStringExtra("reportSessionId"), "");
    this.zRJ = this.fLP.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.zRX = this.fLP.getIntent().getStringExtra("fav_note_xml");
    this.zRM = bt.bI(this.fLP.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.zRN = bt.bI(this.fLP.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.zRO = this.fLP.getIntent().getIntExtra("KsnsUpload_BrandVersion", 0);
    this.zRP = this.fLP.getIntent().getIntExtra("KsnsUpload_BrandVersionType", 0);
    this.zRQ = bt.bI(this.fLP.getIntent().getStringExtra("KsnsUpload_BrandShareActionId"), "");
    this.zRR = this.fLP.getIntent().getBooleanExtra("KsnsUpload_isGame", false);
    this.zRS = bt.bI(this.fLP.getIntent().getStringExtra("KsnsUpload_MessageExtraData"), "");
    this.zRT = this.fLP.getIntent().getIntExtra("KsnsUpload_SubType", 0);
    this.zRy = bt.bI(this.fLP.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.zRy.startsWith("http://mmsns.qpic.cn")) || (this.zRy.startsWith("https://mmsns.qpic.cn")))
    {
      this.rJX = this.zRy;
      this.zQb = null;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.zRy });
    }
    paramBundle = this.fLP.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.zRE = new SendMessageToWX.Req(paramBundle).message;
      if (bt.isNullOrNil(this.title)) {
        this.title = this.zRE.title;
      }
      if (bt.isNullOrNil(this.zRG)) {
        this.zRG = this.zRE.description;
      }
      if (bt.cC(this.zQb)) {
        this.zQb = this.zRE.thumbData;
      }
    }
    paramBundle = this.fLP.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.znS = new eeq();
    }
    try
    {
      this.znS.parseFrom(paramBundle);
      paramBundle = this.fLP.getIntent().getStringExtra("KSnsStrId");
      Object localObject = bt.bI(this.fLP.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = ag.dUe().aAa((String)localObject);
      if (!bt.isNullOrNil(paramBundle))
      {
        this.zRK = com.tencent.mm.modelsns.e.pV(706);
        this.zRK.pZ(this.zRK.ing).Gt(System.currentTimeMillis()).pZ(this.zRK.inh).pZ(1).Gt(paramBundle);
        if (localObject != null)
        {
          this.zRK.pY(((p)localObject).field_type);
          this.zRK.eS(((p)localObject).QM(32)).Gs(((p)localObject).dYT()).Gs(this.link);
        }
        h.zus.b(this.zRK);
      }
      if (this.fLP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
      {
        this.znT = 1;
        this.zQk = bt.bI(this.fLP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        paramBundle = this.fLP.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!bt.isNullOrNil(paramBundle))
        {
          paramBundle = bw.M(paramBundle, "finderFeed");
          if (paramBundle != null)
          {
            this.zQp = new b();
            this.zQp.i("", paramBundle);
          }
        }
        paramBundle = this.fLP.getIntent().getStringExtra("ksnsupload_finder_topic_xml");
        if (!bt.isNullOrNil(paramBundle))
        {
          paramBundle = bw.M(paramBundle, "finderTopic");
          if (paramBundle != null)
          {
            this.zRY = new c();
            this.zRY.i("", paramBundle);
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
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.LinkWidget", paramBundle, "parse web search info failed", new Object[0]);
        this.znS = null;
        continue;
        this.znT = 0;
      }
    }
  }
  
  public final void aq(Bundle paramBundle) {}
  
  public final boolean dZG()
  {
    return true;
  }
  
  public final View dZH()
  {
    AppMethodBeat.i(97927);
    this.rY = z.jO(this.fLP).inflate(2131495816, null);
    if (!bt.isNullOrNil(this.link)) {
      this.rY.setOnClickListener(new ad.1(this));
    }
    this.zQe = ((CdnImageView)this.rY.findViewById(2131300948));
    this.titleTv = ((TextView)this.rY.findViewById(2131305950));
    this.zQf = ((TextView)this.rY.findViewById(2131304202));
    int i;
    label162:
    Object localObject;
    if ((!this.pzW) && (!this.zRA))
    {
      if ((this.znS != null) && (!bt.isNullOrNil(this.znS.DBG)))
      {
        i = 1;
        if ((i == 0) && (this.zRT != 1)) {
          break label313;
        }
      }
    }
    else
    {
      this.rY.findViewById(2131305185).setVisibility(0);
      localObject = y.aBq().F(this.mSessionId, true);
      if ((localObject == null) || (1 != ((y.b)localObject).getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", -1))) {
        break label331;
      }
      localObject = aj.getContext().getString(2131761345);
      this.zQf.setText((CharSequence)localObject);
      this.zQf.setVisibility(0);
      label216:
      if (bt.isNullOrNil(this.title)) {
        break label354;
      }
      this.titleTv.setText(this.title);
      if (this.zQf.getVisibility() != 0) {
        break label343;
      }
      this.titleTv.setMaxLines(1);
      label255:
      if (bt.isNullOrNil(this.rJX)) {
        break label700;
      }
      this.zQe.setVisibility(0);
      this.zQe.setUrl(this.rJX);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.q.b(this.zQe, this.fLP);
      localObject = this.rY;
      AppMethodBeat.o(97927);
      return localObject;
      i = 0;
      break;
      label313:
      this.rY.findViewById(2131305185).setVisibility(8);
      break label162;
      label331:
      this.zQf.setVisibility(8);
      break label216;
      label343:
      this.titleTv.setMaxLines(2);
      break label255;
      label354:
      if ((this.zRL == 17) && (this.zQp != null))
      {
        if ((bt.isNullOrNil(this.zQp.inc.nickname)) && (!bt.isNullOrNil(this.zQp.inc.desc)))
        {
          this.titleTv.setText(k.c(this.fLP, this.zQp.inc.desc));
          break label255;
        }
        if (!bt.isNullOrNil(this.zQp.inc.desc))
        {
          this.titleTv.setText(k.c(this.fLP, this.zQp.inc.nickname + ": " + this.zQp.inc.desc));
          break label255;
        }
        this.titleTv.setText(k.c(this.fLP, this.fLP.getString(2131763973, new Object[] { this.zQp.inc.nickname })));
        break label255;
      }
      if ((this.zRL == 18) && (this.zRY != null))
      {
        localObject = this.fLP.getString(2131755778);
        if (this.zRY.ind != null) {
          if (this.zRY.ind.sMj != 1) {
            break label669;
          }
        }
        label669:
        for (localObject = aj.getContext().getString(2131763974, new Object[] { this.zRY.ind.dzZ });; localObject = this.zRY.ind.dzZ)
        {
          this.zQf.setVisibility(0);
          this.zQf.setText(this.zRY.ind.desc);
          this.titleTv.setText(k.c(this.fLP, (CharSequence)localObject));
          break;
        }
      }
      this.titleTv.setText(bh.aAS(this.link));
      break label255;
      label700:
      if (!bt.cC(this.zQb))
      {
        this.zQe.setVisibility(0);
        this.hMs = com.tencent.mm.sdk.platformtools.g.cr(this.zQb);
        this.zQe.setImageBitmap(this.hMs);
        this.zRx = true;
      }
      else if (!bt.isNullOrNil(this.zRX))
      {
        this.zQe.setImageResource(2131690949);
        this.zQe.setVisibility(0);
      }
      else if (this.zRL == 17)
      {
        if ((this.zQp != null) && (!this.zQp.inc.mediaList.isEmpty()) && (!bt.isNullOrNil(((ari)this.zQp.inc.mediaList.get(0)).thumbUrl))) {
          this.zQe.setUrl(((ari)this.zQp.inc.mediaList.get(0)).thumbUrl);
        }
        this.zQe.setVisibility(0);
      }
      else if (this.zRL == 18)
      {
        if ((this.zRY != null) && (this.zRY.ind != null)) {
          this.zQe.setUrl(this.zRY.ind.iconUrl);
        }
        this.zQe.setVisibility(0);
      }
      else
      {
        this.zQe.setImageResource(2131689584);
        this.zQe.setVisibility(0);
      }
    }
  }
  
  public final boolean dZI()
  {
    AppMethodBeat.i(97929);
    if ((this.hMs != null) && (!this.hMs.isRecycled()) && (this.zRx)) {
      this.hMs.recycle();
    }
    AppMethodBeat.o(97929);
    return false;
  }
  
  public final boolean k(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ad
 * JD-Core Version:    0.7.0.1
 */