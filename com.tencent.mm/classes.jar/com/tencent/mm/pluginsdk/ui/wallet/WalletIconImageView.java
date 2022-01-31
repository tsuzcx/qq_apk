package com.tencent.mm.pluginsdk.ui.wallet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;

public class WalletIconImageView
  extends ImageView
{
  private int ml = 4;
  private int snP = -1;
  private View.OnClickListener snQ = null;
  
  public WalletIconImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WalletIconImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void cov()
  {
    super.setVisibility(this.ml);
    super.setImageResource(this.snP);
    super.setOnClickListener(this.snQ);
  }
  
  public void setImageResource(int paramInt)
  {
    this.snP = paramInt;
    super.setImageResource(paramInt);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.snQ = paramOnClickListener;
  }
  
  public void setToClearState(View.OnClickListener paramOnClickListener)
  {
    super.setVisibility(0);
    super.setImageResource(a.e.list_clear);
    super.setContentDescription(getContext().getString(a.i.clear_btn));
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setVisibility(int paramInt)
  {
    this.ml = paramInt;
    super.setVisibility(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView
 * JD-Core Version:    0.7.0.1
 */