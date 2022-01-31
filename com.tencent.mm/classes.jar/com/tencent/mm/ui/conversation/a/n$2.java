package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class n$2
  implements am.a
{
  n$2(n paramn) {}
  
  public final boolean tC()
  {
    this.vVt.vVl += 1;
    y.v("MicroMsg.NetWarnView", "timer fired, percent:%d", new Object[] { Integer.valueOf(this.vVt.vVl) });
    if (this.vVt.vVl > 99) {
      return false;
    }
    if (this.vVt.pIS == 1) {
      this.vVt.eXO.setText(((Context)this.vVt.sdy.get()).getResources().getString(R.l.net_warn_diagnose_doing, new Object[] { Integer.valueOf(this.vVt.vVl) }));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.a.n.2
 * JD-Core Version:    0.7.0.1
 */