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
  public e Afh;
  public FrameLayout Afi;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void Ry(int paramInt)
  {
    AppMethodBeat.i(126328);
    a(this.AcC, this.AcC.cYC(), this.Afh, paramInt);
    AppMethodBeat.o(126328);
  }
  
  public void edO()
  {
    AppMethodBeat.i(126325);
    if (this.Afh == null)
    {
      if (!this.AcC.edq()) {
        break label133;
      }
      this.Afh = new k(this.AcC.cYC(), this.AcC, this);
      this.Afi.removeAllViews();
      if (!this.AcC.edq()) {
        break label161;
      }
    }
    label133:
    label161:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.AcC.edk().x, this.AcC.edk().y);; localLayoutParams = new FrameLayout.LayoutParams(this.AcC.edk().y, this.AcC.edk().x))
    {
      this.Afi.addView(this.Afh, localLayoutParams);
      this.Afh.a(this.zZN, edd());
      AppMethodBeat.o(126325);
      return;
      this.Afh = new e(this.AcC.cYC(), this.AcC, this);
      break;
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f edP()
  {
    return this.Afh;
  }
  
  public final int edd()
  {
    AppMethodBeat.i(210287);
    int i = lv();
    AppMethodBeat.o(210287);
    return i;
  }
  
  public final void fq(View paramView)
  {
    AppMethodBeat.i(126323);
    this.Afi = ((FrameLayout)paramView.findViewById(2131306411));
    AppMethodBeat.o(126323);
  }
  
  public final View getWowView()
  {
    AppMethodBeat.i(126327);
    View localView = this.Afh.getControlBar().getWowView();
    AppMethodBeat.o(126327);
    return localView;
  }
  
  public final void sd(boolean paramBoolean)
  {
    AppMethodBeat.i(126324);
    super.sd(paramBoolean);
    this.AcC.Ro(lv());
    if (this.Afh.am(paramBoolean, false))
    {
      edc();
      edb();
    }
    AppMethodBeat.o(126324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */