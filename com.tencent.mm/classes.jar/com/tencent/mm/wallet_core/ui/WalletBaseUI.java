package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.deviceinfo.l;
import com.tencent.mm.g.a.pi;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.wallet_core.c.n;
import com.tencent.mm.wallet_core.c.s;
import com.tencent.mm.wallet_core.d.a;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
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
  implements com.tencent.mm.wallet_core.c.i, com.tencent.mm.wallet_core.d.f
{
  public static final int CLEAN_UI_DATA_ACTION_CODE_CLEAN_PASSWORD = 1;
  public static final int CLEAN_UI_DATA_ACTION_CODE_DEFAULT = 0;
  public static final int DIALOG_ID_CONFIRM_FINISH = 1000;
  public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
  private static final String TAG = "MicroMsg.WalletBaseUI";
  private static Set<String> mLockSet = new HashSet();
  private boolean _hasFinish = false;
  private MenuItem.OnMenuItemClickListener backListener;
  private LinkedList<k> callbacks = new LinkedList();
  public boolean isVKBFirstTimeShown = false;
  private Bundle mBundle = new Bundle();
  private s mCurrentNetScene = null;
  private boolean mIsAuthDoing;
  public View mKBLayout;
  public MyKeyboardWindow mKeyboard;
  public boolean mKindaEnable;
  private com.tencent.mm.wallet_core.d.g mNetController = null;
  public com.tencent.mm.wallet_core.d.i mNetSceneMgr = null;
  private IListener<pi> mPayLoopInterruptListener = new WalletBaseUI.1(this);
  public int mPayResultType = 0;
  private com.tencent.mm.wallet_core.d mProcess = null;
  private d.a mProcessEnd;
  private Dialog mProgressDialog;
  private a mTenpayKBStateListener;
  private Dialog mTipDialog = null;
  public WcPayKeyboard mWcKeyboard;
  private MenuItem.OnMenuItemClickListener nextListener;
  
  private void dispatchOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = ((List)this.callbacks.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((k)paramIntent.next()).hhl();
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
      ((k)localIterator.next()).onDestroy();
    }
  }
  
  public static boolean ifAutoReqFocusTarget28()
  {
    int i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.six, 1);
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
    com.tencent.mm.wallet_core.d locald = getProcess();
    if (locald != null) {
      this.mNetSceneMgr.mBundle = locald.dQL;
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
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, t.b paramb)
  {
    this.nextListener = paramOnMenuItemClickListener;
    super.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, null, paramb);
  }
  
  public void cancelNetScene(com.tencent.mm.ak.q paramq)
  {
    com.tencent.mm.wallet_core.d.i locali = this.mNetSceneMgr;
    Log.i("MicroMsg.WalletNetSceneMgr", "cancel scene: %s %s", new Object[] { locali, paramq });
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAg().hqi.a(paramq);
    locali.ksP.remove(paramq);
    locali.ksO.remove(paramq);
    if ((locali.ksP.isEmpty()) && (locali.ksO.isEmpty()) && (locali.tipDialog != null) && (locali.tipDialog.isShowing())) {
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
      this.mNetSceneMgr.a(new n(localPayInfo1.uuid, localPayInfo1.dDL), true, 1);
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
  
  public void doSceneForceProgress(com.tencent.mm.ak.q paramq)
  {
    doSceneProgress(paramq, true, false);
  }
  
  public void doSceneForceProgress(com.tencent.mm.ak.q paramq, int paramInt)
  {
    doSceneProgress(paramq, true, false, paramInt);
  }
  
  public void doSceneProgress(com.tencent.mm.ak.q paramq)
  {
    doSceneProgress(paramq, true, true);
  }
  
  public void doSceneProgress(com.tencent.mm.ak.q paramq, boolean paramBoolean)
  {
    doSceneProgress(paramq, paramBoolean, false);
  }
  
  public void doSceneProgress(com.tencent.mm.ak.q paramq, boolean paramBoolean1, boolean paramBoolean2)
  {
    doSceneProgress(paramq, paramBoolean1, paramBoolean2, 0);
  }
  
  public void doSceneProgress(com.tencent.mm.ak.q paramq, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    setProcessBundle();
    int i = 1;
    if (!paramBoolean2) {
      i = 2;
    }
    this.mNetSceneMgr.a(paramq, paramBoolean1, i, paramInt);
  }
  
  public void doSceneProgressWithVerify(com.tencent.mm.ak.q paramq)
  {
    setProcessBundle();
    this.mNetSceneMgr.a(paramq, true, 3);
  }
  
  public void doSceneSafeProgress(com.tencent.mm.ak.q paramq)
  {
    doSceneProgress(paramq, true, true);
  }
  
  public void finish()
  {
    super.finish();
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
  
  public com.tencent.mm.wallet_core.d.g getNetController()
  {
    if (this.mNetController == null)
    {
      com.tencent.mm.wallet_core.d locald = getProcess();
      if (locald != null) {
        this.mNetController = locald.a(this, this.mNetSceneMgr);
      }
      if (this.mNetController == null) {
        this.mNetController = new com.tencent.mm.wallet_core.d.g(this, this.mNetSceneMgr)
        {
          public final boolean onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
          {
            return false;
          }
          
          public final boolean r(Object... paramAnonymousVarArgs)
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
      return localPayInfo.dDL;
    }
    return "";
  }
  
  public com.tencent.mm.wallet_core.d getProcess()
  {
    if (this.mProcess == null) {
      this.mProcess = com.tencent.mm.wallet_core.a.by(this);
    }
    return this.mProcess;
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
  
  public boolean hasFinish()
  {
    return this._hasFinish;
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
  
  public void keepProcessEnd(d.a parama)
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
      ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).triggerSoterReInit();
      com.tencent.soter.a.a.hlD();
    }
    super.onCreate(paramBundle);
    setStatusColor();
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
      com.tencent.mm.ui.base.h.a(this, getString(2131767399), "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(72969);
          com.tencent.mm.wallet_core.a.c(WalletBaseUI.this, null, -10000);
          AppMethodBeat.o(72969);
        }
      });
    }
    this.mNetSceneMgr = new com.tencent.mm.wallet_core.d.i(this, this);
    this.mNetSceneMgr.addSceneEndListener(385);
    this.mNetSceneMgr.addSceneEndListener(1518);
    this.mPayLoopInterruptListener.alive();
    Log.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
    paramBundle = com.tencent.mm.wallet_core.a.by(this);
    if (paramBundle != null)
    {
      this.mNetSceneMgr.mProcessName = paramBundle.dKC();
      paramBundle.a(this);
    }
    Log.d("MicroMsg.WalletBaseUI", "proc ".concat(String.valueOf(paramBundle)));
    this.mBundle = com.tencent.mm.wallet_core.a.bx(this);
    if (this.mBundle == null) {
      this.mBundle = new Bundle();
    }
    this.mNetSceneMgr.mBundle = this.mBundle;
    if ((checkProcLife()) && (!com.tencent.mm.wallet_core.a.bw(this))) {
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
    if ((this.mNetController != null) && (this.mNetController.A(new Object[0]))) {
      setContentViewVisibility(4);
    }
    for (;;)
    {
      dispatchOnCreate();
      com.tencent.mm.wallet_core.b.hgC();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.b(b.a.rWd, true);
      paramBundle = com.tencent.mm.compatible.deviceinfo.q.aoG();
      Log.i("MicroMsg.WalletBaseUI", "old id: %s, new id: %s", new Object[] { (String)l.aol().get(256), paramBundle });
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
    com.tencent.mm.wallet_core.d locald = com.tencent.mm.wallet_core.a.by(this);
    if (locald != null) {}
    for (int i = locald.a(this, 1);; i = -1)
    {
      if (i != -1) {
        com.tencent.mm.ui.base.h.a(this, true, getString(i), "", getString(2131756033), getString(2131755917), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(72971);
            WalletBaseUI.this.cancelQRPay();
            paramAnonymousDialogInterface = com.tencent.mm.wallet_core.a.by(WalletBaseUI.this);
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
      if (locald != null) {
        locald.b(this, getInput());
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
    com.tencent.mm.wallet_core.d locald = getProcess();
    if (locald != null) {
      locald.b(this);
    }
    unlockPage();
    dispatchOnDestroy();
    this.callbacks.clear();
    keepProcessEnd(null);
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
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
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
    TenpaySecureEditText.setSalt(f.hhV());
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq, boolean paramBoolean)
  {
    Log.d("MicroMsg.WalletBaseUI", "errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    TenpaySecureEditText.setSalt(f.hhV());
    if ((paramq instanceof s))
    {
      s locals = (s)paramq;
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
    onPreSceneEnd(paramInt1, paramInt2, paramString, paramq);
    g.a(this, paramInt1, paramInt2, paramString, paramq, paramBoolean);
  }
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq);
  
  public boolean onSwipeBackFinish()
  {
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
  
  public void regeistQueryOrder(int paramInt, c paramc)
  {
    com.tencent.mm.wallet_core.d.i locali = this.mNetSceneMgr;
    paramc.rtType = paramInt;
    paramc.Rux = locali;
    locali.RuD.put(Integer.valueOf(paramInt), paramc);
  }
  
  public void register(k paramk)
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
  
  public void scrollToFormEditPosAfterShowTenPay(final View paramView1, View paramView2, final int paramInt)
  {
    if (paramView1 != null)
    {
      int[] arrayOfInt = new int[2];
      paramView2.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1] + paramView2.getHeight();
      int j = com.tencent.mm.cb.a.jo(this);
      paramInt = j - i - com.tencent.mm.cb.a.fromDPToPix(this, paramInt);
      Log.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT) });
      if ((paramInt > 0) && (paramInt < HARDCODE_TENPAY_KEYBOARD_HEIGHT))
      {
        paramInt = HARDCODE_TENPAY_KEYBOARD_HEIGHT - paramInt;
        Log.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72967);
            paramView1.scrollBy(0, paramInt);
            AppMethodBeat.o(72967);
          }
        });
      }
    }
  }
  
  public void setAuthState(boolean paramBoolean)
  {
    this.mIsAuthDoing = paramBoolean;
    com.tencent.mm.pluginsdk.wallet.g.gsU().KxR.put("key_pay_offline_is_auth_doing", Boolean.valueOf(paramBoolean));
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
  
  @TargetApi(14)
  public void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    setEditFocusListener(paramView, null, paramInt, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  protected void setEditFocusListener(final View paramView, final EditText paramEditText, final int paramInt, final boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131308962));
    this.mKBLayout = findViewById(2131308960);
    View localView = findViewById(2131308963);
    if (paramEditText == null) {
      paramEditText = (EditText)paramView.findViewById(2131310180);
    }
    for (;;)
    {
      if ((this.mKeyboard == null) || (paramEditText == null) || (this.mKBLayout == null)) {
        return;
      }
      final View.OnFocusChangeListener localOnFocusChangeListener = null;
      if (paramBoolean3) {
        localOnFocusChangeListener = paramEditText.getOnFocusChangeListener();
      }
      f.setNoSystemInputOnEditText(paramEditText);
      paramEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(final View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(72980);
          if ((paramAnonymousView.isFocused()) && (!paramBoolean1))
          {
            ((InputMethodManager)WalletBaseUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(72978);
                if ((!WalletBaseUI.this.mKBLayout.isShown()) && (paramAnonymousView.isShown())) {
                  WalletBaseUI.this.showTenpayKB();
                }
                Object localObject;
                if (((WalletBaseUI.17.this.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
                {
                  localObject = (WalletFormView)WalletBaseUI.17.this.val$parent;
                  if (((z.aUo()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!z.aUo()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
                    break label261;
                  }
                  localObject = new com.tencent.mm.ui.a.d();
                  WalletBaseUI.this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                  WalletBaseUI.17.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
                }
                for (;;)
                {
                  if (((WalletBaseUI.17.this.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
                  {
                    localObject = new com.tencent.mm.ui.a.d();
                    WalletBaseUI.this.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
                    WalletBaseUI.17.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
                  }
                  WalletBaseUI.this.setKBMode(WalletBaseUI.17.this.val$editMode);
                  WalletBaseUI.this.mKeyboard.setInputEditText((EditText)paramAnonymousView);
                  ((InputMethodManager)WalletBaseUI.this.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramAnonymousView.getWindowToken(), 0);
                  AppMethodBeat.o(72978);
                  return;
                  label261:
                  WalletBaseUI.this.mKeyboard.resetSecureAccessibility();
                  WalletBaseUI.17.this.val$hintTv.setAccessibilityDelegate(null);
                }
              }
            }, 300L);
          }
          for (;;)
          {
            if (localOnFocusChangeListener != null) {
              localOnFocusChangeListener.onFocusChange(paramAnonymousView, paramAnonymousBoolean);
            }
            AppMethodBeat.o(72980);
            return;
            new MMHandler().postDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(72979);
                WalletBaseUI.this.hideTenpayKB();
                if (WalletBaseUI.17.this.val$isShowSysKB) {
                  ((InputMethodManager)WalletBaseUI.this.getContext().getSystemService("input_method")).showSoftInput(WalletBaseUI.17.this.val$hintTv, 0);
                }
                AppMethodBeat.o(72979);
              }
            }, 200L);
          }
        }
      });
      paramEditText.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72963);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/WalletBaseUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((!WalletBaseUI.this.mKBLayout.isShown()) && (!paramBoolean1))
          {
            WalletBaseUI.this.showTenpayKB();
            WalletBaseUI.this.setKBMode(paramInt);
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(72963);
            return;
            if (paramBoolean1)
            {
              WalletBaseUI.this.hideTenpayKB();
              ((InputMethodManager)WalletBaseUI.this.getContext().getSystemService("input_method")).showSoftInput(paramEditText, 0);
            }
          }
        }
      });
      if ((com.tencent.mm.compatible.util.d.oD(28)) && (paramBoolean2) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (ifAutoReqFocusTarget28()))) {
        paramEditText.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(72964);
            if (paramEditText.findFocus() == null) {
              paramEditText.requestFocus();
            }
            AppMethodBeat.o(72964);
          }
        });
      }
      localView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(72965);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/WalletBaseUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          WalletBaseUI.this.hideTenpayKB();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(72965);
        }
      });
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
      this.mWcKeyboard = ((WcPayKeyboard)findViewById(2131310544));
    }
    if ((this.mWcKeyboard == null) || (paramEditText == null)) {
      return;
    }
    final View.OnFocusChangeListener localOnFocusChangeListener = null;
    if (paramBoolean2) {
      localOnFocusChangeListener = paramEditText.getOnFocusChangeListener();
    }
    f.setNoSystemInputOnEditText(paramEditText);
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
    if ((com.tencent.mm.compatible.util.d.oD(28)) && (paramBoolean1) && ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (ifAutoReqFocusTarget28()))) {
      paramEditText.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72976);
          if (paramEditText.findFocus() == null) {
            paramEditText.requestFocus();
          }
          AppMethodBeat.o(72976);
        }
      });
    }
    paramEditText.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(72977);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/ui/WalletBaseUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletBaseUI.this.showNormalStWcKb();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(72977);
      }
    });
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
      this.mWcKeyboard.hgN();
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
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
      for (this.mTipDialog = h.b(getContext(), false, new DialogInterface.OnCancelListener()
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
          }); this.mTipDialog != null; this.mTipDialog = h.c(getContext(), true, null))
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
    }
  }
  
  public void showProgress()
  {
    if ((this.mProgressDialog == null) || ((this.mProgressDialog != null) && (!this.mProgressDialog.isShowing())))
    {
      if (this.mProgressDialog != null) {
        this.mProgressDialog.dismiss();
      }
      this.mProgressDialog = h.c(this, false, new DialogInterface.OnCancelListener()
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
      this.mProgressDialog = h.a(this, false, new DialogInterface.OnCancelListener()
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
      this.mWcKeyboard.DJ(true);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
    }
  }
  
  public void unlockPage()
  {
    mLockSet.remove(getClass().getSimpleName());
  }
  
  public void unregister(k paramk)
  {
    if (this.callbacks.contains(paramk)) {
      this.callbacks.remove(paramk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI
 * JD-Core Version:    0.7.0.1
 */