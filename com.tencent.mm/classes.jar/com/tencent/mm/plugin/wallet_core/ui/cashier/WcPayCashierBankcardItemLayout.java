package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;

public class WcPayCashierBankcardItemLayout
  extends LinearLayout
{
  public CdnImageView kAK;
  public FavourLayout upD;
  public TextView uuH;
  public TextView uuI;
  public RadioButton uuJ;
  
  public WcPayCashierBankcardItemLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(47749);
    init();
    AppMethodBeat.o(47749);
  }
  
  public WcPayCashierBankcardItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(47750);
    init();
    AppMethodBeat.o(47750);
  }
  
  public WcPayCashierBankcardItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(47751);
    init();
    AppMethodBeat.o(47751);
  }
  
  private void init()
  {
    AppMethodBeat.i(47752);
    View.inflate(getContext(), 2130971276, this);
    this.kAK = ((CdnImageView)findViewById(2131829439));
    this.uuH = ((TextView)findViewById(2131829440));
    this.uuI = ((TextView)findViewById(2131829442));
    this.uuJ = ((RadioButton)findViewById(2131829441));
    this.upD = ((FavourLayout)findViewById(2131829443));
    AppMethodBeat.o(47752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierBankcardItemLayout
 * JD-Core Version:    0.7.0.1
 */