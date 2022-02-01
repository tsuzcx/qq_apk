package com.tencent.mm.plugin.wallet_core.ui.view;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.robinhood.ticker.TickerView;
import com.robinhood.ticker.TickerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;

public class WcPayMoneyLoadingView
  extends FrameLayout
  implements LifecycleObserver
{
  private TickerView BNg;
  private String BNh;
  private String BNi;
  private boolean BNj;
  public Runnable BNk;
  public ProgressBar iIW;
  
  public WcPayMoneyLoadingView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(71597);
    this.BNh = "";
    this.BNj = false;
    this.BNk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        ac.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
        WcPayMoneyLoadingView.a(WcPayMoneyLoadingView.this).setVisibility(0);
        WcPayMoneyLoadingView.b(WcPayMoneyLoadingView.this);
        AppMethodBeat.o(71596);
      }
    };
    init();
    AppMethodBeat.o(71597);
  }
  
  public WcPayMoneyLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71598);
    this.BNh = "";
    this.BNj = false;
    this.BNk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        ac.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
        WcPayMoneyLoadingView.a(WcPayMoneyLoadingView.this).setVisibility(0);
        WcPayMoneyLoadingView.b(WcPayMoneyLoadingView.this);
        AppMethodBeat.o(71596);
      }
    };
    init();
    b(paramAttributeSet, -1);
    AppMethodBeat.o(71598);
  }
  
  public WcPayMoneyLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71599);
    this.BNh = "";
    this.BNj = false;
    this.BNk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        ac.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
        WcPayMoneyLoadingView.a(WcPayMoneyLoadingView.this).setVisibility(0);
        WcPayMoneyLoadingView.b(WcPayMoneyLoadingView.this);
        AppMethodBeat.o(71596);
      }
    };
    init();
    b(paramAttributeSet, paramInt);
    AppMethodBeat.o(71599);
  }
  
  private void b(AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(71600);
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.a.WcPayMoneyLoadingViewAttrs, paramInt, 0);
    float f = paramAttributeSet.getDimension(0, 15.0F);
    paramInt = paramAttributeSet.getColor(1, -16777216);
    int i = paramAttributeSet.getInteger(3, 4);
    paramAttributeSet.getInteger(2, 0);
    paramAttributeSet.recycle();
    setTextSize(f);
    setTextColor(paramInt);
    setTypeface(e.aO(getContext(), i));
    AppMethodBeat.o(71600);
  }
  
  private void init()
  {
    AppMethodBeat.i(71601);
    inflate(getContext(), 2131494941, this);
    this.BNg = ((TickerView)findViewById(2131302292));
    this.BNg.setCharacterLists(new String[] { "0123456789" });
    AppMethodBeat.o(71601);
  }
  
  public final void cc(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71607);
    if (paramString == null)
    {
      AppMethodBeat.o(71607);
      return;
    }
    if (bs.isNullOrNil(this.BNi))
    {
      setFirstMoney(paramString);
      if (paramBoolean)
      {
        removeCallbacks(this.BNk);
        AppMethodBeat.o(71607);
      }
    }
    else
    {
      setNewMoney(paramString);
    }
    AppMethodBeat.o(71607);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(71611);
    removeCallbacks(this.BNk);
    AppMethodBeat.o(71611);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(71610);
    ac.d("MicroMsg.WcPayMoneyLoadingView", "reset money");
    this.BNi = null;
    AppMethodBeat.o(71610);
  }
  
  public void setFirstMoney(String paramString)
  {
    AppMethodBeat.i(71608);
    ac.d("MicroMsg.WcPayMoneyLoadingView", "set last money: %s", new Object[] { paramString });
    this.BNi = paramString;
    if (!bs.isNullOrNil(paramString)) {
      this.BNg.setText(this.BNh + paramString, false);
    }
    postDelayed(this.BNk, 500L);
    AppMethodBeat.o(71608);
  }
  
  public void setLoadingPb(ProgressBar paramProgressBar)
  {
    this.iIW = paramProgressBar;
  }
  
  public void setMoney(String paramString)
  {
    AppMethodBeat.i(71606);
    cc(paramString, false);
    AppMethodBeat.o(71606);
  }
  
  public void setNewMoney(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(71609);
    ac.d("MicroMsg.WcPayMoneyLoadingView", "set new money: %s", new Object[] { paramString });
    removeCallbacks(this.BNk);
    this.iIW.setVisibility(8);
    label94:
    boolean bool2;
    if (this.BNi.length() != paramString.length())
    {
      this.BNg.setAnimationDuration(800L);
      double d = bs.getDouble(this.BNi, 0.0D);
      if (bs.getDouble(paramString, 0.0D) <= d) {
        break label159;
      }
      this.BNg.setPreferredScrollingDirection(TickerView.a.bMq);
      bool2 = this.BNj;
      if (!bs.isNullOrNil(this.BNi)) {
        break label172;
      }
    }
    for (;;)
    {
      this.BNg.setText(this.BNh + paramString, bool1);
      AppMethodBeat.o(71609);
      return;
      this.BNg.setAnimationDuration(500L);
      break;
      label159:
      this.BNg.setPreferredScrollingDirection(TickerView.a.bMp);
      break label94;
      label172:
      bool1 = bool2;
    }
  }
  
  public void setPrefixSymbol(String paramString)
  {
    this.BNh = paramString;
  }
  
  public void setProgressBarStyle(int paramInt)
  {
    AppMethodBeat.i(71602);
    if (paramInt == 0)
    {
      this.iIW.setIndeterminateDrawable(getResources().getDrawable(2131233682));
      AppMethodBeat.o(71602);
      return;
    }
    this.iIW.setIndeterminateDrawable(getResources().getDrawable(2131233679));
    AppMethodBeat.o(71602);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(71605);
    this.BNg.setTextColor(paramInt);
    AppMethodBeat.o(71605);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(71604);
    this.BNg.setTextSize(paramFloat);
    AppMethodBeat.o(71604);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(71603);
    this.BNg.setTypeface(paramTypeface);
    AppMethodBeat.o(71603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView
 * JD-Core Version:    0.7.0.1
 */