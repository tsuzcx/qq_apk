package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;

public class c
{
  private Rect FLS;
  public boolean Goq;
  private a Yao;
  private boolean Yap;
  private int Yaq;
  private int Yar;
  private Runnable Yas;
  private Runnable Yat;
  private int maxHeight;
  private int pIk;
  private View view;
  private int zPP;
  
  public c(View paramView, a parama)
  {
    AppMethodBeat.i(143328);
    this.FLS = new Rect();
    this.Yap = false;
    this.Goq = false;
    this.view = paramView;
    this.Yao = parama;
    this.Yar = (ar.aB(paramView.getContext()) * 2);
    this.pIk = KeyBoardUtil.getKeyBordHeightPx(paramView.getContext(), true);
    AppMethodBeat.o(143328);
  }
  
  private boolean bCZ()
  {
    AppMethodBeat.i(143333);
    if ((d.qV(24)) && ((this.view.getContext() instanceof Activity)))
    {
      boolean bool = ((Activity)this.view.getContext()).isInMultiWindowMode();
      AppMethodBeat.o(143333);
      return bool;
    }
    AppMethodBeat.o(143333);
    return false;
  }
  
  private boolean hZq()
  {
    AppMethodBeat.i(143332);
    boolean bool = KeyBoardUtil.isPortOrientation(this.view.getContext());
    AppMethodBeat.o(143332);
    return bool;
  }
  
  public final void aW(Runnable paramRunnable)
  {
    AppMethodBeat.i(143330);
    this.Yas = paramRunnable;
    this.Yat = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143326);
        if (c.a(c.this) != null)
        {
          Log.w("MicroMsg.InputPanelHelper", "onKeyboardShowOnce not run in measure");
          c.a(c.this).run();
          c.b(c.this);
        }
        AppMethodBeat.o(143326);
      }
    }, 200L);
    AppMethodBeat.o(143330);
  }
  
  public final void aX(Runnable paramRunnable)
  {
    AppMethodBeat.i(143331);
    this.Yat = paramRunnable;
    this.Yas = null;
    this.view.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(143327);
        if (c.c(c.this) != null)
        {
          Log.w("MicroMsg.InputPanelHelper", "onKeyboardHideOnce not run in measure");
          c.c(c.this).run();
          c.d(c.this);
        }
        AppMethodBeat.o(143327);
      }
    }, 200L);
    AppMethodBeat.o(143331);
  }
  
  public final void axC(int paramInt)
  {
    AppMethodBeat.i(143329);
    if ((!hZq()) || (bCZ()))
    {
      Log.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
      AppMethodBeat.o(143329);
      return;
    }
    int i = this.zPP;
    int j = this.FLS.bottom;
    this.zPP = View.MeasureSpec.getSize(paramInt);
    this.view.getWindowVisibleDisplayFrame(this.FLS);
    boolean bool;
    if (!this.Yap)
    {
      if (j != this.FLS.bottom)
      {
        bool = true;
        this.Yap = bool;
      }
    }
    else
    {
      this.Yaq = this.FLS.bottom;
      if (this.Yaq > this.maxHeight - this.Yar) {
        this.maxHeight = this.Yaq;
      }
      paramInt = this.maxHeight - this.Yaq;
      if (paramInt <= this.Yar) {
        break label298;
      }
      bool = true;
      label147:
      if (bool) {
        this.pIk = paramInt;
      }
      if ((this.Yap) && (bool != this.Goq))
      {
        if (paramInt != this.Yar) {
          break label304;
        }
        this.Yao.h(false, this.pIk - paramInt);
      }
    }
    for (;;)
    {
      this.Goq = bool;
      if (((!this.Yap) || (i <= this.zPP + this.Yar)) && (i >= this.zPP - this.Yar)) {
        break label343;
      }
      Log.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", new Object[] { Boolean.valueOf(bool) });
      this.Yap = false;
      if (!bool) {
        break label322;
      }
      if (this.Yas == null) {
        break label343;
      }
      this.Yas.run();
      this.Yas = null;
      AppMethodBeat.o(143329);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label147;
      label304:
      this.Yao.h(bool, this.pIk);
    }
    label322:
    if (this.Yat != null)
    {
      this.Yat.run();
      this.Yat = null;
    }
    label343:
    AppMethodBeat.o(143329);
  }
  
  public static abstract interface a
  {
    public abstract void h(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */