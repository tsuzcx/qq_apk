package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends LinearLayout
{
  private Context context;
  private int nUo;
  private int zOZ;
  private LinearLayout zPa;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97792);
    this.nUo = 0;
    this.zOZ = 6;
    this.context = paramContext;
    setOrientation(1);
    AppMethodBeat.o(97792);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(97793);
    if (this.nUo % this.zOZ == 0)
    {
      this.zPa = new LinearLayout(this.context);
      this.zPa.setOrientation(0);
      this.zPa.addView(paramView);
      super.addView(this.zPa);
    }
    for (;;)
    {
      this.nUo += 1;
      AppMethodBeat.o(97793);
      return;
      this.zPa.addView(paramView);
    }
  }
  
  public final void setLineMaxCounte(int paramInt)
  {
    if (paramInt > 0) {
      this.zOZ = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.h
 * JD-Core Version:    0.7.0.1
 */