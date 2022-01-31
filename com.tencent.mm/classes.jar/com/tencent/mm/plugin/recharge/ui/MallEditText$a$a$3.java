package com.tencent.mm.plugin.recharge.ui;

import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.tencent.mm.plugin.recharge.model.a;
import com.tencent.mm.sdk.platformtools.bk;

final class MallEditText$a$a$3
  implements Runnable
{
  MallEditText$a$a$3(MallEditText.a.a parama, a parama1) {}
  
  public final void run()
  {
    MallEditText.a(this.nqr.nqq.nqk, this.nqs);
    if (!bk.bl(MallEditText.e(this.nqr.nqq.nqk).name))
    {
      MallEditText.g(this.nqr.nqq.nqk).setText(MallEditText.e(this.nqr.nqq.nqk).name);
      MallEditText.g(this.nqr.nqq.nqk).setVisibility(0);
    }
    for (;;)
    {
      MallEditText.a(this.nqr.nqq.nqk).dismissDropDown();
      return;
      MallEditText.g(this.nqr.nqq.nqk).setText("");
      MallEditText.g(this.nqr.nqq.nqk).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.MallEditText.a.a.3
 * JD-Core Version:    0.7.0.1
 */