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
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ae;
import org.json.JSONObject;

public final class o
  extends m
{
  private ImageView Xk;
  AnimatorSet wV;
  private TextView zVc;
  private int zVd;
  public int zVe;
  
  public o(Context paramContext, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o paramo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramo, paramViewGroup);
    AppMethodBeat.i(219477);
    this.zVd = 0;
    paramo.zRj = 2.147484E+009F;
    this.zVe = com.tencent.mm.cb.a.fromDPToPix(paramContext, 130);
    AppMethodBeat.o(219477);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(219483);
    if (!super.aQ(paramJSONObject))
    {
      ae.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData super failed");
      AppMethodBeat.o(219483);
      return false;
    }
    try
    {
      paramJSONObject.put("jumpCount", this.zVd);
      ae.i("AdLandingPageBottomSwipeComponet", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(219483);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ae.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(219483);
    }
    return false;
  }
  
  public final void dUI()
  {
    AppMethodBeat.i(219478);
    this.Xk = ((ImageView)this.contentView.findViewById(2131305561));
    this.zVc = ((TextView)this.contentView.findViewById(2131305562));
    Object localObject = this.Xk;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -com.tencent.mm.cb.a.fromDPToPix(this.context, 12) });
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 0.8F });
    localObjectAnimator2.setDuration(1000L);
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.8F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(500L);
    this.wV = new AnimatorSet();
    this.wV.play(localObjectAnimator1).with(localObjectAnimator2);
    this.wV.play((Animator)localObject).after(localObjectAnimator1);
    this.wV.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(219475);
        ae.d("AdLandingPageBottomSwipeComponet", "onAnimationCancel");
        AppMethodBeat.o(219475);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(219474);
        o.this.wV.start();
        ae.d("AdLandingPageBottomSwipeComponet", "onAnimationEnd");
        AppMethodBeat.o(219474);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(219476);
        ae.d("AdLandingPageBottomSwipeComponet", "onAnimationRepeat");
        AppMethodBeat.o(219476);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(219473);
        ae.d("AdLandingPageBottomSwipeComponet", "onAnimationStart");
        AppMethodBeat.o(219473);
      }
    });
    this.wV.start();
    if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).zRk)
    {
      this.zVc.setTextColor(Color.parseColor("#CC000000"));
      this.Xk.setImageResource(2131230872);
    }
    for (;;)
    {
      this.contentView.findViewById(2131298353).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(219472);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          o.this.eaG();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(219472);
        }
      });
      AppMethodBeat.o(219478);
      return;
      this.zVc.setTextColor(Color.parseColor("#CCFFFFFF"));
      this.Xk.setImageResource(2131230873);
    }
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(219480);
    if ((this.zVc == null) || (this.Xk == null) || ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP == null))
    {
      AppMethodBeat.o(219480);
      return;
    }
    if (!TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).zQp)) {
      this.zVc.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).zQp);
    }
    AppMethodBeat.o(219480);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(219482);
    super.dUM();
    this.wV.removeAllListeners();
    AppMethodBeat.o(219482);
  }
  
  public final void eaG()
  {
    AppMethodBeat.i(219481);
    this.zVd += 1;
    if ((this.context instanceof SnsAdNativeLandingPagesUI)) {
      try
      {
        int i = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).zQq;
        ae.i("AdLandingPageBottomSwipeComponet", "doJump, swipCount=" + this.zVd + ", actionType=" + i);
        if (i == 0)
        {
          SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)this.context;
          long l = x.aze(localSnsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
          i = localSnsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 0);
          String str = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).jumpUrl;
          k.a(this.context, str, eaD(), i, l, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).zRg);
          localSnsAdNativeLandingPagesUI.overridePendingTransition(2130772108, 2130771986);
        }
        AppMethodBeat.o(219481);
        return;
      }
      catch (Throwable localThrowable)
      {
        ae.e("AdLandingPageBottomSwipeComponet", "doJump exp=" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(219481);
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(219479);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).paddingLeft, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).paddingTop, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).paddingRight, (int)((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o)this.zUP).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(219479);
  }
  
  protected final int getLayout()
  {
    return 2131495497;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */