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
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.ak;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import java.util.concurrent.CountDownLatch;

public final class aj
  extends k
{
  private static final int yqu;
  private CountDownLatch pCh;
  private RadarChart yqv;
  private Bitmap yqw;
  private Bitmap yqx;
  
  static
  {
    AppMethodBeat.i(96818);
    yqu = Color.parseColor("#26eae9e2");
    AppMethodBeat.o(96818);
  }
  
  public aj(Context paramContext, ak paramak, ViewGroup paramViewGroup)
  {
    super(paramContext, paramak, paramViewGroup);
    AppMethodBeat.i(96811);
    this.pCh = new CountDownLatch(2);
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
  
  public final void dJW()
  {
    AppMethodBeat.i(96812);
    this.yqv = ((RadarChart)this.contentView.findViewById(2131297955));
    AppMethodBeat.o(96812);
  }
  
  public final void dJX()
  {
    AppMethodBeat.i(96815);
    super.dJX();
    this.pCh.countDown();
    this.pCh.countDown();
    AppMethodBeat.o(96815);
  }
  
  protected final void dKm()
  {
    AppMethodBeat.i(96814);
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
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
          aj.a(aj.this).await();
          label15:
          if ((aj.b(aj.this) != null) && (aj.c(aj.this) != null)) {
            aj.this.contentView.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(96805);
                aj.a(aj.this, aj.b(aj.this), aj.c(aj.this));
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
    ak localak = (ak)dKG();
    if (localak != null)
    {
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localak.yki, localak.yjt, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(96808);
          try
          {
            paramAnonymousString = f.decodeFile(paramAnonymousString);
            aj.a(aj.this, paramAnonymousString);
            aj.a(aj.this).countDown();
            AppMethodBeat.o(96808);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ac.e("AdlandingRadarChartComp", "%s" + bs.m(paramAnonymousString));
            AppMethodBeat.o(96808);
          }
        }
        
        public final void dFC() {}
        
        public final void dFD()
        {
          AppMethodBeat.i(96807);
          aj.a(aj.this, null);
          aj.a(aj.this).countDown();
          AppMethodBeat.o(96807);
        }
      });
      com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h.a(localak.yko, localak.yjt, new f.a()
      {
        public final void asD(String paramAnonymousString)
        {
          AppMethodBeat.i(96810);
          try
          {
            aj.b(aj.this, f.decodeFile(paramAnonymousString));
            aj.a(aj.this).countDown();
            AppMethodBeat.o(96810);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            ac.e("AdlandingRadarChartComp", "%s" + bs.m(paramAnonymousString));
            AppMethodBeat.o(96810);
          }
        }
        
        public final void dFC() {}
        
        public final void dFD()
        {
          AppMethodBeat.i(96809);
          aj.b(aj.this, null);
          aj.a(aj.this).countDown();
          AppMethodBeat.o(96809);
        }
      });
      dKs();
      AppMethodBeat.o(96814);
      return;
    }
    Log.wtf("AdlandingRadarChartComp", "null info");
    AppMethodBeat.o(96814);
  }
  
  protected final void dKs()
  {
    AppMethodBeat.i(96813);
    ViewGroup.LayoutParams localLayoutParams = this.contentView.getLayoutParams();
    if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins((int)this.ymQ.paddingLeft, (int)this.ymQ.paddingTop, (int)this.ymQ.paddingRight, (int)this.ymQ.paddingBottom);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.aj
 * JD-Core Version:    0.7.0.1
 */