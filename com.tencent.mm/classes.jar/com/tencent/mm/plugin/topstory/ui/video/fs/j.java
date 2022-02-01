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
  
  public final void edO()
  {
    AppMethodBeat.i(126398);
    if (this.Afh == null)
    {
      this.Afh = new k(this.AcC.cYC(), this.AcC, this);
      this.Afi.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.AcC.edk().x, this.AcC.edk().y);
      this.Afi.addView(this.Afh, localLayoutParams);
    }
    this.Afh.a(this.zZN, edd());
    AppMethodBeat.o(126398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.j
 * JD-Core Version:    0.7.0.1
 */