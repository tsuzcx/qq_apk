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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ax;

public final class ar
{
  boolean AJP;
  private int INC;
  private b KAr;
  private FrameLayout KdA;
  AbsoluteLayout KdB;
  protected Animation KdC;
  protected Animation KdD;
  boolean KdE;
  private c Kdz;
  private Context mContext;
  
  public ar(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(98144);
    this.KdB = null;
    this.KdE = false;
    this.AJP = false;
    this.INC = -1;
    this.mContext = paramContext;
    this.Kdz = paramc;
    this.KdA = paramFrameLayout;
    this.KdC = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.KdC = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_down);
    this.KdD = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.KdD = AnimationUtils.loadAnimation(paramContext, i.a.dropdown_up);
    AppMethodBeat.o(98144);
  }
  
  private void gD(final View paramView)
  {
    AppMethodBeat.i(98146);
    this.KdE = true;
    paramView.startAnimation(this.KdD);
    this.KdD.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(98143);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          ar.this.fQe();
        }
        ar.this.KdE = false;
        AppMethodBeat.o(98143);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        ar.this.KdE = true;
      }
    });
    AppMethodBeat.o(98146);
  }
  
  public final boolean fQe()
  {
    AppMethodBeat.i(98147);
    if ((this.KAr != null) && (aj.fOA().fQh())) {
      this.KAr.fQe();
    }
    if (this.KdB != null)
    {
      this.KdA.removeView(this.KdB);
      this.KdB = null;
      AppMethodBeat.o(98147);
      return true;
    }
    this.KdE = false;
    AppMethodBeat.o(98147);
    return false;
  }
  
  public final boolean x(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(229318);
    if (this.KdE)
    {
      AppMethodBeat.o(229318);
      return false;
    }
    if (this.KdB != null)
    {
      if ((this.KdB.getTag() instanceof a)) {
        gD(((a)this.KdB.getTag()).GiP);
      }
      for (;;)
      {
        AppMethodBeat.o(229318);
        return false;
        fQe();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof i)))
    {
      AppMethodBeat.o(229318);
      return false;
    }
    Object localObject2 = (i)paramView.getTag();
    Object localObject1 = ((i)localObject2).fAg;
    this.KdB = new AbsoluteLayout(this.mContext);
    this.KdB.setId(i.f.address);
    this.KdA.addView(this.KdB);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 126.0F);
    int m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 30.0F);
    final View localView = ad.kS(this.mContext).inflate(i.g.open_im_unlike_content, null);
    localView.setOnClickListener(this.Kdz.Lpu);
    localView.setTag(localObject2);
    int i = 0;
    if (paramBoolean) {
      i = ax.ew(this.mContext);
    }
    int[] arrayOfInt = new int[2];
    int j = h.jp(this.mContext);
    ((i)localObject2).JQo.getLocationInWindow(arrayOfInt);
    Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + arrayOfInt[0] + "  " + arrayOfInt[1] + " height: " + j);
    this.INC = com.tencent.mm.ui.ar.kI(this.mContext);
    if (this.AJP)
    {
      j = a.fromDPToPix(this.mContext, 2);
      this.INC = 0;
    }
    for (;;)
    {
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, arrayOfInt[0] - k, arrayOfInt[1] - this.INC - j + m - i);
      localObject1 = new a((String)localObject1, localView);
      this.KdB.setTag(localObject1);
      this.KdB.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      this.KdE = true;
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98142);
          ar.a(ar.this, localView);
          AppMethodBeat.o(98142);
        }
      });
      AppMethodBeat.o(229318);
      return true;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ar
 * JD-Core Version:    0.7.0.1
 */