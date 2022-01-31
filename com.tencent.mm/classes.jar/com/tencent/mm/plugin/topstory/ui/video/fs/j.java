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
  
  public final void cJL()
  {
    AppMethodBeat.i(2012);
    if (this.tkK == null)
    {
      this.tkK = new k(this.tim.bMN(), this.tim, this);
      this.tkK.setOnlyFS(true);
      this.tkL.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.tim.cJi().x, this.tim.cJi().y);
      this.tkL.addView(this.tkK, localLayoutParams);
    }
    this.tkK.a(this.tfm, cJb());
    AppMethodBeat.o(2012);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.j
 * JD-Core Version:    0.7.0.1
 */