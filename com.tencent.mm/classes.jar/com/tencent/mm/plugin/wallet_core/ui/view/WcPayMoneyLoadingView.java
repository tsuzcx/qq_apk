package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.robinhood.ticker.TickerView;
import com.robinhood.ticker.TickerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.wallet_core.ui.i;

public class WcPayMoneyLoadingView
  extends FrameLayout
  implements p
{
  private boolean CSK;
  private TickerView VXu;
  private String VXv;
  private String VXw;
  public Runnable VXx;
  public ProgressBar pRi;
  
  public WcPayMoneyLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71598);
    this.VXv = "";
    this.CSK = false;
    this.VXx = new Runnable()
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
    this.VXv = "";
    this.CSK = false;
    this.VXx = new Runnable()
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
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.k.WcPayMoneyLoadingViewAttrs, paramInt, 0);
    float f = paramAttributeSet.getDimension(a.k.WcPayMoneyLoadingViewAttrs_android_textSize, 15.0F);
    paramInt = paramAttributeSet.getColor(a.k.WcPayMoneyLoadingViewAttrs_android_textColor, -16777216);
    int i = paramAttributeSet.getInteger(a.k.WcPayMoneyLoadingViewAttrs_walletTypeFace, 4);
    paramAttributeSet.getInteger(a.k.WcPayMoneyLoadingViewAttrs_progressBarType, 0);
    paramAttributeSet.recycle();
    setTextSize(f);
    setTextColor(paramInt);
    setTypeface(i.bE(getContext(), i));
    AppMethodBeat.o(71600);
  }
  
  private void init()
  {
    AppMethodBeat.i(71601);
    inflate(getContext(), a.g.money_loading_view, this);
    this.VXu = ((TickerView)findViewById(a.f.mlv_money_tv));
    this.VXu.setCharacterLists(new String[] { "0123456789" });
    AppMethodBeat.o(71601);
  }
  
  public final void dD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71607);
    if (paramString == null)
    {
      AppMethodBeat.o(71607);
      return;
    }
    if (Util.isNullOrNil(this.VXw))
    {
      setFirstMoney(paramString);
      if (paramBoolean)
      {
        removeCallbacks(this.VXx);
        AppMethodBeat.o(71607);
      }
    }
    else
    {
      setNewMoney(paramString);
    }
    AppMethodBeat.o(71607);
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(71611);
    removeCallbacks(this.VXx);
    AppMethodBeat.o(71611);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(71610);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "reset money");
    this.VXw = null;
    AppMethodBeat.o(71610);
  }
  
  public void setFirstMoney(String paramString)
  {
    AppMethodBeat.i(71608);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "set last money: %s", new Object[] { paramString });
    this.VXw = paramString;
    if (!Util.isNullOrNil(paramString)) {
      this.VXu.setText(this.VXv + paramString, false);
    }
    postDelayed(this.VXx, 500L);
    AppMethodBeat.o(71608);
  }
  
  public void setLoadingPb(ProgressBar paramProgressBar)
  {
    this.pRi = paramProgressBar;
  }
  
  public void setMoney(String paramString)
  {
    AppMethodBeat.i(71606);
    dD(paramString, false);
    AppMethodBeat.o(71606);
  }
  
  public void setNewMoney(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(71609);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "set new money: %s", new Object[] { paramString });
    removeCallbacks(this.VXx);
    this.pRi.setVisibility(8);
    label94:
    boolean bool2;
    if (this.VXw.length() != paramString.length())
    {
      this.VXu.setAnimationDuration(800L);
      double d = Util.getDouble(this.VXw, 0.0D);
      if (Util.getDouble(paramString, 0.0D) <= d) {
        break label159;
      }
      this.VXu.setPreferredScrollingDirection(TickerView.a.dZK);
      bool2 = this.CSK;
      if (!Util.isNullOrNil(this.VXw)) {
        break label172;
      }
    }
    for (;;)
    {
      this.VXu.setText(this.VXv + paramString, bool1);
      AppMethodBeat.o(71609);
      return;
      this.VXu.setAnimationDuration(500L);
      break;
      label159:
      this.VXu.setPreferredScrollingDirection(TickerView.a.dZJ);
      break label94;
      label172:
      bool1 = bool2;
    }
  }
  
  public void setPrefixSymbol(String paramString)
  {
    this.VXv = paramString;
  }
  
  public void setProgressBarStyle(int paramInt)
  {
    AppMethodBeat.i(71602);
    if (paramInt == 0)
    {
      this.pRi.setIndeterminateDrawable(getResources().getDrawable(a.e.progress_single_white_medium_holo));
      AppMethodBeat.o(71602);
      return;
    }
    this.pRi.setIndeterminateDrawable(getResources().getDrawable(a.e.progress_large_holo));
    AppMethodBeat.o(71602);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(71605);
    this.VXu.setTextColor(paramInt);
    AppMethodBeat.o(71605);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(71604);
    float f2 = a.getScaleSize(MMApplicationContext.getContext());
    float f1;
    if (!aw.bc(f2, a.mi(MMApplicationContext.getContext())))
    {
      f1 = f2;
      if (!aw.bc(f2, a.mj(MMApplicationContext.getContext()))) {}
    }
    else
    {
      f1 = a.mh(MMApplicationContext.getContext());
    }
    this.VXu.setTextSize(f1 * paramFloat);
    AppMethodBeat.o(71604);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(71603);
    this.VXu.setTypeface(paramTypeface);
    AppMethodBeat.o(71603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView
 * JD-Core Version:    0.7.0.1
 */