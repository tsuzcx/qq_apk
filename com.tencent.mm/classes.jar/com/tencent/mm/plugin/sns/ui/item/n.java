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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.h;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.ao;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.AsyncNormalTextView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.OnlineVideoView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.video.SnsTimelineVideoView.b;
import com.tencent.mm.plugin.sns.ui.video.d;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import java.util.LinkedList;

public class n
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  private View.OnClickListener Aug;
  private boolean Awr;
  private boolean AxJ;
  private boolean AxK;
  private b.e AxL;
  private BaseTimeLineItem.BaseViewHolder AxM;
  View AxN;
  private String AxO;
  View AxP;
  private boolean AxQ;
  private int mScreenHeight;
  private int mScreenWidth;
  private p yVM;
  
  public n()
  {
    AppMethodBeat.i(100124);
    this.AxJ = false;
    this.AxK = false;
    this.AxL = new b.e()
    {
      public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt) {}
    };
    this.AxN = null;
    this.AxO = "";
    this.AxP = null;
    this.AxQ = false;
    this.Aug = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198555);
        ad.i("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          n.this.zpI.zpd.AyP.onClick(paramAnonymousView);
          n.b(n.this);
          AppMethodBeat.o(198555);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ad.e("MicroMsg.VideoTimeLineItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(198555);
        }
      }
    };
    AppMethodBeat.o(100124);
  }
  
  private void U(p paramp)
  {
    AppMethodBeat.i(198556);
    if ((this.zpI != null) && (this.zpI.AjE != null) && (this.zpI.AjE.zPb != null) && (paramp != null)) {
      this.zpI.AjE.zPb.zq(paramp.field_snsId);
    }
    AppMethodBeat.o(198556);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(100127);
    if (paramBoolean)
    {
      ad.i("MicroMsg.VideoTimeLineItem", "lxl setVideoStatusIvVisibility %s, but isPlaying", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(100127);
      return;
    }
    paramBaseViewHolder.Atv.zFD.setVisibility(paramInt);
    AppMethodBeat.o(100127);
  }
  
  private void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, f paramf, int paramInt)
  {
    AppMethodBeat.i(198559);
    ad.d("MicroMsg.VideoTimeLineItem", "cleanNewPlayerSnsSight is called, the position is ".concat(String.valueOf(paramInt)));
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.Atv == null) || (paramf == null))
    {
      AppMethodBeat.o(198559);
      return;
    }
    com.tencent.mm.plugin.sns.ad.timeline.a.c.a(paramBaseViewHolder.Atv.zWz, paramf, this.mActivity, paramInt);
    AppMethodBeat.o(198559);
  }
  
  private static void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, boolean paramBoolean)
  {
    AppMethodBeat.i(198557);
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.Atv == null))
    {
      AppMethodBeat.o(198557);
      return;
    }
    com.tencent.mm.plugin.sns.ad.timeline.a.c.a(paramBaseViewHolder.Atv.zWz, paramBoolean);
    AppMethodBeat.o(198557);
  }
  
  private void eei()
  {
    AppMethodBeat.i(177698);
    ad.i("MicroMsg.VideoTimeLineItem", "%s Ad Video doPause", new Object[] { this });
    if ((this.AxM != null) && (this.AxM.Atv != null))
    {
      if (!dRZ()) {
        break label73;
      }
      l(this.AxM);
    }
    for (;;)
    {
      U(this.yVM);
      this.Awr = false;
      AppMethodBeat.o(177698);
      return;
      label73:
      this.AxM.Atv.zWy.pause();
    }
  }
  
  private static void l(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(198558);
    if ((paramBaseViewHolder == null) || (paramBaseViewHolder.Atv == null))
    {
      AppMethodBeat.o(198558);
      return;
    }
    com.tencent.mm.plugin.sns.ad.timeline.a.c.c(paramBaseViewHolder.Atv.zWz);
    AppMethodBeat.o(198558);
  }
  
  public void a(final BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176431);
    Object localObject2 = ag.dUe().aAa(paramBaseViewHolder.doX);
    if (localObject2 == null)
    {
      ad.w("MicroMsg.VideoTimeLineItem", "play error, snsId:%s", new Object[] { paramBaseViewHolder.doX });
      AppMethodBeat.o(176431);
      return;
    }
    TimeLineObject localTimeLineObject = ((p)localObject2).dYl();
    if ((localTimeLineObject.HAT != null) && (localTimeLineObject.HAT.GaQ.size() > 0)) {}
    for (Object localObject1 = (byn)localTimeLineObject.HAT.GaQ.get(0); localObject1 == null; localObject1 = null)
    {
      AppMethodBeat.o(176431);
      return;
    }
    if (((p)localObject2).QM(32))
    {
      ad.i("MicroMsg.VideoTimeLineItem", "%s Ad autoPlay", new Object[] { this });
      final long l = ((p)localObject2).field_snsId;
      if (!this.AxQ)
      {
        this.AxQ = true;
        paramBaseViewHolder.Atv.zWy.setOnCompletionListener(new b.e()
        {
          public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
          {
            AppMethodBeat.i(100121);
            if (paramAnonymousInt != -1)
            {
              if ((this.zPy == null) || (!this.zPy.QM(32)))
              {
                ad.e("MicroMsg.VideoTimeLineItem", "onCompletion, !isAd,  snsId=" + com.tencent.mm.plugin.sns.data.q.zw(l));
                AppMethodBeat.o(100121);
                return;
              }
              if ((n.this.zpI == null) || (n.this.zpI.AjE == null) || (n.this.zpI.AjE.zPb == null))
              {
                AppMethodBeat.o(100121);
                return;
              }
              n.this.zpI.AjE.zPb.A(l, false);
              ad.d("MicroMsg.VideoTimeLineItem", "onCompletion, retCode=" + paramAnonymousInt + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zw(l));
            }
            AppMethodBeat.o(100121);
          }
        });
        paramBaseViewHolder.Atv.zWy.setOnDecodeDurationListener(new b.f()
        {
          public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
          {
            AppMethodBeat.i(100122);
            if ((this.zPy == null) || (!this.zPy.QM(32)))
            {
              ad.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, !isAd, currentTime=" + paramAnonymousLong + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zw(l));
              AppMethodBeat.o(100122);
              return;
            }
            if ((n.this.zpI == null) || (n.this.zpI.AjE == null) || (n.this.zpI.AjE.zPb == null))
            {
              AppMethodBeat.o(100122);
              return;
            }
            if (this.zPy != null)
            {
              n.this.zpI.AjE.zPb.zp(this.zPy.field_snsId);
              n.this.zpI.AjE.zPb.ak(this.zPy.field_snsId, 1000L * paramAnonymousLong);
            }
            if (!n.this.zpI.AjE.zPb.zm(l))
            {
              int i = (int)paramAnonymousb.dQg();
              n.this.zpI.AjE.zPb.d(l, bt.HI(), false);
              n.this.zpI.AjE.zPb.e(l, i, false);
              n.this.zpI.AjE.zPb.aj(l, l);
              ad.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, addPlay3s, snsId=" + com.tencent.mm.plugin.sns.data.q.zw(l));
            }
            ad.d("MicroMsg.VideoTimeLineItem", "onDecodeProgress, currentTime=" + paramAnonymousLong + ", snsId=" + com.tencent.mm.plugin.sns.data.q.zw(l));
            AppMethodBeat.o(100122);
          }
        });
        paramBaseViewHolder.Atv.zWz.setVideoCallback(new OfflineVideoView.a()
        {
          public final boolean a(PString paramAnonymousPString)
          {
            return false;
          }
          
          public final void onCompletion()
          {
            AppMethodBeat.i(198552);
            paramBaseViewHolder.Atv.zWz.restart();
            n.a(n.this, paramBaseViewHolder, this.zPy);
            AppMethodBeat.o(198552);
          }
          
          public final void onStart(int paramAnonymousInt)
          {
            AppMethodBeat.i(198551);
            ad.d("MicroMsg.VideoTimeLineItem", "onStart is called , the duration second is ".concat(String.valueOf(paramAnonymousInt)));
            AppMethodBeat.o(198551);
          }
          
          public final void tt(int paramAnonymousInt)
          {
            AppMethodBeat.i(198553);
            long l = paramBaseViewHolder.Atv.zWz.getDurationMs();
            n.a(n.this, paramBaseViewHolder, this.zPy, paramAnonymousInt, l);
            AppMethodBeat.o(198553);
          }
        });
        d.eeK().cxw();
        com.tencent.mm.plugin.sns.ui.video.b.eeD().a(this);
        if (!dRZ()) {
          break label301;
        }
        paramBaseViewHolder = this.AxM;
        if ((paramBaseViewHolder != null) && (paramBaseViewHolder.Atv != null)) {
          break label288;
        }
      }
      for (;;)
      {
        eeG();
        this.Awr = true;
        this.AxJ = false;
        AppMethodBeat.o(176431);
        return;
        ad.d("MicroMsg.VideoTimeLineItem", "play, hasSetListener=true");
        break;
        label288:
        com.tencent.mm.plugin.sns.ad.timeline.a.c.b(paramBaseViewHolder.Atv.zWz);
        continue;
        label301:
        this.AxM.Atv.zWy.start();
      }
    }
    com.tencent.mm.plugin.sns.ui.video.b.eeD().pause();
    com.tencent.mm.plugin.sns.ui.video.c localc = new com.tencent.mm.plugin.sns.ui.video.c();
    localc.dIQ = ((byn)localObject1);
    localc.doX = paramBaseViewHolder.doX;
    localc.dzb = com.tencent.mm.plugin.sns.data.q.zw(((p)localObject2).field_snsId);
    localObject1 = ag.dUe().azZ(paramBaseViewHolder.dzb);
    if (localObject1 != null)
    {
      localc.hZE = ((p)localObject1).field_createTime;
      localObject2 = (FrameLayout)paramBaseViewHolder.Atv.zWx.findViewById(2131305105);
      localObject1 = null;
      if (((FrameLayout)localObject2).getChildCount() > 0) {
        localObject1 = (SnsTimelineVideoView)((FrameLayout)localObject2).getChildAt(0);
      }
      if ((localObject1 == null) || (((SnsTimelineVideoView)localObject1).AAW == null) || (((SnsTimelineVideoView)localObject1).ABa) || (!bt.lQ(localTimeLineObject.Id, ((SnsTimelineVideoView)localObject1).AAX)) || (!bt.lQ(((SnsTimelineVideoView)localObject1).AAW.dIQ.Id, localc.dIQ.Id))) {
        break label619;
      }
      ad.i("MicroMsg.VideoTimeLineItem", "reuse videoview:%s", new Object[] { Integer.valueOf(localObject1.hashCode()) });
    }
    for (;;)
    {
      ((SnsTimelineVideoView)localObject1).setVisibility(0);
      ((SnsTimelineVideoView)localObject1).setVideoScaleType(i.e.ESP);
      paramBaseViewHolder.Atv.zWx.findViewById(2131305799).setVisibility(8);
      if (paramBaseViewHolder.Atv.zFD != null) {
        paramBaseViewHolder.Atv.zFD.setVisibility(8);
      }
      ((SnsTimelineVideoView)localObject1).setUICallback(new SnsTimelineVideoView.b()
      {
        public final void Pj(String paramAnonymousString)
        {
          AppMethodBeat.i(198554);
          ad.i("MicroMsg.VideoTimeLineItem", "onDestroy UICallback %s, %s", new Object[] { paramAnonymousString, n.a(n.this) });
          if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals(n.a(n.this))) && (n.this.AxP != null))
          {
            n.this.AxP.setVisibility(0);
            ad.i("MicroMsg.VideoTimeLineItem", "onDestroy show videoStatusIv");
          }
          AppMethodBeat.o(198554);
        }
      });
      d.eeK().a((OnlineVideoView)localObject1, localc, localTimeLineObject.Id);
      AppMethodBeat.o(176431);
      return;
      localc.hZE = ((int)(System.currentTimeMillis() / 1000L));
      break;
      label619:
      if (localObject1 != null) {
        ((FrameLayout)localObject2).removeViewAt(0);
      }
      localObject1 = d.eeK().gn(((FrameLayout)localObject2).getContext());
      if (((SnsTimelineVideoView)localObject1).getParent() != null)
      {
        ((SnsTimelineVideoView)localObject1).eeI();
        ((SnsTimelineVideoView)localObject1).ABb = true;
        ((ViewGroup)((SnsTimelineVideoView)localObject1).getParent()).removeView((View)localObject1);
      }
      ((FrameLayout)localObject2).addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      ((SnsTimelineVideoView)localObject1).setThumbViewScaleType(ImageView.ScaleType.CENTER_CROP);
    }
  }
  
  public void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, bh parambh)
  {
    AppMethodBeat.i(100126);
    this.yVM = parambi.yVM;
    byn localbyn;
    if ((paramTimeLineObject.HAT != null) && (paramTimeLineObject.HAT.GaQ.size() > 0))
    {
      localbyn = (byn)paramTimeLineObject.HAT.GaQ.get(0);
      ad.i("MicroMsg.VideoTimeLineItem", "videoTImeline %d ", new Object[] { Integer.valueOf(paramInt1) });
      if (!d.eeK().aBh(paramTimeLineObject.Id)) {
        break label2838;
      }
    }
    label520:
    label909:
    label1301:
    label2838:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.AxO = paramTimeLineObject.Id;
      this.AxP = paramBaseViewHolder.Atv.zFD;
      f localf = ag.dUb();
      if (!parambi.zOM)
      {
        paramBaseViewHolder.Atv.zWy.setOnSightCompletionAction(null);
        paramBaseViewHolder.Atv.zWy.setOnCompletionListener(null);
        paramBaseViewHolder.Atv.zWy.setOnDecodeDurationListener(null);
        if (paramBaseViewHolder.Atv.zWz != null) {
          paramBaseViewHolder.Atv.zWz.setVideoCallback(null);
        }
      }
      paramBaseViewHolder.Atv.zWy.setIsAdVideo(parambi.zOM);
      if ((paramBaseViewHolder.Atv.zWw != null) && (!bt.lQ(paramBaseViewHolder.Atv.zWw.Id, paramTimeLineObject.Id)))
      {
        ad.i("MicroMsg.VideoTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.Atv.zWw.Id });
        localf.a(paramBaseViewHolder.Atv.zWy, this.mActivity.hashCode(), 0);
        a(paramBaseViewHolder, localf, 0);
      }
      paramBaseViewHolder.Atv.a(paramTimeLineObject, paramInt1, parambi.zQD, parambi.zOM);
      paramBaseViewHolder.Atv.zFE.setVisibility(8);
      long l;
      label414:
      Object localObject2;
      Object localObject3;
      Object localObject1;
      label477:
      int i;
      float f2;
      float f1;
      if ((paramTimeLineObject.HAT != null) && (paramTimeLineObject.HAT.GaQ.size() > 0))
      {
        l = System.nanoTime();
        boolean bool2 = f.t(localbyn);
        ad.i("MicroMsg.VideoTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool2), Long.valueOf(System.nanoTime() - l) });
        if (!bool2) {
          if (localf.w(localbyn))
          {
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.Atv.zWB.setVisibility(0);
            paramBaseViewHolder.Atv.zWB.fLr();
            if ((!parambi.zOM) || (!j.d(paramBaseViewHolder.timeLineObject))) {
              break label2179;
            }
            paramInt2 = 1;
            localObject2 = h.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.Atv.zWy.getUIContext(), false);
            localObject3 = new StringBuilder("isVerticalAdVideo=true, snsId=");
            if (parambi.yVM != null) {
              break label2164;
            }
            localObject1 = "";
            ad.i("MicroMsg.VideoTimeLineItem", localObject1 + ", showW=" + ((Pair)localObject2).first + ", showH=" + ((Pair)localObject2).second);
            localObject1 = localObject2;
            if (parambi.zOM)
            {
              localObject3 = parambi.yVM.dRL();
              i = ((WindowManager)this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                localObject1 = localObject2;
                if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY > 0.0F)
                {
                  localObject1 = localObject2;
                  if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ > 0.0F)
                  {
                    f2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwa, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwb);
                    f1 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.a(((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ, 1, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwa, ((com.tencent.mm.plugin.sns.storage.b)localObject3).zwb);
                    if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvX != 0) {
                      break label2208;
                    }
                    if (f2 < i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12)) {
                      break label2835;
                    }
                    f2 = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12);
                    f1 = (int)(((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ * f2 / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY);
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject1 = Pair.create(Integer.valueOf((int)f2), Integer.valueOf((int)f1));
        label761:
        i = ((Integer)((Pair)localObject1).first).intValue();
        int j = ((Integer)((Pair)localObject1).second).intValue();
        if ((paramBaseViewHolder.Atv.zWy instanceof SightPlayImageView))
        {
          if (!parambi.zOM)
          {
            paramBaseViewHolder.Atv.zWy.setScaleMode(1);
            paramBaseViewHolder.Atv.zWy.setScaleType(QImageView.a.KTb);
          }
        }
        else
        {
          label831:
          paramBaseViewHolder.Atv.zWy.hw(i, j);
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.Atv != null)) {
            break label2467;
          }
          label856:
          if ((paramBaseViewHolder.Atv.zWy instanceof SightPlayImageView))
          {
            if (paramInt2 == 0) {
              break label2484;
            }
            paramBaseViewHolder.Atv.zWy.ySy = true;
          }
          label885:
          if (!dRZ()) {
            break label2498;
          }
          a(paramBaseViewHolder, true);
          paramBaseViewHolder.Atv.zWy.setVisibility(8);
          localObject2 = paramBaseViewHolder.Atv.zWC.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject2).width = i;
          ((ViewGroup.LayoutParams)localObject2).height = j;
          paramBaseViewHolder.Atv.zWC.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          localObject1 = (FrameLayout)paramBaseViewHolder.Atv.zWx.findViewById(2131305105);
          localObject3 = (FrameLayout.LayoutParams)((FrameLayout)localObject1).getLayoutParams();
          ((FrameLayout.LayoutParams)localObject3).width = i;
          ((FrameLayout.LayoutParams)localObject3).height = j;
          ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
          localObject3 = paramBaseViewHolder.Atv.zWx.findViewById(2131305799);
          ((View)localObject3).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject2));
          ((View)localObject3).setVisibility(4);
          this.AxN = ((View)localObject1);
          localObject2 = d.eeK().aBk(paramTimeLineObject.Id);
          ad.i("MicroMsg.VideoTimeLineItem", "lxl fill itemview check videoView reAttach, tlObjId:%s, vv:%s, count:%s", new Object[] { paramTimeLineObject.Id, localObject2, Integer.valueOf(((FrameLayout)localObject1).getChildCount()) });
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof ImageView)))
          {
            ((FrameLayout)localObject1).removeAllViews();
            ad.i("MicroMsg.VideoTimeLineItem", "find thumbView thne remove it %s", new Object[] { paramTimeLineObject.Id });
          }
          if ((((FrameLayout)localObject1).getChildCount() == 1) && ((((FrameLayout)localObject1).getChildAt(0) instanceof SnsTimelineVideoView)))
          {
            localObject3 = (SnsTimelineVideoView)((FrameLayout)localObject1).getChildAt(0);
            if (!paramTimeLineObject.Id.equals(((SnsTimelineVideoView)localObject3).AAX))
            {
              ((FrameLayout)localObject1).removeAllViews();
              ad.i("MicroMsg.VideoTimeLineItem", "find diff id then remove it %s %s", new Object[] { paramTimeLineObject.Id, ((SnsTimelineVideoView)localObject3).AAX });
            }
          }
          if ((localObject2 == null) || (((FrameLayout)localObject1).getChildCount() != 0)) {
            break label2517;
          }
          if ((((SnsTimelineVideoView)localObject2).getParent() != null) && (((SnsTimelineVideoView)localObject2).getParent() != localObject1))
          {
            ((SnsTimelineVideoView)localObject2).ABb = true;
            ((ViewGroup)((SnsTimelineVideoView)localObject2).getParent()).removeView((View)localObject2);
            ((SnsTimelineVideoView)localObject2).setVisibility(0);
            ((SnsTimelineVideoView)localObject2).setVideoScaleType(i.e.ESP);
            ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1));
            ad.i("MicroMsg.VideoTimeLineItem", "lxl reAttach succ");
          }
          if (localObject2 != null)
          {
            localObject1 = paramBaseViewHolder.doX;
            if (paramBaseViewHolder.timeLineObject != null) {
              break label2582;
            }
            paramInt2 = 0;
            label1322:
            ((SnsTimelineVideoView)localObject2).a(localbyn, (String)localObject1, paramInt2);
          }
          if (!dRZ()) {
            break label2663;
          }
          if ((paramBaseViewHolder != null) && (paramBaseViewHolder.Atv != null) && (paramBaseViewHolder.Atv.zWz != null) && (localf != null) && (parambi != null) && (localbyn != null) && (paramTimeLineObject != null)) {
            break label2594;
          }
          label1380:
          paramBaseViewHolder.Atv.zWA.setTag(paramBaseViewHolder.Atv);
          paramTimeLineObject = ao.jo(ag.getAccSnsPath(), localbyn.Id);
          localObject1 = com.tencent.mm.plugin.sns.data.q.i(localbyn);
          if (!com.tencent.mm.vfs.i.fv(paramTimeLineObject + (String)localObject1)) {
            break label2741;
          }
          parambh.AjE.zPb.B(parambi.AmB, true);
          label1456:
          if (!parambi.zOM) {
            break label2766;
          }
          if (ag.dUb().b(parambi.yVM, null) != 5) {
            break label2760;
          }
          bool1 = true;
          label1481:
          parambh.AjE.zPb.c(parambi.AmB, bool1, false);
        }
        for (;;)
        {
          if ((parambi.yVM != null) && (!parambi.yVM.dVZ())) {
            parambh.ecN().c(paramBaseViewHolder.Atv.zWA, parambh.zpd.AyG, parambh.zpd.Ayq);
          }
          AppMethodBeat.o(100126);
          return;
          localbyn = null;
          break;
          if ((parambi.zOM) && (localf.b(parambi.yVM, null) == 5))
          {
            localf.A(localbyn);
            a(paramBaseViewHolder, 8, bool1);
            paramBaseViewHolder.Atv.zWB.setVisibility(0);
            paramBaseViewHolder.Atv.zWB.fLr();
            break label414;
          }
          if (localf.x(localbyn))
          {
            paramBaseViewHolder.Atv.zWB.setVisibility(8);
            paramBaseViewHolder.Atv.zFD.setImageResource(2131691612);
            a(paramBaseViewHolder, 0, bool1);
            break label414;
          }
          localf.y(localbyn);
          a(paramBaseViewHolder, 0, bool1);
          paramBaseViewHolder.Atv.zWB.setVisibility(8);
          paramBaseViewHolder.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
          paramBaseViewHolder.Atv.zFD.setContentDescription(this.mActivity.getString(2131761939));
          if ((!parambi.zOM) && (localf.a(parambi.yVM, null) == 4))
          {
            paramBaseViewHolder.Atv.zFE.setVisibility(0);
            break label414;
          }
          if ((!parambi.zOM) || (localf.b(parambi.yVM, null) != 4)) {
            break label414;
          }
          paramBaseViewHolder.Atv.zFE.setVisibility(0);
          break label414;
          if (localf.u(localbyn))
          {
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.Atv.zWB.setVisibility(8);
            paramBaseViewHolder.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
            paramBaseViewHolder.Atv.zFD.setContentDescription(this.mActivity.getString(2131761939));
          }
          for (;;)
          {
            if (!paramBaseViewHolder.Atv.zWy.ySq.dQd()) {
              break label2162;
            }
            ad.e("MicroMsg.VideoTimeLineItem", "play video error " + localbyn.Id + " " + localbyn.Url + " " + localbyn.GSI + " " + paramInt1);
            localf.y(localbyn);
            a(paramBaseViewHolder, 0, bool1);
            paramBaseViewHolder.Atv.zWB.setVisibility(8);
            paramBaseViewHolder.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
            paramBaseViewHolder.Atv.zFD.setContentDescription(this.mActivity.getString(2131761939));
            break;
            if (localf.v(localbyn))
            {
              a(paramBaseViewHolder, 8, bool1);
              paramBaseViewHolder.Atv.zWB.setVisibility(8);
            }
            else if ((parambi.zOM) && (localf.b(parambi.yVM, null) <= 5))
            {
              if (!this.AxJ)
              {
                ad.i("MicroMsg.VideoTimeLineItem", "fillItem, showPlayBtn");
                eeg();
              }
            }
            else
            {
              localf.y(localbyn);
              a(paramBaseViewHolder, 0, bool1);
              paramBaseViewHolder.Atv.zWB.setVisibility(8);
              paramBaseViewHolder.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
              paramBaseViewHolder.Atv.zFD.setContentDescription(this.mActivity.getString(2131761939));
            }
          }
          label2162:
          break label414;
          label2164:
          localObject1 = Long.valueOf(parambi.yVM.field_snsId);
          break label477;
          localObject2 = h.a(paramBaseViewHolder.timeLineObject, paramBaseViewHolder.Atv.zWy.getUIContext(), parambi.zOM);
          paramInt2 = 0;
          break label520;
          label2208:
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvX == 1)
          {
            i = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12);
            localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY)));
            paramBaseViewHolder.AuZ.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
            break label761;
          }
          localObject1 = localObject2;
          if (((com.tencent.mm.plugin.sns.storage.b)localObject3).zvX != 2) {
            break label761;
          }
          i = i - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 50) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12) - com.tencent.mm.cc.a.fromDPToPix(this.mActivity, 12);
          localObject1 = Pair.create(Integer.valueOf(i), Integer.valueOf((int)(i * ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvZ / ((com.tencent.mm.plugin.sns.storage.b)localObject3).zvY)));
          paramBaseViewHolder.AuZ.setLayoutParams(new LinearLayout.LayoutParams(i, -2));
          break label761;
          if (paramInt2 != 0)
          {
            paramBaseViewHolder.Atv.zWy.setScaleMode(1);
            paramBaseViewHolder.Atv.zWy.setScaleType(QImageView.a.KTb);
            break label831;
          }
          paramBaseViewHolder.Atv.zWy.setScaleMode(0);
          paramBaseViewHolder.Atv.zWy.setScaleType(QImageView.a.KSW);
          break label831;
          label2467:
          com.tencent.mm.plugin.sns.ad.timeline.a.c.a(paramBaseViewHolder.Atv.zWz, i, j);
          break label856;
          label2484:
          paramBaseViewHolder.Atv.zWy.setDrawWidthAndHeightFix(false);
          break label885;
          label2498:
          a(paramBaseViewHolder, false);
          paramBaseViewHolder.Atv.zWy.setVisibility(0);
          break label909;
          label2517:
          if ((bool1) || (((FrameLayout)localObject1).getChildCount() <= 0) || (d.eeK().aBi(paramTimeLineObject.Id))) {
            break label1301;
          }
          l = System.currentTimeMillis();
          ((FrameLayout)localObject1).removeViewAt(0);
          ad.i("MicroMsg.VideoTimeLineItem", "lxl item remove videoview cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          break label1301;
          label2582:
          paramInt2 = paramBaseViewHolder.timeLineObject.CreateTime;
          break label1322;
          label2594:
          paramBaseViewHolder.Atv.zWz.setTag(paramBaseViewHolder.Atv);
          localObject1 = paramBaseViewHolder.Atv.zWz;
          localObject2 = parambi.yVM;
          localObject3 = this.mActivity;
          bj localbj = bj.frn();
          localbj.hbR = paramTimeLineObject.CreateTime;
          com.tencent.mm.plugin.sns.ad.timeline.a.c.a((SnsAdTimelineVideoView)localObject1, localf, (p)localObject2, (Activity)localObject3, localbyn, paramInt1, localbj);
          break label1380;
          label2663:
          paramBaseViewHolder.Atv.zWy.setTagObject(paramBaseViewHolder.Atv);
          localObject1 = parambi.yVM;
          localObject2 = paramBaseViewHolder.Atv.zWy;
          paramInt2 = this.mActivity.hashCode();
          localObject3 = bj.frn();
          ((bj)localObject3).hbR = paramTimeLineObject.CreateTime;
          localf.a((p)localObject1, localbyn, (VideoSightView)localObject2, paramInt2, paramInt1, (bj)localObject3, parambi.zOM, true);
          break label1380;
          label2741:
          parambh.AjE.zPb.B(parambi.AmB, false);
          break label1456;
          label2760:
          bool1 = false;
          break label1481;
          label2766:
          if (ag.dUb().a(parambi.yVM, null) == 5)
          {
            bool1 = true;
            break label1481;
          }
          bool1 = false;
          break label1481;
          if (dRZ()) {
            a(paramBaseViewHolder, localf, paramInt1);
          } else {
            localf.a(paramBaseViewHolder.Atv.zWy, this.mActivity.hashCode(), paramInt1);
          }
        }
      }
    }
  }
  
  protected boolean dRZ()
  {
    AppMethodBeat.i(198560);
    boolean bool2 = false;
    p localp = this.yVM;
    boolean bool1 = bool2;
    if (this.AxK)
    {
      bool1 = bool2;
      if (localp != null)
      {
        bool1 = bool2;
        if (localp.QM(32)) {
          bool1 = true;
        }
      }
    }
    ad.i("MicroMsg.VideoTimeLineItem", "the useNewPlayer return value is ".concat(String.valueOf(bool1)));
    AppMethodBeat.o(198560);
    return bool1;
  }
  
  protected final void eeG()
  {
    AppMethodBeat.i(221354);
    ad.i("MicroMsg.VideoTimeLineItem", "try hide play btn");
    if ((this.AxM != null) && (this.AxM.Atv != null))
    {
      ad.i("MicroMsg.VideoTimeLineItem", "hide play btn");
      this.AxM.Atv.zFD.setVisibility(8);
      this.AxM.Atv.zWB.setVisibility(8);
    }
    AppMethodBeat.o(221354);
  }
  
  public final void eeg()
  {
    AppMethodBeat.i(176430);
    ad.i("MicroMsg.VideoTimeLineItem", "try show play btn");
    if ((this.AxM != null) && (this.AxM.Atv != null) && (!this.Awr))
    {
      ad.i("MicroMsg.VideoTimeLineItem", "show play btn");
      this.AxM.Atv.zFD.setVisibility(0);
      this.AxM.Atv.zWB.setVisibility(8);
      this.AxM.Atv.zFD.setImageDrawable(com.tencent.mm.cc.a.l(this.mActivity, 2131691166));
      this.AxM.Atv.zFD.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176430);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(100129);
    if (this.AxN != null)
    {
      Object localObject = new int[2];
      this.AxN.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.AxN.getMeasuredWidth() + i, this.AxN.getMeasuredHeight() + j);
      AppMethodBeat.o(100129);
      return localObject;
    }
    AppMethodBeat.o(100129);
    return null;
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100125);
    Object localObject = new DisplayMetrics();
    this.mActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.AxK = com.tencent.mm.plugin.sns.ad.timeline.a.c.dRY();
    this.mScreenWidth = ((DisplayMetrics)localObject).widthPixels;
    this.mScreenHeight = ((DisplayMetrics)localObject).heightPixels;
    this.AxM = paramBaseViewHolder;
    if (paramBaseViewHolder.Avc != null)
    {
      paramBaseViewHolder.Avc.setLayoutResource(2131495566);
      paramBaseViewHolder.AvT = ((ViewStub)paramBaseViewHolder.tPw.findViewById(2131300969));
      if (!paramBaseViewHolder.AvU)
      {
        paramBaseViewHolder.Atv.zWx = paramBaseViewHolder.AvT.inflate();
        paramBaseViewHolder.AvU = true;
      }
      paramBaseViewHolder.Atv.zWA = paramBaseViewHolder.Atv.zWx.findViewById(2131298069);
      paramBaseViewHolder.Atv.zWy = ((VideoSightView)paramBaseViewHolder.Atv.zWx.findViewById(2131300914));
      paramBaseViewHolder.Atv.zWy.setMute(true);
      if ((paramBaseViewHolder != null) && (paramBaseViewHolder.Atv != null)) {
        break label383;
      }
    }
    for (;;)
    {
      paramBaseViewHolder.Atv.zWA.setOnClickListener(this.Aug);
      paramBaseViewHolder.Atv.zFD = ((ImageView)paramBaseViewHolder.Atv.zWx.findViewById(2131305196));
      paramBaseViewHolder.Atv.zWB = ((MMPinProgressBtn)paramBaseViewHolder.Atv.zWx.findViewById(2131303515));
      paramBaseViewHolder.Atv.zWC = ((TextView)paramBaseViewHolder.Atv.zWx.findViewById(2131299492));
      paramBaseViewHolder.Atv.zFE = ((TextView)paramBaseViewHolder.Atv.zWx.findViewById(2131299517));
      g.ajD();
      if (((Boolean)g.ajC().ajl().get(344065, Boolean.FALSE)).booleanValue())
      {
        localObject = (TextView)((ViewStub)paramBaseViewHolder.Atv.zWx.findViewById(2131304813)).inflate();
        paramBaseViewHolder.Atv.zWy.setSightInfoView((TextView)localObject);
      }
      AppMethodBeat.o(100125);
      return;
      paramBaseViewHolder.Atv.zWx = paramBaseViewHolder.tPw.findViewById(2131305005);
      paramBaseViewHolder.AvU = true;
      break;
      label383:
      paramBaseViewHolder.Atv.zWz = ((SnsAdTimelineVideoView)paramBaseViewHolder.Atv.zWx.findViewById(2131308163));
      com.tencent.mm.plugin.sns.ad.timeline.a.c.a(paramBaseViewHolder.Atv.zWz);
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177697);
    ad.i("MicroMsg.VideoTimeLineItem", "onUIPause");
    eei();
    AppMethodBeat.o(177697);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176432);
    ad.i("MicroMsg.VideoTimeLineItem", "pause");
    eei();
    eeg();
    AppMethodBeat.o(176432);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176433);
    ad.i("MicroMsg.VideoTimeLineItem", "%s Ad Video stop", new Object[] { this });
    Object localObject;
    if ((this.AxM != null) && (this.AxM.Atv != null))
    {
      if (!dRZ()) {
        break label110;
      }
      localObject = this.AxM;
      ad.d("MicroMsg.VideoTimeLineItem", "newPlayerClear is called");
      if ((localObject != null) && (((BaseTimeLineItem.BaseViewHolder)localObject).Atv != null)) {
        break label82;
      }
    }
    for (;;)
    {
      this.Awr = false;
      AppMethodBeat.o(176433);
      return;
      label82:
      localObject = ((BaseTimeLineItem.BaseViewHolder)localObject).Atv.zWz;
      ad.d("NormalVideoAdHelper", "clear is called");
      if (localObject != null)
      {
        ((SnsAdTimelineVideoView)localObject).clear();
        continue;
        label110:
        this.AxM.Atv.zWy.ySq.clear();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.n
 * JD-Core Version:    0.7.0.1
 */