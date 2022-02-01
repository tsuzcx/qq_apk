package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
  extends LinearLayout
{
  private Context context;
  private int mRc;
  private int xkV;
  private LinearLayout xkW;
  
  public h(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(97792);
    this.mRc = 0;
    this.xkV = 6;
    this.context = paramContext;
    setOrientation(1);
    AppMethodBeat.o(97792);
  }
  
  public final void addView(View paramView)
  {
    AppMethodBeat.i(97793);
    if (this.mRc % this.xkV == 0)
    {
      this.xkW = new LinearLayout(this.context);
      this.xkW.setOrientation(0);
      this.xkW.addView(paramView);
      super.addView(this.xkW);
    }
    for (;;)
    {
      this.mRc += 1;
      AppMethodBeat.o(97793);
      return;
      this.xkW.addView(paramView);
    }
  }
  
  public final void setLineMaxCounte(int paramInt)
  {
    if (paramInt > 0) {
      this.xkV = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.h
 * JD-Core Version:    0.7.0.1
 */