package com.tencent.mm.wallet_core.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.rt;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.y.b;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.e;
import com.tencent.mm.wallet_core.e.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.model.n;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class WalletBaseUI
  extends MMSecDataActivity
  implements com.tencent.mm.wallet_core.c.f, com.tencent.mm.wallet_core.model.i
{
  public static final int CLEAN_UI_DATA_ACTION_CODE_CLEAN_PASSWORD = 1;
  public static final int CLEAN_UI_DATA_ACTION_CODE_DEFAULT = 0;
  public static final int DIALOG_ID_CONFIRM_FINISH = 1000;
  public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  private static final String TAG = "MicroMsg.WalletBaseUI";
  private static Set<String> mLockSet = new HashSet();
  private boolean _hasFinish = false;
  private MenuItem.OnMenuItemClickListener backListener;
  private LinkedList<com.tencent.mm.wallet_core.model.k> callbacks = new LinkedList();
  public boolean isVKBFirstTimeShown = false;
  private Bundle mBundle = new Bundle();
  private com.tencent.mm.wallet_core.model.s mCurrentNetScene = null;
  private boolean mIsAuthDoing;
  public View mKBLayout;
  public MyKeyboardWindow mKeyboard;
  public boolean mKindaEnable;
  private com.tencent.mm.wallet_core.c.g mNetController = null;
  public com.tencent.mm.wallet_core.c.i mNetSceneMgr = null;
  private IListener<rt> mPayLoopInterruptListener = new IListener(com.tencent.mm.app.f.hfK) {};
  public int mPayResultType = 0;
  private e mProcess = null;
  private e.a mProcessEnd;
  private Dialog mProgressDialog;
  private a mTenpayKBStateListener;
  private Dialog mTipDialog = null;
  public WcPayKeyboard mWcKeyboard;
  private MenuItem.OnMenuItemClickListener nextListener;
  
  private void dispatchOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = ((List)this.callbacks.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((com.tencent.mm.wallet_core.model.k)paramIntent.next()).jOI();
    }
  }
  
  private void dispatchOnCreate()
  {
    Iterator localIterator = ((List)this.callbacks.clone()).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  private void dispatchOnDestroy()
  {
    Iterator localIterator = ((List)this.callbacks.clone()).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.wallet_core.model.k)localIterator.next()).onDestroy();
    }
  }
  
  public static boolean ifAutoReqFocusTarget28()
  {
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zkZ, 1);
    Log.i("MicroMsg.WalletBaseUI", "ifAutoReqFocusTarget28() swt:%s", new Object[] { Integer.valueOf(i) });
    return i == 1;
  }
  
  private void setContentViewVisibility()
  {
    if (getLayoutId() <= 0)
    {
      setContentViewVisibility(4);
      return;
    }
    if (isTransparent())
    {
      setContentViewVisibility(4);
      return;
    }
    setContentViewVisibility(0);
  }
  
  private void setProcessBundle()
  {
    e locale = getProcess();
    if (locale != null) {
      this.mNetSceneMgr.mBundle = locale.hPH;
    }
  }
  
  public void addSceneEndListener(int paramInt)
  {
    this.mNetSceneMgr.addSceneEndListener(paramInt);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.nextListener = paramOnMenuItemClickListener;
    super.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, y.b paramb)
  {
    this.nextListener = paramOnMenuItemClickListener;
    super.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, null, paramb);
  }
  
  public void cancelNetScene(p paramp)
  {
    com.tencent.mm.wallet_core.c.i locali = this.mNetSceneMgr;
    Log.i("MicroMsg.WalletNetSceneMgr", "cancel scene: %s %s", new Object[] { locali, paramp });
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramp);
    locali.qhY.remove(paramp);
    locali.qhX.remove(paramp);
    if ((locali.qhY.isEmpty()) && (locali.qhX.isEmpty()) && (locali.tipDialog != null) && (locali.tipDialog.isShowing())) {
      locali.tipDialog.dismiss();
    }
  }
  
  protected void cancelQRPay()
  {
    PayInfo localPayInfo2 = (PayInfo)getInput().getParcelable("key_pay_info");
    PayInfo localPayInfo1 = localPayInfo2;
    if (localPayInfo2 == null) {
      localPayInfo1 = (PayInfo)getIntent().getParcelableExtra("key_pay_info");
    }
    if ((localPayInfo1 != null) && (!Util.isNullOrNil(localPayInfo1.uuid)))
    {
      this.mNetSceneMgr.a(new n(localPayInfo1.uuid, localPayInfo1.hAT), true, 1);
      localPayInfo1.uuid = null;
    }
  }
  
  public boolean checkProcLife()
  {
    return true;
  }
  
  public void cleanScenes()
  {
    this.mNetSceneMgr.forceCancel();
  }
  
  public void cleanUiData(int paramInt) {}
  
  public void clearErr() {}
  
  public void doSceneForceProgress(p paramp)
  {
    doSceneProgress(paramp, true, false);
  }
  
  public void doSceneForceProgress(p paramp, int paramInt)
  {
    doSceneProgress(paramp, true, false, paramInt);
  }
  
  public void doSceneProgress(p paramp)
  {
    doSceneProgress(paramp, true, true);
  }
  
  public void doSceneProgress(p paramp, boolean paramBoolean)
  {
    doSceneProgress(paramp, paramBoolean, false);
  }
  
  public void doSceneProgress(p paramp, boolean paramBoolean1, boolean paramBoolean2)
  {
    doSceneProgress(paramp, paramBoolean1, paramBoolean2, 0);
  }
  
  public void doSceneProgress(p paramp, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    setProcessBundle();
    int i = 1;
    if (!paramBoolean2) {
      i = 2;
    }
    this.mNetSceneMgr.a(paramp, paramBoolean1, i, paramInt);
  }
  
  public void doSceneProgressWithVerify(p paramp)
  {
    setProcessBundle();
    this.mNetSceneMgr.a(paramp, true, 3);
  }
  
  public void doSceneSafeProgress(p paramp)
  {
    doSceneProgress(paramp, true, true);
  }
  
  public void finish()
  {
    super.finish();
    hideLoading();
    hideTenpayKB();
    hideWcKb();
    this._hasFinish = true;
  }
  
  public void forceCancel()
  {
    Log.d("MicroMsg.WalletBaseUI", "cancelforceScene");
    this.mNetSceneMgr.forceCancel();
    finish();
  }
  
  protected boolean getCancelable()
  {
    return true;
  }
  
  public int getContentViewVisibility()
  {
    return getContentView().getVisibility();
  }
  
  public Bundle getInput()
  {
    return this.mBundle;
  }
  
  public com.tencent.mm.wallet_core.c.g getNetController()
  {
    if (this.mNetController == null)
    {
      e locale = getProcess();
      if (locale != null) {
        this.mNetController = locale.a(this, this.mNetSceneMgr);
      }
      if (this.mNetController == null) {
        this.mNetController = new com.tencent.mm.wallet_core.c.g(this, this.mNetSceneMgr)
        {
          public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
          {
            return false;
          }
          
          public final boolean t(Object... paramAnonymousVarArgs)
          {
            return false;
          }
        };
      }
    }
    return this.mNetController;
  }
  
  public String getPayReqKey()
  {
    if (this.mBundle == null) {
      return "";
    }
    PayInfo localPayInfo = (PayInfo)this.mBundle.getParcelable("key_pay_info");
    if (localPayInfo != null) {
      return localPayInfo.hAT;
    }
    return "";
  }
  
  public e getProcess()
  {
    if (this.mProcess == null) {
      this.mProcess = com.tencent.mm.wallet_core.a.cm(this);
    }
    return this.mProcess;
  }
  
  protected Class<? extends h> getReportUIC()
  {
    return h.class;
  }
  
  public String getSubTitle()
  {
    return "";
  }
  
  public CharSequence getTips(int paramInt)
  {
    if (this.mNetController == null) {
      return null;
    }
    return this.mNetController.getTips(paramInt);
  }
  
  public void handleKeyboardTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (!this.mWcKeyboard.jOl())) {
      showCircleStWcKb();
    }
  }
  
  public boolean hasFinish()
  {
    return this._hasFinish;
  }
  
  public void hideKeyboardPushDownBtn()
  {
    View localView = findViewById(a.f.tenpay_push_down);
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = findViewById(a.f.tenpay_keyboard_top_line);
    if (localView != null) {
      localView.setVisibility(8);
    }
  }
  
  public void hideLoading()
  {
    if ((this.mTipDialog != null) && (this.mTipDialog.isShowing())) {
      this.mTipDialog.dismiss();
    }
  }
  
  public void hideProgress()
  {
    if (this.mProgressDialog != null) {
      this.mProgressDialog.dismiss();
    }
  }
  
  public void hideTenpayKB()
  {
    if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(8);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(false);
      }
    }
  }
  
  public void hideWcKb()
  {
    if (this.mWcKeyboard != null)
    {
      this.mWcKeyboard.hideWcKb();
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(false);
      }
      ((h)component(getReportUIC())).aGx(2);
    }
  }
  
  protected boolean isAuthDoing()
  {
    return this.mIsAuthDoing;
  }
  
  public boolean isHandleAutoShowNormalStWcKb()
  {
    return false;
  }
  
  public boolean isProcessing()
  {
    return this.mNetSceneMgr.isProcessing();
  }
  
  public boolean isTransparent()
  {
    if (getLayoutId() <= 0) {}
    while (this.mNetSceneMgr.isProcessing()) {
      return true;
    }
    return false;
  }
  
  public void keepProcessEnd(e.a parama)
  {
    this.mProcessEnd = parama;
  }
  
  public boolean lockPage()
  {
    String str = getClass().getSimpleName();
    if (mLockSet.contains(str))
    {
      Log.w("MicroMsg.WalletBaseUI", "has contain lock key: %s", new Object[] { str });
      finish();
      return false;
    }
    return mLockSet.add(str);
  }
  
  public boolean needConfirmFinish()
  {
    return false;
  }
  
  protected boolean needExecuteBackListener()
  {
    return true;
  }
  
  protected boolean needLockPage()
  {
    return false;
  }
  
  public void next()
  {
    getProcess().a(this, 0, getInput());
  }
  
  public void next(Bundle paramBundle)
  {
    getProcess().a(this, 0, paramBundle);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    getNetController().onActivityResult(paramInt1, paramInt2, paramIntent);
    dispatchOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (needLockPage()) {
      lockPage();
    }
    shouldFixStatusBar();
    if (shouldEnsureSoterConnection())
    {
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.jYq();
    }
    super.onCreate(paramBundle);
    setStatusColor();
    if (!com.tencent.mm.kernel.h.baz())
    {
      Log.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
      com.tencent.mm.ui.base.k.a(this, getString(a.i.wallet_account_not_ready), "", false, new WalletBaseUI.10(this));
    }
    this.mNetSceneMgr = new com.tencent.mm.wallet_core.c.i(this, this);
    this.mNetSceneMgr.addSceneEndListener(385);
    this.mNetSceneMgr.addSceneEndListener(1518);
    this.mPayLoopInterruptListener.alive();
    Log.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
    paramBundle = com.tencent.mm.wallet_core.a.cm(this);
    if (paramBundle != null)
    {
      this.mNetSceneMgr.mProcessName = paramBundle.fud();
      paramBundle.a(this);
    }
    Log.d("MicroMsg.WalletBaseUI", "proc ".concat(String.valueOf(paramBundle)));
    this.mBundle = com.tencent.mm.wallet_core.a.cl(this);
    if (this.mBundle == null) {
      this.mBundle = new Bundle();
    }
    this.mNetSceneMgr.mBundle = this.mBundle;
    if ((checkProcLife()) && (!com.tencent.mm.wallet_core.a.ck(this))) {
      Log.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
    }
    if (getLayoutId() > 0)
    {
      paramBundle = getSubTitle();
      if (!Util.isNullOrNil(paramBundle)) {
        setMMSubTitle(paramBundle);
      }
    }
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(72970);
        WalletBaseUI.this.mPayResultType = 4;
        if (WalletBaseUI.this.needConfirmFinish())
        {
          WalletBaseUI.this.hideVKB();
          WalletBaseUI.this.showDialog(1000);
        }
        for (;;)
        {
          AppMethodBeat.o(72970);
          return true;
          WalletBaseUI.this.finish();
        }
      }
    });
    this.mNetController = getNetController();
    if ((this.mNetController != null) && (this.mNetController.D(new Object[0]))) {
      setContentViewVisibility(4);
    }
    for (;;)
    {
      dispatchOnCreate();
      b.jNX();
      this.mKindaEnable = b.b(c.a.yRc, true);
      paramBundle = com.tencent.mm.compatible.deviceinfo.q.aPg();
      Log.i("MicroMsg.WalletBaseUI", "old id: %s, new id: %s", new Object[] { (String)com.tencent.mm.compatible.deviceinfo.l.aOI().get(256), paramBundle });
      g.bEI(getClass().getSimpleName());
      return;
      setContentViewVisibility();
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    Log.i("MicroMsg.WalletBaseUI", "onCreateDialog id = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    e locale = com.tencent.mm.wallet_core.a.cm(this);
    if (locale != null) {}
    for (int i = locale.a(this, 1);; i = -1)
    {
      if (i != -1) {
        com.tencent.mm.ui.base.k.a(this, true, getString(i), "", getString(a.i.app_yes), getString(a.i.app_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(72971);
            WalletBaseUI.this.cancelQRPay();
            paramAnonymousDialogInterface = com.tencent.mm.wallet_core.a.cm(WalletBaseUI.this);
            WalletBaseUI.this.mPayResultType = 4;
            if (paramAnonymousDialogInterface != null)
            {
              if (!paramAnonymousDialogInterface.j(WalletBaseUI.this, WalletBaseUI.this.getInput()))
              {
                paramAnonymousDialogInterface.b(WalletBaseUI.this, WalletBaseUI.this.getInput());
                AppMethodBeat.o(72971);
              }
            }
            else {
              WalletBaseUI.this.finish();
            }
            AppMethodBeat.o(72971);
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(72972);
            if (WalletBaseUI.this.getContentView() != null) {
              WalletBaseUI.this.getContentView().findFocus();
            }
            AppMethodBeat.o(72972);
          }
        });
      }
      if (locale != null) {
        locale.b(this, getInput());
      }
      for (;;)
      {
        return super.onCreateDialog(paramInt);
        this.mPayResultType = 4;
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mNetSceneMgr.removeSceneEndListener(385);
    this.mNetSceneMgr.removeSceneEndListener(1518);
    this.mPayLoopInterruptListener.dead();
    e locale = getProcess();
    if (locale != null) {
      locale.b(this);
    }
    unlockPage();
    dispatchOnDestroy();
    this.callbacks.clear();
    keepProcessEnd(null);
    g.bEJ(getClass().getSimpleName());
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.mKBLayout != null) && (this.mKBLayout.isShown()))
      {
        hideTenpayKB();
        return true;
      }
      if (needConfirmFinish())
      {
        hideVKB();
        showDialog(1000);
        return true;
      }
      if ((this.backListener != null) && (needExecuteBackListener()))
      {
        this.backListener.onMenuItemClick(null);
        return true;
      }
      if (this.nextListener != null)
      {
        this.nextListener.onMenuItemClick(null);
        return true;
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    int i;
    if ((paramIntent.getBooleanExtra("key_process_is_end", false)) && (!paramIntent.getBooleanExtra("key_process_is_stay", true)))
    {
      setIntent(paramIntent);
      paramIntent = getIntent().getExtras();
      if ((paramIntent == null) || (!paramIntent.containsKey("key_process_result_code"))) {
        break label90;
      }
      i = paramIntent.getInt("key_process_result_code", 0);
      if (i != -1) {
        break label95;
      }
      Log.i("MicroMsg.WalletBaseUI", "process end ok!");
      setResult(-1, getIntent());
    }
    for (;;)
    {
      finish();
      return;
      label90:
      i = 0;
      break;
      label95:
      Log.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : ".concat(String.valueOf(i)));
      setResult(0, getIntent());
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return true;
  }
  
  protected boolean onProgressFinish()
  {
    return false;
  }
  
  public void onResume()
  {
    super.onResume();
    TenpaySecureEditText.setSalt(i.jPu());
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp, boolean paramBoolean)
  {
    Log.d("MicroMsg.WalletBaseUI", "errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    TenpaySecureEditText.setSalt(i.jPu());
    if ((paramp instanceof com.tencent.mm.wallet_core.model.s))
    {
      com.tencent.mm.wallet_core.model.s locals = (com.tencent.mm.wallet_core.model.s)paramp;
      this.mCurrentNetScene = locals;
      if (this.mBundle != null)
      {
        if (locals.is_gen_cert > 0) {
          this.mBundle.putInt("key_is_gen_cert", locals.is_gen_cert);
        }
        if (locals.is_hint_cert > 0) {
          this.mBundle.putInt("key_is_hint_crt", locals.is_hint_cert);
        }
        if (locals.is_ignore_cert > 0) {
          this.mBundle.putInt("key_is_ignore_cert", locals.is_ignore_cert);
        }
        if (!Util.isNullOrNil(locals.crt_token)) {
          this.mBundle.putString("key_crt_token", locals.crt_token);
        }
        if (!Util.isNullOrNil(locals.crt_wording)) {
          this.mBundle.putString("key_crt_wording", locals.crt_wording);
        }
      }
    }
    onPreSceneEnd(paramInt1, paramInt2, paramString, paramp);
    j.a(this, paramInt1, paramInt2, paramString, paramp, paramBoolean);
  }
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp);
  
  public boolean onSwipeBackFinish()
  {
    hideWcKb();
    if (this.backListener != null)
    {
      this.backListener.onMenuItemClick(null);
      return true;
    }
    if (this.nextListener != null)
    {
      this.nextListener.onMenuItemClick(null);
      return true;
    }
    return super.onSwipeBackFinish();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void regeistQueryOrder(int paramInt, com.tencent.mm.wallet_core.c.c paramc)
  {
    com.tencent.mm.wallet_core.c.i locali = this.mNetSceneMgr;
    paramc.rtType = paramInt;
    paramc.agTP = locali;
    locali.agTV.put(Integer.valueOf(paramInt), paramc);
  }
  
  public void register(com.tencent.mm.wallet_core.model.k paramk)
  {
    if (!this.callbacks.contains(paramk)) {
      this.callbacks.add(paramk);
    }
  }
  
  public void removeSceneEndListener(int paramInt)
  {
    this.mNetSceneMgr.removeSceneEndListener(paramInt);
  }
  
  public boolean resend(boolean paramBoolean)
  {
    if ((this.mCurrentNetScene != null) && ((this.mCurrentNetScene.resend()) || (paramBoolean)))
    {
      this.mNetSceneMgr.b(this.mCurrentNetScene, true);
      return true;
    }
    return false;
  }
  
  public void scrollToFormEditPosAfterShowTenPay(View paramView1, View paramView2, int paramInt)
  {
    if (paramView1 != null)
    {
      int[] arrayOfInt = new int[2];
      paramView2.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1] + paramView2.getHeight();
      int j = com.tencent.mm.cd.a.mt(this);
      paramInt = j - i - com.tencent.mm.cd.a.fromDPToPix(this, paramInt);
      Log.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT) });
      if ((paramInt > 0) && (paramInt < HARDCODE_TENPAY_KEYBOARD_HEIGHT))
      {
        paramInt = HARDCODE_TENPAY_KEYBOARD_HEIGHT - paramInt;
        Log.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new WalletBaseUI.8(this, paramView1, paramInt));
      }
    }
  }
  
  public void setAuthState(boolean paramBoolean)
  {
    this.mIsAuthDoing = paramBoolean;
    com.tencent.mm.pluginsdk.wallet.g.iOZ().Ywe.put("key_pay_offline_is_auth_doing", Boolean.valueOf(paramBoolean));
  }
  
  public void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.backListener = paramOnMenuItemClickListener;
    super.setBackBtn(paramOnMenuItemClickListener);
  }
  
  public void setContentViewVisibility(int paramInt)
  {
    super.setContentViewVisibility(paramInt);
  }
  
  protected void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean)
  {
    setEditFocusListener(paramView, paramInt, paramBoolean, true);
  }
  
  protected void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    setEditFocusListener(paramView, paramInt, paramBoolean1, true, paramBoolean2);
  }
  
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    setEditFocusListener(paramView, null, paramInt, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  protected void setEditFocusListener(View paramView, EditText paramEditText, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.mKBLayout = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    if (paramEditText == null) {
      paramEditText = (EditText)paramView.findViewById(a.f.wallet_content);
    }
    for (;;)
    {
      if ((this.mKeyboard == null) || (paramEditText == null) || (this.mKBLayout == null)) {
        return;
      }
      View.OnFocusChangeListener localOnFocusChangeListener = null;
      if (paramBoolean3) {
        localOnFocusChangeListener = paramEditText.getOnFocusChangeListener();
      }
      i.setNoSystemInputOnEditText(paramEditText);
      paramEditText.setOnFocusChangeListener(new WalletBaseUI.17(this, paramBoolean1, paramView, paramEditText, paramInt, localOnFocusChangeListener));
      paramEditText.setOnClickListener(new WalletBaseUI.2(this, paramBoolean1, paramInt, paramEditText));
      if ((d.rb(28)) && (paramBoolean2) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (ifAutoReqFocusTarget28()))) {
        paramEditText.post(new WalletBaseUI.3(this, paramEditText));
      }
      localView.setOnClickListener(new WalletBaseUI.4(this));
      return;
    }
  }
  
  public void setKBMode(int paramInt)
  {
    this.mKeyboard.setXMode(paramInt);
  }
  
  protected void setStatusColor()
  {
    setActionbarColor(getActionbarColor());
  }
  
  public void setTenpayKBStateListener(a parama)
  {
    this.mTenpayKBStateListener = parama;
  }
  
  protected void setWPKeyboard(final EditText paramEditText, final boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mWcKeyboard == null) {
      this.mWcKeyboard = ((WcPayKeyboard)findViewById(a.f.wp_kb));
    }
    if ((this.mWcKeyboard == null) || (paramEditText == null)) {
      return;
    }
    final View.OnFocusChangeListener localOnFocusChangeListener = null;
    if (paramBoolean2) {
      localOnFocusChangeListener = paramEditText.getOnFocusChangeListener();
    }
    i.setNoSystemInputOnEditText(paramEditText);
    paramEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      private boolean firstTime = true;
      
      public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(72975);
        if (paramAnonymousBoolean)
        {
          ((InputMethodManager)WalletBaseUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(72973);
              if ((!WalletBaseUI.this.mWcKeyboard.isShown()) && (paramAnonymousView.isShown()))
              {
                if ((WalletBaseUI.14.this.val$isShowFirstTime) || (!WalletBaseUI.14.a(WalletBaseUI.14.this))) {
                  WalletBaseUI.this.showNormalStWcKb();
                }
                WalletBaseUI.14.b(WalletBaseUI.14.this);
              }
              WalletBaseUI.this.mWcKeyboard.setInputEditText(WalletBaseUI.14.this.val$editText);
              ((InputMethodManager)WalletBaseUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
              AppMethodBeat.o(72973);
            }
          }, 300L);
        }
        for (;;)
        {
          if (localOnFocusChangeListener != null) {
            localOnFocusChangeListener.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
          }
          AppMethodBeat.o(72975);
          return;
          new MMHandler().postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(72974);
              WalletBaseUI.this.hideWcKb();
              AppMethodBeat.o(72974);
            }
          }, 200L);
        }
      }
    });
    if ((d.rb(28)) && (paramBoolean1) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (ifAutoReqFocusTarget28()))) {
      paramEditText.post(new WalletBaseUI.15(this, paramEditText));
    }
    paramEditText.setOnClickListener(new WalletBaseUI.16(this));
  }
  
  protected void setWcKbHeightListener(WcPayKeyboard.a parama)
  {
    if (this.mWcKeyboard != null) {
      this.mWcKeyboard.setHeightListener(parama);
    }
  }
  
  public void setmPayResultType(int paramInt)
  {
    this.mPayResultType = paramInt;
  }
  
  protected boolean shouldEnsureSoterConnection()
  {
    return false;
  }
  
  protected void shouldFixStatusBar() {}
  
  public void showCircleStWcKb()
  {
    if (this.mWcKeyboard != null)
    {
      this.mWcKeyboard.jOk();
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
      ((h)component(getReportUIC())).aGw(2);
      ((h)component(getReportUIC())).aGx(1);
    }
  }
  
  public void showLoading()
  {
    showLoading(true);
  }
  
  public void showLoading(boolean paramBoolean)
  {
    if (this.mTipDialog != null) {
      this.mTipDialog.show();
    }
    for (;;)
    {
      return;
      if (paramBoolean) {}
      for (this.mTipDialog = l.b(getContext(), false, new DialogInterface.OnCancelListener()
          {
            public final void onCancel(DialogInterface paramAnonymousDialogInterface)
            {
              AppMethodBeat.i(72968);
              if ((WalletBaseUI.this.mTipDialog != null) && (WalletBaseUI.this.mTipDialog.isShowing())) {
                WalletBaseUI.this.mTipDialog.dismiss();
              }
              if ((WalletBaseUI.this.getContentView().getVisibility() == 8) || (WalletBaseUI.this.getContentView().getVisibility() == 4))
              {
                Log.i("MicroMsg.WalletBaseUI", "usr cancel, & visibility not visiable, so finish");
                WalletBaseUI.this.finish();
              }
              WalletBaseUI.this.forceCancel();
              AppMethodBeat.o(72968);
            }
          }); this.mTipDialog != null; this.mTipDialog = l.c(getContext(), true, null))
      {
        this.mTipDialog.setCancelable(true);
        return;
      }
    }
  }
  
  public void showNormalStWcKb()
  {
    if (this.mWcKeyboard != null)
    {
      this.mWcKeyboard.showNormalStWcKb();
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
      ((h)component(getReportUIC())).aGw(1);
    }
  }
  
  public void showProgress()
  {
    if ((this.mProgressDialog == null) || ((this.mProgressDialog != null) && (!this.mProgressDialog.isShowing())))
    {
      if (this.mProgressDialog != null) {
        this.mProgressDialog.dismiss();
      }
      this.mProgressDialog = l.c(this, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
    }
  }
  
  public void showSafeProgress()
  {
    if ((this.mProgressDialog == null) || ((this.mProgressDialog != null) && (!this.mProgressDialog.isShowing())))
    {
      if (this.mProgressDialog != null) {
        this.mProgressDialog.dismiss();
      }
      this.mProgressDialog = l.a(this, false, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(72966);
          WalletBaseUI.this.forceCancel();
          AppMethodBeat.o(72966);
        }
      });
    }
  }
  
  public void showTenpayKB()
  {
    if ((this.mKBLayout != null) && (!this.mKBLayout.isShown()))
    {
      this.mKBLayout.setVisibility(0);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
    }
  }
  
  public void showWcKb()
  {
    if ((this.mWcKeyboard != null) && (!this.mWcKeyboard.isShown()))
    {
      this.mWcKeyboard.Ok(true);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
      ((h)component(getReportUIC())).aGw(1);
    }
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(getReportUIC());
  }
  
  public void unlockPage()
  {
    mLockSet.remove(getClass().getSimpleName());
  }
  
  public void unregister(com.tencent.mm.wallet_core.model.k paramk)
  {
    if (this.callbacks.contains(paramk)) {
      this.callbacks.remove(paramk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI
 * JD-Core Version:    0.7.0.1
 */