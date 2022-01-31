package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.c;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.h;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.ay;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.cfm;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.vi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class z
  implements y
{
  private String appId;
  private String appName;
  private String cGN;
  private String cGS;
  private String cGT;
  final MMActivity cmc;
  public String fiU = "";
  public String fiV = "";
  private Bitmap frG = null;
  private int h = -1;
  private View jIo = null;
  String link = "";
  private boolean mCu = false;
  String mSessionId;
  private String rGa = "";
  private byte[] rGb = null;
  private String rGc;
  private int rGd;
  private CdnImageView rGe = null;
  private TextView rGf = null;
  private b rGj = null;
  private String rHA;
  private boolean rHB = false;
  private boolean rHC = false;
  private boolean rHD = false;
  private boolean rHE = false;
  private WXMediaMessage rHF = null;
  private String rHG = "";
  private String rHH = "";
  private String rHI;
  private String rHJ;
  private int rHK = 0;
  private b rHL = null;
  private int rHM = 0;
  private String rHN = "";
  private String rHO = "";
  private int rHP = 0;
  private String rHQ = "";
  private String rHR = "";
  String rHS = "";
  private boolean rHy = false;
  private String rHz;
  private cyl rjx = null;
  private String title = "";
  private TextView titleTv = null;
  private String videoUrl = "";
  private int w = -1;
  
  public z(MMActivity paramMMActivity)
  {
    this.cmc = paramMMActivity;
  }
  
  public final void V(Bundle paramBundle)
  {
    AppMethodBeat.i(38276);
    this.rGj = b.w(this.cmc.getIntent());
    this.rHM = this.cmc.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.rHP = this.cmc.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.rHQ = bo.bf(this.cmc.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.rHR = bo.bf(this.cmc.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.fiU = bo.bf(this.cmc.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.fiV = bo.bf(this.cmc.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.cmc.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.cmc.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.rGd = this.cmc.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.rHA = bo.bf(this.cmc.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.link = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.rGa = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.rGb = this.cmc.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    if ((this.rGb == null) && (this.rHF != null) && (this.rHF.mediaObject != null) && ((this.rHF.mediaObject instanceof WXImageObject))) {
      this.rGb = ((WXImageObject)this.rHF.mediaObject).imageData;
    }
    this.mCu = this.cmc.getIntent().getBooleanExtra("ksnsis_video", false);
    this.rHB = this.cmc.getIntent().getBooleanExtra("ksnsis_music", false);
    this.rHC = this.cmc.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.cGN = bo.bf(this.cmc.getIntent().getStringExtra("src_username"), "");
    this.rGc = bo.bf(this.cmc.getIntent().getStringExtra("src_displayname"), "");
    this.appId = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bo.bf(this.cmc.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.rHD = this.cmc.getIntent().getBooleanExtra("KThrid_app", false);
    this.rHE = this.cmc.getIntent().getBooleanExtra("KSnsAction", false);
    this.rHI = bo.bf(this.cmc.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.rHJ = bo.bf(this.cmc.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.cGS = bo.bf(this.cmc.getIntent().getStringExtra("JsAppId"), "");
    this.cGT = bo.bf(this.cmc.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = bo.bf(this.cmc.getIntent().getStringExtra("reportSessionId"), "");
    this.rHK = this.cmc.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.rHS = this.cmc.getIntent().getStringExtra("fav_note_xml");
    this.rHN = bo.bf(this.cmc.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.rHO = bo.bf(this.cmc.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.rHz = bo.bf(this.cmc.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.rHz.startsWith("http://mmsns.qpic.cn")) || (this.rHz.startsWith("https://mmsns.qpic.cn")))
    {
      this.rGa = this.rHz;
      this.rGb = null;
      ab.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.rHz });
    }
    paramBundle = this.cmc.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.rHF = new SendMessageToWX.Req(paramBundle).message;
      if (bo.isNullOrNil(this.title)) {
        this.title = this.rHF.title;
      }
      if (bo.isNullOrNil(this.rHH)) {
        this.rHH = this.rHF.description;
      }
      if (bo.ce(this.rGb)) {
        this.rGb = this.rHF.thumbData;
      }
    }
    paramBundle = this.cmc.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.rjx = new cyl();
    }
    try
    {
      this.rjx.parseFrom(paramBundle);
      paramBundle = this.cmc.getIntent().getStringExtra("KSnsStrId");
      Object localObject = bo.bf(this.cmc.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = ag.cpf().abv((String)localObject);
      if (!bo.isNullOrNil(paramBundle))
      {
        this.rHL = b.lV(706);
        this.rHL.lZ(this.rHL.fQC).uw(System.currentTimeMillis()).lZ(this.rHL.fQD).lZ(1).uw(paramBundle);
        if (localObject != null)
        {
          this.rHL.lY(((n)localObject).field_type);
          this.rHL.de(((n)localObject).Ex(32)).uv(((n)localObject).csP()).uv(this.link);
        }
        h.roZ.b(this.rHL);
      }
      AppMethodBeat.o(38276);
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.LinkWidget", paramBundle, "parse web search info failed", new Object[0]);
        this.rjx = null;
      }
    }
  }
  
  public final void W(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.b.d.i parami, String paramString1, List<String> paramList1, bap parambap, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(38278);
    Object localObject1;
    if (this.rHB) {
      localObject1 = new ay(4);
    }
    label324:
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      paramPInt.value = ((ay)localObject1).ayi;
      if (paramInt3 > a.raX) {
        ((ay)localObject1).DS(4);
      }
      if (this.rGb == null)
      {
        com.tencent.mm.at.o.ahB();
        paramPInt = c.lK(this.rGa);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = d.a(paramPInt, 150, 150, false, false);
          ab.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.rGb = d.ai(paramPInt);
        }
      }
      ((ay)localObject1).aaQ(this.title).aaO(this.link).aaP(this.link).aaL(paramString1);
      if (this.rHM == 15) {
        ((ay)localObject1).aaO(bo.bf(this.cmc.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.rHB) {
        break;
      }
      if (!((ay)localObject1).a(this.rGb, this.link, this.link, this.link, 3, "", "")) {}
      ((ay)localObject1).DW(this.rGd);
      ((ay)localObject1).aaT(this.cGN);
      ((ay)localObject1).aaU(this.rGc);
      paramString1 = this.rHA;
      ((ay)localObject1).rjr.rHA = bo.nullAsNil(paramString1);
      ab.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      ((ay)localObject1).DU(paramInt1);
      if (!paramBoolean) {
        break label1194;
      }
      ((ay)localObject1).DX(1);
      ((ay)localObject1).dc(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1204;
      }
      new LinkedList();
      paramList2 = t.aac();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          localObject2 = new cfm();
          ((cfm)localObject2).jJA = paramPInt;
          paramString1.add(localObject2);
        }
      }
      if (this.mCu)
      {
        localObject1 = new ay(5);
      }
      else if (this.rHC)
      {
        localObject1 = new ay(25);
        localObject2 = this.rHN;
        ((ay)localObject1).rjr.xTY.username = ((String)localObject2);
        localObject2 = this.rHO;
        ((ay)localObject1).rjr.xTY.path = ((String)localObject2);
      }
      else if (this.rHM == 11)
      {
        localObject1 = new ay(18);
        localObject2 = new cih();
        ((cih)localObject2).fiR = this.rHQ;
        ((cih)localObject2).fiQ = this.title;
        ((cih)localObject2).fiO = this.link;
        ((cih)localObject2).fiS = this.rHR;
        ((cih)localObject2).fiP = this.rHP;
        ((cih)localObject2).fiT = this.rGa;
        ((cih)localObject2).fiU = this.fiU;
        ((cih)localObject2).fiV = this.fiV;
        ((ay)localObject1).rjw = ((cih)localObject2);
        ((ay)localObject1).rjr.xTX = ((cih)localObject2);
      }
      else if (this.rHM == 15)
      {
        localObject1 = new ay(26);
        localObject2 = this.rHS;
        ((ay)localObject1).rjr.xTS.wOc = ((String)localObject2);
      }
      else if ((this.rHM == 16) && (this.rjx != null))
      {
        localObject2 = new ay(3);
        localObject3 = this.rjx;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((ay)localObject2).rjx = ((cyl)localObject3);
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = new ay(3);
      }
    }
    if (this.mCu) {
      if (this.rHF == null) {
        break label1503;
      }
    }
    label788:
    label852:
    label1118:
    label1503:
    for (paramPInt = (WXVideoObject)this.rHF.mediaObject;; paramPInt = null)
    {
      localObject2 = this.rGb;
      localObject3 = this.link;
      if (paramPInt == null)
      {
        paramString1 = this.link;
        if (paramPInt != null) {
          break label852;
        }
      }
      for (paramPInt = this.link;; paramPInt = bo.bf(paramPInt.videoUrl, this.link))
      {
        ((ay)localObject1).a((byte[])localObject2, (String)localObject3, paramString1, paramPInt, 4, bo.bf(this.title, ""), bo.bf(this.rHH, ""));
        break;
        paramString1 = bo.bf(paramPInt.videoLowBandUrl, this.link);
        break label788;
      }
      if (!bo.isNullOrNil(this.rHz))
      {
        paramString1 = this.rHz;
        paramInt2 = this.w;
        paramInt3 = this.h;
        paramString1 = ay.ak("", paramString1, paramString1);
        if (paramString1 == null)
        {
          ab.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
          break;
        }
        paramString1.Desc = "";
        if ((paramInt2 > 0) && (paramInt3 > 0))
        {
          paramPInt = new bcu();
          paramPInt.xsI = paramInt3;
          paramPInt.xsH = paramInt2;
          paramString1.xrV = paramPInt;
        }
        if (!bo.isNullOrNil("")) {
          paramString1.Title = "";
        }
        if (!bo.isNullOrNil("")) {
          paramString1.Desc = "";
        }
        ((ay)localObject1).rjr.xTS.wOa.add(paramString1);
        break;
      }
      if (this.rGb == null) {
        break;
      }
      if (this.rHC)
      {
        paramString1 = this.rGb;
        if (paramString1 != null) {
          break label1118;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          ab.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.bk(this.rGb);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            ab.i("MicroMsg.LinkWidget", "use covert data");
            this.rGb = e.bk(paramString1);
          }
        }
        ((ay)localObject1).b(this.rGb, "", "");
        break;
        if (paramString1.length >= 4) {
          break label1131;
        }
      }
      label1131:
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
      ((ay)localObject1).DX(0);
      break label324;
      if (parami != null) {
        ((ay)localObject1).go(parami.token, parami.xsy);
      }
      ((ay)localObject1).av(paramString1);
      if (!bo.isNullOrNil(this.appId)) {
        ((ay)localObject1).aaR(this.appId);
      }
      if (!bo.isNullOrNil(this.appName)) {
        ((ay)localObject1).aaS(bo.bf(this.appName, ""));
      }
      if (this.rHD) {
        ((ay)localObject1).DW(5);
      }
      ((ay)localObject1).a(parambap);
      if ((this.rHE) && (this.rHF != null))
      {
        ((ay)localObject1).aaM(this.rHF.mediaTagName);
        ((ay)localObject1).aj(this.appId, this.rHF.messageExt, this.rHF.messageAction);
      }
      ((ay)localObject1).aaN(paramString2);
      ((ay)localObject1).g(this.rHI, this.rHJ, this.cGS, paramInt4, paramInt5);
      parami = this.cGT;
      ((ay)localObject1).rjs.cGT = parami;
      ((ay)localObject1).setSessionId(this.mSessionId);
      paramInt1 = this.rHK;
      ((ay)localObject1).rjr.fgB = paramInt1;
      paramInt1 = ((ay)localObject1).commit();
      if (this.rGj != null)
      {
        this.rGj.lX(paramInt1);
        g.roZ.c(this.rGj);
      }
      if (this.rHL != null)
      {
        this.rHL.lX(paramInt1);
        h.roZ.c(this.rHL);
        this.rHL.ake();
      }
      ag.cpb().cnP();
      this.cmc.finish();
      AppMethodBeat.o(38278);
      return false;
    }
  }
  
  public final boolean ctu()
  {
    return true;
  }
  
  public final View ctv()
  {
    AppMethodBeat.i(38277);
    this.jIo = w.hM(this.cmc).inflate(2130971051, null);
    if (!bo.isNullOrNil(this.link)) {
      this.jIo.setOnClickListener(new z.1(this));
    }
    this.rGe = ((CdnImageView)this.jIo.findViewById(2131825855));
    this.titleTv = ((TextView)this.jIo.findViewById(2131825857));
    this.rGf = ((TextView)this.jIo.findViewById(2131825858));
    int i;
    if ((!this.mCu) && (!this.rHB))
    {
      if ((this.rjx != null) && (!bo.isNullOrNil(this.rjx.uJi)))
      {
        i = 1;
        if (i == 0) {
          break label233;
        }
      }
    }
    else
    {
      this.jIo.findViewById(2131824765).setVisibility(0);
      label154:
      if (bo.isNullOrNil(this.title)) {
        break label251;
      }
      this.titleTv.setText(this.title);
      label175:
      if (bo.isNullOrNil(this.rGa)) {
        break label268;
      }
      this.rGe.setVisibility(0);
      this.rGe.setUrl(this.rGa);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.i.b(this.rGe, this.cmc);
      View localView = this.jIo;
      AppMethodBeat.o(38277);
      return localView;
      i = 0;
      break;
      label233:
      this.jIo.findViewById(2131824765).setVisibility(8);
      break label154;
      label251:
      this.titleTv.setText(av.acj(this.link));
      break label175;
      label268:
      if (!bo.ce(this.rGb))
      {
        this.rGe.setVisibility(0);
        this.frG = d.bT(this.rGb);
        this.rGe.setImageBitmap(this.frG);
        this.rHy = true;
      }
      else if (!bo.isNullOrNil(this.rHS))
      {
        this.rGe.setImageResource(2131231779);
        this.rGe.setVisibility(0);
      }
      else
      {
        this.rGe.setImageResource(2131230829);
        this.rGe.setVisibility(0);
      }
    }
  }
  
  public final boolean ctw()
  {
    AppMethodBeat.i(38279);
    if ((this.frG != null) && (!this.frG.isRecycled()) && (this.rHy)) {
      this.frG.recycle();
    }
    AppMethodBeat.o(38279);
    return false;
  }
  
  public final boolean j(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.z
 * JD-Core Version:    0.7.0.1
 */