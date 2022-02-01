package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.c.d;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.h;

public class g
  extends h
  implements a
{
  public e TOt;
  public FrameLayout TOu;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void FD(boolean paramBoolean)
  {
    AppMethodBeat.i(126324);
    super.FD(paramBoolean);
    this.TLM.aoU(KJ());
    if (this.TOt.bi(paramBoolean, false))
    {
      hNu();
      hNt();
    }
    AppMethodBeat.o(126324);
  }
  
  public final void ape(int paramInt)
  {
    AppMethodBeat.i(126328);
    a(this.TLM, this.TLM.fWt(), this.TOt, paramInt);
    AppMethodBeat.o(126328);
  }
  
  public final View getWowView()
  {
    AppMethodBeat.i(126327);
    View localView = this.TOt.getControlBar().getWowView();
    AppMethodBeat.o(126327);
    return localView;
  }
  
  public final int hNv()
  {
    AppMethodBeat.i(369748);
    int i = KJ();
    AppMethodBeat.o(369748);
    return i;
  }
  
  public void hOh()
  {
    AppMethodBeat.i(126325);
    if (this.TOt == null)
    {
      if (!this.TLM.hNH()) {
        break label133;
      }
      this.TOt = new k(this.TLM.fWt(), this.TLM, this);
      this.TOu.removeAllViews();
      if (!this.TLM.hNH()) {
        break label161;
      }
    }
    label133:
    label161:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.TLM.dXX().x, this.TLM.dXX().y);; localLayoutParams = new FrameLayout.LayoutParams(this.TLM.dXX().y, this.TLM.dXX().x))
    {
      this.TOu.addView(this.TOt, localLayoutParams);
      this.TOt.a(this.TIW, hNv());
      AppMethodBeat.o(126325);
      return;
      this.TOt = new e(this.TLM.fWt(), this.TLM, this);
      break;
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f hOi()
  {
    return this.TOt;
  }
  
  public final void ko(View paramView)
  {
    AppMethodBeat.i(126323);
    this.TOu = ((FrameLayout)paramView.findViewById(c.d.video_view_container));
    AppMethodBeat.o(126323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */