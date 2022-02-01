package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;

public final class bs
{
  private int CHZ = -1;
  private bk DQX;
  private FrameLayout DQt;
  LinearLayout EAZ;
  LinearLayout EBa;
  SnsCommentShowAbLayout ERD = null;
  private Context mContext;
  
  public bs(Context paramContext, bk parambk, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.DQX = parambk;
    this.DQt = paramFrameLayout;
  }
  
  private void fB(final View paramView)
  {
    AppMethodBeat.i(99748);
    paramView.clearAnimation();
    paramView.startAnimation(this.DQX.EAY);
    this.DQX.EAY.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99747);
        if (paramView != null)
        {
          paramView.setVisibility(8);
          bs.this.ffL();
        }
        AppMethodBeat.o(99747);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(99748);
  }
  
  public final boolean d(final View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(203845);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      Log.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      AppMethodBeat.o(203845);
      return false;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    Object localObject1 = localBaseViewHolder.dHp;
    if (this.ERD != null)
    {
      if ((this.ERD.getTag() instanceof a))
      {
        localObject2 = (a)this.ERD.getTag();
        if (((a)localObject2).DQN.equals(localObject1))
        {
          fB(((a)localObject2).Atk);
          AppMethodBeat.o(203845);
          return true;
        }
        ffL();
      }
      this.ERD = null;
    }
    this.ERD = new SnsCommentShowAbLayout(this.mContext);
    ForceGpuUtil.setLayerType(this.ERD);
    this.ERD.setId(2131296543);
    new FrameLayout.LayoutParams(-1, -1);
    this.DQt.addView(this.ERD);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 192.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 76.0F);
    int m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 8.0F);
    BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 16.0F);
    int n = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0F);
    Object localObject2 = aa.jQ(this.mContext).inflate(2131496423, null);
    new Rect();
    Object localObject3 = new int[2];
    h.im(this.mContext);
    int i1 = a.fromDPToPix(this.mContext, 1);
    paramView.getLocationInWindow((int[])localObject3);
    this.CHZ = ao.jJ(this.mContext);
    Log.d("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i1 + " height_hardcode:" + i + " statusBarHeight: " + this.CHZ);
    if (paramBoolean1) {}
    for (i = au.eu(this.mContext);; i = 0)
    {
      int j = 0;
      if (paramBoolean2) {
        j = au.getStatusBarHeight(this.mContext);
      }
      localObject3 = new AbsoluteLayout.LayoutParams(-2, -2, localObject3[0] - k - m, localObject3[1] - i1 - (n / 2 - paramView.getMeasuredHeight() / 2) - i - j);
      localObject1 = new a((String)localObject1, (View)localObject2);
      this.ERD.setTag(localObject1);
      this.ERD.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      if (localBaseViewHolder.qcr == 10) {
        ((View)localObject2).findViewById(2131296625).setBackgroundResource(2131232829);
      }
      ((View)localObject2).setVisibility(8);
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99746);
          bs.a(bs.this, paramView, this.ERE);
          AppMethodBeat.o(99746);
        }
      });
      AppMethodBeat.o(203845);
      return true;
    }
  }
  
  public final boolean ffL()
  {
    AppMethodBeat.i(99749);
    if (this.ERD != null)
    {
      this.DQt.removeView(this.ERD);
      this.ERD = null;
      AppMethodBeat.o(99749);
      return true;
    }
    AppMethodBeat.o(99749);
    return false;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bs
 * JD-Core Version:    0.7.0.1
 */