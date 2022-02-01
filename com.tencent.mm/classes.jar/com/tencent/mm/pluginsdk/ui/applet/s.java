package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.patmsg.a.c.a;

public final class s
{
  private final View.OnTouchListener YcM;
  int YcR;
  b YcS;
  boolean Ycd;
  r Yce;
  a Ycl;
  private int background;
  View.OnClickListener dpY;
  int index;
  boolean lAh;
  View rootView;
  int row;
  
  public s()
  {
    AppMethodBeat.i(152233);
    this.background = -1;
    this.YcM = new s.1(this);
    this.dpY = new s.2(this);
    AppMethodBeat.o(152233);
  }
  
  public static abstract interface a
  {
    public abstract void n(ViewGroup paramViewGroup, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean qy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s
 * JD-Core Version:    0.7.0.1
 */