package com.tencent.mm.wallet_core.ui;

import android.os.Build.VERSION;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.mm.model.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.a.c;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WalletBaseUI$7$1
  implements Runnable
{
  WalletBaseUI$7$1(WalletBaseUI.7 param7, View paramView) {}
  
  public final void run()
  {
    if ((!this.wCp.wCn.lMr.isShown()) && (this.val$view.isShown()) && ((this.wCp.eYh) || (this.wCp.wCn.wCm)))
    {
      this.wCp.wCn.wCm = true;
      this.wCp.wCn.cNi();
    }
    Object localObject;
    if (((this.wCp.eYj instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
    {
      localObject = (WalletFormView)this.wCp.eYj;
      if (((q.Gw()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!q.Gw()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
        break label288;
      }
      localObject = new c();
      this.wCp.wCn.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
      this.wCp.eYi.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
    }
    for (;;)
    {
      if (((this.wCp.eYj instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
      {
        localObject = new c();
        this.wCp.wCn.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
        this.wCp.eYi.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
      }
      this.wCp.wCn.IZ(this.wCp.eYk);
      this.wCp.wCn.mKeyboard.setInputEditText((EditText)this.val$view);
      ((InputMethodManager)this.wCp.wCn.mController.uMN.getSystemService("input_method")).hideSoftInputFromWindow(this.val$view.getWindowToken(), 0);
      return;
      label288:
      this.wCp.wCn.mKeyboard.resetSecureAccessibility();
      this.wCp.eYi.setAccessibilityDelegate(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.7.1
 * JD-Core Version:    0.7.0.1
 */