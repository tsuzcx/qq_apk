package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.ml;
import com.tencent.mm.model.r;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.w;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.7;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.b;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboardAnimationActionButton;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class WalletBaseUI
  extends MMActivity
  implements com.tencent.mm.wallet_core.c.h, com.tencent.mm.wallet_core.d.f
{
  public static final int CLEAN_UI_DATA_ACTION_CODE_CLEAN_PASSWORD = 1;
  public static final int CLEAN_UI_DATA_ACTION_CODE_DEFAULT = 0;
  public static final int DIALOG_ID_CONFIRM_FINISH = 1000;
  public static final int HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 270);
  private static final String TAG = "MicroMsg.WalletBaseUI";
  private static com.tencent.mm.wallet_core.c.q mCurrentNetScene = null;
  private static Set<String> mLockSet = new HashSet();
  private boolean _hasFinish = false;
  private MenuItem.OnMenuItemClickListener backListener;
  private LinkedList<j> callbacks = new LinkedList();
  public boolean isVKBFirstTimeShown = false;
  private Bundle mBundle = new Bundle();
  private boolean mIsAuthDoing;
  public View mKBLayout;
  public MyKeyboardWindow mKeyboard;
  public boolean mKindaEnable;
  private com.tencent.mm.wallet_core.d.g mNetController = null;
  public com.tencent.mm.wallet_core.d.i mNetSceneMgr = null;
  private com.tencent.mm.sdk.b.c<ml> mPayLoopInterruptListener = new WalletBaseUI.1(this);
  public int mPayResultType = 0;
  private com.tencent.mm.wallet_core.c mProcess = null;
  private Dialog mProgressDialog;
  private a mTenpayKBStateListener;
  private Dialog mTipDialog = null;
  public WcPayKeyboard mWcKeyboard;
  private MenuItem.OnMenuItemClickListener nextListener;
  
  private void dispatchOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = ((List)this.callbacks.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((j)paramIntent.next()).dSk();
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
      ((j)localIterator.next()).onDestroy();
    }
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
    com.tencent.mm.wallet_core.c localc = getProcess();
    if (localc != null) {
      this.mNetSceneMgr.mBundle = localc.mEJ;
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
  
  public void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, q.b paramb)
  {
    this.nextListener = paramOnMenuItemClickListener;
    super.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener, null, paramb);
  }
  
  public void cancelNetScene(m paramm)
  {
    com.tencent.mm.wallet_core.d.i locali = this.mNetSceneMgr;
    ab.i("MicroMsg.WalletNetSceneMgr", "cancel scene: %s %s", new Object[] { locali, paramm });
    com.tencent.mm.kernel.g.RM();
    com.tencent.mm.kernel.g.RK().eHt.a(paramm);
    locali.gKL.remove(paramm);
    locali.gKK.remove(paramm);
    if ((locali.gKL.isEmpty()) && (locali.gKK.isEmpty()) && (locali.gKM != null) && (locali.gKM.isShowing())) {
      locali.gKM.dismiss();
    }
  }
  
  protected void cancelQRPay()
  {
    PayInfo localPayInfo2 = (PayInfo)getInput().getParcelable("key_pay_info");
    PayInfo localPayInfo1 = localPayInfo2;
    if (localPayInfo2 == null) {
      localPayInfo1 = (PayInfo)getIntent().getParcelableExtra("key_pay_info");
    }
    if ((localPayInfo1 != null) && (!bo.isNullOrNil(localPayInfo1.eAx)))
    {
      this.mNetSceneMgr.a(new com.tencent.mm.wallet_core.c.l(localPayInfo1.eAx, localPayInfo1.cnI), true, 1);
      localPayInfo1.eAx = null;
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
  
  public void doSceneForceProgress(m paramm)
  {
    doSceneProgress(paramm, true, false);
  }
  
  public void doSceneForceProgress(m paramm, int paramInt)
  {
    doSceneProgress(paramm, true, false, paramInt);
  }
  
  public void doSceneProgress(m paramm)
  {
    doSceneProgress(paramm, true, true);
  }
  
  public void doSceneProgress(m paramm, boolean paramBoolean)
  {
    doSceneProgress(paramm, paramBoolean, false);
  }
  
  public void doSceneProgress(m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    doSceneProgress(paramm, paramBoolean1, paramBoolean2, 0);
  }
  
  public void doSceneProgress(m paramm, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    setProcessBundle();
    int i = 1;
    if (!paramBoolean2) {
      i = 2;
    }
    this.mNetSceneMgr.a(paramm, paramBoolean1, i, paramInt);
  }
  
  public void doSceneProgressWithVerify(m paramm)
  {
    setProcessBundle();
    this.mNetSceneMgr.a(paramm, true, 3);
  }
  
  public void doSceneSafeProgress(m paramm)
  {
    doSceneProgress(paramm, true, true);
  }
  
  public void finish()
  {
    super.finish();
    this._hasFinish = true;
  }
  
  public void forceCancel()
  {
    ab.d("MicroMsg.WalletBaseUI", "cancelforceScene");
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
      com.tencent.mm.wallet_core.c localc = getProcess();
      if (localc != null) {
        this.mNetController = localc.a(this, this.mNetSceneMgr);
      }
      if (this.mNetController == null) {
        this.mNetController = new WalletBaseUI.3(this, this, this.mNetSceneMgr);
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
      return localPayInfo.cnI;
    }
    return "";
  }
  
  public com.tencent.mm.wallet_core.c getProcess()
  {
    if (this.mProcess == null) {
      this.mProcess = com.tencent.mm.wallet_core.a.aM(this);
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
      WcPayKeyboard localWcPayKeyboard = this.mWcKeyboard;
      ab.d("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(localWcPayKeyboard.isShown()), localWcPayKeyboard.AVT, bo.dtY() });
      if (localWcPayKeyboard.isShown())
      {
        if (localWcPayKeyboard.dRV()) {
          localWcPayKeyboard.rQ(true);
        }
        if (localWcPayKeyboard.dRU())
        {
          Animation localAnimation = AnimationUtils.loadAnimation(localWcPayKeyboard.getContext(), 2131034292);
          localAnimation.setAnimationListener(new WcPayKeyboard.7(localWcPayKeyboard));
          localWcPayKeyboard.AVS.startAnimation(localAnimation);
        }
      }
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(false);
      }
    }
  }
  
  protected boolean isAuthDoing()
  {
    return this.mIsAuthDoing;
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
  
  public boolean lockPage()
  {
    String str = getClass().getSimpleName();
    if (mLockSet.contains(str))
    {
      ab.w("MicroMsg.WalletBaseUI", "has contain lock key: %s", new Object[] { str });
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
    if ((shouldEnsureSoterConnection()) && (!com.tencent.soter.core.a.dVa())) {
      com.tencent.soter.core.a.dVb();
    }
    super.onCreate(paramBundle);
    setStatusColor();
    if (!com.tencent.mm.kernel.g.RG())
    {
      ab.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
      com.tencent.mm.ui.base.h.a(this, getString(2131304775), "", false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(142667);
          com.tencent.mm.wallet_core.a.b(WalletBaseUI.this, null, -10000);
          AppMethodBeat.o(142667);
        }
      });
    }
    this.mNetSceneMgr = new com.tencent.mm.wallet_core.d.i(this, this);
    this.mNetSceneMgr.addSceneEndListener(385);
    this.mNetSceneMgr.addSceneEndListener(1518);
    this.mPayLoopInterruptListener.alive();
    ab.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
    paramBundle = com.tencent.mm.wallet_core.a.aM(this);
    if (paramBundle != null)
    {
      this.mNetSceneMgr.mProcessName = paramBundle.bzC();
      paramBundle.a(this);
    }
    ab.d("MicroMsg.WalletBaseUI", "proc ".concat(String.valueOf(paramBundle)));
    this.mBundle = com.tencent.mm.wallet_core.a.aL(this);
    if (this.mBundle == null) {
      this.mBundle = new Bundle();
    }
    this.mNetSceneMgr.mBundle = this.mBundle;
    if ((checkProcLife()) && (!com.tencent.mm.wallet_core.a.aK(this))) {
      ab.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
    }
    if (getLayoutId() > 0)
    {
      paramBundle = getSubTitle();
      if (!bo.isNullOrNil(paramBundle)) {
        setMMSubTitle(paramBundle);
      }
    }
    setBackBtn(new WalletBaseUI.9(this));
    this.mNetController = getNetController();
    if ((this.mNetController != null) && (this.mNetController.x(new Object[0]))) {
      setContentViewVisibility(4);
    }
    for (;;)
    {
      dispatchOnCreate();
      com.tencent.mm.wallet_core.b.dRI();
      this.mKindaEnable = com.tencent.mm.wallet_core.b.dpQ();
      paramBundle = com.tencent.mm.compatible.e.q.LK();
      ab.i("MicroMsg.WalletBaseUI", "old id: %s, new id: %s", new Object[] { (String)com.tencent.mm.compatible.e.l.Lm().get(256), paramBundle });
      return;
      setContentViewVisibility();
    }
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    ab.i("MicroMsg.WalletBaseUI", "onCreateDialog id = ".concat(String.valueOf(paramInt)));
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    com.tencent.mm.wallet_core.c localc = com.tencent.mm.wallet_core.a.aM(this);
    if (localc != null) {}
    for (int i = localc.a(this, 1);; i = -1)
    {
      if (i != -1) {
        com.tencent.mm.ui.base.h.a(this, true, getString(i), "", getString(2131297115), getString(2131297014), new WalletBaseUI.10(this), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(142669);
            if (WalletBaseUI.this.getContentView() == null) {}
            for (paramAnonymousDialogInterface = null;; paramAnonymousDialogInterface = WalletBaseUI.this.getContentView().findFocus())
            {
              if ((paramAnonymousDialogInterface != null) && ((paramAnonymousDialogInterface instanceof EditText))) {
                WalletBaseUI.this.showVKB();
              }
              AppMethodBeat.o(142669);
              return;
            }
          }
        });
      }
      if (localc != null) {
        localc.b(this, getInput());
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
    com.tencent.mm.wallet_core.c localc = getProcess();
    if (localc != null) {
      localc.b(this);
    }
    unlockPage();
    dispatchOnDestroy();
    this.callbacks.clear();
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
      ab.i("MicroMsg.WalletBaseUI", "process end ok!");
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
      ab.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : ".concat(String.valueOf(i)));
      setResult(0, getIntent());
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public boolean onPreSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
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
    if (w.dSn()) {
      if (r.ZB()) {
        break label34;
      }
    }
    label34:
    for (Object localObject = new com.tencent.mm.wallet_core.tenpay.model.q();; localObject = new com.tencent.mm.wallet_core.e.a.b())
    {
      this.mNetSceneMgr.a((m)localObject, false);
      return;
    }
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    ab.d("MicroMsg.WalletBaseUI", "errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    TenpaySecureEditText.setSalt(w.dSo());
    if ((paramm instanceof com.tencent.mm.wallet_core.c.q))
    {
      com.tencent.mm.wallet_core.c.q localq = (com.tencent.mm.wallet_core.c.q)paramm;
      mCurrentNetScene = localq;
      if (this.mBundle != null)
      {
        if (localq.is_gen_cert > 0) {
          this.mBundle.putInt("key_is_gen_cert", localq.is_gen_cert);
        }
        if (localq.is_hint_cert > 0) {
          this.mBundle.putInt("key_is_hint_crt", localq.is_hint_cert);
        }
        if (localq.is_ignore_cert > 0) {
          this.mBundle.putInt("key_is_ignore_cert", localq.is_ignore_cert);
        }
        if (!bo.isNullOrNil(localq.crt_token)) {
          this.mBundle.putString("key_crt_token", localq.crt_token);
        }
        if (!bo.isNullOrNil(localq.crt_wording)) {
          this.mBundle.putString("key_crt_wording", localq.crt_wording);
        }
      }
    }
    onPreSceneEnd(paramInt1, paramInt2, paramString, paramm);
    f.a(this, paramInt1, paramInt2, paramString, paramm, paramBoolean);
  }
  
  public abstract boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm);
  
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
  
  public void regeistQueryOrder(int paramInt, com.tencent.mm.wallet_core.d.c paramc)
  {
    com.tencent.mm.wallet_core.d.i locali = this.mNetSceneMgr;
    paramc.rtType = paramInt;
    paramc.AXz = locali;
    locali.AXF.put(Integer.valueOf(paramInt), paramc);
  }
  
  public void register(j paramj)
  {
    if (!this.callbacks.contains(paramj)) {
      this.callbacks.add(paramj);
    }
  }
  
  public void removeSceneEndListener(int paramInt)
  {
    this.mNetSceneMgr.removeSceneEndListener(paramInt);
  }
  
  public boolean resend(boolean paramBoolean)
  {
    if ((mCurrentNetScene != null) && ((mCurrentNetScene.resend()) || (paramBoolean)))
    {
      this.mNetSceneMgr.a(mCurrentNetScene, true);
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
      int j = com.tencent.mm.cb.a.gx(this);
      paramInt = j - i - com.tencent.mm.cb.a.fromDPToPix(this, paramInt);
      ab.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(HARDCODE_TENPAY_KEYBOARD_HEIGHT) });
      if ((paramInt > 0) && (paramInt < HARDCODE_TENPAY_KEYBOARD_HEIGHT))
      {
        paramInt = HARDCODE_TENPAY_KEYBOARD_HEIGHT - paramInt;
        ab.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new WalletBaseUI.6(this, paramView1, paramInt));
      }
    }
  }
  
  public void setAuthState(boolean paramBoolean)
  {
    this.mIsAuthDoing = paramBoolean;
    com.tencent.mm.pluginsdk.wallet.i.dpR().wgO.put("key_pay_offline_is_auth_doing", Boolean.valueOf(paramBoolean));
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
  protected void setEditFocusListener(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    setEditFocusListener(paramView, null, paramInt, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  protected void setEditFocusListener(View paramView, EditText paramEditText, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(2131822419));
    this.mKBLayout = findViewById(2131822418);
    View localView = findViewById(2131822420);
    if (paramEditText == null) {
      paramEditText = (EditText)paramView.findViewById(2131820689);
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
      e.setNoSystemInputOnEditText(paramEditText);
      paramEditText.setOnFocusChangeListener(new WalletBaseUI.14(this, paramBoolean1, paramBoolean2, paramView, paramEditText, paramInt, localOnFocusChangeListener));
      paramEditText.setOnClickListener(new WalletBaseUI.15(this, paramBoolean1, paramInt, paramEditText));
      localView.setOnClickListener(new WalletBaseUI.2(this));
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
  
  protected void setWPKeyboard(EditText paramEditText, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mWcKeyboard = ((WcPayKeyboard)findViewById(2131829492));
    if ((this.mWcKeyboard == null) || (paramEditText == null)) {
      return;
    }
    View.OnFocusChangeListener localOnFocusChangeListener = null;
    if (paramBoolean2) {
      localOnFocusChangeListener = paramEditText.getOnFocusChangeListener();
    }
    e.setNoSystemInputOnEditText(paramEditText);
    paramEditText.setOnFocusChangeListener(new WalletBaseUI.12(this, paramBoolean1, paramEditText, localOnFocusChangeListener));
    paramEditText.setOnClickListener(new WalletBaseUI.13(this));
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
    return true;
  }
  
  protected void shouldFixStatusBar() {}
  
  public void showCircleStWcKb()
  {
    if (this.mWcKeyboard != null)
    {
      this.mWcKeyboard.dRT();
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
    }
  }
  
  public void showLoading()
  {
    if (this.mTipDialog != null)
    {
      this.mTipDialog.show();
      return;
    }
    this.mTipDialog = g.a(getContext(), true, new WalletBaseUI.7(this));
    this.mTipDialog.setCancelable(false);
  }
  
  public void showNormalStWcKb()
  {
    WcPayKeyboard localWcPayKeyboard;
    if (this.mWcKeyboard != null)
    {
      localWcPayKeyboard = this.mWcKeyboard;
      ab.d("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s [%s]", new Object[] { Boolean.valueOf(localWcPayKeyboard.isShown()), localWcPayKeyboard.AVT, bo.dtY() });
      if (!localWcPayKeyboard.isShown()) {
        break label93;
      }
      if (localWcPayKeyboard.dRU()) {
        localWcPayKeyboard.an(false, true);
      }
    }
    for (;;)
    {
      localWcPayKeyboard.AVT = WcPayKeyboard.b.AWa;
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
      return;
      label93:
      if (localWcPayKeyboard.dRU()) {
        localWcPayKeyboard.an(false, false);
      }
      localWcPayKeyboard.rR(true);
    }
  }
  
  public void showProgress()
  {
    if ((this.mProgressDialog == null) || ((this.mProgressDialog != null) && (!this.mProgressDialog.isShowing())))
    {
      if (this.mProgressDialog != null) {
        this.mProgressDialog.dismiss();
      }
      this.mProgressDialog = g.c(this, false, new WalletBaseUI.5(this));
    }
  }
  
  public void showSafeProgress()
  {
    if ((this.mProgressDialog == null) || ((this.mProgressDialog != null) && (!this.mProgressDialog.isShowing())))
    {
      if (this.mProgressDialog != null) {
        this.mProgressDialog.dismiss();
      }
      this.mProgressDialog = g.a(this, false, new WalletBaseUI.4(this));
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
      this.mWcKeyboard.rR(true);
      if (this.mTenpayKBStateListener != null) {
        this.mTenpayKBStateListener.onVisibleStateChange(true);
      }
    }
  }
  
  public void unlockPage()
  {
    mLockSet.remove(getClass().getSimpleName());
  }
  
  public void unregister(j paramj)
  {
    if (this.callbacks.contains(paramj)) {
      this.callbacks.remove(paramj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI
 * JD-Core Version:    0.7.0.1
 */