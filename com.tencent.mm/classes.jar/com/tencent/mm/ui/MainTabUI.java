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
import com.tencent.mm.an.t;
import com.tencent.mm.f.a.dv;
import com.tencent.mm.f.a.ko;
import com.tencent.mm.f.a.lk;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.findersdk.a.z;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.contact.AddressUI.AddressUIFragment;
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
  private static HashMap<String, Integer> WbF;
  com.tencent.mm.plugin.taskbar.api.a MnB;
  a WbA;
  IListener WbB;
  private boolean WbC;
  IListener WbD;
  IListener WbE;
  public HashMap<Integer, MMFragment> WbG;
  ae Wbu;
  LauncherUI.e Wbv;
  boolean Wbw;
  private HashSet<o> Wbx;
  private int Wby;
  private int Wbz;
  public int iU;
  private int iV;
  TabsAdapter mTabsAdapter;
  CustomViewPager mViewPager;
  private final long meZ;
  MMFragmentActivity zwS;
  
  static
  {
    AppMethodBeat.i(33486);
    HashMap localHashMap = new HashMap();
    WbF = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    WbF.put("tab_address", Integer.valueOf(1));
    WbF.put("tab_find_friend", Integer.valueOf(2));
    WbF.put("tab_settings", Integer.valueOf(3));
    AppMethodBeat.o(33486);
  }
  
  public MainTabUI()
  {
    AppMethodBeat.i(33466);
    this.meZ = 180000L;
    this.Wbu = new ae();
    this.Wbx = new HashSet();
    this.iU = -1;
    this.iV = -1;
    this.Wby = -1;
    this.Wbz = -1;
    this.WbB = new MainTabUI.1(this);
    this.WbC = true;
    this.WbD = new IListener() {};
    this.WbE = new IListener() {};
    this.WbG = new HashMap();
    AppMethodBeat.o(33466);
  }
  
  private MMFragment aua(int paramInt)
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
        localMMFragment.setParent(this.zwS);
      }
      AppMethodBeat.o(33478);
      return localMMFragment;
      ((Bundle)localObject1).putInt(MainUI.class.getName(), 0);
      localMMFragment = (MMFragment)Fragment.instantiate(this.zwS, MainUI.class.getName(), (Bundle)localObject1);
      if ((localMMFragment instanceof MainUI))
      {
        localObject1 = (MainUI)localMMFragment;
        Object localObject2 = this.zwS;
        ((MainUI)localObject1).Jvc = ((MMFragmentActivity)localObject2);
        if (((MainUI)localObject1).XCL != null) {
          ((MainUI)localObject1).XCL.setActivity((MMFragmentActivity)localObject2);
        }
        localObject1 = (MainUI)localMMFragment;
        localObject2 = this.MnB;
        ((MainUI)localObject1).XCT = ((com.tencent.mm.plugin.taskbar.api.a)localObject2);
        if (((MainUI)localObject1).XCL != null) {
          ((MainUI)localObject1).XCL.setActionBarUpdateCallback((com.tencent.mm.plugin.taskbar.api.a)localObject2);
        }
      }
      bh.getNotification().dH(true);
      continue;
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vXo, com.tencent.mm.util.b.a.Yyr, 0) == 1)
      {
        localMMFragment = (MMFragment)Fragment.instantiate(this.zwS, MvvmAddressUIFragment.class.getName(), (Bundle)localObject1);
      }
      else
      {
        ((Bundle)localObject1).putInt(AddressUI.AddressUIFragment.class.getName(), 1);
        ((Bundle)localObject1).putBoolean("Need_Voice_Search", true);
        ((Bundle)localObject1).putBoolean("favour_include_biz", true);
        localMMFragment = (MMFragment)Fragment.instantiate(this.zwS, AddressUI.AddressUIFragment.class.getName(), (Bundle)localObject1);
        continue;
        ((Bundle)localObject1).putInt(FindMoreFriendsUI.class.getName(), 2);
        localMMFragment = (MMFragment)Fragment.instantiate(this.zwS, FindMoreFriendsUI.class.getName(), (Bundle)localObject1);
        continue;
        ((Bundle)localObject1).putInt(MoreTabUI.class.getName(), 3);
        localMMFragment = (MMFragment)Fragment.instantiate(this.zwS, MoreTabUI.class.getName(), (Bundle)localObject1);
      }
    }
  }
  
  private void hHW()
  {
    AppMethodBeat.i(33470);
    this.WbG.clear();
    if (this.mViewPager != null)
    {
      this.mViewPager.setCanSlide(false);
      this.mViewPager.setCanSlideBySide(false);
    }
    AppMethodBeat.o(33470);
  }
  
  public final void atY(int paramInt)
  {
    AppMethodBeat.i(33468);
    MainUI localMainUI = (MainUI)this.WbG.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.atY(paramInt);
    }
    AppMethodBeat.o(33468);
  }
  
  public final void atZ(int paramInt)
  {
    AppMethodBeat.i(33474);
    Log.i("MicroMsg.LauncherUI.MainTabUI", "deliverOnTabResume %s", new Object[] { Integer.valueOf(paramInt) });
    MMFragment localMMFragment = auc(paramInt);
    if (localMMFragment == null)
    {
      AppMethodBeat.o(33474);
      return;
    }
    if ((localMMFragment instanceof o)) {
      ((o)localMMFragment).hFo();
    }
    this.mTabsAdapter.mFragmentResumedFlags[paramInt] = true;
    AppMethodBeat.o(33474);
  }
  
  public final void aub(int paramInt)
  {
    AppMethodBeat.i(33479);
    int i = this.iU;
    if (this.mViewPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.WbG.size()) });
      if ((this.mViewPager != null) && (paramInt >= 0) && ((this.mTabsAdapter == null) || (paramInt <= this.mTabsAdapter.getCount() - 1))) {
        break;
      }
      AppMethodBeat.o(33479);
      return;
    }
    if ((this.iU == paramInt) && (this.WbG.size() != 0))
    {
      AppMethodBeat.o(33479);
      return;
    }
    i = this.iU;
    this.iU = paramInt;
    this.Wbu.aud(this.iU);
    if (this.mViewPager != null)
    {
      if (i == -1)
      {
        this.mViewPager.setCurrentItemNotify(this.iU, false);
        atZ(this.iU);
      }
    }
    else
    {
      if ((this.iU != 0) || (!com.tencent.matrix.a.cQs.cQt)) {
        break label264;
      }
      bh.getNotification().dH(true);
    }
    for (;;)
    {
      if (this.iU != 0)
      {
        MMFragment localMMFragment = auc(0);
        if ((localMMFragment instanceof MainUI)) {
          ((MainUI)localMMFragment).hWx();
        }
      }
      AppMethodBeat.o(33479);
      return;
      this.mViewPager.setCurrentItem(this.iU, false);
      break;
      label264:
      bh.getNotification().dH(false);
    }
  }
  
  public final MMFragment auc(int paramInt)
  {
    AppMethodBeat.i(33480);
    if (paramInt < 0)
    {
      AppMethodBeat.o(33480);
      return null;
    }
    if (this.WbG.containsKey(Integer.valueOf(paramInt)))
    {
      localMMFragment = (MMFragment)this.WbG.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(33480);
      return localMMFragment;
    }
    Log.i("MicroMsg.LauncherUI.MainTabUI", "create tab %d", new Object[] { Integer.valueOf(paramInt) });
    MMFragment localMMFragment = aua(paramInt);
    this.WbG.put(Integer.valueOf(paramInt), localMMFragment);
    AppMethodBeat.o(33480);
    return localMMFragment;
  }
  
  public final void byt(String paramString)
  {
    AppMethodBeat.i(33477);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(33477);
      return;
    }
    aub(((Integer)WbF.get(paramString)).intValue());
    AppMethodBeat.o(33477);
  }
  
  public final boolean fcH()
  {
    AppMethodBeat.i(288636);
    MainUI localMainUI = (MainUI)this.WbG.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      boolean bool = localMainUI.fcH();
      AppMethodBeat.o(288636);
      return bool;
    }
    AppMethodBeat.o(288636);
    return false;
  }
  
  public final void hGG()
  {
    AppMethodBeat.i(33475);
    MainUI localMainUI = (MainUI)this.WbG.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.zwS.findViewById(R.h.dKQ);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localMainUI != null) {
      localMainUI.onHiddenChanged(true);
    }
    l.a(this.zwS, 4, this.iU, "prepareStartChatting");
    hHX();
    this.Wbu.hHZ();
    AppMethodBeat.o(33475);
  }
  
  public final void hGL()
  {
    AppMethodBeat.i(33471);
    MainUI localMainUI = (MainUI)this.WbG.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      localMainUI.hUj();
      localMainUI.hWv();
    }
    AppMethodBeat.o(33471);
  }
  
  public final MMFragment hHU()
  {
    AppMethodBeat.i(33467);
    MMFragment localMMFragment = (MMFragment)this.WbG.get(Integer.valueOf(this.iU));
    AppMethodBeat.o(33467);
    return localMMFragment;
  }
  
  public final void hHV()
  {
    AppMethodBeat.i(33469);
    EventCenter.instance.removeListener(this.WbB);
    EventCenter.instance.removeListener(this.WbD);
    EventCenter.instance.removeListener(this.WbE);
    hHW();
    AppMethodBeat.o(33469);
  }
  
  public final void hHX()
  {
    AppMethodBeat.i(33472);
    MainUI localMainUI = (MainUI)this.WbG.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.hWw();
    }
    AppMethodBeat.o(33472);
  }
  
  public final void hHY()
  {
    AppMethodBeat.i(33476);
    if ((this.iU == 0) && (com.tencent.mm.kernel.h.aHF().kcd.foreground)) {
      bh.getNotification().dH(true);
    }
    for (;;)
    {
      Object localObject = (ViewGroup)this.zwS.findViewById(R.h.dKQ);
      if (localObject != null) {
        ((ViewGroup)localObject).setImportantForAccessibility(1);
      }
      hGL();
      l.a(this.zwS, 3, this.iU, "prepareCloseChatting");
      localObject = (MainUI)this.WbG.get(Integer.valueOf(0));
      if (localObject != null)
      {
        ((MainUI)localObject).getContentView();
        if (((MainUI)localObject).mController != null) {
          ((MainUI)localObject).mController.onResume();
        }
        ((MainUI)localObject).onHiddenChanged(false);
      }
      com.tencent.mm.plugin.report.service.i.IzV.xj(true);
      AppMethodBeat.o(33476);
      return;
      bh.getNotification().dH(false);
    }
  }
  
  protected final void hHZ()
  {
    AppMethodBeat.i(33481);
    this.Wbu.hHZ();
    AppMethodBeat.o(33481);
  }
  
  protected final void hIa()
  {
    AppMethodBeat.i(33482);
    this.Wbu.hIa();
    AppMethodBeat.o(33482);
  }
  
  protected final void hIb()
  {
    AppMethodBeat.i(33483);
    this.Wbu.hIb();
    AppMethodBeat.o(33483);
  }
  
  public final void hIc()
  {
    AppMethodBeat.i(288634);
    ae localae = this.Wbu;
    com.tencent.e.h.ZvG.f(new ae.3(localae), "setConversationTagUnread");
    AppMethodBeat.o(288634);
  }
  
  public final void hId()
  {
    AppMethodBeat.i(288635);
    MainUI localMainUI = (MainUI)this.WbG.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.hId();
    }
    AppMethodBeat.o(288635);
  }
  
  public final void mh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33473);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(33473);
      return;
    }
    MMFragment localMMFragment = auc(paramInt1);
    if ((localMMFragment != null) && ((localMMFragment instanceof o))) {
      ((o)localMMFragment).gkE();
    }
    localMMFragment = auc(paramInt2);
    if ((localMMFragment != null) && ((localMMFragment instanceof o))) {
      ((o)localMMFragment).gkF();
    }
    l.a(this.zwS, 4, paramInt1, "deliverOnTabChange");
    l.a(this.zwS, 3, paramInt2, "deliverOnTabChange");
    AppMethodBeat.o(33473);
  }
  
  final void setCanSlide(boolean paramBoolean)
  {
    AppMethodBeat.i(288630);
    this.mViewPager.setCanSlide(paramBoolean);
    AppMethodBeat.o(288630);
  }
  
  public class TabsAdapter
    extends androidx.fragment.app.h
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
      AppMethodBeat.i(283967);
      this.isTabClicked = false;
      this.clickCount = 0;
      this.mFragmentResumedFlags = new boolean[] { 1, 0, 0, 0 };
      this.mViewPager = paramWxViewPager;
      this.mViewPager.setAdapter(this);
      this.mViewPager.setOnPageChangeListener(this);
      AppMethodBeat.o(283967);
    }
    
    private void fixAndroidOProgressBarOutScreenFlashProblem(int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33460);
      Integer localInteger;
      if (paramInt2 == 0)
      {
        localIterator = MainTabUI.WbF.values().iterator();
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
      Iterator localIterator = MainTabUI.WbF.values().iterator();
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
      com.tencent.mm.plugin.report.service.i locali = com.tencent.mm.plugin.report.service.i.IzV;
      if (paramInt == 0)
      {
        locali.xj(bool);
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
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10957, "1");
        continue;
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10957, "2");
        continue;
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10957, "3");
        continue;
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(10957, "4");
        continue;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10957, "5");
          break;
        case 1: 
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10957, "6");
          break;
        case 2: 
          label168:
          com.tencent.mm.plugin.report.service.h.IzE.kvStat(10957, "7");
        }
      }
    }
    
    private void setFragmentLoadingIconVisibility(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33461);
      if ((MainTabUI.this.auc(paramInt1) != null) && (MainTabUI.this.auc(paramInt1).getActivity() != null))
      {
        View localView = MainTabUI.this.auc(paramInt1).findViewById(R.h.loading_progress_bar);
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
      AppMethodBeat.i(283968);
      MMFragment localMMFragment = MainTabUI.this.auc(paramInt);
      AppMethodBeat.o(283968);
      return localMMFragment;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(33464);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V", this, localb.aFi());
      Log.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (this.addressFragment != null))
      {
        this.addressFragment.GH(true);
        this.addressFragment = null;
      }
      if (MainTabUI.c(MainTabUI.this) != null) {
        MainTabUI.c(MainTabUI.this).atK(paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V");
      AppMethodBeat.o(33464);
    }
    
    public void onPageScrolled(final int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33459);
      ae localae = MainTabUI.b(MainTabUI.this);
      if (localae.WbJ != null) {
        localae.WbJ.q(paramInt1, paramFloat);
      }
      if (MainTabUI.c(MainTabUI.this) != null) {
        MainTabUI.c(MainTabUI.this).z(paramInt1, paramFloat);
      }
      if (0.0F != paramFloat)
      {
        if (this.addressFragment == null) {
          this.addressFragment = ((BaseAddressUIFragment)MainTabUI.this.auc(1));
        }
        this.addressFragment.GH(false);
      }
      for (;;)
      {
        fixAndroidOProgressBarOutScreenFlashProblem(paramInt1, paramFloat, paramInt2);
        AppMethodBeat.o(33459);
        return;
        Log.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(MainTabUI.d(MainTabUI.this)) });
        if (-1 == MainTabUI.d(MainTabUI.this))
        {
          MainTabUI.this.mh(MainTabUI.d(MainTabUI.this), MainTabUI.e(MainTabUI.this));
          MainTabUI.this.atZ(paramInt1);
        }
        else
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33456);
              MainTabUI.this.mh(MainTabUI.d(MainTabUI.this), MainTabUI.e(MainTabUI.this));
              MainTabUI.this.atZ(paramInt1);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      Log.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
      if (!com.tencent.mm.kernel.h.aHE().aGM())
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
        MainTabUI.b(MainTabUI.this).aud(paramInt);
        MainTabUI.f(MainTabUI.this).supportInvalidateOptionsMenu();
        localObject1 = MainTabUI.this.auc(MainTabUI.e(MainTabUI.this));
        if ((MainTabUI.d(MainTabUI.this) == 1) && (MainTabUI.e(MainTabUI.this) != 1))
        {
          bh.beI();
          com.tencent.mm.model.c.aHp().i(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (MainTabUI.e(MainTabUI.this) == 1)
        {
          long l = System.currentTimeMillis();
          bh.beI();
          if (l - Util.nullAs((Long)com.tencent.mm.model.c.aHp().b(340226, null), 0L) >= 180000L) {
            ((BaseAddressUIFragment)localObject1).hUl();
          }
        }
        if (MainTabUI.e(MainTabUI.this) == 0) {
          bh.getNotification().dH(true);
        }
        break;
      }
      for (;;)
      {
        Object localObject2;
        if ((localObject1 != null) && (com.tencent.matrix.b.Vt()) && (((MMFragment)localObject1).getActivity() != null))
        {
          localObject2 = ((MMFragment)localObject1).getActivity().getClass().getName();
          com.tencent.matrix.a.cQs.eH((String)localObject2 + "#" + localObject1.getClass().getSimpleName());
        }
        if (MainTabUI.c(MainTabUI.this) != null) {
          MainTabUI.c(MainTabUI.this).atJ(MainTabUI.e(MainTabUI.this));
        }
        localObject1 = new lk();
        ((lk)localObject1).fJf.currentIndex = MainTabUI.e(MainTabUI.this);
        EventCenter.instance.publish((IEvent)localObject1);
        if ((ar.hIO()) && (ar.aGp(MainTabUI.g(MainTabUI.this).getTaskId())) && (az.a(az.hXf(), MainTabUI.g(MainTabUI.this).getTaskId()) != 1) && (u.a(u.hHB(), MainTabUI.g(MainTabUI.this).getTaskId()) != 1))
        {
          localObject2 = new Intent(MainTabUI.g(MainTabUI.this), EmptyActivity.class);
          localObject1 = MainTabUI.g(MainTabUI.this);
          localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject2);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/ui/MainTabUI$TabsAdapter", "onPageSelected", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((MMFragmentActivity)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "onPageSelected", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          Log.i("MicroMsg.LauncherUI.MainTabUI", "start empty activity");
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroidx/viewpager/widget/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
        com.tencent.mm.plugin.newtips.a.fiO().aap(2);
        ((ak)com.tencent.mm.kernel.h.ag(ak.class)).getRedDotManager().aBd("Discovery");
        break;
        com.tencent.mm.plugin.newtips.a.fiO().aap(1);
        break;
        bh.getNotification().dH(false);
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
        localObject = MainTabUI.this.auc(paramInt);
        if ((localObject instanceof AbstractTabChildActivity.AbStractTabFragment)) {
          ((AbstractTabChildActivity.AbStractTabFragment)localObject).hFh();
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
        com.tencent.mm.aa.c.aFn().dl(262145, 266241);
        com.tencent.mm.aa.c.aFn().dl(262156, 266241);
        com.tencent.mm.aa.c.aFn().dl(262147, 266241);
        com.tencent.mm.aa.c.aFn().dl(262149, 266241);
        com.tencent.mm.aa.c.aFn().dl(262152, 266241);
        com.tencent.mm.aa.c.aFn().b(ar.a.Vuw, 266241);
        com.tencent.mm.aa.c.aFn().c(ar.a.Vtk, ar.a.Vtr);
        boolean bool1 = com.tencent.mm.aa.c.aFn().aFk();
        if (bool1) {
          com.tencent.mm.aa.c.aFn().D(352280, false);
        }
        boolean bool2 = com.tencent.mm.aa.c.aFn().dk(262156, 266241);
        localObject = com.tencent.mm.plugin.report.service.h.IzE;
        if (!bool2) {
          break label367;
        }
        paramInt = 1;
        ((com.tencent.mm.plugin.report.service.h)localObject).a(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtd, Boolean.FALSE);
        localObject = (com.tencent.mm.plugin.textstatus.a.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.textstatus.a.d.class);
        if (!bool1) {
          break label372;
        }
      }
      label367:
      label372:
      for (long l = 7L;; l = 8L)
      {
        ((com.tencent.mm.plugin.textstatus.a.d)localObject).report22208(l, "");
        AppMethodBeat.o(33465);
        return;
        paramInt = 0;
        break;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void YM(int paramInt);
    
    public abstract void YN(int paramInt);
    
    public abstract void atJ(int paramInt);
    
    public abstract void atK(int paramInt);
    
    public abstract void z(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI
 * JD-Core Version:    0.7.0.1
 */