package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.aa;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ar;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.k;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import java.util.concurrent.CountDownLatch;

public final class ap
  extends n
{
  private static final int QSJ;
  private RadarChart QSK;
  private Bitmap QSL;
  private Bitmap QSM;
  private CountDownLatch yuW;
  
  static
  {
    AppMethodBeat.i(96818);
    QSJ = Color.parseColor("#26eae9e2");
    AppMethodBeat.o(96818);
  }
  
  public ap(Context paramContext, ar paramar, ViewGroup paramViewGroup)
  {
    super(paramContext, paramar, paramViewGroup);
    AppMethodBeat.i(96811);
    this.yuW = new CountDownLatch(2);
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
  
  public final void Gs()
  {
    AppMethodBeat.i(96812);
    this.QSK = ((RadarChart)this.contentView.findViewById(b.f.chart));
    AppMethodBeat.o(96812);
  }
  
  protected final int getLayout()
  {
    return b.g.sns_ad_native_landing_comp_radarchart;
  }
  
  protected final void had()
  {
    AppMethodBeat.i(96814);
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
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
          ap.a(ap.this).await();
          label15:
          if ((ap.b(ap.this) != null) && (ap.c(ap.this) != null)) {
            ap.this.contentView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96805);
                ap.a(ap.this, ap.b(ap.this), ap.c(ap.this));
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
    ar localar = (ar)hjm();
    if (localar != null)
    {
      k.b("adId", localar.QLJ, new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(96808);
          try
          {
            paramAnonymousString = BitmapUtil.decodeFile(paramAnonymousString);
            ap.a(ap.this, paramAnonymousString);
            ap.a(ap.this).countDown();
            AppMethodBeat.o(96808);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdlandingRadarChartComp", "%s" + Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(96808);
          }
        }
        
        public final void gZM() {}
        
        public final void gZN()
        {
          AppMethodBeat.i(96807);
          ap.a(ap.this, null);
          ap.a(ap.this).countDown();
          AppMethodBeat.o(96807);
        }
      });
      k.b("adId", localar.QLP, new g.a()
      {
        public final void aWn(String paramAnonymousString)
        {
          AppMethodBeat.i(96810);
          try
          {
            ap.b(ap.this, BitmapUtil.decodeFile(paramAnonymousString));
            ap.a(ap.this).countDown();
            AppMethodBeat.o(96810);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            com.tencent.mm.sdk.platformtools.Log.e("AdlandingRadarChartComp", "%s" + Util.stackTraceToString(paramAnonymousString));
            AppMethodBeat.o(96810);
          }
        }
        
        public final void gZM() {}
        
        public final void gZN()
        {
          AppMethodBeat.i(96809);
          ap.b(ap.this, null);
          ap.a(ap.this).countDown();
          AppMethodBeat.o(96809);
        }
      });
      hal();
      AppMethodBeat.o(96814);
      return;
    }
    android.util.Log.wtf("AdlandingRadarChartComp", "null info");
    AppMethodBeat.o(96814);
  }
  
  protected final void hal()
  {
    AppMethodBeat.i(96813);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.QOV.paddingLeft, (int)this.QOV.paddingTop, (int)this.QOV.paddingRight, (int)this.QOV.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96813);
  }
  
  public final void has()
  {
    AppMethodBeat.i(96815);
    super.has();
    this.yuW.countDown();
    this.yuW.countDown();
    AppMethodBeat.o(96815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ap
 * JD-Core Version:    0.7.0.1
 */