package com.tencent.mm.pluginsdk.ui.applet;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class s
{
  r BYH;
  a BYN;
  private final View.OnTouchListener BZo;
  int BZt;
  b BZu;
  private int background;
  boolean fqg;
  View.OnClickListener hs;
  int index;
  int row;
  
  public s()
  {
    AppMethodBeat.i(152233);
    this.background = -1;
    this.BZo = new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    };
    this.hs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(152230);
        AppMethodBeat.o(152230);
      }
    };
    AppMethodBeat.o(152233);
  }
  
  public static abstract interface a
  {
    public abstract void e(ViewGroup paramViewGroup, View paramView, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract boolean kL(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.s
 * JD-Core Version:    0.7.0.1
 */