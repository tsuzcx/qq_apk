package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
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
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.ForceGpuUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.af;

public final class bw
{
  private bn QBJ;
  private FrameLayout QBg;
  SnsCommentShowAbLayout RFT = null;
  LinearLayout RoE;
  LinearLayout RoF;
  private Context mContext;
  
  public bw(Context paramContext, bn parambn, FrameLayout paramFrameLayout)
  {
    this.mContext = paramContext;
    this.QBJ = parambn;
    this.QBg = paramFrameLayout;
  }
  
  private void jN(final View paramView)
  {
    AppMethodBeat.i(99748);
    paramView.clearAnimation();
    paramView.startAnimation(this.QBJ.RoD);
    this.QBJ.RoD.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(99747);
        if (paramView != null) {
          paramView.setVisibility(8);
        }
        bw.this.hmb();
        AppMethodBeat.o(99747);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(99748);
  }
  
  public final boolean hmb()
  {
    AppMethodBeat.i(99749);
    if (this.RFT != null)
    {
      Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix removeCommentView.");
      this.QBg.removeView(this.RFT);
      this.RFT = null;
      AppMethodBeat.o(99749);
      return true;
    }
    AppMethodBeat.o(99749);
    return false;
  }
  
  public final boolean jG(final View paramView)
  {
    AppMethodBeat.i(308323);
    if (!(paramView.getTag() instanceof BaseTimeLineItem.BaseViewHolder))
    {
      Log.e("MicroMsg.TimeLineCommentHelper", "showCommentBtn err2");
      AppMethodBeat.o(308323);
      return false;
    }
    BaseTimeLineItem.BaseViewHolder localBaseViewHolder = (BaseTimeLineItem.BaseViewHolder)paramView.getTag();
    Object localObject3 = localBaseViewHolder.hES;
    if (this.RFT != null)
    {
      if ((this.RFT.getTag() instanceof a))
      {
        localObject1 = (a)this.RFT.getTag();
        if (((a)localObject1).QBA.equals(localObject3))
        {
          jN(((a)localObject1).MdP);
          Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix closeCommentView.");
          AppMethodBeat.o(308323);
          return true;
        }
        hmb();
      }
      this.RFT = null;
    }
    this.RFT = new SnsCommentShowAbLayout(this.mContext);
    ForceGpuUtil.setLayerType(this.RFT);
    this.RFT.setId(b.f.address);
    new FrameLayout.LayoutParams(-1, -1);
    this.QBg.addView(this.RFT);
    Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix addView(ablayout).");
    int i = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 76.0F);
    int j = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 12.0F);
    int k = BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 40.0F);
    Object localObject1 = af.mU(this.mContext).inflate(b.g.sns_comment_button, null);
    int[] arrayOfInt = new int[2];
    int m = a.fromDPToPix(this.mContext, 1);
    paramView.getLocationInWindow(arrayOfInt);
    Object localObject2 = new int[2];
    this.RFT.getLocationInWindow((int[])localObject2);
    arrayOfInt[1] -= localObject2[1];
    Log.i("MicroMsg.TimeLineCommentHelper", "addCommentView getLocationInWindow " + arrayOfInt[0] + "  " + arrayOfInt[1] + " height: " + m + " height_hardcode:" + i);
    localObject2 = new AbsoluteLayout.LayoutParams(-1, -2, j, arrayOfInt[1] - m - (k / 2 - paramView.getMeasuredHeight() / 2));
    localObject3 = new a((String)localObject3, (View)localObject1);
    this.RFT.setTag(localObject3);
    localObject3 = new LinearLayout(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout)localObject3).setHorizontalGravity(8388613);
    localLayoutParams.setMarginEnd(BackwardSupportUtil.BitmapFactory.fromDPToPix(this.mContext, 16.0F));
    ((AbsoluteLayout.LayoutParams)localObject2).width = arrayOfInt[0];
    ((LinearLayout)localObject3).addView((View)localObject1, localLayoutParams);
    this.RFT.addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
    Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix addView(commentView, apar).");
    if (localBaseViewHolder.viewType == 10) {
      ((View)localObject1).findViewById(b.f.album_comment_container).setBackgroundResource(b.e.friendactivity_comment_frame_bg_golden);
    }
    ((View)localObject1).setVisibility(8);
    Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix comment gone.");
    new MMHandler().post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99746);
        Log.i("MicroMsg.TimeLineCommentHelper", "snsCommentFix initCommentView.");
        bw.a(bw.this, paramView, this.RFU);
        AppMethodBeat.o(99746);
      }
    });
    AppMethodBeat.o(308323);
    return true;
  }
  
  final class a
  {
    View MdP = null;
    String QBA;
    
    public a(String paramString, View paramView)
    {
      this.QBA = paramString;
      this.MdP = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bw
 * JD-Core Version:    0.7.0.1
 */