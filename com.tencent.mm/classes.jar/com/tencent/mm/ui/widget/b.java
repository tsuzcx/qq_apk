package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.aj;

public final class b
{
  private a IZd;
  private boolean IZe;
  private int IZf;
  private int IZg;
  private int IZh;
  public boolean IZi;
  Runnable IZj;
  Runnable IZk;
  private Rect fWY;
  private int maxHeight;
  private int ngo;
  private View view;
  
  public b(View paramView, a parama)
  {
    AppMethodBeat.i(143328);
    this.fWY = new Rect();
    this.IZe = false;
    this.IZi = false;
    this.view = paramView;
    this.IZd = parama;
    this.IZh = aj.ej(paramView.getContext());
    this.ngo = y.iw(paramView.getContext());
    AppMethodBeat.o(143328);
  }
  
  private boolean fuB()
  {
    AppMethodBeat.i(143332);
    boolean bool = y.iA(this.view.getContext());
    AppMethodBeat.o(143332);
    return bool;
  }
  
  private boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(143333);
    if ((d.kZ(24)) && ((this.view.getContext() instanceof Activity)))
    {
      boolean bool = ((Activity)this.view.getContext()).isInMultiWindowMode();
      AppMethodBeat.o(143333);
      return bool;
    }
    AppMethodBeat.o(143333);
    return false;
  }
  
  public final void aL(Runnable paramRunnable)
  {
    AppMethodBeat.i(143330);
    this.IZj = paramRunnable;
    this.IZk = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143326);
        if (b.this.IZj != null)
        {
          ac.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
          b.this.IZj.run();
          b.this.IZj = null;
        }
        AppMethodBeat.o(143326);
      }
    }, 200L);
    AppMethodBeat.o(143330);
  }
  
  public final void aM(Runnable paramRunnable)
  {
    AppMethodBeat.i(143331);
    this.IZk = paramRunnable;
    this.IZj = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143327);
        if (b.this.IZk != null)
        {
          ac.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
          b.this.IZk.run();
          b.this.IZk = null;
        }
        AppMethodBeat.o(143327);
      }
    }, 200L);
    AppMethodBeat.o(143331);
  }
  
  public final void acB(int paramInt)
  {
    AppMethodBeat.i(143329);
    if ((!fuB()) || (isInMultiWindowMode()))
    {
      ac.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
      AppMethodBeat.o(143329);
      return;
    }
    int i = this.IZf;
    int j = this.fWY.bottom;
    this.IZf = View.MeasureSpec.getSize(paramInt);
    this.view.getWindowVisibleDisplayFrame(this.fWY);
    boolean bool;
    if (!this.IZe)
    {
      if (j != this.fWY.bottom)
      {
        bool = true;
        this.IZe = bool;
      }
    }
    else
    {
      this.IZg = this.fWY.bottom;
      if (this.IZg > this.maxHeight - this.IZh) {
        this.maxHeight = this.IZg;
      }
      paramInt = this.maxHeight - this.IZg;
      if (paramInt <= this.IZh) {
        break label298;
      }
      bool = true;
      label147:
      if (bool) {
        this.ngo = paramInt;
      }
      if ((this.IZe) && (bool != this.IZi))
      {
        if (paramInt != this.IZh) {
          break label304;
        }
        this.IZd.g(false, this.ngo - paramInt);
      }
    }
    for (;;)
    {
      this.IZi = bool;
      if (((!this.IZe) || (i <= this.IZf + this.IZh)) && (i >= this.IZf - this.IZh)) {
        break label343;
      }
      ac.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", new Object[] { Boolean.valueOf(bool) });
      this.IZe = false;
      if (!bool) {
        break label322;
      }
      if (this.IZj == null) {
        break label343;
      }
      this.IZj.run();
      this.IZj = null;
      AppMethodBeat.o(143329);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label147;
      label304:
      this.IZd.g(bool, this.ngo);
    }
    label322:
    if (this.IZk != null)
    {
      this.IZk.run();
      this.IZk = null;
    }
    label343:
    AppMethodBeat.o(143329);
  }
  
  public static abstract interface a
  {
    public abstract void g(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */