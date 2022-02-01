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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

public class WcPayMoneyLoadingView
  extends FrameLayout
  implements LifecycleObserver
{
  private TickerView Ioo;
  private String Iop;
  private String Ioq;
  private boolean Ior;
  public Runnable Ios;
  public ProgressBar kdb;
  
  public WcPayMoneyLoadingView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(71597);
    this.Iop = "";
    this.Ior = false;
    this.Ios = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        Log.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
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
    this.Iop = "";
    this.Ior = false;
    this.Ios = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        Log.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
        WcPayMoneyLoadingView.a(WcPayMoneyLoadingView.this).setVisibility(0);
        WcPayMoneyLoadingView.b(WcPayMoneyLoadingView.this);
        AppMethodBeat.o(71596);
      }
    };
    init();
    c(paramAttributeSet, -1);
    AppMethodBeat.o(71598);
  }
  
  public WcPayMoneyLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71599);
    this.Iop = "";
    this.Ior = false;
    this.Ios = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71596);
        Log.i("MicroMsg.WcPayMoneyLoadingView", "show loading pb");
        WcPayMoneyLoadingView.a(WcPayMoneyLoadingView.this).setVisibility(0);
        WcPayMoneyLoadingView.b(WcPayMoneyLoadingView.this);
        AppMethodBeat.o(71596);
      }
    };
    init();
    c(paramAttributeSet, paramInt);
    AppMethodBeat.o(71599);
  }
  
  private void c(AttributeSet paramAttributeSet, int paramInt)
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
    setTypeface(f.aS(getContext(), i));
    AppMethodBeat.o(71600);
  }
  
  private void init()
  {
    AppMethodBeat.i(71601);
    inflate(getContext(), 2131495683, this);
    this.Ioo = ((TickerView)findViewById(2131304686));
    this.Ioo.setCharacterLists(new String[] { "0123456789" });
    AppMethodBeat.o(71601);
  }
  
  public final void cH(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71607);
    if (paramString == null)
    {
      AppMethodBeat.o(71607);
      return;
    }
    if (Util.isNullOrNil(this.Ioq))
    {
      setFirstMoney(paramString);
      if (paramBoolean)
      {
        removeCallbacks(this.Ios);
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
    removeCallbacks(this.Ios);
    AppMethodBeat.o(71611);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(71610);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "reset money");
    this.Ioq = null;
    AppMethodBeat.o(71610);
  }
  
  public void setFirstMoney(String paramString)
  {
    AppMethodBeat.i(71608);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "set last money: %s", new Object[] { paramString });
    this.Ioq = paramString;
    if (!Util.isNullOrNil(paramString)) {
      this.Ioo.setText(this.Iop + paramString, false);
    }
    postDelayed(this.Ios, 500L);
    AppMethodBeat.o(71608);
  }
  
  public void setLoadingPb(ProgressBar paramProgressBar)
  {
    this.kdb = paramProgressBar;
  }
  
  public void setMoney(String paramString)
  {
    AppMethodBeat.i(71606);
    cH(paramString, false);
    AppMethodBeat.o(71606);
  }
  
  public void setNewMoney(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(71609);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "set new money: %s", new Object[] { paramString });
    removeCallbacks(this.Ios);
    this.kdb.setVisibility(8);
    label94:
    boolean bool2;
    if (this.Ioq.length() != paramString.length())
    {
      this.Ioo.setAnimationDuration(800L);
      double d = Util.getDouble(this.Ioq, 0.0D);
      if (Util.getDouble(paramString, 0.0D) <= d) {
        break label159;
      }
      this.Ioo.setPreferredScrollingDirection(TickerView.a.chl);
      bool2 = this.Ior;
      if (!Util.isNullOrNil(this.Ioq)) {
        break label172;
      }
    }
    for (;;)
    {
      this.Ioo.setText(this.Iop + paramString, bool1);
      AppMethodBeat.o(71609);
      return;
      this.Ioo.setAnimationDuration(500L);
      break;
      label159:
      this.Ioo.setPreferredScrollingDirection(TickerView.a.chk);
      break label94;
      label172:
      bool1 = bool2;
    }
  }
  
  public void setPrefixSymbol(String paramString)
  {
    this.Iop = paramString;
  }
  
  public void setProgressBarStyle(int paramInt)
  {
    AppMethodBeat.i(71602);
    if (paramInt == 0)
    {
      this.kdb.setIndeterminateDrawable(getResources().getDrawable(2131234496));
      AppMethodBeat.o(71602);
      return;
    }
    this.kdb.setIndeterminateDrawable(getResources().getDrawable(2131234493));
    AppMethodBeat.o(71602);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(71605);
    this.Ioo.setTextColor(paramInt);
    AppMethodBeat.o(71605);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(71604);
    this.Ioo.setTextSize(paramFloat);
    AppMethodBeat.o(71604);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(71603);
    this.Ioo.setTypeface(paramTypeface);
    AppMethodBeat.o(71603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView
 * JD-Core Version:    0.7.0.1
 */