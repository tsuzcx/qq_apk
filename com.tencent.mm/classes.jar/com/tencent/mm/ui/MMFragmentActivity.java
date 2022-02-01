package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
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
import com.tencent.mm.ad.b.a;
import com.tencent.mm.ad.b.b;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.y;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.a;
import com.tencent.mm.ui.widget.h;
import com.tencent.mm.ui.widget.h.a;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MMFragmentActivity
  extends AppCompatActivity
  implements SwipeBackLayout.a, h.a, com.tencent.mm.vending.e.b
{
  public static final long ANIMATION_DURATION = 260L;
  public static final String EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM = "extra_use_system_default_enter_exit_anim";
  private static final String TAG = "MicroMsg.MMFragmentActivity";
  public static final float WIDTH_SETTLE_FACT = 3.5F;
  String className;
  private Resources customResources;
  private a mActivityAnimStyle;
  private View mContentViewForSwipeBack;
  private boolean mIsPaused;
  private com.tencent.mm.vending.a.a mLifeCycleKeeper;
  private c mNfcFilterHelper;
  private SwipeBackLayout mSwipeBackLayout;
  private boolean mSwiping;
  private b onActResult;
  ArrayList<WeakReference<MMFragment>> record;
  private boolean updateResource;
  
  public MMFragmentActivity()
  {
    AppMethodBeat.i(141406);
    this.record = new ArrayList();
    this.mLifeCycleKeeper = new com.tencent.mm.vending.a.a();
    this.onActResult = null;
    this.mActivityAnimStyle = new a();
    this.updateResource = false;
    this.mContentViewForSwipeBack = null;
    AppMethodBeat.o(141406);
  }
  
  public String appendMemLog()
  {
    AppMethodBeat.i(141409);
    long l1 = Runtime.getRuntime().totalMemory();
    long l2 = Runtime.getRuntime().freeMemory();
    String str = String.format("Runtime: [%s:%s:%s] Native: [%s:%s:%s] ", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l1 - l2), Long.valueOf(Debug.getNativeHeapSize()), Long.valueOf(Debug.getNativeHeapAllocatedSize()), Long.valueOf(Debug.getNativeHeapFreeSize()) });
    AppMethodBeat.o(141409);
    return str;
  }
  
  protected boolean convertActivityFromTranslucent()
  {
    return true;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(141454);
    if (isSupportNavigationSwipeBack())
    {
      SwipeBackLayout localSwipeBackLayout = getSwipeBackLayout();
      if ((paramKeyEvent.getKeyCode() == 4) && (localSwipeBackLayout != null) && (localSwipeBackLayout.eOJ()))
      {
        ac.w("ashutest", "ashutest::IS SwipeBack ING, ignore KeyBack Event");
        AppMethodBeat.o(141454);
        return true;
      }
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(141454);
    return bool;
  }
  
  public boolean enableActivityAnimation()
  {
    AppMethodBeat.i(141431);
    Intent localIntent = getIntent();
    if (localIntent != null) {}
    for (boolean bool = x.getBooleanExtra(localIntent, "extra_use_system_default_enter_exit_anim", false);; bool = false)
    {
      if (bool)
      {
        AppMethodBeat.o(141431);
        return false;
      }
      AppMethodBeat.o(141431);
      return true;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(141434);
    super.finish();
    initActivityCloseAnimation();
    AppMethodBeat.o(141434);
  }
  
  public boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public MMFragment getCurrentFragmet()
  {
    AppMethodBeat.i(141427);
    int i = this.record.size();
    if (i == 0)
    {
      AppMethodBeat.o(141427);
      return null;
    }
    MMFragment localMMFragment = (MMFragment)((WeakReference)this.record.get(i - 1)).get();
    if ((localMMFragment != null) && (localMMFragment.isShowing()))
    {
      AppMethodBeat.o(141427);
      return localMMFragment;
    }
    AppMethodBeat.o(141427);
    return null;
  }
  
  public final Resources getOriginalResources()
  {
    AppMethodBeat.i(141449);
    Resources localResources = super.getResources();
    AppMethodBeat.o(141449);
    return localResources;
  }
  
  public Resources getResources()
  {
    AppMethodBeat.i(141448);
    if ((getAssets() != null) && (ai.getResources() != null))
    {
      if ((!this.updateResource) || (this.customResources == null))
      {
        Object localObject2 = getBaseContext().getResources();
        this.customResources = ai.getResources();
        if (((this.customResources instanceof com.tencent.mm.cd.b)) && (localObject2 != null))
        {
          localObject1 = (com.tencent.mm.cd.b)this.customResources;
          localObject2 = ((com.tencent.mm.cd.b)localObject1).GjW.g(((Resources)localObject2).getConfiguration());
          com.tencent.mm.cd.c.a((Configuration)localObject2, aj.j(this.customResources));
          ((com.tencent.mm.cd.b)localObject1).getConfiguration().updateFrom((Configuration)localObject2);
          this.customResources = ((Resources)localObject1);
          this.updateResource = true;
        }
      }
      localObject1 = this.customResources;
      AppMethodBeat.o(141448);
      return localObject1;
    }
    Object localObject1 = super.getResources();
    AppMethodBeat.o(141448);
    return localObject1;
  }
  
  public SwipeBackLayout getSwipeBackLayout()
  {
    return this.mSwipeBackLayout;
  }
  
  public Object getSystemService(String paramString)
  {
    AppMethodBeat.i(141447);
    if ((("clipboard".equals(paramString)) || ("power".equals(paramString))) && (getApplicationContext() != null))
    {
      paramString = getApplicationContext().getSystemService(paramString);
      AppMethodBeat.o(141447);
      return paramString;
    }
    Object localObject = super.getSystemService(paramString);
    if ("layout_inflater".equals(paramString))
    {
      paramString = z.b((LayoutInflater)localObject);
      AppMethodBeat.o(141447);
      return paramString;
    }
    AppMethodBeat.o(141447);
    return localObject;
  }
  
  public WindowManager getWindowManager()
  {
    AppMethodBeat.i(141457);
    Object localObject;
    if (!isDestroyed())
    {
      localObject = super.getWindowManager();
      AppMethodBeat.o(141457);
      return localObject;
    }
    try
    {
      localObject = new Throwable().getStackTrace();
      if ((localObject != null) && (localObject.length >= 2) && (localObject[1].getMethodName().equals("handleDestroyActivity")))
      {
        localObject = com.tencent.mm.plugin.crashfix.b.a.a.a(super.getWindowManager());
        AppMethodBeat.o(141457);
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      ac.e("MicroMsg.MMFragmentActivity", localThrowable.getMessage());
      WindowManager localWindowManager = super.getWindowManager();
      AppMethodBeat.o(141457);
      return localWindowManager;
    }
  }
  
  protected void initActivityCloseAnimation()
  {
    AppMethodBeat.i(141433);
    if (enableActivityAnimation())
    {
      if (com.tencent.mm.ui.base.b.be(getClass()))
      {
        super.overridePendingTransition(a.HoT, a.HoU);
        AppMethodBeat.o(141433);
        return;
      }
      if ((com.tencent.mm.ui.base.b.bb(getClass()) & 0x4) != 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        com.tencent.mm.ui.base.b.jT(this);
        AppMethodBeat.o(141433);
        return;
      }
      com.tencent.mm.ui.base.b.jU(this);
    }
    AppMethodBeat.o(141433);
  }
  
  protected void initActivityOpenAnimation(Intent paramIntent)
  {
    AppMethodBeat.i(141432);
    if (enableActivityAnimation())
    {
      if (paramIntent == null)
      {
        paramIntent = null;
        if (paramIntent == null) {
          break label95;
        }
        paramIntent = com.tencent.mm.ui.base.b.e(paramIntent);
        if ((com.tencent.mm.ui.base.b.aPI(paramIntent) & 0x2) != 0) {
          break label68;
        }
      }
      label68:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label73;
        }
        super.overridePendingTransition(a.HoR, a.HoS);
        AppMethodBeat.o(141432);
        return;
        paramIntent = paramIntent.getComponent();
        break;
      }
      label73:
      if (!com.tencent.mm.ui.base.b.aPK(paramIntent))
      {
        com.tencent.mm.ui.base.b.jR(this);
        AppMethodBeat.o(141432);
        return;
      }
      com.tencent.mm.ui.base.b.jU(this);
    }
    label95:
    AppMethodBeat.o(141432);
  }
  
  public boolean initNavigationSwipeBack()
  {
    AppMethodBeat.i(141445);
    if (com.tencent.mm.compatible.util.d.kZ(19))
    {
      if ((!com.tencent.mm.ui.base.b.bd(getClass())) || (!convertActivityFromTranslucent())) {
        break label60;
      }
      if (ap.isMainThread()) {
        com.tencent.mm.ui.base.b.bi(this);
      }
    }
    label60:
    label95:
    while (isSupportNavigationSwipeBack())
    {
      initSwipeBack();
      AppMethodBeat.o(141445);
      return true;
      if ((com.tencent.mm.ui.base.b.bb(getClass()) & 0x10) != 0) {}
      for (int i = 1;; i = 0)
      {
        if ((i == 0) || (!ap.isMainThread())) {
          break label95;
        }
        com.tencent.mm.ui.base.b.bi(this);
        break;
      }
    }
    AppMethodBeat.o(141445);
    return false;
  }
  
  protected void initSwipeBack()
  {
    AppMethodBeat.i(141446);
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    this.mSwipeBackLayout = ((SwipeBackLayout)LayoutInflater.from(this).inflate(2131495736, localViewGroup, false));
    this.mSwipeBackLayout.init();
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    getWindow().getDecorView().setBackgroundDrawable(null);
    View localView = localViewGroup.getChildAt(0);
    localView.setBackgroundResource(2131101053);
    localViewGroup.removeView(localView);
    this.mSwipeBackLayout.addView(localView);
    this.mSwipeBackLayout.setContentView(localView);
    localViewGroup.addView(this.mSwipeBackLayout);
    this.mSwipeBackLayout.setSwipeGestureDelegate(this);
    AppMethodBeat.o(141446);
  }
  
  public boolean isHideStatusBar()
  {
    AppMethodBeat.i(141444);
    if ((com.tencent.mm.ui.base.b.bb(getClass()) & 0x20) != 0)
    {
      AppMethodBeat.o(141444);
      return true;
    }
    AppMethodBeat.o(141444);
    return false;
  }
  
  public boolean isNfcFilterEnabled()
  {
    return true;
  }
  
  public boolean isPaused()
  {
    return this.mIsPaused;
  }
  
  public boolean isSupportNavigationSwipeBack()
  {
    AppMethodBeat.i(141443);
    if ((com.tencent.mm.compatible.util.d.kZ(19)) && (com.tencent.mm.compatible.g.b.YB()))
    {
      if ((supportNavigationSwipeBack()) && (com.tencent.mm.ui.base.b.bd(getClass())))
      {
        AppMethodBeat.o(141443);
        return true;
      }
      AppMethodBeat.o(141443);
      return false;
    }
    AppMethodBeat.o(141443);
    return false;
  }
  
  public boolean isSwiping()
  {
    return this.mSwiping;
  }
  
  public void keep(com.tencent.mm.vending.e.a parama)
  {
    AppMethodBeat.i(141407);
    this.mLifeCycleKeeper.Jph.keep(parama);
    AppMethodBeat.o(141407);
  }
  
  public void mmStartActivityForResult(b paramb, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(141458);
    this.onActResult = paramb;
    startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(141458);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(141459);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.onActResult != null) {
      this.onActResult.c(paramInt1, paramInt2, paramIntent);
    }
    this.onActResult = null;
    AppMethodBeat.o(141459);
  }
  
  public void onCancel()
  {
    this.mSwiping = false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141455);
    super.onConfigurationChanged(paramConfiguration);
    if (getSupportActionBar() != null)
    {
      paramConfiguration = (ViewGroup)findViewById(2131298945);
      if (paramConfiguration != null)
      {
        paramConfiguration = paramConfiguration.findViewById(2131296343);
        if ((paramConfiguration != null) && ((paramConfiguration instanceof Toolbar)))
        {
          paramConfiguration = (Toolbar)paramConfiguration;
          ViewGroup.LayoutParams localLayoutParams = paramConfiguration.getLayoutParams();
          if (localLayoutParams != null) {
            localLayoutParams.height = com.tencent.mm.compatible.util.a.cd(this);
          }
          paramConfiguration.setLayoutParams(localLayoutParams);
        }
      }
    }
    AppMethodBeat.o(141455);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(141408);
    this.className = getClass().getName();
    ah.cJ(3, this.className);
    super.onCreate(paramBundle);
    paramBundle = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197181);
        ac.i("MicroMsg.MMFragmentActivity", "createNfcFilterHelperTask run");
        MMFragmentActivity.c localc;
        if (MMFragmentActivity.this.isNfcFilterEnabled())
        {
          MMFragmentActivity.access$002(MMFragmentActivity.this, new MMFragmentActivity.c(MMFragmentActivity.this, (byte)0));
          localc = MMFragmentActivity.this.mNfcFilterHelper;
        }
        try
        {
          ac.i("MicroMsg.MMFragmentActivity", "[NFC] getDefaultAdapter");
          localc.HoV = NfcAdapter.getDefaultAdapter(localc.HoP);
          localc.init();
          AppMethodBeat.o(197181);
          return;
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.MMFragmentActivity", localThrowable, "", new Object[0]);
          }
        }
      }
    };
    if ((!i.GqL) || (!ai.getContext().getSharedPreferences(ai.eUX(), 0).getBoolean("gprs_alert", true))) {
      paramBundle.run();
    }
    for (;;)
    {
      ac.i("MicroMsg.MMFragmentActivity", "checktask onCreate:%s#0x%x, taskid:%d, task:%s appendMemLog:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getTaskId()), bs.jb(this), appendMemLog() });
      AppMethodBeat.o(141408);
      return;
      keep(new d()
      {
        public final void onSharedPreferenceChanged(SharedPreferences paramAnonymousSharedPreferences, String paramAnonymousString)
        {
          AppMethodBeat.i(197182);
          if ((paramAnonymousString.equals("gprs_alert")) && (!paramAnonymousSharedPreferences.getBoolean("gprs_alert", true)))
          {
            ac.i("MicroMsg.MMFragmentActivity", "onSharedPreferenceChanged");
            paramBundle.run();
            if ((!MMFragmentActivity.this.isPaused()) && (MMFragmentActivity.this.mNfcFilterHelper != null)) {
              MMFragmentActivity.this.mNfcFilterHelper.onResume();
            }
            dead();
          }
          AppMethodBeat.o(197182);
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(141410);
    ac.i("MicroMsg.MMFragmentActivity", "checktask onDestroy:%s#0x%x task:%s appendMemLog:%s", new Object[] { getClass().getSimpleName(), Integer.valueOf(hashCode()), bs.jb(this), appendMemLog() });
    this.mLifeCycleKeeper.Jph.dead();
    super.onDestroy();
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT == 24)) {}
    try
    {
      if (b.a.gmo == null)
      {
        localObject = Class.forName("android.rms.iaware.FastgrabConfigReader");
        b.a.gmo = (Class)localObject;
        localObject = ((Class)localObject).getDeclaredField("mFastgrabConfigReader");
        b.a.field_mFastgrabConfigReader = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        localObject = b.a.gmo.getDeclaredField("mContext");
        b.a.field_mContext = (Field)localObject;
        ((Field)localObject).setAccessible(true);
      }
      localObject = b.a.field_mFastgrabConfigReader.get(b.a.gmo);
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
        if (b.b.aMt == null)
        {
          localObject = Class.forName("android.gestureboost.GestureBoostManager");
          b.b.aMt = (Class)localObject;
          localObject = ((Class)localObject).getDeclaredField("sGestureBoostManager");
          b.b.gmp = (Field)localObject;
          ((Field)localObject).setAccessible(true);
          localObject = b.b.aMt.getDeclaredField("mContext");
          b.b.gmq = (Field)localObject;
          ((Field)localObject).setAccessible(true);
        }
        localObject = b.b.gmp.get(null);
        if (localObject != null) {
          b.b.gmq.set(localObject, null);
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
          localObject = ai.getContext().getSystemService(Class.forName("com.samsung.android.content.clipboard.SemClipboardManager"));
          Field localField = localObject.getClass().getDeclaredField("mContext");
          localField.setAccessible(true);
          localField.set(localObject, ai.getContext());
        }
        ac.i("MicroMsg.MMFragmentActivity", "Activity dump [%s]", new Object[] { com.tencent.mm.ad.a.aif() });
        AppMethodBeat.o(141410);
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
    AppMethodBeat.i(141413);
    ah.cJ(2, this.className);
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
    c localc;
    if (this.mNfcFilterHelper != null)
    {
      localc = this.mNfcFilterHelper;
      if (localc.HoV == null) {}
    }
    try
    {
      ac.i("MicroMsg.MMFragmentActivity", "[NFC] disableForegroundDispatch");
      localc.HoV.disableForegroundDispatch(localc.HoP);
      this.mLifeCycleKeeper.Jpi.dead();
      AppMethodBeat.o(141413);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e("MicroMsg.MMFragmentActivity", "lo-nfc-onPause: exp:" + localException.getLocalizedMessage());
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(141414);
    ah.cJ(1, this.className);
    this.mIsPaused = false;
    super.onResume();
    if (isSupportNavigationSwipeBack())
    {
      h.b(this);
      onSwipe(1.0F);
      if (getSwipeBackLayout() != null)
      {
        getSwipeBackLayout().setEnableGesture(true);
        getSwipeBackLayout().Jcu = false;
      }
    }
    if (this.mNfcFilterHelper != null) {
      this.mNfcFilterHelper.onResume();
    }
    AppMethodBeat.o(141414);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(141428);
    if (Build.VERSION.SDK_INT < 11) {
      super.onSaveInstanceState(paramBundle);
    }
    AppMethodBeat.o(141428);
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(141452);
    ac.v("ashutest", "ashutest:: on settle %B, speed %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.mContentViewForSwipeBack == null) {
      this.mContentViewForSwipeBack = aj.a(getWindow(), getSupportActionBar().getCustomView());
    }
    View localView = this.mContentViewForSwipeBack;
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localView, l, 0.0F, null);
        AppMethodBeat.o(141452);
        return;
        l = 260L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      j.a(localView, l, localView.getWidth() * -1 / 3.5F, null);
      AppMethodBeat.o(141452);
      return;
      l = 260L;
    }
  }
  
  public void onStart()
  {
    AppMethodBeat.i(141412);
    super.onStart();
    AppMethodBeat.o(141412);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(141411);
    this.mLifeCycleKeeper.Jpj.dead();
    super.onStop();
    AppMethodBeat.o(141411);
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(141451);
    ac.v("ashutest", "ashutest::on swipe %f, duration %d", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L) });
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
      this.mContentViewForSwipeBack = aj.a(localWindow, localView);
      localView = this.mContentViewForSwipeBack;
      if (Float.compare(1.0F, paramFloat) > 0) {
        break;
      }
      j.y(localView, 0.0F);
      AppMethodBeat.o(141451);
      return;
    }
    j.y(localView, localView.getWidth() / 3.5F * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(141451);
  }
  
  public void onSwipeBack()
  {
    AppMethodBeat.i(141453);
    if (!isFinishing()) {
      finish();
    }
    getWindow().getDecorView().setVisibility(8);
    overridePendingTransition(0, 0);
    this.mSwiping = false;
    AppMethodBeat.o(141453);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean popBackStackImmediate()
  {
    AppMethodBeat.i(141425);
    if (this.record.size() == 0)
    {
      AppMethodBeat.o(141425);
      return false;
    }
    this.record.remove(this.record.size() - 1);
    boolean bool = getSupportFragmentManager().popBackStackImmediate();
    AppMethodBeat.o(141425);
    return bool;
  }
  
  public void putActivityCloseAnimation(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141430);
    if (enableActivityAnimation())
    {
      a.HoT = paramInt1;
      a.HoU = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(141430);
  }
  
  public void putActivityOpenAnimation(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141429);
    if (enableActivityAnimation())
    {
      a.HoR = paramInt1;
      a.HoS = paramInt2;
    }
    super.overridePendingTransition(paramInt1, paramInt2);
    AppMethodBeat.o(141429);
  }
  
  public void setMMOnFragmentActivityResult(b paramb)
  {
    this.onActResult = paramb;
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    AppMethodBeat.i(141450);
    if (!com.tencent.mm.sdk.platformtools.a.p(this, paramInt))
    {
      ac.e("MicroMsg.MMFragmentActivity", "AndroidOSafety.safety false ignore setRequestedOrientation %s for activity %s", new Object[] { Integer.valueOf(paramInt), this });
      AppMethodBeat.o(141450);
      return;
    }
    try
    {
      super.setRequestedOrientation(paramInt);
      AppMethodBeat.o(141450);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.printErrStackTrace("MicroMsg.MMFragmentActivity", localThrowable, "AndroidOSafety.safety uncaught", new Object[0]);
      AppMethodBeat.o(141450);
    }
  }
  
  @TargetApi(11)
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    AppMethodBeat.i(141436);
    super.startActivities(paramArrayOfIntent);
    initActivityOpenAnimation(null);
    AppMethodBeat.o(141436);
  }
  
  @TargetApi(16)
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(141435);
    if (d.a(this, this.mIsPaused, paramArrayOfIntent, new Object[] { paramBundle }))
    {
      AppMethodBeat.o(141435);
      return;
    }
    super.startActivities(paramArrayOfIntent, paramBundle);
    initActivityOpenAnimation(null);
    AppMethodBeat.o(141435);
  }
  
  public void startActivity(Intent paramIntent)
  {
    AppMethodBeat.i(141437);
    super.startActivity(paramIntent);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141437);
  }
  
  @TargetApi(16)
  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(141438);
    super.startActivity(paramIntent, paramBundle);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141438);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(141439);
    super.startActivityForResult(paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141439);
  }
  
  @TargetApi(16)
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(141440);
    if (d.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { Integer.valueOf(paramInt), paramBundle }))
    {
      AppMethodBeat.o(141440);
      return;
    }
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141440);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(141441);
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt);
    initActivityOpenAnimation(paramIntent);
    AppMethodBeat.o(141441);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(141442);
    if (d.a(this, this.mIsPaused, new Intent[] { paramIntent }, new Object[] { paramFragment, Integer.valueOf(paramInt) }))
    {
      AppMethodBeat.o(141442);
      return;
    }
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(141442);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    AppMethodBeat.i(141456);
    if ((getCurrentFragmet() != null) && (getCurrentFragmet().interceptSupportInvalidateOptionsMenu()))
    {
      AppMethodBeat.o(141456);
      return;
    }
    super.supportInvalidateOptionsMenu();
    AppMethodBeat.o(141456);
  }
  
  public boolean supportNavigationSwipeBack()
  {
    return true;
  }
  
  public void switchFragment(Fragment paramFragment, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(141426);
    if ((paramFragment == null) || (paramInt1 == 0))
    {
      AppMethodBeat.o(141426);
      return;
    }
    g localg = getSupportFragmentManager();
    k localk = localg.beginTransaction();
    if (paramBoolean2) {
      localk.n(paramInt2, paramInt3);
    }
    if (localg.findFragmentById(paramInt1) != null) {
      if (paramFragment.isHidden()) {
        localk.b(paramFragment);
      }
    }
    for (;;)
    {
      if (paramBoolean1) {
        localk.dF();
      }
      localk.commit();
      localg.executePendingTransactions();
      AppMethodBeat.o(141426);
      return;
      localk.a(paramInt1, paramFragment, paramFragment.getTag());
    }
  }
  
  public void switchFragmentActivity(Fragment paramFragment)
  {
    AppMethodBeat.i(141423);
    if (paramFragment == null)
    {
      AppMethodBeat.o(141423);
      return;
    }
    switchFragmentActivity(paramFragment, paramFragment.getId());
    AppMethodBeat.o(141423);
  }
  
  public void switchFragmentActivity(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(141424);
    switchFragment(paramFragment, paramInt, true, true, 2130772095, 2130772100);
    this.record.add(new WeakReference((MMFragment)paramFragment));
    AppMethodBeat.o(141424);
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(141419);
    switchFragmentInternalBackwardWithAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(141419);
  }
  
  public void switchFragmentInternalBackwardWithAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(141420);
    switchFragment(paramFragment, paramInt, false, true, 2130772140, 2130772145);
    AppMethodBeat.o(141420);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, int paramInt, View paramView)
  {
    AppMethodBeat.i(141422);
    switchFragment(paramFragment, paramInt, false, true, 0, 2130772145);
    if (paramView == null)
    {
      AppMethodBeat.o(141422);
      return;
    }
    paramFragment = AnimationUtils.loadAnimation(this, 2130772140);
    if (paramFragment != null) {
      paramView.startAnimation(paramFragment);
    }
    paramView.setVisibility(0);
    AppMethodBeat.o(141422);
  }
  
  public void switchFragmentInternalBackwardWithAnimLeftSelfView(Fragment paramFragment, View paramView)
  {
    AppMethodBeat.i(141421);
    if (paramFragment == null)
    {
      AppMethodBeat.o(141421);
      return;
    }
    switchFragmentInternalBackwardWithAnimLeftSelfView(paramFragment, paramFragment.getId(), paramView);
    AppMethodBeat.o(141421);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(141417);
    if (paramFragment == null)
    {
      AppMethodBeat.o(141417);
      return;
    }
    switchFragmentInternalFarwardWithAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(141417);
  }
  
  public void switchFragmentInternalFarwardWithAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(141418);
    switchFragment(paramFragment, paramInt, false, true, 2130772144, 2130772141);
    AppMethodBeat.o(141418);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment)
  {
    AppMethodBeat.i(141415);
    if (paramFragment == null)
    {
      AppMethodBeat.o(141415);
      return;
    }
    switchFragmentInternalWithoutAnim(paramFragment, paramFragment.getId());
    AppMethodBeat.o(141415);
  }
  
  public void switchFragmentInternalWithoutAnim(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(141416);
    switchFragment(paramFragment, paramInt, false, false, 0, 0);
    AppMethodBeat.o(141416);
  }
  
  protected com.tencent.mm.vending.e.b theCreate()
  {
    return this.mLifeCycleKeeper.Jph;
  }
  
  protected com.tencent.mm.vending.e.b theResume()
  {
    return this.mLifeCycleKeeper.Jpi;
  }
  
  protected com.tencent.mm.vending.e.b theStart()
  {
    return this.mLifeCycleKeeper.Jpi;
  }
  
  public static final class a
  {
    public static int HoR;
    public static int HoS;
    public static int HoT;
    public static int HoU;
    public static int mnC;
    public static int mnD;
    public static int mnE;
    public static int mnF;
    
    static
    {
      int j = 2130771986;
      AppMethodBeat.i(141404);
      boolean bool2 = com.tencent.mm.compatible.util.d.kZ(19);
      boolean bool1 = com.tencent.mm.compatible.g.b.YB() & bool2;
      if (bool1)
      {
        i = 2130772144;
        mnC = i;
        if (!bool1) {
          break label102;
        }
        i = 2130772141;
        label38:
        mnD = i;
        i = j;
        if (bool1) {
          i = 2130772140;
        }
        mnE = i;
        if (!bool1) {
          break label108;
        }
      }
      label102:
      label108:
      for (int i = 2130772145;; i = 2130772100)
      {
        mnF = i;
        HoR = mnC;
        HoS = mnD;
        HoT = mnE;
        HoU = mnF;
        AppMethodBeat.o(141404);
        return;
        i = 2130772095;
        break;
        i = 2130771986;
        break label38;
      }
    }
    
    public static void fgN()
    {
      int j = 2130771986;
      AppMethodBeat.i(141403);
      y localy = ae.fJi;
      boolean bool = y.Ym();
      ac.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle swipbackType = ".concat(String.valueOf(bool)));
      if (!bool)
      {
        AppMethodBeat.o(141403);
        return;
      }
      bool = com.tencent.mm.compatible.util.d.kZ(19);
      bool = com.tencent.mm.compatible.g.b.YB() & bool;
      ac.i("MicroMsg.MMFragmentActivity", "lm: setAnimationStyle supportSwipe = ".concat(String.valueOf(bool)));
      if (bool)
      {
        i = 2130772144;
        mnC = i;
        if (!bool) {
          break label148;
        }
        i = 2130772141;
        label84:
        mnD = i;
        i = j;
        if (bool) {
          i = 2130772140;
        }
        mnE = i;
        if (!bool) {
          break label154;
        }
      }
      label148:
      label154:
      for (int i = 2130772145;; i = 2130772100)
      {
        mnF = i;
        HoR = mnC;
        HoS = mnD;
        HoT = mnE;
        HoU = mnF;
        AppMethodBeat.o(141403);
        return;
        i = 2130772095;
        break;
        i = 2130771986;
        break label84;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void c(int paramInt1, int paramInt2, Intent paramIntent);
  }
  
  final class c
  {
    NfcAdapter HoV = null;
    private PendingIntent HoW;
    private IntentFilter[] HoX;
    private String[][] HoY;
    
    private c() {}
    
    final void init()
    {
      AppMethodBeat.i(141405);
      Object localObject = new Intent();
      ((Intent)localObject).setClassName(ai.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI");
      ((Intent)localObject).addFlags(536870912);
      this.HoW = PendingIntent.getActivity(MMFragmentActivity.this, 0, (Intent)localObject, 0);
      localObject = new IntentFilter("android.nfc.action.NDEF_DISCOVERED");
      try
      {
        ((IntentFilter)localObject).addDataType("*/*");
        IntentFilter localIntentFilter = new IntentFilter("android.nfc.action.TECH_DISCOVERED");
        localIntentFilter.addDataScheme("vnd.android.nfc");
        this.HoX = new IntentFilter[] { localObject, localIntentFilter, new IntentFilter("android.nfc.action.TAG_DISCOVERED") };
        this.HoY = new String[][] { { NfcA.class.getName(), IsoDep.class.getName() } };
        AppMethodBeat.o(141405);
        return;
      }
      catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
      {
        RuntimeException localRuntimeException = new RuntimeException("fail", localMalformedMimeTypeException);
        AppMethodBeat.o(141405);
        throw localRuntimeException;
      }
    }
    
    public final void onResume()
    {
      AppMethodBeat.i(197183);
      if (this.HoV != null)
      {
        if ((this.HoW == null) || (this.HoX == null) || (this.HoY == null)) {
          init();
        }
        try
        {
          ac.i("MicroMsg.MMFragmentActivity", "[NFC] enableForegroundDispatch");
          this.HoV.enableForegroundDispatch(MMFragmentActivity.this, this.HoW, this.HoX, this.HoY);
          AppMethodBeat.o(197183);
          return;
        }
        catch (Exception localException)
        {
          ac.e("MicroMsg.MMFragmentActivity", "lo-nfc-onResume: exp:" + localException.getLocalizedMessage());
        }
      }
      AppMethodBeat.o(197183);
    }
  }
  
  static abstract class d
    implements SharedPreferences.OnSharedPreferenceChangeListener, com.tencent.mm.vending.e.a
  {
    public d()
    {
      ai.getContext().getSharedPreferences(ai.eUX(), 0).registerOnSharedPreferenceChangeListener(this);
    }
    
    public void dead()
    {
      ac.i("MicroMsg.MMFragmentActivity", "OnSharedPreferenceChangeListenerLifeCycleAware dead");
      ai.getContext().getSharedPreferences(ai.eUX(), 0).unregisterOnSharedPreferenceChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.MMFragmentActivity
 * JD-Core Version:    0.7.0.1
 */