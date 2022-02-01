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
import com.tencent.mm.br.c.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.ol;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.ag;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.d.b.n;
import com.tencent.mm.ui.chatting.d.h.a;
import com.tencent.mm.ui.chatting.d.k;
import com.tencent.mm.ui.chatting.d.p;
import com.tencent.mm.ui.w;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BaseChattingUIFragment
  extends MMFragment
  implements ae, af
{
  protected String PeA;
  private k PeB = new k();
  public boolean PeC = false;
  private int PeD = 0;
  int PeE;
  int PeF;
  protected String Pez;
  private long dUy;
  public com.tencent.mm.ui.chatting.e.a dom = new com.tencent.mm.ui.chatting.e.a(this, this, this);
  private long lastResumeTime;
  
  public BaseChattingUIFragment()
  {
    gMV();
  }
  
  public BaseChattingUIFragment(boolean paramBoolean)
  {
    super(true);
    gMV();
  }
  
  private void amc(int paramInt)
  {
    this.PeD |= paramInt;
  }
  
  private void amd(int paramInt)
  {
    this.PeD &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1 = isStrict(paramInt);
    boolean bool2 = amb(paramInt);
    if ((bool2) && (bool1))
    {
      amc(paramInt);
      if (2 == paramInt) {
        amd(64);
      }
      for (;;)
      {
        paramRunnable.run();
        return;
        if (64 == paramInt) {
          amd(2);
        } else if (4 == paramInt) {
          amd(32);
        } else if (32 == paramInt) {
          amd(4);
        } else if (8 == paramInt) {
          amd(16);
        } else if (16 == paramInt) {
          amd(8);
        } else if (128 == paramInt) {
          amd(256);
        } else if (256 == paramInt) {
          amd(128);
        } else if (512 == paramInt) {
          amd(1024);
        } else if (1024 == paramInt) {
          amd(512);
        }
      }
    }
    Log.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.PeA, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  private void dQn()
  {
    d(32, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34297);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        BaseChattingUIFragment.this.dom.Pwl = true;
        AppMethodBeat.o(34297);
      }
    });
  }
  
  private void gMV()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private void gNc()
  {
    d(4, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34294);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        AppMethodBeat.o(34294);
      }
    });
  }
  
  private boolean gNf()
  {
    return (amb(256)) && (!amb(128));
  }
  
  private void gpe()
  {
    d(64, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34298);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        if ((BaseChattingUIFragment.this.amb(16)) && (!BaseChattingUIFragment.this.amb(8)))
        {
          RuntimeException localRuntimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC), Boolean.valueOf(BaseChattingUIFragment.this.dom.cQp), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.amb(2)) }));
          AppMethodBeat.o(34298);
          throw localRuntimeException;
        }
        BaseChattingUIFragment.this.dom.cQp = false;
        BaseChattingUIFragment.this.dom.setFocused(false);
        BaseChattingUIFragment.this.dom.Pwj = false;
        BaseChattingUIFragment.this.dom.BX(false);
        BaseChattingUIFragment.e(BaseChattingUIFragment.this);
        AppMethodBeat.o(34298);
      }
    });
  }
  
  private boolean isStrict(int paramInt)
  {
    if ((4 == paramInt) && (amb(2))) {}
    while (((8 == paramInt) && (amb(4))) || ((16 == paramInt) && (amb(8))) || ((32 == paramInt) && (amb(4))) || ((64 == paramInt) && (amb(2))) || ((512 == paramInt) && (amb(256)))) {
      return false;
    }
    return true;
  }
  
  public final void addHeaderView(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  public final boolean amb(int paramInt)
  {
    return (this.PeD & paramInt) == 0;
  }
  
  protected void as(as paramas)
  {
    this.PeA = String.format(this.Pez, new Object[] { paramas.field_username });
    this.dom.aw(paramas);
  }
  
  public final int cda()
  {
    return getListView().getFooterViewsCount();
  }
  
  public void doPause()
  {
    d(16, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34296);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).cFy();
        BaseChattingUIFragment.b(BaseChattingUIFragment.this, BaseChattingUIFragment.c(BaseChattingUIFragment.this) + (System.currentTimeMillis() - BaseChattingUIFragment.d(BaseChattingUIFragment.this)));
        BaseChattingUIFragment.this.dom.Pwl = true;
        AppMethodBeat.o(34296);
      }
    });
  }
  
  public void doResume()
  {
    d(8, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34295);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).cFx();
        BaseChattingUIFragment.a(BaseChattingUIFragment.this, System.currentTimeMillis());
        AppMethodBeat.o(34295);
      }
    });
  }
  
  public void eGg() {}
  
  public void gMJ()
  {
    d(2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34293);
        BaseChattingUIFragment.this.dom.cQp = true;
        BaseChattingUIFragment.this.dom.setFocused(true);
        BaseChattingUIFragment.this.dom.Pwj = false;
        BaseChattingUIFragment.this.dom.BX(false);
        BaseChattingUIFragment.this.dom.Pwl = false;
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).gIk();
        Log.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        AppMethodBeat.o(34293);
      }
    });
  }
  
  public final void gMW()
  {
    gMJ();
    if ((this.isCurrentActivity) || (this.PeC)) {
      onEnterBegin();
    }
  }
  
  public final void gMX()
  {
    if (this.dom.cQp) {
      gNc();
    }
  }
  
  public final void gMY()
  {
    if (this.dom.cQp)
    {
      doResume();
      if ((this.isCurrentActivity) || (this.PeC)) {
        onEnterEnd();
      }
    }
  }
  
  public final void gMZ()
  {
    if ((this.dom.cQp) || (isFinishing()))
    {
      if ((amb(8)) && (!isFinishing()) && (!gNe()))
      {
        Log.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        doResume();
        onEnterEnd();
      }
      doPause();
    }
  }
  
  public final void gNa()
  {
    if (((this.dom.cQp) || (isFinishing())) && (!gNf()))
    {
      if (amb(16))
      {
        Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.PeA });
        doPause();
      }
      dQn();
    }
  }
  
  public final void gNb()
  {
    d(512, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34290);
        Log.d("MicroMsg.BaseChattingUIFragment", "fallback for SwipeBack");
        BaseChattingUIFragment.a(BaseChattingUIFragment.this);
        BaseChattingUIFragment.this.onExitBegin();
        AppMethodBeat.o(34290);
      }
    });
    gpe();
    onExitEnd();
  }
  
  public void gNd()
  {
    Log.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.PeA, Boolean.valueOf(this.PeC) });
    Iterator localIterator = this.dom.PvZ.PDU.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof ag)) {
        ((ag)localEntry.getValue()).gOK();
      }
    }
  }
  
  public final boolean gNe()
  {
    return (amb(1024)) && (!amb(512));
  }
  
  public abstract w gNg();
  
  public abstract boolean gNh();
  
  public com.tencent.mm.ui.chatting.n.a.a gNi()
  {
    return null;
  }
  
  public void gNj() {}
  
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
    as localas = this.dom.GUe;
    if ((localas == null) || ((int)localas.gMZ == 0) || (Util.isNullOrNil(localas.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.g.aAc())
    {
      if (com.tencent.mm.al.g.DQ(localas.field_username)) {
        return "_EnterpriseChat";
      }
      if (com.tencent.mm.al.g.Ng(localas.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (com.tencent.mm.al.g.Nf(localas.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localas.gBM()) {
      return "_bizContact";
    }
    if (ab.Eq(localas.field_username)) {
      return "_chatroom";
    }
    if (ab.IG(localas.field_username)) {
      return "_bottle";
    }
    if (ab.IH(localas.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  protected void kh(Context paramContext)
  {
    Log.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.PeA, Boolean.valueOf(this.PeC) });
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    gMW();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.dom.cQp) {
        break;
      }
      Log.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.dom.Pwa.getFragment();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.i.b.d((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((c.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.dom.Pwb.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.Pez = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    kh(paramContext);
    this.dom.a(j.class, this.PeB);
    this.dom.a(n.class, this.dom.Pwb);
    paramContext = com.tencent.mm.ui.chatting.d.h.getComponents().iterator();
    while (paramContext.hasNext())
    {
      h.a locala = (h.a)paramContext.next();
      this.dom.a(locala.aWC, locala.gPt());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.dom.cQp) {
      this.dom.Pwb.onConfigurationChanged(paramConfiguration);
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
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()) });
    gNb();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    gNd();
  }
  
  public void onEnterBegin()
  {
    d(128, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34299);
        Log.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
        int j = WXHardCoderJNI.hcEnterChattingDelay;
        int k = WXHardCoderJNI.hcEnterChattingCPU;
        int m = WXHardCoderJNI.hcEnterChattingIO;
        if (WXHardCoderJNI.hcEnterChattingThr) {}
        for (int i = com.tencent.mm.kernel.g.aAk().getProcessTid();; i = 0)
        {
          localBaseChattingUIFragment.PeE = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
          BaseChattingUIFragment.this.dom.cQp = true;
          BaseChattingUIFragment.this.dom.setFocused(true);
          BaseChattingUIFragment.this.dom.Pwj = false;
          BaseChattingUIFragment.this.dom.BX(false);
          BaseChattingUIFragment.b(BaseChattingUIFragment.this).gIl();
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
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).gIm();
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, localBaseChattingUIFragment.PeE);
        localBaseChattingUIFragment.PeE = 0;
        Log.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcQuitChattingEnable;
        int j = WXHardCoderJNI.hcQuitChattingDelay;
        int k = WXHardCoderJNI.hcQuitChattingCPU;
        int m = WXHardCoderJNI.hcQuitChattingIO;
        if (WXHardCoderJNI.hcQuitChattingThr) {
          i = com.tencent.mm.kernel.g.aAk().getProcessTid();
        }
        localBaseChattingUIFragment.PeF = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).gIn();
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.PeA, Boolean.valueOf(BaseChattingUIFragment.this.PeC) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).gIo();
        Object localObject = BaseChattingUIFragment.this;
        if (((BaseChattingUIFragment)localObject).PeF != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, ((BaseChattingUIFragment)localObject).PeF);
          ((BaseChattingUIFragment)localObject).PeF = 0;
        }
        BaseChattingUIFragment.this.dom.cQp = false;
        BaseChattingUIFragment.this.dom.setFocused(false);
        BaseChattingUIFragment.this.dom.Pwj = false;
        BaseChattingUIFragment.this.dom.BX(false);
        localObject = new ol();
        ((ol)localObject).dUx.action = 1;
        ((ol)localObject).dUx.username = BaseChattingUIFragment.this.dom.getTalkerUserName();
        ((ol)localObject).dUx.dUy = BaseChattingUIFragment.c(BaseChattingUIFragment.this);
        EventCenter.instance.asyncPublish((IEvent)localObject, Looper.getMainLooper());
        AppMethodBeat.o(34292);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.dom.Pwb.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()), Boolean.valueOf(gNe()) });
    gMZ();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.dom.Pwb.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()) });
    gMY();
  }
  
  public final void onStart()
  {
    super.onStart();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()) });
    gMX();
  }
  
  public final void onStop()
  {
    super.onStop();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.PeA, Boolean.valueOf(this.dom.cQp), Boolean.valueOf(isFinishing()), Boolean.valueOf(gNf()) });
    gNa();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.g.aAi();
    if (com.tencent.mm.compatible.e.b.cv(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.aAe().azG()).ca))
    {
      Log.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */