package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.sns.i.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class o
  extends m
{
  private TextView KqM;
  private int KqN;
  public int KqO;
  AnimatorSet atV;
  private ImageView eL;
  
  public o(Context paramContext, q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    AppMethodBeat.i(258560);
    this.KqN = 0;
    paramq.KmE = 2.147484E+009F;
    this.KqO = com.tencent.mm.ci.a.fromDPToPix(paramContext, 130);
    AppMethodBeat.o(258560);
  }
  
  public final boolean by(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(258580);
    if (!super.by(paramJSONObject))
    {
      Log.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData super failed");
      AppMethodBeat.o(258580);
      return false;
    }
    try
    {
      paramJSONObject.put("jumpCount", this.KqN);
      Log.i("AdLandingPageBottomSwipeComponet", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(258580);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(258580);
    }
    return false;
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(258572);
    if ((this.KqM == null) || (this.eL == null) || ((q)this.KqB == null))
    {
      AppMethodBeat.o(258572);
      return;
    }
    if (!TextUtils.isEmpty(((q)this.KqB).KlH)) {
      this.KqM.setText(((q)this.KqB).KlH);
    }
    AppMethodBeat.o(258572);
  }
  
  protected final void fKi()
  {
    AppMethodBeat.i(258570);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((q)this.KqB).paddingLeft, (int)((q)this.KqB).paddingTop, (int)((q)this.KqB).paddingRight, (int)((q)this.KqB).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(258570);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(258577);
    super.fKo();
    this.atV.removeAllListeners();
    AppMethodBeat.o(258577);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(258568);
    this.eL = ((ImageView)this.contentView.findViewById(i.f.swip_icon));
    this.KqM = ((TextView)this.contentView.findViewById(i.f.swip_txt));
    Object localObject = this.eL;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -com.tencent.mm.ci.a.fromDPToPix(this.context, 12) });
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 0.8F });
    localObjectAnimator2.setDuration(1000L);
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.8F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(500L);
    this.atV = new AnimatorSet();
    this.atV.play(localObjectAnimator1).with(localObjectAnimator2);
    this.atV.play((Animator)localObject).after(localObjectAnimator1);
    this.atV.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(270685);
        Log.d("AdLandingPageBottomSwipeComponet", "onAnimationCancel");
        AppMethodBeat.o(270685);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(270684);
        o.this.atV.start();
        Log.d("AdLandingPageBottomSwipeComponet", "onAnimationEnd");
        AppMethodBeat.o(270684);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(270686);
        Log.d("AdLandingPageBottomSwipeComponet", "onAnimationRepeat");
        AppMethodBeat.o(270686);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(270683);
        Log.d("AdLandingPageBottomSwipeComponet", "onAnimationStart");
        AppMethodBeat.o(270683);
      }
    });
    this.atV.start();
    if (((q)this.KqB).KmF)
    {
      this.KqM.setTextColor(Color.parseColor("#CC000000"));
      this.eL.setImageResource(i.e.ad_landing_pages_bottom_swipe_black_icon);
    }
    for (;;)
    {
      this.contentView.findViewById(i.f.click_area).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(220992);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          o.this.fRs();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(220992);
        }
      });
      AppMethodBeat.o(258568);
      return;
      this.KqM.setTextColor(Color.parseColor("#CCFFFFFF"));
      this.eL.setImageResource(i.e.ad_landing_pages_bottom_swipe_white_icon);
    }
  }
  
  public final void fRs()
  {
    AppMethodBeat.i(258575);
    this.KqN += 1;
    if ((this.context instanceof SnsAdNativeLandingPagesUI)) {
      try
      {
        int i = ((q)this.KqB).KlI;
        Log.i("AdLandingPageBottomSwipeComponet", "doJump, swipCount=" + this.KqN + ", actionType=" + i);
        if (i == 0)
        {
          SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)this.context;
          long l = y.aYS(localSnsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
          i = localSnsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 0);
          String str = ((q)this.KqB).jumpUrl;
          com.tencent.mm.plugin.sns.data.m.a(this.context, str, fRp(), i, l, ((q)this.KqB).KmB);
          localSnsAdNativeLandingPagesUI.overridePendingTransition(i.a.push_up_in, i.a.anim_not_change);
        }
        AppMethodBeat.o(258575);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdLandingPageBottomSwipeComponet", "doJump exp=" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(258575);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_pages_item_bottom_swipe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */