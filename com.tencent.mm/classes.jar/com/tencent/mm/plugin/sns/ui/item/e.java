package com.tencent.mm.plugin.sns.ui.item;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sight.decode.a.b.e;
import com.tencent.mm.plugin.sight.decode.a.b.f;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.b.h;
import com.tencent.mm.plugin.sns.storage.b.h.a;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.bh;
import com.tencent.mm.plugin.sns.ui.bi;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.i;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdCardVideoEndView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdSphereAnimView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTimelineVideoView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView;
import com.tencent.mm.plugin.sns.ui.widget.SnsAdTouchProgressView.a;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView;
import com.tencent.mm.plugin.sns.ui.widget.SnsDrawGestureView.a;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abo;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bk;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.QImageView.a;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.o;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends BaseTimeLineItem
  implements com.tencent.mm.plugin.sns.ui.video.a
{
  boolean ALo;
  private View.OnClickListener ALu;
  private View.OnClickListener ALv;
  protected SnsAdTouchProgressView.a ALw;
  volatile boolean ANI;
  Handler AOj;
  a AOk;
  private ax AOl;
  private boolean AOm;
  private boolean AOn;
  boolean AOo;
  private p zlW;
  
  public e()
  {
    AppMethodBeat.i(176422);
    this.AOj = new Handler(Looper.getMainLooper());
    this.ANI = false;
    this.ALo = false;
    this.AOm = false;
    this.AOn = false;
    this.AOo = false;
    this.ALu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176421);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick");
        try
        {
          e.this.zGX.zGs.AQy.onClick(paramAnonymousView);
          if (e.c(e.this)) {
            SnsAdCardVideoEndView.i(e.d(e.this), 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176421);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ae.e("MicroMsg.FullCardAdTimeLineItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.ALv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179368);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.FullCardAdTimeLineItem", "ProxySightClickListener onClick");
        try
        {
          e.this.zGX.zGs.AQl.onClick(paramAnonymousView);
          if (e.c(e.this)) {
            SnsAdCardVideoEndView.i(e.d(e.this), 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/item/FullCardAdTimeLineItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179368);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ae.e("MicroMsg.FullCardAdTimeLineItem", "mProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.ALw = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179359);
        try
        {
          ae.i("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick");
          e.f(e.this).AKJ.AnG.performClick();
          AppMethodBeat.o(179359);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ae.e("MicroMsg.FullCardAdTimeLineItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(179359);
        }
      }
      
      public final void onFinish()
      {
        AppMethodBeat.i(179360);
        e.this.zGX.AAQ.Agz.m(e.f(e.this));
        r.e(new long[] { 20L, 100L });
        d.a(e.this.mActivity, e.f(e.this).Apn, e.d(e.this), 1);
        if (e.d(e.this) != null)
        {
          SnsAdClick localSnsAdClick = new SnsAdClick(1, 1, r.azz(e.d(e.this).ebP().Id), 28, 21);
          if ((e.this.mActivity instanceof SnsTimeLineUI)) {
            k.a(localSnsAdClick, ((SnsTimeLineUI)e.this.mActivity).egD(), e.d(e.this), 28);
          }
          r.a(localSnsAdClick);
          ae.i("MicroMsg.FullCardAdTimeLineItem", "onFinish report MMOCAD_CLICKPOS_AD_FULL_CARD_LONGPRESS");
          AppMethodBeat.o(179360);
          return;
        }
        ae.e("MicroMsg.FullCardAdTimeLineItem", "onFinish report, mSnsinfo==null");
        AppMethodBeat.o(179360);
      }
      
      public final void onStart() {}
    };
    AppMethodBeat.o(176422);
  }
  
  private void U(p paramp)
  {
    AppMethodBeat.i(220089);
    if ((this.zGX != null) && (this.zGX.AAQ != null) && (this.zGX.AAQ.Agi != null) && (paramp != null)) {
      this.zGX.AAQ.Agi.zP(paramp.field_snsId);
    }
    AppMethodBeat.o(220089);
  }
  
  private boolean ehM()
  {
    AppMethodBeat.i(177695);
    if ((this.AOk.timeLineObject.HUG.Gtw == 5) || (this.AOk.timeLineObject.HUG.Gtw == 15))
    {
      ae.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd doPause", new Object[] { this });
      if ((this.AOk != null) && (this.AOk.AKJ != null))
      {
        if (!this.AOo) {
          break label133;
        }
        this.AOk.AKJ.AnI.pause();
        this.AOk.AKJ.AnI.setShouldPlayWhenPrepared(false);
        this.AOl.efe();
      }
      for (;;)
      {
        U(this.zlW);
        this.ANI = false;
        AppMethodBeat.o(177695);
        return true;
        label133:
        this.AOk.AKJ.AnH.pause();
      }
    }
    AppMethodBeat.o(177695);
    return false;
  }
  
  private void ehN()
  {
    AppMethodBeat.i(176427);
    ae.i("MicroMsg.FullCardAdTimeLineItem", "try show play btn");
    if ((this.AOk != null) && (this.AOk.AKJ != null) && (!this.ANI))
    {
      ae.i("MicroMsg.FullCardAdTimeLineItem", "show play btn");
      this.AOk.AKJ.zWJ.setVisibility(0);
      this.AOk.AKJ.AnK.setVisibility(8);
      this.AOk.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
      this.AOk.AKJ.zWJ.setContentDescription(this.mActivity.getString(2131761939));
    }
    AppMethodBeat.o(176427);
  }
  
  protected final void a(bh parambh, bi parambi, final b.h paramh, int paramInt)
  {
    AppMethodBeat.i(179370);
    ae.i("MicroMsg.FullCardAdTimeLineItem", "doOnVideoCompletion, ret=".concat(String.valueOf(paramInt)));
    if (paramInt != -1)
    {
      if ((parambh == null) || (parambh.AAQ == null) || (parambh.AAQ.Agi == null))
      {
        AppMethodBeat.o(179370);
        return;
      }
      parambh.AAQ.Agi.C(parambi.ADP, false);
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179361);
        e locale = e.this;
        b.h localh = paramh;
        if (localh != null) {
          for (;;)
          {
            try
            {
              if ((localh.zOM == null) || (!locale.ANI)) {
                break;
              }
              if (locale.AOo)
              {
                locale.AOk.ALn.setBlurBkg(locale.AOk.AKJ.AnI.getInnerVideoView());
                locale.AOk.ALn.aUA();
                locale.AOk.ALn.eiz();
                locale.ALo = true;
                if (locale.AOo)
                {
                  locale.AOk.AKJ.AnI.setShouldPlayWhenPrepared(false);
                  locale.AOk.AKJ.AnI.pause();
                  locale.a(locale.AOk);
                  locale.AOj.postDelayed(new e.11(locale), localh.zOM.duration);
                  AppMethodBeat.o(179361);
                }
              }
              else
              {
                locale.AOk.ALn.setBlurBkg(locale.AOk.Apn);
                continue;
              }
              localException.AOk.AKJ.AnH.pause();
            }
            catch (Exception localException)
            {
              ae.e("MicroMsg.FullCardAdTimeLineItem", "handleVideoCompletion, exp" + localException.toString());
              AppMethodBeat.o(179361);
              return;
            }
          }
        }
        localException.AOk.ALn.dX(false);
        AppMethodBeat.o(179361);
      }
    });
    AppMethodBeat.o(179370);
  }
  
  protected final void a(final bi parambi, b.h paramh, final p paramp, long paramLong, int paramInt)
  {
    AppMethodBeat.i(179371);
    if ((this.zGX == null) || (this.zGX.AAQ == null) || (this.zGX.AAQ.Agi == null))
    {
      AppMethodBeat.o(179371);
      return;
    }
    if (((paramh == null) || (paramh.zOM == null)) && (this.AOk.ALn.getVisibility() == 0)) {
      this.AOk.ALn.dX(false);
    }
    if (paramp != null)
    {
      this.zGX.AAQ.Agi.zO(paramp.field_snsId);
      this.zGX.AAQ.Agi.aj(paramp.field_snsId, 1000L * paramLong);
    }
    if (!this.zGX.AAQ.Agi.zL(parambi.ADP))
    {
      this.zGX.AAQ.Agi.d(parambi.ADP, bu.HQ(), false);
      this.zGX.AAQ.Agi.e(parambi.ADP, paramInt, false);
      this.zGX.AAQ.Agi.ai(parambi.ADP, parambi.ADP);
    }
    ae.d("MicroMsg.FullCardAdTimeLineItem", "doOnVideoPlaying, currentTime=" + paramLong + ", duration=" + paramInt);
    paramInt = (int)paramLong;
    final a locala = this.AOk;
    int i = paramInt * 1000;
    if (paramh == null)
    {
      parambi = null;
      if ((!bu.isNullOrNil(paramp.dVj().dZK())) && (parambi != null) && (parambi.startTime >= 0L) && (parambi.endTime > parambi.startTime))
      {
        ae.i("MicroMsg.FullCardAdTimeLineItem", "%d-%d,%d", new Object[] { Long.valueOf(parambi.startTime), Long.valueOf(parambi.endTime), Integer.valueOf(i) });
        if ((parambi.startTime > i) || (parambi.endTime < i)) {
          break label428;
        }
        if (a.b(locala).getOnGestureListener() == null) {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(100080);
              e.a.b(locala).setVisibility(0);
              e.a.b(locala).eiK();
              e.a.b(locala).setPaintColor(parambi.color);
              e.a.b(locala).setOnGestureListener(new SnsDrawGestureView.a()
              {
                public final void ehK()
                {
                  AppMethodBeat.i(179364);
                  r.rr(false);
                  e.a.b(e.7.this.AOq).setBackgroundColor(e.this.mActivity.getResources().getColor(2131100894));
                  AppMethodBeat.o(179364);
                }
                
                public final void gl(List<PointF> paramAnonymous2List)
                {
                  int i = 1;
                  AppMethodBeat.i(179365);
                  r.rr(true);
                  Object localObject = r.azB(e.7.this.ALC.zOP);
                  e.a.b(e.7.this.AOq).setBackgroundColor(0);
                  if ((((List)localObject).size() > 0) && (paramAnonymous2List.size() > 0)) {
                    try
                    {
                      paramAnonymous2List = com.tencent.mm.ui.tools.a.a.iU(paramAnonymous2List);
                      double d1 = com.tencent.mm.ui.tools.a.a.I((List)localObject, paramAnonymous2List);
                      String str = r.fR((List)localObject);
                      Collections.reverse((List)localObject);
                      double d2 = com.tencent.mm.ui.tools.a.a.I((List)localObject, paramAnonymous2List);
                      float f = (float)Math.min(d1, d2);
                      ae.i("MicroMsg.FullCardAdTimeLineItem", "similarity: %f,%f, distance:%f", new Object[] { Double.valueOf(d1), Double.valueOf(d2), Float.valueOf(f) });
                      if (f <= e.7.this.ALC.zOO)
                      {
                        e.this.zGX.AAQ.Agz.m(e.7.this.AOq);
                        r.e(new long[] { 20L, 100L });
                        d.a(e.this.mActivity, e.7.this.AOq.Apn, e.7.this.AgF, 1);
                        localObject = new SnsAdClick(1, 1, r.azz(e.7.this.AgF.ebP().Id), 25, 21);
                        if ((e.this.mActivity instanceof SnsTimeLineUI)) {
                          k.a((SnsAdClick)localObject, ((SnsTimeLineUI)e.this.mActivity).egD(), e.7.this.AgF, 25);
                        }
                        r.a((SnsAdClick)localObject);
                        i = 2;
                      }
                      com.tencent.mm.plugin.report.service.g.yxI.f(16552, new Object[] { e.7.this.AgF.ebP().Id, str, r.fR(com.tencent.mm.ui.tools.a.a.iS(paramAnonymous2List)), Integer.valueOf((int)(100.0F * f)), Integer.valueOf(i), Long.valueOf(bu.aSC(e.7.this.AgF.ect())), e.7.this.AgF.dVi().dGD });
                      d.a(i, f, e.7.this.ALC.zOO, e.7.this.AgF.dVi().dGD, e.7.this.AgF.ebP().Id, 1);
                      return;
                    }
                    catch (Exception paramAnonymous2List)
                    {
                      ae.printErrStackTrace("MicroMsg.FullCardAdTimeLineItem", paramAnonymous2List, "recog gesture error!", new Object[0]);
                      return;
                    }
                    finally
                    {
                      e.a.b(e.7.this.AOq).eiK();
                      AppMethodBeat.o(179365);
                    }
                  }
                  AppMethodBeat.o(179365);
                }
                
                public final void onClick()
                {
                  AppMethodBeat.i(179366);
                  r.rr(true);
                  e.a.b(e.7.this.AOq).setBackgroundColor(0);
                  e.7.this.AOq.AKJ.AnG.performClick();
                  AppMethodBeat.o(179366);
                }
              });
              AppMethodBeat.o(100080);
            }
          });
        }
      }
    }
    for (;;)
    {
      d.a(paramh, paramInt * 1000, this.AOk.ALl, this.AOk.ALm);
      AppMethodBeat.o(179371);
      return;
      parambi = paramh.zOH;
      break;
      label428:
      a(locala);
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    AppMethodBeat.i(176423);
    if ((paramBaseViewHolder.timeLineObject.HUG.Gtw == 5) || (paramBaseViewHolder.timeLineObject.HUG.Gtw == 15))
    {
      ae.i("MicroMsg.FullCardAdTimeLineItem", "play: hash=" + hashCode() + ", pos=" + paramInt + ", isEndViewShow=" + this.ALo + ", isPlayingSight=" + this.ANI);
      com.tencent.mm.plugin.sns.ui.video.d.eir().cyX();
      com.tencent.mm.plugin.sns.ui.video.b.eil().a(this);
      if (!this.ALo)
      {
        if (!this.AOo) {
          break label265;
        }
        paramBaseViewHolder.AKJ.AnI.setShouldPlayWhenPrepared(true);
        paramBaseViewHolder.AKJ.AnI.start();
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.FullCardAdTimeLineItem", "try hide play btn");
      if ((this.AOk != null) && (this.AOk.AKJ != null))
      {
        ae.i("MicroMsg.FullCardAdTimeLineItem", "hide play btn");
        this.AOk.AKJ.zWJ.setVisibility(8);
        this.AOk.AKJ.AnK.setVisibility(8);
      }
      this.ANI = true;
      if ((paramBaseViewHolder instanceof a)) {
        ((a)paramBaseViewHolder).ANW = false;
      }
      if ((!this.ALo) && (this.AOk.ALn.getVisibility() == 0)) {
        this.AOk.ALn.dX(true);
      }
      AppMethodBeat.o(176423);
      return;
      label265:
      paramBaseViewHolder.AKJ.AnH.start();
    }
  }
  
  public final void a(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder, int paramInt1, final bi parambi, TimeLineObject paramTimeLineObject, int paramInt2, final bh parambh)
  {
    AppMethodBeat.i(100082);
    ae.i("MicroMsg.FullCardAdTimeLineItem", "ad fillItem, fullCardAd, pos=" + paramInt1 + ", snsId=" + paramTimeLineObject.Id + ", hash=" + hashCode());
    if (paramBaseViewHolder.guz)
    {
      ae.i("MicroMsg.FullCardAdTimeLineItem", "holder is busy");
      AppMethodBeat.o(100082);
      return;
    }
    final a locala = (a)paramBaseViewHolder;
    final p localp = parambi.zlW;
    this.zlW = localp;
    Object localObject1 = null;
    Object localObject2 = localObject1;
    if (localp != null)
    {
      localObject2 = localObject1;
      if (localp.dVj() != null) {
        localObject2 = localp.dVj().zNK;
      }
    }
    localObject1 = (WindowManager)this.mActivity.getSystemService("window");
    int i = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    localObject1 = null;
    locala.tgh.setVisibility(8);
    locala.ALd.setVisibility(8);
    locala.ALe.setVisibility(8);
    locala.ALc.setVisibility(8);
    locala.ALf.setVisibility(8);
    locala.ALg.setVisibility(8);
    locala.ALh.setVisibility(8);
    a.b(locala).setVisibility(8);
    locala.AOt.setVisibility(8);
    locala.ALp.setVisibility(8);
    locala.AKJ.AnH.setOnCompletionListener(null);
    locala.AKJ.AnH.setOnDecodeDurationListener(null);
    locala.AKJ.AnI.setVideoCallback(null);
    a(locala);
    boolean bool;
    label490:
    label502:
    Object localObject4;
    if (localObject2 != null)
    {
      locala.ALn.a(((b.h)localObject2).zOM, 1);
      if ((localp != null) && (locala.ALn.V(localp)))
      {
        this.AOj.removeCallbacksAndMessages(null);
        this.ALo = false;
      }
      localObject3 = locala.AKJ.AnH;
      if (((b.h)localObject2).zOM != null)
      {
        bool = true;
        ((VideoSightView)localObject3).setIsForbidLoopAnim(bool);
        int j = com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 56);
        int k = this.mActivity.getResources().getDimensionPixelSize(2131165490);
        int m = this.mActivity.getResources().getDimensionPixelSize(2131165516);
        paramInt2 = i - j - k - m;
        if (((b.h)localObject2).zOE != 0) {
          break label1631;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
        if (localObject1 == null) {
          break label1673;
        }
        paramInt2 = ((ViewGroup.LayoutParams)localObject1).height;
        localObject3 = new Rect(k + j, j - m, i - m, paramInt2 + (j - m));
        this.AOn = this.AOl.a(this.zlW, ((b.h)localObject2).zON, (Rect)localObject3);
        if ((!this.AOm) && (!this.AOn)) {
          break label1679;
        }
        bool = true;
        label573:
        this.AOo = bool;
        locala.AKJ.AnP = this.AOo;
        localObject4 = new StringBuilder("fillItem, isExptUseNewPlayer=").append(this.AOm).append(", isLongPressGestureAd=").append(this.AOn).append(", hash=").append(hashCode()).append(", snsId=");
        if (localp != null) {
          break label1685;
        }
        localObject3 = "";
        label652:
        ae.i("MicroMsg.FullCardAdTimeLineItem", localObject3);
        if (localObject1 == null) {
          break label1698;
        }
        localObject3 = locala.Apn.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.Apn.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        ((RoundedCornerFrameLayout)locala.Apn).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.mActivity, 8));
        localObject3 = locala.ALi.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.ALi.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.AKJ.AnG.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.AKJ.AnG.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        locala.AKJ.AnH.hy(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        localObject3 = locala.AKJ.AnI.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.AKJ.AnI.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.ALl.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.ALl.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.ALm.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.ALm.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        localObject3 = locala.ALn.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject3).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject3).height = ((ViewGroup.LayoutParams)localObject1).height;
        locala.ALn.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        if (((b.h)localObject2).zOG != 0) {
          break label1755;
        }
        paramInt2 = Color.argb((int)(((b.h)localObject2).zOF * 2.55F), 0, 0, 0);
        i = Color.argb(0, 0, 0, 0);
        localObject1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, i });
        ((GradientDrawable)localObject1).setGradientType(0);
        locala.tgh.setBackground((Drawable)localObject1);
        if ((!bu.isNullOrNil(((b.h)localObject2).title)) || (!bu.isNullOrNil(((b.h)localObject2).description))) {
          locala.tgh.setVisibility(0);
        }
        if (!bu.isNullOrNil(((b.h)localObject2).title))
        {
          locala.ALd.setVisibility(0);
          localObject1 = locala.ALd;
          localObject3 = com.tencent.mm.ce.g.fqZ();
          locala.ALd.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.ce.g)localObject3).b(((b.h)localObject2).title, locala.ALd.getTextSize()));
        }
        if (!bu.isNullOrNil(((b.h)localObject2).description))
        {
          locala.ALe.setVisibility(0);
          localObject1 = locala.ALe;
          localObject3 = com.tencent.mm.ce.g.fqZ();
          locala.ALe.getContext();
          ((TextView)localObject1).setText(((com.tencent.mm.ce.g)localObject3).b(((b.h)localObject2).description, locala.ALe.getTextSize()));
        }
      }
      for (;;)
      {
        if (localp.dVi().dZr())
        {
          paramInt2 = Color.argb((int)(((b.h)localObject2).zOF * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.ALc.setVisibility(0);
          locala.ALc.setBackground((Drawable)localObject1);
          locala.ALh.setVisibility(0);
        }
        if ((paramTimeLineObject.HUG == null) || (paramTimeLineObject.HUG.Gtx.size() <= 0)) {
          break label2118;
        }
        localObject1 = (bzh)paramTimeLineObject.HUG.Gtx.get(0);
        label1379:
        localObject4 = ah.dXB();
        if ((paramBaseViewHolder.AKJ.AnF != null) && (!bu.lX(paramBaseViewHolder.AKJ.AnF.Id, paramTimeLineObject.Id)))
        {
          ae.i("MicroMsg.FullCardAdTimeLineItem", "need clear sightView %s", new Object[] { paramBaseViewHolder.AKJ.AnF.Id });
          ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.AKJ.AnH, this.mActivity.hashCode(), paramInt1);
          ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.AKJ.AnI, this.mActivity.hashCode());
        }
        paramBaseViewHolder.AKJ.a(paramTimeLineObject, paramInt1, parambi.AhK, parambi.AfT);
        paramBaseViewHolder.AKJ.zWK.setVisibility(8);
        if (localObject1 == null) {
          break label3342;
        }
        if (paramTimeLineObject.HUG.Gtw != 1) {
          break label2124;
        }
        locala.ALi.setVisibility(0);
        locala.AKJ.AnG.setVisibility(4);
        parambi = locala.ALi;
        paramInt1 = this.mActivity.hashCode();
        parambh = bk.fvn();
        parambh.heF = paramTimeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject4).b((bzh)localObject1, parambi, -1, paramInt1, parambh);
        locala.ALi.setTag(paramBaseViewHolder);
        locala.ALi.setOnClickListener(this.ALu);
        locala.ANW = false;
        AppMethodBeat.o(100082);
        return;
        bool = false;
        break;
        label1631:
        if (((b.h)localObject2).zOE != 1) {
          break label490;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = paramInt2;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break label490;
        label1673:
        paramInt2 = 0;
        break label502;
        label1679:
        bool = false;
        break label573;
        label1685:
        localObject3 = Long.valueOf(localp.field_snsId);
        break label652;
        label1698:
        localObject3 = new StringBuilder("mediaLayout==null, snsId=");
        if (this.zlW == null) {}
        for (localObject1 = "";; localObject1 = Long.valueOf(this.zlW.field_snsId))
        {
          ae.e("MicroMsg.FullCardAdTimeLineItem", localObject1);
          break;
        }
        label1755:
        if (((b.h)localObject2).zOG == 1)
        {
          paramInt2 = Color.argb((int)(((b.h)localObject2).zOF * 2.55F), 0, 0, 0);
          i = Color.argb(0, 0, 0, 0);
          localObject1 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { paramInt2, i });
          ((GradientDrawable)localObject1).setGradientType(0);
          locala.ALc.setBackground((Drawable)localObject1);
          if ((!bu.isNullOrNil(((b.h)localObject2).title)) || (!bu.isNullOrNil(((b.h)localObject2).description)))
          {
            locala.ALc.setVisibility(0);
            localObject1 = (RelativeLayout.LayoutParams)locala.ALh.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject1).topMargin = com.tencent.mm.cb.a.fromDPToPix(locala.Apn.getContext(), 4);
            locala.ALh.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          }
          if (!bu.isNullOrNil(((b.h)localObject2).title))
          {
            locala.ALf.setVisibility(0);
            localObject1 = locala.ALf;
            localObject3 = com.tencent.mm.ce.g.fqZ();
            locala.ALf.getContext();
            ((TextView)localObject1).setText(((com.tencent.mm.ce.g)localObject3).b(((b.h)localObject2).title, locala.ALf.getTextSize()));
          }
          if (!bu.isNullOrNil(((b.h)localObject2).description))
          {
            locala.ALg.setVisibility(0);
            localObject1 = locala.ALg;
            localObject3 = com.tencent.mm.ce.g.fqZ();
            locala.ALg.getContext();
            ((TextView)localObject1).setText(((com.tencent.mm.ce.g)localObject3).b(((b.h)localObject2).description, locala.ALg.getTextSize()));
          }
        }
      }
    }
    ae.e("MicroMsg.FullCardAdTimeLineItem", "invalid full card");
    if (this.zlW == null)
    {
      localObject1 = "";
      label2055:
      paramInt2 = 0;
      if (localp == null) {
        break label3446;
      }
      if (!localp.dZB()) {
        break label2112;
      }
      paramInt2 = 1;
    }
    label2074:
    label2112:
    label2118:
    label2124:
    label2404:
    label3317:
    label3446:
    for (Object localObject3 = localp.ecx();; localObject3 = "")
    {
      com.tencent.mm.plugin.sns.data.j.b(com.tencent.mm.plugin.sns.data.j.ztN, (String)localObject1, 1, paramInt2, (String)localObject3);
      break;
      localObject1 = r.zV(this.zlW.field_snsId);
      break label2055;
      paramInt2 = 0;
      break label2074;
      localObject1 = null;
      break label1379;
      if ((paramTimeLineObject.HUG.Gtw == 15) || (paramTimeLineObject.HUG.Gtw == 5))
      {
        if (this.AOo)
        {
          locala.AKJ.AnI.setVisibility(0);
          locala.AKJ.AnH.setVisibility(8);
          locala.AKJ.AnI.setVideoCallback(new OfflineVideoView.a()
          {
            public final boolean a(PString paramAnonymousPString)
            {
              AppMethodBeat.i(179355);
              ae.i("MicroMsg.FullCardAdTimeLineItem", "downloadVideo");
              AppMethodBeat.o(179355);
              return false;
            }
            
            public final void onCompletion()
            {
              AppMethodBeat.i(179357);
              ae.i("MicroMsg.FullCardAdTimeLineItem", "onCompletion");
              boolean bool = e.a(e.this).efd();
              if ((e.b(e.this)) && (this.AOp != null) && (this.AOp.zOM == null) && (!bool)) {
                locala.AKJ.AnI.restart();
              }
              e.this.a(parambh, parambi, this.AOp, 0);
              AppMethodBeat.o(179357);
            }
            
            public final void onStart(int paramAnonymousInt)
            {
              AppMethodBeat.i(179356);
              ae.i("MicroMsg.FullCardAdTimeLineItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
              AppMethodBeat.o(179356);
            }
            
            public final void tx(int paramAnonymousInt)
            {
              AppMethodBeat.i(179358);
              int i = paramAnonymousInt / 1000;
              e.this.a(parambi, this.AOp, localp, i, locala.AKJ.AnI.getDurationMs() / 1000);
              Object localObject2 = null;
              Object localObject1 = localObject2;
              if (parambh != null)
              {
                localObject1 = localObject2;
                if (parambh.AAQ != null) {
                  localObject1 = parambh.AAQ.Agi;
                }
              }
              e.a(e.this).a((com.tencent.mm.plugin.sns.ad.e.j)localObject1, paramAnonymousInt, parambi.ADP);
              AppMethodBeat.o(179358);
            }
          });
          if (localObject2 != null)
          {
            d.k(((b.h)localObject2).zOI, locala.ALl);
            d.k(((b.h)localObject2).zOK, locala.ALm);
          }
          if (localObject2 != null) {
            break label2718;
          }
          localObject3 = null;
          final String str = localp.dVj().dZK();
          if ((!bu.isNullOrNil(str)) && (localObject3 != null) && (((b.h.a)localObject3).startTime >= 0L) && (((b.h.a)localObject3).endTime > ((b.h.a)localObject3).startTime)) {
            com.tencent.mm.sdk.g.b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100079);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.ebI().f("adId", str, "adxml", 0);
                AppMethodBeat.o(100079);
              }
            }, "preDownloadFloatPage");
          }
          long l = System.nanoTime();
          bool = com.tencent.mm.plugin.sns.model.g.t((bzh)localObject1);
          ae.i("MicroMsg.FullCardAdTimeLineItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l) });
          localObject3 = locala.AKJ;
          if (bool) {
            break label2904;
          }
          if (!((com.tencent.mm.plugin.sns.model.g)localObject4).w((bzh)localObject1)) {
            break label2728;
          }
          ((aq)localObject3).zWJ.setVisibility(8);
          ((aq)localObject3).AnK.setVisibility(0);
          ((aq)localObject3).AnK.fPL();
          locala.AKJ.AnG.setVisibility(0);
          locala.ALi.setVisibility(4);
          ((aq)localObject3).AnH.setTagObject(localObject3);
          ((aq)localObject3).AnI.setTag(localObject3);
          ((aq)localObject3).AnJ.setTag(paramBaseViewHolder);
          locala.AKJ.AnG.setOnClickListener(this.ALu);
          if (!this.AOo) {
            break label3263;
          }
          paramBaseViewHolder = ((aq)localObject3).AnI;
          paramInt1 = this.mActivity.hashCode();
          localObject3 = bk.fvn();
          ((bk)localObject3).heF = paramTimeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject4).a(localp, (bzh)localObject1, paramBaseViewHolder, paramInt1, (bk)localObject3, parambi.AfT);
          d.a((b.h)localObject2, 0, locala.ALl, locala.ALm);
          paramBaseViewHolder = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id);
          paramTimeLineObject = r.i((bzh)localObject1);
          if (!o.fB(paramBaseViewHolder + paramTimeLineObject)) {
            break label3317;
          }
          parambh.AAQ.Agi.D(parambi.ADP, true);
          if (ah.dXB().b(localp, null) != 5) {
            break label3336;
          }
        }
        for (bool = true;; bool = false)
        {
          parambh.AAQ.Agi.c(parambi.ADP, bool, false);
          AppMethodBeat.o(100082);
          return;
          locala.AKJ.AnI.setVisibility(8);
          locala.AKJ.AnH.setVisibility(0);
          locala.AKJ.AnH.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(179362);
              StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
              if (localp == null) {}
              for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(localp.field_snsId))
              {
                ae.i("MicroMsg.FullCardAdTimeLineItem", paramAnonymousb);
                e.this.a(parambh, parambi, this.AOp, paramAnonymousInt);
                AppMethodBeat.o(179362);
                return;
              }
            }
          });
          locala.AKJ.AnH.setOnDecodeDurationListener(new b.f()
          {
            public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
            {
              AppMethodBeat.i(179363);
              ae.d("MicroMsg.FullCardAdTimeLineItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
              e.this.a(parambi, this.AOp, localp, paramAnonymousLong, (int)paramAnonymousb.dTD());
              AppMethodBeat.o(179363);
            }
          });
          break;
          localObject3 = ((b.h)localObject2).zOH;
          break label2248;
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localp, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject4).A((bzh)localObject1);
            ((aq)localObject3).zWJ.setVisibility(8);
            ((aq)localObject3).AnK.setVisibility(0);
            ((aq)localObject3).AnK.fPL();
            break label2404;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).x((bzh)localObject1))
          {
            ((aq)localObject3).AnK.setVisibility(8);
            ((aq)localObject3).zWJ.setImageResource(2131691612);
            ((aq)localObject3).zWJ.setVisibility(0);
            break label2404;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject4).y((bzh)localObject1);
          ((aq)localObject3).zWJ.setVisibility(0);
          ((aq)localObject3).AnK.setVisibility(8);
          ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
          ((aq)localObject3).zWJ.setContentDescription(this.mActivity.getString(2131761939));
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localp, null) != 4) {
            break label2404;
          }
          ((aq)localObject3).zWK.setVisibility(0);
          break label2404;
          if (((com.tencent.mm.plugin.sns.model.g)localObject4).u((bzh)localObject1))
          {
            ((aq)localObject3).zWJ.setVisibility(0);
            ((aq)localObject3).AnK.setVisibility(8);
            ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
            ((aq)localObject3).zWJ.setContentDescription(this.mActivity.getString(2131761939));
            if (!this.AOo) {
              break label3247;
            }
          }
          for (bool = ((aq)localObject3).AnI.isError();; bool = ((aq)localObject3).AnH.ziA.dTA())
          {
            if (!bool) {
              break label3261;
            }
            ae.e("MicroMsg.FullCardAdTimeLineItem", "play video error " + ((bzh)localObject1).Id + " " + ((bzh)localObject1).Url + " " + ((bzh)localObject1).Hmj + " " + paramInt1);
            ((com.tencent.mm.plugin.sns.model.g)localObject4).y((bzh)localObject1);
            ((aq)localObject3).zWJ.setVisibility(0);
            ((aq)localObject3).AnK.setVisibility(8);
            ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
            ((aq)localObject3).zWJ.setContentDescription(this.mActivity.getString(2131761939));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).v((bzh)localObject1))
            {
              ((aq)localObject3).zWJ.setVisibility(8);
              ((aq)localObject3).AnK.setVisibility(8);
              break label2967;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject4).b(localp, null) <= 5)
            {
              if (locala.ANW) {
                break label2967;
              }
              ae.i("MicroMsg.FullCardAdTimeLineItem", "fillItem, showPlayBtn");
              ehN();
              break label2967;
            }
            ((com.tencent.mm.plugin.sns.model.g)localObject4).y((bzh)localObject1);
            ((aq)localObject3).zWJ.setVisibility(0);
            ((aq)localObject3).AnK.setVisibility(8);
            ((aq)localObject3).zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.mActivity, 2131691166));
            ((aq)localObject3).zWJ.setContentDescription(this.mActivity.getString(2131761939));
            break label2967;
          }
          break label2404;
          paramBaseViewHolder = ((aq)localObject3).AnH;
          paramInt2 = this.mActivity.hashCode();
          localObject3 = bk.fvn();
          ((bk)localObject3).heF = paramTimeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject4).a(localp, (bzh)localObject1, paramBaseViewHolder, paramInt2, paramInt1, (bk)localObject3, parambi.AfT, true);
          break label2523;
          parambh.AAQ.Agi.D(parambi.ADP, false);
          break label2599;
        }
        ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.AKJ.AnH, this.mActivity.hashCode(), paramInt1);
        ((com.tencent.mm.plugin.sns.model.g)localObject4).a(paramBaseViewHolder.AKJ.AnI, this.mActivity.hashCode());
        paramBaseViewHolder.AKJ.AnL.setVisibility(8);
        paramBaseViewHolder.AKJ.AnH.setOnSightCompletionAction(null);
        paramBaseViewHolder.AKJ.AnH.setOnCompletionListener(null);
        paramBaseViewHolder.AKJ.AnH.setOnDecodeDurationListener(null);
        paramBaseViewHolder.AKJ.AnI.setVideoCallback(null);
      }
      AppMethodBeat.o(100082);
      return;
    }
  }
  
  final void a(final a parama)
  {
    AppMethodBeat.i(100083);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179367);
        e.a.b(parama).setVisibility(8);
        e.a.b(parama).setBackgroundColor(0);
        e.a.b(parama).eiK();
        e.a.b(parama).setOnGestureListener(null);
        AppMethodBeat.o(179367);
      }
    });
    AppMethodBeat.o(100083);
  }
  
  public final Rect getDisplayRect()
  {
    AppMethodBeat.i(176426);
    if ((this.AOk != null) && (this.AOk.Apn != null))
    {
      Object localObject = new int[2];
      this.AOk.Apn.getLocationOnScreen((int[])localObject);
      int i = localObject[0];
      int j = localObject[1];
      localObject = new Rect(i, j, this.AOk.Apn.getMeasuredWidth() + i, this.AOk.Apn.getMeasuredHeight() + j);
      AppMethodBeat.o(176426);
      return localObject;
    }
    AppMethodBeat.o(176426);
    return null;
  }
  
  public final void h(BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(100081);
    this.AOk = ((a)paramBaseViewHolder);
    if (paramBaseViewHolder.AMs != null)
    {
      paramBaseViewHolder.AMs.setLayoutResource(2131495603);
      if (!paramBaseViewHolder.AMt)
      {
        this.AOk.Apn = paramBaseViewHolder.AMs.inflate();
        paramBaseViewHolder.AMt = true;
      }
      this.AOk.tgh = this.AOk.uan.findViewById(2131306008);
      this.AOk.ALc = this.AOk.uan.findViewById(2131297449);
      this.AOk.ALd = ((TextView)this.AOk.uan.findViewById(2131306010));
      this.AOk.ALe = ((TextView)this.AOk.uan.findViewById(2131306009));
      this.AOk.ALf = ((TextView)this.AOk.uan.findViewById(2131297451));
      this.AOk.ALg = ((TextView)this.AOk.uan.findViewById(2131297450));
      this.AOk.ALi = ((MaskImageView)this.AOk.uan.findViewById(2131300322));
      this.AOk.ALh = this.AOk.uan.findViewById(2131297455);
      this.AOk.ALi.setScaleType(QImageView.a.Lpz);
      this.AOk.AKJ = new aq();
      this.AOk.AKJ.AnJ = this.AOk.Apn.findViewById(2131300324);
      this.AOk.AKJ.AnG = this.AOk.AKJ.AnJ;
      this.AOk.AKJ.AnJ.setOnClickListener(this.ALv);
      this.AOk.AKJ.AnH = ((VideoSightView)this.AOk.AKJ.AnJ.findViewById(2131300914));
      this.AOk.AKJ.AnI = ((SnsAdTimelineVideoView)this.AOk.AKJ.AnJ.findViewById(2131302995));
      paramBaseViewHolder.AKJ.AnH.setMute(true);
      paramBaseViewHolder.AKJ.AnI.setMute(true);
      this.AOk.AKJ.zWJ = ((ImageView)this.AOk.Apn.findViewById(2131300323));
      this.AOk.AKJ.AnK = ((MMPinProgressBtn)this.AOk.AKJ.AnJ.findViewById(2131303515));
      this.AOk.AKJ.AnL = ((TextView)this.AOk.AKJ.AnJ.findViewById(2131299492));
      this.AOk.AKJ.zWK = ((TextView)this.AOk.AKJ.AnJ.findViewById(2131299517));
      this.AOk.AKJ.AnH.ziI = true;
      this.AOk.AKJ.AnH.setScaleType(QImageView.a.Lpz);
      a.a(this.AOk, (SnsDrawGestureView)this.AOk.uan.findViewById(2131304972));
      this.AOk.ALl = ((ImageView)this.AOk.uan.findViewById(2131300311));
      this.AOk.ALm = ((ImageView)this.AOk.uan.findViewById(2131299487));
      this.AOk.ALn = ((SnsAdCardVideoEndView)this.AOk.uan.findViewById(2131304975));
      if (this.AOk.ALp != null) {
        break label806;
      }
      paramBaseViewHolder = ((ViewStub)this.AOk.ANu.findViewById(2131304926)).inflate();
      this.AOk.ALp = ((SnsAdSphereAnimView)paramBaseViewHolder.findViewById(2131304925));
      this.AOk.AOt = ((SnsAdTouchProgressView)paramBaseViewHolder.findViewById(2131308213));
    }
    for (;;)
    {
      this.AOk.ALp.setVisibility(8);
      this.AOk.AOt.setVisibility(8);
      this.AOl = new ax(this.mActivity, this.AOk, this.AOk.ANu);
      this.AOl.AqD = this.ALw;
      this.AOm = d.ehO();
      AppMethodBeat.o(100081);
      return;
      if (paramBaseViewHolder.AMt) {
        break;
      }
      this.AOk.Apn = paramBaseViewHolder.uan.findViewById(2131300321);
      paramBaseViewHolder.AMt = true;
      break;
      label806:
      ae.e("MicroMsg.FullCardAdTimeLineItem", "buildContent many times");
    }
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(177694);
    ae.i("MicroMsg.FullCardAdTimeLineItem", "onUIPause");
    ehM();
    AppMethodBeat.o(177694);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(176424);
    ae.i("MicroMsg.FullCardAdTimeLineItem", "pause");
    if (ehM()) {
      ehN();
    }
    AppMethodBeat.o(176424);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(176425);
    ae.i("MicroMsg.FullCardAdTimeLineItem", "%s FullCardAd stop", new Object[] { this });
    if ((this.AOk != null) && (this.AOk.AKJ != null))
    {
      if (!this.AOo) {
        break label71;
      }
      this.AOk.AKJ.AnI.clear();
    }
    for (;;)
    {
      this.ANI = false;
      AppMethodBeat.o(176425);
      return;
      label71:
      this.AOk.AKJ.AnH.ziA.clear();
    }
  }
  
  public static class a
    extends BaseTimeLineItem.BaseViewHolder
  {
    public View ALc;
    public TextView ALd;
    public TextView ALe;
    public TextView ALf;
    public TextView ALg;
    public View ALh;
    public MaskImageView ALi;
    private SnsDrawGestureView ALj;
    public ImageView ALl;
    public ImageView ALm;
    public SnsAdCardVideoEndView ALn;
    public SnsAdSphereAnimView ALp;
    public boolean ANW = false;
    public SnsAdTouchProgressView AOt;
    public View Apn;
    public View tgh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.item.e
 * JD-Core Version:    0.7.0.1
 */