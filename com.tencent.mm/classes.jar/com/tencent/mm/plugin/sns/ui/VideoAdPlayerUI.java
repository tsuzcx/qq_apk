package com.tencent.mm.plugin.sns.ui;

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
import com.tencent.mm.am.s;
import com.tencent.mm.message.k.b;
import com.tencent.mm.message.w.a;
import com.tencent.mm.model.v;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.modelsns.l;
import com.tencent.mm.plugin.ar.a.c;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.5;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.6;
import com.tencent.mm.plugin.sight.decode.ui.VideoPlayView.a;
import com.tencent.mm.plugin.sns.ad.g.p.a;
import com.tencent.mm.plugin.sns.ad.g.p.c;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.c.a;
import com.tencent.mm.plugin.sns.model.c.b;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat;
import com.tencent.mm.sdk.platformtools.ConnectivityCompat.Companion;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@com.tencent.mm.ui.base.a(19)
public class VideoAdPlayerUI
  extends MMActivity
  implements c.a, c.b
{
  private SnsInfo PNI;
  private String QKG;
  private VideoPlayView RGk;
  private l RGl;
  private int RGm;
  private dmz RGn;
  private String RGo;
  private int RGp;
  private String[] RGq;
  private String[] RGr;
  private boolean Rnj;
  private boolean Rnk;
  private String Rnl;
  private com.tencent.mm.plugin.sns.ad.g.m Rnm;
  public String Rnn;
  public String Rno;
  private int Rnp;
  private int Rnq;
  private String Rnr;
  private String Rns;
  private String Rnt;
  private long Rnu;
  private int Rnv;
  private int Rnw;
  private String bssid;
  private String fullPath;
  private boolean hLy;
  private String iah;
  private boolean isAd;
  private String mIE;
  private String mediaId;
  private String nTx;
  private String nTy;
  private String ssid;
  private String thumbPath;
  private String thumbUrl;
  private String url;
  private com.tencent.mm.model.d vZw;
  private String viewId;
  
  public VideoAdPlayerUI()
  {
    AppMethodBeat.i(99792);
    this.RGl = null;
    this.Rnm = new com.tencent.mm.plugin.sns.ad.g.m("VideoAdPlayerUI");
    this.fullPath = "";
    this.thumbPath = "";
    this.mIE = "";
    this.url = "";
    this.thumbUrl = "";
    this.mediaId = "";
    this.isAd = false;
    this.RGm = 0;
    this.Rnl = "";
    this.nTx = "";
    this.nTy = "";
    this.Rnn = "";
    this.Rno = "";
    this.Rnp = 0;
    this.Rnq = 0;
    this.Rnr = "";
    this.Rnt = "";
    this.Rnu = 0L;
    this.Rnv = 0;
    this.Rnw = 0;
    this.QKG = "";
    this.viewId = "";
    this.Rnk = false;
    this.Rnj = false;
    this.RGn = null;
    this.hLy = false;
    this.RGq = null;
    this.RGr = null;
    AppMethodBeat.o(99792);
  }
  
  private void amh(int paramInt)
  {
    AppMethodBeat.i(99802);
    if (!this.isAd)
    {
      AppMethodBeat.o(99802);
      return;
    }
    this.Rnm.ajw(this.RGk.getDuration());
    this.Rnm.PWv.PXJ = Util.currentTicks();
    com.tencent.mm.plugin.sns.ad.g.a.b localb = this.Rnm.PWv;
    if (paramInt == 2) {}
    for (paramInt = 2;; paramInt = 1)
    {
      localb.PXI = paramInt;
      this.Rnm.PWv.PXH = 2;
      Log.i("MicroMsg.VideoPlayerUI", "duration  orient " + this.Rnm.PWv.PXI);
      AppMethodBeat.o(99802);
      return;
    }
  }
  
  public final void EE(String paramString) {}
  
  public final void aXr() {}
  
  public void finish()
  {
    AppMethodBeat.i(99796);
    if (this.hLy) {
      this.RGk.pause();
    }
    if ((this.Rnm != null) && (this.QKG != null) && (this.QKG.length() > 0))
    {
      this.Rnm.hbk();
      Intent localIntent = new Intent();
      localIntent.putExtra("KComponentCid", this.QKG);
      localIntent.putExtra("KStreamVideoPlayCount", this.Rnm.PWr);
      localIntent.putExtra("KStreamVideoPlayCompleteCount", this.Rnm.PWs);
      localIntent.putExtra("KStreamVideoTotalPlayTimeInMs", this.Rnm.PWt);
      setResult(-1, localIntent);
    }
    super.finish();
    AppMethodBeat.o(99796);
  }
  
  public int getForceOrientation()
  {
    if (this.Rnj) {
      return 0;
    }
    return 4;
  }
  
  public int getLayoutId()
  {
    return b.g.video_player_ui;
  }
  
  public final void mc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(99799);
    Log.i("MicroMsg.VideoPlayerUI", "isPlaying " + this.RGk.isPlaying());
    if (this.RGk.isPlaying())
    {
      AppMethodBeat.o(99799);
      return;
    }
    this.RGk.setLoop(false);
    if (paramString2.equals(this.RGk.getVideoPath()))
    {
      this.RGk.H(this.RGk.getLastProgresstime());
      this.RGk.start();
      Log.i("MicroMsg.VideoPlayerUI", "onSightProgressstart " + paramString1 + " path: " + paramString2);
      AppMethodBeat.o(99799);
      return;
    }
    this.RGk.setVideoPath(paramString2);
    this.RGk.H(this.RGk.getLastProgresstime());
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
          ((k.b)localObject2).title = this.Rnl;
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
          if (!Util.isNullOrNil(this.RGn.Url))
          {
            ((k.b)localObject2).url = this.RGn.Url;
            if (!Util.isNullOrNil(this.RGn.aaTu)) {
              break label713;
            }
            localObject1 = this.RGn.aaTl;
            ((k.b)localObject2).thumburl = ((String)localObject1);
            ((k.b)localObject2).nTu = this.RGn.aaTr;
            ((k.b)localObject2).nTv = this.RGn.RGm;
            ((k.b)localObject2).nTw = this.Rnl;
            ((k.b)localObject2).nTy = this.nTy;
            ((k.b)localObject2).nTx = this.nTx;
            ((k.b)localObject2).nTz = this.thumbUrl;
            ((k.b)localObject2).nTA = this.Rnn;
            ((k.b)localObject2).nTB = this.Rno;
            ((k.b)localObject2).iah = this.iah;
            localObject1 = com.tencent.mm.vfs.y.bi(this.thumbPath, 0, -1);
            if (localObject1 != null) {
              break label725;
            }
            i = 0;
            Log.i("MicroMsg.VideoPlayerUI", "read buf size %d", new Object[] { Integer.valueOf(i) });
            if (w.a.bwq() != null) {
              w.a.bwq().a((k.b)localObject2, "", "", str2, "", (byte[])localObject1);
            }
            if (this.RGp != 0)
            {
              j = this.Rnm.PWv.PXF;
              i = j;
              if (this.hLy)
              {
                i = j;
                if (this.Rnm.PWv.PXJ != 0L) {
                  i = j + (int)(Util.ticksToNow(this.Rnm.PWv.PXJ) / 1000L);
                }
              }
              localObject1 = new com.tencent.mm.modelstat.h(13228, "1,3," + i + "," + this.ssid + "," + this.bssid + "," + Util.nowSecond() + "," + this.RGo + "," + this.RGm, (int)Util.nowSecond());
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject1, 0);
            }
            com.tencent.mm.plugin.messenger.a.g.gaI().ke(str1, str2);
            if (this.isAd) {
              t.a(new SnsAdClick(0, 6, this.PNI.field_snsId, 12, 0));
            }
            if (this.Rnq == 0) {
              continue;
            }
            boolean bool = au.bwE(str2);
            if (!bool) {
              break label733;
            }
            localObject1 = p.c.PXl;
            localObject2 = this.Rno;
            str3 = this.Rnn;
            j = this.Rnp;
            k = this.Rnq;
            str4 = this.Rnr;
            str5 = this.Rns;
            str6 = this.Rnt;
            l = this.Rnu;
            m = this.Rnv;
            n = this.Rnw;
            if (!bool) {
              break label741;
            }
          }
          label713:
          label725:
          label733:
          label741:
          for (int i = v.getMembersCountByChatRoomName(str2);; i = 0)
          {
            com.tencent.mm.plugin.sns.ad.g.p.a((p.c)localObject1, (String)localObject2, str3, j, k, str4, str5, str6, l, m, n, i);
            break;
            ((k.b)localObject2).url = this.RGn.aaTr;
            break label161;
            localObject1 = this.RGn.aaTu;
            break label183;
            i = localObject1.length;
            break label296;
            localObject1 = p.c.PXk;
            break label596;
          }
        }
        com.tencent.mm.ui.widget.snackbar.b.u(this, getString(b.j.has_send));
      }
    }
    else if (4098 == paramInt1)
    {
      if (this.Rnq != 0) {
        com.tencent.mm.plugin.sns.ad.g.p.a(p.c.PXm, this.Rno, this.Rnn, this.Rnp, this.Rnq, this.Rnr, this.Rns, this.Rnt, this.Rnu, this.Rnv, this.Rnw, 0);
      }
      if (-1 != paramInt2) {
        break label901;
      }
      if (this.isAd) {
        t.a(new SnsAdClick(0, 6, this.PNI.field_snsId, 15, 0));
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
      t.a(new SnsAdClick(0, 6, this.PNI.field_snsId, 13, 0));
      break;
      label901:
      if (this.isAd) {
        t.a(new SnsAdClick(0, 6, this.PNI.field_snsId, 16, 0));
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(99801);
    super.onConfigurationChanged(paramConfiguration);
    VideoPlayView localVideoPlayView = this.RGk;
    Log.i("MicroMsg.VideoPlayView", "onConfigurationChanged " + paramConfiguration.orientation + " " + localVideoPlayView.PHm);
    if (localVideoPlayView.PHm != paramConfiguration.orientation)
    {
      if (paramConfiguration.orientation != 1) {
        break label119;
      }
      localVideoPlayView.update(1);
    }
    for (;;)
    {
      localVideoPlayView.PHm = paramConfiguration.orientation;
      if (localVideoPlayView.PHm == 2) {
        localVideoPlayView.maskView.setVisibility(8);
      }
      amh(paramConfiguration.orientation);
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
    if (aw.bx(getContext())) {
      getController().setActionbarColor(getResources().getColor(b.c.action_bar_color));
    }
    this.RGq = new String[] { getString(b.j.sns_ad_video_right_menu_send_friend), getString(b.j.sns_ad_video_right_menu_share_sns), getString(b.j.sns_ad_video_right_menu_fav) };
    this.RGr = new String[] { getString(b.j.sns_ad_video_right_menu_send_friend), getString(b.j.sns_ad_video_right_menu_share_sns) };
    paramBundle = getIntent().getStringExtra("KSta_SnSId");
    this.PNI = al.hgB().aZK(t.aXD(paramBundle));
    this.vZw = new com.tencent.mm.model.d();
    this.RGl = l.y(getIntent());
    this.fullPath = getIntent().getStringExtra("KFullVideoPath");
    this.mIE = getIntent().getStringExtra("KStremVideoUrl");
    this.thumbUrl = getIntent().getStringExtra("KThumUrl");
    this.mediaId = getIntent().getStringExtra("KMediaId");
    this.isAd = getIntent().getBooleanExtra("KFromTimeLine", false);
    this.url = getIntent().getStringExtra("KUrl");
    this.Rnl = Util.nullAs(getIntent().getStringExtra("KMediaTitle"), "");
    this.RGm = getIntent().getIntExtra("KMediaVideoTime", 0);
    this.Rnk = getIntent().getBooleanExtra("KBlockFav", false);
    this.Rnj = getIntent().getBooleanExtra("ForceLandscape", false);
    this.nTx = getIntent().getStringExtra("StreamWording");
    this.nTy = getIntent().getStringExtra("StremWebUrl");
    this.QKG = getIntent().getStringExtra("KComponentCid");
    this.Rnn = getIntent().getStringExtra("KSta_StremVideoAduxInfo");
    this.Rno = getIntent().getStringExtra("KSta_StremVideoPublishId");
    this.Rnp = getIntent().getIntExtra("KSta_SourceType", 0);
    this.Rnq = getIntent().getIntExtra("KSta_Scene", 0);
    this.Rnr = getIntent().getStringExtra("KSta_FromUserName");
    this.Rns = getIntent().getStringExtra("KSta_ChatName");
    this.Rnt = getIntent().getStringExtra("KSta_SnSId");
    this.Rnu = getIntent().getLongExtra("KSta_MsgId", 0L);
    this.Rnv = getIntent().getIntExtra("KSta_FavID", 0);
    this.Rnw = getIntent().getIntExtra("KSta_ChatroomMembercount", 0);
    this.iah = getIntent().getStringExtra("KSta_SnsStatExtStr");
    this.viewId = Util.nullAs(getIntent().getStringExtra("KViewId"), "");
    this.RGo = Util.nullAs(getIntent().getStringExtra("ReportArgs"), "");
    this.RGp = getIntent().getIntExtra("NeedReportData", 0);
    if (this.RGp != 0)
    {
      this.ssid = ConnectivityCompat.Companion.getFormattedWiFiSsid();
      this.bssid = ConnectivityCompat.Companion.getFormattedWiFiBssid();
    }
    this.RGn = new dmz();
    this.RGn.aaTl = this.thumbUrl;
    this.RGn.aaTr = this.mIE;
    this.RGn.Id = this.mediaId;
    this.RGn.Url = this.url;
    this.RGn.aazR = 1;
    this.RGn.RGm = this.RGm;
    this.Rnm.PWp = Util.currentTicks();
    Log.i("MicroMsg.VideoPlayerUI", "init streamvideo " + this.RGn.Id + " attachurl:" + this.RGn.aaTr + " videoattachTotalTime:" + this.RGn.RGm + " streamvideowording: " + this.nTx + " streamvideoweburl: " + this.nTy + " mediaTitle: " + this.Rnl + " thumburl " + this.thumbUrl + " streamvideoaduxinfo " + this.Rnn + " streamvideopublishid " + this.Rno);
    Object localObject1;
    if (Util.isNullOrNil(this.fullPath))
    {
      paramBundle = as.mg(al.getAccSnsPath(), this.RGn.Id);
      localObject1 = t.j(this.RGn);
      this.fullPath = (paramBundle + (String)localObject1);
    }
    if ((Util.isNullOrNil(this.thumbPath)) || (!com.tencent.mm.vfs.y.ZC(this.thumbPath)))
    {
      paramBundle = "attach" + this.RGn.Id;
      localObject1 = as.mg(al.getAccSnsPath(), paramBundle);
      this.thumbPath = ((String)localObject1 + t.aXm(paramBundle));
    }
    if (!com.tencent.mm.vfs.y.ZC(this.thumbPath)) {}
    try
    {
      paramBundle = new dmz();
      paramBundle.parseFrom(this.RGn.toByteArray());
      paramBundle.Id = ("attach" + paramBundle.Id);
      localObject1 = new com.tencent.mm.plugin.sns.data.p(this.RGn);
      ((com.tencent.mm.plugin.sns.data.p)localObject1).QnY = 1;
      ((com.tencent.mm.plugin.sns.data.p)localObject1).hOG = this.RGn.Id;
      al.hgw().a(paramBundle, 7, (com.tencent.mm.plugin.sns.data.p)localObject1, br.adkd);
      getWindow().addFlags(128);
      this.RGk = ((VideoPlayView)findViewById(b.f.video_play_view));
      paramBundle = this.RGk;
      localObject1 = new AdVideoPlayerLoadingBar(getContext());
      Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = paramBundle.getContext().getResources().getDimensionPixelSize(a.c.NoPadding);
      paramBundle.PGY = ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1);
      paramBundle.wCd.setPlayProgressCallback(true);
      paramBundle.addView((View)paramBundle.PGY, (ViewGroup.LayoutParams)localObject2);
      paramBundle.PGY.setIplaySeekCallback(new VideoPlayView.5(paramBundle));
      paramBundle.PGY.setOnPlayButtonClickListener(new VideoPlayView.6(paramBundle));
      paramBundle.PGY.setIsPlay(paramBundle.wCd.isPlaying());
      if (paramBundle.PGY != null) {
        ((View)paramBundle.PGY).setVisibility(8);
      }
      ((com.tencent.mm.plugin.sight.decode.ui.a)localObject1).seek(0);
      this.RGk.setVideoPlayViewEvent(new VideoPlayView.a()
      {
        public final void Di(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(99782);
          Object localObject;
          if (paramAnonymousBoolean)
          {
            localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv;
            if (VideoAdPlayerUI.this.getResources().getConfiguration().orientation != 2) {
              break label301;
            }
          }
          label301:
          for (int i = 2;; i = 1)
          {
            ((com.tencent.mm.plugin.sns.ad.g.a.b)localObject).PXI = i;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv.PXJ = Util.currentTicks();
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv.PXH = 2;
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv.PXF = 0;
            if ((!VideoAdPlayerUI.b(VideoAdPlayerUI.this)) && ((int)VideoAdPlayerUI.c(VideoAdPlayerUI.this).getLastProgresstime() == 0))
            {
              localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv;
              ((com.tencent.mm.plugin.sns.ad.g.a.b)localObject).PXD += 1;
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv.PXJ = Util.currentTicks();
            VideoAdPlayerUI.d(VideoAdPlayerUI.this).a(VideoAdPlayerUI.c(VideoAdPlayerUI.this));
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              localObject = new com.tencent.mm.modelstat.h(13227, "1,1,0," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0);
            }
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, true);
            AppMethodBeat.o(99782);
            return;
          }
        }
        
        public final void ajp(int paramAnonymousInt)
        {
          AppMethodBeat.i(99786);
          if (VideoAdPlayerUI.i(VideoAdPlayerUI.this) == 0)
          {
            VideoAdPlayerUI.a(VideoAdPlayerUI.this, paramAnonymousInt);
            VideoAdPlayerUI.j(VideoAdPlayerUI.this).RGm = paramAnonymousInt;
          }
          AppMethodBeat.o(99786);
        }
        
        public final void gYM()
        {
          AppMethodBeat.i(99783);
          VideoAdPlayerUI.d(VideoAdPlayerUI.this).gR(false);
          com.tencent.mm.plugin.sns.ad.g.a.b localb = VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv;
          localb.PXF += (int)Util.ticksToNow(VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv.PXJ);
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          AppMethodBeat.o(99783);
        }
        
        public final void gYN()
        {
          AppMethodBeat.i(99784);
          Log.i("MicroMsg.VideoPlayerUI", "onPlayCompletion");
          Object localObject = VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv;
          ((com.tencent.mm.plugin.sns.ad.g.a.b)localObject).PXE += 1;
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
          {
            localObject = new com.tencent.mm.modelstat.h(13227, "1,2," + VideoAdPlayerUI.i(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
            com.tencent.mm.kernel.h.baF();
            com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0);
          }
          AppMethodBeat.o(99784);
        }
        
        public final void gYO()
        {
          AppMethodBeat.i(99785);
          Log.i("MicroMsg.VideoPlayerUI", "onPlayDownloadedPartComplete");
          VideoAdPlayerUI.a(VideoAdPlayerUI.this, false);
          VideoAdPlayerUI.c(VideoAdPlayerUI.this).gYJ();
          AppMethodBeat.o(99785);
        }
      });
      this.RGk.setVideoTotalTime(this.RGn.RGm);
      if (com.tencent.mm.vfs.y.ZC(this.fullPath))
      {
        this.Rnm.PWn = 1;
        this.RGk.setVideoPath(this.fullPath);
        this.RGk.setLeftButtonOnClickListener(new VideoAdPlayerUI.2(this));
        this.RGk.setRightButtonOnCliclListener(new VideoAdPlayerUI.3(this));
        paramBundle = this.RGk;
        localObject1 = this.nTx;
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(99791);
            Object localObject = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
            if (VideoAdPlayerUI.q(VideoAdPlayerUI.this) != 0) {
              com.tencent.mm.plugin.sns.ad.g.p.a(p.a.PWX, VideoAdPlayerUI.this.Rno, VideoAdPlayerUI.this.Rnn, VideoAdPlayerUI.r(VideoAdPlayerUI.this), VideoAdPlayerUI.q(VideoAdPlayerUI.this), VideoAdPlayerUI.s(VideoAdPlayerUI.this), VideoAdPlayerUI.t(VideoAdPlayerUI.this), VideoAdPlayerUI.u(VideoAdPlayerUI.this), VideoAdPlayerUI.v(VideoAdPlayerUI.this), VideoAdPlayerUI.w(VideoAdPlayerUI.this), VideoAdPlayerUI.x(VideoAdPlayerUI.this));
            }
            if (VideoAdPlayerUI.e(VideoAdPlayerUI.this) != 0)
            {
              int j = VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv.PXF;
              int i = j;
              if (VideoAdPlayerUI.b(VideoAdPlayerUI.this))
              {
                i = j;
                if (VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv.PXJ != 0L) {
                  i = j + (int)(Util.ticksToNow(VideoAdPlayerUI.a(VideoAdPlayerUI.this).PWv.PXJ) / 1000L);
                }
              }
              paramAnonymousView = new com.tencent.mm.modelstat.h(13228, "1,1," + i + "," + VideoAdPlayerUI.f(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.g(VideoAdPlayerUI.this) + "," + Util.nowSecond() + "," + VideoAdPlayerUI.h(VideoAdPlayerUI.this) + "," + VideoAdPlayerUI.i(VideoAdPlayerUI.this), (int)Util.nowSecond());
              com.tencent.mm.kernel.h.baF();
              com.tencent.mm.kernel.h.baD().mCm.a(paramAnonymousView, 0);
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
              if (!TextUtils.isEmpty(VideoAdPlayerUI.this.Rnn)) {
                paramAnonymousView = t.lY((String)localObject, VideoAdPlayerUI.this.Rnn);
              }
            }
            localIntent.putExtra("jsapiargs", localBundle);
            localIntent.putExtra("rawUrl", paramAnonymousView);
            localIntent.putExtra("useJs", true);
            if (VideoAdPlayerUI.A(VideoAdPlayerUI.this)) {
              t.a(new SnsAdClick(0, 6, VideoAdPlayerUI.B(VideoAdPlayerUI.this).field_snsId, 18, 0));
            }
            new MMHandler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(99790);
                com.tencent.mm.plugin.sns.d.a.pFn.h(localIntent, VideoAdPlayerUI.this);
                AppMethodBeat.o(99790);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/VideoAdPlayerUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99791);
          }
        };
        paramBundle.PHb = ((String)localObject1);
        paramBundle.PHa.setText((CharSequence)localObject1);
        paramBundle.PHa.setOnClickListener((View.OnClickListener)localObject2);
        this.RGk.gYL();
        if (getIntent().getIntExtra("ShareBtnHidden", 0) != 0)
        {
          paramBundle = this.RGk;
          if (paramBundle.PHc != null)
          {
            paramBundle.PHd = false;
            paramBundle.PHc.setVisibility(8);
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
        this.RGk.gYJ();
        this.RGk.setIsDownloading(true);
        al.hgw().a(this.RGn, 6, null, br.adkd);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99795);
    super.onDestroy();
    getWindow().clearFlags(128);
    if (this.Rnq != 0) {
      com.tencent.mm.plugin.sns.ad.g.p.a(p.a.PWZ, this.Rno, this.Rnn, this.Rnp, this.Rnq, this.Rnr, this.Rns, this.Rnt, this.Rnu, this.Rnv, this.Rnw);
    }
    int i;
    String str;
    int j;
    if (this.isAd)
    {
      if (this.PNI != null) {
        break label468;
      }
      i = 0;
      if (this.PNI != null)
      {
        str = this.Rnm.hbj();
        long l2 = this.Rnm.PWo - this.Rnm.oTU;
        long l1 = l2;
        if (l2 < 0L)
        {
          Log.e("MicroMsg.VideoPlayerUI", "reportVideo minus staytime found! totaltime[%d], offscreenTime[%ld]", new Object[] { Integer.valueOf(this.Rnm.PWo), Long.valueOf(this.Rnm.oTU) });
          l1 = this.Rnm.PWo;
        }
        j = (int)l1;
        localObject = this.PNI.getAdInfo();
        if (localObject != null) {
          break label479;
        }
      }
    }
    label468:
    label479:
    for (Object localObject = "";; localObject = ((ADInfo)localObject).waidPkg)
    {
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(new com.tencent.mm.plugin.sns.ad.g.g(this.viewId, 6, this.Rnm.PWo, str, i, j, j, this.PNI.getAdSnsInfo().getTimelineRemindInfoSourceInfo(), this.PNI.getAdSnsInfo().getTimelineRemindInfoSelfInfo(), (String)localObject), 0);
      if (this.RGp != 0)
      {
        j = this.Rnm.PWv.PXF;
        i = j;
        if (this.hLy)
        {
          i = j;
          if (this.Rnm.PWv.PXJ != 0L) {
            i = j + (int)(Util.ticksToNow(this.Rnm.PWv.PXJ) / 1000L);
          }
        }
        localObject = new com.tencent.mm.modelstat.h(13228, "1,2," + i + "," + this.ssid + "," + this.bssid + "," + Util.nowSecond() + "," + this.RGo + "," + this.RGm, (int)Util.nowSecond());
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a((com.tencent.mm.am.p)localObject, 0);
      }
      setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
      AppMethodBeat.o(99795);
      return;
      i = this.PNI.getAdRecSrc();
      break;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99797);
    super.onPause();
    int i = getResources().getConfiguration().orientation;
    Log.i("MicroMsg.VideoPlayerUI", "onpause  ".concat(String.valueOf(i)));
    amh(i);
    if ((this.RGk != null) && (this.RGk.isPlaying())) {
      this.RGk.pause();
    }
    if (this.RGk != null)
    {
      Log.i("MicroMsg.VideoPlayerUI", "onDetach");
      this.RGk.onDetach();
    }
    al.hgw().QqL.remove(this);
    al.hgw().b(this);
    if (this.Rnm != null) {
      this.Rnm.oTT = Util.currentTicks();
    }
    AppMethodBeat.o(99797);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99798);
    super.onResume();
    al.hgw().QqL.add(this);
    al.hgw().a(this);
    if (this.Rnm != null) {
      this.Rnm.onResume();
    }
    AppMethodBeat.o(99798);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void w(String paramString, boolean paramBoolean) {}
  
  public final void x(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(99800);
    Log.i("MicroMsg.VideoPlayerUI", "onSightFinish ".concat(String.valueOf(paramString)));
    this.RGk.setIsDownloading(false);
    this.RGk.setVideoPath(this.fullPath);
    this.RGk.H(this.RGk.getLastProgresstime());
    this.RGk.setLoop(false);
    if ((this.isAd) && (!Util.isNullOrNil(paramString)) && (this.RGn != null) && (paramString.equals(this.RGn.Id)) && (com.tencent.mm.vfs.y.ZC(this.fullPath))) {
      this.Rnm.PWn = 1;
    }
    AppMethodBeat.o(99800);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.VideoAdPlayerUI
 * JD-Core Version:    0.7.0.1
 */