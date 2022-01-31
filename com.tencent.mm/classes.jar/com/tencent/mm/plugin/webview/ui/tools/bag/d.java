package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R.k;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.SwipeBackLayout;

public final class d
{
  private static final int rrx = b.rro / 2 * (b.rro / 2);
  private int mScreenHeight;
  private int mScreenWidth;
  private d.a rrA;
  private FrameLayout.LayoutParams rrB;
  private boolean rrC;
  private boolean rrD;
  private float rrE = 2.0F;
  private float rrF = 0.15F;
  private long rrG;
  private boolean rrg;
  g rrt;
  private f rru;
  private float rrv;
  private int rry = b.rri - b.rro / 2;
  private int rrz = -b.rro / 2;
  
  public d(g paramg, f paramf)
  {
    this.rrt = paramg;
    this.rru = paramf;
    this.rrA = new d.a(this.rrt.getActivity());
    this.rrA.rrI = new a.a()
    {
      public final void onChange(boolean paramAnonymousBoolean)
      {
        d.a(d.this, paramAnonymousBoolean);
        d.e(d.this).bottomMargin = d.k(d.this);
        d.e(d.this).rightMargin = d.j(d.this);
        d.f(d.this).setLayoutParams(d.e(d.this));
      }
    };
    if (a.fj(ae.getContext()) > a.fk(ae.getContext())) {}
    for (boolean bool = true;; bool = false)
    {
      ln(bool);
      this.rrB = new FrameLayout.LayoutParams(-2, -2);
      this.rrB.gravity = 85;
      this.rrB.bottomMargin = this.rry;
      this.rrB.rightMargin = this.rrz;
      this.rrA.setLayoutParams(this.rrB);
      return;
    }
  }
  
  private void ceV()
  {
    if (!this.rrC) {
      return;
    }
    this.rrA.setVisibility(8);
    this.rrC = false;
  }
  
  private void ceW()
  {
    
    if (this.rrg)
    {
      this.rry = (-b.rro / 2);
      this.rrz = (b.rri - b.rro / 2);
      return;
    }
    this.rry = (b.rri - b.rro / 2);
    this.rrz = (-b.rro / 2);
  }
  
  private void ln(boolean paramBoolean)
  {
    y.i("MicroMsg.BagIndicatorController", "updateOrientation isLandscape:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.rrg = paramBoolean;
    this.mScreenWidth = a.fj(ae.getContext());
    this.mScreenHeight = a.fk(ae.getContext());
    ceW();
    this.rrE = (1.0F / ((this.mScreenWidth - b.rrn / 2) / this.mScreenWidth - 0.2F));
    y.d("MicroMsg.BagIndicatorController", "initIndicator mIndicatorScaleGainConstant:%f", new Object[] { Float.valueOf(this.rrE) });
  }
  
  public final void start()
  {
    ceV();
    this.rrG = -1L;
    if (!this.rrt.cbo()) {
      return;
    }
    this.rrt.a(new g.a()
    {
      public final void aI(float paramAnonymousFloat)
      {
        if (d.a(d.this) < 0L) {
          d.a(d.this, bk.UY());
        }
        if (d.a(d.this, paramAnonymousFloat))
        {
          if (!d.b(d.this))
          {
            float f = d.c(d.this) * paramAnonymousFloat;
            paramAnonymousFloat = f;
            if (f > 1.0F) {
              paramAnonymousFloat = 1.0F;
            }
            if (!d.d(d.this)) {
              break label145;
            }
            d.e(d.this).bottomMargin = ((int)((paramAnonymousFloat * 0.5F - 1.0F) * b.rro));
            d.e(d.this).rightMargin = (d.e(d.this).bottomMargin + b.rri);
          }
          for (;;)
          {
            d.f(d.this).setLayoutParams(d.e(d.this));
            d.g(d.this);
            return;
            label145:
            d.e(d.this).rightMargin = ((int)((paramAnonymousFloat * 0.5F - 1.0F) * b.rro));
            d.e(d.this).bottomMargin = (d.e(d.this).rightMargin + b.rri);
          }
        }
        d.h(d.this);
      }
      
      public final boolean aK(boolean paramAnonymousBoolean)
      {
        y.i("MicroMsg.BagIndicatorController", "onViewReleased willSwipeBack:%b %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(d.b(d.this)) });
        d.a(d.this, -1L);
        if (!paramAnonymousBoolean)
        {
          d.h(d.this);
          d.l(d.this);
        }
        while (!d.b(d.this)) {
          return false;
        }
        y.v("MicroMsg.BagIndicatorController", "onViewReleased showBag");
        d.h(d.this);
        d.l(d.this);
        d.n(d.this).c(d.m(d.this), 14);
        return true;
      }
      
      public final void l(MotionEvent paramAnonymousMotionEvent)
      {
        boolean bool = d.b(d.this);
        d.a(d.this, paramAnonymousMotionEvent);
        if ((d.i(d.this)) && (d.b(d.this) != bool))
        {
          if (d.b(d.this))
          {
            d.e(d.this).rightMargin = d.j(d.this);
            d.e(d.this).bottomMargin = d.k(d.this);
            d.f(d.this).setLayoutParams(d.e(d.this));
            d.b(d.this, paramAnonymousMotionEvent.getRawX());
          }
          paramAnonymousMotionEvent = d.f(d.this);
          bool = d.b(d.this);
          y.v("MicroMsg.BagIndicatorController.BagIndicator", "onHitChange %b", new Object[] { Boolean.valueOf(bool) });
          if (!bool) {
            break label184;
          }
          paramAnonymousMotionEvent.hok.setImageResource(R.k.webview_bag_indicator_icon_press);
          paramAnonymousMotionEvent.aa(1.0F, b.rrp);
          if (paramAnonymousMotionEvent.hpm != null) {
            paramAnonymousMotionEvent.hpm.vibrate(10L);
          }
        }
        return;
        label184:
        paramAnonymousMotionEvent.hok.setImageResource(R.k.webview_bag_indicator_icon_normal);
        paramAnonymousMotionEvent.aa(b.rrp, 1.0F);
      }
    });
    this.rrA.setVisibility(8);
    ViewGroup localViewGroup = this.rrt.cbn();
    for (;;)
    {
      int i;
      try
      {
        if (this.rrA.getParent() != null) {
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
            y.i("MicroMsg.BagIndicatorController", "start pos %d, count %d", new Object[] { Integer.valueOf(j), Integer.valueOf(localViewGroup.getChildCount()) });
          }
        }
        else
        {
          localViewGroup.addView(this.rrA, j);
          return;
        }
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.BagIndicatorController", "start addView exp:%s", new Object[] { localException.getLocalizedMessage() });
        return;
      }
      i += 1;
    }
    y.i("MicroMsg.BagIndicatorController", "start already added");
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