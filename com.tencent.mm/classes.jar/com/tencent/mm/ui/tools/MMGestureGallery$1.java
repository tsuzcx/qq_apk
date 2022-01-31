package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;

final class MMGestureGallery$1
  implements View.OnTouchListener
{
  MMGestureGallery$1(MMGestureGallery paramMMGestureGallery) {}
  
  private void dNM()
  {
    AppMethodBeat.i(107658);
    dNN();
    MMGestureGallery.e(this.AvP).j(2, 500L, 0L);
    AppMethodBeat.o(107658);
  }
  
  private void dNN()
  {
    AppMethodBeat.i(107659);
    MMGestureGallery.e(this.AvP).removeMessages(2);
    AppMethodBeat.o(107659);
  }
  
  private void rt(boolean paramBoolean)
  {
    AppMethodBeat.i(107661);
    MMGestureGallery.K(this.AvP).E(350L, paramBoolean);
    AppMethodBeat.o(107661);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107660);
    if (MMGestureGallery.f(this.AvP) == null) {
      MMGestureGallery.a(this.AvP, VelocityTracker.obtain());
    }
    MMGestureGallery.f(this.AvP).addMovement(paramMotionEvent);
    View localView = this.AvP.getSelectedView();
    paramView = localView;
    if ((localView instanceof ViewGroup))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        MMGestureGallery.a(this.AvP, f.c(paramMotionEvent, 0));
        MMGestureGallery.b(this.AvP, f.d(paramMotionEvent, 0));
      }
      paramView = localView.findViewById(2131820629);
      if ((paramView != null) && (paramView.getVisibility() == 0) && (!(paramView instanceof MultiTouchImageView)))
      {
        if (paramMotionEvent.getAction() == 0) {
          dNM();
        }
        if (paramMotionEvent.getAction() == 1) {
          dNN();
        }
      }
      paramView = localView.findViewById(2131820630);
      if (((paramView == null) || (paramView.getVisibility() == 8)) && (MMGestureGallery.g(this.AvP)) && (MMGestureGallery.h(this.AvP) != null) && (paramMotionEvent.getAction() == 1) && (Math.abs(MMGestureGallery.i(this.AvP) - f.c(paramMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.j(this.AvP) - f.d(paramMotionEvent, 0)) < 10.0F) && (!MMGestureGallery.k(this.AvP))) {
        rt(true);
      }
      if (paramMotionEvent.getAction() == 1) {
        MMGestureGallery.l(this.AvP);
      }
      if (paramView != null)
      {
        localView = paramView.findViewById(2131820629);
        paramView = localView;
        if (localView != null) {}
      }
      else
      {
        AppMethodBeat.o(107660);
        return false;
      }
    }
    float f3;
    if ((paramView instanceof MultiTouchImageView))
    {
      MMGestureGallery.a(this.AvP, (MultiTouchImageView)paramView);
      ab.d("dktest", "MMGestureGallery onTouch event.getAction():" + paramMotionEvent.getAction());
      if (paramMotionEvent.getAction() == 0)
      {
        dNM();
        MMGestureGallery.a(this.AvP).dDK();
        MMGestureGallery.c(this.AvP, paramMotionEvent.getX());
        MMGestureGallery.d(this.AvP, paramMotionEvent.getY());
        MMGestureGallery.e(this.AvP, 0.0F);
        MMGestureGallery.f(this.AvP, MMGestureGallery.a(this.AvP).getScale());
        ab.d("dktest", "originalScale :" + MMGestureGallery.m(this.AvP));
        MMGestureGallery.a(this.AvP, false);
        MMGestureGallery.n(this.AvP);
        if (MMGestureGallery.o(this.AvP) == 1)
        {
          MMGestureGallery.a(this.AvP, System.currentTimeMillis());
          MMGestureGallery.a(this.AvP, f.c(paramMotionEvent, 0));
          MMGestureGallery.b(this.AvP, f.d(paramMotionEvent, 0));
        }
      }
      else
      {
        if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
        {
          dNN();
          MMGestureGallery.e(this.AvP, 0.0F);
          MMGestureGallery.f(this.AvP, MMGestureGallery.a(this.AvP).getScale());
          MMGestureGallery.a(this.AvP, true);
          float f4;
          if (MMGestureGallery.m(this.AvP) < MMGestureGallery.a(this.AvP).getScaleRate())
          {
            f1 = f.c(paramMotionEvent, 0);
            f2 = f.c(paramMotionEvent, 1);
            f3 = f.d(paramMotionEvent, 0);
            f4 = f.d(paramMotionEvent, 1);
            MMGestureGallery.a(this.AvP).an(f1 - f2 + f.c(paramMotionEvent, 1), f3 - f4 + f.d(paramMotionEvent, 1));
          }
          if (MMGestureGallery.m(this.AvP) > MMGestureGallery.a(this.AvP).getDoubleTabScale() * 2.0F)
          {
            f1 = f.c(paramMotionEvent, 0);
            f2 = f.c(paramMotionEvent, 1);
            f3 = f.d(paramMotionEvent, 0);
            f4 = f.d(paramMotionEvent, 1);
            MMGestureGallery.a(this.AvP).setMaxZoomLimit(MMGestureGallery.a(this.AvP).getDoubleTabScale() * 2.0F);
            MMGestureGallery.a(this.AvP).k(MMGestureGallery.a(this.AvP).getDoubleTabScale() * 2.0F, f1 - f2 + f.c(paramMotionEvent, 1), f3 - f4 + f.d(paramMotionEvent, 1));
          }
        }
        if (paramMotionEvent.getAction() == 1)
        {
          dNN();
          MMGestureGallery.r(this.AvP);
          MMGestureGallery.s(this.AvP);
          MMGestureGallery.l(this.AvP);
          if (((!MMGestureGallery.t(this.AvP)) && (!MMGestureGallery.u(this.AvP)) && (!MMGestureGallery.v(this.AvP)) && (!MMGestureGallery.w(this.AvP))) || ((!MMGestureGallery.x(this.AvP)) && (!MMGestureGallery.y(this.AvP)))) {
            break label1363;
          }
          MMGestureGallery.a(this.AvP, new MMGestureGallery.h(this.AvP));
          MMGestureGallery.z(this.AvP);
          MMGestureGallery.A(this.AvP);
          MMGestureGallery.B(this.AvP);
          MMGestureGallery.C(this.AvP);
          MMGestureGallery.D(this.AvP);
          MMGestureGallery.E(this.AvP);
          MMGestureGallery.F(this.AvP);
          label920:
          MMGestureGallery.e(this.AvP, 0.0F);
          MMGestureGallery.f(this.AvP, MMGestureGallery.a(this.AvP).getScale());
          if (MMGestureGallery.o(this.AvP) == 1)
          {
            MMGestureGallery.c(this.AvP, System.currentTimeMillis());
            if (MMGestureGallery.q(this.AvP) - MMGestureGallery.L(this.AvP) >= 350L) {
              break label1662;
            }
            if ((Math.abs(MMGestureGallery.i(this.AvP) - f.c(paramMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.j(this.AvP) - f.d(paramMotionEvent, 0)) < 10.0F)) {
              rt(false);
            }
          }
        }
      }
      for (;;)
      {
        if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
        {
          MMGestureGallery.e(this.AvP, 0.0F);
          MMGestureGallery.f(this.AvP, MMGestureGallery.a(this.AvP).getScale());
          MMGestureGallery.a(this.AvP, true);
        }
        if (paramMotionEvent.getAction() != 2) {
          break label1764;
        }
        if (f.T(paramMotionEvent) != 2) {
          break label1831;
        }
        dNN();
        if ((!MMGestureGallery.M(this.AvP)) && (!MMGestureGallery.v(this.AvP)) && (!MMGestureGallery.w(this.AvP))) {
          break label1683;
        }
        AppMethodBeat.o(107660);
        return true;
        if (MMGestureGallery.o(this.AvP) != 2) {
          break;
        }
        MMGestureGallery.b(this.AvP, System.currentTimeMillis());
        if (MMGestureGallery.p(this.AvP) - MMGestureGallery.q(this.AvP) < 350L)
        {
          if ((Math.abs(MMGestureGallery.i(this.AvP) - f.c(paramMotionEvent, 0)) < 35.0F) && (Math.abs(MMGestureGallery.j(this.AvP) - f.d(paramMotionEvent, 0)) < 35.0F))
          {
            MMGestureGallery.a(this.AvP, 0);
            ab.d("MicroMsg.MMGestureGallery", "double click!");
            if (MMGestureGallery.a(this.AvP).getScale() <= MMGestureGallery.a(this.AvP).getScaleRate())
            {
              MMGestureGallery.a(this.AvP).ao(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
              break;
            }
            MMGestureGallery.a(this.AvP).an(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
            MMGestureGallery.a(this.AvP).dEA();
            break;
          }
          MMGestureGallery.a(this.AvP, 1);
          break;
        }
        MMGestureGallery.a(this.AvP, 1);
        break;
        label1363:
        if ((MMGestureGallery.v(this.AvP)) || (MMGestureGallery.t(this.AvP)))
        {
          MMGestureGallery.C(this.AvP);
          MMGestureGallery.A(this.AvP);
          MMGestureGallery.a(this.AvP, new MMGestureGallery.i(this.AvP));
          MMGestureGallery.z(this.AvP);
        }
        if ((MMGestureGallery.w(this.AvP)) || (MMGestureGallery.u(this.AvP)))
        {
          MMGestureGallery.D(this.AvP);
          MMGestureGallery.B(this.AvP);
          MMGestureGallery.a(this.AvP, new MMGestureGallery.j(this.AvP));
          MMGestureGallery.z(this.AvP);
        }
        if (MMGestureGallery.x(this.AvP))
        {
          MMGestureGallery.E(this.AvP);
          MMGestureGallery.a(this.AvP, new MMGestureGallery.k(this.AvP));
          MMGestureGallery.z(this.AvP);
        }
        if (MMGestureGallery.y(this.AvP))
        {
          MMGestureGallery.F(this.AvP);
          MMGestureGallery.a(this.AvP, new MMGestureGallery.g(this.AvP));
          MMGestureGallery.z(this.AvP);
        }
        if (MMGestureGallery.G(this.AvP))
        {
          if (MMGestureGallery.H(this.AvP) != null) {
            MMGestureGallery.H(this.AvP).ae(0.0F, 0.0F);
          }
          MMGestureGallery.b(this.AvP, false);
        }
        if ((!MMGestureGallery.I(this.AvP)) || (MMGestureGallery.J(this.AvP))) {
          break label920;
        }
        MMGestureGallery.K(this.AvP).E(0L, true);
        MMGestureGallery.b(this.AvP, false);
        break label920;
        label1662:
        MMGestureGallery.a(this.AvP, 0);
        ab.d("MicroMsg.MMGestureGallery", "single long click over!");
      }
      label1683:
      MMGestureGallery.a(this.AvP, true);
      MMGestureGallery.a(this.AvP, 0);
      f1 = f.c(paramMotionEvent, 0) - f.c(paramMotionEvent, 1);
      f2 = f.d(paramMotionEvent, 0) - f.d(paramMotionEvent, 1);
      f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      if (MMGestureGallery.N(this.AvP) != 0.0F) {
        break label1771;
      }
      MMGestureGallery.e(this.AvP, f3);
    }
    for (;;)
    {
      label1764:
      AppMethodBeat.o(107660);
      return false;
      label1771:
      f3 /= MMGestureGallery.N(this.AvP);
      if (MMGestureGallery.O(this.AvP)) {
        MMGestureGallery.a(this.AvP).k(f3 * MMGestureGallery.m(this.AvP), f1 + f.c(paramMotionEvent, 1), f.d(paramMotionEvent, 1) + f2);
      }
    }
    label1831:
    paramView = MMGestureGallery.f(this.AvP);
    paramView.computeCurrentVelocity(1000);
    int i = (int)paramView.getXVelocity();
    int j = (int)paramView.getYVelocity();
    float f1 = paramMotionEvent.getX() - MMGestureGallery.P(this.AvP);
    float f2 = paramMotionEvent.getY() - MMGestureGallery.Q(this.AvP);
    if ((MMGestureGallery.H(this.AvP) != null) && (!MMGestureGallery.J(this.AvP)) && (!MMGestureGallery.O(this.AvP)) && (MMGestureGallery.m(this.AvP) <= MMGestureGallery.a(this.AvP).getScaleRate()))
    {
      MMGestureGallery.H(this.AvP).af(f1, f2);
      if (((Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (j <= 0) || (MMGestureGallery.k(this.AvP))) && (!MMGestureGallery.I(this.AvP))) {
        break label2135;
      }
      MMGestureGallery.H(this.AvP).ae(f1, f2);
      MMGestureGallery.b(this.AvP, true);
      label2026:
      if (f2 <= 200.0F) {
        break label2147;
      }
      MMGestureGallery.c(this.AvP, false);
    }
    for (;;)
    {
      if (MMGestureGallery.f(this.AvP) != null)
      {
        MMGestureGallery.f(this.AvP).recycle();
        MMGestureGallery.a(this.AvP, null);
      }
      if ((Math.abs(MMGestureGallery.i(this.AvP) - f.c(paramMotionEvent, 0)) <= 35.0F) && (Math.abs(MMGestureGallery.j(this.AvP) - f.d(paramMotionEvent, 0)) <= 35.0F)) {
        break;
      }
      dNN();
      MMGestureGallery.a(this.AvP, 0);
      break;
      label2135:
      MMGestureGallery.b(this.AvP, false);
      break label2026;
      label2147:
      MMGestureGallery.c(this.AvP, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.1
 * JD-Core Version:    0.7.0.1
 */