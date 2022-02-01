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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.x;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class m
  extends k
{
  private ImageView Vv;
  AnimatorSet vc;
  private TextView ynd;
  private int yne;
  public int ynf;
  
  public m(Context paramContext, o paramo, ViewGroup paramViewGroup)
  {
    super(paramContext, paramo, paramViewGroup);
    AppMethodBeat.i(200200);
    this.yne = 0;
    paramo.yjv = 2.147484E+009F;
    this.ynf = a.fromDPToPix(paramContext, 130);
    AppMethodBeat.o(200200);
  }
  
  public final boolean aH(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(200206);
    if (!super.aH(paramJSONObject))
    {
      ac.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData super failed");
      AppMethodBeat.o(200206);
      return false;
    }
    try
    {
      paramJSONObject.put("jumpCount", this.yne);
      ac.i("AdLandingPageBottomSwipeComponet", "setComponentKVReportData json=" + paramJSONObject.toString());
      AppMethodBeat.o(200206);
      return true;
    }
    catch (Exception paramJSONObject)
    {
      ac.e("AdLandingPageBottomSwipeComponet", "setComponentKVReportData exp=" + paramJSONObject.toString());
      AppMethodBeat.o(200206);
    }
    return false;
  }
  
  public final void dJW()
  {
    AppMethodBeat.i(200201);
    this.Vv = ((ImageView)this.contentView.findViewById(2131305561));
    this.ynd = ((TextView)this.contentView.findViewById(2131305562));
    Object localObject = this.Vv;
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "translationY", new float[] { 0.0F, -a.fromDPToPix(this.context, 12) });
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator1.setInterpolator(new AccelerateDecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 0.8F });
    localObjectAnimator2.setDuration(1000L);
    localObject = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.8F, 0.0F });
    ((ObjectAnimator)localObject).setDuration(500L);
    this.vc = new AnimatorSet();
    this.vc.play(localObjectAnimator1).with(localObjectAnimator2);
    this.vc.play((Animator)localObject).after(localObjectAnimator1);
    this.vc.addListener(new m.2(this));
    this.vc.start();
    if (((o)this.ymQ).yjw)
    {
      this.ynd.setTextColor(Color.parseColor("#CC000000"));
      this.Vv.setImageResource(2131230872);
    }
    for (;;)
    {
      this.contentView.findViewById(2131298353).setOnClickListener(new m.1(this));
      AppMethodBeat.o(200201);
      return;
      this.ynd.setTextColor(Color.parseColor("#CCFFFFFF"));
      this.Vv.setImageResource(2131230873);
    }
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(200205);
    super.dJX();
    this.vc.removeAllListeners();
    AppMethodBeat.o(200205);
  }
  
  public final void dKK()
  {
    AppMethodBeat.i(200204);
    this.yne += 1;
    if ((this.context instanceof SnsAdNativeLandingPagesUI)) {
      try
      {
        int i = ((o)this.ymQ).yiJ;
        ac.i("AdLandingPageBottomSwipeComponet", "doJump, swipCount=" + this.yne + ", actionType=" + i);
        if (i == 0)
        {
          SnsAdNativeLandingPagesUI localSnsAdNativeLandingPagesUI = (SnsAdNativeLandingPagesUI)this.context;
          long l = x.asL(localSnsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id"));
          i = localSnsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 0);
          String str = ((o)this.ymQ).jumpUrl;
          j.a(this.context, str, dKH(), i, l, ((o)this.ymQ).yjs);
          localSnsAdNativeLandingPagesUI.overridePendingTransition(2130772108, 2130771986);
        }
        AppMethodBeat.o(200204);
        return;
      }
      catch (Throwable localThrowable)
      {
        ac.e("AdLandingPageBottomSwipeComponet", "doJump exp=" + localThrowable.toString());
      }
    }
    AppMethodBeat.o(200204);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(200203);
    if ((this.ynd == null) || (this.Vv == null) || ((o)this.ymQ == null))
    {
      AppMethodBeat.o(200203);
      return;
    }
    if (!TextUtils.isEmpty(((o)this.ymQ).yiI)) {
      this.ynd.setText(((o)this.ymQ).yiI);
    }
    AppMethodBeat.o(200203);
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(200202);
    Object localObject = this.contentView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      ((ViewGroup.MarginLayoutParams)localObject).setMargins((int)((o)this.ymQ).paddingLeft, (int)((o)this.ymQ).paddingTop, (int)((o)this.ymQ).paddingRight, (int)((o)this.ymQ).paddingBottom);
      this.contentView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(200202);
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