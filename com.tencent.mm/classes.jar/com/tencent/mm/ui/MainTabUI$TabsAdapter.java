package com.tencent.mm.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import com.tencent.matrix.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.contact.AddressUI.AddressUIFragment;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class MainTabUI$TabsAdapter
  extends j
  implements ViewPager.OnPageChangeListener, c.a
{
  private AddressUI.AddressUIFragment addressFragment;
  private int clickCount;
  private boolean isTabClicked;
  boolean[] mFragmentResumedFlags;
  private final WxViewPager mViewPager;
  
  public MainTabUI$TabsAdapter(MainTabUI paramMainTabUI, FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager)
  {
    super(paramFragmentActivity.getSupportFragmentManager());
    AppMethodBeat.i(29620);
    this.isTabClicked = false;
    this.clickCount = 0;
    this.mFragmentResumedFlags = new boolean[] { 1, 0, 0, 0 };
    this.mViewPager = paramWxViewPager;
    this.mViewPager.setAdapter(this);
    this.mViewPager.setOnPageChangeListener(this);
    AppMethodBeat.o(29620);
  }
  
  private void fixAndroidOProgressBarOutScreenFlashProblem(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(29623);
    Integer localInteger;
    if (paramInt2 == 0)
    {
      localIterator = MainTabUI.dCL().values().iterator();
      while (localIterator.hasNext())
      {
        localInteger = (Integer)localIterator.next();
        if (localInteger.intValue() != paramInt1) {
          setFragmentLoadingIconVisibility(localInteger.intValue(), 8);
        } else if (this.mFragmentResumedFlags[localInteger.intValue()] == 0) {
          setFragmentLoadingIconVisibility(localInteger.intValue(), 0);
        }
      }
      AppMethodBeat.o(29623);
      return;
    }
    Iterator localIterator = MainTabUI.dCL().values().iterator();
    while (localIterator.hasNext())
    {
      localInteger = (Integer)localIterator.next();
      if ((localInteger.intValue() != paramInt1) && (this.mFragmentResumedFlags[localInteger.intValue()] == 0)) {
        setFragmentLoadingIconVisibility(localInteger.intValue(), 0);
      }
    }
    AppMethodBeat.o(29623);
  }
  
  private void reportSwitch(int paramInt)
  {
    AppMethodBeat.i(29626);
    ab.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", new Object[] { Integer.valueOf(this.clickCount), Integer.valueOf(paramInt) });
    if (this.clickCount > 0)
    {
      this.clickCount -= 1;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.isTabClicked = false;
      AppMethodBeat.o(29626);
      return;
      h.qsU.kvStat(10957, "1");
      continue;
      h.qsU.kvStat(10957, "2");
      continue;
      h.qsU.kvStat(10957, "3");
      continue;
      h.qsU.kvStat(10957, "4");
      continue;
      switch (paramInt)
      {
      default: 
        break;
      case 0: 
        h.qsU.kvStat(10957, "5");
        break;
      case 1: 
        h.qsU.kvStat(10957, "6");
        break;
      case 2: 
        h.qsU.kvStat(10957, "7");
      }
    }
  }
  
  private void setFragmentLoadingIconVisibility(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29624);
    if ((this.this$0.On(paramInt1) != null) && (this.this$0.On(paramInt1).getActivity() != null))
    {
      View localView = this.this$0.On(paramInt1).findViewById(2131823427);
      if (localView != null) {
        localView.setVisibility(paramInt2);
      }
    }
    AppMethodBeat.o(29624);
  }
  
  public int getCount()
  {
    return 4;
  }
  
  public Fragment getItem(int paramInt)
  {
    AppMethodBeat.i(29621);
    MMFragment localMMFragment = this.this$0.On(paramInt);
    AppMethodBeat.o(29621);
    return localMMFragment;
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    AppMethodBeat.i(29627);
    ab.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (this.addressFragment != null))
    {
      this.addressFragment.re(true);
      this.addressFragment = null;
    }
    if (MainTabUI.d(this.this$0) != null) {
      MainTabUI.d(this.this$0).Oc(paramInt);
    }
    AppMethodBeat.o(29627);
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(29622);
    x localx = MainTabUI.c(this.this$0);
    if (localx.zcL != null) {
      localx.zcL.k(paramInt1, paramFloat);
    }
    if (MainTabUI.d(this.this$0) != null) {
      MainTabUI.d(this.this$0).o(paramInt1, paramFloat);
    }
    if (0.0F != paramFloat)
    {
      if (this.addressFragment == null) {
        this.addressFragment = ((AddressUI.AddressUIFragment)this.this$0.On(1));
      }
      this.addressFragment.re(false);
    }
    for (;;)
    {
      fixAndroidOProgressBarOutScreenFlashProblem(paramInt1, paramFloat, paramInt2);
      AppMethodBeat.o(29622);
      return;
      ab.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(MainTabUI.e(this.this$0)) });
      if (-1 == MainTabUI.e(this.this$0))
      {
        this.this$0.hr(MainTabUI.e(this.this$0), MainTabUI.f(this.this$0));
        this.this$0.Ok(paramInt1);
      }
      else
      {
        al.d(new MainTabUI.TabsAdapter.1(this, paramInt1));
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(29625);
    ab.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
    reportSwitch(paramInt);
    MainTabUI.a(this.this$0, MainTabUI.f(this.this$0));
    MainTabUI.b(this.this$0, paramInt);
    MainTabUI.c(this.this$0).Op(paramInt);
    MainTabUI.g(this.this$0).supportInvalidateOptionsMenu();
    MMFragment localMMFragment = this.this$0.On(MainTabUI.f(this.this$0));
    if ((MainTabUI.e(this.this$0) == 1) && (MainTabUI.f(this.this$0) != 1))
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(340226, Long.valueOf(System.currentTimeMillis()));
    }
    if (MainTabUI.f(this.this$0) == 1)
    {
      long l = System.currentTimeMillis();
      aw.aaz();
      if (l - ah.d((Long)com.tencent.mm.model.c.Ru().get(340226, null)) >= 180000L) {
        ((AddressUI.AddressUIFragment)localMMFragment).dLG();
      }
    }
    if (MainTabUI.f(this.this$0) == 0) {
      aw.getNotification().bE(true);
    }
    for (;;)
    {
      if ((localMMFragment != null) && (b.isInstalled()) && (localMMFragment.getActivity() != null))
      {
        String str = localMMFragment.getActivity().getClass().getName();
        com.tencent.matrix.a.bLP.cw(str + "#" + localMMFragment.getClass().getSimpleName());
      }
      if (MainTabUI.d(this.this$0) != null) {
        MainTabUI.d(this.this$0).Ob(MainTabUI.f(this.this$0));
      }
      AppMethodBeat.o(29625);
      return;
      aw.getNotification().bE(false);
    }
  }
  
  public void onTabClick(int paramInt)
  {
    AppMethodBeat.i(29628);
    if (!MainTabUI.a(this.this$0))
    {
      ab.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
      AppMethodBeat.o(29628);
      return;
    }
    Object localObject;
    if (paramInt == MainTabUI.f(this.this$0))
    {
      ab.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
      localObject = this.this$0.On(paramInt);
      if ((localObject instanceof AbstractTabChildActivity.AbStractTabFragment)) {
        ((AbstractTabChildActivity.AbStractTabFragment)localObject).dAE();
      }
      AppMethodBeat.o(29628);
      return;
    }
    this.isTabClicked = true;
    this.clickCount += 1;
    ab.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", new Object[] { Integer.valueOf(this.clickCount) });
    this.mViewPager.setCurrentItem(paramInt, false);
    if (paramInt == 3)
    {
      com.tencent.mm.x.c.PJ().ce(262145, 266241);
      com.tencent.mm.x.c.PJ().ce(262156, 266241);
      com.tencent.mm.x.c.PJ().ce(262147, 266241);
      com.tencent.mm.x.c.PJ().ce(262149, 266241);
      com.tencent.mm.x.c.PJ().ce(262152, 266241);
      com.tencent.mm.x.c.PJ().b(ac.a.yJH, 266241);
      com.tencent.mm.x.c.PJ().c(ac.a.yIY, ac.a.yJf);
      boolean bool = com.tencent.mm.x.c.PJ().cd(262156, 266241);
      localObject = h.qsU;
      if (!bool) {
        break label309;
      }
    }
    label309:
    for (paramInt = 1;; paramInt = 0)
    {
      ((h)localObject).e(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
      g.RM();
      g.RL().Ru().set(ac.a.yIS, Boolean.FALSE);
      AppMethodBeat.o(29628);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI.TabsAdapter
 * JD-Core Version:    0.7.0.1
 */