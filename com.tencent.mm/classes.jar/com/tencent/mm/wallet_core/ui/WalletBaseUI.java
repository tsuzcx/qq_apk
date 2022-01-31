package com.tencent.mm.wallet_core.ui;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.j;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.n;
import com.tenpay.android.wechat.MyKeyboardWindow;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class WalletBaseUI
  extends MMActivity
  implements com.tencent.mm.wallet_core.c.f, com.tencent.mm.wallet_core.d.f
{
  public static final int eYf = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 270);
  private static o wCj = null;
  private static Set<String> wCl = new HashSet();
  public Bundle BX = new Bundle();
  private Dialog klS;
  public View lMr;
  public a lTH;
  private LinkedList<com.tencent.mm.wallet_core.c.h> lUr = new LinkedList();
  public MyKeyboardWindow mKeyboard;
  private MenuItem.OnMenuItemClickListener vqS;
  private c wCg = null;
  public i wCh = null;
  private com.tencent.mm.wallet_core.d.g wCi = null;
  private MenuItem.OnMenuItemClickListener wCk;
  public boolean wCm = false;
  
  public static void cNh() {}
  
  private void cNn()
  {
    Iterator localIterator = ((List)this.lUr.clone()).iterator();
    while (localIterator.hasNext()) {
      localIterator.next();
    }
  }
  
  public final void IZ(int paramInt)
  {
    this.mKeyboard.setXMode(paramInt);
  }
  
  public void VH()
  {
    if ((this.lMr != null) && (this.lMr.isShown()))
    {
      this.lMr.setVisibility(8);
      if (this.lTH != null) {
        this.lTH.gK(false);
      }
    }
  }
  
  public boolean VK()
  {
    return true;
  }
  
  public final boolean Wt()
  {
    if (this.vqS != null)
    {
      this.vqS.onMenuItemClick(null);
      return true;
    }
    if (this.wCk != null)
    {
      this.wCk.onMenuItemClick(null);
      return true;
    }
    return super.Wt();
  }
  
  public void a(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramView, paramInt, paramBoolean1, true, paramBoolean2);
  }
  
  @TargetApi(14)
  public final void a(View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    a(paramView, null, paramInt, paramBoolean1, paramBoolean2, paramBoolean3);
  }
  
  public final void a(View paramView1, View paramView2, int paramInt)
  {
    if (paramView1 != null)
    {
      int[] arrayOfInt = new int[2];
      paramView2.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[1] + paramView2.getHeight();
      int j = com.tencent.mm.cb.a.fk(this);
      paramInt = j - i - com.tencent.mm.cb.a.fromDPToPix(this, paramInt);
      y.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(eYf) });
      if ((paramInt > 0) && (paramInt < eYf))
      {
        paramInt = eYf - paramInt;
        y.d("MicroMsg.WalletBaseUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", new Object[] { Integer.valueOf(paramInt) });
        paramView1.post(new WalletBaseUI.3(this, paramView1, paramInt));
      }
    }
  }
  
  public final void a(View paramView, EditText paramEditText, int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
    this.lMr = findViewById(a.f.tenpay_keyboard_layout);
    View localView = findViewById(a.f.tenpay_push_down);
    if (paramEditText == null) {
      paramEditText = (EditText)paramView.findViewById(a.f.wallet_content);
    }
    for (;;)
    {
      if ((this.mKeyboard == null) || (paramEditText == null) || (this.lMr == null)) {
        return;
      }
      View.OnFocusChangeListener localOnFocusChangeListener = null;
      if (paramBoolean3) {
        localOnFocusChangeListener = paramEditText.getOnFocusChangeListener();
      }
      e.setNoSystemInputOnEditText(paramEditText);
      paramEditText.setOnFocusChangeListener(new WalletBaseUI.7(this, paramBoolean1, paramBoolean2, paramView, paramEditText, paramInt, localOnFocusChangeListener));
      paramEditText.setOnClickListener(new WalletBaseUI.8(this, paramBoolean1, paramInt, paramEditText));
      localView.setOnClickListener(new WalletBaseUI.9(this));
      return;
    }
  }
  
  public final void a(m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramm, paramBoolean1, paramBoolean2, 0);
  }
  
  public final void a(m paramm, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    c localc = cNj();
    if (localc != null) {
      this.wCh.BX = localc.kke;
    }
    int i = 1;
    if (!paramBoolean2) {
      i = 2;
    }
    this.wCh.a(paramm, paramBoolean1, i, paramInt);
  }
  
  public final void a(com.tencent.mm.wallet_core.c.h paramh)
  {
    if (!this.lUr.contains(paramh)) {
      this.lUr.add(paramh);
    }
  }
  
  public final void a(String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener, s.b paramb)
  {
    this.wCk = paramOnMenuItemClickListener;
    super.a(0, paramString, paramOnMenuItemClickListener, paramb);
  }
  
  public final void aEg()
  {
    if ((this.klS == null) || ((this.klS != null) && (!this.klS.isShowing())))
    {
      if (this.klS != null) {
        this.klS.dismiss();
      }
      this.klS = g.b(this, false, new WalletBaseUI.2(this));
    }
  }
  
  public void aFd()
  {
    ta(this.mController.czv());
  }
  
  public boolean aSk()
  {
    if (getLayoutId() <= 0) {}
    while (this.wCh.bfI()) {
      return true;
    }
    return false;
  }
  
  public boolean aSl()
  {
    return false;
  }
  
  public final void addTextOptionMenu(int paramInt, String paramString, MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.wCk = paramOnMenuItemClickListener;
    super.addTextOptionMenu(paramInt, paramString, paramOnMenuItemClickListener);
  }
  
  public void b(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    y.d("MicroMsg.WalletBaseUI", "errType = " + paramInt1 + ", errCode = " + paramInt2 + ", errMsg = " + paramString);
    TenpaySecureEditText.setSalt(u.cMz());
    if ((paramm instanceof o))
    {
      o localo = (o)paramm;
      wCj = localo;
      if (this.BX != null)
      {
        if (localo.quD > 0) {
          this.BX.putInt("key_is_gen_cert", localo.quD);
        }
        if (localo.quF > 0) {
          this.BX.putInt("key_is_hint_crt", localo.quF);
        }
        if (localo.quH > 0) {
          this.BX.putInt("key_is_ignore_cert", localo.quH);
        }
        if (!bk.bl(localo.quE)) {
          this.BX.putString("key_crt_token", localo.quE);
        }
        if (!bk.bl(localo.quG)) {
          this.BX.putString("key_crt_wording", localo.quG);
        }
      }
    }
    j(paramInt1, paramInt2, paramString, paramm);
    f.a(this, paramInt1, paramInt2, paramString, paramm, paramBoolean);
  }
  
  public final String bTO()
  {
    if (this.BX == null) {
      return "";
    }
    PayInfo localPayInfo = (PayInfo)this.BX.getParcelable("key_pay_info");
    if (localPayInfo != null) {
      return localPayInfo.bMX;
    }
    return "";
  }
  
  public boolean bTZ()
  {
    return false;
  }
  
  public void bfH()
  {
    y.d("MicroMsg.WalletBaseUI", "cancelforceScene");
    this.wCh.bfH();
    finish();
  }
  
  public boolean bgK()
  {
    return true;
  }
  
  public final void bka()
  {
    if (this.klS != null) {
      this.klS.dismiss();
    }
  }
  
  public boolean bwA()
  {
    return false;
  }
  
  public abstract boolean c(int paramInt1, int paramInt2, String paramString, m paramm);
  
  public void cN()
  {
    cNj().a(this, 0, this.BX);
  }
  
  public final void cNg()
  {
    PayInfo localPayInfo2 = (PayInfo)this.BX.getParcelable("key_pay_info");
    PayInfo localPayInfo1 = localPayInfo2;
    if (localPayInfo2 == null) {
      localPayInfo1 = (PayInfo)getIntent().getParcelableExtra("key_pay_info");
    }
    if ((localPayInfo1 != null) && (!bk.bl(localPayInfo1.dCX)))
    {
      this.wCh.a(new j(localPayInfo1.dCX, localPayInfo1.bMX), true, 1);
      localPayInfo1.dCX = null;
    }
  }
  
  public final void cNi()
  {
    if ((this.lMr != null) && (!this.lMr.isShown()))
    {
      this.lMr.setVisibility(0);
      if (this.lTH != null) {
        this.lTH.gK(true);
      }
    }
  }
  
  public final c cNj()
  {
    if (this.wCg == null) {
      this.wCg = com.tencent.mm.wallet_core.a.aj(this);
    }
    return this.wCg;
  }
  
  public final com.tencent.mm.wallet_core.d.g cNk()
  {
    if (this.wCi == null)
    {
      c localc = cNj();
      if (localc != null) {
        this.wCi = localc.a(this, this.wCh);
      }
      if (this.wCi == null) {
        this.wCi = new WalletBaseUI.10(this, this, this.wCh);
      }
    }
    return this.wCi;
  }
  
  public final CharSequence cNl()
  {
    if (this.wCi == null) {
      return null;
    }
    return this.wCi.vy(0);
  }
  
  public final void cNm()
  {
    if ((this.klS == null) || ((this.klS != null) && (!this.klS.isShowing())))
    {
      if (this.klS != null) {
        this.klS.dismiss();
      }
      this.klS = g.a(this, false, new WalletBaseUI.11(this));
    }
  }
  
  public final void e(View paramView, int paramInt, boolean paramBoolean)
  {
    a(paramView, paramInt, paramBoolean, true);
  }
  
  public boolean j(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return true;
  }
  
  public final void kh(int paramInt)
  {
    this.wCh.kh(paramInt);
  }
  
  public final void ki(int paramInt)
  {
    this.wCh.ki(paramInt);
  }
  
  public final boolean of(boolean paramBoolean)
  {
    if ((wCj != null) && ((wCj.bqc()) || (paramBoolean)))
    {
      this.wCh.a(wCj, true);
      return true;
    }
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    cNk().onActivityResult(paramInt1, paramInt2, paramIntent);
    paramIntent = ((List)this.lUr.clone()).iterator();
    while (paramIntent.hasNext()) {
      ((com.tencent.mm.wallet_core.c.h)paramIntent.next()).cMt();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    String str;
    if (bwA())
    {
      str = getClass().getSimpleName();
      if (wCl.contains(str))
      {
        y.w("MicroMsg.WalletBaseUI", "has contain lock key: %s", new Object[] { str });
        finish();
      }
    }
    else
    {
      super.onCreate(paramBundle);
      aFd();
      if (!com.tencent.mm.kernel.g.DK())
      {
        y.e("MicroMsg.WalletBaseUI", "hy: account not ready. finish now");
        com.tencent.mm.ui.base.h.a(this, getString(a.i.wallet_account_not_ready), "", false, new WalletBaseUI.1(this));
      }
      this.wCh = new i(this, this);
      this.wCh.kh(385);
      this.wCh.kh(1518);
      y.d("MicroMsg.WalletBaseUI", "current process:" + getIntent().getIntExtra("process_id", 0));
      paramBundle = com.tencent.mm.wallet_core.a.aj(this);
      if (paramBundle != null) {
        this.wCh.dIA = paramBundle.aTh();
      }
      y.d("MicroMsg.WalletBaseUI", "proc " + paramBundle);
      this.BX = com.tencent.mm.wallet_core.a.ai(this);
      if (this.BX == null) {
        this.BX = new Bundle();
      }
      this.wCh.BX = this.BX;
      if ((bgK()) && (!com.tencent.mm.wallet_core.a.ah(this))) {
        y.e("MicroMsg.WalletBaseUI", "Activity extends WalletBaseUI but not in process!!!");
      }
      if ((getLayoutId() > 0) && (!bk.bl(""))) {
        setMMSubTitle("");
      }
      setBackBtn(new WalletBaseUI.4(this));
      this.wCi = cNk();
      if ((this.wCi == null) || (!this.wCi.s(new Object[0]))) {
        break label347;
      }
      vN(4);
    }
    for (;;)
    {
      cNn();
      return;
      wCl.add(str);
      break;
      label347:
      if (getLayoutId() <= 0) {
        vN(4);
      } else if (aSk()) {
        vN(4);
      } else {
        vN(0);
      }
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    y.i("MicroMsg.WalletBaseUI", "onCreateDialog id = " + paramInt);
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    c localc = com.tencent.mm.wallet_core.a.aj(this);
    if (localc != null) {}
    for (int i = localc.a(this, 1);; i = -1)
    {
      if (i != -1) {
        return com.tencent.mm.ui.base.h.a(this, true, getString(i), "", getString(a.i.app_yes), getString(a.i.app_no), new WalletBaseUI.5(this), new WalletBaseUI.6(this));
      }
      if (localc != null) {
        localc.b(this, this.BX);
      }
      for (;;)
      {
        return super.onCreateDialog(paramInt);
        finish();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.wCh.ki(385);
    this.wCh.ki(1518);
    wCl.remove(getClass().getSimpleName());
    Iterator localIterator = ((List)this.lUr.clone()).iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.wallet_core.c.h)localIterator.next()).onDestroy();
    }
    this.lUr.clear();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((this.lMr != null) && (this.lMr.isShown()))
      {
        VH();
        return true;
      }
      if (bTZ())
      {
        XM();
        showDialog(1000);
        return true;
      }
      if ((this.vqS != null) && (VK()))
      {
        this.vqS.onMenuItemClick(null);
        return true;
      }
      if (this.wCk != null)
      {
        this.wCk.onMenuItemClick(null);
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
      y.i("MicroMsg.WalletBaseUI", "process end ok!");
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
      y.i("MicroMsg.WalletBaseUI", "process end with user cancel or err! resultCode : " + i);
      setResult(0, getIntent());
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (u.cMy()) {
      if (q.Gw()) {
        break label34;
      }
    }
    label34:
    for (Object localObject = new n();; localObject = new b())
    {
      this.wCh.a((m)localObject, false);
      return;
    }
  }
  
  public final void setBackBtn(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.vqS = paramOnMenuItemClickListener;
    super.setBackBtn(paramOnMenuItemClickListener);
  }
  
  public void st(int paramInt) {}
  
  public void vN(int paramInt)
  {
    super.vN(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI
 * JD-Core Version:    0.7.0.1
 */