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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.aj.w.a;
import com.tencent.mm.an.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.aq.a.c;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.ad.f.p.a;
import com.tencent.mm.plugin.sns.ad.f.p.c;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.c.a;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class VideoAdPlayerUI
  extends MMActivity
  implements c.a, c.b
{
  private SnsInfo Jzk;
  private String KNA;
  private com.tencent.mm.plugin.sns.ad.f.m KNB;
  public String KNC;
  public String KND;
  private int KNE;
  private int KNF;
  private String KNG;
  private String KNH;
  private String KNI;
  private long KNJ;
  private int KNK;
  private int KNL;
  private boolean KNy;
  private boolean KNz;
  private String KmB;
  private VideoPlayView Lga;
  private l Lgb;
  private int Lgc;
  private cvt Lgd;
  private String Lge;
  private int Lgf;
  private String[] Lgg;
  private String[] Lgh;
  private String bssid;
  private boolean fGh;
  private String fUk;
  private String fullPath;
  private boolean isAd;
  private String kih;
  private String lou;
  private String lov;
  private String mediaId;
  private com.tencent.mm.model.d sUi;
  private String ssid;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String viewId;
  
  public VideoAdPlayerUI()
  {
    AppMethodBeat.i(99792);
    this.Lgb = null;
    this.KNB = new com.tencent.mm.plugin.sns.ad.f.m("VideoAdPlayerUI");
    this.fullPath = "";
    this.thumbPath = "";
    this.kih = "";
    this.url = "";
    this.thumbUrl = "";
    this.mediaId = "";
    this.isAd = false;
    this.Lgc = 0;
    this.KNA = "";
    this.lou = "";
    this.lov = "";
    this.KNC = "";
    this.KND = "";
    this.KNE = 0;
    this.KNF = 0;
    this.KNG = "";
    this.KNI = "";
    this.KNJ = 0L;
    this.KNK = 0;
    this.KNL = 0;
    this.KmB = "";
    this.viewId = "";
    this.KNz = false;
    this.KNy = false;
    this.Lgd = null;
    this.fGh = false;
    this.Lgg = null;
    this.Lgh = null;
    AppMethodBeat.o(99792);
  }
  
  private void ahn(int paramInt)
  {
    AppMethodBeat.i(99802);
    if (!this.isAd)
    {
      AppMethodBeat.o(99802);
      return;
    }
    this.KNB.aeO(this.Lga.getDuration());
    this.KNB.JFu.JGJ = Util.currentTicks();
    com.tencent.mm.plugin.sns.ad.f.a.b localb = this.KNB.JFu;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localb.JGI = paramInt;
      this.KNB.JFu.JGH = 2;
      Log.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.KNB.JFu.JGI);
      AppMethodBeat.o(99802);
      return;
    }
  }
  
  public final void aYK(String paramString) {}
  
  public final void cq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99800);
    Log.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    this.Lga.setIsDownloading(false);
    this.Lga.setVideoPath(this.fullPath);
    this.Lga.q(this.Lga.getLastProgresstime());
    this.Lga.setLoop(false);
    if ((this.isAd) && (!Util.isNullOrNil(paramString)) && (this.Lgd != null) && (paramString.equals(this.Lgd.Id)) && (u.agG(this.fullPath))) {
      this.KNB.JFm = 1;
    }
    AppMethodBeat.o(99800);
  }
  
  public final void cr(String paramString, boolean paramBoolean) {}
  
  public final void fLL() {}
  
  public void finish()
  {
    AppMethodBeat.i(99796);
    if (this.fGh) {
      this.Lga.pause();
    }
    if ((this.KNB != null) && (this.KmB != null) && (this.KmB.length() > 0))
    {
      this.KNB.fKT();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.KmB);
      localIntent.putExtra("KStreamVideoPlayCount", this.KNB.JFq);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.KNB.JFr);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.KNB.JFs);
      setResult(-1, localIntent);
    }
    super.finish();
    AppMethodBeat.o(99796);
  }
  
  public int getForceOrientation()
  {
    if (this.KNy) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return i.g.video_player_ui;
  }
  
  public final void kz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(99799);
    Log.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.Lga.isPlaying());
    if (this.Lga.isPlaying())
    {
      AppMethodBeat.o(99799);
      return;
    }
    this.Lga.setLoop(false);
    if (paramString2.equals(this.Lga.getVideoPath()))
    {
      this.Lga.q(this.Lga.getLastProgresstime());
      this.Lga.start();
      Log.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      AppMethodBeat.o(99799);
      return;
    }
    this.Lga.setVideoPath(paramString2);
    this.Lga.q(this.Lga.getLastProgresstime());
    Log.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + paramString1 + " path: " + paramString2);
    AppMethodBeat.o(99799);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99794);
    Log.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[] { Integer.valueOf(paramInt1) });
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = Util.stringsToList(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          Log.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[] { str2 });
          Object localObject2 = new k.b();
          ((k.b)localObject2).title = this.KNA;
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
          if (!Util.isNullOrNil(this.Lgd.Url))
          {
            ((k.b)localObject2).url = this.Lgd.Url;
            if (!Util.isNullOrNil(this.Lgd.TDO)) {
              break label713;
            }
            localObject1 = this.Lgd.TDF;
            ((k.b)localObject2).thumburl = ((String)localObject1);
            ((k.b)localObject2).lor = this.Lgd.TDL;
            ((k.b)localObject2).los = this.Lgd.Lgc;
            ((k.b)localObject2).lot = this.KNA;
            ((k.b)localObject2).lov = this.lov;
            ((k.b)localObject2).lou = this.lou;
            ((k.b)localObject2).low = this.thumbUrl;
            ((k.b)localObject2).lox = this.KNC;
            ((k.b)localObject2).loy = this.KND;
            ((k.b)localObject2).fUk = this.fUk;
            localObject1 = u.aY(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label725;
            }
            i = 0;
            Log.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.bbx() != null) {
              w.a.bbx().a((k.b)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.Lgf != 0)
            {
              j = this.KNB.JFu.JGF;
              i = j;
              if (this.fGh)
              {
                i = j;
                if (this.KNB.JFu.JGJ != 0L) {
                  i = j + (int)(Util.ticksToNow(this.KNB.JFu.JGJ) / 1000L);
                }
              }
              localObject1 = new com.tencent.mm.modelstat.h(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + Util.nowSecond() + "," + this.Lge + "," + this.Lgc, (int)Util.nowSecond());
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.g.eRW().iQ(str1, str2);
            if (this.isAd) {
              com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, this.Jzk.field_snsId, 12, 0));
            }
            if (this.KNF == 0) {
              continue;
            }
            boolean bool = ab.Lj(str2);
            if (!bool) {
              break label733;
            }
            localObject1 = p.c.JGl;
            localObject2 = this.KND;
            str3 = this.KNC;
            j = this.KNE;
            k = this.KNF;
            str4 = this.KNG;
            str5 = this.KNH;
            str6 = this.KNI;
            l = this.KNJ;
            m = this.KNK;
            n = this.KNL;
            if (!bool) {
              break label741;
            }
          }
          label713:
          label725:
          label733:
          label741:
          for (int i = v.Pu(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.f.p.a((p.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject2).url = this.Lgd.TDL;
            break label161;
            localObject1 = this.Lgd.TDO;
            break label183;
            i = localObject1.length;
            break label296;
            localObject1 = p.c.JGk;
            break label596;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(i.j.has_send));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.KNF != 0) {
        com.tencent.mm.plugin.sns.ad.f.p.a(p.c.JGm, this.KND, this.KNC, this.KNE, this.KNF, this.KNG, this.KNH, this.KNI, this.KNJ, this.KNK, this.KNL, 0);
      }
      if (-1 != paramInt2) {
        break label901;
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, this.Jzk.field_snsId, 15, 0));
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
      com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, this.Jzk.field_snsId, 13, 0));
      break;
      label901:
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, this.Jzk.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99801);
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.Lga;
    Log.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.JtN);
    if (localVideoPlayView.JtN != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label119;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.JtN = paramConfiguration.orientation;
      if (localVideoPlayView.JtN == 2) {
        localVideoPlayView.maskView.setVisibility(8);
      }
      ahn(paramConfiguration.orientation);
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
    if (ar.aN(getContext())) {
      getController().setActionbarColor(getResources().getColor(i.c.action_bar_color));
    }
    this.Lgg = new String[] { getString(i.j.sns_ad_video_right_menu_send_friend), getString(i.j.sns_ad_video_right_menu_share_sns), getString(i.j.sns_ad_video_right_menu_fav) };
    this.Lgh = new String[] { getString(i.j.sns_ad_video_right_menu_send_friend), getString(i.j.sns_ad_video_right_menu_share_sns) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.Jzk = aj.fOI().bbk(com.tencent.mm.plugin.sns.data.t.aZs(paramBundle));
    this.sUi = com.tencent.mm.model.d.bcs();
    this.Lgb = l.x(getIntent());
    this.fullPath = getIntent().getStringExtra("KFullVideoPath");
    this.kih = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.isAd = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.KNA = Util.nullAs(getIntent().getStringExtra("KMediaTitle"), "");
    this.Lgc = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.KNz = getIntent().getBooleanExtra("KBlockFav", false);
    this.KNy = getIntent().getBooleanExtra("ForceLandscape", false);
    this.lou = getIntent().getStringExtra("StreamWording");
    this.lov = getIntent().getStringExtra("StremWebUrl");
    this.KmB = getIntent().getStringExtra("KComponentCid");
    this.KNC = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.KND = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.KNE = getIntent().getIntExtra("KSta_SourceType", 0);
    this.KNF = getIntent().getIntExtra("KSta_Scene", 0);
    this.KNG = getIntent().getStringExtra("KSta_FromUserName");
    this.KNH = getIntent().getStringExtra("KSta_ChatName");
    this.KNI = getIntent().getStringExtra("KSta_SnSId");
    this.KNJ = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.KNK = getIntent().getIntExtra("KSta_FavID", 0);
    this.KNL = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.fUk = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.viewId = Util.nullAs(getIntent().getStringExtra("KViewId"), "");
    this.Lge = Util.nullAs(getIntent().getStringExtra("ReportArgs"), "");
    this.Lgf = getIntent().getIntExtra("NeedReportData", 0);
    if (this.Lgf != 0)
    {
      this.ssid = ConnectivityCompat.Companion.getFormattedWiFiSsid();
      this.bssid = ConnectivityCompat.Companion.getFormattedWiFiBssid();
    }
    this.Lgd = new cvt();
    this.Lgd.TDF = this.thumbUrl;
    this.Lgd.TDL = this.kih;
    this.Lgd.Id = this.mediaId;
    this.Lgd.Url = this.url;
    this.Lgd.TlV = 1;
    this.Lgd.Lgc = this.Lgc;
    this.KNB.JFo = Util.currentTicks();
    Log.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.Lgd.Id + " attachurl:" + this.Lgd.TDL + " videoattachTotalTime:" + this.Lgd.Lgc + " streamvideowording: " + this.lou + " streamvideoweburl: " + this.lov + " mediaTitle: " + this.KNA + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.KNC + " streamvideopublishid " + this.KND);
    Object localObject1;
    if (Util.isNullOrNil(this.fullPath))
    {
      paramBundle = aq.kD(aj.getAccSnsPath(), this.Lgd.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.t.j(this.Lgd);
      this.fullPath = (paramBundle + (String)localObject1);
    }
    if ((Util.isNullOrNil(this.thumbPath)) || (!u.agG(this.thumbPath)))
    {
      paramBundle = "attach" + this.Lgd.Id;
      localObject1 = aq.kD(aj.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + com.tencent.mm.plugin.sns.data.t.aZb(paramBundle));
    }
    if (!u.agG(this.thumbPath)) {}
    try
    {
      paramBundle = new cvt();
      paramBundle.parseFrom(this.Lgd.toByteArray());
      paramBundle.Id = ("attach" + paramBundle.Id);
      localObject1 = new com.tencent.mm.plugin.sns.data.p(this.Lgd);
      ((com.tencent.mm.plugin.sns.data.p)localObject1).JRn = 1;
      ((com.tencent.mm.plugin.sns.data.p)localObject1).fIY = this.Lgd.Id;
      aj.fOD().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.p)localObject1, bp.VGp);
      getWindow().addFlags(128);
      this.Lga = ((VideoPlayView)findViewById(i.f.video_play_view));
      paramBundle = this.Lga;
      localObject1 = new AdVideoPlayerLoadingBar(getContext());
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(a.c.NoPadding);
      paramBundle.Jtz = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.txH.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.Jtz, (ViewGroup.LayoutParams)localObject2);
      paramBundle.Jtz.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.Jtz.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.Jtz.setIsPlay(paramBundle.txH.isPlaying());
      if (paramBundle.Jtz != null) {
        ((View)paramBundle.Jtz).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.Lga.setVideoPlayViewEvent(new VideoPlayView.a()
      {
        public final void aeG(int paramAnonymousInt)
        {
          AppMethodBeat.i(99786);
          if (VideoAdPlayerUI.i(VideoAdPlayerUI.this) == 0)
          {
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, paramAnonymousInt);
            VideoAdPlayerUI.j(VideoAdPlayerUI.this).Lgc = paramAnonymousInt;
          }
          AppMethodBeat.o(99786);
        }
        
        public final void fIT()
        {
          AppMethodBeat.i(99783);
          VideoAdPlayerUI.d(VideoAdPlayerUI.this).fZ(false);
          com.tencent.mm.plugin.sns.ad.f.a.b localb = VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu;
          localb.JGF += (int)Util.ticksToNow(VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu.JGJ);
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          AppMethodBeat.o(99783);
        }
        
        public final void fIU()
        {
          AppMethodBeat.i(99784);
          Log.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
          Object localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu;
          ((com.tencent.mm.plugin.sns.ad.f.a.b)localObject).JGE += 1;
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
          {
            localObject = new com.tencent.mm.modelstat.h(13227, "1,2," + VideoAdPlayerUI.i(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
            com.tencent.mm.kernel.h.aHH();
            com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
          }
          AppMethodBeat.o(99784);
        }
        
        public final void fIV()
        {
          AppMethodBeat.i(99785);
          Log.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          VideoAdPlayerUI.c(VideoAdPlayerUI.this).fIQ();
          AppMethodBeat.o(99785);
        }
        
        public final void ye(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99782);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu;
            if (VideoAdPlayerUI.this.getResources().getConfiguration().orientation != 2) {
              break label301;
            }
          }
          label301:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.sns.ad.f.a.b)localObject).JGI = i;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu.JGJ = Util.currentTicks();
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu.JGH = 2;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu.JGF = 0;
            if ((!VideoAdPlayerUI.b(VideoAdPlayerUI.this)) && ((int)VideoAdPlayerUI.c(VideoAdPlayerUI.this).getLastProgresstime() == 0))
            {
              localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu;
              ((com.tencent.mm.plugin.sns.ad.f.a.b)localObject).JGD += 1;
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu.JGJ = Util.currentTicks();
            VideoAdPlayerUI.d(VideoAdPlayerUI.this).a(VideoAdPlayerUI.c(VideoAdPlayerUI.this));
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              localObject = new com.tencent.mm.modelstat.h(13227, "1,1,0," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, true);
            AppMethodBeat.o(99782);
            return;
          }
        }
      });
      this.Lga.setVideoTotalTime(this.Lgd.Lgc);
      if (u.agG(this.fullPath))
      {
        this.KNB.JFm = 1;
        this.Lga.setVideoPath(this.fullPath);
        this.Lga.setLeftButtonOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99787);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            VideoAdPlayerUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99787);
          }
        });
        this.Lga.setRightButtonOnCliclListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99789);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            localObject = VideoAdPlayerUI.this;
            if (VideoAdPlayerUI.k(VideoAdPlayerUI.this)) {}
            for (paramAnonymousView = VideoAdPlayerUI.l(VideoAdPlayerUI.this);; paramAnonymousView = VideoAdPlayerUI.m(VideoAdPlayerUI.this))
            {
              com.tencent.mm.ui.base.h.a((Context)localObject, null, paramAnonymousView, null, new h.d()
              {
                public final void qy(int paramAnonymous2Int)
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
                    com.tencent.mm.by.c.d(VideoAdPlayerUI.this, ".ui.transmit.SelectConversationUI", localIntent, 4097);
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
        paramBundle = this.Lga;
        localObject1 = this.lou;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99791);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
            if (VideoAdPlayerUI.q(VideoAdPlayerUI.this) != 0) {
              com.tencent.mm.plugin.sns.ad.f.p.a(p.a.JFX, VideoAdPlayerUI.this.KND, VideoAdPlayerUI.this.KNC, VideoAdPlayerUI.r(VideoAdPlayerUI.this), VideoAdPlayerUI.q(VideoAdPlayerUI.this), VideoAdPlayerUI.s(VideoAdPlayerUI.this), VideoAdPlayerUI.t(VideoAdPlayerUI.this), VideoAdPlayerUI.u(VideoAdPlayerUI.this), VideoAdPlayerUI.v(VideoAdPlayerUI.this), VideoAdPlayerUI.w(VideoAdPlayerUI.this), VideoAdPlayerUI.x(VideoAdPlayerUI.this));
            }
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              int j = VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu.JGF;
              int i = j;
              if (VideoAdPlayerUI.b(VideoAdPlayerUI.this))
              {
                i = j;
                if (VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu.JGJ != 0L) {
                  i = j + (int)(Util.ticksToNow(VideoAdPlayerUI.a(VideoAdPlayerUI.this).JFu.JGJ) / 1000L);
                }
              }
              paramAnonymousView = new com.tencent.mm.modelstat.h(13228, "1,1," + i + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
              com.tencent.mm.kernel.h.aHH();
              com.tencent.mm.kernel.h.aHF().kcd.a(paramAnonymousView, 0);
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
              if (!TextUtils.isEmpty(VideoAdPlayerUI.this.KNC)) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.t.kw((String)localObject, VideoAdPlayerUI.this.KNC);
              }
            }
            localIntent.putExtra("jsapiargs", localBundle);
            localIntent.putExtra("rawUrl", paramAnonymousView);
            localIntent.putExtra("useJs", true);
            if (VideoAdPlayerUI.A(VideoAdPlayerUI.this)) {
              com.tencent.mm.plugin.sns.data.t.a(new SnsAdClick(0, 6, VideoAdPlayerUI.B(VideoAdPlayerUI.this).field_snsId, 18, 0));
            }
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99790);
                com.tencent.mm.plugin.sns.c.a.mIG.h(localIntent, VideoAdPlayerUI.this);
                AppMethodBeat.o(99790);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99791);
          }
        };
        paramBundle.JtC = ((String)localObject1);
        paramBundle.JtB.setText((CharSequence)localObject1);
        paramBundle.JtB.setOnClickListener((View.OnClickListener)localObject2);
        this.Lga.fIS();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.Lga;
          if (paramBundle.JtD != null)
          {
            paramBundle.JtE = false;
            paramBundle.JtD.setVisibility(8);
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
        Log.e("MicroMsg.VideoPlayerUI", "error for download thumb");
        continue;
        this.Lga.fIQ();
        this.Lga.setIsDownloading(true);
        aj.fOD().a(this.Lgd, 6, null, bp.VGp);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99795);
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.KNF != 0) {
      com.tencent.mm.plugin.sns.ad.f.p.a(p.a.JFZ, this.KND, this.KNC, this.KNE, this.KNF, this.KNG, this.KNH, this.KNI, this.KNJ, this.KNK, this.KNL);
    }
    int i;
    String str;
    int j;
    if (this.isAd)
    {
      if (this.Jzk != null) {
        break label468;
      }
      i = 0;
      if (this.Jzk != null)
      {
        str = this.KNB.fKS();
        long l2 = this.KNB.JFn - this.KNB.mba;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.KNB.JFn), Long.valueOf(this.KNB.mba) });
          l1 = this.KNB.JFn;
        }
        j = (int)l1;
        localObject = this.Jzk.getAdInfo();
        if (localObject != null) {
          break label479;
        }
      }
    }
    label468:
    label479:
    for (Object localObject = "";; localObject = ((ADInfo)localObject).waidPkg)
    {
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(new com.tencent.mm.plugin.sns.ad.f.g(this.viewId, 6, this.KNB.JFn, str, i, j, j, this.Jzk.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), this.Jzk.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), (String)localObject), 0);
      if (this.Lgf != 0)
      {
        j = this.KNB.JFu.JGF;
        i = j;
        if (this.fGh)
        {
          i = j;
          if (this.KNB.JFu.JGJ != 0L) {
            i = j + (int)(Util.ticksToNow(this.KNB.JFu.JGJ) / 1000L);
          }
        }
        localObject = new com.tencent.mm.modelstat.h(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + Util.nowSecond() + "," + this.Lge + "," + this.Lgc, (int)Util.nowSecond());
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a((q)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
      AppMethodBeat.o(99795);
      return;
      i = this.Jzk.getAdRecSrc();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99797);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    Log.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
    ahn(i);
    if ((this.Lga != null) && (this.Lga.isPlaying())) {
      this.Lga.pause();
    }
    if (this.Lga != null)
    {
      Log.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.Lga.onDetach();
    }
    aj.fOD().JTI.remove(this);
    aj.fOD().b(this);
    if (this.KNB != null) {
      this.KNB.maZ = Util.currentTicks();
    }
    AppMethodBeat.o(99797);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99798);
    super.onResume();
    aj.fOD().JTI.add(this);
    aj.fOD().a(this);
    if (this.KNB != null) {
      this.KNB.onResume();
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