package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.sdk.f.e;
import java.util.concurrent.CountDownLatch;

public final class ab
  extends a
{
  private static final int oIh = Color.parseColor("#26eae9e2");
  private CountDownLatch countDownLatch;
  private Bitmap maskBitmap;
  private RadarChart oIi;
  private Bitmap oIj;
  
  public ab(Context paramContext, y paramy, ViewGroup paramViewGroup)
  {
    super(paramContext, paramy, paramViewGroup);
  }
  
  private static void a(Spannable paramSpannable, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    int i = 0;
    while (i < 2)
    {
      paramSpannable.setSpan(paramVarArgs[i], paramInt1, paramInt2, 18);
      i += 1;
    }
  }
  
  public final View bFf()
  {
    this.oIi = ((RadarChart)this.contentView.findViewById(i.f.chart));
    return this.contentView;
  }
  
  protected final void bFj()
  {
    this.countDownLatch = new CountDownLatch(2);
    e.b(new ab.1(this), "AdlandingRadarComp").start();
    y localy = (y)bFe();
    if (localy != null)
    {
      h.a(localy.oDM, localy.oDh, new ab.2(this));
      h.a(localy.oDS, localy.oDh, new ab.3(this));
      return;
    }
    Log.wtf("AdlandingRadarChartComp", "null info");
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_comp_radarchart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab
 * JD-Core Version:    0.7.0.1
 */