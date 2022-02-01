package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z.b;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.j.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.ary;
import com.tencent.mm.protocal.protobuf.arz;
import com.tencent.mm.protocal.protobuf.bwk;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.dlc;
import com.tencent.mm.protocal.protobuf.edv;
import com.tencent.mm.protocal.protobuf.egh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;

public final class ad
  implements ac
{
  private byte[] Ahi = null;
  private String Ahj;
  private int Ahk;
  private CdnImageView Ahl = null;
  private TextView Ahm = null;
  private com.tencent.mm.modelsns.e Ahq = null;
  private String Ahr = "";
  private b Ahw;
  private boolean AiE = false;
  private String AiF;
  private String AiG;
  private boolean AiH = false;
  boolean AiI = false;
  private boolean AiJ = false;
  private boolean AiK = false;
  private WXMediaMessage AiL = null;
  private String AiM = "";
  private String AiN = "";
  private String AiO;
  private String AiP;
  private int AiQ = 0;
  private com.tencent.mm.modelsns.e AiR = null;
  private int AiS = 0;
  private String AiT = "";
  private String AiU = "";
  private int AiV;
  private int AiW;
  private String AiX;
  private boolean AiY;
  private String AiZ;
  private int Aja;
  private int Ajb = 0;
  private String Ajc = "";
  private String Ajd = "";
  String Aje = "";
  private c Ajf;
  private String appId;
  private String appName;
  private String dIt;
  private String dIy;
  private String dIz;
  final MMActivity fNT;
  private int h = -1;
  public String hEZ = "";
  public String hFa = "";
  private Bitmap hPl = null;
  String link = "";
  String mSessionId;
  private boolean pGA = false;
  private String rSl = "";
  private View rY = null;
  private String title = "";
  private TextView titleTv = null;
  private String videoUrl = "";
  private int w = -1;
  private egh zFh = null;
  private int zFi = 1;
  
  public ad(MMActivity paramMMActivity)
  {
    this.fNT = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bwk parambwk, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97928);
    if (this.AiH) {
      paramLinkedList = new bd(4);
    }
    label363:
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramPInt.value = paramLinkedList.beN;
      if (paramInt3 > a.zsC) {
        paramLinkedList.QI(4);
      }
      if (this.Ahi == null)
      {
        com.tencent.mm.av.q.aIW();
        paramPInt = com.tencent.mm.av.d.wA(this.rSl);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = com.tencent.mm.sdk.platformtools.h.a(paramPInt, 150, 150, false, false);
          ae.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.Ahi = com.tencent.mm.sdk.platformtools.h.Bitmap2Bytes(paramPInt);
        }
      }
      paramLinkedList.aAF(this.title).aAD(this.link).aAE(this.link).aAA(paramString1);
      paramLinkedList.aAD(bu.bI(this.fNT.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
      if (this.AiS == 15) {
        paramLinkedList.aAD(bu.bI(this.fNT.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.AiH) {
        break;
      }
      if (!paramLinkedList.a(this.Ahi, this.link, this.link, this.link, 3, "", "", "", "")) {}
      paramLinkedList.cc(this.zFi, this.Ahr);
      paramLinkedList.QN(this.Ahk);
      paramLinkedList.aAI(this.dIt);
      paramLinkedList.aAJ(this.Ahj);
      paramString1 = this.AiG;
      paramLinkedList.zFb.AiG = bu.nullAsNil(paramString1);
      ae.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      paramLinkedList.QL(paramInt1);
      if (!paramBoolean) {
        break label1474;
      }
      paramLinkedList.QO(1);
      paramLinkedList.fU(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1484;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.i.d.feg();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          localObject1 = new did();
          ((did)localObject1).nIJ = paramPInt;
          paramString1.add(localObject1);
        }
      }
      if (this.pGA)
      {
        paramLinkedList = new bd(5);
      }
      else
      {
        if (this.AiI)
        {
          paramLinkedList = new bd(30);
          localObject1 = this.AiT;
          paramLinkedList.zFb.HUM.username = ((String)localObject1);
          localObject1 = this.AiU;
          paramLinkedList.zFb.HUM.path = ((String)localObject1);
          paramInt2 = this.AiV;
          paramLinkedList.zFb.HUM.version = paramInt2;
          paramInt2 = this.AiW;
          paramLinkedList.zFb.HUM.DUS = paramInt2;
          localObject1 = this.AiX;
          paramLinkedList.zFb.HUM.IiI = ((String)localObject1);
          boolean bool = this.AiY;
          localObject1 = paramLinkedList.zFb.HUM;
          if (bool) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            ((edv)localObject1).isGame = paramInt2;
            localObject1 = this.AiZ;
            paramLinkedList.zFb.HUM.dLl = ((String)localObject1);
            paramInt2 = this.Aja;
            paramLinkedList.zFb.HUM.subType = paramInt2;
            break;
          }
        }
        if (this.AiS == 11)
        {
          paramLinkedList = new bd(18);
          localObject1 = new dlc();
          ((dlc)localObject1).hEW = this.Ajc;
          ((dlc)localObject1).hEV = this.title;
          ((dlc)localObject1).hET = this.link;
          ((dlc)localObject1).hEX = this.Ajd;
          ((dlc)localObject1).hEU = this.Ajb;
          ((dlc)localObject1).hEY = this.rSl;
          ((dlc)localObject1).hEZ = this.hEZ;
          ((dlc)localObject1).hFa = this.hFa;
          paramLinkedList.zFg = ((dlc)localObject1);
          paramLinkedList.zFb.HUL = ((dlc)localObject1);
        }
        else if (this.AiS == 15)
        {
          paramLinkedList = new bd(26);
          localObject1 = this.Aje;
          paramLinkedList.zFb.HUG.Gtz = ((String)localObject1);
        }
        else if ((this.AiS == 16) && (this.zFh != null))
        {
          localObject1 = new bd(3);
          localObject2 = this.zFh;
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (localObject2 != null)
          {
            ((bd)localObject1).zFh = ((egh)localObject2);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.AiS == 17)
        {
          localObject1 = new bd(28);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.Ahw != null)
          {
            ((bd)localObject1).a(this.Ahw);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.AiS == 18)
        {
          localObject1 = new bd(29);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.Ajf != null)
          {
            localObject2 = this.Ajf;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bd)localObject1).zFb.HUG.GtC = ((c)localObject2).ipX;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else
        {
          paramLinkedList = new bd(3);
        }
      }
    }
    if (this.pGA) {
      if (this.AiL == null) {
        break label1773;
      }
    }
    label1066:
    label1474:
    label1484:
    label1773:
    for (paramPInt = (WXVideoObject)this.AiL.mediaObject;; paramPInt = null)
    {
      localObject1 = this.Ahi;
      localObject2 = this.link;
      if (paramPInt == null)
      {
        paramString1 = this.link;
        if (paramPInt != null) {
          break label1134;
        }
      }
      label1134:
      for (paramPInt = this.link;; paramPInt = bu.bI(paramPInt.videoUrl, this.link))
      {
        paramLinkedList.a((byte[])localObject1, (String)localObject2, paramString1, paramPInt, 4, bu.bI(this.title, ""), bu.bI(this.AiN, ""), "", "");
        break;
        paramString1 = bu.bI(paramPInt.videoLowBandUrl, this.link);
        break label1066;
      }
      if (!bu.isNullOrNil(this.AiF))
      {
        paramString1 = this.AiF;
        paramInt2 = this.w;
        paramInt3 = this.h;
        paramString1 = bd.aE("", paramString1, paramString1);
        if (paramString1 == null)
        {
          ae.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
          break;
        }
        paramString1.Desc = "";
        if ((paramInt2 > 0) && (paramInt3 > 0))
        {
          paramPInt = new bzj();
          paramPInt.Hnb = paramInt3;
          paramPInt.Hna = paramInt2;
          paramString1.Hmm = paramPInt;
        }
        if (!bu.isNullOrNil("")) {
          paramString1.Title = "";
        }
        if (!bu.isNullOrNil("")) {
          paramString1.Desc = "";
        }
        paramLinkedList.zFb.HUG.Gtx.add(paramString1);
        break;
      }
      if (this.Ahi == null) {
        break;
      }
      if (this.AiI)
      {
        paramString1 = this.Ahi;
        if (paramString1 != null) {
          break label1398;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          ae.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.bM(this.Ahi);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            ae.i("MicroMsg.LinkWidget", "use covert data");
            this.Ahi = e.bM(paramString1);
          }
        }
        paramLinkedList.b(this.Ahi, "", "");
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
      paramLinkedList.QO(0);
      break label363;
      if (parami != null) {
        paramLinkedList.jy(parami.token, parami.HmQ);
      }
      paramLinkedList.aV(paramString1);
      if (!bu.isNullOrNil(this.appId)) {
        paramLinkedList.aAG(this.appId);
      }
      if (!bu.isNullOrNil(this.appName)) {
        paramLinkedList.aAH(bu.bI(this.appName, ""));
      }
      if (this.AiJ) {
        paramLinkedList.QN(5);
      }
      paramLinkedList.a(parambwk);
      if ((this.AiK) && (this.AiL != null))
      {
        paramLinkedList.aAB(this.AiL.mediaTagName);
        paramLinkedList.aD(this.appId, this.AiL.messageExt, this.AiL.messageAction);
      }
      paramLinkedList.aAC(paramString2);
      paramLinkedList.g(this.AiO, this.AiP, this.dIy, paramInt4, paramInt5);
      paramLinkedList.aAL(this.dIz);
      paramLinkedList.setSessionId(this.mSessionId);
      paramLinkedList.QJ(this.AiQ);
      paramInt1 = paramLinkedList.commit();
      if (this.Ahq != null)
      {
        this.Ahq.qa(paramInt1);
        g.zLJ.c(this.Ahq);
      }
      if (this.AiR != null)
      {
        this.AiR.qa(paramInt1);
        com.tencent.mm.plugin.sns.j.h.zLJ.c(this.AiR);
        this.AiR.aLH();
      }
      ah.dXA().dWc();
      this.fNT.finish();
      AppMethodBeat.o(97928);
      return false;
    }
  }
  
  public final void aq(Bundle paramBundle)
  {
    AppMethodBeat.i(97926);
    this.Ahq = com.tencent.mm.modelsns.e.w(this.fNT.getIntent());
    this.AiS = this.fNT.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.Ajb = this.fNT.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.Ajc = bu.bI(this.fNT.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.Ajd = bu.bI(this.fNT.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.hEZ = bu.bI(this.fNT.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.hFa = bu.bI(this.fNT.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.fNT.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.fNT.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.Ahk = this.fNT.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.AiG = bu.bI(this.fNT.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.link = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.rSl = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.Ahi = this.fNT.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    paramBundle = this.fNT.getIntent().getStringExtra("KsnsUpload_imgPath");
    if ((this.Ahi == null) && (!bu.isNullOrNil(paramBundle))) {
      this.Ahi = o.bb(paramBundle, 0, -1);
    }
    if ((this.Ahi == null) && (this.AiL != null) && (this.AiL.mediaObject != null) && ((this.AiL.mediaObject instanceof WXImageObject))) {
      this.Ahi = ((WXImageObject)this.AiL.mediaObject).imageData;
    }
    this.pGA = this.fNT.getIntent().getBooleanExtra("ksnsis_video", false);
    this.AiH = this.fNT.getIntent().getBooleanExtra("ksnsis_music", false);
    this.AiI = this.fNT.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.dIt = bu.bI(this.fNT.getIntent().getStringExtra("src_username"), "");
    this.Ahj = bu.bI(this.fNT.getIntent().getStringExtra("src_displayname"), "");
    this.appId = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bu.bI(this.fNT.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.AiJ = this.fNT.getIntent().getBooleanExtra("KThrid_app", false);
    this.AiK = this.fNT.getIntent().getBooleanExtra("KSnsAction", false);
    this.AiO = bu.bI(this.fNT.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.AiP = bu.bI(this.fNT.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.dIy = bu.bI(this.fNT.getIntent().getStringExtra("JsAppId"), "");
    this.dIz = bu.bI(this.fNT.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bu.bI(this.fNT.getIntent().getStringExtra("reportSessionId"), "");
    this.AiQ = this.fNT.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.Aje = this.fNT.getIntent().getStringExtra("fav_note_xml");
    this.AiT = bu.bI(this.fNT.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.AiU = bu.bI(this.fNT.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.AiV = this.fNT.getIntent().getIntExtra("KsnsUpload_BrandVersion", 0);
    this.AiW = this.fNT.getIntent().getIntExtra("KsnsUpload_BrandVersionType", 0);
    this.AiX = bu.bI(this.fNT.getIntent().getStringExtra("KsnsUpload_BrandShareActionId"), "");
    this.AiY = this.fNT.getIntent().getBooleanExtra("KsnsUpload_isGame", false);
    this.AiZ = bu.bI(this.fNT.getIntent().getStringExtra("KsnsUpload_MessageExtraData"), "");
    this.Aja = this.fNT.getIntent().getIntExtra("KsnsUpload_SubType", 0);
    this.AiF = bu.bI(this.fNT.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.AiF.startsWith("http://mmsns.qpic.cn")) || (this.AiF.startsWith("https://mmsns.qpic.cn")))
    {
      this.rSl = this.AiF;
      this.Ahi = null;
      ae.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.AiF });
    }
    paramBundle = this.fNT.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.AiL = new SendMessageToWX.Req(paramBundle).message;
      if (bu.isNullOrNil(this.title)) {
        this.title = this.AiL.title;
      }
      if (bu.isNullOrNil(this.AiN)) {
        this.AiN = this.AiL.description;
      }
      if (bu.cF(this.Ahi)) {
        this.Ahi = this.AiL.thumbData;
      }
    }
    paramBundle = this.fNT.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.zFh = new egh();
    }
    try
    {
      this.zFh.parseFrom(paramBundle);
      paramBundle = this.fNT.getIntent().getStringExtra("KSnsStrId");
      Object localObject = bu.bI(this.fNT.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = ah.dXE().aBr((String)localObject);
      if (!bu.isNullOrNil(paramBundle))
      {
        this.AiR = com.tencent.mm.modelsns.e.pY(706);
        this.AiR.qc(this.AiR.iqa).GV(System.currentTimeMillis()).qc(this.AiR.iqb).qc(1).GV(paramBundle);
        if (localObject != null)
        {
          this.AiR.qb(((p)localObject).field_type);
          this.AiR.eV(((p)localObject).Rt(32)).GU(((p)localObject).ecx()).GU(this.link);
        }
        com.tencent.mm.plugin.sns.j.h.zLJ.b(this.AiR);
      }
      if (this.fNT.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
      {
        this.zFi = 1;
        this.Ahr = bu.bI(this.fNT.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        paramBundle = this.fNT.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!bu.isNullOrNil(paramBundle))
        {
          paramBundle = bx.M(paramBundle, "finderFeed");
          if (paramBundle != null)
          {
            this.Ahw = new b();
            this.Ahw.j("", paramBundle);
          }
        }
        paramBundle = this.fNT.getIntent().getStringExtra("ksnsupload_finder_topic_xml");
        if (!bu.isNullOrNil(paramBundle))
        {
          paramBundle = bx.M(paramBundle, "finderTopic");
          if (paramBundle != null)
          {
            this.Ajf = new c();
            this.Ajf.j("", paramBundle);
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
        ae.printErrStackTrace("MicroMsg.LinkWidget", paramBundle, "parse web search info failed", new Object[0]);
        this.zFh = null;
        continue;
        this.zFi = 0;
      }
    }
  }
  
  public final void ar(Bundle paramBundle) {}
  
  public final boolean edl()
  {
    return true;
  }
  
  public final View edm()
  {
    AppMethodBeat.i(97927);
    this.rY = com.tencent.mm.ui.z.jV(this.fNT).inflate(2131495816, null);
    if (!bu.isNullOrNil(this.link)) {
      this.rY.setOnClickListener(new ad.1(this));
    }
    this.Ahl = ((CdnImageView)this.rY.findViewById(2131300948));
    this.titleTv = ((TextView)this.rY.findViewById(2131305950));
    this.Ahm = ((TextView)this.rY.findViewById(2131304202));
    int i;
    label162:
    Object localObject;
    if ((!this.pGA) && (!this.AiH))
    {
      if ((this.zFh != null) && (!bu.isNullOrNil(this.zFh.DTD)))
      {
        i = 1;
        if ((i == 0) && (this.Aja != 1)) {
          break label313;
        }
      }
    }
    else
    {
      this.rY.findViewById(2131305185).setVisibility(0);
      localObject = com.tencent.mm.model.z.aBG().F(this.mSessionId, true);
      if ((localObject == null) || (1 != ((z.b)localObject).getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", -1))) {
        break label331;
      }
      localObject = ak.getContext().getString(2131761345);
      this.Ahm.setText((CharSequence)localObject);
      this.Ahm.setVisibility(0);
      label216:
      if (bu.isNullOrNil(this.title)) {
        break label354;
      }
      this.titleTv.setText(this.title);
      if (this.Ahm.getVisibility() != 0) {
        break label343;
      }
      this.titleTv.setMaxLines(1);
      label255:
      if (bu.isNullOrNil(this.rSl)) {
        break label700;
      }
      this.Ahl.setVisibility(0);
      this.Ahl.setUrl(this.rSl);
    }
    for (;;)
    {
      r.b(this.Ahl, this.fNT);
      localObject = this.rY;
      AppMethodBeat.o(97927);
      return localObject;
      i = 0;
      break;
      label313:
      this.rY.findViewById(2131305185).setVisibility(8);
      break label162;
      label331:
      this.Ahm.setVisibility(8);
      break label216;
      label343:
      this.titleTv.setMaxLines(2);
      break label255;
      label354:
      if ((this.AiS == 17) && (this.Ahw != null))
      {
        if ((bu.isNullOrNil(this.Ahw.ipW.nickname)) && (!bu.isNullOrNil(this.Ahw.ipW.desc)))
        {
          this.titleTv.setText(k.c(this.fNT, this.Ahw.ipW.desc));
          break label255;
        }
        if (!bu.isNullOrNil(this.Ahw.ipW.desc))
        {
          this.titleTv.setText(k.c(this.fNT, this.Ahw.ipW.nickname + ": " + this.Ahw.ipW.desc));
          break label255;
        }
        this.titleTv.setText(k.c(this.fNT, this.fNT.getString(2131763973, new Object[] { this.Ahw.ipW.nickname })));
        break label255;
      }
      if ((this.AiS == 18) && (this.Ajf != null))
      {
        localObject = this.fNT.getString(2131755778);
        if (this.Ajf.ipX != null) {
          if (this.Ajf.ipX.sXu != 1) {
            break label669;
          }
        }
        label669:
        for (localObject = ak.getContext().getString(2131763974, new Object[] { this.Ajf.ipX.dBe });; localObject = this.Ajf.ipX.dBe)
        {
          this.Ahm.setVisibility(0);
          this.Ahm.setText(this.Ajf.ipX.desc);
          this.titleTv.setText(k.c(this.fNT, (CharSequence)localObject));
          break;
        }
      }
      this.titleTv.setText(bh.aCj(this.link));
      break label255;
      label700:
      if (!bu.cF(this.Ahi))
      {
        this.Ahl.setVisibility(0);
        this.hPl = com.tencent.mm.sdk.platformtools.h.cu(this.Ahi);
        this.Ahl.setImageBitmap(this.hPl);
        this.AiE = true;
      }
      else if (!bu.isNullOrNil(this.Aje))
      {
        this.Ahl.setImageResource(2131690949);
        this.Ahl.setVisibility(0);
      }
      else if (this.AiS == 17)
      {
        if ((this.Ahw != null) && (!this.Ahw.ipW.mediaList.isEmpty()) && (!bu.isNullOrNil(((arx)this.Ahw.ipW.mediaList.get(0)).thumbUrl))) {
          this.Ahl.setUrl(((arx)this.Ahw.ipW.mediaList.get(0)).thumbUrl);
        }
        this.Ahl.setVisibility(0);
      }
      else if (this.AiS == 18)
      {
        if ((this.Ajf != null) && (this.Ajf.ipX != null)) {
          this.Ahl.setUrl(this.Ajf.ipX.iconUrl);
        }
        this.Ahl.setVisibility(0);
      }
      else
      {
        this.Ahl.setImageResource(2131689584);
        this.Ahl.setVisibility(0);
      }
    }
  }
  
  public final boolean edn()
  {
    return true;
  }
  
  public final boolean edo()
  {
    AppMethodBeat.i(97929);
    if ((this.hPl != null) && (!this.hPl.isRecycled()) && (this.AiE)) {
      this.hPl.recycle();
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