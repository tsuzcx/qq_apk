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
  
  public final void etN()
  {
    AppMethodBeat.i(126398);
    if (this.BOr == null)
    {
      this.BOr = new k(this.BLL.dkN(), this.BLL, this);
      this.BOs.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.BLL.etj().x, this.BLL.etj().y);
      this.BOs.addView(this.BOr, localLayoutParams);
    }
    this.BOr.a(this.BIY, etc());
    AppMethodBeat.o(126398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.j
 * JD-Core Version:    0.7.0.1
 */