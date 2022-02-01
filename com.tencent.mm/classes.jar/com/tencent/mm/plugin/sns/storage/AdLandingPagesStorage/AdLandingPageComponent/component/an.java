package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ao;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.z;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.CountDownLatch;

public final class an
  extends m
{
  private static final int Ehc;
  private RadarChart Ehd;
  private Bitmap Ehe;
  private Bitmap Ehf;
  private CountDownLatch rDn;
  
  static
  {
    AppMethodBeat.i(96818);
    Ehc = Color.parseColor("#26eae9e2");
    AppMethodBeat.o(96818);
  }
  
  public an(Context paramContext, ao paramao, ViewGroup paramViewGroup)
  {
    super(paramContext, paramao, paramViewGroup);
    AppMethodBeat.i(96811);
    this.rDn = new CountDownLatch(2);
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
  
  protected final void eWT()
  {
    AppMethodBeat.i(96814);
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
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
          an.a(an.this).await();
          label15:
          if ((an.b(an.this) != null) && (an.c(an.this) != null)) {
            an.this.contentView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96805);
                an.a(an.this, an.b(an.this), an.c(an.this));
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
    ao localao = (ao)fdr();
    if (localao != null)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localao.Eah, localao.DZj, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(96808);
          try
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
            an.a(an.this, paramAnonymousString);
            an.a(an.this).countDown();
            AppMethodBeat.o(96808);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdlandingRadarChartComp", "%s" + Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(96808);
          }
        }
        
        public final void eWN() {}
        
        public final void eWO()
        {
          AppMethodBeat.i(96807);
          an.a(an.this, null);
          an.a(an.this).countDown();
          AppMethodBeat.o(96807);
        }
      });
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localao.Ean, localao.DZj, new f.a()
      {
        public final void aNH(String paramAnonymousString)
        {
          AppMethodBeat.i(96810);
          try
          {
            an.b(an.this, BitmapUtil.decodeFile(paramAnonymousString));
            an.a(an.this).countDown();
            AppMethodBeat.o(96810);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdlandingRadarChartComp", "%s" + Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(96810);
          }
        }
        
        public final void eWN() {}
        
        public final void eWO()
        {
          AppMethodBeat.i(96809);
          an.b(an.this, null);
          an.a(an.this).countDown();
          AppMethodBeat.o(96809);
        }
      });
      eWX();
      AppMethodBeat.o(96814);
      return;
    }
    android.util.Log.wtf("AdlandingRadarChartComp", "null info");
    AppMethodBeat.o(96814);
  }
  
  protected final void eWX()
  {
    AppMethodBeat.i(96813);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.EcX.paddingLeft, (int)this.EcX.paddingTop, (int)this.EcX.paddingRight, (int)this.EcX.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96813);
  }
  
  public final void eXd()
  {
    AppMethodBeat.i(96815);
    super.eXd();
    this.rDn.countDown();
    this.rDn.countDown();
    AppMethodBeat.o(96815);
  }
  
  public final void eXe()
  {
    AppMethodBeat.i(96812);
    this.Ehd = ((RadarChart)this.contentView.findViewById(2131298290));
    AppMethodBeat.o(96812);
  }
  
  protected final int getLayout()
  {
    return 2131496376;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.an
 * JD-Core Version:    0.7.0.1
 */