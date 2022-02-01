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
import com.tencent.mm.aw.o;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.d.a;
import com.tencent.mm.plugin.sns.k.h;
import com.tencent.mm.plugin.sns.k.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.az;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.ald;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.cwk;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.dqn;
import com.tencent.mm.protocal.protobuf.dsx;
import com.tencent.mm.protocal.protobuf.yk;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;

public final class ac
  implements ab
{
  private String appId;
  private String appName;
  private String dxE;
  private String dxF;
  private String dxz;
  public String gJB = "";
  public String gJC = "";
  private Bitmap gTB = null;
  private int h = -1;
  final MMActivity imP;
  String link = "";
  String mSessionId;
  private boolean osM = false;
  private View pf = null;
  private String qpB = "";
  private String title = "";
  private TextView titleTv = null;
  private String videoUrl = "";
  private int w = -1;
  private dsx wLn = null;
  private int wLo = 1;
  private byte[] xlX = null;
  private String xlY;
  private int xlZ;
  private CdnImageView xma = null;
  private TextView xmb = null;
  private com.tencent.mm.modelsns.d xmf = null;
  private String xmg = "";
  private String xnA;
  private String xnB;
  private int xnC = 0;
  private com.tencent.mm.modelsns.d xnD = null;
  private int xnE = 0;
  private String xnF = "";
  private String xnG = "";
  private int xnH;
  private int xnI;
  private String xnJ;
  private boolean xnK;
  private String xnL;
  private int xnM;
  private int xnN = 0;
  private String xnO = "";
  private String xnP = "";
  String xnQ = "";
  private b xnR;
  private com.tencent.mm.modelsns.c xnS;
  private boolean xnq = false;
  private String xnr;
  private String xns;
  private boolean xnt = false;
  boolean xnu = false;
  private boolean xnv = false;
  private boolean xnw = false;
  private WXMediaMessage xnx = null;
  private String xny = "";
  private String xnz = "";
  
  public ac(MMActivity paramMMActivity)
  {
    this.imP = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bmn parambmn, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97928);
    if (this.xnt) {
      paramLinkedList = new ba(4);
    }
    label363:
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramPInt.value = paramLinkedList.aTB;
      if (paramInt3 > a.wzN) {
        paramLinkedList.Ms(4);
      }
      if (this.xlX == null)
      {
        o.ayE();
        paramPInt = com.tencent.mm.aw.c.pT(this.qpB);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = f.a(paramPInt, 150, 150, false, false);
          ad.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.xlX = f.Bitmap2Bytes(paramPInt);
        }
      }
      paramLinkedList.aoX(this.title).aoV(this.link).aoW(this.link).aoS(paramString1);
      paramLinkedList.aoV(bt.by(this.imP.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
      if (this.xnE == 15) {
        paramLinkedList.aoV(bt.by(this.imP.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.xnt) {
        break;
      }
      if (!paramLinkedList.a(this.xlX, this.link, this.link, this.link, 3, "", "", "", "")) {}
      paramLinkedList.bR(this.wLo, this.xmg);
      paramLinkedList.Mw(this.xlZ);
      paramLinkedList.apa(this.dxz);
      paramLinkedList.apb(this.xlY);
      paramString1 = this.xns;
      paramLinkedList.wLh.xns = bt.nullAsNil(paramString1);
      ad.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      paramLinkedList.Mu(paramInt1);
      if (!paramBoolean) {
        break label1496;
      }
      paramLinkedList.Mx(1);
      paramLinkedList.fq(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1506;
      }
      new LinkedList();
      paramList2 = w.arx();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          localObject1 = new cwk();
          ((cwk)localObject1).mAQ = paramPInt;
          paramString1.add(localObject1);
        }
      }
      if (this.osM)
      {
        paramLinkedList = new ba(5);
      }
      else
      {
        if (this.xnu)
        {
          paramLinkedList = new ba(30);
          localObject1 = this.xnF;
          paramLinkedList.wLh.Ets.username = ((String)localObject1);
          localObject1 = this.xnG;
          paramLinkedList.wLh.Ets.path = ((String)localObject1);
          paramInt2 = this.xnH;
          paramLinkedList.wLh.Ets.version = paramInt2;
          paramInt2 = this.xnI;
          paramLinkedList.wLh.Ets.AHI = paramInt2;
          localObject1 = this.xnJ;
          paramLinkedList.wLh.Ets.EGj = ((String)localObject1);
          boolean bool = this.xnK;
          localObject1 = paramLinkedList.wLh.Ets;
          if (bool) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            ((dqn)localObject1).isGame = paramInt2;
            localObject1 = this.xnL;
            paramLinkedList.wLh.Ets.dzY = ((String)localObject1);
            paramInt2 = this.xnM;
            paramLinkedList.wLh.Ets.subType = paramInt2;
            break;
          }
        }
        if (this.xnE == 11)
        {
          paramLinkedList = new ba(18);
          localObject1 = new czi();
          ((czi)localObject1).gJy = this.xnO;
          ((czi)localObject1).gJx = this.title;
          ((czi)localObject1).gJv = this.link;
          ((czi)localObject1).gJz = this.xnP;
          ((czi)localObject1).gJw = this.xnN;
          ((czi)localObject1).gJA = this.qpB;
          ((czi)localObject1).gJB = this.gJB;
          ((czi)localObject1).gJC = this.gJC;
          paramLinkedList.wLm = ((czi)localObject1);
          paramLinkedList.wLh.Etr = ((czi)localObject1);
        }
        else if (this.xnE == 15)
        {
          paramLinkedList = new ba(26);
          localObject1 = this.xnQ;
          paramLinkedList.wLh.Etm.DaE = ((String)localObject1);
        }
        else if ((this.xnE == 16) && (this.wLn != null))
        {
          localObject1 = new ba(3);
          localObject2 = this.wLn;
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (localObject2 != null)
          {
            ((ba)localObject1).wLn = ((dsx)localObject2);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.xnE == 17)
        {
          localObject1 = new ba(28);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.xnR != null)
          {
            localObject2 = this.xnR;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((ba)localObject1).wLh.Etm.DaG = ((b)localObject2).htg;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else if (this.xnE == 18)
        {
          localObject1 = new ba(29);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.xnS != null)
          {
            localObject2 = this.xnS;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((ba)localObject1).wLh.Etm.DaH = ((com.tencent.mm.modelsns.c)localObject2).hth;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else
        {
          paramLinkedList = new ba(3);
        }
      }
    }
    if (this.osM) {
      if (this.xnx == null) {
        break label1804;
      }
    }
    label1156:
    label1804:
    for (paramPInt = (WXVideoObject)this.xnx.mediaObject;; paramPInt = null)
    {
      localObject1 = this.xlX;
      localObject2 = this.link;
      if (paramPInt == null)
      {
        paramString1 = this.link;
        label1088:
        if (paramPInt != null) {
          break label1156;
        }
      }
      for (paramPInt = this.link;; paramPInt = bt.by(paramPInt.videoUrl, this.link))
      {
        paramLinkedList.a((byte[])localObject1, (String)localObject2, paramString1, paramPInt, 4, bt.by(this.title, ""), bt.by(this.xnz, ""), "", "");
        break;
        paramString1 = bt.by(paramPInt.videoLowBandUrl, this.link);
        break label1088;
      }
      if (!bt.isNullOrNil(this.xnr))
      {
        paramString1 = this.xnr;
        paramInt2 = this.w;
        paramInt3 = this.h;
        paramString1 = ba.av("", paramString1, paramString1);
        if (paramString1 == null)
        {
          ad.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
          break;
        }
        paramString1.Desc = "";
        if ((paramInt2 > 0) && (paramInt3 > 0))
        {
          paramPInt = new bpk();
          paramPInt.DNI = paramInt3;
          paramPInt.DNH = paramInt2;
          paramString1.DMT = paramPInt;
        }
        if (!bt.isNullOrNil("")) {
          paramString1.Title = "";
        }
        if (!bt.isNullOrNil("")) {
          paramString1.Desc = "";
        }
        paramLinkedList.wLh.Etm.DaC.add(paramString1);
        break;
      }
      if (this.xlX == null) {
        break;
      }
      if (this.xnu)
      {
        paramString1 = this.xlX;
        if (paramString1 != null) {
          break label1420;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          ad.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.bD(this.xlX);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            ad.i("MicroMsg.LinkWidget", "use covert data");
            this.xlX = e.bD(paramString1);
          }
        }
        paramLinkedList.b(this.xlX, "", "");
        break;
        label1420:
        if (paramString1.length >= 4) {
          break label1433;
        }
      }
      label1433:
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
      label1496:
      paramLinkedList.Mx(0);
      break label363;
      label1506:
      if (parami != null) {
        paramLinkedList.iI(parami.token, parami.DNx);
      }
      paramLinkedList.aM(paramString1);
      if (!bt.isNullOrNil(this.appId)) {
        paramLinkedList.aoY(this.appId);
      }
      if (!bt.isNullOrNil(this.appName)) {
        paramLinkedList.aoZ(bt.by(this.appName, ""));
      }
      if (this.xnv) {
        paramLinkedList.Mw(5);
      }
      paramLinkedList.a(parambmn);
      if ((this.xnw) && (this.xnx != null))
      {
        paramLinkedList.aoT(this.xnx.mediaTagName);
        paramLinkedList.au(this.appId, this.xnx.messageExt, this.xnx.messageAction);
      }
      paramLinkedList.aoU(paramString2);
      paramLinkedList.g(this.xnA, this.xnB, this.dxE, paramInt4, paramInt5);
      parami = this.dxF;
      paramLinkedList.wLi.dxF = parami;
      paramLinkedList.setSessionId(this.mSessionId);
      paramInt1 = this.xnC;
      paramLinkedList.wLh.gHj = paramInt1;
      paramInt1 = paramLinkedList.commit();
      if (this.xmf != null)
      {
        this.xmf.oG(paramInt1);
        h.wRM.c(this.xmf);
      }
      if (this.xnD != null)
      {
        this.xnD.oG(paramInt1);
        com.tencent.mm.plugin.sns.k.i.wRM.c(this.xnD);
        this.xnD.aBj();
      }
      af.dtq().drS();
      this.imP.finish();
      AppMethodBeat.o(97928);
      return false;
    }
  }
  
  public final void af(Bundle paramBundle)
  {
    AppMethodBeat.i(97926);
    this.xmf = com.tencent.mm.modelsns.d.w(this.imP.getIntent());
    this.xnE = this.imP.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.xnN = this.imP.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.xnO = bt.by(this.imP.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.xnP = bt.by(this.imP.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.gJB = bt.by(this.imP.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.gJC = bt.by(this.imP.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.imP.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.imP.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.xlZ = this.imP.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.xns = bt.by(this.imP.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.link = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.qpB = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.xlX = this.imP.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    if ((this.xlX == null) && (this.xnx != null) && (this.xnx.mediaObject != null) && ((this.xnx.mediaObject instanceof WXImageObject))) {
      this.xlX = ((WXImageObject)this.xnx.mediaObject).imageData;
    }
    this.osM = this.imP.getIntent().getBooleanExtra("ksnsis_video", false);
    this.xnt = this.imP.getIntent().getBooleanExtra("ksnsis_music", false);
    this.xnu = this.imP.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.dxz = bt.by(this.imP.getIntent().getStringExtra("src_username"), "");
    this.xlY = bt.by(this.imP.getIntent().getStringExtra("src_displayname"), "");
    this.appId = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bt.by(this.imP.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.xnv = this.imP.getIntent().getBooleanExtra("KThrid_app", false);
    this.xnw = this.imP.getIntent().getBooleanExtra("KSnsAction", false);
    this.xnA = bt.by(this.imP.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.xnB = bt.by(this.imP.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.dxE = bt.by(this.imP.getIntent().getStringExtra("JsAppId"), "");
    this.dxF = bt.by(this.imP.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bt.by(this.imP.getIntent().getStringExtra("reportSessionId"), "");
    this.xnC = this.imP.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.xnQ = this.imP.getIntent().getStringExtra("fav_note_xml");
    this.xnF = bt.by(this.imP.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.xnG = bt.by(this.imP.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.xnH = this.imP.getIntent().getIntExtra("KsnsUpload_BrandVersion", 0);
    this.xnI = this.imP.getIntent().getIntExtra("KsnsUpload_BrandVersionType", 0);
    this.xnJ = bt.by(this.imP.getIntent().getStringExtra("KsnsUpload_BrandShareActionId"), "");
    this.xnK = this.imP.getIntent().getBooleanExtra("KsnsUpload_isGame", false);
    this.xnL = bt.by(this.imP.getIntent().getStringExtra("KsnsUpload_MessageExtraData"), "");
    this.xnM = this.imP.getIntent().getIntExtra("KsnsUpload_SubType", 0);
    this.xnr = bt.by(this.imP.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.xnr.startsWith("http://mmsns.qpic.cn")) || (this.xnr.startsWith("https://mmsns.qpic.cn")))
    {
      this.qpB = this.xnr;
      this.xlX = null;
      ad.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.xnr });
    }
    paramBundle = this.imP.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.xnx = new SendMessageToWX.Req(paramBundle).message;
      if (bt.isNullOrNil(this.title)) {
        this.title = this.xnx.title;
      }
      if (bt.isNullOrNil(this.xnz)) {
        this.xnz = this.xnx.description;
      }
      if (bt.cw(this.xlX)) {
        this.xlX = this.xnx.thumbData;
      }
    }
    paramBundle = this.imP.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.wLn = new dsx();
    }
    try
    {
      this.wLn.parseFrom(paramBundle);
      paramBundle = this.imP.getIntent().getStringExtra("KSnsStrId");
      Object localObject = bt.by(this.imP.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = af.dtu().apK((String)localObject);
      if (!bt.isNullOrNil(paramBundle))
      {
        this.xnD = com.tencent.mm.modelsns.d.oE(706);
        this.xnD.oI(this.xnD.htj).zj(System.currentTimeMillis()).oI(this.xnD.htk).oI(1).zj(paramBundle);
        if (localObject != null)
        {
          this.xnD.oH(((p)localObject).field_type);
          this.xnD.ew(((p)localObject).Nb(32)).zi(((p)localObject).dyg()).zi(this.link);
        }
        com.tencent.mm.plugin.sns.k.i.wRM.b(this.xnD);
      }
      if (this.imP.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
      {
        this.wLo = 1;
        this.xmg = bt.by(this.imP.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        paramBundle = this.imP.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!bt.isNullOrNil(paramBundle))
        {
          paramBundle = bw.K(paramBundle, "finderFeed");
          if (paramBundle != null)
          {
            this.xnR = new b();
            this.xnR.h("", paramBundle);
          }
        }
        paramBundle = this.imP.getIntent().getStringExtra("ksnsupload_finder_topic_xml");
        if (!bt.isNullOrNil(paramBundle))
        {
          paramBundle = bw.K(paramBundle, "finderTopic");
          if (paramBundle != null)
          {
            this.xnS = new com.tencent.mm.modelsns.c();
            this.xnS.h("", paramBundle);
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
        ad.printErrStackTrace("MicroMsg.LinkWidget", paramBundle, "parse web search info failed", new Object[0]);
        this.wLn = null;
        continue;
        this.wLo = 0;
      }
    }
  }
  
  public final void ag(Bundle paramBundle) {}
  
  public final boolean dyU()
  {
    return true;
  }
  
  public final View dyV()
  {
    AppMethodBeat.i(97927);
    this.pf = com.tencent.mm.ui.y.js(this.imP).inflate(2131495816, null);
    if (!bt.isNullOrNil(this.link)) {
      this.pf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97925);
          if ((!bt.isNullOrNil(ac.this.xnQ)) || (ac.this.xnu))
          {
            AppMethodBeat.o(97925);
            return;
          }
          Object localObject = com.tencent.mm.model.y.arz().E(ac.this.mSessionId, true);
          if (((y.b)localObject).containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
          {
            int i = ((y.b)localObject).getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
            int j = ((y.b)localObject).getInt("_DATA_SHOW_NATIVE_PAGE", -1);
            if ((i == 5) && (j == 1))
            {
              ad.i("MicroMsg.LinkWidget", "goto native video");
              localObject = new Intent();
              ((Intent)localObject).putExtras(ac.this.imP.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
              paramAnonymousView = paramAnonymousView.findViewById(2131300948);
              if (paramAnonymousView != null)
              {
                i = paramAnonymousView.getWidth();
                j = paramAnonymousView.getHeight();
                int[] arrayOfInt = new int[2];
                paramAnonymousView.getLocationInWindow(arrayOfInt);
                ((Intent)localObject).putExtra("img_gallery_width", i).putExtra("img_gallery_height", j).putExtra("img_gallery_left", arrayOfInt[0]).putExtra("img_gallery_top", arrayOfInt[1]);
              }
              ((Intent)localObject).addFlags(268435456);
              com.tencent.mm.bs.d.b(aj.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", (Intent)localObject);
              AppMethodBeat.o(97925);
              return;
            }
          }
          ad.i("MicroMsg.LinkWidget", "adlink url " + ac.this.link);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", ac.this.link);
          a.hYt.i(paramAnonymousView, ac.this.imP);
          AppMethodBeat.o(97925);
        }
      });
    }
    this.xma = ((CdnImageView)this.pf.findViewById(2131300948));
    this.titleTv = ((TextView)this.pf.findViewById(2131305950));
    this.xmb = ((TextView)this.pf.findViewById(2131304202));
    int i;
    label162:
    Object localObject;
    if ((!this.osM) && (!this.xnt))
    {
      if ((this.wLn != null) && (!bt.isNullOrNil(this.wLn.AGs)))
      {
        i = 1;
        if ((i == 0) && (this.xnM != 1)) {
          break label313;
        }
      }
    }
    else
    {
      this.pf.findViewById(2131305185).setVisibility(0);
      localObject = com.tencent.mm.model.y.arz().E(this.mSessionId, true);
      if ((localObject == null) || (1 != ((y.b)localObject).getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", -1))) {
        break label331;
      }
      localObject = aj.getContext().getString(2131761345);
      this.xmb.setText((CharSequence)localObject);
      this.xmb.setVisibility(0);
      label216:
      if (bt.isNullOrNil(this.title)) {
        break label354;
      }
      this.titleTv.setText(this.title);
      if (this.xmb.getVisibility() != 0) {
        break label343;
      }
      this.titleTv.setMaxLines(1);
      label255:
      if (bt.isNullOrNil(this.qpB)) {
        break label700;
      }
      this.xma.setVisibility(0);
      this.xma.setUrl(this.qpB);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.q.b(this.xma, this.imP);
      localObject = this.pf;
      AppMethodBeat.o(97927);
      return localObject;
      i = 0;
      break;
      label313:
      this.pf.findViewById(2131305185).setVisibility(8);
      break label162;
      label331:
      this.xmb.setVisibility(8);
      break label216;
      label343:
      this.titleTv.setMaxLines(2);
      break label255;
      label354:
      if ((this.xnE == 17) && (this.xnR != null))
      {
        if ((bt.isNullOrNil(this.xnR.htg.nickname)) && (!bt.isNullOrNil(this.xnR.htg.desc)))
        {
          this.titleTv.setText(k.c(this.imP, this.xnR.htg.desc));
          break label255;
        }
        if (!bt.isNullOrNil(this.xnR.htg.desc))
        {
          this.titleTv.setText(k.c(this.imP, this.xnR.htg.nickname + ": " + this.xnR.htg.desc));
          break label255;
        }
        this.titleTv.setText(k.c(this.imP, this.imP.getString(2131763973, new Object[] { this.xnR.htg.nickname })));
        break label255;
      }
      if ((this.xnE == 18) && (this.xnS != null))
      {
        localObject = this.imP.getString(2131755778);
        if (this.xnS.hth != null) {
          if (this.xnS.hth.qSS != 1) {
            break label669;
          }
        }
        label669:
        for (localObject = aj.getContext().getString(2131763974, new Object[] { this.xnS.hth.dqA });; localObject = this.xnS.hth.dqA)
        {
          this.xmb.setVisibility(0);
          this.xmb.setText(this.xnS.hth.desc);
          this.titleTv.setText(k.c(this.imP, (CharSequence)localObject));
          break;
        }
      }
      this.titleTv.setText(be.aqC(this.link));
      break label255;
      label700:
      if (!bt.cw(this.xlX))
      {
        this.xma.setVisibility(0);
        this.gTB = f.cl(this.xlX);
        this.xma.setImageBitmap(this.gTB);
        this.xnq = true;
      }
      else if (!bt.isNullOrNil(this.xnQ))
      {
        this.xma.setImageResource(2131690949);
        this.xma.setVisibility(0);
      }
      else if (this.xnE == 17)
      {
        if ((this.xnR != null) && (!this.xnR.htg.mediaList.isEmpty()) && (!bt.isNullOrNil(((alc)this.xnR.htg.mediaList.get(0)).thumbUrl))) {
          this.xma.setUrl(((alc)this.xnR.htg.mediaList.get(0)).thumbUrl);
        }
        this.xma.setVisibility(0);
      }
      else if (this.xnE == 18)
      {
        if ((this.xnS != null) && (this.xnS.hth != null)) {
          this.xma.setUrl(this.xnS.hth.iconUrl);
        }
        this.xma.setVisibility(0);
      }
      else
      {
        this.xma.setImageResource(2131689584);
        this.xma.setVisibility(0);
      }
    }
  }
  
  public final boolean dyW()
  {
    AppMethodBeat.i(97929);
    if ((this.gTB != null) && (!this.gTB.isRecycled()) && (this.xnq)) {
      this.gTB.recycle();
    }
    AppMethodBeat.o(97929);
    return false;
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac
 * JD-Core Version:    0.7.0.1
 */