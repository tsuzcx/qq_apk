package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.base.o;

final class i$1
  implements View.OnClickListener
{
  i$1(i parami) {}
  
  public final void onClick(View paramView)
  {
    if ((this.sgB.sgA != null) && (this.sgB.sgw != null)) {
      this.sgB.sgA.WL(this.sgB.sgw.sgu);
    }
    this.sgB.sgx.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.i.1
 * JD-Core Version:    0.7.0.1
 */