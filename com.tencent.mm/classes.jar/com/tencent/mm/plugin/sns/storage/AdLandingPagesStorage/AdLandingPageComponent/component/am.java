package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ap;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.CountDownLatch;

public final class am
  extends m
{
  private static final int Kuj;
  private RadarChart Kuk;
  private Bitmap Kul;
  private Bitmap Kum;
  private CountDownLatch viX;
  
  static
  {
    AppMethodBeat.i(96818);
    Kuj = Color.parseColor("#26eae9e2");
    AppMethodBeat.o(96818);
  }
  
  public am(Context paramContext, ap paramap, ViewGroup paramViewGroup)
  {
    super(paramContext, paramap, paramViewGroup);
    AppMethodBeat.i(96811);
    this.viX = new CountDownLatch(2);
    AppMethodBeat.o(96811);
  }
  
  private static void a(Spannable paramSpannable, int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    AppMethodBeat.i(96816);
    int i = 0;
    while (i < 2)
    {
      paramSpannable.setSpan(paramVarArgs[i], paramInt1, paramInt2, 18);
      i += 1;
    }
    AppMethodBeat.o(96816);
  }
  
  protected final void fKe()
  {
    AppMethodBeat.i(96814);
    com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "AdlandingRadarComp";
      }
      
      public final void run()
      {
        AppMethodBeat.i(96806);
        try
        {
          am.a(am.this).await();
          label15:
          if ((am.b(am.this) != null) && (am.c(am.this) != null)) {
            am.this.contentView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96805);
                am.a(am.this, am.b(am.this), am.c(am.this));
                AppMethodBeat.o(96805);
              }
            });
          }
          AppMethodBeat.o(96806);
          return;
        }
        catch (InterruptedException localInterruptedException)
        {
          break label15;
        }
      }
    });
    ap localap = (ap)fRo();
    if (localap != null)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", localap.KnC, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(96808);
          try
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
            am.a(am.this, paramAnonymousString);
            am.a(am.this).countDown();
            AppMethodBeat.o(96808);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdlandingRadarChartComp", "%s" + Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(96808);
          }
        }
        
        public final void fJU() {}
        
        public final void fJV()
        {
          AppMethodBeat.i(96807);
          am.a(am.this, null);
          am.a(am.this).countDown();
          AppMethodBeat.o(96807);
        }
      });
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a("adId", localap.KnI, new f.a()
      {
        public final void aYs(String paramAnonymousString)
        {
          AppMethodBeat.i(96810);
          try
          {
            am.b(am.this, BitmapUtil.decodeFile(paramAnonymousString));
            am.a(am.this).countDown();
            AppMethodBeat.o(96810);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdlandingRadarChartComp", "%s" + Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(96810);
          }
        }
        
        public final void fJU() {}
        
        public final void fJV()
        {
          AppMethodBeat.i(96809);
          am.b(am.this, null);
          am.a(am.this).countDown();
          AppMethodBeat.o(96809);
        }
      });
      fKi();
      AppMethodBeat.o(96814);
      return;
    }
    android.util.Log.wtf("AdlandingRadarChartComp", "null info");
    AppMethodBeat.o(96814);
  }
  
  protected final void fKi()
  {
    AppMethodBeat.i(96813);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.KqB.paddingLeft, (int)this.KqB.paddingTop, (int)this.KqB.paddingRight, (int)this.KqB.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96813);
  }
  
  public final void fKo()
  {
    AppMethodBeat.i(96815);
    super.fKo();
    this.viX.countDown();
    this.viX.countDown();
    AppMethodBeat.o(96815);
  }
  
  public final void fKp()
  {
    AppMethodBeat.i(96812);
    this.Kuk = ((RadarChart)this.contentView.findViewById(i.f.chart));
    AppMethodBeat.o(96812);
  }
  
  protected final int getLayout()
  {
    return i.g.sns_ad_native_landing_comp_radarchart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.am
 * JD-Core Version:    0.7.0.1
 */