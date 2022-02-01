package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class MMScrollView
  extends ScrollView
  implements View.OnFocusChangeListener
{
  private b JGI;
  private a JGJ;
  
  public MMScrollView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MMScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(ViewGroup paramViewGroup, View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    AppMethodBeat.i(72943);
    int j = paramViewGroup.getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = paramViewGroup.getChildAt(i);
      if (((localView instanceof WalletFormView)) || ((localView instanceof EditHintPasswdView))) {
        localView.setOnFocusChangeListener(paramOnFocusChangeListener);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localView instanceof ViewGroup)) {
          a((ViewGroup)localView, paramOnFocusChangeListener);
        }
      }
    }
    AppMethodBeat.o(72943);
  }
  
  public void onFocusChange(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72944);
    ac.d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      AppMethodBeat.o(72944);
      return;
    }
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(72942);
        MMScrollView.this.scrollTo(0, paramView.getTop() - a.fromDPToPix(MMScrollView.this.getContext(), 10));
        AppMethodBeat.o(72942);
      }
    }, 200L);
    AppMethodBeat.o(72944);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72946);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.JGJ != null) {
      this.JGJ.onScrollChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(72946);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(72945);
    b localb;
    if ((this.JGI != null) && (paramInt2 != paramInt4))
    {
      localb = this.JGI;
      if (paramInt2 >= paramInt4) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      localb.tG(bool);
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(72945);
      return;
    }
  }
  
  public void setOnScrollListener(a parama)
  {
    this.JGJ = parama;
  }
  
  public void setOnSizeChangeListener(b paramb)
  {
    if (paramb != null) {
      this.JGI = paramb;
    }
  }
  
  public static abstract interface a
  {
    public abstract void onScrollChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  }
  
  public static abstract interface b
  {
    public abstract void tG(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.MMScrollView
 * JD-Core Version:    0.7.0.1
 */