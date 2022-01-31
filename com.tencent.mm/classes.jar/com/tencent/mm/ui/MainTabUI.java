package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.contact.AddressUI.AddressUIFragment;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import java.util.HashMap;
import java.util.HashSet;

public class MainTabUI
{
  private static HashMap<String, Integer> zcH;
  public int Sl;
  private int Sm;
  private final long TIME_INTERVAL;
  com.tencent.mm.plugin.appbrand.widget.header.a jbW;
  MainTabUI.TabsAdapter mTabsAdapter;
  CustomViewPager mViewPager;
  MMFragmentActivity yXg;
  private HashSet<m> zcA;
  private int zcB;
  private int zcC;
  a zcD;
  c zcE;
  private boolean zcF;
  c zcG;
  public HashMap<Integer, MMFragment> zcI;
  public x zcx;
  LauncherUI.d zcy;
  boolean zcz;
  
  static
  {
    AppMethodBeat.i(29649);
    HashMap localHashMap = new HashMap();
    zcH = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    zcH.put("tab_address", Integer.valueOf(1));
    zcH.put("tab_find_friend", Integer.valueOf(2));
    zcH.put("tab_settings", Integer.valueOf(3));
    AppMethodBeat.o(29649);
  }
  
  public MainTabUI()
  {
    AppMethodBeat.i(29629);
    this.TIME_INTERVAL = 180000L;
    this.zcx = new x();
    this.zcA = new HashSet();
    this.Sl = -1;
    this.Sm = -1;
    this.zcB = -1;
    this.zcC = -1;
    this.zcE = new MainTabUI.1(this);
    this.zcF = true;
    this.zcG = new MainTabUI.2(this);
    this.zcI = new HashMap();
    AppMethodBeat.o(29629);
  }
  
  private MMFragment Ol(int paramInt)
  {
    AppMethodBeat.i(29641);
    MMFragment localMMFragment = null;
    Object localObject1 = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      ab.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localMMFragment != null) {
        localMMFragment.setParent(this.yXg);
      }
      AppMethodBeat.o(29641);
      return localMMFragment;
      ((Bundle)localObject1).putInt(MainUI.class.getName(), 0);
      localMMFragment = (MMFragment)Fragment.instantiate(this.yXg, MainUI.class.getName(), (Bundle)localObject1);
      if ((localMMFragment instanceof MainUI))
      {
        localObject1 = (MainUI)localMMFragment;
        Object localObject2 = this.yXg;
        ((MainUI)localObject1).jdB = ((MMFragmentActivity)localObject2);
        if (((MainUI)localObject1).All != null) {
          ((MainUI)localObject1).All.setActivity((MMFragmentActivity)localObject2);
        }
        localObject1 = (MainUI)localMMFragment;
        localObject2 = this.jbW;
        ((MainUI)localObject1).Alt = ((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        if (((MainUI)localObject1).All != null) {
          ((MainUI)localObject1).All.setActionBarUpdateCallback((com.tencent.mm.plugin.appbrand.widget.header.a)localObject2);
        }
      }
      aw.getNotification().bE(true);
      continue;
      ((Bundle)localObject1).putInt(AddressUI.AddressUIFragment.class.getName(), 1);
      ((Bundle)localObject1).putBoolean("Need_Voice_Search", true);
      ((Bundle)localObject1).putBoolean("favour_include_biz", true);
      localMMFragment = (MMFragment)Fragment.instantiate(this.yXg, AddressUI.AddressUIFragment.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(FindMoreFriendsUI.class.getName(), 2);
      localMMFragment = (MMFragment)Fragment.instantiate(this.yXg, FindMoreFriendsUI.class.getName(), (Bundle)localObject1);
      continue;
      ((Bundle)localObject1).putInt(MoreTabUI.class.getName(), 3);
      localMMFragment = (MMFragment)Fragment.instantiate(this.yXg, MoreTabUI.class.getName(), (Bundle)localObject1);
    }
  }
  
  private void dCD()
  {
    AppMethodBeat.i(29633);
    this.zcI.clear();
    if (this.mViewPager != null)
    {
      this.mViewPager.setCanSlide(false);
      this.mViewPager.setCanSlideBySide(false);
    }
    AppMethodBeat.o(29633);
  }
  
  public final void Oj(int paramInt)
  {
    AppMethodBeat.i(29631);
    MainUI localMainUI = (MainUI)this.zcI.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.Oj(paramInt);
    }
    AppMethodBeat.o(29631);
  }
  
  public final void Ok(int paramInt)
  {
    AppMethodBeat.i(29637);
    MMFragment localMMFragment = On(paramInt);
    if (localMMFragment == null)
    {
      AppMethodBeat.o(29637);
      return;
    }
    if ((localMMFragment instanceof m)) {
      ((m)localMMFragment).dAL();
    }
    this.mTabsAdapter.mFragmentResumedFlags[paramInt] = true;
    AppMethodBeat.o(29637);
  }
  
  public final void Om(int paramInt)
  {
    AppMethodBeat.i(29642);
    int i = this.Sl;
    if (this.mViewPager != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.zcI.size()) });
      if ((this.mViewPager != null) && (paramInt >= 0) && ((this.mTabsAdapter == null) || (paramInt <= this.mTabsAdapter.getCount() - 1))) {
        break;
      }
      AppMethodBeat.o(29642);
      return;
    }
    if ((this.Sl == paramInt) && (this.zcI.size() != 0))
    {
      AppMethodBeat.o(29642);
      return;
    }
    i = this.Sl;
    this.Sl = paramInt;
    this.zcx.Op(this.Sl);
    if (this.mViewPager != null)
    {
      if (i == -1)
      {
        this.mViewPager.setCurrentItemNotify(this.Sl, false);
        Ok(this.Sl);
      }
    }
    else
    {
      if ((this.Sl != 0) || (!com.tencent.matrix.a.bLP.bLR)) {
        break label264;
      }
      aw.getNotification().bE(true);
    }
    for (;;)
    {
      if (this.Sl != 0)
      {
        MMFragment localMMFragment = On(0);
        if ((localMMFragment instanceof MainUI)) {
          ((MainUI)localMMFragment).dMX();
        }
      }
      AppMethodBeat.o(29642);
      return;
      this.mViewPager.setCurrentItem(this.Sl, false);
      break;
      label264:
      aw.getNotification().bE(false);
    }
  }
  
  public final MMFragment On(int paramInt)
  {
    AppMethodBeat.i(29643);
    ab.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0)
    {
      AppMethodBeat.o(29643);
      return null;
    }
    if (this.zcI.containsKey(Integer.valueOf(paramInt)))
    {
      localMMFragment = (MMFragment)this.zcI.get(Integer.valueOf(paramInt));
      AppMethodBeat.o(29643);
      return localMMFragment;
    }
    MMFragment localMMFragment = Ol(paramInt);
    this.zcI.put(Integer.valueOf(paramInt), localMMFragment);
    AppMethodBeat.o(29643);
    return localMMFragment;
  }
  
  public final void atp(String paramString)
  {
    AppMethodBeat.i(29640);
    if ((paramString == null) || (paramString.equals("")))
    {
      AppMethodBeat.o(29640);
      return;
    }
    Om(((Integer)zcH.get(paramString)).intValue());
    AppMethodBeat.o(29640);
  }
  
  public final void dBN()
  {
    AppMethodBeat.i(29638);
    MainUI localMainUI = (MainUI)this.zcI.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.yXg.findViewById(2131820633);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localMainUI != null) {
      localMainUI.onHiddenChanged(true);
    }
    j.a(this.yXg, 4, this.Sl, "prepareStartChatting");
    dCE();
    this.zcx.dCG();
    AppMethodBeat.o(29638);
  }
  
  public final void dBR()
  {
    AppMethodBeat.i(29634);
    MainUI localMainUI = (MainUI)this.zcI.get(Integer.valueOf(0));
    if (localMainUI != null)
    {
      localMainUI.dLE();
      localMainUI.dMV();
    }
    AppMethodBeat.o(29634);
  }
  
  public final MMFragment dCB()
  {
    AppMethodBeat.i(29630);
    MMFragment localMMFragment = (MMFragment)this.zcI.get(Integer.valueOf(this.Sl));
    AppMethodBeat.o(29630);
    return localMMFragment;
  }
  
  public final void dCC()
  {
    AppMethodBeat.i(29632);
    com.tencent.mm.sdk.b.a.ymk.d(this.zcE);
    com.tencent.mm.sdk.b.a.ymk.d(this.zcG);
    dCD();
    AppMethodBeat.o(29632);
  }
  
  public final void dCE()
  {
    AppMethodBeat.i(29635);
    MainUI localMainUI = (MainUI)this.zcI.get(Integer.valueOf(0));
    if (localMainUI != null) {
      localMainUI.dMW();
    }
    AppMethodBeat.o(29635);
  }
  
  public final void dCF()
  {
    AppMethodBeat.i(29639);
    if ((this.Sl == 0) && (g.RK().eHt.foreground)) {
      aw.getNotification().bE(true);
    }
    for (;;)
    {
      Object localObject = (ViewGroup)this.yXg.findViewById(2131820633);
      if (localObject != null) {
        ((ViewGroup)localObject).setImportantForAccessibility(1);
      }
      dBR();
      j.a(this.yXg, 3, this.Sl, "prepareCloseChatting");
      localObject = (MainUI)this.zcI.get(Integer.valueOf(0));
      if (localObject != null)
      {
        ((MainUI)localObject).getContentView();
        if (((MainUI)localObject).mController != null) {
          ((MainUI)localObject).mController.onResume();
        }
        ((MainUI)localObject).onHiddenChanged(false);
      }
      AppMethodBeat.o(29639);
      return;
      aw.getNotification().bE(false);
    }
  }
  
  protected final void dCG()
  {
    AppMethodBeat.i(29644);
    this.zcx.dCG();
    AppMethodBeat.o(29644);
  }
  
  protected final void dCH()
  {
    AppMethodBeat.i(29645);
    this.zcx.dCH();
    AppMethodBeat.o(29645);
  }
  
  protected final void dCI()
  {
    AppMethodBeat.i(29646);
    this.zcx.dCI();
    AppMethodBeat.o(29646);
  }
  
  public final int dCJ()
  {
    AppMethodBeat.i(29647);
    x localx = this.zcx;
    long l = System.currentTimeMillis();
    int i;
    if (!aw.RG())
    {
      ab.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
      i = 0;
    }
    for (;;)
    {
      localx.Oo(i);
      ab.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      AppMethodBeat.o(29647);
      return i;
      i = u.e(t.flc, ag.Nn());
      ab.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", new Object[] { Integer.valueOf(i) });
    }
  }
  
  public final void dCK()
  {
    AppMethodBeat.i(29648);
    this.zcI.get(Integer.valueOf(0));
    AppMethodBeat.o(29648);
  }
  
  public final void hr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(29636);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(29636);
      return;
    }
    MMFragment localMMFragment = On(paramInt1);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).dBD();
    }
    localMMFragment = On(paramInt2);
    if ((localMMFragment != null) && ((localMMFragment instanceof m))) {
      ((m)localMMFragment).dBC();
    }
    j.a(this.yXg, 4, paramInt1, "deliverOnTabChange");
    j.a(this.yXg, 3, paramInt2, "deliverOnTabChange");
    AppMethodBeat.o(29636);
  }
  
  public static abstract interface a
  {
    public abstract void Ob(int paramInt);
    
    public abstract void Oc(int paramInt);
    
    public abstract void o(int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.MainTabUI
 * JD-Core Version:    0.7.0.1
 */