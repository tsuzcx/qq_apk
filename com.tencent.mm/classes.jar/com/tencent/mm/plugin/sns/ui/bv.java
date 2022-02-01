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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;

public final class bv
{
  private int INC = -1;
  LinearLayout KOR;
  LinearLayout KOS;
  private FrameLayout KdA;
  private bm Kee;
  SnsCommentShowAbLayout LfH = null;
  private Context mContext;
  
  public bv(Context paramContext, bm parambm, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.Kee = parambm;
    this.KdA = paramFrameLayout;
  }
  
  private void gI(final View paramView)
  {
    AppMethodBeat.i(99748);
    paramView.clearAnimation();
    paramView.startAnimation(this.Kee.KOQ);
    this.Kee.KOQ.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99747);
        if (paramView != null)
        {
          paramView.setVisibility(8);
          bv.this.fTI();
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
    AppMethodBeat.i(210721);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      Log.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      AppMethodBeat.o(210721);
      return false;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    Object localObject1 = localBaseViewHolder.fAg;
    if (this.LfH != null)
    {
      if ((this.LfH.getTag() instanceof a))
      {
        localObject2 = (a)this.LfH.getTag();
        if (((a)localObject2).KdU.equals(localObject1))
        {
          gI(((a)localObject2).GiP);
          Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix closeCommentView.");
          AppMethodBeat.o(210721);
          return true;
        }
        fTI();
      }
      this.LfH = null;
    }
    this.LfH = new SnsCommentShowAbLayout(this.mContext);
    ForceGpuUtil.setLayerType(this.LfH);
    this.LfH.setId(i.f.address);
    new FrameLayout.LayoutParams(-1, -1);
    this.KdA.addView(this.LfH);
    Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix addView(ablayout).");
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 192.0F);
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 76.0F);
    int m = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 8.0F);
    BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 16.0F);
    int n = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0F);
    Object localObject2 = ad.kS(this.mContext).inflate(i.g.sns_comment_button, null);
    new Rect();
    Object localObject3 = new int[2];
    h.jp(this.mContext);
    int i1 = a.fromDPToPix(this.mContext, 1);
    paramView.getLocationInWindow((int[])localObject3);
    this.INC = ar.kI(this.mContext);
    Log.i("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + localObject3[0] + "  " + localObject3[1] + " height: " + i1 + " height_hardcode:" + i + " statusBarHeight: " + this.INC);
    if (paramBoolean1) {}
    for (i = ax.ew(this.mContext);; i = 0)
    {
      int j = 0;
      if (paramBoolean2) {
        j = ax.getStatusBarHeight(this.mContext);
      }
      localObject3 = new AbsoluteLayout.LayoutParams(-2, -2, localObject3[0] - k - m, localObject3[1] - i1 - (n / 2 - paramView.getMeasuredHeight() / 2) - i - j);
      localObject1 = new a((String)localObject1, (View)localObject2);
      this.LfH.setTag(localObject1);
      this.LfH.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix addView(commentView, apar).");
      if (localBaseViewHolder.viewType == 10) {
        ((View)localObject2).findViewById(i.f.album_comment_container).setBackgroundResource(i.e.friendactivity_comment_frame_bg_golden);
      }
      ((View)localObject2).setVisibility(8);
      Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix comment gone.");
      new MMHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(99746);
          Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix initCommentView.");
          bv.a(bv.this, paramView, this.LfI);
          AppMethodBeat.o(99746);
        }
      });
      AppMethodBeat.o(210721);
      return true;
    }
  }
  
  public final boolean fTI()
  {
    AppMethodBeat.i(99749);
    if (this.LfH != null)
    {
      this.KdA.removeView(this.LfH);
      this.LfH = null;
      AppMethodBeat.o(99749);
      return true;
    }
    AppMethodBeat.o(99749);
    return false;
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
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bv
 * JD-Core Version:    0.7.0.1
 */