package com.tencent.mm.plugin.sns.ui.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.d;
import com.tencent.mm.plugin.sight.decode.model.SightPlayController.e;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.d.e;
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.as;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.plugin.sns.ui.listener.c;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.br;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.LinkedList;

public final class a
  extends b
{
  private Handler PRJ;
  private ViewGroup Qcq;
  private boolean RIX;
  SnsTimelineVideoView RIY;
  com.tencent.mm.plugin.sns.ad.g.l RoZ;
  private Context context;
  public String hES;
  private com.tencent.mm.ui.widget.b.a vEV;
  
  public a(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc, com.tencent.mm.plugin.sns.ad.g.l paraml)
  {
    AppMethodBeat.i(308821);
    this.PRJ = new Handler(Looper.getMainLooper());
    this.timeLineObject = paramTimeLineObject;
    this.PNI = paramSnsInfo;
    this.PZr = paramc;
    this.RoZ = paraml;
    this.hES = paramSnsInfo.getLocalid();
    AppMethodBeat.o(308821);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(308886);
    try
    {
      Log.i("MicroMsg.AdNormalSightDetailItem", "onPause, isAdUseOnlineVideoView=" + this.RIX);
      if (this.RIX) {
        if (this.RIY != null) {
          this.RIY.bck();
        }
      }
      for (;;)
      {
        if ((this.RoZ != null) && (this.PNI != null)) {
          this.RoZ.uu(this.PNI.field_snsId);
        }
        AppMethodBeat.o(308886);
        return;
        if ((this.Qcj != null) && (this.Qcj.RjM != null)) {
          this.Qcj.RjM.pause();
        }
      }
      return;
    }
    finally
    {
      Log.e("MicroMsg.AdNormalSightDetailItem", "onPause, exp=" + localObject.toString());
      AppMethodBeat.o(308886);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(308880);
    this.PNI = com.tencent.mm.plugin.sns.storage.l.aZK(this.PNI.getSnsId());
    Log.i("MicroMsg.AdNormalSightDetailItem", "refreshView, hash=" + hashCode());
    dmz localdmz;
    label186:
    label605:
    if ((this.timeLineObject.ContentObj != null) && (this.timeLineObject.ContentObj.Zpr.size() > 0))
    {
      localdmz = (dmz)this.timeLineObject.ContentObj.Zpr.get(0);
      if (localdmz != null)
      {
        if (!this.RIX) {
          break label649;
        }
        e.a(this.PNI, localdmz);
      }
      label106:
      if ((this.timeLineObject.ContentObj != null) && (this.timeLineObject.ContentObj.Zpr.size() > 0))
      {
        al.hgy();
        if (g.u(localdmz)) {
          break label778;
        }
        if (!al.hgy().x(localdmz)) {
          break label657;
        }
        this.Qcj.PQu.setVisibility(8);
        this.Qcj.RjP.setVisibility(0);
        this.Qcj.RjP.jEN();
        if (!this.RIX) {
          break label1140;
        }
        al.hgy().a(this.PNI, localdmz, this.Qcj.RjM, -1, this.context.hashCode(), 0, br.adkc, this.PNI.isAd(), false, false);
        if (this.RIY != null) {
          break label1093;
        }
        com.tencent.mm.plugin.sns.ad.j.l.W(this.Qcq);
        this.RIY = new SnsTimelineVideoView(this.context, (byte)0);
        this.RIY.hmy();
        this.RIY.setVideoScaleType(i.e.XYN);
        this.RIY.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        com.tencent.mm.plugin.sns.ad.j.l.z(this.RIY, -1, -1);
        com.tencent.mm.plugin.sns.ad.j.l.C(this.RIY, true);
        com.tencent.mm.plugin.sns.ad.j.l.b(this.Qcq, this.RIY, 0);
        this.RIY.setUICallback(new SnsTimelineVideoView.b()
        {
          public final void ZW(String paramAnonymousString)
          {
            AppMethodBeat.i(308844);
            Log.w("MicroMsg.AdNormalSightDetailItem", "timelineVideoView setUICallback onDestroy");
            AppMethodBeat.o(308844);
          }
        });
        this.RIY.setVideoCallback(new com.tencent.mm.plugin.sns.ad.timeline.video.online.a(this.PNI, this.RIY, this.RoZ, 1));
        Log.i("MicroMsg.AdNormalSightDetailItem", "refreshView, new OnLineVideoView, hash=" + this.RIY.hashCode() + ", innerType=" + this.RIY.getInnerVideoView());
        this.RIY.setMute(true);
        this.RIY.a(localdmz, this.PNI.getLocalid(), this.PNI.getTimeLine().CreateTime);
        this.RIY.abandonAudioFocus();
        this.RIY.grj();
        this.PRJ.removeCallbacksAndMessages(null);
        this.PRJ.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(308852);
            if ((a.this.RIY.isPlaying()) || (a.this.RIY.aFF()))
            {
              Log.d("MicroMsg.AdNormalSightDetailItem", "resumePlay");
              a.this.RIY.bcl();
              AppMethodBeat.o(308852);
              return;
            }
            Log.d("MicroMsg.AdNormalSightDetailItem", "onResume");
            a.this.RIY.onResume();
            AppMethodBeat.o(308852);
          }
        }, 250L);
        com.tencent.mm.plugin.sns.ad.j.l.C(this.Qcj.RjP, false);
        label491:
        if (this.RoZ != null)
        {
          String str1 = as.mg(al.getAccSnsPath(), localdmz.Id);
          String str2 = t.i(localdmz);
          str1 = str1 + str2;
          if (!com.tencent.mm.vfs.y.ZC(str1)) {
            break label1191;
          }
          this.RoZ.g(this.PNI.field_snsId, (int)localdmz.aaTF, true);
          if (e.anH())
          {
            bool = com.tencent.mm.modelvideo.y.isH265Video(str1);
            Log.i("MicroMsg.AdNormalSightDetailItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + str1);
          }
          if (al.hgy().b(this.PNI, null) != 5) {
            break label1214;
          }
        }
      }
    }
    label406:
    label1191:
    label1214:
    for (boolean bool = true;; bool = false)
    {
      this.RoZ.e(this.PNI.field_snsId, bool, false);
      AppMethodBeat.o(308880);
      return;
      localdmz = null;
      break;
      e.a(localdmz, false);
      break label106;
      if ((this.PNI.isAd()) && (al.hgy().b(this.PNI, null) == 5))
      {
        al.hgy().B(localdmz);
        this.Qcj.PQu.setVisibility(8);
        this.Qcj.RjP.setVisibility(0);
        this.Qcj.RjP.jEN();
        break label186;
      }
      al.hgy().z(localdmz);
      this.Qcj.PQu.setVisibility(0);
      this.Qcj.RjP.setVisibility(8);
      this.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.shortvideo_play_btn));
      break label186;
      if (al.hgy().v(localdmz))
      {
        this.Qcj.PQu.setVisibility(0);
        this.Qcj.RjP.setVisibility(8);
        this.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.shortvideo_play_btn));
      }
      for (;;)
      {
        if (!this.Qcj.RjM.PGy.gYv()) {
          break label1091;
        }
        Log.d("MicroMsg.AdNormalSightDetailItem", "play video error " + localdmz.Id + " " + localdmz.Url + " " + localdmz.aaTl);
        al.hgy().z(localdmz);
        this.Qcj.PQu.setVisibility(0);
        this.Qcj.RjP.setVisibility(8);
        this.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.shortvideo_play_btn));
        break;
        if (al.hgy().w(localdmz))
        {
          this.Qcj.PQu.setVisibility(8);
          this.Qcj.RjP.setVisibility(8);
        }
        else if ((this.PNI.isAd()) && (al.hgy().b(this.PNI, null) <= 5))
        {
          this.Qcj.PQu.setVisibility(8);
          this.Qcj.RjP.setVisibility(8);
        }
        else
        {
          al.hgy().z(localdmz);
          this.Qcj.PQu.setVisibility(0);
          this.Qcj.RjP.setVisibility(8);
          this.Qcj.PQu.setImageDrawable(com.tencent.mm.cd.a.m(this.context, b.i.shortvideo_play_btn));
        }
      }
      label1091:
      break label186;
      label1093:
      Log.i("MicroMsg.AdNormalSightDetailItem", "refreshView, OnLineVideoView.hash=" + this.RIY.hashCode() + ", hasErr=" + this.RIY.Aqa);
      break label406;
      label1140:
      al.hgy().a(this.PNI, localdmz, this.Qcj.RjM, this.context.hashCode(), 0, br.adkc, this.PNI.isAd());
      this.Qcj.RjM.start();
      break label491;
      this.RoZ.g(this.PNI.field_snsId, (int)localdmz.aaTF, false);
      break label605;
    }
  }
  
  public final void t(View paramView1, View paramView2)
  {
    AppMethodBeat.i(308858);
    this.contentView = paramView1;
    this.context = paramView1.getContext();
    Log.i("MicroMsg.AdNormalSightDetailItem", "initView, hash=" + hashCode());
    if ((this.timeLineObject == null) || (this.PNI == null) || (!this.PNI.isAd()))
    {
      paramView1 = new StringBuilder("initView return, timelineObj==null?");
      boolean bool;
      if (this.timeLineObject == null)
      {
        bool = true;
        paramView1 = paramView1.append(bool).append(", snsInfo==null?");
        if (this.PNI != null) {
          break label162;
        }
        bool = true;
        label112:
        paramView2 = paramView1.append(bool).append(", id=");
        if (this.timeLineObject != null) {
          break label168;
        }
      }
      label162:
      label168:
      for (paramView1 = "";; paramView1 = this.timeLineObject.Id)
      {
        Log.e("MicroMsg.AdNormalSightDetailItem", paramView1);
        AppMethodBeat.o(308858);
        return;
        bool = false;
        break;
        bool = false;
        break label112;
      }
    }
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
    this.Qcj = new aw();
    paramView1 = this.contentView;
    View localView = paramView1.findViewById(b.f.chatting_click_area);
    VideoSightView localVideoSightView = (VideoSightView)paramView1.findViewById(b.f.image);
    this.Qcj.RjL = paramView1;
    this.Qcj.RjO = localView;
    this.Qcj.PQu = ((ImageView)paramView1.findViewById(b.f.status_btn));
    this.Qcj.RjP = ((MMPinProgressBtn)paramView1.findViewById(b.f.progress));
    this.Qcj.QRC = ((TextView)paramView1.findViewById(b.f.errorTv));
    this.Qcj.RjQ = ((TextView)paramView1.findViewById(b.f.endtv));
    this.Qcj.RjM = localVideoSightView;
    this.Qcj.RjM.setMute(true);
    this.Qcj.a(this.timeLineObject, 0, this.PNI.getLocalid(), this.PNI.isAd());
    this.Qcj.QRC.setVisibility(8);
    this.Qcj.RjM.setTagObject(this.Qcj);
    this.Qcj.RjM.setIsAdVideo(this.PNI.isAd());
    this.Qcj.RjS = 5;
    this.Qcj.RjR = ((ImageView)paramView1.findViewById(b.f.sns_sight_biz_icon));
    this.Qcq = ((ViewGroup)paramView1.findViewById(b.f.sns_video_container));
    localView.setTag(this.Qcj);
    this.Qcj.RjO.setOnClickListener(this.PZr.RQt);
    this.vEV = new com.tencent.mm.ui.widget.b.a(this.context);
    this.vEV.c(localView, this.PZr.RQk, this.PZr.RPU);
    int j;
    int i;
    label644:
    Object localObject;
    label694:
    ADXml localADXml;
    float f2;
    float f1;
    int m;
    int n;
    if ((this.PNI.isAd()) && (m.d(this.timeLineObject)))
    {
      j = 1;
      i = 0;
      if (this.PNI != null) {
        i = this.PNI.getAdXml().verticalVideoDisplayType;
      }
      if (i == 1)
      {
        paramView1 = o.dV(this.Qcj.RjM.getUIContext());
        Log.i("MicroMsg.AdNormalSightDetailItem", "isVerticalAdVideo=true, snsId=" + t.uA(this.PNI.field_snsId) + ", showW=" + paramView1.first + ", showH=" + paramView1.second);
        paramView2 = paramView1;
        i = j;
        this.RIX = com.tencent.mm.plugin.sns.ad.timeline.helper.b.c(this.PNI.getAdXml());
        localObject = new StringBuilder("normal ad detail useOnlineVideo=").append(this.RIX).append(", snsId=");
        if (this.timeLineObject != null) {
          break label1295;
        }
        paramView1 = "";
        Log.i("MicroMsg.AdNormalSightDetailItem", paramView1);
        localVideoSightView.setEnableConfigChanged(false);
        localObject = this.PNI;
        localADXml = ((SnsInfo)localObject).getAdXml();
        paramView1 = paramView2;
        if (localADXml != null)
        {
          paramView1 = paramView2;
          if (localADXml.isCardAd())
          {
            paramView1 = paramView2;
            if (localADXml.adMediaDisplayWidth > 0.0F)
            {
              paramView1 = paramView2;
              if (localADXml.adMediaDisplayHeight > 0.0F)
              {
                f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(localADXml.adMediaDisplayWidth, 1, localADXml.adBasicRemWidth, localADXml.adBasicRootFontSize);
                f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.l.a(localADXml.adMediaDisplayHeight, 1, localADXml.adBasicRemWidth, localADXml.adBasicRootFontSize);
                j = com.tencent.mm.cd.a.br(this.context, b.d.SmallestPadding);
                m = this.context.getResources().getDimensionPixelSize(b.d.NormalPadding);
                n = com.tencent.mm.cd.a.br(this.context, b.d.sns_avatar_size);
                if (localADXml.adMediaDisplayMode != 0) {
                  break label1306;
                }
                if (f2 < k - n - j - m - m) {
                  break label1467;
                }
                f2 = k - n - j - m - m;
                f1 = (int)(localADXml.adMediaDisplayHeight * f2 / localADXml.adMediaDisplayWidth);
              }
            }
          }
        }
      }
    }
    label928:
    label1453:
    label1467:
    for (;;)
    {
      paramView1 = Pair.create(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
      if ((this.PNI.isAd()) && (!((SnsInfo)localObject).getAdXml().isLandingPagesAd()) && (((SnsInfo)localObject).getAdInfo().isWeapp()))
      {
        this.Qcj.RjR.setVisibility(0);
        this.Qcj.RjR.setImageResource(b.e.we_app_icon);
      }
      if (paramView1 != null)
      {
        if ((this.Qcj.RjM instanceof SightPlayImageView))
        {
          if (i == 0) {
            break label1426;
          }
          this.Qcj.RjM.setScaleMode(1);
          this.Qcj.RjM.setScaleType(QImageView.a.afVc);
        }
        localVideoSightView.ld(((Integer)paramView1.first).intValue(), ((Integer)paramView1.second).intValue());
        if ((this.Qcj.RjM instanceof SightPlayImageView))
        {
          if (i == 0) {
            break label1453;
          }
          this.Qcj.RjM.PGE = true;
        }
      }
      for (;;)
      {
        paramView2 = this.Qcj.RjQ.getLayoutParams();
        paramView2.width = ((Integer)paramView1.first).intValue();
        paramView2.height = ((Integer)paramView1.second).intValue();
        this.Qcj.RjQ.setLayoutParams(paramView2);
        paramView2 = (FrameLayout.LayoutParams)this.Qcq.getLayoutParams();
        paramView2.width = ((Integer)paramView1.first).intValue();
        paramView2.height = ((Integer)paramView1.second).intValue();
        this.Qcq.setLayoutParams(paramView2);
        this.Qcj.RjM.setOnCompletionListener(new SightPlayController.d()
        {
          public final void c(SightPlayController paramAnonymousSightPlayController, int paramAnonymousInt)
          {
            AppMethodBeat.i(308854);
            if (paramAnonymousInt != -1)
            {
              if (a.this.RoZ == null)
              {
                AppMethodBeat.o(308854);
                return;
              }
              a.this.RoZ.S(a.this.PNI.field_snsId, false);
            }
            AppMethodBeat.o(308854);
          }
        });
        this.Qcj.RjM.setOnDecodeDurationListener(new SightPlayController.e()
        {
          public final void b(SightPlayController paramAnonymousSightPlayController, long paramAnonymousLong)
          {
            AppMethodBeat.i(308860);
            Log.d("MicroMsg.AdNormalSightDetailItem", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
            if ((a.this.RoZ != null) && (a.this.PNI != null))
            {
              a.this.RoZ.ut(a.this.PNI.field_snsId);
              a.this.RoZ.bj(a.this.PNI.field_snsId, 1000L * paramAnonymousLong);
              if (!a.this.RoZ.uq(a.this.PNI.field_snsId))
              {
                int i = (int)paramAnonymousSightPlayController.gYy();
                Log.i("MicroMsg.AdNormalSightDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                a.this.RoZ.c(a.this.PNI.field_snsId, Util.currentTicks(), false);
                a.this.RoZ.f(a.this.PNI.field_snsId, i, false);
                a.this.RoZ.bi(a.this.PNI.field_snsId, a.this.PNI.field_snsId);
              }
            }
            AppMethodBeat.o(308860);
          }
        });
        localVideoSightView.setTagObject(this.Qcj);
        localView.setTag(this.Qcj);
        AppMethodBeat.o(308858);
        return;
        paramView1 = o.a(this.timeLineObject, this.Qcj.RjM.getUIContext(), false);
        break;
        paramView2 = o.a(this.timeLineObject, this.Qcj.RjM.getUIContext(), this.PNI.isAd());
        i = 0;
        break label644;
        paramView1 = this.timeLineObject.Id;
        break label694;
        if (localADXml.adMediaDisplayMode == 1)
        {
          j = k - n - n - j - j - m - m;
          paramView1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * localADXml.adMediaDisplayHeight / localADXml.adMediaDisplayWidth)));
          break label928;
        }
        paramView1 = paramView2;
        if (localADXml.adMediaDisplayMode != 2) {
          break label928;
        }
        j = k - n - j - m - m;
        paramView1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * localADXml.adMediaDisplayHeight / localADXml.adMediaDisplayWidth)));
        break label928;
        this.Qcj.RjM.setScaleMode(0);
        this.Qcj.RjM.setScaleType(QImageView.a.afUX);
        break label1030;
        this.Qcj.RjM.setDrawWidthAndHeightFix(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */