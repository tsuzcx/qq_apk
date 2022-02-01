package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.modelsns.d;
import com.tencent.mm.modelsns.f;
import com.tencent.mm.modelsns.g;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.plugin.findersdk.a.q;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.bf;
import com.tencent.mm.plugin.sns.model.bg;
import com.tencent.mm.plugin.sns.statistics.m;
import com.tencent.mm.plugin.sns.statistics.n;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvj;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.protocal.protobuf.bvm;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.djv;
import com.tencent.mm.protocal.protobuf.dob;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.ffw;
import com.tencent.mm.protocal.protobuf.fjo;
import com.tencent.mm.protocal.protobuf.gfh;
import com.tencent.mm.protocal.protobuf.gib;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.LinkedList<Ljava.lang.Long;>;
import java.util.List;
import java.util.Map;
import org.b.d.i;

public final class ah
  implements ag
{
  private String ADt = "";
  private boolean AnF = false;
  private int DnR = 0;
  private int QzF = 1;
  private com.tencent.mm.modelsns.l RcD = null;
  private String RcE = "";
  private com.tencent.mm.modelsns.e RcQ;
  private byte[] Rcw = null;
  private String Rcx;
  private int Rcy;
  private CdnImageView Rcz = null;
  private int ReA = 0;
  private String ReB = "";
  private String ReC = "";
  String ReD = "";
  private g ReE;
  private b ReF;
  private d ReG;
  private c ReH;
  private h ReI;
  private f ReJ;
  private boolean Rec = false;
  private String Ree;
  private boolean Ref = false;
  boolean Reg = false;
  boolean Reh = false;
  private boolean Rei = false;
  private boolean Rej = false;
  private WXMediaMessage Rek = null;
  private String Rel = "";
  private String Rem = "";
  private String Ren;
  private String Reo;
  private int Rep = 0;
  private com.tencent.mm.modelsns.l Req = null;
  private String Rer = "";
  private String Res = "";
  private int Ret;
  private int Reu;
  private String Rev;
  private boolean Rew;
  private String Rex;
  private int Rey;
  private String Rez;
  private String appId;
  private String appName;
  private View doN = null;
  private int h = -1;
  private String iaa;
  private String iaf;
  private String iag;
  String link = "";
  final MMActivity lzt;
  String mSessionId;
  public String nTA = "";
  public String nTB = "";
  private String nTQ = "";
  private String nTR = "";
  private String nTS = "";
  private Bitmap orY = null;
  private String statExtStr;
  private String title = "";
  private TextView titleTv = null;
  private String videoUrl = "";
  private int w = -1;
  private gib webSearchInfo = null;
  private TextView ycd = null;
  
  public ah(MMActivity paramMMActivity)
  {
    this.lzt = paramMMActivity;
  }
  
  public final boolean a(int paramInt1, int paramInt2, i parami, String paramString1, List<String> paramList1, djv paramdjv, LinkedList<Long> paramLinkedList, int paramInt3, boolean paramBoolean, List<String> paramList2, PInt paramPInt, String paramString2, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(97928);
    if (this.Ref) {
      paramLinkedList = new bg(4, this.lzt);
    }
    label367:
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      paramPInt.value = paramLinkedList.cIh;
      if (paramInt3 > com.tencent.mm.plugin.sns.d.a.Qkq) {
        paramLinkedList.akL(4);
      }
      if (this.Rcw == null)
      {
        r.bJZ();
        paramPInt = com.tencent.mm.modelimage.e.Eo(this.ADt);
        if ((paramPInt != null) && (!paramPInt.isRecycled()))
        {
          paramPInt = BitmapUtil.extractThumbNail(paramPInt, 150, 150, false, false);
          Log.i("MicroMsg.LinkWidget", "create bitmap %d %d", new Object[] { Integer.valueOf(paramPInt.getHeight()), Integer.valueOf(paramPInt.getWidth()) });
          this.Rcw = BitmapUtil.Bitmap2Bytes(paramPInt);
        }
      }
      paramLinkedList.aYR(this.title).aYP(this.link).aYQ(this.link).aYM(paramString1);
      paramLinkedList.aYP(Util.nullAs(this.lzt.getIntent().getStringExtra("ksnsupload_link_desc"), ""));
      if (this.DnR == 15) {
        paramLinkedList.aYP(Util.nullAs(this.lzt.getIntent().getStringExtra("fav_note_link_description"), ""));
      }
      if (!this.Ref) {
        break;
      }
      if (!paramLinkedList.a(this.Rcw, this.link, this.link, this.link, 3, "", "", "", "")) {}
      paramLinkedList.df(this.QzF, this.RcE);
      paramLinkedList.akQ(this.Rcy);
      paramLinkedList.aYU(this.iaa);
      paramLinkedList.aYV(this.Rcx);
      paramString1 = this.statExtStr;
      paramLinkedList.QzA.statExtStr = Util.nullAsNil(paramString1);
      Log.i("MicroMsg.UploadPackHelper", "setStatExtStr:%s", new Object[] { paramString1 });
      paramLinkedList.akO(paramInt1);
      if (!paramBoolean) {
        break label1940;
      }
      paramLinkedList.akR(1);
      paramLinkedList.kB(paramList2);
      paramString1 = new LinkedList();
      if (paramList1 == null) {
        break label1950;
      }
      new LinkedList();
      paramList2 = com.tencent.mm.pluginsdk.platformtools.a.iIX();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramPInt = (String)paramList1.next();
        if ((paramList2 != null) && (!paramList2.contains(paramPInt)))
        {
          localObject1 = new ffw();
          ((ffw)localObject1).UserName = paramPInt;
          paramString1.add(localObject1);
        }
      }
      if (this.AnF)
      {
        paramLinkedList = new bg(5, this.lzt);
      }
      else
      {
        if (this.Reg)
        {
          paramLinkedList = new bg(30, this.lzt);
          localObject1 = this.Rer;
          paramLinkedList.QzA.weappInfo.username = ((String)localObject1);
          localObject1 = this.Res;
          paramLinkedList.QzA.weappInfo.path = ((String)localObject1);
          paramInt2 = this.Ret;
          paramLinkedList.QzA.weappInfo.version = paramInt2;
          paramInt2 = this.Reu;
          paramLinkedList.QzA.weappInfo.tgv = paramInt2;
          localObject1 = this.Rev;
          paramLinkedList.QzA.weappInfo.hzD = ((String)localObject1);
          boolean bool = this.Rew;
          localObject1 = paramLinkedList.QzA.weappInfo;
          if (bool) {}
          for (paramInt2 = 1;; paramInt2 = 0)
          {
            ((gfh)localObject1).accE = paramInt2;
            localObject1 = this.Rex;
            paramLinkedList.QzA.weappInfo.idf = ((String)localObject1);
            paramInt2 = this.Rey;
            paramLinkedList.QzA.weappInfo.subType = paramInt2;
            localObject1 = this.Rez;
            paramLinkedList.QzA.weappInfo.accF = ((String)localObject1);
            break;
          }
        }
        if (this.Reh)
        {
          paramLinkedList = new bg(41, this.lzt);
          localObject1 = new dif();
          ((dif)localObject1).appId = this.nTQ;
          ((dif)localObject1).path = this.nTR;
          ((dif)localObject1).query = this.nTS;
          paramLinkedList.QzA.liteappInfo = ((dif)localObject1);
        }
        else if (this.DnR == 11)
        {
          paramLinkedList = new bg(18, this.lzt);
          localObject1 = new fjo();
          ((fjo)localObject1).nTx = this.ReB;
          ((fjo)localObject1).nTw = this.title;
          ((fjo)localObject1).nTu = this.link;
          ((fjo)localObject1).nTy = this.ReC;
          ((fjo)localObject1).nTv = this.ReA;
          ((fjo)localObject1).nTz = this.ADt;
          ((fjo)localObject1).nTA = this.nTA;
          ((fjo)localObject1).nTB = this.nTB;
          paramLinkedList.QzE = ((fjo)localObject1);
          paramLinkedList.QzA.streamvideo = ((fjo)localObject1);
        }
        else if (this.DnR == 15)
        {
          paramLinkedList = new bg(26, this.lzt);
          localObject1 = this.ReD;
          paramLinkedList.QzA.ContentObj.Zpt = ((String)localObject1);
        }
        else if ((this.DnR == 16) && (this.webSearchInfo != null))
        {
          localObject1 = new bg(3, this.lzt);
          localObject2 = this.webSearchInfo;
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (localObject2 != null)
          {
            ((bg)localObject1).webSearchInfo = ((gib)localObject2);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.DnR == 17)
        {
          localObject1 = new bg(28, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.RcQ != null)
          {
            ((bg)localObject1).a(this.RcQ);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.DnR == 23)
        {
          localObject1 = new bg(36, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReI != null)
          {
            ((bg)localObject1).a(this.ReI);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.DnR == 18)
        {
          localObject1 = new bg(29, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReE != null)
          {
            ((bg)localObject1).a(this.ReE);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.DnR == 22)
        {
          localObject1 = new bg(37, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReE != null)
          {
            ((bg)localObject1).a(this.ReE);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.DnR == 24)
        {
          localObject1 = new bg(39, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReF != null)
          {
            localObject2 = this.ReF;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bg)localObject1).QzA.ContentObj.Zpz = ((b)localObject2).oTZ;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else if (this.DnR == 20)
        {
          localObject1 = new bg(38, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReH != null)
          {
            localObject2 = this.ReH;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bg)localObject1).QzA.ContentObj.Zpx = ((c)localObject2).oUa;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else if (this.DnR == 21)
        {
          localObject1 = new bg(34, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReG != null)
          {
            ((bg)localObject1).a(this.ReG);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.DnR == 30)
        {
          localObject1 = new bg(45, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReG != null)
          {
            ((bg)localObject1).a(this.ReG);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.DnR == 27)
        {
          localObject1 = new bg(43, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReG != null)
          {
            ((bg)localObject1).a(this.ReG);
            paramLinkedList = (LinkedList<Long>)localObject1;
          }
        }
        else if (this.DnR == 29)
        {
          localObject1 = new bg(44, this.lzt);
          paramLinkedList = (LinkedList<Long>)localObject1;
          if (this.ReJ != null)
          {
            localObject2 = this.ReJ;
            paramLinkedList = (LinkedList<Long>)localObject1;
            if (localObject2 != null)
            {
              ((bg)localObject1).QzA.ContentObj.ZpA = ((f)localObject2).oUd;
              paramLinkedList = (LinkedList<Long>)localObject1;
            }
          }
        }
        else
        {
          paramLinkedList = new bg(3, this.lzt);
        }
      }
    }
    if (this.AnF) {
      if (this.Rek == null) {
        break label2239;
      }
    }
    label1717:
    label2239:
    for (paramPInt = (WXVideoObject)this.Rek.mediaObject;; paramPInt = null)
    {
      localObject1 = this.Rcw;
      localObject2 = this.link;
      if (paramPInt == null)
      {
        paramString1 = this.link;
        label1649:
        if (paramPInt != null) {
          break label1717;
        }
      }
      for (paramPInt = this.link;; paramPInt = Util.nullAs(paramPInt.videoUrl, this.link))
      {
        paramLinkedList.a((byte[])localObject1, (String)localObject2, paramString1, paramPInt, 4, Util.nullAs(this.title, ""), Util.nullAs(this.Rem, ""), "", "");
        break;
        paramString1 = Util.nullAs(paramPInt.videoLowBandUrl, this.link);
        break label1649;
      }
      if (!Util.isNullOrNil(this.Ree))
      {
        paramLinkedList.h(this.Ree, "", "", this.w, this.h);
        break;
      }
      if (this.Rcw == null) {
        break;
      }
      if (this.Reg)
      {
        paramString1 = this.Rcw;
        if (paramString1 != null) {
          break label1864;
        }
      }
      for (paramInt3 = 0;; paramInt3 = 0)
      {
        if (paramInt3 != 0)
        {
          Log.i("MicroMsg.LinkWidget", "isPngThumbData");
          paramString1 = e.cx(this.Rcw);
          if ((paramString1 != null) && (paramString1.length > 0))
          {
            Log.i("MicroMsg.LinkWidget", "use covert data");
            this.Rcw = e.cx(paramString1);
          }
        }
        paramLinkedList.b(this.Rcw, "", "");
        break;
        label1864:
        if (paramString1.length >= 4) {
          break label1877;
        }
      }
      label1877:
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
      paramLinkedList.akR(0);
      break label367;
      if (parami != null) {
        paramLinkedList.mm(parami.token, parami.aaTQ);
      }
      paramLinkedList.bU(paramString1);
      if (!Util.isNullOrNil(this.appId)) {
        paramLinkedList.aYS(this.appId);
      }
      if (!Util.isNullOrNil(this.appName)) {
        paramLinkedList.aYT(Util.nullAs(this.appName, ""));
      }
      if (this.Rei) {
        paramLinkedList.akQ(5);
      }
      paramLinkedList.a(paramdjv);
      if ((this.Rej) && (this.Rek != null))
      {
        paramLinkedList.aYN(this.Rek.mediaTagName);
        paramLinkedList.aY(this.appId, this.Rek.messageExt, this.Rek.messageAction);
      }
      paramLinkedList.aYO(paramString2);
      paramLinkedList.i(this.Ren, this.Reo, this.iaf, paramInt4, paramInt5);
      paramLinkedList.aYX(this.iag);
      paramLinkedList.setSessionId(this.mSessionId);
      paramLinkedList.akM(this.Rep);
      paramInt1 = paramLinkedList.FW();
      if (this.RcD != null)
      {
        this.RcD.wQ(paramInt1);
        com.tencent.mm.plugin.sns.statistics.l.QGY.c(this.RcD);
      }
      if (this.Req != null)
      {
        this.Req.wQ(paramInt1);
        m.QGY.c(this.Req);
        this.Req.bMH();
      }
      al.hgx().hej();
      this.lzt.finish();
      AppMethodBeat.o(97928);
      return false;
    }
  }
  
  public final void aZ(Bundle paramBundle)
  {
    AppMethodBeat.i(97926);
    this.RcD = com.tencent.mm.modelsns.l.y(this.lzt.getIntent());
    this.DnR = this.lzt.getIntent().getIntExtra("Ksnsupload_type", 0);
    this.ReA = this.lzt.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
    this.ReB = Util.nullAs(this.lzt.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
    this.ReC = Util.nullAs(this.lzt.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
    this.nTA = Util.nullAs(this.lzt.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
    this.nTB = Util.nullAs(this.lzt.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
    this.w = this.lzt.getIntent().getIntExtra("Ksnsupload_width", -1);
    this.h = this.lzt.getIntent().getIntExtra("Ksnsupload_height", -1);
    this.Rcy = this.lzt.getIntent().getIntExtra("Ksnsupload_source", 0);
    this.statExtStr = Util.nullAs(this.lzt.getIntent().getStringExtra("key_snsad_statextstr"), "");
    this.link = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_link"), "");
    this.title = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_title"), "");
    this.ADt = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
    this.Rcw = this.lzt.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
    paramBundle = this.lzt.getIntent().getStringExtra("KsnsUpload_imgPath");
    if ((this.Rcw == null) && (!Util.isNullOrNil(paramBundle))) {
      this.Rcw = y.bi(paramBundle, 0, -1);
    }
    if ((this.Rcw == null) && (this.Rek != null) && (this.Rek.mediaObject != null) && ((this.Rek.mediaObject instanceof WXImageObject))) {
      this.Rcw = ((WXImageObject)this.Rek.mediaObject).imageData;
    }
    this.AnF = this.lzt.getIntent().getBooleanExtra("ksnsis_video", false);
    this.Ref = this.lzt.getIntent().getBooleanExtra("ksnsis_music", false);
    this.Reg = this.lzt.getIntent().getBooleanExtra("ksnsis_appbrand", false);
    this.Reh = this.lzt.getIntent().getBooleanExtra("ksnsis_liteapp", false);
    this.iaa = Util.nullAs(this.lzt.getIntent().getStringExtra("src_username"), "");
    this.Rcx = Util.nullAs(this.lzt.getIntent().getStringExtra("src_displayname"), "");
    this.appId = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appid"), "");
    this.appName = Util.nullAs(this.lzt.getIntent().getStringExtra("Ksnsupload_appname"), "");
    this.Rei = this.lzt.getIntent().getBooleanExtra("KThrid_app", false);
    this.Rej = this.lzt.getIntent().getBooleanExtra("KSnsAction", false);
    this.Ren = Util.nullAs(this.lzt.getIntent().getStringExtra("ShareUrlOriginal"), "");
    this.Reo = Util.nullAs(this.lzt.getIntent().getStringExtra("ShareUrlOpen"), "");
    this.iaf = Util.nullAs(this.lzt.getIntent().getStringExtra("JsAppId"), "");
    this.iag = Util.nullAs(this.lzt.getIntent().getStringExtra("KPublisherId"), "");
    this.mSessionId = Util.nullAs(this.lzt.getIntent().getStringExtra("reportSessionId"), "");
    this.Rep = this.lzt.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
    this.ReD = this.lzt.getIntent().getStringExtra("fav_note_xml");
    this.Rer = Util.nullAs(this.lzt.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
    this.Res = Util.nullAs(this.lzt.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
    this.Ret = this.lzt.getIntent().getIntExtra("KsnsUpload_BrandVersion", 0);
    this.Reu = this.lzt.getIntent().getIntExtra("KsnsUpload_BrandVersionType", 0);
    this.Rev = Util.nullAs(this.lzt.getIntent().getStringExtra("KsnsUpload_BrandShareActionId"), "");
    this.Rew = this.lzt.getIntent().getBooleanExtra("KsnsUpload_isGame", false);
    this.Rex = Util.nullAs(this.lzt.getIntent().getStringExtra("KsnsUpload_MessageExtraData"), "");
    this.Rey = this.lzt.getIntent().getIntExtra("KsnsUpload_SubType", 0);
    this.Rez = Util.nullAs(this.lzt.getIntent().getStringExtra("KsnsUpload_PreloadResouces"), "");
    if (this.Reh)
    {
      this.nTQ = Util.nullAs(this.lzt.getIntent().getStringExtra("KsnsUpload_LiteAppId"), "");
      this.nTR = Util.nullAs(this.lzt.getIntent().getStringExtra("KsnsUpload_LiteAppPath"), "");
      this.nTS = Util.nullAs(this.lzt.getIntent().getStringExtra("KsnsUpload_LiteAppQuery"), "");
    }
    this.Ree = Util.nullAs(this.lzt.getIntent().getStringExtra("KlinkThumb_url"), "");
    if ((this.Ree.startsWith("http://mmsns.qpic.cn")) || (this.Ree.startsWith("https://mmsns.qpic.cn")))
    {
      this.ADt = this.Ree;
      this.Rcw = null;
      Log.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[] { this.Ree });
    }
    paramBundle = this.lzt.getIntent().getBundleExtra("Ksnsupload_timeline");
    if (paramBundle != null)
    {
      this.Rek = new SendMessageToWX.Req(paramBundle).message;
      if (Util.isNullOrNil(this.title)) {
        this.title = this.Rek.title;
      }
      if (Util.isNullOrNil(this.Rem)) {
        this.Rem = this.Rek.description;
      }
      if (Util.isNullOrNil(this.Rcw)) {
        this.Rcw = this.Rek.thumbData;
      }
    }
    paramBundle = this.lzt.getIntent().getByteArrayExtra("KWebSearchInfo");
    if (paramBundle != null) {
      this.webSearchInfo = new gib();
    }
    try
    {
      this.webSearchInfo.parseFrom(paramBundle);
      paramBundle = this.lzt.getIntent().getStringExtra("KSnsStrId");
      Object localObject = Util.nullAs(this.lzt.getIntent().getStringExtra("KSnsLocalId"), "");
      localObject = al.hgB().aZL((String)localObject);
      if (!Util.isNullOrNil(paramBundle))
      {
        this.Req = com.tencent.mm.modelsns.l.wO(706);
        this.Req.wS(this.Req.oUi).Pi(System.currentTimeMillis()).wS(this.Req.oUj).wS(1).Pi(paramBundle);
        if (localObject != null)
        {
          this.Req.wR(((SnsInfo)localObject).field_type);
          this.Req.hm(((SnsInfo)localObject).isAd()).Ph(((SnsInfo)localObject).getUxinfo()).Ph(this.link);
        }
        m.QGY.b(this.Req);
      }
      if (this.lzt.getIntent().getBooleanExtra("SendAppMessageWrapper_TokenValid", true))
      {
        this.QzF = 1;
        this.RcE = Util.nullAs(this.lzt.getIntent().getStringExtra("SendAppMessageWrapper_PkgName"), "");
        paramBundle = this.lzt.getIntent().getStringExtra("ksnsupload_finder_object_xml");
        if (!Util.isNullOrNil(paramBundle))
        {
          localObject = XmlParser.parseXml(paramBundle, "finderFeed", null);
          if (localObject != null)
          {
            this.RcQ = new com.tencent.mm.modelsns.e();
            this.RcQ.i("", (Map)localObject);
          }
        }
        localObject = this.lzt.getIntent().getStringExtra("ksnsupload_finder_topic_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderTopic", null);
          if (localObject != null)
          {
            this.ReE = new g();
            this.ReE.i("", (Map)localObject);
          }
        }
        localObject = this.lzt.getIntent().getStringExtra("ksnsupload_finder_activity_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderTopic", null);
          if (localObject != null)
          {
            this.ReF = new b();
            this.ReF.oTZ = q.F("", (Map)localObject);
          }
        }
        localObject = this.lzt.getIntent().getStringExtra("ksnsupload_finder_album_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderColumn", null);
          if (localObject != null)
          {
            this.ReH = new c();
            this.ReH.i("", (Map)localObject);
          }
        }
        localObject = this.lzt.getIntent().getStringExtra("ksnsupload_finder_live_xml");
        if (!Util.isNullOrNil((String)localObject))
        {
          localObject = XmlParser.parseXml((String)localObject, "finderLive", null);
          if (localObject != null)
          {
            this.ReG = new d();
            this.ReG.i("", (Map)localObject);
          }
        }
        if (!Util.isNullOrNil(this.lzt.getIntent().getStringExtra("ksnsupload_mega_video_object_xml")))
        {
          paramBundle = XmlParser.parseXml(paramBundle, "finderMegaVideo", null);
          if (paramBundle != null)
          {
            this.ReI = new h();
            this.ReI.i("", paramBundle);
          }
        }
        paramBundle = this.lzt.getIntent().getStringExtra("ksnsupload_finder_poi_xml");
        if (!Util.isNullOrNil(paramBundle))
        {
          paramBundle = XmlParser.parseXml(paramBundle, "finder", null);
          if (paramBundle != null)
          {
            this.ReJ = new f();
            this.ReJ.i("", paramBundle);
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
        this.QzF = 0;
      }
    }
  }
  
  public final void ba(Bundle paramBundle) {}
  
  public final boolean hlP()
  {
    return true;
  }
  
  public final View hlQ()
  {
    AppMethodBeat.i(97927);
    this.doN = af.mU(this.lzt).inflate(b.g.upload_media_link, null);
    if (!Util.isNullOrNil(this.link)) {
      this.doN.setOnClickListener(new ah.1(this));
    }
    this.Rcz = ((CdnImageView)this.doN.findViewById(b.f.image_left));
    this.titleTv = ((TextView)this.doN.findViewById(b.f.titletext));
    this.ycd = ((TextView)this.doN.findViewById(b.f.righttext));
    int i;
    label162:
    Object localObject;
    if ((!this.AnF) && (!this.Ref))
    {
      if ((this.webSearchInfo != null) && (!Util.isNullOrNil(this.webSearchInfo.WoZ)))
      {
        i = 1;
        if ((i == 0) && (this.Rey != 1)) {
          break label313;
        }
      }
    }
    else
    {
      this.doN.findViewById(b.f.state).setVisibility(0);
      localObject = ad.bCb().M(this.mSessionId, true);
      if ((localObject == null) || (1 != ((ad.b)localObject).getInt("_DATA_CENTER_IS_PAY_SUBSCRIBE", -1))) {
        break label331;
      }
      localObject = MMApplicationContext.getContext().getString(b.j.mp_pay_content);
      this.ycd.setText((CharSequence)localObject);
      this.ycd.setVisibility(0);
      label216:
      if (Util.isNullOrNil(this.title)) {
        break label354;
      }
      this.titleTv.setText(this.title);
      if (this.ycd.getVisibility() != 0) {
        break label343;
      }
      this.titleTv.setMaxLines(1);
      label255:
      if (Util.isNullOrNil(this.ADt)) {
        break label1374;
      }
      this.Rcz.setVisibility(0);
      this.Rcz.setUrl(this.ADt);
    }
    label1834:
    label2100:
    for (;;)
    {
      t.c(this.Rcz, this.lzt);
      localObject = this.doN;
      AppMethodBeat.o(97927);
      return localObject;
      i = 0;
      break;
      label313:
      this.doN.findViewById(b.f.state).setVisibility(8);
      break label162;
      label331:
      this.ycd.setVisibility(8);
      break label216;
      label343:
      this.titleTv.setMaxLines(2);
      break label255;
      label354:
      if ((this.DnR == 17) && (this.RcQ != null))
      {
        if ((Util.isNullOrNil(t.e(this.RcQ.oUc))) && (!Util.isNullOrNil(this.RcQ.oUc.desc)))
        {
          this.titleTv.setText(p.b(this.lzt, this.RcQ.oUc.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.RcQ.oUc.desc))
        {
          this.titleTv.setText(p.b(this.lzt, t.e(this.RcQ.oUc) + ": " + this.RcQ.oUc.desc));
          break label255;
        }
        this.titleTv.setText(p.b(this.lzt, this.lzt.getString(b.j.sns_share_finder_feed_title, new Object[] { t.e(this.RcQ.oUc) })));
        break label255;
      }
      if ((this.DnR == 23) && (this.ReI != null))
      {
        if ((Util.isNullOrNil(this.ReI.oUe.nickname)) && (!Util.isNullOrNil(this.ReI.oUe.desc)))
        {
          this.titleTv.setText(p.b(this.lzt, this.ReI.oUe.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.ReI.oUe.desc))
        {
          this.titleTv.setText(p.b(this.lzt, this.ReI.oUe.nickname + ": " + this.ReI.oUe.desc));
          break label255;
        }
        this.titleTv.setText(p.b(this.lzt, this.lzt.getString(b.j.sns_share_finder_feed_title, new Object[] { this.ReI.oUe.nickname })));
        break label255;
      }
      if (((this.DnR == 18) || (this.DnR == 22)) && (this.ReE != null))
      {
        localObject = this.lzt.getString(b.j.app_finder_topic);
        if (this.ReE.oTZ != null) {
          if (this.ReE.oTZ.Auy != 1) {
            break label872;
          }
        }
        label872:
        for (localObject = MMApplicationContext.getContext().getString(b.j.sns_share_finder_topic_card_prefix, new Object[] { this.ReE.oTZ.topic });; localObject = this.ReE.oTZ.topic)
        {
          this.ycd.setVisibility(0);
          this.ycd.setText(this.ReE.oTZ.desc);
          this.titleTv.setText(p.b(this.lzt, (CharSequence)localObject));
          break;
        }
      }
      String str;
      if ((this.DnR == 24) && (this.ReF != null))
      {
        str = this.lzt.getString(b.j.app_finder_topic);
        localObject = str;
        if (this.ReF.oTZ != null)
        {
          localObject = str;
          if (this.ReF.oTZ.aade != null) {
            if (this.ReF.oTZ.Auy != 7) {
              break label1012;
            }
          }
        }
        label1012:
        for (localObject = o.a(this.ReF.oTZ.aade);; localObject = this.ReF.oTZ.topic)
        {
          this.ycd.setVisibility(0);
          this.ycd.setText(this.ReF.oTZ.desc);
          this.titleTv.setText(p.b(this.lzt, (CharSequence)localObject));
          break;
        }
      }
      if ((this.DnR == 20) && (this.ReH != null))
      {
        localObject = this.ReH.oUa.title;
        this.titleTv.setText(p.b(this.lzt, (CharSequence)localObject));
        break label255;
      }
      if (((this.DnR == 21) || (this.DnR == 30)) && (this.ReG != null))
      {
        if ((Util.isNullOrNil(this.ReG.oUb.nickName)) && (!Util.isNullOrNil(this.ReG.oUb.desc)))
        {
          this.titleTv.setText(p.b(this.lzt, this.ReG.oUb.desc));
          break label255;
        }
        if (!Util.isNullOrNil(this.ReG.oUb.desc))
        {
          this.titleTv.setText(p.b(this.lzt, this.ReG.oUb.nickName + ": " + this.ReG.oUb.desc));
          break label255;
        }
        this.titleTv.setText(p.b(this.lzt, this.lzt.getString(b.j.sns_share_finder_live_title, new Object[] { this.ReG.oUb.nickName })));
        break label255;
      }
      if ((this.DnR == 29) && (this.ReJ != null))
      {
        localObject = "";
        if (this.ReJ.oUd != null)
        {
          localObject = this.ReJ.oUd.poiName;
          this.ycd.setVisibility(0);
          this.ycd.setText(this.ReJ.oUd.AXm);
        }
        this.titleTv.setText(p.b(this.lzt, (CharSequence)localObject));
        break label255;
      }
      this.titleTv.setText(bn.baM(this.link));
      break label255;
      label1374:
      if (!Util.isNullOrNil(this.Rcw))
      {
        this.Rcz.setVisibility(0);
        this.orY = BitmapUtil.decodeByteArray(this.Rcw);
        this.Rcz.setImageBitmap(this.orY);
        this.Rec = true;
      }
      else if (!Util.isNullOrNil(this.ReD))
      {
        this.Rcz.setImageResource(b.i.note_sns_link_default);
        this.Rcz.setVisibility(0);
      }
      else if (this.DnR == 17)
      {
        if ((this.RcQ != null) && (!this.RcQ.oUc.mediaList.isEmpty()) && (!Util.isNullOrNil(((bvj)this.RcQ.oUc.mediaList.get(0)).thumbUrl))) {
          this.Rcz.setUrl(((bvj)this.RcQ.oUc.mediaList.get(0)).thumbUrl);
        }
        this.Rcz.setVisibility(0);
      }
      else
      {
        if (this.DnR == 23)
        {
          if ((this.ReI != null) && (!this.ReI.oUe.mediaList.isEmpty()))
          {
            if (Util.isNullOrNil(((dob)this.ReI.oUe.mediaList.get(0)).coverUrl)) {
              break label1645;
            }
            this.Rcz.setUrl(((dob)this.ReI.oUe.mediaList.get(0)).coverUrl);
          }
          for (;;)
          {
            this.Rcz.setVisibility(0);
            break;
            label1645:
            if (!Util.isNullOrNil(((dob)this.ReI.oUe.mediaList.get(0)).thumbUrl)) {
              this.Rcz.setUrl(((dob)this.ReI.oUe.mediaList.get(0)).thumbUrl);
            }
          }
        }
        if ((this.DnR == 18) || (this.DnR == 22))
        {
          if ((this.ReE != null) && (this.ReE.oTZ != null)) {
            this.Rcz.setUrl(this.ReE.oTZ.iconUrl);
          }
          this.Rcz.setVisibility(0);
        }
        else
        {
          if (this.DnR == 24)
          {
            if ((this.ReF != null) && (this.ReF.oTZ != null))
            {
              if (Util.isNullOrNil(this.ReF.oTZ.iconUrl)) {
                break label1834;
              }
              this.Rcz.setUrl(this.ReF.oTZ.iconUrl);
            }
            for (;;)
            {
              this.Rcz.setVisibility(0);
              break;
              this.Rcz.setImageDrawable(com.tencent.mm.cd.a.m(this.Rcz.getContext(), b.i.icon_filled_activity));
            }
          }
          if (this.DnR == 20)
          {
            if (this.ReH != null)
            {
              localObject = (String)this.ReH.oUa.aacP.get(0);
              str = (String)this.ReH.oUa.aacQ.get(0);
              this.Rcz.setUrl((String)localObject + str);
            }
            this.Rcz.setVisibility(0);
          }
          else if ((this.DnR == 21) || (this.DnR == 30))
          {
            if ((this.ReG != null) && (!this.ReG.oUb.coverUrl.isEmpty()) && (!Util.isNullOrNil(this.ReG.oUb.coverUrl))) {
              this.Rcz.setUrl(this.ReG.oUb.coverUrl);
            }
            this.Rcz.setVisibility(0);
          }
          else
          {
            if (this.DnR == 29)
            {
              if ((this.ReJ != null) && (this.ReJ.oUd != null))
              {
                if (Util.isNullOrNil(this.ReJ.oUd.XOv)) {
                  break label2100;
                }
                this.Rcz.setUrl(this.ReJ.oUd.XOv);
              }
              for (;;)
              {
                this.Rcz.setVisibility(0);
                break;
                this.Rcz.setImageDrawable(com.tencent.mm.cd.a.m(this.Rcz.getContext(), b.i.icons_outlined_location));
              }
            }
            this.Rcz.setImageResource(b.i.app_attach_file_icon_webpage);
            this.Rcz.setVisibility(0);
          }
        }
      }
    }
  }
  
  public final boolean hlR()
  {
    return true;
  }
  
  public final boolean hlS()
  {
    return true;
  }
  
  public final boolean hlT()
  {
    AppMethodBeat.i(97929);
    if ((this.orY != null) && (!this.orY.isRecycled()) && (this.Rec)) {
      this.orY.recycle();
    }
    AppMethodBeat.o(97929);
    return false;
  }
  
  public final boolean n(int paramInt, Intent paramIntent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ah
 * JD-Core Version:    0.7.0.1
 */