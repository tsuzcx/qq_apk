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
import com.tencent.mm.by.c.a;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.a.pi;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.ah;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.d.b.n;
import com.tencent.mm.ui.chatting.d.h.a;
import com.tencent.mm.ui.chatting.d.l;
import com.tencent.mm.ui.chatting.d.q;
import com.tencent.mm.ui.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BaseChattingUIFragment
  extends MMFragment
  implements ae, af
{
  protected String WxR;
  protected String WxS;
  private l WxT = new l();
  public boolean WxU = false;
  private int WxV = 0;
  int WxW;
  int WxX;
  private long fOa;
  public com.tencent.mm.ui.chatting.e.a fgR = new com.tencent.mm.ui.chatting.e.a(this, this, this);
  private long lastResumeTime;
  
  public BaseChattingUIFragment()
  {
    hMe();
  }
  
  public BaseChattingUIFragment(boolean paramBoolean)
  {
    super(true);
    hMe();
  }
  
  private void avc(int paramInt)
  {
    this.WxV |= paramInt;
  }
  
  private void avd(int paramInt)
  {
    this.WxV &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private boolean ave(int paramInt)
  {
    if ((4 == paramInt) && (avb(2))) {}
    while (((8 == paramInt) && (avb(4))) || ((16 == paramInt) && (avb(8))) || ((32 == paramInt) && (avb(4))) || ((64 == paramInt) && (avb(2))) || ((512 == paramInt) && (avb(256)))) {
      return false;
    }
    return true;
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1 = ave(paramInt);
    boolean bool2 = avb(paramInt);
    if ((bool2) && (bool1))
    {
      avc(paramInt);
      if (2 == paramInt) {
        avd(64);
      }
      for (;;)
      {
        paramRunnable.run();
        return;
        if (64 == paramInt) {
          avd(2);
        } else if (4 == paramInt) {
          avd(32);
        } else if (32 == paramInt) {
          avd(4);
        } else if (8 == paramInt) {
          avd(16);
        } else if (16 == paramInt) {
          avd(8);
        } else if (128 == paramInt) {
          avd(256);
        } else if (256 == paramInt) {
          avd(128);
        } else if (512 == paramInt) {
          avd(1024);
        } else if (1024 == paramInt) {
          avd(512);
        }
      }
    }
    Log.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.WxS, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  private void esN()
  {
    d(32, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34297);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        BaseChattingUIFragment.this.fgR.WQE = true;
        AppMethodBeat.o(34297);
      }
    });
  }
  
  private void hMe()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private void hMl()
  {
    d(4, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34294);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        AppMethodBeat.o(34294);
      }
    });
  }
  
  private boolean hMo()
  {
    return (avb(256)) && (!avb(128));
  }
  
  private void hjX()
  {
    d(64, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34298);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        if ((BaseChattingUIFragment.this.avb(16)) && (!BaseChattingUIFragment.this.avb(8)))
        {
          RuntimeException localRuntimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU), Boolean.valueOf(BaseChattingUIFragment.this.fgR.dgo), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.avb(2)) }));
          AppMethodBeat.o(34298);
          throw localRuntimeException;
        }
        BaseChattingUIFragment.this.fgR.dgo = false;
        BaseChattingUIFragment.this.fgR.Y(false);
        BaseChattingUIFragment.this.fgR.WQC = false;
        BaseChattingUIFragment.this.fgR.Gs(false);
        BaseChattingUIFragment.e(BaseChattingUIFragment.this);
        AppMethodBeat.o(34298);
      }
    });
  }
  
  public final boolean avb(int paramInt)
  {
    return (this.WxV & paramInt) == 0;
  }
  
  protected void ay(as paramas)
  {
    this.WxS = String.format(this.WxR, new Object[] { paramas.field_username });
    this.fgR.aC(paramas);
  }
  
  public final int cqm()
  {
    return getListView().getFooterViewsCount();
  }
  
  public final void dI(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  public void doPause()
  {
    d(16, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34296);
        Log.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).hGY();
        BaseChattingUIFragment.b(BaseChattingUIFragment.this, BaseChattingUIFragment.c(BaseChattingUIFragment.this) + (System.currentTimeMillis() - BaseChattingUIFragment.d(BaseChattingUIFragment.this)));
        BaseChattingUIFragment.this.fgR.WQE = true;
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).hGX();
        BaseChattingUIFragment.a(BaseChattingUIFragment.this, System.currentTimeMillis());
        BaseChattingUIFragment.this.fgR.WQE = false;
        AppMethodBeat.o(34295);
      }
    });
  }
  
  public void fsh() {}
  
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
    as localas = this.fgR.NKq;
    if ((localas == null) || ((int)localas.jxt == 0) || (Util.isNullOrNil(localas.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.h.aHB())
    {
      if (com.tencent.mm.ao.g.KI(localas.field_username)) {
        return "_EnterpriseChat";
      }
      if (com.tencent.mm.ao.g.UC(localas.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (com.tencent.mm.ao.g.UB(localas.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localas.hxX()) {
      return "_bizContact";
    }
    if (ab.Lj(localas.field_username)) {
      return "_chatroom";
    }
    if (ab.PY(localas.field_username)) {
      return "_bottle";
    }
    if (ab.PZ(localas.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  public void hLS()
  {
    d(2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34293);
        BaseChattingUIFragment.this.fgR.dgo = true;
        BaseChattingUIFragment.this.fgR.Y(true);
        BaseChattingUIFragment.this.fgR.WQC = false;
        BaseChattingUIFragment.this.fgR.Gs(false);
        BaseChattingUIFragment.this.fgR.WQE = false;
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).hGU();
        Log.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        AppMethodBeat.o(34293);
      }
    });
  }
  
  public final void hMf()
  {
    hLS();
    if ((this.isCurrentActivity) || (this.WxU)) {
      onEnterBegin();
    }
  }
  
  public final void hMg()
  {
    if (this.fgR.dgo) {
      hMl();
    }
  }
  
  public final void hMh()
  {
    if (this.fgR.dgo)
    {
      doResume();
      if ((this.isCurrentActivity) || (this.WxU)) {
        onEnterEnd();
      }
    }
  }
  
  public final void hMi()
  {
    if ((this.fgR.dgo) || (isFinishing()))
    {
      if ((avb(8)) && (!isFinishing()) && (!hMn()))
      {
        Log.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        doResume();
        onEnterEnd();
      }
      doPause();
    }
  }
  
  public final void hMj()
  {
    if (((this.fgR.dgo) || (isFinishing())) && (!hMo()))
    {
      if (avb(16))
      {
        Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.WxS });
        doPause();
      }
      esN();
    }
  }
  
  public final void hMk()
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
    hjX();
    onExitEnd();
  }
  
  public void hMm()
  {
    Log.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.WxS, Boolean.valueOf(this.WxU) });
    Iterator localIterator = this.fgR.WQs.WYH.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof ah)) {
        ((ah)localEntry.getValue()).hNZ();
      }
    }
  }
  
  public final boolean hMn()
  {
    return (avb(1024)) && (!avb(512));
  }
  
  public abstract z hMp();
  
  public final int hMq()
  {
    return getListView().getHeaderViewsCount();
  }
  
  public abstract boolean hMr();
  
  public com.tencent.mm.ui.chatting.o.a.a hMs()
  {
    return null;
  }
  
  public void hMt() {}
  
  protected void lf(Context paramContext)
  {
    Log.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.WxS, Boolean.valueOf(this.WxU) });
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    hMf();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.fgR.dgo) {
        break;
      }
      Log.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.fgR.WQt.getFragment();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.i.b.d((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((c.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.fgR.WQu.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.WxR = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    lf(paramContext);
    this.fgR.a(j.class, this.WxT);
    this.fgR.a(n.class, this.fgR.WQu);
    paramContext = com.tencent.mm.ui.chatting.d.h.getComponents().iterator();
    while (paramContext.hasNext())
    {
      h.a locala = (h.a)paramContext.next();
      this.fgR.a(locala.aFS, locala.hOJ());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.fgR.dgo) {
      this.fgR.WQu.onConfigurationChanged(paramConfiguration);
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
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.WxS, Boolean.valueOf(this.fgR.dgo), Boolean.valueOf(isFinishing()) });
    hMk();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    hMm();
  }
  
  public void onEnterBegin()
  {
    d(128, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34299);
        Log.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
        int j = WXHardCoderJNI.hcEnterChattingDelay;
        int k = WXHardCoderJNI.hcEnterChattingCPU;
        int m = WXHardCoderJNI.hcEnterChattingIO;
        if (WXHardCoderJNI.hcEnterChattingThr) {}
        for (int i = com.tencent.mm.kernel.h.aHJ().getProcessTid();; i = 0)
        {
          localBaseChattingUIFragment.WxW = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
          BaseChattingUIFragment.this.fgR.dgo = true;
          BaseChattingUIFragment.this.fgR.Y(true);
          BaseChattingUIFragment.this.fgR.WQC = false;
          BaseChattingUIFragment.this.fgR.Gs(false);
          BaseChattingUIFragment.b(BaseChattingUIFragment.this).hGV();
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
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).hGW();
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, localBaseChattingUIFragment.WxW);
        localBaseChattingUIFragment.WxW = 0;
        Log.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcQuitChattingEnable;
        int j = WXHardCoderJNI.hcQuitChattingDelay;
        int k = WXHardCoderJNI.hcQuitChattingCPU;
        int m = WXHardCoderJNI.hcQuitChattingIO;
        if (WXHardCoderJNI.hcQuitChattingThr) {
          i = com.tencent.mm.kernel.h.aHJ().getProcessTid();
        }
        localBaseChattingUIFragment.WxX = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).hGZ();
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
        Log.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.WxS, Boolean.valueOf(BaseChattingUIFragment.this.WxU) });
        BaseChattingUIFragment.b(BaseChattingUIFragment.this).hHa();
        Object localObject = BaseChattingUIFragment.this;
        if (((BaseChattingUIFragment)localObject).WxX != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, ((BaseChattingUIFragment)localObject).WxX);
          ((BaseChattingUIFragment)localObject).WxX = 0;
        }
        BaseChattingUIFragment.this.fgR.dgo = false;
        BaseChattingUIFragment.this.fgR.Y(false);
        BaseChattingUIFragment.this.fgR.WQC = false;
        BaseChattingUIFragment.this.fgR.Gs(false);
        localObject = new pi();
        ((pi)localObject).fNZ.action = 1;
        ((pi)localObject).fNZ.username = BaseChattingUIFragment.this.fgR.getTalkerUserName();
        ((pi)localObject).fNZ.fOa = BaseChattingUIFragment.c(BaseChattingUIFragment.this);
        EventCenter.instance.asyncPublish((IEvent)localObject, Looper.getMainLooper());
        AppMethodBeat.o(34292);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.fgR.WQu.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.WxS, Boolean.valueOf(this.fgR.dgo), Boolean.valueOf(isFinishing()), Boolean.valueOf(hMn()) });
    hMi();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.fgR.WQu.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.WxS, Boolean.valueOf(this.fgR.dgo), Boolean.valueOf(isFinishing()) });
    hMh();
  }
  
  public final void onStart()
  {
    super.onStart();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.WxS, Boolean.valueOf(this.fgR.dgo), Boolean.valueOf(isFinishing()) });
    hMg();
  }
  
  public final void onStop()
  {
    super.onStop();
    Log.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.WxS, Boolean.valueOf(this.fgR.dgo), Boolean.valueOf(isFinishing()), Boolean.valueOf(hMo()) });
    hMj();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.h.aHH();
    if (com.tencent.mm.compatible.e.b.cr(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.h.aHD().aHf()).Zw))
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