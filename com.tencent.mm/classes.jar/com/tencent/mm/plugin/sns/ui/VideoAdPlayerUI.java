package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.af.r;
import com.tencent.mm.af.r.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.t;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sns.a.b.h;
import com.tencent.mm.plugin.sns.a.b.k;
import com.tencent.mm.plugin.sns.a.b.k.a;
import com.tencent.mm.plugin.sns.a.b.k.c;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.b.a;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.o;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.q;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class VideoAdPlayerUI
  extends MMActivity
  implements b.a, b.b
{
  private String bssid;
  private String cBO;
  private String cGU;
  private String eNO;
  private String fiR;
  private String fiS;
  private String hpq;
  private com.tencent.mm.model.d idF;
  private boolean isPlaying;
  private com.tencent.mm.plugin.sns.storage.n rMD;
  public String rNA;
  private int rNB;
  private int rNC;
  private String rND;
  private String rNE;
  private String rNF;
  private long rNG;
  private int rNH;
  private int rNI;
  private String rNu;
  private boolean rNv;
  private boolean rNw;
  private String rNx;
  private h rNy;
  public String rNz;
  private boolean raZ;
  private String rsI;
  private VideoPlayView sdd;
  private com.tencent.mm.modelsns.b sde;
  private int sdf;
  private bcs sdg;
  private String sdh;
  private int sdi;
  private String[] sdj;
  private String[] sdk;
  private String ssid;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  
  public VideoAdPlayerUI()
  {
    AppMethodBeat.i(39917);
    this.sde = null;
    this.rNy = new h("VideoAdPlayerUI");
    this.eNO = "";
    this.thumbPath = "";
    this.rNu = "";
    this.url = "";
    this.thumbUrl = "";
    this.cBO = "";
    this.raZ = false;
    this.sdf = 0;
    this.rNx = "";
    this.fiR = "";
    this.fiS = "";
    this.rNz = "";
    this.rNA = "";
    this.rNB = 0;
    this.rNC = 0;
    this.rND = "";
    this.rNF = "";
    this.rNG = 0L;
    this.rNH = 0;
    this.rNI = 0;
    this.rsI = "";
    this.hpq = "";
    this.rNw = false;
    this.rNv = false;
    this.sdg = null;
    this.isPlaying = false;
    this.sdj = null;
    this.sdk = null;
    AppMethodBeat.o(39917);
  }
  
  private void EW(int paramInt)
  {
    AppMethodBeat.i(39927);
    if (!this.raZ)
    {
      AppMethodBeat.o(39927);
      return;
    }
    this.rNy.Dx(this.sdd.getDuration());
    this.rNy.qZJ.raN = bo.yB();
    com.tencent.mm.plugin.sns.a.b.a.a locala = this.rNy.qZJ;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      locala.raM = paramInt;
      this.rNy.qZJ.raL = 2;
      ab.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.rNy.qZJ.raM);
      AppMethodBeat.o(39927);
      return;
    }
  }
  
  public final void ZU(String paramString) {}
  
  public final void bp(String paramString, boolean paramBoolean) {}
  
  public final void bq(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(39925);
    ab.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    this.sdd.setIsDownloading(false);
    this.sdd.setVideoPath(this.eNO);
    this.sdd.A(this.sdd.getLastProgresstime());
    this.sdd.setLoop(false);
    if ((this.raZ) && (!bo.isNullOrNil(paramString)) && (this.sdg != null) && (paramString.equals(this.sdg.Id)) && (com.tencent.mm.vfs.e.cN(this.eNO))) {
      this.rNy.qZB = 1;
    }
    AppMethodBeat.o(39925);
  }
  
  public final void cnV() {}
  
  public void finish()
  {
    AppMethodBeat.i(39921);
    if (this.isPlaying) {
      this.sdd.pause();
    }
    if ((this.rNy != null) && (this.rsI != null) && (this.rsI.length() > 0))
    {
      this.rNy.cnG();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.rsI);
      localIntent.putExtra("KStreamVideoPlayCount", this.rNy.qZF);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.rNy.qZG);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.rNy.qZH);
      setResult(-1, localIntent);
    }
    super.finish();
    AppMethodBeat.o(39921);
  }
  
  public int getForceOrientation()
  {
    if (this.rNv) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return 2130971069;
  }
  
  public final void gi(String paramString1, String paramString2)
  {
    AppMethodBeat.i(39924);
    ab.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.sdd.isPlaying());
    if (this.sdd.isPlaying())
    {
      AppMethodBeat.o(39924);
      return;
    }
    this.sdd.setLoop(false);
    if (paramString2.equals(this.sdd.getVideoPath()))
    {
      this.sdd.A(this.sdd.getLastProgresstime());
      this.sdd.start();
      ab.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      AppMethodBeat.o(39924);
      return;
    }
    this.sdd.setVideoPath(paramString2);
    this.sdd.A(this.sdd.getLastProgresstime());
    ab.i("MicroMsg.VideoPlayerUI", "onSightProgresssetVideoPath " + paramString1 + " path: " + paramString2);
    AppMethodBeat.o(39924);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(39919);
    ab.i("MicroMsg.VideoPlayerUI", "onActivityResult %d", new Object[] { Integer.valueOf(paramInt1) });
    if (4097 == paramInt1)
    {
      if (-1 == paramInt2)
      {
        Object localObject1 = paramIntent.getStringExtra("Select_Conv_User");
        String str1 = paramIntent.getStringExtra("custom_send_text");
        Iterator localIterator = bo.P(((String)localObject1).split(",")).iterator();
        while (localIterator.hasNext())
        {
          String str2 = (String)localIterator.next();
          ab.i("MicroMsg.VideoPlayerUI", "send sight to %s", new Object[] { str2 });
          Object localObject2 = new j.b();
          ((j.b)localObject2).title = this.rNx;
          ((j.b)localObject2).type = 4;
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
          if (!bo.isNullOrNil(this.sdg.Url))
          {
            ((j.b)localObject2).url = this.sdg.Url;
            if (!bo.isNullOrNil(this.sdg.xsc)) {
              break label713;
            }
            localObject1 = this.sdg.xrS;
            ((j.b)localObject2).thumburl = ((String)localObject1);
            ((j.b)localObject2).fiO = this.sdg.xrZ;
            ((j.b)localObject2).fiP = this.sdg.sdf;
            ((j.b)localObject2).fiQ = this.rNx;
            ((j.b)localObject2).fiS = this.fiS;
            ((j.b)localObject2).fiR = this.fiR;
            ((j.b)localObject2).fiT = this.thumbUrl;
            ((j.b)localObject2).fiU = this.rNz;
            ((j.b)localObject2).fiV = this.rNA;
            ((j.b)localObject2).cGU = this.cGU;
            localObject1 = com.tencent.mm.vfs.e.i(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label725;
            }
            i = 0;
            ab.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (r.a.Yp() != null) {
              r.a.Yp().a((j.b)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.sdi != 0)
            {
              j = this.rNy.qZJ.raJ;
              i = j;
              if (this.isPlaying)
              {
                i = j;
                if (this.rNy.qZJ.raN != 0L) {
                  i = j + (int)(bo.av(this.rNy.qZJ.raN) / 1000L);
                }
              }
              localObject1 = new com.tencent.mm.modelstat.i(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + bo.aox() + "," + this.sdh + "," + this.sdf, (int)bo.aox());
              com.tencent.mm.kernel.g.RM();
              com.tencent.mm.kernel.g.RK().eHt.a((m)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.g.bPJ().fh(str1, str2);
            if (this.raZ) {
              com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, this.rMD.field_snsId, 12, 0));
            }
            if (this.rNC == 0) {
              continue;
            }
            boolean bool = t.lA(str2);
            if (!bool) {
              break label733;
            }
            localObject1 = k.c.rau;
            localObject2 = this.rNA;
            str3 = this.rNz;
            j = this.rNB;
            k = this.rNC;
            str4 = this.rND;
            str5 = this.rNE;
            str6 = this.rNF;
            l = this.rNG;
            m = this.rNH;
            n = this.rNI;
            if (!bool) {
              break label741;
            }
          }
          label713:
          label725:
          label733:
          label741:
          for (int i = com.tencent.mm.model.n.nv(str2);; i = 0)
          {
            k.a((k.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((j.b)localObject2).url = this.sdg.xrZ;
            break label161;
            localObject1 = this.sdg.xsc;
            break label183;
            i = localObject1.length;
            break label296;
            localObject1 = k.c.rat;
            break label596;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131300637));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.rNC != 0) {
        k.a(k.c.rav, this.rNA, this.rNz, this.rNB, this.rNC, this.rND, this.rNE, this.rNF, this.rNG, this.rNH, this.rNI, 0);
      }
      if (-1 != paramInt2) {
        break label901;
      }
      if (this.raZ) {
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, this.rMD.field_snsId, 15, 0));
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(39919);
      return;
      if (!this.raZ) {
        break;
      }
      com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, this.rMD.field_snsId, 13, 0));
      break;
      label901:
      if (this.raZ) {
        com.tencent.mm.plugin.sns.data.i.a(new SnsAdClick(0, 6, this.rMD.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(39926);
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.sdd;
    ab.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.qUJ);
    if (localVideoPlayView.qUJ != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label119;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.qUJ = paramConfiguration.orientation;
      if (localVideoPlayView.qUJ == 2) {
        localVideoPlayView.jbK.setVisibility(8);
      }
      EW(paramConfiguration.orientation);
      AppMethodBeat.o(39926);
      return;
      label119:
      localVideoPlayView.update(2);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(39918);
    super.onCreate(paramBundle);
    hideTitleView();
    if (af.hW(getContext())) {
      getController().setActionbarColor(getResources().getColor(2131689641));
    }
    this.sdj = new String[] { getString(2131303767), getString(2131303768), getString(2131303766) };
    this.sdk = new String[] { getString(2131303767), getString(2131303768) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.rMD = ag.cpf().abu(com.tencent.mm.plugin.sns.data.i.ZN(paramBundle));
    this.idF = new com.tencent.mm.model.d();
    this.sde = com.tencent.mm.modelsns.b.w(getIntent());
    this.eNO = getIntent().getStringExtra("KFullVideoPath");
    this.rNu = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.cBO = getIntent().getStringExtra("KMediaId");
    this.raZ = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.rNx = bo.bf(getIntent().getStringExtra("KMediaTitle"), "");
    this.sdf = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.rNw = getIntent().getBooleanExtra("KBlockFav", false);
    this.rNv = getIntent().getBooleanExtra("ForceLandscape", false);
    this.fiR = getIntent().getStringExtra("StreamWording");
    this.fiS = getIntent().getStringExtra("StremWebUrl");
    this.rsI = getIntent().getStringExtra("KComponentCid");
    this.rNz = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.rNA = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.rNB = getIntent().getIntExtra("KSta_SourceType", 0);
    this.rNC = getIntent().getIntExtra("KSta_Scene", 0);
    this.rND = getIntent().getStringExtra("KSta_FromUserName");
    this.rNE = getIntent().getStringExtra("KSta_ChatName");
    this.rNF = getIntent().getStringExtra("KSta_SnSId");
    this.rNG = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.rNH = getIntent().getIntExtra("KSta_FavID", 0);
    this.rNI = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.cGU = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.hpq = bo.bf(getIntent().getStringExtra("KViewId"), "");
    this.sdh = bo.bf(getIntent().getStringExtra("ReportArgs"), "");
    this.sdi = getIntent().getIntExtra("NeedReportData", 0);
    if (this.sdi != 0)
    {
      this.ssid = at.gX(ah.getContext());
      this.bssid = at.gY(ah.getContext());
    }
    this.sdg = new bcs();
    this.sdg.xrS = this.thumbUrl;
    this.sdg.xrZ = this.rNu;
    this.sdg.Id = this.cBO;
    this.sdg.Url = this.url;
    this.sdg.xrR = 1;
    this.sdg.sdf = this.sdf;
    this.rNy.qZD = bo.yB();
    ab.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.sdg.Id + " attachurl:" + this.sdg.xrZ + " videoattachTotalTime:" + this.sdg.sdf + " streamvideowording: " + this.fiR + " streamvideoweburl: " + this.fiS + " mediaTitle: " + this.rNx + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.rNz + " streamvideopublishid " + this.rNA);
    Object localObject1;
    if (bo.isNullOrNil(this.eNO))
    {
      paramBundle = ao.gl(ag.getAccSnsPath(), this.sdg.Id);
      localObject1 = com.tencent.mm.plugin.sns.data.i.k(this.sdg);
      this.eNO = (paramBundle + (String)localObject1);
    }
    if ((bo.isNullOrNil(this.thumbPath)) || (!com.tencent.mm.vfs.e.cN(this.thumbPath)))
    {
      paramBundle = "attach" + this.sdg.Id;
      localObject1 = ao.gl(ag.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + com.tencent.mm.plugin.sns.data.i.Zx(paramBundle));
    }
    if (!com.tencent.mm.vfs.e.cN(this.thumbPath)) {}
    try
    {
      paramBundle = new bcs();
      paramBundle.parseFrom(this.sdg.toByteArray());
      paramBundle.Id = ("attach" + paramBundle.Id);
      localObject1 = new com.tencent.mm.plugin.sns.data.e(this.sdg);
      ((com.tencent.mm.plugin.sns.data.e)localObject1).rbj = 1;
      ((com.tencent.mm.plugin.sns.data.e)localObject1).ohe = this.sdg.Id;
      ag.cpa().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.e)localObject1, az.yNU);
      getWindow().addFlags(128);
      this.sdd = ((VideoPlayView)findViewById(2131828722));
      paramBundle = this.sdd;
      localObject1 = new AdVideoPlayerLoadingBar(getContext());
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(2131427798);
      paramBundle.qUu = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.kvG.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.qUu, (ViewGroup.LayoutParams)localObject2);
      paramBundle.qUu.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.qUu.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.qUu.setIsPlay(paramBundle.kvG.isPlaying());
      if (paramBundle.qUu != null) {
        ((View)paramBundle.qUu).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.sdd.setVideoPlayViewEvent(new VideoAdPlayerUI.1(this));
      this.sdd.setVideoTotalTime(this.sdg.sdf);
      if (com.tencent.mm.vfs.e.cN(this.eNO))
      {
        this.rNy.qZB = 1;
        this.sdd.setVideoPath(this.eNO);
        this.sdd.setLeftButtonOnClickListener(new VideoAdPlayerUI.2(this));
        this.sdd.setRightButtonOnCliclListener(new VideoAdPlayerUI.3(this));
        paramBundle = this.sdd;
        localObject1 = this.fiR;
        localObject2 = new VideoAdPlayerUI.4(this);
        paramBundle.qUx = ((String)localObject1);
        paramBundle.qUw.setText((CharSequence)localObject1);
        paramBundle.qUw.setOnClickListener((View.OnClickListener)localObject2);
        this.sdd.cmQ();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.sdd;
          if (paramBundle.qUz != null)
          {
            paramBundle.qUA = false;
            paramBundle.qUz.setVisibility(8);
          }
        }
        AppMethodBeat.o(39918);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        ab.e("MicroMsg.VideoPlayerUI", "error for download thumb");
        continue;
        this.sdd.cmO();
        this.sdd.setIsDownloading(true);
        ag.cpa().a(this.sdg, 6, null, az.yNU);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(39920);
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.rNC != 0) {
      k.a(k.a.rai, this.rNA, this.rNz, this.rNB, this.rNC, this.rND, this.rNE, this.rNF, this.rNG, this.rNH, this.rNI);
    }
    if (this.raZ) {
      if (this.rMD != null) {
        break label454;
      }
    }
    label454:
    for (int i = 0;; i = this.rMD.csR())
    {
      Object localObject;
      int j;
      if (this.rMD != null)
      {
        localObject = this.rNy.cnF();
        long l2 = this.rNy.qZC - this.rNy.fQy;
        long l1 = l2;
        if (l2 < 0L)
        {
          ab.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.rNy.qZC), Long.valueOf(this.rNy.fQy) });
          l1 = this.rNy.qZC;
        }
        j = (int)l1;
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a(new com.tencent.mm.plugin.sns.a.b.d(this.hpq, 6, 2, this.rNy.qZC, null, null, 2, (String)localObject, -1, i, j, j, 0, this.rMD.csQ().csj(), this.rMD.csQ().csk()), 0);
      }
      if (this.sdi != 0)
      {
        j = this.rNy.qZJ.raJ;
        i = j;
        if (this.isPlaying)
        {
          i = j;
          if (this.rNy.qZJ.raN != 0L) {
            i = j + (int)(bo.av(this.rNy.qZJ.raN) / 1000L);
          }
        }
        localObject = new com.tencent.mm.modelstat.i(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + bo.aox() + "," + this.sdh + "," + this.sdf, (int)bo.aox());
        com.tencent.mm.kernel.g.RM();
        com.tencent.mm.kernel.g.RK().eHt.a((m)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
      AppMethodBeat.o(39920);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(39922);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    ab.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
    EW(i);
    if ((this.sdd != null) && (this.sdd.isPlaying())) {
      this.sdd.pause();
    }
    if (this.sdd != null)
    {
      ab.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.sdd.onDetach();
    }
    ag.cpa().rde.remove(this);
    ag.cpa().b(this);
    if (this.rNy != null) {
      this.rNy.fQx = bo.yB();
    }
    AppMethodBeat.o(39922);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(39923);
    super.onResume();
    ag.cpa().rde.add(this);
    ag.cpa().a(this);
    if (this.rNy != null) {
      this.rNy.onResume();
    }
    AppMethodBeat.o(39923);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI
 * JD-Core Version:    0.7.0.1
 */