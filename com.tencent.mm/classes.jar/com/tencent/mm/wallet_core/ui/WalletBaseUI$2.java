package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class WalletBaseUI$2
  implements View.OnClickListener
{
  WalletBaseUI$2(WalletBaseUI paramWalletBaseUI, boolean paramBoolean, int paramInt, EditText paramEditText) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(72963);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/wallet_core/ui/WalletBaseUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((!this.agUX.mKBLayout.isShown()) && (!this.val$isShowSysKB))
    {
      this.agUX.showTenpayKB();
      this.agUX.setKBMode(this.val$editMode);
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/wallet_core/ui/WalletBaseUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(72963);
      return;
      if (this.val$isShowSysKB)
      {
        this.agUX.hideTenpayKB();
        ((InputMethodManager)this.agUX.getContext().getSystemService("input_method")).showSoftInput(this.val$hintTv, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.2
 * JD-Core Version:    0.7.0.1
 */