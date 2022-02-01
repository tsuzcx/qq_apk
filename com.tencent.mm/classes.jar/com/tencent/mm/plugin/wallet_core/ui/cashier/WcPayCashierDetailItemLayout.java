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
import com.tencent.mm.sdk.platformtools.ai;

public class WcPayCashierDetailItemLayout
  extends LinearLayout
{
  private static final int BJY;
  private static final int BJZ;
  private static final int orn;
  public CdnImageView BKa;
  public CdnImageView BKb;
  public TextView oWU;
  public TextView wMg;
  
  static
  {
    AppMethodBeat.i(71333);
    orn = a.fromDPToPix(ai.getContext(), 288);
    BJY = a.fromDPToPix(ai.getContext(), 20);
    BJZ = a.fromDPToPix(ai.getContext(), 11);
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
    this.wMg = ((TextView)findViewById(2131307052));
    this.BKa = ((CdnImageView)findViewById(2131307053));
    this.oWU = ((TextView)findViewById(2131307055));
    this.BKb = ((CdnImageView)findViewById(2131307054));
    Drawable localDrawable = this.BKb.getDrawable();
    if (localDrawable != null) {
      localDrawable.setColorFilter(getResources().getColor(2131099676), PorterDuff.Mode.SRC_ATOP);
    }
    AppMethodBeat.o(71330);
  }
  
  public final void R(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(71332);
    this.oWU.setText(paramCharSequence);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(71326);
        Layout localLayout = WcPayCashierDetailItemLayout.this.oWU.getLayout();
        if ((localLayout != null) && (localLayout.getLineCount() > 1)) {
          WcPayCashierDetailItemLayout.this.oWU.setMaxWidth((int)localLayout.getLineWidth(0));
        }
        AppMethodBeat.o(71326);
      }
    });
    AppMethodBeat.o(71332);
  }
  
  public final void etX()
  {
    AppMethodBeat.i(71331);
    if (this.oWU.getVisibility() != 8) {
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(71325);
          int j = WcPayCashierDetailItemLayout.this.wMg.getWidth();
          int i = j;
          if (WcPayCashierDetailItemLayout.this.BKa.getVisibility() != 8) {
            i = j + WcPayCashierDetailItemLayout.BJY;
          }
          j = i;
          if (WcPayCashierDetailItemLayout.this.BKb.getVisibility() != 8) {
            j = i + WcPayCashierDetailItemLayout.BJZ;
          }
          i = WcPayCashierDetailItemLayout.orn;
          WcPayCashierDetailItemLayout.this.oWU.setMaxWidth(i - j);
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