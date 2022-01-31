package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.mm.R.l;

final class j$10
  implements Runnable
{
  j$10(j paramj, int paramInt) {}
  
  public final void run()
  {
    if (j.h(this.vTn) != null) {
      j.h(this.vTn).setMessage(j.a(this.vTn).getString(R.l.app_loading_data) + this.fjt + "%");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.10
 * JD-Core Version:    0.7.0.1
 */