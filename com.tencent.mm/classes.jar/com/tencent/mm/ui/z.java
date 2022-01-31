package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import com.tencent.mm.R.h;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.contact.AddressUI.a;
import java.util.HashMap;
import java.util.HashSet;

public final class z
{
  private static HashMap<String, Integer> uOQ;
  private final long TIME_INTERVAL = 180000L;
  public int jVi = -1;
  MMFragmentActivity uJA;
  public aa uOE = new aa();
  LauncherUI.d uOF;
  boolean uOG;
  private HashSet<o> uOH = new HashSet();
  CustomViewPager uOI;
  z.a uOJ;
  private int uOK = -1;
  private int uOL = -1;
  private int uOM = -1;
  com.tencent.mm.sdk.b.c uON = new z.1(this);
  private boolean uOO = true;
  com.tencent.mm.sdk.b.c uOP = new z.2(this);
  public HashMap<Integer, x> uOR = new HashMap();
  
  static
  {
    HashMap localHashMap = new HashMap();
    uOQ = localHashMap;
    localHashMap.put("tab_main", Integer.valueOf(0));
    uOQ.put("tab_address", Integer.valueOf(1));
    uOQ.put("tab_find_friend", Integer.valueOf(2));
    uOQ.put("tab_settings", Integer.valueOf(3));
  }
  
  public final void FX(int paramInt)
  {
    x localx = FZ(paramInt);
    if (localx == null) {
      return;
    }
    if ((localx instanceof o)) {
      ((o)localx).cxP();
    }
    this.uOJ.uOW[paramInt] = true;
  }
  
  public final void FY(int paramInt)
  {
    int i = this.jVi;
    boolean bool;
    if (this.uOI != null)
    {
      bool = true;
      y.i("MicroMsg.LauncherUI.MainTabUI", "change tab to %d, cur tab %d, has init tab %B, tab cache size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(this.uOR.size()) });
      if ((this.uOI != null) && (paramInt >= 0) && ((this.uOJ == null) || (paramInt <= this.uOJ.getCount() - 1))) {
        break label96;
      }
    }
    label96:
    while ((this.jVi == paramInt) && (this.uOR.size() != 0))
    {
      return;
      bool = false;
      break;
    }
    this.jVi = paramInt;
    this.uOE.Gb(this.jVi);
    if (this.uOI != null)
    {
      this.uOI.m(this.jVi, false);
      FX(this.jVi);
    }
    if ((this.jVi == 0) && (g.DO().dJT.foreground))
    {
      au.getNotification().bc(true);
      return;
    }
    au.getNotification().bc(false);
  }
  
  public final x FZ(int paramInt)
  {
    Object localObject = null;
    y.d("MicroMsg.LauncherUI.MainTabUI", "get tab %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt < 0) {
      return null;
    }
    if (this.uOR.containsKey(Integer.valueOf(paramInt))) {
      return (x)this.uOR.get(Integer.valueOf(paramInt));
    }
    Bundle localBundle = new Bundle();
    switch (paramInt)
    {
    }
    for (;;)
    {
      y.v("MicroMsg.LauncherUI.MainTabUI", "createFragment index:%d", new Object[] { Integer.valueOf(paramInt) });
      if (localObject != null) {
        ((x)localObject).setParent(this.uJA);
      }
      this.uOR.put(Integer.valueOf(paramInt), localObject);
      return localObject;
      localBundle.putInt(com.tencent.mm.ui.conversation.k.class.getName(), 0);
      localObject = (x)Fragment.instantiate(this.uJA, com.tencent.mm.ui.conversation.k.class.getName(), localBundle);
      if ((localObject instanceof com.tencent.mm.ui.conversation.k)) {
        ((com.tencent.mm.ui.conversation.k)localObject).mContext = this.uJA;
      }
      au.getNotification().bc(true);
      continue;
      localBundle.putInt(AddressUI.a.class.getName(), 1);
      localBundle.putBoolean("Need_Voice_Search", true);
      localBundle.putBoolean("favour_include_biz", true);
      localObject = (x)Fragment.instantiate(this.uJA, AddressUI.a.class.getName(), localBundle);
      continue;
      localBundle.putInt(h.class.getName(), 2);
      localObject = (x)Fragment.instantiate(this.uJA, h.class.getName(), localBundle);
      continue;
      localBundle.putInt(ac.class.getName(), 3);
      localObject = (x)Fragment.instantiate(this.uJA, ac.class.getName(), localBundle);
    }
  }
  
  public final void acW(String paramString)
  {
    if ((paramString == null) || (paramString.equals(""))) {
      return;
    }
    FY(((Integer)uOQ.get(paramString)).intValue());
  }
  
  public final void cyJ()
  {
    com.tencent.mm.ui.conversation.k localk = (com.tencent.mm.ui.conversation.k)this.uOR.get(Integer.valueOf(0));
    if (localk != null)
    {
      localk.cHo();
      localk.cIq();
    }
  }
  
  public final x czH()
  {
    return (x)this.uOR.get(Integer.valueOf(this.jVi));
  }
  
  public final void czI()
  {
    a.udP.d(this.uON);
    a.udP.d(this.uOP);
    this.uOR.clear();
    if (this.uOI != null)
    {
      this.uOI.setCanSlide(false);
      this.uOI.setCanSlideBySide(false);
    }
  }
  
  public final void czJ()
  {
    com.tencent.mm.ui.conversation.k localk = (com.tencent.mm.ui.conversation.k)this.uOR.get(Integer.valueOf(0));
    if (localk != null) {
      localk.cIr();
    }
  }
  
  public final void czK()
  {
    com.tencent.mm.ui.conversation.k localk = (com.tencent.mm.ui.conversation.k)this.uOR.get(Integer.valueOf(0));
    ViewGroup localViewGroup = (ViewGroup)this.uJA.findViewById(R.h.launcher_container);
    if (localViewGroup != null) {
      localViewGroup.setImportantForAccessibility(4);
    }
    if (localk != null) {
      localk.onHiddenChanged(true);
    }
    k.a(this.uJA, 4, this.jVi, "prepareStartChatting");
    czJ();
    this.uOE.czM();
  }
  
  public final int czL()
  {
    aa localaa = this.uOE;
    int j = 0;
    int i = j;
    if (localaa.uOZ != null)
    {
      i = j;
      if (localaa.uOZ.getMainTabUnread() > 0) {
        i = localaa.uOZ.getMainTabUnread();
      }
    }
    return i;
  }
  
  protected final void czM()
  {
    this.uOE.czM();
  }
  
  protected final void czN()
  {
    this.uOE.czN();
  }
  
  protected final void czO()
  {
    this.uOE.czO();
  }
  
  public final int czP()
  {
    aa localaa = this.uOE;
    long l = System.currentTimeMillis();
    int i;
    if (!au.DK())
    {
      y.w("MicroMsg.UnreadCountHelper", "getMainTabUnreadCount, but mmcore not ready");
      i = 0;
    }
    for (;;)
    {
      localaa.Ga(i);
      y.d("MicroMsg.LauncherUI.MainTabUnreadMgr", "unreadcheck setConversationTagUnread  last time %d, unread %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
      return i;
      i = t.e(s.dUT, al.cAh());
      y.d("MicroMsg.LauncherUI", "getMainTabUnreadCount  unread : %d", new Object[] { Integer.valueOf(i) });
    }
  }
  
  public final void fk(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    x localx = FZ(paramInt1);
    if ((localx != null) && ((localx instanceof o))) {
      ((o)localx).cyz();
    }
    localx = FZ(paramInt2);
    if ((localx != null) && ((localx instanceof o))) {
      ((o)localx).cyy();
    }
    k.a(this.uJA, 4, paramInt1, "deliverOnTabChange");
    k.a(this.uJA, 3, paramInt2, "deliverOnTabChange");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.z
 * JD-Core Version:    0.7.0.1
 */