package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;

public class WalletBalanceFetchResultItemView
  extends LinearLayout
{
  private TextView haW;
  private TextView iIV;
  private boolean nwo = false;
  
  public WalletBalanceFetchResultItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public WalletBalanceFetchResultItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.nwo = paramBoolean;
    init();
  }
  
  private void init()
  {
    if (this.nwo) {
      inflate(getContext(), a.g.bank_remit_detail_item_money_layout, this);
    }
    for (;;)
    {
      this.haW = ((TextView)findViewById(a.f.brdi_title_tv));
      this.iIV = ((TextView)findViewById(a.f.brdi_desc_tv));
      return;
      inflate(getContext(), a.g.bank_remit_detail_item_comm_layout, this);
    }
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    String str = getContext().getString(paramInt);
    this.haW.setText(str);
    this.iIV.setText(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView
 * JD-Core Version:    0.7.0.1
 */