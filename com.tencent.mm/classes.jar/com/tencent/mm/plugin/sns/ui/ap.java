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
import com.tencent.mm.plugin.sns.h.b;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;

public final class ap
{
  private int CHZ;
  private c DQs;
  private FrameLayout DQt;
  AbsoluteLayout DQu;
  protected Animation DQv;
  protected Animation DQw;
  boolean DQx;
  private b Eni;
  private Context mContext;
  boolean onr;
  
  public ap(Context paramContext, c paramc, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(98144);
    this.DQu = null;
    this.DQx = false;
    this.onr = false;
    this.CHZ = -1;
    this.mContext = paramContext;
    this.DQs = paramc;
    this.DQt = paramFrameLayout;
    this.DQv = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.DQv = AnimationUtils.loadAnimation(paramContext, 2130772028);
    this.DQw = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.DQw = AnimationUtils.loadAnimation(paramContext, 2130772029);
    AppMethodBeat.o(98144);
  }
  
  private void fw(final View paramView)
  {
    AppMethodBeat.i(98146);
    this.DQx = true;
    paramView.startAnimation(this.DQw);
    this.DQw.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(98143);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          ap.this.fcl();
        }
        ap.this.DQx = false;
        AppMethodBeat.o(98143);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        ap.this.DQx = true;
      }
    });
    AppMethodBeat.o(98146);
  }
  
  public final boolean fcl()
  {
    AppMethodBeat.i(98147);
    if ((this.Eni != null) && (aj.faG().fco())) {
      this.Eni.fcl();
    }
    if (this.DQu != null)
    {
      this.DQt.removeView(this.DQu);
      this.DQu = null;
      AppMethodBeat.o(98147);
      return true;
    }
    this.DQx = false;
    AppMethodBeat.o(98147);
    return false;
  }
  
  public final boolean v(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(203354);
    if (this.DQx)
    {
      AppMethodBeat.o(203354);
      return false;
    }
    if (this.DQu != null)
    {
      if ((this.DQu.getTag() instanceof a)) {
        fw(((a)this.DQu.getTag()).Atk);
      }
      for (;;)
      {
        AppMethodBeat.o(203354);
        return false;
        fcl();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof com.tencent.mm.plugin.sns.data.g)))
    {
      AppMethodBeat.o(203354);
      return false;
    }
    Object localObject2 = (com.tencent.mm.plugin.sns.data.g)paramView.getTag();
    Object localObject1 = ((com.tencent.mm.plugin.sns.data.g)localObject2).dHp;
    this.DQu = new AbsoluteLayout(this.mContext);
    this.DQu.setId(2131296543);
    this.DQt.addView(this.DQu);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 126.0F);
    int m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 30.0F);
    final View localView = aa.jQ(this.mContext).inflate(2131495887, null);
    localView.setOnClickListener(this.DQs.FaW);
    localView.setTag(localObject2);
    int i = 0;
    if (paramBoolean) {
      i = au.eu(this.mContext);
    }
    int[] arrayOfInt = new int[2];
    int j = h.im(this.mContext);
    ((com.tencent.mm.plugin.sns.data.g)localObject2).DDJ.getLocationInWindow(arrayOfInt);
    Log.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + arrayOfInt[0] + "  " + arrayOfInt[1] + " height: " + j);
    this.CHZ = ao.jJ(this.mContext);
    if (this.onr)
    {
      j = a.fromDPToPix(this.mContext, 2);
      this.CHZ = 0;
    }
    for (;;)
    {
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, arrayOfInt[0] - k, arrayOfInt[1] - this.CHZ - j + m - i);
      localObject1 = new a((String)localObject1, localView);
      this.DQu.setTag(localObject1);
      this.DQu.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      this.DQx = true;
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(98142);
          ap.a(ap.this, localView);
          AppMethodBeat.o(98142);
        }
      });
      AppMethodBeat.o(203354);
      return true;
    }
  }
  
  final class a
  {
    View Atk = null;
    String DQN;
    
    public a(String paramString, View paramView)
    {
      this.DQN = paramString;
      this.Atk = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.ap
 * JD-Core Version:    0.7.0.1
 */