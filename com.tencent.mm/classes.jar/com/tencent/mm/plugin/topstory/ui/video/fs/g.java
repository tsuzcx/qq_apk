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
  public e GoY;
  public FrameLayout GoZ;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void acf(int paramInt)
  {
    AppMethodBeat.i(126328);
    a(this.Gmr, this.Gmr.eeF(), this.GoY, paramInt);
    AppMethodBeat.o(126328);
  }
  
  public final void fU(View paramView)
  {
    AppMethodBeat.i(126323);
    this.GoZ = ((FrameLayout)paramView.findViewById(2131309842));
    AppMethodBeat.o(126323);
  }
  
  public final int fyz()
  {
    AppMethodBeat.i(258728);
    int i = lR();
    AppMethodBeat.o(258728);
    return i;
  }
  
  public void fzj()
  {
    AppMethodBeat.i(126325);
    if (this.GoY == null)
    {
      if (!this.Gmr.fyL()) {
        break label133;
      }
      this.GoY = new k(this.Gmr.eeF(), this.Gmr, this);
      this.GoZ.removeAllViews();
      if (!this.Gmr.fyL()) {
        break label161;
      }
    }
    label133:
    label161:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.Gmr.cZM().x, this.Gmr.cZM().y);; localLayoutParams = new FrameLayout.LayoutParams(this.Gmr.cZM().y, this.Gmr.cZM().x))
    {
      this.GoZ.addView(this.GoY, localLayoutParams);
      this.GoY.a(this.GjH, fyz());
      AppMethodBeat.o(126325);
      return;
      this.GoY = new e(this.Gmr.eeF(), this.Gmr, this);
      break;
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f fzk()
  {
    return this.GoY;
  }
  
  public final View getWowView()
  {
    AppMethodBeat.i(126327);
    View localView = this.GoY.getControlBar().getWowView();
    AppMethodBeat.o(126327);
    return localView;
  }
  
  public final void wu(boolean paramBoolean)
  {
    AppMethodBeat.i(126324);
    super.wu(paramBoolean);
    this.Gmr.abV(lR());
    if (this.GoY.ay(paramBoolean, false))
    {
      fyy();
      fyx();
    }
    AppMethodBeat.o(126324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */