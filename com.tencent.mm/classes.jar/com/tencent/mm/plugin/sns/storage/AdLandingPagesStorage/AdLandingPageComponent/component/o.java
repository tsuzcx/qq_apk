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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class o
  extends m
{
  private TextView Edj;
  private int Edk;
  public int Edl;
  private ImageView Xx;
  AnimatorSet xc;
  
  public o(Context paramContext, p paramp, ViewGroup paramViewGroup)
  {
    super(paramContext, paramp, paramViewGroup);
    AppMethodBeat.i(202931);
    this.Edk = 0;
    paramp.DZl = 2.147484E+009F;
    this.Edl = com.tencent.mm.cb.a.fromDPToPix(paramContext, 130);
    AppMethodBeat.o(202931);
  }
  
  public final boolean bp(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(202937);
    if (!super.bp(paramJSONObject))
    {
      Log.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData super failed");
      AppMethodBeat.o(202937);
      return false;
    }
    try
    {
      paramJSONObject.put("jumpCount", this.Edk);
      Log.i("AdLandingPageBottomSwipeComponet", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(202937);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(202937);
    }
    return false;
  }
  
  protected final void eWT()
  {
    AppMethodBeat.i(202934);
    if ((this.Edj == null) || (this.Xx == null) || ((p)this.EcX == null))
    {
      AppMethodBeat.o(202934);
      return;
    }
    if (!TextUtils.isEmpty(((p)this.EcX).DYo)) {
      this.Edj.setText(((p)this.EcX).DYo);
    }
    AppMethodBeat.o(202934);
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(202933);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((p)this.EcX).paddingLeft, (int)((p)this.EcX).paddingTop, (int)((p)this.EcX).paddingRight, (int)((p)this.EcX).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(202933);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(202936);
    super.eXd();
    this.xc.removeAllListeners();
    AppMethodBeat.o(202936);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(202932);
    this.Xx = ((ImageView)this.contentView.findViewById(2131308784));
    this.Edj = ((TextView)this.contentView.findViewById(2131308785));
    Object localObject = this.Xx;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -com.tencent.mm.cb.a.fromDPToPix(this.context, 12) });
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 0.8F });
    localObjectAnimator2.setDuration(1000L);
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.8F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(500L);
    this.xc = new AnimatorSet();
    this.xc.play(localObjectAnimator1).with(localObjectAnimator2);
    this.xc.play((Animator)localObject).after(localObjectAnimator1);
    this.xc.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(202929);
        Log.d("AdLandingPageBottomSwipeComponet", "onAnimationCancel");
        AppMethodBeat.o(202929);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(202928);
        o.this.xc.start();
        Log.d("AdLandingPageBottomSwipeComponet", "onAnimationEnd");
        AppMethodBeat.o(202928);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(202930);
        Log.d("AdLandingPageBottomSwipeComponet", "onAnimationRepeat");
        AppMethodBeat.o(202930);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(202927);
        Log.d("AdLandingPageBottomSwipeComponet", "onAnimationStart");
        AppMethodBeat.o(202927);
      }
    });
    this.xc.start();
    if (((p)this.EcX).DZm)
    {
      this.Edj.setTextColor(Color.parseColor("#CC000000"));
      this.Xx.setImageResource(2131230887);
    }
    for (;;)
    {
      this.contentView.findViewById(2131298752).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(202926);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          o.this.fdv();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/component/AdLandingPageBottomSwipeComponet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(202926);
        }
      });
      AppMethodBeat.o(202932);
      return;
      this.Edj.setTextColor(Color.parseColor("#CCFFFFFF"));
      this.Xx.setImageResource(2131230888);
    }
  }
  
  public final void fdv()
  {
    AppMethodBeat.i(202935);
    this.Edk += 1;
    if ((this.context instanceof SnsAdNativeLandingPagesUI)) {
      try
      {
        int i = ((p)this.EcX).DYp;
        Log.i("AdLandingPageBottomSwipeComponet", "doJump, swipCount=" + this.Edk + ", actionType=" + i);
        if (i == 0)
        {
          SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)this.context;
          long l = y.aOa(localSnsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
          i = localSnsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 0);
          String str = ((p)this.EcX).jumpUrl;
          k.a(this.context, str, fds(), i, l, ((p)this.EcX).DZi);
          localSnsAdNativeLandingPagesUI.overridePendingTransition(2130772132, 2130771986);
        }
        AppMethodBeat.o(202935);
        return;
      }
      catch (Throwable localThrowable)
      {
        Log.e("AdLandingPageBottomSwipeComponet", "doJump exp=" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(202935);
  }
  
  protected final int getLayout()
  {
    return 2131496380;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o
 * JD-Core Version:    0.7.0.1
 */