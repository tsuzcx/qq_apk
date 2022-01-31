package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends LinearLayout
{
  private Context context;
  private int jRS;
  private int rFi;
  private LinearLayout rFj;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(38162);
    this.jRS = 0;
    this.rFi = 6;
    this.context = paramContext;
    setOrientation(1);
    AppMethodBeat.o(38162);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(38163);
    if (this.jRS % this.rFi == 0)
    {
      this.rFj = new LinearLayout(this.context);
      this.rFj.setOrientation(0);
      this.rFj.addView(paramView);
      super.addView(this.rFj);
    }
    for (;;)
    {
      this.jRS += 1;
      AppMethodBeat.o(38163);
      return;
      this.rFj.addView(paramView);
    }
  }
  
  public final void setLineMaxCounte(int paramInt)
  {
    if (paramInt > 0) {
      this.rFi = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.h
 * JD-Core Version:    0.7.0.1
 */