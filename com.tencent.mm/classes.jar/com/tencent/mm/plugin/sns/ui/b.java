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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.sns.ad.d.i;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;

public final class b
{
  private Context mContext;
  boolean mXd;
  private int yYM;
  private com.tencent.mm.plugin.sns.h.b zNE;
  private com.tencent.mm.plugin.sns.ad.timeline.feedback.c zNF;
  TextView zNG;
  ListView zNH;
  View zNI;
  i zbv;
  private com.tencent.mm.plugin.sns.ui.d.c zpd;
  private FrameLayout zpe;
  AbsoluteLayout zpf;
  protected Animation zpg;
  protected Animation zph;
  boolean zpi;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.c paramc, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.h.b paramb)
  {
    AppMethodBeat.i(97689);
    this.zpf = null;
    this.zpi = false;
    this.mXd = false;
    this.yYM = -1;
    this.mContext = paramContext;
    this.zNE = paramb;
    this.zpd = paramc;
    this.zpe = paramFrameLayout;
    this.zpg = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.zpg = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.zph = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.zph = AnimationUtils.loadAnimation(paramContext, 2130772023);
    this.zNF = com.tencent.mm.plugin.sns.ad.timeline.feedback.c.a(paramContext, paramc);
    AppMethodBeat.o(97689);
  }
  
  public final boolean dVw()
  {
    AppMethodBeat.i(97691);
    if ((this.zNE != null) && (ag.dTW().dVz())) {
      this.zNE.dVw();
    }
    if (this.zpf != null)
    {
      this.zpe.removeView(this.zpf);
      this.zpf = null;
      AppMethodBeat.o(97691);
      return true;
    }
    this.zpi = false;
    this.zNH = null;
    this.zNI = null;
    AppMethodBeat.o(97691);
    return false;
  }
  
  public final boolean dZp()
  {
    AppMethodBeat.i(97692);
    final int k = this.zNG.getHeight();
    this.zNG.setVisibility(8);
    int i = 0;
    Object localObject = null;
    final int j = 0;
    while (i < this.zNH.getAdapter().getCount())
    {
      localObject = this.zNH.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.zNI.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.zNH.getLayoutParams()).bottomMargin = (k - j);
    this.zNH.setVisibility(0);
    localObject = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(97688);
        paramAnonymousTransformation = (RelativeLayout.LayoutParams)b.this.zNH.getLayoutParams();
        if (paramAnonymousFloat == 1.0F) {}
        for (int i = 0;; i = (int)((k - j) * (1.0F - paramAnonymousFloat)))
        {
          paramAnonymousTransformation.bottomMargin = i;
          b.this.zNH.requestLayout();
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
    this.zNH.startAnimation((Animation)localObject);
    AppMethodBeat.o(97692);
    return true;
  }
  
  public final boolean eZ(final View paramView)
  {
    AppMethodBeat.i(97690);
    int i;
    if ((ag.dTW().dVz()) && (this.zNE != null))
    {
      i = this.zNE.eW(paramView);
      if ((i == 0) || (i == 1))
      {
        AppMethodBeat.o(97690);
        return true;
      }
      ad.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
    }
    for (;;)
    {
      if (this.zpi)
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
        localObject1 = ag.dUe().aAa(((com.tencent.mm.plugin.sns.data.b)localObject1).doX);
        com.tencent.mm.plugin.sns.ad.e.g.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a((p)localObject1, false, paramView, this.zbv));
        if (this.zNF == null) {
          continue;
        }
        boolean bool = this.zNF.a(paramView, (p)localObject1);
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(97690);
        return true;
      }
      catch (Throwable localThrowable) {}
      if (this.zpf != null)
      {
        if ((this.zpf.getTag() instanceof a))
        {
          paramView = ((a)this.zpf.getTag()).yXL;
          this.zpi = true;
          paramView.startAnimation(this.zph);
          this.zph.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(97687);
              if (paramView != null)
              {
                paramView.clearAnimation();
                paramView.setVisibility(8);
                b.this.dVw();
              }
              b.this.zpi = false;
              AppMethodBeat.o(97687);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation)
            {
              b.this.zpi = true;
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(97690);
          return false;
          dVw();
        }
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
      {
        AppMethodBeat.o(97690);
        return false;
      }
      com.tencent.mm.plugin.sns.data.b localb = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
      Object localObject2 = localb.doX;
      this.zpf = new AbsoluteLayout(this.mContext);
      this.zpf.setId(2131296470);
      new FrameLayout.LayoutParams(-1, -1);
      this.zpe.addView(this.zpf);
      int j = BackwardSupportUtil.b.g(this.mContext, 150.0F);
      int k = BackwardSupportUtil.b.g(this.mContext, 17.0F);
      BackwardSupportUtil.b.g(this.mContext, 40.0F);
      final View localView = z.jO(this.mContext).inflate(2131492940, null);
      TextView localTextView = (TextView)localView.findViewById(2131296446);
      Object localObject1 = ac.iM(aj.getContext());
      com.tencent.mm.plugin.sns.storage.b localb1 = localb.zcq.ApR;
      if (localb1 != null)
      {
        if (!"zh_CN".equals(localObject1)) {
          break label654;
        }
        localObject1 = localb1.zvN;
        if (!bt.isNullOrNil((String)localObject1))
        {
          localTextView.setText((CharSequence)localObject1);
          localTextView.setClickable(true);
        }
      }
      new Rect();
      i = h.hm(this.mContext);
      localObject1 = localb.zcq.edN();
      ad.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject1[0] + "  " + localObject1[1] + " height: " + i);
      this.yYM = al.jG(this.mContext);
      if (this.mXd)
      {
        i = a.fromDPToPix(this.mContext, 2);
        this.yYM = 0;
      }
      for (;;)
      {
        localObject1 = new AbsoluteLayout.LayoutParams(-2, -2, localObject1[0] - j, localObject1[1] - this.yYM - i + k);
        localObject2 = new a((String)localObject2, localView);
        this.zpf.setTag(localObject2);
        this.zpf.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localView.setVisibility(8);
        this.zpi = true;
        new ap().post(new Runnable()
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
          localObject1 = localb1.zvP;
          break;
        }
        localObject1 = localb1.zvO;
        break;
        i = a.fromDPToPix(this.mContext, 2) + i;
      }
    }
  }
  
  final class a
  {
    View yXL = null;
    String zpy;
    
    public a(String paramString, View paramView)
    {
      this.zpy = paramString;
      this.yXL = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */