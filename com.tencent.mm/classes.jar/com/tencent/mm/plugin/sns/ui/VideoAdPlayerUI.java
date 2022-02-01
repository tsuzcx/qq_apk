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
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.ad.d.f;
import com.tencent.mm.plugin.sns.ad.d.j;
import com.tencent.mm.plugin.sns.ad.d.m.a;
import com.tencent.mm.plugin.sns.ad.d.m.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
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
  private VideoPlayView AqK;
  private com.tencent.mm.modelsns.e AqL;
  private int AqM;
  private byn AqN;
  private String AqO;
  private int AqP;
  private String[] AqQ;
  private String[] AqR;
  private String aQj;
  private String bssid;
  private String dHv;
  private String hCh;
  private String hCi;
  private String hdP;
  private boolean isAd;
  private boolean lQV;
  private String mediaId;
  private com.tencent.mm.model.d ota;
  private String ssid;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private p yXF;
  private String zAg;
  private String zZA;
  private j zZB;
  public String zZC;
  public String zZD;
  private int zZE;
  private int zZF;
  private String zZG;
  private String zZH;
  private String zZI;
  private long zZJ;
  private int zZK;
  private int zZL;
  private String zZx;
  private boolean zZy;
  private boolean zZz;
  
  public VideoAdPlayerUI()
  {
    AppMethodBeat.i(99792);
    this.AqL = null;
    this.zZB = new j("VideoAdPlayerUI");
    this.hdP = "";
    this.thumbPath = "";
    this.zZx = "";
    this.url = "";
    this.thumbUrl = "";
    this.mediaId = "";
    this.isAd = false;
    this.AqM = 0;
    this.zZA = "";
    this.hCh = "";
    this.hCi = "";
    this.zZC = "";
    this.zZD = "";
    this.zZE = 0;
    this.zZF = 0;
    this.zZG = "";
    this.zZI = "";
    this.zZJ = 0L;
    this.zZK = 0;
    this.zZL = 0;
    this.zAg = "";
    this.aQj = "";
    this.zZz = false;
    this.zZy = false;
    this.AqN = null;
    this.lQV = false;
    this.AqQ = null;
    this.AqR = null;
    AppMethodBeat.o(99792);
  }
  
  private void Rn(int paramInt)
  {
    AppMethodBeat.i(99802);
    if (!this.isAd)
    {
      AppMethodBeat.o(99802);
      return;
    }
    this.zZB.Py(this.AqK.getDuration());
    this.zZB.yZm.zas = bt.HI();
    com.tencent.mm.plugin.sns.ad.d.a.a locala = this.zZB.yZm;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      locala.zar = paramInt;
      this.zZB.yZm.zaq = 2;
      ad.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.zZB.yZm.zar);
      AppMethodBeat.o(99802);
      return;
    }
  }
  
  public final void ays(String paramString) {}
  
  public final void bM(String paramString, boolean paramBoolean) {}
  
  public final void bN(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99800);
    ad.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    this.AqK.setIsDownloading(false);
    this.AqK.setVideoPath(this.hdP);
    this.AqK.p(this.AqK.getLastProgresstime());
    this.AqK.setLoop(false);
    if ((this.isAd) && (!bt.isNullOrNil(paramString)) && (this.AqN != null) && (paramString.equals(this.AqN.Id)) && (com.tencent.mm.vfs.i.fv(this.hdP))) {
      this.zZB.yZe = 1;
    }
    AppMethodBeat.o(99800);
  }
  
  public final void dTb() {}
  
  public void finish()
  {
    AppMethodBeat.i(99796);
    if (this.lQV) {
      this.AqK.pause();
    }
    if ((this.zZB != null) && (this.zAg != null) && (this.zAg.length() > 0))
    {
      this.zZB.dRA();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.zAg);
      localIntent.putExtra("KStreamVideoPlayCount", this.zZB.yZi);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.zZB.yZj);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.zZB.yZk);
      setResult(-1, localIntent);
    }
    super.finish();
    AppMethodBeat.o(99796);
  }
  
  public int getForceOrientation()
  {
    if (this.zZy) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131495835;
  }
  
  public final void jk(String paramString1, String paramString2)
  {
    AppMethodBeat.i(99799);
    ad.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.AqK.isPlaying());
    if (this.AqK.isPlaying())
    {
      AppMethodBeat.o(99799);
      return;
    }
    this.AqK.setLoop(false);
    if (paramString2.equals(this.AqK.getVideoPath()))
    {
      this.AqK.p(this.AqK.getLastProgresstime());
      this.AqK.start();
      ad.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      AppMethodBeat.o(99799);
      return;
    }
    this.AqK.setVideoPath(paramString2);
    this.AqK.p(this.AqK.getLastProgresstime());
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
        Iterator localIterator = bt.U(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          ad.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[] { str2 });
          Object localObject2 = new k.b();
          ((k.b)localObject2).title = this.zZA;
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
          if (!bt.isNullOrNil(this.AqN.Url))
          {
            ((k.b)localObject2).url = this.AqN.Url;
            if (!bt.isNullOrNil(this.AqN.GSS)) {
              break label713;
            }
            localObject1 = this.AqN.GSI;
            ((k.b)localObject2).thumburl = ((String)localObject1);
            ((k.b)localObject2).hCe = this.AqN.GSP;
            ((k.b)localObject2).hCf = this.AqN.AqM;
            ((k.b)localObject2).hCg = this.zZA;
            ((k.b)localObject2).hCi = this.hCi;
            ((k.b)localObject2).hCh = this.hCh;
            ((k.b)localObject2).hCj = this.thumbUrl;
            ((k.b)localObject2).hCk = this.zZC;
            ((k.b)localObject2).hCl = this.zZD;
            ((k.b)localObject2).dHv = this.dHv;
            localObject1 = com.tencent.mm.vfs.i.aY(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label725;
            }
            i = 0;
            ad.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.azd() != null) {
              w.a.azd().a((k.b)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.AqP != 0)
            {
              j = this.zZB.yZm.zao;
              i = j;
              if (this.lQV)
              {
                i = j;
                if (this.zZB.yZm.zas != 0L) {
                  i = j + (int)(bt.aO(this.zZB.yZm.zas) / 1000L);
                }
              }
              localObject1 = new com.tencent.mm.modelstat.i(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + bt.aQJ() + "," + this.AqO + "," + this.AqM, (int)bt.aQJ());
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.g.dlD().hP(str1, str2);
            if (this.isAd) {
              com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.yXF.field_snsId, 12, 0));
            }
            if (this.zZF == 0) {
              continue;
            }
            boolean bool = com.tencent.mm.model.w.vF(str2);
            if (!bool) {
              break label733;
            }
            localObject1 = m.c.yZZ;
            localObject2 = this.zZD;
            str3 = this.zZC;
            j = this.zZE;
            k = this.zZF;
            str4 = this.zZG;
            str5 = this.zZH;
            str6 = this.zZI;
            l = this.zZJ;
            m = this.zZK;
            n = this.zZL;
            if (!bool) {
              break label741;
            }
          }
          label713:
          label725:
          label733:
          label741:
          for (int i = com.tencent.mm.model.q.yS(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.d.m.a((m.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject2).url = this.AqN.GSP;
            break label161;
            localObject1 = this.AqN.GSS;
            break label183;
            i = localObject1.length;
            break label296;
            localObject1 = m.c.yZY;
            break label596;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131760233));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.zZF != 0) {
        com.tencent.mm.plugin.sns.ad.d.m.a(m.c.zaa, this.zZD, this.zZC, this.zZE, this.zZF, this.zZG, this.zZH, this.zZI, this.zZJ, this.zZK, this.zZL, 0);
      }
      if (-1 != paramInt2) {
        break label901;
      }
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.yXF.field_snsId, 15, 0));
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
      com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.yXF.field_snsId, 13, 0));
      break;
      label901:
      if (this.isAd) {
        com.tencent.mm.plugin.sns.data.q.a(new SnsAdClick(0, 6, this.yXF.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99801);
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.AqK;
    ad.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.yTh);
    if (localVideoPlayView.yTh != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label119;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.yTh = paramConfiguration.orientation;
      if (localVideoPlayView.yTh == 2) {
        localVideoPlayView.gZU.setVisibility(8);
      }
      Rn(paramConfiguration.orientation);
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
    if (al.aG(getContext())) {
      getController().setActionbarColor(getResources().getColor(2131099873));
    }
    this.AqQ = new String[] { getString(2131763770), getString(2131763771), getString(2131763769) };
    this.AqR = new String[] { getString(2131763770), getString(2131763771) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.yXF = ag.dUe().azZ(com.tencent.mm.plugin.sns.data.q.ayi(paramBundle));
    this.ota = new com.tencent.mm.model.d();
    this.AqL = com.tencent.mm.modelsns.e.w(getIntent());
    this.hdP = getIntent().getStringExtra("KFullVideoPath");
    this.zZx = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.isAd = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.zZA = bt.bI(getIntent().getStringExtra("KMediaTitle"), "");
    this.AqM = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.zZz = getIntent().getBooleanExtra("KBlockFav", false);
    this.zZy = getIntent().getBooleanExtra("ForceLandscape", false);
    this.hCh = getIntent().getStringExtra("StreamWording");
    this.hCi = getIntent().getStringExtra("StremWebUrl");
    this.zAg = getIntent().getStringExtra("KComponentCid");
    this.zZC = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.zZD = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.zZE = getIntent().getIntExtra("KSta_SourceType", 0);
    this.zZF = getIntent().getIntExtra("KSta_Scene", 0);
    this.zZG = getIntent().getStringExtra("KSta_FromUserName");
    this.zZH = getIntent().getStringExtra("KSta_ChatName");
    this.zZI = getIntent().getStringExtra("KSta_SnSId");
    this.zZJ = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.zZK = getIntent().getIntExtra("KSta_FavID", 0);
    this.zZL = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.dHv = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.aQj = bt.bI(getIntent().getStringExtra("KViewId"), "");
    this.AqO = bt.bI(getIntent().getStringExtra("ReportArgs"), "");
    this.AqP = getIntent().getIntExtra("NeedReportData", 0);
    if (this.AqP != 0)
    {
      this.ssid = ay.iV(aj.getContext());
      this.bssid = ay.iW(aj.getContext());
    }
    this.AqN = new byn();
    this.AqN.GSI = this.thumbUrl;
    this.AqN.GSP = this.zZx;
    this.AqN.Id = this.mediaId;
    this.AqN.Url = this.url;
    this.AqN.GEe = 1;
    this.AqN.AqM = this.AqM;
    this.zZB.yZg = bt.HI();
    ad.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.AqN.Id + " attachurl:" + this.AqN.GSP + " videoattachTotalTime:" + this.AqN.AqM + " streamvideowording: " + this.hCh + " streamvideoweburl: " + this.hCi + " mediaTitle: " + this.zZA + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.zZC + " streamvideopublishid " + this.zZD);
    Object localObject1;
    if (bt.isNullOrNil(this.hdP))
    {
      paramBundle = ao.jo(ag.getAccSnsPath(), this.AqN.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.q.j(this.AqN);
      this.hdP = (paramBundle + (String)localObject1);
    }
    if ((bt.isNullOrNil(this.thumbPath)) || (!com.tencent.mm.vfs.i.fv(this.thumbPath)))
    {
      paramBundle = "attach" + this.AqN.Id;
      localObject1 = ao.jo(ag.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + com.tencent.mm.plugin.sns.data.q.axR(paramBundle));
    }
    if (!com.tencent.mm.vfs.i.fv(this.thumbPath)) {}
    try
    {
      paramBundle = new byn();
      paramBundle.parseFrom(this.AqN.toByteArray());
      paramBundle.Id = ("attach" + paramBundle.Id);
      localObject1 = new com.tencent.mm.plugin.sns.data.m(this.AqN);
      ((com.tencent.mm.plugin.sns.data.m)localObject1).zds = 1;
      ((com.tencent.mm.plugin.sns.data.m)localObject1).dwW = this.AqN.Id;
      ag.dTZ().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.m)localObject1, bj.ILV);
      getWindow().addFlags(128);
      this.AqK = ((VideoPlayView)findViewById(2131306370));
      paramBundle = this.AqK;
      localObject1 = new AdVideoPlayerLoadingBar(getContext());
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(2131165506);
      paramBundle.yST = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.oHt.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.yST, (ViewGroup.LayoutParams)localObject2);
      paramBundle.yST.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.yST.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.yST.setIsPlay(paramBundle.oHt.isPlaying());
      if (paramBundle.yST != null) {
        ((View)paramBundle.yST).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.AqK.setVideoPlayViewEvent(new VideoPlayView.a()
      {
        public final void Pw(int paramAnonymousInt)
        {
          AppMethodBeat.i(99786);
          if (VideoAdPlayerUI.i(VideoAdPlayerUI.this) == 0)
          {
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, paramAnonymousInt);
            VideoAdPlayerUI.j(VideoAdPlayerUI.this).AqM = paramAnonymousInt;
          }
          AppMethodBeat.o(99786);
        }
        
        public final void dQt()
        {
          AppMethodBeat.i(99783);
          VideoAdPlayerUI.d(VideoAdPlayerUI.this).ex(false);
          com.tencent.mm.plugin.sns.ad.d.a.a locala = VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm;
          locala.zao += (int)bt.aO(VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm.zas);
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          AppMethodBeat.o(99783);
        }
        
        public final void dQu()
        {
          AppMethodBeat.i(99784);
          ad.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
          Object localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm;
          ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).zan += 1;
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
          {
            localObject = new com.tencent.mm.modelstat.i(13227, "1,2," + VideoAdPlayerUI.i(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bt.aQJ() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bt.aQJ());
            com.tencent.mm.kernel.g.ajD();
            com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
          }
          AppMethodBeat.o(99784);
        }
        
        public final void dQv()
        {
          AppMethodBeat.i(99785);
          ad.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          VideoAdPlayerUI.c(VideoAdPlayerUI.this).dQq();
          AppMethodBeat.o(99785);
        }
        
        public final void rd(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99782);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm;
            if (VideoAdPlayerUI.this.getResources().getConfiguration().orientation != 2) {
              break label301;
            }
          }
          label301:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).zar = i;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm.zas = bt.HI();
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm.zaq = 2;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm.zao = 0;
            if ((!VideoAdPlayerUI.b(VideoAdPlayerUI.this)) && ((int)VideoAdPlayerUI.c(VideoAdPlayerUI.this).getLastProgresstime() == 0))
            {
              localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm;
              ((com.tencent.mm.plugin.sns.ad.d.a.a)localObject).zam += 1;
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm.zas = bt.HI();
            VideoAdPlayerUI.d(VideoAdPlayerUI.this).a(VideoAdPlayerUI.c(VideoAdPlayerUI.this));
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              localObject = new com.tencent.mm.modelstat.i(13227, "1,1,0," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bt.aQJ() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bt.aQJ());
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, true);
            AppMethodBeat.o(99782);
            return;
          }
        }
      });
      this.AqK.setVideoTotalTime(this.AqN.AqM);
      if (com.tencent.mm.vfs.i.fv(this.hdP))
      {
        this.zZB.yZe = 1;
        this.AqK.setVideoPath(this.hdP);
        this.AqK.setLeftButtonOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99787);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            VideoAdPlayerUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99787);
          }
        });
        this.AqK.setRightButtonOnCliclListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99789);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            localObject = VideoAdPlayerUI.this;
            if (VideoAdPlayerUI.k(VideoAdPlayerUI.this)) {}
            for (paramAnonymousView = VideoAdPlayerUI.l(VideoAdPlayerUI.this);; paramAnonymousView = VideoAdPlayerUI.m(VideoAdPlayerUI.this))
            {
              com.tencent.mm.ui.base.h.a((Context)localObject, null, paramAnonymousView, null, new h.c()
              {
                public final void lf(int paramAnonymous2Int)
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
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(99789);
              return;
            }
          }
        });
        paramBundle = this.AqK;
        localObject1 = this.hCh;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99791);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
            if (VideoAdPlayerUI.q(VideoAdPlayerUI.this) != 0) {
              com.tencent.mm.plugin.sns.ad.d.m.a(m.a.yZL, VideoAdPlayerUI.this.zZD, VideoAdPlayerUI.this.zZC, VideoAdPlayerUI.r(VideoAdPlayerUI.this), VideoAdPlayerUI.q(VideoAdPlayerUI.this), VideoAdPlayerUI.s(VideoAdPlayerUI.this), VideoAdPlayerUI.t(VideoAdPlayerUI.this), VideoAdPlayerUI.u(VideoAdPlayerUI.this), VideoAdPlayerUI.v(VideoAdPlayerUI.this), VideoAdPlayerUI.w(VideoAdPlayerUI.this), VideoAdPlayerUI.x(VideoAdPlayerUI.this));
            }
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              int j = VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm.zao;
              int i = j;
              if (VideoAdPlayerUI.b(VideoAdPlayerUI.this))
              {
                i = j;
                if (VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm.zas != 0L) {
                  i = j + (int)(bt.aO(VideoAdPlayerUI.a(VideoAdPlayerUI.this).yZm.zas) / 1000L);
                }
              }
              paramAnonymousView = new com.tencent.mm.modelstat.i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + bt.aQJ() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)bt.aQJ());
              com.tencent.mm.kernel.g.ajD();
              com.tencent.mm.kernel.g.ajB().gAO.a(paramAnonymousView, 0);
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
              if (!TextUtils.isEmpty(VideoAdPlayerUI.this.zZC)) {
                paramAnonymousView = com.tencent.mm.plugin.sns.data.q.jh((String)localObject, VideoAdPlayerUI.this.zZC);
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
                com.tencent.mm.plugin.sns.c.a.iRG.i(localIntent, VideoAdPlayerUI.this);
                AppMethodBeat.o(99790);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99791);
          }
        };
        paramBundle.ySW = ((String)localObject1);
        paramBundle.ySV.setText((CharSequence)localObject1);
        paramBundle.ySV.setOnClickListener((View.OnClickListener)localObject2);
        this.AqK.dQs();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.AqK;
          if (paramBundle.ySX != null)
          {
            paramBundle.ySY = false;
            paramBundle.ySX.setVisibility(8);
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
        this.AqK.dQq();
        this.AqK.setIsDownloading(true);
        ag.dTZ().a(this.AqN, 6, null, bj.ILV);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99795);
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.zZF != 0) {
      com.tencent.mm.plugin.sns.ad.d.m.a(m.a.yZN, this.zZD, this.zZC, this.zZE, this.zZF, this.zZG, this.zZH, this.zZI, this.zZJ, this.zZK, this.zZL);
    }
    int i;
    String str;
    int j;
    if (this.isAd)
    {
      if (this.yXF != null) {
        break label468;
      }
      i = 0;
      if (this.yXF != null)
      {
        str = this.zZB.dRz();
        long l2 = this.zZB.yZf - this.zZB.imY;
        long l1 = l2;
        if (l2 < 0L)
        {
          ad.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.zZB.yZf), Long.valueOf(this.zZB.imY) });
          l1 = this.zZB.yZf;
        }
        j = (int)l1;
        localObject = this.yXF.dRK();
        if (localObject != null) {
          break label479;
        }
      }
    }
    label468:
    label479:
    for (Object localObject = "";; localObject = ((com.tencent.mm.plugin.sns.storage.a)localObject).zvb)
    {
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.ajB().gAO.a(new f(this.aQj, 6, this.zZB.yZf, str, i, j, j, this.yXF.dYU().dYn(), this.yXF.dYU().dYo(), (String)localObject), 0);
      if (this.AqP != 0)
      {
        j = this.zZB.yZm.zao;
        i = j;
        if (this.lQV)
        {
          i = j;
          if (this.zZB.yZm.zas != 0L) {
            i = j + (int)(bt.aO(this.zZB.yZm.zas) / 1000L);
          }
        }
        localObject = new com.tencent.mm.modelstat.i(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + bt.aQJ() + "," + this.AqO + "," + this.AqM, (int)bt.aQJ());
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajB().gAO.a((n)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
      AppMethodBeat.o(99795);
      return;
      i = this.yXF.dYV();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99797);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ad.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
    Rn(i);
    if ((this.AqK != null) && (this.AqK.isPlaying())) {
      this.AqK.pause();
    }
    if (this.AqK != null)
    {
      ad.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.AqK.onDetach();
    }
    ag.dTZ().zfL.remove(this);
    ag.dTZ().b(this);
    if (this.zZB != null) {
      this.zZB.imX = bt.HI();
    }
    AppMethodBeat.o(99797);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99798);
    super.onResume();
    ag.dTZ().zfL.add(this);
    ag.dTZ().a(this);
    if (this.zZB != null) {
      this.zZB.onResume();
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