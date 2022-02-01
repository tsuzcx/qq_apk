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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.sns.data.e;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;

public final class am
{
  private Context mContext;
  boolean mXd;
  private int yYM;
  private b zNE;
  private c zpd;
  private FrameLayout zpe;
  AbsoluteLayout zpf;
  protected Animation zpg;
  protected Animation zph;
  boolean zpi;
  
  public am(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(98144);
    this.zpf = null;
    this.zpi = false;
    this.mXd = false;
    this.yYM = -1;
    this.mContext = paramContext;
    this.zpd = paramc;
    this.zpe = paramFrameLayout;
    this.zpg = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.zpg = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.zph = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.zph = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(98144);
  }
  
  private void fi(final View paramView)
  {
    AppMethodBeat.i(98146);
    this.zpi = true;
    paramView.startAnimation(this.zph);
    this.zph.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(98143);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          am.this.dVw();
        }
        am.this.zpi = false;
        AppMethodBeat.o(98143);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        am.this.zpi = true;
      }
    });
    AppMethodBeat.o(98146);
  }
  
  public final boolean dVw()
  {
    AppMethodBeat.i(98147);
    if ((this.zNE != null) && (ag.dTW().dVz())) {
      this.zNE.dVw();
    }
    if (this.zpf != null)
    {
      this.zpe.removeView(this.zpf);
      this.zpf = null;
      AppMethodBeat.o(98147);
      return true;
    }
    this.zpi = false;
    AppMethodBeat.o(98147);
    return false;
  }
  
  public final boolean eZ(final View paramView)
  {
    AppMethodBeat.i(98145);
    if (this.zpi)
    {
      AppMethodBeat.o(98145);
      return false;
    }
    if (this.zpf != null)
    {
      if ((this.zpf.getTag() instanceof a)) {
        fi(((a)this.zpf.getTag()).yXL);
      }
      for (;;)
      {
        AppMethodBeat.o(98145);
        return false;
        dVw();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
    {
      AppMethodBeat.o(98145);
      return false;
    }
    Object localObject2 = (e)paramView.getTag();
    Object localObject1 = ((e)localObject2).doX;
    this.zpf = new AbsoluteLayout(this.mContext);
    this.zpf.setId(2131296470);
    this.zpe.addView(this.zpf);
    int j = BackwardSupportUtil.b.g(this.mContext, 126.0F);
    int k = BackwardSupportUtil.b.g(this.mContext, 30.0F);
    final View localView = z.jO(this.mContext).inflate(2131495055, null);
    localView.setOnClickListener(this.zpd.AyV);
    localView.setTag(localObject2);
    int[] arrayOfInt = new int[2];
    int i = h.hm(this.mContext);
    ((e)localObject2).zcI.getLocationInWindow(arrayOfInt);
    ad.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + arrayOfInt[0] + "  " + arrayOfInt[1] + " height: " + i);
    this.yYM = al.jH(this.mContext);
    if (this.mXd)
    {
      i = a.fromDPToPix(this.mContext, 2);
      this.yYM = 0;
    }
    for (;;)
    {
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, arrayOfInt[0] - j, arrayOfInt[1] - this.yYM - i + k);
      localObject1 = new a((String)localObject1, localView);
      this.zpf.setTag(localObject1);
      this.zpf.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      this.zpi = true;
      new ap().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98142);
          am.a(am.this, localView);
          AppMethodBeat.o(98142);
        }
      });
      AppMethodBeat.o(98145);
      return true;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.am
 * JD-Core Version:    0.7.0.1
 */