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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;

public class WcPayMoneyLoadingView
  extends FrameLayout
  implements LifecycleObserver
{
  private TickerView DFd;
  private String DFe;
  private String DFf;
  private boolean DFg;
  public Runnable DFh;
  public ProgressBar jeY;
  
  public WcPayMoneyLoadingView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(71597);
    this.DFe = "";
    this.DFg = false;
    this.DFh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        ae.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
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
    this.DFe = "";
    this.DFg = false;
    this.DFh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        ae.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
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
    this.DFe = "";
    this.DFg = false;
    this.DFh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        ae.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
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
    setTypeface(f.aR(getContext(), i));
    AppMethodBeat.o(71600);
  }
  
  private void init()
  {
    AppMethodBeat.i(71601);
    inflate(getContext(), 2131494941, this);
    this.DFd = ((TickerView)findViewById(2131302292));
    this.DFd.setCharacterLists(new String[] { "0123456789" });
    AppMethodBeat.o(71601);
  }
  
  public final void co(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71607);
    if (paramString == null)
    {
      AppMethodBeat.o(71607);
      return;
    }
    if (bu.isNullOrNil(this.DFf))
    {
      setFirstMoney(paramString);
      if (paramBoolean)
      {
        removeCallbacks(this.DFh);
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
    removeCallbacks(this.DFh);
    AppMethodBeat.o(71611);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(71610);
    ae.d("MicroMsg.WcPayMoneyLoadingView", "reset money");
    this.DFf = null;
    AppMethodBeat.o(71610);
  }
  
  public void setFirstMoney(String paramString)
  {
    AppMethodBeat.i(71608);
    ae.d("MicroMsg.WcPayMoneyLoadingView", "set last money: %s", new Object[] { paramString });
    this.DFf = paramString;
    if (!bu.isNullOrNil(paramString)) {
      this.DFd.setText(this.DFe + paramString, false);
    }
    postDelayed(this.DFh, 500L);
    AppMethodBeat.o(71608);
  }
  
  public void setLoadingPb(ProgressBar paramProgressBar)
  {
    this.jeY = paramProgressBar;
  }
  
  public void setMoney(String paramString)
  {
    AppMethodBeat.i(71606);
    co(paramString, false);
    AppMethodBeat.o(71606);
  }
  
  public void setNewMoney(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(71609);
    ae.d("MicroMsg.WcPayMoneyLoadingView", "set new money: %s", new Object[] { paramString });
    removeCallbacks(this.DFh);
    this.jeY.setVisibility(8);
    label94:
    boolean bool2;
    if (this.DFf.length() != paramString.length())
    {
      this.DFd.setAnimationDuration(800L);
      double d = bu.getDouble(this.DFf, 0.0D);
      if (bu.getDouble(paramString, 0.0D) <= d) {
        break label159;
      }
      this.DFd.setPreferredScrollingDirection(TickerView.a.bWD);
      bool2 = this.DFg;
      if (!bu.isNullOrNil(this.DFf)) {
        break label172;
      }
    }
    for (;;)
    {
      this.DFd.setText(this.DFe + paramString, bool1);
      AppMethodBeat.o(71609);
      return;
      this.DFd.setAnimationDuration(500L);
      break;
      label159:
      this.DFd.setPreferredScrollingDirection(TickerView.a.bWC);
      break label94;
      label172:
      bool1 = bool2;
    }
  }
  
  public void setPrefixSymbol(String paramString)
  {
    this.DFe = paramString;
  }
  
  public void setProgressBarStyle(int paramInt)
  {
    AppMethodBeat.i(71602);
    if (paramInt == 0)
    {
      this.jeY.setIndeterminateDrawable(getResources().getDrawable(2131233682));
      AppMethodBeat.o(71602);
      return;
    }
    this.jeY.setIndeterminateDrawable(getResources().getDrawable(2131233679));
    AppMethodBeat.o(71602);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(71605);
    this.DFd.setTextColor(paramInt);
    AppMethodBeat.o(71605);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(71604);
    this.DFd.setTextSize(paramFloat);
    AppMethodBeat.o(71604);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(71603);
    this.DFd.setTypeface(paramTypeface);
    AppMethodBeat.o(71603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView
 * JD-Core Version:    0.7.0.1
 */