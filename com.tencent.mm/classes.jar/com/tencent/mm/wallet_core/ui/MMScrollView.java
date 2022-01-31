package com.tencent.mm.wallet_core.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class MMScrollView
  extends ScrollView
  implements View.OnFocusChangeListener
{
  private MMScrollView.b wCa;
  private MMScrollView.a wCb;
  
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
  }
  
  public void onFocusChange(final View paramView, boolean paramBoolean)
  {
    y.d("MicroMsg.MMScrollView", "onFocusChange:" + paramBoolean);
    if (!paramBoolean) {
      return;
    }
    postDelayed(new Runnable()
    {
      public final void run()
      {
        MMScrollView.this.scrollTo(0, paramView.getTop() - a.fromDPToPix(MMScrollView.this.getContext(), 10));
      }
    }, 200L);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    MMScrollView.b localb;
    if ((this.wCa != null) && (paramInt2 != paramInt4))
    {
      localb = this.wCa;
      if (paramInt2 >= paramInt4) {
        break label47;
      }
    }
    label47:
    for (boolean bool = true;; bool = false)
    {
      localb.kD(bool);
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
  }
  
  public void setOnScrollListener(MMScrollView.a parama)
  {
    this.wCb = parama;
  }
  
  public void setOnSizeChangeListener(MMScrollView.b paramb)
  {
    if (paramb != null) {
      this.wCa = paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.MMScrollView
 * JD-Core Version:    0.7.0.1
 */