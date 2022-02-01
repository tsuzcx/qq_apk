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
  public e NbK;
  public FrameLayout NbL;
  
  public g(View paramView, b paramb)
  {
    super(paramView, paramb);
  }
  
  public final void Ah(boolean paramBoolean)
  {
    AppMethodBeat.i(126324);
    super.Ah(paramBoolean);
    this.MZd.ajB(md());
    if (this.NbK.aL(paramBoolean, false))
    {
      gqv();
      gqu();
    }
    AppMethodBeat.o(126324);
  }
  
  public final void ajL(int paramInt)
  {
    AppMethodBeat.i(126328);
    a(this.MZd, this.MZd.eOa(), this.NbK, paramInt);
    AppMethodBeat.o(126328);
  }
  
  public final View getWowView()
  {
    AppMethodBeat.i(126327);
    View localView = this.NbK.getControlBar().getWowView();
    AppMethodBeat.o(126327);
    return localView;
  }
  
  public final int gqw()
  {
    AppMethodBeat.i(292762);
    int i = md();
    AppMethodBeat.o(292762);
    return i;
  }
  
  public void gri()
  {
    AppMethodBeat.i(126325);
    if (this.NbK == null)
    {
      if (!this.MZd.gqI()) {
        break label133;
      }
      this.NbK = new k(this.MZd.eOa(), this.MZd, this);
      this.NbL.removeAllViews();
      if (!this.MZd.gqI()) {
        break label161;
      }
    }
    label133:
    label161:
    for (FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(this.MZd.dpI().x, this.MZd.dpI().y);; localLayoutParams = new FrameLayout.LayoutParams(this.MZd.dpI().y, this.MZd.dpI().x))
    {
      this.NbL.addView(this.NbK, localLayoutParams);
      this.NbK.a(this.MWs, gqw());
      AppMethodBeat.o(126325);
      return;
      this.NbK = new e(this.MZd.eOa(), this.MZd, this);
      break;
    }
  }
  
  public final com.tencent.mm.plugin.topstory.ui.video.f grj()
  {
    return this.NbK;
  }
  
  public final void hd(View paramView)
  {
    AppMethodBeat.i(126323);
    this.NbL = ((FrameLayout)paramView.findViewById(c.d.video_view_container));
    AppMethodBeat.o(126323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.g
 * JD-Core Version:    0.7.0.1
 */