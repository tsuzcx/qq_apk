package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ai.d;
import com.tencent.mm.storage.ad;

final class b$1
  implements DialogInterface.OnClickListener
{
  b$1(d paramd, Activity paramActivity, ad paramad, boolean paramBoolean, int paramInt, Runnable paramRunnable) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.a(this.vYn, this.eRW, this.doS, this.vYo, this.vYp);
    if (this.vYq != null) {
      this.vYq.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.1
 * JD-Core Version:    0.7.0.1
 */