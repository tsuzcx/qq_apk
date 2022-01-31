package com.tencent.mm.wallet_core.ui;

import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WalletBaseUI$14$1
  implements Runnable
{
  WalletBaseUI$14$1(WalletBaseUI.14 param14, View paramView) {}
  
  public final void run()
  {
    AppMethodBeat.i(142674);
    if ((!this.AYC.AYz.mKBLayout.isShown()) && (this.val$view.isShown()) && ((this.AYC.val$isShowFirstTime) || (this.AYC.AYz.isVKBFirstTimeShown)))
    {
      this.AYC.AYz.isVKBFirstTimeShown = true;
      this.AYC.AYz.showTenpayKB();
    }
    Object localObject;
    if (((this.AYC.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
    {
      localObject = (WalletFormView)this.AYC.val$parent;
      if (((r.ZB()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!r.ZB()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
        break label295;
      }
      localObject = new c();
      this.AYC.AYz.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      this.AYC.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    for (;;)
    {
      if (((this.AYC.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
      {
        localObject = new c();
        this.AYC.AYz.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
        this.AYC.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
      }
      this.AYC.AYz.setKBMode(this.AYC.val$editMode);
      this.AYC.AYz.mKeyboard.setInputEditText((EditText)this.val$view);
      ((InputMethodManager)this.AYC.AYz.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
      AppMethodBeat.o(142674);
      return;
      label295:
      this.AYC.AYz.mKeyboard.resetSecureAccessibility();
      this.AYC.val$hintTv.setAccessibilityDelegate(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.14.1
 * JD-Core Version:    0.7.0.1
 */