package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.mm.br.d.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.chatting.b.b.j;
import com.tencent.mm.ui.chatting.b.g.a;
import com.tencent.mm.ui.chatting.b.l;
import com.tencent.mm.ui.chatting.b.w;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class e
  extends x
  implements ag, ah
{
  public com.tencent.mm.ui.chatting.c.a byx = new com.tencent.mm.ui.chatting.c.a(this, this, this);
  protected String vhQ;
  protected String vhR;
  private com.tencent.mm.ui.chatting.b.h vhS = new com.tencent.mm.ui.chatting.b.h();
  l vhT = new l();
  public boolean vhU = false;
  private int vhV = 0;
  int vhW;
  int vhX;
  
  public e()
  {
    cCd();
  }
  
  public e(byte paramByte)
  {
    super(true);
    cCd();
  }
  
  private void GK(int paramInt)
  {
    this.vhV &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void cCd()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private boolean cCm()
  {
    return (GJ(256)) && (!GJ(128));
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1;
    boolean bool2;
    if ((4 == paramInt) && (GJ(2)))
    {
      bool1 = false;
      bool2 = GJ(paramInt);
      if ((!bool2) || (!bool1)) {
        break label303;
      }
      this.vhV |= paramInt;
      if (2 != paramInt) {
        break label163;
      }
      GK(64);
    }
    for (;;)
    {
      paramRunnable.run();
      return;
      if ((8 == paramInt) && (GJ(4)))
      {
        bool1 = false;
        break;
      }
      if ((16 == paramInt) && (GJ(8)))
      {
        bool1 = false;
        break;
      }
      if ((32 == paramInt) && (GJ(4)))
      {
        bool1 = false;
        break;
      }
      if ((64 == paramInt) && (GJ(2)))
      {
        bool1 = false;
        break;
      }
      if ((512 == paramInt) && (GJ(256)))
      {
        bool1 = false;
        break;
      }
      bool1 = true;
      break;
      label163:
      if (64 == paramInt) {
        GK(2);
      } else if (4 == paramInt) {
        GK(32);
      } else if (32 == paramInt) {
        GK(4);
      } else if (8 == paramInt) {
        GK(16);
      } else if (16 == paramInt) {
        GK(8);
      } else if (128 == paramInt) {
        GK(256);
      } else if (256 == paramInt) {
        GK(128);
      } else if (512 == paramInt) {
        GK(1024);
      } else if (1024 == paramInt) {
        GK(512);
      }
    }
    label303:
    y.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.vhR, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  public final boolean GJ(int paramInt)
  {
    return (this.vhV & paramInt) == 0;
  }
  
  protected void Y(ad paramad)
  {
    this.vhR = String.format(this.vhQ, new Object[] { paramad.field_username });
    this.byx.ab(paramad);
  }
  
  public final void addHeaderView(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  public void btn() {}
  
  public void cBR()
  {
    d(2, new e.1(this));
  }
  
  public void cBS()
  {
    d(8, new e.4(this));
  }
  
  public void cBU()
  {
    d(16, new e.5(this));
  }
  
  public void cBV()
  {
    d(64, new e.7(this));
  }
  
  public final void cCe()
  {
    cBR();
    if ((this.isCurrentActivity) || (this.vhU)) {
      cyT();
    }
  }
  
  public final void cCf()
  {
    if (this.byx.euf) {
      d(4, new e.3(this));
    }
  }
  
  public final void cCg()
  {
    if (this.byx.euf)
    {
      cBS();
      if ((this.isCurrentActivity) || (this.vhU)) {
        cyU();
      }
    }
  }
  
  public final void cCh()
  {
    if ((this.byx.euf) || (isFinishing()))
    {
      if ((GJ(8)) && (!isFinishing()) && (!cCl()))
      {
        y.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        cBS();
        cyU();
      }
      cBU();
    }
  }
  
  public final void cCi()
  {
    if (((this.byx.euf) || (isFinishing())) && (!cCm()))
    {
      if (GJ(16))
      {
        y.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.vhR });
        cBU();
      }
      d(32, new e.6(this));
    }
  }
  
  public final void cCj()
  {
    cyV();
    cBV();
    cyW();
  }
  
  public void cCk()
  {
    y.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.vhR, Boolean.valueOf(this.vhU) });
    Iterator localIterator = this.byx.vtw.vyt.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof w)) {
        ((w)localEntry.getValue()).cDC();
      }
    }
  }
  
  protected final boolean cCl()
  {
    return (GJ(1024)) && (!GJ(512));
  }
  
  public abstract t cCn();
  
  public abstract boolean cCo();
  
  public com.tencent.mm.ui.chatting.k.a.a cCp()
  {
    return null;
  }
  
  public void cCq() {}
  
  public void cyT()
  {
    d(128, new e.8(this));
  }
  
  public final void cyU()
  {
    d(256, new e.9(this));
  }
  
  public void cyV()
  {
    d(512, new e.10(this));
  }
  
  public void cyW()
  {
    d(1024, new e.2(this));
  }
  
  protected void gP(Context paramContext)
  {
    y.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.vhR, Boolean.valueOf(this.vhU) });
  }
  
  public final View getChildAt(int paramInt)
  {
    return getListView().getChildAt(paramInt);
  }
  
  public int getFirstVisiblePosition()
  {
    return getListView().getFirstVisiblePosition();
  }
  
  public final int getHeaderViewsCount()
  {
    return getListView().getHeaderViewsCount();
  }
  
  public String getIdentityString()
  {
    ad localad = this.byx.pSb;
    if ((localad == null) || ((int)localad.dBe == 0) || (bk.bl(localad.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.g.DK())
    {
      if (com.tencent.mm.ai.f.eW(localad.field_username)) {
        return "_EnterpriseChat";
      }
      if (com.tencent.mm.ai.f.lc(localad.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (com.tencent.mm.ai.f.lb(localad.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localad.cua()) {
      return "_bizContact";
    }
    if (s.fn(localad.field_username)) {
      return "_chatroom";
    }
    if (s.hd(localad.field_username)) {
      return "_bottle";
    }
    if (s.he(localad.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    cCe();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      y.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.byx.euf) {
        break;
      }
      y.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.byx.vtx.cGN();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.f.b.b((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((d.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.vhT.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.vhQ = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    gP(paramContext);
    this.byx.a(com.tencent.mm.ui.chatting.b.b.f.class, this.vhS);
    this.byx.a(j.class, this.vhT);
    paramContext = com.tencent.mm.ui.chatting.b.g.cEd().iterator();
    while (paramContext.hasNext())
    {
      g.a locala = (g.a)paramContext.next();
      this.byx.a(locala.aov, locala.cEe());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.byx.euf) {
      this.vhT.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = paramBundle.getLayoutParams();
    paramLayoutInflater = paramViewGroup;
    if (paramViewGroup == null) {
      paramLayoutInflater = new ViewGroup.LayoutParams(-1, -1);
    }
    paramBundle.setLayoutParams(paramLayoutInflater);
    return paramBundle;
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    y.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.vhR, Boolean.valueOf(this.byx.euf), Boolean.valueOf(isFinishing()) });
    cCj();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    cCk();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.vhT.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    y.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.vhR, Boolean.valueOf(this.byx.euf), Boolean.valueOf(isFinishing()), Boolean.valueOf(cCl()) });
    cCh();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.vhT.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    y.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.vhR, Boolean.valueOf(this.byx.euf), Boolean.valueOf(isFinishing()) });
    cCg();
  }
  
  public final void onStart()
  {
    super.onStart();
    y.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.vhR, Boolean.valueOf(this.byx.euf), Boolean.valueOf(isFinishing()) });
    cCf();
  }
  
  public final void onStop()
  {
    super.onStop();
    y.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.vhR, Boolean.valueOf(this.byx.euf), Boolean.valueOf(isFinishing()), Boolean.valueOf(cCm()) });
    cCi();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.g.DQ();
    if (com.tencent.mm.compatible.f.b.be(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.DM().Dr()).bT))
    {
      y.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.e
 * JD-Core Version:    0.7.0.1
 */