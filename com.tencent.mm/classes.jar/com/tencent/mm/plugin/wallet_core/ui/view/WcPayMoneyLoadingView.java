package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.robinhood.ticker.TickerView;
import com.robinhood.ticker.TickerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

public class WcPayMoneyLoadingView
  extends FrameLayout
  implements k
{
  private TickerView PgG;
  private String PgH;
  private String PgI;
  private boolean PgJ;
  public Runnable PgK;
  public ProgressBar mUB;
  
  public WcPayMoneyLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71598);
    this.PgH = "";
    this.PgJ = false;
    this.PgK = new Runnable()
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
    this.PgH = "";
    this.PgJ = false;
    this.PgK = new Runnable()
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
    setTypeface(g.bl(getContext(), i));
    AppMethodBeat.o(71600);
  }
  
  private void init()
  {
    AppMethodBeat.i(71601);
    inflate(getContext(), a.g.money_loading_view, this);
    this.PgG = ((TickerView)findViewById(a.f.mlv_money_tv));
    this.PgG.setCharacterLists(new String[] { "0123456789" });
    AppMethodBeat.o(71601);
  }
  
  public final void cV(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71607);
    if (paramString == null)
    {
      AppMethodBeat.o(71607);
      return;
    }
    if (Util.isNullOrNil(this.PgI))
    {
      setFirstMoney(paramString);
      if (paramBoolean)
      {
        removeCallbacks(this.PgK);
        AppMethodBeat.o(71607);
      }
    }
    else
    {
      setNewMoney(paramString);
    }
    AppMethodBeat.o(71607);
  }
  
  @t(jl=h.a.ON_DESTROY)
  public void onActivityDestroy()
  {
    AppMethodBeat.i(71611);
    removeCallbacks(this.PgK);
    AppMethodBeat.o(71611);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(71610);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "reset money");
    this.PgI = null;
    AppMethodBeat.o(71610);
  }
  
  public void setFirstMoney(String paramString)
  {
    AppMethodBeat.i(71608);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "set last money: %s", new Object[] { paramString });
    this.PgI = paramString;
    if (!Util.isNullOrNil(paramString)) {
      this.PgG.setText(this.PgH + paramString, false);
    }
    postDelayed(this.PgK, 500L);
    AppMethodBeat.o(71608);
  }
  
  public void setLoadingPb(ProgressBar paramProgressBar)
  {
    this.mUB = paramProgressBar;
  }
  
  public void setMoney(String paramString)
  {
    AppMethodBeat.i(71606);
    cV(paramString, false);
    AppMethodBeat.o(71606);
  }
  
  public void setNewMoney(String paramString)
  {
    boolean bool1 = false;
    AppMethodBeat.i(71609);
    Log.d("MicroMsg.WcPayMoneyLoadingView", "set new money: %s", new Object[] { paramString });
    removeCallbacks(this.PgK);
    this.mUB.setVisibility(8);
    label94:
    boolean bool2;
    if (this.PgI.length() != paramString.length())
    {
      this.PgG.setAnimationDuration(800L);
      double d = Util.getDouble(this.PgI, 0.0D);
      if (Util.getDouble(paramString, 0.0D) <= d) {
        break label159;
      }
      this.PgG.setPreferredScrollingDirection(TickerView.a.cjm);
      bool2 = this.PgJ;
      if (!Util.isNullOrNil(this.PgI)) {
        break label172;
      }
    }
    for (;;)
    {
      this.PgG.setText(this.PgH + paramString, bool1);
      AppMethodBeat.o(71609);
      return;
      this.PgG.setAnimationDuration(500L);
      break;
      label159:
      this.PgG.setPreferredScrollingDirection(TickerView.a.cjl);
      break label94;
      label172:
      bool1 = bool2;
    }
  }
  
  public void setPrefixSymbol(String paramString)
  {
    this.PgH = paramString;
  }
  
  public void setProgressBarStyle(int paramInt)
  {
    AppMethodBeat.i(71602);
    if (paramInt == 0)
    {
      this.mUB.setIndeterminateDrawable(getResources().getDrawable(a.e.progress_single_white_medium_holo));
      AppMethodBeat.o(71602);
      return;
    }
    this.mUB.setIndeterminateDrawable(getResources().getDrawable(a.e.progress_large_holo));
    AppMethodBeat.o(71602);
  }
  
  public void setTextColor(int paramInt)
  {
    AppMethodBeat.i(71605);
    this.PgG.setTextColor(paramInt);
    AppMethodBeat.o(71605);
  }
  
  public void setTextSize(float paramFloat)
  {
    AppMethodBeat.i(71604);
    this.PgG.setTextSize(paramFloat);
    AppMethodBeat.o(71604);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    AppMethodBeat.i(71603);
    this.PgG.setTypeface(paramTypeface);
    AppMethodBeat.o(71603);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView
 * JD-Core Version:    0.7.0.1
 */