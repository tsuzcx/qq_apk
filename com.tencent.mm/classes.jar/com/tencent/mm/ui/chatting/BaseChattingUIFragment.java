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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.bq.d.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.d;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.c.b.k;
import com.tencent.mm.ui.chatting.c.g.a;
import com.tencent.mm.ui.chatting.c.l;
import com.tencent.mm.ui.chatting.c.w;
import com.tencent.mm.ui.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public abstract class BaseChattingUIFragment
  extends MMFragment
  implements ad, ae
{
  public com.tencent.mm.ui.chatting.d.a caz = new com.tencent.mm.ui.chatting.d.a(this, this, this);
  protected String zwK;
  protected String zwL;
  private com.tencent.mm.ui.chatting.c.h zwM = new com.tencent.mm.ui.chatting.c.h();
  l zwN = new l();
  public boolean zwO = false;
  private int zwP = 0;
  int zwQ;
  int zwR;
  
  public BaseChattingUIFragment()
  {
    dFP();
  }
  
  public BaseChattingUIFragment(byte paramByte)
  {
    super(true);
    dFP();
  }
  
  private void Pj(int paramInt)
  {
    this.zwP |= paramInt;
  }
  
  private void Pk(int paramInt)
  {
    this.zwP &= (paramInt ^ 0xFFFFFFFF);
  }
  
  private void bDG()
  {
    d(32, new BaseChattingUIFragment.8(this));
  }
  
  private void d(int paramInt, Runnable paramRunnable)
  {
    boolean bool1 = isStrict(paramInt);
    boolean bool2 = Pi(paramInt);
    if ((bool2) && (bool1))
    {
      Pj(paramInt);
      if (2 == paramInt) {
        Pk(64);
      }
      for (;;)
      {
        paramRunnable.run();
        return;
        if (64 == paramInt) {
          Pk(2);
        } else if (4 == paramInt) {
          Pk(32);
        } else if (32 == paramInt) {
          Pk(4);
        } else if (8 == paramInt) {
          Pk(16);
        } else if (16 == paramInt) {
          Pk(8);
        } else if (128 == paramInt) {
          Pk(256);
        } else if (256 == paramInt) {
          Pk(128);
        } else if (512 == paramInt) {
          Pk(1024);
        } else if (1024 == paramInt) {
          Pk(512);
        }
      }
    }
    ab.w("MicroMsg.BaseChattingUIFragment", "catch! [check] %s flag:%x isNever:%s isStrict:%s", new Object[] { this.zwL, Integer.valueOf(paramInt), Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
  }
  
  private void dFP()
  {
    Bundle localBundle = new Bundle();
    if (!localBundle.containsKey(getClass().getName())) {
      localBundle.putInt(getClass().getName(), 2147483647);
    }
    setArguments(localBundle);
  }
  
  private void dFW()
  {
    d(4, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30444);
        ab.i("MicroMsg.BaseChattingUIFragment", "[doStart] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.zwL, Boolean.valueOf(BaseChattingUIFragment.this.zwO) });
        AppMethodBeat.o(30444);
      }
    });
  }
  
  private boolean dFZ()
  {
    return (Pi(256)) && (!Pi(128));
  }
  
  private void dnu()
  {
    d(64, new BaseChattingUIFragment.9(this));
  }
  
  private boolean isStrict(int paramInt)
  {
    if ((4 == paramInt) && (Pi(2))) {}
    while (((8 == paramInt) && (Pi(4))) || ((16 == paramInt) && (Pi(8))) || ((32 == paramInt) && (Pi(4))) || ((64 == paramInt) && (Pi(2))) || ((512 == paramInt) && (Pi(256)))) {
      return false;
    }
    return true;
  }
  
  public final boolean Pi(int paramInt)
  {
    return (this.zwP & paramInt) == 0;
  }
  
  protected void ab(com.tencent.mm.storage.ad paramad)
  {
    this.zwL = String.format(this.zwK, new Object[] { paramad.field_username });
    this.caz.ae(paramad);
  }
  
  public final void addHeaderView(View paramView)
  {
    getListView().addHeaderView(paramView);
  }
  
  public void cdy() {}
  
  public void dFC()
  {
    d(2, new BaseChattingUIFragment.4(this));
  }
  
  public void dFD()
  {
    d(8, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30445);
        ab.i("MicroMsg.BaseChattingUIFragment", "[doResume] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.zwL, Boolean.valueOf(BaseChattingUIFragment.this.zwO) });
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).dCb();
        AppMethodBeat.o(30445);
      }
    });
  }
  
  public void dFF()
  {
    d(16, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(30446);
        ab.i("MicroMsg.BaseChattingUIFragment", "[doPause] activity:%s isPreLoaded:%b", new Object[] { BaseChattingUIFragment.this.zwL, Boolean.valueOf(BaseChattingUIFragment.this.zwO) });
        BaseChattingUIFragment.a(BaseChattingUIFragment.this).dCc();
        AppMethodBeat.o(30446);
      }
    });
  }
  
  public final void dFQ()
  {
    dFC();
    if ((this.isCurrentActivity) || (this.zwO)) {
      onEnterBegin();
    }
  }
  
  public final void dFR()
  {
    if (this.caz.bSe) {
      dFW();
    }
  }
  
  public final void dFS()
  {
    if (this.caz.bSe)
    {
      dFD();
      if ((this.isCurrentActivity) || (this.zwO)) {
        onEnterEnd();
      }
    }
  }
  
  public final void dFT()
  {
    if ((this.caz.bSe) || (isFinishing()))
    {
      if ((Pi(8)) && (!isFinishing()) && (!dFY()))
      {
        ab.w("MicroMsg.BaseChattingUIFragment", "[onPause] is never doResume before doPause! Because while entering ChattingUI, the app back to background.");
        dFD();
        onEnterEnd();
      }
      dFF();
    }
  }
  
  public final void dFU()
  {
    if (((this.caz.bSe) || (isFinishing())) && (!dFZ()))
    {
      if (Pi(16))
      {
        ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s is never pause when stop coming!", new Object[] { this.zwL });
        dFF();
      }
      bDG();
    }
  }
  
  public final void dFV()
  {
    d(512, new BaseChattingUIFragment.1(this));
    dnu();
    onExitEnd();
  }
  
  public void dFX()
  {
    ab.i("MicroMsg.BaseChattingUIFragment", "[doDetach] activity:%s isPreLoaded:%b", new Object[] { this.zwL, Boolean.valueOf(this.zwO) });
    Iterator localIterator = this.caz.zJw.zOP.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry.getValue() instanceof w)) {
        ((w)localEntry.getValue()).dHq();
      }
    }
  }
  
  public final boolean dFY()
  {
    return (Pi(1024)) && (!Pi(512));
  }
  
  public abstract s dGa();
  
  public abstract boolean dGb();
  
  public com.tencent.mm.ui.chatting.l.a.a dGc()
  {
    return null;
  }
  
  public void dGd() {}
  
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
    com.tencent.mm.storage.ad localad = this.caz.txj;
    if ((localad == null) || ((int)localad.euF == 0) || (bo.isNullOrNil(localad.field_username))) {
      return "";
    }
    if (com.tencent.mm.kernel.g.RG())
    {
      if (f.lg(localad.field_username)) {
        return "_EnterpriseChat";
      }
      if (f.rX(localad.field_username)) {
        return "_EnterpriseFatherBiz";
      }
      if (f.rW(localad.field_username)) {
        return "_EnterpriseChildBiz";
      }
    }
    if (localad.dwz()) {
      return "_bizContact";
    }
    if (t.lA(localad.field_username)) {
      return "_chatroom";
    }
    if (t.nM(localad.field_username)) {
      return "_bottle";
    }
    if (t.nN(localad.field_username)) {
      return "_QQ";
    }
    return "";
  }
  
  public final int getLastVisiblePosition()
  {
    return getListView().getLastVisiblePosition();
  }
  
  public abstract ListView getListView();
  
  protected void ik(Context paramContext)
  {
    ab.i("MicroMsg.BaseChattingUIFragment", "[doAttach] activity:%s isPreLoaded:%b", new Object[] { this.zwL, Boolean.valueOf(this.zwO) });
  }
  
  public final void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    dFQ();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.BaseChattingUIFragment", "onActivityResult return, requestCode:%d resultCode:%s data is null? %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(bool) });
      if (this.caz.bSe) {
        break;
      }
      ab.w("MicroMsg.BaseChattingUIFragment", "[onActivityResult] not foreground, return, requestCode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = this.caz.zJx.getFragment();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.chatting.g.b.c((Fragment)localObject, paramInt1);
      if (localObject != null) {
        ((d.a)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
    this.zwN.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public final void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.zwK = (getActivity().getClass().getName() + "@" + hashCode() + " @talker:%s");
    ik(paramContext);
    this.caz.a(com.tencent.mm.ui.chatting.c.b.g.class, this.zwM);
    this.caz.a(k.class, this.zwN);
    paramContext = com.tencent.mm.ui.chatting.c.g.getComponents().iterator();
    while (paramContext.hasNext())
    {
      g.a locala = (g.a)paramContext.next();
      this.caz.a(locala.aqP, locala.dHT());
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.caz.bSe) {
      this.zwN.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    disableMultiTouch();
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
    ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onDestroy] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.zwL, Boolean.valueOf(this.caz.bSe), Boolean.valueOf(isFinishing()) });
    dFV();
  }
  
  public final void onDetach()
  {
    super.onDetach();
    dFX();
  }
  
  public void onEnterBegin()
  {
    d(128, new BaseChattingUIFragment.10(this));
  }
  
  public final void onEnterEnd()
  {
    d(256, new BaseChattingUIFragment.11(this));
  }
  
  public void onExitBegin()
  {
    d(512, new BaseChattingUIFragment.2(this));
  }
  
  public void onExitEnd()
  {
    d(1024, new BaseChattingUIFragment.3(this));
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.zwN.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void onPause()
  {
    super.onPause();
    ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onPause] activity:%s isForeground:%s isFinishing:%s isExiting:%s", new Object[] { this.zwL, Boolean.valueOf(this.caz.bSe), Boolean.valueOf(isFinishing()), Boolean.valueOf(dFY()) });
    dFT();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.zwN.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public final void onResume()
  {
    super.onResume();
    ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onResume] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.zwL, Boolean.valueOf(this.caz.bSe), Boolean.valueOf(isFinishing()) });
    dFS();
  }
  
  public final void onStart()
  {
    super.onStart();
    ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStart] activity:%s isForeground:%s isFinishing:%s", new Object[] { this.zwL, Boolean.valueOf(this.caz.bSe), Boolean.valueOf(isFinishing()) });
    dFR();
  }
  
  public final void onStop()
  {
    super.onStop();
    ab.w("MicroMsg.BaseChattingUIFragment.Sys", "[onStop] activity:%s isForeground:%s isFinishing:%s isEntering:%s", new Object[] { this.zwL, Boolean.valueOf(this.caz.bSe), Boolean.valueOf(isFinishing()), Boolean.valueOf(dFZ()) });
    dFU();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    if (this.isCurrentActivity) {
      return false;
    }
    com.tencent.mm.kernel.g.RM();
    if (com.tencent.mm.compatible.f.b.bI(((com.tencent.mm.kernel.b.h)com.tencent.mm.kernel.g.RI().Rj()).bX))
    {
      ab.w("MicroMsg.BaseChattingUIFragment", "Running on a Chromebook, so we not support swipeback and so on");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.BaseChattingUIFragment
 * JD-Core Version:    0.7.0.1
 */