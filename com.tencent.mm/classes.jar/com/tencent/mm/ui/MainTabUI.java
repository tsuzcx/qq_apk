package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.aw;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.it;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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
  private static HashMap<String, Integer> FPP;
  MMFragmentActivity FKl;
  public z FPE;
  LauncherUI.d FPF;
  boolean FPG;
  private HashSet<m> FPH;
  private int FPI;
  private int FPJ;
  a FPK;
  com.tencent.mm.sdk.b.c FPL;
  private boolean FPM;
  com.tencent.mm.sdk.b.c FPN;
  com.tencent.mm.sdk.b.c FPO;
  public HashMap<Integer, MMFragment> FPQ;
  public int Zo;
  private int Zp;
  private final long hxB;
  com.tencent.mm.plugin.appbrand.widget.header.a lRQ;
  TabsAdapter mTabsAdapter;
  CustomViewPager mViewPager;
  
  static
  {
    AppMethodBeat.i(33486);
    HashMap localHashMap = new HashMap();
    FPP = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    FPP.put("tab_address", Integer.valueOf(1));
    FPP.put("tab_find_friend", Integer.valueOf(2));
    FPP.put("tab_settings", Integer.valueOf(3));
    AppMethodBeat.o(33486);
  }
  
  public MainTabUI()
  {
    AppMethodBeat.i(33466);
    this.hxB = 180000L;
    this.FPE = new z();
    this.FPH = new HashSet();
    this.Zo = -1;
    this.Zp = -1;
    this.FPI = -1;
    this.FPJ = -1;
    this.FPL = new com.tencent.mm.sdk.b.c() {};
    this.FPM = true;
    this.FPN = new com.tencent.mm.sdk.b.c() {};
    this.FPO = new com.tencent.mm.sdk.b.c() {};
    this.FPQ = new HashMap();
    AppMethodBeat.o(33466);
  }
  
  private MMFragment Xr(int paramInt)
  {
    AppMethodBeat.i(33478);
    MMFragment localMMFragment = null;
    Object localObject1 = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ad.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localMMFragment != null) {
        localMMFragment.setParent(this.FKl);
      }
      AppMethodBeat.o(33478);
      return localMMFragment;
      ((Bundle)localObject1).putInt(MainUI.class.getName(), 0);
      localMMFragment = (MMFragment)Fragment.instantiate(this.FKl, MainUI.class.getName(), (Bundle)localObject1);
      if ((localMMFragment instanceof MainUI))
      {
        localObject1 = (MainUI)localMMFragment;
        Object localObject2 = this.FKl;
        ((MainUI)localObject1).lTx = ((MMFragmentActivity)localObject2);
        if (((MainUI)localObject1).HeP != null) {
          ((MainUI)localObject1).HeP.setActivity((MMFragmentActivity)localObject2);
        }
        localObject1 = (MainUI)localMMFragment;
        localObject2 = this.lRQ;
        ((MainUI)localObject1).HeX = ((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        if (((MainUI)localObject1).HeP != null) {
          ((MainUI)localObject1).HeP.setActionBarUpdateCallback((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        }
      }
      az.getNotification().cw(true);
      continue;
      ((Bundle)localObject1).putInt(AddressUI.AddressUIFragment.class.getName(), 1);
      ((Bundle)localObject1).putBoolean("Need_Voice_Search", true);
      ((Bundle)localObject1).putBoolean("favour_include_biz", true);
      localMMFragment = (MMFragment)Fragment.instantiate(this.FKl, AddressUI.AddressUIFragment.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(FindMoreFriendsUI.class.getName(), 2);
      localMMFragment = (MMFragment)Fragment.instantiate(this.FKl, FindMoreFriendsUI.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(MoreTabUI.class.getName(), 3);
      localMMFragment = (MMFragment)Fragment.instantiate(this.FKl, MoreTabUI.class.getName(), (Bundle)localObject1);
    }
  }
  
  private void eRh()
  {
    AppMethodBeat.i(33470);
    this.FPQ.clear();
    if (this.mViewPager != null)
    {
      this.mViewPager.setCanSlide(false);
      this.mViewPager.setCanSlideBySide(false);
    }
    AppMethodBeat.o(33470);
  }
  
  public final void Xp(int paramInt)
  {
    AppMethodBeat.i(33468);
    MainUI localMainUI = (MainUI)this.FPQ.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.Xp(paramInt);
    }
    AppMethodBeat.o(33468);
  }
  
  public final void Xq(int paramInt)
  {
    AppMethodBeat.i(33474);
    MMFragment localMMFragment = Xt(paramInt);
    if (localMMFragment == null)
    {
      AppMethodBeat.o(33474);
      return;
    }
    if ((localMMFragment instanceof m)) {
      ((m)localMMFragment).ePh();
    }
    this.mTabsAdapter.mFragmentResumedFlags[paramInt] = true;
    AppMethodBeat.o(33474);
  }
  
  public final void Xs(int paramInt)
  {
    AppMethodBeat.i(33479);
    int i = this.Zo;
    if (this.mViewPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.FPQ.size()) });
      if ((this.mViewPager != null) && (paramInt >= 0) && ((this.mTabsAdapter == null) || (paramInt <= this.mTabsAdapter.getCount() - 1))) {
        break;
      }
      AppMethodBeat.o(33479);
      return;
    }
    if ((this.Zo == paramInt) && (this.FPQ.size() != 0))
    {
      AppMethodBeat.o(33479);
      return;
    }
    i = this.Zo;
    this.Zo = paramInt;
    this.FPE.Xv(this.Zo);
    if (this.mViewPager != null)
    {
      if (i == -1)
      {
        this.mViewPager.setCurrentItemNotify(this.Zo, false);
        Xq(this.Zo);
      }
    }
    else
    {
      if ((this.Zo != 0) || (!com.tencent.matrix.a.csS.csU)) {
        break label264;
      }
      az.getNotification().cw(true);
    }
    for (;;)
    {
      if (this.Zo != 0)
      {
        MMFragment localMMFragment = Xt(0);
        if ((localMMFragment instanceof MainUI)) {
          ((MainUI)localMMFragment).fcE();
        }
      }
      AppMethodBeat.o(33479);
      return;
      this.mViewPager.setCurrentItem(this.Zo, false);
      break;
      label264:
      az.getNotification().cw(false);
    }
  }
  
  public final MMFragment Xt(int paramInt)
  {
    AppMethodBeat.i(33480);
    ad.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(33480);
      return null;
    }
    if (this.FPQ.containsKey(Integer.valueOf(paramInt)))
    {
      localMMFragment = (MMFragment)this.FPQ.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(33480);
      return localMMFragment;
    }
    MMFragment localMMFragment = Xr(paramInt);
    this.FPQ.put(Integer.valueOf(paramInt), localMMFragment);
    AppMethodBeat.o(33480);
    return localMMFragment;
  }
  
  public final void aKb(String paramString)
  {
    AppMethodBeat.i(33477);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(33477);
      return;
    }
    Xs(((Integer)FPP.get(paramString)).intValue());
    AppMethodBeat.o(33477);
  }
  
  public final void bFb()
  {
    AppMethodBeat.i(33469);
    com.tencent.mm.sdk.b.a.ESL.d(this.FPL);
    com.tencent.mm.sdk.b.a.ESL.d(this.FPN);
    com.tencent.mm.sdk.b.a.ESL.d(this.FPO);
    eRh();
    AppMethodBeat.o(33469);
  }
  
  public final void eQl()
  {
    AppMethodBeat.i(33475);
    MainUI localMainUI = (MainUI)this.FPQ.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.FKl.findViewById(2131301337);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localMainUI != null) {
      localMainUI.onHiddenChanged(true);
    }
    j.a(this.FKl, 4, this.Zo, "prepareStartChatting");
    eRi();
    this.FPE.eRk();
    AppMethodBeat.o(33475);
  }
  
  public final void eQp()
  {
    AppMethodBeat.i(33471);
    MainUI localMainUI = (MainUI)this.FPQ.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      localMainUI.fba();
      localMainUI.fcC();
    }
    AppMethodBeat.o(33471);
  }
  
  public final MMFragment eRg()
  {
    AppMethodBeat.i(33467);
    MMFragment localMMFragment = (MMFragment)this.FPQ.get(Integer.valueOf(this.Zo));
    AppMethodBeat.o(33467);
    return localMMFragment;
  }
  
  public final void eRi()
  {
    AppMethodBeat.i(33472);
    MainUI localMainUI = (MainUI)this.FPQ.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.fcD();
    }
    AppMethodBeat.o(33472);
  }
  
  public final void eRj()
  {
    AppMethodBeat.i(33476);
    if ((this.Zo == 0) && (g.afA().gcy.foreground)) {
      az.getNotification().cw(true);
    }
    for (;;)
    {
      Object localObject = (ViewGroup)this.FKl.findViewById(2131301337);
      if (localObject != null) {
        ((ViewGroup)localObject).setImportantForAccessibility(1);
      }
      eQp();
      j.a(this.FKl, 3, this.Zo, "prepareCloseChatting");
      localObject = (MainUI)this.FPQ.get(Integer.valueOf(0));
      if (localObject != null)
      {
        ((MainUI)localObject).getContentView();
        if (((MainUI)localObject).mController != null) {
          ((MainUI)localObject).mController.onResume();
        }
        ((MainUI)localObject).onHiddenChanged(false);
      }
      com.tencent.mm.plugin.report.service.i.vKx.oS(true);
      AppMethodBeat.o(33476);
      return;
      az.getNotification().cw(false);
    }
  }
  
  protected final void eRk()
  {
    AppMethodBeat.i(33481);
    this.FPE.eRk();
    AppMethodBeat.o(33481);
  }
  
  protected final void eRl()
  {
    AppMethodBeat.i(33482);
    this.FPE.eRl();
    AppMethodBeat.o(33482);
  }
  
  protected final void eRm()
  {
    AppMethodBeat.i(33483);
    this.FPE.eRm();
    AppMethodBeat.o(33483);
  }
  
  public final int eRn()
  {
    AppMethodBeat.i(33484);
    z localz = this.FPE;
    long l = System.currentTimeMillis();
    int i;
    if (!az.afw())
    {
      ad.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
      i = 0;
    }
    for (;;)
    {
      localz.Xu(i);
      ad.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      AppMethodBeat.o(33484);
      return i;
      i = x.d(w.gMn, aj.Za());
      ad.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", new Object[] { Integer.valueOf(i) });
    }
  }
  
  public final void eRo()
  {
    AppMethodBeat.i(33485);
    this.FPQ.get(Integer.valueOf(0));
    AppMethodBeat.o(33485);
  }
  
  public final void jd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33473);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(33473);
      return;
    }
    MMFragment localMMFragment = Xt(paramInt1);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).eQb();
    }
    localMMFragment = Xt(paramInt2);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).eQa();
    }
    j.a(this.FKl, 4, paramInt1, "deliverOnTabChange");
    j.a(this.FKl, 3, paramInt2, "deliverOnTabChange");
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
        localIterator = MainTabUI.eRp().values().iterator();
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
      Iterator localIterator = MainTabUI.eRp().values().iterator();
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
      ad.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", new Object[] { Integer.valueOf(this.clickCount), Integer.valueOf(paramInt) });
      com.tencent.mm.plugin.report.service.i locali = com.tencent.mm.plugin.report.service.i.vKx;
      if (paramInt == 0)
      {
        locali.oS(bool);
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
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10957, "1");
        continue;
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10957, "2");
        continue;
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10957, "3");
        continue;
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(10957, "4");
        continue;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10957, "5");
          break;
        case 1: 
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10957, "6");
          break;
        case 2: 
          label168:
          com.tencent.mm.plugin.report.service.h.vKh.kvStat(10957, "7");
        }
      }
    }
    
    private void setFragmentLoadingIconVisibility(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33461);
      if ((MainTabUI.this.Xt(paramInt1) != null) && (MainTabUI.this.Xt(paramInt1).getActivity() != null))
      {
        View localView = MainTabUI.this.Xt(paramInt1).findViewById(2131301509);
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
      MMFragment localMMFragment = MainTabUI.this.Xt(paramInt);
      AppMethodBeat.o(33458);
      return localMMFragment;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(33464);
      ad.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (this.addressFragment != null))
      {
        this.addressFragment.wr(true);
        this.addressFragment = null;
      }
      if (MainTabUI.d(MainTabUI.this) != null) {
        MainTabUI.d(MainTabUI.this).Xh(paramInt);
      }
      AppMethodBeat.o(33464);
    }
    
    public void onPageScrolled(final int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33459);
      z localz = MainTabUI.c(MainTabUI.this);
      if (localz.FPT != null) {
        localz.FPT.n(paramInt1, paramFloat);
      }
      if (MainTabUI.d(MainTabUI.this) != null) {
        MainTabUI.d(MainTabUI.this).u(paramInt1, paramFloat);
      }
      if (0.0F != paramFloat)
      {
        if (this.addressFragment == null) {
          this.addressFragment = ((AddressUI.AddressUIFragment)MainTabUI.this.Xt(1));
        }
        this.addressFragment.wr(false);
      }
      for (;;)
      {
        fixAndroidOProgressBarOutScreenFlashProblem(paramInt1, paramFloat, paramInt2);
        AppMethodBeat.o(33459);
        return;
        ad.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(MainTabUI.e(MainTabUI.this)) });
        if (-1 == MainTabUI.e(MainTabUI.this))
        {
          MainTabUI.this.jd(MainTabUI.e(MainTabUI.this), MainTabUI.f(MainTabUI.this));
          MainTabUI.this.Xq(paramInt1);
        }
        else
        {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33456);
              MainTabUI.this.jd(MainTabUI.e(MainTabUI.this), MainTabUI.f(MainTabUI.this));
              MainTabUI.this.Xq(paramInt1);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject).lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ado());
      ad.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
      switch (paramInt)
      {
      default: 
        reportSwitch(paramInt);
        MainTabUI.a(MainTabUI.this, MainTabUI.f(MainTabUI.this));
        MainTabUI.b(MainTabUI.this, paramInt);
        MainTabUI.c(MainTabUI.this).Xv(paramInt);
        MainTabUI.g(MainTabUI.this).supportInvalidateOptionsMenu();
        localObject = MainTabUI.this.Xt(MainTabUI.f(MainTabUI.this));
        if ((MainTabUI.e(MainTabUI.this) == 1) && (MainTabUI.f(MainTabUI.this) != 1))
        {
          az.arV();
          com.tencent.mm.model.c.afk().set(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (MainTabUI.f(MainTabUI.this) == 1)
        {
          long l = System.currentTimeMillis();
          az.arV();
          if (l - bt.a((Long)com.tencent.mm.model.c.afk().get(340226, null), 0L) >= 180000L) {
            ((AddressUI.AddressUIFragment)localObject).fbc();
          }
        }
        if (MainTabUI.f(MainTabUI.this) == 0) {
          az.getNotification().cw(true);
        }
        break;
      }
      for (;;)
      {
        if ((localObject != null) && (com.tencent.matrix.b.GE()) && (((MMFragment)localObject).getActivity() != null))
        {
          String str = ((MMFragment)localObject).getActivity().getClass().getName();
          com.tencent.matrix.a.csS.cQ(str + "#" + localObject.getClass().getSimpleName());
        }
        if (MainTabUI.d(MainTabUI.this) != null) {
          MainTabUI.d(MainTabUI.this).Xg(MainTabUI.f(MainTabUI.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
        com.tencent.mm.plugin.newtips.a.cWs().Ip(2);
        ((com.tencent.mm.plugin.i.a.j)g.ad(com.tencent.mm.plugin.i.a.j.class)).getRedDotManager().YU("Discovery");
        break;
        com.tencent.mm.plugin.newtips.a.cWs().Ip(1);
        break;
        az.getNotification().cw(false);
      }
    }
    
    public void onTabClick(int paramInt)
    {
      AppMethodBeat.i(33465);
      if (!MainTabUI.a(MainTabUI.this))
      {
        ad.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
        AppMethodBeat.o(33465);
        return;
      }
      Object localObject;
      if (paramInt == MainTabUI.f(MainTabUI.this))
      {
        ad.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
        localObject = MainTabUI.this.Xt(paramInt);
        if ((localObject instanceof AbstractTabChildActivity.AbStractTabFragment)) {
          ((AbstractTabChildActivity.AbStractTabFragment)localObject).ePa();
        }
        AppMethodBeat.o(33465);
        return;
      }
      this.isTabClicked = true;
      this.clickCount += 1;
      ad.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", new Object[] { Integer.valueOf(this.clickCount) });
      this.mViewPager.setCurrentItem(paramInt, false);
      if (paramInt == 3)
      {
        com.tencent.mm.z.c.adr().cK(262145, 266241);
        com.tencent.mm.z.c.adr().cK(262156, 266241);
        com.tencent.mm.z.c.adr().cK(262147, 266241);
        com.tencent.mm.z.c.adr().cK(262149, 266241);
        com.tencent.mm.z.c.adr().cK(262152, 266241);
        com.tencent.mm.z.c.adr().b(ae.a.FsT, 266241);
        com.tencent.mm.z.c.adr().c(ae.a.FrW, ae.a.Fsd);
        boolean bool = com.tencent.mm.z.c.adr().cJ(262156, 266241);
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        if (!bool) {
          break label309;
        }
      }
      label309:
      for (paramInt = 1;; paramInt = 0)
      {
        ((com.tencent.mm.plugin.report.service.h)localObject).f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
        g.afC();
        g.afB().afk().set(ae.a.FrQ, Boolean.FALSE);
        AppMethodBeat.o(33465);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void Xg(int paramInt);
    
    public abstract void Xh(int paramInt);
    
    public abstract void u(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI
 * JD-Core Version:    0.7.0.1
 */