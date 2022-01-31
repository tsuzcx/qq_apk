package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.h.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.aui;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.ckw;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class z
  implements y
{
  private String appId;
  private String appName;
  final MMActivity bER;
  private String bYG;
  private String bYL;
  private String bYM;
  public String dSV = "";
  public String dSW = "";
  String eAl = "";
  private TextView eXr = null;
  private Bitmap ebo = null;
  private String fKV;
  private int h = -1;
  private View hNa = null;
  private boolean khM = false;
  private String oOp = "";
  private byte[] oOq = null;
  private String oOr;
  private int oOs;
  private CdnImageView oOt = null;
  private TextView oOu = null;
  private b oOy = null;
  private boolean oPM = false;
  private String oPN;
  private String oPO;
  private boolean oPP = false;
  private boolean oPQ = false;
  private boolean oPR = false;
  private boolean oPS = false;
  private WXMediaMessage oPT = null;
  private String oPU = "";
  private String oPV = "";
  private String oPW;
  private String oPX;
  private int oPY = 0;
  private b oPZ = null;
  private int oQa = 0;
  private String oQb = "";
  private String oQc = "";
  private int oQd = 0;
  private String oQe = "";
  private String oQf = "";
  String oQg = "";
  private ckw ouE = null;
  private String title = "";
  private String videoUrl = "";
  private int w = -1;
  
  public z(MMActivity paramMMActivity)
  {
    this.bER = paramMMActivity;
  }
  
  public final void E(Bundle paramBundle)
  {
    this.oOy = b.i(this.bER.getIntent());
    this.oQa = this.bER.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.oQd = this.bER.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.oQe = bk.aM(this.bER.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.oQf = bk.aM(this.bER.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.dSV = bk.aM(this.bER.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.dSW = bk.aM(this.bER.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.bER.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.bER.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.oOs = this.bER.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.oPO = bk.aM(this.bER.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.eAl = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.oOp = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.oOq = this.bER.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    if ((this.oOq == null) && (this.oPT != null) && (this.oPT.mediaObject != null) && ((this.oPT.mediaObject instanceof WXImageObject))) {
      this.oOq = ((WXImageObject)this.oPT.mediaObject).imageData;
    }
    this.khM = this.bER.getIntent().getBooleanExtra("ksnsis_video", false);
    this.oPP = this.bER.getIntent().getBooleanExtra("ksnsis_music", false);
    this.oPQ = this.bER.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.bYG = bk.aM(this.bER.getIntent().getStringExtra("src_username"), "");
    this.oOr = bk.aM(this.bER.getIntent().getStringExtra("src_displayname"), "");
    this.appId = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = bk.aM(this.bER.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.oPR = this.bER.getIntent().getBooleanExtra("KThrid_app", false);
    this.oPS = this.bER.getIntent().getBooleanExtra("KSnsAction", false);
    this.oPW = bk.aM(this.bER.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.oPX = bk.aM(this.bER.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.bYL = bk.aM(this.bER.getIntent().getStringExtra("JsAppId"), "");
    this.bYM = bk.aM(this.bER.getIntent().getStringExtra("KPublisherId"), "");
    this.fKV = bk.aM(this.bER.getIntent().getStringExtra("reportSessionId"), "");
    this.oPY = this.bER.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.oQg = this.bER.getIntent().getStringExtra("fav_note_xml");
    this.oQb = bk.aM(this.bER.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.oQc = bk.aM(this.bER.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.oPN = bk.aM(this.bER.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.oPN.startsWith("http://mmsns.qpic.cn")) || (this.oPN.startsWith("https://mmsns.qpic.cn")))
    {
      this.oOp = this.oPN;
      this.oOq = null;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.oPN });
    }
    paramBundle = this.bER.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.oPT = new SendMessageToWX.Req(paramBundle).message;
      if (bk.bl(this.title)) {
        this.title = this.oPT.title;
      }
      if (bk.bl(this.oPV)) {
        this.oPV = this.oPT.description;
      }
      if (bk.bE(this.oOq)) {
        this.oOq = this.oPT.thumbData;
      }
    }
    paramBundle = this.bER.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.ouE = new ckw();
    }
    try
    {
      this.ouE.aH(paramBundle);
      paramBundle = this.bER.getIntent().getStringExtra("KSnsStrId");
      Object localObject = bk.aM(this.bER.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = af.bDF().OB((String)localObject);
      if (!bk.bl(paramBundle))
      {
        this.oPZ = b.jd(706);
        this.oPZ.jh(this.oPZ.eAJ).nj(System.currentTimeMillis()).jh(this.oPZ.eAK).jh(1).nj(paramBundle);
        if (localObject != null)
        {
          this.oPZ.jg(((n)localObject).field_type);
          this.oPZ.cb(((n)localObject).yr(32)).ni(((n)localObject).bGM()).ni(this.eAl);
        }
        g.ozP.b(this.oPZ);
      }
      return;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.LinkWidget", paramBundle, "parse web search info failed", new Object[0]);
        this.ouE = null;
      }
    }
  }
  
  public final void F(Bundle paramBundle) {}
  
  public final boolean a(int paramInt1, int paramInt2, org.c.d.i parami, String paramString1, List<String> paramList1, aui paramaui, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    Object localObject1;
    if (this.oPP) {
      localObject1 = new ax(4);
    }
    label318:
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      paramPInt.value = ((ax)localObject1).avS;
      if (paramInt3 > a.omJ) {
        ((ax)localObject1).xS(4);
      }
      if (this.oOq == null)
      {
        com.tencent.mm.as.o.OI();
        paramPInt = com.tencent.mm.as.c.jK(this.oOp);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = com.tencent.mm.sdk.platformtools.c.a(paramPInt, 150, 150, false, false);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.oOq = com.tencent.mm.sdk.platformtools.c.T(paramPInt);
        }
      }
      ((ax)localObject1).NW(this.title).NU(this.eAl).NV(this.eAl).NR(paramString1);
      if (this.oQa == 15) {
        ((ax)localObject1).NU(bk.aM(this.bER.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.oPP) {
        break;
      }
      if (!((ax)localObject1).a(this.oOq, this.eAl, this.eAl, this.eAl, 3, "", "")) {}
      ((ax)localObject1).xW(this.oOs);
      ((ax)localObject1).NZ(this.bYG);
      ((ax)localObject1).Oa(this.oOr);
      paramString1 = this.oPO;
      ((ax)localObject1).ouy.oPO = bk.pm(paramString1);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      ((ax)localObject1).xU(paramInt1);
      if (!paramBoolean) {
        break label1188;
      }
      ((ax)localObject1).xX(1);
      ((ax)localObject1).cx(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1198;
      }
      new LinkedList();
      paramList2 = s.Ha();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if (!paramList2.contains(paramPInt))
        {
          localObject2 = new buw();
          ((buw)localObject2).hPY = paramPInt;
          paramString1.add(localObject2);
        }
      }
      if (this.khM)
      {
        localObject1 = new ax(5);
      }
      else if (this.oPQ)
      {
        localObject1 = new ax(25);
        localObject2 = this.oQb;
        ((ax)localObject1).ouy.tNx.username = ((String)localObject2);
        localObject2 = this.oQc;
        ((ax)localObject1).ouy.tNx.path = ((String)localObject2);
      }
      else if (this.oQa == 11)
      {
        localObject1 = new ax(18);
        localObject2 = new bvz();
        ((bvz)localObject2).dSS = this.oQe;
        ((bvz)localObject2).dSR = this.title;
        ((bvz)localObject2).dSP = this.eAl;
        ((bvz)localObject2).dST = this.oQf;
        ((bvz)localObject2).dSQ = this.oQd;
        ((bvz)localObject2).dSU = this.oOp;
        ((bvz)localObject2).dSV = this.dSV;
        ((bvz)localObject2).dSW = this.dSW;
        ((ax)localObject1).ouD = ((bvz)localObject2);
        ((ax)localObject1).ouy.tNw = ((bvz)localObject2);
      }
      else if (this.oQa == 15)
      {
        localObject1 = new ax(26);
        localObject2 = this.oQg;
        ((ax)localObject1).ouy.tNr.sPL = ((String)localObject2);
      }
      else if ((this.oQa == 16) && (this.ouE != null))
      {
        localObject2 = new ax(3);
        localObject3 = this.ouE;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((ax)localObject2).ouE = ((ckw)localObject3);
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject1 = new ax(3);
      }
    }
    if (this.khM) {
      if (this.oPT == null) {
        break label1491;
      }
    }
    label782:
    label846:
    label1491:
    for (paramPInt = (WXVideoObject)this.oPT.mediaObject;; paramPInt = null)
    {
      localObject2 = this.oOq;
      localObject3 = this.eAl;
      if (paramPInt == null)
      {
        paramString1 = this.eAl;
        if (paramPInt != null) {
          break label846;
        }
      }
      for (paramPInt = this.eAl;; paramPInt = bk.aM(paramPInt.videoUrl, this.eAl))
      {
        ((ax)localObject1).a((byte[])localObject2, (String)localObject3, paramString1, paramPInt, 4, bk.aM(this.title, ""), bk.aM(this.oPV, ""));
        break;
        paramString1 = bk.aM(paramPInt.videoLowBandUrl, this.eAl);
        break label782;
      }
      if (!bk.bl(this.oPN))
      {
        paramString1 = this.oPN;
        paramInt2 = this.w;
        paramInt3 = this.h;
        paramString1 = ax.Z("", paramString1, paramString1);
        if (paramString1 == null)
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.UploadPackHelper", "share img o.url is null!");
          break;
        }
        paramString1.kRN = "";
        if ((paramInt2 > 0) && (paramInt3 > 0))
        {
          paramPInt = new awf();
          paramPInt.tsG = paramInt3;
          paramPInt.tsF = paramInt2;
          paramString1.trS = paramPInt;
        }
        if (!bk.bl("")) {
          paramString1.bGw = "";
        }
        if (!bk.bl("")) {
          paramString1.kRN = "";
        }
        ((ax)localObject1).ouy.tNr.sPJ.add(paramString1);
        break;
      }
      if (this.oOq == null) {
        break;
      }
      if (this.oPQ)
      {
        paramString1 = this.oOq;
        if (paramString1 != null) {
          break label1112;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.aM(this.oOq);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.LinkWidget", "use covert data");
            this.oOq = e.aM(paramString1);
          }
        }
        ((ax)localObject1).b(this.oOq, "", "");
        break;
        label1112:
        if (paramString1.length >= 4) {
          break label1125;
        }
      }
      label1125:
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
      ((ax)localObject1).xX(0);
      break label318;
      if (parami != null) {
        ((ax)localObject1).eM(parami.token, parami.tsv);
      }
      ((ax)localObject1).am(paramString1);
      if (!bk.bl(this.appId)) {
        ((ax)localObject1).NX(this.appId);
      }
      if (!bk.bl(this.appName)) {
        ((ax)localObject1).NY(bk.aM(this.appName, ""));
      }
      if (this.oPR) {
        ((ax)localObject1).xW(5);
      }
      ((ax)localObject1).a(paramaui);
      if ((this.oPS) && (this.oPT != null))
      {
        ((ax)localObject1).NS(this.oPT.mediaTagName);
        ((ax)localObject1).Y(this.appId, this.oPT.messageExt, this.oPT.messageAction);
      }
      ((ax)localObject1).NT(paramString2);
      ((ax)localObject1).f(this.oPW, this.oPX, this.bYL, paramInt4, paramInt5);
      parami = this.bYM;
      ((ax)localObject1).ouz.bYM = parami;
      ((ax)localObject1).setSessionId(this.fKV);
      paramInt1 = this.oPY;
      ((ax)localObject1).ouy.dQA = paramInt1;
      paramInt1 = ((ax)localObject1).commit();
      if (this.oOy != null)
      {
        this.oOy.jf(paramInt1);
        f.ozP.c(this.oOy);
      }
      if (this.oPZ != null)
      {
        this.oPZ.jf(paramInt1);
        g.ozP.c(this.oPZ);
        this.oPZ.QX();
      }
      af.bDB().bCp();
      this.bER.finish();
      return false;
    }
  }
  
  public final boolean bHq()
  {
    return true;
  }
  
  public final View bHr()
  {
    this.hNa = com.tencent.mm.ui.y.gt(this.bER).inflate(i.g.upload_media_link, null);
    if (!bk.bl(this.eAl)) {
      this.hNa.setOnClickListener(new z.1(this));
    }
    this.oOt = ((CdnImageView)this.hNa.findViewById(i.f.image_left));
    this.eXr = ((TextView)this.hNa.findViewById(i.f.titletext));
    this.oOu = ((TextView)this.hNa.findViewById(i.f.righttext));
    int i;
    if ((!this.khM) && (!this.oPP))
    {
      if ((this.ouE != null) && (!bk.bl(this.ouE.qTY)))
      {
        i = 1;
        if (i == 0) {
          break label219;
        }
      }
    }
    else
    {
      this.hNa.findViewById(i.f.state).setVisibility(0);
      label148:
      if (bk.bl(this.title)) {
        break label237;
      }
      this.eXr.setText(this.title);
      label169:
      if (bk.bl(this.oOp)) {
        break label254;
      }
      this.oOt.setVisibility(0);
      this.oOt.setUrl(this.oOp);
    }
    for (;;)
    {
      com.tencent.mm.plugin.sns.data.i.b(this.oOt, this.bER);
      return this.hNa;
      i = 0;
      break;
      label219:
      this.hNa.findViewById(i.f.state).setVisibility(8);
      break label148;
      label237:
      this.eXr.setText(au.Pq(this.eAl));
      break label169;
      label254:
      if (!bk.bE(this.oOq))
      {
        this.oOt.setVisibility(0);
        this.ebo = com.tencent.mm.sdk.platformtools.c.bu(this.oOq);
        this.oOt.setImageBitmap(this.ebo);
        this.oPM = true;
      }
      else if (!bk.bl(this.oQg))
      {
        this.oOt.setImageResource(i.i.note_sns_link_default);
        this.oOt.setVisibility(0);
      }
      else
      {
        this.oOt.setImageResource(i.i.app_attach_file_icon_webpage);
        this.oOt.setVisibility(0);
      }
    }
  }
  
  public final boolean bHs()
  {
    if ((this.ebo != null) && (!this.ebo.isRecycled()) && (this.oPM)) {
      this.ebo.recycle();
    }
    return false;
  }
  
  public final boolean d(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.z
 * JD-Core Version:    0.7.0.1
 */