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
  public e yRs;
  public FrameLayout yRt;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void Ps(int paramInt)
  {
    AppMethodBeat.i(126328);
    a(this.yOL, this.yOL.cKW(), this.yRs, paramInt);
    AppMethodBeat.o(126328);
  }
  
  public final int dOD()
  {
    AppMethodBeat.i(202284);
    int i = ln();
    AppMethodBeat.o(202284);
    return i;
  }
  
  public void dPo()
  {
    AppMethodBeat.i(126325);
    if (this.yRs == null)
    {
      if (!this.yOL.dOQ()) {
        break label133;
      }
      this.yRs = new k(this.yOL.cKW(), this.yOL, this);
      this.yRt.removeAllViews();
      if (!this.yOL.dOQ()) {
        break label161;
      }
    }
    label133:
    label161:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.yOL.dOK().x, this.yOL.dOK().y);; localLayoutParams = new FrameLayout.LayoutParams(this.yOL.dOK().y, this.yOL.dOK().x))
    {
      this.yRt.addView(this.yRs, localLayoutParams);
      this.yRs.a(this.yLU, dOD());
      AppMethodBeat.o(126325);
      return;
      this.yRs = new e(this.yOL.cKW(), this.yOL, this);
      break;
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f dPp()
  {
    return this.yRs;
  }
  
  public final void fd(View paramView)
  {
    AppMethodBeat.i(126323);
    this.yRt = ((FrameLayout)paramView.findViewById(2131306411));
    AppMethodBeat.o(126323);
  }
  
  public final View getWowView()
  {
    AppMethodBeat.i(126327);
    View localView = this.yRs.getControlBar().getWowView();
    AppMethodBeat.o(126327);
    return localView;
  }
  
  public final void rf(boolean paramBoolean)
  {
    AppMethodBeat.i(126324);
    super.rf(paramBoolean);
    this.yOL.Pi(ln());
    if (this.yRs.aj(paramBoolean, false))
    {
      dOC();
      dOB();
    }
    AppMethodBeat.o(126324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */