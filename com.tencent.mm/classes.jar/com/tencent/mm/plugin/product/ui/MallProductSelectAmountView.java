package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MallProductSelectAmountView
  extends LinearLayout
{
  private TextView gpq;
  private ImageView pwl;
  private ImageView pwm;
  private int pwn;
  private int pwo;
  private int pwp;
  private int pwq;
  private MallProductSelectAmountView.a pwr;
  
  public MallProductSelectAmountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(44097);
    this.gpq = null;
    this.pwl = null;
    this.pwm = null;
    this.pwn = 2147483647;
    this.pwo = 1;
    this.pwp = 1;
    this.pwq = this.pwp;
    this.pwr = null;
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2130970452, this, true);
    this.gpq = ((TextView)paramContext.findViewById(2131826800));
    this.pwl = ((ImageView)paramContext.findViewById(2131826801));
    this.pwm = ((ImageView)paramContext.findViewById(2131826799));
    this.gpq.setText(this.pwq);
    this.pwl.setOnClickListener(new MallProductSelectAmountView.1(this));
    this.pwm.setOnClickListener(new MallProductSelectAmountView.2(this));
    AppMethodBeat.o(44097);
  }
  
  private boolean cbw()
  {
    AppMethodBeat.i(44099);
    if (this.pwq > this.pwn)
    {
      this.pwq = this.pwn;
      if (this.pwr != null) {
        this.pwr.gz(this.pwq);
      }
      if (this.pwr != null) {
        this.pwr.fi(this.pwq, this.pwo);
      }
      this.gpq.setText(this.pwq);
      AppMethodBeat.o(44099);
      return false;
    }
    if (this.pwq > this.pwp) {
      this.pwm.setEnabled(true);
    }
    for (;;)
    {
      AppMethodBeat.o(44099);
      return true;
      if (this.pwq != this.pwp) {
        break;
      }
      this.pwm.setEnabled(false);
    }
    this.pwm.setEnabled(false);
    this.pwq = this.pwp;
    if (this.pwr != null) {
      this.pwr.gz(this.pwq);
    }
    if (this.pwr != null) {
      this.pwr.fi(this.pwq, 2);
    }
    this.gpq.setText(this.pwq);
    AppMethodBeat.o(44099);
    return false;
  }
  
  public final void fh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(44102);
    if (paramInt1 > paramInt2) {
      this.pwo = 3;
    }
    for (this.pwn = paramInt2;; this.pwn = paramInt1)
    {
      cbw();
      if (this.pwr != null) {
        this.pwr.gz(this.pwq);
      }
      AppMethodBeat.o(44102);
      return;
      this.pwo = 1;
    }
  }
  
  public void setAddEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(44100);
    this.pwl.setEnabled(paramBoolean);
    AppMethodBeat.o(44100);
  }
  
  public void setAmount(int paramInt)
  {
    AppMethodBeat.i(44098);
    this.pwq = paramInt;
    if (cbw())
    {
      this.gpq.setText(this.pwq);
      if (this.pwr != null) {
        this.pwr.gz(this.pwq);
      }
    }
    AppMethodBeat.o(44098);
  }
  
  public void setMinAmount(int paramInt)
  {
    AppMethodBeat.i(44103);
    this.pwp = paramInt;
    cbw();
    AppMethodBeat.o(44103);
  }
  
  public void setOnAmountChangeListener(MallProductSelectAmountView.a parama)
  {
    this.pwr = parama;
  }
  
  public void setRemoveEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(44101);
    this.pwm.setEnabled(paramBoolean);
    AppMethodBeat.o(44101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.product.ui.MallProductSelectAmountView
 * JD-Core Version:    0.7.0.1
 */