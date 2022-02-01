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
import com.tencent.mm.av.o;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.j.h;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ba;
import com.tencent.mm.plugin.sns.model.bb;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.anw;
import com.tencent.mm.protocal.protobuf.anx;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bub;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.protocal.protobuf.deu;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.dyo;
import com.tencent.mm.protocal.protobuf.zf;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.z;
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
  private String dvl;
  private String dvq;
  private String dvr;
  private int h = -1;
  public String hkb = "";
  public String hkc = "";
  private Bitmap hua = null;
  final MMActivity iMV;
  String link = "";
  String mSessionId;
  private boolean oWm = false;
  private String qYH = "";
  private View qe = null;
  private String title = "";
  private TextView titleTv = null;
  private String videoUrl = "";
  private int w = -1;
  private dyo xXT = null;
  private int xXU = 1;
  private String yAA;
  private boolean yAB;
  private String yAC;
  private int yAD;
  private int yAE = 0;
  private String yAF = "";
  private String yAG = "";
  String yAH = "";
  private b yAI;
  private com.tencent.mm.modelsns.c yAJ;
  private boolean yAh = false;
  private String yAi;
  private String yAj;
  private boolean yAk = false;
  boolean yAl = false;
  private boolean yAm = false;
  private boolean yAn = false;
  private WXMediaMessage yAo = null;
  private String yAp = "";
  private String yAq = "";
  private String yAr;
  private String yAs;
  private int yAt = 0;
  private com.tencent.mm.modelsns.d yAu = null;
  private int yAv = 0;
  private String yAw = "";
  private String yAx = "";
  private int yAy;
  private int yAz;
  private byte[] yyP = null;
  private String yyQ;
  private int yyR;
  private CdnImageView yyS = null;
  private TextView yyT = null;
  private com.tencent.mm.modelsns.d yyX = null;
  private String yyY = "";
  
  public ac(MMActivity paramMMActivity)
  {
    this.iMV = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, brd parambrd, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97928);
    if (this.yAk) {
      paramLinkedList = new bb(4);
    }
    label363:
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramPInt.value = paramLinkedList.aUt;
      if (paramInt3 > a.xMh) {
        paramLinkedList.Ou(4);
      }
      if (this.yyP == null)
      {
        o.aFw();
        paramPInt = com.tencent.mm.av.c.te(this.qYH);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = f.a(paramPInt, 150, 150, false, false);
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.yyP = f.Bitmap2Bytes(paramPInt);
        }
      }
      paramLinkedList.auj(this.title).auh(this.link).aui(this.link).aue(paramString1);
      paramLinkedList.auh(bs.bG(this.iMV.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
      if (this.yAv == 15) {
        paramLinkedList.auh(bs.bG(this.iMV.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.yAk) {
        break;
      }
      if (!paramLinkedList.a(this.yyP, this.link, this.link, this.link, 3, "", "", "", "")) {}
      paramLinkedList.bV(this.xXU, this.yyY);
      paramLinkedList.Oy(this.yyR);
      paramLinkedList.aum(this.dvl);
      paramLinkedList.aun(this.yyQ);
      paramString1 = this.yAj;
      paramLinkedList.xXN.yAj = bs.nullAsNil(paramString1);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      paramLinkedList.Ow(paramInt1);
      if (!paramBoolean) {
        break label1496;
      }
      paramLinkedList.Oz(1);
      paramLinkedList.fy(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1506;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.g.j.fdk();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          localObject1 = new dbw();
          ((dbw)localObject1).ncR = paramPInt;
          paramString1.add(localObject1);
        }
      }
      if (this.oWm)
      {
        paramLinkedList = new bb(5);
      }
      else
      {
        if (this.yAl)
        {
          paramLinkedList = new bb(30);
          localObject1 = this.yAw;
          paramLinkedList.xXN.FQu.username = ((String)localObject1);
          localObject1 = this.yAx;
          paramLinkedList.xXN.FQu.path = ((String)localObject1);
          paramInt2 = this.yAy;
          paramLinkedList.xXN.FQu.version = paramInt2;
          paramInt2 = this.yAz;
          paramLinkedList.xXN.FQu.BZZ = paramInt2;
          localObject1 = this.yAA;
          paramLinkedList.xXN.FQu.Gdv = ((String)localObject1);
          boolean bool = this.yAB;
          localObject1 = paramLinkedList.xXN.FQu;
          if (bool) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            ((dwe)localObject1).isGame = paramInt2;
            localObject1 = this.yAC;
            paramLinkedList.xXN.FQu.dxK = ((String)localObject1);
            paramInt2 = this.yAD;
            paramLinkedList.xXN.FQu.subType = paramInt2;
            break;
          }
        }
        if (this.yAv == 11)
        {
          paramLinkedList = new bb(18);
          localObject1 = new deu();
          ((deu)localObject1).hjY = this.yAF;
          ((deu)localObject1).hjX = this.title;
          ((deu)localObject1).hjV = this.link;
          ((deu)localObject1).hjZ = this.yAG;
          ((deu)localObject1).hjW = this.yAE;
          ((deu)localObject1).hka = this.qYH;
          ((deu)localObject1).hkb = this.hkb;
          ((deu)localObject1).hkc = this.hkc;
          paramLinkedList.xXS = ((deu)localObject1);
          paramLinkedList.xXN.FQt = ((deu)localObject1);
        }
        else if (this.yAv == 15)
        {
          paramLinkedList = new bb(26);
          localObject1 = this.yAH;
          paramLinkedList.xXN.FQo.EtB = ((String)localObject1);
        }
        else if ((this.yAv == 16) && (this.xXT != null))
        {
          localObject1 = new bb(3);
          localObject2 = this.xXT;
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (localObject2 != null)
          {
            ((bb)localObject1).xXT = ((dyo)localObject2);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.yAv == 17)
        {
          localObject1 = new bb(28);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.yAI != null)
          {
            localObject2 = this.yAI;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bb)localObject1).xXN.FQo.EtD = ((b)localObject2).hTI;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else if (this.yAv == 18)
        {
          localObject1 = new bb(29);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.yAJ != null)
          {
            localObject2 = this.yAJ;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bb)localObject1).xXN.FQo.EtE = ((com.tencent.mm.modelsns.c)localObject2).hTJ;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else
        {
          paramLinkedList = new bb(3);
        }
      }
    }
    if (this.oWm) {
      if (this.yAo == null) {
        break label1804;
      }
    }
    label1156:
    label1804:
    for (paramPInt = (WXVideoObject)this.yAo.mediaObject;; paramPInt = null)
    {
      localObject1 = this.yyP;
      localObject2 = this.link;
      if (paramPInt == null)
      {
        paramString1 = this.link;
        label1088:
        if (paramPInt != null) {
          break label1156;
        }
      }
      for (paramPInt = this.link;; paramPInt = bs.bG(paramPInt.videoUrl, this.link))
      {
        paramLinkedList.a((byte[])localObject1, (String)localObject2, paramString1, paramPInt, 4, bs.bG(this.title, ""), bs.bG(this.yAq, ""), "", "");
        break;
        paramString1 = bs.bG(paramPInt.videoLowBandUrl, this.link);
        break label1088;
      }
      if (!bs.isNullOrNil(this.yAi))
      {
        paramString1 = this.yAi;
        paramInt2 = this.w;
        paramInt3 = this.h;
        paramString1 = bb.ax("", paramString1, paramString1);
        if (paramString1 == null)
        {
          com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
          break;
        }
        paramString1.Desc = "";
        if ((paramInt2 > 0) && (paramInt3 > 0))
        {
          paramPInt = new bub();
          paramPInt.FjZ = paramInt3;
          paramPInt.FjY = paramInt2;
          paramString1.Fjk = paramPInt;
        }
        if (!bs.isNullOrNil("")) {
          paramString1.Title = "";
        }
        if (!bs.isNullOrNil("")) {
          paramString1.Desc = "";
        }
        paramLinkedList.xXN.FQo.Etz.add(paramString1);
        break;
      }
      if (this.yyP == null) {
        break;
      }
      if (this.yAl)
      {
        paramString1 = this.yyP;
        if (paramString1 != null) {
          break label1420;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.bC(this.yyP);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LinkWidget", "use covert data");
            this.yyP = e.bC(paramString1);
          }
        }
        paramLinkedList.b(this.yyP, "", "");
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
      paramLinkedList.Oz(0);
      break label363;
      label1506:
      if (parami != null) {
        paramLinkedList.jf(parami.token, parami.FjO);
      }
      paramLinkedList.aT(paramString1);
      if (!bs.isNullOrNil(this.appId)) {
        paramLinkedList.auk(this.appId);
      }
      if (!bs.isNullOrNil(this.appName)) {
        paramLinkedList.aul(bs.bG(this.appName, ""));
      }
      if (this.yAm) {
        paramLinkedList.Oy(5);
      }
      paramLinkedList.a(parambrd);
      if ((this.yAn) && (this.yAo != null))
      {
        paramLinkedList.auf(this.yAo.mediaTagName);
        paramLinkedList.aw(this.appId, this.yAo.messageExt, this.yAo.messageAction);
      }
      paramLinkedList.aug(paramString2);
      paramLinkedList.g(this.yAr, this.yAs, this.dvq, paramInt4, paramInt5);
      parami = this.dvr;
      paramLinkedList.xXO.dvr = parami;
      paramLinkedList.setSessionId(this.mSessionId);
      paramInt1 = this.yAt;
      paramLinkedList.xXN.hhK = paramInt1;
      paramInt1 = paramLinkedList.commit();
      if (this.yyX != null)
      {
        this.yyX.pu(paramInt1);
        h.yes.c(this.yyX);
      }
      if (this.yAu != null)
      {
        this.yAu.pu(paramInt1);
        com.tencent.mm.plugin.sns.j.i.yes.c(this.yAu);
        this.yAu.aHZ();
      }
      af.dHN().dGr();
      this.iMV.finish();
      AppMethodBeat.o(97928);
      return false;
    }
  }
  
  public final void ak(Bundle paramBundle)
  {
    AppMethodBeat.i(97926);
    this.yyX = com.tencent.mm.modelsns.d.w(this.iMV.getIntent());
    this.yAv = this.iMV.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.yAE = this.iMV.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.yAF = bs.bG(this.iMV.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.yAG = bs.bG(this.iMV.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.hkb = bs.bG(this.iMV.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.hkc = bs.bG(this.iMV.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.iMV.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.iMV.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.yyR = this.iMV.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.yAj = bs.bG(this.iMV.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.link = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.qYH = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.yyP = this.iMV.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    if ((this.yyP == null) && (this.yAo != null) && (this.yAo.mediaObject != null) && ((this.yAo.mediaObject instanceof WXImageObject))) {
      this.yyP = ((WXImageObject)this.yAo.mediaObject).imageData;
    }
    this.oWm = this.iMV.getIntent().getBooleanExtra("ksnsis_video", false);
    this.yAk = this.iMV.getIntent().getBooleanExtra("ksnsis_music", false);
    this.yAl = this.iMV.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.dvl = bs.bG(this.iMV.getIntent().getStringExtra("src_username"), "");
    this.yyQ = bs.bG(this.iMV.getIntent().getStringExtra("src_displayname"), "");
    this.appId = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bs.bG(this.iMV.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.yAm = this.iMV.getIntent().getBooleanExtra("KThrid_app", false);
    this.yAn = this.iMV.getIntent().getBooleanExtra("KSnsAction", false);
    this.yAr = bs.bG(this.iMV.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.yAs = bs.bG(this.iMV.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.dvq = bs.bG(this.iMV.getIntent().getStringExtra("JsAppId"), "");
    this.dvr = bs.bG(this.iMV.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bs.bG(this.iMV.getIntent().getStringExtra("reportSessionId"), "");
    this.yAt = this.iMV.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.yAH = this.iMV.getIntent().getStringExtra("fav_note_xml");
    this.yAw = bs.bG(this.iMV.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.yAx = bs.bG(this.iMV.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.yAy = this.iMV.getIntent().getIntExtra("KsnsUpload_BrandVersion", 0);
    this.yAz = this.iMV.getIntent().getIntExtra("KsnsUpload_BrandVersionType", 0);
    this.yAA = bs.bG(this.iMV.getIntent().getStringExtra("KsnsUpload_BrandShareActionId"), "");
    this.yAB = this.iMV.getIntent().getBooleanExtra("KsnsUpload_isGame", false);
    this.yAC = bs.bG(this.iMV.getIntent().getStringExtra("KsnsUpload_MessageExtraData"), "");
    this.yAD = this.iMV.getIntent().getIntExtra("KsnsUpload_SubType", 0);
    this.yAi = bs.bG(this.iMV.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.yAi.startsWith("http://mmsns.qpic.cn")) || (this.yAi.startsWith("https://mmsns.qpic.cn")))
    {
      this.qYH = this.yAi;
      this.yyP = null;
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.yAi });
    }
    paramBundle = this.iMV.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.yAo = new SendMessageToWX.Req(paramBundle).message;
      if (bs.isNullOrNil(this.title)) {
        this.title = this.yAo.title;
      }
      if (bs.isNullOrNil(this.yAq)) {
        this.yAq = this.yAo.description;
      }
      if (bs.cv(this.yyP)) {
        this.yyP = this.yAo.thumbData;
      }
    }
    paramBundle = this.iMV.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.xXT = new dyo();
    }
    try
    {
      this.xXT.parseFrom(paramBundle);
      paramBundle = this.iMV.getIntent().getStringExtra("KSnsStrId");
      Object localObject = bs.bG(this.iMV.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = af.dHR().auT((String)localObject);
      if (!bs.isNullOrNil(paramBundle))
      {
        this.yAu = com.tencent.mm.modelsns.d.ps(706);
        this.yAu.pw(this.yAu.hTL).Do(System.currentTimeMillis()).pw(this.yAu.hTM).pw(1).Do(paramBundle);
        if (localObject != null)
        {
          this.yAu.pv(((p)localObject).field_type);
          this.yAu.eQ(((p)localObject).Pe(32)).Dn(((p)localObject).dMD()).Dn(this.link);
        }
        com.tencent.mm.plugin.sns.j.i.yes.b(this.yAu);
      }
      if (this.iMV.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
      {
        this.xXU = 1;
        this.yyY = bs.bG(this.iMV.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        paramBundle = this.iMV.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!bs.isNullOrNil(paramBundle))
        {
          paramBundle = bv.L(paramBundle, "finderFeed");
          if (paramBundle != null)
          {
            this.yAI = new b();
            this.yAI.h("", paramBundle);
          }
        }
        paramBundle = this.iMV.getIntent().getStringExtra("ksnsupload_finder_topic_xml");
        if (!bs.isNullOrNil(paramBundle))
        {
          paramBundle = bv.L(paramBundle, "finderTopic");
          if (paramBundle != null)
          {
            this.yAJ = new com.tencent.mm.modelsns.c();
            this.yAJ.h("", paramBundle);
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
        com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.LinkWidget", paramBundle, "parse web search info failed", new Object[0]);
        this.xXT = null;
        continue;
        this.xXU = 0;
      }
    }
  }
  
  public final void al(Bundle paramBundle) {}
  
  public final boolean dNr()
  {
    return true;
  }
  
  public final View dNs()
  {
    AppMethodBeat.i(97927);
    this.qe = z.jD(this.iMV).inflate(2131495816, null);
    if (!bs.isNullOrNil(this.link)) {
      this.qe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(97925);
          if ((!bs.isNullOrNil(ac.this.yAH)) || (ac.this.yAl))
          {
            AppMethodBeat.o(97925);
            return;
          }
          Object localObject = y.ayq().F(ac.this.mSessionId, true);
          if (((y.b)localObject).containsKey("_DATA_CENTER_ITEM_SHOW_TYPE"))
          {
            int i = ((y.b)localObject).getInt("_DATA_CENTER_ITEM_SHOW_TYPE", -1);
            int j = ((y.b)localObject).getInt("_DATA_SHOW_NATIVE_PAGE", -1);
            if ((i == 5) && (j == 1))
            {
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LinkWidget", "goto native video");
              localObject = new Intent();
              ((Intent)localObject).putExtras(ac.this.iMV.getIntent().getBundleExtra("BizVideoDetailUIExtras"));
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
              com.tencent.mm.br.d.b(ai.getContext(), "brandservice", ".ui.timeline.video.BizVideoDetailUI", (Intent)localObject);
              AppMethodBeat.o(97925);
              return;
            }
          }
          com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.LinkWidget", "adlink url " + ac.this.link);
          paramAnonymousView = new Intent();
          paramAnonymousView.putExtra("rawUrl", ac.this.link);
          a.iyx.i(paramAnonymousView, ac.this.iMV);
          AppMethodBeat.o(97925);
        }
      });
    }
    this.yyS = ((CdnImageView)this.qe.findViewById(2131300948));
    this.titleTv = ((TextView)this.qe.findViewById(2131305950));
    this.yyT = ((TextView)this.qe.findViewById(2131304202));
    int i;
    label162:
    Object localObject;
    if ((!this.oWm) && (!this.yAk))
    {
      if ((this.xXT != null) && (!bs.isNullOrNil(this.xXT.BYK)))
      {
        i = 1;
        if ((i == 0) && (this.yAD != 1)) {
          break label313;
        }
      }
    }
    else
    {
      this.qe.findViewById(2131305185).setVisibility(0);
      localObject = y.ayq().F(this.mSessionId, true);
      if ((localObject == null) || (1 != ((y.b)localObject).getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", -1))) {
        break label331;
      }
      localObject = ai.getContext().getString(2131761345);
      this.yyT.setText((CharSequence)localObject);
      this.yyT.setVisibility(0);
      label216:
      if (bs.isNullOrNil(this.title)) {
        break label354;
      }
      this.titleTv.setText(this.title);
      if (this.yyT.getVisibility() != 0) {
        break label343;
      }
      this.titleTv.setMaxLines(1);
      label255:
      if (bs.isNullOrNil(this.qYH)) {
        break label700;
      }
      this.yyS.setVisibility(0);
      this.yyS.setUrl(this.qYH);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.q.b(this.yyS, this.iMV);
      localObject = this.qe;
      AppMethodBeat.o(97927);
      return localObject;
      i = 0;
      break;
      label313:
      this.qe.findViewById(2131305185).setVisibility(8);
      break label162;
      label331:
      this.yyT.setVisibility(8);
      break label216;
      label343:
      this.titleTv.setMaxLines(2);
      break label255;
      label354:
      if ((this.yAv == 17) && (this.yAI != null))
      {
        if ((bs.isNullOrNil(this.yAI.hTI.nickname)) && (!bs.isNullOrNil(this.yAI.hTI.desc)))
        {
          this.titleTv.setText(k.c(this.iMV, this.yAI.hTI.desc));
          break label255;
        }
        if (!bs.isNullOrNil(this.yAI.hTI.desc))
        {
          this.titleTv.setText(k.c(this.iMV, this.yAI.hTI.nickname + ": " + this.yAI.hTI.desc));
          break label255;
        }
        this.titleTv.setText(k.c(this.iMV, this.iMV.getString(2131763973, new Object[] { this.yAI.hTI.nickname })));
        break label255;
      }
      if ((this.yAv == 18) && (this.yAJ != null))
      {
        localObject = this.iMV.getString(2131755778);
        if (this.yAJ.hTJ != null) {
          if (this.yAJ.hTJ.rPI != 1) {
            break label669;
          }
        }
        label669:
        for (localObject = ai.getContext().getString(2131763974, new Object[] { this.yAJ.hTJ.dol });; localObject = this.yAJ.hTJ.dol)
        {
          this.yyT.setVisibility(0);
          this.yyT.setText(this.yAJ.hTJ.desc);
          this.titleTv.setText(k.c(this.iMV, (CharSequence)localObject));
          break;
        }
      }
      this.titleTv.setText(be.avL(this.link));
      break label255;
      label700:
      if (!bs.cv(this.yyP))
      {
        this.yyS.setVisibility(0);
        this.hua = f.ck(this.yyP);
        this.yyS.setImageBitmap(this.hua);
        this.yAh = true;
      }
      else if (!bs.isNullOrNil(this.yAH))
      {
        this.yyS.setImageResource(2131690949);
        this.yyS.setVisibility(0);
      }
      else if (this.yAv == 17)
      {
        if ((this.yAI != null) && (!this.yAI.hTI.mediaList.isEmpty()) && (!bs.isNullOrNil(((anw)this.yAI.hTI.mediaList.get(0)).thumbUrl))) {
          this.yyS.setUrl(((anw)this.yAI.hTI.mediaList.get(0)).thumbUrl);
        }
        this.yyS.setVisibility(0);
      }
      else if (this.yAv == 18)
      {
        if ((this.yAJ != null) && (this.yAJ.hTJ != null)) {
          this.yyS.setUrl(this.yAJ.hTJ.iconUrl);
        }
        this.yyS.setVisibility(0);
      }
      else
      {
        this.yyS.setImageResource(2131689584);
        this.yyS.setVisibility(0);
      }
    }
  }
  
  public final boolean dNt()
  {
    AppMethodBeat.i(97929);
    if ((this.hua != null) && (!this.hua.isRecycled()) && (this.yAh)) {
      this.hua.recycle();
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ac
 * JD-Core Version:    0.7.0.1
 */