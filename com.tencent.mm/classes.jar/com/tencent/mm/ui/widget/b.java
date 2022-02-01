package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.al;

public final class b
{
  public boolean KMi;
  private a LmH;
  private Rect LmI;
  private boolean LmJ;
  private int LmK;
  private int LmL;
  private int LmM;
  Runnable LmN;
  Runnable LmO;
  private int maxHeight;
  private int nMm;
  private View view;
  
  public b(View paramView, a parama)
  {
    AppMethodBeat.i(143328);
    this.LmI = new Rect();
    this.LmJ = false;
    this.KMi = false;
    this.view = paramView;
    this.LmH = parama;
    this.LmM = al.en(paramView.getContext());
    this.nMm = aa.iL(paramView.getContext());
    AppMethodBeat.o(143328);
  }
  
  private boolean fPH()
  {
    AppMethodBeat.i(143332);
    boolean bool = aa.iP(this.view.getContext());
    AppMethodBeat.o(143332);
    return bool;
  }
  
  private boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(143333);
    if ((d.lA(24)) && ((this.view.getContext() instanceof Activity)))
    {
      boolean bool = ((Activity)this.view.getContext()).isInMultiWindowMode();
      AppMethodBeat.o(143333);
      return bool;
    }
    AppMethodBeat.o(143333);
    return false;
  }
  
  public final void aH(Runnable paramRunnable)
  {
    AppMethodBeat.i(143330);
    this.LmN = paramRunnable;
    this.LmO = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143326);
        if (b.this.LmN != null)
        {
          ae.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
          b.this.LmN.run();
          b.this.LmN = null;
        }
        AppMethodBeat.o(143326);
      }
    }, 200L);
    AppMethodBeat.o(143330);
  }
  
  public final void aI(Runnable paramRunnable)
  {
    AppMethodBeat.i(143331);
    this.LmO = paramRunnable;
    this.LmN = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143327);
        if (b.this.LmO != null)
        {
          ae.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
          b.this.LmO.run();
          b.this.LmO = null;
        }
        AppMethodBeat.o(143327);
      }
    }, 200L);
    AppMethodBeat.o(143331);
  }
  
  public final void afH(int paramInt)
  {
    AppMethodBeat.i(143329);
    if ((!fPH()) || (isInMultiWindowMode()))
    {
      ae.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
      AppMethodBeat.o(143329);
      return;
    }
    int i = this.LmK;
    int j = this.LmI.bottom;
    this.LmK = View.MeasureSpec.getSize(paramInt);
    this.view.getWindowVisibleDisplayFrame(this.LmI);
    boolean bool;
    if (!this.LmJ)
    {
      if (j != this.LmI.bottom)
      {
        bool = true;
        this.LmJ = bool;
      }
    }
    else
    {
      this.LmL = this.LmI.bottom;
      if (this.LmL > this.maxHeight - this.LmM) {
        this.maxHeight = this.LmL;
      }
      paramInt = this.maxHeight - this.LmL;
      if (paramInt <= this.LmM) {
        break label298;
      }
      bool = true;
      label147:
      if (bool) {
        this.nMm = paramInt;
      }
      if ((this.LmJ) && (bool != this.KMi))
      {
        if (paramInt != this.LmM) {
          break label304;
        }
        this.LmH.g(false, this.nMm - paramInt);
      }
    }
    for (;;)
    {
      this.KMi = bool;
      if (((!this.LmJ) || (i <= this.LmK + this.LmM)) && (i >= this.LmK - this.LmM)) {
        break label343;
      }
      ae.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", new Object[] { Boolean.valueOf(bool) });
      this.LmJ = false;
      if (!bool) {
        break label322;
      }
      if (this.LmN == null) {
        break label343;
      }
      this.LmN.run();
      this.LmN = null;
      AppMethodBeat.o(143329);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label147;
      label304:
      this.LmH.g(bool, this.nMm);
    }
    label322:
    if (this.LmO != null)
    {
      this.LmO.run();
      this.LmO = null;
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