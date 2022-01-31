package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;

final class MMGestureGallery$1
  implements View.OnTouchListener
{
  MMGestureGallery$1(MMGestureGallery paramMMGestureGallery) {}
  
  private void cIY()
  {
    cIZ();
    MMGestureGallery.e(this.wdi).h(2, 500L, 0L);
  }
  
  private void cIZ()
  {
    MMGestureGallery.e(this.wdi).removeMessages(2);
  }
  
  private void nJ(boolean paramBoolean)
  {
    MMGestureGallery.K(this.wdi).x(350L, paramBoolean);
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (MMGestureGallery.f(this.wdi) == null) {
      MMGestureGallery.a(this.wdi, VelocityTracker.obtain());
    }
    MMGestureGallery.f(this.wdi).addMovement(paramMotionEvent);
    View localView = this.wdi.getSelectedView();
    paramView = localView;
    if ((localView instanceof ViewGroup))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        MMGestureGallery.a(this.wdi, f.c(paramMotionEvent, 0));
        MMGestureGallery.b(this.wdi, f.d(paramMotionEvent, 0));
      }
      paramView = localView.findViewById(a.g.image);
      if ((paramView != null) && (paramView.getVisibility() == 0) && (!(paramView instanceof MultiTouchImageView)))
      {
        if (paramMotionEvent.getAction() == 0) {
          cIY();
        }
        if (paramMotionEvent.getAction() == 1) {
          cIZ();
        }
      }
      paramView = localView.findViewById(a.g.image_gallery_download_success);
      if (((paramView == null) || (paramView.getVisibility() == 8)) && (MMGestureGallery.g(this.wdi)) && (MMGestureGallery.h(this.wdi) != null) && (paramMotionEvent.getAction() == 1) && (Math.abs(MMGestureGallery.i(this.wdi) - f.c(paramMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.j(this.wdi) - f.d(paramMotionEvent, 0)) < 10.0F) && (!MMGestureGallery.k(this.wdi))) {
        nJ(true);
      }
      if (paramMotionEvent.getAction() == 1) {
        MMGestureGallery.l(this.wdi);
      }
      if (paramView != null)
      {
        localView = paramView.findViewById(a.g.image);
        paramView = localView;
        if (localView != null) {}
      }
      else
      {
        return false;
      }
    }
    float f3;
    if ((paramView instanceof MultiTouchImageView))
    {
      MMGestureGallery.a(this.wdi, (MultiTouchImageView)paramView);
      y.d("dktest", "MMGestureGallery onTouch event.getAction():" + paramMotionEvent.getAction());
      if (paramMotionEvent.getAction() == 0)
      {
        cIY();
        MMGestureGallery.a(this.wdi).cAz();
        MMGestureGallery.c(this.wdi, paramMotionEvent.getX());
        MMGestureGallery.d(this.wdi, paramMotionEvent.getY());
        MMGestureGallery.e(this.wdi, 0.0F);
        MMGestureGallery.f(this.wdi, MMGestureGallery.a(this.wdi).getScale());
        y.d("dktest", "originalScale :" + MMGestureGallery.m(this.wdi));
        MMGestureGallery.a(this.wdi, false);
        MMGestureGallery.n(this.wdi);
        if (MMGestureGallery.o(this.wdi) == 1)
        {
          MMGestureGallery.a(this.wdi, System.currentTimeMillis());
          MMGestureGallery.a(this.wdi, f.c(paramMotionEvent, 0));
          MMGestureGallery.b(this.wdi, f.d(paramMotionEvent, 0));
        }
      }
      else
      {
        if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
        {
          cIZ();
          MMGestureGallery.e(this.wdi, 0.0F);
          MMGestureGallery.f(this.wdi, MMGestureGallery.a(this.wdi).getScale());
          MMGestureGallery.a(this.wdi, true);
          float f4;
          if (MMGestureGallery.m(this.wdi) < MMGestureGallery.a(this.wdi).getScaleRate())
          {
            f1 = f.c(paramMotionEvent, 0);
            f2 = f.c(paramMotionEvent, 1);
            f3 = f.d(paramMotionEvent, 0);
            f4 = f.d(paramMotionEvent, 1);
            MMGestureGallery.a(this.wdi).ac(f1 - f2 + f.c(paramMotionEvent, 1), f3 - f4 + f.d(paramMotionEvent, 1));
          }
          if (MMGestureGallery.m(this.wdi) > MMGestureGallery.a(this.wdi).getDoubleTabScale() * 2.0F)
          {
            f1 = f.c(paramMotionEvent, 0);
            f2 = f.c(paramMotionEvent, 1);
            f3 = f.d(paramMotionEvent, 0);
            f4 = f.d(paramMotionEvent, 1);
            MMGestureGallery.a(this.wdi).setMaxZoomLimit(MMGestureGallery.a(this.wdi).getDoubleTabScale() * 2.0F);
            MMGestureGallery.a(this.wdi).k(MMGestureGallery.a(this.wdi).getDoubleTabScale() * 2.0F, f1 - f2 + f.c(paramMotionEvent, 1), f3 - f4 + f.d(paramMotionEvent, 1));
          }
        }
        if (paramMotionEvent.getAction() == 1)
        {
          cIZ();
          MMGestureGallery.r(this.wdi);
          MMGestureGallery.s(this.wdi);
          MMGestureGallery.l(this.wdi);
          if (((!MMGestureGallery.t(this.wdi)) && (!MMGestureGallery.u(this.wdi)) && (!MMGestureGallery.v(this.wdi)) && (!MMGestureGallery.w(this.wdi))) || ((!MMGestureGallery.x(this.wdi)) && (!MMGestureGallery.y(this.wdi)))) {
            break label1351;
          }
          MMGestureGallery.a(this.wdi, new MMGestureGallery.h(this.wdi));
          MMGestureGallery.z(this.wdi);
          MMGestureGallery.A(this.wdi);
          MMGestureGallery.B(this.wdi);
          MMGestureGallery.C(this.wdi);
          MMGestureGallery.D(this.wdi);
          MMGestureGallery.E(this.wdi);
          MMGestureGallery.F(this.wdi);
          label913:
          MMGestureGallery.e(this.wdi, 0.0F);
          MMGestureGallery.f(this.wdi, MMGestureGallery.a(this.wdi).getScale());
          if (MMGestureGallery.o(this.wdi) == 1)
          {
            MMGestureGallery.c(this.wdi, System.currentTimeMillis());
            if (MMGestureGallery.q(this.wdi) - MMGestureGallery.L(this.wdi) >= 350L) {
              break label1650;
            }
            if ((Math.abs(MMGestureGallery.i(this.wdi) - f.c(paramMotionEvent, 0)) < 10.0F) && (Math.abs(MMGestureGallery.j(this.wdi) - f.d(paramMotionEvent, 0)) < 10.0F)) {
              nJ(false);
            }
          }
        }
      }
      for (;;)
      {
        if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
        {
          MMGestureGallery.e(this.wdi, 0.0F);
          MMGestureGallery.f(this.wdi, MMGestureGallery.a(this.wdi).getScale());
          MMGestureGallery.a(this.wdi, true);
        }
        if (paramMotionEvent.getAction() != 2) {
          break label1752;
        }
        if (f.J(paramMotionEvent) != 2) {
          break label1814;
        }
        cIZ();
        if ((!MMGestureGallery.M(this.wdi)) && (!MMGestureGallery.v(this.wdi)) && (!MMGestureGallery.w(this.wdi))) {
          break label1671;
        }
        return true;
        if (MMGestureGallery.o(this.wdi) != 2) {
          break;
        }
        MMGestureGallery.b(this.wdi, System.currentTimeMillis());
        if (MMGestureGallery.p(this.wdi) - MMGestureGallery.q(this.wdi) < 350L)
        {
          if ((Math.abs(MMGestureGallery.i(this.wdi) - f.c(paramMotionEvent, 0)) < 35.0F) && (Math.abs(MMGestureGallery.j(this.wdi) - f.d(paramMotionEvent, 0)) < 35.0F))
          {
            MMGestureGallery.a(this.wdi, 0);
            y.d("MicroMsg.MMGestureGallery", "double click!");
            if (MMGestureGallery.a(this.wdi).getScale() <= MMGestureGallery.a(this.wdi).getScaleRate())
            {
              MMGestureGallery.a(this.wdi).ad(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
              break;
            }
            MMGestureGallery.a(this.wdi).ac(f.c(paramMotionEvent, 0), f.d(paramMotionEvent, 0));
            MMGestureGallery.a(this.wdi).cBl();
            break;
          }
          MMGestureGallery.a(this.wdi, 1);
          break;
        }
        MMGestureGallery.a(this.wdi, 1);
        break;
        label1351:
        if ((MMGestureGallery.v(this.wdi)) || (MMGestureGallery.t(this.wdi)))
        {
          MMGestureGallery.C(this.wdi);
          MMGestureGallery.A(this.wdi);
          MMGestureGallery.a(this.wdi, new MMGestureGallery.i(this.wdi));
          MMGestureGallery.z(this.wdi);
        }
        if ((MMGestureGallery.w(this.wdi)) || (MMGestureGallery.u(this.wdi)))
        {
          MMGestureGallery.D(this.wdi);
          MMGestureGallery.B(this.wdi);
          MMGestureGallery.a(this.wdi, new MMGestureGallery.j(this.wdi));
          MMGestureGallery.z(this.wdi);
        }
        if (MMGestureGallery.x(this.wdi))
        {
          MMGestureGallery.E(this.wdi);
          MMGestureGallery.a(this.wdi, new MMGestureGallery.k(this.wdi));
          MMGestureGallery.z(this.wdi);
        }
        if (MMGestureGallery.y(this.wdi))
        {
          MMGestureGallery.F(this.wdi);
          MMGestureGallery.a(this.wdi, new MMGestureGallery.g(this.wdi));
          MMGestureGallery.z(this.wdi);
        }
        if (MMGestureGallery.G(this.wdi))
        {
          if (MMGestureGallery.H(this.wdi) != null) {
            MMGestureGallery.H(this.wdi).X(0.0F, 0.0F);
          }
          MMGestureGallery.b(this.wdi, false);
        }
        if ((!MMGestureGallery.I(this.wdi)) || (MMGestureGallery.J(this.wdi))) {
          break label913;
        }
        MMGestureGallery.K(this.wdi).x(0L, true);
        MMGestureGallery.b(this.wdi, false);
        break label913;
        label1650:
        MMGestureGallery.a(this.wdi, 0);
        y.d("MicroMsg.MMGestureGallery", "single long click over!");
      }
      label1671:
      MMGestureGallery.a(this.wdi, true);
      MMGestureGallery.a(this.wdi, 0);
      f1 = f.c(paramMotionEvent, 0) - f.c(paramMotionEvent, 1);
      f2 = f.d(paramMotionEvent, 0) - f.d(paramMotionEvent, 1);
      f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
      if (MMGestureGallery.N(this.wdi) != 0.0F) {
        break label1754;
      }
      MMGestureGallery.e(this.wdi, f3);
    }
    for (;;)
    {
      label1752:
      return false;
      label1754:
      f3 /= MMGestureGallery.N(this.wdi);
      if (MMGestureGallery.O(this.wdi)) {
        MMGestureGallery.a(this.wdi).k(f3 * MMGestureGallery.m(this.wdi), f1 + f.c(paramMotionEvent, 1), f.d(paramMotionEvent, 1) + f2);
      }
    }
    label1814:
    paramView = MMGestureGallery.f(this.wdi);
    paramView.computeCurrentVelocity(1000);
    int i = (int)paramView.getXVelocity();
    int j = (int)paramView.getYVelocity();
    float f1 = paramMotionEvent.getX() - MMGestureGallery.P(this.wdi);
    float f2 = paramMotionEvent.getY() - MMGestureGallery.Q(this.wdi);
    if ((MMGestureGallery.H(this.wdi) != null) && (!MMGestureGallery.J(this.wdi)) && (!MMGestureGallery.O(this.wdi)) && (MMGestureGallery.m(this.wdi) <= MMGestureGallery.a(this.wdi).getScaleRate()))
    {
      MMGestureGallery.H(this.wdi).Y(f1, f2);
      if (((Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (j <= 0) || (MMGestureGallery.k(this.wdi))) && (!MMGestureGallery.I(this.wdi))) {
        break label2118;
      }
      MMGestureGallery.H(this.wdi).X(f1, f2);
      MMGestureGallery.b(this.wdi, true);
      label2009:
      if (f2 <= 200.0F) {
        break label2130;
      }
      MMGestureGallery.c(this.wdi, false);
    }
    for (;;)
    {
      if (MMGestureGallery.f(this.wdi) != null)
      {
        MMGestureGallery.f(this.wdi).recycle();
        MMGestureGallery.a(this.wdi, null);
      }
      if ((Math.abs(MMGestureGallery.i(this.wdi) - f.c(paramMotionEvent, 0)) <= 35.0F) && (Math.abs(MMGestureGallery.j(this.wdi) - f.d(paramMotionEvent, 0)) <= 35.0F)) {
        break;
      }
      cIZ();
      MMGestureGallery.a(this.wdi, 0);
      break;
      label2118:
      MMGestureGallery.b(this.wdi, false);
      break label2009;
      label2130:
      MMGestureGallery.c(this.wdi, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.tools.MMGestureGallery.1
 * JD-Core Version:    0.7.0.1
 */