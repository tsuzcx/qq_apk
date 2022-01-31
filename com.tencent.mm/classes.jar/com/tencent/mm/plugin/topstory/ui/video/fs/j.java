package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.topstory.ui.video.b;

public final class j
  extends g
{
  public j(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void bNY()
  {
    if (this.pHp == null)
    {
      this.pHp = new e(this.pEP.bfn(), this.pEP, this);
      this.pHp.setOnlyFS(true);
      this.pHq.removeAllViews();
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.pEP.bNz().x, this.pEP.bNz().y);
      this.pHq.addView(this.pHp, localLayoutParams);
    }
    this.pHp.a(this.pDy, bNr());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.j
 * JD-Core Version:    0.7.0.1
 */