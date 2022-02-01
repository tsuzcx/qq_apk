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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.al.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.a.b.f;
import com.tencent.mm.plugin.sns.a.b.m.a;
import com.tencent.mm.plugin.sns.a.b.m.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bc;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.r;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class VideoAdPlayerUI
  extends MMActivity
  implements b.a, b.b
{
  private String bssid;
  private String dAM;
  private String dxG;
  private String gJy;
  private String gJz;
  private String gjt;
  private boolean isAd;
  private boolean kQm;
  private String mediaId;
  private com.tencent.mm.model.d nnt;
  private String ssid;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String wWE;
  private p wwP;
  private VideoPlayView xMh;
  private com.tencent.mm.modelsns.d xMi;
  private int xMj;
  private bpi xMk;
  private String xMl;
  private int xMm;
  private String[] xMn;
  private String[] xMo;
  private int xvA;
  private int xvB;
  private String xvn;
  private boolean xvo;
  private boolean xvp;
  private String xvq;
  private com.tencent.mm.plugin.sns.a.b.j xvr;
  public String xvs;
  public String xvt;
  private int xvu;
  private int xvv;
  private String xvw;
  private String xvx;
  private String xvy;
  private long xvz;
  
  public VideoAdPlayerUI()
  {
    AppMethodBeat.i(99792);
    this.xMi = null;
    this.xvr = new com.tencent.mm.plugin.sns.a.b.j("VideoAdPlayerUI");
    this.gjt = "";
    this.thumbPath = "";
    this.xvn = "";
    this.url = "";
    this.thumbUrl = "";
    this.mediaId = "";
    this.isAd = false;
    this.xMj = 0;
    this.xvq = "";
    this.gJy = "";
    this.gJz = "";
    this.xvs = "";
    this.xvt = "";
    this.xvu = 0;
    this.xvv = 0;
    this.xvw = "";
    this.xvy = "";
    this.xvz = 0L;
    this.xvA = 0;
    this.xvB = 0;
    this.wWE = "";
    this.dAM = "";
    this.xvp = false;
    this.xvo = false;
    this.xMk = null;
    this.kQm = false;
    this.xMn = null;
    this.xMo = null;
    AppMethodBeat.o(99792);
  }
  
  private void NA(int paramInt)
  {
    AppMethodBeat.i(99802);
    if (!this.isAd)
    {
      AppMethodBeat.o(99802);
      return;
    }
    this.xvr.LV(this.xMh.getDuration());
    this.xvr.wyw.wzC = bt.GC();
    com.tencent.mm.plugin.sns.a.b.a.a locala = this.xvr.wyw;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      locala.wzB = paramInt;
      this.xvr.wyw.wzA = 2;
      ad.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.xvr.wyw.wzB);
      AppMethodBeat.o(99802);
      return;
    }
  }
  
  public final void aob(String paramString) {}
  
  public final void by(String paramString, boolean paramBoolean) {}
  
  public final void bz(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99800);
    ad.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    this.xMh.setIsDownloading(false);
    this.xMh.setVideoPath(this.gjt);
    this.xMh.q(this.xMh.getLastProgresstime());
    this.xMh.setLoop(false);
    if ((this.isAd) && (!bt.isNullOrNil(paramString)) && (this.xMk != null) && (paramString.equals(this.xMk.Id)) && (com.tencent.mm.vfs.i.eK(this.gjt))) {
      this.xvr.wyo = 1;
    }
    AppMethodBeat.o(99800);
  }
  
  public final void dsp() {}
  
  public void finish()
  {
    AppMethodBeat.i(99796);
    if (this.kQm) {
      this.xMh.pause();
    }
    if ((this.xvr != null) && (this.wWE != null) && (this.wWE.length() > 0))
    {
      this.xvr.drw();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.wWE);
      localIntent.putExtra("KStreamVideoPlayCount", this.xvr.wys);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.xvr.wyt);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.xvr.wyu);
      setResult(-1, localIntent);
    }
    super.finish();
    AppMethodBeat.o(99796);
  }
  
  public int getForceOrientation()
  {
    if (this.xvo) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131495835;
  }
  
  public final void iB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(99799);
    ad.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.xMh.isPlaying());
    if (this.xMh.isPlaying())
    {
      AppMethodBeat.o(99799);
      return;
    }
    this.xMh.setLoop(false);
    if (paramString2.equals(this.xMh.getVideoPath()))
    {
      this.xMh.q(this.xMh.getLastProgresstime());
      this.xMh.start();
      ad.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      AppMethodBeat.o(99799);
      return;
    }
    this.xMh.setVideoPath(paramString2);
    this.xMh.q(this.xMh.getLastProgresstime());
    ad.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + paramString1 + " path: " + paramString2);
    AppMethodBeat.o(99799);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99794);
    ad.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[] { Integer.valueOf(paramInt1) });
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bt.S(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          ad.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[] { str2 });
          Object localObject2 = new k.b();
          ((k.b)localObject2).title = this.xvq;
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
          if (!bt.isNullOrNil(this.xMk.Url))
          {
            ((k.b)localObject2).url = this.xMk.Url;
            if (!bt.isNullOrNil(this.xMk.DNa)) {
              break label713;
            }
            localObject1 = this.xMk.DMQ;
            ((k.b)localObject2).thumburl = ((String)localObject1);
            ((k.b)localObject2).gJv = this.xMk.DMX;
            ((k.b)localObject2).gJw = this.xMk.xMj;
            ((k.b)localObject2).gJx = this.xvq;
            ((k.b)localObject2).gJz = this.gJz;
            ((k.b)localObject2).gJy = this.gJy;
            ((k.b)localObject2).gJA = this.thumbUrl;
            ((k.b)localObject2).gJB = this.xvs;
            ((k.b)localObject2).gJC = this.xvt;
            ((k.b)localObject2).dxG = this.dxG;
            localObject1 = com.tencent.mm.vfs.i.aR(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label725;
            }
            i = 0;
            ad.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.apB() != null) {
              w.a.apB().a((k.b)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.xMm != 0)
            {
              j = this.xvr.wyw.wzy;
              i = j;
              if (this.kQm)
              {
                i = j;
                if (this.xvr.wyw.wzC != 0L) {
                  i = j + (int)(bt.aS(this.xvr.wyw.wzC) / 1000L);
                }
              }
              localObject1 = new com.tencent.mm.modelstat.i(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + bt.aGK() + "," + this.xMl + "," + this.xMj, (int)bt.aGK());
              g.afC();
              g.afA().gcy.a((n)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.j.cOB().hm(str1, str2);
            if (this.isAd) {
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.wwP.field_snsId, 12, 0));
            }
            if (this.xvv == 0) {
              continue;
            }
            boolean bool = com.tencent.mm.model.w.pF(str2);
            if (!bool) {
              break label733;
            }
            localObject1 = m.c.wzj;
            localObject2 = this.xvt;
            str3 = this.xvs;
            j = this.xvu;
            k = this.xvv;
            str4 = this.xvw;
            str5 = this.xvx;
            str6 = this.xvy;
            l = this.xvz;
            m = this.xvA;
            n = this.xvB;
            if (!bool) {
              break label741;
            }
          }
          label713:
          label725:
          label733:
          label741:
          for (int i = com.tencent.mm.model.q.rY(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.a.b.m.a((m.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject2).url = this.xMk.DMX;
            break label161;
            localObject1 = this.xMk.DNa;
            break label183;
            i = localObject1.length;
            break label296;
            localObject1 = m.c.wzi;
            break label596;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.xvv != 0) {
        com.tencent.mm.plugin.sns.a.b.m.a(m.c.wzk, this.xvt, this.xvs, this.xvu, this.xvv, this.xvw, this.xvx, this.xvy, this.xvz, this.xvA, this.xvB, 0);
      }
      if (-1 != paramInt2) {
        break label901;
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.wwP.field_snsId, 15, 0));
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
      com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.wwP.field_snsId, 13, 0));
      break;
      label901:
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.wwP.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99801);
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.xMh;
    ad.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.wth);
    if (localVideoPlayView.wth != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label119;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.wth = paramConfiguration.orientation;
      if (localVideoPlayView.wth == 2) {
        localVideoPlayView.lRB.setVisibility(8);
      }
      NA(paramConfiguration.orientation);
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
    if (ai.aF(getContext())) {
      getController().setActionbarColor(getResources().getColor(2131099873));
    }
    this.xMn = new String[] { getString(2131763770), getString(2131763771), getString(2131763769) };
    this.xMo = new String[] { getString(2131763770), getString(2131763771) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.wwP = af.dtu().apJ(com.tencent.mm.plugin.sns.data.q.anR(paramBundle));
    this.nnt = new com.tencent.mm.model.d();
    this.xMi = com.tencent.mm.modelsns.d.w(getIntent());
    this.gjt = getIntent().getStringExtra("KFullVideoPath");
    this.xvn = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.isAd = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.xvq = bt.by(getIntent().getStringExtra("KMediaTitle"), "");
    this.xMj = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.xvp = getIntent().getBooleanExtra("KBlockFav", false);
    this.xvo = getIntent().getBooleanExtra("ForceLandscape", false);
    this.gJy = getIntent().getStringExtra("StreamWording");
    this.gJz = getIntent().getStringExtra("StremWebUrl");
    this.wWE = getIntent().getStringExtra("KComponentCid");
    this.xvs = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.xvt = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.xvu = getIntent().getIntExtra("KSta_SourceType", 0);
    this.xvv = getIntent().getIntExtra("KSta_Scene", 0);
    this.xvw = getIntent().getStringExtra("KSta_FromUserName");
    this.xvx = getIntent().getStringExtra("KSta_ChatName");
    this.xvy = getIntent().getStringExtra("KSta_SnSId");
    this.xvz = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.xvA = getIntent().getIntExtra("KSta_FavID", 0);
    this.xvB = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.dxG = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.dAM = bt.by(getIntent().getStringExtra("KViewId"), "");
    this.xMl = bt.by(getIntent().getStringExtra("ReportArgs"), "");
    this.xMm = getIntent().getIntExtra("NeedReportData", 0);
    if (this.xMm != 0)
    {
      this.ssid = ay.iA(aj.getContext());
      this.bssid = ay.iB(aj.getContext());
    }
    this.xMk = new bpi();
    this.xMk.DMQ = this.thumbUrl;
    this.xMk.DMX = this.xvn;
    this.xMk.Id = this.mediaId;
    this.xMk.Url = this.url;
    this.xMk.Dzl = 1;
    this.xMk.xMj = this.xMj;
    this.xvr.wyq = bt.GC();
    ad.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.xMk.Id + " attachurl:" + this.xMk.DMX + " videoattachTotalTime:" + this.xMk.xMj + " streamvideowording: " + this.gJy + " streamvideoweburl: " + this.gJz + " mediaTitle: " + this.xvq + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.xvs + " streamvideopublishid " + this.xvt);
    Object localObject1;
    if (bt.isNullOrNil(this.gjt))
    {
      paramBundle = an.iF(af.getAccSnsPath(), this.xMk.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.q.j(this.xMk);
      this.gjt = (paramBundle + (String)localObject1);
    }
    if ((bt.isNullOrNil(this.thumbPath)) || (!com.tencent.mm.vfs.i.eK(this.thumbPath)))
    {
      paramBundle = "attach" + this.xMk.Id;
      localObject1 = an.iF(af.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + com.tencent.mm.plugin.sns.data.q.anA(paramBundle));
    }
    if (!com.tencent.mm.vfs.i.eK(this.thumbPath)) {}
    try
    {
      paramBundle = new bpi();
      paramBundle.parseFrom(this.xMk.toByteArray());
      paramBundle.Id = ("attach" + paramBundle.Id);
      localObject1 = new com.tencent.mm.plugin.sns.data.m(this.xMk);
      ((com.tencent.mm.plugin.sns.data.m)localObject1).wBd = 1;
      ((com.tencent.mm.plugin.sns.data.m)localObject1).dnB = this.xMk.Id;
      af.dtp().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.m)localObject1, bc.FzF);
      getWindow().addFlags(128);
      this.xMh = ((VideoPlayView)findViewById(2131306370));
      paramBundle = this.xMh;
      localObject1 = new AdVideoPlayerLoadingBar(getContext());
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(2131165506);
      paramBundle.wsT = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.nAZ.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.wsT, (ViewGroup.LayoutParams)localObject2);
      paramBundle.wsT.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.wsT.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.wsT.setIsPlay(paramBundle.nAZ.isPlaying());
      if (paramBundle.wsT != null) {
        ((View)paramBundle.wsT).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.xMh.setVideoPlayViewEvent(new VideoPlayView.a()
      {
        public final void LT(int paramAnonymousInt)
        {
          AppMethodBeat.i(99786);
          if (VideoAdPlayerUI.i(VideoAdPlayerUI.this) == 0)
          {
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, paramAnonymousInt);
            VideoAdPlayerUI.j(VideoAdPlayerUI.this).xMj = paramAnonymousInt;
          }
          AppMethodBeat.o(99786);
        }
        
        public final void dqI()
        {
          AppMethodBeat.i(99783);
          VideoAdPlayerUI.d(VideoAdPlayerUI.this).ea(false);
          com.tencent.mm.plugin.sns.a.b.a.a locala = VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw;
          locala.wzy += (int)bt.aS(VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw.wzC);
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          AppMethodBeat.o(99783);
        }
        
        public final void dqJ()
        {
          AppMethodBeat.i(99784);
          ad.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
          Object localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw;
          ((com.tencent.mm.plugin.sns.a.b.a.a)localObject).wzx += 1;
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
          {
            localObject = new com.tencent.mm.modelstat.i(13227, "1,2," + VideoAdPlayerUI.i(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bt.aGK() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bt.aGK());
            g.afC();
            g.afA().gcy.a((n)localObject, 0);
          }
          AppMethodBeat.o(99784);
        }
        
        public final void dqK()
        {
          AppMethodBeat.i(99785);
          ad.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          VideoAdPlayerUI.c(VideoAdPlayerUI.this).dqF();
          AppMethodBeat.o(99785);
        }
        
        public final void pC(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99782);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw;
            if (VideoAdPlayerUI.this.getResources().getConfiguration().orientation != 2) {
              break label301;
            }
          }
          label301:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.sns.a.b.a.a)localObject).wzB = i;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw.wzC = bt.GC();
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw.wzA = 2;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw.wzy = 0;
            if ((!VideoAdPlayerUI.b(VideoAdPlayerUI.this)) && ((int)VideoAdPlayerUI.c(VideoAdPlayerUI.this).getLastProgresstime() == 0))
            {
              localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw;
              ((com.tencent.mm.plugin.sns.a.b.a.a)localObject).wzw += 1;
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw.wzC = bt.GC();
            VideoAdPlayerUI.d(VideoAdPlayerUI.this).a(VideoAdPlayerUI.c(VideoAdPlayerUI.this));
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              localObject = new com.tencent.mm.modelstat.i(13227, "1,1,0," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bt.aGK() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bt.aGK());
              g.afC();
              g.afA().gcy.a((n)localObject, 0);
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, true);
            AppMethodBeat.o(99782);
            return;
          }
        }
      });
      this.xMh.setVideoTotalTime(this.xMk.xMj);
      if (com.tencent.mm.vfs.i.eK(this.gjt))
      {
        this.xvr.wyo = 1;
        this.xMh.setVideoPath(this.gjt);
        this.xMh.setLeftButtonOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99787);
            VideoAdPlayerUI.this.finish();
            AppMethodBeat.o(99787);
          }
        });
        this.xMh.setRightButtonOnCliclListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99789);
            VideoAdPlayerUI localVideoAdPlayerUI = VideoAdPlayerUI.this;
            if (VideoAdPlayerUI.k(VideoAdPlayerUI.this)) {}
            for (paramAnonymousView = VideoAdPlayerUI.l(VideoAdPlayerUI.this);; paramAnonymousView = VideoAdPlayerUI.m(VideoAdPlayerUI.this))
            {
              com.tencent.mm.ui.base.h.a(localVideoAdPlayerUI, null, paramAnonymousView, null, new h.c()
              {
                public final void kM(int paramAnonymous2Int)
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
                    com.tencent.mm.bs.d.c(VideoAdPlayerUI.this, ".ui.transmit.SelectConversationUI", localIntent, 4097);
                    AppMethodBeat.o(99788);
                    return;
                    VideoAdPlayerUI.o(VideoAdPlayerUI.this);
                    AppMethodBeat.o(99788);
                    return;
                    VideoAdPlayerUI.p(VideoAdPlayerUI.this);
                  }
                }
              });
              AppMethodBeat.o(99789);
              return;
            }
          }
        });
        paramBundle = this.xMh;
        localObject1 = this.gJy;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99791);
            if (VideoAdPlayerUI.q(VideoAdPlayerUI.this) != 0) {
              com.tencent.mm.plugin.sns.a.b.m.a(m.a.wyV, VideoAdPlayerUI.this.xvt, VideoAdPlayerUI.this.xvs, VideoAdPlayerUI.r(VideoAdPlayerUI.this), VideoAdPlayerUI.q(VideoAdPlayerUI.this), VideoAdPlayerUI.s(VideoAdPlayerUI.this), VideoAdPlayerUI.t(VideoAdPlayerUI.this), VideoAdPlayerUI.u(VideoAdPlayerUI.this), VideoAdPlayerUI.v(VideoAdPlayerUI.this), VideoAdPlayerUI.w(VideoAdPlayerUI.this), VideoAdPlayerUI.x(VideoAdPlayerUI.this));
            }
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              int j = VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw.wzy;
              int i = j;
              if (VideoAdPlayerUI.b(VideoAdPlayerUI.this))
              {
                i = j;
                if (VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw.wzC != 0L) {
                  i = j + (int)(bt.aS(VideoAdPlayerUI.a(VideoAdPlayerUI.this).wyw.wzC) / 1000L);
                }
              }
              paramAnonymousView = new com.tencent.mm.modelstat.i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bt.aGK() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bt.aGK());
              g.afC();
              g.afA().gcy.a(paramAnonymousView, 0);
            }
            VideoAdPlayerUI.this.finish();
            final Intent localIntent = new Intent();
            Bundle localBundle = new Bundle();
            localBundle.putString("key_snsad_statextstr", VideoAdPlayerUI.y(VideoAdPlayerUI.this));
            String str = VideoAdPlayerUI.z(VideoAdPlayerUI.this);
            paramAnonymousView = str;
            if (VideoAdPlayerUI.A(VideoAdPlayerUI.this))
            {
              paramAnonymousView = str;
              if (!TextUtils.isEmpty(VideoAdPlayerUI.this.xvs)) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iy(str, VideoAdPlayerUI.this.xvs);
              }
            }
            localIntent.putExtra("jsapiargs", localBundle);
            localIntent.putExtra("rawUrl", paramAnonymousView);
            localIntent.putExtra("useJs", true);
            if (VideoAdPlayerUI.A(VideoAdPlayerUI.this)) {
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, VideoAdPlayerUI.B(VideoAdPlayerUI.this).field_snsId, 18, 0));
            }
            new ap(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99790);
                com.tencent.mm.plugin.sns.d.a.hYt.i(localIntent, VideoAdPlayerUI.this);
                AppMethodBeat.o(99790);
              }
            });
            AppMethodBeat.o(99791);
          }
        };
        paramBundle.wsW = ((String)localObject1);
        paramBundle.wsV.setText((CharSequence)localObject1);
        paramBundle.wsV.setOnClickListener((View.OnClickListener)localObject2);
        this.xMh.dqH();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.xMh;
          if (paramBundle.wsX != null)
          {
            paramBundle.wsY = false;
            paramBundle.wsX.setVisibility(8);
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
        ad.e("MicroMsg.VideoPlayerUI", "error for download thumb");
        continue;
        this.xMh.dqF();
        this.xMh.setIsDownloading(true);
        af.dtp().a(this.xMk, 6, null, bc.FzF);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99795);
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.xvv != 0) {
      com.tencent.mm.plugin.sns.a.b.m.a(m.a.wyX, this.xvt, this.xvs, this.xvu, this.xvv, this.xvw, this.xvx, this.xvy, this.xvz, this.xvA, this.xvB);
    }
    int i;
    String str;
    int j;
    if (this.isAd)
    {
      if (this.wwP != null) {
        break label468;
      }
      i = 0;
      if (this.wwP != null)
      {
        str = this.xvr.drv();
        long l2 = this.xvr.wyp - this.xvr.htc;
        long l1 = l2;
        if (l2 < 0L)
        {
          ad.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.xvr.wyp), Long.valueOf(this.xvr.htc) });
          l1 = this.xvr.wyp;
        }
        j = (int)l1;
        localObject = this.wwP.dxu();
        if (localObject != null) {
          break label479;
        }
      }
    }
    label468:
    label479:
    for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).wSu)
    {
      g.afC();
      g.afA().gcy.a(new f(this.dAM, 6, this.xvr.wyp, str, i, j, j, this.wwP.dyh().dxA(), this.wwP.dyh().dxB(), (String)localObject), 0);
      if (this.xMm != 0)
      {
        j = this.xvr.wyw.wzy;
        i = j;
        if (this.kQm)
        {
          i = j;
          if (this.xvr.wyw.wzC != 0L) {
            i = j + (int)(bt.aS(this.xvr.wyw.wzC) / 1000L);
          }
        }
        localObject = new com.tencent.mm.modelstat.i(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + bt.aGK() + "," + this.xMl + "," + this.xMj, (int)bt.aGK());
        g.afC();
        g.afA().gcy.a((n)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
      AppMethodBeat.o(99795);
      return;
      i = this.wwP.dyi();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99797);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ad.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
    NA(i);
    if ((this.xMh != null) && (this.xMh.isPlaying())) {
      this.xMh.pause();
    }
    if (this.xMh != null)
    {
      ad.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.xMh.onDetach();
    }
    af.dtp().wDw.remove(this);
    af.dtp().b(this);
    if (this.xvr != null) {
      this.xvr.htb = bt.GC();
    }
    AppMethodBeat.o(99797);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99798);
    super.onResume();
    af.dtp().wDw.add(this);
    af.dtp().a(this);
    if (this.xvr != null) {
      this.xvr.onResume();
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