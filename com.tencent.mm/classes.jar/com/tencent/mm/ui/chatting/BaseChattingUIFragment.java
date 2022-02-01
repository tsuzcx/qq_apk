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
import com.tencent.mm.br.d.a;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
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
  implements ae, af
{
  int JTA;
  protected String JTu;
  protected String JTv;
  private k JTw = new k();
  public boolean JTx = false;
  private int JTy = 0;
  int JTz;
  public com.tencent.mm.ui.chatting.e.a cXJ = new com.tencent.mm.ui.chatting.e.a(this, this, this);
  private long dCI;
  private long lastResumeTime;
  
  public BaseChattingUIFragment()
  {
    fEN();
  }
  
  public BaseChattingUIFragment(byte paramByte)
  {
    super(true);
    fEN();
  }
  
  private void ads(int paramInt)
  {
    this.JTy |= paramInt;
  }
  
  private void adt(int paramInt)
  {
    this.JTy &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void cWY()
  {
    d(32, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34297);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        BaseChattingUIFragment.this.cXJ.Kkm = true;
        AppMethodBeat.o(34297);
      }
    });
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1 = isStrict(paramInt);
    boolean bool2 = adr(paramInt);
    if ((bool2) && (bool1))
    {
      ads(paramInt);
      if (2 == paramInt) {
        adt(64);
      }
      for (;;)
      {
        paramRunnable.run();
        return;
        if (64 == paramInt) {
          adt(2);
        } else if (4 == paramInt) {
          adt(32);
        } else if (32 == paramInt) {
          adt(4);
        } else if (8 == paramInt) {
          adt(16);
        } else if (16 == paramInt) {
          adt(8);
        } else if (128 == paramInt) {
          adt(256);
        } else if (256 == paramInt) {
          adt(128);
        } else if (512 == paramInt) {
          adt(1024);
        } else if (1024 == paramInt) {
          adt(512);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.JTv, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  private void fEN()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private void fEU()
  {
    d(4, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34294);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        AppMethodBeat.o(34294);
      }
    });
  }
  
  private boolean fEX()
  {
    return (adr(256)) && (!adr(128));
  }
  
  private void ffV()
  {
    d(64, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34298);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        if ((BaseChattingUIFragment.this.adr(16)) && (!BaseChattingUIFragment.this.adr(8)))
        {
          RuntimeException localRuntimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx), Boolean.valueOf(BaseChattingUIFragment.this.cXJ.cCq), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.adr(2)) }));
          AppMethodBeat.o(34298);
          throw localRuntimeException;
        }
        BaseChattingUIFragment.this.cXJ.cCq = false;
        BaseChattingUIFragment.this.cXJ.setFocused(false);
        BaseChattingUIFragment.this.cXJ.Kkk = false;
        BaseChattingUIFragment.this.cXJ.yi(false);
        BaseChattingUIFragment.e(BaseChattingUIFragment.this);
        AppMethodBeat.o(34298);
      }
    });
  }
  
  private boolean isStrict(int paramInt)
  {
    if ((4 == paramInt) && (adr(2))) {}
    while (((8 == paramInt) && (adr(4))) || ((16 == paramInt) && (adr(8))) || ((32 == paramInt) && (adr(4))) || ((64 == paramInt) && (adr(2))) || ((512 == paramInt) && (adr(256)))) {
      return false;
    }
    return true;
  }
  
  public final void addHeaderView(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  public final boolean adr(int paramInt)
  {
    return (this.JTy & paramInt) == 0;
  }
  
  protected void aq(an paraman)
  {
    this.JTv = String.format(this.JTu, new Object[] { paraman.field_username });
    this.cXJ.au(paraman);
  }
  
  public final int bGB()
  {
    return getListView().getFooterViewsCount();
  }
  
  public void dFr() {}
  
  public void ehQ()
  {
    d(16, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34296);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fAw();
        BaseChattingUIFragment.b(BaseChattingUIFragment.this, BaseChattingUIFragment.c(BaseChattingUIFragment.this) + (System.currentTimeMillis() - BaseChattingUIFragment.d(BaseChattingUIFragment.this)));
        BaseChattingUIFragment.this.cXJ.Kkm = true;
        AppMethodBeat.o(34296);
      }
    });
  }
  
  public void fEB()
  {
    d(2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34293);
        BaseChattingUIFragment.this.cXJ.cCq = true;
        BaseChattingUIFragment.this.cXJ.setFocused(true);
        BaseChattingUIFragment.this.cXJ.Kkk = false;
        BaseChattingUIFragment.this.cXJ.yi(false);
        BaseChattingUIFragment.this.cXJ.Kkm = false;
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fAs();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        AppMethodBeat.o(34293);
      }
    });
  }
  
  public void fED()
  {
    d(8, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34295);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fAv();
        BaseChattingUIFragment.a(BaseChattingUIFragment.this, System.currentTimeMillis());
        AppMethodBeat.o(34295);
      }
    });
  }
  
  public final void fEO()
  {
    fEB();
    if ((this.isCurrentActivity) || (this.JTx)) {
      onEnterBegin();
    }
  }
  
  public final void fEP()
  {
    if (this.cXJ.cCq) {
      fEU();
    }
  }
  
  public final void fEQ()
  {
    if (this.cXJ.cCq)
    {
      fED();
      if ((this.isCurrentActivity) || (this.JTx)) {
        onEnterEnd();
      }
    }
  }
  
  public final void fER()
  {
    if ((this.cXJ.cCq) || (isFinishing()))
    {
      if ((adr(8)) && (!isFinishing()) && (!fEW()))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        fED();
        onEnterEnd();
      }
      ehQ();
    }
  }
  
  public final void fES()
  {
    if (((this.cXJ.cCq) || (isFinishing())) && (!fEX()))
    {
      if (adr(16))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.JTv });
        ehQ();
      }
      cWY();
    }
  }
  
  public final void fET()
  {
    d(512, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34290);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BaseChattingUIFragment", "fallback for SwipeBack");
        BaseChattingUIFragment.a(BaseChattingUIFragment.this);
        BaseChattingUIFragment.this.onExitBegin();
        AppMethodBeat.o(34290);
      }
    });
    ffV();
    onExitEnd();
  }
  
  public void fEV()
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.JTv, Boolean.valueOf(this.JTx) });
    Iterator localIterator = this.cXJ.KjZ.KrM.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof com.tencent.mm.ui.chatting.d.ae)) {
        ((com.tencent.mm.ui.chatting.d.ae)localEntry.getValue()).fGE();
      }
    }
  }
  
  public final boolean fEW()
  {
    return (adr(1024)) && (!adr(512));
  }
  
  public abstract v fEY();
  
  public abstract boolean fEZ();
  
  public com.tencent.mm.ui.chatting.n.a.a fFa()
  {
    return null;
  }
  
  public void fFb() {}
  
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
    an localan = this.cXJ.Cqh;
    if ((localan == null) || ((int)localan.ght == 0) || (bu.isNullOrNil(localan.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.g.ajM())
    {
      if (com.tencent.mm.al.g.vz(localan.field_username)) {
        return "_EnterpriseChat";
      }
      if (com.tencent.mm.al.g.Es(localan.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (com.tencent.mm.al.g.Er(localan.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localan.fug()) {
      return "_bizContact";
    }
    if (x.wb(localan.field_username)) {
      return "_chatroom";
    }
    if (x.Ac(localan.field_username)) {
      return "_bottle";
    }
    if (x.Ad(localan.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  protected void kp(Context paramContext)
  {
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.JTv, Boolean.valueOf(this.JTx) });
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    fEO();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.cXJ.cCq) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.cXJ.Kka.getFragment();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.i.b.d((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((d.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.cXJ.Kkb.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.JTu = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    kp(paramContext);
    this.cXJ.a(j.class, this.JTw);
    this.cXJ.a(n.class, this.cXJ.Kkb);
    paramContext = com.tencent.mm.ui.chatting.d.h.getComponents().iterator();
    while (paramContext.hasNext())
    {
      h.a locala = (h.a)paramContext.next();
      this.cXJ.a(locala.aWK, locala.fHn());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.cXJ.cCq) {
      this.cXJ.Kkb.onConfigurationChanged(paramConfiguration);
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
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.JTv, Boolean.valueOf(this.cXJ.cCq), Boolean.valueOf(isFinishing()) });
    fET();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    fEV();
  }
  
  public void onEnterBegin()
  {
    d(128, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34299);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
        int j = WXHardCoderJNI.hcEnterChattingDelay;
        int k = WXHardCoderJNI.hcEnterChattingCPU;
        int m = WXHardCoderJNI.hcEnterChattingIO;
        if (WXHardCoderJNI.hcEnterChattingThr) {}
        for (int i = com.tencent.mm.kernel.g.ajU().foN();; i = 0)
        {
          localBaseChattingUIFragment.JTz = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
          BaseChattingUIFragment.this.cXJ.cCq = true;
          BaseChattingUIFragment.this.cXJ.setFocused(true);
          BaseChattingUIFragment.this.cXJ.Kkk = false;
          BaseChattingUIFragment.this.cXJ.yi(false);
          BaseChattingUIFragment.b(BaseChattingUIFragment.this).fAt();
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
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fAu();
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, localBaseChattingUIFragment.JTz);
        localBaseChattingUIFragment.JTz = 0;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcQuitChattingEnable;
        int j = WXHardCoderJNI.hcQuitChattingDelay;
        int k = WXHardCoderJNI.hcQuitChattingCPU;
        int m = WXHardCoderJNI.hcQuitChattingIO;
        if (WXHardCoderJNI.hcQuitChattingThr) {
          i = com.tencent.mm.kernel.g.ajU().foN();
        }
        localBaseChattingUIFragment.JTA = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fAx();
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
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.JTv, Boolean.valueOf(BaseChattingUIFragment.this.JTx) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).fAy();
        Object localObject = BaseChattingUIFragment.this;
        if (((BaseChattingUIFragment)localObject).JTA != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, ((BaseChattingUIFragment)localObject).JTA);
          ((BaseChattingUIFragment)localObject).JTA = 0;
        }
        BaseChattingUIFragment.this.cXJ.cCq = false;
        BaseChattingUIFragment.this.cXJ.setFocused(false);
        BaseChattingUIFragment.this.cXJ.Kkk = false;
        BaseChattingUIFragment.this.cXJ.yi(false);
        localObject = new nt();
        ((nt)localObject).dCH.action = 1;
        ((nt)localObject).dCH.username = BaseChattingUIFragment.this.cXJ.getTalkerUserName();
        ((nt)localObject).dCH.dCI = BaseChattingUIFragment.c(BaseChattingUIFragment.this);
        com.tencent.mm.sdk.b.a.IvT.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
        AppMethodBeat.o(34292);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.cXJ.Kkb.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.JTv, Boolean.valueOf(this.cXJ.cCq), Boolean.valueOf(isFinishing()), Boolean.valueOf(fEW()) });
    fER();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.cXJ.Kkb.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.JTv, Boolean.valueOf(this.cXJ.cCq), Boolean.valueOf(isFinishing()) });
    fEQ();
  }
  
  public final void onStart()
  {
    super.onStart();
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.JTv, Boolean.valueOf(this.cXJ.cCq), Boolean.valueOf(isFinishing()) });
    fEP();
  }
  
  public final void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.JTv, Boolean.valueOf(this.cXJ.cCq), Boolean.valueOf(isFinishing()), Boolean.valueOf(fEX()) });
    fES();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.g.ajS();
    if (com.tencent.mm.compatible.d.b.ca(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.ajO().ajq()).ca))
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */