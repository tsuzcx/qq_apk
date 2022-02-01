package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.ns;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.d.b.n;
import com.tencent.mm.ui.chatting.d.h.a;
import com.tencent.mm.ui.chatting.d.k;
import com.tencent.mm.ui.chatting.d.p;
import com.tencent.mm.ui.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BaseChattingUIFragment
  extends MMFragment
  implements ad, ae
{
  protected String JyE;
  protected String JyF;
  private k JyG = new k();
  public boolean JyH = false;
  private int JyI = 0;
  int JyJ;
  int JyK;
  public com.tencent.mm.ui.chatting.e.a cWM = new com.tencent.mm.ui.chatting.e.a(this, this, this);
  private long dBD;
  private long lastResumeTime;
  
  public BaseChattingUIFragment()
  {
    fAL();
  }
  
  public BaseChattingUIFragment(byte paramByte)
  {
    super(true);
    fAL();
  }
  
  private void acK(int paramInt)
  {
    this.JyI |= paramInt;
  }
  
  private void acL(int paramInt)
  {
    this.JyI &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void cUt()
  {
    d(32, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34297);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        BaseChattingUIFragment.this.cWM.JPa = true;
        AppMethodBeat.o(34297);
      }
    });
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1 = isStrict(paramInt);
    boolean bool2 = acJ(paramInt);
    if ((bool2) && (bool1))
    {
      acK(paramInt);
      if (2 == paramInt) {
        acL(64);
      }
      for (;;)
      {
        paramRunnable.run();
        return;
        if (64 == paramInt) {
          acL(2);
        } else if (4 == paramInt) {
          acL(32);
        } else if (32 == paramInt) {
          acL(4);
        } else if (8 == paramInt) {
          acL(16);
        } else if (16 == paramInt) {
          acL(8);
        } else if (128 == paramInt) {
          acL(256);
        } else if (256 == paramInt) {
          acL(128);
        } else if (512 == paramInt) {
          acL(1024);
        } else if (1024 == paramInt) {
          acL(512);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.JyF, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  private void fAL()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private void fAS()
  {
    d(4, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34294);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        AppMethodBeat.o(34294);
      }
    });
  }
  
  private boolean fAV()
  {
    return (acJ(256)) && (!acJ(128));
  }
  
  private void fch()
  {
    d(64, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34298);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        if ((BaseChattingUIFragment.this.acJ(16)) && (!BaseChattingUIFragment.this.acJ(8)))
        {
          RuntimeException localRuntimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH), Boolean.valueOf(BaseChattingUIFragment.this.cWM.cBJ), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.acJ(2)) }));
          AppMethodBeat.o(34298);
          throw localRuntimeException;
        }
        BaseChattingUIFragment.this.cWM.cBJ = false;
        BaseChattingUIFragment.this.cWM.setFocused(false);
        BaseChattingUIFragment.this.cWM.JOY = false;
        BaseChattingUIFragment.this.cWM.yb(false);
        BaseChattingUIFragment.e(BaseChattingUIFragment.this);
        AppMethodBeat.o(34298);
      }
    });
  }
  
  private boolean isStrict(int paramInt)
  {
    if ((4 == paramInt) && (acJ(2))) {}
    while (((8 == paramInt) && (acJ(4))) || ((16 == paramInt) && (acJ(8))) || ((32 == paramInt) && (acJ(4))) || ((64 == paramInt) && (acJ(2))) || ((512 == paramInt) && (acJ(256)))) {
      return false;
    }
    return true;
  }
  
  public final boolean acJ(int paramInt)
  {
    return (this.JyI & paramInt) == 0;
  }
  
  public final void addHeaderView(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  protected void aj(am paramam)
  {
    this.JyF = String.format(this.JyE, new Object[] { paramam.field_username });
    this.cWM.an(paramam);
  }
  
  public final int bFG()
  {
    return getListView().getFooterViewsCount();
  }
  
  public void dCa() {}
  
  public void eei()
  {
    d(16, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34296);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fww();
        BaseChattingUIFragment.b(BaseChattingUIFragment.this, BaseChattingUIFragment.c(BaseChattingUIFragment.this) + (System.currentTimeMillis() - BaseChattingUIFragment.d(BaseChattingUIFragment.this)));
        BaseChattingUIFragment.this.cWM.JPa = true;
        AppMethodBeat.o(34296);
      }
    });
  }
  
  public void fAB()
  {
    d(8, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34295);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fwv();
        BaseChattingUIFragment.a(BaseChattingUIFragment.this, System.currentTimeMillis());
        AppMethodBeat.o(34295);
      }
    });
  }
  
  public final void fAM()
  {
    fAz();
    if ((this.isCurrentActivity) || (this.JyH)) {
      onEnterBegin();
    }
  }
  
  public final void fAN()
  {
    if (this.cWM.cBJ) {
      fAS();
    }
  }
  
  public final void fAO()
  {
    if (this.cWM.cBJ)
    {
      fAB();
      if ((this.isCurrentActivity) || (this.JyH)) {
        onEnterEnd();
      }
    }
  }
  
  public final void fAP()
  {
    if ((this.cWM.cBJ) || (isFinishing()))
    {
      if ((acJ(8)) && (!isFinishing()) && (!fAU()))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        fAB();
        onEnterEnd();
      }
      eei();
    }
  }
  
  public final void fAQ()
  {
    if (((this.cWM.cBJ) || (isFinishing())) && (!fAV()))
    {
      if (acJ(16))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.JyF });
        eei();
      }
      cUt();
    }
  }
  
  public final void fAR()
  {
    d(512, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34290);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BaseChattingUIFragment", "fallback for SwipeBack");
        BaseChattingUIFragment.a(BaseChattingUIFragment.this);
        BaseChattingUIFragment.this.onExitBegin();
        AppMethodBeat.o(34290);
      }
    });
    fch();
    onExitEnd();
  }
  
  public void fAT()
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.JyF, Boolean.valueOf(this.JyH) });
    Iterator localIterator = this.cWM.JON.JVu.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof com.tencent.mm.ui.chatting.d.ae)) {
        ((com.tencent.mm.ui.chatting.d.ae)localEntry.getValue()).fCC();
      }
    }
  }
  
  public final boolean fAU()
  {
    return (acJ(1024)) && (!acJ(512));
  }
  
  public abstract v fAW();
  
  public abstract boolean fAX();
  
  public com.tencent.mm.ui.chatting.n.a.a fAY()
  {
    return null;
  }
  
  public void fAZ() {}
  
  public void fAz()
  {
    d(2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34293);
        BaseChattingUIFragment.this.cWM.cBJ = true;
        BaseChattingUIFragment.this.cWM.setFocused(true);
        BaseChattingUIFragment.this.cWM.JOY = false;
        BaseChattingUIFragment.this.cWM.yb(false);
        BaseChattingUIFragment.this.cWM.JPa = false;
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fws();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        AppMethodBeat.o(34293);
      }
    });
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
    am localam = this.cWM.BYG;
    if ((localam == null) || ((int)localam.gfj == 0) || (bt.isNullOrNil(localam.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.g.ajx())
    {
      if (com.tencent.mm.am.g.vd(localam.field_username)) {
        return "_EnterpriseChat";
      }
      if (com.tencent.mm.am.g.DQ(localam.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (com.tencent.mm.am.g.DP(localam.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localam.fqg()) {
      return "_bizContact";
    }
    if (w.vF(localam.field_username)) {
      return "_chatroom";
    }
    if (w.zs(localam.field_username)) {
      return "_bottle";
    }
    if (w.zt(localam.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  protected void ki(Context paramContext)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.JyF, Boolean.valueOf(this.JyH) });
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    fAM();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.cWM.cBJ) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.cWM.JOO.getFragment();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.i.b.d((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((d.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.cWM.JOP.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.JyE = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    ki(paramContext);
    this.cWM.a(j.class, this.JyG);
    this.cWM.a(n.class, this.cWM.JOP);
    paramContext = com.tencent.mm.ui.chatting.d.h.getComponents().iterator();
    while (paramContext.hasNext())
    {
      h.a locala = (h.a)paramContext.next();
      this.cWM.a(locala.aWK, locala.fDk());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.cWM.cBJ) {
      this.cWM.JOP.onConfigurationChanged(paramConfiguration);
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
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.JyF, Boolean.valueOf(this.cWM.cBJ), Boolean.valueOf(isFinishing()) });
    fAR();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    fAT();
  }
  
  public void onEnterBegin()
  {
    d(128, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34299);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
        int j = WXHardCoderJNI.hcEnterChattingDelay;
        int k = WXHardCoderJNI.hcEnterChattingCPU;
        int m = WXHardCoderJNI.hcEnterChattingIO;
        if (WXHardCoderJNI.hcEnterChattingThr) {}
        for (int i = com.tencent.mm.kernel.g.ajF().fkS();; i = 0)
        {
          localBaseChattingUIFragment.JyJ = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
          BaseChattingUIFragment.this.cWM.cBJ = true;
          BaseChattingUIFragment.this.cWM.setFocused(true);
          BaseChattingUIFragment.this.cWM.JOY = false;
          BaseChattingUIFragment.this.cWM.yb(false);
          BaseChattingUIFragment.b(BaseChattingUIFragment.this).fwt();
          BaseChattingUIFragment.b(BaseChattingUIFragment.this, 0L);
          AppMethodBeat.o(34299);
          return;
        }
      }
    });
  }
  
  public final void onEnterEnd()
  {
    d(256, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34300);
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fwu();
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, localBaseChattingUIFragment.JyJ);
        localBaseChattingUIFragment.JyJ = 0;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        AppMethodBeat.o(34300);
      }
    });
  }
  
  public void onExitBegin()
  {
    d(512, new Runnable()
    {
      public final void run()
      {
        int i = 0;
        AppMethodBeat.i(34291);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcQuitChattingEnable;
        int j = WXHardCoderJNI.hcQuitChattingDelay;
        int k = WXHardCoderJNI.hcQuitChattingCPU;
        int m = WXHardCoderJNI.hcQuitChattingIO;
        if (WXHardCoderJNI.hcQuitChattingThr) {
          i = com.tencent.mm.kernel.g.ajF().fkS();
        }
        localBaseChattingUIFragment.JyK = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fwx();
        AppMethodBeat.o(34291);
      }
    });
  }
  
  public void onExitEnd()
  {
    d(1024, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34292);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JyF, Boolean.valueOf(BaseChattingUIFragment.this.JyH) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fwy();
        Object localObject = BaseChattingUIFragment.this;
        if (((BaseChattingUIFragment)localObject).JyK != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, ((BaseChattingUIFragment)localObject).JyK);
          ((BaseChattingUIFragment)localObject).JyK = 0;
        }
        BaseChattingUIFragment.this.cWM.cBJ = false;
        BaseChattingUIFragment.this.cWM.setFocused(false);
        BaseChattingUIFragment.this.cWM.JOY = false;
        BaseChattingUIFragment.this.cWM.yb(false);
        localObject = new ns();
        ((ns)localObject).dBC.action = 1;
        ((ns)localObject).dBC.username = BaseChattingUIFragment.this.cWM.getTalkerUserName();
        ((ns)localObject).dBC.dBD = BaseChattingUIFragment.c(BaseChattingUIFragment.this);
        com.tencent.mm.sdk.b.a.IbL.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
        AppMethodBeat.o(34292);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.cWM.JOP.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.JyF, Boolean.valueOf(this.cWM.cBJ), Boolean.valueOf(isFinishing()), Boolean.valueOf(fAU()) });
    fAP();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.cWM.JOP.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.JyF, Boolean.valueOf(this.cWM.cBJ), Boolean.valueOf(isFinishing()) });
    fAO();
  }
  
  public final void onStart()
  {
    super.onStart();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.JyF, Boolean.valueOf(this.cWM.cBJ), Boolean.valueOf(isFinishing()) });
    fAN();
  }
  
  public final void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.JyF, Boolean.valueOf(this.cWM.cBJ), Boolean.valueOf(isFinishing()), Boolean.valueOf(fAV()) });
    fAQ();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.g.ajD();
    if (com.tencent.mm.compatible.d.b.bY(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajz().ajb()).ca))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */