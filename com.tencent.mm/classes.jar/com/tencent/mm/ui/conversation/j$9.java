package com.tencent.mm.ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h;

final class j$9
  implements Runnable
{
  j$9(j paramj) {}
  
  public final void run()
  {
    long l = j.f(this.vTn).zJ();
    if (j.g(this.vTn) == null) {}
    for (int i = -2;; i = j.g(this.vTn).hashCode())
    {
      y.d("MicroMsg.InitHelper", "dkinit showProgressDlg t:%d initScene:%d", new Object[] { Long.valueOf(l), Integer.valueOf(i) });
      if ((j.h(this.vTn) != null) && (j.h(this.vTn).isShowing())) {
        j.h(this.vTn).dismiss();
      }
      j localj = this.vTn;
      Activity localActivity = j.a(this.vTn);
      j.a(this.vTn).getString(R.l.app_tip);
      j.a(localj, h.b(localActivity, j.a(this.vTn).getString(R.l.app_loading_data), false, new j.9.1(this)));
      au.DS().sQ();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.j.9
 * JD-Core Version:    0.7.0.1
 */