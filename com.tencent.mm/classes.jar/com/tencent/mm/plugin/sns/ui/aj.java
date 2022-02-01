package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.y;

public final class aj
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
  
  public aj(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(98144);
    this.wMA = null;
    this.wMD = false;
    this.lUw = false;
    this.wxW = -1;
    this.mContext = paramContext;
    this.wMy = paramb;
    this.wMz = paramFrameLayout;
    this.wMB = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.wMB = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.wMC = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.wMC = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(98144);
  }
  
  private void eG(final View paramView)
  {
    AppMethodBeat.i(98146);
    this.wMD = true;
    paramView.startAnimation(this.wMC);
    this.wMC.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(98143);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          aj.this.duJ();
        }
        aj.this.wMD = false;
        AppMethodBeat.o(98143);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        aj.this.wMD = true;
      }
    });
    AppMethodBeat.o(98146);
  }
  
  public final boolean duJ()
  {
    AppMethodBeat.i(98147);
    if ((this.xjA != null) && (af.dtm().duM())) {
      this.xjA.duJ();
    }
    if (this.wMA != null)
    {
      this.wMz.removeView(this.wMA);
      this.wMA = null;
      AppMethodBeat.o(98147);
      return true;
    }
    this.wMD = false;
    AppMethodBeat.o(98147);
    return false;
  }
  
  public final boolean ex(final View paramView)
  {
    AppMethodBeat.i(98145);
    if (this.wMD)
    {
      AppMethodBeat.o(98145);
      return false;
    }
    if (this.wMA != null)
    {
      if ((this.wMA.getTag() instanceof a)) {
        eG(((a)this.wMA.getTag()).wwV);
      }
      for (;;)
      {
        AppMethodBeat.o(98145);
        return false;
        duJ();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
    {
      AppMethodBeat.o(98145);
      return false;
    }
    Object localObject2 = (e)paramView.getTag();
    Object localObject1 = ((e)localObject2).dgg;
    this.wMA = new AbsoluteLayout(this.mContext);
    this.wMA.setId(2131296470);
    this.wMz.addView(this.wMA);
    int j = BackwardSupportUtil.b.g(this.mContext, 126.0F);
    int k = BackwardSupportUtil.b.g(this.mContext, 30.0F);
    final View localView = y.js(this.mContext).inflate(2131495055, null);
    localView.setOnClickListener(this.wMy.xTW);
    localView.setTag(localObject2);
    int[] arrayOfInt = new int[2];
    int i = com.tencent.mm.pluginsdk.g.gW(this.mContext);
    ((e)localObject2).wAx.getLocationInWindow(arrayOfInt);
    ad.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + arrayOfInt[0] + "  " + arrayOfInt[1] + " height: " + i);
    this.wxW = ai.jl(this.mContext);
    if (this.lUw)
    {
      i = a.fromDPToPix(this.mContext, 2);
      this.wxW = 0;
    }
    for (;;)
    {
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, arrayOfInt[0] - j, arrayOfInt[1] - this.wxW - i + k);
      localObject1 = new a((String)localObject1, localView);
      this.wMA.setTag(localObject1);
      this.wMA.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      this.wMD = true;
      new ap().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98142);
          aj.a(aj.this, localView);
          AppMethodBeat.o(98142);
        }
      });
      AppMethodBeat.o(98145);
      return true;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aj
 * JD-Core Version:    0.7.0.1
 */