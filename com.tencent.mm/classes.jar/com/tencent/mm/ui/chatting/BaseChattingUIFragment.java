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
import com.tencent.mm.am.f;
import com.tencent.mm.bs.d.a;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.c.au;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.ac;
import com.tencent.mm.ui.chatting.c.b.l;
import com.tencent.mm.ui.chatting.c.h.a;
import com.tencent.mm.ui.chatting.c.i;
import com.tencent.mm.ui.chatting.c.n;
import com.tencent.mm.ui.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BaseChattingUIFragment
  extends MMFragment
  implements ad, ae
{
  protected String GkY;
  protected String GkZ;
  private i Gla = new i();
  public boolean Glb = false;
  private int Glc = 0;
  int Gld;
  int Gle;
  public com.tencent.mm.ui.chatting.d.a cOd = new com.tencent.mm.ui.chatting.d.a(this, this, this);
  private long dsf;
  private long lastResumeTime;
  
  public BaseChattingUIFragment()
  {
    eUK();
  }
  
  public BaseChattingUIFragment(byte paramByte)
  {
    super(true);
    eUK();
  }
  
  private void Yp(int paramInt)
  {
    this.Glc |= paramInt;
  }
  
  private void Yq(int paramInt)
  {
    this.Glc &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void cyO()
  {
    d(32, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34297);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doStop] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        AppMethodBeat.o(34297);
      }
    });
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1 = isStrict(paramInt);
    boolean bool2 = Yo(paramInt);
    if ((bool2) && (bool1))
    {
      Yp(paramInt);
      if (2 == paramInt) {
        Yq(64);
      }
      for (;;)
      {
        paramRunnable.run();
        return;
        if (64 == paramInt) {
          Yq(2);
        } else if (4 == paramInt) {
          Yq(32);
        } else if (32 == paramInt) {
          Yq(4);
        } else if (8 == paramInt) {
          Yq(16);
        } else if (16 == paramInt) {
          Yq(8);
        } else if (128 == paramInt) {
          Yq(256);
        } else if (256 == paramInt) {
          Yq(128);
        } else if (512 == paramInt) {
          Yq(1024);
        } else if (1024 == paramInt) {
          Yq(512);
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.GkZ, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  private void eUK()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private void eUR()
  {
    d(4, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34294);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        AppMethodBeat.o(34294);
      }
    });
  }
  
  private boolean eUU()
  {
    return (Yo(256)) && (!Yo(128));
  }
  
  private void exO()
  {
    d(64, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34298);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doDestroy] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        if ((BaseChattingUIFragment.this.Yo(16)) && (!BaseChattingUIFragment.this.Yo(8)))
        {
          RuntimeException localRuntimeException = new RuntimeException(String.format("[doDestroy] never doPause, activity:%s isPreLoaded:%b isForeground:%b isFinishing:%b isNeverCreate:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb), Boolean.valueOf(BaseChattingUIFragment.this.cOd.ctF), Boolean.valueOf(BaseChattingUIFragment.this.isFinishing()), Boolean.valueOf(BaseChattingUIFragment.this.Yo(2)) }));
          AppMethodBeat.o(34298);
          throw localRuntimeException;
        }
        BaseChattingUIFragment.this.cOd.ctF = false;
        BaseChattingUIFragment.this.cOd.setFocused(false);
        BaseChattingUIFragment.this.cOd.GzP = false;
        BaseChattingUIFragment.this.cOd.wl(false);
        BaseChattingUIFragment.d(BaseChattingUIFragment.this);
        AppMethodBeat.o(34298);
      }
    });
  }
  
  private boolean isStrict(int paramInt)
  {
    if ((4 == paramInt) && (Yo(2))) {}
    while (((8 == paramInt) && (Yo(4))) || ((16 == paramInt) && (Yo(8))) || ((32 == paramInt) && (Yo(4))) || ((64 == paramInt) && (Yo(2))) || ((512 == paramInt) && (Yo(256)))) {
      return false;
    }
    return true;
  }
  
  public final boolean Yo(int paramInt)
  {
    return (this.Glc & paramInt) == 0;
  }
  
  public final void addHeaderView(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  protected void ai(af paramaf)
  {
    this.GkZ = String.format(this.GkY, new Object[] { paramaf.field_username });
    this.cOd.am(paramaf);
  }
  
  public void dDq()
  {
    d(16, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34296);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).eQE();
        BaseChattingUIFragment.b(BaseChattingUIFragment.this, BaseChattingUIFragment.b(BaseChattingUIFragment.this) + (System.currentTimeMillis() - BaseChattingUIFragment.c(BaseChattingUIFragment.this)));
        AppMethodBeat.o(34296);
      }
    });
  }
  
  public void ddQ() {}
  
  public final void eUL()
  {
    eUx();
    if ((this.isCurrentActivity) || (this.Glb)) {
      onEnterBegin();
    }
  }
  
  public final void eUM()
  {
    if (this.cOd.ctF) {
      eUR();
    }
  }
  
  public final void eUN()
  {
    if (this.cOd.ctF)
    {
      eUz();
      if ((this.isCurrentActivity) || (this.Glb)) {
        onEnterEnd();
      }
    }
  }
  
  public final void eUO()
  {
    if ((this.cOd.ctF) || (isFinishing()))
    {
      if ((Yo(8)) && (!isFinishing()) && (!eUT()))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        eUz();
        onEnterEnd();
      }
      dDq();
    }
  }
  
  public final void eUP()
  {
    if (((this.cOd.ctF) || (isFinishing())) && (!eUU()))
    {
      if (Yo(16))
      {
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.GkZ });
        dDq();
      }
      cyO();
    }
  }
  
  public final void eUQ()
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
    exO();
    onExitEnd();
  }
  
  public void eUS()
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.GkZ, Boolean.valueOf(this.Glb) });
    Iterator localIterator = this.cOd.GzF.GFl.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof ac)) {
        ((ac)localEntry.getValue()).eWx();
      }
    }
  }
  
  public final boolean eUT()
  {
    return (Yo(1024)) && (!Yo(512));
  }
  
  public abstract u eUV();
  
  public abstract boolean eUW();
  
  public com.tencent.mm.ui.chatting.m.a.a eUX()
  {
    return null;
  }
  
  public void eUY() {}
  
  public void eUx()
  {
    d(2, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34293);
        BaseChattingUIFragment.this.cOd.ctF = true;
        BaseChattingUIFragment.this.cOd.setFocused(true);
        BaseChattingUIFragment.this.cOd.GzP = false;
        BaseChattingUIFragment.this.cOd.wl(false);
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).eQA();
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doCreate] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        AppMethodBeat.o(34293);
      }
    });
  }
  
  public void eUz()
  {
    d(8, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34295);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).eQD();
        BaseChattingUIFragment.a(BaseChattingUIFragment.this, System.currentTimeMillis());
        AppMethodBeat.o(34295);
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
    af localaf = this.cOd.zgX;
    if ((localaf == null) || ((int)localaf.fId == 0) || (bt.isNullOrNil(localaf.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.g.afw())
    {
      if (f.pc(localaf.field_username)) {
        return "_EnterpriseChat";
      }
      if (f.wL(localaf.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (f.wK(localaf.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localaf.eKB()) {
      return "_bizContact";
    }
    if (w.pF(localaf.field_username)) {
      return "_chatroom";
    }
    if (w.st(localaf.field_username)) {
      return "_bottle";
    }
    if (w.su(localaf.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  protected void jM(Context paramContext)
  {
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.GkZ, Boolean.valueOf(this.Glb) });
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    eUL();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.cOd.ctF) {
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.cOd.GzG.getFragment();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.h.b.d((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((d.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.cOd.GzH.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.GkY = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    jM(paramContext);
    this.cOd.a(com.tencent.mm.ui.chatting.c.b.h.class, this.Gla);
    this.cOd.a(l.class, this.cOd.GzH);
    paramContext = com.tencent.mm.ui.chatting.c.h.getComponents().iterator();
    while (paramContext.hasNext())
    {
      h.a locala = (h.a)paramContext.next();
      this.cOd.a(locala.aLD, locala.eXe());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.cOd.ctF) {
      this.cOd.GzH.onConfigurationChanged(paramConfiguration);
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
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.GkZ, Boolean.valueOf(this.cOd.ctF), Boolean.valueOf(isFinishing()) });
    eUQ();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    eUS();
  }
  
  public void onEnterBegin()
  {
    d(128, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34299);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[onEnterBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcEnterChattingEnable;
        int j = WXHardCoderJNI.hcEnterChattingDelay;
        int k = WXHardCoderJNI.hcEnterChattingCPU;
        int m = WXHardCoderJNI.hcEnterChattingIO;
        if (WXHardCoderJNI.hcEnterChattingThr) {}
        for (int i = com.tencent.mm.kernel.g.afE().eFQ();; i = 0)
        {
          localBaseChattingUIFragment.Gld = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcEnterChattingTimeout, 301, WXHardCoderJNI.hcEnterChattingAction, "ChattingUIFragment");
          BaseChattingUIFragment.this.cOd.ctF = true;
          BaseChattingUIFragment.this.cOd.setFocused(true);
          BaseChattingUIFragment.this.cOd.GzP = false;
          BaseChattingUIFragment.this.cOd.wl(false);
          BaseChattingUIFragment.a(BaseChattingUIFragment.this).eQB();
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
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).eQC();
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcEnterChattingEnable, localBaseChattingUIFragment.Gld);
        localBaseChattingUIFragment.Gld = 0;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[onEnterEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[onExitBegin] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        BaseChattingUIFragment localBaseChattingUIFragment = BaseChattingUIFragment.this;
        boolean bool = WXHardCoderJNI.hcQuitChattingEnable;
        int j = WXHardCoderJNI.hcQuitChattingDelay;
        int k = WXHardCoderJNI.hcQuitChattingCPU;
        int m = WXHardCoderJNI.hcQuitChattingIO;
        if (WXHardCoderJNI.hcQuitChattingThr) {
          i = com.tencent.mm.kernel.g.afE().eFQ();
        }
        localBaseChattingUIFragment.Gle = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcQuitChattingTimeout, 302, WXHardCoderJNI.hcQuitChattingAction, "ChattingUIFragment");
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).eQF();
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
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BaseChattingUIFragment", "[onExitEnd] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.GkZ, Boolean.valueOf(BaseChattingUIFragment.this.Glb) });
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).eQG();
        Object localObject = BaseChattingUIFragment.this;
        if (((BaseChattingUIFragment)localObject).Gle != 0)
        {
          WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcQuitChattingEnable, ((BaseChattingUIFragment)localObject).Gle);
          ((BaseChattingUIFragment)localObject).Gle = 0;
        }
        BaseChattingUIFragment.this.cOd.ctF = false;
        BaseChattingUIFragment.this.cOd.setFocused(false);
        BaseChattingUIFragment.this.cOd.GzP = false;
        BaseChattingUIFragment.this.cOd.wl(false);
        localObject = new nb();
        ((nb)localObject).dse.action = 1;
        ((nb)localObject).dse.username = BaseChattingUIFragment.this.cOd.getTalkerUserName();
        ((nb)localObject).dse.dsf = BaseChattingUIFragment.b(BaseChattingUIFragment.this);
        com.tencent.mm.sdk.b.a.ESL.a((com.tencent.mm.sdk.b.b)localObject, Looper.getMainLooper());
        AppMethodBeat.o(34292);
      }
    });
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.cOd.GzH.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.GkZ, Boolean.valueOf(this.cOd.ctF), Boolean.valueOf(isFinishing()), Boolean.valueOf(eUT()) });
    eUO();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.cOd.GzH.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.GkZ, Boolean.valueOf(this.cOd.ctF), Boolean.valueOf(isFinishing()) });
    eUN();
  }
  
  public final void onStart()
  {
    super.onStart();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.GkZ, Boolean.valueOf(this.cOd.ctF), Boolean.valueOf(isFinishing()) });
    eUM();
  }
  
  public final void onStop()
  {
    super.onStop();
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.GkZ, Boolean.valueOf(this.cOd.ctF), Boolean.valueOf(isFinishing()), Boolean.valueOf(eUU()) });
    eUP();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.g.afC();
    if (com.tencent.mm.compatible.d.b.bX(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.afy().aeZ()).ca))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */