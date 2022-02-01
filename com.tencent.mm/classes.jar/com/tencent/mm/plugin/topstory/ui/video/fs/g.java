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
  public e BOr;
  public FrameLayout BOs;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void TP(int paramInt)
  {
    AppMethodBeat.i(126328);
    a(this.BLL, this.BLL.dkN(), this.BOr, paramInt);
    AppMethodBeat.o(126328);
  }
  
  public void etN()
  {
    AppMethodBeat.i(126325);
    if (this.BOr == null)
    {
      if (!this.BLL.etp()) {
        break label133;
      }
      this.BOr = new k(this.BLL.dkN(), this.BLL, this);
      this.BOs.removeAllViews();
      if (!this.BLL.etp()) {
        break label161;
      }
    }
    label133:
    label161:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.BLL.etj().x, this.BLL.etj().y);; localLayoutParams = new FrameLayout.LayoutParams(this.BLL.etj().y, this.BLL.etj().x))
    {
      this.BOs.addView(this.BOr, localLayoutParams);
      this.BOr.a(this.BIY, etc());
      AppMethodBeat.o(126325);
      return;
      this.BOr = new e(this.BLL.dkN(), this.BLL, this);
      break;
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f etO()
  {
    return this.BOr;
  }
  
  public final int etc()
  {
    AppMethodBeat.i(224389);
    int i = lN();
    AppMethodBeat.o(224389);
    return i;
  }
  
  public final void fC(View paramView)
  {
    AppMethodBeat.i(126323);
    this.BOs = ((FrameLayout)paramView.findViewById(2131306411));
    AppMethodBeat.o(126323);
  }
  
  public final View getWowView()
  {
    AppMethodBeat.i(126327);
    View localView = this.BOr.getControlBar().getWowView();
    AppMethodBeat.o(126327);
    return localView;
  }
  
  public final void sQ(boolean paramBoolean)
  {
    AppMethodBeat.i(126324);
    super.sQ(paramBoolean);
    this.BLL.TF(lN());
    if (this.BOr.ap(paramBoolean, false))
    {
      etb();
      eta();
    }
    AppMethodBeat.o(126324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */