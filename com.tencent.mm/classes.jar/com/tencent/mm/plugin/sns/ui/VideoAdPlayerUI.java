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
import com.tencent.mm.ah.w.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.ad.d.f;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bf;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class VideoAdPlayerUI
  extends MMActivity
  implements b.a, b.b
{
  private String bssid;
  private String dvs;
  private String dyy;
  private String gKe;
  private String hjY;
  private String hjZ;
  private boolean isAd;
  private boolean lrL;
  private String mediaId;
  private com.tencent.mm.model.d nQt;
  private String ssid;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private p xIq;
  private String yId;
  private boolean yIe;
  private boolean yIf;
  private String yIg;
  private com.tencent.mm.plugin.sns.ad.d.j yIh;
  public String yIi;
  public String yIj;
  private int yIk;
  private int yIl;
  private String yIm;
  private String yIn;
  private String yIo;
  private long yIp;
  private int yIq;
  private int yIr;
  private VideoPlayView yYW;
  private com.tencent.mm.modelsns.d yYX;
  private int yYY;
  private btz yYZ;
  private String yZa;
  private int yZb;
  private String[] yZc;
  private String[] yZd;
  private String yjs;
  
  public VideoAdPlayerUI()
  {
    AppMethodBeat.i(99792);
    this.yYX = null;
    this.yIh = new com.tencent.mm.plugin.sns.ad.d.j("VideoAdPlayerUI");
    this.gKe = "";
    this.thumbPath = "";
    this.yId = "";
    this.url = "";
    this.thumbUrl = "";
    this.mediaId = "";
    this.isAd = false;
    this.yYY = 0;
    this.yIg = "";
    this.hjY = "";
    this.hjZ = "";
    this.yIi = "";
    this.yIj = "";
    this.yIk = 0;
    this.yIl = 0;
    this.yIm = "";
    this.yIo = "";
    this.yIp = 0L;
    this.yIq = 0;
    this.yIr = 0;
    this.yjs = "";
    this.dyy = "";
    this.yIf = false;
    this.yIe = false;
    this.yYZ = null;
    this.lrL = false;
    this.yZc = null;
    this.yZd = null;
    AppMethodBeat.o(99792);
  }
  
  private void PE(int paramInt)
  {
    AppMethodBeat.i(99802);
    if (!this.isAd)
    {
      AppMethodBeat.o(99802);
      return;
    }
    this.yIh.NV(this.yYW.getDuration());
    this.yIh.xJX.xLd = bs.Gn();
    com.tencent.mm.plugin.sns.ad.d.a.a locala = this.yIh.xJX;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      locala.xLc = paramInt;
      this.yIh.xJX.xLb = 2;
      ac.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.yIh.xJX.xLc);
      AppMethodBeat.o(99802);
      return;
    }
  }
  
  public final void atn(String paramString) {}
  
  public final void bF(String paramString, boolean paramBoolean) {}
  
  public final void bG(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99800);
    ac.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    this.yYW.setIsDownloading(false);
    this.yYW.setVideoPath(this.gKe);
    this.yYW.p(this.yYW.getLastProgresstime());
    this.yYW.setLoop(false);
    if ((this.isAd) && (!bs.isNullOrNil(paramString)) && (this.yYZ != null) && (paramString.equals(this.yYZ.Id)) && (com.tencent.mm.vfs.i.eA(this.gKe))) {
      this.yIh.xJP = 1;
    }
    AppMethodBeat.o(99800);
  }
  
  public final void dGO() {}
  
  public void finish()
  {
    AppMethodBeat.i(99796);
    if (this.lrL) {
      this.yYW.pause();
    }
    if ((this.yIh != null) && (this.yjs != null) && (this.yjs.length() > 0))
    {
      this.yIh.dFI();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.yjs);
      localIntent.putExtra("KStreamVideoPlayCount", this.yIh.xJT);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.yIh.xJU);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.yIh.xJV);
      setResult(-1, localIntent);
    }
    super.finish();
    AppMethodBeat.o(99796);
  }
  
  public int getForceOrientation()
  {
    if (this.yIe) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131495835;
  }
  
  public final void iY(String paramString1, String paramString2)
  {
    AppMethodBeat.i(99799);
    ac.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.yYW.isPlaying());
    if (this.yYW.isPlaying())
    {
      AppMethodBeat.o(99799);
      return;
    }
    this.yYW.setLoop(false);
    if (paramString2.equals(this.yYW.getVideoPath()))
    {
      this.yYW.p(this.yYW.getLastProgresstime());
      this.yYW.start();
      ac.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      AppMethodBeat.o(99799);
      return;
    }
    this.yYW.setVideoPath(paramString2);
    this.yYW.p(this.yYW.getLastProgresstime());
    ac.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + paramString1 + " path: " + paramString2);
    AppMethodBeat.o(99799);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99794);
    ac.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[] { Integer.valueOf(paramInt1) });
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bs.S(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          ac.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[] { str2 });
          Object localObject2 = new k.b();
          ((k.b)localObject2).title = this.yIg;
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
          if (!bs.isNullOrNil(this.yYZ.Url))
          {
            ((k.b)localObject2).url = this.yYZ.Url;
            if (!bs.isNullOrNil(this.yYZ.Fjr)) {
              break label713;
            }
            localObject1 = this.yYZ.Fjh;
            ((k.b)localObject2).thumburl = ((String)localObject1);
            ((k.b)localObject2).hjV = this.yYZ.Fjo;
            ((k.b)localObject2).hjW = this.yYZ.yYY;
            ((k.b)localObject2).hjX = this.yIg;
            ((k.b)localObject2).hjZ = this.hjZ;
            ((k.b)localObject2).hjY = this.hjY;
            ((k.b)localObject2).hka = this.thumbUrl;
            ((k.b)localObject2).hkb = this.yIi;
            ((k.b)localObject2).hkc = this.yIj;
            ((k.b)localObject2).dvs = this.dvs;
            localObject1 = com.tencent.mm.vfs.i.aU(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label725;
            }
            i = 0;
            ac.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.awq() != null) {
              w.a.awq().a((k.b)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.yZb != 0)
            {
              j = this.yIh.xJX.xKZ;
              i = j;
              if (this.lrL)
              {
                i = j;
                if (this.yIh.xJX.xLd != 0L) {
                  i = j + (int)(bs.aO(this.yIh.xJX.xLd) / 1000L);
                }
              }
              localObject1 = new com.tencent.mm.modelstat.i(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + bs.aNx() + "," + this.yZa + "," + this.yYY, (int)bs.aNx());
              g.agS();
              g.agQ().ghe.a((n)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.j.dck().hF(str1, str2);
            if (this.isAd) {
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.xIq.field_snsId, 12, 0));
            }
            if (this.yIl == 0) {
              continue;
            }
            boolean bool = com.tencent.mm.model.w.sQ(str2);
            if (!bool) {
              break label733;
            }
            localObject1 = m.c.xKK;
            localObject2 = this.yIj;
            str3 = this.yIi;
            j = this.yIk;
            k = this.yIl;
            str4 = this.yIm;
            str5 = this.yIn;
            str6 = this.yIo;
            l = this.yIp;
            m = this.yIq;
            n = this.yIr;
            if (!bool) {
              break label741;
            }
          }
          label713:
          label725:
          label733:
          label741:
          for (int i = com.tencent.mm.model.q.wb(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.d.m.a((m.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject2).url = this.yYZ.Fjo;
            break label161;
            localObject1 = this.yYZ.Fjr;
            break label183;
            i = localObject1.length;
            break label296;
            localObject1 = m.c.xKJ;
            break label596;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.yIl != 0) {
        com.tencent.mm.plugin.sns.ad.d.m.a(m.c.xKL, this.yIj, this.yIi, this.yIk, this.yIl, this.yIm, this.yIn, this.yIo, this.yIp, this.yIq, this.yIr, 0);
      }
      if (-1 != paramInt2) {
        break label901;
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.xIq.field_snsId, 15, 0));
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
      com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.xIq.field_snsId, 13, 0));
      break;
      label901:
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.xIq.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99801);
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.yYW;
    ac.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.xEx);
    if (localVideoPlayView.xEx != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label119;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.xEx = paramConfiguration.orientation;
      if (localVideoPlayView.xEx == 2) {
        localVideoPlayView.gGk.setVisibility(8);
      }
      PE(paramConfiguration.orientation);
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
    if (aj.aG(getContext())) {
      getController().setActionbarColor(getResources().getColor(2131099873));
    }
    this.yZc = new String[] { getString(2131763770), getString(2131763771), getString(2131763769) };
    this.yZd = new String[] { getString(2131763770), getString(2131763771) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.xIq = af.dHR().auS(com.tencent.mm.plugin.sns.data.q.atd(paramBundle));
    this.nQt = new com.tencent.mm.model.d();
    this.yYX = com.tencent.mm.modelsns.d.w(getIntent());
    this.gKe = getIntent().getStringExtra("KFullVideoPath");
    this.yId = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.isAd = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.yIg = bs.bG(getIntent().getStringExtra("KMediaTitle"), "");
    this.yYY = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.yIf = getIntent().getBooleanExtra("KBlockFav", false);
    this.yIe = getIntent().getBooleanExtra("ForceLandscape", false);
    this.hjY = getIntent().getStringExtra("StreamWording");
    this.hjZ = getIntent().getStringExtra("StremWebUrl");
    this.yjs = getIntent().getStringExtra("KComponentCid");
    this.yIi = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.yIj = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.yIk = getIntent().getIntExtra("KSta_SourceType", 0);
    this.yIl = getIntent().getIntExtra("KSta_Scene", 0);
    this.yIm = getIntent().getStringExtra("KSta_FromUserName");
    this.yIn = getIntent().getStringExtra("KSta_ChatName");
    this.yIo = getIntent().getStringExtra("KSta_SnSId");
    this.yIp = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.yIq = getIntent().getIntExtra("KSta_FavID", 0);
    this.yIr = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.dvs = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.dyy = bs.bG(getIntent().getStringExtra("KViewId"), "");
    this.yZa = bs.bG(getIntent().getStringExtra("ReportArgs"), "");
    this.yZb = getIntent().getIntExtra("NeedReportData", 0);
    if (this.yZb != 0)
    {
      this.ssid = ax.iL(ai.getContext());
      this.bssid = ax.iM(ai.getContext());
    }
    this.yYZ = new btz();
    this.yYZ.Fjh = this.thumbUrl;
    this.yYZ.Fjo = this.yId;
    this.yYZ.Id = this.mediaId;
    this.yYZ.Url = this.url;
    this.yYZ.EUH = 1;
    this.yYZ.yYY = this.yYY;
    this.yIh.xJR = bs.Gn();
    ac.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.yYZ.Id + " attachurl:" + this.yYZ.Fjo + " videoattachTotalTime:" + this.yYZ.yYY + " streamvideowording: " + this.hjY + " streamvideoweburl: " + this.hjZ + " mediaTitle: " + this.yIg + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.yIi + " streamvideopublishid " + this.yIj);
    Object localObject1;
    if (bs.isNullOrNil(this.gKe))
    {
      paramBundle = an.jc(af.getAccSnsPath(), this.yYZ.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.q.j(this.yYZ);
      this.gKe = (paramBundle + (String)localObject1);
    }
    if ((bs.isNullOrNil(this.thumbPath)) || (!com.tencent.mm.vfs.i.eA(this.thumbPath)))
    {
      paramBundle = "attach" + this.yYZ.Id;
      localObject1 = an.jc(af.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + com.tencent.mm.plugin.sns.data.q.asM(paramBundle));
    }
    if (!com.tencent.mm.vfs.i.eA(this.thumbPath)) {}
    try
    {
      paramBundle = new btz();
      paramBundle.parseFrom(this.yYZ.toByteArray());
      paramBundle.Id = ("attach" + paramBundle.Id);
      localObject1 = new com.tencent.mm.plugin.sns.data.m(this.yYZ);
      ((com.tencent.mm.plugin.sns.data.m)localObject1).xNy = 1;
      ((com.tencent.mm.plugin.sns.data.m)localObject1).dlj = this.yYZ.Id;
      af.dHM().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.m)localObject1, bf.GYH);
      getWindow().addFlags(128);
      this.yYW = ((VideoPlayView)findViewById(2131306370));
      paramBundle = this.yYW;
      localObject1 = new AdVideoPlayerLoadingBar(getContext());
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(2131165506);
      paramBundle.xEj = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.odZ.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.xEj, (ViewGroup.LayoutParams)localObject2);
      paramBundle.xEj.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.xEj.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.xEj.setIsPlay(paramBundle.odZ.isPlaying());
      if (paramBundle.xEj != null) {
        ((View)paramBundle.xEj).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.yYW.setVideoPlayViewEvent(new VideoPlayView.a()
      {
        public final void NT(int paramAnonymousInt)
        {
          AppMethodBeat.i(99786);
          if (VideoAdPlayerUI.i(VideoAdPlayerUI.this) == 0)
          {
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, paramAnonymousInt);
            VideoAdPlayerUI.j(VideoAdPlayerUI.this).yYY = paramAnonymousInt;
          }
          AppMethodBeat.o(99786);
        }
        
        public final void dER()
        {
          AppMethodBeat.i(99783);
          VideoAdPlayerUI.d(VideoAdPlayerUI.this).ev(false);
          com.tencent.mm.plugin.sns.ad.d.a.a locala = VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX;
          locala.xKZ += (int)bs.aO(VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX.xLd);
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          AppMethodBeat.o(99783);
        }
        
        public final void dES()
        {
          AppMethodBeat.i(99784);
          ac.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
          Object localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX;
          ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).xKY += 1;
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
          {
            localObject = new com.tencent.mm.modelstat.i(13227, "1,2," + VideoAdPlayerUI.i(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bs.aNx() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bs.aNx());
            g.agS();
            g.agQ().ghe.a((n)localObject, 0);
          }
          AppMethodBeat.o(99784);
        }
        
        public final void dET()
        {
          AppMethodBeat.i(99785);
          ac.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          VideoAdPlayerUI.c(VideoAdPlayerUI.this).dEO();
          AppMethodBeat.o(99785);
        }
        
        public final void qB(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99782);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX;
            if (VideoAdPlayerUI.this.getResources().getConfiguration().orientation != 2) {
              break label301;
            }
          }
          label301:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).xLc = i;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX.xLd = bs.Gn();
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX.xLb = 2;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX.xKZ = 0;
            if ((!VideoAdPlayerUI.b(VideoAdPlayerUI.this)) && ((int)VideoAdPlayerUI.c(VideoAdPlayerUI.this).getLastProgresstime() == 0))
            {
              localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX;
              ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).xKX += 1;
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX.xLd = bs.Gn();
            VideoAdPlayerUI.d(VideoAdPlayerUI.this).a(VideoAdPlayerUI.c(VideoAdPlayerUI.this));
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              localObject = new com.tencent.mm.modelstat.i(13227, "1,1,0," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bs.aNx() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bs.aNx());
              g.agS();
              g.agQ().ghe.a((n)localObject, 0);
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, true);
            AppMethodBeat.o(99782);
            return;
          }
        }
      });
      this.yYW.setVideoTotalTime(this.yYZ.yYY);
      if (com.tencent.mm.vfs.i.eA(this.gKe))
      {
        this.yIh.xJP = 1;
        this.yYW.setVideoPath(this.gKe);
        this.yYW.setLeftButtonOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99787);
            VideoAdPlayerUI.this.finish();
            AppMethodBeat.o(99787);
          }
        });
        this.yYW.setRightButtonOnCliclListener(new View.OnClickListener()
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
                public final void kG(int paramAnonymous2Int)
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
              AppMethodBeat.o(99789);
              return;
            }
          }
        });
        paramBundle = this.yYW;
        localObject1 = this.hjY;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99791);
            if (VideoAdPlayerUI.q(VideoAdPlayerUI.this) != 0) {
              com.tencent.mm.plugin.sns.ad.d.m.a(m.a.xKw, VideoAdPlayerUI.this.yIj, VideoAdPlayerUI.this.yIi, VideoAdPlayerUI.r(VideoAdPlayerUI.this), VideoAdPlayerUI.q(VideoAdPlayerUI.this), VideoAdPlayerUI.s(VideoAdPlayerUI.this), VideoAdPlayerUI.t(VideoAdPlayerUI.this), VideoAdPlayerUI.u(VideoAdPlayerUI.this), VideoAdPlayerUI.v(VideoAdPlayerUI.this), VideoAdPlayerUI.w(VideoAdPlayerUI.this), VideoAdPlayerUI.x(VideoAdPlayerUI.this));
            }
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              int j = VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX.xKZ;
              int i = j;
              if (VideoAdPlayerUI.b(VideoAdPlayerUI.this))
              {
                i = j;
                if (VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX.xLd != 0L) {
                  i = j + (int)(bs.aO(VideoAdPlayerUI.a(VideoAdPlayerUI.this).xJX.xLd) / 1000L);
                }
              }
              paramAnonymousView = new com.tencent.mm.modelstat.i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bs.aNx() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bs.aNx());
              g.agS();
              g.agQ().ghe.a(paramAnonymousView, 0);
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
              if (!TextUtils.isEmpty(VideoAdPlayerUI.this.yIi)) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.iV(str, VideoAdPlayerUI.this.yIi);
              }
            }
            localIntent.putExtra("jsapiargs", localBundle);
            localIntent.putExtra("rawUrl", paramAnonymousView);
            localIntent.putExtra("useJs", true);
            if (VideoAdPlayerUI.A(VideoAdPlayerUI.this)) {
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, VideoAdPlayerUI.B(VideoAdPlayerUI.this).field_snsId, 18, 0));
            }
            new ao(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99790);
                com.tencent.mm.plugin.sns.c.a.iyx.i(localIntent, VideoAdPlayerUI.this);
                AppMethodBeat.o(99790);
              }
            });
            AppMethodBeat.o(99791);
          }
        };
        paramBundle.xEm = ((String)localObject1);
        paramBundle.xEl.setText((CharSequence)localObject1);
        paramBundle.xEl.setOnClickListener((View.OnClickListener)localObject2);
        this.yYW.dEQ();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.yYW;
          if (paramBundle.xEn != null)
          {
            paramBundle.xEo = false;
            paramBundle.xEn.setVisibility(8);
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
        ac.e("MicroMsg.VideoPlayerUI", "error for download thumb");
        continue;
        this.yYW.dEO();
        this.yYW.setIsDownloading(true);
        af.dHM().a(this.yYZ, 6, null, bf.GYH);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99795);
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.yIl != 0) {
      com.tencent.mm.plugin.sns.ad.d.m.a(m.a.xKy, this.yIj, this.yIi, this.yIk, this.yIl, this.yIm, this.yIn, this.yIo, this.yIp, this.yIq, this.yIr);
    }
    int i;
    String str;
    int j;
    if (this.isAd)
    {
      if (this.xIq != null) {
        break label468;
      }
      i = 0;
      if (this.xIq != null)
      {
        str = this.yIh.dFH();
        long l2 = this.yIh.xJQ - this.yIh.hTE;
        long l1 = l2;
        if (l2 < 0L)
        {
          ac.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.yIh.xJQ), Long.valueOf(this.yIh.hTE) });
          l1 = this.yIh.xJQ;
        }
        j = (int)l1;
        localObject = this.xIq.dFQ();
        if (localObject != null) {
          break label479;
        }
      }
    }
    label468:
    label479:
    for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).yfa)
    {
      g.agS();
      g.agQ().ghe.a(new f(this.dyy, 6, this.yIh.xJQ, str, i, j, j, this.xIq.dME().dLX(), this.xIq.dME().dLY(), (String)localObject), 0);
      if (this.yZb != 0)
      {
        j = this.yIh.xJX.xKZ;
        i = j;
        if (this.lrL)
        {
          i = j;
          if (this.yIh.xJX.xLd != 0L) {
            i = j + (int)(bs.aO(this.yIh.xJX.xLd) / 1000L);
          }
        }
        localObject = new com.tencent.mm.modelstat.i(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + bs.aNx() + "," + this.yZa + "," + this.yYY, (int)bs.aNx());
        g.agS();
        g.agQ().ghe.a((n)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
      AppMethodBeat.o(99795);
      return;
      i = this.xIq.dMF();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99797);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ac.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
    PE(i);
    if ((this.yYW != null) && (this.yYW.isPlaying())) {
      this.yYW.pause();
    }
    if (this.yYW != null)
    {
      ac.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.yYW.onDetach();
    }
    af.dHM().xPR.remove(this);
    af.dHM().b(this);
    if (this.yIh != null) {
      this.yIh.hTD = bs.Gn();
    }
    AppMethodBeat.o(99797);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99798);
    super.onResume();
    af.dHM().xPR.add(this);
    af.dHM().a(this);
    if (this.yIh != null) {
      this.yIh.onResume();
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