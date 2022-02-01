package com.tencent.mm.plugin.sns.ad.timeline.c.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.ad.d.d;
import com.tencent.mm.plugin.sns.ad.widget.living.FinderLivingAnimWrapper;
import com.tencent.mm.plugin.sns.ad.widget.shakead.ShakeCoverView;
import com.tencent.mm.plugin.sns.ad.widget.twistad.TwistCoverView;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.ADXml.g;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView.b;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.plugin.thumbplayer.view.ThumbPlayerVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.u;

public final class a
{
  private static boolean JKo = false;
  private b JKi;
  private ADXml.g JKj;
  private com.tencent.mm.plugin.sns.ad.f.l JKk;
  private TimeLineObject JKl;
  private com.tencent.mm.plugin.sns.ad.widget.living.c JKm;
  public c JKn;
  private SnsInfo Jws;
  private Context mContext;
  
  public static void afc(int paramInt)
  {
    AppMethodBeat.i(229770);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvu, 0);
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        JKo = bool;
        com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "updateFullCardExptCfg, expt=" + i + ", snene=" + paramInt);
        if (paramInt == 1) {
          com.tencent.mm.plugin.report.service.h.IzE.el(1697, 21);
        }
        AppMethodBeat.o(229770);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      com.tencent.mm.sdk.platformtools.Log.e("FullCardAdWrapper", "updateAbTestCfg, exp=" + localThrowable.toString());
      AppMethodBeat.o(229770);
    }
  }
  
  public static boolean d(ADXml paramADXml)
  {
    AppMethodBeat.i(229768);
    if ((paramADXml != null) && (paramADXml.isLongPressGestureAd()))
    {
      com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, longPressAd disable");
      AppMethodBeat.o(229768);
      return false;
    }
    if (com.tencent.mm.plugin.sns.ad.c.Jxs == 1)
    {
      com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, force offline");
      AppMethodBeat.o(229768);
      return false;
    }
    if (com.tencent.mm.plugin.sns.ad.c.Jxs == 2)
    {
      com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView true, force online");
      AppMethodBeat.o(229768);
      return true;
    }
    if (!fLC())
    {
      com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, expt disable");
      AppMethodBeat.o(229768);
      return false;
    }
    if (!com.tencent.mm.plugin.sns.ad.timeline.b.b.a(paramADXml))
    {
      com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView false, adXml StreamingMode disable");
      AppMethodBeat.o(229768);
      return false;
    }
    com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "fullcard useOnlineVideoView true");
    AppMethodBeat.o(229768);
    return true;
  }
  
  public static boolean fLC()
  {
    AppMethodBeat.i(229765);
    try
    {
      int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vvt, 0);
      com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "isExptUseOnlineVideoView, expt=".concat(String.valueOf(i)));
      if (i > 0)
      {
        AppMethodBeat.o(229765);
        return true;
      }
      AppMethodBeat.o(229765);
      return false;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(229765);
    }
    return true;
  }
  
  public static void fLD()
  {
    AppMethodBeat.i(229774);
    afc(1);
    AppMethodBeat.o(229774);
  }
  
  public static boolean fLE()
  {
    AppMethodBeat.i(229778);
    if (com.tencent.mm.plugin.sns.ad.c.Jxt == 1)
    {
      com.tencent.mm.sdk.platformtools.Log.d("FullCardAdWrapper", "isUseNewFullCardItem false, force old");
      AppMethodBeat.o(229778);
      return false;
    }
    if (com.tencent.mm.plugin.sns.ad.c.Jxt == 2)
    {
      com.tencent.mm.sdk.platformtools.Log.d("FullCardAdWrapper", "isUseNewFullCardItem true, force new");
      AppMethodBeat.o(229778);
      return true;
    }
    com.tencent.mm.sdk.platformtools.Log.d("FullCardAdWrapper", "isUseNewFullCardItem expt=" + JKo);
    boolean bool = JKo;
    AppMethodBeat.o(229778);
    return bool;
  }
  
  public static b gg(View paramView)
  {
    AppMethodBeat.i(229737);
    b localb = new b();
    localb.AZc = paramView.findViewById(i.f.top_layer);
    localb.JKr = paramView.findViewById(i.f.bottom_layer);
    localb.zOg = ((TextView)paramView.findViewById(i.f.top_layer_title));
    localb.JKt = ((TextView)paramView.findViewById(i.f.top_layer_desc));
    localb.JKu = ((TextView)paramView.findViewById(i.f.bottom_layer_title));
    localb.JKv = ((TextView)paramView.findViewById(i.f.bottom_layer_desc));
    localb.JKw = paramView.findViewById(i.f.bottom_mini_program);
    localb.JKx = ((ImageView)paramView.findViewById(i.f.mini_program_icon));
    localb.JKy = ((TextView)paramView.findViewById(i.f.mini_program_txt));
    localb.JKs = ((MaskImageView)paramView.findViewById(i.f.full_card_img));
    localb.JKs.setScaleType(QImageView.a.Ydm);
    localb.JKG = new av();
    localb.JKG.KKm = paramView.findViewById(i.f.full_card_video);
    localb.JKG.KKj = localb.JKG.KKm;
    localb.JKG.KKk = ((VideoSightView)localb.JKG.KKm.findViewById(i.f.image));
    localb.JKG.KKl = ((SnsAdTimelineVideoView)localb.JKG.KKm.findViewById(i.f.offline_video));
    localb.JKG.KKl.setMute(true);
    localb.JKG.JAL = ((ImageView)paramView.findViewById(i.f.full_card_status_icon));
    localb.JKG.KKn = ((MMPinProgressBtn)localb.JKG.KKm.findViewById(i.f.progress));
    localb.JKG.KKo = ((TextView)localb.JKG.KKm.findViewById(i.f.endtv));
    localb.JKG.Ktc = ((TextView)localb.JKG.KKm.findViewById(i.f.errorTv));
    localb.JKA = ((ImageView)paramView.findViewById(i.f.front_cover));
    localb.JKB = ((ImageView)paramView.findViewById(i.f.end_cover));
    localb.JKH = ((ViewStub)paramView.findViewById(i.f.ad_live_status_layout_stub));
    localb.JKJ = ((ViewStub)paramView.findViewById(i.f.ad_live_anim_layout_stub));
    localb.JKL = ((ViewGroup)paramView.findViewById(i.f.full_card_online_video_container));
    AppMethodBeat.o(229737);
    return localb;
  }
  
  private static void n(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229754);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if ((localLayoutParams != null) && ((localLayoutParams.width != paramInt1) || (localLayoutParams.height != paramInt2)))
    {
      localLayoutParams.width = paramInt1;
      localLayoutParams.height = paramInt2;
      paramView.setLayoutParams(localLayoutParams);
    }
    AppMethodBeat.o(229754);
  }
  
  public final void a(b paramb, ADXml.g paramg, SnsInfo paramSnsInfo, TimeLineObject paramTimeLineObject, Context paramContext, com.tencent.mm.plugin.sns.ad.f.l paraml)
  {
    this.JKi = paramb;
    this.JKj = paramg;
    this.Jws = paramSnsInfo;
    this.mContext = paramContext;
    this.JKk = paraml;
    this.JKl = paramTimeLineObject;
  }
  
  public final void a(cvt paramcvt, com.tencent.mm.plugin.sns.model.g paramg, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(229752);
    long l1 = this.Jws.field_snsId;
    Object localObject1;
    Object localObject2;
    if (this.JKl.ContentObj.Sqq == 1)
    {
      this.JKi.JKs.setVisibility(0);
      this.JKi.JKG.KKj.setVisibility(4);
      localObject1 = this.JKi.JKs;
      paramInt = this.mContext.hashCode();
      localObject2 = bp.hzh();
      ((bp)localObject2).time = this.JKl.CreateTime;
      paramg.b(paramcvt, (View)localObject1, -1, paramInt, (bp)localObject2);
      this.JKi.JKO.JKq = false;
      paramg = this.Jws;
      if (paramg == null) {
        break label2171;
      }
    }
    for (;;)
    {
      try
      {
        if (paramg.getAdXml() == null) {
          break label2171;
        }
        if (paramg.getAdXml().adLiveInfo == null)
        {
          break label2171;
          if (paramInt == 0) {
            break label2120;
          }
          localObject1 = paramg.getTimeLine();
          if (this.JKi.JKI == null) {
            this.JKi.JKI = ((ViewGroup)this.JKi.JKH.inflate());
          }
          if (this.JKm == null) {
            this.JKm = new com.tencent.mm.plugin.sns.ad.widget.living.c(this.JKi.JKI, null, null);
          }
          if ((localObject1 == null) || (this.JKm == null)) {
            continue;
          }
          paramcvt = paramg.getAdXml().adLiveInfo;
          paramInt = com.tencent.mm.plugin.sns.ad.widget.living.b.fX(((TimeLineObject)localObject1).Id, paramcvt.liveType);
          this.JKm.a(((TimeLineObject)localObject1).Id, paramcvt);
          this.JKm.setLiveStatus(paramInt);
          com.tencent.mm.plugin.sns.ad.widget.living.b.a(((TimeLineObject)localObject1).Id, this.JKm);
          com.tencent.mm.plugin.sns.ad.timeline.dynamic.a.fLk().b(0, paramg);
          paramBoolean = com.tencent.mm.plugin.sns.ad.widget.living.c.afn(paramInt);
          paramg = ((TimeLineObject)localObject1).Id;
          if (!FinderLivingAnimWrapper.a(paramcvt, paramBoolean)) {
            continue;
          }
          if (this.JKi.JKK == null) {
            this.JKi.JKK = ((FinderLivingAnimWrapper)this.JKi.JKJ.inflate());
          }
          if (this.JKi.JKK == null) {
            continue;
          }
          paramInt = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 60);
          int i = com.tencent.mm.ci.a.fromDPToPix(this.mContext, 35);
          this.JKi.JKK.a(paramcvt, paramg, paramInt, i);
          this.JKi.JKK.setVisibility(0);
          AppMethodBeat.o(229752);
          return;
          if ((this.JKl.ContentObj.Sqq != 15) && (this.JKl.ContentObj.Sqq != 5)) {
            break;
          }
          this.JKi.JKG.KKl.setVisibility(0);
          this.JKi.JKG.KKk.setVisibility(8);
          if (this.JKj != null)
          {
            f.n(this.JKj.KjL, this.JKi.JKA);
            f.n(this.JKj.KjN, this.JKi.JKB);
          }
          d.a(this.Jws, paramcvt);
          long l2 = System.nanoTime();
          boolean bool = com.tencent.mm.plugin.sns.model.g.u(paramcvt);
          l2 = System.nanoTime() - l2;
          com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l2) });
          localObject1 = this.JKi.JKG;
          if (!bool)
          {
            if (paramg.x(paramcvt))
            {
              ((av)localObject1).JAL.setVisibility(8);
              ((av)localObject1).KKn.setVisibility(0);
              ((av)localObject1).KKn.hZF();
              this.JKi.JKs.setVisibility(4);
              ((av)localObject1).KKl.setTag(localObject1);
              f.a(this.JKj, 0, this.JKi.JKA, this.JKi.JKB);
              localObject2 = aq.kD(aj.getAccSnsPath(), paramcvt.Id);
              localObject3 = t.i(paramcvt);
              localObject2 = (String)localObject2 + (String)localObject3;
              paramInt = (int)paramcvt.TDZ;
              com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "media videoDuration=".concat(String.valueOf(l2)));
              if (!u.agG((String)localObject2)) {
                continue;
              }
              this.JKk.f(l1, paramInt, true);
              if (d.No())
              {
                bool = v.isH265Video((String)localObject2);
                com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "AdH265Helper, fileExists, isH265File=" + bool + ", path=" + (String)localObject2);
              }
              if (aj.fOF().b(this.Jws, null) != 5) {
                continue;
              }
              bool = true;
              this.JKk.d(l1, bool, false);
              if (!paramBoolean) {
                continue;
              }
              paramInt = 0;
              if (this.JKi.JKM != null) {
                continue;
              }
              paramInt = 1;
              com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "new onlineVideoView for init");
              if (paramInt != 0)
              {
                l1 = System.currentTimeMillis();
                com.tencent.mm.plugin.sns.ad.i.l.M(this.JKi.JKL);
                this.JKi.JKM = new SnsTimelineVideoView(this.mContext, (byte)0);
                this.JKi.JKM.fUe();
                this.JKi.JKM.setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcH);
                this.JKi.JKM.setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
                this.JKi.JKM.KHL = true;
                this.JKi.JKM.fhw();
                com.tencent.mm.plugin.sns.ad.i.l.v(this.JKi.JKM, -1, -1);
                com.tencent.mm.plugin.sns.ad.i.l.w(this.JKi.JKM, true);
                com.tencent.mm.plugin.sns.ad.i.l.b(this.JKi.JKL, this.JKi.JKM, -1);
                l2 = System.currentTimeMillis();
                paramg = new StringBuilder("onlineVideoView, inner VideoViewType=");
                localObject2 = this.JKi.JKM.getInnerVideoView();
                if (!(localObject2 instanceof VideoPlayerTextureView)) {
                  continue;
                }
                paramInt = 1;
                com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", paramInt + ", hash=" + this.JKi.JKM.hashCode() + ", cost=" + (l2 - l1));
              }
              this.JKi.JKM.setMute(true);
              this.JKi.JKM.setThumbViewVisibility(0);
              com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "onlineVideoView setVideoData, hash=" + this.JKi.JKM.hashCode());
              this.JKi.JKM.a(paramcvt, this.Jws.getLocalid(), this.Jws.getTimeLine().CreateTime);
              this.JKi.JKM.Lrv = this.JKl.Id;
              this.JKi.JKM.abandonAudioFocus();
              this.JKi.JKG.KKj.setVisibility(8);
              this.JKi.JKL.setVisibility(0);
              if (!paramBoolean) {
                continue;
              }
              this.JKi.JKM.setVideoCallback(new OnlineVideoView.b()
              {
                public final void AS(int paramAnonymousInt)
                {
                  AppMethodBeat.i(255213);
                  if (a.a(a.this) != null) {
                    a.a(a.this).aW(paramAnonymousInt, true);
                  }
                  AppMethodBeat.o(255213);
                }
                
                public final void onCompletion()
                {
                  AppMethodBeat.i(255210);
                  com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "online, onCompletion");
                  if (a.a(a.this) != null) {
                    a.a(a.this).yr(true);
                  }
                  AppMethodBeat.o(255210);
                }
                
                public final void onStart(int paramAnonymousInt)
                {
                  AppMethodBeat.i(255209);
                  com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "online, onStart:".concat(String.valueOf(paramAnonymousInt)));
                  if (a.a(a.this) != null) {
                    a.a(a.this).aV(paramAnonymousInt, true);
                  }
                  AppMethodBeat.o(255209);
                }
              });
              break;
            }
            if (paramg.b(this.Jws, null) == 5)
            {
              paramg.B(paramcvt);
              ((av)localObject1).JAL.setVisibility(8);
              ((av)localObject1).KKn.setVisibility(0);
              ((av)localObject1).KKn.hZF();
              continue;
            }
            if (paramg.y(paramcvt))
            {
              ((av)localObject1).KKn.setVisibility(8);
              ((av)localObject1).JAL.setImageResource(i.i.shortvideo_play_icon_err);
              ((av)localObject1).JAL.setVisibility(0);
              continue;
            }
            paramg.z(paramcvt);
            ((av)localObject1).JAL.setVisibility(0);
            ((av)localObject1).KKn.setVisibility(8);
            ((av)localObject1).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.shortvideo_play_btn));
            ((av)localObject1).JAL.setContentDescription(this.mContext.getString(i.j.play_sight_desc));
            if (paramg.b(this.Jws, null) != 4) {
              continue;
            }
            ((av)localObject1).Ktc.setVisibility(0);
            continue;
          }
          if (paramg.v(paramcvt))
          {
            ((av)localObject1).JAL.setVisibility(0);
            ((av)localObject1).KKn.setVisibility(8);
            ((av)localObject1).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.shortvideo_play_btn));
            ((av)localObject1).JAL.setContentDescription(this.mContext.getString(i.j.play_sight_desc));
            bool = false;
            if (paramBoolean)
            {
              if (this.JKi.JKM != null) {
                bool = this.JKi.JKM.wTx;
              }
              if (!bool) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.Log.e("FullCardAdWrapper", "play video error " + paramcvt.Id + " " + paramcvt.Url + " " + paramcvt.TDF + " " + paramInt + ", online=" + paramBoolean);
              paramg.z(paramcvt);
              ((av)localObject1).JAL.setVisibility(0);
              ((av)localObject1).KKn.setVisibility(8);
              ((av)localObject1).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.shortvideo_play_btn));
              ((av)localObject1).JAL.setContentDescription(this.mContext.getString(i.j.play_sight_desc));
              localObject2 = com.tencent.mm.plugin.report.service.h.IzE;
              if (!paramBoolean) {
                continue;
              }
              paramInt = 19;
              ((com.tencent.mm.plugin.report.service.h)localObject2).el(1697, paramInt);
            }
          }
          else
          {
            if (paramg.w(paramcvt))
            {
              ((av)localObject1).JAL.setVisibility(8);
              ((av)localObject1).KKn.setVisibility(8);
              continue;
            }
            if (paramg.b(this.Jws, null) <= 5)
            {
              if (this.JKi.JKO.scene == 1)
              {
                this.JKi.JKG.JAL.setVisibility(8);
                this.JKi.JKG.KKn.setVisibility(8);
                continue;
              }
              if ((this.JKi.JKO.JKq) || (this.JKn == null)) {
                continue;
              }
              com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "fillItem, showPlayBtn");
              this.JKn.fLF();
              continue;
            }
            paramg.z(paramcvt);
            ((av)localObject1).JAL.setVisibility(0);
            ((av)localObject1).KKn.setVisibility(8);
            ((av)localObject1).JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mContext, i.i.shortvideo_play_btn));
            ((av)localObject1).JAL.setContentDescription(this.mContext.getString(i.j.play_sight_desc));
            continue;
          }
          bool = ((av)localObject1).KKl.isError();
          continue;
          continue;
          paramInt = 18;
          continue;
          this.JKk.f(l1, paramInt, false);
          continue;
          bool = false;
          continue;
          if (this.JKi.JKM.Lrx)
          {
            paramInt = 1;
            com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "new onlineVideoView for waitDestroy");
            continue;
          }
          if (!this.JKi.JKM.wTx) {
            continue;
          }
          paramInt = 1;
          com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "new onlineVideoView for hasError");
          continue;
          if ((localObject2 instanceof VideoTextureView))
          {
            paramInt = 2;
            continue;
          }
          if ((localObject2 instanceof ThumbPlayerVideoView))
          {
            paramInt = 3;
            continue;
          }
          paramInt = 0;
          continue;
          this.JKi.JKG.KKj.setVisibility(0);
          this.JKi.JKL.setVisibility(8);
          localObject2 = this.Jws;
          Object localObject3 = ((av)localObject1).KKl;
          paramInt = this.mContext.hashCode();
          bp localbp = bp.hzh();
          localbp.time = this.JKl.CreateTime;
          paramg.a((SnsInfo)localObject2, paramcvt, (SnsAdTimelineVideoView)localObject3, paramInt, localbp, true);
          continue;
          ((av)localObject1).KKl.setVideoCallback(new OfflineVideoView.a()
          {
            public final void AS(int paramAnonymousInt)
            {
              AppMethodBeat.i(268568);
              if (a.a(a.this) != null) {
                a.a(a.this).aW(paramAnonymousInt, false);
              }
              AppMethodBeat.o(268568);
            }
            
            public final boolean a(PString paramAnonymousPString)
            {
              AppMethodBeat.i(268562);
              com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "offline, downloadVideo");
              AppMethodBeat.o(268562);
              return false;
            }
            
            public final void onCompletion()
            {
              AppMethodBeat.i(268567);
              com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "offline, onCompletion");
              if (a.a(a.this) != null) {
                a.a(a.this).yr(false);
              }
              AppMethodBeat.o(268567);
            }
            
            public final void onStart(int paramAnonymousInt)
            {
              AppMethodBeat.i(268565);
              com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "offline, onStart:".concat(String.valueOf(paramAnonymousInt)));
              if (a.a(a.this) != null) {
                a.a(a.this).aV(paramAnonymousInt, false);
              }
              AppMethodBeat.o(268565);
            }
          });
          break;
        }
        paramInt = 1;
        continue;
        if (this.JKi.JKK != null) {
          this.JKi.JKK.setVisibility(8);
        }
        AppMethodBeat.o(229752);
        return;
      }
      catch (Throwable paramcvt)
      {
        com.tencent.mm.sdk.platformtools.Log.e("FullCardAdWrapper", "fillLivingViewInfo, exp=" + android.util.Log.getStackTraceString(paramcvt));
        AppMethodBeat.o(229752);
        return;
      }
      label2120:
      if (this.JKi.JKI != null) {
        this.JKi.JKI.setVisibility(8);
      }
      if (this.JKi.JKK != null) {
        this.JKi.JKK.setVisibility(8);
      }
      AppMethodBeat.o(229752);
      return;
      label2171:
      paramInt = 0;
    }
  }
  
  public final ViewGroup.LayoutParams afb(int paramInt)
  {
    AppMethodBeat.i(229745);
    this.JKi.AZc.setVisibility(8);
    this.JKi.zOg.setVisibility(8);
    this.JKi.JKt.setVisibility(8);
    this.JKi.JKr.setVisibility(8);
    this.JKi.JKu.setVisibility(8);
    this.JKi.JKv.setVisibility(8);
    this.JKi.JKw.setVisibility(8);
    Object localObject1;
    if ((this.JKj != null) && (this.JKj.KjP != null) && (this.JKi.JKC == null))
    {
      localObject1 = (ViewStub)this.JKi.xYJ.findViewById(i.f.sns_end_cover_view_stub);
      if (localObject1 != null) {
        this.JKi.JKC = ((SnsAdCardVideoEndView)((ViewStub)localObject1).inflate());
      }
    }
    StringBuilder localStringBuilder;
    Object localObject2;
    label240:
    int i;
    if (this.JKj != null) {
      if (this.JKj.KjH == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        localStringBuilder = new StringBuilder("fillItemStyle, hash=").append(this.JKi.hashCode()).append(", snsId=");
        if (this.Jws != null) {
          break label888;
        }
        localObject2 = "";
        com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", (String)localObject2);
        if (localObject1 == null) {
          break label903;
        }
        n(this.JKi.xYJ, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        ((RoundedCornerFrameLayout)this.JKi.xYJ).setRadius(com.tencent.mm.ci.a.fromDPToPix(this.mContext, 8));
        n(this.JKi.JKs, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        n(this.JKi.JKG.KKl, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        n(this.JKi.JKL, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        n(this.JKi.JKA, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        n(this.JKi.JKB, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        if (this.JKi.JKC != null) {
          n(this.JKi.JKC, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        }
        if (this.JKj.KjJ != 0) {
          break label960;
        }
        paramInt = Color.argb((int)(this.JKj.KjI * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt, i });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.JKi.AZc.setBackground((Drawable)localObject2);
        if ((!Util.isNullOrNil(this.JKj.title)) || (!Util.isNullOrNil(this.JKj.description))) {
          this.JKi.AZc.setVisibility(0);
        }
        if (!Util.isNullOrNil(this.JKj.title))
        {
          this.JKi.zOg.setVisibility(0);
          this.JKi.zOg.setText(com.tencent.mm.cl.h.htZ().a(this.JKi.zOg.getContext(), this.JKj.title, this.JKi.zOg.getTextSize()));
        }
        if (!Util.isNullOrNil(this.JKj.description))
        {
          this.JKi.JKt.setVisibility(0);
          this.JKi.JKt.setText(com.tencent.mm.cl.h.htZ().a(this.JKi.JKt.getContext(), this.JKj.description, this.JKi.JKt.getTextSize()));
        }
        label671:
        if (!this.Jws.getAdInfo().isWeapp())
        {
          localObject2 = localObject1;
          if (!com.tencent.mm.plugin.sns.ad.d.l.a(this.Jws.getAdXml(), this.Jws.getAdInfo())) {}
        }
        else
        {
          paramInt = Color.argb((int)(this.JKj.KjI * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt, i });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.JKi.JKr.setBackground((Drawable)localObject2);
          this.JKi.JKr.setVisibility(0);
          this.JKi.JKw.setVisibility(0);
          if (!this.Jws.getAdInfo().isWeapp()) {
            break label1260;
          }
          this.JKi.JKy.setText(i.j.sns_ad_card_weapp_tag);
          this.JKi.JKx.setImageResource(com.tencent.mm.plugin.sns.i.e.mini_program_icon_white);
          localObject2 = localObject1;
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(229745);
      return localObject2;
      if (this.JKj.KjH == 1)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break;
        label888:
        localObject2 = t.Qu(this.Jws.field_snsId);
        break label240;
        label903:
        localStringBuilder = new StringBuilder("mediaLayout==null, snsId=");
        if (this.Jws == null) {}
        for (localObject2 = "";; localObject2 = Long.valueOf(this.Jws.field_snsId))
        {
          com.tencent.mm.sdk.platformtools.Log.e("FullCardAdWrapper", localObject2);
          break;
        }
        label960:
        if (this.JKj.KjJ != 1) {
          break label671;
        }
        paramInt = Color.argb((int)(this.JKj.KjI * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt, i });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.JKi.JKr.setBackground((Drawable)localObject2);
        if ((!Util.isNullOrNil(this.JKj.title)) || (!Util.isNullOrNil(this.JKj.description)))
        {
          this.JKi.JKr.setVisibility(0);
          localObject2 = (RelativeLayout.LayoutParams)this.JKi.JKw.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.ci.a.fromDPToPix(this.JKi.xYJ.getContext(), 4);
          this.JKi.JKw.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
        if (!Util.isNullOrNil(this.JKj.title))
        {
          this.JKi.JKu.setVisibility(0);
          this.JKi.JKu.setText(com.tencent.mm.cl.h.htZ().a(this.JKi.JKu.getContext(), this.JKj.title, this.JKi.JKu.getTextSize()));
        }
        if (Util.isNullOrNil(this.JKj.description)) {
          break label671;
        }
        this.JKi.JKv.setVisibility(0);
        this.JKi.JKv.setText(com.tencent.mm.cl.h.htZ().a(this.JKi.JKv.getContext(), this.JKj.description, this.JKi.JKv.getTextSize()));
        break label671;
        label1260:
        this.JKi.JKy.setText(i.j.finder_app_name);
        this.JKi.JKx.setImageResource(com.tencent.mm.plugin.sns.i.e.ad_fullcard_finder_icon_white);
        localObject2 = localObject1;
        continue;
      }
      localObject1 = null;
      break;
      localObject2 = null;
    }
  }
  
  public final void yd(boolean paramBoolean)
  {
    AppMethodBeat.i(229762);
    com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "startPlay, onlineVideo=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (this.JKi.JKM != null)
      {
        if ((this.JKi.JKM.isPlaying()) || (this.JKi.JKM.adH()))
        {
          com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "onlineVideo, resumePlay, hash=" + hashCode());
          this.JKi.JKM.fLJ();
          AppMethodBeat.o(229762);
          return;
        }
        com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "onlineVideo, onResume, hash=" + hashCode());
        this.JKi.JKM.onResume();
        AppMethodBeat.o(229762);
      }
    }
    else
    {
      this.JKi.JKG.KKl.setShouldPlayWhenPrepared(true);
      this.JKi.JKG.KKl.start();
    }
    AppMethodBeat.o(229762);
  }
  
  public final void yp(boolean paramBoolean)
  {
    AppMethodBeat.i(229758);
    com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "pausePlay, onlineVideo=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if ((this.JKi.JKM != null) && (this.JKi.JKM.isPlaying()))
      {
        this.JKi.JKM.dmi();
        AppMethodBeat.o(229758);
      }
    }
    else
    {
      this.JKi.JKG.KKl.setShouldPlayWhenPrepared(false);
      this.JKi.JKG.KKl.pause();
    }
    AppMethodBeat.o(229758);
  }
  
  public final void yq(boolean paramBoolean)
  {
    AppMethodBeat.i(229759);
    com.tencent.mm.sdk.platformtools.Log.i("FullCardAdWrapper", "restartPlay, onlineVideo=".concat(String.valueOf(paramBoolean)));
    if (paramBoolean)
    {
      if (this.JKi.JKM != null)
      {
        this.JKi.JKM.bc(0, true);
        AppMethodBeat.o(229759);
      }
    }
    else {
      this.JKi.JKG.KKl.bgP();
    }
    AppMethodBeat.o(229759);
  }
  
  public static final class a
  {
    public boolean JKq = false;
    public int scene;
  }
  
  public static final class b
  {
    public View AZc;
    public ImageView JKA;
    public ImageView JKB;
    public SnsAdCardVideoEndView JKC;
    public SnsAdTouchProgressView JKD;
    public SnsAdSphereAnimView JKE;
    public TwistCoverView JKF;
    public av JKG;
    public ViewStub JKH;
    public ViewGroup JKI;
    public ViewStub JKJ;
    public FinderLivingAnimWrapper JKK;
    public ViewGroup JKL;
    public SnsTimelineVideoView JKM;
    public ShakeCoverView JKN;
    public a.a JKO;
    public View JKr;
    public MaskImageView JKs;
    public TextView JKt;
    public TextView JKu;
    public TextView JKv;
    public View JKw;
    public ImageView JKx;
    public TextView JKy;
    public SnsDrawGestureView JKz;
    public View xYJ;
    public TextView zOg;
    
    public b()
    {
      AppMethodBeat.i(224389);
      this.JKO = new a.a();
      AppMethodBeat.o(224389);
    }
  }
  
  public static abstract interface c
  {
    public abstract void aV(int paramInt, boolean paramBoolean);
    
    public abstract void aW(int paramInt, boolean paramBoolean);
    
    public abstract void fLF();
    
    public abstract void yr(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.c.b.a
 * JD-Core Version:    0.7.0.1
 */