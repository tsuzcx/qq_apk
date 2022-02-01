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
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class n
  extends l
{
  private ImageView Xk;
  AnimatorSet wV;
  private TextView zDX;
  private int zDY;
  public int zDZ;
  
  public n(Context paramContext, o paramo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramo, paramViewGroup);
    AppMethodBeat.i(197971);
    this.zDY = 0;
    paramo.zAj = 2.147484E+009F;
    this.zDZ = com.tencent.mm.cc.a.fromDPToPix(paramContext, 130);
    AppMethodBeat.o(197971);
  }
  
  public final boolean aQ(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(197977);
    if (!super.aQ(paramJSONObject))
    {
      ad.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData super failed");
      AppMethodBeat.o(197977);
      return false;
    }
    try
    {
      paramJSONObject.put("jumpCount", this.zDY);
      ad.i("AdLandingPageBottomSwipeComponet", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(197977);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(197977);
    }
    return false;
  }
  
  public final void dRk()
  {
    AppMethodBeat.i(197972);
    this.Xk = ((ImageView)this.contentView.findViewById(2131305561));
    this.zDX = ((TextView)this.contentView.findViewById(2131305562));
    Object localObject = this.Xk;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -com.tencent.mm.cc.a.fromDPToPix(this.context, 12) });
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
        AppMethodBeat.i(197969);
        ad.d("AdLandingPageBottomSwipeComponet", "onAnimationCancel");
        AppMethodBeat.o(197969);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(197968);
        n.this.wV.start();
        ad.d("AdLandingPageBottomSwipeComponet", "onAnimationEnd");
        AppMethodBeat.o(197968);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(197970);
        ad.d("AdLandingPageBottomSwipeComponet", "onAnimationRepeat");
        AppMethodBeat.o(197970);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(197967);
        ad.d("AdLandingPageBottomSwipeComponet", "onAnimationStart");
        AppMethodBeat.o(197967);
      }
    });
    this.wV.start();
    if (((o)this.zDK).zAk)
    {
      this.zDX.setTextColor(Color.parseColor("#CC000000"));
      this.Xk.setImageResource(2131230872);
    }
    for (;;)
    {
      this.contentView.findViewById(2131298353).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(197966);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          n.this.dXc();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(197966);
        }
      });
      AppMethodBeat.o(197972);
      return;
      this.zDX.setTextColor(Color.parseColor("#CCFFFFFF"));
      this.Xk.setImageResource(2131230873);
    }
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(197974);
    if ((this.zDX == null) || (this.Xk == null) || ((o)this.zDK == null))
    {
      AppMethodBeat.o(197974);
      return;
    }
    if (!TextUtils.isEmpty(((o)this.zDK).zyQ)) {
      this.zDX.setText(((o)this.zDK).zyQ);
    }
    AppMethodBeat.o(197974);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(197976);
    super.dRo();
    this.wV.removeAllListeners();
    AppMethodBeat.o(197976);
  }
  
  protected final void dWF()
  {
    AppMethodBeat.i(197973);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((o)this.zDK).paddingLeft, (int)((o)this.zDK).paddingTop, (int)((o)this.zDK).paddingRight, (int)((o)this.zDK).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(197973);
  }
  
  public final void dXc()
  {
    AppMethodBeat.i(197975);
    this.zDY += 1;
    if ((this.context instanceof SnsAdNativeLandingPagesUI)) {
      try
      {
        int i = ((o)this.zDK).zyR;
        ad.i("AdLandingPageBottomSwipeComponet", "doJump, swipCount=" + this.zDY + ", actionType=" + i);
        if (i == 0)
        {
          SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)this.context;
          long l = x.axN(localSnsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
          i = localSnsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 0);
          String str = ((o)this.zDK).jumpUrl;
          j.a(this.context, str, dWZ(), i, l, ((o)this.zDK).zAg);
          localSnsAdNativeLandingPagesUI.overridePendingTransition(2130772108, 2130771986);
        }
        AppMethodBeat.o(197975);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.e("AdLandingPageBottomSwipeComponet", "doJump exp=" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(197975);
  }
  
  protected final int getLayout()
  {
    return 2131495497;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n
 * JD-Core Version:    0.7.0.1
 */