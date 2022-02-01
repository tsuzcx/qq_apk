package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.qu;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.br.c.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.chatting.component.ak;
import com.tencent.mm.ui.chatting.component.api.j;
import com.tencent.mm.ui.chatting.component.api.l;
import com.tencent.mm.ui.chatting.component.api.p;
import com.tencent.mm.ui.chatting.component.h.a;
import com.tencent.mm.ui.chatting.component.k;
import com.tencent.mm.ui.chatting.component.m;
import com.tencent.mm.ui.chatting.component.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BaseChattingUIFragment
  extends MMFragment
  implements ah, ai
{
  protected String aefm;
  protected String aefn;
  private m aefo = new m();
  private k aefp = new k();
  public boolean aefq = false;
  private int aefr = 0;
  int aefs;
  int aeft;
  private long hTS;
  protected com.tencent.mm.ui.chatting.d.a hlc = new com.tencent.mm.ui.chatting.d.a(this, this, this);
  public boolean nCq = false;
  private long qvl;
  
  public BaseChattingUIFragment()
  {
    joG();
  }
  
  public BaseChattingUIFragment(boolean paramBoolean)
  {
    super(true);
    joG();
  }
  
  private void aBE(int paramInt)
  {
    this.aefr |= paramInt;
  }
  
  private void aBF(int paramInt)
  {
    this.aefr &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean aBG(int paramInt)
  {
    if ((4 == paramInt) && (aBD(2))) {}
    while (((8 == paramInt) && (aBD(4))) || ((16 == paramInt) && (aBD(8))) || ((32 == paramInt) && (aBD(4))) || ((64 == paramInt) && (aBD(2))) || ((512 == paramInt) && (aBD(256)))) {
      return false;
    }
    return true;
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1 = aBG(paramInt);
    boolean bool2 = aBD(paramInt);
    if ((bool2) && (bool1))
    {
      aBE(paramInt);
      if (2 == paramInt) {
        aBF(64);
      }
      for (;;)
      {
        paramRunnable.run();
        return;
        if (64 == paramInt) {
          aBF(2);
        } else if (4 == paramInt) {
          aBF(32);
        } else if (32 == paramInt) {
          aBF(4);
        } else if (8 == paramInt) {
          aBF(16);
        } else if (16 == paramInt) {
          aBF(8);
        } else if (128 == paramInt) {
          aBF(256);
        } else if (256 == paramInt) {
          aBF(128);
        } else if (512 == paramInt) {
          aBF(1024);
        } else if (1024 == paramInt) {
          aBF(512);
        }
      }
    }
    Log.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.aefn, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  private void fzH()
  {
    d(32, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34297);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        BaseChattingUIFragment.this.iNh().aezX = true;
        AppMethodBeat.o(34297);
      }
    });
  }
  
  private void joG()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private void joN()
  {
    d(4, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34294);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        AppMethodBeat.o(34294);
      }
    });
  }
  
  private boolean joR()
  {
    return (aBD(256)) && (!aBD(128));
  }
  
  public final boolean aBD(int paramInt)
  {
    return (this.aefr & paramInt) == 0;
  }
  
  protected void aE(au paramau)
  {
    this.aefn = String.format(this.aefm, new Object[] { paramau.field_username });
    this.hlc.aI(paramau);
  }
  
  protected final void bAy(String paramString)
  {
    this.hlc.aemd = paramString;
  }
  
  public final int cST()
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).jjj();
        BaseChattingUIFragment.b(BaseChattingUIFragment.this, System.currentTimeMillis() - BaseChattingUIFragment.c(BaseChattingUIFragment.this));
        BaseChattingUIFragment.this.iNh().aezX = true;
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).jji();
        BaseChattingUIFragment.a(BaseChattingUIFragment.this, System.currentTimeMillis());
        BaseChattingUIFragment.this.iNh().aezX = false;
        AppMethodBeat.o(34295);
      }
    });
  }
  
  public final void ev(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  public void gDP() {}
  
  public final View getChildAt(int paramInt)
  {
    return getListView().getChildAt(paramInt);
  }
  
  public int getFirstVisiblePosition()
  {
    return getListView().getFirstVisiblePosition();
  }
  
  public String getIdentityString()
  {
    au localau = this.hlc.Uxa;
    if ((localau == null) || ((int)localau.maN == 0) || (Util.isNullOrNil(localau.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.h.baz())
    {
      if (com.tencent.mm.an.g.Dn(localau.field_username)) {
        return "_EnterpriseChat";
      }
      if (com.tencent.mm.an.g.MB(localau.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (com.tencent.mm.an.g.MA(localau.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localau.iZC()) {
      return "_bizContact";
    }
    if (au.bwE(localau.field_username)) {
      return "_chatroom";
    }
    if (au.bwS(localau.field_username)) {
      return "_bottle";
    }
    if (au.bwN(localau.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  public void iKP()
  {
    d(64, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34298);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        if ((BaseChattingUIFragment.this.aBD(16)) && (!BaseChattingUIFragment.this.aBD(8)))
        {
          RuntimeException localRuntimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq), Boolean.valueOf(BaseChattingUIFragment.this.isForeground()), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.aBD(2)) }));
          AppMethodBeat.o(34298);
          throw localRuntimeException;
        }
        BaseChattingUIFragment.this.iNh().ffv = false;
        BaseChattingUIFragment.this.iNh().aE(false);
        BaseChattingUIFragment.this.iNh().aezV = false;
        BaseChattingUIFragment.this.iNh().Mh(false);
        BaseChattingUIFragment.d(BaseChattingUIFragment.this);
        AppMethodBeat.o(34298);
      }
    });
  }
  
  public final com.tencent.mm.ui.chatting.d.a iNh()
  {
    return this.hlc;
  }
  
  public final boolean isForeground()
  {
    return this.hlc.ffv;
  }
  
  public final void joH()
  {
    jou();
    if ((this.isCurrentActivity) || (this.aefq)) {
      onEnterBegin();
    }
  }
  
  public final void joI()
  {
    if (this.hlc.ffv) {
      joN();
    }
  }
  
  public final void joJ()
  {
    if (this.hlc.ffv)
    {
      doResume();
      if ((this.isCurrentActivity) || (this.aefq)) {
        onEnterEnd();
      }
    }
  }
  
  public final void joK()
  {
    if ((this.hlc.ffv) || (isFinishing()))
    {
      if ((aBD(8)) && (!isFinishing()) && (!joQ()))
      {
        Log.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        doResume();
        onEnterEnd();
      }
      doPause();
    }
  }
  
  public final void joL()
  {
    if (((this.hlc.ffv) || (isFinishing())) && (!joR()))
    {
      if (aBD(16))
      {
        Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.aefn });
        doPause();
      }
      fzH();
    }
  }
  
  public final void joM()
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
    iKP();
    onExitEnd();
  }
  
  public void joO()
  {
    Log.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.aefn, Boolean.valueOf(this.aefq) });
    Iterator localIterator = this.hlc.aezL.aeIh.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof ak)) {
        ((ak)localEntry.getValue()).jqF();
      }
    }
  }
  
  protected final s joP()
  {
    return this.hlc.aezN;
  }
  
  public final boolean joQ()
  {
    return (aBD(1024)) && (!aBD(512));
  }
  
  public abstract ab joS();
  
  public final int joT()
  {
    return getListView().getHeaderViewsCount();
  }
  
  public abstract boolean joU();
  
  public com.tencent.mm.ui.chatting.k.a.a joV()
  {
    return null;
  }
  
  public void joW() {}
  
  public void jou()
  {
    d(2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34293);
        BaseChattingUIFragment.this.iNh().ffv = true;
        BaseChattingUIFragment.this.iNh().aE(true);
        BaseChattingUIFragment.this.iNh().aezV = false;
        BaseChattingUIFragment.this.iNh().Mh(false);
        BaseChattingUIFragment.this.iNh().aezX = false;
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).jjf();
        Log.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        AppMethodBeat.o(34293);
      }
    });
  }
  
  protected void nj(Context paramContext)
  {
    Log.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.aefn, Boolean.valueOf(this.aefq) });
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    joH();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.hlc.ffv) {
        break;
      }
      Log.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.hlc.aezM.getFragment();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.g.b.d((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((c.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.hlc.aezN.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.aefm = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    nj(paramContext);
    this.hlc.a(l.class, this.aefo);
    this.hlc.a(p.class, this.hlc.aezN);
    this.hlc.a(j.class, this.aefp);
    paramContext = com.tencent.mm.ui.chatting.component.h.getComponents().iterator();
    while (paramContext.hasNext())
    {
      h.a locala = (h.a)paramContext.next();
      this.hlc.a(locala.clazz, locala.jrz());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.hlc.ffv) {
      this.hlc.aezN.onConfigurationChanged(paramConfiguration);
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
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.aefn, Boolean.valueOf(this.hlc.ffv), Boolean.valueOf(isFinishing()) });
    joM();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    joO();
  }
  
  public void onDragBegin()
  {
    this.hlc.aezN.onDragBegin();
  }
  
  public void onEnterBegin()
  {
    d(128, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34299);
        Log.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
        int j = WXHardCoderJNI.hcEnterChattingDelay;
        int k = WXHardCoderJNI.hcEnterChattingCPU;
        int m = WXHardCoderJNI.hcEnterChattingIO;
        if (WXHardCoderJNI.hcEnterChattingThr) {}
        for (int i = com.tencent.mm.kernel.h.baH().getProcessTid();; i = 0)
        {
          localBaseChattingUIFragment.aefs = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
          BaseChattingUIFragment.this.iNh().ffv = true;
          BaseChattingUIFragment.this.iNh().aE(true);
          BaseChattingUIFragment.this.iNh().aezV = false;
          BaseChattingUIFragment.this.iNh().Mh(false);
          BaseChattingUIFragment.b(BaseChattingUIFragment.this).jjg();
          BaseChattingUIFragment.e(BaseChattingUIFragment.this);
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
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).jjh();
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, localBaseChattingUIFragment.aefs);
        localBaseChattingUIFragment.aefs = 0;
        Log.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcQuitChattingEnable;
        int j = WXHardCoderJNI.hcQuitChattingDelay;
        int k = WXHardCoderJNI.hcQuitChattingCPU;
        int m = WXHardCoderJNI.hcQuitChattingIO;
        if (WXHardCoderJNI.hcQuitChattingThr) {
          i = com.tencent.mm.kernel.h.baH().getProcessTid();
        }
        localBaseChattingUIFragment.aeft = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).jjk();
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.aefn, Boolean.valueOf(BaseChattingUIFragment.this.aefq) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).jjl();
        Object localObject = BaseChattingUIFragment.this;
        if (((BaseChattingUIFragment)localObject).aeft != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, ((BaseChattingUIFragment)localObject).aeft);
          ((BaseChattingUIFragment)localObject).aeft = 0;
        }
        BaseChattingUIFragment.this.iNh().ffv = false;
        BaseChattingUIFragment.this.iNh().aE(false);
        BaseChattingUIFragment.this.iNh().aezV = false;
        BaseChattingUIFragment.this.iNh().Mh(false);
        localObject = new qu();
        ((qu)localObject).hTR.action = 1;
        ((qu)localObject).hTR.username = BaseChattingUIFragment.this.iNh().getTalkerUserName();
        ((qu)localObject).hTR.hTS = BaseChattingUIFragment.f(BaseChattingUIFragment.this);
        ((qu)localObject).asyncPublish(Looper.getMainLooper());
        AppMethodBeat.o(34292);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.hlc.aezN.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.aefn, Boolean.valueOf(this.hlc.ffv), Boolean.valueOf(isFinishing()), Boolean.valueOf(joQ()) });
    joK();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.hlc.aezN.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.aefn, Boolean.valueOf(this.hlc.ffv), Boolean.valueOf(isFinishing()) });
    joJ();
  }
  
  public final void onStart()
  {
    super.onStart();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.aefn, Boolean.valueOf(this.hlc.ffv), Boolean.valueOf(isFinishing()) });
    joI();
  }
  
  public final void onStop()
  {
    super.onStop();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.aefn, Boolean.valueOf(this.hlc.ffv), Boolean.valueOf(isFinishing()), Boolean.valueOf(joR()) });
    joL();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.h.baF();
    if (com.tencent.mm.compatible.e.b.df(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.baB().bad()).bGP))
    {
      Log.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */