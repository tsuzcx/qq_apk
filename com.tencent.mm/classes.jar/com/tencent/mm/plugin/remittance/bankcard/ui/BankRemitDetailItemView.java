package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.k;

public class BankRemitDetailItemView
  extends LinearLayout
{
  private TextView lCL;
  private TextView lDu;
  private boolean xTA;
  
  public BankRemitDetailItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public BankRemitDetailItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(67502);
    this.xTA = false;
    init();
    AppMethodBeat.o(67502);
  }
  
  public BankRemitDetailItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(67503);
    this.xTA = false;
    init();
    AppMethodBeat.o(67503);
  }
  
  public BankRemitDetailItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(67501);
    this.xTA = false;
    this.xTA = paramBoolean;
    init();
    AppMethodBeat.o(67501);
  }
  
  private void init()
  {
    AppMethodBeat.i(67504);
    if (this.xTA) {
      inflate(getContext(), 2131493152, this);
    }
    for (;;)
    {
      this.lCL = ((TextView)findViewById(2131297519));
      this.lDu = ((TextView)findViewById(2131297518));
      AppMethodBeat.o(67504);
      return;
      inflate(getContext(), 2131493151, this);
    }
  }
  
  public final void a(String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(67505);
    this.lCL.setText(paramString);
    if (paramBoolean)
    {
      this.lDu.setText(k.b(getContext(), paramCharSequence, this.lDu.getTextSize()));
      AppMethodBeat.o(67505);
      return;
    }
    this.lDu.setText(paramCharSequence);
    AppMethodBeat.o(67505);
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(67506);
    a(getContext().getString(paramInt), paramCharSequence, false);
    AppMethodBeat.o(67506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailItemView
 * JD-Core Version:    0.7.0.1
 */