package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class MMScrollView
  extends ScrollView
  implements View.OnFocusChangeListener
{
  private MMScrollView.b AYt;
  private MMScrollView.a AYu;
  
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
    AppMethodBeat.i(49223);
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
    AppMethodBeat.o(49223);
  }
  
  public void onFocusChange(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49224);
    ab.d("MicroMsg.MMScrollView", "onFocusChange:".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean)
    {
      AppMethodBeat.o(49224);
      return;
    }
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(49222);
        MMScrollView.this.scrollTo(0, paramView.getTop() - a.fromDPToPix(MMScrollView.this.getContext(), 10));
        AppMethodBeat.o(49222);
      }
    }, 200L);
    AppMethodBeat.o(49224);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49226);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.AYu != null) {
      this.AYu.onScrollChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    AppMethodBeat.o(49226);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49225);
    MMScrollView.b localb;
    if ((this.AYt != null) && (paramInt2 != paramInt4))
    {
      localb = this.AYt;
      if (paramInt2 >= paramInt4) {
        break label57;
      }
    }
    label57:
    for (boolean bool = true;; bool = false)
    {
      localb.nK(bool);
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      AppMethodBeat.o(49225);
      return;
    }
  }
  
  public void setOnScrollListener(MMScrollView.a parama)
  {
    this.AYu = parama;
  }
  
  public void setOnSizeChangeListener(MMScrollView.b paramb)
  {
    if (paramb != null) {
      this.AYt = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.MMScrollView
 * JD-Core Version:    0.7.0.1
 */