package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class m
  extends k
{
  private ImageView Uz;
  AnimatorSet uc;
  private TextView xao;
  private int xap;
  public int xaq;
  
  public m(Context paramContext, o paramo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramo, paramViewGroup);
    AppMethodBeat.i(187400);
    this.xap = 0;
    paramo.wWH = 2.147484E+009F;
    this.xaq = a.fromDPToPix(paramContext, 130);
    AppMethodBeat.o(187400);
  }
  
  public final boolean aG(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(187406);
    if (!super.aG(paramJSONObject))
    {
      ad.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData super failed");
      AppMethodBeat.o(187406);
      return false;
    }
    try
    {
      paramJSONObject.put("jumpCount", this.xap);
      ad.i("AdLandingPageBottomSwipeComponet", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(187406);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ad.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(187406);
    }
    return false;
  }
  
  protected final void dvN()
  {
    AppMethodBeat.i(187403);
    if ((this.xao == null) || (this.Uz == null) || ((o)this.xab == null))
    {
      AppMethodBeat.o(187403);
      return;
    }
    if (!TextUtils.isEmpty(((o)this.xab).wVU)) {
      this.xao.setText(((o)this.xab).wVU);
    }
    AppMethodBeat.o(187403);
  }
  
  protected final void dvT()
  {
    AppMethodBeat.i(187402);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((o)this.xab).paddingLeft, (int)((o)this.xab).paddingTop, (int)((o)this.xab).paddingRight, (int)((o)this.xab).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(187402);
  }
  
  public final void dvx()
  {
    AppMethodBeat.i(187401);
    this.Uz = ((ImageView)this.contentView.findViewById(2131305561));
    this.xao = ((TextView)this.contentView.findViewById(2131305562));
    Object localObject = this.Uz;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -a.fromDPToPix(this.context, 12) });
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 0.8F });
    localObjectAnimator2.setDuration(1000L);
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.8F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(500L);
    this.uc = new AnimatorSet();
    this.uc.play(localObjectAnimator1).with(localObjectAnimator2);
    this.uc.play((Animator)localObject).after(localObjectAnimator1);
    this.uc.addListener(new m.2(this));
    this.uc.start();
    if (((o)this.xab).wWI)
    {
      this.xao.setTextColor(Color.parseColor("#CC000000"));
      this.Uz.setImageResource(2131230872);
    }
    for (;;)
    {
      this.contentView.findViewById(2131298353).setOnClickListener(new m.1(this));
      AppMethodBeat.o(187401);
      return;
      this.xao.setTextColor(Color.parseColor("#CCFFFFFF"));
      this.Uz.setImageResource(2131230873);
    }
  }
  
  public final void dvy()
  {
    AppMethodBeat.i(187405);
    super.dvy();
    this.uc.removeAllListeners();
    AppMethodBeat.o(187405);
  }
  
  public final void dwl()
  {
    AppMethodBeat.i(187404);
    this.xap += 1;
    if ((this.context instanceof SnsAdNativeLandingPagesUI)) {
      try
      {
        int i = ((o)this.xab).wVV;
        ad.i("AdLandingPageBottomSwipeComponet", "doJump, swipCount=" + this.xap + ", actionType=" + i);
        if (i == 0)
        {
          SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)this.context;
          long l = x.anz(localSnsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
          i = localSnsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 0);
          String str = ((o)this.xab).jumpUrl;
          j.a(this.context, str, dwi(), i, l, ((o)this.xab).wWE);
          localSnsAdNativeLandingPagesUI.overridePendingTransition(2130772108, 2130771986);
        }
        AppMethodBeat.o(187404);
        return;
      }
      catch (Throwable localThrowable)
      {
        ad.e("AdLandingPageBottomSwipeComponet", "doJump exp=" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(187404);
  }
  
  protected final int getLayout()
  {
    return 2131495497;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m
 * JD-Core Version:    0.7.0.1
 */