package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.nfc.NfcAdapter;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AnimationUtils;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.g;
import com.tencent.mm.ac.a.h;
import com.tencent.mm.cm.a.b;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.ui.widget.g.a;
import com.tencent.mm.vending.e.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MMFragmentActivity
  extends AppCompatActivity
  implements SwipeBackLayout.a, g.a, com.tencent.mm.vending.e.b
{
  public static final long DURATION = 220L;
  private static final String TAG = "MicroMsg.MMFragmentActivity";
  String className;
  private a mActivityAnimStyle = new a();
  private View mContentViewForSwipeBack = null;
  private boolean mIsPaused;
  private com.tencent.mm.vending.a.a mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
  private b mNfcFilterHelper;
  private SwipeBackLayout mSwipeBackLayout;
  private boolean mSwiping;
  ArrayList<WeakReference<x>> record = new ArrayList();
  
  public boolean convertActivityFromTranslucent()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((isSupportNavigationSwipeBack()) && (paramKeyEvent.getKeyCode() == 4) && (getSwipeBackLayout().cnC()))
    {
      com.tencent.mm.sdk.platformtools.y.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public final boolean enableActivityAnimation()
  {
    return true;
  }
  
  public void finish()
  {
    super.finish();
    initActivityCloseAnimation();
  }
  
  public boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public x getCurrentFragmet()
  {
    int i = this.record.size();
    Object localObject;
    if (i == 0) {
      localObject = null;
    }
    x localx;
    do
    {
      return localObject;
      localx = (x)((WeakReference)this.record.get(i - 1)).get();
      if (localx == null) {
        break;
      }
      localObject = localx;
    } while (localx.isShowing());
    return null;
  }
  
  public Resources getResources()
  {
    if ((getAssets() != null) && (ae.getResources() != null)) {
      return ae.getResources();
    }
    return super.getResources();
  }
  
  public SwipeBackLayout getSwipeBackLayout()
  {
    return this.mSwipeBackLayout;
  }
  
  public Object getSystemService(String paramString)
  {
    Object localObject2 = super.getSystemService(paramString);
    Object localObject1 = localObject2;
    if ("layout_inflater".equals(paramString)) {
      localObject1 = y.a((LayoutInflater)localObject2);
    }
    return localObject1;
  }
  
  public void initActivityCloseAnimation()
  {
    if (enableActivityAnimation())
    {
      if (com.tencent.mm.ui.base.b.ab(getClass())) {
        super.overridePendingTransition(a.uOk, a.uOl);
      }
    }
    else {
      return;
    }
    if ((com.tencent.mm.ui.base.b.Z(getClass()) & 0x4) != 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      com.tencent.mm.ui.base.b.gK(this);
      return;
    }
    com.tencent.mm.ui.base.b.gL(this);
  }
  
  public void initActivityOpenAnimation(Intent paramIntent)
  {
    if (enableActivityAnimation())
    {
      if (paramIntent != null) {
        break label62;
      }
      paramIntent = null;
      if (paramIntent != null)
      {
        if (!paramIntent.getClassName().startsWith(paramIntent.getPackageName())) {
          break label70;
        }
        paramIntent = paramIntent.getClassName();
        label36:
        if ((com.tencent.mm.ui.base.b.adb(paramIntent) & 0x2) != 0) {
          break label98;
        }
      }
    }
    label62:
    label70:
    label98:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label103;
      }
      super.overridePendingTransition(a.uOi, a.uOj);
      return;
      paramIntent = paramIntent.getComponent();
      break;
      paramIntent = paramIntent.getPackageName() + paramIntent.getClassName();
      break label36;
    }
    label103:
    if ((com.tencent.mm.ui.base.b.adb(paramIntent) & 0x4) != 0) {}
    for (i = 1; i == 0; i = 0)
    {
      com.tencent.mm.ui.base.b.gI(this);
      return;
    }
    com.tencent.mm.ui.base.b.gL(this);
  }
  
  public boolean initNavigationSwipeBack()
  {
    if (com.tencent.mm.compatible.util.d.gF(19))
    {
      if ((!com.tencent.mm.ui.base.b.aa(getClass())) || (!convertActivityFromTranslucent())) {
        break label49;
      }
      com.tencent.mm.sdk.platformtools.ai.d(new Runnable()
      {
        public final void run()
        {
          com.tencent.mm.ui.base.b.ab(MMFragmentActivity.this);
        }
      });
    }
    label49:
    label85:
    while (isSupportNavigationSwipeBack())
    {
      initSwipeBack();
      return true;
      if ((com.tencent.mm.ui.base.b.Z(getClass()) & 0x10) != 0) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label85;
        }
        com.tencent.mm.sdk.platformtools.ai.d(new Runnable()
        {
          public final void run()
          {
            com.tencent.mm.ui.base.b.ab(MMFragmentActivity.this);
          }
        });
        break;
      }
    }
    return false;
  }
  
  public void initSwipeBack()
  {
    ViewGroup localViewGroup1 = (ViewGroup)getWindow().getDecorView();
    this.mSwipeBackLayout = ((SwipeBackLayout)LayoutInflater.from(this).inflate(a.h.swipeback_layout, localViewGroup1, false));
    this.mSwipeBackLayout.init();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.getChildAt(0);
    localViewGroup2.setBackgroundResource(a.d.transparent);
    localViewGroup1.removeView(localViewGroup2);
    this.mSwipeBackLayout.addView(localViewGroup2);
    this.mSwipeBackLayout.setContentView(localViewGroup2);
    localViewGroup1.addView(this.mSwipeBackLayout);
    this.mSwipeBackLayout.setSwipeGestureDelegate(this);
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (com.tencent.mm.compatible.util.d.gF(19))
    {
      bool1 = bool2;
      if (com.tencent.mm.compatible.i.a.zD())
      {
        bool1 = bool2;
        if (supportNavigationSwipeBack())
        {
          bool1 = bool2;
          if (com.tencent.mm.ui.base.b.aa(getClass())) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isSwiping()
  {
    return this.mSwiping;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    this.mLifeCycleKeeper.wsJ.keep(parama);
  }
  
  public void onCancel()
  {
    this.mSwiping = false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (getSupportActionBar() != null)
    {
      paramConfiguration = (ViewGroup)findViewById(a.g.decor_content_parent);
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.findViewById(a.g.action_bar);
        if ((paramConfiguration != null) && ((paramConfiguration instanceof Toolbar)))
        {
          paramConfiguration = (Toolbar)paramConfiguration;
          ViewGroup.LayoutParams localLayoutParams = paramConfiguration.getLayoutParams();
          if (localLayoutParams != null) {
            localLayoutParams.height = com.tencent.mm.compatible.util.a.bh(this);
          }
          paramConfiguration.setLayoutParams(localLayoutParams);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.className = getClass().getName();
    ai.be(3, this.className);
    super.onCreate(paramBundle);
    this.mNfcFilterHelper = new b((byte)0);
    paramBundle = this.mNfcFilterHelper;
    try
    {
      paramBundle.uOm = NfcAdapter.getDefaultAdapter(paramBundle.uOd);
      paramBundle.init();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMFragmentActivity", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    this.mLifeCycleKeeper.wsJ.dead();
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    try
    {
      if (com.tencent.mm.cm.a.a.fzJ == null)
      {
        localObject = Class.forName("android.rms.iaware.FastgrabConfigReader");
        com.tencent.mm.cm.a.a.fzJ = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredField("mFastgrabConfigReader");
        com.tencent.mm.cm.a.a.field_mFastgrabConfigReader = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        localObject = com.tencent.mm.cm.a.a.fzJ.getDeclaredField("mContext");
        com.tencent.mm.cm.a.a.field_mContext = (Field)localObject;
        ((Field)localObject).setAccessible(true);
      }
      localObject = com.tencent.mm.cm.a.a.field_mFastgrabConfigReader.get(com.tencent.mm.cm.a.a.fzJ);
      if (com.tencent.mm.cm.a.a.field_mContext.get(localObject) == this) {
        com.tencent.mm.cm.a.a.field_mContext.set(localObject, null);
      }
    }
    catch (Throwable localThrowable3)
    {
      Object localObject;
      label112:
      break label112;
    }
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    for (;;)
    {
      try
      {
        if (a.b.aov == null)
        {
          localObject = Class.forName("android.gestureboost.GestureBoostManager");
          a.b.aov = (Class)localObject;
          localObject = ((Class)localObject).getDeclaredField("sGestureBoostManager");
          a.b.pGl = (Field)localObject;
          ((Field)localObject).setAccessible(true);
          localObject = a.b.aov.getDeclaredField("mContext");
          a.b.pGm = (Field)localObject;
          ((Field)localObject).setAccessible(true);
        }
        localObject = a.b.pGl.get(null);
        if (localObject != null) {
          a.b.pGm.set(localObject, null);
        }
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      try
      {
        if ((Build.VERSION.SDK_INT >= 23) && (Build.MANUFACTURER.equals("samsung")))
        {
          localObject = ae.getContext().getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
          Field localField = localObject.getClass().getDeclaredField("mContext");
          localField.setAccessible(true);
          localField.set(localObject, null);
        }
        super.onDestroy();
        return;
      }
      catch (Throwable localThrowable1) {}
    }
  }
  
  public void onDrag()
  {
    this.mSwiping = true;
  }
  
  public void onPause()
  {
    ai.be(2, this.className);
    this.mIsPaused = true;
    super.onPause();
    if (isSupportNavigationSwipeBack())
    {
      if (getSwipeBackLayout() != null) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      if (!isFinishing()) {
        g.a(this);
      }
    }
    b localb;
    if (this.mNfcFilterHelper != null)
    {
      localb = this.mNfcFilterHelper;
      if (localb.uOm == null) {}
    }
    try
    {
      localb.uOm.disableForegroundDispatch(localb.uOd);
      this.mLifeCycleKeeper.wsK.dead();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMFragmentActivity", "lo-nfc-onPause: exp:" + localException.getLocalizedMessage());
      }
    }
  }
  
  public void onResume()
  {
    ai.be(1, this.className);
    this.mIsPaused = false;
    super.onResume();
    if (isSupportNavigationSwipeBack())
    {
      g.b(this);
      onSwipe(1.0F);
      if (getSwipeBackLayout() != null)
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().wlh = false;
      }
    }
    b localb;
    if (this.mNfcFilterHelper != null)
    {
      localb = this.mNfcFilterHelper;
      if (localb.uOm != null) {
        if ((localb.mPendingIntent == null) || (localb.uOn == null) || (localb.uOo == null)) {
          localb.init();
        }
      }
    }
    try
    {
      localb.uOm.enableForegroundDispatch(localb.uOd, localb.mPendingIntent, localb.uOn, localb.uOo);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMFragmentActivity", "lo-nfc-onResume: exp:" + localException.getLocalizedMessage());
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 11) {
      super.onSaveInstanceState(paramBundle);
    }
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 110L;
    com.tencent.mm.sdk.platformtools.y.v("ashutest", "ashutest:: on settle %B, speed %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.mContentViewForSwipeBack == null) {
      this.mContentViewForSwipeBack = ak.a(getWindow(), getSupportActionBar().getCustomView());
    }
    View localView = this.mContentViewForSwipeBack;
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        h.a(localView, l, 0.0F, null);
        return;
        l = 220L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      h.a(localView, l, localView.getWidth() * -1 / 2.5F, null);
      return;
      l = 220L;
    }
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onStop()
  {
    this.mLifeCycleKeeper.wsL.dead();
    super.onStop();
  }
  
  public void onSwipe(float paramFloat)
  {
    com.tencent.mm.sdk.platformtools.y.v("ashutest", "ashutest::on swipe %f, duration %d", new Object[] { Float.valueOf(paramFloat), Long.valueOf(220L) });
    Window localWindow;
    if (this.mContentViewForSwipeBack == null)
    {
      localWindow = getWindow();
      if (getSupportActionBar() == null) {
        break label83;
      }
    }
    label83:
    for (View localView = getSupportActionBar().getCustomView();; localView = null)
    {
      this.mContentViewForSwipeBack = ak.a(localWindow, localView);
      localView = this.mContentViewForSwipeBack;
      if (Float.compare(1.0F, paramFloat) > 0) {
        break;
      }
      h.q(localView, 0.0F);
      return;
    }
    h.q(localView, localView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
  }
  
  public void onSwipeBack()
  {
    if (!isFinishing()) {
      finish();
    }
    getWindow().getDecorView().setVisibility(8);
    overridePendingTransition(0, 0);
    this.mSwiping = false;
  }
  
  public boolean popBackStackImmediate()
  {
    if (this.record.size() == 0) {
      return false;
    }
    this.record.remove(this.record.size() - 1);
    return getSupportFragmentManager().popBackStackImmediate();
  }
  
  public void putActivityCloseAnimation(int paramInt1, int paramInt2)
  {
    if (enableActivityAnimation())
    {
      a.uOk = paramInt1;
      a.uOl = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  public void putActivityOpenAnimation(int paramInt1, int paramInt2)
  {
    if (enableActivityAnimation())
    {
      a.uOi = paramInt1;
      a.uOj = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
  }
  
  @TargetApi(11)
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    super.startActivities(paramArrayOfIntent);
    initActivityOpenAnimation(null);
  }
  
  @TargetApi(16)
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    if (d.a(this, this.mIsPaused, paramArrayOfIntent, new Object[] { paramBundle })) {
      return;
    }
    super.startActivities(paramArrayOfIntent, paramBundle);
    initActivityOpenAnimation(null);
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
    initActivityOpenAnimation(paramIntent);
  }
  
  @TargetApi(16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    super.startActivity(paramIntent, paramBundle);
    initActivityOpenAnimation(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    super.startActivityForResult(paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
  }
  
  @TargetApi(16)
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (d.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { Integer.valueOf(paramInt), paramBundle })) {
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    initActivityOpenAnimation(paramIntent);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (d.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { paramFragment, Integer.valueOf(paramInt) })) {
      return;
    }
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    if ((getCurrentFragmet() != null) && (getCurrentFragmet().interceptSupportInvalidateOptionsMenu())) {
      return;
    }
    super.supportInvalidateOptionsMenu();
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return true;
  }
  
  public void switchFragment(Fragment paramFragment, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    if ((paramFragment == null) || (paramInt1 == 0)) {
      return;
    }
    j localj = getSupportFragmentManager();
    o localo = localj.bP();
    if (paramBoolean2) {
      localo.m(paramInt2, paramInt3);
    }
    if (localj.Z(paramInt1) != null) {
      if (paramFragment.isHidden()) {
        localo.b(paramFragment);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        localo.bI();
      }
      localo.commit();
      localj.executePendingTransactions();
      return;
      localo.a(paramInt1, paramFragment, paramFragment.getTag());
    }
  }
  
  public void switchFragmentActivity(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    switchFragmentActivity(paramFragment, paramFragment.getId());
  }
  
  public void switchFragmentActivity(Fragment paramFragment, int paramInt)
  {
    switchFragment(paramFragment, paramInt, true, true, com.tencent.mm.ac.a.a.pop_in, com.tencent.mm.ac.a.a.pop_out);
    this.record.add(new WeakReference((x)paramFragment));
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment)
  {
    switchFragmentInternalBackwardWithAnim(paramFragment, paramFragment.getId());
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment, int paramInt)
  {
    switchFragment(paramFragment, paramInt, false, true, com.tencent.mm.ac.a.a.slide_left_in, com.tencent.mm.ac.a.a.slide_right_out);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, int paramInt, View paramView)
  {
    switchFragment(paramFragment, paramInt, false, true, 0, com.tencent.mm.ac.a.a.slide_right_out);
    if (paramView == null) {
      return;
    }
    paramFragment = AnimationUtils.loadAnimation(this, com.tencent.mm.ac.a.a.slide_left_in);
    if (paramFragment != null) {
      paramView.startAnimation(paramFragment);
    }
    paramView.setVisibility(0);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, View paramView)
  {
    if (paramFragment == null) {
      return;
    }
    switchFragmentInternalBackwardWithAnimLeftSelfView(paramFragment, paramFragment.getId(), paramView);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    switchFragmentInternalFarwardWithAnim(paramFragment, paramFragment.getId());
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment, int paramInt)
  {
    switchFragment(paramFragment, paramInt, false, true, com.tencent.mm.ac.a.a.slide_right_in, com.tencent.mm.ac.a.a.slide_left_out);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return;
    }
    switchFragmentInternalWithoutAnim(paramFragment, paramFragment.getId());
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment, int paramInt)
  {
    switchFragment(paramFragment, paramInt, false, false, 0, 0);
  }
  
  protected com.tencent.mm.vending.e.b theCreate()
  {
    return this.mLifeCycleKeeper.wsJ;
  }
  
  protected com.tencent.mm.vending.e.b theResume()
  {
    return this.mLifeCycleKeeper.wsK;
  }
  
  protected com.tencent.mm.vending.e.b theStart()
  {
    return this.mLifeCycleKeeper.wsK;
  }
  
  public static final class a
  {
    public static int uOe;
    public static int uOf;
    public static int uOg;
    public static int uOh;
    public static int uOi;
    public static int uOj;
    public static int uOk;
    public static int uOl;
    
    static
    {
      boolean bool2 = com.tencent.mm.compatible.util.d.gF(19);
      boolean bool1 = com.tencent.mm.compatible.i.a.zD() & bool2;
      if (bool1)
      {
        i = com.tencent.mm.ac.a.a.slide_right_in;
        uOe = i;
        if (!bool1) {
          break label92;
        }
        i = com.tencent.mm.ac.a.a.slide_left_out;
        label32:
        uOf = i;
        if (!bool1) {
          break label99;
        }
        i = com.tencent.mm.ac.a.a.slide_left_in;
        label44:
        uOg = i;
        if (!bool1) {
          break label106;
        }
      }
      label92:
      label99:
      label106:
      for (int i = com.tencent.mm.ac.a.a.slide_right_out;; i = com.tencent.mm.ac.a.a.pop_out)
      {
        uOh = i;
        uOi = uOe;
        uOj = uOf;
        uOk = uOg;
        uOl = uOh;
        return;
        i = com.tencent.mm.ac.a.a.pop_in;
        break;
        i = com.tencent.mm.ac.a.a.anim_not_change;
        break label32;
        i = com.tencent.mm.ac.a.a.anim_not_change;
        break label44;
      }
    }
    
    public static void czF()
    {
      u localu = q.dyi;
      boolean bool = u.zw();
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle swipbackType = " + bool);
      if (!bool) {
        return;
      }
      bool = com.tencent.mm.compatible.util.d.gF(19);
      bool = com.tencent.mm.compatible.i.a.zD() & bool;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle supportSwipe = " + bool);
      if (bool)
      {
        i = com.tencent.mm.ac.a.a.slide_right_in;
        uOe = i;
        if (!bool) {
          break label147;
        }
        i = com.tencent.mm.ac.a.a.slide_left_out;
        label87:
        uOf = i;
        if (!bool) {
          break label154;
        }
        i = com.tencent.mm.ac.a.a.slide_left_in;
        label99:
        uOg = i;
        if (!bool) {
          break label161;
        }
      }
      label147:
      label154:
      label161:
      for (int i = com.tencent.mm.ac.a.a.slide_right_out;; i = com.tencent.mm.ac.a.a.pop_out)
      {
        uOh = i;
        uOi = uOe;
        uOj = uOf;
        uOk = uOg;
        uOl = uOh;
        return;
        i = com.tencent.mm.ac.a.a.pop_in;
        break;
        i = com.tencent.mm.ac.a.a.anim_not_change;
        break label87;
        i = com.tencent.mm.ac.a.a.anim_not_change;
        break label99;
      }
    }
  }
  
  private final class b
  {
    PendingIntent mPendingIntent;
    NfcAdapter uOm = null;
    IntentFilter[] uOn;
    String[][] uOo;
    
    private b() {}
    
    final void init()
    {
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(ae.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
      ((Intent)localObject).addFlags(536870912);
      this.mPendingIntent = PendingIntent.getActivity(MMFragmentActivity.this, 0, (Intent)localObject, 0);
      localObject = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
      try
      {
        ((IntentFilter)localObject).addDataType("*/*");
        IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TECH_DISCOVERED");
        localIntentFilter.addDataScheme("vnd.android.nfc");
        this.uOn = new IntentFilter[] { localObject, localIntentFilter, new IntentFilter("android.nfc.action.TAG_DISCOVERED") };
        this.uOo = new String[][] { { NfcA.class.getName(), IsoDep.class.getName() } };
        return;
      }
      catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
      {
        throw new RuntimeException("fail", localMalformedMimeTypeException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity
 * JD-Core Version:    0.7.0.1
 */