package com.tencent.mm.plugin.voip.ui;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

public final class d$c
{
  am fjC = new am(new am.a()
  {
    public final boolean tC()
    {
      int i = d.c.this.pXd[(d.c.this.pXf % d.c.this.pXd.length)];
      if (d.c.this.lh != null)
      {
        if (-1 != i) {
          break label68;
        }
        d.c.this.lh.setText(null);
      }
      for (;;)
      {
        d.c localc = d.c.this;
        localc.pXf += 1;
        return true;
        label68:
        d.c.this.lh.setText(i);
      }
    }
  }, true);
  TextView lh;
  int[] pXd;
  private int pXe;
  int pXf;
  
  public final void a(TextView paramTextView, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramTextView == null))
    {
      y.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
      return;
    }
    bSc();
    this.pXf = 0;
    this.pXd = paramArrayOfInt;
    this.lh = paramTextView;
    this.pXe = 500;
    if (this.fjC != null)
    {
      paramArrayOfInt = this.fjC;
      long l = this.pXe;
      paramArrayOfInt.S(l, l);
    }
    y.b("MicroMsg.DynamicTextWrap", "start textview:" + paramTextView, new Object[0]);
  }
  
  public final void bSc()
  {
    if (this.fjC != null) {
      this.fjC.stopTimer();
    }
    y.b("MicroMsg.DynamicTextWrap", "stop textview: " + this.lh, new Object[0]);
    this.lh = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.d.c
 * JD-Core Version:    0.7.0.1
 */