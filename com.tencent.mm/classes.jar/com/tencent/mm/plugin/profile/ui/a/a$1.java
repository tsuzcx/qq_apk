package com.tencent.mm.plugin.profile.ui.a;

import android.app.Activity;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.ui.base.h;

final class a$1
  implements am.a
{
  a$1(a parama) {}
  
  public final boolean tC()
  {
    if (!this.mZv.bMV.isFinishing())
    {
      a locala = this.mZv;
      Activity localActivity = this.mZv.bMV;
      this.mZv.bMV.getString(R.l.app_tip);
      locala.ksE = h.b(localActivity, this.mZv.bMV.getString(R.l.app_waiting), true, new a.1.1(this));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.a.a.1
 * JD-Core Version:    0.7.0.1
 */