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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class WcPayCashierDetailItemLayout
  extends LinearLayout
{
  private static final int Pdy;
  private static final int Pdz;
  private static final int tOT;
  public TextView InN;
  public CdnImageView PdA;
  public CdnImageView PdB;
  public TextView uzI;
  
  static
  {
    AppMethodBeat.i(71333);
    tOT = a.fromDPToPix(MMApplicationContext.getContext(), 288);
    Pdy = a.fromDPToPix(MMApplicationContext.getContext(), 20);
    Pdz = a.fromDPToPix(MMApplicationContext.getContext(), 11);
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
    View.inflate(getContext(), a.g.wc_pay_cashier_detail_item, this);
    this.InN = ((TextView)findViewById(a.f.wpci_left_tv));
    this.PdA = ((CdnImageView)findViewById(a.f.wpci_middle_iv));
    this.uzI = ((TextView)findViewById(a.f.wpci_right_tv));
    this.PdB = ((CdnImageView)findViewById(a.f.wpci_right_arrow_iv));
    Drawable localDrawable = this.PdB.getDrawable();
    if (localDrawable != null) {
      localDrawable.setColorFilter(getResources().getColor(a.c.BW_50), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(71330);
  }
  
  public final void ai(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(71332);
    this.uzI.setText(paramCharSequence);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71326);
        Layout localLayout = WcPayCashierDetailItemLayout.this.uzI.getLayout();
        if ((localLayout != null) && (localLayout.getLineCount() > 1)) {
          WcPayCashierDetailItemLayout.this.uzI.setMaxWidth((int)localLayout.getLineWidth(0));
        }
        AppMethodBeat.o(71326);
      }
    });
    AppMethodBeat.o(71332);
  }
  
  public final void gLY()
  {
    AppMethodBeat.i(71331);
    if (this.uzI.getVisibility() != 8) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71325);
          int j = WcPayCashierDetailItemLayout.this.InN.getWidth();
          int i = j;
          if (WcPayCashierDetailItemLayout.this.PdA.getVisibility() != 8) {
            i = j + WcPayCashierDetailItemLayout.Pdy;
          }
          j = i;
          if (WcPayCashierDetailItemLayout.this.PdB.getVisibility() != 8) {
            j = i + WcPayCashierDetailItemLayout.Pdz;
          }
          i = WcPayCashierDetailItemLayout.Yx();
          WcPayCashierDetailItemLayout.this.uzI.setMaxWidth(i - j);
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