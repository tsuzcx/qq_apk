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
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.z;

public final class aj
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
  private com.tencent.mm.plugin.sns.h.b yws;
  
  public aj(Context paramContext, com.tencent.mm.plugin.sns.ui.d.b paramb, FrameLayout paramFrameLayout)
  {
    AppMethodBeat.i(98144);
    this.xZg = null;
    this.xZj = false;
    this.mwy = false;
    this.xJx = -1;
    this.mContext = paramContext;
    this.xZe = paramb;
    this.xZf = paramFrameLayout;
    this.xZh = new ScaleAnimation(1.0F, 1.0F, 0.0F, 1.0F, 1, 1.0F, 1, 0.0F);
    this.xZh = AnimationUtils.loadAnimation(paramContext, 2130772022);
    this.xZi = new ScaleAnimation(1.0F, 1.0F, 1.0F, 0.0F, 1, 1.0F, 1, 0.0F);
    this.xZi = AnimationUtils.loadAnimation(paramContext, 2130772023);
    AppMethodBeat.o(98144);
  }
  
  private void eT(final View paramView)
  {
    AppMethodBeat.i(98146);
    this.xZj = true;
    paramView.startAnimation(this.xZi);
    this.xZi.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(98143);
        if (paramView != null)
        {
          paramView.clearAnimation();
          paramView.setVisibility(8);
          aj.this.dJj();
        }
        aj.this.xZj = false;
        AppMethodBeat.o(98143);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        aj.this.xZj = true;
      }
    });
    AppMethodBeat.o(98146);
  }
  
  public final boolean dJj()
  {
    AppMethodBeat.i(98147);
    if ((this.yws != null) && (af.dHJ().dJm())) {
      this.yws.dJj();
    }
    if (this.xZg != null)
    {
      this.xZf.removeView(this.xZg);
      this.xZg = null;
      AppMethodBeat.o(98147);
      return true;
    }
    this.xZj = false;
    AppMethodBeat.o(98147);
    return false;
  }
  
  public final boolean eK(final View paramView)
  {
    AppMethodBeat.i(98145);
    if (this.xZj)
    {
      AppMethodBeat.o(98145);
      return false;
    }
    if (this.xZg != null)
    {
      if ((this.xZg.getTag() instanceof a)) {
        eT(((a)this.xZg.getTag()).xIw);
      }
      for (;;)
      {
        AppMethodBeat.o(98145);
        return false;
        dJj();
      }
    }
    if ((paramView.getTag() == null) || (!(paramView.getTag() instanceof e)))
    {
      AppMethodBeat.o(98145);
      return false;
    }
    Object localObject2 = (e)paramView.getTag();
    Object localObject1 = ((e)localObject2).ddB;
    this.xZg = new AbsoluteLayout(this.mContext);
    this.xZg.setId(2131296470);
    this.xZf.addView(this.xZg);
    int j = BackwardSupportUtil.b.g(this.mContext, 126.0F);
    int k = BackwardSupportUtil.b.g(this.mContext, 30.0F);
    final View localView = z.jD(this.mContext).inflate(2131495055, null);
    localView.setOnClickListener(this.xZe.zgS);
    localView.setTag(localObject2);
    int[] arrayOfInt = new int[2];
    int i = com.tencent.mm.pluginsdk.g.hh(this.mContext);
    ((e)localObject2).xMQ.getLocationInWindow(arrayOfInt);
    ac.d("MicroMsg.AdNotLikeHelper", "addCommentView getLocationInWindow " + arrayOfInt[0] + "  " + arrayOfInt[1] + " height: " + i);
    this.xJx = com.tencent.mm.ui.aj.jw(this.mContext);
    if (this.mwy)
    {
      i = a.fromDPToPix(this.mContext, 2);
      this.xJx = 0;
    }
    for (;;)
    {
      localObject2 = new AbsoluteLayout.LayoutParams(-2, -2, arrayOfInt[0] - j, arrayOfInt[1] - this.xJx - i + k);
      localObject1 = new a((String)localObject1, localView);
      this.xZg.setTag(localObject1);
      this.xZg.addView(localView, (ViewGroup.LayoutParams)localObject2);
      localView.setVisibility(8);
      this.xZj = true;
      new ao().post(new Runnable()
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.aj
 * JD-Core Version:    0.7.0.1
 */