package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.ai;

public final class b
{
  private a HyG;
  private boolean HyH;
  private int HyI;
  private int HyJ;
  private int HyK;
  public boolean HyL;
  Runnable HyM;
  Runnable HyN;
  private Rect fTd;
  private int mEi;
  private int maxHeight;
  private View view;
  
  public b(View paramView, a parama)
  {
    AppMethodBeat.i(143328);
    this.fTd = new Rect();
    this.HyH = false;
    this.HyL = false;
    this.view = paramView;
    this.HyG = parama;
    this.HyK = ai.eb(paramView.getContext());
    this.mEi = z.il(paramView.getContext());
    AppMethodBeat.o(143328);
  }
  
  private boolean feG()
  {
    AppMethodBeat.i(143332);
    boolean bool = z.ip(this.view.getContext());
    AppMethodBeat.o(143332);
    return bool;
  }
  
  private boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(143333);
    if ((d.lf(24)) && ((this.view.getContext() instanceof Activity)))
    {
      boolean bool = ((Activity)this.view.getContext()).isInMultiWindowMode();
      AppMethodBeat.o(143333);
      return bool;
    }
    AppMethodBeat.o(143333);
    return false;
  }
  
  public final void aI(Runnable paramRunnable)
  {
    AppMethodBeat.i(143330);
    this.HyM = paramRunnable;
    this.HyN = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143326);
        if (b.this.HyM != null)
        {
          ad.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
          b.this.HyM.run();
          b.this.HyM = null;
        }
        AppMethodBeat.o(143326);
      }
    }, 200L);
    AppMethodBeat.o(143330);
  }
  
  public final void aJ(Runnable paramRunnable)
  {
    AppMethodBeat.i(143331);
    this.HyN = paramRunnable;
    this.HyM = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143327);
        if (b.this.HyN != null)
        {
          ad.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
          b.this.HyN.run();
          b.this.HyN = null;
        }
        AppMethodBeat.o(143327);
      }
    }, 200L);
    AppMethodBeat.o(143331);
  }
  
  public final void aao(int paramInt)
  {
    AppMethodBeat.i(143329);
    if ((!feG()) || (isInMultiWindowMode()))
    {
      ad.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
      AppMethodBeat.o(143329);
      return;
    }
    int i = this.HyI;
    int j = this.fTd.bottom;
    this.HyI = View.MeasureSpec.getSize(paramInt);
    this.view.getWindowVisibleDisplayFrame(this.fTd);
    boolean bool;
    if (!this.HyH)
    {
      if (j != this.fTd.bottom)
      {
        bool = true;
        this.HyH = bool;
      }
    }
    else
    {
      this.HyJ = this.fTd.bottom;
      if (this.HyJ > this.maxHeight - this.HyK) {
        this.maxHeight = this.HyJ;
      }
      paramInt = this.maxHeight - this.HyJ;
      if (paramInt <= this.HyK) {
        break label298;
      }
      bool = true;
      label147:
      if (bool) {
        this.mEi = paramInt;
      }
      if ((this.HyH) && (bool != this.HyL))
      {
        if (paramInt != this.HyK) {
          break label304;
        }
        this.HyG.g(false, this.mEi - paramInt);
      }
    }
    for (;;)
    {
      this.HyL = bool;
      if (((!this.HyH) || (i <= this.HyI + this.HyK)) && (i >= this.HyI - this.HyK)) {
        break label343;
      }
      ad.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", new Object[] { Boolean.valueOf(bool) });
      this.HyH = false;
      if (!bool) {
        break label322;
      }
      if (this.HyM == null) {
        break label343;
      }
      this.HyM.run();
      this.HyM = null;
      AppMethodBeat.o(143329);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label147;
      label304:
      this.HyG.g(bool, this.mEi);
    }
    label322:
    if (this.HyN != null)
    {
      this.HyN.run();
      this.HyN = null;
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