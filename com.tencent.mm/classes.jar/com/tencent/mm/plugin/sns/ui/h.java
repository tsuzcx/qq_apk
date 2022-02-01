package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends LinearLayout
{
  private Context context;
  private int nts;
  private int yxN;
  private LinearLayout yxO;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97792);
    this.nts = 0;
    this.yxN = 6;
    this.context = paramContext;
    setOrientation(1);
    AppMethodBeat.o(97792);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(97793);
    if (this.nts % this.yxN == 0)
    {
      this.yxO = new LinearLayout(this.context);
      this.yxO.setOrientation(0);
      this.yxO.addView(paramView);
      super.addView(this.yxO);
    }
    for (;;)
    {
      this.nts += 1;
      AppMethodBeat.o(97793);
      return;
      this.yxO.addView(paramView);
    }
  }
  
  public final void setLineMaxCounte(int paramInt)
  {
    if (paramInt > 0) {
      this.yxN = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.h
 * JD-Core Version:    0.7.0.1
 */