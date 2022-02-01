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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ad.e.j;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;

public final class b
{
  private com.tencent.mm.plugin.sns.h.b AeL;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.c AeM;
  TextView AeN;
  ListView AeO;
  View AeP;
  private Context mContext;
  boolean ncj;
  private com.tencent.mm.plugin.sns.ui.d.c zGs;
  private FrameLayout zGt;
  AbsoluteLayout zGu;
  protected Animation zGv;
  protected Animation zGw;
  boolean zGx;
  private int zpn;
  j zrZ;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.h.b paramb)
  {
    AppMethodBeat.i(97689);
    this.zGu = null;
    this.zGx = false;
    this.ncj = false;
    this.zpn = -1;
    this.mContext = paramContext;
    this.AeL = paramb;
    this.zGs = paramc;
    this.zGt = paramFrameLayout;
    this.zGv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.zGv = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.zGw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.zGw = AnimationUtils.loadAnimation(paramContext, 2130772023);
    this.AeM = com.tencent.mm.plugin.sns.ad.timeline.feedback.c.a(paramContext, paramc);
    AppMethodBeat.o(97689);
  }
  
  public final boolean dYX()
  {
    AppMethodBeat.i(97691);
    if ((this.AeL != null) && (ah.dXw().dZa())) {
      this.AeL.dYX();
    }
    if (this.zGu != null)
    {
      this.zGt.removeView(this.zGu);
      this.zGu = null;
      AppMethodBeat.o(97691);
      return true;
    }
    this.zGx = false;
    this.AeO = null;
    this.AeP = null;
    AppMethodBeat.o(97691);
    return false;
  }
  
  public final boolean eY(final View paramView)
  {
    AppMethodBeat.i(97690);
    int i;
    if ((ah.dXw().dZa()) && (this.AeL != null))
    {
      i = this.AeL.eV(paramView);
      if ((i == 0) || (i == 1))
      {
        AppMethodBeat.o(97690);
        return true;
      }
      ae.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
    }
    for (;;)
    {
      if (this.zGx)
      {
        AppMethodBeat.o(97690);
        return false;
      }
      try
      {
        localObject1 = paramView.getTag();
        if (!(localObject1 instanceof com.tencent.mm.plugin.sns.data.b)) {
          continue;
        }
        localObject1 = ah.dXE().aBr(((com.tencent.mm.plugin.sns.data.b)localObject1).dqc);
        com.tencent.mm.plugin.sns.ad.f.g.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a((p)localObject1, false, paramView, this.zrZ));
        if (this.AeM == null) {
          continue;
        }
        boolean bool = this.AeM.a(paramView, (p)localObject1);
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(97690);
        return true;
      }
      catch (Throwable localThrowable) {}
      if (this.zGu != null)
      {
        if ((this.zGu.getTag() instanceof a))
        {
          paramView = ((a)this.zGu.getTag()).zom;
          this.zGx = true;
          paramView.startAnimation(this.zGw);
          this.zGw.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(97687);
              if (paramView != null)
              {
                paramView.clearAnimation();
                paramView.setVisibility(8);
                b.this.dYX();
              }
              b.this.zGx = false;
              AppMethodBeat.o(97687);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation)
            {
              b.this.zGx = true;
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(97690);
          return false;
          dYX();
        }
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
      {
        AppMethodBeat.o(97690);
        return false;
      }
      com.tencent.mm.plugin.sns.data.b localb = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
      Object localObject2 = localb.dqc;
      this.zGu = new AbsoluteLayout(this.mContext);
      this.zGu.setId(2131296470);
      new FrameLayout.LayoutParams(-1, -1);
      this.zGt.addView(this.zGu);
      int j = BackwardSupportUtil.b.h(this.mContext, 150.0F);
      int k = BackwardSupportUtil.b.h(this.mContext, 17.0F);
      BackwardSupportUtil.b.h(this.mContext, 40.0F);
      final View localView = z.jV(this.mContext).inflate(2131492940, null);
      TextView localTextView = (TextView)localView.findViewById(2131296446);
      Object localObject1 = ad.iR(ak.getContext());
      com.tencent.mm.plugin.sns.storage.b localb1 = localb.ztd.AHh;
      if (localb1 != null)
      {
        if (!"zh_CN".equals(localObject1)) {
          break label654;
        }
        localObject1 = localb1.zNi;
        if (!bu.isNullOrNil((String)localObject1))
        {
          localTextView.setText((CharSequence)localObject1);
          localTextView.setClickable(true);
        }
      }
      new Rect();
      i = h.hs(this.mContext);
      localObject1 = localb.ztd.ehu();
      ae.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject1[0] + "  " + localObject1[1] + " height: " + i);
      this.zpn = al.jN(this.mContext);
      if (this.ncj)
      {
        i = a.fromDPToPix(this.mContext, 2);
        this.zpn = 0;
      }
      for (;;)
      {
        localObject1 = new AbsoluteLayout.LayoutParams(-2, -2, localObject1[0] - j, localObject1[1] - this.zpn - i + k);
        localObject2 = new a((String)localObject2, localView);
        this.zGu.setTag(localObject2);
        this.zGu.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localView.setVisibility(8);
        this.zGx = true;
        new aq().post(new Runnable()
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
          localObject1 = localb1.zNk;
          break;
        }
        localObject1 = localb1.zNj;
        break;
        i = a.fromDPToPix(this.mContext, 2) + i;
      }
    }
  }
  
  public final boolean ecU()
  {
    AppMethodBeat.i(97692);
    final int k = this.AeN.getHeight();
    this.AeN.setVisibility(8);
    int i = 0;
    Object localObject = null;
    final int j = 0;
    while (i < this.AeO.getAdapter().getCount())
    {
      localObject = this.AeO.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.AeP.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.AeO.getLayoutParams()).bottomMargin = (k - j);
    this.AeO.setVisibility(0);
    localObject = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(97688);
        paramAnonymousTransformation = (RelativeLayout.LayoutParams)b.this.AeO.getLayoutParams();
        if (paramAnonymousFloat == 1.0F) {}
        for (int i = 0;; i = (int)((k - j) * (1.0F - paramAnonymousFloat)))
        {
          paramAnonymousTransformation.bottomMargin = i;
          b.this.AeO.requestLayout();
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
    this.AeO.startAnimation((Animation)localObject);
    AppMethodBeat.o(97692);
    return true;
  }
  
  final class a
  {
    String zGN;
    View zom = null;
    
    public a(String paramString, View paramView)
    {
      this.zGN = paramString;
      this.zom = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */