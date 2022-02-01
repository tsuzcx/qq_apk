package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.aj;

public class WcPayCashierDetailItemLayout
  extends LinearLayout
{
  private static final int Dkq;
  private static final int Dkr;
  private static final int oUJ;
  public CdnImageView Dks;
  public CdnImageView Dkt;
  public TextView pAE;
  public TextView xZN;
  
  static
  {
    AppMethodBeat.i(71333);
    oUJ = a.fromDPToPix(aj.getContext(), 288);
    Dkq = a.fromDPToPix(aj.getContext(), 20);
    Dkr = a.fromDPToPix(aj.getContext(), 11);
    AppMethodBeat.o(71333);
  }
  
  public WcPayCashierDetailItemLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(71327);
    init();
    AppMethodBeat.o(71327);
  }
  
  public WcPayCashierDetailItemLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(71328);
    init();
    AppMethodBeat.o(71328);
  }
  
  public WcPayCashierDetailItemLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(71329);
    init();
    AppMethodBeat.o(71329);
  }
  
  private void init()
  {
    AppMethodBeat.i(71330);
    View.inflate(getContext(), 2131496054, this);
    this.xZN = ((TextView)findViewById(2131307052));
    this.Dks = ((CdnImageView)findViewById(2131307053));
    this.pAE = ((TextView)findViewById(2131307055));
    this.Dkt = ((CdnImageView)findViewById(2131307054));
    Drawable localDrawable = this.Dkt.getDrawable();
    if (localDrawable != null) {
      localDrawable.setColorFilter(getResources().getColor(2131099676), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(71330);
  }
  
  public final void Q(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(71332);
    this.pAE.setText(paramCharSequence);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71326);
        Layout localLayout = WcPayCashierDetailItemLayout.this.pAE.getLayout();
        if ((localLayout != null) && (localLayout.getLineCount() > 1)) {
          WcPayCashierDetailItemLayout.this.pAE.setMaxWidth((int)localLayout.getLineWidth(0));
        }
        AppMethodBeat.o(71326);
      }
    });
    AppMethodBeat.o(71332);
  }
  
  public final void eId()
  {
    AppMethodBeat.i(71331);
    if (this.pAE.getVisibility() != 8) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71325);
          int j = WcPayCashierDetailItemLayout.this.xZN.getWidth();
          int i = j;
          if (WcPayCashierDetailItemLayout.this.Dks.getVisibility() != 8) {
            i = j + WcPayCashierDetailItemLayout.Dkq;
          }
          j = i;
          if (WcPayCashierDetailItemLayout.this.Dkt.getVisibility() != 8) {
            j = i + WcPayCashierDetailItemLayout.Dkr;
          }
          i = WcPayCashierDetailItemLayout.oUJ;
          WcPayCashierDetailItemLayout.this.pAE.setMaxWidth(i - j);
          AppMethodBeat.o(71325);
        }
      });
    }
    AppMethodBeat.o(71331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDetailItemLayout
 * JD-Core Version:    0.7.0.1
 */