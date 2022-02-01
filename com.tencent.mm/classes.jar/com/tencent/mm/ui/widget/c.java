package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.KeyBoardUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;

public class c
{
  private Rect LGX;
  public boolean Mik;
  private a afSj;
  private boolean afSk;
  private int afSl;
  private int afSm;
  private Runnable afSn;
  private Runnable afSo;
  private int afd;
  private int maxHeight;
  private int sNb;
  private View view;
  
  public c(View paramView, a parama)
  {
    AppMethodBeat.i(143328);
    this.LGX = new Rect();
    this.afSk = false;
    this.Mik = false;
    this.view = paramView;
    this.afSj = parama;
    this.afSm = (aw.bk(paramView.getContext()) * 2);
    this.sNb = KeyBoardUtil.getKeyBordHeightPx(paramView.getContext(), true);
    AppMethodBeat.o(143328);
  }
  
  private boolean ccm()
  {
    AppMethodBeat.i(143333);
    if ((d.rb(24)) && ((this.view.getContext() instanceof Activity)))
    {
      boolean bool = ((Activity)this.view.getContext()).isInMultiWindowMode();
      AppMethodBeat.o(143333);
      return bool;
    }
    AppMethodBeat.o(143333);
    return false;
  }
  
  private boolean jEz()
  {
    AppMethodBeat.i(143332);
    boolean bool = KeyBoardUtil.isPortOrientation(this.view.getContext());
    AppMethodBeat.o(143332);
    return bool;
  }
  
  public final void aEm(int paramInt)
  {
    AppMethodBeat.i(143329);
    if ((!jEz()) || (ccm()))
    {
      Log.i("MicroMsg.InputPanelHelper", "onMeasure: delay call runnable");
      AppMethodBeat.o(143329);
      return;
    }
    int i = this.afd;
    int j = this.LGX.bottom;
    this.afd = View.MeasureSpec.getSize(paramInt);
    this.view.getWindowVisibleDisplayFrame(this.LGX);
    boolean bool;
    if (!this.afSk)
    {
      if (j != this.LGX.bottom)
      {
        bool = true;
        this.afSk = bool;
      }
    }
    else
    {
      this.afSl = this.LGX.bottom;
      if (this.afSl > this.maxHeight - this.afSm) {
        this.maxHeight = this.afSl;
      }
      paramInt = this.maxHeight - this.afSl;
      if (paramInt <= this.afSm) {
        break label298;
      }
      bool = true;
      label147:
      if (bool) {
        this.sNb = paramInt;
      }
      if ((this.afSk) && (bool != this.Mik))
      {
        if (paramInt != this.afSm) {
          break label304;
        }
        this.afSj.onInputPanelChange(false, this.sNb - paramInt);
      }
    }
    for (;;)
    {
      this.Mik = bool;
      if (((!this.afSk) || (i <= this.afd + this.afSm)) && (i >= this.afd - this.afSm)) {
        break label343;
      }
      Log.i("MicroMsg.InputPanelHelper", "onMeasure: run, %s", new Object[] { Boolean.valueOf(bool) });
      this.afSk = false;
      if (!bool) {
        break label322;
      }
      if (this.afSn == null) {
        break label343;
      }
      this.afSn.run();
      this.afSn = null;
      AppMethodBeat.o(143329);
      return;
      bool = false;
      break;
      label298:
      bool = false;
      break label147;
      label304:
      this.afSj.onInputPanelChange(bool, this.sNb);
    }
    label322:
    if (this.afSo != null)
    {
      this.afSo.run();
      this.afSo = null;
    }
    label343:
    AppMethodBeat.o(143329);
  }
  
  public final void be(Runnable paramRunnable)
  {
    AppMethodBeat.i(143330);
    this.afSn = paramRunnable;
    this.afSo = null;
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
  
  public final void bf(Runnable paramRunnable)
  {
    AppMethodBeat.i(143331);
    this.afSo = paramRunnable;
    this.afSn = null;
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
  
  public static abstract interface a
  {
    public abstract void onInputPanelChange(boolean paramBoolean, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */