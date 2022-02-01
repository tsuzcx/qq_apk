package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends LinearLayout
{
  private int EoC;
  private LinearLayout EoD;
  private int bva;
  private Context context;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97792);
    this.bva = 0;
    this.EoC = 6;
    this.context = paramContext;
    setOrientation(1);
    AppMethodBeat.o(97792);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(97793);
    if (this.bva % this.EoC == 0)
    {
      this.EoD = new LinearLayout(this.context);
      this.EoD.setOrientation(0);
      this.EoD.addView(paramView);
      super.addView(this.EoD);
    }
    for (;;)
    {
      this.bva += 1;
      AppMethodBeat.o(97793);
      return;
      this.EoD.addView(paramView);
    }
  }
  
  public final void setLineMaxCounte(int paramInt)
  {
    if (paramInt > 0) {
      this.EoC = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.h
 * JD-Core Version:    0.7.0.1
 */