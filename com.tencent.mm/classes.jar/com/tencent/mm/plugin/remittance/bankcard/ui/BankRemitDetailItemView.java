package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.d.j;

public class BankRemitDetailItemView
  extends LinearLayout
{
  private TextView iJG;
  private TextView kPB;
  private boolean qhq;
  
  public BankRemitDetailItemView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public BankRemitDetailItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(44589);
    this.qhq = false;
    init();
    AppMethodBeat.o(44589);
  }
  
  public BankRemitDetailItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(44590);
    this.qhq = false;
    init();
    AppMethodBeat.o(44590);
  }
  
  public BankRemitDetailItemView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(44588);
    this.qhq = false;
    this.qhq = paramBoolean;
    init();
    AppMethodBeat.o(44588);
  }
  
  private void init()
  {
    AppMethodBeat.i(44591);
    if (this.qhq) {
      inflate(getContext(), 2130968820, this);
    }
    for (;;)
    {
      this.iJG = ((TextView)findViewById(2131821678));
      this.kPB = ((TextView)findViewById(2131821679));
      AppMethodBeat.o(44591);
      return;
      inflate(getContext(), 2130968819, this);
    }
  }
  
  public final void a(String paramString, CharSequence paramCharSequence, boolean paramBoolean)
  {
    AppMethodBeat.i(44592);
    this.iJG.setText(paramString);
    if (paramBoolean)
    {
      this.kPB.setText(j.b(getContext(), paramCharSequence, this.kPB.getTextSize()));
      AppMethodBeat.o(44592);
      return;
    }
    this.kPB.setText(paramCharSequence);
    AppMethodBeat.o(44592);
  }
  
  public final void b(int paramInt, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(44593);
    a(getContext().getString(paramInt), paramCharSequence, false);
    AppMethodBeat.o(44593);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitDetailItemView
 * JD-Core Version:    0.7.0.1
 */