package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ae.n.a;
import com.tencent.mm.ah.p;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.ai.a.c;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.a.b.j.a;
import com.tencent.mm.plugin.sns.a.b.j.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class VideoAdPlayerUI
  extends MMActivity
  implements b.a, b.b
{
  private String bUi = "";
  private String bYN;
  private String bssid;
  private String dSS = "";
  private String dST = "";
  private String erh = "";
  private String fVM = "";
  private com.tencent.mm.model.d gEB;
  private boolean isPlaying = false;
  private String oDg = "";
  private com.tencent.mm.plugin.sns.storage.n oUH;
  private boolean omL = false;
  private h pdc = new h("VideoAdPlayerUI");
  private VideoPlayView pkA;
  private com.tencent.mm.modelsns.b pkB = null;
  private String pkC = "";
  private int pkD = 0;
  private String pkE = "";
  public String pkF = "";
  public String pkG = "";
  private int pkH = 0;
  private int pkI = 0;
  private String pkJ = "";
  private String pkK;
  private String pkL = "";
  private long pkM = 0L;
  private int pkN = 0;
  private int pkO = 0;
  private boolean pkP = false;
  private boolean pkQ = false;
  private awd pkR = null;
  private String pkS;
  private int pkT;
  private String[] pkU = null;
  private String[] pkV = null;
  private String ssid;
  private String thumbPath = "";
  private String thumbUrl = "";
  private String url = "";
  
  private void yO(int paramInt)
  {
    if (!this.omL) {
      return;
    }
    this.pdc.xx(this.pkA.getDuration());
    this.pdc.olx.omz = bk.UZ();
    com.tencent.mm.plugin.sns.a.b.a.a locala = this.pdc.olx;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      locala.omy = paramInt;
      this.pdc.olx.omx = 2;
      y.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.pdc.olx.omy);
      return;
    }
  }
  
  public final void Ni(String paramString) {}
  
  public final void bCt() {}
  
  public final void ba(String paramString, boolean paramBoolean) {}
  
  public final void bb(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.VideoPlayerUI", "onSightFinish " + paramString);
    this.pkA.setIsDownloading(false);
    this.pkA.setVideoPath(this.erh);
    this.pkA.x(this.pkA.getLastProgresstime());
    this.pkA.setLoop(false);
    if ((this.omL) && (!bk.bl(paramString)) && (this.pkR != null) && (paramString.equals(this.pkR.lsK)) && (com.tencent.mm.vfs.e.bK(this.erh))) {
      this.pdc.olp = 1;
    }
  }
  
  public final void eG(String paramString1, String paramString2)
  {
    y.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.pkA.isPlaying());
    if (this.pkA.isPlaying()) {
      return;
    }
    this.pkA.setLoop(false);
    if (paramString2.equals(this.pkA.getVideoPath()))
    {
      this.pkA.x(this.pkA.getLastProgresstime());
      this.pkA.start();
      y.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      return;
    }
    this.pkA.setVideoPath(paramString2);
    this.pkA.x(this.pkA.getLastProgresstime());
    y.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + paramString1 + " path: " + paramString2);
  }
  
  public void finish()
  {
    if (this.isPlaying) {
      this.pkA.pause();
    }
    if ((this.pdc != null) && (this.oDg != null) && (this.oDg.length() > 0))
    {
      this.pdc.bCg();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.oDg);
      localIntent.putExtra("KStreamVideoPlayCount", this.pdc.olt);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.pdc.olu);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.pdc.olv);
      setResult(-1, localIntent);
    }
    super.finish();
  }
  
  protected final int getForceOrientation()
  {
    if (this.pkQ) {
      return 0;
    }
    return 4;
  }
  
  protected final int getLayoutId()
  {
    return i.g.video_player_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[] { Integer.valueOf(paramInt1) });
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bk.G(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          y.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[] { str2 });
          Object localObject2 = new g.a();
          ((g.a)localObject2).title = this.pkE;
          ((g.a)localObject2).type = 4;
          label157:
          label179:
          int j;
          label292:
          label593:
          String str3;
          int k;
          String str4;
          String str5;
          String str6;
          long l;
          int m;
          int n;
          if (!bk.bl(this.pkR.kSC))
          {
            ((g.a)localObject2).url = this.pkR.kSC;
            if (!bk.bl(this.pkR.trZ)) {
              break label710;
            }
            localObject1 = this.pkR.trP;
            ((g.a)localObject2).thumburl = ((String)localObject1);
            ((g.a)localObject2).dSP = this.pkR.trW;
            ((g.a)localObject2).dSQ = this.pkR.pkD;
            ((g.a)localObject2).dSR = this.pkE;
            ((g.a)localObject2).dST = this.dST;
            ((g.a)localObject2).dSS = this.dSS;
            ((g.a)localObject2).dSU = this.thumbUrl;
            ((g.a)localObject2).dSV = this.pkF;
            ((g.a)localObject2).dSW = this.pkG;
            ((g.a)localObject2).bYN = this.bYN;
            localObject1 = com.tencent.mm.vfs.e.c(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label722;
            }
            i = 0;
            y.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (n.a.Fn() != null) {
              n.a.Fn().a((g.a)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.pkT != 0)
            {
              j = this.pdc.olx.omv;
              i = j;
              if (this.isPlaying)
              {
                i = j;
                if (this.pdc.olx.omz != 0L) {
                  i = j + (int)(bk.cp(this.pdc.olx.omz) / 1000L);
                }
              }
              localObject1 = new com.tencent.mm.modelstat.i(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + bk.UX() + "," + this.pkS + "," + this.pkD, (int)bk.UX());
              com.tencent.mm.kernel.g.DQ();
              com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.g.bhI().dO(str1, str2);
            if (this.omL) {
              com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, this.oUH.field_snsId, 12, 0));
            }
            if (this.pkI == 0) {
              continue;
            }
            boolean bool = com.tencent.mm.model.s.fn(str2);
            if (!bool) {
              break label730;
            }
            localObject1 = j.c.omg;
            localObject2 = this.pkG;
            str3 = this.pkF;
            j = this.pkH;
            k = this.pkI;
            str4 = this.pkJ;
            str5 = this.pkK;
            str6 = this.pkL;
            l = this.pkM;
            m = this.pkN;
            n = this.pkO;
            if (!bool) {
              break label738;
            }
          }
          label710:
          label722:
          label730:
          label738:
          for (int i = com.tencent.mm.model.m.gM(str2);; i = 0)
          {
            j.a((j.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((g.a)localObject2).url = this.pkR.trW;
            break label157;
            localObject1 = this.pkR.trZ;
            break label179;
            i = localObject1.length;
            break label292;
            localObject1 = j.c.omf;
            break label593;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.h(this, getString(i.j.has_send));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.pkI != 0) {
        j.a(j.c.omh, this.pkG, this.pkF, this.pkH, this.pkI, this.pkJ, this.pkK, this.pkL, this.pkM, this.pkN, this.pkO, 0);
      }
      if (-1 != paramInt2) {
        break label892;
      }
      if (this.omL) {
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, this.oUH.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (!this.omL) {
        break;
      }
      com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, this.oUH.field_snsId, 13, 0));
      break;
      label892:
      if (this.omL) {
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, this.oUH.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.pkA;
    y.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.ogu);
    if (localVideoPlayView.ogu != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label107;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.ogu = paramConfiguration.orientation;
      if (localVideoPlayView.ogu == 2) {
        localVideoPlayView.hoY.setVisibility(8);
      }
      yO(paramConfiguration.orientation);
      return;
      label107:
      localVideoPlayView.update(2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    getWindow().setFlags(1024, 1024);
    this.pkU = new String[] { getString(i.j.sns_ad_video_right_menu_send_friend), getString(i.j.sns_ad_video_right_menu_share_sns), getString(i.j.sns_ad_video_right_menu_fav) };
    this.pkV = new String[] { getString(i.j.sns_ad_video_right_menu_send_friend), getString(i.j.sns_ad_video_right_menu_share_sns) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.oUH = af.bDF().OA(com.tencent.mm.plugin.sns.data.i.Ng(paramBundle));
    this.gEB = new com.tencent.mm.model.d();
    this.pkB = com.tencent.mm.modelsns.b.i(getIntent());
    this.erh = getIntent().getStringExtra("KFullVideoPath");
    this.pkC = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.bUi = getIntent().getStringExtra("KMediaId");
    this.omL = getIntent().getBooleanExtra("IsAd", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.pkE = bk.aM(getIntent().getStringExtra("KMediaTitle"), "");
    this.pkD = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.pkP = getIntent().getBooleanExtra("KBlockFav", false);
    this.pkQ = getIntent().getBooleanExtra("ForceLandscape", false);
    this.dSS = getIntent().getStringExtra("StreamWording");
    this.dST = getIntent().getStringExtra("StremWebUrl");
    this.oDg = getIntent().getStringExtra("KComponentCid");
    this.pkF = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.pkG = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.pkH = getIntent().getIntExtra("KSta_SourceType", 0);
    this.pkI = getIntent().getIntExtra("KSta_Scene", 0);
    this.pkJ = getIntent().getStringExtra("KSta_FromUserName");
    this.pkK = getIntent().getStringExtra("KSta_ChatName");
    this.pkL = getIntent().getStringExtra("KSta_SnSId");
    this.pkM = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.pkN = getIntent().getIntExtra("KSta_FavID", 0);
    this.pkO = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.bYN = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.fVM = bk.aM(getIntent().getStringExtra("KViewId"), "");
    this.pkS = bk.aM(getIntent().getStringExtra("ReportArgs"), "");
    this.pkT = getIntent().getIntExtra("NeedReportData", 0);
    if (this.pkT != 0)
    {
      paramBundle = ((WifiManager)getSystemService("wifi")).getConnectionInfo();
      this.ssid = paramBundle.getSSID();
      this.bssid = paramBundle.getBSSID();
    }
    this.pkR = new awd();
    this.pkR.trP = this.thumbUrl;
    this.pkR.trW = this.pkC;
    this.pkR.lsK = this.bUi;
    this.pkR.kSC = this.url;
    this.pkR.trO = 1;
    this.pkR.pkD = this.pkD;
    this.pdc.olr = bk.UZ();
    y.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.pkR.lsK + " attachurl:" + this.pkR.trW + " videoattachTotalTime:" + this.pkR.pkD + " streamvideowording: " + this.dSS + " streamvideoweburl: " + this.dST + " mediaTitle: " + this.pkE + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.pkF + " streamvideopublishid " + this.pkG);
    Object localObject1;
    if (bk.bl(this.erh))
    {
      paramBundle = an.eJ(af.getAccSnsPath(), this.pkR.lsK);
      localObject1 = com.tencent.mm.plugin.sns.data.i.k(this.pkR);
      this.erh = (paramBundle + (String)localObject1);
    }
    if ((bk.bl(this.thumbPath)) || (!com.tencent.mm.vfs.e.bK(this.thumbPath)))
    {
      paramBundle = "attach" + this.pkR.lsK;
      localObject1 = an.eJ(af.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + com.tencent.mm.plugin.sns.data.i.MR(paramBundle));
    }
    if (!com.tencent.mm.vfs.e.bK(this.thumbPath)) {}
    try
    {
      paramBundle = new awd();
      paramBundle.aH(this.pkR.toByteArray());
      paramBundle.lsK = ("attach" + paramBundle.lsK);
      localObject1 = new com.tencent.mm.plugin.sns.data.e(this.pkR);
      ((com.tencent.mm.plugin.sns.data.e)localObject1).omU = 1;
      ((com.tencent.mm.plugin.sns.data.e)localObject1).lJQ = this.pkR.lsK;
      af.bDA().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.e)localObject1, az.uBK);
      getWindow().addFlags(128);
      this.pkA = ((VideoPlayView)findViewById(i.f.video_play_view));
      paramBundle = this.pkA;
      localObject1 = new AdVideoPlayerLoadingBar(this.mController.uMN);
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(a.c.NoPadding);
      paramBundle.ogf = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.iuC.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.ogf, (ViewGroup.LayoutParams)localObject2);
      paramBundle.ogf.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.ogf.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.ogf.setIsPlay(paramBundle.iuC.isPlaying());
      if (paramBundle.ogf != null) {
        ((View)paramBundle.ogf).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.pkA.setVideoPlayViewEvent(new VideoAdPlayerUI.1(this));
      this.pkA.setVideoTotalTime(this.pkR.pkD);
      if (com.tencent.mm.vfs.e.bK(this.erh))
      {
        this.pdc.olp = 1;
        this.pkA.setVideoPath(this.erh);
        this.pkA.setLeftButtonOnClickListener(new VideoAdPlayerUI.2(this));
        this.pkA.setRightButtonOnCliclListener(new VideoAdPlayerUI.3(this));
        paramBundle = this.pkA;
        localObject1 = this.dSS;
        localObject2 = new VideoAdPlayerUI.4(this);
        paramBundle.ogi = ((String)localObject1);
        paramBundle.ogh.setText((CharSequence)localObject1);
        paramBundle.ogh.setOnClickListener((View.OnClickListener)localObject2);
        this.pkA.bBq();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.pkA;
          if (paramBundle.ogk != null)
          {
            paramBundle.ogl = false;
            paramBundle.ogk.setVisibility(8);
          }
        }
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        y.e("MicroMsg.VideoPlayerUI", "error for download thumb");
        continue;
        this.pkA.bBo();
        this.pkA.setIsDownloading(true);
        af.bDA().a(this.pkR, 6, null, az.uBK);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.pkI != 0) {
      j.a(j.a.olU, this.pkG, this.pkF, this.pkH, this.pkI, this.pkJ, this.pkK, this.pkL, this.pkM, this.pkN, this.pkO);
    }
    if (this.omL) {
      if (this.oUH != null) {
        break label443;
      }
    }
    label443:
    for (int i = 0;; i = this.oUH.bGO())
    {
      Object localObject;
      int j;
      if (this.oUH != null)
      {
        localObject = this.pdc.bCf();
        long l2 = this.pdc.olq - this.pdc.eAG;
        long l1 = l2;
        if (l2 < 0L)
        {
          y.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.pdc.olq), Long.valueOf(this.pdc.eAG) });
          l1 = this.pdc.olq;
        }
        j = (int)l1;
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a(new com.tencent.mm.plugin.sns.a.b.d(this.fVM, 6, 2, this.pdc.olq, null, null, 2, (String)localObject, -1, i, j, j, 0, this.oUH.bGN().bGg(), this.oUH.bGN().bGh()), 0);
      }
      if (this.pkT != 0)
      {
        j = this.pdc.olx.omv;
        i = j;
        if (this.isPlaying)
        {
          i = j;
          if (this.pdc.olx.omz != 0L) {
            i = j + (int)(bk.cp(this.pdc.olx.omz) / 1000L);
          }
        }
        localObject = new com.tencent.mm.modelstat.i(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + bk.UX() + "," + this.pkS + "," + this.pkD, (int)bk.UX());
        com.tencent.mm.kernel.g.DQ();
        com.tencent.mm.kernel.g.DO().dJT.a((com.tencent.mm.ah.m)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", czu()));
      return;
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    y.i("MicroMsg.VideoPlayerUI", "onpause  " + i);
    yO(i);
    if ((this.pkA != null) && (this.pkA.isPlaying())) {
      this.pkA.pause();
    }
    if (this.pkA != null)
    {
      y.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.pkA.onDetach();
    }
    af.bDA().ooJ.remove(this);
    af.bDA().b(this);
    if (this.pdc != null) {
      this.pdc.eAF = bk.UZ();
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    af.bDA().ooJ.add(this);
    af.bDA().a(this);
    if (this.pdc != null) {
      this.pdc.onResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI
 * JD-Core Version:    0.7.0.1
 */