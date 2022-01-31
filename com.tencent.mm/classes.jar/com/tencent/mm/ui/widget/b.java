package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.af;

public final class b
{
  private b.a ACd;
  private boolean ACe;
  private int ACf;
  private int ACg;
  private int ACh;
  private boolean ACi;
  Runnable ACj;
  Runnable ACk;
  private Rect eyx;
  private int maxHeight;
  private int sMo;
  private View view;
  
  public b(View paramView, b.a parama)
  {
    AppMethodBeat.i(107853);
    this.eyx = new Rect();
    this.ACe = false;
    this.ACi = false;
    this.view = paramView;
    this.ACd = parama;
    this.ACh = af.fx(paramView.getContext());
    this.sMo = x.gJ(paramView.getContext());
    AppMethodBeat.o(107853);
  }
  
  private boolean dOC()
  {
    AppMethodBeat.i(107857);
    boolean bool = x.gN(this.view.getContext());
    AppMethodBeat.o(107857);
    return bool;
  }
  
  private boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(107858);
    if ((d.fv(24)) && ((this.view.getContext() instanceof Activity)))
    {
      boolean bool = ((Activity)this.view.getContext()).isInMultiWindowMode();
      AppMethodBeat.o(107858);
      return bool;
    }
    AppMethodBeat.o(107858);
    return false;
  }
  
  public final void QX(int paramInt)
  {
    AppMethodBeat.i(107854);
    if ((!dOC()) || (isInMultiWindowMode()))
    {
      ab.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
      AppMethodBeat.o(107854);
      return;
    }
    int i = this.ACf;
    int j = this.eyx.bottom;
    this.ACf = View.MeasureSpec.getSize(paramInt);
    this.view.getWindowVisibleDisplayFrame(this.eyx);
    boolean bool;
    if (!this.ACe)
    {
      if (j != this.eyx.bottom)
      {
        bool = true;
        this.ACe = bool;
      }
    }
    else
    {
      this.ACg = this.eyx.bottom;
      if (this.ACg > this.maxHeight - this.ACh) {
        this.maxHeight = this.ACg;
      }
      paramInt = this.maxHeight - this.ACg;
      if (paramInt <= this.ACh) {
        break label298;
      }
      bool = true;
      label147:
      if (bool) {
        this.sMo = paramInt;
      }
      if ((this.ACe) && (bool != this.ACi))
      {
        if (paramInt != this.ACh) {
          break label304;
        }
        this.ACd.p(false, this.sMo - paramInt);
      }
    }
    for (;;)
    {
      this.ACi = bool;
      if (((!this.ACe) || (i <= this.ACf + this.ACh)) && (i >= this.ACf - this.ACh)) {
        break label343;
      }
      ab.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", new Object[] { Boolean.valueOf(bool) });
      this.ACe = false;
      if (!bool) {
        break label322;
      }
      if (this.ACj == null) {
        break label343;
      }
      this.ACj.run();
      this.ACj = null;
      AppMethodBeat.o(107854);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label147;
      label304:
      this.ACd.p(bool, this.sMo);
    }
    label322:
    if (this.ACk != null)
    {
      this.ACk.run();
      this.ACk = null;
    }
    label343:
    AppMethodBeat.o(107854);
  }
  
  public final void ay(Runnable paramRunnable)
  {
    AppMethodBeat.i(107855);
    this.ACj = paramRunnable;
    this.ACk = null;
    this.view.postDelayed(new b.1(this), 200L);
    AppMethodBeat.o(107855);
  }
  
  public final void az(Runnable paramRunnable)
  {
    AppMethodBeat.i(107856);
    this.ACk = paramRunnable;
    this.ACj = null;
    this.view.postDelayed(new b.2(this), 200L);
    AppMethodBeat.o(107856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */