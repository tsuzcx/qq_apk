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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.CountDownLatch;

public final class al
  extends m
{
  private static final int zYL;
  private CountDownLatch qmr;
  private RadarChart zYM;
  private Bitmap zYN;
  private Bitmap zYO;
  
  static
  {
    AppMethodBeat.i(96818);
    zYL = Color.parseColor("#26eae9e2");
    AppMethodBeat.o(96818);
  }
  
  public al(Context paramContext, am paramam, ViewGroup paramViewGroup)
  {
    super(paramContext, paramam, paramViewGroup);
    AppMethodBeat.i(96811);
    this.qmr = new CountDownLatch(2);
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
  
  public final void dUI()
  {
    AppMethodBeat.i(96812);
    this.zYM = ((RadarChart)this.contentView.findViewById(2131297955));
    AppMethodBeat.o(96812);
  }
  
  protected final void dUJ()
  {
    AppMethodBeat.i(96814);
    com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
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
          al.a(al.this).await();
          label15:
          if ((al.b(al.this) != null) && (al.c(al.this) != null)) {
            al.this.contentView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96805);
                al.a(al.this, al.b(al.this), al.c(al.this));
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
    am localam = (am)eaC();
    if (localam != null)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localam.zRX, localam.zRh, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(96808);
          try
          {
            paramAnonymousString = com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString);
            al.a(al.this, paramAnonymousString);
            al.a(al.this).countDown();
            AppMethodBeat.o(96808);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ae.e("AdlandingRadarChartComp", "%s" + bu.o(paramAnonymousString));
            AppMethodBeat.o(96808);
          }
        }
        
        public final void dVu() {}
        
        public final void dVv()
        {
          AppMethodBeat.i(96807);
          al.a(al.this, null);
          al.a(al.this).countDown();
          AppMethodBeat.o(96807);
        }
      });
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localam.zSd, localam.zRh, new f.a()
      {
        public final void ayY(String paramAnonymousString)
        {
          AppMethodBeat.i(96810);
          try
          {
            al.b(al.this, com.tencent.mm.sdk.platformtools.h.decodeFile(paramAnonymousString));
            al.a(al.this).countDown();
            AppMethodBeat.o(96810);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ae.e("AdlandingRadarChartComp", "%s" + bu.o(paramAnonymousString));
            AppMethodBeat.o(96810);
          }
        }
        
        public final void dVu() {}
        
        public final void dVv()
        {
          AppMethodBeat.i(96809);
          al.b(al.this, null);
          al.a(al.this).countDown();
          AppMethodBeat.o(96809);
        }
      });
      eah();
      AppMethodBeat.o(96814);
      return;
    }
    Log.wtf("AdlandingRadarChartComp", "null info");
    AppMethodBeat.o(96814);
  }
  
  public final void dUM()
  {
    AppMethodBeat.i(96815);
    super.dUM();
    this.qmr.countDown();
    this.qmr.countDown();
    AppMethodBeat.o(96815);
  }
  
  protected final void eah()
  {
    AppMethodBeat.i(96813);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zUP.paddingLeft, (int)this.zUP.paddingTop, (int)this.zUP.paddingRight, (int)this.zUP.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96813);
  }
  
  protected final int getLayout()
  {
    return 2131495493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.al
 * JD-Core Version:    0.7.0.1
 */