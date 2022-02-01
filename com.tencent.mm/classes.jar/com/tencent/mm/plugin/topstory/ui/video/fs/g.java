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
  public e BwT;
  public FrameLayout BwU;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void Ti(int paramInt)
  {
    AppMethodBeat.i(126328);
    a(this.Bun, this.Bun.dhO(), this.BwT, paramInt);
    AppMethodBeat.o(126328);
  }
  
  public final int epv()
  {
    AppMethodBeat.i(221365);
    int i = lN();
    AppMethodBeat.o(221365);
    return i;
  }
  
  public void eqg()
  {
    AppMethodBeat.i(126325);
    if (this.BwT == null)
    {
      if (!this.Bun.epI()) {
        break label133;
      }
      this.BwT = new k(this.Bun.dhO(), this.Bun, this);
      this.BwU.removeAllViews();
      if (!this.Bun.epI()) {
        break label161;
      }
    }
    label133:
    label161:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.Bun.epC().x, this.Bun.epC().y);; localLayoutParams = new FrameLayout.LayoutParams(this.Bun.epC().y, this.Bun.epC().x))
    {
      this.BwU.addView(this.BwT, localLayoutParams);
      this.BwT.a(this.Brz, epv());
      AppMethodBeat.o(126325);
      return;
      this.BwT = new e(this.Bun.dhO(), this.Bun, this);
      break;
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f eqh()
  {
    return this.BwT;
  }
  
  public final void fD(View paramView)
  {
    AppMethodBeat.i(126323);
    this.BwU = ((FrameLayout)paramView.findViewById(2131306411));
    AppMethodBeat.o(126323);
  }
  
  public final View getWowView()
  {
    AppMethodBeat.i(126327);
    View localView = this.BwT.getControlBar().getWowView();
    AppMethodBeat.o(126327);
    return localView;
  }
  
  public final void sJ(boolean paramBoolean)
  {
    AppMethodBeat.i(126324);
    super.sJ(paramBoolean);
    this.Bun.SY(lN());
    if (this.BwT.aq(paramBoolean, false))
    {
      epu();
      ept();
    }
    AppMethodBeat.o(126324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */