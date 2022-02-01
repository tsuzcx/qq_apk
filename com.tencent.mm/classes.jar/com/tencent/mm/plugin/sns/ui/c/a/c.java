package com.tencent.mm.plugin.sns.ui.c.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
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
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.OfflineVideoView.a;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.ax;
import com.tencent.mm.plugin.sns.ui.item.d;
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

public final class c
  extends a
{
  private boolean ALa;
  public View ALc;
  private TextView ALd;
  private TextView ALe;
  private TextView ALf;
  private TextView ALg;
  public View ALh;
  public MaskImageView ALi;
  SnsDrawGestureView ALj;
  b.h ALk;
  ImageView ALl;
  ImageView ALm;
  SnsAdCardVideoEndView ALn;
  boolean ALo;
  private SnsAdSphereAnimView ALp;
  ax ALq;
  private boolean ALr;
  private boolean ALs;
  boolean ALt;
  private View.OnClickListener ALu;
  private View.OnClickListener ALv;
  protected SnsAdTouchProgressView.a ALw;
  public View Apn;
  com.tencent.mm.plugin.sns.ad.e.j Asq;
  Context context;
  boolean mIsPaused;
  public View tgh;
  
  public c(TimeLineObject paramTimeLineObject, p paramp, com.tencent.mm.plugin.sns.ui.d.c paramc, com.tencent.mm.plugin.sns.ad.e.j paramj)
  {
    AppMethodBeat.i(176410);
    this.ALo = false;
    this.ALr = false;
    this.ALs = false;
    this.ALt = false;
    this.ALu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(176409);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick");
        try
        {
          c.this.zrv.AQy.onClick(paramAnonymousView);
          if (c.this.ALo) {
            SnsAdCardVideoEndView.i(c.this.znm, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(176409);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ae.e("MicroMsg.FullCardAdDetailItem", "ProxyCardClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.ALv = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179347);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick");
        try
        {
          c.this.zrv.AQl.onClick(paramAnonymousView);
          if (c.this.ALo) {
            SnsAdCardVideoEndView.i(c.this.znm, 2);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/detail/item/FullCardAdDetailItem$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(179347);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            ae.e("MicroMsg.FullCardAdDetailItem", "ProxySightClickListener onClick, exp=" + paramAnonymousView.toString());
          }
        }
      }
    };
    this.ALa = false;
    this.mIsPaused = false;
    this.ALw = new SnsAdTouchProgressView.a()
    {
      public final void onCancel() {}
      
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(179338);
        try
        {
          ae.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick");
          c.this.AKJ.AnG.performClick();
          AppMethodBeat.o(179338);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          ae.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onClick exp=" + paramAnonymousView.toString());
          AppMethodBeat.o(179338);
        }
      }
      
      public final void onFinish()
      {
        int i = 1;
        AppMethodBeat.i(179339);
        ae.i("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish");
        for (;;)
        {
          try
          {
            c.this.zrv.a(c.this);
            r.e(new long[] { 20L, 100L });
            if (!(c.this.context instanceof SnsCommentDetailUI)) {
              break label197;
            }
            i = ((SnsCommentDetailUI)c.this.context).getSource();
          }
          catch (Exception localException)
          {
            SnsAdClick localSnsAdClick;
            ae.e("MicroMsg.FullCardAdDetailItem", "SnsAdTouchProgressView onFinish, exp=" + localException.toString());
            AppMethodBeat.o(179339);
            return;
          }
          d.a(c.this.context, c.this.contentView, c.this.znm, i);
          localSnsAdClick = new SnsAdClick(1, 2, r.azz(c.this.znm.ebP().Id), 28, 21);
          k.a(localSnsAdClick, c.this.Asq, c.this.znm, 28);
          r.a(localSnsAdClick);
          AppMethodBeat.o(179339);
          return;
          label197:
          while (i != 2)
          {
            i = 2;
            break;
          }
          i = 16;
        }
      }
      
      public final void onStart() {}
    };
    this.timeLineObject = paramTimeLineObject;
    this.znm = paramp;
    this.zrv = paramc;
    this.Asq = paramj;
    AppMethodBeat.o(176410);
  }
  
  private void ehI()
  {
    AppMethodBeat.i(176411);
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179346);
        c.this.ALj.setVisibility(8);
        c.this.ALj.setBackgroundColor(0);
        c.this.ALj.eiK();
        c.this.ALj.setOnGestureListener(null);
        AppMethodBeat.o(179346);
      }
    });
    AppMethodBeat.o(176411);
  }
  
  public final void c(FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(220073);
    try
    {
      ae.i("MicroMsg.FullCardAdDetailItem", "initLongPressView");
      SnsAdTouchProgressView localSnsAdTouchProgressView = (SnsAdTouchProgressView)paramFrameLayout.findViewById(2131308213);
      localSnsAdTouchProgressView.setVisibility(8);
      this.ALq = new ax(this.context, localSnsAdTouchProgressView, this.ALp, this.AKJ, paramFrameLayout);
      this.ALq.AqD = this.ALw;
      AppMethodBeat.o(220073);
      return;
    }
    catch (Exception paramFrameLayout)
    {
      ae.e("MicroMsg.FullCardAdDetailItem", "initLongPressView exp=" + Log.getStackTraceString(paramFrameLayout));
      AppMethodBeat.o(220073);
    }
  }
  
  public final void ehJ()
  {
    AppMethodBeat.i(179349);
    for (;;)
    {
      try
      {
        if ((this.ALk == null) || (this.ALk.zOM == null)) {
          break;
        }
        if (this.ALt)
        {
          this.ALn.setBlurBkg(this.AKJ.AnI.getInnerVideoView());
          this.ALn.aUA();
          this.ALn.eiz();
          this.ALo = true;
          if (this.ALt)
          {
            this.AKJ.AnI.setShouldPlayWhenPrepared(false);
            this.AKJ.AnI.pause();
            ehI();
            ar.o(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(179348);
                if (((c.this.context instanceof Activity)) && (!((Activity)c.this.context).isFinishing()))
                {
                  c.this.ALn.dX(true);
                  c.this.ALo = false;
                  if (!c.this.mIsPaused)
                  {
                    if (c.this.ALt)
                    {
                      c.this.AKJ.AnI.restart();
                      AppMethodBeat.o(179348);
                      return;
                    }
                    c.this.AKJ.AnH.start();
                    AppMethodBeat.o(179348);
                    return;
                  }
                  ae.e("MicroMsg.FullCardAdDetailItem", "activity isPaused");
                  AppMethodBeat.o(179348);
                  return;
                }
                ae.e("MicroMsg.FullCardAdDetailItem", "onCompletion, postDelayed-run activity isFinished");
                AppMethodBeat.o(179348);
              }
            }, this.ALk.zOM.duration);
            AppMethodBeat.o(179349);
          }
        }
        else
        {
          this.ALn.setBlurBkg(this.contentView);
          continue;
        }
        this.AKJ.AnH.pause();
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.FullCardAdDetailItem", "handleVideoCompletion, exp" + localException.toString());
        AppMethodBeat.o(179349);
        return;
      }
    }
    this.ALn.dX(false);
    AppMethodBeat.o(179349);
  }
  
  public final void m(View paramView1, View paramView2)
  {
    AppMethodBeat.i(100020);
    this.contentView = paramView1;
    this.ArR = paramView2;
    this.context = paramView1.getContext();
    this.Apn = paramView1.findViewById(2131300321);
    this.tgh = paramView1.findViewById(2131306008);
    this.ALc = paramView1.findViewById(2131297449);
    this.ALd = ((TextView)paramView1.findViewById(2131306010));
    this.ALe = ((TextView)paramView1.findViewById(2131306009));
    this.ALf = ((TextView)paramView1.findViewById(2131297451));
    this.ALg = ((TextView)paramView1.findViewById(2131297450));
    this.ALh = paramView1.findViewById(2131297455);
    this.ALi = ((MaskImageView)paramView1.findViewById(2131300322));
    this.ALj = ((SnsDrawGestureView)paramView1.findViewById(2131304972));
    this.ALi.setScaleType(QImageView.a.Lpz);
    this.ALl = ((ImageView)paramView1.findViewById(2131300311));
    this.ALm = ((ImageView)paramView1.findViewById(2131299487));
    this.AKJ = new aq();
    this.AKJ.AnJ = paramView1.findViewById(2131300324);
    this.AKJ.AnG = this.AKJ.AnJ;
    this.AKJ.AnJ.setOnClickListener(this.ALv);
    this.AKJ.AnH = ((VideoSightView)this.AKJ.AnJ.findViewById(2131300914));
    this.AKJ.AnI = ((SnsAdTimelineVideoView)this.AKJ.AnJ.findViewById(2131302995));
    this.AKJ.AnH.setMute(true);
    this.AKJ.AnI.setMute(true);
    this.AKJ.zWJ = ((ImageView)paramView1.findViewById(2131300323));
    this.AKJ.AnK = ((MMPinProgressBtn)this.AKJ.AnJ.findViewById(2131303515));
    this.AKJ.AnL = ((TextView)this.AKJ.AnJ.findViewById(2131299492));
    this.AKJ.zWK = ((TextView)this.AKJ.AnJ.findViewById(2131299517));
    this.AKJ.AnH.ziI = true;
    this.AKJ.AnH.setScaleType(QImageView.a.Lpz);
    this.ALn = ((SnsAdCardVideoEndView)paramView1.findViewById(2131304975));
    if (this.ALp == null) {
      this.ALp = ((SnsAdSphereAnimView)((ViewStub)this.kFh.findViewById(2131304926)).inflate());
    }
    for (;;)
    {
      this.ALp.setVisibility(8);
      this.ALr = d.ehO();
      AppMethodBeat.o(100020);
      return;
      ae.e("MicroMsg.FullCardAdDetailItem", "initView many times");
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(179350);
    ae.i("MicroMsg.FullCardAdDetailItem", "onPause, hasPlayedVideo=" + this.ALa);
    this.mIsPaused = true;
    try
    {
      if ((this.ALa) && (this.AKJ != null) && (this.AKJ.AnH != null))
      {
        if (!this.ALt) {
          break label137;
        }
        this.AKJ.AnI.pause();
        this.AKJ.AnI.setShouldPlayWhenPrepared(false);
        if (this.ALq != null) {
          this.ALq.efe();
        }
      }
      for (;;)
      {
        if ((this.Asq != null) && (this.znm != null)) {
          this.Asq.zP(this.znm.field_snsId);
        }
        AppMethodBeat.o(179350);
        return;
        label137:
        this.AKJ.AnH.pause();
      }
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.FullCardAdDetailItem", "onPause, exp=" + localException.toString());
      AppMethodBeat.o(179350);
    }
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(100021);
    this.znm = h.aBq(this.znm.getSnsId());
    this.ALk = null;
    if ((this.znm != null) && (this.znm.dVj() != null)) {
      this.ALk = this.znm.dVj().zNK;
    }
    Object localObject1 = (WindowManager)this.context.getSystemService("window");
    int j = Math.min(((WindowManager)localObject1).getDefaultDisplay().getWidth(), ((WindowManager)localObject1).getDefaultDisplay().getHeight());
    this.tgh.setVisibility(8);
    this.ALd.setVisibility(8);
    this.ALe.setVisibility(8);
    this.ALc.setVisibility(8);
    this.ALf.setVisibility(8);
    this.ALg.setVisibility(8);
    this.ALh.setVisibility(8);
    this.ALa = false;
    this.mIsPaused = false;
    int k = com.tencent.mm.cb.a.ax(this.context, 2131166827);
    int m = com.tencent.mm.cb.a.ax(this.context, 2131165274);
    int n = this.context.getResources().getDimensionPixelSize(2131165516);
    int i;
    if (this.ALk != null)
    {
      i = j - k - m - n - n;
      if (this.ALk.zOE == 0)
      {
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((int)(((ViewGroup.LayoutParams)localObject1).width * 0.75F));
      }
    }
    label3072:
    for (;;)
    {
      int i1;
      Object localObject3;
      if (localObject1 != null)
      {
        localObject2 = this.contentView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((RoundedCornerFrameLayout)this.contentView).setRadius(com.tencent.mm.cb.a.fromDPToPix(this.context, 8));
        localObject2 = this.ALi.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.ALi.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.AKJ.AnG.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.AKJ.AnG.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.AKJ.AnH.hy(((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height);
        localObject2 = this.AKJ.AnI.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.AKJ.AnI.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.ALl.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.ALl.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.ALm.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.ALm.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject2 = this.ALn.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject2).width = ((ViewGroup.LayoutParams)localObject1).width;
        ((ViewGroup.LayoutParams)localObject2).height = ((ViewGroup.LayoutParams)localObject1).height;
        this.ALn.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (this.ALk.zOG != 0) {
          break label1482;
        }
        i = Color.argb((int)(this.ALk.zOF * 2.55F), 0, 0, 0);
        i1 = Color.argb(0, 0, 0, 0);
        localObject2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, i1 });
        ((GradientDrawable)localObject2).setGradientType(0);
        this.tgh.setBackground((Drawable)localObject2);
        if ((!bu.isNullOrNil(this.ALk.title)) || (!bu.isNullOrNil(this.ALk.description))) {
          this.tgh.setVisibility(0);
        }
        this.ALc.setVisibility(8);
        if (!bu.isNullOrNil(this.ALk.title))
        {
          this.ALd.setVisibility(0);
          localObject2 = this.ALd;
          localObject3 = com.tencent.mm.ce.g.fqZ();
          this.ALd.getContext();
          ((TextView)localObject2).setText(((com.tencent.mm.ce.g)localObject3).b(this.ALk.title, this.ALd.getTextSize()));
        }
        if (!bu.isNullOrNil(this.ALk.description))
        {
          this.ALe.setVisibility(0);
          localObject2 = this.ALe;
          localObject3 = com.tencent.mm.ce.g.fqZ();
          this.ALe.getContext();
          ((TextView)localObject2).setText(((com.tencent.mm.ce.g)localObject3).b(this.ALk.description, this.ALe.getTextSize()));
        }
      }
      label989:
      Object localObject4;
      boolean bool;
      label1097:
      label1122:
      label1264:
      final long l1;
      for (;;)
      {
        if (this.znm.dVi().dZr())
        {
          i = Color.argb((int)(this.ALk.zOF * 2.55F), 0, 0, 0);
          i1 = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, i1 });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.ALc.setVisibility(0);
          this.ALc.setBackground((Drawable)localObject2);
          this.ALh.setVisibility(0);
        }
        localObject2 = localObject1;
        if ((this.timeLineObject.HUG == null) || (this.timeLineObject.HUG.Gtx.size() <= 0)) {
          break label1857;
        }
        localObject1 = (bzh)this.timeLineObject.HUG.Gtx.get(0);
        this.AKJ.a(this.timeLineObject, 0, this.znm.eco(), true);
        this.AKJ.zWK.setVisibility(8);
        localObject3 = ah.dXB();
        if (localObject1 == null) {
          break label3163;
        }
        this.ALn.a(this.ALk.zOM, 2);
        if (this.ALn.V(this.znm)) {
          this.ALo = false;
        }
        if (this.AKJ.AnH != null)
        {
          localObject4 = this.AKJ.AnH;
          if (this.ALk.zOM == null) {
            break label1863;
          }
          bool = true;
          ((VideoSightView)localObject4).setIsForbidLoopAnim(bool);
        }
        if (this.ALq != null)
        {
          if (localObject2 == null) {
            break label1869;
          }
          i = ((ViewGroup.LayoutParams)localObject2).height;
          localObject2 = new Rect(k + m, k, j - n, i + k);
          this.ALs = this.ALq.a(this.znm, this.ALk.zON, (Rect)localObject2);
        }
        if ((!this.ALr) && (!this.ALs)) {
          break label1874;
        }
        bool = true;
        label1184:
        this.ALt = bool;
        this.AKJ.AnP = this.ALt;
        localObject4 = new StringBuilder("refreshView, isExptUseNewPlayer=").append(this.ALr).append(", isLongPressGestureAd=").append(this.ALs).append(", hash=").append(hashCode()).append(", snsId=");
        if (this.znm != null) {
          break label1880;
        }
        localObject2 = "";
        ae.i("MicroMsg.FullCardAdDetailItem", localObject2);
        l1 = this.znm.field_snsId;
        if (this.timeLineObject.HUG.Gtw != 1) {
          break label1895;
        }
        this.ALi.setVisibility(0);
        this.ALi.setTag(this);
        this.ALi.setOnClickListener(this.ALu);
        localObject2 = this.ALi;
        i = this.context.hashCode();
        localObject4 = bk.fvn();
        ((bk)localObject4).heF = this.timeLineObject.CreateTime;
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a((bzh)localObject1, (View)localObject2, -1, i, (bk)localObject4, 3);
        AppMethodBeat.o(100021);
        return;
        if (this.ALk.zOE != 1) {
          break label3275;
        }
        localObject1 = new ViewGroup.LayoutParams(-2, -2);
        ((ViewGroup.LayoutParams)localObject1).width = i;
        ((ViewGroup.LayoutParams)localObject1).height = ((ViewGroup.LayoutParams)localObject1).width;
        break;
        localObject3 = new StringBuilder("mediaLayout==null, snsId=");
        if (this.znm == null) {}
        for (localObject2 = "";; localObject2 = Long.valueOf(this.znm.field_snsId))
        {
          ae.e("MicroMsg.FullCardAdDetailItem", localObject2);
          break;
        }
        label1482:
        if (this.ALk.zOG == 1)
        {
          i = Color.argb((int)(this.ALk.zOF * 2.55F), 0, 0, 0);
          i1 = Color.argb(0, 0, 0, 0);
          localObject2 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[] { i, i1 });
          ((GradientDrawable)localObject2).setGradientType(0);
          this.tgh.setVisibility(8);
          this.ALc.setBackground((Drawable)localObject2);
          if ((!bu.isNullOrNil(this.ALk.title)) || (!bu.isNullOrNil(this.ALk.description)))
          {
            this.ALc.setVisibility(0);
            localObject2 = (RelativeLayout.LayoutParams)this.ALh.getLayoutParams();
            ((RelativeLayout.LayoutParams)localObject2).topMargin = com.tencent.mm.cb.a.fromDPToPix(this.context, 4);
            this.ALh.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          }
          if (!bu.isNullOrNil(this.ALk.title))
          {
            this.ALf.setVisibility(0);
            localObject2 = this.ALf;
            localObject3 = com.tencent.mm.ce.g.fqZ();
            this.ALf.getContext();
            ((TextView)localObject2).setText(((com.tencent.mm.ce.g)localObject3).b(this.ALk.title, this.ALf.getTextSize()));
          }
          if (!bu.isNullOrNil(this.ALk.description))
          {
            this.ALg.setVisibility(0);
            localObject2 = this.ALg;
            localObject3 = com.tencent.mm.ce.g.fqZ();
            this.ALg.getContext();
            ((TextView)localObject2).setText(((com.tencent.mm.ce.g)localObject3).b(this.ALk.description, this.ALg.getTextSize()));
          }
        }
      }
      ae.e("MicroMsg.FullCardAdDetailItem", "invalid full card");
      if (this.znm == null)
      {
        localObject1 = "";
        label1789:
        i = 0;
        if (this.znm == null) {
          break label3267;
        }
        if (!this.znm.dZB()) {
          break label1852;
        }
        i = 1;
      }
      label1810:
      label1852:
      label1857:
      label3267:
      for (Object localObject2 = this.znm.ecx();; localObject2 = "")
      {
        com.tencent.mm.plugin.sns.data.j.b(com.tencent.mm.plugin.sns.data.j.ztN, (String)localObject1, 0, i, (String)localObject2);
        localObject2 = null;
        break;
        localObject1 = r.zV(this.znm.field_snsId);
        break label1789;
        i = 0;
        break label1810;
        localObject1 = null;
        break label989;
        label1863:
        bool = false;
        break label1097;
        label1869:
        i = 0;
        break label1122;
        label1874:
        bool = false;
        break label1184;
        label1880:
        localObject2 = Long.valueOf(this.znm.field_snsId);
        break label1264;
        label1895:
        label2156:
        bk localbk;
        if ((this.timeLineObject.HUG.Gtw == 15) || (this.timeLineObject.HUG.Gtw == 5))
        {
          long l2 = System.nanoTime();
          bool = com.tencent.mm.plugin.sns.model.g.t((bzh)localObject1);
          ae.i("MicroMsg.FullCardAdDetailItem", "isMediaSightExist %b duration %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(System.nanoTime() - l2) });
          if (!this.ALt) {
            break label2409;
          }
          this.AKJ.AnI.setVisibility(0);
          this.AKJ.AnH.setVisibility(8);
          this.AKJ.AnI.setVideoCallback(new OfflineVideoView.a()
          {
            public final boolean a(PString paramAnonymousPString)
            {
              AppMethodBeat.i(179334);
              ae.i("MicroMsg.FullCardAdDetailItem", "downloadVideo");
              AppMethodBeat.o(179334);
              return false;
            }
            
            public final void onCompletion()
            {
              AppMethodBeat.i(179336);
              ae.i("MicroMsg.FullCardAdDetailItem", "onCompletion");
              if (c.this.ALq != null) {}
              for (boolean bool = c.this.ALq.efd();; bool = false)
              {
                if ((c.this.ALk.zOM == null) && (!bool)) {
                  c.this.AKJ.AnI.restart();
                }
                c.this.Asq.C(l1, false);
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(176407);
                    c.this.ehJ();
                    AppMethodBeat.o(176407);
                  }
                });
                AppMethodBeat.o(179336);
                return;
              }
            }
            
            public final void onStart(int paramAnonymousInt)
            {
              AppMethodBeat.i(179335);
              ae.i("MicroMsg.FullCardAdDetailItem", "onStart:".concat(String.valueOf(paramAnonymousInt)));
              AppMethodBeat.o(179335);
            }
            
            public final void tx(int paramAnonymousInt)
            {
              AppMethodBeat.i(179337);
              int i = paramAnonymousInt / 1000;
              ae.d("MicroMsg.FullCardAdDetailItem", "updateTime %d", new Object[] { Integer.valueOf(i) });
              if (c.this.Asq != null)
              {
                if (c.this.znm != null)
                {
                  c.this.Asq.zO(c.this.znm.field_snsId);
                  c.this.Asq.aj(c.this.znm.field_snsId, paramAnonymousInt);
                }
                if (!c.this.Asq.zL(l1))
                {
                  int j = c.this.AKJ.AnI.getDurationMs() / 1000;
                  ae.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(j)));
                  c.this.Asq.d(l1, bu.HQ(), false);
                  c.this.Asq.e(l1, j, false);
                  c.this.Asq.ai(l1, l1);
                }
              }
              c.a(c.this, c.this.ALk, c.this.znm, i * 1000);
              d.a(c.this.ALk, i * 1000, c.this.ALl, c.this.ALm);
              if (c.this.ALq != null) {
                c.this.ALq.a(c.this.Asq, paramAnonymousInt, l1);
              }
              AppMethodBeat.o(179337);
            }
          });
          d.a(this.ALk, 0, this.ALl, this.ALm);
          localObject2 = this.ALk.zOH;
          localObject4 = this.znm.dVj().dZK();
          if ((!bu.isNullOrNil((String)localObject4)) && (localObject2 != null) && (((b.h.a)localObject2).startTime >= 0L) && (((b.h.a)localObject2).endTime > ((b.h.a)localObject2).startTime)) {
            com.tencent.mm.sdk.g.b.c(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(100018);
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.j.ebI().f("adId", this.ALB, "adxml", 0);
                AppMethodBeat.o(100018);
              }
            }, "preDownloadFloatPage");
          }
          if (bool) {
            break label2679;
          }
          if (!((com.tencent.mm.plugin.sns.model.g)localObject3).w((bzh)localObject1)) {
            break label2475;
          }
          this.AKJ.zWJ.setVisibility(8);
          this.AKJ.AnK.setVisibility(0);
          this.AKJ.AnK.fPL();
          this.AKJ.AnG.setVisibility(0);
          this.AKJ.AnH.setTagObject(this.AKJ);
          this.AKJ.AnI.setTag(this.AKJ);
          this.AKJ.AnJ.setTag(this);
          this.AKJ.AnG.setOnClickListener(this.ALu);
          if (!this.ALt) {
            break label3072;
          }
          localObject2 = this.znm;
          localObject4 = this.AKJ.AnI;
          i = this.context.hashCode();
          localbk = bk.fvn();
          localbk.heF = this.timeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a((p)localObject2, (bzh)localObject1, (SnsAdTimelineVideoView)localObject4, i, localbk, true);
          this.AKJ.AnI.start();
          this.AKJ.AnI.setShouldPlayWhenPrepared(true);
          this.ALa = true;
          localObject2 = ap.jv(ah.getAccSnsPath(), ((bzh)localObject1).Id);
          localObject1 = r.i((bzh)localObject1);
          if (this.Asq != null)
          {
            if (!o.fB((String)localObject2 + (String)localObject1)) {
              break label3144;
            }
            this.Asq.D(l1, true);
            label2372:
            if (ah.dXB().b(this.znm, null) != 5) {
              break label3157;
            }
          }
        }
        label3144:
        label3157:
        for (bool = true;; bool = false)
        {
          this.Asq.c(l1, bool, false);
          AppMethodBeat.o(100021);
          return;
          label2409:
          this.AKJ.AnI.setVisibility(8);
          this.AKJ.AnH.setVisibility(0);
          this.AKJ.AnH.setOnCompletionListener(new b.e()
          {
            public final void c(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, int paramAnonymousInt)
            {
              AppMethodBeat.i(179341);
              StringBuilder localStringBuilder = new StringBuilder("sight play completed, retCode=").append(paramAnonymousInt).append(", snsId=");
              if (c.this.znm == null) {}
              for (paramAnonymousb = "";; paramAnonymousb = Long.valueOf(c.this.znm.field_snsId))
              {
                ae.i("MicroMsg.FullCardAdDetailItem", paramAnonymousb);
                if (paramAnonymousInt != -1) {
                  c.this.Asq.C(l1, false);
                }
                ar.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(179340);
                    c.this.ehJ();
                    AppMethodBeat.o(179340);
                  }
                });
                AppMethodBeat.o(179341);
                return;
              }
            }
          });
          this.AKJ.AnH.setOnDecodeDurationListener(new b.f()
          {
            public final void b(com.tencent.mm.plugin.sight.decode.a.b paramAnonymousb, long paramAnonymousLong)
            {
              AppMethodBeat.i(179342);
              ae.d("MicroMsg.FullCardAdDetailItem", "sight play %d", new Object[] { Long.valueOf(paramAnonymousLong) });
              if (c.this.Asq != null)
              {
                if (c.this.znm != null)
                {
                  c.this.Asq.zO(c.this.znm.field_snsId);
                  c.this.Asq.aj(c.this.znm.field_snsId, 1000L * paramAnonymousLong);
                }
                if (!c.this.Asq.zL(l1))
                {
                  i = (int)paramAnonymousb.dTD();
                  ae.i("MicroMsg.FullCardAdDetailItem", "updatePlayStartTime, duration=".concat(String.valueOf(i)));
                  c.this.Asq.d(l1, bu.HQ(), false);
                  c.this.Asq.e(l1, i, false);
                  c.this.Asq.ai(l1, l1);
                }
              }
              int i = (int)paramAnonymousLong;
              c.a(c.this, c.this.ALk, c.this.znm, i * 1000);
              d.a(c.this.ALk, i * 1000, c.this.ALl, c.this.ALm);
              AppMethodBeat.o(179342);
            }
          });
          break;
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.znm, null) == 5)
          {
            ((com.tencent.mm.plugin.sns.model.g)localObject3).A((bzh)localObject1);
            this.AKJ.zWJ.setVisibility(8);
            this.AKJ.AnK.setVisibility(0);
            this.AKJ.AnK.fPL();
            break label2156;
          }
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).x((bzh)localObject1))
          {
            this.AKJ.AnK.setVisibility(8);
            this.AKJ.zWJ.setImageResource(2131691612);
            this.AKJ.zWJ.setVisibility(0);
            break label2156;
          }
          ((com.tencent.mm.plugin.sns.model.g)localObject3).y((bzh)localObject1);
          this.AKJ.zWJ.setVisibility(0);
          this.AKJ.AnK.setVisibility(8);
          this.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
          this.AKJ.zWJ.setContentDescription(this.context.getString(2131761939));
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.znm, null) != 4) {
            break label2156;
          }
          this.AKJ.zWK.setVisibility(0);
          break label2156;
          label2679:
          if (((com.tencent.mm.plugin.sns.model.g)localObject3).u((bzh)localObject1))
          {
            this.AKJ.zWJ.setVisibility(0);
            this.AKJ.AnK.setVisibility(8);
            this.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
            this.AKJ.zWJ.setContentDescription(this.context.getString(2131761939));
            if (!this.ALt) {
              break label3054;
            }
          }
          label3054:
          for (bool = this.AKJ.AnI.isError();; bool = this.AKJ.AnH.ziA.dTA())
          {
            if (!bool) {
              break label3070;
            }
            ae.d("MicroMsg.FullCardAdDetailItem", "play video error " + ((bzh)localObject1).Id + " " + ((bzh)localObject1).Url + " " + ((bzh)localObject1).Hmj);
            ((com.tencent.mm.plugin.sns.model.g)localObject3).y((bzh)localObject1);
            this.AKJ.zWJ.setVisibility(0);
            this.AKJ.AnK.setVisibility(8);
            this.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
            this.AKJ.zWJ.setContentDescription(this.context.getString(2131761939));
            break;
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).v((bzh)localObject1))
            {
              this.AKJ.zWJ.setVisibility(8);
              this.AKJ.AnK.setVisibility(8);
              break label2752;
            }
            if (((com.tencent.mm.plugin.sns.model.g)localObject3).b(this.znm, null) <= 5)
            {
              this.AKJ.zWJ.setVisibility(8);
              this.AKJ.AnK.setVisibility(8);
              break label2752;
            }
            ((com.tencent.mm.plugin.sns.model.g)localObject3).y((bzh)localObject1);
            this.AKJ.zWJ.setVisibility(0);
            this.AKJ.AnK.setVisibility(8);
            this.AKJ.zWJ.setImageDrawable(com.tencent.mm.cb.a.l(this.context, 2131691166));
            this.AKJ.zWJ.setContentDescription(this.context.getString(2131761939));
            break label2752;
          }
          label3070:
          break label2156;
          localObject2 = this.znm;
          localObject4 = this.AKJ.AnH;
          i = this.context.hashCode();
          localbk = bk.fvn();
          localbk.heF = this.timeLineObject.CreateTime;
          ((com.tencent.mm.plugin.sns.model.g)localObject3).a((p)localObject2, (bzh)localObject1, (VideoSightView)localObject4, i, 0, localbk, true, true);
          this.AKJ.AnH.start();
          break label2304;
          this.Asq.D(l1, false);
          break label2372;
        }
        label3163:
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(this.AKJ.AnH, this.context.hashCode(), 0);
        ((com.tencent.mm.plugin.sns.model.g)localObject3).a(this.AKJ.AnI, this.context.hashCode());
        this.AKJ.AnL.setVisibility(8);
        this.AKJ.AnH.setOnSightCompletionAction(null);
        this.AKJ.AnH.setOnCompletionListener(null);
        this.AKJ.AnH.setOnDecodeDurationListener(null);
        this.AKJ.AnI.setVideoCallback(null);
        AppMethodBeat.o(100021);
        return;
      }
      label2304:
      label2475:
      label2752:
      label3275:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.c.a.c
 * JD-Core Version:    0.7.0.1
 */