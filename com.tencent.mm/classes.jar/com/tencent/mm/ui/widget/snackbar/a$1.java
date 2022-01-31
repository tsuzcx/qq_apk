package com.tencent.mm.ui.widget.snackbar;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

final class a$1
  implements View.OnClickListener
{
  a$1(a parama) {}
  
  public final void onClick(View paramView)
  {
    if ((this.wpS.wpP != null) && (this.wpS.wpO.isShowing())) {
      this.wpS.wpP.amw();
    }
    this.wpS.mHandler.postDelayed(new a.1.1(this), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.snackbar.a.1
 * JD-Core Version:    0.7.0.1
 */