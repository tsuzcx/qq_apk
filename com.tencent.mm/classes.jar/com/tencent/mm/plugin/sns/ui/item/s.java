package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsns.o;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.bm;
import com.tencent.mm.plugin.sns.ui.bn;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.vfs.u;
import java.util.LinkedList;

public class s
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private SnsInfo Jws;
  private View.OnClickListener LjE;
  private boolean Lmj;
  private boolean Lob;
  private b.e Loc;
  private BaseTimeLineItem.BaseViewHolder Lod;
  View Loe;
  private String Lof;
  View Log;
  private boolean Loh;
  private int mScreenHeight;
  private int mScreenWidth;
  
  public s()
  {
    AppMethodBeat.i(100124);
    this.Lob = false;
    this.Loc = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt) {}
    };
    this.Loe = null;
    this.Lof = "";
    this.Log = null;
    this.Loh = false;
    this.LjE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(177696);
        Log.i("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          if (s.this.Kee.KYo.fTj() == 0) {
            s.this.Kee.Kdz.Lpo.onClick(paramAnonymousView);
          }
          for (;;)
          {
            s.b(s.this);
            AppMethodBeat.o(177696);
            return;
            if (s.this.Kee.KYo.fTj() == 1) {
              s.this.Kee.Kdz.Lpo.onClick(paramAnonymousView);
            }
          }
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.e("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(177696);
        }
      }
    };
    AppMethodBeat.o(100124);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100127);
    if (paramBoolean)
    {
      Log.i("MicroMsg.VideoTimeLineItem", "lxl setVideoStatusIvVisibility %s, but isPlaying", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(100127);
      return;
    }
    paramBaseViewHolder.JKG.JAL.setVisibility(paramInt);
    AppMethodBeat.o(100127);
  }
  
  private void ac(SnsInfo paramSnsInfo)
  {
    AppMethodBeat.i(267176);
    if ((this.Kee != null) && (this.Kee.KYo != null) && (this.Kee.KYo.KBN != null) && (paramSnsInfo != null)) {
      this.Kee.KYo.KBN.Qn(paramSnsInfo.field_snsId);
    }
    AppMethodBeat.o(267176);
  }
  
  private void doPause()
  {
    AppMethodBeat.i(177698);
    Log.i("MicroMsg.VideoTimeLineItem", "%s Ad Video doPause", new Object[] { this });
    if ((this.Lod != null) && (this.Lod.JKG != null))
    {
      this.Lod.JKG.KKk.pause();
      ac(this.Jws);
    }
    this.Lmj = false;
    AppMethodBeat.o(177698);
  }
  
  public final void a(ViewStub paramViewStub, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(267174);
    paramViewStub = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(paramViewStub);
    this.mScreenWidth = paramViewStub.widthPixels;
    this.mScreenHeight = paramViewStub.heightPixels;
    this.Lod = paramBaseViewHolder;
    if (paramBaseViewHolder.LkR != null)
    {
      paramBaseViewHolder.LkR.setLayoutResource(i.g.sns_media_sight_item);
      paramBaseViewHolder.LlI = ((ViewStub)paramBaseViewHolder.convertView.findViewById(i.f.images_keeper_li));
      if (!paramBaseViewHolder.LlJ) {
        paramBaseViewHolder.JKG.KKj = paramBaseViewHolder.LlI.inflate();
      }
    }
    for (paramBaseViewHolder.LlJ = true;; paramBaseViewHolder.LlJ = true)
    {
      paramBaseViewHolder.JKG.KKm = paramBaseViewHolder.JKG.KKj.findViewById(i.f.chatting_click_area);
      paramBaseViewHolder.JKG.KKk = ((VideoSightView)paramBaseViewHolder.JKG.KKj.findViewById(i.f.image));
      paramBaseViewHolder.JKG.KKk.setMute(true);
      paramBaseViewHolder.JKG.KKm.setOnClickListener(this.LjE);
      paramBaseViewHolder.JKG.JAL = ((ImageView)paramBaseViewHolder.JKG.KKj.findViewById(i.f.status_btn));
      paramBaseViewHolder.JKG.KKn = ((MMPinProgressBtn)paramBaseViewHolder.JKG.KKj.findViewById(i.f.progress));
      paramBaseViewHolder.JKG.KKo = ((TextView)paramBaseViewHolder.JKG.KKj.findViewById(i.f.endtv));
      paramBaseViewHolder.JKG.Ktc = ((TextView)paramBaseViewHolder.JKG.KKj.findViewById(i.f.errorTv));
      paramBaseViewHolder.JKG.KKp = ((ImageView)paramBaseViewHolder.JKG.KKj.findViewById(i.f.sns_sight_biz_icon));
      h.aHH();
      if (((Boolean)h.aHG().aHp().b(344065, Boolean.FALSE)).booleanValue())
      {
        paramViewStub = (TextView)((ViewStub)paramBaseViewHolder.JKG.KKj.findViewById(i.f.sight_info_viewstub)).inflate();
        paramBaseViewHolder.JKG.KKk.setSightInfoView(paramViewStub);
      }
      AppMethodBeat.o(267174);
      return;
      paramBaseViewHolder.JKG.KKj = paramBaseViewHolder.convertView.findViewById(i.f.sns_media_sight_item);
    }
  }
  
  public void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176431);
    Object localObject2 = aj.fOI().bbl(paramBaseViewHolder.fAg);
    if (localObject2 == null)
    {
      Log.w("MicroMsg.VideoTimeLineItem", "play error, snsId:%s", new Object[] { paramBaseViewHolder.fAg });
      AppMethodBeat.o(176431);
      return;
    }
    TimeLineObject localTimeLineObject = ((SnsInfo)localObject2).getTimeLine();
    if ((localTimeLineObject.ContentObj != null) && (localTimeLineObject.ContentObj.Sqr.size() > 0)) {}
    for (Object localObject1 = (cvt)localTimeLineObject.ContentObj.Sqr.get(0); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(176431);
      return;
    }
    if (((SnsInfo)localObject2).isAd())
    {
      Log.i("MicroMsg.VideoTimeLineItem", "%s Ad autoPlay", new Object[] { this });
      final long l = ((SnsInfo)localObject2).field_snsId;
      if (!this.Loh)
      {
        this.Loh = true;
        paramBaseViewHolder.JKG.KKk.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100121);
            if (paramAnonymousInt != -1)
            {
              if ((this.JHl == null) || (!this.JHl.isAd()))
              {
                Log.e("MicroMsg.VideoTimeLineItem", "onCompletion, !isAd,  snsId=" + t.Qu(l));
                AppMethodBeat.o(100121);
                return;
              }
              if ((s.this.Kee == null) || (s.this.Kee.KYo == null) || (s.this.Kee.KYo.KBN == null))
              {
                AppMethodBeat.o(100121);
                return;
              }
              s.this.Kee.KYo.KBN.I(l, false);
              Log.d("MicroMsg.VideoTimeLineItem", "onCompletion, retCode=" + paramAnonymousInt + ", snsId=" + t.Qu(l));
            }
            AppMethodBeat.o(100121);
          }
        });
        paramBaseViewHolder.JKG.KKk.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100122);
            if ((this.JHl == null) || (!this.JHl.isAd()))
            {
              Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, !isAd, currentTime=" + paramAnonymousLong + ", snsId=" + t.Qu(l));
              AppMethodBeat.o(100122);
              return;
            }
            if ((s.this.Kee == null) || (s.this.Kee.KYo == null) || (s.this.Kee.KYo.KBN == null))
            {
              AppMethodBeat.o(100122);
              return;
            }
            if (this.JHl != null)
            {
              s.this.Kee.KYo.KBN.Qm(this.JHl.field_snsId);
              s.this.Kee.KYo.KBN.az(this.JHl.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!s.this.Kee.KYo.KBN.Qj(l))
            {
              int i = (int)paramAnonymousb.fIF();
              s.this.Kee.KYo.KBN.c(l, Util.currentTicks(), false);
              s.this.Kee.KYo.KBN.e(l, i, false);
              s.this.Kee.KYo.KBN.ay(l, l);
              Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, addPlay3s, snsId=" + t.Qu(l));
            }
            Log.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + t.Qu(l));
            AppMethodBeat.o(100122);
          }
        });
      }
      for (;;)
      {
        e.fZg().dmi();
        com.tencent.mm.plugin.sns.ui.video.b.fYX().a(this);
        this.Lod.JKG.KKk.start();
        fLI();
        this.Lmj = true;
        this.Lob = false;
        AppMethodBeat.o(176431);
        return;
        Log.d("MicroMsg.VideoTimeLineItem", "play, hasSetListener=true");
      }
    }
    com.tencent.mm.plugin.sns.ui.video.b.fYX().pause();
    com.tencent.mm.plugin.sns.ui.video.d locald = new com.tencent.mm.plugin.sns.ui.video.d();
    locald.fVT = ((cvt)localObject1);
    locald.fAg = paramBaseViewHolder.fAg;
    locald.fLp = t.Qu(((SnsInfo)localObject2).field_snsId);
    localObject1 = aj.fOI().bbk(paramBaseViewHolder.fLp);
    if (localObject1 != null)
    {
      locald.createTime = ((SnsInfo)localObject1).getCreateTime();
      localObject2 = (FrameLayout)paramBaseViewHolder.JKG.KKj.findViewById(i.f.sns_video_container);
      if (((FrameLayout)localObject2).getChildCount() <= 0) {
        break label692;
      }
    }
    label692:
    for (localObject1 = (SnsTimelineVideoView)((FrameLayout)localObject2).getChildAt(0);; localObject1 = null)
    {
      if ((localObject1 != null) && (((SnsTimelineVideoView)localObject1).Lru != null) && (!((SnsTimelineVideoView)localObject1).Lrx) && (Util.isEqual(localTimeLineObject.Id, ((SnsTimelineVideoView)localObject1).Lrv)) && (Util.isEqual(((SnsTimelineVideoView)localObject1).Lru.fVT.Id, locald.fVT.Id))) {
        Log.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
      }
      for (;;)
      {
        ((SnsTimelineVideoView)localObject1).setVisibility(0);
        ((SnsTimelineVideoView)localObject1).setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcH);
        paramBaseViewHolder.JKG.KKj.findViewById(i.f.thumb_mask).setVisibility(8);
        if (paramBaseViewHolder.JKG.JAL != null) {
          paramBaseViewHolder.JKG.JAL.setVisibility(8);
        }
        ((SnsTimelineVideoView)localObject1).setUICallback(new SnsTimelineVideoView.b()
        {
          public final void agY(String paramAnonymousString)
          {
            AppMethodBeat.i(100123);
            Log.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", new Object[] { paramAnonymousString, s.a(s.this) });
            if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(s.a(s.this))) && (s.this.Log != null))
            {
              s.this.Log.setVisibility(0);
              Log.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
            }
            AppMethodBeat.o(100123);
          }
        });
        ((SnsTimelineVideoView)localObject1).setVideoCallback(null);
        e.fZg().a((OnlineVideoView)localObject1, locald, localTimeLineObject.Id);
        AppMethodBeat.o(176431);
        return;
        locald.createTime = ((int)(System.currentTimeMillis() / 1000L));
        break;
        e.fZg();
        if ((e.fZi()) && (localObject1 != null) && (((SnsTimelineVideoView)localObject1).Lru == null))
        {
          Log.i("MicroMsg.VideoTimeLineItem", "reuse videoview by precreate View:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
        }
        else
        {
          if (localObject1 != null) {
            ((FrameLayout)localObject2).removeViewAt(0);
          }
          localObject1 = e.fZg().ie(((FrameLayout)localObject2).getContext());
          if (((SnsTimelineVideoView)localObject1).getParent() != null)
          {
            ((SnsTimelineVideoView)localObject1).fZb();
            ((SnsTimelineVideoView)localObject1).Lry = true;
            ((ViewGroup)((SnsTimelineVideoView)localObject1).getParent()).removeView((View)localObject1);
          }
          ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
          ((SnsTimelineVideoView)localObject1).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
        }
      }
    }
  }
  
  public void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bn parambn, TimeLineObject paramTimeLineObject, int paramInt2, bm parambm)
  {
    AppMethodBeat.i(100126);
    this.Jws = parambn.Jws;
    cvt localcvt;
    if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqr.size() > 0))
    {
      localcvt = (cvt)paramTimeLineObject.ContentObj.Sqr.get(0);
      if ((this.Jws == null) || (!this.Jws.isAd())) {
        break label1777;
      }
      Log.i("MicroMsg.VideoTimeLineItem", "ad fillItem, videoItem, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
      label119:
      if (!e.fZg().bcz(paramTimeLineObject.Id)) {
        break label2966;
      }
    }
    label527:
    label2966:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.Lof = paramTimeLineObject.Id;
      this.Log = paramBaseViewHolder.JKG.JAL;
      g localg = aj.fOF();
      if (!parambn.KBz)
      {
        paramBaseViewHolder.JKG.KKk.setOnSightCompletionAction(null);
        paramBaseViewHolder.JKG.KKk.setOnCompletionListener(null);
        paramBaseViewHolder.JKG.KKk.setOnDecodeDurationListener(null);
      }
      paramBaseViewHolder.JKG.KKk.setIsAdVideo(parambn.KBz);
      if ((paramBaseViewHolder.JKG.KKi != null) && (!Util.isEqual(paramBaseViewHolder.JKG.KKi.Id, paramTimeLineObject.Id)))
      {
        Log.i("MicroMsg.VideoTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.JKG.KKi.Id });
        localg.a(paramBaseViewHolder.JKG.KKk, this.mActivity.hashCode(), 0);
      }
      paramBaseViewHolder.JKG.a(paramTimeLineObject, paramInt1, parambn.KDB, parambn.KBz);
      paramBaseViewHolder.JKG.Ktc.setVisibility(8);
      paramBaseViewHolder.JKG.KKp.setVisibility(8);
      long l;
      label444:
      Object localObject1;
      label504:
      Object localObject3;
      Object localObject2;
      label577:
      int i;
      if ((paramTimeLineObject.ContentObj != null) && (paramTimeLineObject.ContentObj.Sqr.size() > 0))
      {
        l = System.nanoTime();
        boolean bool2 = g.u(localcvt);
        Log.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
        if (!bool2) {
          if (localg.x(localcvt))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.JKG.KKn.setVisibility(0);
            paramBaseViewHolder.JKG.KKn.hZF();
            if ((!parambn.KBz) || (!m.d(paramBaseViewHolder.timeLineObject))) {
              break label2441;
            }
            paramInt2 = 0;
            if (this.Jws != null) {
              paramInt2 = this.Jws.getAdXml().verticalVideoDisplayType;
            }
            if (paramInt2 != 1) {
              break label2403;
            }
            localObject1 = o.dc(paramBaseViewHolder.JKG.KKk.getUIContext());
            localObject3 = new StringBuilder("isVerticalAdVideo=true, snsId=");
            if (parambn.Jws != null) {
              break label2426;
            }
            localObject2 = "";
            Log.i("MicroMsg.VideoTimeLineItem", localObject2 + ", showW=" + ((Pair)localObject1).first + ", showH=" + ((Pair)localObject1).second);
            paramInt2 = 1;
            localObject2 = localObject1;
            localObject3 = localObject2;
            if (parambn.KBz)
            {
              SnsInfo localSnsInfo = parambn.Jws;
              localObject3 = localSnsInfo.getAdXml();
              i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((ADXml)localObject3).adMediaDisplayWidth > 0.0F)
                {
                  localObject1 = localObject2;
                  if (((ADXml)localObject3).adMediaDisplayHeight > 0.0F)
                  {
                    float f3 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject3).adMediaDisplayWidth, 1, ((ADXml)localObject3).adBasicRemWidth, ((ADXml)localObject3).adBasicRootFontSize);
                    float f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((ADXml)localObject3).adMediaDisplayHeight, 1, ((ADXml)localObject3).adBasicRemWidth, ((ADXml)localObject3).adBasicRootFontSize);
                    if (((ADXml)localObject3).adMediaDisplayMode != 0) {
                      break label2470;
                    }
                    float f1 = f3;
                    if (f3 >= i - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12))
                    {
                      f1 = i - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12);
                      f2 = (int)(((ADXml)localObject3).adMediaDisplayHeight * f1 / ((ADXml)localObject3).adMediaDisplayWidth);
                    }
                    localObject1 = Pair.create(Integer.valueOf((int)f1), Integer.valueOf((int)f2));
                  }
                }
              }
              label826:
              localObject3 = localObject1;
              if (!localSnsInfo.getAdXml().isLandingPagesAd())
              {
                localObject3 = localObject1;
                if (localSnsInfo.getAdInfo().isWeapp())
                {
                  paramBaseViewHolder.JKG.KKp.setVisibility(0);
                  paramBaseViewHolder.JKG.KKp.setImageResource(com.tencent.mm.plugin.sns.i.e.we_app_icon);
                  localObject3 = localObject1;
                }
              }
            }
            i = ((Integer)((Pair)localObject3).first).intValue();
            int j = ((Integer)((Pair)localObject3).second).intValue();
            if ((paramBaseViewHolder.JKG.KKk instanceof SightPlayImageView))
            {
              if (parambn.KBz) {
                break label2670;
              }
              paramBaseViewHolder.JKG.KKk.setScaleMode(1);
              paramBaseViewHolder.JKG.KKk.setScaleType(QImageView.a.Ydm);
            }
            label954:
            paramBaseViewHolder.JKG.KKk.ju(i, j);
            if ((paramBaseViewHolder.JKG.KKk instanceof SightPlayImageView))
            {
              if (paramInt2 == 0) {
                break label2729;
              }
              paramBaseViewHolder.JKG.KKk.Jte = true;
            }
            label997:
            paramBaseViewHolder.JKG.KKk.setVisibility(0);
            localObject2 = paramBaseViewHolder.JKG.KKo.getLayoutParams();
            ((ViewGroup.LayoutParams)localObject2).width = i;
            ((ViewGroup.LayoutParams)localObject2).height = j;
            paramBaseViewHolder.JKG.KKo.setLayoutParams((ViewGroup.LayoutParams)localObject2);
            localObject1 = (FrameLayout)paramBaseViewHolder.JKG.KKj.findViewById(i.f.sns_video_container);
            localObject3 = (FrameLayout.LayoutParams)((FrameLayout)localObject1).getLayoutParams();
            ((FrameLayout.LayoutParams)localObject3).width = i;
            ((FrameLayout.LayoutParams)localObject3).height = j;
            ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
            localObject3 = paramBaseViewHolder.JKG.KKj.findViewById(i.f.thumb_mask);
            ((View)localObject3).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject2));
            ((View)localObject3).setVisibility(4);
            this.Loe = ((View)localObject1);
            localObject2 = e.fZg().bcC(paramTimeLineObject.Id);
            Log.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", new Object[] { paramTimeLineObject.Id, localObject2, Integer.valueOf(((FrameLayout)localObject1).getChildCount()) });
            if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof ImageView)))
            {
              ((FrameLayout)localObject1).removeAllViews();
              Log.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", new Object[] { paramTimeLineObject.Id });
            }
            if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof SnsTimelineVideoView)))
            {
              localObject3 = (SnsTimelineVideoView)((FrameLayout)localObject1).getChildAt(0);
              if (!paramTimeLineObject.Id.equals(((SnsTimelineVideoView)localObject3).Lrv))
              {
                ((FrameLayout)localObject1).removeAllViews();
                Log.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", new Object[] { paramTimeLineObject.Id, ((SnsTimelineVideoView)localObject3).Lrv });
              }
            }
            if ((localObject2 == null) || (((FrameLayout)localObject1).getChildCount() != 0)) {
              break label2743;
            }
            if ((((SnsTimelineVideoView)localObject2).getParent() != null) && (((SnsTimelineVideoView)localObject2).getParent() != localObject1))
            {
              ((SnsTimelineVideoView)localObject2).Lry = true;
              ((ViewGroup)((SnsTimelineVideoView)localObject2).getParent()).removeView((View)localObject2);
              ((SnsTimelineVideoView)localObject2).setVisibility(0);
              ((SnsTimelineVideoView)localObject2).setVideoScaleType(com.tencent.mm.pluginsdk.ui.i.e.RcH);
              ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
              Log.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
            }
            label1400:
            if (localObject2 != null)
            {
              localObject1 = paramBaseViewHolder.fAg;
              if (paramBaseViewHolder.timeLineObject != null) {
                break label2808;
              }
              paramInt2 = 0;
              ((SnsTimelineVideoView)localObject2).a(localcvt, (String)localObject1, paramInt2);
            }
            paramBaseViewHolder.JKG.KKk.setTagObject(paramBaseViewHolder.JKG);
            if ((parambn.Jws == null) || (!parambn.Jws.isAd()) || (!fLA())) {
              break label2820;
            }
            localObject1 = parambn.Jws;
            localObject2 = paramBaseViewHolder.JKG.KKk;
            paramInt2 = this.mActivity.hashCode();
            localObject3 = bp.hzh();
            ((bp)localObject3).time = paramTimeLineObject.CreateTime;
            localg.a((SnsInfo)localObject1, localcvt, (VideoSightView)localObject2, -1, paramInt2, paramInt1, (bp)localObject3, parambn.KBz, true, false);
            label1533:
            paramBaseViewHolder.JKG.KKm.setTag(paramBaseViewHolder.JKG);
            paramTimeLineObject = aq.kD(aj.getAccSnsPath(), localcvt.Id);
            localObject1 = t.i(localcvt);
            paramTimeLineObject = paramTimeLineObject + (String)localObject1;
            if (!u.agG(paramTimeLineObject)) {
              break label2884;
            }
            parambm.KYo.KBN.f(parambn.Lbm, (int)localcvt.TDZ, true);
            if ((com.tencent.mm.plugin.sns.ad.d.d.No()) && (parambn.KBz))
            {
              bool1 = v.isH265Video(paramTimeLineObject);
              Log.i("MicroMsg.VideoTimeLineItem", "AdH265Helper, fileExists, isH265File=" + bool1 + ", path=" + paramTimeLineObject);
            }
            if (!parambn.KBz) {
              break label2915;
            }
            if (aj.fOF().b(parambn.Jws, null) != 5) {
              break label2909;
            }
            bool1 = true;
            label1698:
            parambm.KYo.KBN.d(parambn.Lbm, bool1, false);
          }
        }
      }
      for (;;)
      {
        if ((parambn.Jws != null) && (!parambn.Jws.isCardAd())) {
          parambm.fXi().c(paramBaseViewHolder.JKG.KKm, parambm.Kdz.Lpf, parambm.Kdz.LoP);
        }
        AppMethodBeat.o(100126);
        return;
        localcvt = null;
        break;
        label1777:
        Log.i("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[] { Integer.valueOf(paramInt1) });
        break label119;
        if ((parambn.KBz) && (localg.b(parambn.Jws, null) == 5))
        {
          localg.B(localcvt);
          a(paramBaseViewHolder, 8, bool1);
          paramBaseViewHolder.JKG.KKn.setVisibility(0);
          paramBaseViewHolder.JKG.KKn.hZF();
          break label444;
        }
        if (localg.y(localcvt))
        {
          paramBaseViewHolder.JKG.KKn.setVisibility(8);
          paramBaseViewHolder.JKG.JAL.setImageResource(i.i.shortvideo_play_icon_err);
          a(paramBaseViewHolder, 0, bool1);
          break label444;
        }
        localg.z(localcvt);
        a(paramBaseViewHolder, 0, bool1);
        paramBaseViewHolder.JKG.KKn.setVisibility(8);
        paramBaseViewHolder.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
        paramBaseViewHolder.JKG.JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        if ((!parambn.KBz) && (localg.a(parambn.Jws, null) == 4))
        {
          paramBaseViewHolder.JKG.Ktc.setVisibility(0);
          break label444;
        }
        if ((!parambn.KBz) || (localg.b(parambn.Jws, null) != 4)) {
          break label444;
        }
        paramBaseViewHolder.JKG.Ktc.setVisibility(0);
        break label444;
        if (localg.v(localcvt))
        {
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.JKG.KKn.setVisibility(8);
          paramBaseViewHolder.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
          paramBaseViewHolder.JKG.JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
        }
        for (;;)
        {
          if (!paramBaseViewHolder.JKG.KKk.JsW.fIC()) {
            break label2401;
          }
          Log.e("MicroMsg.VideoTimeLineItem", "play video error " + localcvt.Id + " " + localcvt.Url + " " + localcvt.TDF + " " + paramInt1);
          localg.z(localcvt);
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.JKG.KKn.setVisibility(8);
          paramBaseViewHolder.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
          paramBaseViewHolder.JKG.JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          break;
          if (localg.w(localcvt))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.JKG.KKn.setVisibility(8);
          }
          else if ((parambn.KBz) && (localg.b(parambn.Jws, null) <= 5))
          {
            if (!this.Lob)
            {
              Log.i("MicroMsg.VideoTimeLineItem", "fillItem, showPlayBtn");
              fLF();
            }
          }
          else
          {
            localg.z(localcvt);
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.JKG.KKn.setVisibility(8);
            paramBaseViewHolder.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
            paramBaseViewHolder.JKG.JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
          }
        }
        label2401:
        break label444;
        label2403:
        localObject1 = o.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.JKG.KKk.getUIContext(), false);
        break label504;
        label2426:
        localObject2 = Long.valueOf(parambn.Jws.field_snsId);
        break label527;
        localObject2 = o.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.JKG.KKk.getUIContext(), parambn.KBz);
        paramInt2 = 0;
        break label577;
        label2470:
        if (((ADXml)localObject3).adMediaDisplayMode == 1)
        {
          i = i - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((ADXml)localObject3).adMediaDisplayHeight / ((ADXml)localObject3).adMediaDisplayWidth)));
          paramBaseViewHolder.LkO.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
          break label826;
        }
        localObject1 = localObject2;
        if (((ADXml)localObject3).adMediaDisplayMode != 2) {
          break label826;
        }
        i = i - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.ci.a.fromDPToPix(this.mActivity, 12);
        localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((ADXml)localObject3).adMediaDisplayHeight / ((ADXml)localObject3).adMediaDisplayWidth)));
        paramBaseViewHolder.LkO.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
        break label826;
        label2670:
        if (paramInt2 != 0)
        {
          paramBaseViewHolder.JKG.KKk.setScaleMode(1);
          paramBaseViewHolder.JKG.KKk.setScaleType(QImageView.a.Ydm);
          break label954;
        }
        paramBaseViewHolder.JKG.KKk.setScaleMode(0);
        paramBaseViewHolder.JKG.KKk.setScaleType(QImageView.a.Ydh);
        break label954;
        label2729:
        paramBaseViewHolder.JKG.KKk.setDrawWidthAndHeightFix(false);
        break label997;
        label2743:
        if ((bool1) || (((FrameLayout)localObject1).getChildCount() <= 0) || (e.fZg().bcA(paramTimeLineObject.Id))) {
          break label1400;
        }
        l = System.currentTimeMillis();
        ((FrameLayout)localObject1).removeViewAt(0);
        Log.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        break label1400;
        label2808:
        paramInt2 = paramBaseViewHolder.timeLineObject.CreateTime;
        break label1421;
        localObject1 = parambn.Jws;
        localObject2 = paramBaseViewHolder.JKG.KKk;
        paramInt2 = this.mActivity.hashCode();
        localObject3 = bp.hzh();
        ((bp)localObject3).time = paramTimeLineObject.CreateTime;
        localg.a((SnsInfo)localObject1, localcvt, (VideoSightView)localObject2, paramInt2, paramInt1, (bp)localObject3, parambn.KBz, true);
        break label1533;
        label2884:
        parambm.KYo.KBN.f(parambn.Lbm, (int)localcvt.TDZ, false);
        break label1673;
        label2909:
        bool1 = false;
        break label1698;
        label2915:
        if (aj.fOF().a(parambn.Jws, null) == 5)
        {
          bool1 = true;
          break label1698;
        }
        bool1 = false;
        break label1698;
        localg.a(paramBaseViewHolder.JKG.KKk, this.mActivity.hashCode(), paramInt1);
      }
    }
  }
  
  protected boolean fLA()
  {
    return false;
  }
  
  public final void fLF()
  {
    AppMethodBeat.i(176430);
    Log.i("MicroMsg.VideoTimeLineItem", "try show play btn");
    if ((this.Lod != null) && (this.Lod.JKG != null) && (!this.Lmj))
    {
      Log.i("MicroMsg.VideoTimeLineItem", "show play btn");
      this.Lod.JKG.JAL.setVisibility(0);
      this.Lod.JKG.KKn.setVisibility(8);
      this.Lod.JKG.JAL.setImageDrawable(com.tencent.mm.ci.a.m(this.mActivity, i.i.shortvideo_play_btn));
      this.Lod.JKG.JAL.setContentDescription(this.mActivity.getString(i.j.play_sight_desc));
    }
    AppMethodBeat.o(176430);
  }
  
  protected final void fLI()
  {
    AppMethodBeat.i(267175);
    Log.i("MicroMsg.VideoTimeLineItem", "try hide play btn");
    if ((this.Lod != null) && (this.Lod.JKG != null))
    {
      Log.i("MicroMsg.VideoTimeLineItem", "hide play btn");
      this.Lod.JKG.JAL.setVisibility(8);
      this.Lod.JKG.KKn.setVisibility(8);
    }
    AppMethodBeat.o(267175);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(100129);
    if (this.Loe != null)
    {
      Object localObject = new int[2];
      this.Loe.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.Loe.getMeasuredWidth() + i, this.Loe.getMeasuredHeight() + j);
      AppMethodBeat.o(100129);
      return localObject;
    }
    AppMethodBeat.o(100129);
    return null;
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177697);
    Log.i("MicroMsg.VideoTimeLineItem", "onUIPause");
    doPause();
    AppMethodBeat.o(177697);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176432);
    Log.i("MicroMsg.VideoTimeLineItem", "pause");
    doPause();
    fLF();
    AppMethodBeat.o(176432);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176433);
    Log.i("MicroMsg.VideoTimeLineItem", "%s Ad Video stop", new Object[] { this });
    if ((this.Lod != null) && (this.Lod.JKG != null)) {
      this.Lod.JKG.KKk.JsW.clear();
    }
    this.Lmj = false;
    AppMethodBeat.o(176433);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.s
 * JD-Core Version:    0.7.0.1
 */