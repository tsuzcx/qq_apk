package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;

public final class h
  extends LinearLayout
{
  private Context context;
  private int hYe = 0;
  private LinearLayout oNA;
  private int oNz = 6;
  
  public h(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    setOrientation(1);
  }
  
  public final void addView(View paramView)
  {
    if (this.hYe % this.oNz == 0)
    {
      this.oNA = new LinearLayout(this.context);
      this.oNA.setOrientation(0);
      this.oNA.addView(paramView);
      super.addView(this.oNA);
    }
    for (;;)
    {
      this.hYe += 1;
      return;
      this.oNA.addView(paramView);
    }
  }
  
  public final void setLineMaxCounte(int paramInt)
  {
    this.oNz = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.h
 * JD-Core Version:    0.7.0.1
 */