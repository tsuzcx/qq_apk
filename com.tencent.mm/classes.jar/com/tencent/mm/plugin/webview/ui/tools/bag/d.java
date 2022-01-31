package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class d
{
  private static final int vhC = b.vht / 2 * (b.vht / 2);
  private int mScreenHeight;
  private int mScreenWidth;
  private float vhA;
  private int vhD;
  private int vhE;
  private d.a vhF;
  private FrameLayout.LayoutParams vhG;
  private boolean vhH;
  private boolean vhI;
  private float vhJ;
  private float vhK;
  private long vhL;
  private boolean vhl;
  g vhy;
  private f vhz;
  
  public d(g paramg, f paramf)
  {
    AppMethodBeat.i(8161);
    this.vhD = (b.vhn - b.vht / 2);
    this.vhE = (-b.vht / 2);
    this.vhJ = 2.0F;
    this.vhK = 0.15F;
    this.vhy = paramg;
    this.vhz = paramf;
    this.vhF = new d.a(this.vhy.getActivity());
    this.vhF.vhN = new a.a()
    {
      public final void onChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8157);
        d.a(d.this, paramAnonymousBoolean);
        d.g(d.this).bottomMargin = d.l(d.this);
        d.g(d.this).rightMargin = d.k(d.this);
        d.h(d.this).setLayoutParams(d.g(d.this));
        AppMethodBeat.o(8157);
      }
    };
    if (a.gw(ah.getContext()) > a.gx(ah.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      ov(bool);
      this.vhG = new FrameLayout.LayoutParams(-2, -2);
      this.vhG.gravity = 85;
      this.vhG.bottomMargin = this.vhD;
      this.vhG.rightMargin = this.vhE;
      this.vhF.setLayoutParams(this.vhG);
      AppMethodBeat.o(8161);
      return;
    }
  }
  
  private void dfc()
  {
    AppMethodBeat.i(8163);
    if (!this.vhH)
    {
      AppMethodBeat.o(8163);
      return;
    }
    this.vhF.setVisibility(8);
    this.vhH = false;
    AppMethodBeat.o(8163);
  }
  
  private void dfd()
  {
    AppMethodBeat.i(8164);
    if (this.vhy != null) {
      b.fy(this.vhy.getActivity());
    }
    if (this.vhl)
    {
      this.vhD = (-b.vht / 2);
      this.vhE = (b.vhn - b.vht / 2);
      AppMethodBeat.o(8164);
      return;
    }
    this.vhD = (b.vhn - b.vht / 2);
    this.vhE = (-b.vht / 2);
    AppMethodBeat.o(8164);
  }
  
  private void ov(boolean paramBoolean)
  {
    AppMethodBeat.i(8165);
    ab.i("MicroMsg.BagIndicatorController", "updateOrientation isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vhl = paramBoolean;
    this.mScreenWidth = a.gw(ah.getContext());
    this.mScreenHeight = a.gx(ah.getContext());
    dfd();
    this.vhJ = (1.0F / ((this.mScreenWidth - b.vhs / 2) / this.mScreenWidth - 0.2F));
    ab.d("MicroMsg.BagIndicatorController", "initIndicator mIndicatorScaleGainConstant:%f", new Object[] { Float.valueOf(this.vhJ) });
    AppMethodBeat.o(8165);
  }
  
  public final void start()
  {
    AppMethodBeat.i(8162);
    dfc();
    this.vhL = -1L;
    if (!this.vhy.dbs())
    {
      AppMethodBeat.o(8162);
      return;
    }
    this.vhy.a(new g.a()
    {
      public final boolean aZ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(8155);
        ab.i("MicroMsg.BagIndicatorController", "onViewReleased willSwipeBack:%b %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(d.d(d.this)) });
        d.a(d.this, -1L);
        if (!paramAnonymousBoolean)
        {
          d.j(d.this);
          d.m(d.this);
          AppMethodBeat.o(8155);
          return false;
        }
        if (d.d(d.this))
        {
          ab.v("MicroMsg.BagIndicatorController", "onViewReleased showBag");
          d.j(d.this);
          d.m(d.this);
          d.o(d.this).f(d.n(d.this), 14);
          AppMethodBeat.o(8155);
          return true;
        }
        AppMethodBeat.o(8155);
        return false;
      }
      
      public final void bl(float paramAnonymousFloat)
      {
        AppMethodBeat.i(8153);
        if (d.a(d.this) < 0L) {
          d.a(d.this, bo.aoy());
        }
        if (d.a(d.this, paramAnonymousFloat))
        {
          if (!d.b(d.this)) {
            d.c(d.this);
          }
          if (!d.d(d.this))
          {
            float f = d.e(d.this) * paramAnonymousFloat;
            paramAnonymousFloat = f;
            if (f > 1.0F) {
              paramAnonymousFloat = 1.0F;
            }
            if (!d.f(d.this)) {
              break label174;
            }
            d.g(d.this).bottomMargin = ((int)((paramAnonymousFloat * 0.5F - 1.0F) * b.vht));
            d.g(d.this).rightMargin = (d.g(d.this).bottomMargin + b.vhn);
          }
          for (;;)
          {
            d.h(d.this).setLayoutParams(d.g(d.this));
            d.i(d.this);
            AppMethodBeat.o(8153);
            return;
            label174:
            d.g(d.this).rightMargin = ((int)((paramAnonymousFloat * 0.5F - 1.0F) * b.vht));
            d.g(d.this).bottomMargin = (d.g(d.this).rightMargin + b.vhn);
          }
        }
        d.j(d.this);
        AppMethodBeat.o(8153);
      }
      
      public final void l(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(8154);
        boolean bool = d.d(d.this);
        d.a(d.this, paramAnonymousMotionEvent);
        if ((d.b(d.this)) && (d.d(d.this) != bool))
        {
          if (d.d(d.this))
          {
            d.g(d.this).rightMargin = d.k(d.this);
            d.g(d.this).bottomMargin = d.l(d.this);
            d.h(d.this).setLayoutParams(d.g(d.this));
            d.b(d.this, paramAnonymousMotionEvent.getRawX());
          }
          paramAnonymousMotionEvent = d.h(d.this);
          bool = d.d(d.this);
          ab.v("MicroMsg.BagIndicatorController.BagIndicator", "onHitChange %b", new Object[] { Boolean.valueOf(bool) });
          if (bool)
          {
            paramAnonymousMotionEvent.iCl.setImageResource(2131232228);
            paramAnonymousMotionEvent.ak(1.0F, b.vhu);
            if (paramAnonymousMotionEvent.jbU != null) {
              paramAnonymousMotionEvent.jbU.vibrate(10L);
            }
            AppMethodBeat.o(8154);
            return;
          }
          paramAnonymousMotionEvent.iCl.setImageResource(2131232227);
          paramAnonymousMotionEvent.ak(b.vhu, 1.0F);
        }
        AppMethodBeat.o(8154);
      }
    });
    this.vhF.setVisibility(8);
    ViewGroup localViewGroup = this.vhy.bTL();
    for (;;)
    {
      int i;
      try
      {
        if (this.vhF.getParent() != null) {
          break;
        }
        int k = localViewGroup.getChildCount();
        i = 0;
        int j = k;
        if (i < localViewGroup.getChildCount())
        {
          if ((localViewGroup.getChildAt(i) instanceof SwipeBackLayout))
          {
            j = i + 1;
            ab.i("MicroMsg.BagIndicatorController", "start pos %d, count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localViewGroup.getChildCount()) });
          }
        }
        else
        {
          localViewGroup.addView(this.vhF, j);
          AppMethodBeat.o(8162);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.BagIndicatorController", "start addView exp:%s", new Object[] { localException.getLocalizedMessage() });
        AppMethodBeat.o(8162);
        return;
      }
      i += 1;
    }
    ab.i("MicroMsg.BagIndicatorController", "start already added");
    AppMethodBeat.o(8162);
  }
  
  static abstract interface a$a
  {
    public abstract void onChange(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.d
 * JD-Core Version:    0.7.0.1
 */