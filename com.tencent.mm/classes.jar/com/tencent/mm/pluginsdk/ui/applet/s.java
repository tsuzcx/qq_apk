package com.tencent.mm.pluginsdk.ui.applet;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
{
  r DqY;
  private final View.OnTouchListener DrF;
  int DrK;
  b DrL;
  a Dre;
  private int background;
  boolean ftK;
  int index;
  View.OnClickListener iu;
  int row;
  
  public s()
  {
    AppMethodBeat.i(152233);
    this.background = -1;
    this.DrF = new s.1(this);
    this.iu = new s.2(this);
    AppMethodBeat.o(152233);
  }
  
  public static abstract interface a
  {
    public abstract void e(ViewGroup paramViewGroup, View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean kF(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s
 * JD-Core Version:    0.7.0.1
 */