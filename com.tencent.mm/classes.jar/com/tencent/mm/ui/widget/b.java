package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.ui.al;

public final class b
{
  private a KQj;
  private Rect KQk;
  private boolean KQl;
  private int KQm;
  private int KQn;
  private int KQo;
  Runnable KQp;
  Runnable KQq;
  public boolean KpO;
  private int maxHeight;
  private int nGK;
  private View view;
  
  public b(View paramView, a parama)
  {
    AppMethodBeat.i(143328);
    this.KQk = new Rect();
    this.KQl = false;
    this.KpO = false;
    this.view = paramView;
    this.KQj = parama;
    this.KQo = al.ej(paramView.getContext());
    this.nGK = z.iG(paramView.getContext());
    AppMethodBeat.o(143328);
  }
  
  private boolean fLo()
  {
    AppMethodBeat.i(143332);
    boolean bool = z.iK(this.view.getContext());
    AppMethodBeat.o(143332);
    return bool;
  }
  
  private boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(143333);
    if ((d.ly(24)) && ((this.view.getContext() instanceof Activity)))
    {
      boolean bool = ((Activity)this.view.getContext()).isInMultiWindowMode();
      AppMethodBeat.o(143333);
      return bool;
    }
    AppMethodBeat.o(143333);
    return false;
  }
  
  public final void aK(Runnable paramRunnable)
  {
    AppMethodBeat.i(143330);
    this.KQp = paramRunnable;
    this.KQq = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143326);
        if (b.this.KQp != null)
        {
          ad.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
          b.this.KQp.run();
          b.this.KQp = null;
        }
        AppMethodBeat.o(143326);
      }
    }, 200L);
    AppMethodBeat.o(143330);
  }
  
  public final void aL(Runnable paramRunnable)
  {
    AppMethodBeat.i(143331);
    this.KQq = paramRunnable;
    this.KQp = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143327);
        if (b.this.KQq != null)
        {
          ad.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
          b.this.KQq.run();
          b.this.KQq = null;
        }
        AppMethodBeat.o(143327);
      }
    }, 200L);
    AppMethodBeat.o(143331);
  }
  
  public final void aeY(int paramInt)
  {
    AppMethodBeat.i(143329);
    if ((!fLo()) || (isInMultiWindowMode()))
    {
      ad.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
      AppMethodBeat.o(143329);
      return;
    }
    int i = this.KQm;
    int j = this.KQk.bottom;
    this.KQm = View.MeasureSpec.getSize(paramInt);
    this.view.getWindowVisibleDisplayFrame(this.KQk);
    boolean bool;
    if (!this.KQl)
    {
      if (j != this.KQk.bottom)
      {
        bool = true;
        this.KQl = bool;
      }
    }
    else
    {
      this.KQn = this.KQk.bottom;
      if (this.KQn > this.maxHeight - this.KQo) {
        this.maxHeight = this.KQn;
      }
      paramInt = this.maxHeight - this.KQn;
      if (paramInt <= this.KQo) {
        break label298;
      }
      bool = true;
      label147:
      if (bool) {
        this.nGK = paramInt;
      }
      if ((this.KQl) && (bool != this.KpO))
      {
        if (paramInt != this.KQo) {
          break label304;
        }
        this.KQj.g(false, this.nGK - paramInt);
      }
    }
    for (;;)
    {
      this.KpO = bool;
      if (((!this.KQl) || (i <= this.KQm + this.KQo)) && (i >= this.KQm - this.KQo)) {
        break label343;
      }
      ad.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", new Object[] { Boolean.valueOf(bool) });
      this.KQl = false;
      if (!bool) {
        break label322;
      }
      if (this.KQp == null) {
        break label343;
      }
      this.KQp.run();
      this.KQp = null;
      AppMethodBeat.o(143329);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label147;
      label304:
      this.KQj.g(bool, this.nGK);
    }
    label322:
    if (this.KQq != null)
    {
      this.KQq.run();
      this.KQq = null;
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