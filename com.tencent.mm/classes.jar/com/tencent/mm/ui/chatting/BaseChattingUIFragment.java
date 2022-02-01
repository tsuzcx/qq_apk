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
import com.tencent.mm.al.f;
import com.tencent.mm.br.d.a;
import com.tencent.mm.g.a.nk;
import com.tencent.mm.g.c.av;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.l;
import com.tencent.mm.ui.chatting.c.h.a;
import com.tencent.mm.ui.chatting.c.i;
import com.tencent.mm.ui.chatting.c.n;
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
  protected String HKN;
  protected String HKO;
  private i HKP = new i();
  public boolean HKQ = false;
  private int HKR = 0;
  int HKS;
  int HKT;
  public com.tencent.mm.ui.chatting.d.a cLy = new com.tencent.mm.ui.chatting.d.a(this, this, this);
  private long dpQ;
  private long lastResumeTime;
  
  public BaseChattingUIFragment()
  {
    fkw();
  }
  
  public BaseChattingUIFragment(byte paramByte)
  {
    super(true);
    fkw();
  }
  
  private void aaA(int paramInt)
  {
    this.HKR |= paramInt;
  }
  
  private void aaB(int paramInt)
  {
    this.HKR &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void cMa()
  {
    d(32, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34297);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        AppMethodBeat.o(34297);
      }
    });
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1 = isStrict(paramInt);
    boolean bool2 = aaz(paramInt);
    if ((bool2) && (bool1))
    {
      aaA(paramInt);
      if (2 == paramInt) {
        aaB(64);
      }
      for (;;)
      {
        paramRunnable.run();
        return;
        if (64 == paramInt) {
          aaB(2);
        } else if (4 == paramInt) {
          aaB(32);
        } else if (32 == paramInt) {
          aaB(4);
        } else if (8 == paramInt) {
          aaB(16);
        } else if (16 == paramInt) {
          aaB(8);
        } else if (128 == paramInt) {
          aaB(256);
        } else if (256 == paramInt) {
          aaB(128);
        } else if (512 == paramInt) {
          aaB(1024);
        } else if (1024 == paramInt) {
          aaB(512);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.HKO, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  private void eNi()
  {
    d(64, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34298);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        if ((BaseChattingUIFragment.this.aaz(16)) && (!BaseChattingUIFragment.this.aaz(8)))
        {
          RuntimeException localRuntimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ), Boolean.valueOf(BaseChattingUIFragment.this.cLy.cqM), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.aaz(2)) }));
          AppMethodBeat.o(34298);
          throw localRuntimeException;
        }
        BaseChattingUIFragment.this.cLy.cqM = false;
        BaseChattingUIFragment.this.cLy.setFocused(false);
        BaseChattingUIFragment.this.cLy.HZK = false;
        BaseChattingUIFragment.this.cLy.xp(false);
        BaseChattingUIFragment.d(BaseChattingUIFragment.this);
        AppMethodBeat.o(34298);
      }
    });
  }
  
  private void fkD()
  {
    d(4, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34294);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        AppMethodBeat.o(34294);
      }
    });
  }
  
  private boolean fkG()
  {
    return (aaz(256)) && (!aaz(128));
  }
  
  private void fkw()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private boolean isStrict(int paramInt)
  {
    if ((4 == paramInt) && (aaz(2))) {}
    while (((8 == paramInt) && (aaz(4))) || ((16 == paramInt) && (aaz(8))) || ((32 == paramInt) && (aaz(4))) || ((64 == paramInt) && (aaz(2))) || ((512 == paramInt) && (aaz(256)))) {
      return false;
    }
    return true;
  }
  
  public final boolean aaz(int paramInt)
  {
    return (this.HKR & paramInt) == 0;
  }
  
  public final void addHeaderView(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  protected void aj(ai paramai)
  {
    this.HKO = String.format(this.HKN, new Object[] { paramai.field_username });
    this.cLy.an(paramai);
  }
  
  public void dRO()
  {
    d(16, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34296);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).fgk();
        BaseChattingUIFragment.b(BaseChattingUIFragment.this, BaseChattingUIFragment.b(BaseChattingUIFragment.this) + (System.currentTimeMillis() - BaseChattingUIFragment.c(BaseChattingUIFragment.this)));
        AppMethodBeat.o(34296);
      }
    });
  }
  
  public void dry() {}
  
  public final void fkA()
  {
    if ((this.cLy.cqM) || (isFinishing()))
    {
      if ((aaz(8)) && (!isFinishing()) && (!fkF()))
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        fkm();
        onEnterEnd();
      }
      dRO();
    }
  }
  
  public final void fkB()
  {
    if (((this.cLy.cqM) || (isFinishing())) && (!fkG()))
    {
      if (aaz(16))
      {
        com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.HKO });
        dRO();
      }
      cMa();
    }
  }
  
  public final void fkC()
  {
    d(512, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34290);
        BaseChattingUIFragment.this.onExitBegin();
        AppMethodBeat.o(34290);
      }
    });
    eNi();
    onExitEnd();
  }
  
  public void fkE()
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.HKO, Boolean.valueOf(this.HKQ) });
    Iterator localIterator = this.cLy.HZB.Ifh.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof com.tencent.mm.ui.chatting.c.ac)) {
        ((com.tencent.mm.ui.chatting.c.ac)localEntry.getValue()).fmj();
      }
    }
  }
  
  public final boolean fkF()
  {
    return (aaz(1024)) && (!aaz(512));
  }
  
  public abstract v fkH();
  
  public abstract boolean fkI();
  
  public com.tencent.mm.ui.chatting.m.a.a fkJ()
  {
    return null;
  }
  
  public void fkK() {}
  
  public void fkk()
  {
    d(2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34293);
        BaseChattingUIFragment.this.cLy.cqM = true;
        BaseChattingUIFragment.this.cLy.setFocused(true);
        BaseChattingUIFragment.this.cLy.HZK = false;
        BaseChattingUIFragment.this.cLy.xp(false);
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).fgg();
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        AppMethodBeat.o(34293);
      }
    });
  }
  
  public void fkm()
  {
    d(8, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34295);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).fgj();
        BaseChattingUIFragment.a(BaseChattingUIFragment.this, System.currentTimeMillis());
        AppMethodBeat.o(34295);
      }
    });
  }
  
  public final void fkx()
  {
    fkk();
    if ((this.isCurrentActivity) || (this.HKQ)) {
      onEnterBegin();
    }
  }
  
  public final void fky()
  {
    if (this.cLy.cqM) {
      fkD();
    }
  }
  
  public final void fkz()
  {
    if (this.cLy.cqM)
    {
      fkm();
      if ((this.isCurrentActivity) || (this.HKQ)) {
        onEnterEnd();
      }
    }
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
    ai localai = this.cLy.AzG;
    if ((localai == null) || ((int)localai.fLJ == 0) || (bs.isNullOrNil(localai.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.g.agM())
    {
      if (f.so(localai.field_username)) {
        return "_EnterpriseChat";
      }
      if (f.AR(localai.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (f.AQ(localai.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localai.fad()) {
      return "_bizContact";
    }
    if (w.sQ(localai.field_username)) {
      return "_chatroom";
    }
    if (w.ww(localai.field_username)) {
      return "_bottle";
    }
    if (w.wx(localai.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  protected void jX(Context paramContext)
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.HKO, Boolean.valueOf(this.HKQ) });
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    fkx();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.cLy.cqM) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.cLy.HZC.getFragment();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.h.b.d((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((d.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.cLy.HZD.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.HKN = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    jX(paramContext);
    this.cLy.a(com.tencent.mm.ui.chatting.c.b.h.class, this.HKP);
    this.cLy.a(l.class, this.cLy.HZD);
    paramContext = com.tencent.mm.ui.chatting.c.h.getComponents().iterator();
    while (paramContext.hasNext())
    {
      h.a locala = (h.a)paramContext.next();
      this.cLy.a(locala.aMt, locala.fmQ());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.cLy.cqM) {
      this.cLy.HZD.onConfigurationChanged(paramConfiguration);
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
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.HKO, Boolean.valueOf(this.cLy.cqM), Boolean.valueOf(isFinishing()) });
    fkC();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    fkE();
  }
  
  public void onEnterBegin()
  {
    d(128, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34299);
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
        int j = WXHardCoderJNI.hcEnterChattingDelay;
        int k = WXHardCoderJNI.hcEnterChattingCPU;
        int m = WXHardCoderJNI.hcEnterChattingIO;
        if (WXHardCoderJNI.hcEnterChattingThr) {}
        for (int i = com.tencent.mm.kernel.g.agU().eVl();; i = 0)
        {
          localBaseChattingUIFragment.HKS = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
          BaseChattingUIFragment.this.cLy.cqM = true;
          BaseChattingUIFragment.this.cLy.setFocused(true);
          BaseChattingUIFragment.this.cLy.HZK = false;
          BaseChattingUIFragment.this.cLy.xp(false);
          BaseChattingUIFragment.a(BaseChattingUIFragment.this).fgh();
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
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).fgi();
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, localBaseChattingUIFragment.HKS);
        localBaseChattingUIFragment.HKS = 0;
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcQuitChattingEnable;
        int j = WXHardCoderJNI.hcQuitChattingDelay;
        int k = WXHardCoderJNI.hcQuitChattingCPU;
        int m = WXHardCoderJNI.hcQuitChattingIO;
        if (WXHardCoderJNI.hcQuitChattingThr) {
          i = com.tencent.mm.kernel.g.agU().eVl();
        }
        localBaseChattingUIFragment.HKT = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).fgl();
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
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.HKO, Boolean.valueOf(BaseChattingUIFragment.this.HKQ) });
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).fgm();
        Object localObject = BaseChattingUIFragment.this;
        if (((BaseChattingUIFragment)localObject).HKT != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, ((BaseChattingUIFragment)localObject).HKT);
          ((BaseChattingUIFragment)localObject).HKT = 0;
        }
        BaseChattingUIFragment.this.cLy.cqM = false;
        BaseChattingUIFragment.this.cLy.setFocused(false);
        BaseChattingUIFragment.this.cLy.HZK = false;
        BaseChattingUIFragment.this.cLy.xp(false);
        localObject = new nk();
        ((nk)localObject).dpP.action = 1;
        ((nk)localObject).dpP.username = BaseChattingUIFragment.this.cLy.getTalkerUserName();
        ((nk)localObject).dpP.dpQ = BaseChattingUIFragment.b(BaseChattingUIFragment.this);
        com.tencent.mm.sdk.b.a.GpY.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
        AppMethodBeat.o(34292);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.cLy.HZD.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.HKO, Boolean.valueOf(this.cLy.cqM), Boolean.valueOf(isFinishing()), Boolean.valueOf(fkF()) });
    fkA();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.cLy.HZD.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.HKO, Boolean.valueOf(this.cLy.cqM), Boolean.valueOf(isFinishing()) });
    fkz();
  }
  
  public final void onStart()
  {
    super.onStart();
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.HKO, Boolean.valueOf(this.cLy.cqM), Boolean.valueOf(isFinishing()) });
    fky();
  }
  
  public final void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.HKO, Boolean.valueOf(this.cLy.cqM), Boolean.valueOf(isFinishing()), Boolean.valueOf(fkG()) });
    fkB();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.g.agS();
    if (com.tencent.mm.compatible.d.b.ca(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.agO().agp()).ca))
    {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */