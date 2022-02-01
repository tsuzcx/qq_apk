package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.ah.w;
import com.tencent.mm.ah.w.a;
import com.tencent.mm.model.x;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.ad.e.f;
import com.tencent.mm.plugin.sns.ad.e.k;
import com.tencent.mm.plugin.sns.ad.e.n.a;
import com.tencent.mm.plugin.sns.ad.e.n.c;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.model.c;
import com.tencent.mm.plugin.sns.model.c.a;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class VideoAdPlayerUI
  extends MMActivity
  implements c.a, c.b
{
  private VideoPlayView AHY;
  private com.tencent.mm.modelsns.e AHZ;
  private int AIa;
  private bzh AIb;
  private String AIc;
  private int AId;
  private String[] AIe;
  private String[] AIf;
  private String AqK;
  private boolean AqL;
  private boolean AqM;
  private String AqN;
  private k AqO;
  public String AqP;
  public String AqQ;
  private int AqR;
  private int AqS;
  private String AqT;
  private String AqU;
  private String AqV;
  private long AqW;
  private int AqX;
  private int AqY;
  private String aQj;
  private String bssid;
  private String dIA;
  private String hEW;
  private String hEX;
  private String hgD;
  private boolean isAd;
  private boolean lVw;
  private String mediaId;
  private com.tencent.mm.model.d ozB;
  private String ssid;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String zRg;
  private p znm;
  
  public VideoAdPlayerUI()
  {
    AppMethodBeat.i(99792);
    this.AHZ = null;
    this.AqO = new k("VideoAdPlayerUI");
    this.hgD = "";
    this.thumbPath = "";
    this.AqK = "";
    this.url = "";
    this.thumbUrl = "";
    this.mediaId = "";
    this.isAd = false;
    this.AIa = 0;
    this.AqN = "";
    this.hEW = "";
    this.hEX = "";
    this.AqP = "";
    this.AqQ = "";
    this.AqR = 0;
    this.AqS = 0;
    this.AqT = "";
    this.AqV = "";
    this.AqW = 0L;
    this.AqX = 0;
    this.AqY = 0;
    this.zRg = "";
    this.aQj = "";
    this.AqM = false;
    this.AqL = false;
    this.AIb = null;
    this.lVw = false;
    this.AIe = null;
    this.AIf = null;
    AppMethodBeat.o(99792);
  }
  
  private void RU(int paramInt)
  {
    AppMethodBeat.i(99802);
    if (!this.isAd)
    {
      AppMethodBeat.o(99802);
      return;
    }
    this.AqO.Qf(this.AHY.getDuration());
    this.AqO.zpN.zqT = bu.HQ();
    com.tencent.mm.plugin.sns.ad.e.a.a locala = this.AqO.zpN;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      locala.zqS = paramInt;
      this.AqO.zpN.zqR = 2;
      ae.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.AqO.zpN.zqS);
      AppMethodBeat.o(99802);
      return;
    }
  }
  
  public final void azJ(String paramString) {}
  
  public final void bQ(String paramString, boolean paramBoolean) {}
  
  public final void bR(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99800);
    ae.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    this.AHY.setIsDownloading(false);
    this.AHY.setVideoPath(this.hgD);
    this.AHY.p(this.AHY.getLastProgresstime());
    this.AHY.setLoop(false);
    if ((this.isAd) && (!bu.isNullOrNil(paramString)) && (this.AIb != null) && (paramString.equals(this.AIb.Id)) && (o.fB(this.hgD))) {
      this.AqO.zpF = 1;
    }
    AppMethodBeat.o(99800);
  }
  
  public final void dWB() {}
  
  public void finish()
  {
    AppMethodBeat.i(99796);
    if (this.lVw) {
      this.AHY.pause();
    }
    if ((this.AqO != null) && (this.zRg != null) && (this.zRg.length() > 0))
    {
      this.AqO.dUY();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.zRg);
      localIntent.putExtra("KStreamVideoPlayCount", this.AqO.zpJ);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.AqO.zpK);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.AqO.zpL);
      setResult(-1, localIntent);
    }
    super.finish();
    AppMethodBeat.o(99796);
  }
  
  public int getForceOrientation()
  {
    if (this.AqL) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131495835;
  }
  
  public final void jr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(99799);
    ae.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.AHY.isPlaying());
    if (this.AHY.isPlaying())
    {
      AppMethodBeat.o(99799);
      return;
    }
    this.AHY.setLoop(false);
    if (paramString2.equals(this.AHY.getVideoPath()))
    {
      this.AHY.p(this.AHY.getLastProgresstime());
      this.AHY.start();
      ae.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      AppMethodBeat.o(99799);
      return;
    }
    this.AHY.setVideoPath(paramString2);
    this.AHY.p(this.AHY.getLastProgresstime());
    ae.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + paramString1 + " path: " + paramString2);
    AppMethodBeat.o(99799);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99794);
    ae.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[] { Integer.valueOf(paramInt1) });
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bu.U(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          ae.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[] { str2 });
          Object localObject2 = new k.b();
          ((k.b)localObject2).title = this.AqN;
          ((k.b)localObject2).type = 4;
          label161:
          label183:
          int j;
          label296:
          label596:
          String str3;
          int k;
          String str4;
          String str5;
          String str6;
          long l;
          int m;
          int n;
          if (!bu.isNullOrNil(this.AIb.Url))
          {
            ((k.b)localObject2).url = this.AIb.Url;
            if (!bu.isNullOrNil(this.AIb.Hmt)) {
              break label713;
            }
            localObject1 = this.AIb.Hmj;
            ((k.b)localObject2).thumburl = ((String)localObject1);
            ((k.b)localObject2).hET = this.AIb.Hmq;
            ((k.b)localObject2).hEU = this.AIb.AIa;
            ((k.b)localObject2).hEV = this.AqN;
            ((k.b)localObject2).hEX = this.hEX;
            ((k.b)localObject2).hEW = this.hEW;
            ((k.b)localObject2).hEY = this.thumbUrl;
            ((k.b)localObject2).hEZ = this.AqP;
            ((k.b)localObject2).hFa = this.AqQ;
            ((k.b)localObject2).dIA = this.dIA;
            localObject1 = o.bb(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label725;
            }
            i = 0;
            ae.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.azs() != null) {
              w.a.azs().a((k.b)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.AId != 0)
            {
              j = this.AqO.zpN.zqP;
              i = j;
              if (this.lVw)
              {
                i = j;
                if (this.AqO.zpN.zqT != 0L) {
                  i = j + (int)(bu.aO(this.AqO.zpN.zqT) / 1000L);
                }
              }
              localObject1 = new i(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + bu.aRi() + "," + this.AIc + "," + this.AIa, (int)bu.aRi());
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.g.doC().hW(str1, str2);
            if (this.isAd) {
              com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, this.znm.field_snsId, 12, 0));
            }
            if (this.AqS == 0) {
              continue;
            }
            boolean bool = x.wb(str2);
            if (!bool) {
              break label733;
            }
            localObject1 = n.c.zqA;
            localObject2 = this.AqQ;
            str3 = this.AqP;
            j = this.AqR;
            k = this.AqS;
            str4 = this.AqT;
            str5 = this.AqU;
            str6 = this.AqV;
            l = this.AqW;
            m = this.AqX;
            n = this.AqY;
            if (!bool) {
              break label741;
            }
          }
          label713:
          label725:
          label733:
          label741:
          for (int i = com.tencent.mm.model.r.zC(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.e.n.a((n.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject2).url = this.AIb.Hmq;
            break label161;
            localObject1 = this.AIb.Hmt;
            break label183;
            i = localObject1.length;
            break label296;
            localObject1 = n.c.zqz;
            break label596;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.AqS != 0) {
        com.tencent.mm.plugin.sns.ad.e.n.a(n.c.zqB, this.AqQ, this.AqP, this.AqR, this.AqS, this.AqT, this.AqU, this.AqV, this.AqW, this.AqX, this.AqY, 0);
      }
      if (-1 != paramInt2) {
        break label901;
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, this.znm.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(99794);
      return;
      if (!this.isAd) {
        break;
      }
      com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, this.znm.field_snsId, 13, 0));
      break;
      label901:
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, this.znm.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99801);
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.AHY;
    ae.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.zjr);
    if (localVideoPlayView.zjr != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label119;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.zjr = paramConfiguration.orientation;
      if (localVideoPlayView.zjr == 2) {
        localVideoPlayView.hcH.setVisibility(8);
      }
      RU(paramConfiguration.orientation);
      AppMethodBeat.o(99801);
      return;
      label119:
      localVideoPlayView.update(2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99793);
    super.onCreate(paramBundle);
    hideTitleView();
    if (al.aH(getContext())) {
      getController().setActionbarColor(getResources().getColor(2131099873));
    }
    this.AIe = new String[] { getString(2131763770), getString(2131763771), getString(2131763769) };
    this.AIf = new String[] { getString(2131763770), getString(2131763771) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.znm = ah.dXE().aBq(com.tencent.mm.plugin.sns.data.r.azz(paramBundle));
    this.ozB = new com.tencent.mm.model.d();
    this.AHZ = com.tencent.mm.modelsns.e.w(getIntent());
    this.hgD = getIntent().getStringExtra("KFullVideoPath");
    this.AqK = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.isAd = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.AqN = bu.bI(getIntent().getStringExtra("KMediaTitle"), "");
    this.AIa = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.AqM = getIntent().getBooleanExtra("KBlockFav", false);
    this.AqL = getIntent().getBooleanExtra("ForceLandscape", false);
    this.hEW = getIntent().getStringExtra("StreamWording");
    this.hEX = getIntent().getStringExtra("StremWebUrl");
    this.zRg = getIntent().getStringExtra("KComponentCid");
    this.AqP = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.AqQ = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.AqR = getIntent().getIntExtra("KSta_SourceType", 0);
    this.AqS = getIntent().getIntExtra("KSta_Scene", 0);
    this.AqT = getIntent().getStringExtra("KSta_FromUserName");
    this.AqU = getIntent().getStringExtra("KSta_ChatName");
    this.AqV = getIntent().getStringExtra("KSta_SnSId");
    this.AqW = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.AqX = getIntent().getIntExtra("KSta_FavID", 0);
    this.AqY = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.dIA = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.aQj = bu.bI(getIntent().getStringExtra("KViewId"), "");
    this.AIc = bu.bI(getIntent().getStringExtra("ReportArgs"), "");
    this.AId = getIntent().getIntExtra("NeedReportData", 0);
    if (this.AId != 0)
    {
      this.ssid = az.ja(ak.getContext());
      this.bssid = az.jb(ak.getContext());
    }
    this.AIb = new bzh();
    this.AIb.Hmj = this.thumbUrl;
    this.AIb.Hmq = this.AqK;
    this.AIb.Id = this.mediaId;
    this.AIb.Url = this.url;
    this.AIb.GXH = 1;
    this.AIb.AIa = this.AIa;
    this.AqO.zpH = bu.HQ();
    ae.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.AIb.Id + " attachurl:" + this.AIb.Hmq + " videoattachTotalTime:" + this.AIb.AIa + " streamvideowording: " + this.hEW + " streamvideoweburl: " + this.hEX + " mediaTitle: " + this.AqN + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.AqP + " streamvideopublishid " + this.AqQ);
    Object localObject1;
    if (bu.isNullOrNil(this.hgD))
    {
      paramBundle = ap.jv(ah.getAccSnsPath(), this.AIb.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.r.j(this.AIb);
      this.hgD = (paramBundle + (String)localObject1);
    }
    if ((bu.isNullOrNil(this.thumbPath)) || (!o.fB(this.thumbPath)))
    {
      paramBundle = "attach" + this.AIb.Id;
      localObject1 = ap.jv(ah.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + com.tencent.mm.plugin.sns.data.r.azi(paramBundle));
    }
    if (!o.fB(this.thumbPath)) {}
    try
    {
      paramBundle = new bzh();
      paramBundle.parseFrom(this.AIb.toByteArray());
      paramBundle.Id = ("attach" + paramBundle.Id);
      localObject1 = new com.tencent.mm.plugin.sns.data.n(this.AIb);
      ((com.tencent.mm.plugin.sns.data.n)localObject1).zui = 1;
      ((com.tencent.mm.plugin.sns.data.n)localObject1).dyb = this.AIb.Id;
      ah.dXz().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.n)localObject1, bk.JgC);
      getWindow().addFlags(128);
      this.AHY = ((VideoPlayView)findViewById(2131306370));
      paramBundle = this.AHY;
      localObject1 = new AdVideoPlayerLoadingBar(getContext());
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(2131165506);
      paramBundle.zjd = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.oNV.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.zjd, (ViewGroup.LayoutParams)localObject2);
      paramBundle.zjd.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.zjd.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.zjd.setIsPlay(paramBundle.oNV.isPlaying());
      if (paramBundle.zjd != null) {
        ((View)paramBundle.zjd).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.AHY.setVideoPlayViewEvent(new VideoPlayView.a()
      {
        public final void Qd(int paramAnonymousInt)
        {
          AppMethodBeat.i(99786);
          if (VideoAdPlayerUI.i(VideoAdPlayerUI.this) == 0)
          {
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, paramAnonymousInt);
            VideoAdPlayerUI.j(VideoAdPlayerUI.this).AIa = paramAnonymousInt;
          }
          AppMethodBeat.o(99786);
        }
        
        public final void dTQ()
        {
          AppMethodBeat.i(99783);
          VideoAdPlayerUI.d(VideoAdPlayerUI.this).ez(false);
          com.tencent.mm.plugin.sns.ad.e.a.a locala = VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN;
          locala.zqP += (int)bu.aO(VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN.zqT);
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          AppMethodBeat.o(99783);
        }
        
        public final void dTR()
        {
          AppMethodBeat.i(99784);
          ae.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
          Object localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN;
          ((com.tencent.mm.plugin.sns.ad.e.a.a)localObject).zqO += 1;
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
          {
            localObject = new i(13227, "1,2," + VideoAdPlayerUI.i(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bu.aRi() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bu.aRi());
            com.tencent.mm.kernel.g.ajS();
            com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject, 0);
          }
          AppMethodBeat.o(99784);
        }
        
        public final void dTS()
        {
          AppMethodBeat.i(99785);
          ae.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          VideoAdPlayerUI.c(VideoAdPlayerUI.this).dTN();
          AppMethodBeat.o(99785);
        }
        
        public final void rk(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99782);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN;
            if (VideoAdPlayerUI.this.getResources().getConfiguration().orientation != 2) {
              break label301;
            }
          }
          label301:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.sns.ad.e.a.a)localObject).zqS = i;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN.zqT = bu.HQ();
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN.zqR = 2;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN.zqP = 0;
            if ((!VideoAdPlayerUI.b(VideoAdPlayerUI.this)) && ((int)VideoAdPlayerUI.c(VideoAdPlayerUI.this).getLastProgresstime() == 0))
            {
              localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN;
              ((com.tencent.mm.plugin.sns.ad.e.a.a)localObject).zqN += 1;
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN.zqT = bu.HQ();
            VideoAdPlayerUI.d(VideoAdPlayerUI.this).a(VideoAdPlayerUI.c(VideoAdPlayerUI.this));
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              localObject = new i(13227, "1,1,0," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bu.aRi() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bu.aRi());
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject, 0);
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, true);
            AppMethodBeat.o(99782);
            return;
          }
        }
      });
      this.AHY.setVideoTotalTime(this.AIb.AIa);
      if (o.fB(this.hgD))
      {
        this.AqO.zpF = 1;
        this.AHY.setVideoPath(this.hgD);
        this.AHY.setLeftButtonOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99787);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            VideoAdPlayerUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99787);
          }
        });
        this.AHY.setRightButtonOnCliclListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99789);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            localObject = VideoAdPlayerUI.this;
            if (VideoAdPlayerUI.k(VideoAdPlayerUI.this)) {}
            for (paramAnonymousView = VideoAdPlayerUI.l(VideoAdPlayerUI.this);; paramAnonymousView = VideoAdPlayerUI.m(VideoAdPlayerUI.this))
            {
              com.tencent.mm.ui.base.h.a((Context)localObject, null, paramAnonymousView, null, new h.c()
              {
                public final void lh(int paramAnonymous2Int)
                {
                  AppMethodBeat.i(99788);
                  switch (paramAnonymous2Int)
                  {
                  }
                  for (;;)
                  {
                    AppMethodBeat.o(99788);
                    return;
                    Intent localIntent = new Intent();
                    localIntent.putExtra("Select_Conv_Type", 3);
                    localIntent.putExtra("select_is_ret", true);
                    localIntent.putExtra("mutil_select_is_ret", true);
                    localIntent.putExtra("ad_video_title", VideoAdPlayerUI.n(VideoAdPlayerUI.this));
                    localIntent.putExtra("Retr_Msg_Type", 2);
                    com.tencent.mm.br.d.c(VideoAdPlayerUI.this, ".ui.transmit.SelectConversationUI", localIntent, 4097);
                    AppMethodBeat.o(99788);
                    return;
                    VideoAdPlayerUI.o(VideoAdPlayerUI.this);
                    AppMethodBeat.o(99788);
                    return;
                    VideoAdPlayerUI.p(VideoAdPlayerUI.this);
                  }
                }
              });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99789);
              return;
            }
          }
        });
        paramBundle = this.AHY;
        localObject1 = this.hEW;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99791);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
            if (VideoAdPlayerUI.q(VideoAdPlayerUI.this) != 0) {
              com.tencent.mm.plugin.sns.ad.e.n.a(n.a.zqm, VideoAdPlayerUI.this.AqQ, VideoAdPlayerUI.this.AqP, VideoAdPlayerUI.r(VideoAdPlayerUI.this), VideoAdPlayerUI.q(VideoAdPlayerUI.this), VideoAdPlayerUI.s(VideoAdPlayerUI.this), VideoAdPlayerUI.t(VideoAdPlayerUI.this), VideoAdPlayerUI.u(VideoAdPlayerUI.this), VideoAdPlayerUI.v(VideoAdPlayerUI.this), VideoAdPlayerUI.w(VideoAdPlayerUI.this), VideoAdPlayerUI.x(VideoAdPlayerUI.this));
            }
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              int j = VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN.zqP;
              int i = j;
              if (VideoAdPlayerUI.b(VideoAdPlayerUI.this))
              {
                i = j;
                if (VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN.zqT != 0L) {
                  i = j + (int)(bu.aO(VideoAdPlayerUI.a(VideoAdPlayerUI.this).zpN.zqT) / 1000L);
                }
              }
              paramAnonymousView = new i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bu.aRi() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bu.aRi());
              com.tencent.mm.kernel.g.ajS();
              com.tencent.mm.kernel.g.ajQ().gDv.a(paramAnonymousView, 0);
            }
            VideoAdPlayerUI.this.finish();
            final Intent localIntent = new Intent();
            Bundle localBundle = new Bundle();
            localBundle.putString("key_snsad_statextstr", VideoAdPlayerUI.y(VideoAdPlayerUI.this));
            localObject = VideoAdPlayerUI.z(VideoAdPlayerUI.this);
            paramAnonymousView = (View)localObject;
            if (VideoAdPlayerUI.A(VideoAdPlayerUI.this))
            {
              paramAnonymousView = (View)localObject;
              if (!TextUtils.isEmpty(VideoAdPlayerUI.this.AqP)) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.r.jo((String)localObject, VideoAdPlayerUI.this.AqP);
              }
            }
            localIntent.putExtra("jsapiargs", localBundle);
            localIntent.putExtra("rawUrl", paramAnonymousView);
            localIntent.putExtra("useJs", true);
            if (VideoAdPlayerUI.A(VideoAdPlayerUI.this)) {
              com.tencent.mm.plugin.sns.data.r.a(new SnsAdClick(0, 6, VideoAdPlayerUI.B(VideoAdPlayerUI.this).field_snsId, 18, 0));
            }
            new aq(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99790);
                com.tencent.mm.plugin.sns.c.a.iUz.i(localIntent, VideoAdPlayerUI.this);
                AppMethodBeat.o(99790);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99791);
          }
        };
        paramBundle.zjg = ((String)localObject1);
        paramBundle.zjf.setText((CharSequence)localObject1);
        paramBundle.zjf.setOnClickListener((View.OnClickListener)localObject2);
        this.AHY.dTP();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.AHY;
          if (paramBundle.zjh != null)
          {
            paramBundle.zji = false;
            paramBundle.zjh.setVisibility(8);
          }
        }
        AppMethodBeat.o(99793);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ae.e("MicroMsg.VideoPlayerUI", "error for download thumb");
        continue;
        this.AHY.dTN();
        this.AHY.setIsDownloading(true);
        ah.dXz().a(this.AIb, 6, null, bk.JgC);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99795);
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.AqS != 0) {
      com.tencent.mm.plugin.sns.ad.e.n.a(n.a.zqo, this.AqQ, this.AqP, this.AqR, this.AqS, this.AqT, this.AqU, this.AqV, this.AqW, this.AqX, this.AqY);
    }
    int i;
    String str;
    int j;
    if (this.isAd)
    {
      if (this.znm != null) {
        break label468;
      }
      i = 0;
      if (this.znm != null)
      {
        str = this.AqO.dUX();
        long l2 = this.AqO.zpG - this.AqO.ipS;
        long l1 = l2;
        if (l2 < 0L)
        {
          ae.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.AqO.zpG), Long.valueOf(this.AqO.ipS) });
          l1 = this.AqO.zpG;
        }
        j = (int)l1;
        localObject = this.znm.dVi();
        if (localObject != null) {
          break label479;
        }
      }
    }
    label468:
    label479:
    for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).zMw)
    {
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(new f(this.aQj, 6, this.AqO.zpG, str, i, j, j, this.znm.ecy().ebR(), this.znm.ecy().ebS(), (String)localObject), 0);
      if (this.AId != 0)
      {
        j = this.AqO.zpN.zqP;
        i = j;
        if (this.lVw)
        {
          i = j;
          if (this.AqO.zpN.zqT != 0L) {
            i = j + (int)(bu.aO(this.AqO.zpN.zqT) / 1000L);
          }
        }
        localObject = new i(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + bu.aRi() + "," + this.AIc + "," + this.AIa, (int)bu.aRi());
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a((com.tencent.mm.ak.n)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
      AppMethodBeat.o(99795);
      return;
      i = this.znm.ecz();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99797);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ae.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
    RU(i);
    if ((this.AHY != null) && (this.AHY.isPlaying())) {
      this.AHY.pause();
    }
    if (this.AHY != null)
    {
      ae.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.AHY.onDetach();
    }
    ah.dXz().zwB.remove(this);
    ah.dXz().b(this);
    if (this.AqO != null) {
      this.AqO.ipR = bu.HQ();
    }
    AppMethodBeat.o(99797);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99798);
    super.onResume();
    ah.dXz().zwB.add(this);
    ah.dXz().a(this);
    if (this.AqO != null) {
      this.AqO.onResume();
    }
    AppMethodBeat.o(99798);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI
 * JD-Core Version:    0.7.0.1
 */