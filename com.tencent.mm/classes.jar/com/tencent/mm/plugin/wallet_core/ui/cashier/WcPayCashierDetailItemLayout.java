package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ah;

public class WcPayCashierDetailItemLayout
  extends LinearLayout
{
  private static final int kHI;
  private static final int uuK;
  private static final int uuL;
  public TextView ldI;
  public TextView qkT;
  public CdnImageView uuM;
  public CdnImageView uuN;
  
  static
  {
    AppMethodBeat.i(142533);
    kHI = a.fromDPToPix(ah.getContext(), 288);
    uuK = a.fromDPToPix(ah.getContext(), 20);
    uuL = a.fromDPToPix(ah.getContext(), 11);
    AppMethodBeat.o(142533);
  }
  
  public WcPayCashierDetailItemLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(47753);
    init();
    AppMethodBeat.o(47753);
  }
  
  public WcPayCashierDetailItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47754);
    init();
    AppMethodBeat.o(47754);
  }
  
  public WcPayCashierDetailItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(47755);
    init();
    AppMethodBeat.o(47755);
  }
  
  private void init()
  {
    AppMethodBeat.i(47756);
    View.inflate(getContext(), 2130971277, this);
    this.qkT = ((TextView)findViewById(2131829444));
    this.uuM = ((CdnImageView)findViewById(2131829445));
    this.ldI = ((TextView)findViewById(2131829446));
    this.uuN = ((CdnImageView)findViewById(2131829447));
    AppMethodBeat.o(47756);
  }
  
  public final void K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142532);
    this.ldI.setText(paramCharSequence);
    post(new WcPayCashierDetailItemLayout.2(this));
    AppMethodBeat.o(142532);
  }
  
  public final void cWh()
  {
    AppMethodBeat.i(142531);
    if (this.ldI.getVisibility() != 8) {
      post(new WcPayCashierDetailItemLayout.1(this));
    }
    AppMethodBeat.o(142531);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDetailItemLayout
 * JD-Core Version:    0.7.0.1
 */