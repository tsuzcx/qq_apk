package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.az;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.ke;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  private static HashMap<String, Integer> JxQ;
  MMFragmentActivity JrI;
  aa JxF;
  LauncherUI.d JxG;
  boolean JxH;
  private HashSet<m> JxI;
  private int JxJ;
  private int JxK;
  a JxL;
  com.tencent.mm.sdk.b.c JxM;
  private boolean JxN;
  com.tencent.mm.sdk.b.c JxO;
  com.tencent.mm.sdk.b.c JxP;
  public HashMap<Integer, MMFragment> JxR;
  public int abZ;
  private int aca;
  private final long ius;
  TabsAdapter mTabsAdapter;
  CustomViewPager mViewPager;
  com.tencent.mm.plugin.appbrand.widget.header.a mZF;
  
  static
  {
    AppMethodBeat.i(33486);
    HashMap localHashMap = new HashMap();
    JxQ = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    JxQ.put("tab_address", Integer.valueOf(1));
    JxQ.put("tab_find_friend", Integer.valueOf(2));
    JxQ.put("tab_settings", Integer.valueOf(3));
    AppMethodBeat.o(33486);
  }
  
  public MainTabUI()
  {
    AppMethodBeat.i(33466);
    this.ius = 180000L;
    this.JxF = new aa();
    this.JxI = new HashSet();
    this.abZ = -1;
    this.aca = -1;
    this.JxJ = -1;
    this.JxK = -1;
    this.JxM = new com.tencent.mm.sdk.b.c() {};
    this.JxN = true;
    this.JxO = new com.tencent.mm.sdk.b.c() {};
    this.JxP = new com.tencent.mm.sdk.b.c() {};
    this.JxR = new HashMap();
    AppMethodBeat.o(33466);
  }
  
  private MMFragment acv(int paramInt)
  {
    AppMethodBeat.i(33478);
    MMFragment localMMFragment = null;
    Object localObject1 = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ae.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localMMFragment != null) {
        localMMFragment.setParent(this.JrI);
      }
      AppMethodBeat.o(33478);
      return localMMFragment;
      ((Bundle)localObject1).putInt(MainUI.class.getName(), 0);
      localMMFragment = (MMFragment)Fragment.instantiate(this.JrI, MainUI.class.getName(), (Bundle)localObject1);
      if ((localMMFragment instanceof MainUI))
      {
        localObject1 = (MainUI)localMMFragment;
        Object localObject2 = this.JrI;
        ((MainUI)localObject1).nbm = ((MMFragmentActivity)localObject2);
        if (((MainUI)localObject1).KSA != null) {
          ((MainUI)localObject1).KSA.setActivity((MMFragmentActivity)localObject2);
        }
        localObject1 = (MainUI)localMMFragment;
        localObject2 = this.mZF;
        ((MainUI)localObject1).KSH = ((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        if (((MainUI)localObject1).KSA != null) {
          ((MainUI)localObject1).KSA.setActionBarUpdateCallback((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        }
      }
      bc.getNotification().cz(true);
      continue;
      ((Bundle)localObject1).putInt(AddressUI.AddressUIFragment.class.getName(), 1);
      ((Bundle)localObject1).putBoolean("Need_Voice_Search", true);
      ((Bundle)localObject1).putBoolean("favour_include_biz", true);
      localMMFragment = (MMFragment)Fragment.instantiate(this.JrI, AddressUI.AddressUIFragment.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(FindMoreFriendsUI.class.getName(), 2);
      localMMFragment = (MMFragment)Fragment.instantiate(this.JrI, FindMoreFriendsUI.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(MoreTabUI.class.getName(), 3);
      localMMFragment = (MMFragment)Fragment.instantiate(this.JrI, MoreTabUI.class.getName(), (Bundle)localObject1);
    }
  }
  
  private void fBe()
  {
    AppMethodBeat.i(33470);
    this.JxR.clear();
    if (this.mViewPager != null)
    {
      this.mViewPager.setCanSlide(false);
      this.mViewPager.setCanSlideBySide(false);
    }
    AppMethodBeat.o(33470);
  }
  
  public final void aWU(String paramString)
  {
    AppMethodBeat.i(33477);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(33477);
      return;
    }
    acw(((Integer)JxQ.get(paramString)).intValue());
    AppMethodBeat.o(33477);
  }
  
  public final void act(int paramInt)
  {
    AppMethodBeat.i(33468);
    MainUI localMainUI = (MainUI)this.JxR.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.act(paramInt);
    }
    AppMethodBeat.o(33468);
  }
  
  public final void acu(int paramInt)
  {
    AppMethodBeat.i(33474);
    MMFragment localMMFragment = acx(paramInt);
    if (localMMFragment == null)
    {
      AppMethodBeat.o(33474);
      return;
    }
    if ((localMMFragment instanceof m)) {
      ((m)localMMFragment).fyT();
    }
    this.mTabsAdapter.mFragmentResumedFlags[paramInt] = true;
    AppMethodBeat.o(33474);
  }
  
  public final void acw(int paramInt)
  {
    AppMethodBeat.i(33479);
    int i = this.abZ;
    if (this.mViewPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      ae.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.JxR.size()) });
      if ((this.mViewPager != null) && (paramInt >= 0) && ((this.mTabsAdapter == null) || (paramInt <= this.mTabsAdapter.getCount() - 1))) {
        break;
      }
      AppMethodBeat.o(33479);
      return;
    }
    if ((this.abZ == paramInt) && (this.JxR.size() != 0))
    {
      AppMethodBeat.o(33479);
      return;
    }
    i = this.abZ;
    this.abZ = paramInt;
    this.JxF.acy(this.abZ);
    if (this.mViewPager != null)
    {
      if (i == -1)
      {
        this.mViewPager.setCurrentItemNotify(this.abZ, false);
        acu(this.abZ);
      }
    }
    else
    {
      if ((this.abZ != 0) || (!com.tencent.matrix.a.cBz.cBB)) {
        break label264;
      }
      bc.getNotification().cz(true);
    }
    for (;;)
    {
      if (this.abZ != 0)
      {
        MMFragment localMMFragment = acx(0);
        if ((localMMFragment instanceof MainUI)) {
          ((MainUI)localMMFragment).fNE();
        }
      }
      AppMethodBeat.o(33479);
      return;
      this.mViewPager.setCurrentItem(this.abZ, false);
      break;
      label264:
      bc.getNotification().cz(false);
    }
  }
  
  public final MMFragment acx(int paramInt)
  {
    AppMethodBeat.i(33480);
    ae.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(33480);
      return null;
    }
    if (this.JxR.containsKey(Integer.valueOf(paramInt)))
    {
      localMMFragment = (MMFragment)this.JxR.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(33480);
      return localMMFragment;
    }
    MMFragment localMMFragment = acv(paramInt);
    this.JxR.put(Integer.valueOf(paramInt), localMMFragment);
    AppMethodBeat.o(33480);
    return localMMFragment;
  }
  
  public final void bRR()
  {
    AppMethodBeat.i(33469);
    com.tencent.mm.sdk.b.a.IvT.d(this.JxM);
    com.tencent.mm.sdk.b.a.IvT.d(this.JxO);
    com.tencent.mm.sdk.b.a.IvT.d(this.JxP);
    fBe();
    AppMethodBeat.o(33469);
  }
  
  public final void fAe()
  {
    AppMethodBeat.i(33475);
    MainUI localMainUI = (MainUI)this.JxR.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.JrI.findViewById(2131301337);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localMainUI != null) {
      localMainUI.onHiddenChanged(true);
    }
    j.a(this.JrI, 4, this.abZ, "prepareStartChatting");
    fBf();
    this.JxF.fBh();
    AppMethodBeat.o(33475);
  }
  
  public final void fAi()
  {
    AppMethodBeat.i(33471);
    MainUI localMainUI = (MainUI)this.JxR.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      localMainUI.fLW();
      localMainUI.fNC();
    }
    AppMethodBeat.o(33471);
  }
  
  public final MMFragment fBd()
  {
    AppMethodBeat.i(33467);
    MMFragment localMMFragment = (MMFragment)this.JxR.get(Integer.valueOf(this.abZ));
    AppMethodBeat.o(33467);
    return localMMFragment;
  }
  
  public final void fBf()
  {
    AppMethodBeat.i(33472);
    MainUI localMainUI = (MainUI)this.JxR.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.fND();
    }
    AppMethodBeat.o(33472);
  }
  
  public final void fBg()
  {
    AppMethodBeat.i(33476);
    if ((this.abZ == 0) && (com.tencent.mm.kernel.g.ajQ().gDv.foreground)) {
      bc.getNotification().cz(true);
    }
    for (;;)
    {
      Object localObject = (ViewGroup)this.JrI.findViewById(2131301337);
      if (localObject != null) {
        ((ViewGroup)localObject).setImportantForAccessibility(1);
      }
      fAi();
      j.a(this.JrI, 3, this.abZ, "prepareCloseChatting");
      localObject = (MainUI)this.JxR.get(Integer.valueOf(0));
      if (localObject != null)
      {
        ((MainUI)localObject).getContentView();
        if (((MainUI)localObject).mController != null) {
          ((MainUI)localObject).mController.onResume();
        }
        ((MainUI)localObject).onHiddenChanged(false);
      }
      com.tencent.mm.plugin.report.service.h.yxY.qw(true);
      AppMethodBeat.o(33476);
      return;
      bc.getNotification().cz(false);
    }
  }
  
  protected final void fBh()
  {
    AppMethodBeat.i(33481);
    this.JxF.fBh();
    AppMethodBeat.o(33481);
  }
  
  protected final void fBi()
  {
    AppMethodBeat.i(33482);
    this.JxF.fBi();
    AppMethodBeat.o(33482);
  }
  
  protected final void fBj()
  {
    AppMethodBeat.i(33483);
    this.JxF.fBj();
    AppMethodBeat.o(33483);
  }
  
  public final void fBk()
  {
    AppMethodBeat.i(187006);
    aa localaa = this.JxF;
    com.tencent.e.h.MqF.h(new aa.3(localaa), "setConversationTagUnread");
    AppMethodBeat.o(187006);
  }
  
  public final void fBl()
  {
    AppMethodBeat.i(33485);
    this.JxR.get(Integer.valueOf(0));
    AppMethodBeat.o(33485);
  }
  
  public final void jG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(33473);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(33473);
      return;
    }
    MMFragment localMMFragment = acx(paramInt1);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).fzR();
    }
    localMMFragment = acx(paramInt2);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).fzQ();
    }
    j.a(this.JrI, 4, paramInt1, "deliverOnTabChange");
    j.a(this.JrI, 3, paramInt2, "deliverOnTabChange");
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
        localIterator = MainTabUI.fBm().values().iterator();
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
      Iterator localIterator = MainTabUI.fBm().values().iterator();
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
      ae.v("MicroMsg.LauncherUI.MainTabUI", "reportSwitch clickCount:%d, pos:%d", new Object[] { Integer.valueOf(this.clickCount), Integer.valueOf(paramInt) });
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.yxY;
      if (paramInt == 0)
      {
        localh.qw(bool);
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
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10957, "1");
        continue;
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10957, "2");
        continue;
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10957, "3");
        continue;
        com.tencent.mm.plugin.report.service.g.yxI.kvStat(10957, "4");
        continue;
        switch (paramInt)
        {
        default: 
          break;
        case 0: 
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10957, "5");
          break;
        case 1: 
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10957, "6");
          break;
        case 2: 
          label168:
          com.tencent.mm.plugin.report.service.g.yxI.kvStat(10957, "7");
        }
      }
    }
    
    private void setFragmentLoadingIconVisibility(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(33461);
      if ((MainTabUI.this.acx(paramInt1) != null) && (MainTabUI.this.acx(paramInt1).getActivity() != null))
      {
        View localView = MainTabUI.this.acx(paramInt1).findViewById(2131301509);
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
      MMFragment localMMFragment = MainTabUI.this.acx(paramInt);
      AppMethodBeat.o(33458);
      return localMMFragment;
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      AppMethodBeat.i(33464);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V", this, localb.ahF());
      ae.d("MicroMsg.LauncherUI.MainTabUI", "onPageScrollStateChanged state %d", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt == 0) && (this.addressFragment != null))
      {
        this.addressFragment.yw(true);
        this.addressFragment = null;
      }
      if (MainTabUI.d(MainTabUI.this) != null) {
        MainTabUI.d(MainTabUI.this).acj(paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageScrollStateChanged", "(I)V");
      AppMethodBeat.o(33464);
    }
    
    public void onPageScrolled(final int paramInt1, float paramFloat, int paramInt2)
    {
      AppMethodBeat.i(33459);
      aa localaa = MainTabUI.c(MainTabUI.this);
      if (localaa.JxU != null) {
        localaa.JxU.o(paramInt1, paramFloat);
      }
      if (MainTabUI.d(MainTabUI.this) != null) {
        MainTabUI.d(MainTabUI.this).v(paramInt1, paramFloat);
      }
      if (0.0F != paramFloat)
      {
        if (this.addressFragment == null) {
          this.addressFragment = ((AddressUI.AddressUIFragment)MainTabUI.this.acx(1));
        }
        this.addressFragment.yw(false);
      }
      for (;;)
      {
        fixAndroidOProgressBarOutScreenFlashProblem(paramInt1, paramFloat, paramInt2);
        AppMethodBeat.o(33459);
        return;
        ae.v("MicroMsg.LauncherUI.MainTabUI", "onPageScrolled, position = %d, mLastIndex = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(MainTabUI.e(MainTabUI.this)) });
        if (-1 == MainTabUI.e(MainTabUI.this))
        {
          MainTabUI.this.jG(MainTabUI.e(MainTabUI.this), MainTabUI.f(MainTabUI.this));
          MainTabUI.this.acu(paramInt1);
        }
        else
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(33456);
              MainTabUI.this.jG(MainTabUI.e(MainTabUI.this), MainTabUI.f(MainTabUI.this));
              MainTabUI.this.acu(paramInt1);
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
      ((com.tencent.mm.hellhoundlib.b.b)localObject).mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      ae.d("MicroMsg.LauncherUI.MainTabUI", "on page selected changed to %d", new Object[] { Integer.valueOf(paramInt) });
      if (!com.tencent.mm.kernel.g.ajP().aiZ())
      {
        ae.i("MicroMsg.LauncherUI.MainTabUI", "on page position %d selected, but account not initialized.", new Object[] { Integer.valueOf(paramInt) });
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
        MainTabUI.c(MainTabUI.this).acy(paramInt);
        MainTabUI.g(MainTabUI.this).supportInvalidateOptionsMenu();
        localObject = MainTabUI.this.acx(MainTabUI.f(MainTabUI.this));
        if ((MainTabUI.e(MainTabUI.this) == 1) && (MainTabUI.f(MainTabUI.this) != 1))
        {
          bc.aCg();
          com.tencent.mm.model.c.ajA().set(340226, Long.valueOf(System.currentTimeMillis()));
        }
        if (MainTabUI.f(MainTabUI.this) == 1)
        {
          long l = System.currentTimeMillis();
          bc.aCg();
          if (l - bu.a((Long)com.tencent.mm.model.c.ajA().get(340226, null), 0L) >= 180000L) {
            ((AddressUI.AddressUIFragment)localObject).fLY();
          }
        }
        if (MainTabUI.f(MainTabUI.this) == 0) {
          bc.getNotification().cz(true);
        }
        break;
      }
      for (;;)
      {
        if ((localObject != null) && (com.tencent.matrix.b.HS()) && (((MMFragment)localObject).getActivity() != null))
        {
          String str = ((MMFragment)localObject).getActivity().getClass().getName();
          com.tencent.matrix.a.cBz.dL(str + "#" + localObject.getClass().getSimpleName());
        }
        if (MainTabUI.d(MainTabUI.this) != null) {
          MainTabUI.d(MainTabUI.this).aci(MainTabUI.f(MainTabUI.this));
        }
        localObject = new ke();
        ((ke)localObject).dyh.currentIndex = MainTabUI.f(MainTabUI.this);
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MainTabUI$TabsAdapter", "com/tencent/mm/ui/MainTabUI$TabsAdapterandroid/support/v4/view/ViewPager$OnPageChangeListener", "onPageSelected", "(I)V");
        AppMethodBeat.o(33462);
        return;
        com.tencent.mm.plugin.newtips.a.dxD().Mv(2);
        ((t)com.tencent.mm.kernel.g.ad(t.class)).getRedDotManager().aih("Discovery");
        break;
        com.tencent.mm.plugin.newtips.a.dxD().Mv(1);
        break;
        bc.getNotification().cz(false);
      }
    }
    
    public void onTabClick(int paramInt)
    {
      AppMethodBeat.i(33465);
      if (!MainTabUI.a(MainTabUI.this))
      {
        ae.i("MicroMsg.LauncherUI.MainTabUI", "alvinluo now cannot change tab");
        AppMethodBeat.o(33465);
        return;
      }
      Object localObject;
      if (paramInt == MainTabUI.f(MainTabUI.this))
      {
        ae.d("MicroMsg.LauncherUI.MainTabUI", "on click same index");
        localObject = MainTabUI.this.acx(paramInt);
        if ((localObject instanceof AbstractTabChildActivity.AbStractTabFragment)) {
          ((AbstractTabChildActivity.AbStractTabFragment)localObject).fyM();
        }
        AppMethodBeat.o(33465);
        return;
      }
      this.isTabClicked = true;
      this.clickCount += 1;
      ae.v("MicroMsg.LauncherUI.MainTabUI", "onTabClick count:%d", new Object[] { Integer.valueOf(this.clickCount) });
      this.mViewPager.setCurrentItem(paramInt, false);
      if (paramInt == 3)
      {
        com.tencent.mm.y.c.ahI().cK(262145, 266241);
        com.tencent.mm.y.c.ahI().cK(262156, 266241);
        com.tencent.mm.y.c.ahI().cK(262147, 266241);
        com.tencent.mm.y.c.ahI().cK(262149, 266241);
        com.tencent.mm.y.c.ahI().cK(262152, 266241);
        com.tencent.mm.y.c.ahI().b(am.a.IXJ, 266241);
        com.tencent.mm.y.c.ahI().c(am.a.IWG, am.a.IWN);
        boolean bool = com.tencent.mm.y.c.ahI().cJ(262156, 266241);
        localObject = com.tencent.mm.plugin.report.service.g.yxI;
        if (!bool) {
          break label309;
        }
      }
      label309:
      for (paramInt = 1;; paramInt = 0)
      {
        ((com.tencent.mm.plugin.report.service.g)localObject).f(14872, new Object[] { Integer.valueOf(6), Integer.valueOf(paramInt), "", "", Integer.valueOf(0) });
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWA, Boolean.FALSE);
        AppMethodBeat.o(33465);
        return;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aci(int paramInt);
    
    public abstract void acj(int paramInt);
    
    public abstract void v(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI
 * JD-Core Version:    0.7.0.1
 */