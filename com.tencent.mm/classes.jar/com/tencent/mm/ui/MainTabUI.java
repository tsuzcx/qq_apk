package com.tencent.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.mq;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.finder.extension.reddot.l.a;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.contact.address.BaseAddressUIFragment;
import com.tencent.mm.ui.contact.address.MvvmAddressUIFragment;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.mogic.WxViewPager;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MainTabUI
{
  private static HashMap<String, Integer> adHe;
  MMFragmentActivity EzS;
  com.tencent.mm.plugin.taskbar.api.a SQU;
  ah adGR;
  LauncherUI.e adGS;
  boolean adGT;
  private HashSet<p> adGU;
  private int adGV;
  private int adGW;
  a adGX;
  Boolean adGY;
  IListener adGZ;
  private boolean adHa;
  IListener adHb;
  IListener adHc;
  boolean adHd;
  public HashMap<Integer, MMFragment> adHf;
  public int jP;
  private int jQ;
  TabsAdapter mTabsAdapter;
  CustomViewPager mViewPager;
  private final long oXR;
  
  static
  {
    AppMethodBeat.i(33486);
    HashMap localHashMap = new HashMap();
    adHe = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    adHe.put("tab_address", Integer.valueOf(1));
    adHe.put("tab_find_friend", Integer.valueOf(2));
    adHe.put("tab_settings", Integer.valueOf(3));
    AppMethodBeat.o(33486);
  }
  
  public MainTabUI()
  {
    AppMethodBeat.i(33466);
    this.oXR = 180000L;
    this.adGR = new ah();
    this.adGU = new HashSet();
    this.jP = -1;
    this.jQ = -1;
    this.adGV = -1;
    this.adGW = -1;
    this.adGY = Boolean.FALSE;
    this.adGZ = new MainTabUI.1(this, com.tencent.mm.app.f.hfK);
    this.adHa = true;
    this.adHb = new MainTabUI.2(this, com.tencent.mm.app.f.hfK);
    this.adHc = new MainTabUI.3(this, com.tencent.mm.app.f.hfK);
    this.adHd = false;
    this.adHf = new HashMap();
    AppMethodBeat.o(33466);
  }
  
  private MMFragment KC(int paramInt)
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
        localMMFragment.setParent(this.EzS);
      }
      AppMethodBeat.o(33478);
      return localMMFragment;
      ((Bundle)localObject1).putInt(MainUI.class.getName(), 0);
      localMMFragment = (MMFragment)Fragment.instantiate(this.EzS, MainUI.class.getName(), (Bundle)localObject1);
      if ((localMMFragment instanceof MainUI))
      {
        localObject1 = (MainUI)localMMFragment;
        Object localObject2 = this.EzS;
        ((MainUI)localObject1).PIA = ((MMFragmentActivity)localObject2);
        if (((MainUI)localObject1).afpp != null) {
          ((MainUI)localObject1).afpp.setActivity((MMFragmentActivity)localObject2);
        }
        localObject1 = (MainUI)localMMFragment;
        localObject2 = this.SQU;
        ((MainUI)localObject1).afqv = ((com.tencent.mm.plugin.taskbar.api.a)localObject2);
        if (((MainUI)localObject1).afpp != null) {
          ((MainUI)localObject1).afpp.setActionBarUpdateCallback((com.tencent.mm.plugin.taskbar.api.a)localObject2);
        }
      }
      com.tencent.mm.model.bh.getNotification().et(true);
      continue;
      localMMFragment = (MMFragment)Fragment.instantiate(this.EzS, MvvmAddressUIFragment.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(FindMoreFriendsUI.class.getName(), 2);
      localMMFragment = (MMFragment)Fragment.instantiate(this.EzS, FindMoreFriendsUI.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(MoreTabUI.class.getName(), 3);
      localMMFragment = (MMFragment)Fragment.instantiate(this.EzS, MoreTabUI.class.getName(), (Bundle)localObject1);
    }
  }
  
  private void jkd()
  {
    AppMethodBeat.i(33470);
    this.adHf.clear();
    if (this.mViewPager != null)
    {
      this.mViewPager.setCanSlide(false);
      this.mViewPager.setCanSlideBySide(false);
    }
    AppMethodBeat.o(33470);
  }
  
  public final void aAq(int paramInt)
  {
    AppMethodBeat.i(33468);
    MainUI localMainUI = (MainUI)this.adHf.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.aAq(paramInt);
    }
    AppMethodBeat.o(33468);
  }
  
  public final void aAr(int paramInt)
  {
    AppMethodBeat.i(33474);
    Log.i("MicroMsg.LauncherUI.MainTabUI", "deliverOnTabResume %s", new Object[] { Integer.valueOf(paramInt) });
    MMFragment localMMFragment = aAt(paramInt);
    if (localMMFragment == null)
    {
      AppMethodBeat.o(33474);
      return;
    }
    if ((localMMFragment instanceof p)) {
      ((p)localMMFragment).jhA();
    }
    this.mTabsAdapter.mFragmentResumedFlags[paramInt] = true;
    AppMethodBeat.o(33474);
  }
  
  public final void aAs(int paramInt)
  {
    AppMethodBeat.i(33479);
    int i = this.jP;
    if (this.mViewPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.adHf.size()) });
      if ((this.mViewPager != null) && (paramInt >= 0) && ((this.mTabsAdapter == null) || (paramInt <= this.mTabsAdapter.getCount() - 1))) {
        break;
      }
      AppMethodBeat.o(33479);
      return;
    }
    if ((this.jP == paramInt) && (this.adHf.size() != 0))
    {
      AppMethodBeat.o(33479);
      return;
    }
    i = this.jP;
    this.jP = paramInt;
    this.adGR.aAu(this.jP);
    if (this.mViewPager != null)
    {
      if (i == -1)
      {
        this.mViewPager.setCurrentItemNotify(this.jP, false);
        aAr(this.jP);
      }
    }
    else
    {
      if ((this.jP != 0) || (!com.tencent.matrix.a.eLw.eLx)) {
        break label264;
      }
      com.tencent.mm.model.bh.getNotification().et(true);
    }
    for (;;)
    {
      if (this.jP != 0)
      {
        MMFragment localMMFragment = aAt(0);
        if ((localMMFragment instanceof MainUI)) {
          ((MainUI)localMMFragment).jAM();
        }
      }
      AppMethodBeat.o(33479);
      return;
      this.mViewPager.setCurrentItem(this.jP, false);
      break;
      label264:
      com.tencent.mm.model.bh.getNotification().et(false);
    }
  }
  
  public final MMFragment aAt(int paramInt)
  {
    AppMethodBeat.i(33480);
    if (paramInt < 0)
    {
      AppMethodBeat.o(33480);
      return null;
    }
    if (this.adHf.containsKey(Integer.valueOf(paramInt)))
    {
      localMMFragment = (MMFragment)this.adHf.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(33480);
      return localMMFragment;
    }
    Log.i("MicroMsg.LauncherUI.MainTabUI", "create tab %d", new Object[] { Integer.valueOf(paramInt) });
    MMFragment localMMFragment = KC(paramInt);
    this.adHf.put(Integer.valueOf(paramInt), localMMFragment);
    AppMethodBeat.o(33480);
    return localMMFragment;
  }
  
  public final void bzP(String paramString)
  {
    AppMethodBeat.i(33477);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(33477);
      return;
    }
    aAs(((Integer)adHe.get(paramString)).intValue());
    AppMethodBeat.o(33477);
  }
  
  public final boolean glK()
  {
    AppMethodBeat.i(249237);
    MainUI localMainUI = (MainUI)this.adHf.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      boolean bool = localMainUI.glK();
      AppMethodBeat.o(249237);
      return bool;
    }
    AppMethodBeat.o(249237);
    return false;
  }
  
  public final void jiR()
  {
    AppMethodBeat.i(33475);
    MainUI localMainUI = (MainUI)this.adHf.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.EzS.findViewById(R.h.fMr);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localMainUI != null) {
      localMainUI.onHiddenChanged(true);
    }
    k.a(this.EzS, 4, this.jP, "prepareStartChatting");
    jke();
    this.adGR.jkg();
    this.adHd = true;
    AppMethodBeat.o(33475);
  }
  
  public final void jiW()
  {
    AppMethodBeat.i(33471);
    MainUI localMainUI = (MainUI)this.adHf.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      localMainUI.jxZ();
      localMainUI.jAK();
    }
    AppMethodBeat.o(33471);
  }
  
  public final MMFragment jkb()
  {
    AppMethodBeat.i(33467);
    MMFragment localMMFragment = (MMFragment)this.adHf.get(Integer.valueOf(this.jP));
    AppMethodBeat.o(33467);
    return localMMFragment;
  }
  
  public final void jkc()
  {
    AppMethodBeat.i(33469);
    this.adGZ.dead();
    this.adHb.dead();
    this.adHc.dead();
    jkd();
    AppMethodBeat.o(33469);
  }
  
  public final void jke()
  {
    AppMethodBeat.i(33472);
    MainUI localMainUI = (MainUI)this.adHf.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.jAL();
    }
    AppMethodBeat.o(33472);
  }
  
  public final void jkf()
  {
    AppMethodBeat.i(33476);
    if ((this.jP == 0) && (com.tencent.mm.kernel.h.baD().mCm.foreground)) {
      com.tencent.mm.model.bh.getNotification().et(true);
    }
    for (;;)
    {
      Object localObject = (ViewGroup)this.EzS.findViewById(R.h.fMr);
      if (localObject != null) {
        ((ViewGroup)localObject).setImportantForAccessibility(1);
      }
      jiW();
      k.a(this.EzS, 3, this.jP, "prepareCloseChatting");
      localObject = (MainUI)this.adHf.get(Integer.valueOf(0));
      if (localObject != null)
      {
        ((MainUI)localObject).getContentView();
        if (((MainUI)localObject).mController != null) {
          ((MainUI)localObject).mController.onResume();
        }
        ((MainUI)localObject).onHiddenChanged(false);
      }
      com.tencent.mm.plugin.report.service.i.OAE.BK(true);
      AppMethodBeat.o(33476);
      return;
      com.tencent.mm.model.bh.getNotification().et(false);
    }
  }
  
  protected final void jkg()
  {
    AppMethodBeat.i(33481);
    this.adGR.jkg();
    AppMethodBeat.o(33481);
  }
  
  protected final void jkh()
  {
    AppMethodBeat.i(33482);
    this.adGR.jkh();
    AppMethodBeat.o(33482);
  }
  
  protected final void jki()
  {
    AppMethodBeat.i(33483);
    this.adGR.jki();
    AppMethodBeat.o(33483);
  }
  
  public final void jkj()
  {
    AppMethodBeat.i(249233);
    ah localah = this.adGR;
    com.tencent.threadpool.h.ahAA.i(new ah.2(localah), "setConversationTagUnread");
    AppMethodBeat.o(249233);
  }
  
  public final void jkk()
  {
    AppMethodBeat.i(249235);
    this.adGY = Boolean.FALSE;
    MainUI localMainUI = (MainUI)this.adHf.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.jkk();
    }
    AppMethodBeat.o(249235);
  }
  
  public final void nY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33473);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(33473);
      return;
    }
    MMFragment localMMFragment = aAt(paramInt1);
    if ((localMMFragment != null) && ((localMMFragment instanceof p))) {
      ((p)localMMFragment).hFp();
    }
    localMMFragment = aAt(paramInt2);
    if ((localMMFragment != null) && ((localMMFragment instanceof p))) {
      ((p)localMMFragment).hFq();
    }
    k.a(this.EzS, 4, paramInt1, "deliverOnTabChange");
    k.a(this.EzS, 3, paramInt2, "deliverOnTabChange");
    AppMethodBeat.o(33473);
  }
  
  final void setCanSlide(boolean paramBoolean)
  {
    AppMethodBeat.i(249199);
    this.mViewPager.setCanSlide(paramBoolean);
    AppMethodBeat.o(249199);
  }
  
  public class TabsAdapter
    extends androidx.fragment.app.p
    implements ViewPager.OnPageChangeListener, d.a
  {
    private byte _hellAccFlag_;
    private BaseAddressUIFragment addressFragment;
    private int clickCount;
    private boolean isTabClicked;
    boolean[] mFragmentResumedFlags;
    private final WxViewPager mViewPager;
    
    public TabsAdapter(FragmentActivity paramFragmentActivity, WxViewPager paramWxViewPager)
    {
      super();
      AppMethodBeat.i(249550);
      this.isTabClicked = false;
      this.clickCount = 0;
      this.mFragmentResumedFlags = new boolean[] { 1, 0, 0, 0 };
      this.mViewPager = paramWxViewPager;
      this.mViewPager.setAdapter(this);
      this.mViewPager.setOnPageChangeListener(this);
      AppMethodBeat.o(249550);
    }
    
    private void fixAndroidOProgressBarOutScreenFlashProblem(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33460);
      Integer localInteger;
      if (paramInt2 == 0)
      {
        localIterator = MainTabUI.adHe.values().iterator();
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
      Iterator localIterator = MainTabUI.adHe.values().iterator();
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
      com.tencent.mm.plugin.report.service.i locali = com.tencent.mm.plugin.report.service.i.OAE;
      if (paramInt == 0)
      {
        locali.BK(bool);
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
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10957, "1");
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10957, "2");
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10957, "3");
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10957, "4");
        continue;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10957, "5");
          break;
        case 1: 
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10957, "6");
          break;
        case 2: 
          label168:
          com.tencent.mm.plugin.report.service.h.OAn.kvStat(10957, "7");
        }
      }
    }
    
    private void setFragmentLoadingIconVisibility(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33461);
      if ((MainTabUI.this.aAt(paramInt1) != null) && (MainTabUI.this.aAt(paramInt1).getActivity() != null))
      {
        View localView = MainTabUI.this.aAt(paramInt1).findViewById(R.h.loading_progress_bar);
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
      AppMethodBeat.i(249569);
      MMFragment localMMFragment = MainTabUI.this.aAt(paramInt);
      AppMethodBeat.o(249569);
      return localMMFragment;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(33464);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V", this, localb.aYj());
      Log.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (this.addressFragment != null))
      {
        this.addressFragment.Mw(true);
        this.addressFragment = null;
      }
      if (MainTabUI.c(MainTabUI.this) != null) {
        MainTabUI.c(MainTabUI.this).aAc(paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V");
      AppMethodBeat.o(33464);
    }
    
    public void onPageScrolled(final int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33459);
      ah localah = MainTabUI.b(MainTabUI.this);
      if (localah.adHj != null) {
        localah.adHj.t(paramInt1, paramFloat);
      }
      if (MainTabUI.c(MainTabUI.this) != null) {
        MainTabUI.c(MainTabUI.this).C(paramInt1, paramFloat);
      }
      if (0.0F != paramFloat)
      {
        if (this.addressFragment == null) {
          this.addressFragment = ((BaseAddressUIFragment)MainTabUI.this.aAt(1));
        }
        this.addressFragment.Mw(false);
      }
      for (;;)
      {
        fixAndroidOProgressBarOutScreenFlashProblem(paramInt1, paramFloat, paramInt2);
        AppMethodBeat.o(33459);
        return;
        Log.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(MainTabUI.d(MainTabUI.this)) });
        if (-1 == MainTabUI.d(MainTabUI.this))
        {
          MainTabUI.this.nY(MainTabUI.d(MainTabUI.this), MainTabUI.e(MainTabUI.this));
          MainTabUI.this.aAr(paramInt1);
        }
        else
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33456);
              MainTabUI.this.nY(MainTabUI.d(MainTabUI.this), MainTabUI.e(MainTabUI.this));
              MainTabUI.this.aAr(paramInt1);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
      Log.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
      if (!com.tencent.mm.kernel.h.baC().aZN())
      {
        Log.i("MicroMsg.LauncherUI.MainTabUI", "on page position %d selected, but account not initialized.", new Object[] { Integer.valueOf(paramInt) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
      }
      switch (paramInt)
      {
      default: 
        reportSwitch(paramInt);
        MainTabUI.a(MainTabUI.this, MainTabUI.e(MainTabUI.this));
        MainTabUI.b(MainTabUI.this, paramInt);
        MainTabUI.b(MainTabUI.this).aAu(paramInt);
        MainTabUI.f(MainTabUI.this).supportInvalidateOptionsMenu();
        localObject1 = MainTabUI.this.aAt(MainTabUI.e(MainTabUI.this));
        if ((MainTabUI.d(MainTabUI.this) == 1) && (MainTabUI.e(MainTabUI.this) != 1))
        {
          com.tencent.mm.model.bh.bCz();
          com.tencent.mm.model.c.ban().B(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (MainTabUI.e(MainTabUI.this) == 1)
        {
          long l = System.currentTimeMillis();
          com.tencent.mm.model.bh.bCz();
          if (l - Util.nullAs((Long)com.tencent.mm.model.c.ban().d(340226, null), 0L) >= 180000L) {
            ((BaseAddressUIFragment)localObject1).jyb();
          }
        }
        if (MainTabUI.e(MainTabUI.this) == 0) {
          com.tencent.mm.model.bh.getNotification().et(true);
        }
        break;
      }
      for (;;)
      {
        if ((localObject1 != null) && (com.tencent.matrix.c.isInstalled()) && (((MMFragment)localObject1).getActivity() != null))
        {
          localObject2 = ((MMFragment)localObject1).getActivity().getClass().getName();
          com.tencent.matrix.a.eLw.gf((String)localObject2 + "#" + localObject1.getClass().getSimpleName());
        }
        if (MainTabUI.c(MainTabUI.this) != null) {
          MainTabUI.c(MainTabUI.this).aAb(MainTabUI.e(MainTabUI.this));
        }
        localObject1 = new mq();
        ((mq)localObject1).hOM.currentIndex = MainTabUI.e(MainTabUI.this);
        ((mq)localObject1).publish();
        if ((!aw.jlc()) || (!aw.aAA(MainTabUI.g(MainTabUI.this).getTaskId())) || (bh.a(bh.jBC(), MainTabUI.g(MainTabUI.this).getTaskId()) == 1) || (w.a(w.jjL(), MainTabUI.g(MainTabUI.this).getTaskId()) == 1) || (aj.aAz(MainTabUI.g(MainTabUI.this).getTaskId()) == 1)) {
          break label723;
        }
        if ((MainTabUI.e(MainTabUI.this) != 0) || (!MainTabUI.h(MainTabUI.this).booleanValue())) {
          break label612;
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
        com.tencent.mm.plugin.newtips.a.gtf().aeI(2);
        ((cn)com.tencent.mm.kernel.h.az(cn.class)).getRedDotManager().TL("Discovery");
        break;
        com.tencent.mm.plugin.newtips.a.gtf().aeI(1);
        break;
        com.tencent.mm.model.bh.getNotification().et(false);
      }
      label612:
      Object localObject2 = new Intent(MainTabUI.g(MainTabUI.this), EmptyActivity.class);
      localObject1 = MainTabUI.g(MainTabUI.this);
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/ui/MainTabUI$TabsAdapter", "onPageSelected", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((MMFragmentActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "onPageSelected", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i("MicroMsg.LauncherUI.MainTabUI", "start empty activity");
      label723:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
      AppMethodBeat.o(33462);
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
        localObject = MainTabUI.this.aAt(paramInt);
        if ((localObject instanceof AbstractTabChildActivity.AbStractTabFragment)) {
          ((AbstractTabChildActivity.AbStractTabFragment)localObject).jht();
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
        com.tencent.mm.aa.c.aYo().dX(262145, 266241);
        com.tencent.mm.aa.c.aYo().dX(262156, 266241);
        com.tencent.mm.aa.c.aYo().dX(262147, 266241);
        com.tencent.mm.aa.c.aYo().dX(262149, 266241);
        com.tencent.mm.aa.c.aYo().dX(262152, 266241);
        com.tencent.mm.aa.c.aYo().b(at.a.acWf, 266241);
        com.tencent.mm.aa.c.aYo().c(at.a.acUP, at.a.acUW);
        boolean bool1 = com.tencent.mm.aa.c.aYo().aYl();
        if (bool1) {
          com.tencent.mm.aa.c.aYo().R(352280, false);
        }
        boolean bool2 = com.tencent.mm.aa.c.aYo().dW(262156, 266241);
        localObject = com.tencent.mm.plugin.report.service.h.OAn;
        if (bool2)
        {
          paramInt = 1;
          ((com.tencent.mm.plugin.report.service.h)localObject).b(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
          com.tencent.mm.kernel.h.baF();
          com.tencent.mm.kernel.h.baE().ban().set(at.a.acUI, Boolean.FALSE);
          localObject = (com.tencent.mm.plugin.textstatus.a.f)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.textstatus.a.f.class);
          if (!bool1) {
            break label372;
          }
        }
        label372:
        for (long l = 7L;; l = 8L)
        {
          ((com.tencent.mm.plugin.textstatus.a.f)localObject).report22208(l, "");
          AppMethodBeat.o(33465);
          return;
          paramInt = 0;
          break;
        }
      }
      if ((paramInt == 2) && (MainTabUI.b(MainTabUI.this) != null))
      {
        localObject = MainTabUI.b(MainTabUI.this);
        if (((ah)localObject).adHi != null)
        {
          localObject = ((ah)localObject).adHi;
          l.a locala = ((com.tencent.mm.plugin.finder.extension.reddot.k)localObject).ARt;
          if (locala != null) {
            ((com.tencent.mm.plugin.finder.extension.reddot.k)localObject).a(2, locala.ASh, locala.ASg);
          }
        }
      }
      AppMethodBeat.o(33465);
    }
  }
  
  public static abstract interface a
  {
    public abstract void C(int paramInt, float paramFloat);
    
    public abstract void aAb(int paramInt);
    
    public abstract void aAc(int paramInt);
    
    public abstract void acY(int paramInt);
    
    public abstract void acZ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI
 * JD-Core Version:    0.7.0.1
 */