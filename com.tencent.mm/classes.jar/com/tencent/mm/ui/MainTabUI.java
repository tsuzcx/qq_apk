package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.dm;
import com.tencent.mm.g.a.ji;
import com.tencent.mm.g.a.kd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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
  private static HashMap<String, Integer> Jdg;
  MMFragmentActivity IXa;
  aa JcV;
  LauncherUI.d JcW;
  boolean JcX;
  private HashSet<m> JcY;
  private int JcZ;
  private int Jda;
  a Jdb;
  com.tencent.mm.sdk.b.c Jdc;
  private boolean Jdd;
  com.tencent.mm.sdk.b.c Jde;
  com.tencent.mm.sdk.b.c Jdf;
  public HashMap<Integer, MMFragment> Jdh;
  public int abZ;
  private int aca;
  private final long iry;
  TabsAdapter mTabsAdapter;
  com.tencent.mm.plugin.appbrand.widget.header.a mUy;
  CustomViewPager mViewPager;
  
  static
  {
    AppMethodBeat.i(33486);
    HashMap localHashMap = new HashMap();
    Jdg = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    Jdg.put("tab_address", Integer.valueOf(1));
    Jdg.put("tab_find_friend", Integer.valueOf(2));
    Jdg.put("tab_settings", Integer.valueOf(3));
    AppMethodBeat.o(33486);
  }
  
  public MainTabUI()
  {
    AppMethodBeat.i(33466);
    this.iry = 180000L;
    this.JcV = new aa();
    this.JcY = new HashSet();
    this.abZ = -1;
    this.aca = -1;
    this.JcZ = -1;
    this.Jda = -1;
    this.Jdc = new com.tencent.mm.sdk.b.c() {};
    this.Jdd = true;
    this.Jde = new com.tencent.mm.sdk.b.c() {};
    this.Jdf = new com.tencent.mm.sdk.b.c() {};
    this.Jdh = new HashMap();
    AppMethodBeat.o(33466);
  }
  
  private MMFragment abN(int paramInt)
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
        localMMFragment.setParent(this.IXa);
      }
      AppMethodBeat.o(33478);
      return localMMFragment;
      ((Bundle)localObject1).putInt(MainUI.class.getName(), 0);
      localMMFragment = (MMFragment)Fragment.instantiate(this.IXa, MainUI.class.getName(), (Bundle)localObject1);
      if ((localMMFragment instanceof MainUI))
      {
        localObject1 = (MainUI)localMMFragment;
        Object localObject2 = this.IXa;
        ((MainUI)localObject1).mWg = ((MMFragmentActivity)localObject2);
        if (((MainUI)localObject1).Kwg != null) {
          ((MainUI)localObject1).Kwg.setActivity((MMFragmentActivity)localObject2);
        }
        localObject1 = (MainUI)localMMFragment;
        localObject2 = this.mUy;
        ((MainUI)localObject1).Kwn = ((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        if (((MainUI)localObject1).Kwg != null) {
          ((MainUI)localObject1).Kwg.setActionBarUpdateCallback((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        }
      }
      ba.getNotification().cz(true);
      continue;
      ((Bundle)localObject1).putInt(AddressUI.AddressUIFragment.class.getName(), 1);
      ((Bundle)localObject1).putBoolean("Need_Voice_Search", true);
      ((Bundle)localObject1).putBoolean("favour_include_biz", true);
      localMMFragment = (MMFragment)Fragment.instantiate(this.IXa, AddressUI.AddressUIFragment.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(FindMoreFriendsUI.class.getName(), 2);
      localMMFragment = (MMFragment)Fragment.instantiate(this.IXa, FindMoreFriendsUI.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(MoreTabUI.class.getName(), 3);
      localMMFragment = (MMFragment)Fragment.instantiate(this.IXa, MoreTabUI.class.getName(), (Bundle)localObject1);
    }
  }
  
  private void fxc()
  {
    AppMethodBeat.i(33470);
    this.Jdh.clear();
    if (this.mViewPager != null)
    {
      this.mViewPager.setCanSlide(false);
      this.mViewPager.setCanSlideBySide(false);
    }
    AppMethodBeat.o(33470);
  }
  
  public final void aVt(String paramString)
  {
    AppMethodBeat.i(33477);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(33477);
      return;
    }
    abO(((Integer)Jdg.get(paramString)).intValue());
    AppMethodBeat.o(33477);
  }
  
  public final void abL(int paramInt)
  {
    AppMethodBeat.i(33468);
    MainUI localMainUI = (MainUI)this.Jdh.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.abL(paramInt);
    }
    AppMethodBeat.o(33468);
  }
  
  public final void abM(int paramInt)
  {
    AppMethodBeat.i(33474);
    MMFragment localMMFragment = abP(paramInt);
    if (localMMFragment == null)
    {
      AppMethodBeat.o(33474);
      return;
    }
    if ((localMMFragment instanceof m)) {
      ((m)localMMFragment).fuS();
    }
    this.mTabsAdapter.mFragmentResumedFlags[paramInt] = true;
    AppMethodBeat.o(33474);
  }
  
  public final void abO(int paramInt)
  {
    AppMethodBeat.i(33479);
    int i = this.abZ;
    if (this.mViewPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.Jdh.size()) });
      if ((this.mViewPager != null) && (paramInt >= 0) && ((this.mTabsAdapter == null) || (paramInt <= this.mTabsAdapter.getCount() - 1))) {
        break;
      }
      AppMethodBeat.o(33479);
      return;
    }
    if ((this.abZ == paramInt) && (this.Jdh.size() != 0))
    {
      AppMethodBeat.o(33479);
      return;
    }
    i = this.abZ;
    this.abZ = paramInt;
    this.JcV.abQ(this.abZ);
    if (this.mViewPager != null)
    {
      if (i == -1)
      {
        this.mViewPager.setCurrentItemNotify(this.abZ, false);
        abM(this.abZ);
      }
    }
    else
    {
      if ((this.abZ != 0) || (!com.tencent.matrix.a.cAS.cAU)) {
        break label264;
      }
      ba.getNotification().cz(true);
    }
    for (;;)
    {
      if (this.abZ != 0)
      {
        MMFragment localMMFragment = abP(0);
        if ((localMMFragment instanceof MainUI)) {
          ((MainUI)localMMFragment).fJn();
        }
      }
      AppMethodBeat.o(33479);
      return;
      this.mViewPager.setCurrentItem(this.abZ, false);
      break;
      label264:
      ba.getNotification().cz(false);
    }
  }
  
  public final MMFragment abP(int paramInt)
  {
    AppMethodBeat.i(33480);
    ad.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(33480);
      return null;
    }
    if (this.Jdh.containsKey(Integer.valueOf(paramInt)))
    {
      localMMFragment = (MMFragment)this.Jdh.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(33480);
      return localMMFragment;
    }
    MMFragment localMMFragment = abN(paramInt);
    this.Jdh.put(Integer.valueOf(paramInt), localMMFragment);
    AppMethodBeat.o(33480);
    return localMMFragment;
  }
  
  public final void bQQ()
  {
    AppMethodBeat.i(33469);
    com.tencent.mm.sdk.b.a.IbL.d(this.Jdc);
    com.tencent.mm.sdk.b.a.IbL.d(this.Jde);
    com.tencent.mm.sdk.b.a.IbL.d(this.Jdf);
    fxc();
    AppMethodBeat.o(33469);
  }
  
  public final void fwe()
  {
    AppMethodBeat.i(33475);
    MainUI localMainUI = (MainUI)this.Jdh.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.IXa.findViewById(2131301337);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localMainUI != null) {
      localMainUI.onHiddenChanged(true);
    }
    j.a(this.IXa, 4, this.abZ, "prepareStartChatting");
    fxd();
    this.JcV.fxf();
    AppMethodBeat.o(33475);
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(33471);
    MainUI localMainUI = (MainUI)this.Jdh.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      localMainUI.fHE();
      localMainUI.fJl();
    }
    AppMethodBeat.o(33471);
  }
  
  public final MMFragment fxb()
  {
    AppMethodBeat.i(33467);
    MMFragment localMMFragment = (MMFragment)this.Jdh.get(Integer.valueOf(this.abZ));
    AppMethodBeat.o(33467);
    return localMMFragment;
  }
  
  public final void fxd()
  {
    AppMethodBeat.i(33472);
    MainUI localMainUI = (MainUI)this.Jdh.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.fJm();
    }
    AppMethodBeat.o(33472);
  }
  
  public final void fxe()
  {
    AppMethodBeat.i(33476);
    if ((this.abZ == 0) && (com.tencent.mm.kernel.g.ajB().gAO.foreground)) {
      ba.getNotification().cz(true);
    }
    for (;;)
    {
      Object localObject = (ViewGroup)this.IXa.findViewById(2131301337);
      if (localObject != null) {
        ((ViewGroup)localObject).setImportantForAccessibility(1);
      }
      fwi();
      j.a(this.IXa, 3, this.abZ, "prepareCloseChatting");
      localObject = (MainUI)this.Jdh.get(Integer.valueOf(0));
      if (localObject != null)
      {
        ((MainUI)localObject).getContentView();
        if (((MainUI)localObject).mController != null) {
          ((MainUI)localObject).mController.onResume();
        }
        ((MainUI)localObject).onHiddenChanged(false);
      }
      com.tencent.mm.plugin.report.service.h.yih.qp(true);
      AppMethodBeat.o(33476);
      return;
      ba.getNotification().cz(false);
    }
  }
  
  protected final void fxf()
  {
    AppMethodBeat.i(33481);
    this.JcV.fxf();
    AppMethodBeat.o(33481);
  }
  
  protected final void fxg()
  {
    AppMethodBeat.i(33482);
    this.JcV.fxg();
    AppMethodBeat.o(33482);
  }
  
  protected final void fxh()
  {
    AppMethodBeat.i(33483);
    this.JcV.fxh();
    AppMethodBeat.o(33483);
  }
  
  public final void fxj()
  {
    AppMethodBeat.i(33485);
    this.Jdh.get(Integer.valueOf(0));
    AppMethodBeat.o(33485);
  }
  
  public final void gzT()
  {
    AppMethodBeat.i(221392);
    aa localaa = this.JcV;
    com.tencent.e.h.LTJ.i(new aa.3(localaa), "setConversationTagUnread");
    AppMethodBeat.o(221392);
  }
  
  public final void jC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33473);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(33473);
      return;
    }
    MMFragment localMMFragment = abP(paramInt1);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).fvR();
    }
    localMMFragment = abP(paramInt2);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).fvQ();
    }
    j.a(this.IXa, 4, paramInt1, "deliverOnTabChange");
    j.a(this.IXa, 3, paramInt2, "deliverOnTabChange");
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
        localIterator = MainTabUI.fxk().values().iterator();
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
      Iterator localIterator = MainTabUI.fxk().values().iterator();
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
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.yih;
      if (paramInt == 0)
      {
        localh.qp(bool);
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
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10957, "1");
        continue;
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10957, "2");
        continue;
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10957, "3");
        continue;
        com.tencent.mm.plugin.report.service.g.yhR.kvStat(10957, "4");
        continue;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10957, "5");
          break;
        case 1: 
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10957, "6");
          break;
        case 2: 
          label168:
          com.tencent.mm.plugin.report.service.g.yhR.kvStat(10957, "7");
        }
      }
    }
    
    private void setFragmentLoadingIconVisibility(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33461);
      if ((MainTabUI.this.abP(paramInt1) != null) && (MainTabUI.this.abP(paramInt1).getActivity() != null))
      {
        View localView = MainTabUI.this.abP(paramInt1).findViewById(2131301509);
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
      MMFragment localMMFragment = MainTabUI.this.abP(paramInt);
      AppMethodBeat.o(33458);
      return localMMFragment;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(33464);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V", this, localb.ahq());
      ad.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (this.addressFragment != null))
      {
        this.addressFragment.yj(true);
        this.addressFragment = null;
      }
      if (MainTabUI.d(MainTabUI.this) != null) {
        MainTabUI.d(MainTabUI.this).abB(paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V");
      AppMethodBeat.o(33464);
    }
    
    public void onPageScrolled(final int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33459);
      aa localaa = MainTabUI.c(MainTabUI.this);
      if (localaa.Jdk != null) {
        localaa.Jdk.o(paramInt1, paramFloat);
      }
      if (MainTabUI.d(MainTabUI.this) != null) {
        MainTabUI.d(MainTabUI.this).w(paramInt1, paramFloat);
      }
      if (0.0F != paramFloat)
      {
        if (this.addressFragment == null) {
          this.addressFragment = ((AddressUI.AddressUIFragment)MainTabUI.this.abP(1));
        }
        this.addressFragment.yj(false);
      }
      for (;;)
      {
        fixAndroidOProgressBarOutScreenFlashProblem(paramInt1, paramFloat, paramInt2);
        AppMethodBeat.o(33459);
        return;
        ad.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(MainTabUI.e(MainTabUI.this)) });
        if (-1 == MainTabUI.e(MainTabUI.this))
        {
          MainTabUI.this.jC(MainTabUI.e(MainTabUI.this), MainTabUI.f(MainTabUI.this));
          MainTabUI.this.abM(paramInt1);
        }
        else
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33456);
              MainTabUI.this.jC(MainTabUI.e(MainTabUI.this), MainTabUI.f(MainTabUI.this));
              MainTabUI.this.abM(paramInt1);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      ad.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
      if (!com.tencent.mm.kernel.g.ajA().aiK())
      {
        ad.i("MicroMsg.LauncherUI.MainTabUI", "on page position %d selected, but account not initialized.", new Object[] { Integer.valueOf(paramInt) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
      }
      switch (paramInt)
      {
      default: 
        reportSwitch(paramInt);
        MainTabUI.a(MainTabUI.this, MainTabUI.f(MainTabUI.this));
        MainTabUI.b(MainTabUI.this, paramInt);
        MainTabUI.c(MainTabUI.this).abQ(paramInt);
        MainTabUI.g(MainTabUI.this).supportInvalidateOptionsMenu();
        localObject = MainTabUI.this.abP(MainTabUI.f(MainTabUI.this));
        if ((MainTabUI.e(MainTabUI.this) == 1) && (MainTabUI.f(MainTabUI.this) != 1))
        {
          ba.aBQ();
          com.tencent.mm.model.c.ajl().set(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (MainTabUI.f(MainTabUI.this) == 1)
        {
          long l = System.currentTimeMillis();
          ba.aBQ();
          if (l - bt.a((Long)com.tencent.mm.model.c.ajl().get(340226, null), 0L) >= 180000L) {
            ((AddressUI.AddressUIFragment)localObject).fHG();
          }
        }
        if (MainTabUI.f(MainTabUI.this) == 0) {
          ba.getNotification().cz(true);
        }
        break;
      }
      for (;;)
      {
        if ((localObject != null) && (com.tencent.matrix.b.HK()) && (((MMFragment)localObject).getActivity() != null))
        {
          String str = ((MMFragment)localObject).getActivity().getClass().getName();
          com.tencent.matrix.a.cAS.dI(str + "#" + localObject.getClass().getSimpleName());
        }
        if (MainTabUI.d(MainTabUI.this) != null) {
          MainTabUI.d(MainTabUI.this).abA(MainTabUI.f(MainTabUI.this));
        }
        localObject = new kd();
        ((kd)localObject).dxc.currentIndex = MainTabUI.f(MainTabUI.this);
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
        com.tencent.mm.plugin.newtips.a.dun().LQ(2);
        ((t)com.tencent.mm.kernel.g.ad(t.class)).getRedDotManager().ahl("Discovery");
        break;
        com.tencent.mm.plugin.newtips.a.dun().LQ(1);
        break;
        ba.getNotification().cz(false);
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
        localObject = MainTabUI.this.abP(paramInt);
        if ((localObject instanceof AbstractTabChildActivity.AbStractTabFragment)) {
          ((AbstractTabChildActivity.AbStractTabFragment)localObject).fuL();
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
        com.tencent.mm.z.c.aht().cK(262145, 266241);
        com.tencent.mm.z.c.aht().cK(262156, 266241);
        com.tencent.mm.z.c.aht().cK(262147, 266241);
        com.tencent.mm.z.c.aht().cK(262149, 266241);
        com.tencent.mm.z.c.aht().cK(262152, 266241);
        com.tencent.mm.z.c.aht().b(al.a.IDj, 266241);
        com.tencent.mm.z.c.aht().c(al.a.ICh, al.a.ICo);
        boolean bool = com.tencent.mm.z.c.aht().cJ(262156, 266241);
        localObject = com.tencent.mm.plugin.report.service.g.yhR;
        if (!bool) {
          break label309;
        }
      }
      label309:
      for (paramInt = 1;; paramInt = 0)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
        com.tencent.mm.kernel.g.ajD();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICb, Boolean.FALSE);
        AppMethodBeat.o(33465);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void abA(int paramInt);
    
    public abstract void abB(int paramInt);
    
    public abstract void w(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI
 * JD-Core Version:    0.7.0.1
 */