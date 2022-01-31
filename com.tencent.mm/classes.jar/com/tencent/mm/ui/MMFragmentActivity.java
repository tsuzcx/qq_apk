package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
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
import android.os.Debug;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.b.a;
import com.tencent.mm.ac.b.b;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.h;
import com.tencent.mm.ui.widget.h.a;
import com.tencent.mm.vending.e.c;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MMFragmentActivity
  extends AppCompatActivity
  implements SwipeBackLayout.a, h.a, com.tencent.mm.vending.e.b
{
  public static final long ANIMATION_DURATION = 320L;
  public static final String EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM = "extra_use_system_default_enter_exit_anim";
  private static final String TAG = "MicroMsg.MMFragmentActivity";
  public static final float WIDTH_SETTLE_FACT = 3.5F;
  String className;
  private Resources customResources;
  private a mActivityAnimStyle;
  private View mContentViewForSwipeBack;
  private boolean mIsPaused;
  private com.tencent.mm.vending.a.a mLifeCycleKeeper;
  private b mNfcFilterHelper;
  private SwipeBackLayout mSwipeBackLayout;
  private boolean mSwiping;
  ArrayList<WeakReference<MMFragment>> record;
  private boolean updateResource;
  
  public MMFragmentActivity()
  {
    AppMethodBeat.i(106054);
    this.record = new ArrayList();
    this.mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
    this.mActivityAnimStyle = new a();
    this.updateResource = false;
    this.mContentViewForSwipeBack = null;
    AppMethodBeat.o(106054);
  }
  
  public String appendMemLog()
  {
    AppMethodBeat.i(106057);
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    String str = String.format("Runtime: [%s:%s:%s] Native: [%s:%s:%s] ", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l1 - l2), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Debug.getNativeHeapAllocatedSize()), Long.valueOf(Debug.getNativeHeapFreeSize()) });
    AppMethodBeat.o(106057);
    return str;
  }
  
  protected boolean convertActivityFromTranslucent()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(106100);
    if (isSupportNavigationSwipeBack())
    {
      SwipeBackLayout localSwipeBackLayout = getSwipeBackLayout();
      if ((paramKeyEvent.getKeyCode() == 4) && (localSwipeBackLayout != null) && (localSwipeBackLayout.doA()))
      {
        ab.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
        AppMethodBeat.o(106100);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(106100);
    return bool;
  }
  
  public boolean enableActivityAnimation()
  {
    AppMethodBeat.i(106079);
    Intent localIntent = getIntent();
    if (localIntent != null) {}
    for (boolean bool = com.tencent.mm.sdk.platformtools.w.a(localIntent, "extra_use_system_default_enter_exit_anim", false);; bool = false)
    {
      if (bool)
      {
        AppMethodBeat.o(106079);
        return false;
      }
      AppMethodBeat.o(106079);
      return true;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(106082);
    super.finish();
    initActivityCloseAnimation();
    AppMethodBeat.o(106082);
  }
  
  public boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public MMFragment getCurrentFragmet()
  {
    AppMethodBeat.i(106075);
    int i = this.record.size();
    if (i == 0)
    {
      AppMethodBeat.o(106075);
      return null;
    }
    MMFragment localMMFragment = (MMFragment)((WeakReference)this.record.get(i - 1)).get();
    if ((localMMFragment != null) && (localMMFragment.isShowing()))
    {
      AppMethodBeat.o(106075);
      return localMMFragment;
    }
    AppMethodBeat.o(106075);
    return null;
  }
  
  public final Resources getOriginalResources()
  {
    AppMethodBeat.i(155335);
    Resources localResources = super.getResources();
    AppMethodBeat.o(155335);
    return localResources;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(106096);
    if ((ah.getContext().getAssets() != null) && (ah.getResources() != null))
    {
      if ((!this.updateResource) || (this.customResources == null))
      {
        Object localObject2 = getBaseContext().getResources();
        this.customResources = ah.getResources();
        if (((this.customResources instanceof com.tencent.mm.cc.b)) && (localObject2 != null))
        {
          localObject1 = (com.tencent.mm.cc.b)this.customResources;
          localObject2 = ((com.tencent.mm.cc.b)localObject1).yjj.c(((Resources)localObject2).getConfiguration());
          ((com.tencent.mm.cc.b)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
          this.customResources = ((Resources)localObject1);
          this.updateResource = true;
        }
      }
      localObject1 = this.customResources;
      AppMethodBeat.o(106096);
      return localObject1;
    }
    Object localObject1 = super.getResources();
    AppMethodBeat.o(106096);
    return localObject1;
  }
  
  public SwipeBackLayout getSwipeBackLayout()
  {
    return this.mSwipeBackLayout;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(106095);
    if (("clipboard".equals(paramString)) && (getApplicationContext() != null))
    {
      paramString = getApplicationContext().getSystemService(paramString);
      AppMethodBeat.o(106095);
      return paramString;
    }
    Object localObject = super.getSystemService(paramString);
    if ("layout_inflater".equals(paramString))
    {
      paramString = w.b((LayoutInflater)localObject);
      AppMethodBeat.o(106095);
      return paramString;
    }
    AppMethodBeat.o(106095);
    return localObject;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(156397);
    try
    {
      Object localObject = new Throwable().getStackTrace();
      if ((localObject != null) && (localObject.length >= 2) && (localObject[1].getMethodName().equals("handleDestroyActivity")))
      {
        localObject = com.tencent.mm.plugin.crashfix.b.a.a.a(super.getWindowManager());
        AppMethodBeat.o(156397);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.MMFragmentActivity", localThrowable.getMessage());
      WindowManager localWindowManager = super.getWindowManager();
      AppMethodBeat.o(156397);
      return localWindowManager;
    }
  }
  
  protected void initActivityCloseAnimation()
  {
    AppMethodBeat.i(106081);
    if (enableActivityAnimation())
    {
      if (com.tencent.mm.ui.base.b.ax(getClass()))
      {
        super.overridePendingTransition(a.zcd, a.zce);
        AppMethodBeat.o(106081);
        return;
      }
      if ((com.tencent.mm.ui.base.b.au(getClass()) & 0x4) != 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        com.tencent.mm.ui.base.b.ig(this);
        AppMethodBeat.o(106081);
        return;
      }
      com.tencent.mm.ui.base.b.ih(this);
    }
    AppMethodBeat.o(106081);
  }
  
  protected void initActivityOpenAnimation(Intent paramIntent)
  {
    AppMethodBeat.i(106080);
    if (enableActivityAnimation())
    {
      if (paramIntent == null)
      {
        paramIntent = null;
        if (paramIntent == null) {
          break label95;
        }
        paramIntent = com.tencent.mm.ui.base.b.e(paramIntent);
        if ((com.tencent.mm.ui.base.b.atu(paramIntent) & 0x2) != 0) {
          break label68;
        }
      }
      label68:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label73;
        }
        super.overridePendingTransition(a.zcb, a.zcc);
        AppMethodBeat.o(106080);
        return;
        paramIntent = paramIntent.getComponent();
        break;
      }
      label73:
      if (!com.tencent.mm.ui.base.b.atw(paramIntent))
      {
        com.tencent.mm.ui.base.b.ie(this);
        AppMethodBeat.o(106080);
        return;
      }
      com.tencent.mm.ui.base.b.ih(this);
    }
    label95:
    AppMethodBeat.o(106080);
  }
  
  public boolean initNavigationSwipeBack()
  {
    AppMethodBeat.i(106093);
    if (com.tencent.mm.compatible.util.d.fv(19))
    {
      if ((!com.tencent.mm.ui.base.b.aw(getClass())) || (!convertActivityFromTranslucent())) {
        break label60;
      }
      if (al.isMainThread()) {
        com.tencent.mm.ui.base.b.aD(this);
      }
    }
    label60:
    label95:
    while (isSupportNavigationSwipeBack())
    {
      initSwipeBack();
      AppMethodBeat.o(106093);
      return true;
      if ((com.tencent.mm.ui.base.b.au(getClass()) & 0x10) != 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!al.isMainThread())) {
          break label95;
        }
        com.tencent.mm.ui.base.b.aD(this);
        break;
      }
    }
    AppMethodBeat.o(106093);
    return false;
  }
  
  protected void initSwipeBack()
  {
    AppMethodBeat.i(106094);
    ViewGroup localViewGroup1 = (ViewGroup)getWindow().getDecorView();
    this.mSwipeBackLayout = ((SwipeBackLayout)LayoutInflater.from(this).inflate(2130970980, localViewGroup1, false));
    this.mSwipeBackLayout.init();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.getChildAt(0);
    localViewGroup2.setBackgroundResource(2131690605);
    localViewGroup1.removeView(localViewGroup2);
    this.mSwipeBackLayout.addView(localViewGroup2);
    this.mSwipeBackLayout.setContentView(localViewGroup2);
    localViewGroup1.addView(this.mSwipeBackLayout);
    this.mSwipeBackLayout.setSwipeGestureDelegate(this);
    AppMethodBeat.o(106094);
  }
  
  public boolean isHideStatusBar()
  {
    AppMethodBeat.i(106092);
    if ((com.tencent.mm.ui.base.b.au(getClass()) & 0x20) != 0)
    {
      AppMethodBeat.o(106092);
      return true;
    }
    AppMethodBeat.o(106092);
    return false;
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public final boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(106091);
    if ((com.tencent.mm.compatible.util.d.fv(19)) && (com.tencent.mm.compatible.i.b.Mg()))
    {
      if ((supportNavigationSwipeBack()) && (com.tencent.mm.ui.base.b.aw(getClass())))
      {
        AppMethodBeat.o(106091);
        return true;
      }
      AppMethodBeat.o(106091);
      return false;
    }
    AppMethodBeat.o(106091);
    return false;
  }
  
  public boolean isSwiping()
  {
    return this.mSwiping;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(106055);
    this.mLifeCycleKeeper.ANE.keep(parama);
    AppMethodBeat.o(106055);
  }
  
  public void onCancel()
  {
    this.mSwiping = false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106101);
    super.onConfigurationChanged(paramConfiguration);
    if (getSupportActionBar() != null)
    {
      paramConfiguration = (ViewGroup)findViewById(2131820955);
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.findViewById(2131820957);
        if ((paramConfiguration != null) && ((paramConfiguration instanceof Toolbar)))
        {
          paramConfiguration = (Toolbar)paramConfiguration;
          ViewGroup.LayoutParams localLayoutParams = paramConfiguration.getLayoutParams();
          if (localLayoutParams != null) {
            localLayoutParams.height = com.tencent.mm.compatible.util.a.bL(this);
          }
          paramConfiguration.setLayoutParams(localLayoutParams);
        }
      }
    }
    AppMethodBeat.o(106101);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106056);
    this.className = getClass().getName();
    ad.bK(3, this.className);
    super.onCreate(paramBundle);
    this.mNfcFilterHelper = new b((byte)0);
    paramBundle = this.mNfcFilterHelper;
    try
    {
      paramBundle.zcf = NfcAdapter.getDefaultAdapter(paramBundle.zcj);
      paramBundle.init();
      ab.i("MicroMsg.MMFragmentActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s appendMemLog:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bo.hm(this), appendMemLog() });
      AppMethodBeat.o(106056);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.MMFragmentActivity", localThrowable, "", new Object[0]);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106058);
    ab.i("MicroMsg.MMFragmentActivity", "checktask onDestroy:%s#0x%x task:%s appendMemLog:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), bo.hm(this), appendMemLog() });
    this.mLifeCycleKeeper.ANE.dead();
    super.onDestroy();
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    try
    {
      if (b.a.eMx == null)
      {
        localObject = Class.forName("android.rms.iaware.FastgrabConfigReader");
        b.a.eMx = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredField("mFastgrabConfigReader");
        b.a.field_mFastgrabConfigReader = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        localObject = b.a.eMx.getDeclaredField("mContext");
        b.a.field_mContext = (Field)localObject;
        ((Field)localObject).setAccessible(true);
      }
      localObject = b.a.field_mFastgrabConfigReader.get(b.a.eMx);
      if (b.a.field_mContext.get(localObject) == this) {
        b.a.field_mContext.set(localObject, null);
      }
    }
    catch (Throwable localThrowable3)
    {
      Object localObject;
      label168:
      break label168;
    }
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    for (;;)
    {
      try
      {
        if (b.b.aqP == null)
        {
          localObject = Class.forName("android.gestureboost.GestureBoostManager");
          b.b.aqP = (Class)localObject;
          localObject = ((Class)localObject).getDeclaredField("sGestureBoostManager");
          b.b.eMy = (Field)localObject;
          ((Field)localObject).setAccessible(true);
          localObject = b.b.aqP.getDeclaredField("mContext");
          b.b.eMz = (Field)localObject;
          ((Field)localObject).setAccessible(true);
        }
        localObject = b.b.eMy.get(null);
        if (localObject != null) {
          b.b.eMz.set(localObject, null);
        }
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      try
      {
        if ((Build.VERSION.SDK_INT >= 23) && (Build.MANUFACTURER.equalsIgnoreCase("samsung")))
        {
          localObject = ah.getContext().getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
          Field localField = localObject.getClass().getDeclaredField("mContext");
          localField.setAccessible(true);
          localField.set(localObject, ah.getContext());
        }
        ab.i("MicroMsg.MMFragmentActivity", "Activity dump [%s]", new Object[] { com.tencent.mm.ac.a.SU() });
        AppMethodBeat.o(106058);
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
    AppMethodBeat.i(106061);
    ad.bK(2, this.className);
    this.mIsPaused = true;
    super.onPause();
    if (isSupportNavigationSwipeBack())
    {
      if (getSwipeBackLayout() != null) {
        getSwipeBackLayout().setEnableGesture(false);
      }
      if (!isFinishing()) {
        h.a(this);
      }
    }
    b localb;
    if (this.mNfcFilterHelper != null)
    {
      localb = this.mNfcFilterHelper;
      if (localb.zcf == null) {}
    }
    try
    {
      localb.zcf.disableForegroundDispatch(localb.zcj);
      this.mLifeCycleKeeper.ANF.dead();
      AppMethodBeat.o(106061);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.MMFragmentActivity", "lo-nfc-onPause: exp:" + localException.getLocalizedMessage());
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(106062);
    ad.bK(1, this.className);
    this.mIsPaused = false;
    super.onResume();
    if (isSupportNavigationSwipeBack())
    {
      h.b(this);
      onSwipe(1.0F);
      if (getSwipeBackLayout() != null)
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().AEZ = false;
      }
    }
    if (this.mNfcFilterHelper != null)
    {
      b localb = this.mNfcFilterHelper;
      if (localb.zcf != null)
      {
        if ((localb.zcg == null) || (localb.zch == null) || (localb.zci == null)) {
          localb.init();
        }
        try
        {
          localb.zcf.enableForegroundDispatch(localb.zcj, localb.zcg, localb.zch, localb.zci);
          AppMethodBeat.o(106062);
          return;
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.MMFragmentActivity", "lo-nfc-onResume: exp:" + localException.getLocalizedMessage());
        }
      }
    }
    AppMethodBeat.o(106062);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(106076);
    if (Build.VERSION.SDK_INT < 11) {
      super.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(106076);
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 160L;
    AppMethodBeat.i(106098);
    ab.v("ashutest", "ashutest:: on settle %B, speed %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.mContentViewForSwipeBack == null) {
      this.mContentViewForSwipeBack = af.a(getWindow(), getSupportActionBar().getCustomView());
    }
    View localView = this.mContentViewForSwipeBack;
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localView, l, 0.0F, null);
        AppMethodBeat.o(106098);
        return;
        l = 320L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      j.a(localView, l, localView.getWidth() * -1 / 3.5F, null);
      AppMethodBeat.o(106098);
      return;
      l = 320L;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(106060);
    super.onStart();
    AppMethodBeat.o(106060);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(106059);
    this.mLifeCycleKeeper.ANG.dead();
    super.onStop();
    AppMethodBeat.o(106059);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(106097);
    ab.v("ashutest", "ashutest::on swipe %f, duration %d", new Object[] { Float.valueOf(paramFloat), Long.valueOf(320L) });
    Window localWindow;
    if (this.mContentViewForSwipeBack == null)
    {
      localWindow = getWindow();
      if (getSupportActionBar() == null) {
        break label95;
      }
    }
    label95:
    for (View localView = getSupportActionBar().getCustomView();; localView = null)
    {
      this.mContentViewForSwipeBack = af.a(localWindow, localView);
      localView = this.mContentViewForSwipeBack;
      if (Float.compare(1.0F, paramFloat) > 0) {
        break;
      }
      j.t(localView, 0.0F);
      AppMethodBeat.o(106097);
      return;
    }
    j.t(localView, localView.getWidth() / 3.5F * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(106097);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(106099);
    if (!isFinishing()) {
      finish();
    }
    getWindow().getDecorView().setVisibility(8);
    overridePendingTransition(0, 0);
    this.mSwiping = false;
    AppMethodBeat.o(106099);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean popBackStackImmediate()
  {
    AppMethodBeat.i(106073);
    if (this.record.size() == 0)
    {
      AppMethodBeat.o(106073);
      return false;
    }
    this.record.remove(this.record.size() - 1);
    boolean bool = getSupportFragmentManager().popBackStackImmediate();
    AppMethodBeat.o(106073);
    return bool;
  }
  
  public void putActivityCloseAnimation(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106078);
    if (enableActivityAnimation())
    {
      a.zcd = paramInt1;
      a.zce = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(106078);
  }
  
  public void putActivityOpenAnimation(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106077);
    if (enableActivityAnimation())
    {
      a.zcb = paramInt1;
      a.zcc = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(106077);
  }
  
  @TargetApi(11)
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    AppMethodBeat.i(106084);
    super.startActivities(paramArrayOfIntent);
    initActivityOpenAnimation(null);
    AppMethodBeat.o(106084);
  }
  
  @TargetApi(16)
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(106083);
    if (d.a(this, this.mIsPaused, paramArrayOfIntent, new Object[] { paramBundle }))
    {
      AppMethodBeat.o(106083);
      return;
    }
    super.startActivities(paramArrayOfIntent, paramBundle);
    initActivityOpenAnimation(null);
    AppMethodBeat.o(106083);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(106085);
    super.startActivity(paramIntent);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(106085);
  }
  
  @TargetApi(16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(106086);
    super.startActivity(paramIntent, paramBundle);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(106086);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(106087);
    super.startActivityForResult(paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(106087);
  }
  
  @TargetApi(16)
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(106088);
    if (d.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { Integer.valueOf(paramInt), paramBundle }))
    {
      AppMethodBeat.o(106088);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(106088);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(106089);
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(106089);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(106090);
    if (d.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { paramFragment, Integer.valueOf(paramInt) }))
    {
      AppMethodBeat.o(106090);
      return;
    }
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(106090);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(106102);
    if ((getCurrentFragmet() != null) && (getCurrentFragmet().interceptSupportInvalidateOptionsMenu()))
    {
      AppMethodBeat.o(106102);
      return;
    }
    super.supportInvalidateOptionsMenu();
    AppMethodBeat.o(106102);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return true;
  }
  
  public void switchFragment(Fragment paramFragment, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(106074);
    if ((paramFragment == null) || (paramInt1 == 0))
    {
      AppMethodBeat.o(106074);
      return;
    }
    g localg = getSupportFragmentManager();
    k localk = localg.beginTransaction();
    if (paramBoolean2) {
      localk.m(paramInt2, paramInt3);
    }
    if (localg.findFragmentById(paramInt1) != null) {
      if (paramFragment.isHidden()) {
        localk.c(paramFragment);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        localk.F(null);
      }
      localk.commit();
      localg.executePendingTransactions();
      AppMethodBeat.o(106074);
      return;
      localk.a(paramInt1, paramFragment, paramFragment.getTag());
    }
  }
  
  public void switchFragmentActivity(Fragment paramFragment)
  {
    AppMethodBeat.i(106071);
    if (paramFragment == null)
    {
      AppMethodBeat.o(106071);
      return;
    }
    switchFragmentActivity(paramFragment, paramFragment.getId());
    AppMethodBeat.o(106071);
  }
  
  public void switchFragmentActivity(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(106072);
    switchFragment(paramFragment, paramInt, true, true, 2131034217, 2131034222);
    this.record.add(new WeakReference((MMFragment)paramFragment));
    AppMethodBeat.o(106072);
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(106067);
    switchFragmentInternalBackwardWithAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(106067);
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(106068);
    switchFragment(paramFragment, paramInt, false, true, 2131034262, 2131034267);
    AppMethodBeat.o(106068);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, int paramInt, View paramView)
  {
    AppMethodBeat.i(106070);
    switchFragment(paramFragment, paramInt, false, true, 0, 2131034267);
    if (paramView == null)
    {
      AppMethodBeat.o(106070);
      return;
    }
    paramFragment = AnimationUtils.loadAnimation(this, 2131034262);
    if (paramFragment != null) {
      paramView.startAnimation(paramFragment);
    }
    paramView.setVisibility(0);
    AppMethodBeat.o(106070);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, View paramView)
  {
    AppMethodBeat.i(106069);
    if (paramFragment == null)
    {
      AppMethodBeat.o(106069);
      return;
    }
    switchFragmentInternalBackwardWithAnimLeftSelfView(paramFragment, paramFragment.getId(), paramView);
    AppMethodBeat.o(106069);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(106065);
    if (paramFragment == null)
    {
      AppMethodBeat.o(106065);
      return;
    }
    switchFragmentInternalFarwardWithAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(106065);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(106066);
    switchFragment(paramFragment, paramInt, false, true, 2131034266, 2131034263);
    AppMethodBeat.o(106066);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(106063);
    if (paramFragment == null)
    {
      AppMethodBeat.o(106063);
      return;
    }
    switchFragmentInternalWithoutAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(106063);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(106064);
    switchFragment(paramFragment, paramInt, false, false, 0, 0);
    AppMethodBeat.o(106064);
  }
  
  protected com.tencent.mm.vending.e.b theCreate()
  {
    return this.mLifeCycleKeeper.ANE;
  }
  
  protected com.tencent.mm.vending.e.b theResume()
  {
    return this.mLifeCycleKeeper.ANF;
  }
  
  protected com.tencent.mm.vending.e.b theStart()
  {
    return this.mLifeCycleKeeper.ANF;
  }
  
  public static final class a
  {
    public static int zbX;
    public static int zbY;
    public static int zbZ;
    public static int zca;
    public static int zcb;
    public static int zcc;
    public static int zcd;
    public static int zce;
    
    static
    {
      int j = 2131034130;
      AppMethodBeat.i(106052);
      boolean bool2 = com.tencent.mm.compatible.util.d.fv(19);
      boolean bool1 = com.tencent.mm.compatible.i.b.Mg() & bool2;
      if (bool1)
      {
        i = 2131034266;
        zbX = i;
        if (!bool1) {
          break label102;
        }
        i = 2131034263;
        label38:
        zbY = i;
        i = j;
        if (bool1) {
          i = 2131034262;
        }
        zbZ = i;
        if (!bool1) {
          break label108;
        }
      }
      label102:
      label108:
      for (int i = 2131034267;; i = 2131034222)
      {
        zca = i;
        zcb = zbX;
        zcc = zbY;
        zcd = zbZ;
        zce = zca;
        AppMethodBeat.o(106052);
        return;
        i = 2131034217;
        break;
        i = 2131034130;
        break label38;
      }
    }
    
    public static void dCz()
    {
      int j = 2131034130;
      AppMethodBeat.i(106051);
      x localx = ac.erz;
      boolean bool = x.LY();
      ab.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle swipbackType = ".concat(String.valueOf(bool)));
      if (!bool)
      {
        AppMethodBeat.o(106051);
        return;
      }
      bool = com.tencent.mm.compatible.util.d.fv(19);
      bool = com.tencent.mm.compatible.i.b.Mg() & bool;
      ab.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle supportSwipe = ".concat(String.valueOf(bool)));
      if (bool)
      {
        i = 2131034266;
        zbX = i;
        if (!bool) {
          break label148;
        }
        i = 2131034263;
        label84:
        zbY = i;
        i = j;
        if (bool) {
          i = 2131034262;
        }
        zbZ = i;
        if (!bool) {
          break label154;
        }
      }
      label148:
      label154:
      for (int i = 2131034267;; i = 2131034222)
      {
        zca = i;
        zcb = zbX;
        zcc = zbY;
        zcd = zbZ;
        zce = zca;
        AppMethodBeat.o(106051);
        return;
        i = 2131034217;
        break;
        i = 2131034130;
        break label84;
      }
    }
  }
  
  final class b
  {
    NfcAdapter zcf = null;
    PendingIntent zcg;
    IntentFilter[] zch;
    String[][] zci;
    
    private b() {}
    
    final void init()
    {
      AppMethodBeat.i(106053);
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
      ((Intent)localObject).addFlags(536870912);
      this.zcg = PendingIntent.getActivity(MMFragmentActivity.this, 0, (Intent)localObject, 0);
      localObject = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
      try
      {
        ((IntentFilter)localObject).addDataType("*/*");
        IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TECH_DISCOVERED");
        localIntentFilter.addDataScheme("vnd.android.nfc");
        this.zch = new IntentFilter[] { localObject, localIntentFilter, new IntentFilter("android.nfc.action.TAG_DISCOVERED") };
        this.zci = new String[][] { { NfcA.class.getName(), IsoDep.class.getName() } };
        AppMethodBeat.o(106053);
        return;
      }
      catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
      {
        RuntimeException localRuntimeException = new RuntimeException("fail", localMalformedMimeTypeException);
        AppMethodBeat.o(106053);
        throw localRuntimeException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity
 * JD-Core Version:    0.7.0.1
 */