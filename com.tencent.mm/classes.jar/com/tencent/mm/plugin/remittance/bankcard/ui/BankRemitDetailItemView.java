package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.span.p;

public class BankRemitDetailItemView
  extends LinearLayout
{
  private boolean OdQ;
  private TextView pJi;
  private TextView sUt;
  
  public BankRemitDetailItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public BankRemitDetailItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67502);
    this.OdQ = false;
    init();
    AppMethodBeat.o(67502);
  }
  
  public BankRemitDetailItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67503);
    this.OdQ = false;
    init();
    AppMethodBeat.o(67503);
  }
  
  public BankRemitDetailItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(67501);
    this.OdQ = false;
    this.OdQ = paramBoolean;
    init();
    AppMethodBeat.o(67501);
  }
  
  private void init()
  {
    AppMethodBeat.i(67504);
    if (this.OdQ) {
      inflate(getContext(), a.g.bank_remit_detail_item_money_layout, this);
    }
    for (;;)
    {
      this.sUt = ((TextView)findViewById(a.f.brdi_title_tv));
      this.pJi = ((TextView)findViewById(a.f.brdi_desc_tv));
      AppMethodBeat.o(67504);
      return;
      inflate(getContext(), a.g.bank_remit_detail_item_comm_layout, this);
    }
  }
  
  public final void a(String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(67505);
    this.sUt.setText(paramString);
    if (paramBoolean)
    {
      this.pJi.setText(p.b(getContext(), paramCharSequence, this.pJi.getTextSize()));
      AppMethodBeat.o(67505);
      return;
    }
    this.pJi.setText(paramCharSequence);
    AppMethodBeat.o(67505);
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(67506);
    a(getContext().getString(paramInt), paramCharSequence, false);
    AppMethodBeat.o(67506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailItemView
 * JD-Core Version:    0.7.0.1
 */