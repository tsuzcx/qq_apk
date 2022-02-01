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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.al;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.g;
import java.util.concurrent.CountDownLatch;

public final class ak
  extends l
{
  private static final int zHE;
  private CountDownLatch qfM;
  private RadarChart zHF;
  private Bitmap zHG;
  private Bitmap zHH;
  
  static
  {
    AppMethodBeat.i(96818);
    zHE = Color.parseColor("#26eae9e2");
    AppMethodBeat.o(96818);
  }
  
  public ak(Context paramContext, al paramal, ViewGroup paramViewGroup)
  {
    super(paramContext, paramal, paramViewGroup);
    AppMethodBeat.i(96811);
    this.qfM = new CountDownLatch(2);
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
  
  public final void dRk()
  {
    AppMethodBeat.i(96812);
    this.zHF = ((RadarChart)this.contentView.findViewById(2131297955));
    AppMethodBeat.o(96812);
  }
  
  protected final void dRl()
  {
    AppMethodBeat.i(96814);
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
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
          ak.a(ak.this).await();
          label15:
          if ((ak.b(ak.this) != null) && (ak.c(ak.this) != null)) {
            ak.this.contentView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96805);
                ak.a(ak.this, ak.b(ak.this), ak.c(ak.this));
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
    al localal = (al)dWY();
    if (localal != null)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localal.zAX, localal.zAh, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(96808);
          try
          {
            paramAnonymousString = g.decodeFile(paramAnonymousString);
            ak.a(ak.this, paramAnonymousString);
            ak.a(ak.this).countDown();
            AppMethodBeat.o(96808);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.e("AdlandingRadarChartComp", "%s" + bt.n(paramAnonymousString));
            AppMethodBeat.o(96808);
          }
        }
        
        public final void dRW() {}
        
        public final void dRX()
        {
          AppMethodBeat.i(96807);
          ak.a(ak.this, null);
          ak.a(ak.this).countDown();
          AppMethodBeat.o(96807);
        }
      });
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localal.zBd, localal.zAh, new f.a()
      {
        public final void axG(String paramAnonymousString)
        {
          AppMethodBeat.i(96810);
          try
          {
            ak.b(ak.this, g.decodeFile(paramAnonymousString));
            ak.a(ak.this).countDown();
            AppMethodBeat.o(96810);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ad.e("AdlandingRadarChartComp", "%s" + bt.n(paramAnonymousString));
            AppMethodBeat.o(96810);
          }
        }
        
        public final void dRW() {}
        
        public final void dRX()
        {
          AppMethodBeat.i(96809);
          ak.b(ak.this, null);
          ak.a(ak.this).countDown();
          AppMethodBeat.o(96809);
        }
      });
      dWF();
      AppMethodBeat.o(96814);
      return;
    }
    Log.wtf("AdlandingRadarChartComp", "null info");
    AppMethodBeat.o(96814);
  }
  
  public final void dRo()
  {
    AppMethodBeat.i(96815);
    super.dRo();
    this.qfM.countDown();
    this.qfM.countDown();
    AppMethodBeat.o(96815);
  }
  
  protected final void dWF()
  {
    AppMethodBeat.i(96813);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.zDK.paddingLeft, (int)this.zDK.paddingTop, (int)this.zDK.paddingRight, (int)this.zDK.paddingBottom);
    }
    this.contentView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(96813);
  }
  
  protected final int getLayout()
  {
    return 2131495493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ak
 * JD-Core Version:    0.7.0.1
 */