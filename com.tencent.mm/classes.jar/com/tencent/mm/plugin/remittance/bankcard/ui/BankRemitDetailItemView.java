package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.d.j;

public class BankRemitDetailItemView
  extends LinearLayout
{
  private TextView haW;
  private TextView iIV;
  private boolean nwo = false;
  
  public BankRemitDetailItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public BankRemitDetailItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public BankRemitDetailItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  public BankRemitDetailItemView(Context paramContext, boolean paramBoolean)
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
  
  public final void a(String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    this.haW.setText(paramString);
    if (paramBoolean)
    {
      this.iIV.setText(j.a(getContext(), paramCharSequence, this.iIV.getTextSize()));
      return;
    }
    this.iIV.setText(paramCharSequence);
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    a(getContext().getString(paramInt), paramCharSequence, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailItemView
 * JD-Core Version:    0.7.0.1
 */