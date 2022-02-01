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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.ag.w;
import com.tencent.mm.ag.w.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.modelstat.i;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.ad.g.l;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.ad.g.o.a;
import com.tencent.mm.plugin.sns.ad.g.o.c;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.c.a;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.d;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class VideoAdPlayerUI
  extends MMActivity
  implements c.a, c.b
{
  private String DZi;
  private SnsInfo DsC;
  private VideoPlayView ERV;
  private k ERW;
  private int ERX;
  private cnb ERY;
  private String ERZ;
  private int ESa;
  private String[] ESb;
  private String[] ESc;
  private String EzJ;
  private boolean EzK;
  private boolean EzL;
  private String EzM;
  private l EzN;
  public String EzO;
  public String EzP;
  private int EzQ;
  private int EzR;
  private String EzS;
  private String EzT;
  private String EzU;
  private long EzV;
  private int EzW;
  private int EzX;
  private String bssid;
  private String ean;
  private String fullPath;
  private boolean gVd;
  private boolean isAd;
  private String izc;
  private String izd;
  private String mediaId;
  private com.tencent.mm.model.d pNk;
  private String ssid;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private String viewId;
  
  public VideoAdPlayerUI()
  {
    AppMethodBeat.i(99792);
    this.ERW = null;
    this.EzN = new l("VideoAdPlayerUI");
    this.fullPath = "";
    this.thumbPath = "";
    this.EzJ = "";
    this.url = "";
    this.thumbUrl = "";
    this.mediaId = "";
    this.isAd = false;
    this.ERX = 0;
    this.EzM = "";
    this.izc = "";
    this.izd = "";
    this.EzO = "";
    this.EzP = "";
    this.EzQ = 0;
    this.EzR = 0;
    this.EzS = "";
    this.EzU = "";
    this.EzV = 0L;
    this.EzW = 0;
    this.EzX = 0;
    this.DZi = "";
    this.viewId = "";
    this.EzL = false;
    this.EzK = false;
    this.ERY = null;
    this.gVd = false;
    this.ESb = null;
    this.ESc = null;
    AppMethodBeat.o(99792);
  }
  
  private void ZQ(int paramInt)
  {
    AppMethodBeat.i(99802);
    if (!this.isAd)
    {
      AppMethodBeat.o(99802);
      return;
    }
    this.EzN.XK(this.ERV.getDuration());
    this.EzN.DvW.Dxc = Util.currentTicks();
    com.tencent.mm.plugin.sns.ad.g.a.a locala = this.EzN.DvW;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      locala.Dxb = paramInt;
      this.EzN.DvW.Dxa = 2;
      Log.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.EzN.DvW.Dxb);
      AppMethodBeat.o(99802);
      return;
    }
  }
  
  public final void aOG(String paramString) {}
  
  public final void ci(String paramString, boolean paramBoolean) {}
  
  public final void cj(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99800);
    Log.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    this.ERV.setIsDownloading(false);
    this.ERV.setVideoPath(this.fullPath);
    this.ERV.q(this.ERV.getLastProgresstime());
    this.ERV.setLoop(false);
    if ((this.isAd) && (!Util.isNullOrNil(paramString)) && (this.ERY != null) && (paramString.equals(this.ERY.Id)) && (s.YS(this.fullPath))) {
      this.EzN.DvO = 1;
    }
    AppMethodBeat.o(99800);
  }
  
  public final void eZJ() {}
  
  public void finish()
  {
    AppMethodBeat.i(99796);
    if (this.gVd) {
      this.ERV.pause();
    }
    if ((this.EzN != null) && (this.DZi != null) && (this.DZi.length() > 0))
    {
      this.EzN.eXs();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.DZi);
      localIntent.putExtra("KStreamVideoPlayCount", this.EzN.DvS);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.EzN.DvT);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.EzN.DvU);
      setResult(-1, localIntent);
    }
    super.finish();
    AppMethodBeat.o(99796);
  }
  
  public int getForceOrientation()
  {
    if (this.EzK) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2131496803;
  }
  
  public final void ke(String paramString1, String paramString2)
  {
    AppMethodBeat.i(99799);
    Log.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.ERV.isPlaying());
    if (this.ERV.isPlaying())
    {
      AppMethodBeat.o(99799);
      return;
    }
    this.ERV.setLoop(false);
    if (paramString2.equals(this.ERV.getVideoPath()))
    {
      this.ERV.q(this.ERV.getLastProgresstime());
      this.ERV.start();
      Log.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      AppMethodBeat.o(99799);
      return;
    }
    this.ERV.setVideoPath(paramString2);
    this.ERV.q(this.ERV.getLastProgresstime());
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
          ((k.b)localObject2).title = this.EzM;
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
          if (!Util.isNullOrNil(this.ERY.Url))
          {
            ((k.b)localObject2).url = this.ERY.Url;
            if (!Util.isNullOrNil(this.ERY.MsI)) {
              break label713;
            }
            localObject1 = this.ERY.Msz;
            ((k.b)localObject2).thumburl = ((String)localObject1);
            ((k.b)localObject2).iyZ = this.ERY.MsF;
            ((k.b)localObject2).iza = this.ERY.ERX;
            ((k.b)localObject2).izb = this.EzM;
            ((k.b)localObject2).izd = this.izd;
            ((k.b)localObject2).izc = this.izc;
            ((k.b)localObject2).ize = this.thumbUrl;
            ((k.b)localObject2).izf = this.EzO;
            ((k.b)localObject2).izg = this.EzP;
            ((k.b)localObject2).ean = this.ean;
            localObject1 = s.aW(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label725;
            }
            i = 0;
            Log.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.aSz() != null) {
              w.a.aSz().a((k.b)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.ESa != 0)
            {
              j = this.EzN.DvW.DwY;
              i = j;
              if (this.gVd)
              {
                i = j;
                if (this.EzN.DvW.Dxc != 0L) {
                  i = j + (int)(Util.ticksToNow(this.EzN.DvW.Dxc) / 1000L);
                }
              }
              localObject1 = new i(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + Util.nowSecond() + "," + this.ERZ + "," + this.ERX, (int)Util.nowSecond());
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.g.eir().iF(str1, str2);
            if (this.isAd) {
              r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 12, 0));
            }
            if (this.EzR == 0) {
              continue;
            }
            boolean bool = ab.Eq(str2);
            if (!bool) {
              break label733;
            }
            localObject1 = o.c.DwJ;
            localObject2 = this.EzP;
            str3 = this.EzO;
            j = this.EzQ;
            k = this.EzR;
            str4 = this.EzS;
            str5 = this.EzT;
            str6 = this.EzU;
            l = this.EzV;
            m = this.EzW;
            n = this.EzX;
            if (!bool) {
              break label741;
            }
          }
          label713:
          label725:
          label733:
          label741:
          for (int i = v.Ie(str2);; i = 0)
          {
            o.a((o.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject2).url = this.ERY.MsF;
            break label161;
            localObject1 = this.ERY.MsI;
            break label183;
            i = localObject1.length;
            break label296;
            localObject1 = o.c.DwI;
            break label596;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131761619));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.EzR != 0) {
        o.a(o.c.DwK, this.EzP, this.EzO, this.EzQ, this.EzR, this.EzS, this.EzT, this.EzU, this.EzV, this.EzW, this.EzX, 0);
      }
      if (-1 != paramInt2) {
        break label901;
      }
      if (this.isAd) {
        r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 15, 0));
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
      r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 13, 0));
      break;
      label901:
      if (this.isAd) {
        r.a(new SnsAdClick(0, 6, this.DsC.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99801);
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.ERV;
    Log.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.Doi);
    if (localVideoPlayView.Doi != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label119;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.Doi = paramConfiguration.orientation;
      if (localVideoPlayView.Doi == 2) {
        localVideoPlayView.maskView.setVisibility(8);
      }
      ZQ(paramConfiguration.orientation);
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
    if (ao.aQ(getContext())) {
      getController().setActionbarColor(getResources().getColor(2131099891));
    }
    this.ESb = new String[] { getString(2131765992), getString(2131765993), getString(2131765990) };
    this.ESc = new String[] { getString(2131765992), getString(2131765993) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.DsC = aj.faO().aQl(r.aOw(paramBundle));
    this.pNk = new com.tencent.mm.model.d();
    this.ERW = k.w(getIntent());
    this.fullPath = getIntent().getStringExtra("KFullVideoPath");
    this.EzJ = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.isAd = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.EzM = Util.nullAs(getIntent().getStringExtra("KMediaTitle"), "");
    this.ERX = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.EzL = getIntent().getBooleanExtra("KBlockFav", false);
    this.EzK = getIntent().getBooleanExtra("ForceLandscape", false);
    this.izc = getIntent().getStringExtra("StreamWording");
    this.izd = getIntent().getStringExtra("StremWebUrl");
    this.DZi = getIntent().getStringExtra("KComponentCid");
    this.EzO = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.EzP = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.EzQ = getIntent().getIntExtra("KSta_SourceType", 0);
    this.EzR = getIntent().getIntExtra("KSta_Scene", 0);
    this.EzS = getIntent().getStringExtra("KSta_FromUserName");
    this.EzT = getIntent().getStringExtra("KSta_ChatName");
    this.EzU = getIntent().getStringExtra("KSta_SnSId");
    this.EzV = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.EzW = getIntent().getIntExtra("KSta_FavID", 0);
    this.EzX = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.ean = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.viewId = Util.nullAs(getIntent().getStringExtra("KViewId"), "");
    this.ERZ = Util.nullAs(getIntent().getStringExtra("ReportArgs"), "");
    this.ESa = getIntent().getIntExtra("NeedReportData", 0);
    if (this.ESa != 0)
    {
      this.ssid = NetStatusUtil.getConnectedWifiSsid(MMApplicationContext.getContext());
      this.bssid = NetStatusUtil.getConnectedWifiBssid(MMApplicationContext.getContext());
    }
    this.ERY = new cnb();
    this.ERY.Msz = this.thumbUrl;
    this.ERY.MsF = this.EzJ;
    this.ERY.Id = this.mediaId;
    this.ERY.Url = this.url;
    this.ERY.Mcw = 1;
    this.ERY.ERX = this.ERX;
    this.EzN.DvQ = Util.currentTicks();
    Log.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.ERY.Id + " attachurl:" + this.ERY.MsF + " videoattachTotalTime:" + this.ERY.ERX + " streamvideowording: " + this.izc + " streamvideoweburl: " + this.izd + " mediaTitle: " + this.EzM + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.EzO + " streamvideopublishid " + this.EzP);
    Object localObject1;
    if (Util.isNullOrNil(this.fullPath))
    {
      paramBundle = ar.ki(aj.getAccSnsPath(), this.ERY.Id);
      localObject1 = r.k(this.ERY);
      this.fullPath = (paramBundle + (String)localObject1);
    }
    if ((Util.isNullOrNil(this.thumbPath)) || (!s.YS(this.thumbPath)))
    {
      paramBundle = "attach" + this.ERY.Id;
      localObject1 = ar.ki(aj.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + r.aOf(paramBundle));
    }
    if (!s.YS(this.thumbPath)) {}
    try
    {
      paramBundle = new cnb();
      paramBundle.parseFrom(this.ERY.toByteArray());
      paramBundle.Id = ("attach" + paramBundle.Id);
      localObject1 = new com.tencent.mm.plugin.sns.data.n(this.ERY);
      ((com.tencent.mm.plugin.sns.data.n)localObject1).DEs = 1;
      ((com.tencent.mm.plugin.sns.data.n)localObject1).dPI = this.ERY.Id;
      aj.faJ().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.n)localObject1, bp.Oqt);
      getWindow().addFlags(128);
      this.ERV = ((VideoPlayView)findViewById(2131309799));
      paramBundle = this.ERV;
      localObject1 = new AdVideoPlayerLoadingBar(getContext());
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(2131165524);
      paramBundle.DnU = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.qbJ.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.DnU, (ViewGroup.LayoutParams)localObject2);
      paramBundle.DnU.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.DnU.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.DnU.setIsPlay(paramBundle.qbJ.isPlaying());
      if (paramBundle.DnU != null) {
        ((View)paramBundle.DnU).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.ERV.setVideoPlayViewEvent(new VideoPlayView.a()
      {
        public final void XH(int paramAnonymousInt)
        {
          AppMethodBeat.i(99786);
          if (VideoAdPlayerUI.i(VideoAdPlayerUI.this) == 0)
          {
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, paramAnonymousInt);
            VideoAdPlayerUI.j(VideoAdPlayerUI.this).ERX = paramAnonymousInt;
          }
          AppMethodBeat.o(99786);
        }
        
        public final void eVQ()
        {
          AppMethodBeat.i(99783);
          VideoAdPlayerUI.d(VideoAdPlayerUI.this).fp(false);
          com.tencent.mm.plugin.sns.ad.g.a.a locala = VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW;
          locala.DwY += (int)Util.ticksToNow(VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW.Dxc);
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          AppMethodBeat.o(99783);
        }
        
        public final void eVR()
        {
          AppMethodBeat.i(99784);
          Log.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
          Object localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW;
          ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).DwX += 1;
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
          {
            localObject = new i(13227, "1,2," + VideoAdPlayerUI.i(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject, 0);
          }
          AppMethodBeat.o(99784);
        }
        
        public final void eVS()
        {
          AppMethodBeat.i(99785);
          Log.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          VideoAdPlayerUI.c(VideoAdPlayerUI.this).eVN();
          AppMethodBeat.o(99785);
        }
        
        public final void uG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99782);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW;
            if (VideoAdPlayerUI.this.getResources().getConfiguration().orientation != 2) {
              break label301;
            }
          }
          label301:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).Dxb = i;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW.Dxc = Util.currentTicks();
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW.Dxa = 2;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW.DwY = 0;
            if ((!VideoAdPlayerUI.b(VideoAdPlayerUI.this)) && ((int)VideoAdPlayerUI.c(VideoAdPlayerUI.this).getLastProgresstime() == 0))
            {
              localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW;
              ((com.tencent.mm.plugin.sns.ad.g.a.a)localObject).DwW += 1;
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW.Dxc = Util.currentTicks();
            VideoAdPlayerUI.d(VideoAdPlayerUI.this).a(VideoAdPlayerUI.c(VideoAdPlayerUI.this));
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              localObject = new i(13227, "1,1,0," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject, 0);
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, true);
            AppMethodBeat.o(99782);
            return;
          }
        }
      });
      this.ERV.setVideoTotalTime(this.ERY.ERX);
      if (s.YS(this.fullPath))
      {
        this.EzN.DvO = 1;
        this.ERV.setVideoPath(this.fullPath);
        this.ERV.setLeftButtonOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99787);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            VideoAdPlayerUI.this.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99787);
          }
        });
        this.ERV.setRightButtonOnCliclListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99789);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            localObject = VideoAdPlayerUI.this;
            if (VideoAdPlayerUI.k(VideoAdPlayerUI.this)) {}
            for (paramAnonymousView = VideoAdPlayerUI.l(VideoAdPlayerUI.this);; paramAnonymousView = VideoAdPlayerUI.m(VideoAdPlayerUI.this))
            {
              h.a((Context)localObject, null, paramAnonymousView, null, new h.d()
              {
                public final void oj(int paramAnonymous2Int)
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
                    com.tencent.mm.br.c.c(VideoAdPlayerUI.this, ".ui.transmit.SelectConversationUI", localIntent, 4097);
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
        paramBundle = this.ERV;
        localObject1 = this.izc;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99791);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
            if (VideoAdPlayerUI.q(VideoAdPlayerUI.this) != 0) {
              o.a(o.a.Dwv, VideoAdPlayerUI.this.EzP, VideoAdPlayerUI.this.EzO, VideoAdPlayerUI.r(VideoAdPlayerUI.this), VideoAdPlayerUI.q(VideoAdPlayerUI.this), VideoAdPlayerUI.s(VideoAdPlayerUI.this), VideoAdPlayerUI.t(VideoAdPlayerUI.this), VideoAdPlayerUI.u(VideoAdPlayerUI.this), VideoAdPlayerUI.v(VideoAdPlayerUI.this), VideoAdPlayerUI.w(VideoAdPlayerUI.this), VideoAdPlayerUI.x(VideoAdPlayerUI.this));
            }
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              int j = VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW.DwY;
              int i = j;
              if (VideoAdPlayerUI.b(VideoAdPlayerUI.this))
              {
                i = j;
                if (VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW.Dxc != 0L) {
                  i = j + (int)(Util.ticksToNow(VideoAdPlayerUI.a(VideoAdPlayerUI.this).DvW.Dxc) / 1000L);
                }
              }
              paramAnonymousView = new i(13228, "1,1," + i + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAg().hqi.a(paramAnonymousView, 0);
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
              if (!TextUtils.isEmpty(VideoAdPlayerUI.this.EzO)) {
                paramAnonymousView = r.kb((String)localObject, VideoAdPlayerUI.this.EzO);
              }
            }
            localIntent.putExtra("jsapiargs", localBundle);
            localIntent.putExtra("rawUrl", paramAnonymousView);
            localIntent.putExtra("useJs", true);
            if (VideoAdPlayerUI.A(VideoAdPlayerUI.this)) {
              r.a(new SnsAdClick(0, 6, VideoAdPlayerUI.B(VideoAdPlayerUI.this).field_snsId, 18, 0));
            }
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99790);
                com.tencent.mm.plugin.sns.c.a.jRt.i(localIntent, VideoAdPlayerUI.this);
                AppMethodBeat.o(99790);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99791);
          }
        };
        paramBundle.DnX = ((String)localObject1);
        paramBundle.DnW.setText((CharSequence)localObject1);
        paramBundle.DnW.setOnClickListener((View.OnClickListener)localObject2);
        this.ERV.eVP();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.ERV;
          if (paramBundle.DnY != null)
          {
            paramBundle.DnZ = false;
            paramBundle.DnY.setVisibility(8);
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
        this.ERV.eVN();
        this.ERV.setIsDownloading(true);
        aj.faJ().a(this.ERY, 6, null, bp.Oqt);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99795);
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.EzR != 0) {
      o.a(o.a.Dwx, this.EzP, this.EzO, this.EzQ, this.EzR, this.EzS, this.EzT, this.EzU, this.EzV, this.EzW, this.EzX);
    }
    int i;
    String str;
    int j;
    if (this.isAd)
    {
      if (this.DsC != null) {
        break label468;
      }
      i = 0;
      if (this.DsC != null)
      {
        str = this.EzN.eXr();
        long l2 = this.EzN.DvP - this.EzN.jkZ;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.EzN.DvP), Long.valueOf(this.EzN.jkZ) });
          l1 = this.EzN.DvP;
        }
        j = (int)l1;
        localObject = this.DsC.getAdInfo();
        if (localObject != null) {
          break label479;
        }
      }
    }
    label468:
    label479:
    for (Object localObject = "";; localObject = ((ADInfo)localObject).waidPkg)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(new com.tencent.mm.plugin.sns.ad.g.g(this.viewId, 6, this.EzN.DvP, str, i, j, j, this.DsC.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), this.DsC.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), (String)localObject), 0);
      if (this.ESa != 0)
      {
        j = this.EzN.DvW.DwY;
        i = j;
        if (this.gVd)
        {
          i = j;
          if (this.EzN.DvW.Dxc != 0L) {
            i = j + (int)(Util.ticksToNow(this.EzN.DvW.Dxc) / 1000L);
          }
        }
        localObject = new i(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + Util.nowSecond() + "," + this.ERZ + "," + this.ERX, (int)Util.nowSecond());
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a((q)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
      AppMethodBeat.o(99795);
      return;
      i = this.DsC.getAdRecSrc();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99797);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    Log.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
    ZQ(i);
    if ((this.ERV != null) && (this.ERV.isPlaying())) {
      this.ERV.pause();
    }
    if (this.ERV != null)
    {
      Log.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.ERV.onDetach();
    }
    aj.faJ().DGK.remove(this);
    aj.faJ().b(this);
    if (this.EzN != null) {
      this.EzN.jkY = Util.currentTicks();
    }
    AppMethodBeat.o(99797);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99798);
    super.onResume();
    aj.faJ().DGK.add(this);
    aj.faJ().a(this);
    if (this.EzN != null) {
      this.EzN.onResume();
    }
    AppMethodBeat.o(99798);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI
 * JD-Core Version:    0.7.0.1
 */