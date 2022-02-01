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
import com.tencent.mm.cb.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class WcPayCashierDetailItemLayout
  extends LinearLayout
{
  private static final int Ilg;
  private static final int Ilh;
  private static final int qql;
  public TextView Cqw;
  public CdnImageView Ili;
  public CdnImageView Ilj;
  public TextView qWU;
  
  static
  {
    AppMethodBeat.i(71333);
    qql = a.fromDPToPix(MMApplicationContext.getContext(), 288);
    Ilg = a.fromDPToPix(MMApplicationContext.getContext(), 20);
    Ilh = a.fromDPToPix(MMApplicationContext.getContext(), 11);
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
    View.inflate(getContext(), 2131497034, this);
    this.Cqw = ((TextView)findViewById(2131310576));
    this.Ili = ((CdnImageView)findViewById(2131310577));
    this.qWU = ((TextView)findViewById(2131310579));
    this.Ilj = ((CdnImageView)findViewById(2131310578));
    Drawable localDrawable = this.Ilj.getDrawable();
    if (localDrawable != null) {
      localDrawable.setColorFilter(getResources().getColor(2131099683), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(71330);
  }
  
  public final void U(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(71332);
    this.qWU.setText(paramCharSequence);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71326);
        Layout localLayout = WcPayCashierDetailItemLayout.this.qWU.getLayout();
        if ((localLayout != null) && (localLayout.getLineCount() > 1)) {
          WcPayCashierDetailItemLayout.this.qWU.setMaxWidth((int)localLayout.getLineWidth(0));
        }
        AppMethodBeat.o(71326);
      }
    });
    AppMethodBeat.o(71332);
  }
  
  public final void fTs()
  {
    AppMethodBeat.i(71331);
    if (this.qWU.getVisibility() != 8) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71325);
          int j = WcPayCashierDetailItemLayout.this.Cqw.getWidth();
          int i = j;
          if (WcPayCashierDetailItemLayout.this.Ili.getVisibility() != 8) {
            i = j + WcPayCashierDetailItemLayout.Ilg;
          }
          j = i;
          if (WcPayCashierDetailItemLayout.this.Ilj.getVisibility() != 8) {
            j = i + WcPayCashierDetailItemLayout.Ilh;
          }
          i = WcPayCashierDetailItemLayout.Tp();
          WcPayCashierDetailItemLayout.this.qWU.setMaxWidth(i - j);
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