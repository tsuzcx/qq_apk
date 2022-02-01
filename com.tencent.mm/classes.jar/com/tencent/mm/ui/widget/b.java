package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;

public final class b
{
  public boolean AxH;
  private a QBP;
  private boolean QBQ;
  private int QBR;
  private int QBS;
  Runnable QBT;
  Runnable QBU;
  private int maxHeight;
  private int oXi;
  private int uZv;
  private Rect vPN;
  private View view;
  
  public b(View paramView, a parama)
  {
    AppMethodBeat.i(143328);
    this.vPN = new Rect();
    this.QBQ = false;
    this.AxH = false;
    this.view = paramView;
    this.QBP = parama;
    this.QBS = (ao.aD(paramView.getContext()) * 2);
    this.oXi = KeyBoardUtil.getKeyBordHeightPx(paramView.getContext(), true);
    AppMethodBeat.o(143328);
  }
  
  private boolean gYB()
  {
    AppMethodBeat.i(143332);
    boolean bool = KeyBoardUtil.isPortOrientation(this.view.getContext());
    AppMethodBeat.o(143332);
    return bool;
  }
  
  private boolean isInMultiWindowMode()
  {
    AppMethodBeat.i(143333);
    if ((d.oD(24)) && ((this.view.getContext() instanceof Activity)))
    {
      boolean bool = ((Activity)this.view.getContext()).isInMultiWindowMode();
      AppMethodBeat.o(143333);
      return bool;
    }
    AppMethodBeat.o(143333);
    return false;
  }
  
  public final void aP(Runnable paramRunnable)
  {
    AppMethodBeat.i(143330);
    this.QBT = paramRunnable;
    this.QBU = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143326);
        if (b.this.QBT != null)
        {
          Log.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
          b.this.QBT.run();
          b.this.QBT = null;
        }
        AppMethodBeat.o(143326);
      }
    }, 200L);
    AppMethodBeat.o(143330);
  }
  
  public final void aQ(Runnable paramRunnable)
  {
    AppMethodBeat.i(143331);
    this.QBU = paramRunnable;
    this.QBT = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143327);
        if (b.this.QBU != null)
        {
          Log.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
          b.this.QBU.run();
          b.this.QBU = null;
        }
        AppMethodBeat.o(143327);
      }
    }, 200L);
    AppMethodBeat.o(143331);
  }
  
  public final void aou(int paramInt)
  {
    AppMethodBeat.i(143329);
    if ((!gYB()) || (isInMultiWindowMode()))
    {
      Log.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
      AppMethodBeat.o(143329);
      return;
    }
    int i = this.uZv;
    int j = this.vPN.bottom;
    this.uZv = View.MeasureSpec.getSize(paramInt);
    this.view.getWindowVisibleDisplayFrame(this.vPN);
    boolean bool;
    if (!this.QBQ)
    {
      if (j != this.vPN.bottom)
      {
        bool = true;
        this.QBQ = bool;
      }
    }
    else
    {
      this.QBR = this.vPN.bottom;
      if (this.QBR > this.maxHeight - this.QBS) {
        this.maxHeight = this.QBR;
      }
      paramInt = this.maxHeight - this.QBR;
      if (paramInt <= this.QBS) {
        break label298;
      }
      bool = true;
      label147:
      if (bool) {
        this.oXi = paramInt;
      }
      if ((this.QBQ) && (bool != this.AxH))
      {
        if (paramInt != this.QBS) {
          break label304;
        }
        this.QBP.f(false, this.oXi - paramInt);
      }
    }
    for (;;)
    {
      this.AxH = bool;
      if (((!this.QBQ) || (i <= this.uZv + this.QBS)) && (i >= this.uZv - this.QBS)) {
        break label343;
      }
      Log.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", new Object[] { Boolean.valueOf(bool) });
      this.QBQ = false;
      if (!bool) {
        break label322;
      }
      if (this.QBT == null) {
        break label343;
      }
      this.QBT.run();
      this.QBT = null;
      AppMethodBeat.o(143329);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label147;
      label304:
      this.QBP.f(bool, this.oXi);
    }
    label322:
    if (this.QBU != null)
    {
      this.QBU.run();
      this.QBU = null;
    }
    label343:
    AppMethodBeat.o(143329);
  }
  
  public static abstract interface a
  {
    public abstract void f(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b
 * JD-Core Version:    0.7.0.1
 */