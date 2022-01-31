package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ad;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.sdk.g.d;
import java.util.concurrent.CountDownLatch;

public final class ac
  extends h
{
  private static final int ryc;
  private CountDownLatch countDownLatch;
  private Bitmap maskBitmap;
  private RadarChart ryd;
  private Bitmap rye;
  
  static
  {
    AppMethodBeat.i(37358);
    ryc = Color.parseColor("#26eae9e2");
    AppMethodBeat.o(37358);
  }
  
  public ac(Context paramContext, ad paramad, ViewGroup paramViewGroup)
  {
    super(paramContext, paramad, paramViewGroup);
    AppMethodBeat.i(37351);
    this.countDownLatch = new CountDownLatch(2);
    AppMethodBeat.o(37351);
  }
  
  private static void a(Spannable paramSpannable, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(37356);
    int i = 0;
    while (i < 2)
    {
      paramSpannable.setSpan(paramVarArgs[i], paramInt1, paramInt2, 18);
      i += 1;
    }
    AppMethodBeat.o(37356);
  }
  
  public final void cqK()
  {
    AppMethodBeat.i(37352);
    this.ryd = ((RadarChart)this.contentView.findViewById(2131824191));
    AppMethodBeat.o(37352);
  }
  
  protected final void cqP()
  {
    AppMethodBeat.i(37354);
    d.h(new ac.1(this), "AdlandingRadarComp").start();
    ad localad = (ad)crb();
    if (localad != null)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localad.rtn, localad.rsJ, new ac.2(this));
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localad.rtt, localad.rsJ, new ac.3(this));
      cqQ();
      AppMethodBeat.o(37354);
      return;
    }
    Log.wtf("AdlandingRadarChartComp", "null info");
    AppMethodBeat.o(37354);
  }
  
  protected final void cqQ()
  {
    AppMethodBeat.i(37353);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.rve.paddingLeft, (int)this.rve.paddingTop, (int)this.rve.paddingRight, (int)this.rve.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(37353);
  }
  
  public final void cqz()
  {
    AppMethodBeat.i(37355);
    super.cqz();
    this.countDownLatch.countDown();
    this.countDownLatch.countDown();
    AppMethodBeat.o(37355);
  }
  
  protected final int getLayout()
  {
    return 2130970775;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ac
 * JD-Core Version:    0.7.0.1
 */