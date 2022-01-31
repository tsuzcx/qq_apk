package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.plugin.topstory.ui.b.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.h;

public class g
  extends h
  implements a
{
  public e pHp;
  public FrameLayout pHq;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public void bNY()
  {
    if (this.pHp == null)
    {
      this.pHp = new e(this.pEP.bfn(), this.pEP, this);
      this.pHq.removeAllViews();
      if (!this.pEP.bNE()) {
        break label111;
      }
    }
    label111:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.pEP.bNz().x, this.pEP.bNz().y);; localLayoutParams = new FrameLayout.LayoutParams(this.pEP.bNz().y, this.pEP.bNz().x))
    {
      this.pHq.addView(this.pHp, localLayoutParams);
      this.pHp.a(this.pDy, bNr());
      return;
    }
  }
  
  public final f bNZ()
  {
    return this.pHp;
  }
  
  public final int bNr()
  {
    return id();
  }
  
  public final void dm(View paramView)
  {
    this.pHq = ((FrameLayout)paramView.findViewById(b.d.video_view_container));
  }
  
  public final void jJ(boolean paramBoolean)
  {
    super.jJ(paramBoolean);
    this.pEP.zx(id());
    if (this.pHp.jI(paramBoolean))
    {
      bNq();
      bNp();
    }
  }
  
  public final void zF(int paramInt)
  {
    a(this.pEP, this.pEP.bfn(), this.pHp, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */