package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.j;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dq;
import com.tencent.mm.g.a.jy;
import com.tencent.mm.g.a.kt;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.i.a.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
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
  private static HashMap<String, Integer> OIk;
  com.tencent.mm.plugin.taskbar.api.a FSw;
  ab OHZ;
  LauncherUI.d OIa;
  boolean OIb;
  private HashSet<n> OIc;
  private int OId;
  private int OIe;
  a OIf;
  IListener OIg;
  private boolean OIh;
  IListener OIi;
  IListener OIj;
  public HashMap<Integer, MMFragment> OIl;
  public int acm;
  private int acn;
  private final long jpE;
  TabsAdapter mTabsAdapter;
  CustomViewPager mViewPager;
  MMFragmentActivity uLr;
  
  static
  {
    AppMethodBeat.i(33486);
    HashMap localHashMap = new HashMap();
    OIk = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    OIk.put("tab_address", Integer.valueOf(1));
    OIk.put("tab_find_friend", Integer.valueOf(2));
    OIk.put("tab_settings", Integer.valueOf(3));
    AppMethodBeat.o(33486);
  }
  
  public MainTabUI()
  {
    AppMethodBeat.i(33466);
    this.jpE = 180000L;
    this.OHZ = new ab();
    this.OIc = new HashSet();
    this.acm = -1;
    this.acn = -1;
    this.OId = -1;
    this.OIe = -1;
    this.OIg = new MainTabUI.1(this);
    this.OIh = true;
    this.OIi = new IListener() {};
    this.OIj = new IListener() {};
    this.OIl = new HashMap();
    AppMethodBeat.o(33466);
  }
  
  private MMFragment ald(int paramInt)
  {
    AppMethodBeat.i(33478);
    MMFragment localMMFragment = null;
    Object localObject1 = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      Log.i("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localMMFragment != null) {
        localMMFragment.setParent(this.uLr);
      }
      AppMethodBeat.o(33478);
      return localMMFragment;
      ((Bundle)localObject1).putInt(MainUI.class.getName(), 0);
      localMMFragment = (MMFragment)Fragment.instantiate(this.uLr, MainUI.class.getName(), (Bundle)localObject1);
      if ((localMMFragment instanceof MainUI))
      {
        localObject1 = (MainUI)localMMFragment;
        Object localObject2 = this.uLr;
        ((MainUI)localObject1).Dpx = ((MMFragmentActivity)localObject2);
        if (((MainUI)localObject1).QfG != null) {
          ((MainUI)localObject1).QfG.setActivity((MMFragmentActivity)localObject2);
        }
        localObject1 = (MainUI)localMMFragment;
        localObject2 = this.FSw;
        ((MainUI)localObject1).QfN = ((com.tencent.mm.plugin.taskbar.api.a)localObject2);
        if (((MainUI)localObject1).QfG != null) {
          ((MainUI)localObject1).QfG.setActionBarUpdateCallback((com.tencent.mm.plugin.taskbar.api.a)localObject2);
        }
      }
      bg.getNotification().dh(true);
      continue;
      ((Bundle)localObject1).putInt(AddressUI.AddressUIFragment.class.getName(), 1);
      ((Bundle)localObject1).putBoolean("Need_Voice_Search", true);
      ((Bundle)localObject1).putBoolean("favour_include_biz", true);
      localMMFragment = (MMFragment)Fragment.instantiate(this.uLr, AddressUI.AddressUIFragment.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(FindMoreFriendsUI.class.getName(), 2);
      localMMFragment = (MMFragment)Fragment.instantiate(this.uLr, FindMoreFriendsUI.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(MoreTabUI.class.getName(), 3);
      localMMFragment = (MMFragment)Fragment.instantiate(this.uLr, MoreTabUI.class.getName(), (Bundle)localObject1);
    }
  }
  
  private void gIY()
  {
    AppMethodBeat.i(33470);
    this.OIl.clear();
    if (this.mViewPager != null)
    {
      this.mViewPager.setCanSlide(false);
      this.mViewPager.setCanSlideBySide(false);
    }
    AppMethodBeat.o(33470);
  }
  
  public final void alb(int paramInt)
  {
    AppMethodBeat.i(33468);
    MainUI localMainUI = (MainUI)this.OIl.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.alb(paramInt);
    }
    AppMethodBeat.o(33468);
  }
  
  public final void alc(int paramInt)
  {
    AppMethodBeat.i(33474);
    Log.i("MicroMsg.LauncherUI.MainTabUI", "deliverOnTabResume %s", new Object[] { Integer.valueOf(paramInt) });
    MMFragment localMMFragment = alf(paramInt);
    if (localMMFragment == null)
    {
      AppMethodBeat.o(33474);
      return;
    }
    if ((localMMFragment instanceof n)) {
      ((n)localMMFragment).gGH();
    }
    this.mTabsAdapter.mFragmentResumedFlags[paramInt] = true;
    AppMethodBeat.o(33474);
  }
  
  public final void ale(int paramInt)
  {
    AppMethodBeat.i(33479);
    int i = this.acm;
    if (this.mViewPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.OIl.size()) });
      if ((this.mViewPager != null) && (paramInt >= 0) && ((this.mTabsAdapter == null) || (paramInt <= this.mTabsAdapter.getCount() - 1))) {
        break;
      }
      AppMethodBeat.o(33479);
      return;
    }
    if ((this.acm == paramInt) && (this.OIl.size() != 0))
    {
      AppMethodBeat.o(33479);
      return;
    }
    i = this.acm;
    this.acm = paramInt;
    this.OHZ.alg(this.acm);
    if (this.mViewPager != null)
    {
      if (i == -1)
      {
        this.mViewPager.setCurrentItemNotify(this.acm, false);
        alc(this.acm);
      }
    }
    else
    {
      if ((this.acm != 0) || (!com.tencent.matrix.a.cPA.cPB)) {
        break label264;
      }
      bg.getNotification().dh(true);
    }
    for (;;)
    {
      if (this.acm != 0)
      {
        MMFragment localMMFragment = alf(0);
        if ((localMMFragment instanceof MainUI)) {
          ((MainUI)localMMFragment).gVY();
        }
      }
      AppMethodBeat.o(33479);
      return;
      this.mViewPager.setCurrentItem(this.acm, false);
      break;
      label264:
      bg.getNotification().dh(false);
    }
  }
  
  public final MMFragment alf(int paramInt)
  {
    AppMethodBeat.i(33480);
    if (paramInt < 0)
    {
      AppMethodBeat.o(33480);
      return null;
    }
    if (this.OIl.containsKey(Integer.valueOf(paramInt)))
    {
      localMMFragment = (MMFragment)this.OIl.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(33480);
      return localMMFragment;
    }
    Log.i("MicroMsg.LauncherUI.MainTabUI", "create tab %d", new Object[] { Integer.valueOf(paramInt) });
    MMFragment localMMFragment = ald(paramInt);
    this.OIl.put(Integer.valueOf(paramInt), localMMFragment);
    AppMethodBeat.o(33480);
    return localMMFragment;
  }
  
  public final void blU(String paramString)
  {
    AppMethodBeat.i(33477);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(33477);
      return;
    }
    ale(((Integer)OIk.get(paramString)).intValue());
    AppMethodBeat.o(33477);
  }
  
  public final void cpB()
  {
    AppMethodBeat.i(33469);
    EventCenter.instance.removeListener(this.OIg);
    EventCenter.instance.removeListener(this.OIi);
    EventCenter.instance.removeListener(this.OIj);
    gIY();
    AppMethodBeat.o(33469);
  }
  
  public final void gHX()
  {
    AppMethodBeat.i(33475);
    MainUI localMainUI = (MainUI)this.OIl.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.uLr.findViewById(2131303052);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localMainUI != null) {
      localMainUI.onHiddenChanged(true);
    }
    k.a(this.uLr, 4, this.acm, "prepareStartChatting");
    gIZ();
    this.OHZ.gJb();
    AppMethodBeat.o(33475);
  }
  
  public final MMFragment gIX()
  {
    AppMethodBeat.i(33467);
    MMFragment localMMFragment = (MMFragment)this.OIl.get(Integer.valueOf(this.acm));
    AppMethodBeat.o(33467);
    return localMMFragment;
  }
  
  public final void gIZ()
  {
    AppMethodBeat.i(33472);
    MainUI localMainUI = (MainUI)this.OIl.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.gVX();
    }
    AppMethodBeat.o(33472);
  }
  
  public final void gIb()
  {
    AppMethodBeat.i(33471);
    MainUI localMainUI = (MainUI)this.OIl.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      localMainUI.gUq();
      localMainUI.gVW();
    }
    AppMethodBeat.o(33471);
  }
  
  public final void gJa()
  {
    AppMethodBeat.i(33476);
    if ((this.acm == 0) && (g.aAg().hqi.foreground)) {
      bg.getNotification().dh(true);
    }
    for (;;)
    {
      Object localObject = (ViewGroup)this.uLr.findViewById(2131303052);
      if (localObject != null) {
        ((ViewGroup)localObject).setImportantForAccessibility(1);
      }
      gIb();
      k.a(this.uLr, 3, this.acm, "prepareCloseChatting");
      localObject = (MainUI)this.OIl.get(Integer.valueOf(0));
      if (localObject != null)
      {
        ((MainUI)localObject).getContentView();
        if (((MainUI)localObject).mController != null) {
          ((MainUI)localObject).mController.onResume();
        }
        ((MainUI)localObject).onHiddenChanged(false);
      }
      com.tencent.mm.plugin.report.service.i.CyW.tN(true);
      AppMethodBeat.o(33476);
      return;
      bg.getNotification().dh(false);
    }
  }
  
  protected final void gJb()
  {
    AppMethodBeat.i(33481);
    this.OHZ.gJb();
    AppMethodBeat.o(33481);
  }
  
  protected final void gJc()
  {
    AppMethodBeat.i(33482);
    this.OHZ.gJc();
    AppMethodBeat.o(33482);
  }
  
  protected final void gJd()
  {
    AppMethodBeat.i(33483);
    this.OHZ.gJd();
    AppMethodBeat.o(33483);
  }
  
  public final void gJe()
  {
    AppMethodBeat.i(232646);
    ab localab = this.OHZ;
    com.tencent.f.h.RTc.d(new ab.3(localab), "setConversationTagUnread");
    AppMethodBeat.o(232646);
  }
  
  public final void gJf()
  {
    AppMethodBeat.i(33485);
    this.OIl.get(Integer.valueOf(0));
    AppMethodBeat.o(33485);
  }
  
  public final void kP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33473);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(33473);
      return;
    }
    MMFragment localMMFragment = alf(paramInt1);
    if ((localMMFragment != null) && ((localMMFragment instanceof n))) {
      ((n)localMMFragment).gHF();
    }
    localMMFragment = alf(paramInt2);
    if ((localMMFragment != null) && ((localMMFragment instanceof n))) {
      ((n)localMMFragment).gHE();
    }
    k.a(this.uLr, 4, paramInt1, "deliverOnTabChange");
    k.a(this.uLr, 3, paramInt2, "deliverOnTabChange");
    AppMethodBeat.o(33473);
  }
  
  final void setCanSlide(boolean paramBoolean)
  {
    AppMethodBeat.i(232645);
    this.mViewPager.setCanSlide(paramBoolean);
    AppMethodBeat.o(232645);
  }
  
  public class TabsAdapter
    extends j
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
        localIterator = MainTabUI.OIk.values().iterator();
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
      Iterator localIterator = MainTabUI.OIk.values().iterator();
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
      Log.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", new Object[] { Integer.valueOf(this.clickCount), Integer.valueOf(paramInt) });
      com.tencent.mm.plugin.report.service.i locali = com.tencent.mm.plugin.report.service.i.CyW;
      if (paramInt == 0)
      {
        locali.tN(bool);
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
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10957, "1");
        continue;
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10957, "2");
        continue;
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10957, "3");
        continue;
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(10957, "4");
        continue;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10957, "5");
          break;
        case 1: 
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10957, "6");
          break;
        case 2: 
          label168:
          com.tencent.mm.plugin.report.service.h.CyF.kvStat(10957, "7");
        }
      }
    }
    
    private void setFragmentLoadingIconVisibility(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33461);
      if ((MainTabUI.this.alf(paramInt1) != null) && (MainTabUI.this.alf(paramInt1).getActivity() != null))
      {
        View localView = MainTabUI.this.alf(paramInt1).findViewById(2131303712);
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
      MMFragment localMMFragment = MainTabUI.this.alf(paramInt);
      AppMethodBeat.o(33458);
      return localMMFragment;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(33464);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V", this, localb.axR());
      Log.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (this.addressFragment != null))
      {
        this.addressFragment.Cl(true);
        this.addressFragment = null;
      }
      if (MainTabUI.c(MainTabUI.this) != null) {
        MainTabUI.c(MainTabUI.this).akQ(paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V");
      AppMethodBeat.o(33464);
    }
    
    public void onPageScrolled(final int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33459);
      ab localab = MainTabUI.b(MainTabUI.this);
      if (localab.OIo != null) {
        localab.OIo.p(paramInt1, paramFloat);
      }
      if (MainTabUI.c(MainTabUI.this) != null) {
        MainTabUI.c(MainTabUI.this).z(paramInt1, paramFloat);
      }
      if (0.0F != paramFloat)
      {
        if (this.addressFragment == null) {
          this.addressFragment = ((AddressUI.AddressUIFragment)MainTabUI.this.alf(1));
        }
        this.addressFragment.Cl(false);
      }
      for (;;)
      {
        fixAndroidOProgressBarOutScreenFlashProblem(paramInt1, paramFloat, paramInt2);
        AppMethodBeat.o(33459);
        return;
        Log.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(MainTabUI.d(MainTabUI.this)) });
        if (-1 == MainTabUI.d(MainTabUI.this))
        {
          MainTabUI.this.kP(MainTabUI.d(MainTabUI.this), MainTabUI.e(MainTabUI.this));
          MainTabUI.this.alc(paramInt1);
        }
        else
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33456);
              MainTabUI.this.kP(MainTabUI.d(MainTabUI.this), MainTabUI.e(MainTabUI.this));
              MainTabUI.this.alc(paramInt1);
              AppMethodBeat.o(33456);
            }
          });
        }
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      AppMethodBeat.i(33462);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      Log.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
      if (!g.aAf().azp())
      {
        Log.i("MicroMsg.LauncherUI.MainTabUI", "on page position %d selected, but account not initialized.", new Object[] { Integer.valueOf(paramInt) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
      }
      switch (paramInt)
      {
      default: 
        reportSwitch(paramInt);
        MainTabUI.a(MainTabUI.this, MainTabUI.e(MainTabUI.this));
        MainTabUI.b(MainTabUI.this, paramInt);
        MainTabUI.b(MainTabUI.this).alg(paramInt);
        MainTabUI.f(MainTabUI.this).supportInvalidateOptionsMenu();
        localObject1 = MainTabUI.this.alf(MainTabUI.e(MainTabUI.this));
        if ((MainTabUI.d(MainTabUI.this) == 1) && (MainTabUI.e(MainTabUI.this) != 1))
        {
          bg.aVF();
          com.tencent.mm.model.c.azQ().set(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (MainTabUI.e(MainTabUI.this) == 1)
        {
          long l = System.currentTimeMillis();
          bg.aVF();
          if (l - Util.nullAs((Long)com.tencent.mm.model.c.azQ().get(340226, null), 0L) >= 180000L) {
            ((AddressUI.AddressUIFragment)localObject1).gUs();
          }
        }
        if (MainTabUI.e(MainTabUI.this) == 0) {
          bg.getNotification().dh(true);
        }
        break;
      }
      for (;;)
      {
        Object localObject2;
        if ((localObject1 != null) && (com.tencent.matrix.b.isInstalled()) && (((MMFragment)localObject1).getActivity() != null))
        {
          localObject2 = ((MMFragment)localObject1).getActivity().getClass().getName();
          com.tencent.matrix.a.cPA.eg((String)localObject2 + "#" + localObject1.getClass().getSimpleName());
        }
        if (MainTabUI.c(MainTabUI.this) != null) {
          MainTabUI.c(MainTabUI.this).akP(MainTabUI.e(MainTabUI.this));
        }
        localObject1 = new kt();
        ((kt)localObject1).dPO.currentIndex = MainTabUI.e(MainTabUI.this);
        EventCenter.instance.publish((IEvent)localObject1);
        if ((ao.gJN()) && (aw.b(aw.gWy(), MainTabUI.g(MainTabUI.this).getTaskId())) && (aw.a(aw.gWy(), MainTabUI.g(MainTabUI.this).getTaskId()) != 1))
        {
          localObject2 = new Intent(MainTabUI.g(MainTabUI.this), EmptyActivity.class);
          localObject1 = MainTabUI.g(MainTabUI.this);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/ui/MainTabUI$TabsAdapter", "onPageSelected", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMFragmentActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "onPageSelected", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          Log.i("MicroMsg.LauncherUI.MainTabUI", "start empty activity");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
        com.tencent.mm.plugin.newtips.a.exl().TC(2);
        ((aj)g.ah(aj.class)).getRedDotManager().asV("Discovery");
        break;
        com.tencent.mm.plugin.newtips.a.exl().TC(1);
        break;
        bg.getNotification().dh(false);
      }
    }
    
    public void onTabClick(int paramInt)
    {
      AppMethodBeat.i(33465);
      if (!MainTabUI.a(MainTabUI.this))
      {
        Log.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
        AppMethodBeat.o(33465);
        return;
      }
      Object localObject;
      if (paramInt == MainTabUI.e(MainTabUI.this))
      {
        Log.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
        localObject = MainTabUI.this.alf(paramInt);
        if ((localObject instanceof AbstractTabChildActivity.AbStractTabFragment)) {
          ((AbstractTabChildActivity.AbStractTabFragment)localObject).gGA();
        }
        AppMethodBeat.o(33465);
        return;
      }
      this.isTabClicked = true;
      this.clickCount += 1;
      Log.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", new Object[] { Integer.valueOf(this.clickCount) });
      this.mViewPager.setCurrentItem(paramInt, false);
      if (paramInt == 3)
      {
        com.tencent.mm.y.c.axV().cQ(262145, 266241);
        com.tencent.mm.y.c.axV().cQ(262156, 266241);
        com.tencent.mm.y.c.axV().cQ(262147, 266241);
        com.tencent.mm.y.c.axV().cQ(262149, 266241);
        com.tencent.mm.y.c.axV().cQ(262152, 266241);
        com.tencent.mm.y.c.axV().b(ar.a.Ogg, 266241);
        com.tencent.mm.y.c.axV().c(ar.a.OeY, ar.a.Off);
        boolean bool1 = com.tencent.mm.y.c.axV().axS();
        if (bool1) {
          com.tencent.mm.y.c.axV().B(352280, false);
        }
        boolean bool2 = com.tencent.mm.y.c.axV().cP(262156, 266241);
        localObject = com.tencent.mm.plugin.report.service.h.CyF;
        if (!bool2) {
          break label367;
        }
        paramInt = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).a(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
        g.aAi();
        g.aAh().azQ().set(ar.a.OeS, Boolean.FALSE);
        localObject = (com.tencent.mm.plugin.textstatus.a.c)g.ah(com.tencent.mm.plugin.textstatus.a.c.class);
        if (!bool1) {
          break label372;
        }
      }
      label367:
      label372:
      for (long l = 7L;; l = 8L)
      {
        ((com.tencent.mm.plugin.textstatus.a.c)localObject).report22208(l, "");
        AppMethodBeat.o(33465);
        return;
        paramInt = 0;
        break;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void akP(int paramInt);
    
    public abstract void akQ(int paramInt);
    
    public abstract void akq(int paramInt);
    
    public abstract void aws(int paramInt);
    
    public abstract void z(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI
 * JD-Core Version:    0.7.0.1
 */