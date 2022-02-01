package com.tencent.mm.wallet_core.ui;

import android.os.Build.VERSION;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.formview.EditHintPasswdView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WalletBaseUI$17
  implements View.OnFocusChangeListener
{
  WalletBaseUI$17(WalletBaseUI paramWalletBaseUI, boolean paramBoolean, View paramView, EditText paramEditText, int paramInt, View.OnFocusChangeListener paramOnFocusChangeListener) {}
  
  public final void onFocusChange(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(72980);
    if ((paramView.isFocused()) && (!this.val$isShowSysKB))
    {
      ((InputMethodManager)this.agUX.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72978);
          if ((!WalletBaseUI.17.this.agUX.mKBLayout.isShown()) && (paramView.isShown())) {
            WalletBaseUI.17.this.agUX.showTenpayKB();
          }
          Object localObject;
          if (((WalletBaseUI.17.this.val$parent instanceof WalletFormView)) && (Build.VERSION.SDK_INT >= 14))
          {
            localObject = (WalletFormView)WalletBaseUI.17.this.val$parent;
            if (((z.bBi()) || (((WalletFormView)localObject).getEncrptType() == 100)) && ((!z.bBi()) || (((WalletFormView)localObject).getEncrptType() == 0))) {
              break label261;
            }
            localObject = new c();
            WalletBaseUI.17.this.agUX.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
            WalletBaseUI.17.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
          }
          for (;;)
          {
            if (((WalletBaseUI.17.this.val$parent instanceof EditHintPasswdView)) && (Build.VERSION.SDK_INT >= 14))
            {
              localObject = new c();
              WalletBaseUI.17.this.agUX.mKeyboard.setSecureAccessibility((View.AccessibilityDelegate)localObject);
              WalletBaseUI.17.this.val$hintTv.setAccessibilityDelegate((View.AccessibilityDelegate)localObject);
            }
            WalletBaseUI.17.this.agUX.setKBMode(WalletBaseUI.17.this.val$editMode);
            WalletBaseUI.17.this.agUX.mKeyboard.setInputEditText((EditText)paramView);
            ((InputMethodManager)WalletBaseUI.17.this.agUX.getContext().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
            AppMethodBeat.o(72978);
            return;
            label261:
            WalletBaseUI.17.this.agUX.mKeyboard.resetSecureAccessibility();
            WalletBaseUI.17.this.val$hintTv.setAccessibilityDelegate(null);
          }
        }
      }, 300L);
    }
    for (;;)
    {
      if (this.val$finalOrigFocusListener != null) {
        this.val$finalOrigFocusListener.onFocusChange(paramView, paramBoolean);
      }
      AppMethodBeat.o(72980);
      return;
      new MMHandler().postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(72979);
          WalletBaseUI.17.this.agUX.hideTenpayKB();
          if (WalletBaseUI.17.this.val$isShowSysKB) {
            ((InputMethodManager)WalletBaseUI.17.this.agUX.getContext().getSystemService("input_method")).showSoftInput(WalletBaseUI.17.this.val$hintTv, 0);
          }
          AppMethodBeat.o(72979);
        }
      }, 200L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.17
 * JD-Core Version:    0.7.0.1
 */