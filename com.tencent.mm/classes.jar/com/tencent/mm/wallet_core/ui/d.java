package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

public class d
  implements View.OnClickListener
{
  private long gZf = 0L;
  private View.OnClickListener nuB;
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.gZf >= 500L)
    {
      this.nuB.onClick(paramView);
      this.gZf = l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.d
 * JD-Core Version:    0.7.0.1
 */