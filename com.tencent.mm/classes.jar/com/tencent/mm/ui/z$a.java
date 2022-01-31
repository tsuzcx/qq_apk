package com.tencent.mm.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.n;
import android.support.v4.view.ViewPager.e;
import android.view.View;
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.contact.AddressUI.a;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.y.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public final class z$a
  extends n
  implements ViewPager.e, c.a
{
  private int oFs = 0;
  private AddressUI.a uOT;
  private final WxViewPager uOU;
  private boolean uOV = false;
  boolean[] uOW = { 1, 0, 0, 0 };
  
  public z$a(z paramz, FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager)
  {
    super(paramFragmentActivity.getSupportFragmentManager());
    this.uOU = paramWxViewPager;
    this.uOU.setAdapter(this);
    this.uOU.setOnPageChangeListener(this);
  }
  
  private void fl(int paramInt1, int paramInt2)
  {
    if (this.uOS.FZ(paramInt1) != null)
    {
      View localView = this.uOS.FZ(paramInt1).findViewById(R.h.loading_progress_bar);
      if (localView != null) {
        localView.setVisibility(paramInt2);
      }
    }
  }
  
  public final void Q(int paramInt)
  {
    y.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (this.uOT != null))
    {
      this.uOT.nv(true);
      this.uOT = null;
    }
  }
  
  public final void R(int paramInt)
  {
    y.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
    y.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", new Object[] { Integer.valueOf(this.oFs), Integer.valueOf(paramInt) });
    if (this.oFs > 0)
    {
      this.oFs -= 1;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.uOV = false;
      z.a(this.uOS, z.e(this.uOS));
      z.b(this.uOS, paramInt);
      z.c(this.uOS).Gb(paramInt);
      z.f(this.uOS).supportInvalidateOptionsMenu();
      if ((z.d(this.uOS) == 1) && (z.e(this.uOS) != 1))
      {
        au.Hx();
        com.tencent.mm.model.c.Dz().o(340226, Long.valueOf(System.currentTimeMillis()));
      }
      if (z.e(this.uOS) == 1)
      {
        long l = System.currentTimeMillis();
        au.Hx();
        if (l - ah.d((Long)com.tencent.mm.model.c.Dz().get(340226, null)) >= 180000L) {
          ((AddressUI.a)this.uOS.FZ(z.e(this.uOS))).cHq();
        }
      }
      if (z.e(this.uOS) != 0) {
        break;
      }
      au.getNotification().bc(true);
      return;
      h.nFQ.aC(10957, "1");
      continue;
      h.nFQ.aC(10957, "2");
      continue;
      h.nFQ.aC(10957, "3");
      continue;
      h.nFQ.aC(10957, "4");
      continue;
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        h.nFQ.aC(10957, "5");
        break;
      case 1: 
        h.nFQ.aC(10957, "6");
        break;
      case 2: 
        h.nFQ.aC(10957, "7");
      }
    }
    au.getNotification().bc(false);
  }
  
  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject = z.c(this.uOS);
    if (((aa)localObject).uOZ != null) {
      ((aa)localObject).uOZ.i(paramInt1, paramFloat);
    }
    Integer localInteger;
    if (0.0F != paramFloat)
    {
      if (this.uOT == null) {
        this.uOT = ((AddressUI.a)this.uOS.FZ(1));
      }
      this.uOT.nv(false);
      if (paramInt2 == 0) {
        localObject = z.czQ().values().iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject).hasNext()) {
          return;
        }
        localInteger = (Integer)((Iterator)localObject).next();
        if (localInteger.intValue() != paramInt1)
        {
          fl(localInteger.intValue(), 8);
          continue;
          y.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(z.d(this.uOS)) });
          if (-1 == z.d(this.uOS))
          {
            this.uOS.fk(z.d(this.uOS), z.e(this.uOS));
            this.uOS.FX(paramInt1);
            break;
          }
          ai.d(new z.a.1(this, paramInt1));
          break;
        }
        if (this.uOW[localInteger.intValue()] == 0) {
          fl(localInteger.intValue(), 0);
        }
      }
    }
    localObject = z.czQ().values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localInteger = (Integer)((Iterator)localObject).next();
      if ((localInteger.intValue() != paramInt1) && (this.uOW[localInteger.intValue()] == 0)) {
        fl(localInteger.intValue(), 0);
      }
    }
  }
  
  public final Fragment ae(int paramInt)
  {
    return this.uOS.FZ(paramInt);
  }
  
  public final int getCount()
  {
    return 4;
  }
  
  public final void qc(int paramInt)
  {
    if (!z.a(this.uOS)) {
      y.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
    }
    do
    {
      Object localObject;
      do
      {
        return;
        if (paramInt != z.e(this.uOS)) {
          break;
        }
        y.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
        localObject = this.uOS.FZ(paramInt);
      } while (!(localObject instanceof AbstractTabChildActivity.a));
      ((AbstractTabChildActivity.a)localObject).cxJ();
      return;
      this.uOV = true;
      this.oFs += 1;
      y.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", new Object[] { Integer.valueOf(this.oFs) });
      this.uOU.m(paramInt, false);
      if (paramInt == 3)
      {
        com.tencent.mm.y.c.BS().bd(262145, 266241);
        com.tencent.mm.y.c.BS().bd(262156, 266241);
        com.tencent.mm.y.c.BS().bd(262147, 266241);
        com.tencent.mm.y.c.BS().bd(262149, 266241);
        com.tencent.mm.y.c.BS().b(ac.a.uyT, 266241);
        boolean bool = com.tencent.mm.y.c.BS().bc(262156, 266241);
        localObject = h.nFQ;
        if (bool) {}
        for (paramInt = 1;; paramInt = 0)
        {
          ((h)localObject).f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
          g.DQ();
          g.DP().Dz().c(ac.a.uyI, Boolean.valueOf(false));
          return;
        }
      }
    } while (paramInt != 2);
    com.tencent.mm.y.c.BS().b(ac.a.uzK, 266241);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.z.a
 * JD-Core Version:    0.7.0.1
 */