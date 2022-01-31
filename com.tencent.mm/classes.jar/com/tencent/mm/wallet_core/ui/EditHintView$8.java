package com.tencent.mm.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tenpay.android.wechat.TenpaySecureEditText;

final class EditHintView$8
  implements View.OnClickListener
{
  EditHintView$8(EditHintView paramEditHintView) {}
  
  public final void onClick(View paramView)
  {
    if (EditHintView.l(this.wBY).getVisibility() == 0)
    {
      if ((!this.wBY.fun) || (bk.bl(this.wBY.getText()))) {
        break label47;
      }
      this.wBY.wBN.ClearInput();
    }
    label47:
    do
    {
      return;
      if (EditHintView.f(this.wBY) != 1) {
        break;
      }
    } while ((EditHintView.m(this.wBY) == null) || (!EditHintView.n(this.wBY)));
    return;
    EditHintView.o(this.wBY);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.EditHintView.8
 * JD-Core Version:    0.7.0.1
 */