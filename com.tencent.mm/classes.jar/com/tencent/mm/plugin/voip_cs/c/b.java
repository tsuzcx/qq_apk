package com.tencent.mm.plugin.voip_cs.c;

import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public am fjC = new am(new b.1(this), true);
  public TextView lh;
  public int[] pXd;
  public int pXe;
  public int pXf;
  
  public final void bSc()
  {
    if (this.fjC != null) {
      this.fjC.stopTimer();
    }
    y.b("MicroMsg.DynamicTextWrap", "stop textview: " + this.lh, new Object[0]);
    this.lh = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.b
 * JD-Core Version:    0.7.0.1
 */