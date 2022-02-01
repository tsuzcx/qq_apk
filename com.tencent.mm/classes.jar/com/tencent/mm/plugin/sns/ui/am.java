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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.data.f;
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.h.g;
import com.tencent.mm.plugin.sns.model.ah;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.z;

public final class am
{
  private b AeL;
  private Context mContext;
  boolean ncj;
  private c zGs;
  private FrameLayout zGt;
  AbsoluteLayout zGu;
  protected Animation zGv;
  protected Animation zGw;
  boolean zGx;
  private int zpn;
  
  public am(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(98144);
    this.zGu = null;
    this.zGx = false;
    this.ncj = false;
    this.zpn = -1;
    this.mContext = paramContext;
    this.zGs = paramc;
    this.zGt = paramFrameLayout;
    this.zGv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.zGv = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.zGw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.zGw = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(98144);
  }
  
  private void fh(final View paramView)
  {
    AppMethodBeat.i(98146);
    this.zGx = true;
    paramView.startAnimation(this.zGw);
    this.zGw.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(98143);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          am.this.dYX();
        }
        am.this.zGx = false;
        AppMethodBeat.o(98143);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        am.this.zGx = true;
      }
    });
    AppMethodBeat.o(98146);
  }
  
  public final boolean dYX()
  {
    AppMethodBeat.i(98147);
    if ((this.AeL != null) && (ah.dXw().dZa())) {
      this.AeL.dYX();
    }
    if (this.zGu != null)
    {
      this.zGt.removeView(this.zGu);
      this.zGu = null;
      AppMethodBeat.o(98147);
      return true;
    }
    this.zGx = false;
    AppMethodBeat.o(98147);
    return false;
  }
  
  public final boolean eY(final View paramView)
  {
    AppMethodBeat.i(98145);
    if (this.zGx)
    {
      AppMethodBeat.o(98145);
      return false;
    }
    if (this.zGu != null)
    {
      if ((this.zGu.getTag() instanceof a)) {
        fh(((a)this.zGu.getTag()).zom);
      }
      for (;;)
      {
        AppMethodBeat.o(98145);
        return false;
        dYX();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof f)))
    {
      AppMethodBeat.o(98145);
      return false;
    }
    Object localObject2 = (f)paramView.getTag();
    Object localObject1 = ((f)localObject2).dqc;
    this.zGu = new AbsoluteLayout(this.mContext);
    this.zGu.setId(2131296470);
    this.zGt.addView(this.zGu);
    int j = BackwardSupportUtil.b.h(this.mContext, 126.0F);
    int k = BackwardSupportUtil.b.h(this.mContext, 30.0F);
    final View localView = z.jV(this.mContext).inflate(2131495055, null);
    localView.setOnClickListener(this.zGs.AQr);
    localView.setTag(localObject2);
    int[] arrayOfInt = new int[2];
    int i = h.hs(this.mContext);
    ((f)localObject2).zty.getLocationInWindow(arrayOfInt);
    ae.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + arrayOfInt[0] + "  " + arrayOfInt[1] + " height: " + i);
    this.zpn = al.jO(this.mContext);
    if (this.ncj)
    {
      i = a.fromDPToPix(this.mContext, 2);
      this.zpn = 0;
    }
    for (;;)
    {
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, arrayOfInt[0] - j, arrayOfInt[1] - this.zpn - i + k);
      localObject1 = new a((String)localObject1, localView);
      this.zGu.setTag(localObject1);
      this.zGu.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      this.zGx = true;
      new aq().post(new Runnable()
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.am
 * JD-Core Version:    0.7.0.1
 */