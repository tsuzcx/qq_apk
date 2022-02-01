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
import com.tencent.mm.plugin.sns.ad.e.d;
import com.tencent.mm.plugin.sns.ad.timeline.feedback.c;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.z;

public final class b
{
  private Context mContext;
  boolean mwy;
  private int xJx;
  private com.tencent.mm.plugin.sns.ui.d.b xZe;
  private FrameLayout xZf;
  AbsoluteLayout xZg;
  protected Animation xZh;
  protected Animation xZi;
  boolean xZj;
  i ywr;
  private com.tencent.mm.plugin.sns.h.b yws;
  private c ywt;
  TextView ywu;
  ListView ywv;
  View yww;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.h.b paramb1)
  {
    AppMethodBeat.i(97689);
    this.xZg = null;
    this.xZj = false;
    this.mwy = false;
    this.xJx = -1;
    this.mContext = paramContext;
    this.yws = paramb1;
    this.xZe = paramb;
    this.xZf = paramFrameLayout;
    this.xZh = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.xZh = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.xZi = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.xZi = AnimationUtils.loadAnimation(paramContext, 2130772023);
    this.ywt = c.a(paramContext, paramb);
    AppMethodBeat.o(97689);
  }
  
  public final boolean dJj()
  {
    AppMethodBeat.i(97691);
    if ((this.yws != null) && (af.dHJ().dJm())) {
      this.yws.dJj();
    }
    if (this.xZg != null)
    {
      this.xZf.removeView(this.xZg);
      this.xZg = null;
      AppMethodBeat.o(97691);
      return true;
    }
    this.xZj = false;
    this.ywv = null;
    this.yww = null;
    AppMethodBeat.o(97691);
    return false;
  }
  
  public final boolean dNa()
  {
    AppMethodBeat.i(97692);
    final int k = this.ywu.getHeight();
    this.ywu.setVisibility(8);
    int i = 0;
    Object localObject = null;
    final int j = 0;
    while (i < this.ywv.getAdapter().getCount())
    {
      localObject = this.ywv.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.yww.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.ywv.getLayoutParams()).bottomMargin = (k - j);
    this.ywv.setVisibility(0);
    localObject = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(97688);
        paramAnonymousTransformation = (RelativeLayout.LayoutParams)b.this.ywv.getLayoutParams();
        if (paramAnonymousFloat == 1.0F) {}
        for (int i = 0;; i = (int)((k - j) * (1.0F - paramAnonymousFloat)))
        {
          paramAnonymousTransformation.bottomMargin = i;
          b.this.ywv.requestLayout();
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
    this.ywv.startAnimation((Animation)localObject);
    AppMethodBeat.o(97692);
    return true;
  }
  
  public final boolean eK(final View paramView)
  {
    AppMethodBeat.i(97690);
    int i;
    if ((af.dHJ().dJm()) && (this.yws != null))
    {
      i = this.yws.eG(paramView);
      if ((i == 0) || (i == 1))
      {
        AppMethodBeat.o(97690);
        return true;
      }
      ac.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
    }
    for (;;)
    {
      if (this.xZj)
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
        localObject1 = af.dHR().auT(((com.tencent.mm.plugin.sns.data.b)localObject1).ddB);
        d.a(com.tencent.mm.plugin.sns.ad.timeline.feedback.a.b.a((p)localObject1, false, paramView, this.ywr));
        if (this.ywt == null) {
          continue;
        }
        boolean bool = this.ywt.a(paramView, (p)localObject1);
        if (!bool) {
          continue;
        }
        AppMethodBeat.o(97690);
        return true;
      }
      catch (Throwable localThrowable) {}
      if (this.xZg != null)
      {
        if ((this.xZg.getTag() instanceof a))
        {
          paramView = ((a)this.xZg.getTag()).xIw;
          this.xZj = true;
          paramView.startAnimation(this.xZi);
          this.xZi.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymousAnimation)
            {
              AppMethodBeat.i(97687);
              if (paramView != null)
              {
                paramView.clearAnimation();
                paramView.setVisibility(8);
                b.this.dJj();
              }
              b.this.xZj = false;
              AppMethodBeat.o(97687);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
            
            public final void onAnimationStart(Animation paramAnonymousAnimation)
            {
              b.this.xZj = true;
            }
          });
        }
        for (;;)
        {
          AppMethodBeat.o(97690);
          return false;
          dJj();
        }
      }
      if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
      {
        AppMethodBeat.o(97690);
        return false;
      }
      com.tencent.mm.plugin.sns.data.b localb = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
      Object localObject2 = localb.ddB;
      this.xZg = new AbsoluteLayout(this.mContext);
      this.xZg.setId(2131296470);
      new FrameLayout.LayoutParams(-1, -1);
      this.xZf.addView(this.xZg);
      int j = BackwardSupportUtil.b.g(this.mContext, 150.0F);
      int k = BackwardSupportUtil.b.g(this.mContext, 17.0F);
      BackwardSupportUtil.b.g(this.mContext, 40.0F);
      final View localView = z.jD(this.mContext).inflate(2131492940, null);
      TextView localTextView = (TextView)localView.findViewById(2131296446);
      Object localObject1 = ab.iC(ai.getContext());
      com.tencent.mm.plugin.sns.storage.b localb1 = localb.xMy.yYg;
      if (localb1 != null)
      {
        if (!"zh_CN".equals(localObject1)) {
          break label654;
        }
        localObject1 = localb1.yfL;
        if (!bs.isNullOrNil((String)localObject1))
        {
          localTextView.setText((CharSequence)localObject1);
          localTextView.setClickable(true);
        }
      }
      new Rect();
      i = com.tencent.mm.pluginsdk.g.hh(this.mContext);
      localObject1 = localb.xMy.dRt();
      ac.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject1[0] + "  " + localObject1[1] + " height: " + i);
      this.xJx = aj.ji(this.mContext);
      if (this.mwy)
      {
        i = a.fromDPToPix(this.mContext, 2);
        this.xJx = 0;
      }
      for (;;)
      {
        localObject1 = new AbsoluteLayout.LayoutParams(-2, -2, localObject1[0] - j, localObject1[1] - this.xJx - i + k);
        localObject2 = new a((String)localObject2, localView);
        this.xZg.setTag(localObject2);
        this.xZg.addView(localView, (ViewGroup.LayoutParams)localObject1);
        localView.setVisibility(8);
        this.xZj = true;
        new ao().post(new Runnable()
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
          localObject1 = localb1.yfN;
          break;
        }
        localObject1 = localb1.yfM;
        break;
        i = a.fromDPToPix(this.mContext, 2) + i;
      }
    }
  }
  
  final class a
  {
    View xIw = null;
    String xZz;
    
    public a(String paramString, View paramView)
    {
      this.xZz = paramString;
      this.xIw = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */