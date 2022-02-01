package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.i.a.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.contact.AddressUI.AddressUIFragment;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MainTabUI
{
  private static HashMap<String, Integer> HpA;
  MMFragmentActivity Hjt;
  public HashMap<Integer, MMFragment> HpB;
  aa Hpp;
  LauncherUI.d Hpq;
  boolean Hpr;
  private HashSet<m> Hps;
  private int Hpt;
  private int Hpu;
  a Hpv;
  com.tencent.mm.sdk.b.c Hpw;
  private boolean Hpx;
  com.tencent.mm.sdk.b.c Hpy;
  com.tencent.mm.sdk.b.c Hpz;
  public int aaj;
  private int aak;
  private final long hYc;
  TabsAdapter mTabsAdapter;
  CustomViewPager mViewPager;
  com.tencent.mm.plugin.appbrand.widget.header.a mtS;
  
  static
  {
    AppMethodBeat.i(33486);
    HashMap localHashMap = new HashMap();
    HpA = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    HpA.put("tab_address", Integer.valueOf(1));
    HpA.put("tab_find_friend", Integer.valueOf(2));
    HpA.put("tab_settings", Integer.valueOf(3));
    AppMethodBeat.o(33486);
  }
  
  public MainTabUI()
  {
    AppMethodBeat.i(33466);
    this.hYc = 180000L;
    this.Hpp = new aa();
    this.Hps = new HashSet();
    this.aaj = -1;
    this.aak = -1;
    this.Hpt = -1;
    this.Hpu = -1;
    this.Hpw = new com.tencent.mm.sdk.b.c() {};
    this.Hpx = true;
    this.Hpy = new com.tencent.mm.sdk.b.c() {};
    this.Hpz = new com.tencent.mm.sdk.b.c() {};
    this.HpB = new HashMap();
    AppMethodBeat.o(33466);
  }
  
  private MMFragment ZD(int paramInt)
  {
    AppMethodBeat.i(33478);
    MMFragment localMMFragment = null;
    Object localObject1 = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ac.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localMMFragment != null) {
        localMMFragment.setParent(this.Hjt);
      }
      AppMethodBeat.o(33478);
      return localMMFragment;
      ((Bundle)localObject1).putInt(MainUI.class.getName(), 0);
      localMMFragment = (MMFragment)Fragment.instantiate(this.Hjt, MainUI.class.getName(), (Bundle)localObject1);
      if ((localMMFragment instanceof MainUI))
      {
        localObject1 = (MainUI)localMMFragment;
        Object localObject2 = this.Hjt;
        ((MainUI)localObject1).mvz = ((MMFragmentActivity)localObject2);
        if (((MainUI)localObject1).IFc != null) {
          ((MainUI)localObject1).IFc.setActivity((MMFragmentActivity)localObject2);
        }
        localObject1 = (MainUI)localMMFragment;
        localObject2 = this.mtS;
        ((MainUI)localObject1).IFj = ((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        if (((MainUI)localObject1).IFc != null) {
          ((MainUI)localObject1).IFc.setActionBarUpdateCallback((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        }
      }
      az.getNotification().cx(true);
      continue;
      ((Bundle)localObject1).putInt(AddressUI.AddressUIFragment.class.getName(), 1);
      ((Bundle)localObject1).putBoolean("Need_Voice_Search", true);
      ((Bundle)localObject1).putBoolean("favour_include_biz", true);
      localMMFragment = (MMFragment)Fragment.instantiate(this.Hjt, AddressUI.AddressUIFragment.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(FindMoreFriendsUI.class.getName(), 2);
      localMMFragment = (MMFragment)Fragment.instantiate(this.Hjt, FindMoreFriendsUI.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(MoreTabUI.class.getName(), 3);
      localMMFragment = (MMFragment)Fragment.instantiate(this.Hjt, MoreTabUI.class.getName(), (Bundle)localObject1);
    }
  }
  
  private void fgQ()
  {
    AppMethodBeat.i(33470);
    this.HpB.clear();
    if (this.mViewPager != null)
    {
      this.mViewPager.setCanSlide(false);
      this.mViewPager.setCanSlideBySide(false);
    }
    AppMethodBeat.o(33470);
  }
  
  public final void ZB(int paramInt)
  {
    AppMethodBeat.i(33468);
    MainUI localMainUI = (MainUI)this.HpB.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.ZB(paramInt);
    }
    AppMethodBeat.o(33468);
  }
  
  public final void ZC(int paramInt)
  {
    AppMethodBeat.i(33474);
    MMFragment localMMFragment = ZF(paramInt);
    if (localMMFragment == null)
    {
      AppMethodBeat.o(33474);
      return;
    }
    if ((localMMFragment instanceof m)) {
      ((m)localMMFragment).feL();
    }
    this.mTabsAdapter.mFragmentResumedFlags[paramInt] = true;
    AppMethodBeat.o(33474);
  }
  
  public final void ZE(int paramInt)
  {
    AppMethodBeat.i(33479);
    int i = this.aaj;
    if (this.mViewPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      ac.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.HpB.size()) });
      if ((this.mViewPager != null) && (paramInt >= 0) && ((this.mTabsAdapter == null) || (paramInt <= this.mTabsAdapter.getCount() - 1))) {
        break;
      }
      AppMethodBeat.o(33479);
      return;
    }
    if ((this.aaj == paramInt) && (this.HpB.size() != 0))
    {
      AppMethodBeat.o(33479);
      return;
    }
    i = this.aaj;
    this.aaj = paramInt;
    this.Hpp.ZG(this.aaj);
    if (this.mViewPager != null)
    {
      if (i == -1)
      {
        this.mViewPager.setCurrentItemNotify(this.aaj, false);
        ZC(this.aaj);
      }
    }
    else
    {
      if ((this.aaj != 0) || (!com.tencent.matrix.a.cqa.cqc)) {
        break label264;
      }
      az.getNotification().cx(true);
    }
    for (;;)
    {
      if (this.aaj != 0)
      {
        MMFragment localMMFragment = ZF(0);
        if ((localMMFragment instanceof MainUI)) {
          ((MainUI)localMMFragment).fsz();
        }
      }
      AppMethodBeat.o(33479);
      return;
      this.mViewPager.setCurrentItem(this.aaj, false);
      break;
      label264:
      az.getNotification().cx(false);
    }
  }
  
  public final MMFragment ZF(int paramInt)
  {
    AppMethodBeat.i(33480);
    ac.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(33480);
      return null;
    }
    if (this.HpB.containsKey(Integer.valueOf(paramInt)))
    {
      localMMFragment = (MMFragment)this.HpB.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(33480);
      return localMMFragment;
    }
    MMFragment localMMFragment = ZD(paramInt);
    this.HpB.put(Integer.valueOf(paramInt), localMMFragment);
    AppMethodBeat.o(33480);
    return localMMFragment;
  }
  
  public final void aPD(String paramString)
  {
    AppMethodBeat.i(33477);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(33477);
      return;
    }
    ZE(((Integer)HpA.get(paramString)).intValue());
    AppMethodBeat.o(33477);
  }
  
  public final void bMp()
  {
    AppMethodBeat.i(33469);
    com.tencent.mm.sdk.b.a.GpY.d(this.Hpw);
    com.tencent.mm.sdk.b.a.GpY.d(this.Hpy);
    com.tencent.mm.sdk.b.a.GpY.d(this.Hpz);
    fgQ();
    AppMethodBeat.o(33469);
  }
  
  public final void ffR()
  {
    AppMethodBeat.i(33475);
    MainUI localMainUI = (MainUI)this.HpB.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.Hjt.findViewById(2131301337);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localMainUI != null) {
      localMainUI.onHiddenChanged(true);
    }
    j.a(this.Hjt, 4, this.aaj, "prepareStartChatting");
    fgR();
    this.Hpp.fgT();
    AppMethodBeat.o(33475);
  }
  
  public final void ffV()
  {
    AppMethodBeat.i(33471);
    MainUI localMainUI = (MainUI)this.HpB.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      localMainUI.fqR();
      localMainUI.fsx();
    }
    AppMethodBeat.o(33471);
  }
  
  public final MMFragment fgP()
  {
    AppMethodBeat.i(33467);
    MMFragment localMMFragment = (MMFragment)this.HpB.get(Integer.valueOf(this.aaj));
    AppMethodBeat.o(33467);
    return localMMFragment;
  }
  
  public final void fgR()
  {
    AppMethodBeat.i(33472);
    MainUI localMainUI = (MainUI)this.HpB.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.fsy();
    }
    AppMethodBeat.o(33472);
  }
  
  public final void fgS()
  {
    AppMethodBeat.i(33476);
    if ((this.aaj == 0) && (g.agQ().ghe.foreground)) {
      az.getNotification().cx(true);
    }
    for (;;)
    {
      Object localObject = (ViewGroup)this.Hjt.findViewById(2131301337);
      if (localObject != null) {
        ((ViewGroup)localObject).setImportantForAccessibility(1);
      }
      ffV();
      j.a(this.Hjt, 3, this.aaj, "prepareCloseChatting");
      localObject = (MainUI)this.HpB.get(Integer.valueOf(0));
      if (localObject != null)
      {
        ((MainUI)localObject).getContentView();
        if (((MainUI)localObject).mController != null) {
          ((MainUI)localObject).mController.onResume();
        }
        ((MainUI)localObject).onHiddenChanged(false);
      }
      com.tencent.mm.plugin.report.service.i.wUB.pQ(true);
      AppMethodBeat.o(33476);
      return;
      az.getNotification().cx(false);
    }
  }
  
  protected final void fgT()
  {
    AppMethodBeat.i(33481);
    this.Hpp.fgT();
    AppMethodBeat.o(33481);
  }
  
  protected final void fgU()
  {
    AppMethodBeat.i(33482);
    this.Hpp.fgU();
    AppMethodBeat.o(33482);
  }
  
  protected final void fgV()
  {
    AppMethodBeat.i(33483);
    this.Hpp.fgV();
    AppMethodBeat.o(33483);
  }
  
  public final int fgW()
  {
    AppMethodBeat.i(33484);
    aa localaa = this.Hpp;
    long l = System.currentTimeMillis();
    int i = com.tencent.mm.ui.conversation.h.fsb();
    if (localaa.HpE != null)
    {
      localaa.HpE.Zj(i);
      localaa.HpD.ffU();
    }
    ac.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
    AppMethodBeat.o(33484);
    return i;
  }
  
  public final void fgX()
  {
    AppMethodBeat.i(33485);
    this.HpB.get(Integer.valueOf(0));
    AppMethodBeat.o(33485);
  }
  
  public final void jq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33473);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(33473);
      return;
    }
    MMFragment localMMFragment = ZF(paramInt1);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).ffH();
    }
    localMMFragment = ZF(paramInt2);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).ffG();
    }
    j.a(this.Hjt, 4, paramInt1, "deliverOnTabChange");
    j.a(this.Hjt, 3, paramInt2, "deliverOnTabChange");
    AppMethodBeat.o(33473);
  }
  
  public class TabsAdapter
    extends android.support.v4.app.j
    implements ViewPager.OnPageChangeListener, c.a
  {
    private byte _hellAccFlag_;
    private AddressUI.AddressUIFragment addressFragment;
    private int clickCount;
    private boolean isTabClicked;
    boolean[] mFragmentResumedFlags;
    private final WxViewPager mViewPager;
    
    public TabsAdapter(FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager)
    {
      super();
      AppMethodBeat.i(33457);
      this.isTabClicked = false;
      this.clickCount = 0;
      this.mFragmentResumedFlags = new boolean[] { 1, 0, 0, 0 };
      this.mViewPager = paramWxViewPager;
      this.mViewPager.setAdapter(this);
      this.mViewPager.setOnPageChangeListener(this);
      AppMethodBeat.o(33457);
    }
    
    private void fixAndroidOProgressBarOutScreenFlashProblem(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33460);
      Integer localInteger;
      if (paramInt2 == 0)
      {
        localIterator = MainTabUI.fgY().values().iterator();
        while (localIterator.hasNext())
        {
          localInteger = (Integer)localIterator.next();
          if (localInteger.intValue() != paramInt1) {
            setFragmentLoadingIconVisibility(localInteger.intValue(), 8);
          } else if (this.mFragmentResumedFlags[localInteger.intValue()] == 0) {
            setFragmentLoadingIconVisibility(localInteger.intValue(), 0);
          }
        }
        AppMethodBeat.o(33460);
        return;
      }
      Iterator localIterator = MainTabUI.fgY().values().iterator();
      while (localIterator.hasNext())
      {
        localInteger = (Integer)localIterator.next();
        if ((localInteger.intValue() != paramInt1) && (this.mFragmentResumedFlags[localInteger.intValue()] == 0)) {
          setFragmentLoadingIconVisibility(localInteger.intValue(), 0);
        }
      }
      AppMethodBeat.o(33460);
    }
    
    private void reportSwitch(int paramInt)
    {
      boolean bool = true;
      AppMethodBeat.i(33463);
      ac.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", new Object[] { Integer.valueOf(this.clickCount), Integer.valueOf(paramInt) });
      com.tencent.mm.plugin.report.service.i locali = com.tencent.mm.plugin.report.service.i.wUB;
      if (paramInt == 0)
      {
        locali.pQ(bool);
        if (this.clickCount <= 0) {
          break label168;
        }
        this.clickCount -= 1;
        switch (paramInt)
        {
        }
      }
      for (;;)
      {
        this.isTabClicked = false;
        AppMethodBeat.o(33463);
        return;
        bool = false;
        break;
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10957, "1");
        continue;
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10957, "2");
        continue;
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10957, "3");
        continue;
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(10957, "4");
        continue;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10957, "5");
          break;
        case 1: 
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10957, "6");
          break;
        case 2: 
          label168:
          com.tencent.mm.plugin.report.service.h.wUl.kvStat(10957, "7");
        }
      }
    }
    
    private void setFragmentLoadingIconVisibility(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33461);
      if ((MainTabUI.this.ZF(paramInt1) != null) && (MainTabUI.this.ZF(paramInt1).getActivity() != null))
      {
        View localView = MainTabUI.this.ZF(paramInt1).findViewById(2131301509);
        if (localView != null) {
          localView.setVisibility(paramInt2);
        }
      }
      AppMethodBeat.o(33461);
    }
    
    public int getCount()
    {
      return 4;
    }
    
    public Fragment getItem(int paramInt)
    {
      AppMethodBeat.i(33458);
      MMFragment localMMFragment = MainTabUI.this.ZF(paramInt);
      AppMethodBeat.o(33458);
      return localMMFragment;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(33464);
      ac.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (this.addressFragment != null))
      {
        this.addressFragment.xw(true);
        this.addressFragment = null;
      }
      if (MainTabUI.d(MainTabUI.this) != null) {
        MainTabUI.d(MainTabUI.this).Zr(paramInt);
      }
      AppMethodBeat.o(33464);
    }
    
    public void onPageScrolled(final int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33459);
      aa localaa = MainTabUI.c(MainTabUI.this);
      if (localaa.HpE != null) {
        localaa.HpE.n(paramInt1, paramFloat);
      }
      if (MainTabUI.d(MainTabUI.this) != null) {
        MainTabUI.d(MainTabUI.this).u(paramInt1, paramFloat);
      }
      if (0.0F != paramFloat)
      {
        if (this.addressFragment == null) {
          this.addressFragment = ((AddressUI.AddressUIFragment)MainTabUI.this.ZF(1));
        }
        this.addressFragment.xw(false);
      }
      for (;;)
      {
        fixAndroidOProgressBarOutScreenFlashProblem(paramInt1, paramFloat, paramInt2);
        AppMethodBeat.o(33459);
        return;
        ac.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(MainTabUI.e(MainTabUI.this)) });
        if (-1 == MainTabUI.e(MainTabUI.this))
        {
          MainTabUI.this.jq(MainTabUI.e(MainTabUI.this), MainTabUI.f(MainTabUI.this));
          MainTabUI.this.ZC(paramInt1);
        }
        else
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33456);
              MainTabUI.this.jq(MainTabUI.e(MainTabUI.this), MainTabUI.f(MainTabUI.this));
              MainTabUI.this.ZC(paramInt1);
              AppMethodBeat.o(33456);
            }
          });
        }
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(33462);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aeE());
      ac.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
      switch (paramInt)
      {
      default: 
        reportSwitch(paramInt);
        MainTabUI.a(MainTabUI.this, MainTabUI.f(MainTabUI.this));
        MainTabUI.b(MainTabUI.this, paramInt);
        MainTabUI.c(MainTabUI.this).ZG(paramInt);
        MainTabUI.g(MainTabUI.this).supportInvalidateOptionsMenu();
        localObject = MainTabUI.this.ZF(MainTabUI.f(MainTabUI.this));
        if ((MainTabUI.e(MainTabUI.this) == 1) && (MainTabUI.f(MainTabUI.this) != 1))
        {
          az.ayM();
          com.tencent.mm.model.c.agA().set(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (MainTabUI.f(MainTabUI.this) == 1)
        {
          long l = System.currentTimeMillis();
          az.ayM();
          if (l - bs.a((Long)com.tencent.mm.model.c.agA().get(340226, null), 0L) >= 180000L) {
            ((AddressUI.AddressUIFragment)localObject).fqT();
          }
        }
        if (MainTabUI.f(MainTabUI.this) == 0) {
          az.getNotification().cx(true);
        }
        break;
      }
      for (;;)
      {
        if ((localObject != null) && (com.tencent.matrix.b.Gp()) && (((MMFragment)localObject).getActivity() != null))
        {
          String str = ((MMFragment)localObject).getActivity().getClass().getName();
          com.tencent.matrix.a.cqa.cF(str + "#" + localObject.getClass().getSimpleName());
        }
        if (MainTabUI.d(MainTabUI.this) != null) {
          MainTabUI.d(MainTabUI.this).Zq(MainTabUI.f(MainTabUI.this));
        }
        localObject = new jv();
        ((jv)localObject).dlp.currentIndex = MainTabUI.f(MainTabUI.this);
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
        com.tencent.mm.plugin.newtips.a.dkb().Ko(2);
        ((l)g.ad(l.class)).getRedDotManager().adv("Discovery");
        break;
        com.tencent.mm.plugin.newtips.a.dkb().Ko(1);
        break;
        az.getNotification().cx(false);
      }
    }
    
    public void onTabClick(int paramInt)
    {
      AppMethodBeat.i(33465);
      if (!MainTabUI.a(MainTabUI.this))
      {
        ac.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
        AppMethodBeat.o(33465);
        return;
      }
      Object localObject;
      if (paramInt == MainTabUI.f(MainTabUI.this))
      {
        ac.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
        localObject = MainTabUI.this.ZF(paramInt);
        if ((localObject instanceof AbstractTabChildActivity.AbStractTabFragment)) {
          ((AbstractTabChildActivity.AbStractTabFragment)localObject).feE();
        }
        AppMethodBeat.o(33465);
        return;
      }
      this.isTabClicked = true;
      this.clickCount += 1;
      ac.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", new Object[] { Integer.valueOf(this.clickCount) });
      this.mViewPager.setCurrentItem(paramInt, false);
      if (paramInt == 3)
      {
        com.tencent.mm.y.c.aeH().cI(262145, 266241);
        com.tencent.mm.y.c.aeH().cI(262156, 266241);
        com.tencent.mm.y.c.aeH().cI(262147, 266241);
        com.tencent.mm.y.c.aeH().cI(262149, 266241);
        com.tencent.mm.y.c.aeH().cI(262152, 266241);
        com.tencent.mm.y.c.aeH().b(ah.a.GQM, 266241);
        com.tencent.mm.y.c.aeH().c(ah.a.GPM, ah.a.GPU);
        boolean bool = com.tencent.mm.y.c.aeH().cH(262156, 266241);
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        if (!bool) {
          break label309;
        }
      }
      label309:
      for (paramInt = 1;; paramInt = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
        g.agS();
        g.agR().agA().set(ah.a.GPG, Boolean.FALSE);
        AppMethodBeat.o(33465);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Zq(int paramInt);
    
    public abstract void Zr(int paramInt);
    
    public abstract void u(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI
 * JD-Core Version:    0.7.0.1
 */