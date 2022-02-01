package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends LinearLayout
{
  private int Rbt;
  private LinearLayout Rbu;
  private int cYv;
  private Context context;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97792);
    this.cYv = 0;
    this.Rbt = 6;
    this.context = paramContext;
    setOrientation(1);
    AppMethodBeat.o(97792);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(97793);
    if (this.cYv % this.Rbt == 0)
    {
      this.Rbu = new LinearLayout(this.context);
      this.Rbu.setOrientation(0);
      this.Rbu.addView(paramView);
      super.addView(this.Rbu);
    }
    for (;;)
    {
      this.cYv += 1;
      AppMethodBeat.o(97793);
      return;
      this.Rbu.addView(paramView);
    }
  }
  
  public final void setLineMaxCounte(int paramInt)
  {
    if (paramInt > 0) {
      this.Rbt = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.h
 * JD-Core Version:    0.7.0.1
 */