package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.h;

public class g
  extends h
  implements a
{
  public e tkK;
  public FrameLayout tkL;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void GL(int paramInt)
  {
    AppMethodBeat.i(1950);
    a(this.tim, this.tim.bMN(), this.tkK, paramInt);
    AppMethodBeat.o(1950);
  }
  
  public void cJL()
  {
    AppMethodBeat.i(1947);
    if (this.tkK == null)
    {
      if (!this.tim.cJn()) {
        break label135;
      }
      this.tkK = new k(this.tim.bMN(), this.tim, this);
      this.tkL.removeAllViews();
      if (!this.tim.cJn()) {
        break label163;
      }
    }
    label135:
    label163:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.tim.cJi().x, this.tim.cJi().y);; localLayoutParams = new FrameLayout.LayoutParams(this.tim.cJi().y, this.tim.cJi().x))
    {
      this.tkL.addView(this.tkK, localLayoutParams);
      this.tkK.a(this.tfm, cJb());
      AppMethodBeat.o(1947);
      return;
      this.tkK = new e(this.tim.bMN(), this.tim, this);
      break;
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f cJM()
  {
    return this.tkK;
  }
  
  public final int cJb()
  {
    AppMethodBeat.i(156796);
    int i = jN();
    AppMethodBeat.o(156796);
    return i;
  }
  
  public final void ep(View paramView)
  {
    AppMethodBeat.i(1945);
    this.tkL = ((FrameLayout)paramView.findViewById(2131828187));
    AppMethodBeat.o(1945);
  }
  
  public final View getWowView()
  {
    AppMethodBeat.i(1949);
    View localView = this.tkK.getControlBar().getWowView();
    AppMethodBeat.o(1949);
    return localView;
  }
  
  public final void mA(boolean paramBoolean)
  {
    AppMethodBeat.i(1946);
    super.mA(paramBoolean);
    this.tim.GA(jN());
    if (this.tkK.Q(paramBoolean, false))
    {
      cJa();
      cIZ();
    }
    AppMethodBeat.o(1946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */