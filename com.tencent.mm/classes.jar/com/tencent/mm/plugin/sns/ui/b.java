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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.y;

public final class b
{
  boolean lUw;
  private Context mContext;
  AbsoluteLayout wMA;
  protected Animation wMB;
  protected Animation wMC;
  boolean wMD;
  private com.tencent.mm.plugin.sns.ui.d.b wMy;
  private FrameLayout wMz;
  private int wxW;
  private com.tencent.mm.plugin.sns.i.b xjA;
  TextView xjB;
  ListView xjC;
  View xjD;
  
  public b(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout, com.tencent.mm.plugin.sns.i.b paramb1)
  {
    AppMethodBeat.i(97689);
    this.wMA = null;
    this.wMD = false;
    this.lUw = false;
    this.wxW = -1;
    this.mContext = paramContext;
    this.xjA = paramb1;
    this.wMy = paramb;
    this.wMz = paramFrameLayout;
    this.wMB = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.wMB = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.wMC = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.wMC = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(97689);
  }
  
  public final boolean duJ()
  {
    AppMethodBeat.i(97691);
    if ((this.xjA != null) && (af.dtm().duM())) {
      this.xjA.duJ();
    }
    if (this.wMA != null)
    {
      this.wMz.removeView(this.wMA);
      this.wMA = null;
      AppMethodBeat.o(97691);
      return true;
    }
    this.wMD = false;
    this.xjC = null;
    this.xjD = null;
    AppMethodBeat.o(97691);
    return false;
  }
  
  public final boolean dyD()
  {
    AppMethodBeat.i(97692);
    final int k = this.xjB.getHeight();
    this.xjB.setVisibility(8);
    int i = 0;
    Object localObject = null;
    final int j = 0;
    while (i < this.xjC.getAdapter().getCount())
    {
      localObject = this.xjC.getAdapter().getView(i, (View)localObject, null);
      ((View)localObject).measure(this.xjD.getWidth(), -2);
      j += ((View)localObject).getMeasuredHeight();
      i += 1;
    }
    ((RelativeLayout.LayoutParams)this.xjC.getLayoutParams()).bottomMargin = (k - j);
    this.xjC.setVisibility(0);
    localObject = new Animation()
    {
      protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
      {
        AppMethodBeat.i(97688);
        paramAnonymousTransformation = (RelativeLayout.LayoutParams)b.this.xjC.getLayoutParams();
        if (paramAnonymousFloat == 1.0F) {}
        for (int i = 0;; i = (int)((k - j) * (1.0F - paramAnonymousFloat)))
        {
          paramAnonymousTransformation.bottomMargin = i;
          b.this.xjC.requestLayout();
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
    this.xjC.startAnimation((Animation)localObject);
    AppMethodBeat.o(97692);
    return true;
  }
  
  public final boolean ex(final View paramView)
  {
    AppMethodBeat.i(97690);
    if ((af.dtm().duM()) && (this.xjA != null))
    {
      i = this.xjA.et(paramView);
      if ((i == 0) || (i == 1))
      {
        AppMethodBeat.o(97690);
        return true;
      }
      ad.i("MicroMsg.AdNotLikeHelper", "abtest error return 2");
    }
    if (this.wMD)
    {
      AppMethodBeat.o(97690);
      return false;
    }
    if (this.wMA != null)
    {
      if ((this.wMA.getTag() instanceof a))
      {
        paramView = ((a)this.wMA.getTag()).wwV;
        this.wMD = true;
        paramView.startAnimation(this.wMC);
        this.wMC.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(97687);
            if (paramView != null)
            {
              paramView.clearAnimation();
              paramView.setVisibility(8);
              b.this.duJ();
            }
            b.this.wMD = false;
            AppMethodBeat.o(97687);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation)
          {
            b.this.wMD = true;
          }
        });
      }
      for (;;)
      {
        AppMethodBeat.o(97690);
        return false;
        duJ();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.b)))
    {
      AppMethodBeat.o(97690);
      return false;
    }
    com.tencent.mm.plugin.sns.data.b localb = (com.tencent.mm.plugin.sns.data.b)paramView.getTag();
    Object localObject2 = localb.dgg;
    this.wMA = new AbsoluteLayout(this.mContext);
    this.wMA.setId(2131296470);
    new FrameLayout.LayoutParams(-1, -1);
    this.wMz.addView(this.wMA);
    int j = BackwardSupportUtil.b.g(this.mContext, 150.0F);
    int k = BackwardSupportUtil.b.g(this.mContext, 17.0F);
    BackwardSupportUtil.b.g(this.mContext, 40.0F);
    final View localView = y.js(this.mContext).inflate(2131492940, null);
    TextView localTextView = (TextView)localView.findViewById(2131296446);
    Object localObject1 = ac.ir(aj.getContext());
    com.tencent.mm.plugin.sns.storage.b localb1 = localb.wAe.xLr;
    if (localb1 != null)
    {
      if (!"zh_CN".equals(localObject1)) {
        break label578;
      }
      localObject1 = localb1.wTb;
      if (!bt.isNullOrNil((String)localObject1))
      {
        localTextView.setText((CharSequence)localObject1);
        localTextView.setClickable(true);
      }
    }
    new Rect();
    int i = com.tencent.mm.pluginsdk.g.gW(this.mContext);
    localObject1 = localb.wAe.dCW();
    ad.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + localObject1[0] + "  " + localObject1[1] + " height: " + i);
    this.wxW = ai.iX(this.mContext);
    if (this.lUw)
    {
      i = a.fromDPToPix(this.mContext, 2);
      this.wxW = 0;
    }
    for (;;)
    {
      localObject1 = new AbsoluteLayout.LayoutParams(-2, -2, localObject1[0] - j, localObject1[1] - this.wxW - i + k);
      localObject2 = new a((String)localObject2, localView);
      this.wMA.setTag(localObject2);
      this.wMA.addView(localView, (ViewGroup.LayoutParams)localObject1);
      localView.setVisibility(8);
      this.wMD = true;
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
      label578:
      if (("zh_TW".equals(localObject1)) || ("zh_HK".equals(localObject1)))
      {
        localObject1 = localb1.wTd;
        break;
      }
      localObject1 = localb1.wTc;
      break;
      i = a.fromDPToPix(this.mContext, 2) + i;
    }
  }
  
  final class a
  {
    String wMT;
    View wwV = null;
    
    public a(String paramString, View paramView)
    {
      this.wMT = paramString;
      this.wwV = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.b
 * JD-Core Version:    0.7.0.1
 */