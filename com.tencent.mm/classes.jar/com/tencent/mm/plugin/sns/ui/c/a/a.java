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
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.d.d;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

public final class a
  extends b
{
  private ViewGroup JKL;
  private Handler JMp;
  com.tencent.mm.plugin.sns.ad.f.l KPn;
  private boolean LiV;
  SnsTimelineVideoView LiW;
  private Context context;
  public String fAg;
  private com.tencent.mm.ui.widget.b.a szq;
  
  public a(TimeLineObject paramTimeLineObject, SnsInfo paramSnsInfo, c paramc, com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    AppMethodBeat.i(268721);
    this.JMp = new Handler(Looper.getMainLooper());
    this.timeLineObject = paramTimeLineObject;
    this.Jzk = paramSnsInfo;
    this.JIp = paramc;
    this.KPn = paraml;
    this.fAg = paramSnsInfo.getLocalid();
    AppMethodBeat.o(268721);
  }
  
  public final void n(View paramView1, View paramView2)
  {
    AppMethodBeat.i(268722);
    this.contentView = paramView1;
    this.context = paramView1.getContext();
    Log.i("MicroMsg.AdNormalSightDetailItem", "initView, hash=" + hashCode());
    if ((this.timeLineObject == null) || (this.Jzk == null) || (!this.Jzk.isAd()))
    {
      paramView1 = new StringBuilder("initView return, timelineObj==null?");
      boolean bool;
      if (this.timeLineObject == null)
      {
        bool = true;
        paramView1 = paramView1.append(bool).append(", snsInfo==null?");
        if (this.Jzk != null) {
          break label155;
        }
        bool = true;
        label108:
        paramView2 = paramView1.append(bool).append(", id=");
        if (this.timeLineObject != null) {
          break label161;
        }
      }
      label155:
      label161:
      for (paramView1 = "";; paramView1 = this.timeLineObject.Id)
      {
        Log.e("MicroMsg.AdNormalSightDetailItem", paramView1);
        AppMethodBeat.o(268722);
        return;
        bool = false;
        break;
        bool = false;
        break label108;
      }
    }
    int k = ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getWidth();
    this.JKG = new av();
    paramView1 = this.contentView;
    View localView = paramView1.findViewById(i.f.chatting_click_area);
    VideoSightView localVideoSightView = (VideoSightView)paramView1.findViewById(i.f.image);
    this.JKG.KKj = paramView1;
    this.JKG.KKm = localView;
    this.JKG.JAL = ((ImageView)paramView1.findViewById(i.f.status_btn));
    this.JKG.KKn = ((MMPinProgressBtn)paramView1.findViewById(i.f.progress));
    this.JKG.Ktc = ((TextView)paramView1.findViewById(i.f.errorTv));
    this.JKG.KKo = ((TextView)paramView1.findViewById(i.f.endtv));
    this.JKG.KKk = localVideoSightView;
    this.JKG.KKk.setMute(true);
    this.JKG.a(this.timeLineObject, 0, this.Jzk.getLocalid(), this.Jzk.isAd());
    this.JKG.Ktc.setVisibility(8);
    this.JKG.KKk.setTagObject(this.JKG);
    this.JKG.KKk.setIsAdVideo(this.Jzk.isAd());
    this.JKG.KKq = 5;
    this.JKG.KKp = ((ImageView)paramView1.findViewById(i.f.sns_sight_biz_icon));
    this.JKL = ((ViewGroup)paramView1.findViewById(i.f.sns_video_container));
    localView.setTag(this.JKG);
    this.JKG.KKm.setOnClickListener(this.JIp.Lpo);
    this.szq = new com.tencent.mm.ui.widget.b.a(this.context);
    this.szq.c(localView, this.JIp.Lpf, this.JIp.LoP);
    int j;
    int i;
    label636:
    Object localObject;
    label685:
    ADXml localADXml;
    float f2;
    float f1;
    int m;
    int n;
    if ((this.Jzk.isAd()) && (m.d(this.timeLineObject)))
    {
      j = 1;
      i = 0;
      if (this.Jzk != null) {
        i = this.Jzk.getAdXml().verticalVideoDisplayType;
      }
      if (i == 1)
      {
        paramView1 = o.dc(this.JKG.KKk.getUIContext());
        Log.i("MicroMsg.AdNormalSightDetailItem", "isVerticalAdVideo=true, snsId=" + t.Qu(this.Jzk.field_snsId) + ", showW=" + paramView1.first + ", showH=" + paramView1.second);
        paramView2 = paramView1;
        i = j;
        this.LiV = com.tencent.mm.plugin.sns.ad.timeline.b.b.b(this.Jzk.getAdXml());
        localObject = new StringBuilder("normal ad detail useOnlineVideo=").append(this.LiV).append(", snsId=");
        if (this.timeLineObject != null) {
          break label1285;
        }
        paramView1 = "";
        Log.i("MicroMsg.AdNormalSightDetailItem", paramView1);
        localVideoSightView.setEnableConfigChanged(false);
        localObject = this.Jzk;
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
                f2 = i.a(localADXml.adMediaDisplayWidth, 1, localADXml.adBasicRemWidth, localADXml.adBasicRootFontSize);
                f1 = i.a(localADXml.adMediaDisplayHeight, 1, localADXml.adBasicRemWidth, localADXml.adBasicRootFontSize);
                j = com.tencent.mm.ci.a.aY(this.context, i.d.SmallestPadding);
                m = this.context.getResources().getDimensionPixelSize(i.d.NormalPadding);
                n = com.tencent.mm.ci.a.aY(this.context, i.d.sns_avatar_size);
                if (localADXml.adMediaDisplayMode != 0) {
                  break label1296;
                }
                if (f2 < k - n - j - m - m) {
                  break label1457;
                }
                f2 = k - n - j - m - m;
                f1 = (int)(localADXml.adMediaDisplayHeight * f2 / localADXml.adMediaDisplayWidth);
              }
            }
          }
        }
      }
    }
    label919:
    label1443:
    label1457:
    for (;;)
    {
      paramView1 = Pair.create(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
      if ((this.Jzk.isAd()) && (!((SnsInfo)localObject).getAdXml().isLandingPagesAd()) && (((SnsInfo)localObject).getAdInfo().isWeapp()))
      {
        this.JKG.KKp.setVisibility(0);
        this.JKG.KKp.setImageResource(com.tencent.mm.plugin.sns.i.e.we_app_icon);
      }
      if (paramView1 != null)
      {
        if ((this.JKG.KKk instanceof SightPlayImageView))
        {
          if (i == 0) {
            break label1416;
          }
          this.JKG.KKk.setScaleMode(1);
          this.JKG.KKk.setScaleType(QImageView.a.Ydm);
        }
        label1021:
        localVideoSightView.ju(((Integer)paramView1.first).intValue(), ((Integer)paramView1.second).intValue());
        if ((this.JKG.KKk instanceof SightPlayImageView))
        {
          if (i == 0) {
            break label1443;
          }
          this.JKG.KKk.Jte = true;
        }
      }
      for (;;)
      {
        paramView2 = this.JKG.KKo.getLayoutParams();
        paramView2.width = ((Integer)paramView1.first).intValue();
        paramView2.height = ((Integer)paramView1.second).intValue();
        this.JKG.KKo.setLayoutParams(paramView2);
        paramView2 = (FrameLayout.LayoutParams)this.JKL.getLayoutParams();
        paramView2.width = ((Integer)paramView1.first).intValue();
        paramView2.height = ((Integer)paramView1.second).intValue();
        this.JKL.setLayoutParams(paramView2);
        this.JKG.KKk.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(225727);
            if (paramAnonymousInt != -1)
            {
              if (a.this.KPn == null)
              {
                AppMethodBeat.o(225727);
                return;
              }
              a.this.KPn.I(a.this.Jzk.field_snsId, false);
            }
            AppMethodBeat.o(225727);
          }
        });
        this.JKG.KKk.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(269081);
            Log.d("MicroMsg.AdNormalSightDetailItem", "onDecodeProgress:".concat(String.valueOf(paramAnonymousLong)));
            if ((a.this.KPn != null) && (a.this.Jzk != null))
            {
              a.this.KPn.Qm(a.this.Jzk.field_snsId);
              a.this.KPn.az(a.this.Jzk.field_snsId, 1000L * paramAnonymousLong);
              if (!a.this.KPn.Qj(a.this.Jzk.field_snsId))
              {
                int i = (int)paramAnonymousb.fIF();
                Log.i("MicroMsg.AdNormalSightDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                a.this.KPn.c(a.this.Jzk.field_snsId, Util.currentTicks(), false);
                a.this.KPn.e(a.this.Jzk.field_snsId, i, false);
                a.this.KPn.ay(a.this.Jzk.field_snsId, a.this.Jzk.field_snsId);
              }
            }
            AppMethodBeat.o(269081);
          }
        });
        localVideoSightView.setTagObject(this.JKG);
        localView.setTag(this.JKG);
        AppMethodBeat.o(268722);
        return;
        paramView1 = o.a(this.timeLineObject, this.JKG.KKk.getUIContext(), false);
        break;
        paramView2 = o.a(this.timeLineObject, this.JKG.KKk.getUIContext(), this.Jzk.isAd());
        i = 0;
        break label636;
        paramView1 = this.timeLineObject.Id;
        break label685;
        if (localADXml.adMediaDisplayMode == 1)
        {
          j = k - n - n - j - j - m - m;
          paramView1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * localADXml.adMediaDisplayHeight / localADXml.adMediaDisplayWidth)));
          break label919;
        }
        paramView1 = paramView2;
        if (localADXml.adMediaDisplayMode != 2) {
          break label919;
        }
        j = k - n - j - m - m;
        paramView1 = Pair.create(Integer.valueOf(j), Integer.valueOf((int)(j * localADXml.adMediaDisplayHeight / localADXml.adMediaDisplayWidth)));
        break label919;
        this.JKG.KKk.setScaleMode(0);
        this.JKG.KKk.setScaleType(QImageView.a.Ydh);
        break label1021;
        this.JKG.KKk.setDrawWidthAndHeightFix(false);
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(268726);
    try
    {
      Log.i("MicroMsg.AdNormalSightDetailItem", "onPause, isAdUseOnlineVideoView=" + this.LiV);
      if (this.LiV) {
        if (this.LiW != null) {
          this.LiW.dmi();
        }
      }
      for (;;)
      {
        if ((this.KPn != null) && (this.Jzk != null)) {
          this.KPn.Qn(this.Jzk.field_snsId);
        }
        AppMethodBeat.o(268726);
        return;
        if ((this.JKG != null) && (this.JKG.KKk != null)) {
          this.JKG.KKk.pause();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MicroMsg.AdNormalSightDetailItem", "onPause, exp=" + localThrowable.toString());
      AppMethodBeat.o(268726);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(268724);
    this.Jzk = f.bbk(this.Jzk.getSnsId());
    Log.i("MicroMsg.AdNormalSightDetailItem", "refreshView, hash=" + hashCode());
    cvt localcvt;
    label188:
    label607:
    if ((this.timeLineObject.ContentObj != null) && (this.timeLineObject.ContentObj.Sqr.size() > 0))
    {
      localcvt = (cvt)this.timeLineObject.ContentObj.Sqr.get(0);
      if (localcvt != null)
      {
        if (!this.LiV) {
          break label652;
        }
        d.a(this.Jzk, localcvt);
      }
      label108:
      if ((this.timeLineObject.ContentObj != null) && (this.timeLineObject.ContentObj.Sqr.size() > 0))
      {
        aj.fOF();
        if (g.u(localcvt)) {
          break label781;
        }
        if (!aj.fOF().x(localcvt)) {
          break label660;
        }
        this.JKG.JAL.setVisibility(8);
        this.JKG.KKn.setVisibility(0);
        this.JKG.KKn.hZF();
        if (!this.LiV) {
          break label1143;
        }
        aj.fOF().a(this.Jzk, localcvt, this.JKG.KKk, -1, this.context.hashCode(), 0, bp.VGo, this.Jzk.isAd(), false, false);
        if (this.LiW != null) {
          break label1096;
        }
        com.tencent.mm.plugin.sns.ad.i.l.M(this.JKL);
        this.LiW = new SnsTimelineVideoView(this.context, (byte)0);
        this.LiW.fUe();
        this.LiW.setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcH);
        this.LiW.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        com.tencent.mm.plugin.sns.ad.i.l.v(this.LiW, -1, -1);
        com.tencent.mm.plugin.sns.ad.i.l.w(this.LiW, true);
        com.tencent.mm.plugin.sns.ad.i.l.b(this.JKL, this.LiW, 0);
        this.LiW.setUICallback(new SnsTimelineVideoView.b()
        {
          public final void agY(String paramAnonymousString)
          {
            AppMethodBeat.i(227247);
            Log.w("MicroMsg.AdNormalSightDetailItem", "timelineVideoView setUICallback onDestroy");
            AppMethodBeat.o(227247);
          }
        });
        this.LiW.setVideoCallback(new com.tencent.mm.plugin.sns.ad.timeline.video.online.a(this.Jzk, this.LiW, this.KPn, 1));
        Log.i("MicroMsg.AdNormalSightDetailItem", "refreshView, new OnLineVideoView, hash=" + this.LiW.hashCode() + ", innerType=" + this.LiW.getInnerVideoView());
        this.LiW.setMute(true);
        this.LiW.a(localcvt, this.Jzk.getLocalid(), this.Jzk.getTimeLine().CreateTime);
        this.LiW.abandonAudioFocus();
        this.LiW.fhw();
        this.JMp.removeCallbacksAndMessages(null);
        this.JMp.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(244329);
            if ((a.this.LiW.isPlaying()) || (a.this.LiW.adH()))
            {
              Log.d("MicroMsg.AdNormalSightDetailItem", "resumePlay");
              a.this.LiW.fLJ();
              AppMethodBeat.o(244329);
              return;
            }
            Log.d("MicroMsg.AdNormalSightDetailItem", "onResume");
            a.this.LiW.onResume();
            AppMethodBeat.o(244329);
          }
        }, 250L);
        com.tencent.mm.plugin.sns.ad.i.l.w(this.JKG.KKn, false);
        label493:
        if (this.KPn != null)
        {
          String str1 = aq.kD(aj.getAccSnsPath(), localcvt.Id);
          String str2 = t.i(localcvt);
          str1 = str1 + str2;
          if (!u.agG(str1)) {
            break label1194;
          }
          this.KPn.f(this.Jzk.field_snsId, (int)localcvt.TDZ, true);
          if (d.No())
          {
            bool = v.isH265Video(str1);
            Log.i("MicroMsg.AdNormalSightDetailItem", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + str1);
          }
          if (aj.fOF().b(this.Jzk, null) != 5) {
            break label1217;
          }
        }
      }
    }
    label408:
    label1194:
    label1217:
    for (boolean bool = true;; bool = false)
    {
      this.KPn.d(this.Jzk.field_snsId, bool, false);
      AppMethodBeat.o(268724);
      return;
      localcvt = null;
      break;
      d.a(localcvt, false);
      break label108;
      if ((this.Jzk.isAd()) && (aj.fOF().b(this.Jzk, null) == 5))
      {
        aj.fOF().B(localcvt);
        this.JKG.JAL.setVisibility(8);
        this.JKG.KKn.setVisibility(0);
        this.JKG.KKn.hZF();
        break label188;
      }
      aj.fOF().z(localcvt);
      this.JKG.JAL.setVisibility(0);
      this.JKG.KKn.setVisibility(8);
      this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
      break label188;
      if (aj.fOF().v(localcvt))
      {
        this.JKG.JAL.setVisibility(0);
        this.JKG.KKn.setVisibility(8);
        this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
      }
      for (;;)
      {
        if (!this.JKG.KKk.JsW.fIC()) {
          break label1094;
        }
        Log.d("MicroMsg.AdNormalSightDetailItem", "play video error " + localcvt.Id + " " + localcvt.Url + " " + localcvt.TDF);
        aj.fOF().z(localcvt);
        this.JKG.JAL.setVisibility(0);
        this.JKG.KKn.setVisibility(8);
        this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
        break;
        if (aj.fOF().w(localcvt))
        {
          this.JKG.JAL.setVisibility(8);
          this.JKG.KKn.setVisibility(8);
        }
        else if ((this.Jzk.isAd()) && (aj.fOF().b(this.Jzk, null) <= 5))
        {
          this.JKG.JAL.setVisibility(8);
          this.JKG.KKn.setVisibility(8);
        }
        else
        {
          aj.fOF().z(localcvt);
          this.JKG.JAL.setVisibility(0);
          this.JKG.KKn.setVisibility(8);
          this.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.context, i.i.shortvideo_play_btn));
        }
      }
      label1094:
      break label188;
      label1096:
      Log.i("MicroMsg.AdNormalSightDetailItem", "refreshView, OnLineVideoView.hash=" + this.LiW.hashCode() + ", hasErr=" + this.LiW.wTx);
      break label408;
      label1143:
      aj.fOF().a(this.Jzk, localcvt, this.JKG.KKk, this.context.hashCode(), 0, bp.VGo, this.Jzk.isAd());
      this.JKG.KKk.start();
      break label493;
      this.KPn.f(this.Jzk.field_snsId, (int)localcvt.TDZ, false);
      break label607;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.a
 * JD-Core Version:    0.7.0.1
 */