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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class WcPayCashierDetailItemLayout
  extends LinearLayout
{
  private static final int VUf;
  private static final int VUg;
  private static final int wSj;
  public TextView Olf;
  public CdnImageView VUh;
  public CdnImageView VUi;
  public TextView xGl;
  
  static
  {
    AppMethodBeat.i(71333);
    wSj = a.fromDPToPix(MMApplicationContext.getContext(), 288);
    VUf = a.fromDPToPix(MMApplicationContext.getContext(), 20);
    VUg = a.fromDPToPix(MMApplicationContext.getContext(), 11);
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
    this.Olf = ((TextView)findViewById(a.f.wpci_left_tv));
    this.VUh = ((CdnImageView)findViewById(a.f.wpci_middle_iv));
    this.xGl = ((TextView)findViewById(a.f.wpci_right_tv));
    this.VUi = ((CdnImageView)findViewById(a.f.wpci_right_arrow_iv));
    Drawable localDrawable = this.VUi.getDrawable();
    if (localDrawable != null) {
      localDrawable.setColorFilter(getResources().getColor(a.c.BW_50), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(71330);
  }
  
  public final void av(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(71332);
    this.xGl.setText(paramCharSequence);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71326);
        Layout localLayout = WcPayCashierDetailItemLayout.this.xGl.getLayout();
        if ((localLayout != null) && (localLayout.getLineCount() > 1)) {
          WcPayCashierDetailItemLayout.this.xGl.setMaxWidth((int)localLayout.getLineWidth(0));
        }
        AppMethodBeat.o(71326);
      }
    });
    AppMethodBeat.o(71332);
  }
  
  public final void ilo()
  {
    AppMethodBeat.i(71331);
    if (this.xGl.getVisibility() != 8) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71325);
          int j = WcPayCashierDetailItemLayout.this.Olf.getWidth();
          int i = j;
          if (WcPayCashierDetailItemLayout.this.VUh.getVisibility() != 8) {
            i = j + WcPayCashierDetailItemLayout.VUf;
          }
          j = i;
          if (WcPayCashierDetailItemLayout.this.VUi.getVisibility() != 8) {
            j = i + WcPayCashierDetailItemLayout.VUg;
          }
          i = WcPayCashierDetailItemLayout.wSj;
          WcPayCashierDetailItemLayout.this.xGl.setMaxWidth(i - j);
          AppMethodBeat.o(71325);
        }
      });
    }
    AppMethodBeat.o(71331);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.WcPayCashierDetailItemLayout
 * JD-Core Version:    0.7.0.1
 */