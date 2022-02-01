package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;

public final class j
  extends g
{
  public j(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void dPo()
  {
    AppMethodBeat.i(126398);
    if (this.yRs == null)
    {
      this.yRs = new k(this.yOL.cKW(), this.yOL, this);
      this.yRt.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.yOL.dOK().x, this.yOL.dOK().y);
      this.yRt.addView(this.yRs, localLayoutParams);
    }
    this.yRs.a(this.yLU, dOD());
    AppMethodBeat.o(126398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.j
 * JD-Core Version:    0.7.0.1
 */