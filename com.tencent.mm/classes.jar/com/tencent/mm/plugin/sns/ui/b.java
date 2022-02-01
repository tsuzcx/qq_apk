package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.ad.f.l;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;

public final class b
{
  boolean AJP;
  private int INC;
  l JHg;
  private com.tencent.mm.plugin.sns.h.b KAr;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.c KAs;
  TextView KAt;
  ListView KAu;
  View KAv;
  private FrameLayout KdA;
  AbsoluteLayout KdB;
  protected Animation KdC;
  protected Animation KdD;
  boolean KdE;
  private com.tencent.mm.plugin.sns.ui.d.c Kdz;
  private Context mContext;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.h.b paramb)
  {
    AppMethodBeat.i(97689);
    this.KdB = null;
    this.KdE = false;
    this.AJP = false;
    this.INC = -1;
    this.mContext = paramContext;
    this.KAr = paramb;
    this.Kdz = paramc;
    this.KdA = paramFrameLayout;
    this.KdC = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.KdC = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_down);
    this.KdD = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.KdD = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_up);
    this.KAs = com.tencent.mm.plugin.sns.ad.timeline.feedback.c.a(paramContext, paramc);
    AppMethodBeat.o(97689);
  }
  
  public final boolean fQe()
  {
    AppMethodBeat.i(97691);
    if ((this.KAr != null) && (aj.fOA().fQh())) {
      this.KAr.fQe();
    }
    if (this.KdB != null)
    {
      this.KdA.removeView(this.KdB);
      this.KdB = null;
      AppMethodBeat.o(97691);
      return true;
    }
    this.KdE = false;
    this.KAu = null;
    this.KAv = null;
    AppMethodBeat.o(97691);
    return false;
  }
  
  public final boolean fTc()
  {
    AppMethodBeat.i(97692);
    final int k = this.KAt.getHeight();
    this.KAt.setVisibility(8);
    int i = 0;
    Object localObject = null;
    final int j = 0;
    while (i < this.KAu.getAdapter().getCount())
    {
      localObject = this.KAu.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.KAv.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.KAu.getLayoutParams()).bottomMargin = (k - j);
    this.KAu.setVisibility(0);
    localObject = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(97688);
        paramAnonymousTransformation = (RelativeLayout.LayoutParams)b.this.KAu.getLayoutParams();
        if (paramAnonymousFloat == 1.0F) {}
        for (int i = 0;; i = (int)((k - j) * (1.0F - paramAnonymousFloat)))
        {
          paramAnonymousTransformation.bottomMargin = i;
          b.this.KAu.requestLayout();
          AppMethodBeat.o(97688);
          return;
        }
      }
      
      public final boolean willChangeBounds()
      {
        return true;
      }
    };
    ((Animation)localObject).setDuration(250L);
    this.KAu.startAnimation((Animation)localObject);
    AppMethodBeat.o(97692);
    return true;
  }
  
  public final boolean gu(final View paramView)
  {
    AppMethodBeat.i(97690);
    int i;
    if ((aj.fOA().fQh()) && (this.KAr != null))
    {
      i = this.KAr.gr(paramView);
      if ((i == 0) || (i == 1))
      {
        AppMethodBeat.o(97690);
        return true;
      }
      Log.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
    }
    for (;;)
    {
      if (this.KdE)
      {
        AppMethodBeat.o(97690);
        return false;
      }
      try
      {
        localObject1 = paramView.getTag();
        if (!(localObject1 instanceof e)) {
          continue;
        }
        localObject1 = aj.fOI().bbl(((e)localObject1).fAg);
        j.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a((SnsInfo)localObject1, false, paramView, this.JHg));
        if (this.KAs == null) {
          continue;
        }
        boolean bool = this.KAs.a(paramView, (SnsInfo)localObject1);
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(97690);
        return true;
      }
      catch (Throwable localThrowable) {}
      if (this.KdB != null)
      {
        if ((this.KdB.getTag() instanceof a))
        {
          paramView = ((a)this.KdB.getTag()).GiP;
          this.KdE = true;
          paramView.startAnimation(this.KdD);
          this.KdD.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(97687);
              if (paramView != null)
              {
                paramView.clearAnimation();
                paramView.setVisibility(8);
                b.this.fQe();
              }
              b.this.KdE = false;
              AppMethodBeat.o(97687);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation)
            {
              b.this.KdE = true;
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(97690);
          return false;
          fQe();
        }
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
      {
        AppMethodBeat.o(97690);
        return false;
      }
      e locale = (e)paramView.getTag();
      Object localObject2 = locale.fAg;
      this.KdB = new AbsoluteLayout(this.mContext);
      this.KdB.setId(i.f.address);
      new FrameLayout.LayoutParams(-1, -1);
      this.KdA.addView(this.KdB);
      int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 150.0F);
      int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 17.0F);
      BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0F);
      final View localView = ad.kS(this.mContext).inflate(i.g.ad_unlike_content, null);
      TextView localTextView = (TextView)localView.findViewById(i.f.ad_unlike_tip);
      Object localObject1 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
      ADXml localADXml = locale.JPW.LeX;
      if (localADXml != null)
      {
        if (!"zh_CN".equals(localObject1)) {
          break label654;
        }
        localObject1 = localADXml.expandInsideTitle_cn;
        if (!Util.isNullOrNil((String)localObject1))
        {
          localTextView.setText((CharSequence)localObject1);
          localTextView.setClickable(true);
        }
      }
      new Rect();
      i = h.jp(this.mContext);
      localObject1 = locale.JPW.fYf();
      Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject1[0] + "  " + localObject1[1] + " height: " + i);
      this.INC = ar.getStatusBarHeight(this.mContext);
      if (this.AJP)
      {
        i = a.fromDPToPix(this.mContext, 2);
        this.INC = 0;
      }
      for (;;)
      {
        localObject1 = new AbsoluteLayout.LayoutParams(-2, -2, localObject1[0] - j, localObject1[1] - this.INC - i + k);
        localObject2 = new a((String)localObject2, localView);
        this.KdB.setTag(localObject2);
        this.KdB.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localView.setVisibility(8);
        this.KdE = true;
        new MMHandler().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(97686);
            b.a(b.this, paramView, localView);
            AppMethodBeat.o(97686);
          }
        });
        AppMethodBeat.o(97690);
        return true;
        label654:
        if (("zh_TW".equals(localObject1)) || ("zh_HK".equals(localObject1)))
        {
          localObject1 = localADXml.expandInsideTitle_tw;
          break;
        }
        localObject1 = localADXml.expandInsideTitle_en;
        break;
        i = a.fromDPToPix(this.mContext, 2) + i;
      }
    }
  }
  
  final class a
  {
    View GiP = null;
    String KdU;
    
    public a(String paramString, View paramView)
    {
      this.KdU = paramString;
      this.GiP = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */