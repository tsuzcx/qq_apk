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
  
  public final void fzj()
  {
    AppMethodBeat.i(126398);
    if (this.GoY == null)
    {
      this.GoY = new k(this.Gmr.eeF(), this.Gmr, this);
      this.GoZ.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.Gmr.cZM().x, this.Gmr.cZM().y);
      this.GoZ.addView(this.GoY, localLayoutParams);
    }
    this.GoY.a(this.GjH, fyz());
    AppMethodBeat.o(126398);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.j
 * JD-Core Version:    0.7.0.1
 */