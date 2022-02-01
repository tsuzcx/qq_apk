package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends LinearLayout
{
  private int Agg;
  private LinearLayout Agh;
  private Context context;
  private int nZU;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97792);
    this.nZU = 0;
    this.Agg = 6;
    this.context = paramContext;
    setOrientation(1);
    AppMethodBeat.o(97792);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(97793);
    if (this.nZU % this.Agg == 0)
    {
      this.Agh = new LinearLayout(this.context);
      this.Agh.setOrientation(0);
      this.Agh.addView(paramView);
      super.addView(this.Agh);
    }
    for (;;)
    {
      this.nZU += 1;
      AppMethodBeat.o(97793);
      return;
      this.Agh.addView(paramView);
    }
  }
  
  public final void setLineMaxCounte(int paramInt)
  {
    if (paramInt > 0) {
      this.Agg = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.h
 * JD-Core Version:    0.7.0.1
 */