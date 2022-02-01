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
import com.tencent.mm.plugin.sns.b.a;
import com.tencent.mm.plugin.sns.b.e;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.data.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.ai;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class p
  extends n
{
  private TextView QPh;
  private int QPi;
  public int QPj;
  AnimatorSet cis;
  private ImageView fN;
  
  public p(Context paramContext, q paramq, ViewGroup paramViewGroup)
  {
    super(paramContext, paramq, paramViewGroup);
    AppMethodBeat.i(307161);
    this.QPi = 0;
    paramq.QKJ = 2.147484E+009F;
    this.QPj = a.fromDPToPix(paramContext, 130);
    AppMethodBeat.o(307161);
  }
  
  public final void Gs()
  {
    AppMethodBeat.i(307169);
    this.fN = ((ImageView)this.contentView.findViewById(b.f.swip_icon));
    this.QPh = ((TextView)this.contentView.findViewById(b.f.swip_txt));
    Object localObject = this.fN;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -a.fromDPToPix(this.context, 12) });
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 0.8F });
    localObjectAnimator2.setDuration(1000L);
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.8F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(500L);
    this.cis = new AnimatorSet();
    this.cis.play(localObjectAnimator1).with(localObjectAnimator2);
    this.cis.play((Animator)localObject).after(localObjectAnimator1);
    this.cis.addListener(new p.2(this));
    this.cis.start();
    if (((q)this.QOV).QKK)
    {
      this.QPh.setTextColor(Color.parseColor("#CC000000"));
      this.fN.setImageResource(b.e.ad_landing_pages_bottom_swipe_black_icon);
    }
    for (;;)
    {
      this.contentView.findViewById(b.f.click_area).setOnClickListener(new p.1(this));
      AppMethodBeat.o(307169);
      return;
      this.QPh.setTextColor(Color.parseColor("#CCFFFFFF"));
      this.fN.setImageResource(b.e.ad_landing_pages_bottom_swipe_white_icon);
    }
  }
  
  public final boolean bP(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(307193);
    if (!super.bP(paramJSONObject))
    {
      Log.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData super failed");
      AppMethodBeat.o(307193);
      return false;
    }
    try
    {
      paramJSONObject.put("jumpCount", this.QPi);
      Log.i("AdLandingPageBottomSwipeComponet", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(307193);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      Log.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(307193);
    }
    return false;
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_pages_item_bottom_swipe;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(307178);
    if ((this.QPh == null) || (this.fN == null) || ((q)this.QOV == null))
    {
      AppMethodBeat.o(307178);
      return;
    }
    if (!TextUtils.isEmpty(((q)this.QOV).QJM)) {
      this.QPh.setText(((q)this.QOV).QJM);
    }
    AppMethodBeat.o(307178);
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(307174);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((q)this.QOV).paddingLeft, (int)((q)this.QOV).paddingTop, (int)((q)this.QOV).paddingRight, (int)((q)this.QOV).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(307174);
  }
  
  public final void has()
  {
    AppMethodBeat.i(307189);
    super.has();
    this.cis.removeAllListeners();
    AppMethodBeat.o(307189);
  }
  
  public final void hjq()
  {
    AppMethodBeat.i(307184);
    this.QPi += 1;
    if ((this.context instanceof SnsAdNativeLandingPagesUI)) {
      try
      {
        int i = ((q)this.QOV).QJN;
        Log.i("AdLandingPageBottomSwipeComponet", "doJump, swipCount=" + this.QPi + ", actionType=" + i);
        if (i == 0)
        {
          SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)this.context;
          long l = ai.aXe(localSnsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
          i = localSnsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 0);
          String str = ((q)this.QOV).jumpUrl;
          m.a(this.context, str, hjn(), i, l, ((q)this.QOV).QKG);
          localSnsAdNativeLandingPagesUI.overridePendingTransition(b.a.push_up_in, b.a.anim_not_change);
        }
        AppMethodBeat.o(307184);
        return;
      }
      finally
      {
        Log.e("AdLandingPageBottomSwipeComponet", "doJump exp=" + localObject.toString());
      }
    }
    AppMethodBeat.o(307184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p
 * JD-Core Version:    0.7.0.1
 */